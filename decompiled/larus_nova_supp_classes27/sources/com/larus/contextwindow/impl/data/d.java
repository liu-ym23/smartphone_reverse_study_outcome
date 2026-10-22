package com.larus.contextwindow.impl.data;

import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.s0;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.u0;
import com.larus.bmhome.actionbar.model.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(ReplyOption r6, List r7) {
        Intrinsics.checkNotNullParameter(r7, "actionBarItems");
        if (r6 == null) goto L50;
        ModelItemIdentity r1 = r6.getModel();
        if (r1 == null) goto L57;
        Iterator r8 = r7.iterator();
    L8:
        Object r3 = null;
        if (r8.hasNext() == false) goto L13;
        Object r2 = r8.next();
        if (Intrinsics.areEqual(((z0) r2).b, "coco_deep_thinking") == false) goto L8;
    L14:
        z0 r4 = (z0) r2;
        if (r4 == null) goto L17;
        p0 r9 = r4.o;
    L18:
        if (r9 == null) goto L20;
        boolean r5 = Intrinsics.areEqual(r9.k, Boolean.TRUE);
    L21:
        if (r5 == false) goto L43;
        s0 r10 = r9.j;
        if (r10 == null) goto L51;
        u0 r11 = r10.a;
        if (r11 == null) goto L52;
        ArrayList r12 = r11.a;
        if (r12 == null) goto L53;
        Iterator r13 = r12.iterator();
    L30:
        if (r13.hasNext() == false) goto L34;
        Object r14 = r13.next();
        if (Intrinsics.areEqual(((t0) r14).a, r6.getModeId()) == false) goto L30;
        r3 = r14;
    L34:
        t0 r15 = (t0) r3;
        if (r15 == null) goto L54;
        Integer r16 = r15.j;
        int r17 = AgentMode.MOA.getValue();
        if (r16 != null) goto L40;
        return false;
    L40:
        if (r16.intValue() != r17) goto L55;
        return true;
    L55:
        return false;
    L54:
        return false;
    L53:
        return false;
    L52:
        return false;
    L51:
        return false;
    L43:
        return Intrinsics.areEqual(r1, wa8.t0.e);
    L20:
        r5 = false;
        goto L21
    L17:
        r9 = null;
        goto L18
    L13:
        r2 = null;
        goto L14
    L57:
        return false;
    L50:
        return false;
    }
}
