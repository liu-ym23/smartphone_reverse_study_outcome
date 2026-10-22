package blb;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ IGetDataCallback<String> d;

        public a(String r1, boolean r2, Context r3, IGetDataCallback<String> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            com.ss.android.lark.image.uploader.entity.b.a r0 = new com.ss.android.lark.image.uploader.entity.b.a();
            r0.c(this.a);
            r0.i = this.b;
            com.ss.android.lark.image.uploader.entity.b r1 = r0.b();
            ImageInfo r2 = com.ss.android.lark.image.uploader.utils.b.d(this.a, true, false);
            int r3 = c.a;
            String r4 = c.b(this.c, this.a, r2, r1, null);
            String r5 = com.ss.android.lark.vfs.d.a().G(r4, true).getAbsolutePath();
            if (TextUtils.isEmpty(r5) == false) goto L5;
        L8:
            this.d.onError(new ErrorResult("compress failed"));
            return;
        L5:
            if (new PolarisFileWrapper(r5).exists() == false) goto L8;
            this.d.onSuccess(r5);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static void c(com.ss.android.lark.image.uploader.entity.b r5, ImageUploadTask r6) {
        Intrinsics.checkNotNullParameter(r5, "uploadImage");
        Intrinsics.checkNotNullParameter(r6, "imageUploadTask");
        String r0 = r5.a;
        ImageInfo r1 = r5.k;
        if (r1 != null) goto L5;
        r1 = com.ss.android.lark.image.uploader.utils.b.d(r0, true, false);
    L5:
        String r7 = b(r6.getContext(), r0, r1, r5, r6.e);
        if (TextUtils.isEmpty(r7) == false) goto L9;
        return;
    L9:
        if (new PolarisFileWrapper(r7).exists() == false) goto L11;
        ImageInfo r2 = com.ss.android.lark.image.uploader.utils.b.d(r7, true, true);
        String r8 = com.ss.android.lark.vfs.d.a().G(r7, true).getAbsolutePath();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r5.a = r8;
        r5.k = r2;
        int r9 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "compress success, before compress:" + r5.k + ", after compress:" + r2);
        return;
    L11:
        com.ss.android.lark.image.uploader.utils.c.b("ImageCompressManager", "failed to compress", null, false);
    }

    public static com.ss.android.lark.image.uploader.entity.a a(String r6, String r7, long r8) {
        Intrinsics.checkNotNullParameter(r6, "originPath");
        Intrinsics.checkNotNullParameter(r7, "compressPath");
        if (TextUtils.equals(r7, r6) == false) goto L5;
    L13:
        return null;
    L5:
        if (new PolarisFileWrapper(r6).exists() == false) goto L13;
        if (new PolarisFileWrapper(r7).exists() == false) goto L13;
        long r0 = System.currentTimeMillis() - r8;
        long r9 = new PolarisFileWrapper(r6).length();
        long r10 = new PolarisFileWrapper(r7).length();
        float r4 = 1.0f;
        if (r9 == 0) goto L15;
        r4 = (r10 * 1.0f) / r9;
    L15:
        return new com.ss.android.lark.image.uploader.entity.a(r4, "native", (int) r0);
    }

    public static void d(Context r2, String r3, boolean r4, IGetDataCallback r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "imagePath");
        Intrinsics.checkNotNullParameter(r5, "callback");
        int r0 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "preCompress, filePath:" + r3);
        RxScheduledExecutor.justInIO(new a(r3, r4, r2, r5));
    }

    public static String b(Context r11, String r12, ImageInfo r13, com.ss.android.lark.image.uploader.entity.b r14, flb.b r15) {
        if (r13 != null) goto L7;
        int r16 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.b("ImageCompressManager", "failed to get imageInfo, uploadImage:" + r14 + ", skip compress", null, false);
        return "";
    L7:
        if (r14.b == false) goto L9;
    L12:
        boolean r5 = true;
    L14:
        if (r5 == false) goto L17;
        int r17 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "uploadImage:" + r14 + ", skip compress");
        return "";
    L17:
        int[] r3 = blb.a.a(r13, r15);
        int r6 = r3[0];
        int r8 = r3[1];
        if (r6 >= Math.min(r13.a, r13.b)) goto L20;
    L24:
        boolean r7 = false;
    L25:
        if (r7 == false) goto L28;
        int r18 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "uploadImage:" + r14 + ", cal no need compress, skip compress");
        return "";
    L28:
        zkb.a r9 = zkb.a.a;
        String r10 = zkb.a.a(r11, r12, r3[0], r3[1]);
        if (new PolarisFileWrapper(r10).exists() == false) goto L31;
        int r19 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "uploadImage:" + r14 + ", compress cache exist:" + r10);
    L34:
        return r10;
    L31:
        String r20 = r9.b(r10);
        b r4 = d.a(e.a(r12, r13, r3[0]), r14, r13, r3[1], r20);
        if (r4 == null) goto L36;
        int r110 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "compress finish, outputPath:" + r4.a);
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "rename ret:" + r9.c(r20, r10) + ", tempPath:" + r20 + ", finalPath:" + r10);
        goto L34
    L36:
        if (r14.i == false) goto L42;
        com.ss.android.lark.image.uploader.utils.c.b("ImageCompressManager", "compress webp failed, fallback", null, false);
        r14.i = false;
        if (new PolarisFileWrapper(r20).exists() == false) goto L41;
        com.ss.android.lark.image.uploader.utils.c.b("ImageCompressManager", "delete last file", null, false);
        new PolarisFileWrapper(r20).delete();
    L41:
        return b(r11, r12, r13, r14, r15);
    L42:
        return "";
    L20:
        if (r8 < r13.d) goto L24;
        if (r13.h != ImageUtils.ImageType.TYPE_JPG) goto L24;
        r7 = true;
        goto L25
    L9:
        if (r13.i == true) goto L12;
        r5 = false;
        goto L14
    }
}
