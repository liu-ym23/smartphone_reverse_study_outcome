package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r8, List r9, String r10, String r11) {
        com.bytedance.android.livesdk.chatroom.o r0 = IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), null, 0, 3);
        boolean r1 = false;
        if (r0 == null) goto L7;
        Boolean r2 = r0.isAnchor();
        if (r2 == null) goto L7;
        boolean r3 = r2.booleanValue();
    L8:
        if (r0 == null) goto L12;
        User r4 = r0.getUser();
        if (r4 == null) goto L12;
        String r5 = r4.getIdString();
    L13:
        IMiddlewareUserService r6 = jc1.k.f(IMiddlewareUserService.class);
        if (r6 == null) goto L18;
        com.bytedance.android.livesdk.user.e r7 = r6.user();
        if (r7 == null) goto L18;
        boolean r12 = r7.isAdmin();
    L20:
        if (r5 != null) goto L22;
    L23:
        r5 = jc1.k.n(IMiddlewareUserService.class).user().n();
    L25:
        if (r3 == true) goto L45;
        if (r12 == false) goto L31;
        if (((Boolean) vm2.e.f0.getValue(null, vm2.e.a[56])).booleanValue() == true) goto L45;
    L31:
        if (Intrinsics.areEqual(r8, r5) == true) goto L39;
        if (r9 != null) goto L34;
    L36:
        if (r11 == null) goto L52;
        return r11;
    L52:
        return "0";
    L34:
        if (CollectionsKt.contains(r9, r5) == false) goto L36;
    L39:
        if (r10 != null) goto L41;
    L42:
        r1 = true;
    L43:
        if (r1 == true) goto L52;
        return r10;
    L41:
        if (r10.length() != 0) goto L43;
    L45:
        if (r10 != null) goto L47;
    L48:
        r1 = true;
    L49:
        if (r1 == true) goto L52;
        return r10;
    L47:
        if (r10.length() != 0) goto L49;
    L22:
        if (Intrinsics.areEqual(r5, "0") == false) goto L25;
    L18:
        r12 = false;
    L12:
        r5 = null;
    L7:
        r3 = false;
        goto L8
    }
}
