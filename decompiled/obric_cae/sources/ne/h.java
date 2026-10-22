package ne;

import ge.p;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends he.j implements p<CharSequence, Integer, xd.d<? extends Integer, ? extends Integer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<String> f9543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f9544b;

    public h(List<String> r8, boolean r10) {
        this.f9543a = r8;
        this.f9544b = r10;
        super(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ge.p
    public final xd.d<? extends Integer, ? extends Integer> invoke(CharSequence r13, Integer r14) {
        CharSequence r15 = r13;
        int r16 = r14.intValue();
        he.i.f(r15, "$this$$receiver");
        boolean r8 = this.f9544b;
        List<String> r12 = this.f9543a;
        if (r8 == true) goto L18;
        if (r12.size() != 1) goto L18;
        int r10 = r12.size();
        if (r10 == 0) goto L16;
        if (r10 != 1) goto L14;
        String r17 = r12.get(0);
        int r18 = j.A0(r15, r17, r16, false, 4);
        if (r18 < 0) goto L54;
        xd.d r19 = new xd.d(Integer.valueOf(r18), r17);
    L55:
        if (r19 != null) goto L57;
        return null;
    L57:
        return new xd.d(r19.f13867a, Integer.valueOf(((String) r19.f13868b).length()));
    L54:
        r19 = null;
        goto L55
    L14:
        throw new IllegalArgumentException("List has more than one element.");
    L16:
        throw new NoSuchElementException("List is empty.");
    L18:
        if (r16 >= 0) goto L20;
        r16 = 0;
    L20:
        ke.c r11 = new ke.c(r16, r15.length());
        boolean r20 = r15 instanceof String;
        int r21 = r11.f9111m;
        int r22 = r11.f9110b;
        if (r20 == false) goto L38;
        if (r21 <= 0) goto L24;
        if (r16 > r22) goto L24;
    L26:
        Iterator<T> r110 = r12.iterator();
    L28:
        if (r110.hasNext() == false) goto L32;
        Object r111 = r110.next();
        String r23 = (String) r111;
        if (g.t0(0, r16, r23.length(), r23, (String) r15, r8) == false) goto L28;
    L33:
        String r112 = (String) r111;
        if (r112 != null) goto L35;
        if (r16 == r22) goto L54;
        r16 = r16 + r21;
        goto L26
    L35:
        r19 = new xd.d(Integer.valueOf(r16), r112);
        goto L55
    L32:
        r111 = null;
    L24:
        if (r21 >= 0) goto L54;
        if (r22 > r16) goto L54;
    L38:
        if (r21 <= 0) goto L40;
        if (r16 > r22) goto L40;
    L42:
        Iterator<T> r24 = r12.iterator();
    L44:
        if (r24.hasNext() == false) goto L48;
        Object r25 = r24.next();
        String r26 = (String) r25;
        if (j.D0(r26, r15, r16, r26.length(), r8) == false) goto L44;
    L49:
        String r27 = (String) r25;
        if (r27 != null) goto L51;
        if (r16 == r22) goto L54;
        r16 = r16 + r21;
        goto L42
    L51:
        r19 = new xd.d(Integer.valueOf(r16), r27);
        goto L55
    L48:
        r25 = null;
    L40:
        if (r21 >= 0) goto L54;
        if (r22 > r16) goto L54;
        goto L54
    }
}
