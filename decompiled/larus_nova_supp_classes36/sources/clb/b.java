package clb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.image.uploader.upload.AvatarUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.BackgroundUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.EncryptImageUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.ProfileCoverUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.StickerUploader$batchUploadImage$1;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements clb.a {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // clb.a
    public final boolean c() {
        Intrinsics.checkNotNullParameter("lark.image.jpeg.tool.safe.read.disable", TabAppInfo.IMAGE_JSON_KEY);
        return false;
    }

    @Override // clb.a
    public final void e(String r2, ProfileCoverUploader$uploadImage$1 r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }

    @Override // clb.a
    public final void g(List r2, StickerUploader$batchUploadImage$1 r3) {
        Intrinsics.checkNotNullParameter(r2, "pathList");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }

    @Override // clb.a
    public final void h(String r2, BackgroundUploader$uploadImage$1 r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }

    @Override // clb.a
    public final void i(String r2, AvatarUploader$uploadImage$1 r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }

    @Override // clb.a
    public final void d(PolarisFileWrapper r1, int r2, int r3, boolean r4, EncryptImageUploader$uploadImage$1 r5) {
        Intrinsics.checkNotNullParameter(r1, "file");
        Intrinsics.checkNotNullParameter(r5, "callback");
        int r6 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("MockImageUploadDependency", "uploadEncryptImage");
        CoreThreadPool.getBackgroundHandler().postDelayed(new c(r5), 1000);
    }

    @Override // clb.a
    public final int[] f(long r1, int r3, int r4, int r5, int r6, int r7) {
        int r2 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("MockImageUploadDependency", "getImageCompressParams");
        return new int[]{r3, r5};
    }
}
