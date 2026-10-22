package wz9;

import android.content.Context;
import com.larus.bmhome.actionbar.model.d0;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.uaigc.music.template.MusicTemplateListSelectorWidgetV2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import up8.b;
import wa8.a0;
import xt7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a extends b {
    public d0 l;
    public bq8.a m;
    public boolean n;

    public int getType() {
        return 10;
    }

    public final boolean a() {
        d0 r0 = this.l;
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.c, Boolean.TRUE);
    L6:
        if (r1 == true) goto L8;
    L9:
        return true;
    L8:
        if (g() != null) goto L9;
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public final Long c() {
        bq8.a r0 = this.m;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r0.a);
    }

    public final String g() {
        d0 r0 = this.l;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        List r2 = r0.a;
        boolean r3 = false;
        if (r2 == null) goto L19;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L9:
        if (r5.hasNext() == false) goto L20;
        Object r6 = r5.next();
        Integer r7 = ((w) r6).s;
        if (r7 != null) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == false) goto L9;
        r4.add(r6);
        goto L9
    L14:
        if (r7.intValue() != 1) goto L16;
        r8 = true;
    L20:
        if (r4 != null) goto L22;
    L23:
        r3 = true;
    L24:
        if (r3 == false) goto L26;
        return null;
    L26:
        d0 r9 = this.l;
        if (r9 == null) goto L29;
        d0 r10 = d0.d(r9, r4, this.m, 14);
    L40:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L32
        Object r12 = Result.constructor-impl(d.b.a(kuc.a.d(d0.Companion.serializer()), r10));     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r12) == true) goto L39;
        r1 = r12;
    L39:
        return (String) r1;
    L32:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L29:
        r10 = null;
        goto L40
    L22:
        if (r4.isEmpty() == false) goto L24;
    L19:
        r4 = null;
        goto L20
    }

    public a() {
    }

    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new MusicTemplateListSelectorWidgetV2(r2);
    }

    public final void m(Map<String, ?> r9) {
        Intrinsics.checkNotNullParameter(r9, "instructionDefaultParams");
        Object r10 = r9.get(String.valueOf(getType()));
        ArrayList r1 = null;
        if ((r10 instanceof Map) == false) goto L5;
        Map r11 = (Map) r10;
    L6:
        if (r11 == null) goto L9;
        Object r0 = r11.get(null);
        if (r0 == null) goto L9;
    L13:
        if ((r0 instanceof Map) == false) goto L15;
        Map r2 = (Map) r0;
    L16:
        if (r2 == null) goto L87;
        Object r12 = r2.get("default_select_id");
        if (r12 == null) goto L88;
        String r13 = r12.toString();
        if (r13 == null) goto L89;
        FLogger.a.d("MusicTemplateListSelectorController", "onReStoreComponentStateByDefaultParams: select:".concat(r13));
        d0 r3 = this.l;
        boolean r4 = false;
        if (r3 == null) goto L38;
        List r5 = r3.a;
        if (r5 == null) goto L38;
        Iterator r6 = r5.iterator();
        int r7 = 0;
    L27:
        if (r6.hasNext() == false) goto L38;
        Object r8 = r6.next();
        int r14 = r7 + 1;
        if (r7 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        w r15 = (w) r8;
        if (Intrinsics.areEqual(String.valueOf(r15.a), r13) == false) goto L36;
        r15.s = 1;
        d0 r16 = this.l;
        if (r16 == null) goto L37;
        r16.b = Integer.valueOf(r7);
    L37:
        r7 = r14;
        goto L27
    L36:
        r15.s = 0;
    L38:
        d0 r17 = this.l;
        if (r17 == null) goto L41;
        bq8.a r18 = r17.e;
    L42:
        this.m = r18;
        if (r17 == null) goto L58;
        List r19 = r17.a;
        if (r19 == null) goto L58;
        r1 = new ArrayList();
        Iterator r20 = r19.iterator();
    L48:
        if (r20.hasNext() == false) goto L58;
        Object r21 = r20.next();
        Integer r22 = ((w) r21).s;
        if (r22 != null) goto L53;
    L55:
        boolean r23 = false;
    L56:
        if (r23 == false) goto L48;
        r1.add(r21);
        goto L48
    L53:
        if (r22.intValue() != 1) goto L55;
        r23 = true;
    L58:
        if (r1 != null) goto L60;
    L63:
        boolean r24 = true;
    L64:
        if (r24 == true) goto L90;
        u r25 = ((b) this).b;
        if (r25 == null) goto L73;
        Integer r26 = r25.a;
        if (r26 == null) goto L73;
        if (r26.intValue() != 1) goto L73;
        r4 = true;
    L73:
        if (r4 == false) goto L91;
        c r27 = ((b) this).c;
        if (r27 == null) goto L92;
        r27.setImageStyleRadioSelected(true);
        return;
    L92:
        return;
    L91:
        return;
    L90:
        return;
    L60:
        if (r1.isEmpty() == true) goto L63;
        r24 = false;
        goto L64
    L41:
        r18 = null;
        goto L42
    L89:
        return;
    L88:
        return;
    L87:
        return;
    L15:
        r2 = null;
    L9:
        if (r11 == null) goto L11;
        r0 = r11.get("match_all_id");
        goto L13
    L11:
        r0 = null;
        goto L13
    L5:
        r11 = null;
        goto L6
    }

    public final a0 n(String r5) {
        boolean r0 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r6 = Result.constructor-impl((d0) d.b.c(d0.Companion.serializer(), r5));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r6);
        if (r4 != null) goto L28;
        d0 r7 = (d0) r6;
        List r8 = r7.d;
        if (r8 == null) goto L25;
        w r9 = (w) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L25;
        if (r9.j != true) goto L25;
        r0 = true;
    L25:
        this.n = r0;
        this.l = r7;
        this.m = r7.e;
        return new a0(Boolean.TRUE, "");
    L28:
        return new a0(Boolean.FALSE, r4.getMessage());
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "image list selector is empty template");
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void k(String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "defaultStateTemplate");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L5
        Object r14 = Result.constructor-impl((d0) d.b.c(d0.Companion.serializer(), r11));     // Catch: Throwable -> L5
    L7:
        ArrayList r0 = null;
        if (Result.isFailure-impl(r14) == false) goto L10;
        r14 = null;
    L10:
        d0 r15 = (d0) r14;
        if (r15 != null) goto L13;
        return;
    L13:
        List r16 = r15.a;
        boolean r1 = false;
        if (r16 == null) goto L35;
        Iterator r17 = r16.iterator();
    L17:
        if (r17.hasNext() == false) goto L35;
        w r3 = (w) r17.next();
        d0 r4 = this.l;
        if (r4 == null) goto L17;
        List r5 = r4.a;
        if (r5 == null) goto L17;
        Iterator r6 = r5.iterator();
        int r7 = 0;
    L24:
        if (r6.hasNext() == false) goto L17;
        Object r8 = r6.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        w r10 = (w) r8;
        if (Intrinsics.areEqual(r10.a, r3.a) == false) goto L33;
        r10.s = 1;
        d0 r18 = this.l;
        if (r18 == null) goto L34;
        r18.b = Integer.valueOf(r7);
    L34:
        r7 = r9;
        goto L24
    L33:
        r10.s = 0;
    L35:
        bq8.a r19 = r15.e;
        if (r19 == null) goto L38;
        this.m = r19;
    L38:
        d0 r110 = this.l;
        if (r110 == null) goto L54;
        List r111 = r110.a;
        if (r111 == null) goto L54;
        r0 = new ArrayList();
        Iterator r112 = r111.iterator();
    L44:
        if (r112.hasNext() == false) goto L54;
        Object r113 = r112.next();
        Integer r20 = ((w) r113).s;
        if (r20 != null) goto L49;
    L51:
        boolean r21 = false;
    L52:
        if (r21 == false) goto L44;
        r0.add(r113);
        goto L44
    L49:
        if (r20.intValue() != 1) goto L51;
        r21 = true;
    L54:
        if (r0 != null) goto L56;
    L59:
        boolean r114 = true;
    L60:
        if (r114 == true) goto L91;
        u r115 = ((b) this).b;
        if (r115 == null) goto L69;
        Integer r116 = r115.a;
        if (r116 == null) goto L69;
        if (r116.intValue() != 1) goto L69;
        r1 = true;
    L69:
        if (r1 == false) goto L92;
        c r117 = ((b) this).c;
        if (r117 == null) goto L93;
        r117.setImageStyleRadioSelected(true);
        return;
    L93:
        return;
    L92:
        return;
    L91:
        return;
    L56:
        if (r0.isEmpty() == true) goto L59;
        r114 = false;
    L5:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
