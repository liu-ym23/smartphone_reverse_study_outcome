package com.bytedance.android.live.revlink.link.biz.component;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.live.revenuelink.utils.MultiChannelOptManager;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.AnchorLinkInitType;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectUtilsKt;
import com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.g0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiAnchorLinkContext;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.plantform.RevLinkMultiChannelDataContext;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.a7;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.r1;
import com.bytedance.android.livesdk.link.model.bridge.s1;
import com.bytedance.android.livesdk.link.model.bridge.z1;
import com.bytedance.android.livesdk.link.model.c7;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.u5;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.badger.collect.impl.constants.Constants;
import dq2.w;
import fr2.h0;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiRTCBizComponent extends com.bytedance.android.live.revenuelink.rtc.e implements com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revenuelink.rtc.j {
    public final String a;
    public final CompositeDisposable b;
    public final Map<String, Boolean> c;
    public final com.bytedance.android.live.revlink.impl.multianchor.dialog.a d;
    public final boolean e;
    public final MultiChannelOptManager f;
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.b g;
    public final n h;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a i;
    public final h j;
    public final com.bytedance.android.live.revenuelink.rtc.i k;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.i l;
    public final MultiBizLifeControlComponent m;
    public final com.bytedance.android.livesdk.revenue.service.room.c n;
    public final com.bytedance.android.live.revlink.link.streaminteract.biz.c o;
    public final MultiAnchorLinkContext p;
    public final yz0.f q;
    public final Function0<Unit> r;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiRTCBizComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass1(MultiRTCBizComponent r8) {
            super(1, r8, MultiRTCBizComponent.class, "onInteractAnchorParamChange", "onInteractAnchorParamChange(Ljava/lang/String;)V", 0);
        }

        public final void invoke(String r2) {
            MultiRTCBizComponent r0 = (MultiRTCBizComponent) ((CallableReference) this).receiver;
            if (r2 != null) goto L5;
            r0.getClass();
            return;
        L5:
            r0.k.J(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((String) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiRTCBizComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/r1;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/bridge/r1;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<r1, Unit> {
        public AnonymousClass2(MultiRTCBizComponent r8) {
            super(1, r8, MultiRTCBizComponent.class, "onMultiChannelInfoChange", "onMultiChannelInfoChange(Lcom/bytedance/android/livesdk/link/model/bridge/IMultiChannelDataBridge;)V", 0);
        }

        public final void invoke(r1 r7) {
            MultiRTCBizComponent r0 = (MultiRTCBizComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r7 == null) goto L33;
            a7 r8 = (a7) r7;
            s1 r1 = r8.getMultiChannel();
            if (r1 == null) goto L7;
            b7 r2 = (b7) r1;
        L8:
            MultiLinkAnchorControlContext r3 = r0.getContext().ua();
            if (r3 == null) goto L14;
            UnexpectedFrameMonitor r4 = r3.getUnexpectedFrameMonitor();
            if (r4 == null) goto L14;
            Intrinsics.checkNotNullParameter(r8, Constants.Keys.DATA);
            r4.q(r8.getPreRtcInfo());
        L14:
            if (r0.e == false) goto L18;
            AnchorRtcConnectModel r5 = r0.j();
            if (r5 == null) goto L34;
            r5.updatePushRtcStreamInfo(r8.getPreRtcInfo(), r2, "getCrossRoomRtcInfo");
            return;
        L34:
            return;
        L18:
            r0.p.setMultiChannelInfo(r2, true);
            if (r2 != null) goto L21;
            return;
        L21:
            if (r2.getUseMultiChannel() == true) goto L23;
            return;
        L23:
            if (r0.k.g0() == false) goto L28;
            com.bytedance.android.live.revenuelink.rtc.i r9 = r0.k;
            Map<Long, String> r6 = r2.getChannelMap();
            if (r6 != null) goto L27;
            r6 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L27:
            r9.a1(r6, "getCrossRoomRtcInfo", String.valueOf(r0.getContext().G()));
            return;
        L28:
            com.bytedance.android.live.revenuelink.rtc.i r10 = r0.k;
            Map<Long, String> r12 = r2.getChannelMap();
            if (r12 != null) goto L31;
            r12 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L31:
            r10.c1(r12, "getCrossRoomRtcInfo", String.valueOf(r0.getContext().G()));
            return;
        L7:
            r2 = null;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((r1) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiRTCBizComponent$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/bytedance/android/livesdk/link/model/p;", "p1", "", "p2", "", "invoke", "(Ljava/util/List;I)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function2<List<? extends com.bytedance.android.livesdk.link.model.p>, Integer, Unit> {
        public AnonymousClass3(MultiRTCBizComponent r8) {
            super(2, r8, MultiRTCBizComponent.class, "onOnlineListChange", "onOnlineListChange(Ljava/util/List;I)V", 0);
        }

        public final void invoke(List<? extends com.bytedance.android.livesdk.link.model.p> r5, int r6) {
            MultiRTCBizComponent r7 = (MultiRTCBizComponent) ((CallableReference) this).receiver;
            r7.getClass();
            if (r5 == null) goto L52;
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator<T> r8 = r5.iterator();
        L7:
            if (r8.hasNext() == false) goto L16;
            com.bytedance.android.livesdk.link.model.p r1 = (com.bytedance.android.livesdk.link.model.p) r8.next();
            String r2 = iz.a.a(r1.getUser());
            if (r2 != null) goto L11;
            r2 = "";
        L11:
            Boolean r3 = (Boolean) ((LinkedHashMap) r7.c).get(r2);
            if (r3 == null) goto L14;
            boolean r4 = r3.booleanValue();
        L15:
            r0.put(r2, TuplesKt.to(Boolean.valueOf(r4), r1));
            goto L7
        L14:
            r4 = false;
            goto L15
        L16:
            LinkedHashMap r9 = new LinkedHashMap();
            Iterator r10 = r0.entrySet().iterator();
        L18:
            if (r10.hasNext() == false) goto L22;
            Map.Entry r12 = (Map.Entry) r10.next();
            if ((!((Boolean) ((Pair) r12.getValue()).getFirst()).booleanValue()) == false) goto L18;
            r9.put(r12.getKey(), r12.getValue());
            goto L18
        L22:
            Iterator r13 = r9.entrySet().iterator();
        L24:
            if (r13.hasNext() == false) goto L30;
            Map.Entry r14 = (Map.Entry) r13.next();
            String r15 = (String) r14.getKey();
            com.bytedance.android.livesdk.link.model.p r16 = (com.bytedance.android.livesdk.link.model.p) ((Pair) r14.getValue()).component2();
            if (r16 == null) goto L24;
            com.bytedance.android.livesdk.link.model.bridge.j r17 = com.bytedance.android.livesdk.link.model.q.b(r16);
            if (r17 == null) goto L24;
            r7.q(r16, r17.getUseBackupStream(), "linkUserUpdate");
            goto L24
        L30:
            ((LinkedHashMap) r7.c).clear();
            Map<String, Boolean> r18 = r7.c;
            LinkedHashMap r19 = new LinkedHashMap(MapsKt.mapCapacity(r0.size()));
            Iterator r20 = r0.entrySet().iterator();
        L32:
            if (r20.hasNext() == false) goto L34;
            Map.Entry r22 = (Map.Entry) r20.next();
            r19.put(r22.getKey(), Boolean.valueOf(((Boolean) ((Pair) r22.getValue()).getFirst()).booleanValue()));
            goto L32
        L34:
            r18.putAll(r19);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((List) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiRTCBizComponent$attach$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/i6;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/i6;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<i6, Unit> {
        public AnonymousClass5(MultiRTCBizComponent r8) {
            super(1, r8, MultiRTCBizComponent.class, "onLinkerMessage", "onLinkerMessage(Lcom/bytedance/android/livesdk/link/model/ILinkerMessage;)V", 0);
        }

        public final void invoke(i6 r9) {
            Intrinsics.checkNotNullParameter(r9, "p1");
            MultiRTCBizComponent r0 = (MultiRTCBizComponent) ((CallableReference) this).receiver;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r9, "$this$sceneExt");
            if (((int) r9.getScene()) == 7) goto L7;
            Intrinsics.checkNotNullParameter(r9, "$this$sceneExt");
            if (((int) r9.getScene()) == 2) goto L7;
            return;
        L7:
            Intrinsics.checkNotNullParameter(r9, "$this$typeExt");
            if (((int) r9.getType2()) != 24) goto L61;
            v r2 = com.bytedance.android.live.revlink.link.biz.service.i.H(r0);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r9, Constants.OperatorKey.MSG);
            LinkedHashMap r3 = new LinkedHashMap();
            r3.put("msg_id", String.valueOf(qj.a(r9)));
            Intrinsics.checkNotNullParameter(r9, "$this$sceneExt");
            r3.put("msg_scene", Long.valueOf(r9.getScene()));
            Intrinsics.checkNotNullParameter(r9, "$this$linkerIdExt");
            r3.put("msg_linker_id", Long.valueOf(r9.getLinkerId()));
            u5 r1 = r9.getAnchorStreamSwitchContent();
            if (r1 == null) goto L16;
            r3.put("use_backup", Boolean.valueOf(r1.isUseBackUp()));
            Intrinsics.checkNotNullParameter(r1, "$this$anchorRevUID");
            String r4 = r1.getAnchorUserId();
            if (r4 != null) goto L15;
            r4 = "";
        L15:
            r3.put("switch_anchor_id", r4);
        L16:
            r2.b(r3);
            if (r2.k() == false) goto L19;
            r2.H("receive_anchor_switch_stream_msg", r3);
        L20:
            u5 r10 = r9.getAnchorStreamSwitchContent();
            if (r10 == null) goto L58;
            AnchorLinkUserCenterV2 r5 = com.bytedance.android.live.revlink.link.biz.service.i.t(r0);
            List r6 = r10.getLinkUsers();
            com.bytedance.android.livesdk.link.model.p r7 = null;
            if (r6 == null) goto L28;
            List r8 = r6;
            ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator r13 = r8.iterator();
        L26:
            if (r13.hasNext() == false) goto L29;
            r12.add(((com.bytedance.android.livesdk.link.model.bridge.k) r13.next()).castTo(com.bytedance.android.livesdk.link.model.p.class));
        L29:
            if (r12 == null) goto L31;
            List<? extends com.bytedance.android.livesdk.link.model.p> r14 = CollectionsKt.toList(r12);
        L32:
            r5.p(r14, "switchStreamMsg", null);
            List r15 = r10.getLinkUsers();
            if (r15 == null) goto L50;
            List r16 = CollectionsKt.toList(r15);
            if (r16 == null) goto L50;
            Iterator r17 = r16.iterator();
        L38:
            if (r17.hasNext() == false) goto L46;
            Object r18 = r17.next();
            IBaseUser r19 = ((com.bytedance.android.livesdk.link.model.bridge.k) r18).getUser();
            if (r19 == null) goto L42;
            String r20 = iz.a.a(r19);
        L43:
            Intrinsics.checkNotNullParameter(r10, "$this$anchorRevUID");
            if (Intrinsics.areEqual(r20, r10.getAnchorUserId()) == false) goto L38;
        L47:
            com.bytedance.android.livesdk.link.model.bridge.k r22 = (com.bytedance.android.livesdk.link.model.bridge.k) r18;
            if (r22 == null) goto L50;
            r7 = (com.bytedance.android.livesdk.link.model.p) r22.castTo(com.bytedance.android.livesdk.link.model.p.class);
            goto L50
        L42:
            r20 = null;
            goto L43
        L46:
            r18 = null;
        L50:
            r0.q(r7, r10.isUseBackUp(), "switchStreamMsg");
            if (r7 == null) goto L59;
            com.bytedance.android.livesdk.link.model.q.b(r7);
            return;
        L59:
            return;
        L31:
            r14 = null;
            goto L32
        L28:
            r12 = null;
            goto L29
        L58:
            return;
        L19:
            int r23 = com.bytedance.android.live.revenue.common.v.a;
            com.bytedance.android.live.revenue.common.v.h("ttlive_anchor_link", "receive_anchor_switch_stream_msg " + r3);
            goto L20
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((i6) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.d(getContext().getLinkDataSet().B5(), new AnonymousClass1(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.d(this.f.e, new AnonymousClass2(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revlink.link.biz.service.i.t(this).m(new AnonymousClass3(this)), this.b);
        this.k.g1(this);
        p0.a(0, false, true, new AnonymousClass4(this), 3);
        Observable r0 = yz0.h.a.a(this.q, CommonMessageTypeKt.a(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        final AnonymousClass5 r1 = new AnonymousClass5(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.subscribe(new a(r1)), this.b);
        RevLinkMultiChannelDataContext r2 = com.bytedance.android.live.revlink.link.biz.service.i.a0(this);
        if (r2 == null) goto L5;
        r2.observeMultiChannelOptManager(this.f);
    L5:
        this.f.b("enter");
        UnexpectedFrameMonitor r3 = k();
        if (r3 == null) goto L42;
        r3.k = this.f;
        com.bytedance.android.live.revenuelink.rtc.i r6 = r3.e;
        if (r6 == null) goto L10;
        r6.g1(r3.o);
    L10:
        com.bytedance.android.live.revenuelink.rtc.i r7 = r3.e;
        if (r7 == null) goto L42;
        com.bytedance.android.live.revenuelink.rtc.p r8 = r7.L();
        if (r8 == null) goto L42;
        List<com.bytedance.android.live.revenuelink.rtc.o> r9 = r8.l();
        if (r9 == null) goto L42;
        Iterator<T> r10 = r9.iterator();
    L18:
        if (r10.hasNext() == false) goto L42;
        com.bytedance.android.live.revenuelink.rtc.o r12 = (com.bytedance.android.live.revenuelink.rtc.o) r10.next();
        if (r12.c == null) goto L22;
        boolean r13 = true;
    L23:
        if (r13 == false) goto L18;
        Map<Long, z1> r14 = r3.n();
        if (r14 == null) goto L37;
        Collection<z1> r15 = r14.values();
        if (r15 == null) goto L37;
        Iterator<T> r16 = r15.iterator();
    L31:
        if (r16.hasNext() == false) goto L35;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((z1) r17).getLinkmicIdStr(), r12.b) == false) goto L31;
    L36:
        z1 r18 = (z1) r17;
    L38:
        if (r18 == null) goto L41;
        if (AnchorRtcConnectUtilsKt.d(r18) == true) goto L18;
    L41:
        r3.p(r12.b, "enterMultiLink");
        goto L42
    L35:
        r17 = null;
    L37:
        r18 = null;
        goto L38
    L22:
        r13 = false;
    L42:
        AnchorRtcConnectModel r4 = j();
        if (r4 == null) goto L47;
        com.bytedance.live.datacontext.k<Boolean> r5 = r4.getMultiLinkLoadEvent();
        if (r5 == null) goto L47;
        r5.post(Boolean.TRUE);
    L47:
        com.bytedance.android.live.revlink.impl.multianchor.utils.b r19 = this.g;
        i11.b r20 = r19.b;
        if (r20 == null) goto L50;
        r20.i(r19.e);
    L50:
        i11.b r22 = r19.b;
        if (r22 == null) goto L55;
        List<com.bytedance.android.livesdk.link.model.p> r23 = r22.getOnlineUserList();
        if (r23 == null) goto L55;
        r19.d.addAll(r23);
    L55:
        com.bytedance.android.live.revlink.impl.global.c r24 = r19.i;
        if (r24 == null) goto L58;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r25 = r24.Q1();
    L59:
        if (r25 == null) goto L63;
        LiveData<List<af2.b>> r26 = r25.getScoreState();
        if (r26 == null) goto L63;
        r26.observeForever(r19.h);
    L63:
        com.bytedance.android.live.revlink.impl.global.c r27 = r19.i;
        if (r27 == null) goto L66;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r28 = r27.Ig();
    L67:
        if (r28 == null) goto L72;
        LiveData<PkBaseStateMachine.c> r29 = r28.getPkBaseState();
        if (r29 == null) goto L72;
        r29.observeForever(r19.g);
    L72:
        if (this.k.isEngineOn() == false) goto L127;
        f21.a r30 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r30 != null) goto L77;
    L81:
        StringBuilder r32 = new StringBuilder("onRtcAlreadyStartedOnCreate ");
        b7 r33 = com.bytedance.android.live.revlink.link.biz.service.i.A(this).f();
        if (r33 == null) goto L84;
        String r34 = c7.a(r33);
    L85:
        r32.append(r34);
        jy0.b.d("ttlive_anchor_link", r32.toString());
        b7 r35 = com.bytedance.android.live.revlink.link.biz.service.i.A(this).f();
        if (r35 != null) goto L88;
    L99:
        IConfig.b.c1.getClass();
        IConfig.b r36 = IConfig.b.a.a;
        if (r36 == null) goto L127;
        this.k.v1(vc0.b.a(r36), 7, 6);
        if (this.k.Q0() == false) goto L104;
    L106:
        Iterator<T> r37 = this.k.L().l().iterator();
    L108:
        if (r37.hasNext() == false) goto L117;
        com.bytedance.android.live.revenuelink.rtc.o r38 = (com.bytedance.android.live.revenuelink.rtc.o) r37.next();
        if (r38.g == true) goto L112;
    L114:
        boolean r39 = false;
    L115:
        if (r39 == false) goto L108;
        this.k.h(r38.b, false, "recoverBackupMute");
        goto L108
    L112:
        if (Intrinsics.areEqual(r38.a, "rtc_user_join_crosstalk_backup") == false) goto L114;
        r39 = true;
        goto L115
    L117:
        f21.a r40 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r40 == null) goto L127;
        if (r40.h != true) goto L127;
        AnchorRtcConnectModel r42 = j();
        if (r42 != null) goto L124;
    L126:
        this.r.invoke();
        goto L127
    L124:
        if (r42.enableFirstFrameOpt() != true) goto L126;
        jy0.b.c("ttlive_anchor_link", "skip pk multi invite join_channel", null, 4);
        goto L127
    L104:
        if (this.e == false) goto L106;
        this.k.q1("multiAnchorStart");
        goto L106
    L88:
        if (r35.getUseMultiChannel() == false) goto L99;
        if (this.e == true) goto L99;
        if (this.k.g0() == false) goto L96;
        Map<Long, String> r43 = r35.getChannelMap();
        if (r43 == null) goto L99;
        this.k.a1(r43, "onCreateRtcOn", String.valueOf(getContext().G()));
        goto L99
    L96:
        Map<Long, String> r44 = r35.getChannelMap();
        if (r44 == null) goto L99;
        this.k.a1(r44, "onCreateRtcOn", String.valueOf(getContext().G()));
        goto L99
    L84:
        r34 = null;
        goto L85
    L77:
        if (r30.c() != true) goto L81;
        com.bytedance.android.live.revlink.link.biz.service.i.f0(this).m(com.bytedance.android.live.revlink.link.biz.service.i.i(this));
        com.bytedance.android.live.revlink.link.biz.service.i.d0(this).getClass();
        com.bytedance.android.live.revlink.impl.multianchor.dialog.a r45 = this.d;
        if (r45 == null) goto L99;
        r45.b();
    L127:
        MultiChannelOptManager r46 = this.f;
        StringBuilder r47 = new StringBuilder("enterMultiLink_");
        f21.a r48 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r48 == null) goto L130;
        AnchorLinkInitType r49 = r48.c;
    L131:
        r47.append(r49);
        r46.b(r47.toString());
        UnexpectedFrameMonitor r50 = k();
        if (r50 == null) goto L135;
        r50.o("enterMultiLink");
    L135:
        if (this.e == false) goto L156;
        f21.a r52 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r52 == null) goto L156;
        if (r52.h != true) goto L156;
        AnchorRtcConnectModel r53 = j();
        if (r53 == null) goto L156;
        com.bytedance.live.datacontext.n<Map<Long, z1>> r54 = r53.getPreRtcInfoMap();
        if (r54 == null) goto L156;
        Map r55 = (Map) r54.getValue();
        if (r55 == null) goto L156;
        Collection r56 = r55.values();
        ArrayList r57 = new ArrayList();
        Iterator r58 = r56.iterator();
    L149:
        if (r58.hasNext() == false) goto L154;
        Object r59 = r58.next();
        if ((!AnchorRtcConnectUtilsKt.d((z1) r59)) == false) goto L149;
        r57.add(r59);
        goto L149
    L154:
        if ((!r57.isEmpty()) == false) goto L156;
        this.f.a(6, "pkMultiInviteFallback", "ensurePreRtcInfo");
    L156:
        HashMap r60 = h0.a(this.k.L().d());
        List<String> r62 = this.k.L().c();
        f21.a r63 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r63 == null) goto L182;
        ArrayList r64 = (ArrayList) r62;
        if (r64.size() == r60.size()) goto L183;
        v r65 = com.bytedance.android.live.revlink.link.biz.service.i.H(this);
        String r66 = r63.toString();
        boolean r67 = r63.k;
        r65.getClass();
        Intrinsics.checkNotNullParameter(r66, "contextStr");
        Intrinsics.checkNotNullParameter(r60, "remoteViewMap");
        Intrinsics.checkNotNullParameter(r62, "remoteUserList");
        LinkedHashMap r68 = new LinkedHashMap();
        r68.put("error_msg", "view:" + r60.size() + ",user:" + r64.size());
        r68.put("connection_context", r66);
        r68.put("remote_views", r60);
        r68.put("remote_users", r62);
        r68.put("is_multi_to_multi", Boolean.valueOf(r67));
        r65.b(r68);
        r65.f(r68);
        int r69 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.b("ttlive_anchor_link", "link_init_remote_view_error: " + r68, null);
        return;
    L183:
        return;
    L182:
        return;
    L130:
        r49 = null;
        goto L131
    L66:
        r28 = null;
        goto L67
    L58:
        r25 = null;
        goto L59
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        RevLinkMultiChannelDataContext r0 = com.bytedance.android.live.revlink.link.biz.service.i.a0(this);
        if (r0 == null) goto L5;
        r0.removeMultiChannelOptManager();
    L5:
        com.bytedance.android.live.revenuelink.connect.f r1 = com.bytedance.android.live.revlink.link.biz.service.i.c(this);
        if (r1 == null) goto L8;
        r1.removeLinkOutListener(7, this.h);
    L8:
        UnexpectedFrameMonitor r2 = k();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r3 = null;
        if (r2 == null) goto L23;
        r2.k = null;
        com.bytedance.android.live.revenuelink.rtc.i r4 = r2.e;
        if (r4 == null) goto L13;
        r4.i1(r2.o);
    L13:
        Disposable r5 = r2.h;
        if (r5 == null) goto L16;
        r5.dispose();
    L16:
        Disposable r6 = r2.i;
        if (r6 == null) goto L19;
        r6.dispose();
    L19:
        Disposable r7 = r2.j;
        if (r7 == null) goto L22;
        r7.dispose();
    L22:
        r2.m = null;
    L23:
        this.k.i1(this);
        this.b.clear();
        MultiChannelOptManager r8 = this.f;
        com.bytedance.android.live.revenuelink.rtc.i r9 = r8.h;
        if (r9 == null) goto L26;
        r9.i1(r8.f);
    L26:
        r8.b.dispose();
        com.bytedance.android.live.revlink.impl.multianchor.utils.b r10 = this.g;
        r10.d.clear();
        i11.b r12 = r10.b;
        if (r12 == null) goto L29;
        r12.l(r10.e);
    L29:
        r10.a.dispose();
        com.bytedance.android.live.revlink.impl.global.c r13 = r10.i;
        if (r13 == null) goto L32;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r14 = r13.Q1();
    L33:
        if (r14 == null) goto L37;
        LiveData<List<af2.b>> r15 = r14.getScoreState();
        if (r15 == null) goto L37;
        r15.removeObserver(r10.h);
    L37:
        com.bytedance.android.live.revlink.impl.global.c r16 = r10.i;
        if (r16 == null) goto L40;
        r3 = r16.Ig();
    L40:
        if (r3 == null) goto L45;
        LiveData<PkBaseStateMachine.c> r17 = r3.getPkBaseState();
        if (r17 == null) goto L45;
        r17.removeObserver(r10.g);
    L45:
        if (this.j.j == true) goto L54;
        com.bytedance.android.live.revlink.link.biz.service.i.d0(this).getClass();
        if (this.k.isEngineOn() == false) goto L49;
        w("anchorLinkFinish");
    L49:
        this.m.c("unusual_leave", false, com.bytedance.android.live.revlink.link.biz.service.i.Z(this).o());
        com.bytedance.android.live.revlink.impl.control.d r18 = com.bytedance.android.live.revlink.link.biz.service.i.e(this);
        if (r18 == null) goto L52;
        r18.reset();
    L52:
        getContext().getCommonService().i();
        return;
    L54:
        return;
    L32:
        r14 = null;
        goto L33
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    public final AnchorRtcConnectModel j() {
        return getContext().Hb();
    }

    public final UnexpectedFrameMonitor k() {
        MultiLinkAnchorControlContext r0 = com.bytedance.android.live.revlink.link.biz.service.i.G(this);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getUnexpectedFrameMonitor();
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void o() {
        AnchorRtcConnectModel r0 = j();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L9:
        com.bytedance.android.live.revlink.impl.multianchor.utils.b r2 = this.g;
        r2.getClass();
        Intrinsics.checkNotNullParameter("rtcStartSuccess", "reqFrom");
        com.bytedance.android.live.revlink.impl.global.c r4 = r2.i;
        LinkCrossRoomDataHolder r5 = null;
        if (r4 == null) goto L12;
        LinkCrossRoomDataHolder r6 = r4.getLinkCrossRoomDataHolder();
    L13:
        if (r6 == null) goto L15;
        String r7 = r6.e();
    L16:
        if (r7 != null) goto L18;
    L21:
        if (r1 == false) goto L33;
        com.bytedance.android.live.revlink.impl.global.c r3 = r2.i;
        if (r3 == null) goto L33;
        com.bytedance.android.live.revlink.impl.multianchor.utils.d r8 = r3.of();
        if (r8 == null) goto L33;
        Intrinsics.checkNotNullParameter("rtcStartSuccess", "reqFrom");
        LinkedHashMap r9 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r10 = r8.d;
        if (r10 == null) goto L29;
        r5 = r10.getLinkCrossRoomDataHolder();
    L29:
        if (r5 == null) goto L31;
        String r12 = r5.e();
    L32:
        r9.put("error_msg", "rtcStartSuccess_".concat(r12));
        r8.c("invalid_linkmic_id_during_link", r9);
        goto L33
    L31:
        r12 = "null";
    L33:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.a r13 = this.d;
        if (r13 == null) goto L36;
        r13.b();
    L36:
        this.j.r.setValue(Unit.INSTANCE);
        return;
    L18:
        if (r7.length() == 0) goto L21;
        r1 = false;
        goto L21
    L15:
        r7 = null;
        goto L16
    L12:
        r6 = null;
        goto L13
    L5:
        if (r0.enableFirstFrameOpt() != true) goto L9;
        g0 r14 = com.bytedance.android.live.revlink.link.biz.service.i.f0(this);
        r14.getClass();
        JSONObject r15 = new JSONObject();
        v r16 = r14.o();
        if (r16 == null) goto L9;
        r16.I("pre_push_rtc_start_success_in_link", r15, true);
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.i;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.j
    public final void i(vc0.a r5) {
        Object r0 = r5.b;
        if ((r0 instanceof xh6.c) == true) goto L5;
        xh6.c r6 = vh6.c.b(fr2.g0.class).o6().e(Reflection.getOrCreateKotlinClass(fr2.n.class), r5.a);
        if ((r6 instanceof fr2.n) == true) goto L11;
        r6 = null;
    L11:
        fr2.n r1 = (fr2.n) r6;
    L12:
        com.bytedance.android.live.revenuelink.rtc.i r7 = this.k;
        IRoomBase r2 = this.n.getRoomContext().getCommonRoom();
        if ((r2 instanceof IRoom) == true) goto L15;
        r2 = null;
    L15:
        AnchorRtcConnectUtilsKt.c(r7, r1, (IRoom) r2, null);
        if (r1 == null) goto L19;
        r1.V3(this.o);
        return;
    L19:
        return;
    L5:
        if ((r0 instanceof fr2.n) == true) goto L7;
        r0 = null;
    L7:
        r1 = (fr2.n) r0;
        goto L12
    }

    public final boolean n(long r6) {
        long r0 = 0;
        if (r6 == 0) goto L6;
        return true;
    L6:
        RelinkDataContext r7 = com.bytedance.android.live.revlink.link.biz.service.i.X(this);
        if (r7 == null) goto L9;
        r0 = r7.getRelinkSuccessTimestamp();
    L9:
        i97.a r8 = i97.a.a;
        long r9 = (SystemClock.elapsedRealtime() - r0) / ((long) WebcastRedirectException.UNKNOWN);
        y41.f r1 = y41.f.N;
        r1.getClass();
        ReadOnlyProperty r2 = y41.f.B;
        KProperty[] r3 = y41.f.a;
        if (r9 >= ((Number) r2.getValue(r1, r3[26])).longValue()) goto L13;
        return false;
    L13:
        r1.getClass();
        return ((Boolean) y41.f.A.getValue(r1, r3[25])).booleanValue();
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void onUserJoined(String r13) {
        Intrinsics.checkNotNullParameter(r13, "interactId");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.a r1 = this.d;
        if (r1 == null) goto L47;
        Intrinsics.checkNotNullParameter(r13, "interactId");
        i11.b r0 = r1.a;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.link.model.p r2 = r0.v(r13);
    L8:
        if (r2 == null) goto L47;
        com.bytedance.android.livesdk.link.model.bridge.j r5 = com.bytedance.android.livesdk.link.model.q.b(r2);
        if (r5 == null) goto L47;
        boolean r9 = r5.getUseBackupStream();
        if (r1.a(r5.getMainLinkMicId()) == false) goto L14;
    L17:
        boolean r10 = true;
    L19:
        if (Intrinsics.areEqual(r13, r5.getMainLinkMicId()) == false) goto L32;
        com.bytedance.android.live.revenuelink.rtc.i r6 = r1.b;
        if (r6 == null) goto L23;
        r6.D1(r13, r9, "onMainUserJoin");
    L23:
        com.bytedance.android.live.revenuelink.rtc.i r7 = r1.b;
        if (r7 == null) goto L32;
        if (r9 == true) goto L29;
        if (r10 == true) goto L29;
        boolean r8 = false;
    L30:
        r7.h(r13, r8, "onMainUserJoin");
    L29:
        r8 = true;
    L32:
        if (Intrinsics.areEqual(r13, r5.getBackupLinkMicId()) == false) goto L44;
        com.bytedance.android.live.revenuelink.rtc.i r12 = r1.b;
        if (r12 == null) goto L36;
        r12.D1(r13, !r9, "onBackupUserJoin");
    L36:
        com.bytedance.android.live.revenuelink.rtc.i r14 = r1.b;
        if (r14 == null) goto L44;
        if (r9 == false) goto L42;
        if (r10 == true) goto L42;
        boolean r15 = false;
    L43:
        r14.h(r13, r15, "onBackupUserJoin");
    L42:
        r15 = true;
    L44:
        jy0.b.c("ttlive_anchor_link_switch_stream", "onRtcUserJoin " + r13 + " manualMute=" + r10 + ' ' + r2.toSimpleString(), null, 4);
        v r16 = r1.d;
        if (r16 == null) goto L47;
        r16.C(r5.toString(), r2.toSimpleString(), r9, r10, "rtcUserJoin");
        goto L47
    L14:
        if (r1.a(r5.getBackupLinkMicId()) == true) goto L17;
        r10 = false;
        goto L19
    L7:
        r2 = null;
    L47:
        y41.c r3 = y41.c.e;
        r3.getClass();
        if (((Boolean) y41.c.d.getValue(r3, y41.c.a[2])).booleanValue() == false) goto L62;
        cy0.e.a.getClass();
        cy0.j r4 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r4).b(er2.b.class);
        Intrinsics.checkNotNull(r17);
        iq2.b r18 = ((com.bytedance.live.kmp.core.c) r17).getChorusService();
        if (r18 != null) goto L52;
        return;
    L52:
        if (r18.e() != true) goto L64;
        com.bytedance.android.live.revenuelink.rtc.o r19 = this.k.L().k(r13);
        if (r19 != null) goto L56;
        return;
    L56:
        if (r19.j != true) goto L66;
        com.bytedance.android.live.revenuelink.rtc.i r20 = this.k;
        if (r13 != null) goto L60;
        r13 = "";
    L60:
        r20.b0(r13, 0, "multiBackupMute");
        return;
    L66:
        return;
    L64:
        return;
    }

    public final void w(String r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r1).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r0);
        w r2 = ((com.bytedance.live.kmp.core.c) r0).M1();
        if (r2 == null) goto L5;
        int r3 = r2.w();
    L6:
        if (r3 <= 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        this.k.o1();
        return;
    L11:
        this.k.T1(r4, false);
        return;
    L8:
        r5 = false;
        goto L9
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void R(long r2, Exception r4) {
        this.m.c("rtc_start_error", false, DataType.FALSE);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void X0(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r0 = getContext();
        if (r0 == null) goto L12;
        RevLinkWindowRegionContext r1 = r0.P8();
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r4 = r1.getPartnerService();
        if (r4 == null) goto L14;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r5 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r4.getValue();
        if (r5 == null) goto L15;
        r5.X0(r2, r3);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void e1(String r19, long r20) {
        this.l.b(r19);
        long r4 = 0;
        if (r20 != 0) goto L5;
        String r6 = "rtc_offline_callback_0";
    L83:
        String r13 = r6;
        Iterator r7 = ((CopyOnWriteArrayList) com.bytedance.android.live.revlink.link.biz.service.i.t(this).a).iterator();     // Catch: Exception -> L80
    L8:
        if (r7.hasNext() == false) goto L24;
        com.bytedance.android.livesdk.link.model.p r8 = (com.bytedance.android.livesdk.link.model.p) r7.next();     // Catch: Exception -> L80
        if (com.bytedance.android.livesdk.link.model.q.b(r8) == null) goto L8;
        com.bytedance.android.livesdk.link.model.bridge.j r9 = com.bytedance.android.livesdk.link.model.q.b(r8);     // Catch: Exception -> L80
        if (r9 == null) goto L14;
        String r10 = r9.getMainLinkMicId();     // Catch: Exception -> L80
    L16:
        if (Intrinsics.areEqual(r19, r10) == true) goto L25;
        com.bytedance.android.livesdk.link.model.bridge.j r12 = com.bytedance.android.livesdk.link.model.q.b(r8);     // Catch: Exception -> L80
        if (r12 == null) goto L20;
        String r14 = r12.getBackupLinkMicId();     // Catch: Exception -> L80
    L22:
        if (Intrinsics.areEqual(r19, r14) == false) goto L8;
    L20:
        r14 = null;
    L25:
        if (r8 == null) goto L27;
        com.bytedance.android.livesdk.link.model.bridge.j r15 = com.bytedance.android.livesdk.link.model.q.b(r8);     // Catch: Exception -> L80
    L28:
        if (r15 != null) goto L31;
    L38:
        com.bytedance.android.livesdk.link.model.p r16 = com.bytedance.android.live.revlink.link.biz.service.i.t(this).getGuestInfo(null, r19);     // Catch: Exception -> L80
        if (r16 != null) goto L41;
        r16 = r8;
    L41:
        if (r16 != null) goto L43;
        v r2 = com.bytedance.android.live.revlink.link.biz.service.i.H(this);     // Catch: Exception -> L80
        r2.getClass();     // Catch: Exception -> L80
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Exception -> L80
        r3.put("remote_user_id", r19);     // Catch: Exception -> L80
        r2.b(r3);     // Catch: Exception -> L80
        r2.f(r3);     // Catch: Exception -> L80
        r2.H("rtc_user_leave_not_stop_forward_stream", r3);     // Catch: Exception -> L80
    L76:
        this.f.b("onUserLeaved");     // Catch: Exception -> L80
        UnexpectedFrameMonitor r0 = k();     // Catch: Exception -> L80
        if (r0 == null) goto L91;
        r0.o("onRtcLeave");     // Catch: Exception -> L80
        return;
    L91:
        return;
    L43:
        if (n(r20) == false) goto L62;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r1 = com.bytedance.android.live.revlink.link.biz.service.i.w(this);     // Catch: Exception -> L80
        if (r1 == null) goto L62;
        com.bytedance.android.live.revenuelink.connect.n r5 = r1.getLinkOutManagerFn();     // Catch: Exception -> L80
        if (r5 == null) goto L62;
        long r17 = getContext().G();     // Catch: Exception -> L80
        IBaseUser r18 = r16.getUser();     // Catch: Exception -> L80
        if (r18 == null) goto L51;
        String r110 = r18.getIdString();     // Catch: Exception -> L80
    L52:
        IBaseUser r22 = r16.getUser();     // Catch: Exception -> L80
        if (r22 == null) goto L55;
        Intrinsics.checkNotNullParameter(r22, "$this$secUidExt");     // Catch: Exception -> L80
        String r111 = r22.getCastSecUid();     // Catch: Exception -> L80
    L56:
        IBaseUser r23 = r16.getUser();     // Catch: Exception -> L80
        if (r23 == null) goto L59;
        long r112 = com.bytedance.android.live.base.model.user.n.a(r23);     // Catch: Exception -> L80
    L60:
        r5.j(new d11.e(7, r17, r110, r111, r13, 0, r112, 32));     // Catch: Exception -> L80
        goto L62
    L59:
        r112 = 0;
        goto L60
    L55:
        r111 = null;
        goto L56
    L51:
        r110 = null;
    L62:
        if (this.e == true) goto L76;
        com.bytedance.android.live.revenuelink.rtc.i r24 = this.k;     // Catch: Exception -> L80
        IBaseUser r25 = r16.getUser();     // Catch: Exception -> L80
        if (r25 == null) goto L66;
        long r26 = com.bytedance.android.live.base.model.user.n.a(r25);     // Catch: Exception -> L80
    L67:
        r24.H1(r26, "multiAnchorOnUserLeave");     // Catch: Exception -> L80
        b7 r27 = com.bytedance.android.live.revlink.link.biz.service.i.A(this).f();     // Catch: Exception -> L80
        if (r27 == null) goto L76;
        if (r27.getUseMultiChannel() == false) goto L76;
        Map r28 = r27.getChannelMap();     // Catch: Exception -> L80
        IBaseUser r29 = r16.getUser();     // Catch: Exception -> L80
        if (r29 == null) goto L74;
        r4 = com.bytedance.android.live.base.model.user.n.a(r29);     // Catch: Exception -> L80
    L74:
        r28.remove(Long.valueOf(r4));     // Catch: Exception -> L80
        goto L76
    L66:
        r26 = 0;
        goto L67
    L31:
        if (this.k.L().k(r15.getMainLinkMicId()) == null) goto L33;
    L36:
        jy0.b.c("ttlive_anchor_link_rtc", "important linkMicId leave, do not stopForwardStream " + this.k.L().c() + ' ' + r8.toSimpleString(), null, 4);     // Catch: Exception -> L80
        return;
    L33:
        if (this.k.L().k(r15.getBackupLinkMicId()) != null) goto L36;
        jy0.b.c("ttlive_anchor_link_rtc", "important linkMicId all stream leave, stopForwardStream " + this.k.L().c() + ' ' + r8.toSimpleString(), null, 4);     // Catch: Exception -> L80
        goto L38
    L27:
        r15 = null;
        goto L28
    L14:
        r10 = null;
        goto L16
    L24:
        r8 = null;
    L80:
        e = move-exception;
        int r30 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.c("ttlive_anchor", e);
        return;
    L5:
        r6 = "rtc_offline_callback_1";
        goto L83
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void f0(long r2, Exception r4) {
        this.m.c("rtc_error", false, DataType.FALSE);
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void s(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "message");
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r0 = getContext();
        if (r0 == null) goto L12;
        RevLinkWindowRegionContext r1 = r0.P8();
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r4 = r1.getPartnerService();
        if (r4 == null) goto L14;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r5 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r4.getValue();
        if (r5 == null) goto L15;
        r5.s(r2, r3);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
    public final void J(String[] r4, boolean[] r5, int[] r6) {
        int r7 = 0;
        if (r4 == null) goto L5;
        int r0 = r4.length;
    L6:
        if (r7 >= r0) goto L18;
        if (r4 == null) goto L9;
        String r1 = r4[r7];
    L11:
        if (Intrinsics.areEqual(r1, getContext().Zl()) == false) goto L17;
        if (r5 == null) goto L17;
        if (r5[r7] != true) goto L17;
        getContext().getLiveVideoClientFactory().x0();
        return;
    L17:
        r7 = r7 + 1;
        goto L6
    L9:
        r1 = null;
        goto L11
    L18:
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public final void q(com.bytedance.android.livesdk.link.model.p r16, boolean r17, String r18) {
        Intrinsics.checkNotNullParameter(r18, "reqSrc");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.a r7 = this.d;
        if (r7 == null) goto L52;
        Intrinsics.checkNotNullParameter(r18, "reqSrc");
        StringBuilder r0 = new StringBuilder("selectAnchorTargetStream useBackupStream=");
        r0.append(r17);
        r0.append(", ");
        Unit r1 = null;
        if (r16 == null) goto L7;
        String r2 = r16.toSimpleString();
    L8:
        r0.append(r2);
        r0.append(' ');
        jy0.b.c("ttlive_anchor_link_switch_stream", r0.toString(), null, 4);
        if (r16 == null) goto L44;
        com.bytedance.android.livesdk.link.model.bridge.j r3 = com.bytedance.android.livesdk.link.model.q.b(r16);
        if (r3 == null) goto L44;
        String r8 = r3.getMainLinkMicId();
        String r9 = "";
        if (r8 != null) goto L15;
        r8 = "";
    L15:
        String r10 = r3.getBackupLinkMicId();
        if (r10 == null) goto L20;
        r9 = r10;
    L20:
        if (r7.a(r8) == false) goto L22;
    L25:
        boolean r12 = true;
    L26:
        com.bytedance.android.live.revenuelink.rtc.i r13 = r7.b;
        if (r13 == null) goto L29;
        r13.D1(r8, r17, "selectStream_" + r18);
    L29:
        com.bytedance.android.live.revenuelink.rtc.i r14 = r7.b;
        if (r14 == null) goto L32;
        r14.D1(r9, !r17, "selectStream_" + r18);
    L32:
        if (r12 == true) goto L39;
        com.bytedance.android.live.revenuelink.rtc.i r4 = r7.b;
        if (r4 == null) goto L36;
        r4.h(r8, r17, "selectStream_" + r18);
    L36:
        com.bytedance.android.live.revenuelink.rtc.i r5 = r7.b;
        if (r5 == null) goto L40;
        r5.h(r9, !r17, "selectStream_" + r18);
    L40:
        v r6 = r7.d;
        if (r6 == null) goto L43;
        r6.C(r3.toString(), r16.toSimpleString(), r17, r12, r18);
        r1 = Unit.INSTANCE;
    L43:
        if (r1 == null) goto L44;
        return;
    L39:
        jy0.b.c("ttlive_anchor_link_switch_stream", "do not unmute remote audio since manual mute", null, 4);
        goto L40
    L22:
        if (r7.a(r9) == true) goto L25;
        r12 = false;
    L44:
        v r15 = r7.d;
        if (r15 == null) goto L54;
        if (r16 == null) goto L49;
        String r19 = r16.toSimpleString();
        if (r19 == null) goto L49;
    L50:
        Intrinsics.checkNotNullParameter(r19, "switchStreamContent");
        LinkedHashMap r20 = new LinkedHashMap();
        r20.put("content", r19);
        r15.b(r20);
        r15.H("switch_anchor_stream_link_user_null", r20);
        Unit r22 = Unit.INSTANCE;
        return;
    L49:
        r19 = "null";
        goto L50
    L54:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public MultiRTCBizComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, h r3, com.bytedance.android.live.revenuelink.rtc.i r4, com.bytedance.android.live.revlink.link.domain.service.a r5, MultiBizLifeControlComponent r6, com.bytedance.android.livesdk.revenue.service.room.c r7, com.bytedance.android.live.revlink.link.streaminteract.biz.c r8, MultiAnchorLinkContext r9, yz0.f r10, Function0 r12) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bizDataContext");
        Intrinsics.checkNotNullParameter(r4, "anchorRtcManager");
        Intrinsics.checkNotNullParameter(r5, "muteManager");
        Intrinsics.checkNotNullParameter(r6, "bizLifeControlComponent");
        Intrinsics.checkNotNullParameter(r7, "revRoomService");
        Intrinsics.checkNotNullParameter(r8, "streamMixManager");
        Intrinsics.checkNotNullParameter(r9, "linkContext");
        Intrinsics.checkNotNullParameter(r10, "messageManagerService");
        Intrinsics.checkNotNullParameter(r12, "joinChannelOperation");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        this.n = r7;
        this.o = r8;
        this.p = r9;
        this.q = r10;
        this.r = r12;
        this.a = "MultiRTCBizComponent";
        this.b = new CompositeDisposable();
        this.c = new LinkedHashMap();
        if ((!y41.a.c.a()) == false) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.a r13 = new com.bytedance.android.live.revlink.impl.multianchor.dialog.a(com.bytedance.android.live.revlink.link.biz.service.i.t(this), r4, r5, com.bytedance.android.live.revlink.link.biz.service.i.H(this));
    L6:
        this.d = r13;
        this.e = AnchorRtcConnectUtilsKt.f();
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r14 = getContext();
        getContext().G();
        this.f = new MultiChannelOptManager(r14, r4, getContext().getAnchorLinkUserCenter());
        this.g = new com.bytedance.android.live.revlink.impl.multianchor.utils.b(getContext());
        this.h = new n(this);
        return;
    L5:
        r13 = null;
        goto L6
    }
}
