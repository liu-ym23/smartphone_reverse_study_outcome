package com.larus.bmhome.view.actionbar.custom;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.obric.assistant.spi.account.ObricAccountSPIServiceDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(List r10) {
        gga.a r0 = ObricAccountSPIServiceDelegate.b.e();
        if (r0.a == true) goto L5;
        return;
    L5:
        if (r10 == null) goto L64;
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L86;
        com.larus.bmhome.actionbar.model.p0 r1 = ((com.larus.bmhome.actionbar.model.z0) r11.next()).o;
        if (r1 == null) goto L8;
        Integer r2 = r1.a;
        int r3 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r2 == null) goto L8;
        if (r2.intValue() != r3) goto L8;
        com.larus.bmhome.actionbar.model.a2 r4 = r1.d();
        Integer r5 = null;
        if (r4 == null) goto L21;
        List r6 = r4.a;
    L22:
        if (r6 != null) goto L24;
        r6 = CollectionsKt.emptyList();
    L24:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L26:
        if (r8.hasNext() == false) goto L34;
        Object r9 = r8.next();
        ModelItemIdentity r12 = ((com.larus.bmhome.actionbar.model.b2) r9).b();
        if (r12 == null) goto L30;
        Integer r13 = Integer.valueOf(r12.getDeprecatedItemId());
    L32:
        if (r0.a(r13) == false) goto L26;
        r7.add(r9);
        goto L26
    L30:
        r13 = null;
        goto L32
    L34:
        Integer r14 = r0.c;
        if (r14 == null) goto L55;
        int r15 = r14.intValue();
        boolean r16 = false;
        if (r7.isEmpty() == true) goto L51;
        Iterator r17 = r7.iterator();
    L41:
        if (r17.hasNext() == false) goto L51;
        ModelItemIdentity r18 = ((com.larus.bmhome.actionbar.model.b2) r17.next()).b();
        if (r18 != null) goto L45;
    L47:
        boolean r19 = false;
    L48:
        if (r19 == false) goto L41;
        r16 = true;
        goto L51
    L45:
        if (r18.getDeprecatedItemId() != r15) goto L47;
        r19 = true;
    L51:
        if (Boolean.valueOf(r16).booleanValue() == false) goto L53;
        r5 = r14;
    L53:
        if (r5 == null) goto L55;
    L61:
        r1.c = r5;
        com.larus.bmhome.actionbar.model.a2 r20 = r1.d();
        if (r20 == null) goto L8;
        r20.a = new ArrayList(r7);
    L55:
        com.larus.bmhome.actionbar.model.b2 r21 = (com.larus.bmhome.actionbar.model.b2) CollectionsKt.firstOrNull(r7);
        if (r21 == null) goto L60;
        ModelItemIdentity r22 = r21.b();
        if (r22 == null) goto L60;
        r5 = Integer.valueOf(r22.getDeprecatedItemId());
    L60:
        r5 = r1.c;
        goto L61
    L21:
        r6 = null;
        goto L22
    L86:
        return;
    }
}
