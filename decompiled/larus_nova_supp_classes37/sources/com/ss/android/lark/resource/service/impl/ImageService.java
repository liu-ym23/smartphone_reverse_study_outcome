package com.ss.android.lark.resource.service.impl;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.bytedance.lark.pb.basic.v1.SerCrypto;
import com.bytedance.lark.pb.media.v1.DownloadFileScene;
import com.bytedance.lark.pb.media.v1.GetAvatarPathRequest;
import com.bytedance.lark.pb.media.v1.GetAvatarPathResponse;
import com.bytedance.lark.pb.media.v1.MGetResourcesRequest;
import com.bytedance.lark.pb.media.v1.MGetResourcesResponse;
import com.bytedance.lark.sdk.Sdk;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.image.impl.steam.SteamImageLoadTraceReporter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUploadRetryConfigSetting;
import com.ss.android.lark.resource.service.IResourceManisService;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.sdk.h;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import com.suite.lark.platform.service.resourcerepository.api.ResourceRequestBaseSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(qpc.a.class)
public class ImageService implements qpc.a {
    private static final int AVATAR_SIZE_THRESHOLD = 150;
    private static final int DEFAULT_SDK_ERROR_CODE = 600000;
    private static final int DRAFT_RESOURCE_SOURCE_CLOUD_DRAFT = 2;
    private static final int DRAFT_RESOURCE_SOURCE_LOCAL_DRAFT = 1;
    private static final int DRAFT_RESOURCE_SOURCE_UNKNOWN = 0;
    private static final int ERROR_SDK_AVATAR_PATH_EMPTY = 701002;
    public static final String FEATURE_CHAT_DRAFT_RESET_SYNC = "lark.chat.reset.sync";
    private static final int RESOURCE_TYPE_AVATAR = 0;
    private static final int RESOURCE_TYPE_IMAGE = 1;
    private static final int SIZE_MIDDLE = 240;
    private static final int SIZE_SMALL = 72;
    private static final String TAG = "ImageService";
    private static final int WAIT_TIMEOUT_IN_MILLIS = 30000;

    public class a implements SdkSender.IParser<Resource> {
        public a() {
        }

        public final Object parse(byte[] r3) throws IOException {
            GetAvatarPathResponse r4 = (GetAvatarPathResponse) GetAvatarPathResponse.ADAPTER.decode(r3);
            Resource r0 = new Resource();
            if (r4 == null) goto L5;
            r0.b = r4.path;
        L6:
            return r0;
        L5:
            r0.e = new ErrorResult(ImageService.ERROR_SDK_AVATAR_PATH_EMPTY);
            goto L6
        }
    }

    public class b implements SdkSender.IParser<String> {
        public b() {
        }

        public final Object parse(byte[] r2) throws IOException {
            return ((GetAvatarPathResponse) GetAvatarPathResponse.ADAPTER.decode(r2)).path;
        }
    }

    public class c implements SdkSender.IParser<String> {
        public c() {
        }

        public final Object parse(byte[] r2) throws IOException {
            return ((GetAvatarPathResponse) GetAvatarPathResponse.ADAPTER.decode(r2)).path;
        }
    }

    public class d implements SdkSender.IParser<Resource> {
        public final /* synthetic */ ImageService a;

        public d(ImageService r1) {
            this.a = r1;
        }

        public final Object parse(byte[] r3) throws IOException {
            MGetResourcesResponse r4 = (MGetResourcesResponse) MGetResourcesResponse.ADAPTER.decode(r3);
            Map<String, Resource> r0 = com.ss.android.lark.resource.service.impl.a.a(r4.resources);
            Resource r1 = ImageService.access$100(this.a, r0);
            if (r1 == null) goto L5;
            r1.d = r4.trace;
        L5:
            return r1;
        }
    }

    public ImageService() {
    }

    private String builderToString(MGetResourcesRequest.Builder r5) {
        StringBuilder r0 = new StringBuilder();
        if (r5 == null) goto L20;
        List r1 = r5.sets;
        if (CollectionUtils.isNotEmpty(r1) == false) goto L13;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        MGetResourcesRequest.Set r3 = (MGetResourcesRequest.Set) r2.next();
        if (r3 == null) goto L8;
        r0.append("key=");
        r0.append(r3.key);
        r0.append(",path=");
        r0.append(r3.path);
    L13:
        if (r5.sync_data_strategy == null) goto L16;
        r0.append(",sync_data_strategy=");
        r0.append(r5.sync_data_strategy.getValue());
    L16:
        if (r5.scene == null) goto L18;
        r0.append(",scene=");
        r0.append(r5.scene.getValue());
    L18:
        r0.append(",from_local=");
        r0.append(r5.from_local);
        r0.append(",is_reaction=");
        r0.append(r5.is_reaction);
        r0.append(",is_emojis=");
        r0.append(r5.is_emojis);
    L20:
        return r0.toString();
    }

    private MGetResourcesRequest.Set generateRequestSet(ResourceRequestBaseSet r2) {
        return generateRequestSet(r2, 0);
    }

    private Resource getFirstOrNull(Map<String, Resource> r3) {
        if (r3 != null) goto L5;
    L11:
        return null;
    L5:
        if (r3.isEmpty() == true) goto L11;
        Iterator<Map.Entry<String, Resource>> r4 = r3.entrySet().iterator();
        if (r4.hasNext() == false) goto L11;
        return r4.next().getValue();
    }

    private void logResource(Resource r3) {
        StringBuilder r0 = new StringBuilder();
        if (r3 == null) goto L5;
        r0.append("key:");
        r0.append(r3.a);
        r0.append("path:");
        r0.append(r3.b);
        r0.append("isEncrypted:");
        r0.append(r3.c);
        r0.append("errorResult:");
        r0.append(r3.e);
    L5:
        Log.i(TAG, "logResource, " + r0);
    }

    private String syncGetResourceInner(MGetResourcesRequest.Builder r3) {
        Resource r4 = syncGetResourceInner(r3, null, com.ss.android.lark.sdk.a.a());
        if (r4 != null) goto L6;
        return null;
    L6:
        return r4.b;
    }

    public static /* synthetic */ void access$000(ImageService r0, Resource r1) {
        r0.logResource(r1);
    }

    public static /* synthetic */ Resource access$100(ImageService r0, Map r1) {
        return r0.getFirstOrNull(r1);
    }

    private h generateRequestParams(String r1, boolean r2) {
        h r3 = new h();
        r3.b = r2;
        return r3;
    }

    private MGetResourcesRequest.Set generateRequestSet(ResourceRequestBaseSet r3, int r4) {
        MGetResourcesRequest.Set.Builder r5 = new MGetResourcesRequest.Set.Builder().key(r3.b).path(r3.c);
        r5.fs_unit = r3.d;
        r5.image_crypto = r3.e;
        if (r3.getType() != ResourceRequestBaseSet.Type.AVATAR) goto L6;
        g r6 = (g) r3;
        r5.avatarParams(null);
        r5.avatar_fs_unit_params(null);
    L6:
        return r5.build();
    }

    public String getEmojiImage(String r3, String r4) {
        ResourceRequestBaseSet r0 = new ResourceRequestBaseSet(r4, r3, null, null);
        ArrayList r5 = new ArrayList();
        r5.add(generateRequestSet(r0));
        MGetResourcesRequest.Builder r6 = new MGetResourcesRequest.Builder().sets(r5);
        r6.is_emojis(Boolean.TRUE).is_reaction(Boolean.FALSE);
        return syncGetResourceInner(r6);
    }

    public String getEncryptImageInMainProcess(String r3, String r4) {
        ResourceRequestBaseSet r0 = new ResourceRequestBaseSet(r4, r3, null, null);
        ArrayList r5 = new ArrayList();
        r5.add(generateRequestSet(r0));
        return syncGetResourceInner(new MGetResourcesRequest.Builder().sets(r5));
    }

    public String getReactionImage(String r3, String r4) {
        ResourceRequestBaseSet r0 = new ResourceRequestBaseSet(r4, r3, null, null);
        ArrayList r5 = new ArrayList();
        r5.add(generateRequestSet(r0));
        MGetResourcesRequest.Builder r6 = new MGetResourcesRequest.Builder().sets(r5);
        r6.is_reaction(Boolean.TRUE);
        return syncGetResourceInner(r6);
    }

    private Resource syncGetResourceInner(MGetResourcesRequest.Builder r8, h r9, String r10) {
        if (r10 != null) goto L4;
        r10 = com.ss.android.lark.sdk.a.a();
    L4:
        String r2 = r10;
        Iterator r11 = r8.sets.iterator();
    L6:
        if (r11.hasNext() == false) goto L13;
        MGetResourcesRequest.Set r0 = (MGetResourcesRequest.Set) r11.next();
        if (TextUtils.isEmpty(r0.key) == false) goto L12;
        if (TextUtils.isEmpty(r0.path) == false) goto L12;
        Log.e(TAG, "key and path is empty.please check your code");
    L12:
        SteamImageLoadTraceReporter.INSTANCE.put(r0.key, r2);
        goto L6
    L13:
        final CountDownLatch r12 = new CountDownLatch(1);
        final SdkSender.d r6 = new SdkSender.d();
        final String r1 = builderToString(r8);
        SdkSender.asynSendRequestNonWrap(Command.MGET_RESOURCES, r8, r2, new AnonymousClass5(this, r1, r6, r12), new d(this), r9);
        r12.await(MmUploadRetryConfigSetting.MAX_INTERVAL_MS, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L16
    L18:
        Resource r13 = (Resource) r6.a;
        if (r13 != null) goto L28;
        Resource r14 = new Resource();
        r14.e = r6.b;
        return r14;
    L28:
        return r13;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public String getAvatarPath(String r4, String r5, int r6, float r7) {
        if (z.e(LarkContext.getApplication()) == true) goto L5;
        jrc.b r0 = jrc.b.a.a;
        Application r1 = LarkContext.getApplication();
        r0.getClass();
        IResourceManisService r2 = (IResourceManisService) jrc.b.a(r1, IResourceManisService.class);
        Log.i(TAG, "getAvatarPath in subProcess:" + z.b(LarkContext.getApplication()));
        if (r2 != null) goto L9;
        return null;
    L9:
        return r2.getAvatarPath(r4, r5, r6, r7);
    L5:
        return getAvatarPathInMainProcess(r4, r5, r6, r7);
    }

    public String getAvatarPathInMainProcess(String r2, String r3, int r4, float r5) {
        GetAvatarPathRequest.Builder r6 = new GetAvatarPathRequest.Builder().entity_id(r2).key(r3).dp_size(Integer.valueOf(r4)).dpr(Float.valueOf(r5));
        return (String) SdkSender.sendRequest(Command.GET_AVATAR_PATH, r6, WAIT_TIMEOUT_IN_MILLIS, new b());
    }

    public void asyncGetAvatarPath(String r2, String r3, int r4, float r5, IGetDataCallback<String> r6) {
        GetAvatarPathRequest.Builder r7 = new GetAvatarPathRequest.Builder().entity_id(r2).key(r3).dp_size(Integer.valueOf(r4)).dpr(Float.valueOf(r5));
        SdkSender.asynSendRequestNonWrap(Command.GET_AVATAR_PATH, r7, r6, new c());
    }

    public byte[] getAvatar(long r3, String r5, int r6, float r7, String r8) {
        Map r0 = com.bytedance.lark.sdk.d.e;
        com.bytedance.lark.sdk.d.f.a.getClass();
        byte[] r4 = Sdk._getAvatar(r3, r5, r6, r7, r8);     // Catch: Exception -> L5
        Log.i("sdk", "getAvatar native success, key is:" + r5);     // Catch: Exception -> L5
        return r4;
    L5:
        e = move-exception;
        e.printStackTrace();
        Log.e("sdk", "getAvatar failed, key is:" + r5, e);
        return null;
    }

    public Resource getPassThroughImage(String r2, String r3, String r4, SerCrypto r5, ImageSetPassThrough.FileType r6) {
        ArrayList r7 = new ArrayList();
        r7.add(new ImageSetPassThrough.Builder().key(r3).fs_unit(r4).crypto(r5).file_type(r6).build());
        MGetResourcesRequest.Builder r8 = new MGetResourcesRequest.Builder().image_set_pass_through(r7);
        h r9 = new h();
        r9.b = true;
        return syncGetResourceInner(r8, r9, com.ss.android.lark.sdk.a.a());
    }

    public Resource getAvatarImageResource(long r4, String r6, int r7, float r8, String r9, String r10) {
        final CountDownLatch r0 = new CountDownLatch(1);
        if (r10 != null) goto L5;
        r10 = com.ss.android.lark.sdk.a.a();
    L5:
        final SdkSender.d r1 = new SdkSender.d();
        GetAvatarPathRequest.Builder r5 = new GetAvatarPathRequest.Builder().entity_id(String.valueOf(r4)).key(r6).dp_size(Integer.valueOf(r7)).dpr(Float.valueOf(r8)).format(r9);
        SdkSender.asynSendRequestNonWrap(Command.GET_AVATAR_PATH, r5, r10, new AnonymousClass1(this, r1, r0), new a());
        r0.await(MmUploadRetryConfigSetting.MAX_INTERVAL_MS, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L8
    L10:
        Resource r11 = (Resource) r1.a;
        if (r11 != null) goto L16;
        Resource r12 = new Resource();
        r12.e = r1.b;
        return r12;
    L16:
        return r11;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public Resource getEncryptImage(String r9, String r10, String r11, ByteString r12, String r13, boolean r14) {
        return getEncryptImage(r9, r10, r11, r12, r13, r14, 0);
    }

    public Resource getEncryptImageInMainProcess(String r9, String r10, String r11, ByteString r12, String r13, boolean r14) {
        return getEncryptImageInMainProcess(r9, r10, r11, r12, r13, r14, 0);
    }

    public Resource getEncryptImage(String r10, String r11, String r12, ByteString r13, String r14, boolean r15, int r16) {
        if (z.e(LarkContext.getApplication()) == true) goto L5;
        jrc.b r0 = jrc.b.a.a;
        Application r1 = LarkContext.getApplication();
        r0.getClass();
        IResourceManisService r2 = (IResourceManisService) jrc.b.a(r1, IResourceManisService.class);
        if (r2 != null) goto L9;
        return null;
    L9:
        return r2.getEncryptImage(r10, r11, r12, r13.toString(), r14, r15, r16);
    L5:
        return getEncryptImageInMainProcess(r10, r11, r12, r13, r14, r15, r16);
    }

    public Resource getEncryptImageInMainProcess(String r3, String r4, String r5, ByteString r6, String r7, boolean r8, int r9) {
        ResourceRequestBaseSet r0 = new ResourceRequestBaseSet(r4, r3, null, null);
        if (TextUtils.isEmpty(r5) == true) goto L8;
        if (r6 == null) goto L8;
        if (r6.size() <= 0) goto L8;
        r0.e = r6;
        r0.d = r5;
    L8:
        ArrayList r10 = new ArrayList();
        r10.add(generateRequestSet(r0, r9));
        MGetResourcesRequest.Builder r11 = new MGetResourcesRequest.Builder().sets(r10);
        if (r9 != 0) goto L11;
    L13:
        h r12 = generateRequestParams(r7, r8);
        StringBuilder r13 = new StringBuilder("[getEncryptImageInMainProcess] key:");
        r13.append(r4);
        r13.append(" fsUnit:");
        r13.append(r5);
        r13.append(" crypto is not null:");
        if (r6 == null) goto L16;
        boolean r14 = true;
    L17:
        r13.append(r14);
        Log.i(TAG, r13.toString());
        return syncGetResourceInner(r11, r12, r7);
    L16:
        r14 = false;
        goto L17
    L11:
        if (FeatureGatingModule.getFeatureGatingService().isEnable(FEATURE_CHAT_DRAFT_RESET_SYNC) == false) goto L13;
        r11.scene(DownloadFileScene.Draft);
        goto L13
    }
}
