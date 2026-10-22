package com.bytedance.android.live.liveinteract.plantform.datamerge.handler.revenue;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.livesdk.chatroom.viewmodel.k;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.j;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rj0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/datamerge/handler/revenue/PaidLinkMicPlayModeHandler;", "Lcom/bytedance/android/live/liveinteract/plantform/datamerge/handler/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidLinkMicPlayModeHandler extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a implements Observer<KVData> {
    public static final /* synthetic */ int l = 0;
    public boolean b;
    public final List<ILinkPlayerInfoBridge> c;
    public final Map<String, Long> d;
    public final e e;
    public final List<ILinkPlayerInfoBridge> f;
    public final d g;
    public final f h;
    public final LifecycleOwner i;
    public final i<ILinkPlayerInfoBridge> j;
    public final DataCenter k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PaidLinkMicPlayModeHandler a;

        public b(PaidLinkMicPlayModeHandler r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            PaidLinkMicPlayModeHandler r0 = this.a;
            String r6 = ((dh0.b) r5).a;
            int r1 = PaidLinkMicPlayModeHandler.l;
            r0.getClass();
            gh0.a.b("PaidLinkMicPlayModeHandler", "restoreEmptyStub, interactId: " + r6, 4);
            Iterator r2 = ((ArrayList) r0.f).iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            Object r3 = r2.next();
            if (Intrinsics.areEqual(((ILinkPlayerInfoBridge) r3).getInteractId(), r6) == false) goto L4;
        L9:
            ILinkPlayerInfoBridge r4 = (ILinkPlayerInfoBridge) r3;
            if (r4 == null) goto L16;
            ((ArrayList) r0.f).remove(r4);
            r0.a().Z0(r0.f);
            return;
        L16:
            return;
        L8:
            r3 = null;
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PaidLinkMicPlayModeHandler a;

        public c(PaidLinkMicPlayModeHandler r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            k r5 = (k) r4;
            StringBuilder r0 = new StringBuilder("switch layout, scene: ");
            Integer r1 = null;
            if (r5 == null) goto L5;
            Integer r2 = Integer.valueOf(r5.a);
        L6:
            r0.append(r2);
            r0.append(", uiLayout: ");
            if (r5 == null) goto L9;
            r1 = Integer.valueOf(r5.b);
        L9:
            r0.append(r1);
            gh0.a.b("PaidLinkMicPlayModeHandler", r0.toString(), 4);
            ((ArrayList) this.a.f).clear();
            this.a.a().Z0(this.a.f);
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class d extends i.d {
        public final /* synthetic */ PaidLinkMicPlayModeHandler a;

        public d(PaidLinkMicPlayModeHandler r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void l(List<ILinkPlayerInfoBridge> r2) {
            Intrinsics.checkNotNullParameter(r2, "list");
            onOnlineListChanged(r2);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r13) {
            Intrinsics.checkNotNullParameter(r13, "list");
            ArrayList r0 = new ArrayList();
            r0.addAll(this.a.c);
            ((ArrayList) this.a.c).clear();
            ((ArrayList) this.a.c).addAll(r13);
            if (((ArrayList) this.a.c).size() <= r0.size()) goto L5;
            boolean r14 = true;
        L7:
            if (((ArrayList) this.a.c).size() >= r0.size()) goto L9;
            boolean r1 = true;
        L10:
            ArrayList r4 = new ArrayList();
            if (r14 == false) goto L24;
            Iterator r6 = ((ArrayList) this.a.c).iterator();
        L14:
            if (r6.hasNext() == false) goto L38;
            ILinkPlayerInfoBridge r7 = (ILinkPlayerInfoBridge) r6.next();
            Iterator r8 = r0.iterator();
        L17:
            if (r8.hasNext() == false) goto L21;
            Object r9 = r8.next();
            if (Intrinsics.areEqual(((ILinkPlayerInfoBridge) r9).getInteractId(), r7.getInteractId()) == false) goto L17;
        L22:
            if (r9 != null) goto L14;
            r4.add(r7);
            goto L14
        L21:
            r9 = null;
        L38:
            if (r14 == false) goto L52;
            gh0.a.b("PaidLinkMicPlayModeHandler", "onRemoteUserJoined, changeUserList=" + r4, 4);
            Iterator r15 = r4.iterator();
        L41:
            if (r15.hasNext() == false) goto L52;
            ILinkPlayerInfoBridge r10 = (ILinkPlayerInfoBridge) r15.next();
            Iterator r11 = ((ArrayList) this.a.f).iterator();
        L44:
            if (r11.hasNext() == false) goto L48;
            Object r12 = r11.next();
            if (Intrinsics.areEqual(((ILinkPlayerInfoBridge) r12).getInteractId(), r10.getInteractId()) == false) goto L44;
        L49:
            ILinkPlayerInfoBridge r16 = (ILinkPlayerInfoBridge) r12;
            if (r16 == null) goto L41;
            gh0.a.b("PaidLinkMicPlayModeHandler", "onRemoteUserJoined, interactId: " + r10.getInteractId(), 4);
            ((ArrayList) this.a.f).remove(r16);
            this.a.a().Z0(this.a.f);
            goto L41
        L48:
            r12 = null;
        L52:
            if (r1 == false) goto L72;
            gh0.a.b("PaidLinkMicPlayModeHandler", "onRemoteUserLeaved, changeUserList=" + r4, 4);
            Iterator r17 = r4.iterator();
        L55:
            if (r17.hasNext() == false) goto L105;
            ILinkPlayerInfoBridge r2 = (ILinkPlayerInfoBridge) r17.next();
            Iterator r5 = ((ArrayList) this.a.f).iterator();
        L58:
            if (r5.hasNext() == false) goto L62;
            Object r18 = r5.next();
            if (Intrinsics.areEqual(((ILinkPlayerInfoBridge) r18).getInteractId(), r2.getInteractId()) == false) goto L58;
        L63:
            ILinkPlayerInfoBridge r19 = (ILinkPlayerInfoBridge) r18;
            if (r19 == null) goto L66;
            ((ArrayList) this.a.f).remove(r19);
            boolean r20 = true;
        L68:
            if (r2.getPaidCount() <= 0) goto L70;
            ILinkPlayerInfoBridge r21 = n.a(r2);
            r21.setPaidUserLeave(true);
            ((ArrayList) this.a.f).add(r21);
            r20 = true;
        L70:
            if (r20 == false) goto L55;
            gh0.a.b("PaidLinkMicPlayModeHandler", "onRemotePaidUserLeaved, interactId: " + r2.getInteractId() + ", userPosition: " + r2.getUserPosition(), 4);
            this.a.a().Z0(this.a.f);
            goto L55
        L66:
            r20 = false;
            goto L68
        L62:
            r18 = null;
            goto L63
        L105:
            return;
        L72:
            return;
        L24:
            if (r1 == false) goto L38;
            Iterator r3 = r0.iterator();
        L27:
            if (r3.hasNext() == false) goto L38;
            ILinkPlayerInfoBridge r22 = (ILinkPlayerInfoBridge) r3.next();
            Iterator r23 = ((ArrayList) this.a.c).iterator();
        L30:
            if (r23.hasNext() == false) goto L34;
            Object r24 = r23.next();
            if (Intrinsics.areEqual(((ILinkPlayerInfoBridge) r24).getInteractId(), r22.getInteractId()) == false) goto L30;
        L35:
            if (r24 != null) goto L27;
            r4.add(r22);
            goto L27
        L34:
            r24 = null;
            goto L35
        L9:
            r1 = false;
            goto L10
        L5:
            r14 = false;
            goto L7
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ PaidLinkMicPlayModeHandler a;

        public e(PaidLinkMicPlayModeHandler r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            cj0.k r5 = (cj0.k) r4;
            if (r5 == null) goto L7;
            boolean r0 = true;
            if (r5.a != true) goto L7;
        L9:
            if (this.a.b == r0) goto L12;
            gh0.a.b("PaidLinkMicPlayModeHandler", "mPaidLinkMicStateObserver, change from " + this.a.b + " to " + r0, 4);
            PaidLinkMicPlayModeHandler r6 = this.a;
            r6.b = r0;
            r6.a().A0(this.a.b);
            return;
        L12:
            return;
        L7:
            r0 = false;
            goto L9
        }
    }

    public static final class f implements h.a {
        public final /* synthetic */ PaidLinkMicPlayModeHandler a;

        @Override // rj0.h.a
        public final void B0(long r1) {
        }

        public f(PaidLinkMicPlayModeHandler r1) {
            this.a = r1;
        }

        @Override // rj0.h.a
        public final void v3(Map<String, Long> r4) {
            Intrinsics.checkNotNullParameter(r4, "guestTimeRemaining");
            cj0.c r0 = PaidLinkMicContext.Companion.a();
            if (r0 != null) goto L5;
        L7:
            gh0.a.a("PaidLinkMicPlayModeHandler", "onGuestRemainingTimeChanged", true);
            ((LinkedHashMap) this.a.d).clear();
            this.a.d.putAll(r4);
            this.a.c();
            return;
        L5:
            if (r0.isPaidLinkOn() == true) goto L7;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        cj0.c r0 = PaidLinkMicContext.Companion.a();
        if (r0 == null) goto L7;
        NextLiveData<cj0.k> r1 = r0.getPaidLinkMicState();
        if (r1 == null) goto L11;
        r1.observe(this.i, this.e);
    L11:
        if (Intrinsics.areEqual(m.n(this.k, null, 2).isAnchor(), Boolean.TRUE) == false) goto L13;
        this.j.Q4(this.g);
        xs2.b.a().b(dh0.b.class).subscribe(new b(this));
    L13:
        int r2 = cj0.e.h;
        h r3 = cj0.e.a.a();
        if (r3 == null) goto L16;
        r3.e(this.h);
    L16:
        j r4 = m.h(this.k, null, 2).getVideoTalkRoomSubScene();
        if (r4 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r4.getValue();
        if (r5 == null) goto L27;
        BehaviorSubject r6 = r5.i();
        if (r6 == null) goto L28;
        Disposable r7 = r6.subscribe(new c(this));
        if (r7 == null) goto L29;
        RxUtilKt.c(r7, null);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L7:
        DataCenter r8 = this.k;
        if (r8 == null) goto L11;
        r8.observe("cmd_paid_linkmic_widget_ready", this);
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        cj0.c r0 = PaidLinkMicContext.Companion.a();
        if (r0 == null) goto L8;
        NextLiveData<cj0.k> r1 = r0.getPaidLinkMicState();
        if (r1 == null) goto L8;
        r1.removeObserver(this.e);
    L8:
        if (Intrinsics.areEqual(m.n(this.k, null, 2).isAnchor(), Boolean.TRUE) == false) goto L10;
        this.j.T4(this.g);
    L10:
        int r2 = cj0.e.h;
        h r3 = cj0.e.a.a();
        if (r3 == null) goto L14;
        r3.f(this.h);
    L14:
        if (KtvSettingHelper.r().booleanValue() == false) goto L19;
        DataCenter r4 = this.k;
        if (r4 == null) goto L19;
        r4.removeObserver(this);
    L19:
        if (((LiveMemLeakConfig) j1.a.getValue()).getFixDataCenter() == false) goto L24;
        DataCenter r5 = this.k;
        if (r5 == null) goto L25;
        r5.removeObserver(this);
        return;
    L25:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a b(List<ch0.e> r11) {
        Intrinsics.checkNotNullParameter(r11, "oldMergeDataList");
        List<ch0.e> r12 = r11;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
        ch0.e r2 = null;
    L4:
        if (r13.hasNext() == false) goto L23;
        ch0.e r3 = (ch0.e) r13.next();
        HashMap r8 = new HashMap(r3.d);
        r8.put("EXT_KEY_UPDATE_PAID_TIME_REMAIN", Boolean.TRUE);
        Map<String, Long> r4 = this.d;
        IBaseUser r5 = r3.a.getUser();
        if (r5 == null) goto L8;
        String r6 = r5.getIdString();
    L9:
        Long r7 = (Long) ((LinkedHashMap) r4).get(r6);
        if (r7 == null) goto L12;
        long r9 = r7.longValue();
    L13:
        r8.put("EXT_KEY_UPDATE_PAID_TIME_REMAIN_VALUE", Long.valueOf(r9));
        ch0.e r10 = ch0.e.a(r3, null, null, null, r8, 7);
        IBaseUser r14 = r10.a.getUser();
        if (r14 == null) goto L16;
        String r15 = r14.getIdString();
    L18:
        if (Intrinsics.areEqual(r15, gh0.a.c()) == false) goto L21;
        if (r10 == r3) goto L21;
        r2 = r10;
    L21:
        r0.add(r10);
        goto L4
    L16:
        r15 = null;
        goto L18
    L12:
        r9 = 0;
        goto L13
    L8:
        r6 = null;
        goto L9
    L23:
        return new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a(true, r0, r2);
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L20;
        Object r0 = r4.getData();
        if ((r0 instanceof Object) == true) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L24;
        String r5 = r4.getKey();
        if (r5.hashCode() == (-403549272)) goto L13;
        return;
    L13:
        if (r5.equals("cmd_paid_linkmic_widget_ready") == false) goto L21;
        cj0.c r6 = PaidLinkMicContext.Companion.a();
        if (r6 == null) goto L22;
        NextLiveData<cj0.k> r7 = r6.getPaidLinkMicState();
        if (r7 == null) goto L23;
        r7.observe(this.i, this.e);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L24:
        return;
    }

    public PaidLinkMicPlayModeHandler(LifecycleOwner r2, i<ILinkPlayerInfoBridge> r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "lifeCycleOwner");
        Intrinsics.checkNotNullParameter(r3, "linkUserCenter");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.c r5 = MultiRevenueDataContext.a.c();
        if (r5 == null) goto L5;
        boolean r6 = r5.isPaidLinkOn();
    L6:
        this.b = r6;
        this.c = new ArrayList();
        this.d = new LinkedHashMap();
        this.e = new e(this);
        this.f = new ArrayList();
        this.g = new d(this);
        this.h = new f(this);
        return;
    L5:
        r6 = false;
        goto L6
    }
}
