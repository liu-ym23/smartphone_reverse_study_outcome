package com.larus.uaigc.image.instruction;

import android.content.Context;
import com.larus.bmhome.actionbar.model.n;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateImage;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c extends up8.b {
    public n l;
    public TemplateInfo$TemplateInfo m;

    public int getType() {
        return 11;
    }

    public final boolean a() {
        n r0 = this.l;
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
        TemplateInfo$TemplateInfo r0 = this.m;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r0.a);
    }

    public final String g() {
        n r0 = this.l;
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
        n r9 = this.l;
        if (r9 == null) goto L29;
        n r10 = n.d(r9, r4, this.m);
    L40:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L32
        Object r12 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(n.Companion.serializer()), r10));     // Catch: Throwable -> L32
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

    public c() {
    }

    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new ImageListSelectorWithMoreTemplateWidget(r2);
    }

    public final void m(Map<String, ?> r8) {
        Intrinsics.checkNotNullParameter(r8, "instructionDefaultParams");
        Object r9 = r8.get(String.valueOf(getType()));
        if ((r9 instanceof Map) == false) goto L5;
        Map r10 = (Map) r9;
    L6:
        if (r10 == null) goto L9;
        Object r0 = r10.get(null);
        if (r0 == null) goto L9;
    L13:
        if ((r0 instanceof Map) == false) goto L15;
        Map r1 = (Map) r0;
    L16:
        if (r1 == null) goto L37;
        Object r11 = r1.get("default_select_id");
        if (r11 == null) goto L44;
        FLogger.a.d("ImageListSelectorWithMoreTemplateController", "onReStoreComponentStateByDefaultParams: select:" + r11);
        n r2 = this.l;
        if (r2 == null) goto L45;
        List r3 = r2.a;
        if (r3 == null) goto L46;
        Iterator r4 = r3.iterator();
    L25:
        if (r4.hasNext() == false) goto L47;
        w r5 = (w) r4.next();
        Long r6 = r5.a;
        if (r6 == null) goto L29;
        String r7 = r6.toString();
    L31:
        if (Intrinsics.areEqual(r7, r11) == true) goto L32;
        r5.s = 0;
        goto L25
    L32:
        r5.s = 1;
        com.larus.bmhome.view.actionbar.edit.c r12 = ((up8.b) this).c;
        if (r12 == null) goto L35;
        r12.setImageStyleRadioSelected(true);
    L35:
        FLogger.a.d("ImageListSelectorWithMoreTemplateController", "hit restore by default params option  id:" + ((String) r11) + ", option name:" + r5.b);
        goto L25
    L29:
        r7 = null;
        goto L31
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L37:
        return;
    L15:
        r1 = null;
    L9:
        if (r10 == null) goto L11;
        r0 = r10.get("match_all_id");
        goto L13
    L11:
        r0 = null;
        goto L13
    L5:
        r10 = null;
        goto L6
    }

    public final a0 n(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Object r4 = Result.constructor-impl((n) xt7.d.b.c(n.Companion.serializer(), r3));     // Catch: Throwable -> L13
    L15:
        Throwable r2 = Result.exceptionOrNull-impl(r4);
        if (r2 != null) goto L24;
        n r5 = (n) r4;
        this.l = r5;
        if (r5 == null) goto L20;
        TemplateInfo$TemplateInfo r6 = r5.e;
    L21:
        this.m = r6;
        return new a0(Boolean.TRUE, "");
    L20:
        r6 = null;
        goto L21
    L24:
        return new a0(Boolean.FALSE, r2.getMessage());
    L13:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new a0(Boolean.FALSE, "image list selector is empty template");
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void k(String r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r22, "defaultStateTemplate");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r0 = Result.constructor-impl((n) xt7.d.b.c(n.Companion.serializer(), r22));     // Catch: Throwable -> L5
    L7:
        String r3 = null;
        if (Result.isFailure-impl(r0) == false) goto L10;
        r0 = null;
    L10:
        n r1 = (n) r0;
        if (r1 != null) goto L13;
        return;
    L13:
        com.larus.bmhome.view.actionbar.edit.c r4 = ((up8.b) this).c;
        if (r4 == null) goto L22;
        List r5 = r1.a;
        if (r5 == null) goto L20;
        w r6 = (w) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L20;
        Long r7 = r6.a;
    L21:
        r4.setDefaultSelectedImageStyleId(r7);
    L20:
        r7 = null;
    L22:
        List r8 = r1.a;
        if (r8 == null) goto L41;
        Iterator r9 = r8.iterator();
    L26:
        if (r9.hasNext() == false) goto L41;
        w r10 = (w) r9.next();
        n r11 = this.l;
        if (r11 == null) goto L26;
        List r12 = r11.a;
        if (r12 == null) goto L26;
        Iterator r13 = r12.iterator();
    L33:
        if (r13.hasNext() == false) goto L26;
        w r14 = (w) r13.next();
        if (Intrinsics.areEqual(r14.a, r10.a) == true) goto L36;
        r14.s = 0;
        goto L33
    L36:
        r14.s = 1;
        com.larus.bmhome.view.actionbar.edit.c r15 = ((up8.b) this).c;
        if (r15 == null) goto L39;
        r15.setImageStyleRadioSelected(true);
    L39:
        FLogger.a.d("ImageListSelectorWithMoreTemplateController", "hit restore option id:" + r10.a + ", option name:" + r14.b);
    L41:
        TemplateInfo$TemplateInfo r16 = r1.e;
        if (r16 == null) goto L79;
        long r17 = r16.a;
        TemplateInfo$TemplateImage r18 = r16.e;
        if (r18 == null) goto L46;
        String r19 = r18.a;
    L47:
        long r110 = 0;
        if (r18 == null) goto L50;
        long r20 = r18.b;
    L51:
        if (r18 == null) goto L53;
        long r111 = r18.c;
    L54:
        TemplateInfo$TemplateImage r21 = new TemplateInfo$TemplateImage(r19, r20, r111);
        TemplateInfo$TemplateImage r24 = r16.d;
        if (r24 == null) goto L57;
        r3 = r24.a;
    L57:
        String r112 = r3;
        if (r24 == null) goto L60;
        long r113 = r24.b;
    L61:
        if (r24 == null) goto L63;
        r110 = r24.c;
    L63:
        this.m = new TemplateInfo$TemplateInfo(r17, null, new TemplateInfo$TemplateImage(r112, r113, r110), r21, null, 0, 0, 0, null, 998);
        return;
    L60:
        r113 = 0;
        goto L61
    L53:
        r111 = 0;
        goto L54
    L50:
        r20 = 0;
        goto L51
    L46:
        r19 = null;
        goto L47
    L79:
        return;
    L5:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
