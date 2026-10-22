package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.widget.CompoundButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ TabPopoverFilterMenuView.b a;
    public final /* synthetic */ int b;

    public b(TabPopoverFilterMenuView.b r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r1, boolean r2) {
        if (r2 == false) goto L7;
        Function1<? super Integer, Unit> r3 = this.a.c;
        if (r3 == null) goto L8;
        Unit r4 = (Unit) r3.invoke(Integer.valueOf(this.b));
        return;
    L8:
        return;
    }
}
