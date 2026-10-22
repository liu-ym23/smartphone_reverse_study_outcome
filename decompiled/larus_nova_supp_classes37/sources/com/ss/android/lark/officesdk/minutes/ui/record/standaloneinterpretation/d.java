package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import android.widget.CompoundButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ Function1<Boolean, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super Boolean, Unit> r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r1, boolean r2) {
        this.a.invoke(Boolean.valueOf(r2));
    }
}
