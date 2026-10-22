package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import android.view.View;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ u7 a;
    public final /* synthetic */ Message b;

    public y1(u7 r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        u7 r10 = this.a;
        String r11 = this.b.getMessageId();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r10.kx(r11, false);
    }
}
