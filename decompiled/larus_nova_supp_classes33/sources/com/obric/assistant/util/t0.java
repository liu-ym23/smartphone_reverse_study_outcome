package com.obric.assistant.util;

import android.app.Activity;
import android.content.Context;
import com.larus.bmhome.chat.h4;
import com.larus.home.api.main.HomeService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activity_stack.IObricActivityStackService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class t0 {
    public static final boolean a(ComponentFeature r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Context r0 = r8.getContext();
        int r1 = com.obric.assistant.chat.p.a;
        t1a.b r9 = s1a.d.a(r8);
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r9, "pageContext");
        IObricActivityStackService r2 = (IObricActivityStackService) ServiceManager.get().getService(IObricActivityStackService.class);
        Object r3 = null;
        if (r2 == null) goto L5;
        List r4 = r2.b();
    L7:
        if (HomeService.a.o() == true) goto L18;
        if (r4 == null) goto L16;
        ListIterator r10 = r4.listIterator(r4.size());
    L11:
        if (r10.hasPrevious() == false) goto L15;
        Object r5 = r10.previous();
        if ((((Activity) r5) instanceof h4) == false) goto L11;
        r3 = r5;
    L15:
        r3 = (Activity) r3;
    L16:
        boolean r11 = Intrinsics.areEqual(r3, r0);
    L48:
        if (r11 == true) goto L50;
        FLogger.a.d("ComponentEx", r0 + " is not top chat page");
    L50:
        return r11;
    L18:
        if (r4 == null) goto L47;
        ListIterator r6 = r4.listIterator(r4.size());
    L21:
        if (r6.hasPrevious() == false) goto L31;
        Object r7 = r6.previous();
        Activity r12 = (Activity) r7;
        if ((r12 instanceof h4) == false) goto L25;
    L28:
        boolean r13 = true;
    L29:
        if (r13 == false) goto L21;
    L32:
        Activity r14 = (Activity) r7;
        if (r14 == null) goto L47;
        if ((r14 instanceof h4) == false) goto L38;
        r11 = Intrinsics.areEqual(r14, r0);
        goto L48
    L38:
        xe8.a r15 = HomeService.a.v(r14);
        if (r15 == null) goto L43;
        t1a.b r16 = r15.WF();
        if (r16 == null) goto L43;
        r3 = (laa.d) r16.getAbility(laa.d.class);
    L43:
        if (r3 == null) goto L47;
        if (r3 != r9.getAbility(laa.d.class)) goto L47;
        r11 = true;
        goto L48
    L25:
        if (HomeService.a.v(r12) != null) goto L28;
        r13 = false;
        goto L29
    L31:
        r7 = null;
    L47:
        r11 = false;
        goto L48
    L5:
        r4 = null;
        goto L7
    }
}
