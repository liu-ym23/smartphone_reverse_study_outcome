package vt0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.api.ILinkService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mv0.k;
import qs0.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r7, String r8) {
        if (r8 != null) goto L5;
        return DataType.TRUE;
    L5:
        i r1 = os0.b.c().getIInteractService();
        List r3 = null;
        if (r1 == null) goto L27;
        k.d r2 = r1.getLinkUserInfoCenter();
        if (r2 == null) goto L27;
        List<ILinkPlayerInfoBridge> r4 = r2.n();
        if (r4 == null) goto L27;
        List<ILinkPlayerInfoBridge> r5 = r4;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r9 = r5.iterator();
    L13:
        if (r9.hasNext() == false) goto L19;
        ILinkPlayerInfoBridge r10 = (ILinkPlayerInfoBridge) r9.next();
        if (r10 == null) goto L17;
        IBaseUser r12 = r10.getUser();
    L18:
        r6.add(r12);
        goto L13
    L17:
        r12 = null;
        goto L18
    L19:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r14 = r6.iterator();
    L21:
        if (r14.hasNext() == false) goto L28;
        IBaseUser r15 = (IBaseUser) r14.next();
        if (r15 == null) goto L25;
        String r16 = r15.getIdString();
    L26:
        r13.add(r16);
        goto L21
    L25:
        r16 = null;
    L28:
        boolean r17 = com.bytedance.android.live.revenue.core.util.h.a;
        ILinkService r18 = (ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class);
        p11.e r19 = r18.mo468getMultiAnchorService();
        if (r19 == null) goto L46;
        List r20 = r19.j();
        if (r20 == null) goto L46;
        List r22 = r20;
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r24 = r22.iterator();
    L34:
        if (r24.hasNext() == false) goto L36;
        r23.add(((com.bytedance.android.livesdk.link.model.bridge.k) r24.next()).getUser());
        goto L34
    L36:
        ArrayList r25 = new ArrayList();
        Iterator r26 = r23.iterator();
    L38:
        if (r26.hasNext() == false) goto L45;
        IBaseUser r27 = (IBaseUser) r26.next();
        if (r27 == null) goto L42;
        String r28 = r27.getIdString();
    L43:
        if (r28 == null) goto L38;
        r25.add(r28);
        goto L38
    L42:
        r28 = null;
        goto L43
    L45:
        r3 = CollectionsKt.toMutableList(r25);
    L46:
        p11.h r29 = r18.mo470getPkService();
        if (r29 == null) goto L53;
        IBaseUser r30 = r29.C();
        if (r30 == null) goto L53;
        if (r3 == null) goto L53;
        r3.add(r30.getIdString());
    L53:
        if (Intrinsics.areEqual(r8, r7) == false) goto L57;
        return "2";
    L57:
        if (r3 != null) goto L59;
    L62:
        if (r13 != null) goto L64;
    L67:
        return DataType.TRUE;
    L64:
        if (r13.contains(r8) != true) goto L67;
        return "4";
    L59:
        if (r3.contains(r8) != true) goto L62;
        return "3";
    L27:
        r13 = null;
        goto L28
    }
}
