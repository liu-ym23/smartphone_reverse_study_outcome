package com.ss.android.lark.keyboard.editor.input;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class u extends OnSingleClickListener {
    public final /* synthetic */ RichTextInputExpandPlugin a;

    public u(RichTextInputExpandPlugin r3) {
        this.a = r3;
        super(500);
    }

    public final void onSingleClick(View r11) {
        BaseRichTextInputPlugin.l0(this.a, true, false, null, null, null, false, null, null, 254);
    }
}
