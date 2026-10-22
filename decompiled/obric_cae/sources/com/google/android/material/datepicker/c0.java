package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ y f4659s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f4660t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ SingleDateSelector f4661u;

    public c0(SingleDateSelector r8, String r10, SimpleDateFormat r11, TextInputLayout r12, CalendarConstraints r13, u.a r14, TextInputLayout r15) {
        this.f4661u = r8;
        this.f4659s = r14;
        this.f4660t = r15;
        super(r10, r11, r12, r13);
    }

    @Override // com.google.android.material.datepicker.d
    public final void a() {
        this.f4660t.getError();
        this.f4661u.getClass();
        this.f4659s.a();
    }

    @Override // com.google.android.material.datepicker.d
    public final void b(Long r8) {
        SingleDateSelector r10 = this.f4661u;
        if (r8 != null) goto L5;
        r10.f4633a = null;
    L6:
        r10.getClass();
        Long r11 = r10.f4633a;
        this.f4659s.b(r11);
        return;
    L5:
        r10.r(r8.longValue());
        goto L6
    }
}
