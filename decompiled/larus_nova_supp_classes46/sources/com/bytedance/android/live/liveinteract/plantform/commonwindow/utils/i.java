package com.bytedance.android.live.liveinteract.plantform.commonwindow.utils;

import android.graphics.Path;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.c1;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(m r8, List r9, com.bytedance.android.live.liveinteract.videotalk.utils.c r10, com.bytedance.android.live.ui.c r11, boolean r12, Function0 r13) {
        Intrinsics.checkNotNullParameter(r9, "windowList");
        Intrinsics.checkNotNullParameter(r13, "checkAudience");
        Path r0 = new Path();
        Iterator r14 = r9.iterator();
        int r2 = 0;
    L3:
        Integer r5 = null;
        tf0.e r6 = null;
        if (r14.hasNext() == false) goto L29;
        Object r3 = r14.next();
        int r7 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        tf0.e r4 = (tf0.e) r3;
        if (r12 == false) goto L15;
        if (r10 == null) goto L12;
        Path r15 = r10.a(r2, 0.0f, 0.0f);
    L13:
        r0.addPath(r15);
    L28:
        r2 = r7;
        goto L3
    L12:
        r15 = new Path();
        goto L13
    L15:
        if ((r4 instanceof MultiLinkGuestViewBinder.a) == false) goto L18;
        r6 = r4;
    L18:
        MultiLinkGuestViewBinder.a r16 = (MultiLinkGuestViewBinder.a) r6;
        if (r16 == null) goto L28;
        ILinkPlayerInfoBridge r17 = r16.k.a;
        if (r17.getUser() == null) goto L28;
        if (je0.d.x(Integer.valueOf(r17.getLinkType())) == false) goto L28;
        if (r10 == null) goto L26;
        Path r18 = r10.a(r2, 0.0f, 0.0f);
    L27:
        r0.addPath(r18);
        goto L28
    L26:
        r18 = new Path();
        goto L27
    L29:
        if (r8 != null) goto L31;
    L39:
        int r19 = c1.a;
        if (r8 == null) goto L42;
        Integer r20 = Integer.valueOf(r8.m());
    L43:
        if (r8 == null) goto L46;
        r5 = Integer.valueOf(r8.getUiLayout());
    L46:
        if (c1.a(r20, r5) == true) goto L48;
    L53:
        if (r11 == null) goto L55;
        r11.o(r0);
    L55:
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r21 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
        if (r21 == null) goto L65;
        r21.Jl(r0);
        return;
    L65:
        return;
    L48:
        if (((Boolean) r13.invoke()).booleanValue() == false) goto L53;
        if (r10 == null) goto L51;
        Path r22 = r10.a(0, 0.0f, 0.0f);
    L52:
        r0.addPath(r22);
        goto L53
    L51:
        r22 = new Path();
        goto L52
    L42:
        r20 = null;
        goto L43
    L31:
        if (r8.getUiLayout() != 16) goto L39;
        if (((Boolean) r13.invoke()).booleanValue() == false) goto L39;
        int r23 = qi0.e.a;
        int r24 = qi0.e.a(r8.getUiLayout());
        if (r10 == null) goto L37;
        Path r25 = r10.a(r24, 0.0f, 0.0f);
    L38:
        r0.addPath(r25);
        goto L39
    L37:
        r25 = new Path();
        goto L38
    }
}
