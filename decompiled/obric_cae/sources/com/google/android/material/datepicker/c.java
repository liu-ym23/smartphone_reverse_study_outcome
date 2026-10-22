package com.google.android.material.datepicker;

import com.obric.cae.location.util.LocationUtil;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4657b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f4658m;

    public /* synthetic */ c(int r8, Object r10, long r11) {
        this.f4656a = r8;
        this.f4658m = r10;
        this.f4657b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f4656a;
        long r10 = this.f4657b;
        Object r11 = this.f4658m;
        switch(r8) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        d r12 = (d) r11;
        r12.getClass();
        Object[] r13 = {f.b(r10).replace(' ', 160)};
        String r14 = String.format(r12.f4666o, r13);
        r12.f4662a.setError(r14);
        r12.a();
        return;
    L7:
        LocationUtil.a((LocationUtil) r11, r10);
    }
}
