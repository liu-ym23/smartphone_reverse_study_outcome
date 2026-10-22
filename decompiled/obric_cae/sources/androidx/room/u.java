package androidx.room;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class u extends i.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v<Object> f2700b;

    public u(String[] r8, v<Object> r10) {
        this.f2700b = r10;
        super(r8);
    }

    @Override // androidx.room.i.c
    public final void a(Set<String> r8) {
        he.i.f(r8, "tables");
        i.c r10 = i.c.A();
        androidx.activity.j r11 = this.f2700b.f2711u;
        if (r10.B() == false) goto L5;
        r11.run();
        return;
    L5:
        r10.C(r11);
    }
}
