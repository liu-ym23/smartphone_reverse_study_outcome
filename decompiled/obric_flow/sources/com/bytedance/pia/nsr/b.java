package com.bytedance.pia.nsr;

import ko.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f7170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f7171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7172c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ nh.d e;
    public final /* synthetic */ Function2 f;
    public final /* synthetic */ Function1 g;

    public b(String r5, long r10, String r11, boolean r12, nh.d r13, Function2 r14, Function1 r15) {
        this.f7170a = r5;
        this.f7171b = r10;
        this.f7172c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r r5 = h.f7194a;
        Function2 r10 = this.f;
        Function1 r11 = this.g;
        h.b(this.f7170a, this.f7171b, this.f7172c, this.d, this.e, r10, r11);
    }
}
