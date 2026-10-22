package clb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.image.uploader.upload.AvatarUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.BackgroundUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.EncryptImageUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.ProfileCoverUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.StickerUploader$batchUploadImage$1;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {
    boolean c();

    void d(PolarisFileWrapper r1, int r2, int r3, boolean r4, EncryptImageUploader$uploadImage$1 r5);

    void e(String r1, ProfileCoverUploader$uploadImage$1 r2);

    int[] f(long r1, int r3, int r4, int r5, int r6, int r7);

    void g(List r1, StickerUploader$batchUploadImage$1 r2);

    void h(String r1, BackgroundUploader$uploadImage$1 r2);

    void i(String r1, AvatarUploader$uploadImage$1 r2);
}
