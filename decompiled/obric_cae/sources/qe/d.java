package qe;

import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pe.g f11299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f11300b;

    public d(pe.h r8, f r10) {
        this.f11299a = r8;
        this.f11300b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j r8 = j.f13877a;
        this.f11299a.c(this.f11300b, r8);
    }
}
