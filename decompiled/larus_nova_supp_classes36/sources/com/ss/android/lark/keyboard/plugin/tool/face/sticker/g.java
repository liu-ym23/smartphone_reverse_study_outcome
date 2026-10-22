package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ FacePageNewFragment2 a;

    public g(FacePageNewFragment2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        new com.ss.android.lark.widget.photopicker.e(new com.ss.android.lark.widget.photopicker.s(new com.ss.android.lark.widget.photopicker.s.a())).b(this.a.requireContext(), this.a, 1024);
    }
}
