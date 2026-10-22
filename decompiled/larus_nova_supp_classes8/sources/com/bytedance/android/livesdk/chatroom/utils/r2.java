package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.drawable.Animatable;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r2 implements com.bytedance.android.live.core.utils.p0 {
    public final /* synthetic */ a4 a;

    public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
    }

    public final /* synthetic */ void d(ImageInfo r1) {
    }

    public final /* synthetic */ void e(py.k r1) {
    }

    public r2(SkinLoader$loopLoadImg$2 r1) {
        this.a = r1;
    }

    public final void b(py.k r2, Exception r3) {
        a4 r4 = this.a;
        if (r4 == null) goto L6;
        r4.b(SkinLoadResultType.ERROR, "remote error");
        return;
    }

    public final void c(py.k r1, int r2, int r3, boolean r4) {
        a4 r5 = this.a;
        if (r5 == null) goto L6;
        r5.b(SkinLoadResultType.SUCCESS, "");
        return;
    }
}
