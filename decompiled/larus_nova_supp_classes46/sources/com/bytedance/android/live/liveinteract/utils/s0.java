package com.bytedance.android.live.liveinteract.utils;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s0 {

    public static final class a implements lm3.c.a {
        public final /* synthetic */ Function0 b;

        public a(Function0 r1) {
            this.b = r1;
        }

        public final void onAction(lm3.d r1) {
            this.b.invoke();
        }
    }

    public static final void a(Context r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "onNext");
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        String r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r2 = r0.getLinkUserInfoCenter();
        if (r2 == null) goto L7;
        Iterable r3 = r2.getOnlineUserList();
    L8:
        if (r3 == null) goto L17;
        Iterator r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        Object r5 = r4.next();
        if (com.bytedance.android.live.liveinteract.plantform.a.a((ILinkPlayerInfoBridge) r5) == false) goto L11;
    L16:
        ILinkPlayerInfoBridge r6 = (ILinkPlayerInfoBridge) r5;
    L19:
        if (r6 == null) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == true) goto L24;
        r10.invoke();
        return;
    L24:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L27;
        f2.b(2131918830, 0);
        return;
    L27:
        lm3.d.a r8 = new lm3.d.a(r9);
        r8.a = r9.getString(2131918834);
        r8.b = r9.getString(2131918833);
        lm3.c r11 = new lm3.c();
        r11.b = r9.getString(2131918831);
        r11.c = lm3.c.a.a;
        Unit r12 = Unit.INSTANCE;
        lm3.c r13 = new lm3.c();
        r13.b = r9.getString(2131918832);
        r13.c = new a(r10);
        r8.e = CollectionsKt.listOf(new lm3.c[]{r11, r13});
        r8.a();
        IInteractService r14 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r14 != null) goto L30;
        return;
    L30:
        if (r14.getTalkRoomLogUtils() == null) goto L45;
        if (r6 == null) goto L35;
        IBaseUser r15 = r6.getUser();
        if (r15 == null) goto L35;
        r1 = r15.getIdString();
    L35:
        Intrinsics.checkNotNullParameter("connection_tips", "popupType");
        if (r1 == null) goto L47;
        HashMap r16 = new HashMap();
        r16.put("popup_type", "connection_tips");
        r16.put("AI_guest_id", r1);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_AI_connection_invite_show", r16, new Object[]{am2.x.class, IRoom.class});
        return;
    L47:
        return;
    L45:
        return;
    L21:
        r7 = false;
        goto L22
    L15:
        r5 = null;
        goto L16
    L17:
        r6 = null;
    L7:
        r3 = null;
        goto L8
    }
}
