package xs8;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.DropdownListSelectorWidgetV2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f extends up8.b {
    public com.larus.bmhome.actionbar.model.i l;
    public final Keva m;
    public List<com.larus.bmhome.actionbar.model.h> n;
    public boolean o;

    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.b
    public int getType() {
        return 2;
    }

    @Override // up8.d
    public final String g() {
        Object r1 = null;
        if (this.l != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        com.larus.bmhome.actionbar.model.i r2 = this.l;
        if (r2 == null) goto L35;
        List r3 = r2.a;
        if (r3 == null) goto L35;
        Iterator r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L35;
        com.larus.bmhome.actionbar.model.h r5 = (com.larus.bmhome.actionbar.model.h) r4.next();
        List r6 = r5.e;
        boolean r7 = false;
        if (r6 == null) goto L27;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r6.iterator();
    L16:
        if (r9.hasNext() == false) goto L26;
        Object r10 = r9.next();
        Integer r11 = ((w) r10).s;
        if (r11 != null) goto L21;
    L23:
        boolean r12 = false;
    L24:
        if (r12 == false) goto L16;
        r8.add(r10);
        goto L16
    L21:
        if (r11.intValue() != 1) goto L23;
        r12 = true;
        goto L24
    L26:
        ArrayList r13 = r8;
    L28:
        if (r13 != null) goto L30;
    L32:
        if (r7 == false) goto L11;
        r0.add(com.larus.bmhome.actionbar.model.h.a(r5, null, null, null, r13, null, null, 4079));
        goto L11
    L30:
        if ((!r13.isEmpty()) != true) goto L32;
        r7 = true;
        goto L32
    L27:
        r13 = null;
    L35:
        if (r0.isEmpty() == false) goto L38;
        return null;
    L38:
        if (this.l == null) goto L40;
        com.larus.bmhome.actionbar.model.i r14 = new com.larus.bmhome.actionbar.model.i(r0);
    L51:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L43
        Object r16 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.i.Companion.serializer()), r14));     // Catch: Throwable -> L43
    L46:
        if (Result.isFailure-impl(r16) == true) goto L50;
        r1 = r16;
    L50:
        return (String) r1;
    L43:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    L40:
        r14 = null;
        goto L51
    }

    public f() {
        this.m = Keva.getRepo("default", 0);
        this.n = new ArrayList();
    }

    @Override // up8.b
    public final boolean j() {
        return this.o;
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new DropdownListSelectorWidgetV2(r2);
    }

    @Override // up8.b
    public final void m(Map<String, ?> r8) {
        Intrinsics.checkNotNullParameter(r8, "instructionDefaultParams");
        Object r9 = r8.get(String.valueOf(getType()));
        if ((r9 instanceof Map) == false) goto L5;
        Map r10 = (Map) r9;
    L6:
        com.larus.bmhome.actionbar.model.i r0 = this.l;
        if (r0 == null) goto L40;
        List r1 = r0.a;
        if (r1 == null) goto L53;
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L54;
        com.larus.bmhome.actionbar.model.h r3 = (com.larus.bmhome.actionbar.model.h) r2.next();
        if (r10 == null) goto L17;
        Object r4 = r10.get(String.valueOf(r3.b));
        if (r4 == null) goto L17;
    L21:
        if ((r4 instanceof Map) == false) goto L23;
        Map r5 = (Map) r4;
    L24:
        if (r5 == null) goto L28;
        Object r6 = r5.get("default_select_id");
        if (r6 == null) goto L28;
        String r7 = r6.toString();
    L30:
        if (o0.d(r7) == false) goto L12;
        FLogger.a.d("DropdownListSelectorController", "onReStoreComponentStateByDefaultParams: select:" + r7);
        List r11 = r3.e;
        if (r11 == null) goto L12;
        Iterator r12 = r11.iterator();
    L35:
        if (r12.hasNext() == false) goto L12;
        w r13 = (w) r12.next();
        if (Intrinsics.areEqual(String.valueOf(r13.a), r7) == true) goto L38;
        r13.s = 0;
        goto L35
    L38:
        r13.s = 1;
    L28:
        r7 = null;
        goto L30
    L23:
        r5 = null;
    L17:
        if (r10 == null) goto L19;
        r4 = r10.get("match_all_id");
        goto L21
    L19:
        r4 = null;
        goto L21
    L54:
        return;
    L53:
        return;
    L40:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // up8.b
    public final a0 n(String r14) {
        if (r14 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        Object r15 = Result.constructor-impl((com.larus.bmhome.actionbar.model.i) xt7.d.b.c(com.larus.bmhome.actionbar.model.i.Companion.serializer(), r14));     // Catch: Throwable -> L14
    L16:
        Throwable r5 = Result.exceptionOrNull-impl(r15);
        if (r5 != null) goto L113;
        com.larus.bmhome.actionbar.model.i r16 = (com.larus.bmhome.actionbar.model.i) r15;
        List<com.larus.bmhome.actionbar.model.h> r6 = null;
        if (r16 == null) goto L21;
        List r7 = r16.a;
    L22:
        List r8 = r7;
        if (r8 != null) goto L25;
    L28:
        boolean r9 = true;
    L29:
        if (r9 == true) goto L31;
        this.l = r16;
        if (r16 == null) goto L107;
        List r17 = r16.a;
        if (r17 == null) goto L107;
        Iterator r18 = r17.iterator();
    L38:
        if (r18.hasNext() == false) goto L107;
        com.larus.bmhome.actionbar.model.h r10 = (com.larus.bmhome.actionbar.model.h) r18.next();
        if (Intrinsics.areEqual(r10.i, Boolean.TRUE) == false) goto L50;
        Keva r11 = this.m;
        StringBuilder r12 = new StringBuilder("dropbox_");
        com.larus.bmhome.view.actionbar.edit.c r13 = this.c;
        if (r13 == null) goto L44;
        String r19 = r13.getActionBarType();
    L45:
        r12.append(r19);
        r12.append('_');
        u r110 = this.b;
        if (r110 == null) goto L48;
        Integer r111 = r110.a;
    L49:
        r12.append(r111);
        r12.append('_');
        r12.append(r10.b);
        long r20 = r11.getLong(r12.toString(), -1);
    L52:
        if (r20 == (-1)) goto L71;
        List r21 = r10.e;
        if (r21 == null) goto L71;
        Iterator r22 = r21.iterator();
    L57:
        if (r22.hasNext() == false) goto L67;
        Object r23 = r22.next();
        Long r24 = ((w) r23).a;
        if (r24 != null) goto L62;
    L64:
        boolean r25 = false;
    L65:
        if (r25 == false) goto L57;
    L68:
        w r26 = (w) r23;
        if (r26 == null) goto L71;
        r26.s = 1;
    L73:
        if (r26 == null) goto L75;
    L90:
        w r112 = null;
    L91:
        if (r112 != null) goto L106;
        if (r26 != null) goto L106;
        if (Intrinsics.areEqual(r10.h, Boolean.TRUE) == true) goto L98;
        Integer r27 = r10.f;
        if (r27 == null) goto L98;
        int r28 = r27.intValue();
    L99:
        if (r28 < 0) goto L106;
        List r113 = r10.e;
        if (r113 == null) goto L103;
        w r29 = (w) CollectionsKt.getOrNull(r113, r28);
    L104:
        if (r29 == null) goto L106;
        r29.s = 1;
        goto L106
    L103:
        r29 = null;
    L98:
        r28 = -1;
    L106:
        FLogger.a.i("DropdownListSelectorController", "draftSelectedItemId=" + r20 + ", draftSelectedItem=" + r26 + ", defaultSelectionIndex=" + r10.f + ",selectedItemByDefaultId=" + r10.g);
        goto L38
    L75:
        if (Intrinsics.areEqual(r10.h, Boolean.TRUE) == true) goto L90;
        List r30 = r10.e;
        if (r30 == null) goto L88;
        Iterator r31 = r30.iterator();
    L80:
        if (r31.hasNext() == false) goto L84;
        Object r114 = r31.next();
        if (Intrinsics.areEqual(((w) r114).a, r10.g) == false) goto L80;
    L85:
        r112 = (w) r114;
        if (r112 == null) goto L88;
        r112.s = 1;
    L89:
        FLogger.a.i("DropdownListSelectorController", "selectedItemByDefaultId=" + r10.g);
        goto L91
    L84:
        r114 = null;
    L88:
        r112 = null;
        goto L89
    L62:
        if (r24.longValue() != r20) goto L64;
        r25 = true;
        goto L65
    L67:
        r23 = null;
    L71:
        r26 = null;
        goto L73
    L48:
        r111 = null;
        goto L49
    L44:
        r19 = null;
        goto L45
    L50:
        r20 = -1;
    L107:
        com.larus.bmhome.actionbar.model.i r115 = this.l;
        if (r115 == null) goto L110;
        r6 = new com.larus.bmhome.actionbar.model.i(r115.a).a;
    L110:
        this.n = r6;
        return new a0(Boolean.TRUE, "");
    L31:
        return new a0(Boolean.FALSE, "drop down box parse empty");
    L25:
        if (r8.isEmpty() == true) goto L28;
        r9 = false;
        goto L29
    L21:
        r7 = null;
        goto L22
    L113:
        return new a0(Boolean.FALSE, r5.getMessage());
    L14:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "drop down box is empty template");
    L5:
        if (r14.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    @Override // up8.b
    public final void k(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "defaultStateTemplate");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl((com.larus.bmhome.actionbar.model.i) xt7.d.b.c(com.larus.bmhome.actionbar.model.i.Companion.serializer(), r8));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r10) == false) goto L10;
        r10 = null;
    L10:
        com.larus.bmhome.actionbar.model.i r11 = (com.larus.bmhome.actionbar.model.i) r10;
        if (r11 != null) goto L14;
        return;
    L14:
        if (r9 == false) goto L16;
        this.o = true;
    L16:
        List r12 = r11.a;
        if (r12 == null) goto L81;
        Iterator r13 = r12.iterator();
    L20:
        if (r13.hasNext() == false) goto L126;
        com.larus.bmhome.actionbar.model.h r14 = (com.larus.bmhome.actionbar.model.h) r13.next();
        if (o0.d(r14.a) == true) goto L23;
        com.larus.bmhome.actionbar.model.i r2 = this.l;
        if (r2 == null) goto L20;
        List r3 = r2.a;
        if (r3 == null) goto L20;
        Iterator r4 = r3.iterator();
    L58:
        if (r4.hasNext() == false) goto L62;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.h) r5).b, r14.b) == false) goto L58;
    L63:
        com.larus.bmhome.actionbar.model.h r6 = (com.larus.bmhome.actionbar.model.h) r5;
        if (r6 == null) goto L20;
        List r15 = r14.e;
        if (r15 == null) goto L70;
        w r16 = (w) CollectionsKt.firstOrNull(r15);
        if (r16 == null) goto L70;
        Long r17 = r16.a;
    L71:
        if (r17 == null) goto L20;
        List r7 = r6.e;
        if (r7 == null) goto L20;
        Iterator r18 = r7.iterator();
    L76:
        if (r18.hasNext() == false) goto L20;
        w r19 = (w) r18.next();
        if (Intrinsics.areEqual(r19.a, r17) == true) goto L79;
        r19.s = 0;
        goto L76
    L79:
        r19.s = 1;
    L70:
        r17 = null;
        goto L71
    L62:
        r5 = null;
        goto L63
    L23:
        com.larus.bmhome.actionbar.model.i r20 = this.l;
        if (r20 == null) goto L20;
        List r21 = r20.a;
        if (r21 == null) goto L20;
        Iterator r22 = r21.iterator();
    L29:
        if (r22.hasNext() == false) goto L33;
        Object r23 = r22.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.h) r23).a, r14.a) == false) goto L29;
    L34:
        com.larus.bmhome.actionbar.model.h r24 = (com.larus.bmhome.actionbar.model.h) r23;
        if (r24 == null) goto L20;
        List r25 = r14.e;
        if (r25 == null) goto L41;
        w r26 = (w) CollectionsKt.firstOrNull(r25);
        if (r26 == null) goto L41;
        Long r27 = r26.a;
    L42:
        if (r27 == null) goto L20;
        List r28 = r24.e;
        if (r28 == null) goto L20;
        Iterator r29 = r28.iterator();
    L47:
        if (r29.hasNext() == false) goto L20;
        w r30 = (w) r29.next();
        if (Intrinsics.areEqual(r30.a, r27) == true) goto L50;
        r30.s = 0;
        goto L47
    L50:
        r30.s = 1;
    L41:
        r27 = null;
        goto L42
    L33:
        r23 = null;
        goto L34
    L126:
        return;
    L81:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
