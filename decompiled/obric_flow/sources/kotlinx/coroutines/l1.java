package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public class l1 extends r1 implements t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18980c;

    public l1(Job r10) {
        boolean r5 = true;
        super(true);
        K(r10);
        AtomicReferenceFieldUpdater r11 = r1.f18989b;
        o r12 = (o) r11.get(this);
        if ((r12 instanceof p) == false) goto L5;
        p r13 = (p) r12;
    L7:
        if (r13 == null) goto L21;
        r1 r14 = r13.h();
        if (r14 == null) goto L21;
    L12:
        if (r14.F() == true) goto L22;
        o r15 = (o) r11.get(r14);
        if ((r15 instanceof p) == false) goto L17;
        p r16 = (p) r15;
    L18:
        if (r16 == null) goto L21;
        r14 = r16.h();
        if (r14 != null) goto L12;
    L17:
        r16 = null;
    L22:
        this.f18980c = r5;
        return;
    L21:
        r5 = false;
        goto L22
    L5:
        r13 = null;
        goto L7
    }

    @Override // kotlinx.coroutines.r1
    public final boolean F() {
        return this.f18980c;
    }

    @Override // kotlinx.coroutines.r1
    public final boolean G() {
        return true;
    }
}
