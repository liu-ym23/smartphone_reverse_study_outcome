package gz8;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.a2;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.s0;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.u0;
import com.larus.bmhome.actionbar.model.u1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l implements k {
    public final s0 a;

    public l(s0 r1) {
        this.a = r1;
    }

    public final List<t0> d(int r8) {
        s0 r0 = this.a;
        if (r0 == null) goto L7;
        u0 r1 = r0.a;
        if (r1 == null) goto L7;
        List r2 = r1.a;
    L8:
        if (r2 != null) goto L10;
        r2 = CollectionsKt.emptyList();
    L10:
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L12:
        if (r4.hasNext() == false) goto L29;
        Object r5 = r4.next();
        t0 r6 = (t0) r5;
        String r7 = r6.a;
        boolean r9 = false;
        if (r7 != null) goto L16;
    L19:
        boolean r10 = true;
    L20:
        if (r10 == true) goto L27;
        Integer r11 = r6.j;
        if (r11 == null) goto L27;
        if (r11.intValue() != r8) goto L27;
        r9 = true;
    L27:
        if (r9 == false) goto L12;
        r3.add(r5);
        goto L12
    L16:
        if (StringsKt.isBlank(r7) == true) goto L19;
        r10 = false;
        goto L20
    L29:
        return r3;
    L7:
        r2 = null;
        goto L8
    }

    @Override // gz8.k
    public final ReplyOption a(int r10, ReplyOption r11) {
        List<t0> r12 = d(r10);
        s0 r0 = this.a;
        Integer r1 = null;
        if (r0 == null) goto L7;
        a2 r2 = r0.b;
        if (r2 == null) goto L7;
        List r3 = r2.a;
    L8:
        if (r3 != null) goto L10;
        r3 = CollectionsKt.emptyList();
    L10:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        Object r6 = r5.next();
        if (c.a((b2) r6) == false) goto L12;
        r4.add(r6);
        goto L12
    L16:
        if (r11 == null) goto L75;
        Iterator r7 = r4.iterator();
    L19:
        if (r7.hasNext() == false) goto L23;
        Object r8 = r7.next();
        if (c.b((b2) r8, r11.getModel()) == false) goto L19;
    L24:
        b2 r9 = (b2) r8;
        if (r9 == null) goto L27;
        ModelItemIdentity r13 = r9.b();
    L28:
        if (r9 == null) goto L75;
        if (r13 == null) goto L75;
        String r14 = r11.getModeId();
        if (r14 != null) goto L33;
    L35:
        r14 = null;
    L36:
        if (r14 == null) goto L45;
        Iterator r15 = ((ArrayList) r12).iterator();
    L39:
        if (r15.hasNext() == false) goto L43;
        Object r16 = r15.next();
        if (Intrinsics.areEqual(((t0) r16).a, r14) == false) goto L39;
    L44:
        t0 r17 = (t0) r16;
    L62:
        if (r17 == null) goto L75;
        if (c.c(r17, r13) == false) goto L66;
    L67:
        String r18 = r17.a;
        Integer r19 = r11.getReasoningEffort();
        if (r19 != null) goto L72;
        u1 r110 = r9.t;
        if (r110 == null) goto L74;
        r1 = r110.b;
    L74:
        return new ReplyOption(r13, r18, r1);
    L72:
        r1 = r19;
        goto L74
    L66:
        if (Intrinsics.areEqual(r9.s, r17.a) == false) goto L75;
    L43:
        r16 = null;
        goto L44
    L45:
        ArrayList r20 = (ArrayList) r12;
        Iterator r21 = r20.iterator();
    L47:
        if (r21.hasNext() == false) goto L51;
        Object r22 = r21.next();
        if (Intrinsics.areEqual(((t0) r22).a, r9.s) == false) goto L47;
    L52:
        r17 = (t0) r22;
        if (r17 != null) goto L62;
        Iterator r23 = r20.iterator();
    L56:
        if (r23.hasNext() == false) goto L60;
        Object r24 = r23.next();
        if (c.c((t0) r24, r13) == false) goto L56;
    L61:
        r17 = (t0) r24;
        goto L62
    L60:
        r24 = null;
        goto L61
    L51:
        r22 = null;
        goto L52
    L33:
        if ((!StringsKt.isBlank(r14)) == false) goto L35;
    L27:
        r13 = null;
        goto L28
    L23:
        r8 = null;
    L75:
        Iterator r111 = r4.iterator();
    L77:
        if (r111.hasNext() == false) goto L105;
        b2 r25 = (b2) r111.next();
        ModelItemIdentity r26 = r25.b();
        if (r26 == null) goto L77;
        ArrayList r27 = (ArrayList) r12;
        Iterator r28 = r27.iterator();
    L83:
        if (r28.hasNext() == false) goto L87;
        Object r29 = r28.next();
        if (Intrinsics.areEqual(((t0) r29).a, r25.s) == false) goto L83;
    L88:
        t0 r30 = (t0) r29;
        if (r30 != null) goto L100;
        Iterator r31 = r27.iterator();
    L92:
        if (r31.hasNext() == false) goto L96;
        Object r32 = r31.next();
        if (c.c((t0) r32, r26) == false) goto L92;
    L97:
        r30 = (t0) r32;
        if (r30 != null) goto L100;
    L96:
        r32 = null;
    L100:
        String r112 = r30.a;
        u1 r33 = r25.t;
        if (r33 == null) goto L104;
        r1 = r33.b;
    L104:
        return new ReplyOption(r26, r112, r1);
    L87:
        r29 = null;
        goto L88
    L105:
        Iterator r113 = ((ArrayList) r12).iterator();
    L107:
        if (r113.hasNext() == false) goto L132;
        t0 r114 = (t0) r113.next();
        Iterator<T> r34 = c.e(r114).iterator();
    L110:
        if (r34.hasNext() == false) goto L121;
        ModelItemIdentity r35 = (ModelItemIdentity) r34.next();
        Iterator r36 = r4.iterator();
    L113:
        if (r36.hasNext() == false) goto L117;
        Object r37 = r36.next();
        if (c.b((b2) r37, r35) == false) goto L113;
    L118:
        b2 r38 = (b2) r37;
        if (r38 == null) goto L110;
    L122:
        if (r38 == null) goto L107;
        ModelItemIdentity r39 = r38.b();
        if (r39 == null) goto L107;
        String r115 = r114.a;
        u1 r40 = r38.t;
        if (r40 == null) goto L131;
        r1 = r40.b;
    L131:
        return new ReplyOption(r39, r115, r1);
    L117:
        r37 = null;
        goto L118
    L121:
        r38 = null;
        goto L122
    L132:
        return null;
    L7:
        r3 = null;
        goto L8
    }

    @Override // gz8.k
    public final List<b2> b(int r12, boolean r13) {
        List<t0> r14 = d(r12);
        s0 r0 = this.a;
        if (r0 == null) goto L7;
        a2 r1 = r0.b;
        if (r1 == null) goto L7;
        List r2 = r1.a;
    L8:
        if (r2 != null) goto L10;
        r2 = CollectionsKt.emptyList();
    L10:
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L12:
        if (r4.hasNext() == false) goto L41;
        Object r5 = r4.next();
        b2 r6 = (b2) r5;
        ModelItemIdentity r7 = r6.b();
        boolean r8 = false;
        if (r7 != null) goto L17;
    L39:
        if (r8 == false) goto L12;
        r3.add(r5);
        goto L12
    L17:
        if (r7.getKey() == null) goto L39;
        if (r13 == true) goto L20;
    L21:
        ArrayList r9 = (ArrayList) r14;
        if (r9.isEmpty() == true) goto L36;
        Iterator r10 = r9.iterator();
    L26:
        if (r10.hasNext() == false) goto L36;
        t0 r11 = (t0) r10.next();
        if (Intrinsics.areEqual(r11.a, r6.s) == false) goto L30;
    L33:
        boolean r15 = true;
    L34:
        if (r15 == false) goto L26;
        boolean r16 = true;
    L37:
        if (r16 == false) goto L39;
        r8 = true;
        goto L39
    L30:
        if (c.c(r11, r7) == true) goto L33;
        r15 = false;
    L36:
        r16 = false;
        goto L37
    L20:
        if (c.a(r6) == false) goto L39;
    L41:
        return r3;
    L7:
        r2 = null;
        goto L8
    }

    @Override // gz8.k
    public final boolean c(ReplyOption r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "option");
        List<t0> r10 = d(r9);
        String r0 = r8.getModeId();
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L20;
        ArrayList r11 = (ArrayList) r10;
        if (r11.isEmpty() == true) goto L60;
        Iterator r12 = r11.iterator();
    L15:
        if (r12.hasNext() == false) goto L61;
        if (Intrinsics.areEqual(((t0) r12.next()).a, r0) == false) goto L15;
        return true;
    L61:
        return false;
    L60:
        return false;
    L20:
        s0 r1 = this.a;
        Object r4 = null;
        if (r1 == null) goto L25;
        a2 r2 = r1.b;
        if (r2 == null) goto L25;
        List r5 = r2.a;
    L26:
        if (r5 != null) goto L28;
        r5 = CollectionsKt.emptyList();
    L28:
        Iterator r6 = r5.iterator();
    L30:
        if (r6.hasNext() == false) goto L34;
        Object r7 = r6.next();
        if (c.b((b2) r7, r8.getModel()) == false) goto L30;
        r4 = r7;
    L34:
        b2 r13 = (b2) r4;
        if (r13 == null) goto L62;
        String r14 = r13.s;
        if (r14 == null) goto L63;
        ArrayList r15 = (ArrayList) r10;
        if (r15.isEmpty() == true) goto L47;
        Iterator r16 = r15.iterator();
    L43:
        if (r16.hasNext() == false) goto L47;
        if (Intrinsics.areEqual(((t0) r16.next()).a, r14) == false) goto L43;
        boolean r17 = true;
    L48:
        if (r17 != true) goto L64;
        return true;
    L64:
        return false;
    L47:
        r17 = false;
        goto L48
    L63:
        return false;
    L62:
        return false;
    L25:
        r5 = null;
        goto L26
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r3 = false;
        goto L9
    }
}
