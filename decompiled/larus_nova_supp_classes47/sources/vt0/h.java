package vt0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.revlink.api.ILinkService;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import mv0.b0;
import mv0.k;
import p11.j;
import qs0.r;
import qs0.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "targetUid");
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        j r1 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).mo471getRevenueLinkDataHolder();
        if (r1 == null) goto L5;
        String r2 = r1.a();
    L7:
        if (Intrinsics.areEqual(r2, r6) == false) goto L9;
    L91:
        ALogger.i("UserTypeUtil", "target is link anchor");
        return true;
    L9:
        if (os0.b.c().getMultiAnchorOutService().a(r6) == true) goto L91;
        r r3 = os0.b.c().getIMediaLinkOutService();
        if (r3 != null) goto L13;
    L14:
        qs0.d r4 = os0.b.c().getIBroadcastService();
        if (r4 != null) goto L17;
    L18:
        u r5 = os0.b.c().getIPkAudienceLinkOutServiceProxy();
        if (r5 == null) goto L25;
        b0.a r7 = r5.getPkLinkUserInfoCenter();
        if (r7 == null) goto L25;
        if (r7.l(r6) == true) goto L91;
    L25:
        k.d r8 = os0.b.c().getIInteractService().getLinkUserInfoCenter();
        if (r8 == null) goto L48;
        List<ILinkPlayerInfoBridge> r9 = r8.n();
        if (r9 == null) goto L48;
        Iterator<T> r10 = r9.iterator();
    L31:
        if (r10.hasNext() == false) goto L41;
        Object r12 = r10.next();
        ILinkPlayerInfoBridge r13 = (ILinkPlayerInfoBridge) r12;
        if (r13 == null) goto L37;
        IBaseUser r14 = r13.getUser();
        if (r14 == null) goto L37;
        String r15 = r14.getIdString();
    L39:
        if (Intrinsics.areEqual(r15, r6) == false) goto L31;
    L42:
        ILinkPlayerInfoBridge r16 = (ILinkPlayerInfoBridge) r12;
        if (r16 == null) goto L48;
        if (r16.getLinkStatus() != 2) goto L48;
        ALogger.i("UserTypeUtil", "target is link audience");
        return true;
    L37:
        r15 = null;
        goto L39
    L41:
        r12 = null;
    L48:
        k.d r17 = os0.b.c().getIInteractService().getLinkUserInfoCenter();
        if (r17 == null) goto L66;
        List<ILinkPlayerInfoBridge> r18 = r17.m();
        if (r18 == null) goto L66;
        Iterator<T> r19 = r18.iterator();
    L54:
        if (r19.hasNext() == false) goto L64;
        Object r20 = r19.next();
        ILinkPlayerInfoBridge r22 = (ILinkPlayerInfoBridge) r20;
        if (r22 == null) goto L60;
        IBaseUser r23 = r22.getUser();
        if (r23 == null) goto L60;
        String r24 = r23.getIdString();
    L62:
        if (Intrinsics.areEqual(r24, r6) == false) goto L54;
    L65:
        ILinkPlayerInfoBridge r25 = (ILinkPlayerInfoBridge) r20;
    L67:
        if (r25 == null) goto L70;
        ALogger.i("UserTypeUtil", "target is link audience by cross room");
        return true;
    L70:
        boolean r26 = com.bytedance.android.live.revenue.core.util.h.a;
        List r27 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getGroupMemberList();
        if (r27 == null) goto L80;
        Iterator r28 = r27.iterator();
    L74:
        if (r28.hasNext() == false) goto L78;
        Object r29 = r28.next();
        if (Intrinsics.areEqual(((IBaseUser) r29).getIdString(), r6) == false) goto L74;
    L79:
        IBaseUser r30 = (IBaseUser) r29;
    L81:
        if (r30 == null) goto L83;
        return true;
    L83:
        k.b r32 = os0.b.c().getIInteractService().h(null);
        if (r32 != null) goto L86;
        return false;
    L86:
        if (r32.l(r6) != true) goto L102;
        ALogger.i("UserTypeUtil", "target is link audience by new video link");
        return true;
    L102:
        return false;
    L78:
        r29 = null;
        goto L79
    L80:
        r30 = null;
    L60:
        r24 = null;
        goto L62
    L64:
        r20 = null;
    L66:
        r25 = null;
        goto L67
    L17:
        if (r4.isUserInAnchorLink(r6) == true) goto L91;
    L13:
        if (r3.isUserInMediaLink(r6) == true) goto L91;
    L5:
        r2 = null;
        goto L7
    }

    public static String a(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "selfUid");
        Intrinsics.checkNotNullParameter(r2, "targetUid");
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        if (Intrinsics.areEqual(r1, r3) == false) goto L12;
        if (Intrinsics.areEqual(r2, r3) == false) goto L8;
        return "anchor_c_self";
    L8:
        if (b(r2) == false) goto L10;
        return "anchor_c_guest";
    L10:
        return "anchor_c_audience";
    L12:
        if (Intrinsics.areEqual(r2, r3) == false) goto L15;
        return "audience_c_anchor";
    L15:
        if (Intrinsics.areEqual(r2, r1) == false) goto L18;
        return "audience_c_self";
    L18:
        if (b(r2) == false) goto L20;
        return "audience_c_guest";
    L20:
        return "audience_c_audience";
    }
}
