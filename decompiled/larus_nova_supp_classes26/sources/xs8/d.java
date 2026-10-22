package xs8;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.a0;
import com.larus.bmhome.actionbar.model.c0;
import com.larus.bmhome.actionbar.model.f0;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.CollaboratedMultiFeatureSelectorWidget;
import com.larus.bmhome.view.actionbar.edit.component.j0;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import ouc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends up8.b {
    public final Lazy l;
    public com.larus.bmhome.actionbar.model.b m;
    public String n;
    public final Map<Integer, Long> o;
    public final Map<Integer, Integer> p;

    @Override // up8.b
    public int getType() {
        return 8;
    }

    @Override // up8.b
    public final int i() {
        return 9;
    }

    public final void G() {
        com.larus.bmhome.actionbar.model.b r0 = this.m;
        if (r0 == null) goto L5;
        r0.c = this.n;
    L5:
        a0 r1 = s();
        if (r1 == null) goto L8;
        List r2 = r1.c;
    L9:
        if (r2 != null) goto L11;
        r2 = CollectionsKt.emptyList();
    L11:
        Iterator r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L53;
        f0 r4 = (f0) r3.next();
        Integer r5 = r4.f();
        if (r5 == null) goto L13;
        int r6 = r5.intValue();
        com.larus.bmhome.actionbar.model.h r7 = r4.d();
        if (r7 == null) goto L41;
        Long r8 = (Long) ((LinkedHashMap) this.o).get(Integer.valueOf(r6));
        List r9 = r7.e;
        if (r9 == null) goto L30;
        List r10 = r9;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L22:
        if (r12.hasNext() == false) goto L31;
        w r13 = (w) r12.next();
        if (r8 != null) goto L26;
    L28:
        int r14 = 0;
    L29:
        r11.add(w.a(r13, null, null, Integer.valueOf(r14), null, null, null, 8126463));
        goto L22
    L26:
        if (Intrinsics.areEqual(r13.a, r8) == false) goto L28;
        r14 = 1;
    L31:
        r7.e = r11;
        r4.c = r7;
        r4.j = r11;
        r4.i = r7.d;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L34
        Object r16 = Result.constructor-impl(xt7.d.b.a(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r7));     // Catch: Throwable -> L34
    L36:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L40;
        FLogger.a.e("CollaboratedMultiFeatureSelectorController", "sync dropdown template failed", r17);
        r16 = r4.b;
    L40:
        r4.b = (String) r16;
    L34:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L30:
        r11 = null;
    L41:
        com.larus.bmhome.actionbar.model.j r19 = r4.e();
        if (r19 == null) goto L13;
        Integer r20 = (Integer) ((LinkedHashMap) this.p).get(Integer.valueOf(r6));
        r19.i = r20;
        r4.d = r19;
        r4.v = r20;
        r4.i = r19.c;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L46
        Object r22 = Result.constructor-impl(xt7.d.b.a(com.larus.bmhome.actionbar.model.j.Companion.serializer(), r19));     // Catch: Throwable -> L46
    L48:
        Throwable r23 = Result.exceptionOrNull-impl(r22);
        if (r23 == null) goto L52;
        FLogger.a.e("CollaboratedMultiFeatureSelectorController", "sync duration template failed", r23);
        r22 = r4.b;
    L52:
        r4.b = (String) r22;
    L46:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    L53:
        return;
    L8:
        r2 = null;
        goto L9
    }

    @Override // up8.d
    public final String g() {
        com.larus.bmhome.actionbar.model.b r0 = this.m;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        G();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.b.Companion.serializer()), r0));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r3) == true) goto L15;
        r1 = r3;
    L15:
        return (String) r1;
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final a0 s() {
        com.larus.bmhome.actionbar.model.b r0 = this.m;
        if (r0 == null) goto L5;
        Map r1 = r0.a;
    L6:
        if (r1 != null) goto L8;
        r1 = MapsKt.emptyMap();
    L8:
        String r2 = this.n;
        if (r2 == null) goto L13;
        a0 r3 = (a0) r1.get(r2);
        if (r3 == null) goto L13;
        return r3;
    L13:
        return (a0) CollectionsKt.firstOrNull(r1.values());
    L5:
        r1 = null;
        goto L6
    }

    public final Map<Integer, Long> z() {
        return MapsKt.toMap(this.o);
    }

    public d() {
        this.l = LazyKt.lazy(new b());
        this.o = new LinkedHashMap();
        this.p = new LinkedHashMap();
    }

    @Override // up8.d
    public final boolean a() {
        a0 r0 = s();
        if (r0 == null) goto L5;
        List r1 = r0.c;
    L6:
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        List r2 = r1;
        if ((r2 instanceof Collection) == true) goto L11;
    L13:
        Iterator r3 = r2.iterator();
    L15:
        if (r3.hasNext() == false) goto L42;
        f0 r4 = (f0) r3.next();
        Integer r5 = r4.f();
        if (r5 == null) goto L32;
        int r6 = r5.intValue();
        com.larus.bmhome.actionbar.model.h r7 = r4.d();
        if (r7 != null) goto L21;
        com.larus.bmhome.actionbar.model.j r8 = r4.e();
        if (r8 == null) goto L32;
        if (Intrinsics.areEqual(r8.j, Boolean.TRUE) == true) goto L32;
        Map<Integer, Integer> r9 = this.p;
        LinkedHashMap r10 = (LinkedHashMap) r9;
        if (r10.get(Integer.valueOf(r6)) != null) goto L32;
    L25:
        boolean r11 = false;
    L33:
        if (r11 == true) goto L15;
        return false;
    L21:
        if (Intrinsics.areEqual(r7.h, Boolean.TRUE) == true) goto L32;
        Map<Integer, Long> r12 = this.o;
        LinkedHashMap r13 = (LinkedHashMap) r12;
        if (r13.get(Integer.valueOf(r6)) == null) goto L25;
    L32:
        r11 = true;
        goto L33
    L42:
        return true;
    L11:
        if (r2.isEmpty() == false) goto L13;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public static Long E(com.larus.bmhome.actionbar.model.h r4) {
        List r5 = r4.e;
        if (r5 == null) goto L26;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L16;
        Object r1 = r6.next();
        Integer r2 = ((w) r1).s;
        if (r2 == null) goto L13;
        boolean r3 = true;
        if (r2.intValue() != 1) goto L13;
    L14:
        if (r3 == false) goto L6;
    L17:
        w r7 = (w) r1;
        if (r7 != null) goto L20;
        return null;
    L20:
        return r7.a;
    L13:
        r3 = false;
        goto L14
    L16:
        r1 = null;
        goto L17
    L26:
        return null;
    }

    public static com.larus.bmhome.actionbar.model.h u(c0 r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        v r1 = xt7.d.b;     // Catch: Throwable -> L7
        juc.c r3 = com.larus.bmhome.actionbar.model.h.Companion.serializer();     // Catch: Throwable -> L7
        String r4 = r2.c;     // Catch: Throwable -> L7
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        Object r5 = Result.constructor-impl((com.larus.bmhome.actionbar.model.h) r1.c(r3, r4));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r5) == false) goto L13;
        r5 = null;
    L13:
        return (com.larus.bmhome.actionbar.model.h) r5;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static Long x(com.larus.bmhome.actionbar.model.h r4) {
        if (Intrinsics.areEqual(r4.h, Boolean.TRUE) == false) goto L5;
        return null;
    L5:
        Long r0 = r4.g;
        if (r0 != null) goto L8;
    L14:
        Integer r1 = r4.f;
        if (r1 == null) goto L17;
        int r2 = r1.intValue();
    L18:
        List r5 = r4.e;
        if (r5 == null) goto L24;
        w r6 = (w) CollectionsKt.getOrNull(r5, r2);
        if (r6 != null) goto L23;
        return null;
    L23:
        return r6.a;
    L24:
        return null;
    L17:
        r2 = -1;
        goto L18
    L8:
        if (w(r4, Long.valueOf(r0.longValue())) == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L14;
        return Long.valueOf(r0.longValue());
    }

    public final void F(Long r3) {
        if (r3 == null) goto L22;
        String r4 = r3.toString();
        if (r4 == null) goto L23;
        com.larus.bmhome.actionbar.model.b r0 = this.m;
        if (r0 == null) goto L8;
        Map r1 = r0.a;
    L9:
        if (r1 != null) goto L12;
        r1 = MapsKt.emptyMap();
    L12:
        if (r1.containsKey(r4) == true) goto L15;
        r4 = null;
    L15:
        if (r4 != null) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(r4, this.n) == false) goto L20;
        return;
    L20:
        this.n = r4;
        B(true, true);
        G();
        FLogger.a.i("CollaboratedMultiFeatureSelectorController", "switchActiveConfigByOptionId activeConfigKey=" + this.n);
        return;
    L8:
        r1 = null;
        goto L9
    L23:
        return;
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new CollaboratedMultiFeatureSelectorWidget(r2);
    }

    @Override // up8.b
    public final void m(Map<String, ?> r10) {
        Intrinsics.checkNotNullParameter(r10, "instructionDefaultParams");
        Object r11 = r10.get("2");
        if ((r11 instanceof Map) == false) goto L5;
        Map r12 = (Map) r11;
    L6:
        com.larus.bmhome.actionbar.model.b r0 = this.m;
        if (r0 == null) goto L24;
        Integer r1 = r0.b;
        if (r1 == null) goto L24;
        String r2 = y(r12, r1.intValue(), false);
        if (r2 == null) goto L24;
        com.larus.bmhome.actionbar.model.b r3 = this.m;
        if (r3 == null) goto L15;
        Map r4 = r3.a;
    L16:
        if (r4 != null) goto L19;
        r4 = MapsKt.emptyMap();
    L19:
        if (r4.containsKey(r2) == true) goto L22;
        r2 = null;
    L22:
        if (r2 == null) goto L24;
        this.n = r2;
        goto L24
    L15:
        r4 = null;
    L24:
        a0 r5 = s();
        if (r5 != null) goto L27;
        return;
    L27:
        List r6 = r5.c;
        if (r6 != null) goto L31;
        r6 = CollectionsKt.emptyList();
    L31:
        if (r6.isEmpty() == false) goto L33;
        return;
    L33:
        t(r5, false, false);
        Iterator r7 = r6.iterator();
    L34:
        boolean r8 = true;
        if (r7.hasNext() == false) goto L88;
        f0 r9 = (f0) r7.next();
        Integer r13 = r9.f();
        if (r13 == null) goto L34;
        int r14 = r13.intValue();
        com.larus.bmhome.actionbar.model.h r15 = r9.d();
        if (r15 == null) goto L34;
        Integer r16 = this.g;
        if (r16 != null) goto L45;
    L52:
        if (r16 != null) goto L55;
    L56:
        if (r16 != null) goto L59;
    L66:
        r8 = false;
    L67:
        String r17 = y(r12, r14, r8);
        if (r17 == null) goto L34;
        List r18 = r15.e;
        if (r18 == null) goto L34;
        Iterator r19 = r18.iterator();
    L74:
        if (r19.hasNext() == false) goto L82;
        Object r20 = r19.next();
        Long r21 = ((w) r20).a;
        if (r21 == null) goto L78;
        String r22 = r21.toString();
    L80:
        if (Intrinsics.areEqual(r22, r17) == false) goto L74;
    L83:
        w r23 = (w) r20;
        if (r23 == null) goto L34;
        Long r24 = r23.a;
        if (r24 == null) goto L34;
        long r25 = r24.longValue();
        this.o.put(Integer.valueOf(r14), Long.valueOf(r25));
        goto L34
    L78:
        r22 = null;
        goto L80
    L82:
        r20 = null;
        goto L83
    L59:
        if (r16.intValue() != 24) goto L66;
    L60:
        Integer r26 = r15.b;
        if (r26 == null) goto L66;
        if (r26.intValue() != 1) goto L66;
    L55:
        if (r16.intValue() == 18) goto L60;
    L45:
        if (r16.intValue() != 4) goto L52;
        Integer r27 = r15.b;
        if (r27 == null) goto L66;
        if (r27.intValue() != 2) goto L66;
    L88:
        B(false, true);
        G();
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // up8.b
    public final wa8.a0 n(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r11 = Result.constructor-impl((com.larus.bmhome.actionbar.model.b) xt7.d.b.c(com.larus.bmhome.actionbar.model.b.Companion.serializer(), r10));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r11);
        if (r4 != null) goto L76;
        com.larus.bmhome.actionbar.model.b r12 = (com.larus.bmhome.actionbar.model.b) r11;
        this.m = r12;
        Map r5 = r12.a;
        if (r5 != null) goto L21;
        r5 = MapsKt.emptyMap();
    L21:
        String r6 = r12.c;
        String r7 = null;
        if (r6 != null) goto L24;
    L29:
        com.larus.bmhome.actionbar.model.b r8 = this.m;
        if (r8 == null) goto L63;
        Integer r9 = r8.b;
        if (r9 == null) goto L63;
        int r13 = r9.intValue();
        up8.b r14 = this.f;
        if (r14 == null) goto L63;
        List<up8.b> r15 = r14.f();
        if (r15 == null) goto L63;
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L39:
        if (r17.hasNext() == false) goto L43;
        Object r18 = r17.next();
        if ((r18 instanceof g) == false) goto L39;
        r16.add(r18);
        goto L39
    L43:
        Iterator r19 = r16.iterator();
    L45:
        if (r19.hasNext() == false) goto L57;
        Object r20 = r19.next();
        com.larus.bmhome.actionbar.model.h r21 = ((g) r20).l;
        if (r21 == null) goto L54;
        Integer r22 = r21.b;
        if (r22 == null) goto L54;
        if (r22.intValue() != r13) goto L54;
        boolean r23 = true;
    L55:
        if (r23 == false) goto L45;
    L58:
        g r24 = (g) r20;
        if (r24 == null) goto L63;
        com.larus.bmhome.actionbar.model.h r0 = r24.l;
        if (r0 == null) goto L63;
        Long r1 = E(r0);
    L64:
        if (r1 == null) goto L72;
        String r25 = r1.toString();
        if (r25 == null) goto L72;
        if (r5.containsKey(r25) == false) goto L70;
        r7 = r25;
    L70:
        if (r7 == null) goto L72;
        r6 = r7;
    L73:
        this.n = r6;
        t(s(), true, true);
        G();
        FLogger.a.i("CollaboratedMultiFeatureSelectorController", "parseTemplate activeConfigKey=" + this.n + ", collaboratedDropdownBoxId=" + r12.b);
        return new wa8.a0(Boolean.TRUE, "");
    L72:
        r6 = (String) CollectionsKt.firstOrNull(r5.keySet());
    L54:
        r23 = false;
        goto L55
    L57:
        r20 = null;
    L63:
        r1 = null;
        goto L64
    L24:
        if (r5.containsKey(r6) == true) goto L27;
        r6 = null;
    L27:
        if (r6 == null) goto L29;
    L76:
        return new wa8.a0(Boolean.FALSE, r4.getMessage());
    L14:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "collaborated multi feature selector is empty template");
    L5:
        if (r10.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static boolean A(com.larus.bmhome.actionbar.model.j r5, Integer r6) {
        if (r6 == null) goto L28;
        r6.intValue();
        Integer r1 = r5.d;
        if (r1 == null) goto L29;
        int r2 = r1.intValue();
        Integer r3 = r5.e;
        if (r3 == null) goto L30;
        int r4 = r3.intValue();
        Integer r7 = r5.f;
        if (r7 == null) goto L11;
        int r8 = r7.intValue();
    L12:
        Integer r9 = Integer.valueOf(r8);
        if (r9.intValue() <= 0) goto L15;
        boolean r10 = true;
    L16:
        if (r10 == true) goto L19;
        r9 = null;
    L19:
        if (r9 == null) goto L21;
        int r11 = r9.intValue();
    L23:
        if (new IntRange(r2, r4).contains(r6.intValue()) == true) goto L25;
        return false;
    L25:
        if (((r6.intValue() - r2) % r11) != 0) goto L32;
        return true;
    L32:
        return false;
    L21:
        r11 = 1;
        goto L23
    L15:
        r10 = false;
        goto L16
    L11:
        r8 = 1;
        goto L12
    L30:
        return false;
    L29:
        return false;
    L28:
        return false;
    }

    public static boolean w(com.larus.bmhome.actionbar.model.h r3, Long r4) {
        if (r4 == null) goto L24;
        r4.longValue();
        List r5 = r3.e;
        if (r5 == null) goto L25;
        List r6 = r5;
        if ((r6 instanceof Collection) == true) goto L9;
    L11:
        Iterator r7 = r6.iterator();
    L13:
        if (r7.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(((w) r7.next()).a, r4) == false) goto L13;
        boolean r8 = true;
    L18:
        if (r8 != true) goto L26;
        return true;
    L26:
        return false;
    L17:
        r8 = false;
        goto L18
    L9:
        if (r6.isEmpty() == false) goto L11;
    L25:
        return false;
    L24:
        return false;
    }

    public final void B(boolean r2, boolean r3) {
        t(s(), r3, r2);
    }

    public final Long C(int r12, String r13) {
        String r0 = D(r12, r13);
        boolean r2 = false;
        if (((Keva) this.l.getValue()).contains(r0) == false) goto L10;
        Long r14 = Long.valueOf(((Keva) this.l.getValue()).getLong(r0, -1));
        if (r14.longValue() == (-1)) goto L7;
        r2 = true;
    L7:
        if (r2 == true) goto L9;
        return null;
    L9:
        return r14;
    L10:
        Keva r1 = (Keva) this.l.getValue();
        String r7 = this.n;
        if (r7 != null) goto L18;
        a0 r8 = s();
        if (r8 == null) goto L15;
        r7 = r8.a;
    L16:
        if (r7 != null) goto L18;
        r7 = "default";
        goto L18
    L15:
        r7 = null;
    L18:
        StringBuilder r9 = new StringBuilder("collab_");
        com.larus.bmhome.view.actionbar.edit.c r10 = this.c;
        if (r10 == null) goto L21;
        Integer r11 = r10.getInstructionType();
    L22:
        r9.append(r11);
        r9.append('_');
        r9.append(this.g);
        r9.append('_');
        u r15 = this.b;
        if (r15 == null) goto L25;
        Integer r16 = r15.a;
    L26:
        r9.append(r16);
        r9.append('_');
        com.larus.bmhome.actionbar.model.b r17 = this.m;
        if (r17 == null) goto L29;
        Integer r18 = r17.b;
    L30:
        r9.append(r18);
        r9.append('_');
        r9.append(r7);
        r9.append('_');
        r9.append(r12);
        r9.append('_');
        r9.append(r13);
        Long r19 = Long.valueOf(r1.getLong(r9.toString(), -1));
        if (r19.longValue() == (-1)) goto L33;
        r2 = true;
    L33:
        if (r2 == true) goto L36;
        r19 = null;
    L36:
        if (r19 == null) goto L40;
        ((Keva) this.l.getValue()).storeLong(r0, r19.longValue());
        return r19;
    L40:
        return null;
    L29:
        r18 = null;
        goto L30
    L25:
        r16 = null;
        goto L26
    L21:
        r11 = null;
        goto L22
    }

    public final String D(int r5, String r6) {
        StringBuilder r0 = new StringBuilder("collab_");
        com.larus.bmhome.view.actionbar.edit.c r1 = this.c;
        Integer r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = r1.getInstructionType();
    L6:
        r0.append(r3);
        r0.append('_');
        r0.append(this.g);
        r0.append('_');
        u r4 = this.b;
        if (r4 == null) goto L9;
        Integer r7 = r4.a;
    L10:
        r0.append(r7);
        r0.append('_');
        com.larus.bmhome.actionbar.model.b r8 = this.m;
        if (r8 == null) goto L13;
        r2 = r8.b;
    L13:
        r0.append(r2);
        r0.append('_');
        r0.append(r5);
        r0.append('_');
        r0.append(r6);
        return r0.toString();
    L9:
        r7 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // up8.b
    public final void k(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "defaultStateTemplate");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl((com.larus.bmhome.actionbar.model.b) xt7.d.b.c(com.larus.bmhome.actionbar.model.b.Companion.serializer(), r5));     // Catch: Throwable -> L5
    L7:
        List r0 = null;
        if (Result.isFailure-impl(r8) == false) goto L10;
        r8 = null;
    L10:
        com.larus.bmhome.actionbar.model.b r9 = (com.larus.bmhome.actionbar.model.b) r8;
        if (r9 != null) goto L13;
        return;
    L13:
        String r10 = r9.c;
        if (r10 == null) goto L27;
        com.larus.bmhome.actionbar.model.b r1 = this.m;
        if (r1 == null) goto L18;
        Map r2 = r1.a;
    L19:
        if (r2 != null) goto L22;
        r2 = MapsKt.emptyMap();
    L22:
        if (r2.containsKey(r10) == true) goto L25;
        r10 = null;
    L25:
        if (r10 == null) goto L27;
    L28:
        this.n = r10;
        a0 r11 = r9.d();
        if (r11 == null) goto L31;
        r0 = r11.c;
    L31:
        if (r0 != null) goto L33;
        r0 = CollectionsKt.emptyList();
    L33:
        Iterator r12 = r0.iterator();
    L35:
        if (r12.hasNext() == false) goto L48;
        f0 r13 = (f0) r12.next();
        Integer r3 = r13.f();
        if (r3 == null) goto L35;
        int r4 = r3.intValue();
        com.larus.bmhome.actionbar.model.h r14 = r13.d();
        if (r14 == null) goto L43;
        Long r15 = E(r14);
        if (r15 == null) goto L43;
        long r16 = r15.longValue();
        this.o.put(Integer.valueOf(r4), Long.valueOf(r16));
    L43:
        com.larus.bmhome.actionbar.model.j r17 = r13.e();
        if (r17 == null) goto L35;
        Integer r18 = r17.i;
        if (r18 == null) goto L35;
        int r19 = r18.intValue();
        this.p.put(Integer.valueOf(r4), Integer.valueOf(r19));
        goto L35
    L48:
        B(false, true);
        G();
        return;
    L18:
        r2 = null;
    L27:
        r10 = this.n;
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void v(Map<Integer, Long> r6, Map<Integer, Integer> r7) {
        Intrinsics.checkNotNullParameter(r6, "selectedDropdownOptionIds");
        Intrinsics.checkNotNullParameter(r7, "selectedDurations");
        ((LinkedHashMap) this.o).clear();
        this.o.putAll(r6);
        ((LinkedHashMap) this.p).clear();
        this.p.putAll(r7);
        B(false, true);
        a0 r8 = s();
        if (r8 == null) goto L5;
        List r9 = r8.c;
    L6:
        if (r9 != null) goto L8;
        r9 = CollectionsKt.emptyList();
    L8:
        Iterator r10 = r9.iterator();
    L10:
        if (r10.hasNext() == false) goto L27;
        f0 r11 = (f0) r10.next();
        Integer r0 = r11.f();
        if (r0 == null) goto L10;
        int r1 = r0.intValue();
        com.larus.bmhome.actionbar.model.h r2 = r11.d();
        if (r2 != null) goto L16;
    L20:
        com.larus.bmhome.actionbar.model.j r12 = r11.e();
        if (r12 == null) goto L10;
        if (Intrinsics.areEqual(r12.k, Boolean.TRUE) == false) goto L10;
        Integer r13 = (Integer) ((LinkedHashMap) this.p).get(Integer.valueOf(r1));
        if (r13 == null) goto L10;
        ((Keva) this.l.getValue()).storeLong(D(r1, "duration"), r13.intValue());
        goto L10
    L16:
        if (Intrinsics.areEqual(r2.i, Boolean.TRUE) == false) goto L20;
        Long r3 = (Long) ((LinkedHashMap) this.o).get(Integer.valueOf(r1));
        if (r3 == null) goto L20;
        ((Keva) this.l.getValue()).storeLong(D(r1, "dropdown"), r3.longValue());
        goto L20
    L27:
        G();
        return;
    L5:
        r9 = null;
        goto L6
    }

    public static String y(Map r2, int r3, boolean r4) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Object r1 = r2.get(String.valueOf(r3));
        if (r1 != null) goto L13;
        r1 = r2.get(Integer.valueOf(r3));
        if (r1 != null) goto L13;
        if (r4 == false) goto L11;
        r1 = r2.get("match_all_id");
        goto L13
    L11:
        r1 = null;
    L13:
        if ((r1 instanceof Map) == false) goto L15;
        Map r5 = (Map) r1;
    L16:
        if (r5 == null) goto L21;
        Object r6 = r5.get("default_select_id");
        if (r6 != null) goto L20;
        return null;
    L20:
        return r6.toString();
    L21:
        return null;
    L15:
        r5 = null;
        goto L16
    }

    public final void t(a0 r18, boolean r19, boolean r20) {
        if (r18 == null) goto L5;
        List r1 = r18.c;
    L6:
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        Iterator r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L212;
        f0 r3 = (f0) r2.next();
        Integer r4 = r3.f();
        if (r4 == null) goto L10;
        int r5 = r4.intValue();
        com.larus.bmhome.actionbar.model.h r6 = r3.d();
        long r7 = -1;
        boolean r8 = false;
        if (r6 == null) goto L103;
        Object r10 = ((LinkedHashMap) this.o).get(Integer.valueOf(r5));
        Long r11 = (Long) r10;
        if (r19 == true) goto L18;
    L20:
        boolean r12 = false;
    L21:
        if (r12 == true) goto L24;
        r10 = null;
    L24:
        Long r13 = (Long) r10;
        if (r20 == true) goto L27;
    L29:
        Long r14 = null;
    L30:
        if (r20 == true) goto L32;
    L36:
        Long r15 = null;
    L37:
        if (r13 != null) goto L43;
        if (r15 != null) goto L42;
        r13 = E(r6);
        if (r13 != null) goto L43;
        r13 = x(r6);
        goto L43
    L42:
        r13 = r15;
    L43:
        List r16 = r6.e;
        if (r16 == null) goto L53;
        Iterator r17 = r16.iterator();
    L47:
        if (r17.hasNext() == false) goto L51;
        Object r110 = r17.next();
        if (Intrinsics.areEqual(((w) r110).a, r13) == false) goto L47;
    L52:
        w r111 = (w) r110;
    L54:
        if (r111 == null) goto L59;
        if (j0.g(r111) == true) goto L59;
    L88:
        this.o.put(Integer.valueOf(r5), r13);
        if (r20 == true) goto L91;
    L94:
        boolean r9 = false;
    L95:
        if (r9 == false) goto L103;
        if (Intrinsics.areEqual(r14, r13) == true) goto L103;
        if (r13 == null) goto L101;
        long r112 = r13.longValue();
    L102:
        ((Keva) this.l.getValue()).storeLong(D(r5, "dropdown"), r112);
        goto L103
    L101:
        r112 = -1;
        goto L102
    L91:
        if (Intrinsics.areEqual(r6.i, Boolean.TRUE) == false) goto L94;
        if (r14 == null) goto L94;
        r9 = true;
    L59:
        if (Intrinsics.areEqual(r6.h, Boolean.TRUE) == false) goto L61;
    L60:
        r13 = null;
        goto L88
    L61:
        r13 = x(r6);
        List r113 = r6.e;
        if (r113 == null) goto L71;
        Iterator r114 = r113.iterator();
    L65:
        if (r114.hasNext() == false) goto L69;
        Object r115 = r114.next();
        if (Intrinsics.areEqual(((w) r115).a, r13) == false) goto L65;
    L70:
        w r116 = (w) r115;
    L72:
        if (r116 != null) goto L74;
    L76:
        List r117 = r6.e;
        if (r117 == null) goto L60;
        Iterator r118 = r117.iterator();
    L80:
        if (r118.hasNext() == false) goto L84;
        Object r119 = r118.next();
        if ((!j0.g((w) r119)) == false) goto L80;
    L85:
        w r120 = (w) r119;
        if (r120 == null) goto L60;
        r13 = r120.a;
        goto L88
    L84:
        r119 = null;
        goto L85
    L74:
        if (j0.g(r116) == true) goto L76;
    L69:
        r115 = null;
        goto L70
    L71:
        r116 = null;
        goto L72
    L51:
        r110 = null;
        goto L52
    L53:
        r111 = null;
        goto L54
    L32:
        if (Intrinsics.areEqual(r6.i, Boolean.TRUE) == false) goto L36;
        if (w(r6, r14) == false) goto L36;
        r15 = r14;
        goto L37
    L27:
        if (Intrinsics.areEqual(r6.i, Boolean.TRUE) == false) goto L29;
        r14 = C(r5, "dropdown");
        goto L30
    L18:
        if (w(r6, r11) == false) goto L20;
        r12 = true;
    L103:
        com.larus.bmhome.actionbar.model.j r21 = r3.e();
        if (r21 == null) goto L10;
        Object r22 = ((LinkedHashMap) this.p).get(Integer.valueOf(r5));
        Integer r121 = (Integer) r22;
        if (r19 == true) goto L108;
    L110:
        boolean r122 = false;
    L111:
        if (r122 == true) goto L114;
        r22 = null;
    L114:
        Integer r23 = (Integer) r22;
        if (r20 == true) goto L117;
    L131:
        Integer r123 = null;
    L132:
        if (r20 == true) goto L134;
    L138:
        Integer r124 = null;
    L139:
        if (r23 != null) goto L157;
        if (r124 != null) goto L155;
        r23 = r21.i;
        if (A(r21, r23) == true) goto L145;
        r23 = null;
    L145:
        if (r23 != null) goto L157;
        r23 = r21.h;
        if (Intrinsics.areEqual(r21.j, Boolean.TRUE) == false) goto L149;
    L151:
        boolean r125 = false;
    L152:
        if (r125 == true) goto L157;
        r23 = null;
        goto L157
    L149:
        if (A(r21, r23) == false) goto L151;
        r125 = true;
        goto L152
    L155:
        r23 = r124;
    L157:
        if (A(r21, r23) == false) goto L162;
        if (j0.f(r21, r23) == true) goto L162;
    L193:
        this.p.put(Integer.valueOf(r5), r23);
        if (r20 == true) goto L196;
    L199:
        if (r123 == null) goto L201;
        Long r24 = Long.valueOf(r123.intValue());
    L202:
        if (r23 == null) goto L204;
        Long r25 = Long.valueOf(r23.intValue());
    L205:
        if (r8 == false) goto L10;
        if (Intrinsics.areEqual(r24, r25) == true) goto L10;
        if (r25 == null) goto L211;
        r7 = r25.longValue();
    L211:
        ((Keva) this.l.getValue()).storeLong(D(r5, "duration"), r7);
        goto L10
    L204:
        r25 = null;
        goto L205
    L201:
        r24 = null;
        goto L202
    L196:
        if (Intrinsics.areEqual(r21.k, Boolean.TRUE) == false) goto L199;
        if (r123 == null) goto L199;
        r8 = true;
    L162:
        if (Intrinsics.areEqual(r21.j, Boolean.TRUE) == true) goto L192;
        r23 = r21.h;
        if (A(r21, r23) == true) goto L167;
    L169:
        Integer r26 = r21.d;
        if (r26 == null) goto L192;
        int r27 = r26.intValue();
        Integer r126 = r21.e;
        if (r126 == null) goto L192;
        int r127 = r126.intValue();
        Integer r128 = r21.f;
        if (r128 == null) goto L176;
        int r129 = r128.intValue();
    L177:
        Integer r130 = Integer.valueOf(r129);
        if (r130.intValue() <= 0) goto L180;
        boolean r131 = true;
    L181:
        if (r131 == true) goto L184;
        r130 = null;
    L184:
        if (r130 == null) goto L186;
        int r132 = r130.intValue();
    L187:
        if (r27 > r127) goto L192;
        if (j0.f(r21, Integer.valueOf(r27)) == false) goto L190;
        r27 = r27 + r132;
        goto L187
    L190:
        r23 = Integer.valueOf(r27);
        goto L193
    L186:
        r132 = 1;
        goto L187
    L180:
        r131 = false;
        goto L181
    L176:
        r129 = 1;
        goto L177
    L167:
        if (j0.f(r21, r23) == true) goto L169;
    L192:
        r23 = null;
        goto L193
    L134:
        if (Intrinsics.areEqual(r21.k, Boolean.TRUE) == false) goto L138;
        if (A(r21, r123) == false) goto L138;
        r124 = r123;
        goto L139
    L117:
        if (Intrinsics.areEqual(r21.k, Boolean.TRUE) == false) goto L131;
        Long r133 = C(r5, "duration");
        if (r133 == null) goto L131;
        long r134 = r133.longValue();
        if (r134 >= (-2147483648L)) goto L123;
    L125:
        boolean r135 = false;
    L126:
        if (r135 == true) goto L129;
        r133 = null;
    L129:
        if (r133 == null) goto L131;
        r123 = Integer.valueOf((int) r133.longValue());
        goto L132
    L123:
        if (r134 > 2147483647L) goto L125;
        r135 = true;
        goto L126
    L108:
        if (A(r21, r121) == false) goto L110;
        r122 = true;
        goto L111
    L212:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
