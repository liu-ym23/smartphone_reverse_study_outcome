package com.larus.bmhome.chat.layout.holder.video;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.chat.layout.holder.image.n0;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ String a;
    public final /* synthetic */ GenerateVideoBox b;
    public final /* synthetic */ Uri c;
    public final /* synthetic */ n0 d;
    public final /* synthetic */ String e;
    public final /* synthetic */ int f;

    public final void onFailure(String r4, Throwable r5) {
        String r6 = this.a;
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L12;
        FLogger.a.e(this.b.y, "[image_load_failed]:" + this.a, r5);
        return;
    L12:
        return;
    L5:
        if (r6.length() == 0) goto L8;
        r7 = false;
        goto L9
    }

    public final void onIntermediateImageSet(String r6, Object r7) {
        ImageInfo r8 = (ImageInfo) r7;
        FLogger r0 = FLogger.a;
        String r1 = this.b.y;
        StringBuilder r2 = new StringBuilder("[onIntermediateImageSet]:");
        r2.append(this.c);
        r2.append("   ");
        r2.append(r6);
        r2.append(' ');
        if (r8 == null) goto L7;
        ImageFormat r4 = r8.getImageFormat();
        if (r4 == null) goto L7;
        String r5 = r4.getFileExtension();
    L8:
        r2.append(r5);
        r2.append(' ');
        r0.i(r1, r2.toString());
        super.onIntermediateImageSet(r6, r8);
        n0 r9 = this.d;
        if (r9 == null) goto L12;
        r9.b(this.e, this.f);
        return;
    L12:
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final void onSubmit(String r1, Object r2) {
        super.onSubmit(r1, r2);
    }

    public final void onFinalImageSet(String r5, Object r6, Animatable r7) {
        ImageInfo r8 = (ImageInfo) r6;
        FLogger r0 = FLogger.a;
        String r1 = this.b.y;
        StringBuilder r2 = new StringBuilder("[onFinalImageSet]:");
        r2.append(this.a);
        r2.append("   ");
        r2.append(r5);
        r2.append("  ");
        if (r8 == null) goto L7;
        ImageFormat r3 = r8.getImageFormat();
        if (r3 == null) goto L7;
        String r4 = r3.getFileExtension();
    L8:
        r2.append(r4);
        r2.append(' ');
        r0.i(r1, r2.toString());
        super.onFinalImageSet(r5, r8, r7);
        n0 r9 = this.d;
        if (r9 == null) goto L11;
        r9.b(this.e, this.f);
    L11:
        this.b.t = true;
        return;
    L7:
        r4 = null;
        goto L8
    }

    public h(String r1, GenerateVideoBox r2, Uri r3, n0 r4, String r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
