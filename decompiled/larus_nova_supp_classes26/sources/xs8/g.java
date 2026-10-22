package xs8;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.DropdownSelectorWidget;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;
import wa8.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g extends up8.b {
    public com.larus.bmhome.actionbar.model.h l;
    public final Keva m;
    public int n;

    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.b
    public int getType() {
        return 2;
    }

    @Override // up8.b
    public final int i() {
        return 3;
    }

    @Override // up8.d
    public final String g() {
        com.larus.bmhome.actionbar.model.h r0 = this.l;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        List r2 = r0.e;
        if (r2 == null) goto L20;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L19;
        Object r5 = r4.next();
        Integer r6 = ((w) r5).s;
        if (r6 == null) goto L16;
        boolean r7 = true;
        if (r6.intValue() != 1) goto L16;
    L17:
        if (r7 == false) goto L9;
        r3.add(r5);
    L16:
        r7 = false;
        goto L17
    L19:
        ArrayList r10 = r3;
    L21:
        com.larus.bmhome.actionbar.model.h r8 = this.l;
        if (r8 == null) goto L24;
        com.larus.bmhome.actionbar.model.h r9 = com.larus.bmhome.actionbar.model.h.a(r8, null, null, null, r10, null, null, 4079);
    L35:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L27
        Object r12 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.h.Companion.serializer()), r9));     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r12) == true) goto L34;
        r1 = r12;
    L34:
        return (String) r1;
    L27:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L24:
        r9 = null;
        goto L35
    L20:
        r10 = null;
        goto L21
    }

    public final Long s() {
        com.larus.bmhome.actionbar.model.h r0 = this.l;
        if (r0 != null) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Integer r2 = r0.b;
        if (r2 != null) goto L9;
    L11:
        if (r2 != null) goto L14;
    L46:
        l r3 = null;
    L47:
        if (r3 != null) goto L49;
        return null;
    L49:
        long r5 = r3.b;
        if (r3.c == false) goto L54;
        com.larus.bmhome.view.actionbar.edit.c r1 = this.c;
        if (r1 == null) goto L54;
        r1.syncVideoModel(r5);
    L54:
        List r4 = r0.e;
        if (r4 == null) goto L68;
        Iterator r6 = r4.iterator();
    L58:
        if (r6.hasNext() == false) goto L68;
        w r7 = (w) r6.next();
        Long r8 = r7.a;
        if (r8 != null) goto L63;
    L65:
        int r9 = 0;
    L66:
        r7.s = r9;
        goto L58
    L63:
        if (r8.longValue() != r5) goto L65;
        r9 = 1;
    L68:
        if (Intrinsics.areEqual(r0.i, Boolean.TRUE) == false) goto L70;
        this.m.storeLong("dropbox_" + this.n + '_' + r0.b, r5);
    L70:
        Integer r10 = this.g;
        if (r10 == null) goto L75;
        int r11 = r10.intValue();
        com.larus.bmhome.view.actionbar.edit.c r12 = this.c;
        if (r12 == null) goto L75;
        r12.selectModel(r11, r5);
    L75:
        FLogger.a.i("DropdownSelectorController", "fallback expired subscribed model, dropdownId=" + r0.b + ", selectedId=" + r3.a + ", fallbackId=" + r5);
        return Long.valueOf(r5);
    L14:
        if (r2.intValue() != 6) goto L46;
        boolean r13 = true;
    L16:
        List r14 = r0.e;
        if (r14 == null) goto L46;
        Iterator r15 = r14.iterator();
    L20:
        if (r15.hasNext() == false) goto L30;
        Object r16 = r15.next();
        Integer r17 = ((w) r16).s;
        if (r17 != null) goto L25;
    L27:
        boolean r18 = false;
    L28:
        if (r18 == false) goto L20;
    L31:
        w r19 = (w) r16;
        if (r19 == null) goto L46;
        Long r20 = r19.a;
        if (r20 == null) goto L46;
        long r21 = r20.longValue();
        Long r22 = k0.b(r0, r21);
        if (r22 == null) goto L46;
        if (r22.longValue() == r21) goto L40;
        boolean r23 = true;
    L41:
        if (r23 == true) goto L44;
        r22 = null;
    L44:
        if (r22 == null) goto L46;
        r3 = new l(r21, r22.longValue(), r13);
        goto L47
    L40:
        r23 = false;
        goto L41
    L25:
        if (r17.intValue() != 1) goto L27;
        r18 = true;
        goto L28
    L30:
        r16 = null;
        goto L31
    L9:
        if (r2.intValue() != 30) goto L11;
        r13 = false;
        goto L16
    }

    public final boolean t() {
        com.larus.bmhome.view.actionbar.edit.c r0 = this.c;
        if (r0 == null) goto L5;
        Integer r1 = r0.getInstructionType();
    L7:
        if (r1 != null) goto L10;
    L36:
        if (r1 != null) goto L39;
    L40:
        if (r1 != null) goto L43;
    L45:
        if (r1 != null) goto L48;
    L49:
        if (r1 != null) goto L52;
    L69:
        return false;
    L52:
        if (r1.intValue() != 24) goto L69;
    L53:
        com.larus.bmhome.actionbar.model.h r2 = this.l;
        if (r2 == null) goto L69;
        Integer r3 = r2.b;
        if (r3 == null) goto L69;
        if (r3.intValue() != 1) goto L69;
        return true;
    L48:
        if (r1.intValue() == 18) goto L53;
    L43:
        if (r1.intValue() != 4) goto L45;
    L61:
        com.larus.bmhome.actionbar.model.h r4 = this.l;
        if (r4 == null) goto L69;
        Integer r5 = r4.b;
        if (r5 == null) goto L69;
        if (r5.intValue() != 2) goto L69;
        return true;
    L39:
        if (r1.intValue() == 16) goto L61;
    L10:
        if (r1.intValue() != 28) goto L36;
        Integer r6 = this.g;
        if (r6 != null) goto L15;
    L24:
        if (r6 == null) goto L69;
        if (r6.intValue() != 18) goto L69;
        com.larus.bmhome.actionbar.model.h r7 = this.l;
        if (r7 == null) goto L69;
        Integer r8 = r7.b;
        if (r8 == null) goto L69;
        if (r8.intValue() != 1) goto L69;
        return true;
    L15:
        if (r6.intValue() != 4) goto L24;
        com.larus.bmhome.actionbar.model.h r9 = this.l;
        if (r9 == null) goto L69;
        Integer r10 = r9.b;
        if (r10 == null) goto L69;
        if (r10.intValue() != 2) goto L69;
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public g() {
        this.m = Keva.getRepo("drop_save", 0);
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new DropdownSelectorWidget(r2);
    }

    @Override // up8.b
    public final void m(Map<String, ?> r8) {
        Intrinsics.checkNotNullParameter(r8, "instructionDefaultParams");
        com.larus.bmhome.actionbar.model.h r0 = this.l;
        if (r0 == null) goto L7;
        Integer r1 = r0.b;
        if (r1 == null) goto L7;
        String r2 = r1.toString();
    L8:
        Object r9 = r8.get(String.valueOf(getType()));
        if ((r9 instanceof Map) == false) goto L11;
        Map r10 = (Map) r9;
    L12:
        if (r10 == null) goto L15;
        Object r3 = r10.get(r2);
        if (r3 == null) goto L15;
    L19:
        if ((r3 instanceof Map) == false) goto L21;
        Map r4 = (Map) r3;
    L22:
        if (r4 == null) goto L73;
        Object r11 = r4.get("default_select_id");
        if (r11 == null) goto L74;
        FLogger.a.d("DropdownSelectorController", "onReStoreComponentStateByDefaultParams: select:" + r11);
        com.larus.bmhome.actionbar.model.h r5 = this.l;
        if (r5 == null) goto L41;
        List r6 = r5.e;
        if (r6 == null) goto L41;
        Iterator r7 = r6.iterator();
    L31:
        if (r7.hasNext() == false) goto L39;
        Object r12 = r7.next();
        Long r13 = ((w) r12).a;
        if (r13 == null) goto L35;
        String r14 = r13.toString();
    L37:
        if (Intrinsics.areEqual(r14, r11) == false) goto L31;
    L40:
        w r15 = (w) r12;
    L42:
        if (r15 == null) goto L64;
        FLogger.a.i("DropdownSelectorController", "has onRestoreComponentStateByDefaultParams " + r11);
        com.larus.bmhome.actionbar.model.h r16 = this.l;
        if (r16 == null) goto L64;
        List r17 = r16.e;
        if (r17 == null) goto L64;
        Iterator r18 = r17.iterator();
        int r19 = 0;
    L49:
        if (r18.hasNext() == false) goto L64;
        Object r20 = r18.next();
        int r21 = r19 + 1;
        if (r19 >= 0) goto L53;
        CollectionsKt.throwIndexOverflow();
    L53:
        w r22 = (w) r20;
        Long r23 = r22.a;
        if (r23 == null) goto L56;
        String r24 = r23.toString();
    L58:
        if (Intrinsics.areEqual(r24, r11) == false) goto L62;
        r22.s = 1;
        com.larus.bmhome.actionbar.model.h r25 = this.l;
        if (r25 == null) goto L63;
        r25.f = Integer.valueOf(r19);
    L63:
        r19 = r21;
        goto L49
    L62:
        r22.s = 0;
        goto L63
    L56:
        r24 = null;
    L64:
        s();
        return;
    L35:
        r14 = null;
        goto L37
    L39:
        r12 = null;
    L41:
        r15 = null;
        goto L42
    L74:
        return;
    L73:
        return;
    L21:
        r4 = null;
    L15:
        if (r10 == null) goto L17;
        r3 = r10.get("match_all_id");
        goto L19
    L17:
        r3 = null;
        goto L19
    L11:
        r10 = null;
    L7:
        r2 = null;
        goto L8
    }

    @Override // up8.b
    public final a0 n(String r15) {
        boolean r2 = false;
        if (r15 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        Object r16 = Result.constructor-impl((com.larus.bmhome.actionbar.model.h) xt7.d.b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r15));     // Catch: Throwable -> L14
    L16:
        Throwable r5 = Result.exceptionOrNull-impl(r16);
        if (r5 != null) goto L199;
        com.larus.bmhome.actionbar.model.h r17 = (com.larus.bmhome.actionbar.model.h) r16;
        List<w> r6 = null;
        if (r17 == null) goto L21;
        List r7 = r17.e;
    L22:
        List r8 = r7;
        if (r8 != null) goto L25;
    L28:
        boolean r9 = true;
    L29:
        if (r9 == true) goto L31;
        this.l = r17;
        if (r17 == null) goto L50;
        List r18 = r17.e;
        if (r18 == null) goto L50;
        Iterator r19 = r18.iterator();
    L38:
        if (r19.hasNext() == false) goto L48;
        Object r10 = r19.next();
        Integer r11 = ((w) r10).s;
        if (r11 != null) goto L43;
    L45:
        boolean r12 = false;
    L46:
        if (r12 == false) goto L38;
    L49:
        w r13 = (w) r10;
    L52:
        if (t() == false) goto L59;
        com.larus.bmhome.actionbar.model.h r110 = this.l;
        if (r110 == null) goto L56;
        boolean r111 = Intrinsics.areEqual(r110.h, Boolean.TRUE);
    L57:
        if (r111 == false) goto L59;
        boolean r112 = true;
    L61:
        if (r13 != null) goto L81;
        com.larus.bmhome.actionbar.model.h r14 = this.l;
        if (r14 == null) goto L66;
        boolean r20 = Intrinsics.areEqual(r14.i, Boolean.TRUE);
    L67:
        if (r20 == false) goto L81;
        if (r112 == true) goto L81;
        if (this.n != 4) goto L76;
        Keva r21 = this.m;
        StringBuilder r113 = new StringBuilder("dropbox_");
        com.larus.bmhome.actionbar.model.h r22 = this.l;
        if (r22 == null) goto L74;
        Integer r23 = r22.b;
    L75:
        r113.append(r23);
        long r24 = r21.getLong(r113.toString(), -1);
    L83:
        if (r24 == (-1)) goto L104;
        com.larus.bmhome.actionbar.model.h r25 = this.l;
        if (r25 == null) goto L104;
        List r26 = r25.e;
        if (r26 == null) goto L104;
        Iterator r27 = r26.iterator();
    L90:
        if (r27.hasNext() == false) goto L100;
        Object r28 = r27.next();
        Long r114 = ((w) r28).a;
        if (r114 != null) goto L95;
    L97:
        boolean r115 = false;
    L98:
        if (r115 == false) goto L90;
    L101:
        w r29 = (w) r28;
        if (r29 == null) goto L104;
        r29.s = 1;
    L106:
        if (r29 != null) goto L132;
        if (r13 != null) goto L132;
        com.larus.bmhome.actionbar.model.h r116 = this.l;
        if (r116 == null) goto L126;
        List r117 = r116.e;
        if (r117 == null) goto L126;
        Iterator r118 = r117.iterator();
    L114:
        if (r118.hasNext() == false) goto L122;
        Object r119 = r118.next();
        Long r120 = ((w) r119).a;
        com.larus.bmhome.actionbar.model.h r121 = this.l;
        if (r121 == null) goto L118;
        Long r122 = r121.g;
    L120:
        if (Intrinsics.areEqual(r120, r122) == false) goto L114;
    L123:
        w r123 = (w) r119;
        if (r123 == null) goto L126;
        r123.s = 1;
    L127:
        FLogger r124 = FLogger.a;
        StringBuilder r125 = new StringBuilder("selectedItemByDefaultId=");
        com.larus.bmhome.actionbar.model.h r126 = this.l;
        if (r126 == null) goto L130;
        Long r127 = r126.g;
    L131:
        r125.append(r127);
        r124.i("DropdownSelectorController", r125.toString());
    L133:
        if (r123 != null) goto L151;
        if (r29 != null) goto L151;
        if (r13 != null) goto L151;
        com.larus.bmhome.actionbar.model.h r30 = this.l;
        if (r30 == null) goto L141;
        Integer r31 = r30.f;
        if (r31 == null) goto L141;
        int r32 = r31.intValue();
    L142:
        if (r32 < 0) goto L151;
        com.larus.bmhome.actionbar.model.h r128 = this.l;
        if (r128 == null) goto L148;
        List r129 = r128.e;
        if (r129 == null) goto L148;
        w r33 = (w) CollectionsKt.getOrNull(r129, r32);
    L149:
        if (r33 == null) goto L151;
        r33.s = 1;
    L148:
        r33 = null;
    L141:
        r32 = -1;
    L151:
        if (r29 != null) goto L153;
    L157:
        FLogger r1 = FLogger.a;
        StringBuilder r34 = new StringBuilder("currentBindData is ");
        r34.append(this.l);
        r34.append(", isRatio=");
        r34.append(t());
        r34.append(", canBeEmpty=");
        com.larus.bmhome.actionbar.model.h r35 = this.l;
        if (r35 == null) goto L160;
        Boolean r36 = r35.h;
    L161:
        r34.append(r36);
        r34.append(", ignoreDraftSelection=");
        r34.append(r112);
        r34.append(", draftSelectedItemId=");
        r34.append(r24);
        r34.append(", selectedOption=");
        com.larus.bmhome.actionbar.model.h r130 = this.l;
        if (r130 == null) goto L179;
        List r131 = r130.e;
        if (r131 == null) goto L179;
        Iterator r132 = r131.iterator();
    L167:
        if (r132.hasNext() == false) goto L177;
        Object r37 = r132.next();
        Integer r38 = ((w) r37).s;
        if (r38 != null) goto L172;
    L174:
        boolean r39 = false;
    L175:
        if (r39 == false) goto L167;
    L178:
        w r40 = (w) r37;
    L180:
        r34.append(r40);
        r1.i("DropdownSelectorController", r34.toString());
        if (t() == false) goto L196;
        com.larus.bmhome.view.actionbar.edit.c r133 = this.c;
        if (r133 == null) goto L190;
        com.larus.bmhome.actionbar.model.h r0 = this.l;
        if (r0 == null) goto L187;
        r6 = r0.e;
    L187:
        if (r6 != null) goto L189;
        r6 = CollectionsKt.emptyList();
    L189:
        r133.setRatioOptionList(r6);
    L190:
        com.larus.bmhome.view.actionbar.edit.c r134 = this.c;
        if (r134 == null) goto L196;
        com.larus.bmhome.actionbar.model.h r41 = this.l;
        if (r41 == null) goto L195;
        r2 = Intrinsics.areEqual(r41.h, Boolean.TRUE);
    L195:
        r134.setRatioCanBeEmpty(r2);
    L196:
        s();
        return new a0(Boolean.TRUE, "");
    L172:
        if (r38.intValue() != 1) goto L174;
        r39 = true;
        goto L175
    L177:
        r37 = null;
    L179:
        r40 = null;
        goto L180
    L160:
        r36 = null;
        goto L161
    L153:
        if (this.n != 4) goto L157;
        com.larus.bmhome.view.actionbar.edit.c r42 = this.c;
        if (r42 == null) goto L157;
        r42.setImageStyleRadioSelected(false);
        goto L157
    L130:
        r127 = null;
        goto L131
    L118:
        r122 = null;
        goto L120
    L122:
        r119 = null;
    L126:
        r123 = null;
    L132:
        r123 = null;
        goto L133
    L95:
        if (r114.longValue() != r24) goto L97;
        r115 = true;
        goto L98
    L100:
        r28 = null;
    L104:
        r29 = null;
        goto L106
    L74:
        r23 = null;
        goto L75
    L76:
        Keva r43 = this.m;
        StringBuilder r135 = new StringBuilder("dropbox_");
        r135.append(this.n);
        r135.append('_');
        com.larus.bmhome.actionbar.model.h r44 = this.l;
        if (r44 == null) goto L79;
        Integer r45 = r44.b;
    L80:
        r135.append(r45);
        r24 = r43.getLong(r135.toString(), -1);
        goto L83
    L79:
        r45 = null;
        goto L80
    L66:
        r20 = false;
    L81:
        r24 = -1;
        goto L83
    L56:
        r111 = false;
    L59:
        r112 = false;
        goto L61
    L43:
        if (r11.intValue() != 1) goto L45;
        r12 = true;
        goto L46
    L48:
        r10 = null;
    L50:
        r13 = null;
        goto L52
    L31:
        return new a0(Boolean.FALSE, "drop down box parse empty");
    L25:
        if (r8.isEmpty() == true) goto L28;
        r9 = false;
        goto L29
    L21:
        r7 = null;
        goto L22
    L199:
        return new a0(Boolean.FALSE, r5.getMessage());
    L14:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "drop down box is empty template");
    L5:
        if (r15.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    @Override // up8.b
    public final void q(Integer r1) {
        if (r1 == null) goto L4;
        int r2 = r1.intValue();
    L5:
        this.n = r2;
        return;
    L4:
        r2 = 0;
        goto L5
    }

    @Override // up8.b
    public final void k(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "defaultStateTemplate");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl((com.larus.bmhome.actionbar.model.h) xt7.d.b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r4));     // Catch: Throwable -> L5
    L7:
        Object r0 = null;
        if (Result.isFailure-impl(r7) == false) goto L10;
        r7 = null;
    L10:
        com.larus.bmhome.actionbar.model.h r8 = (com.larus.bmhome.actionbar.model.h) r7;
        if (r8 != null) goto L13;
        return;
    L13:
        List r9 = r8.e;
        if (r9 == null) goto L18;
        w r10 = (w) CollectionsKt.firstOrNull(r9);
        if (r10 == null) goto L18;
        Long r11 = r10.a;
    L19:
        if (r11 == null) goto L43;
        com.larus.bmhome.actionbar.model.h r12 = this.l;
        if (r12 == null) goto L31;
        List r13 = r12.e;
        if (r13 == null) goto L31;
        Iterator r14 = r13.iterator();
    L26:
        if (r14.hasNext() == false) goto L30;
        Object r1 = r14.next();
        if (Intrinsics.areEqual(((w) r1).a, r11) == false) goto L26;
        r0 = r1;
    L30:
        r0 = (w) r0;
    L31:
        if (r0 == null) goto L43;
        com.larus.bmhome.actionbar.model.h r15 = this.l;
        if (r15 == null) goto L43;
        List r16 = r15.e;
        if (r16 == null) goto L43;
        Iterator r17 = r16.iterator();
    L38:
        if (r17.hasNext() == false) goto L43;
        w r2 = (w) r17.next();
        if (Intrinsics.areEqual(r2.a, r11) == true) goto L41;
        r2.s = 0;
        goto L38
    L41:
        r2.s = 1;
    L43:
        s();
        return;
    L18:
        r11 = null;
    L5:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
