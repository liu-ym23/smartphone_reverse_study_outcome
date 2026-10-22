package s1;

import androidx.work.impl.WorkDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class a0 implements androidx.work.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u1.a f11947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q1.a f11948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r1.u f11949c;

    static {
        androidx.work.m.f("WMFgUpdater");
    }

    public a0(WorkDatabase r8, q1.a r10, u1.a r11) {
        this.f11948b = r10;
        this.f11947a = r11;
        this.f11949c = r8.f();
    }
}
