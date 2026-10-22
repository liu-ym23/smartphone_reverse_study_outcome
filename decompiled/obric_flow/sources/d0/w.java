package d0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class w implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f16574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0.d f16575b;

    public w(ArrayList r5, r0.d r10) {
        this.f16574a = r5;
        this.f16575b = r10;
    }

    @Override // d0.r
    public final boolean a(Object r5) {
        Iterator r10 = this.f16574a.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (((r) r10.next()).a(r5) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // d0.r
    public final q b(Object r10, int r11, int r12, z.f r13) {
        ArrayList r5 = this.f16574a;
        int r14 = r5.size();
        ArrayList r15 = new ArrayList(r14);
        int r16 = 0;
        z.c r17 = null;
    L3:
        if (r16 >= r14) goto L11;
        r r18 = (r) r5.get(r16);
        if (r18.a(r10) == false) goto L9;
        q r19 = r18.b(r10, r11, r12, r13);
        if (r19 == null) goto L9;
        r15.add(r19.f16567c);
        r17 = r19.f16565a;
    L9:
        r16 = r16 + 1;
        goto L3
    L11:
        if (r15.isEmpty() == true) goto L19;
        if (r17 != null) goto L14;
        return null;
    L14:
        return new q(r17, new v(r15, this.f16575b));
    L19:
        return null;
    }

    public final String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f16574a.toArray()) + '}';
    }
}
