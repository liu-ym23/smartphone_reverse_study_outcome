package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import android.view.ViewGroup;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.internal.MVIBindingImpl;
import com.bytedance.android.anya.t;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.gift.model.s1;
import com.bytedance.android.livesdk.gift.model.u1;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.message.model.q8;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\u00020\u00032\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/pkTray/CrossRoomTrayDataStore;", "Lcom/bytedance/android/scope/o;", "Lcom/bytedance/android/anya/BaseMVIDataStore;", "Lcom/bytedance/android/livesdk/gift/platform/business/pkTray/n;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CrossRoomTrayDataStore extends BaseMVIDataStore<CrossRoomTrayDataStore> implements com.bytedance.android.scope.o, n, Observer<KVData> {
    public static final /* synthetic */ KProperty[] p = null;
    public final ReadOnlyProperty e;
    public final ReadOnlyProperty f;
    public final Map<String, com.bytedance.android.anya.q> g;
    public final Map<String, TrayStatus> h;
    public final CompositeDisposable i;
    public final f j;
    public final e k;
    public final DataCenter l;
    public final yz0.k m;
    public final yz0.l n;
    public final ILinkService o;

    public final class a implements Consumer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.pkTray.CrossRoomTrayDataStore$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/q8;", "p1", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/message/model/q8;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<q8, Unit> {
        public AnonymousClass1(CrossRoomTrayDataStore r8) {
            super(1, r8, CrossRoomTrayDataStore.class, "onReceiverTrayMessage", "onReceiverTrayMessage(Lcom/bytedance/android/livesdk/message/model/ILightGiftMessage;)V", 0);
        }

        public final void invoke(q8 r23) {
            Intrinsics.checkNotNullParameter(r23, "p1");
            CrossRoomTrayDataStore r2 = (CrossRoomTrayDataStore) ((CallableReference) this).receiver;
            KProperty[] r3 = CrossRoomTrayDataStore.p;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r23, "message");
            String r4 = String.valueOf(r23.getToUserId());
            p11.h r5 = r2.o.getPkService();
            ReadOnlyProperty r6 = com.bytedance.android.livesdk.gift.platform.business.e.B;
            KProperty[] r7 = com.bytedance.android.livesdk.gift.platform.business.e.a;
            Object r8 = null;
            if (((Boolean) r6.getValue(null, r7[26])).booleanValue() == true) goto L5;
        L13:
            boolean r9 = false;
        L14:
            if (r9 == false) goto L102;
            String r10 = String.valueOf(r23.getToUserId());
            if (((LinkedHashMap) r2.g).get(r10) != null) goto L39;
            e r11 = r2.k;
            r11.getClass();
            Intrinsics.checkNotNullParameter(r10, "createKey");
            Boolean r13 = r11.a.get(r10);
            Boolean r14 = Boolean.TRUE;
            if (Intrinsics.areEqual(r13, r14) == true) goto L36;
            r11.a.put(r10, r14);
            GiftContext r15 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r15 == null) goto L36;
            com.bytedance.live.datacontext.n<ViewGroup> r16 = r15.getPkTrayTempContainer();
            if (r16 == null) goto L36;
            ViewGroup r17 = (ViewGroup) r16.getValue();
            if (r17 == null) goto L36;
            k r18 = new k(r17.getContext(), r17);
            MVIBindingImpl r19 = r11.c(r18, m.class);
            ((ArrayList) r11.c).add(r18);
            Object r110 = CollectionsKt.lastOrNull(r11.b);
            if ((r110 instanceof m) == true) goto L32;
            r110 = null;
        L32:
            m r111 = (m) r110;
            if (r111 == null) goto L35;
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            r111.v = r10;
        L35:
            r11.a.put(r10, Boolean.FALSE);
        L37:
            if (r19 == null) goto L39;
            r19.a();
            r2.g.put(r10, r19);
        L36:
            r19 = null;
        L39:
            r2.g(null, new CrossRoomTrayDataStore$adjustTrayPosition$1(r2, ((Boolean) r2.l.get("cmd_what_audience_join_guest_link", Boolean.FALSE)).booleanValue()));
            if (r23.getCount() != 0) goto L42;
            r23.setCount(r23.getGroupCount());
        L42:
            Intrinsics.checkNotNullParameter(r23, "$this$toTrayData");
            s1 r20 = r23.getGiftInfo();
            if (r20 == null) goto L45;
            int r21 = (int) r20.getDiamondCount();
        L46:
            int r112 = r21 * ((int) r23.getCount());
            s1 r24 = r23.getGiftInfo();
            if (r24 == null) goto L50;
            py.k r25 = r24.getGiftIcon();
            if (r25 == null) goto L50;
        L51:
            py.k r113 = r25;
            int r114 = (int) r23.getCount();
            String r115 = String.valueOf(r23.getToUserId());
            s1 r26 = r23.getGiftInfo();
            if (r26 == null) goto L54;
            long r116 = r26.getGiftId();
        L55:
            IBaseUser r27 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getPkService().C();
            if (r27 == null) goto L59;
            String r28 = String.valueOf(r27.getLiveRoomId());
            if (r28 == null) goto L59;
        L60:
            String r117 = r28;
            u1 r0 = r23.getTrayInfo();
            if (r0 == null) goto L68;
            Long r1 = Long.valueOf(r0.getDuration());
            if (r1.longValue() <= 0) goto L65;
            boolean r29 = true;
        L66:
            if (r29 == false) goto L68;
        L69:
            Unit r30 = Unit.INSTANCE;
            if (r1 == null) goto L72;
            long r31 = r1.longValue();
        L73:
            d r33 = new d(r112, r113, r114, r115, r116, r117, r31);
            f r34 = r2.j;
            r34.getClass();
            Intrinsics.checkNotNullParameter(r10, "key");
            Intrinsics.checkNotNullParameter(r33, "data");
            if (r34.a.containsKey(r10) == false) goto L92;
            PriorityQueue r35 = (PriorityQueue) ((LinkedHashMap) r34.a).get(r10);
            if (r35 == null) goto L89;
            Iterator r36 = r35.iterator();
        L79:
            if (r36.hasNext() == false) goto L86;
            Object r37 = r36.next();
            if (((d) r37).e != r33.e) goto L83;
            boolean r118 = true;
        L84:
            if (r118 == false) goto L79;
            r8 = r37;
            goto L86
        L83:
            r118 = false;
        L86:
            d r38 = (d) r8;
            if (r38 == null) goto L89;
            r38.c += r33.c;
        L95:
            r2.n(r10);
            return;
        L89:
            PriorityQueue r39 = (PriorityQueue) ((LinkedHashMap) r34.a).get(r10);
            if (r39 == null) goto L95;
            r39.offer(r33);
            goto L95
        L92:
            r34.a.put(r10, new PriorityQueue(((Number) com.bytedance.android.livesdk.gift.platform.business.e.C.getValue(null, r7[27])).intValue(), new g()));
            PriorityQueue r40 = (PriorityQueue) ((LinkedHashMap) r34.a).get(r10);
            if (r40 == null) goto L95;
            r40.offer(r33);
            goto L95
        L72:
            r31 = 2000;
            goto L73
        L65:
            r29 = false;
        L68:
            r1 = null;
        L59:
            r28 = BuildConfig.FLAVOR;
            goto L60
        L54:
            r116 = 0;
        L50:
            r25 = (py.k) vh7.f.c(py.k.class);
            goto L51
        L45:
            r21 = 0;
            goto L46
        L102:
            return;
        L5:
            if (r5.getPkState() != 1) goto L13;
            IBaseUser r41 = r5.C();
            if (r41 == null) goto L9;
            String r43 = r41.getIdString();
        L11:
            if (Intrinsics.areEqual(r43, r4) == false) goto L13;
            r9 = true;
            goto L14
        L9:
            r43 = null;
            goto L11
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((q8) r1);
            return Unit.INSTANCE;
        }
    }

    static {
        p = new KProperty[]{Reflection.property1(new PropertyReference1Impl(CrossRoomTrayDataStore.class, "newConsumeMessage", "getNewConsumeMessage()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(CrossRoomTrayDataStore.class, "trayPosition", "getTrayPosition()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0))};
    }

    public final t<CrossRoomTrayDataStore, Map<String, d>> o() {
        return (t) this.e.getValue(this, p[0]);
    }

    public final t<CrossRoomTrayDataStore, Map<String, Integer>> q() {
        return (t) this.f.getValue(this, p[1]);
    }

    public final void onStart() {
        yz0.l r0 = this.n;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(yz0.h.a.a(r0, com.bytedance.android.live.revenue.common.message.b.J, false, 6).subscribe(new a(new AnonymousClass1(this))), this.i);
        this.l.observeForever("cmd_what_audience_join_guest_link", this);
    }

    public final void onStop() {
        e r0 = this.k;
        ((ArrayList) r0.b).clear();
        ((ArrayList) r0.c).clear();
        r0.a.clear();
        Iterator r1 = ((LinkedHashMap) this.g).values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.bytedance.android.anya.q) r1.next()).unbind();
        goto L4
    L6:
        ((LinkedHashMap) this.g).clear();
        ((LinkedHashMap) this.j.a).clear();
        this.i.clear();
        this.l.removeObserver("cmd_what_audience_join_guest_link", this);
    }

    public static final int k(CrossRoomTrayDataStore r4) {
        oq2.d r0 = r4.o.getPkService().G();
        if (com.bytedance.android.live.core.utils.s1.E() <= 1) goto L5;
        float r1 = com.bytedance.android.live.core.utils.s1.E();
    L6:
        int r2 = com.bytedance.android.live.revenue.common.i.b(4);
        if (r4.m.isAnchor() == true) goto L9;
        int r5 = (int) (28 * r1);
    L10:
        int r3 = r2 + r5;
        int r6 = com.bytedance.android.live.revenue.common.i.b(7);
        return (((r0.a + r0.c) - r3) - r6) - com.bytedance.android.live.revenue.common.i.b(32);
    L9:
        r5 = 0;
        goto L10
    L5:
        r1 = 1.0f;
        goto L6
    }

    public final void n(final String r4) {
        if (((TrayStatus) ((LinkedHashMap) this.h).get(r4)) != TrayStatus.Busy) goto L5;
        return;
    L5:
        f r0 = this.j;
        Function1<d, Unit> r1 = new CrossRoomTrayDataStore$changeCurrentConsumeMessage$1(this, r4);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r1, "action");
        PriorityQueue r5 = (PriorityQueue) ((LinkedHashMap) r0.a).get(r4);
        if (r5 == null) goto L11;
        d r6 = (d) r5.poll();
        if (r6 == null) goto L12;
        r1.invoke(r6);
        return;
    L12:
        return;
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 == null) goto L5;
        String r1 = r6.getKey();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.hashCode() == 1080946897) goto L12;
        return;
    L12:
        if (r1.equals("cmd_what_audience_join_guest_link") == false) goto L19;
        Boolean r2 = Boolean.FALSE;
        Boolean r7 = (Boolean) r6.getData(r2);
        if (r7 == null) goto L17;
        r2 = r7;
    L17:
        g(null, new CrossRoomTrayDataStore$adjustTrayPosition$1(this, r2.booleanValue()));
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public CrossRoomTrayDataStore(f r2, e r3, DataCenter r4, yz0.k r5, yz0.l r6, ILinkService r7) {
        Intrinsics.checkNotNullParameter(r2, "messageQueue");
        Intrinsics.checkNotNullParameter(r3, "trayFacade");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "roomDataService");
        Intrinsics.checkNotNullParameter(r6, "roomMessageService");
        Intrinsics.checkNotNullParameter(r7, "revlinkService");
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.n = r6;
        this.o = r7;
        com.bytedance.android.anya.internal.k r8 = i(MapsKt.emptyMap()).a();
        KProperty[] r9 = p;
        this.e = r8.a(r9[0]);
        this.f = i(MapsKt.emptyMap()).a().a(r9[1]);
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
        this.i = new CompositeDisposable();
    }
}
