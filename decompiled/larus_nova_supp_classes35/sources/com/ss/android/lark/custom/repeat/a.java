package com.ss.android.lark.custom.repeat;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements oab.e {
    public final /* synthetic */ ChooseCustomRepeatFragment a;

    @Override // oab.e
    public final void f() {
        this.a.r.setRepeatType(10);
    }

    @Override // oab.e
    public final void i() {
        this.a.r.setRepeatType(9);
    }

    public a(ChooseCustomRepeatFragment r1) {
        this.a = r1;
    }

    @Override // oab.e
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "weekDay");
        this.a.r.setCustomerByMonthWeekDay(r2);
    }

    @Override // oab.e
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "weekNo");
        this.a.r.setCustomerByMonthWeekNo(r2);
    }

    @Override // oab.e
    public final void c(int r2) {
        this.a.r.addWeekList(r2);
    }

    @Override // oab.e
    public final void d(int r2) {
        this.a.r.addMonthList(r2);
    }

    @Override // oab.e
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, ChameleonOpenTracker.ParamKey.RESULT);
        ChooseCustomRepeatFragment r3 = this.a;
        int r0 = ChooseCustomRepeatFragment.u;
        r3.ba0();
    }

    @Override // oab.e
    public final void g(int r2) {
        this.a.r.removeMonthList(r2);
    }

    @Override // oab.e
    public final void h(int r2) {
        this.a.r.removeWeekList(r2);
    }
}
