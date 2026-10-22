package com.bytedance.android.live.revenuelink.connect;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revenuelink.connect.params.TimeOutType;
import com.bytedance.android.livesdk.link.model.a7;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.bridge.j2;
import com.bytedance.android.livesdk.link.model.bridge.n0;
import com.bytedance.android.livesdk.link.model.bridge.r1;
import com.bytedance.android.livesdk.link.model.bridge.s1;
import com.bytedance.android.livesdk.link.model.bridge.t1;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j5;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0002RU\u0018\u0000 q2\u00020\u00012\u00020\u0002:\u0001rB\u001f\u0012\u0006\u0010]\u001a\u00020\\\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010g\u001a\u00020f¢\u0006\u0004\bo\u0010pJ\u0014\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0011j\b\u0012\u0004\u0012\u00020\u000b`\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001dH\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001dH\u0016JX\u0010+\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\r2\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#2\u0014\u0010(\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0004\u0012\u00020\u00060&2\u0014\u0010*\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020\u00060&H\u0016J\u0018\u0010.\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010-\u001a\u00020,H\u0016J<\u00102\u001a\u00020\u00062\u0006\u00100\u001a\u00020/2\u0014\u0010(\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0004\u0012\u00020\u00060&2\u0014\u0010*\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020\u00060&H\u0016J\u0006\u00103\u001a\u00020\u0006R\u0018\u00106\u001a\u000604j\u0002`58\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001e\u0010=\u001a\n\u0018\u00010;j\u0004\u0018\u0001`<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R$\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u000b0?j\b\u0012\u0004\u0012\u00020\u000b`@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR'\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0011j\b\u0012\u0004\u0012\u00020\u000b`\u00128\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR0\u0010I\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020,0Gj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020,`H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JRR\u0010M\u001a>\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00190Kj\b\u0012\u0004\u0012\u00020\u0019`L0Gj\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00190Kj\b\u0012\u0004\u0012\u00020\u0019`L`H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010JRR\u0010N\u001a>\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001d0Kj\b\u0012\u0004\u0012\u00020\u001d`L0Gj\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001d0Kj\b\u0012\u0004\u0012\u00020\u001d`L`H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010JR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\u0015\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010YR\u0016\u0010\u0017\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010[R\u0017\u0010]\u001a\u00020\\8\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0017\u0010b\u001a\u00020a8\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0017\u0010g\u001a\u00020f8\u0006¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u0016\u0010n\u001a\u0004\u0018\u00010k8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010m¨\u0006s"}, d2 = {"Lcom/bytedance/android/live/revenuelink/connect/ConnectDataContext;", "Lcom/bytedance/android/live/revenuelink/connect/f;", "Lcom/bytedance/live/datacontext/DataContext;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "", "onMessage", "startBeInviteTimeOuter", "Lcom/bytedance/android/livesdk/link/model/i6;", "linkerMessage", "Ley/f;", "state", "", "getRefuseReason", "Lcom/bytedance/android/live/revenuelink/connect/k;", "connectStateMonitor", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "connectState", "Lcom/bytedance/android/live/revenuelink/connect/n;", "linkOutManager", "Lcom/bytedance/android/live/revenuelink/connect/l;", "linkInManager", "scene", "Lcom/bytedance/android/live/revenuelink/connect/m;", "listener", "addLinkOutListener", "removeLinkOutListener", "Lcom/bytedance/android/live/revenuelink/connect/i;", "addLinkInListener", "removeLinkInListener", "source", "", "changeForward", "", "reqSrc", "reason", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdk/link/model/bridge/r1;", "onSuccess", "", "onError", "fetchMultiChannelInfo", "Lcom/bytedance/android/live/revenuelink/connect/q;", "strategy", "registerRefuseStrategy", "Ld11/q;", "switchSceneParams", "Lcom/bytedance/android/livesdk/link/model/bridge/j2;", "switchScene", "onStop", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBase;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBase;", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/revenue/platform/api/core/rx/Disposable;", "beInviteTimeouter", "Lio/reactivex/disposables/Disposable;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "_connectState", "Landroidx/lifecycle/MutableLiveData;", "realConnectState", "Landroidx/lifecycle/LiveData;", "getRealConnectState", "()Landroidx/lifecycle/LiveData;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "refuseStrategyMap", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "linkOutListenerMap", "linkInListenerMap", "Lcom/bytedance/android/live/revenuelink/connect/ConnectStateMachine;", "stateMachine", "Lcom/bytedance/android/live/revenuelink/connect/ConnectStateMachine;", "com/bytedance/android/live/revenuelink/connect/ConnectDataContext$e", "linkOutListener", "Lcom/bytedance/android/live/revenuelink/connect/ConnectDataContext$e;", "com/bytedance/android/live/revenuelink/connect/ConnectDataContext$d", "linkInListener", "Lcom/bytedance/android/live/revenuelink/connect/ConnectDataContext$d;", "Lcom/bytedance/android/live/revenuelink/connect/LinkOutManager;", "Lcom/bytedance/android/live/revenuelink/connect/LinkOutManager;", "Lcom/bytedance/android/live/revenuelink/connect/r;", "Lcom/bytedance/android/live/revenuelink/connect/r;", "Lcom/bytedance/android/live/revenuelink/withroom/a;", "linkStoreService", "Lcom/bytedance/android/live/revenuelink/withroom/a;", "getLinkStoreService", "()Lcom/bytedance/android/live/revenuelink/withroom/a;", "Lyz0/f;", "messageService", "Lyz0/f;", "getMessageService", "()Lyz0/f;", "Lyz0/g;", "roomDataService", "Lyz0/g;", "getRoomDataService", "()Lyz0/g;", "Lcom/bytedance/android/live/revenuelink/rtc/f;", "getAnchorLinkRtcService", "()Lcom/bytedance/android/live/revenuelink/rtc/f;", "anchorLinkRtcService", "<init>", "(Lcom/bytedance/android/live/revenuelink/withroom/a;Lyz0/f;Lyz0/g;)V", "Companion", "a", "revenue-link-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ConnectDataContext extends DataContext implements com.bytedance.android.live.revenuelink.connect.f {
    public static final a Companion = null;
    public static final String TAG = "ttlive_anchor_link_connect";
    private final MutableLiveData<ey.f> _connectState;
    private Disposable beInviteTimeouter;
    private final CompositeDisposable cd;
    private final d linkInListener;
    private HashMap<Integer, ArrayList<i>> linkInListenerMap;
    private r linkInManager;
    private final e linkOutListener;
    private HashMap<Integer, ArrayList<m>> linkOutListenerMap;
    private LinkOutManager linkOutManager;
    private final com.bytedance.android.live.revenuelink.withroom.a linkStoreService;
    private final yz0.f messageService;
    private final LiveData<ey.f> realConnectState;
    private final HashMap<Integer, q> refuseStrategyMap;
    private final IRoomBase room;
    private final yz0.g roomDataService;
    private final ConnectStateMachine stateMachine;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenuelink.connect.ConnectDataContext$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(ConnectDataContext r8) {
            super(1, r8, ConnectDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ConnectDataContext.access$onMessage((ConnectDataContext) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ConnectDataContext a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;
        public final /* synthetic */ long e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ Function1 g;

        public b(ConnectDataContext r1, String r2, String r3, long r4, long r6, boolean r8, Function1 r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
            this.f = r8;
            this.g = r9;
        }

        public final void accept(Object r14) {
            ExtraResponse r15 = (ExtraResponse) r14;
            StringBuilder r0 = new StringBuilder("fetchMultiChannelInfo success reqSrc=");
            r0.append(this.b);
            r0.append(" reason=");
            r0.append(this.c);
            r0.append(", resp:");
            s1 r1 = ((a7) r15.data).getMultiChannel();
            com.bytedance.android.live.revenuelink.rtc.i r2 = null;
            if (r1 == null) goto L5;
            String r3 = t1.a(r1);
        L6:
            r0.append(r3);
            r0.append(" logId=");
            r0.append(r15.logId);
            jy0.b.c(ConnectDataContext.TAG, r0.toString(), null, 4);
            com.bytedance.android.live.revenuelink.withroom.a r4 = this.a.getLinkStoreService();
            if (r4 == null) goto L11;
            o r5 = r4.z8();
            if (r5 == null) goto L11;
            long r6 = this.d;
            String r7 = String.valueOf(this.b);
            String r8 = this.c;
            i97.a r9 = i97.a.a;
            o.a.a(r5, r6, r7, r8, System.currentTimeMillis() - this.e, (a7) r15.data, null, 32);
        L11:
            a7 r10 = (a7) r15.data;
            if (r10 == null) goto L33;
            s1 r12 = r10.getMultiChannel();
            if (r12 == null) goto L33;
            if (r12.getUseMultiChannel() == false) goto L33;
            if (this.f == false) goto L33;
            com.bytedance.android.live.revenuelink.rtc.f r13 = ConnectDataContext.access$getAnchorLinkRtcService$p(this.a);
            if (r13 == null) goto L23;
            r2 = r13.getRtcManager();
        L23:
            if (r2 != null) goto L25;
        L29:
            Map<Long, String> r16 = r12.getChannelMap();
            if (r16 == null) goto L33;
            if (r2 == null) goto L33;
            r2.c1(r16, "getCrossRoomRtcInfo", String.valueOf(this.d));
            goto L33
        L25:
            if (r2.g0() != true) goto L29;
            Map r17 = r12.getChannelMap();
            if (r17 == null) goto L33;
            r2.a1(MapsKt.toMutableMap(r17), "getCrossRoomRtcInfo", String.valueOf(this.d));
        L33:
            this.g.invoke(r15.data);
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ConnectDataContext a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ Function1 f;

        public c(ConnectDataContext r1, long r2, String r4, String r5, long r6, Function1 r8) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r8;
        }

        public final void accept(Object r12) {
            Throwable r13 = (Throwable) r12;
            com.bytedance.android.live.revenuelink.withroom.a r0 = this.a.getLinkStoreService();
            if (r0 == null) goto L7;
            o r1 = r0.z8();
            if (r1 == null) goto L7;
            long r2 = this.b;
            String r3 = String.valueOf(this.c);
            String r4 = this.d;
            i97.a r5 = i97.a.a;
            o.a.a(r1, r2, r3, r4, System.currentTimeMillis() - this.e, null, r13, 16);
        L7:
            this.f.invoke(r13);
        }
    }

    public static final class d extends com.bytedance.android.live.revenuelink.connect.c {
        public final /* synthetic */ ConnectDataContext a;

        public d(ConnectDataContext r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.c, com.bytedance.android.live.revenuelink.connect.i
        public final void Z2(fy.d r4) {
            Intrinsics.checkNotNullParameter(r4, "finishParams");
            Intrinsics.checkNotNullParameter(r4, "finishParams");
            ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.h(0));
            ArrayList r0 = (ArrayList) ConnectDataContext.access$getLinkInListenerMap$p(this.a).get(Integer.valueOf(r4.b));
            if (r0 == null) goto L8;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((i) r1.next()).Z2(r4);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.c, com.bytedance.android.live.revenuelink.connect.i
        public final void h3(fy.f r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r3, "joinChannelParams");
            Intrinsics.checkNotNullParameter(r3, "joinChannelParams");
            ArrayList r0 = (ArrayList) ConnectDataContext.access$getLinkInListenerMap$p(this.a).get(Integer.valueOf(r3.b));
            if (r0 == null) goto L8;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((i) r1.next()).h3(r3, r4);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.c, com.bytedance.android.live.revenuelink.connect.i
        public final void i3(fy.d r4, Throwable r5) {
            Intrinsics.checkNotNullParameter(r4, "finishParams");
            Intrinsics.checkNotNullParameter(r4, "finishParams");
            ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.h(0));
            ArrayList r0 = (ArrayList) ConnectDataContext.access$getLinkInListenerMap$p(this.a).get(Integer.valueOf(r4.b));
            if (r0 == null) goto L8;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((i) r1.next()).i3(r4, r5);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.c, com.bytedance.android.live.revenuelink.connect.i
        public final void k3(fy.h r4, ExtraResponse<n0, Extra> r5) {
            Intrinsics.checkNotNullParameter(r4, "leaveParams");
            Intrinsics.checkNotNullParameter(r4, "leaveParams");
            ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.h(0));
            ArrayList r0 = (ArrayList) ConnectDataContext.access$getLinkInListenerMap$p(this.a).get(Integer.valueOf(r4.b));
            if (r0 == null) goto L8;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((i) r1.next()).k3(r4, r5);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.c, com.bytedance.android.live.revenuelink.connect.i
        public final void m2(fy.h r4, Throwable r5) {
            Intrinsics.checkNotNullParameter(r4, "leaveParams");
            Intrinsics.checkNotNullParameter(r4, "leaveParams");
            ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.h(0));
            ArrayList r0 = (ArrayList) ConnectDataContext.access$getLinkInListenerMap$p(this.a).get(Integer.valueOf(r4.b));
            if (r0 == null) goto L8;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((i) r1.next()).m2(r4, r5);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.c, com.bytedance.android.live.revenuelink.connect.i
        public final void m3(fy.f r4, ExtraResponse<com.bytedance.android.livesdk.link.model.bridge.f, Extra> r5) {
            Intrinsics.checkNotNullParameter(r4, "joinChannelParams");
            Intrinsics.checkNotNullParameter(r5, "response");
            super.m3(r4, r5);
            ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.g(r4, (com.bytedance.android.livesdk.link.model.bridge.f) r5.data));
            ArrayList r0 = (ArrayList) ConnectDataContext.access$getLinkInListenerMap$p(this.a).get(Integer.valueOf(r4.b));
            if (r0 == null) goto L8;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((i) r1.next()).m3(r4, r5);
            goto L6
        L10:
            return;
        }
    }

    public static final class e implements j {
        public final /* synthetic */ ConnectDataContext a;

        public e(ConnectDataContext r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void A3(d11.d r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            ArrayList r0 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r3.a));
            if (r0 == null) goto L8;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((m) r1.next()).A3(r3);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void M2(d11.b r6) {
            Intrinsics.checkNotNullParameter(r6, "params");
            ConnectStateMachine r0 = ConnectDataContext.access$getStateMachine$p(this.a);
            IBaseUser r3 = r6.h.getOwnerKt();
            if (r3 == null) goto L5;
            String r4 = iz.a.a(r3);
        L6:
            r0.a(new ey.e.n(new d11.r(r4, TimeOutType.Apply_Time_Out)));
            ArrayList r1 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r6.a));
            if (r1 == null) goto L12;
            Iterator r2 = r1.iterator();
        L10:
            if (r2.hasNext() == false) goto L14;
            ((m) r2.next()).M2(r6);
            goto L10
        L14:
            return;
        L12:
            return;
        L5:
            r4 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void Q4(d11.d r6) {
            Intrinsics.checkNotNullParameter(r6, "params");
            ConnectStateMachine r0 = ConnectDataContext.access$getStateMachine$p(this.a);
            IRoom r3 = r6.h;
            if (r3 == null) goto L7;
            IBaseUser r4 = r3.getOwnerKt();
            if (r4 == null) goto L7;
            String r5 = iz.a.a(r4);
        L8:
            r0.a(new ey.e.n(new d11.r(r5, TimeOutType.Invite_Time_Out)));
            ArrayList r1 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r6.a));
            if (r1 == null) goto L14;
            Iterator r2 = r1.iterator();
        L12:
            if (r2.hasNext() == false) goto L16;
            ((m) r2.next()).Q4(r6);
            goto L12
        L16:
            return;
        L14:
            return;
        L7:
            r5 = null;
            goto L8
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void X4(i6 r6) {
            Intrinsics.checkNotNullParameter(r6, "_linkerMessage");
            i6 r7 = r6.castTo(i6.class);
            ey.l r0 = ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.b(r7, null));
            ArrayList r1 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf((int) i1.b(r7)));
            if (r1 == null) goto L8;
            Iterator r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L10;
            m r3 = (m) r2.next();
            Intrinsics.checkNotNullParameter(r7, "$this$sceneExt");
            r3.Je((int) r7.getScene(), r7, r0);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void Y4(i6 r14) {
            Intrinsics.checkNotNullParameter(r14, "_linkerMessage");
            i6 r15 = r14.castTo(i6.class);
            LiveData<ey.f> r0 = this.a.getRealConnectState();
            if (r0 == null) goto L30;
            ey.f r1 = (ey.f) r0.getValue();
            if (r1 == null) goto L30;
            long r2 = r1.a;
            if (r2 == 0) goto L30;
            if (r2 == i1.a(r15)) goto L30;
            LinkOutManager r3 = ConnectDataContext.access$getLinkOutManager$p(this.a);
            Intrinsics.checkNotNullParameter(r15, "$this$linkerIdExt");
            long r4 = r15.getLinkerId();
            IRoomBase r5 = ConnectDataContext.access$getRoom$p(this.a);
            if (r5 == null) goto L13;
            Long r6 = Long.valueOf(IRoomKtKt.getId(r5));
        L14:
            long r7 = r6.longValue();
            g1 r8 = r15.getInvite();
            if (r8 == null) goto L17;
            g1 r9 = r8;
            Intrinsics.checkNotNullParameter(r9, "$this$fromUid");
            String r10 = r9.get_fromUid();
        L18:
            g1 r12 = r15.getInvite();
            if (r12 == null) goto L21;
            g1 r13 = r12;
            Intrinsics.checkNotNullParameter(r13, "$this$secFromUid");
            String r16 = r13.get_secFromUid();
        L22:
            e6 r17 = r15.getInvite();
            if (r17 == null) goto L27;
            j5 r18 = r17.getFromLinkMicInfo();
            if (r18 == null) goto L27;
            String r19 = r18.getInteractIdStr();
        L28:
            r3.k(new d11.f(7, r4, 2, r7, r10, r16, r19), null);
            return;
        L27:
            r19 = null;
            goto L28
        L21:
            r16 = null;
            goto L22
        L17:
            r10 = null;
            goto L18
        L13:
            r6 = null;
        L30:
            ArrayList r20 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf((int) i1.b(r15)));
            if (r20 == null) goto L39;
            Iterator r22 = r20.iterator();
        L34:
            if (r22.hasNext() == false) goto L43;
            m r23 = (m) r22.next();
            Intrinsics.checkNotNullParameter(r15, "$this$sceneExt");
            int r24 = (int) r15.getScene();
            ey.f.d r25 = (ey.f) ConnectDataContext.access$get_connectState$p(this.a).getValue();
            if (r25 != null) goto L38;
            r25 = new ey.f.d(0);
        L38:
            r23.jo(r24, r15, new ey.l.b(r25));
            goto L34
        L43:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void Z3(d11.g r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            ArrayList r0 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r3.a));
            if (r0 == null) goto L8;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((m) r1.next()).Z3(r3);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void Z4(i6 r33) {
            Intrinsics.checkNotNullParameter(r33, "_linkerMessage");
            i6 r1 = r33.castTo(i6.class);
            Iterator r2 = ConnectDataContext.access$getRefuseStrategyMap$p(this.a).entrySet().iterator();
            int r4 = 0;
        L4:
            if (r2.hasNext() == false) goto L7;
            r4 = ((q) ((Map.Entry) r2.next()).getValue()).a(r1, (ey.f) this.a.getRealConnectState().getValue());
            if (r4 == 0) goto L4;
        L7:
            cy0.e.a.getClass();
            cy0.j r5 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r3 = com.bytedance.android.scope.m.b(r5).b(IRevBroadcastService.class);
            Intrinsics.checkNotNull(r3);
            if (((com.bytedance.live.kmp.core.c) r3).rejectPkWhenReceiveCloudGroupLiveInvite() == false) goto L10;
            r4 = 13;
        L10:
            if (r4 != 0) goto L12;
            ConnectDataContext r6 = this.a;
            r4 = ConnectDataContext.access$getRefuseReason(r6, r1, (ey.f) r6.getRealConnectState().getValue());
        L12:
            int r12 = r4;
            if (r12 != (-1)) goto L16;
            return;
        L16:
            if (r12 != 0) goto L23;
            ey.l r7 = ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.e(r1));
            ArrayList r8 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf((int) i1.b(r1)));
            if (r8 == null) goto L45;
            Iterator r9 = r8.iterator();
        L21:
            if (r9.hasNext() == false) goto L46;
            m r10 = (m) r9.next();
            Intrinsics.checkNotNullParameter(r1, "$this$sceneExt");
            r10.ej((int) r1.getScene(), r1, r7);
            goto L21
        L46:
            return;
        L45:
            return;
        L23:
            e6 r13 = r1.getInvite();
            if (r13 == null) goto L26;
            int r14 = r13.getBizType();
        L27:
            LinkOutManager r15 = ConnectDataContext.access$getLinkOutManager$p(this.a);
            Intrinsics.checkNotNullParameter(r1, "$this$sceneExt");
            int r16 = (int) r1.getScene();
            Intrinsics.checkNotNullParameter(r1, "$this$linkerIdExt");
            long r17 = r1.getLinkerId();
            IRoomBase r18 = ConnectDataContext.access$getRoom$p(this.a);
            if (r18 == null) goto L30;
            Long r19 = Long.valueOf(IRoomKtKt.getId(r18));
        L31:
            long r110 = r19.longValue();
            g1 r20 = r1.getInvite();
            if (r20 == null) goto L34;
            g1 r22 = r20;
            Intrinsics.checkNotNullParameter(r22, "$this$fromUid");
            String r111 = r22.get_fromUid();
        L35:
            g1 r23 = r1.getInvite();
            if (r23 == null) goto L38;
            g1 r24 = r23;
            Intrinsics.checkNotNullParameter(r24, "$this$secFromUid");
            String r25 = r24.get_secFromUid();
        L39:
            r15.h(new d11.g(r16, r14, r17, r110, r12, r111, r25, null, null, new d11.a(0, 0, 0, null, false, false, false, "autoReject", 0, null, null, null, 3967), null, null, null, null, 15744), null);
            return;
        L38:
            r25 = null;
            goto L39
        L34:
            r111 = null;
            goto L35
        L30:
            r19 = null;
            goto L31
        L26:
            r14 = 0;
            goto L27
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void b5(i6 r7) {
            Intrinsics.checkNotNullParameter(r7, "_linkerMessage");
            i6 r8 = r7.castTo(i6.class);
            int r1 = (int) r8.getType2();
            if (r1 != 5) goto L5;
            ey.l r0 = ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.k(r8));
        L9:
            HashMap r2 = ConnectDataContext.access$getLinkOutListenerMap$p(this.a);
            Intrinsics.checkNotNullParameter(r8, "$this$sceneExt");
            ArrayList r3 = (ArrayList) r2.get(Integer.valueOf((int) r8.getScene()));
            if (r3 == null) goto L15;
            Iterator r4 = r3.iterator();
        L13:
            if (r4.hasNext() == false) goto L17;
            m r5 = (m) r4.next();
            Intrinsics.checkNotNullParameter(r8, "$this$sceneExt");
            r5.Tg((int) r8.getScene(), r8, r0);
            goto L13
        L17:
            return;
        L15:
            return;
        L5:
            if (r1 == 8) goto L7;
            r0 = null;
            goto L9
        L7:
            r0 = ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.i(r8));
            goto L9
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void Y1(d11.c r3, long r4) {
            Intrinsics.checkNotNullParameter(r3, "params");
            ArrayList r0 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r3.a));
            if (r0 == null) goto L8;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((m) r1.next()).Y1(r3, r4);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void Z1(d11.e r3, long r4) {
            Intrinsics.checkNotNullParameter(r3, "params");
            ArrayList r0 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r3.a));
            if (r0 == null) goto L8;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((m) r1.next()).Z1(r3, r4);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void d5(d11.c r4, long r5) {
            Intrinsics.checkNotNullParameter(r4, "params");
            ey.l r0 = ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.b(null, r4));
            ArrayList r1 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r4.a));
            if (r1 == null) goto L8;
            Iterator r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L10;
            ((m) r2.next()).q9(r4, r5, r0);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void O1(d11.e r3, Throwable r4, long r5) {
            Intrinsics.checkNotNullParameter(r3, "params");
            ArrayList r0 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r3.a));
            if (r0 == null) goto L8;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((m) r1.next()).O1(r3, r4, r5);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void R4(d11.g r9, q5 r10, long r12) {
            Intrinsics.checkNotNullParameter(r9, "params");
            Intrinsics.checkNotNullParameter(r10, "replyResult");
            ey.l r0 = ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.l(r9, r10));
            ArrayList r1 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r9.a));
            if (r1 == null) goto L8;
            Iterator r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L10;
            ((m) r2.next()).nf(r9, r10, r12, r0);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void S4(d11.c r10, Throwable r12, long r13) {
            Intrinsics.checkNotNullParameter(r10, "params");
            ey.l r0 = ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.b(null, r10));
            ArrayList r1 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r10.a));
            if (r1 == null) goto L8;
            Iterator r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L10;
            ((m) r2.next()).wh(r10, r12, r13, r0);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void T4(d11.g r10, Throwable r12, long r13) {
            Intrinsics.checkNotNullParameter(r10, "params");
            ey.l r0 = ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.l(r10, null));
            ArrayList r1 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r10.a));
            if (r1 == null) goto L8;
            Iterator r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L10;
            ((m) r2.next()).Cn(r10, r12, r13, r0);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void U4(d11.f r9, com.bytedance.android.livesdk.link.model.v r10, long r12) {
            Intrinsics.checkNotNullParameter(r9, "params");
            Intrinsics.checkNotNullParameter(r10, "permitData");
            ey.l r0 = ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.j(r9, r10));
            ArrayList r1 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r9.a));
            if (r1 == null) goto L8;
            Iterator r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L10;
            ((m) r2.next()).Jd(r9, r10, r12, r0);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void V4(d11.d r9, Throwable r10, long r12) {
            Intrinsics.checkNotNullParameter(r9, "params");
            ArrayList r0 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r9.a));
            if (r0 == null) goto L11;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L15;
            m r2 = (m) r1.next();
            ey.f.d r3 = (ey.f) ConnectDataContext.access$get_connectState$p(this.a).getValue();
            if (r3 != null) goto L10;
            r3 = new ey.f.d(0);
        L10:
            r2.rp(r9, r10, r12, new ey.l.b(r3));
            goto L6
        L15:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void W4(d11.b r9, Throwable r10, long r12) {
            Intrinsics.checkNotNullParameter(r9, "params");
            ArrayList r0 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r9.a));
            if (r0 == null) goto L11;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L15;
            m r2 = (m) r1.next();
            ey.f.d r3 = (ey.f) ConnectDataContext.access$get_connectState$p(this.a).getValue();
            if (r3 != null) goto L10;
            r3 = new ey.f.d(0);
        L10:
            r2.Vc(r9, r10, r12, new ey.l.b(r3));
            goto L6
        L15:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void a5(d11.d r9, long r10, v4 r12) {
            Intrinsics.checkNotNullParameter(r9, "params");
            Intrinsics.checkNotNullParameter(r12, "inviteResult");
            ey.l r0 = ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.f(r9, r12));
            ArrayList r1 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r9.a));
            if (r1 == null) goto L8;
            Iterator r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L10;
            ((m) r2.next()).hl(r9, r10, r12, r0);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void c5(d11.f r9, Throwable r10, long r12) {
            Intrinsics.checkNotNullParameter(r9, "params");
            ArrayList r0 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r9.a));
            if (r0 == null) goto L11;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L15;
            m r2 = (m) r1.next();
            ey.f.d r3 = (ey.f) ConnectDataContext.access$get_connectState$p(this.a).getValue();
            if (r3 != null) goto L10;
            r3 = new ey.f.d(0);
        L10:
            r2.pp(r9, r10, r12, new ey.l.b(r3));
            goto L6
        L15:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.j
        public final void e5(d11.b r9, com.bytedance.android.livesdk.link.model.f r10, long r12) {
            Intrinsics.checkNotNullParameter(r9, "params");
            Intrinsics.checkNotNullParameter(r10, "applyResult");
            ey.l r0 = ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.a(r9));
            ArrayList r1 = (ArrayList) ConnectDataContext.access$getLinkOutListenerMap$p(this.a).get(Integer.valueOf(r9.a));
            if (r1 == null) goto L8;
            Iterator r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L10;
            ((m) r2.next()).O8(r9, r10, r12, r0);
            goto L6
        L10:
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ ConnectDataContext a;

        public g(ConnectDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            ConnectDataContext.access$getStateMachine$p(this.a).a(new ey.e.n(new d11.r(null, TimeOutType.Be_Invite_Time_Out)));
        }
    }

    static {
        Companion = new a();
    }

    private final k connectStateMonitor() {
        return this.linkStoreService.z0();
    }

    private final com.bytedance.android.live.revenuelink.rtc.f getAnchorLinkRtcService() {
        return this.linkStoreService.m0();
    }

    private final void startBeInviteTimeOuter() {
        Disposable r0 = this.beInviteTimeouter;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        com.bytedance.revenue.platform.api.core.rx.l r1 = com.bytedance.revenue.platform.api.core.rx.l.a;
        u0 r2 = u0.f;
        long r3 = u0.a.a(h11.a.f.a().S()).a;
        int r4 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Scheduler r5 = Schedulers.computation();
        Disposable r6 = Observable.timer(r3, TimeUnit.MILLISECONDS, r5).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this));
        this.cd.add(r6);
        this.beInviteTimeouter = r6;
    }

    public final void onStop() {
        this._connectState.setValue(new ey.f.d(0));
        LinkOutManager r0 = this.linkOutManager;
        com.bytedance.android.live.revenuelink.multimsg.a r1 = r0.a;
        if (r1 == null) goto L15;
        if (r1.a == false) goto L9;
        com.bytedance.android.live.revenuelink.rtc.i r2 = r1.h;
        if (r2 == null) goto L9;
        r2.i1(r1);
    L9:
        r1.d.clear();
        Iterator<Map.Entry<String, CompositeDisposable>> r3 = r1.f.entrySet().iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        r3.next().getValue().dispose();
        goto L11
    L13:
        r1.f.clear();
        r1.e.clear();
    L15:
        if (r0.b.isDisposed() == true) goto L17;
        r0.b.dispose();
    L17:
        r r4 = this.linkInManager;
        if (r4.a.isDisposed() == true) goto L20;
        r4.a.dispose();
    L20:
        this.cd.dispose();
    }

    @Override // com.bytedance.android.live.revenuelink.connect.f
    public LiveData<ey.f> connectState() {
        return this._connectState;
    }

    public final com.bytedance.android.live.revenuelink.withroom.a getLinkStoreService() {
        return this.linkStoreService;
    }

    public final yz0.f getMessageService() {
        return this.messageService;
    }

    public final LiveData<ey.f> getRealConnectState() {
        return this.realConnectState;
    }

    public final yz0.g getRoomDataService() {
        return this.roomDataService;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.f
    public l linkInManager() {
        return this.linkInManager;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.f
    public n linkOutManager() {
        return this.linkOutManager;
    }

    public static final /* synthetic */ k access$connectStateMonitor(ConnectDataContext r0) {
        return r0.connectStateMonitor();
    }

    public static final /* synthetic */ com.bytedance.android.live.revenuelink.rtc.f access$getAnchorLinkRtcService$p(ConnectDataContext r0) {
        return r0.getAnchorLinkRtcService();
    }

    public static final /* synthetic */ Disposable access$getBeInviteTimeouter$p(ConnectDataContext r0) {
        return r0.beInviteTimeouter;
    }

    public static final /* synthetic */ HashMap access$getLinkInListenerMap$p(ConnectDataContext r0) {
        return r0.linkInListenerMap;
    }

    public static final /* synthetic */ HashMap access$getLinkOutListenerMap$p(ConnectDataContext r0) {
        return r0.linkOutListenerMap;
    }

    public static final /* synthetic */ LinkOutManager access$getLinkOutManager$p(ConnectDataContext r0) {
        return r0.linkOutManager;
    }

    public static final /* synthetic */ HashMap access$getRefuseStrategyMap$p(ConnectDataContext r0) {
        return r0.refuseStrategyMap;
    }

    public static final /* synthetic */ IRoomBase access$getRoom$p(ConnectDataContext r0) {
        return r0.room;
    }

    public static final /* synthetic */ ConnectStateMachine access$getStateMachine$p(ConnectDataContext r0) {
        return r0.stateMachine;
    }

    public static final /* synthetic */ MutableLiveData access$get_connectState$p(ConnectDataContext r0) {
        return r0._connectState;
    }

    public static final /* synthetic */ void access$startBeInviteTimeOuter(ConnectDataContext r0) {
        r0.startBeInviteTimeOuter();
    }

    private final void onMessage(yh6.c r3) {
        if ((r3 instanceof h1) == true) goto L5;
        return;
    L5:
        i6 r4 = ((vh7.c) r3).castTo(i6.class);
        int r1 = (int) i1.c(r4);
        if (r1 != 2) goto L8;
        Intrinsics.checkNotNullParameter(r4, "$this$sceneExt");
        if (((int) r4.getScene()) != 1) goto L16;
        this.stateMachine.a(new ey.e.c(r4));
        return;
    L16:
        return;
    L8:
        if (r1 != 31) goto L17;
        this.stateMachine.a(new ey.e.m(r4));
        return;
    }

    public static final /* synthetic */ void access$onMessage(ConnectDataContext r0, yh6.c r1) {
        r0.onMessage(r1);
    }

    public static final /* synthetic */ void access$setBeInviteTimeouter$p(ConnectDataContext r0, Disposable r1) {
        r0.beInviteTimeouter = r1;
    }

    public static final /* synthetic */ void access$setLinkInListenerMap$p(ConnectDataContext r0, HashMap r1) {
        r0.linkInListenerMap = r1;
    }

    public static final /* synthetic */ void access$setLinkOutListenerMap$p(ConnectDataContext r0, HashMap r1) {
        r0.linkOutListenerMap = r1;
    }

    public static final /* synthetic */ void access$setLinkOutManager$p(ConnectDataContext r0, LinkOutManager r1) {
        r0.linkOutManager = r1;
    }

    private final int getRefuseReason(i6 r7, ey.f r8) {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r0 == null) goto L15;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L15;
        vh7.c r2 = r1.getCommonRoom();
        if (r2 == null) goto L15;
        if (((IRoomLinkExt) ((IRoom) r2).castTo(IRoomLinkExt.class)).getMosaicStatus() != 1) goto L15;
        k r9 = connectStateMonitor();
        if (r9 == null) goto L13;
        r9.c(ConnectAutoRejectType.MOSAIC_STATUS, r7);
    L13:
        return 6;
    L15:
        if (r7.getInvite() != null) goto L20;
        k r10 = connectStateMonitor();
        if (r10 == null) goto L19;
        r10.c(ConnectAutoRejectType.ERROR_IN_MESSAGE, r7);
    L19:
        return 6;
    L20:
        if (r8 != null) goto L22;
        return 0;
    L22:
        if (r8.a == 0) goto L50;
        Intrinsics.checkNotNullParameter(r7, "$this$linkerIdExt");
        if (r7.getLinkerId() != r8.a) goto L26;
        return 0;
    L26:
        if (com.bytedance.android.live.revenuelink.connect.b.a(r7) == true) goto L52;
        int r12 = r8.d;
        if (r12 != 1) goto L30;
        k r13 = connectStateMonitor();
        if (r13 == null) goto L47;
        r13.c(ConnectAutoRejectType.REJECT_IN_INVITING, r7);
    L47:
        return 4;
    L30:
        if (r12 != 2) goto L32;
        k r14 = connectStateMonitor();
        if (r14 == null) goto L47;
        r14.c(ConnectAutoRejectType.REJECT_IN_BE_INVITING, r7);
        goto L47
    L32:
        if (r12 == 3) goto L38;
        if (r12 != 4) goto L47;
        k r15 = connectStateMonitor();
        if (r15 == null) goto L47;
        r15.c(ConnectAutoRejectType.LINKING_NOT_MULTI_INVITE, r7);
        goto L47
    L38:
        k r16 = connectStateMonitor();
        if (r16 == null) goto L47;
        r16.c(ConnectAutoRejectType.REJECT_IN_APPLYING, r7);
        goto L47
    L52:
        return 0;
    L50:
        return 0;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.f
    public void addLinkInListener(int r3, i r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (this.linkInListenerMap.containsKey(Integer.valueOf(r3)) == false) goto L7;
        ArrayList<i> r5 = this.linkInListenerMap.get(Integer.valueOf(r3));
        if (r5 == null) goto L9;
        r5.add(r4);
        return;
    L9:
        return;
    L7:
        ArrayList<i> r0 = new ArrayList();
        r0.add(r4);
        this.linkInListenerMap.put(Integer.valueOf(r3), r0);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.f
    public void addLinkOutListener(int r3, m r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (this.linkOutListenerMap.containsKey(Integer.valueOf(r3)) == false) goto L7;
        ArrayList<m> r5 = this.linkOutListenerMap.get(Integer.valueOf(r3));
        if (r5 == null) goto L9;
        r5.add(r4);
        return;
    L9:
        return;
    L7:
        ArrayList<m> r0 = new ArrayList();
        r0.add(r4);
        this.linkOutListenerMap.put(Integer.valueOf(r3), r0);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.f
    public void registerRefuseStrategy(int r2, q r3) {
        Intrinsics.checkNotNullParameter(r3, "strategy");
        this.refuseStrategyMap.put(Integer.valueOf(r2), r3);
    }

    @Override // com.bytedance.android.live.revenuelink.connect.f
    public void removeLinkInListener(int r2, i r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ArrayList<i> r4 = this.linkInListenerMap.get(Integer.valueOf(r2));
        if (r4 == null) goto L6;
        r4.remove(r3);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.f
    public void removeLinkOutListener(int r2, m r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ArrayList<m> r4 = this.linkOutListenerMap.get(Integer.valueOf(r2));
        if (r4 == null) goto L6;
        r4.remove(r3);
        return;
    }

    public ConnectDataContext(com.bytedance.android.live.revenuelink.withroom.a r12, yz0.f r13, yz0.g r14) {
        Intrinsics.checkNotNullParameter(r12, "linkStoreService");
        Intrinsics.checkNotNullParameter(r13, "messageService");
        Intrinsics.checkNotNullParameter(r14, "roomDataService");
        this.linkStoreService = r12;
        this.messageService = r13;
        this.roomDataService = r14;
        CompositeDisposable r0 = new CompositeDisposable();
        this.cd = r0;
        IRoomBase r15 = r14.mo444getRoom();
        this.room = r15;
        MutableLiveData<ey.f> r7 = new MutableLiveData();
        this._connectState = r7;
        this.realConnectState = r7;
        this.refuseStrategyMap = new HashMap();
        this.linkOutListenerMap = new HashMap();
        this.linkInListenerMap = new HashMap();
        this.stateMachine = new ConnectStateMachine(new ConnectDataContext$stateMachine$1(this));
        e r3 = new e(this);
        this.linkOutListener = r3;
        d r8 = new d(this);
        this.linkInListener = r8;
        LinkOutManager r9 = new LinkOutManager(this, r3, r13, r12, r15);
        com.bytedance.android.live.revenuelink.rtc.f r1 = getAnchorLinkRtcService();
        if (r1 == null) goto L5;
        com.bytedance.android.live.revenuelink.rtc.i r2 = r1.getRtcManager();
    L6:
        com.bytedance.android.live.revenuelink.multimsg.d r4 = new com.bytedance.android.live.revenuelink.multimsg.d(r2, this.messageService);
        yz0.f r5 = r9.g;
        if (r5 == null) goto L13;
        com.bytedance.android.live.revenue.common.message.a r6 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r10 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r6, "$this$LINK_MIC");
        Observable r16 = yz0.h.a.a(r5, (yh6.b) CommonMessageTypeKt.c.getValue(), false, 6);
        if (r16 == null) goto L13;
        final LinkOutManager$attach$1 r17 = new LinkOutManager$attach$1(r9);
        Disposable r18 = r16.subscribe(new v(r17));
        if (r18 == null) goto L13;
        com.bytedance.revenue.platform.api.core.rx.f.a(r18, r9.b);
    L13:
        r9.a = r4;
        com.bytedance.android.live.revenue.common.message.a r19 = com.bytedance.android.live.revenue.common.message.a.g;
        r4.j(CommonMessageTypeKt.a(r19), r9);
        t r20 = new t(r9);
        Intrinsics.checkNotNullParameter(r20, "interceptor");
        if (r4.e.contains(r20) == true) goto L17;
        r4.e.add(r20);
    L17:
        Unit r22 = Unit.INSTANCE;
        this.linkOutManager = r9;
        this.linkInManager = new r(r12, r15, r8);
        if (r13 == null) goto L24;
        Observable r110 = yz0.h.a.a(r13, CommonMessageTypeKt.a(r19), false, 6);
        if (r110 == null) goto L24;
        final AnonymousClass1 r111 = new AnonymousClass1(this);
        Disposable r112 = r110.subscribe(new f(r111));
        if (r112 == null) goto L24;
        com.bytedance.revenue.platform.api.core.rx.f.a(r112, r0);
    L24:
        r7.setValue(new ey.f.d(0));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static final /* synthetic */ int access$getRefuseReason(ConnectDataContext r0, i6 r1, ey.f r2) {
        return r0.getRefuseReason(r1, r2);
    }

    public void switchScene(d11.q r2, Function1<? super j2, Unit> r3, Function1<? super Throwable, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "switchSceneParams");
        Intrinsics.checkNotNullParameter(r3, "onSuccess");
        Intrinsics.checkNotNullParameter(r4, "onError");
        e11.c.a(e11.b.a);
        throw null;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.f
    public void fetchMultiChannelInfo(int r17, boolean r18, String r19, String r20, Function1<? super r1, Unit> r22, Function1<? super Throwable, Unit> r23) {
        Intrinsics.checkNotNullParameter(r22, "onSuccess");
        Intrinsics.checkNotNullParameter(r23, "onError");
        i97.a r0 = i97.a.a;
        long r12 = System.currentTimeMillis();
        ey.f r1 = (ey.f) this.realConnectState.getValue();
        if (r1 == null) goto L5;
        long r2 = r1.a;
    L6:
        long r14 = r2;
        e11.b r3 = e11.c.a(e11.b.a);
        e11.a r4 = (e11.a) r3;
        Observable<ExtraResponse<a7, Extra>> r5 = r4.f(r14, IRoomKtKt.getId(this.room), r17);
        int r6 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r5.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r19, r20, r14, r12, r18, r22), new c(this, r14, r19, r20, r12, r23)), this.cd);
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
