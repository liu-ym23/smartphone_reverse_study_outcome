package com.larus.bmhome.bot;

import android.widget.CompoundButton;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b6 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ b6(Function1 r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r2, boolean r3) {
        Function1 r4 = this.a;
        int r0 = ServiceBotSettingFragment.i;
        r4.invoke(Boolean.valueOf(r3));
    }
}
