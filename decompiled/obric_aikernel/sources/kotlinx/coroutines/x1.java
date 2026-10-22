package kotlinx.coroutines;

import kotlin.PublishedApi;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
public class x1 extends c2 implements z {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f10729h;

    public x1(v1 r10) {
        super(true);
        z0(r10);
        this.f10729h = f1();
    }

    private final boolean f1() {
        t r10 = v0();
        if ((r10 instanceof u) == false) goto L5;
        u r11 = (u) r10;
    L7:
        if (r11 == null) goto L22;
        c2 r12 = r11.r();
        if (r12 == null) goto L22;
    L12:
        if (r12.s0() == true) goto L13;
        t r13 = r12.v0();
        if ((r13 instanceof u) == false) goto L18;
        u r14 = (u) r13;
    L19:
        if (r14 == null) goto L22;
        r12 = r14.r();
        if (r12 != null) goto L12;
    L18:
        r14 = null;
        goto L19
    L13:
        return true;
    L22:
        return false;
    L5:
        r11 = null;
        goto L7
    }

    @Override // kotlinx.coroutines.c2
    public boolean s0() {
        return this.f10729h;
    }

    @Override // kotlinx.coroutines.c2
    public boolean t0() {
        return true;
    }
}
