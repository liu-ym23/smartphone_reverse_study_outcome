package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.list.FriendsInviteListBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkInviteListWidget$mInviteCallback$1 implements uf0.c {
    public final /* synthetic */ LinkInviteListWidget a;

    public LinkInviteListWidget$mInviteCallback$1(LinkInviteListWidget r1) {
        this.a = r1;
    }

    @Override // uf0.c
    public final void v5(IBaseUser r10, List<? extends e1> r11) {
        Intrinsics.checkNotNullParameter(r10, "user");
        LinkInviteListWidget r0 = this.a;
        Context r1 = ((Widget) r0).context;
        if (r1 != null) goto L5;
        return;
    L5:
        final IRoom r2 = r0.m;
        if (r2 != null) goto L8;
        return;
    L8:
        List<? extends e1> r3 = r11;
        int r4 = 0;
        if (r3 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == true) goto L22;
        int r6 = com.bytedance.android.live.liveinteract.linkpanel.util.j.a;
        Intrinsics.checkNotNullParameter("panel_friend", "source");
        ALogger.i("InvitePageLogger", "logInviteByIM: source = ".concat("panel_friend"));
        final boolean r7 = ((e1) ListProtector.get(r11, 0)).getNeedPush();
        final String r12 = ((e1) ListProtector.get(r11, 0)).getAction();
        if (r12 != null) goto L19;
        r12 = "";
    L19:
        IMiddlewareHostSocial r8 = jc1.k.f(IMiddlewareHostSocial.class);
        if (r8 == null) goto L22;
        r8.inviteFriendByIM(r1, r10, new LinkInviteListWidget$mInviteCallback$1$onInviteFriendSuccess$1(this, r2, r7, r12));
    L22:
        me.drakeet.multitype.b r9 = null;
        int r13 = -1;
        if ((!((ArrayList) this.a.A).isEmpty()) == false) goto L60;
        LinkInviteListWidget r14 = this.a;
        if (r14.n == false) goto L27;
    L44:
        Iterator<T> r15 = r14.l.iterator();
        ILinkPlayerInfoBridge r16 = null;
    L46:
        if (r15.hasNext() == false) goto L61;
        Object r17 = r15.next();
        int r18 = r4 + 1;
        if (r4 >= 0) goto L51;
        CollectionsKt.throwIndexOverflow();
    L51:
        if ((r17 instanceof com.bytedance.android.live.liveinteract.linkpanel.list.f) == false) goto L59;
        com.bytedance.android.live.liveinteract.linkpanel.list.f r19 = (com.bytedance.android.live.liveinteract.linkpanel.list.f) r17;
        IBaseUser r20 = r19.a.getUser();
        if (r20 == null) goto L55;
        String r21 = r20.getIdString();
    L57:
        if (Intrinsics.areEqual(r21, r10.getIdString()) == false) goto L59;
        r16 = r19.a;
        r13 = r4;
        goto L59
    L55:
        r21 = null;
    L59:
        r4 = r18;
    L61:
        if (r16 == null) goto L69;
        if (r16.isActive() == true) goto L65;
    L67:
        r16.setLastInvitedTimeMillis(p6.b());
        goto L69
    L65:
        if (r16.getListUserType() != 2) goto L67;
        r16.setInviting(true);
    L69:
        if (Intrinsics.areEqual((String) ((LinkedHashMap) this.a.C).get(r10.getIdString()), "friend") == false) goto L85;
        this.a.C.remove(r10.getIdString());
        MultiTypeAdapter r110 = this.a.h;
        if (r110 == null) goto L75;
        me.drakeet.multitype.d r111 = r110.b;
        if (r111 == null) goto L75;
        me.drakeet.multitype.b r112 = (me.drakeet.multitype.b) ListProtector.get(r111.b, 3);
    L77:
        if ((r112 instanceof FriendsInviteListBinder) == false) goto L80;
        r9 = r112;
    L80:
        FriendsInviteListBinder r22 = (FriendsInviteListBinder) r9;
        if (r22 == null) goto L85;
        MultiTypeAdapter r113 = r22.b;
        if (r113 == null) goto L85;
        r113.notifyItemChanged(r13);
    L75:
        r112 = null;
    L85:
        MultiTypeAdapter r114 = this.a.h;
        if (r114 == null) goto L97;
        r114.notifyDataSetChanged();
        return;
    L97:
        return;
    L27:
        if (r14.p == true) goto L44;
        Iterator<T> r115 = r14.k.iterator();
        r16 = null;
    L30:
        if (r115.hasNext() == false) goto L61;
        Object r23 = r115.next();
        int r24 = r4 + 1;
        if (r4 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        if ((r23 instanceof com.bytedance.android.live.liveinteract.linkpanel.list.f) == false) goto L43;
        com.bytedance.android.live.liveinteract.linkpanel.list.f r25 = (com.bytedance.android.live.liveinteract.linkpanel.list.f) r23;
        IBaseUser r26 = r25.a.getUser();
        if (r26 == null) goto L39;
        String r27 = r26.getIdString();
    L41:
        if (Intrinsics.areEqual(r27, r10.getIdString()) == false) goto L43;
        r16 = r25.a;
        r13 = r4;
        goto L43
    L39:
        r27 = null;
    L43:
        r4 = r24;
        goto L30
    L60:
        r16 = null;
        goto L61
    L11:
        if (r3.isEmpty() == true) goto L14;
        r5 = false;
        goto L15
    }
}
