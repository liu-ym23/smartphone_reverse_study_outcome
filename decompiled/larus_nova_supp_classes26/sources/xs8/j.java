package xs8;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.actionbar.model.b0;
import com.larus.bmhome.actionbar.model.c0;
import com.larus.bmhome.actionbar.model.f0;
import com.larus.bmhome.actionbar.model.g0;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.instruction.IInstructionSubCreator;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.actionbar.edit.component.MultiSelectorWidget;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ouc.v;
import wa8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j extends up8.b {
    public b0 l;
    public com.larus.bmhome.view.actionbar.edit.d m;

    public static final class a {
    }

    static {
    }

    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.b
    public int getType() {
        return 8;
    }

    @Override // up8.d
    public final String g() {
        Object r1 = null;
        if (this.l != null) goto L5;
        return null;
    L5:
        List<up8.b> r0 = this.k;
        if (r0 == null) goto L37;
        Iterator<T> r2 = r0.iterator();
        int r3 = 0;
    L9:
        if (r2.hasNext() == false) goto L37;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        up8.b r6 = (up8.b) r4;
        if (r6 == null) goto L22;
        b0 r7 = this.l;
        if (r7 == null) goto L22;
        List r8 = r7.a;
        if (r8 == null) goto L22;
        c0 r9 = (c0) ListProtector.get(r8, r3);
        if (r9 == null) goto L22;
        r9.c = r6.g();
    L22:
        r3 = r5;
    L37:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L29
        v r11 = xt7.d.b;     // Catch: Throwable -> L29
        juc.n r12 = kuc.a.d(b0.Companion.serializer());     // Catch: Throwable -> L29
        b0 r13 = this.l;     // Catch: Throwable -> L29
        if (r13 == null) goto L26;
        b0 r14 = g0.a(r13);     // Catch: Throwable -> L29
    L27:
        Object r15 = Result.constructor-impl(r11.a(r12, r14));     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r15) == true) goto L36;
        r1 = r15;
    L36:
        return (String) r1;
    L26:
        r14 = null;
    L29:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    }

    public j() {
        this.k = new ArrayList();
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new MultiSelectorWidget(r2);
    }

    @Override // up8.b
    public final a0 n(String r17) {
        if (r17 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        Object r0 = Result.constructor-impl((b0) xt7.d.b.c(b0.Companion.serializer(), r17));     // Catch: Throwable -> L14
    L16:
        Throwable r3 = Result.exceptionOrNull-impl(r0);
        if (r3 != null) goto L89;
        b0 r4 = (b0) r0;
        if (r4 == null) goto L21;
        List r5 = r4.a;
    L22:
        List r6 = r5;
        if (r6 != null) goto L25;
    L28:
        boolean r7 = true;
    L29:
        if (r7 == true) goto L31;
        this.l = r4;
        if (r4 == null) goto L87;
        List r8 = r4.a;
        if (r8 == null) goto L87;
        Iterator r9 = r8.iterator();
        int r10 = 0;
    L38:
        if (r9.hasNext() == false) goto L87;
        Object r11 = r9.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();
    L42:
        c0 r13 = (c0) r11;
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        Set<IInstructionSubCreator> r16 = rs8.m.c;
        if (r16 == null) goto L61;
        Iterator<T> r18 = r16.iterator();
    L46:
        if (r18.hasNext() == false) goto L53;
        Object r19 = r18.next();
        if (((IInstructionSubCreator) r19).getMultiItemType() != r13.b) goto L50;
        boolean r20 = true;
    L51:
        if (r20 == false) goto L46;
    L54:
        IInstructionSubCreator r21 = (IInstructionSubCreator) r19;
        if (r21 == null) goto L61;
        up8.b r110 = r21.d();
        r110.d = this.d;
        r110.e = this.e;
        r110.g = this.g;
        ActivityResultLauncher<String> r22 = this.h;
        ActivityResultLauncher<Intent> r23 = this.i;
        r110.h = r22;
        r110.i = r23;
        r110.q(r13.a);
        String r24 = r13.c;
        if (r24 == null) goto L59;
        a0 r25 = r110.r(r24, this.c, r110.b, this.m, this);
    L60:
        r15.element = r25;
        FLogger.a.d("MultiSelectorController", "DROP_DOWN_BOX itemBuildResult=" + r15.element);
        r14.element = r110;
        goto L61
    L59:
        r25 = null;
        goto L60
    L50:
        r20 = false;
        goto L51
    L53:
        r19 = null;
    L61:
        a0 r26 = (a0) r15.element;
        if (r26 == null) goto L64;
        boolean r27 = Intrinsics.areEqual(r26.a, Boolean.TRUE);
    L65:
        if (r27 == false) goto L71;
        up8.b r28 = (up8.b) r14.element;
        if (r28 == null) goto L74;
        List<up8.b> r29 = this.k;
        if (r29 == null) goto L74;
        r29.add(r28);
    L74:
        Pair[] r30 = new Pair[3];
        a0 r31 = (a0) r15.element;
        if (r31 == null) goto L77;
        boolean r32 = Intrinsics.areEqual(r31.a, Boolean.TRUE);
    L78:
        if (r32 == false) goto L80;
        String r33 = "1";
    L81:
        r30[0] = TuplesKt.to("is_success", r33);
        a0 r34 = (a0) r15.element;
        if (r34 == null) goto L84;
        String r35 = r34.b;
    L85:
        r30[1] = TuplesKt.to("fail_reason", r35);
        r30[2] = TuplesKt.to("instruction_multiselect_item_type", String.valueOf(r13.b));
        com.larus.platform.service.o.a.b("flow_instruction_decode_template", com.larus.utils.f.c(r30));
        r10 = r12;
        goto L38
    L84:
        r35 = null;
        goto L85
    L80:
        r33 = TriggerSendLoading.NO_LOADING;
        goto L81
    L77:
        r32 = false;
        goto L78
    L71:
        List<up8.b> r36 = this.k;
        if (r36 == null) goto L74;
        r36.add(null);
        goto L74
    L64:
        r27 = false;
    L87:
        return new a0(Boolean.TRUE, "");
    L31:
        return new a0(Boolean.FALSE, "multi option is empty");
    L25:
        if (r6.isEmpty() == true) goto L28;
        r7 = false;
        goto L29
    L21:
        r5 = null;
        goto L22
    L89:
        return new a0(Boolean.FALSE, r3.getMessage());
    L14:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "feature selector is empty template");
    L5:
        if (r17.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // up8.b
    public final void k(String r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r22, "defaultStateTemplate");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r0 = Result.constructor-impl((b0) xt7.d.b.c(b0.Companion.serializer(), r22));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r0) == false) goto L10;
        r0 = null;
    L10:
        b0 r1 = (b0) r0;
        if (r1 != null) goto L13;
        return;
    L13:
        List r3 = r1.a;
        if (r3 == null) goto L42;
        Iterator r4 = r3.iterator();
    L17:
        if (r4.hasNext() == false) goto L42;
        c0 r6 = (c0) r4.next();
        b0 r7 = this.l;
        if (r7 == null) goto L17;
        List r8 = r7.a;
        if (r8 == null) goto L17;
        Iterator r9 = r8.iterator();
        int r10 = 0;
    L24:
        if (r9.hasNext() == false) goto L34;
        c0 r11 = (c0) r9.next();
        if (r11.b == r6.b) goto L28;
    L30:
        boolean r12 = false;
    L31:
        if (r12 == true) goto L35;
        r10 = r10 + 1;
    L35:
        String r13 = r6.c;
        if (r13 == null) goto L17;
        List<up8.b> r14 = f();
        if (r14 == null) goto L17;
        up8.b r15 = (up8.b) CollectionsKt.getOrNull(r14, r10);
        if (r15 == null) goto L17;
        up8.b.l(r15, r13);
        goto L17
    L28:
        if (Intrinsics.areEqual(r11.a, r6.a) == false) goto L30;
        r12 = true;
        goto L31
    L34:
        r10 = -1;
    L42:
        List r5 = r1.a;
        if (r5 != null) goto L45;
        r5 = CollectionsKt.emptyList();
    L45:
        List r16 = r5;
        b0 r17 = this.l;
        if (r17 == null) goto L225;
        List r18 = r17.a;
        if (r18 == null) goto L291;
        Iterator r19 = r18.iterator();
        int r20 = 0;
    L51:
        if (r19.hasNext() == false) goto L292;
        Object r21 = r19.next();
        int r24 = r20 + 1;
        if (r20 >= 0) goto L56;
        CollectionsKt.throwIndexOverflow();
    L56:
        if (((c0) r21).b != 9) goto L224;
        List<up8.b> r25 = f();
        if (r25 == null) goto L61;
        up8.b r26 = (up8.b) CollectionsKt.getOrNull(r25, r20);
    L63:
        if ((r26 instanceof d) == false) goto L65;
        d r27 = (d) r26;
    L66:
        if (r27 == null) goto L224;
        Intrinsics.checkNotNullParameter(r16, "defaultSelectorStates");
        com.larus.bmhome.actionbar.model.b r28 = r27.m;
        if (r28 == null) goto L224;
        Integer r29 = r28.b;
        if (r29 == null) goto L101;
        int r30 = r29.intValue();
        Iterator r110 = r16.iterator();
    L74:
        if (r110.hasNext() == false) goto L86;
        Object r111 = r110.next();
        c0 r112 = (c0) r111;
        if (r112.b != 3) goto L83;
        Integer r113 = r112.a;
        if (r113 == null) goto L83;
        if (r113.intValue() != r30) goto L83;
        boolean r114 = true;
    L84:
        if (r114 == false) goto L74;
    L87:
        c0 r115 = (c0) r111;
        if (r115 == null) goto L101;
        com.larus.bmhome.actionbar.model.h r31 = d.u(r115);
        if (r31 == null) goto L101;
        Long r32 = d.E(r31);
        if (r32 == null) goto L101;
        String r33 = r32.toString();
        if (r33 == null) goto L101;
        Map r34 = r28.a;
        if (r34 != null) goto L99;
        r34 = MapsKt.emptyMap();
    L99:
        if (r34.containsKey(r33) == false) goto L101;
    L102:
        if (r33 == null) goto L104;
        r27.n = r33;
    L104:
        com.larus.bmhome.actionbar.model.a0 r35 = r27.s();
        if (r35 == null) goto L107;
        List r36 = r35.c;
    L108:
        if (r36 != null) goto L110;
        r36 = CollectionsKt.emptyList();
    L110:
        List r116 = r36;
        List r37 = r16;
        ArrayList r117 = new ArrayList();
        Iterator r118 = r37.iterator();
    L112:
        if (r118.hasNext() == false) goto L119;
        Object r119 = r118.next();
        if (((c0) r119).b != 3) goto L116;
        boolean r120 = true;
    L117:
        if (r120 == false) goto L112;
        r117.add(r119);
        goto L112
    L116:
        r120 = false;
        goto L117
    L119:
        ArrayList r121 = new ArrayList();
        Iterator r122 = r117.iterator();
    L121:
        if (r122.hasNext() == false) goto L131;
        c0 r123 = (c0) r122.next();
        Integer r124 = r123.a;
        if (r124 == null) goto L128;
        int r125 = r124.intValue();
        com.larus.bmhome.actionbar.model.h r126 = d.u(r123);
        if (r126 == null) goto L128;
        Pair r127 = TuplesKt.to(Integer.valueOf(r125), r126);
    L129:
        if (r127 == null) goto L121;
        r121.add(r127);
    L128:
        r127 = null;
        goto L129
    L131:
        Map r128 = MapsKt.toMap(r121);
        ArrayList r129 = new ArrayList();
        Iterator r130 = r128.entrySet().iterator();
    L133:
        if (r130.hasNext() == false) goto L150;
        Map.Entry r131 = (Map.Entry) r130.next();
        int r132 = ((Number) r131.getKey()).intValue();
        Long r133 = d.E((com.larus.bmhome.actionbar.model.h) r131.getValue());
        if (r133 == null) goto L147;
        long r134 = r133.longValue();
        if (r134 >= (-2147483648L)) goto L139;
    L141:
        boolean r135 = false;
    L142:
        if (r135 == true) goto L145;
        r133 = null;
    L145:
        if (r133 == null) goto L147;
        Pair r38 = TuplesKt.to(Integer.valueOf(r132), Integer.valueOf((int) r133.longValue()));
    L148:
        if (r38 == null) goto L133;
        r129.add(r38);
        goto L133
    L139:
        if (r134 > 2147483647L) goto L141;
        r135 = true;
    L147:
        r38 = null;
        goto L148
    L150:
        Map r39 = MapsKt.toMap(r129);
        ArrayList r40 = new ArrayList();
        Iterator r41 = r37.iterator();
    L152:
        if (r41.hasNext() == false) goto L159;
        Object r136 = r41.next();
        if (((c0) r136).b != 10) goto L156;
        boolean r137 = true;
    L157:
        if (r137 == false) goto L152;
        r40.add(r136);
        goto L152
    L156:
        r137 = false;
        goto L157
    L159:
        ArrayList r138 = new ArrayList();
        Iterator r42 = r40.iterator();
    L161:
        if (r42.hasNext() == false) goto L184;
        c0 r43 = (c0) r42.next();
        Integer r139 = r43.a;
        if (r139 == null) goto L181;
        int r140 = r139.intValue();
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L170
        v r142 = xt7.d.b;     // Catch: Throwable -> L170
        juc.c r143 = com.larus.bmhome.actionbar.model.j.Companion.serializer();     // Catch: Throwable -> L170
        String r44 = r43.c;     // Catch: Throwable -> L170
        if (r44 != null) goto L168;
        r44 = "";
    L168:
        Object r45 = Result.constructor-impl((com.larus.bmhome.actionbar.model.j) r142.c(r143, r44));     // Catch: Throwable -> L170
    L173:
        if (Result.isFailure-impl(r45) == false) goto L175;
        r45 = null;
    L175:
        com.larus.bmhome.actionbar.model.j r46 = (com.larus.bmhome.actionbar.model.j) r45;
        if (r46 == null) goto L181;
        Integer r47 = r46.i;
        if (r47 == null) goto L181;
        Pair r48 = TuplesKt.to(Integer.valueOf(r140), Integer.valueOf(r47.intValue()));
    L182:
        if (r48 == null) goto L161;
        r138.add(r48);
    L170:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
    L181:
        r48 = null;
        goto L182
    L184:
        Map r49 = MapsKt.plus(r39, MapsKt.toMap(r138));
        Iterator r50 = r116.iterator();
        boolean r51 = false;
    L186:
        if (r50.hasNext() == false) goto L219;
        f0 r145 = (f0) r50.next();
        Integer r146 = r145.f();
        if (r146 == null) goto L186;
        int r147 = r146.intValue();
        com.larus.bmhome.actionbar.model.h r148 = r145.d();
        if (r148 == null) goto L205;
        com.larus.bmhome.actionbar.model.h r149 = (com.larus.bmhome.actionbar.model.h) r128.get(Integer.valueOf(r147));
        if (r149 == null) goto L194;
        Long r150 = d.E(r149);
        if (r150 == null) goto L205;
        if (d.w(r148, Long.valueOf(r150.longValue())) == true) goto L202;
        r150 = null;
    L202:
        if (r150 == null) goto L205;
        long r151 = r150.longValue();
        r27.o.put(Integer.valueOf(r147), Long.valueOf(r151));
    L204:
        r51 = true;
        goto L205
    L194:
        if (Intrinsics.areEqual(r148.h, Boolean.TRUE) == false) goto L205;
        r27.o.put(Integer.valueOf(r147), null);
    L205:
        com.larus.bmhome.actionbar.model.j r152 = r145.e();
        if (r152 == null) goto L186;
        Integer r153 = (Integer) r49.get(Integer.valueOf(r147));
        if (r153 == null) goto L210;
        if (d.A(r152, Integer.valueOf(r153.intValue())) == true) goto L216;
        r153 = null;
    L216:
        if (r153 == null) goto L186;
        int r52 = r153.intValue();
        r27.p.put(Integer.valueOf(r147), Integer.valueOf(r52));
    L218:
        r51 = true;
        goto L186
    L210:
        if (Intrinsics.areEqual(r152.j, Boolean.TRUE) == false) goto L186;
        r27.p.put(Integer.valueOf(r147), null);
        goto L218
    L219:
        if (r51 == true) goto L223;
        if (r33 == null) goto L224;
    L223:
        r27.B(false, true);
        r27.G();
        goto L224
    L107:
        r36 = null;
    L83:
        r114 = false;
        goto L84
    L86:
        r111 = null;
    L101:
        r33 = null;
        goto L102
    L65:
        r27 = null;
        goto L66
    L61:
        r26 = null;
    L224:
        r20 = r24;
        goto L51
    L292:
        return;
    L291:
        return;
    L225:
        return;
    L5:
        th = move-exception;
        Result.Companion r53 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // up8.b, up8.d
    public final a0 b(u r1, com.larus.bmhome.view.actionbar.edit.c r2, com.larus.bmhome.view.actionbar.edit.d r3, up8.b r4) {
        this.m = r3;
        return super.b(r1, r2, r3, r4);
    }

    @Override // up8.b
    public final a0 r(String r2, com.larus.bmhome.view.actionbar.edit.c r3, u r4, com.larus.bmhome.view.actionbar.edit.d r5, up8.b r6) {
        Intrinsics.checkNotNullParameter(r2, "template");
        this.m = r5;
        return super.r(r2, r3, r4, r5, r6);
    }
}
