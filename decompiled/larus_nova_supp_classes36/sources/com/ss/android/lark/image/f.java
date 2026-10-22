package com.ss.android.lark.image;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.image.impl.service.ImageService;
import com.ss.android.lark.image.uploader.upload.AvatarUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.BackgroundUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.EncryptImageUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.ProfileCoverUploader$uploadImage$1;
import com.ss.android.lark.image.uploader.upload.StickerUploader$batchUploadImage$1;
import com.ss.android.lark.utils.p;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements clb.a {
    public f() {
    }

    @Override // clb.a
    public final boolean c() {
        return idb.f.a().isEnable("lark.image.jpeg.tool.safe.read.disable");
    }

    @Override // clb.a
    public final void e(String r2, ProfileCoverUploader$uploadImage$1 r3) {
        ImageService.inst().uploadProfileCoverFile(r2, r3);
    }

    @Override // clb.a
    public final void g(List r2, StickerUploader$batchUploadImage$1 r3) {
        ImageService.inst().uploadSticker(r2, r3);
    }

    @Override // clb.a
    public final void h(String r8, BackgroundUploader$uploadImage$1 r9) {
        File r1 = new PolarisFileWrapper(r8);
        int[] r10 = p.g(r8);
        ImageService.inst().uploadEncryptImage(r1, r10[0], r10[1], false, true, r9);
    }

    @Override // clb.a
    public final void i(String r2, AvatarUploader$uploadImage$1 r3) {
        ImageService.inst().uploadAvatar(r2, r3);
    }

    @Override // clb.a
    public final void d(PolarisFileWrapper r8, int r9, int r10, boolean r11, EncryptImageUploader$uploadImage$1 r12) {
        ImageService.inst().uploadEncryptImage(r8, r9, r10, true, r11, r12);
    }

    @Override // clb.a
    public final int[] f(long r9, int r11, int r12, int r13, int r14, int r15) {
        return ImageService.inst().getImageCompressParams(r9, r11, r12, r13, r14, r15);
    }
}
