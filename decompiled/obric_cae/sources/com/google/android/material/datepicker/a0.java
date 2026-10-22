package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public final class a0 extends d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f4640s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f4641t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ y f4642u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ RangeDateSelector f4643v;

    public a0(RangeDateSelector r8, String r10, SimpleDateFormat r11, TextInputLayout r12, CalendarConstraints r13, TextInputLayout r14, TextInputLayout r15, u.a r16) {
        this.f4643v = r8;
        this.f4640s = r14;
        this.f4641t = r15;
        this.f4642u = r16;
        super(r10, r11, r12, r13);
    }

    @Override // com.google.android.material.datepicker.d
    public final void a() {
        RangeDateSelector r8 = this.f4643v;
        r8.f4631n = null;
        TextInputLayout r10 = this.f4641t;
        y r11 = this.f4642u;
        RangeDateSelector.t(r8, this.f4640s, r10, r11);
    }

    @Override // com.google.android.material.datepicker.d
    public final void b(Long r8) {
        RangeDateSelector r10 = this.f4643v;
        r10.f4631n = r8;
        TextInputLayout r11 = this.f4641t;
        y r12 = this.f4642u;
        RangeDateSelector.t(r10, this.f4640s, r11, r12);
    }
}
