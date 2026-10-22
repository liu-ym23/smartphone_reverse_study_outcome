package com.ss.android.lark.resource.service.impl;

import android.text.TextUtils;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.lark.pb.basic.v1.CancelDataCleanRequest;
import com.bytedance.lark.pb.basic.v1.CancelDataCleanResponse;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.TriggerDataCleanRequest;
import com.bytedance.lark.pb.basic.v1.TriggerDataCleanResponse;
import com.bytedance.lark.pb.media.v1.AvatarFsUnitParams;
import com.bytedance.lark.pb.media.v1.CancelResourceRequest;
import com.bytedance.lark.pb.media.v1.CancelResourceResponse;
import com.bytedance.lark.pb.media.v1.ClearResourcesRequest;
import com.bytedance.lark.pb.media.v1.DeleteResourcesRequest;
import com.bytedance.lark.pb.media.v1.DeleteResourcesResponse;
import com.bytedance.lark.pb.media.v1.DownloadFileOptions;
import com.bytedance.lark.pb.media.v1.DownloadFileScene;
import com.bytedance.lark.pb.media.v1.DownloadResourceRequest;
import com.bytedance.lark.pb.media.v1.DownloadResourceResponse;
import com.bytedance.lark.pb.media.v1.GetResourceUrlsRequest;
import com.bytedance.lark.pb.media.v1.GetResourceUrlsResponse;
import com.bytedance.lark.pb.media.v1.GetResourcesSizeRequest;
import com.bytedance.lark.pb.media.v1.GetResourcesSizeResponse;
import com.bytedance.lark.pb.media.v1.MGetResourcesRequest;
import com.bytedance.lark.pb.media.v1.MGetResourcesResponse;
import com.bytedance.lark.pb.media.v1.VisitInfo;
import com.bytedance.lark.sdk.Sdk;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.ApiUtils;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import com.suite.lark.platform.service.resourcerepository.api.ResourceRequestBaseSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(qpc.e.class)
public class ResourceService implements qpc.e {
    private static final int SIZE_MIDDLE = 240;
    private static final int SIZE_SMALL = 72;
    private static final String TAG = "ResourceService";

    public class a implements SdkSender.IParser<TriggerDataCleanResponse> {
        public a() {
        }

        public final Object parse(byte[] r2) throws IOException {
            return (TriggerDataCleanResponse) TriggerDataCleanResponse.ADAPTER.decode(r2);
        }
    }

    public class b implements SdkSender.IParser<CancelDataCleanResponse> {
        public b() {
        }

        public final Object parse(byte[] r2) throws IOException {
            return (CancelDataCleanResponse) CancelDataCleanResponse.ADAPTER.decode(r2);
        }
    }

    public class c implements SdkSender.IParser<Map<String, Resource>> {
        public c() {
        }

        public final Object parse(byte[] r2) throws IOException {
            return com.ss.android.lark.resource.service.impl.a.a(((MGetResourcesResponse) MGetResourcesResponse.ADAPTER.decode(r2)).resources);
        }
    }

    public class d implements SdkSender.IParser<Map<String, Resource>> {
        public d() {
        }

        public final Object parse(byte[] r2) throws IOException {
            return com.ss.android.lark.resource.service.impl.a.a(((MGetResourcesResponse) MGetResourcesResponse.ADAPTER.decode(r2)).resources);
        }
    }

    public class e implements SdkSender.IParser<Map<String, Resource>> {
        public e() {
        }

        public final Object parse(byte[] r2) throws IOException {
            return com.ss.android.lark.resource.service.impl.a.a(((MGetResourcesResponse) MGetResourcesResponse.ADAPTER.decode(r2)).resources);
        }
    }

    public class f implements SdkSender.IParser<List<String>> {
        public f() {
        }

        public final Object parse(byte[] r2) throws IOException {
            return new ArrayList(((DeleteResourcesResponse) DeleteResourcesResponse.ADAPTER.decode(r2)).success_keys);
        }
    }

    public class g implements SdkSender.IParser<String> {
        public final /* bridge */ /* synthetic */ Object parse(byte[] r1) throws IOException {
            return "";
        }

        public g() {
        }
    }

    public class h implements SdkSender.IParser<Float> {
        public h() {
        }

        public final Object parse(byte[] r2) throws IOException {
            return ((GetResourcesSizeResponse) GetResourcesSizeResponse.ADAPTER.decode(r2)).size_m;
        }
    }

    public class i implements SdkSender.IParser<Boolean> {
        public i() {
        }

        public final Object parse(byte[] r2) throws IOException {
            DownloadResourceResponse r3 = (DownloadResourceResponse) DownloadResourceResponse.ADAPTER.decode(r2);
            return Boolean.TRUE;
        }
    }

    public class j implements SdkSender.IParser<Boolean> {
        public j() {
        }

        public final Object parse(byte[] r2) throws IOException {
            CancelResourceResponse r3 = (CancelResourceResponse) CancelResourceResponse.ADAPTER.decode(r2);
            return Boolean.TRUE;
        }
    }

    public class k implements SdkSender.IParser<String> {
        public k() {
        }

        public final Object parse(byte[] r2) throws IOException {
            List r3 = ((GetResourceUrlsResponse) GetResourceUrlsResponse.ADAPTER.decode(r2)).urls;
            if (CollectionUtils.isEmpty(r3) == false) goto L6;
            return "";
        L6:
            return (String) ListProtector.get(r3, 0);
        }
    }

    public qpc.a getImageService() {
        return (qpc.a) ApiUtils.getApi(qpc.a.class);
    }

    public ResourceService() {
    }

    private MGetResourcesRequest.Set generateRequestSet(ResourceRequestBaseSet r7) {
        MGetResourcesRequest.Set.Builder r0 = new MGetResourcesRequest.Set.Builder().key(r7.b).path(r7.c);
        DownloadFileOptions.Builder r3 = null;
        if (r7.getType() != ResourceRequestBaseSet.Type.AVATAR) goto L6;
        com.ss.android.lark.resource.service.impl.g r1 = (com.ss.android.lark.resource.service.impl.g) r7;
        r0.avatarParams(null);
        r0.avatar_fs_unit_params(null);
    L6:
        if (TextUtils.isEmpty(r7.f) == true) goto L9;
        r3 = new DownloadFileOptions.Builder().preview_token(r7.f);
    L9:
        if (TextUtils.isEmpty(r7.g) == true) goto L14;
        if (r3 != null) goto L12;
        r3 = new DownloadFileOptions.Builder();
    L12:
        r3.msg_link_token(r7.g);
    L14:
        if (r7.h == null) goto L18;
        if (r3 != null) goto L17;
        r3 = new DownloadFileOptions.Builder();
    L17:
        ResourceRequestBaseSet.a r8 = r7.h;
        r3.visit_info(new VisitInfo.Builder().scene_type(DownloadFileScene.fromValue(r8.a)).entity_type(File.EntityType.fromValue(r8.b)).entity_id(r8.c).inner_msg_id(Long.valueOf(r8.d)).auth_file_key(r8.e).im_ext(r8.f).ext(r8.g).build());
    L18:
        if (r3 == null) goto L21;
        r0.options(r3.build());
    L21:
        return r0.build();
    }

    public void addPushPushResourceListener(qpc.c r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        ResourcePush r0 = ResourcePush.a.a;
        com.ss.android.lark.sdk.f.a(r0.a, r4, new com.ss.android.lark.resource.service.impl.b(r0));
    }

    public void addPushResourceDownloadProgressListener(qpc.b r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        ResourcePush r0 = ResourcePush.a.a;
        ((CopyOnWriteArrayList) r0.c).add(r4);
        com.ss.android.lark.sdk.f.a(r0.d, r4, new com.ss.android.lark.resource.service.impl.d(r0));
    }

    public void addPushResourceUploadProgressListener(qpc.d r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        ResourcePush r0 = ResourcePush.a.a;
        ((CopyOnWriteArrayList) r0.b).add(r4);
        com.ss.android.lark.sdk.f.a(r0.d, r4, new com.ss.android.lark.resource.service.impl.d(r0));
    }

    public void cancelDataClean(IGetDataCallback<CancelDataCleanResponse> r4) {
        CancelDataCleanRequest.Builder r0 = new CancelDataCleanRequest.Builder();
        SdkSender.asynSendRequestNonWrap(Command.CANCEL_DATA_CLEAN, r0, r4, new b());
    }

    public void cancelDownloadResource(String r4) {
        CancelResourceRequest.Builder r5 = new CancelResourceRequest.Builder().key(r4);
        SdkSender.asynSendRequestNonWrap(Command.CANCEL_RESOURCE, r5, null, new j());
    }

    public void clearResources(IGetDataCallback<String> r4) {
        ClearResourcesRequest.Builder r0 = new ClearResourcesRequest.Builder();
        SdkSender.asynSendRequestNonWrap(Command.CLEAR_RESOURCES, r0, r4, new g());
    }

    public byte[] decryptResource(String r3) {
        Map r0 = com.bytedance.lark.sdk.d.e;
        com.bytedance.lark.sdk.d.f.a.getClass();
        return Sdk._ResourceEncryptWithSdkKeyReadAll(r3);
    L5:
        Log.e("sdk", "get decrypt data failed path = " + r3);
        return null;
    }

    public Map<String, Resource> getResources(List<ResourceRequestBaseSet> r3) {
        ArrayList r0 = new ArrayList();
        Iterator<ResourceRequestBaseSet> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(generateRequestSet(r4.next()));
        goto L4
    L6:
        MGetResourcesRequest.Builder r5 = new MGetResourcesRequest.Builder().sets(r0);
        Map<String, Resource> r6 = (Map) SdkSender.syncSend(Command.MGET_RESOURCES, r5, new c());
        if (r6 == null) goto L9;
        return r6;
    L9:
        return new HashMap();
    }

    public void getResourcesSize(IGetDataCallback<Float> r4) {
        GetResourcesSizeRequest.Builder r0 = new GetResourcesSizeRequest.Builder();
        SdkSender.asynSendRequestNonWrap(Command.GET_RESOURCES_SIZE, r0, r4, new h());
    }

    public void removePushResourceDownloadProgressListener(qpc.b r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ResourcePush r0 = ResourcePush.a.a;
        ((CopyOnWriteArrayList) r0.c).remove(r3);
        List<Object> r1 = r0.d;
        monitor-enter(r1);
        CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) r1;     // Catch: Throwable -> L20
        r2.remove(r3);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        if (r2.isEmpty() == false) goto L19;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (r2.isEmpty() == false) goto L14;
        com.ss.android.lark.sdk.g.e.a.c(Command.PUSH_RESOURCE_PROGRESS);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L19:
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public void removePushResourceListener(qpc.c r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        List<qpc.c> r0 = ResourcePush.a.a.a;
        if (r3 == null) goto L30;
        monitor-enter(r0);
        r0.remove(r3);     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        if (r0.isEmpty() == false) goto L21;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (r0.isEmpty() == false) goto L16;
        com.ss.android.lark.sdk.g.e.a.c(Command.PUSH_RESOURCE);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L21:
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public void removePushResourceUploadProgressListener(qpc.d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ResourcePush r0 = ResourcePush.a.a;
        ((CopyOnWriteArrayList) r0.b).remove(r3);
        List<Object> r1 = r0.d;
        monitor-enter(r1);
        CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) r1;     // Catch: Throwable -> L20
        r2.remove(r3);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        if (r2.isEmpty() == false) goto L19;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (r2.isEmpty() == false) goto L14;
        com.ss.android.lark.sdk.g.e.a.c(Command.PUSH_RESOURCE_PROGRESS);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L19:
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public Map<String, Resource> synGetResources(List<ResourceRequestBaseSet> r4) {
        ArrayList r0 = new ArrayList();
        Iterator<ResourceRequestBaseSet> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(generateRequestSet(r5.next()));
        goto L4
    L6:
        MGetResourcesRequest.Builder r6 = new MGetResourcesRequest.Builder().sets(r0);
        Map<String, Resource> r7 = (Map) SdkSender.sendRequest(Command.MGET_RESOURCES, r6, 30000, new d());
        if (r7 == null) goto L9;
        return r7;
    L9:
        return new HashMap();
    }

    private AvatarFsUnitParams generatePbAvatarFsUnitParams(int r3, int r4) {
        return new AvatarFsUnitParams.Builder().cut_type(AvatarFsUnitParams.CutType.fromValue(AvatarFsUnitParams.CutType.FACE.getValue())).size_type(generatePbImageSizeType(r3, r4)).build();
    }

    private AvatarFsUnitParams.ImageSizeType generatePbImageSizeType(int r2, int r3) {
        if (r2 > SIZE_SMALL) goto L8;
        if (r3 > SIZE_SMALL) goto L8;
        return AvatarFsUnitParams.ImageSizeType.SMALL;
    L8:
        if (r2 > SIZE_MIDDLE) goto L13;
        if (r3 > SIZE_MIDDLE) goto L13;
        return AvatarFsUnitParams.ImageSizeType.MIDDLE;
    L13:
        return AvatarFsUnitParams.ImageSizeType.ORIGIN;
    }

    public void deleteResources(List<String> r3, IGetDataCallback<List<String>> r4) {
        DeleteResourcesRequest.Builder r5 = new DeleteResourcesRequest.Builder().keys(r3);
        SdkSender.asynSendRequestNonWrap(Command.DELETE_RESOURCES, r5, r4, new f());
    }

    public void downloadResource(String r2, String r3, String r4) {
        DownloadResourceRequest.Builder r5 = new DownloadResourceRequest.Builder().key(r2).path(r3).url(r4);
        SdkSender.asynSendRequestNonWrap(Command.DOWNLOAD_RESOURCE, r5, null, new i());
    }

    public String getResUrlByResKey(String r2, int r3, int r4) {
        return getResUrlByResKey(r2, null, r3, r4);
    }

    public void getResources(List<ResourceRequestBaseSet> r3, int r4, IGetDataCallback<Map<String, Resource>> r5) {
        ArrayList r0 = new ArrayList();
        Iterator<ResourceRequestBaseSet> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.add(generateRequestSet(r6.next()));
        goto L4
    L6:
        MGetResourcesRequest.Builder r7 = new MGetResourcesRequest.Builder().sets(r0);
        if (r4 == (-99)) goto L9;
        r7.scene(DownloadFileScene.fromValue(r4));
    L9:
        SdkSender.asynSendRequestNonWrap(Command.MGET_RESOURCES, r7, r5, new e());
    }

    public String getResUrlByResKey(String r2, String r3, int r4, int r5) {
        GetResourceUrlsRequest.Builder r0 = new GetResourceUrlsRequest.Builder();
        r0.key(r2);
        r0.fs_unit(r3);
        r0.avatar_fs_unit_params(generatePbAvatarFsUnitParams(r4, r5));
        SdkSender.d r6 = SdkSender.syncSendMayError(Command.GET_RESOURCE_URLS, r0, new k());
        if (r6.b == null) goto L7;
        Log.e(TAG, "get resource url failed: " + r6.b.toString());
        return "";
    L7:
        if (TextUtils.isEmpty((CharSequence) r6.a) == false) goto L11;
        Log.e(TAG, "get resource url failed: resource url is empty");
        return "";
    L11:
        return (String) r6.a;
    }

    public void triggerDataClean(Integer r2, Integer r3, TriggerDataCleanRequest.CleanType r4, IGetDataCallback<TriggerDataCleanResponse> r5) {
        TriggerDataCleanRequest.Builder r6 = new TriggerDataCleanRequest.Builder().time_limit(r2).exec_time_limit(r3).clean_type(r4);
        SdkSender.asynSendRequestNonWrap(Command.TRIGGER_DATA_CLEAN, r6, r5, new a());
    }
}
