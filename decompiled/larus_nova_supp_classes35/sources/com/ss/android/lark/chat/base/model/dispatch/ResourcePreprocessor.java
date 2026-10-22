package com.ss.android.lark.chat.base.model.dispatch;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.PreprocessResourceRequest;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.LarkUriUtil;
import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.c1;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.videosend.compress.VideoCompressResult;
import com.ss.android.lark.videosend.compress.VideoPreCompressManager;
import com.ss.android.lark.videosend.tools.CompressPathManager;
import com.ss.ttvideoengine.utils.Error;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ResourcePreprocessor implements qzb.a {
    public final okb.b a;
    public final boolean b;
    public final Map<String, d> c;
    public final Handler d;

    public static final enum FileType extends Enum<FileType> {
        public static final FileType FILE = null;
        public static final FileType IMAGE = null;
        public static final FileType MEDIA = null;
        public static final /* synthetic */ FileType[] a = null;
        public int index;

        static {
            FileType r0 = new FileType("FILE", 0, 1);
            FILE = r0;
            FileType r1 = new FileType("IMAGE", 1, 2);
            IMAGE = r1;
            FileType r4 = new FileType("MEDIA", 2, 5);
            MEDIA = r4;
            a = new FileType[]{r0, r1, r4};
        }

        public static FileType[] values() {
            return (FileType[]) a.clone();
        }

        public static FileType fromValue(int r5) {
            FileType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            FileType r3 = r0[r2];
            if (r3.index == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L9:
            return FILE;
        }

        public static FileType valueOf(String r1) {
            return (FileType) r27.a.a(FileType.class, r1);
        }

        public FileType(String r1, int r2, int r3) {
            super(r1, r2);
            this.index = r3;
        }
    }

    public class ImagePreprocessor extends e {
        public final /* synthetic */ ResourcePreprocessor a;

        public ImagePreprocessor(ResourcePreprocessor r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor.e
        public final boolean a(d r1) {
            return !TextUtils.isEmpty(r1.b);
        }

        @Override // com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor.e
        public final void b(final d r9, final IGetDataCallback<String> r10) {
            boolean r0 = true;
            File r1 = com.ss.android.lark.vfs.d.a().G(r9.b, true);     // Catch: IOException -> L5
        L8:
            if (r1 != null) goto L10;
        L22:
            Log.e("ResourcePreprocessor", "preprocess failed, file not exist path = " + r9.b);
            return;
        L10:
            if (r1.exists() == false) goto L22;
            final IGetDataCallback<String> r3 = new AnonymousClass1(this, r9, r10);
            if (r9.h == true) goto L20;
            final String r11 = r1.getName();
            Log.i("ResourcePreprocessor", "preprocessImage - compress start: " + r11);
            int r12 = blb.c.a;
            Context r13 = ImSdk.a.getContext();
            String r2 = r1.getPath();
            ResourcePreprocessor r4 = this.a;
            r4.getClass();
            boolean r5 = ((Boolean) ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(gua.a.class, true)).booleanValue();
            Log.i("ResourcePreprocessor", "isEnableConvertWebp:" + r4.b + ", isExperimentEnable:" + r5);
            if (r4.b == false) goto L18;
            if (r5 == false) goto L18;
        L19:
            blb.c.d(r13, r2, r0, new AnonymousClass2(this, r11, r3));
            return;
        L18:
            r0 = false;
            goto L19
        L20:
            r3.onSuccess(r1.getPath());
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            r1 = null;
            goto L8
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FileType.values().length];
            a = r0;
            r0[FileType.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[FileType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[FileType.MEDIA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class b extends e {
        public b() {
        }

        @Override // com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor.e
        public final boolean a(d r2) {
            if (TextUtils.isEmpty(r2.b) == true) goto L5;
        L8:
            return true;
        L5:
            if (r2.c != null) goto L8;
            return false;
        }

        @Override // com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor.e
        public final void b(d r6, IGetDataCallback<String> r7) {
            if (TextUtils.isEmpty(r6.b) == false) goto L5;
            String r0 = LarkUriUtil.e(LarkContext.getApplication(), r6.c);
        L7:
            if (TextUtils.isEmpty(r0) == false) goto L10;
            Log.w("ResourcePreprocessor", "preprocess file path is empty");
            Exception r8 = new Exception("unknown error");
            ErrorResult r1 = new ErrorResult(0);
            ErrorResult.access$002(r1, -1);
            ErrorResult.access$102(r1, Error.ParameterNull);
            ErrorResult.access$202(r1, 0);
            ErrorResult.access$302(r1, r8);
            ErrorResult.access$402(r1, BuildConfig.FLAVOR);
            ErrorResult.access$502(r1, "Get file path failed");
            ErrorResult.access$602(r1, BuildConfig.FLAVOR);
            ErrorResult.access$702(r1, BuildConfig.FLAVOR);
            ErrorResult.access$802(r1, 0);
            ErrorResult.access$902(r1, null);
            ErrorResult.access$1002(r1, null);
            ErrorResult.access$1102(r1, null);
            r7.onError(r1);
            return;
        L10:
            String r2 = ResourcePreprocessor.c(PreprocessResourceRequest.FileType.FILE, r0, Long.valueOf(c1.b(ImSdk.a.getContext(), r6.c)));
            Log.d("ResourcePreprocessor", "preprocess file onSuccess:" + r2);
            if (TextUtils.isEmpty(r2) == true) goto L13;
            r6.d = r2;
        L13:
            r7.onSuccess(r2);
            return;
        L5:
            r0 = r6.b;
            goto L7
        }
    }

    public static final class c {
        public static final ResourcePreprocessor a = null;

        static {
            a = new ResourcePreprocessor();
        }
    }

    public static class d {
        public final FileType a;
        public final String b;
        public final Uri c;
        public String d;
        public String e;
        public String f;
        public final boolean g;
        public final boolean h;

        public final int hashCode() {
            return Objects.hash(new Object[]{this.a, this.b, Boolean.valueOf(this.g), Boolean.valueOf(this.h)});
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (this.g == r6.g) goto L11;
        L17:
            return false;
        L11:
            if (this.h != r6.h) goto L17;
            if (this.a != r6.a) goto L17;
            if (Objects.equals(this.b, r6.b) == false) goto L17;
            return true;
        }

        public d(FileType r1, String r2, Uri r3, boolean r4, boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.g = r4;
            this.h = r5;
        }
    }

    public static abstract class e {
        public e() {
        }

        public abstract boolean a(d r1);

        public abstract void b(d r1, IGetDataCallback<String> r2);
    }

    public static class f extends e {

        public class a extends oac.b {
            public final /* synthetic */ d b;
            public final /* synthetic */ String c;
            public final /* synthetic */ IGetDataCallback d;
            public final /* synthetic */ f e;

            public final void c(VideoCompressResult r5) {
                super.c(r5);
                ExecutorService r6 = CoreThreadPool.getDefault().getCachedThreadPool();
                final d r0 = this.b;
                final String r1 = this.c;
                final IGetDataCallback r2 = this.d;
                r6.execute(new m(this, r0, r1, r2));
            }

            public a(f r1, String r2, d r3, String r4, IGetDataCallback r5) {
                this.e = r1;
                this.b = r3;
                this.c = r4;
                this.d = r5;
                super(r2, null);
            }
        }

        public f() {
        }

        @Override // com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor.e
        public final boolean a(d r1) {
            return !TextUtils.isEmpty(r1.b);
        }

        @Override // com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor.e
        public final void b(d r12, IGetDataCallback<String> r13) {
            String r6 = r12.b;
            if (new PolarisFileWrapper(r6).exists() == true) goto L5;
            return;
        L5:
            String r4 = CompressPathManager.generateCompressFilePath(r6, Boolean.valueOf(r12.h));
            String r0 = com.ss.android.lark.sdk.a.a();
            if (TextUtils.isEmpty(r4) == false) goto L8;
            return;
        L8:
            if (TextUtils.isEmpty(r0) == true) goto L17;
            r12.f = r0;
            if (VFSFiles.b.i(r4).canRead() == false) goto L13;
            c(r12, r4, r13);
            return;
        L13:
            VideoPreCompressManager.compress(new VideoPreCompressManager.a(VideoPreCompressManager.Scene.SELECT_VIDEO, r6, r12.h, new a(this, r6, r12, r4, r13)));
            return;
        }

        public static void c(d r2, String r3, IGetDataCallback r4) {
            String r0 = ResourcePreprocessor.c(PreprocessResourceRequest.FileType.MEDIA, r3, null);
            if (TextUtils.isEmpty(r0) == true) goto L6;
            r2.d = r0;
        L6:
            if (TextUtils.isEmpty(r3) == true) goto L8;
            r2.e = r3;
        L8:
            if (r4 == null) goto L11;
            r4.onSuccess(r0);
            return;
        }
    }

    public ResourcePreprocessor() {
        okb.b r0 = ImSdkProxy.c();
        this.a = r0;
        this.b = r0.isFeatureGatingEnable("lark.android.img.convert.to.webp");
        this.c = Collections.synchronizedMap(new HashMap());
        if (this.d != null) goto L5;
        this.d = CoreThreadPool.newThreadHandler("ResourcePreprocessor", new k(this));
    L5:
        ImSdkProxy.e().registerUserSwitchListener(this);
    }

    public static String a(d r2) {
        FileType r0 = r2.a;
        if (r0 != FileType.MEDIA) goto L6;
        return r2.e;
    L6:
        if (r0 != FileType.IMAGE) goto L9;
        return r2.b + "_" + r2.h;
    L9:
        if (r0 != FileType.FILE) goto L15;
        Uri r1 = r2.c;
        if (r1 == null) goto L13;
        String r3 = r1.getPath();
    L14:
        Log.d("ResourcePreprocessor", "file getKeyPath:" + r3);
        return r3;
    L13:
        r3 = r2.b;
        goto L14
    L15:
        return null;
    }

    public final void d(d r7) {
        FileType r0 = r7.a;
        if (r0 != FileType.MEDIA) goto L6;
    L10:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L16;
        Log.i("ResourcePreprocessor", "preprocessResource not enabled，file type is " + r7.a);
        return;
    L16:
        Log.i("ResourcePreprocessor", "delayPreprocessResource:" + r7.b + "/ preprocessKey:" + r7.d + "/ checked:" + r7.g + "/isOrigin:" + r7.h + "/fileType:" + r7.a + "/" + this.c.get(a(r7)));
        if (r7.g == false) goto L19;
        Handler r2 = this.d;
        r2.sendMessage(r2.obtainMessage(0, r7));
        return;
    L19:
        d r3 = b(a(r7), false);
        this.d.removeMessages(0, r3);
        if (r3 != null) goto L22;
        return;
    L22:
        if (TextUtils.isEmpty(r3.d) == true) goto L27;
        Handler r4 = this.d;
        r4.sendMessage(r4.obtainMessage(1, r7));
        return;
    L27:
        return;
    L6:
        if (r0 == FileType.FILE) goto L10;
        if (r0 == FileType.IMAGE) goto L10;
        r1 = false;
        goto L13
    }

    public final d b(String r2, boolean r3) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return null;
    L6:
        if (r3 == false) goto L10;
        return this.c.remove(r2);
    L10:
        return this.c.get(r2);
    }

    public static String c(PreprocessResourceRequest.FileType r1, String r2, Long r3) {
        String r4 = (String) SdkSender.syncSend(Command.PREPROCESS_RESOURCE, new PreprocessResourceRequest.Builder().file_type(r1).file_path(r2).file_handle(r3), new l());
        Log.i("ResourcePreprocessor", "notifySdkPreprocessResource:" + r4);
        return r4;
    }
}
