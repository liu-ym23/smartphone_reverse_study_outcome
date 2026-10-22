package te;

import ge.p;
import he.j;
import pe.e1;
import ue.t;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends j implements p<Integer, ae.f.b, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g<?> f12401a;

    public i(g<?> r8) {
        this.f12401a = r8;
        super(2);
    }

    @Override // ge.p
    public final Integer invoke(Integer r8, ae.f.b r10) {
        int r11 = r8.intValue();
        ae.f.b r12 = r10;
        ae.f.c<?> r13 = r12.getKey();
        ae.f.b r14 = this.f12401a.f12395b.q0(r13);
        int r15 = e1.f10007f;
        if (r13 == e1.b.f10008a) goto L8;
        if (r12 == r14) goto L6;
        int r16 = Integer.MIN_VALUE;
    L27:
        return Integer.valueOf(r16);
    L6:
        r16 = r11 + 1;
        goto L27
    L8:
        e1 r17 = (e1) r14;
        e1 r18 = (e1) r12;
    L9:
        if (r18 == null) goto L10;
        if (r18 == r17) goto L15;
        if ((r18 instanceof t) == false) goto L15;
        r18 = r18.getParent();
    L15:
        if (r18 != r17) goto L22;
        if (r17 == null) goto L20;
        r11 = r11 + 1;
    L20:
        return Integer.valueOf(r11);
    L22:
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + r18 + ", expected child of " + r17 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    L10:
        r18 = null;
        goto L15
    }
}
