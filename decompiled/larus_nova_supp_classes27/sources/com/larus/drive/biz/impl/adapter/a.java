package com.larus.drive.biz.impl.adapter;

import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.utils.e1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ DriveFileListAdapter.FileViewHolder a;

    public a(DriveFileListAdapter.FileViewHolder r1) {
        this.a = r1;
    }

    public final void onFailure(String r1, Throwable r2) {
        e1.q(this.a.a.c);
        e1.x(this.a.a.b);
    }
}
