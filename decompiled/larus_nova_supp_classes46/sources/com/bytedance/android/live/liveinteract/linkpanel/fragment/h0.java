package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.utils.r2;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h0 {
    public static final Map<String, LinkedList<com.bytedance.android.live.liveinteract.plantform.model.u>> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static void a(com.bytedance.android.live.liveinteract.plantform.model.u r7) {
        Intrinsics.checkNotNullParameter(r7, "user");
        com.bytedance.android.livesdk.user.e r0 = jc1.k.n(IMiddlewareUserService.class).user();
        Object r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.n();
    L6:
        if (r2 == null) goto L40;
        boolean r3 = true;
        if (r2.a(r2) != true) goto L41;
        Map<String, LinkedList<com.bytedance.android.live.liveinteract.plantform.model.u>> r4 = a;
        LinkedList<com.bytedance.android.live.liveinteract.plantform.model.u> r5 = (LinkedList) ((LinkedHashMap) r4).get(r2);
        if (r5 != null) goto L13;
        r5 = new LinkedList();
        ALogger.i("SearchUserHistoryStore", "anchorId add new");
        r4.put(r2, r5);
    L13:
        if (r5.size() != 50) goto L15;
        r5.removeLast();
    L15:
        Iterator<T> r6 = r5.iterator();
    L17:
        if (r6.hasNext() == false) goto L30;
        Object r8 = r6.next();
        IBaseUser r9 = ((com.bytedance.android.live.liveinteract.plantform.model.u) r8).getUser();
        if (r9 == null) goto L21;
        String r10 = r9.getIdString();
    L22:
        IBaseUser r11 = r7.getUser();
        if (r11 == null) goto L25;
        String r12 = r11.getIdString();
    L27:
        if (Intrinsics.areEqual(r10, r12) == false) goto L17;
        r1 = r8;
        goto L30
    L25:
        r12 = null;
        goto L27
    L21:
        r10 = null;
    L30:
        if (r1 == null) goto L33;
        r3 = false;
    L33:
        com.bytedance.android.live.liveinteract.plantform.model.u r13 = (com.bytedance.android.live.liveinteract.plantform.model.u) vh7.f.c(com.bytedance.android.live.liveinteract.plantform.model.u.class);
        r13.setSearchType(2);
        ILinkPlayerInfoBridge r14 = (ILinkPlayerInfoBridge) vh7.f.c(ILinkPlayerInfoBridge.class);
        r14.setUser(r7.getUser());
        Unit r15 = Unit.INSTANCE;
        r13.setInviteInfo(r14);
        if (r3 == false) goto L42;
        r5.add(0, r13);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
