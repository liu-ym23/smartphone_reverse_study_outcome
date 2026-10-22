package dc8;

import com.larus.bmhome.chat.adapter.t;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import dc8.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a<Component, ComponentContext extends b<Component>> implements c<Component, ComponentContext> {
    public final Function0<ComponentContext> a;
    public final Map<String, ComponentContext> b;
    public final Map<String, C0074a> c;

    /* JADX INFO: renamed from: dc8.a$a, reason: collision with other inner class name */
    public static final class C0074a {
        public boolean a;
        public boolean b;

        public C0074a() {
            boolean r1 = false;
            this(r1, 3);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0074a) == true) goto L8;
            return false;
        L8:
            C0074a r6 = (C0074a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return r2 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "StatusInfo(bound=" + this.a + ", attached=" + this.b + ')';
        }

        public /* synthetic */ C0074a(boolean r2, int r3) {
            if ((r3 & 1) == 0) goto L5;
            r2 = false;
        L5:
            this(r2, false);
        }

        public C0074a(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public a(t r2) {
        Intrinsics.checkNotNullParameter(r2, "componentContextFactory");
        this.a = r2;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    @Override // dc8.c
    public final ComponentContext X0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        ComponentContext r0 = (ComponentContext) ((LinkedHashMap) this.b).get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (ComponentContext) a(r2);
    }

    public final ComponentContext a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        ComponentContext r0 = (ComponentContext) ((LinkedHashMap) this.b).get(r3);
        if (r0 != null) goto L6;
        ComponentContext r1 = (ComponentContext) this.a.invoke();
        this.b.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    @Override // dc8.c
    public final void N1(String r2, BaseCompositeTextCell<? extends xc8.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "cell");
        b r0 = (b) ((LinkedHashMap) this.b).get(r2);
        if (r0 == null) goto L7;
        r0.s(r3);
        if (r0.isEmpty() == false) goto L7;
        this.b.remove(r2);
    L7:
        C0074a r4 = (C0074a) ((LinkedHashMap) this.c).get(r2);
        C0074a r5 = (C0074a) ((LinkedHashMap) this.c).get(r2);
        if (r5 == null) goto L11;
        r5.a = false;
        return;
    }

    @Override // dc8.c
    public final void S(String r2, BaseCompositeTextCell<? extends xc8.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "cell");
        C0074a r4 = (C0074a) ((LinkedHashMap) this.c).get(r2);
        C0074a r5 = (C0074a) ((LinkedHashMap) this.c).get(r2);
        if (r5 == null) goto L6;
        r5.b = false;
        return;
    }

    @Override // dc8.c
    public final void u1(String r2, BaseCompositeTextCell<? extends xc8.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "cell");
        C0074a r4 = (C0074a) ((LinkedHashMap) this.c).get(r2);
        C0074a r5 = (C0074a) ((LinkedHashMap) this.c).get(r2);
        if (r5 == null) goto L6;
        r5.b = true;
        return;
    }

    @Override // dc8.c
    public final ComponentContext I1(String r7, BaseCompositeTextCell<? extends xc8.b> r8, xc8.b r9, List<? extends Component> r10) {
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter(r8, "cell");
        Intrinsics.checkNotNullParameter(r9, "state");
        Intrinsics.checkNotNullParameter(r10, "components");
        ArrayList r0 = new ArrayList();
        Map<String, ComponentContext> r1 = this.b;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r3 = ((LinkedHashMap) r1).entrySet().iterator();
    L3:
        boolean r4 = true;
        if (r3.hasNext() == false) goto L13;
        Map.Entry r5 = (Map.Entry) r3.next();
        if (Intrinsics.areEqual(r5.getKey(), r7) == false) goto L8;
    L10:
        r4 = false;
    L11:
        if (r4 == false) goto L3;
        r2.put(r5.getKey(), r5.getValue());
        goto L3
    L8:
        if (((b) r5.getValue()).t(r8) == false) goto L10;
    L13:
        Iterator r6 = r2.entrySet().iterator();
    L15:
        if (r6.hasNext() == false) goto L19;
        Map.Entry r11 = (Map.Entry) r6.next();
        ((b) r11.getValue()).s(r8);
        if (((b) r11.getValue()).isEmpty() == false) goto L15;
        r0.add(r11.getKey());
        goto L15
    L19:
        Iterator r12 = r0.iterator();
    L21:
        if (r12.hasNext() == false) goto L23;
        String r13 = (String) r12.next();
        this.b.remove(r13);
        goto L21
    L23:
        ComponentContext r14 = (ComponentContext) a(r7);
        r14.r(r8, r9, r10);
        C0074a r15 = (C0074a) ((LinkedHashMap) this.c).get(r7);
        Map<String, C0074a> r16 = this.c;
        C0074a r17 = (C0074a) ((LinkedHashMap) r16).get(r7);
        if (r17 == null) goto L26;
        C0074a r18 = new C0074a(true, r17.b);
    L27:
        r16.put(r7, r18);
        return r14;
    L26:
        r18 = new C0074a(r4, 2);
        goto L27
    }
}
