package com.bytedance.android.live.context;

import am2.x;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.observer.ExpBizPerfObserver;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.context.PlatformExpRoomContext;
import com.bytedance.android.live.room.api.experience.log.ExpOptLog;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.keva.Keva;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0017\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b0\u00101J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\f\u001a\u00020\u0003R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R,\u0010$\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0017\u0010'\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/bytedance/android/live/context/LiveExpRoomContext;", "Lcom/bytedance/android/live/room/api/experience/context/PlatformExpRoomContext;", "Ld61/b;", "", "unregisterAllListener", "Ll61/b;", "scene", "Lg61/a;", "listener", "Lio/reactivex/disposables/Disposable;", "registerExpBizListener", "unregisterExpBizListener", "startWork", "", "tag$delegate", "Lkotlin/Lazy;", "getTag", "()Ljava/lang/String;", "tag", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "", "Li61/b;", "producers$delegate", "getProducers", "()Ljava/util/List;", "producers", "Lh90/a;", "dispatch", "Lh90/a;", "getDispatch", "()Lh90/a;", "", "Lkotlin/Pair;", "Lcom/bytedance/android/live/observer/ExpBizPerfObserver;", "bizPerfListeners", "Ljava/util/Map;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "getRoomContext", "()Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;)V", "Companion", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveExpRoomContext extends PlatformExpRoomContext implements d61.b {
    public static final Companion Companion = null;
    private static final String SHARE_TAG = "LiveExpRoomContext";
    private final Map<l61.b, Pair<ExpBizPerfObserver, Disposable>> bizPerfListeners;
    private final CompositeDisposable cd;
    private final DataCenter dataCenter;
    private final h90.a dispatch;
    private final Lazy producers$delegate;
    private final MiddlewareRoomContext roomContext;
    private final Lazy tag$delegate;

    public static final class Companion {
        public Companion() {
        }

        public static d61.b a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(LiveExpRoomContext.SHARE_TAG);
            DataContext r1 = null;
            if (r0 != null) goto L11;
            RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r2 == null) goto L9;
            j r3 = r2.getExpContext();
            if (r3 == null) goto L9;
            r0 = (DataContext) r3.getValue();
        L9:
            r0 = null;
        L11:
            if ((r0 instanceof d61.b) == false) goto L15;
            r1 = r0;
        L15:
            return (d61.b) r1;
        }

        public static void b(final Function1 r5) {
            Intrinsics.checkNotNullParameter(r5, "action");
            d61.b r0 = a();
            if (r0 != null) goto L5;
        L6:
            RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r1 == null) goto L13;
            j r2 = r1.getExpContext();
            if (r2 == null) goto L14;
            r2.c(new LiveExpRoomContext$Companion$useShare$$inlined$run$lambda$1(r5));
            Unit r6 = Unit.INSTANCE;
            return;
        L14:
            return;
        L13:
            return;
        L5:
            if (((Unit) r5.invoke(r0)) == null) goto L6;
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ LiveExpRoomContext a;

        public a(LiveExpRoomContext r1) {
            this.a = r1;
        }

        public final void run() {
            LiveExpRoomContext.access$unregisterAllListener(this.a);
            Iterator<T> r0 = this.a.getProducers().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((i61.b) r0.next()).onRelease();
            goto L4
        L6:
            ExpOptLog r1 = ExpOptLog.c;
            r1.getClass();
            if ((!ExpOptLog.b.isEmpty()) == true) goto L10;
            r1 = null;
        L10:
            if (r1 == null) goto L12;
            ExpOptLog.b(this.a.getDataCenter());
        L12:
            LiveExpRoomContext.access$getCd$p(this.a).clear();
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ Disposable a;
        public final /* synthetic */ LiveExpRoomContext b;
        public final /* synthetic */ l61.b c;
        public final /* synthetic */ g61.a d;

        public b(Disposable r1, LiveExpRoomContext r2, l61.b r3, g61.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void run() {
            this.a.dispose();
            LiveExpRoomContext.access$getBizPerfListeners$p(this.b).remove(this.c);
            Keva r0 = o61.a.a;
            o61.a.d(this.c);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ExpBizPerfObserver a;

        public c(ExpBizPerfObserver r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ExpBizPerfObserver r0 = this.a;
            r0.b((k61.a) r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LiveExpRoomContext a;

        public d(LiveExpRoomContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            SimpleAlogArgsBuilder r4 = new SimpleAlogArgsBuilder();
            r4.d(LiveExpRoomContext.access$getTag$p(this.a));
            r4.c("正式启动降级框架流程");
            ExpOptLog.d(r4.b());
            this.a.getWorkshop().start();
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            SafetyGuard.a(null, (Throwable) r3, "start exp word fail");
        }
    }

    private final String getTag() {
        return (String) this.tag$delegate.getValue();
    }

    public List<i61.b> getProducers() {
        return (List) this.producers$delegate.getValue();
    }

    static {
        Companion = new Companion();
    }

    private final void unregisterAllListener() {
        Map<l61.b, Pair<ExpBizPerfObserver, Disposable>> r0 = this.bizPerfListeners;
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<Map.Entry<l61.b, Pair<ExpBizPerfObserver, Disposable>>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add((Disposable) r2.next().getValue().getSecond());
        goto L4
    L6:
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        ((Disposable) r3.next()).dispose();
        goto L8
    L10:
        this.bizPerfListeners.clear();
    }

    public final void startWork() {
        Lazy r0 = PlatformExpUtils.b;
        if (((fv1.a) r0.getValue()).c() == false) goto L26;
        o r1 = u.l().c(x.class);
        int r2 = 0;
        if (r1 == null) goto L13;
        Map r3 = r1.getMap();
        if (r3 == null) goto L13;
        String r4 = (String) r3.get("action_type");
        if (r4 == null) goto L13;
        if (r4.equals("click") != true) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        long r6 = ((fv1.a) r0.getValue()).a();
    L17:
        SimpleAlogArgsBuilder r7 = new SimpleAlogArgsBuilder();
        r7.d(getTag());
        r7.c("延迟启动降级框架流程");
        Pair[] r8 = {TuplesKt.to("是否为点击进房", Boolean.valueOf(r5)), TuplesKt.to("delayTime", Long.valueOf(r6))};
    L18:
        if (r2 >= 2) goto L25;
        Pair r9 = r8[r2];
        if (r9 == null) goto L24;
        Object r11 = r9.getSecond();
        if (r11 == null) goto L24;
        r7.a((String) r9.getFirst(), r11);
    L24:
        r2 = r2 + 1;
        goto L18
    L25:
        ExpOptLog.d(r7.b());
        RxUtilKt.c(RxUtilKt.h(Observable.timer(r6 * ((long) 1000), TimeUnit.MILLISECONDS)).subscribe(new d(this), e.a), this.cd);
        return;
    L16:
        r6 = ((fv1.a) r0.getValue()).b();
    L13:
        r5 = false;
        goto L14
    L26:
        getWorkshop().start();
    }

    public /* bridge */ /* synthetic */ e61.a getDispatch() {
        return m555getDispatch();
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final MiddlewareRoomContext getRoomContext() {
        return this.roomContext;
    }

    /* JADX INFO: renamed from: getDispatch, reason: collision with other method in class */
    public h90.a m555getDispatch() {
        return this.dispatch;
    }

    public static final /* synthetic */ Map access$getBizPerfListeners$p(LiveExpRoomContext r0) {
        return r0.bizPerfListeners;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(LiveExpRoomContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ String access$getTag$p(LiveExpRoomContext r0) {
        return r0.getTag();
    }

    public static final /* synthetic */ void access$unregisterAllListener(LiveExpRoomContext r0) {
        r0.unregisterAllListener();
    }

    public LiveExpRoomContext(DataCenter r2, MiddlewareRoomContext r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        this.dataCenter = r2;
        this.roomContext = r3;
        this.tag$delegate = LazyKt.lazy(LiveExpRoomContext$tag$2.INSTANCE);
        CompositeDisposable r4 = new CompositeDisposable();
        this.cd = r4;
        com.bytedance.live.datacontext.b.a(this, SHARE_TAG);
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r4);
        this.producers$delegate = LazyKt.lazy(new LiveExpRoomContext$producers$2(this));
        this.dispatch = new h90.a();
        this.bizPerfListeners = new LinkedHashMap();
    }

    public Disposable registerExpBizListener(l61.b r4, g61.a r5) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "listener");
        SimpleAlogArgsBuilder r0 = new SimpleAlogArgsBuilder();
        r0.d(getTag());
        r0.c(r4.getDesc() + " 业务注册了体验性能回调");
        ExpOptLog.d(r0.b());
        Pair<ExpBizPerfObserver, Disposable> r1 = this.bizPerfListeners.get(r4);
        if (r1 == null) goto L6;
        Disposable r2 = (Disposable) r1.getSecond();
        if (r2 == null) goto L6;
        return r2;
    L6:
        ExpBizPerfObserver r3 = new ExpBizPerfObserver(r4, r5);
        Disposable r6 = Disposables.fromAction(new b(m555getDispatch().a.a().subscribe(new c(r3)), this, r4, r5));
        this.bizPerfListeners.put(r4, TuplesKt.to(r3, r6));
        return r6;
    }

    public void unregisterExpBizListener(l61.b r3, g61.a r4) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Pair<ExpBizPerfObserver, Disposable> r5 = this.bizPerfListeners.get(r3);
        if (r5 == null) goto L8;
        Disposable r6 = (Disposable) r5.getSecond();
        if (r6 == null) goto L9;
        SimpleAlogArgsBuilder r0 = new SimpleAlogArgsBuilder();
        r0.d(getTag());
        r0.c(r3.getDesc() + " 业务反注册了体验性能回调");
        ExpOptLog.d(r0.b());
        r6.dispose();
        return;
    L9:
        return;
    }
}
