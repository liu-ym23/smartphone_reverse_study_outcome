package com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime;

import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GregorianCalendar f3577b;

    private d(String r1, String r2) {
        super(r1, r2);
        GregorianCalendar r3 = new GregorianCalendar(0, 0, 0);
        this.f3577b = r3;
        r3.clear(1);
        r3.clear(2);
        r3.clear(5);
    }

    public static GregorianCalendar a(String r1, String r2) {
        d r0 = new d(r1, r2);
        r0.a();
        return r0.f3577b;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void a(int r2) {
        this.f3577b.set(13, r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void a(java.util.TimeZone r1) {
        this.f3577b.setTimeZone(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void b(int r2) {
        this.f3577b.set(12, r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void c() {
        this.f3577b.set(14, a(1, 3));
        b();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void c(int r2) {
        this.f3577b.set(11, r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void d(int r2) {
        this.f3577b.set(5, r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void e(int r2) {
        this.f3577b.set(2, r2 - 1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime.b
    public void f(int r2) {
        this.f3577b.set(1, r2);
    }
}
