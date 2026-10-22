package ai;

import java.lang.reflect.Array;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends w0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f289c;
    public final /* synthetic */ w0 d;

    public /* synthetic */ q(w0 r5, int r10) {
        this.f289c = r10;
        this.d = r5;
    }

    @Override // ai.w0
    public final void a(e0 r5, Object r10) {
        switch(this.f289c) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        if (r10 == null) goto L9;
        int r11 = Array.getLength(r10);
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L20;
        this.d.a(r5, Array.get(r10, r12));
        r12 = r12 + 1;
        goto L7
    L20:
        return;
    L9:
        return;
    L10:
        Iterable r13 = (Iterable) r10;
        if (r13 == null) goto L17;
        Iterator r14 = r13.iterator();
    L15:
        if (r14.hasNext() == false) goto L21;
        Object r15 = r14.next();
        this.d.a(r5, r15);
        goto L15
    L21:
        return;
    }
}
