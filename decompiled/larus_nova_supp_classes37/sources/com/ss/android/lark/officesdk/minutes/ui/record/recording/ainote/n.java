package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n implements View.OnLayoutChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ Function0<Unit> b;

    public n(View r1, Function0<Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r1, "v");
        this.a.removeOnLayoutChangeListener(this);
        this.b.invoke();
    }
}
