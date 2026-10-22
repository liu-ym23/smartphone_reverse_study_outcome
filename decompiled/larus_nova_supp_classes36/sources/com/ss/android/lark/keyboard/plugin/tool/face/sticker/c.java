package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends OnSingleClickListener {
    public final /* synthetic */ FaceNewAdapter a;

    public c(FaceNewAdapter r1) {
        this.a = r1;
    }

    public final void onSingleClick(View r1) {
        FaceNewAdapter.c r2 = this.a.g;
        if (r2 == null) goto L6;
        r2.a();
        return;
    }
}
