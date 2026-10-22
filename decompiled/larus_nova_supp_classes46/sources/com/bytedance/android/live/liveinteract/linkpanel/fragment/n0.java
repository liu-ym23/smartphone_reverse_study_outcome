package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.utils.r2;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n0 extends k0 {
    public Disposable c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ n0 a;

        public a(n0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            TalkRoomSearchContract$View r0 = (TalkRoomSearchContract$View) this.a.b;
            if (r0 == null) goto L6;
            r0.ca0((com.bytedance.android.live.liveinteract.plantform.model.t) r3.data);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ n0 a;

        public b(n0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            TalkRoomSearchContract$View r0 = (TalkRoomSearchContract$View) this.a.b;
            if (r0 == null) goto L6;
            r0.ba0(r3);
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.live.liveinteract.linkpanel.fragment.TalkRoomSearchContract$View] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.LinkedList] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.LinkedList] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.ArrayList] */
    public final void d() {
        ?? r0 = (TalkRoomSearchContract$View) this.b;
        if (r0 == 0) goto L62;
        Map<String, LinkedList<com.bytedance.android.live.liveinteract.plantform.model.u>> r1 = h0.a;
        com.bytedance.android.livesdk.user.e r2 = jc1.k.n(IMiddlewareUserService.class).user();
        String r3 = null;
        if (r2 == null) goto L7;
        String r4 = r2.n();
    L9:
        if (r4 != null) goto L11;
    L48:
        StringBuilder r5 = new StringBuilder("anchorId not find, ");
        com.bytedance.android.livesdk.user.e r6 = jc1.k.n(IMiddlewareUserService.class).user();
        if (r6 == null) goto L51;
        r3 = r6.n();
    L51:
        r5.append(r3);
        r5.append(" != ");
        r5.append(r4);
        ALogger.i("SearchUserHistoryStore", r5.toString());
        ?? r7 = new LinkedList();
    L52:
        r0.aa0(r7);
        return;
    L11:
        if (r2.a(r4) != true) goto L48;
        Map<String, LinkedList<com.bytedance.android.live.liveinteract.plantform.model.u>> r8 = h0.a;
        if (r8.containsKey(r4) == false) goto L48;
        ALogger.i("SearchUserHistoryStore", "anchorId find");
        LinkedList r9 = (LinkedList) ((LinkedHashMap) r8).get(r4);
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r10 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r10 == null) goto L17;
        Iterable r11 = r10.getOnlineUserList();
    L18:
        if (r9 == null) goto L47;
        r7 = new ArrayList();
        Iterator r12 = r9.iterator();
    L21:
        if (r12.hasNext() == false) goto L52;
        Object r13 = r12.next();
        com.bytedance.android.live.liveinteract.plantform.model.u r14 = (com.bytedance.android.live.liveinteract.plantform.model.u) r13;
        ILinkPlayerInfoBridge r15 = r14.getInviteInfo();
        boolean r16 = false;
        if (r15 == null) goto L25;
        r15.setHasInvited(false);
    L25:
        if (r11 == null) goto L42;
        Iterator r17 = r11.iterator();
    L28:
        if (r17.hasNext() == false) goto L40;
        Object r18 = r17.next();
        IBaseUser r19 = ((ILinkPlayerInfoBridge) r18).getUser();
        if (r19 == null) goto L32;
        String r110 = r19.getIdString();
    L33:
        IBaseUser r111 = r14.getUser();
        if (r111 == null) goto L36;
        String r112 = r111.getIdString();
    L38:
        if (Intrinsics.areEqual(r110, r112) == false) goto L28;
    L41:
        ILinkPlayerInfoBridge r113 = (ILinkPlayerInfoBridge) r18;
    L43:
        if (r113 != null) goto L45;
        r16 = true;
    L45:
        if (r16 == false) goto L21;
        r7.add(r13);
        goto L21
    L36:
        r112 = null;
        goto L38
    L32:
        r110 = null;
        goto L33
    L40:
        r18 = null;
        goto L41
    L42:
        r113 = null;
        goto L43
    L47:
        r7 = new LinkedList();
        goto L52
    L17:
        r11 = null;
        goto L18
    L7:
        r4 = null;
        goto L9
    }

    public n0(TalkRoomSearchFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    public final void e(long r3, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "queryWord");
        this.c = ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).userSearch(r3, r5, r6).as(c())).subscribe(new a(this), new b(this));
    }
}
