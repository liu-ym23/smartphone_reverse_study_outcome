package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.content.Context;
import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements FaceNewAdapter.d {
    public final /* synthetic */ FacePageNewFragment2 a;

    public i(FacePageNewFragment2 r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.sticker.FaceNewAdapter.d
    public final void a(Context r1, int r2, int r3, String r4, ImageView r5, int r6) {
        FacePageNewFragment2 r7 = this.a;
        int r8 = FacePageNewFragment2.n;
        k r9 = r7.U90();
        if (r9 != null) goto L5;
        return;
    L5:
        r9.b();
    }
}
