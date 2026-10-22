package com.bytedance.android.livesdk.chatroom.viewmodule;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoader;
import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.iw0;
import com.bytedance.android.livesdk.config.j11;
import com.bytedance.android.livesdk.config.pd;
import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.bytedance.android.livesdk.room.Task.execute.ExecutorHelper;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.utils.TimeConsumingFuncUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b2\u00103J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0014R\u0014\u0010\u0019\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001fR\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010\u001fR\u0017\u0010.\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/AnimationCenterScheduler;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/chatroom/viewmodel/IAnimationScheduler;", "", "time", "", "onSchedule", "Lcom/bytedance/android/livesdk/chatroom/viewmodel/c;", "listener", "logAnimationOnce", "it", "", "isSameListener", "Lkotlin/Function0;", "", "info", "logDebugInfo", "onToolbarLoaded", "Lcom/bytedance/android/livesdk/chatroom/viewmodel/a;", "requestAnimationAtOnce", "enable", "enableShowAnim", "registerListener", "unRegisterListener", "onCleared", "TAG", "Ljava/lang/String;", "Ljava/util/PriorityQueue;", "list", "Ljava/util/PriorityQueue;", "autoStart", "Z", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdk/chatroom/viewmodel/d;", "Lkotlin/collections/ArrayList;", "observerList", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/x2;", "scheduler", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/x2;", "mutex", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "enableAnim", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnimationCenterScheduler extends ViewModel implements IAnimationScheduler {
    private final String TAG;
    private boolean autoStart;
    private final CompositeDisposable cd;
    private final DataCenter dataCenter;
    private boolean enableAnim;
    private final PriorityQueue<com.bytedance.android.livesdk.chatroom.viewmodel.c> list;
    private boolean mutex;
    private final ArrayList<com.bytedance.android.livesdk.chatroom.viewmodel.d> observerList;
    private x2 scheduler;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.AnimationCenterScheduler$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public AnonymousClass1(AnimationCenterScheduler r8) {
            super(1, r8, AnimationCenterScheduler.class, "onSchedule", "onSchedule(J)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3) {
            invoke(((Number) r3).longValue());
            return Unit.INSTANCE;
        }

        public final void invoke(long r2) {
            AnimationCenterScheduler.access$onSchedule((AnimationCenterScheduler) ((CallableReference) this).receiver, r2);
        }
    }

    public static final class a<T> implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r2, Object r3) {
            com.bytedance.android.livesdk.chatroom.viewmodel.c r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.c) r2;
            com.bytedance.android.livesdk.chatroom.viewmodel.c r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.c) r3;
            int r0 = 0;
            if (r5 == null) goto L7;
            com.bytedance.android.livesdk.chatroom.viewmodel.a r6 = r5.getInfo();
            if (r6 == null) goto L7;
            int r7 = r6.a;
        L8:
            if (r4 == null) goto L13;
            com.bytedance.android.livesdk.chatroom.viewmodel.a r8 = r4.getInfo();
            if (r8 == null) goto L13;
            r0 = r8.a;
        L13:
            return r7 - r0;
        L7:
            r7 = 0;
            goto L8
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Map a;

        public b(Map r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_toolbar_icon_motion", this.a, new Object[]{am2.x.class, IRoom.class});     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AnimationCenterScheduler a;

        public c(AnimationCenterScheduler r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            if (AnimationCenterScheduler.access$getList$p(this.a).size() <= 0) goto L7;
            AnimationCenterScheduler.access$logDebugInfo(this.a, AnimationCenterScheduler$onToolbarLoaded$1$1.INSTANCE);
            x2 r4 = AnimationCenterScheduler.access$getScheduler$p(this.a);
            if (r4 == null) goto L7;
            r4.a();
        L7:
            AnimationCenterScheduler.access$setAutoStart$p(this.a, true);
        }
    }

    public void onCleared() {
        logDebugInfo(C04311.INSTANCE);
        this.observerList.clear();
        this.list.clear();
        this.cd.dispose();
        x2 r0 = this.scheduler;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler
    public void onToolbarLoaded() {
        IAnimationScheduler.M0.getClass();
        Integer r0 = (Integer) iw0.a.getValue();
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L7:
        if (r2 != 1) goto L9;
        r1 = true;
    L9:
        this.mutex = r1;
        RxUtilKt.c(Observable.timer(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this)), this.cd);
        return;
    L5:
        r2 = 0;
        goto L7
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public AnimationCenterScheduler(DataCenter r5) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.dataCenter = r5;
        this.TAG = "AnimationCenterScheduler";
        this.list = new PriorityQueue(10, a.a);
        this.observerList = new ArrayList();
        this.cd = new CompositeDisposable();
        this.enableAnim = true;
        IAnimationScheduler.M0.getClass();
        j11 r6 = (j11) pd.a.getValue();     // Catch: Exception -> L7
        if (r6 == null) goto L9;
        long r0 = r6.interval;     // Catch: Exception -> L7
    L11:
        if (r0 > 0) goto L13;
        r0 = AppointmentService.SOURCE_UNDEFINED;
    L13:
        this.scheduler = new f1(new AnonymousClass1(this), r0);
        return;
    L9:
        r0 = 5000;
    L7:
        e = move-exception;
        SafetyGuard.a(null, e, "live animation center setting interval error.");
        goto L9
    }

    public static final /* synthetic */ boolean access$getAutoStart$p(AnimationCenterScheduler r0) {
        return r0.autoStart;
    }

    public static final /* synthetic */ PriorityQueue access$getList$p(AnimationCenterScheduler r0) {
        return r0.list;
    }

    public static final /* synthetic */ x2 access$getScheduler$p(AnimationCenterScheduler r0) {
        return r0.scheduler;
    }

    private final void logAnimationOnce(com.bytedance.android.livesdk.chatroom.viewmodel.c r10) {
        TimeConsumingFuncUtils r0 = TimeConsumingFuncUtils.INSTANCE;
        String r2 = "";
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r5 = null;
        if (r0.asyncToolbarAnim() == true) goto L5;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r1 = y3.m(this.dataCenter);
        if ((r1 instanceof x3) == false) goto L25;
        r5 = r1;
    L25:
        x3 r6 = (x3) r5;
        if (r6 != null) goto L28;
        return;
    L28:
        ExtendedToolbarButton r11 = r10.c().extended();
        int r3 = r6.v(r11);
        com.bytedance.android.livesdk.chatroom.utils.o1.d().getClass();
        String r4 = com.bytedance.android.livesdk.chatroom.utils.o1.a(r3);
        com.bytedance.android.livesdk.chatroom.utils.o1.d().getClass();
        Object r12 = com.bytedance.android.livesdk.chatroom.utils.o1.a.get(r11);
        if ((r12 instanceof String) == false) goto L31;
        String r13 = (String) r12;
    L32:
        if (r13 == null) goto L35;
        r2 = r13;
    L35:
        Map r14 = MapsKt.mapOf(new Pair[]{TuplesKt.to("icon_type", r2), TuplesKt.to("icon_order", r4)});
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_toolbar_icon_motion", r14, new Object[]{am2.x.class, IRoom.class});
        return;
    L31:
        r13 = "";
        goto L32
    L5:
        if (r0.enableReport() == false) goto L37;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r7 = y3.m(this.dataCenter);
        if ((r7 instanceof x3) == false) goto L10;
        r5 = r7;
    L10:
        x3 r8 = (x3) r5;
        if (r8 != null) goto L13;
        return;
    L13:
        ExtendedToolbarButton r15 = r10.c().extended();
        int r9 = r8.v(r15);
        com.bytedance.android.livesdk.chatroom.utils.o1.d().getClass();
        String r16 = com.bytedance.android.livesdk.chatroom.utils.o1.a(r9);
        com.bytedance.android.livesdk.chatroom.utils.o1.d().getClass();
        Object r17 = com.bytedance.android.livesdk.chatroom.utils.o1.a.get(r15);
        if ((r17 instanceof String) == false) goto L16;
        String r18 = (String) r17;
    L17:
        if (r18 == null) goto L20;
        r2 = r18;
    L20:
        Map r19 = MapsKt.mapOf(new Pair[]{TuplesKt.to("icon_type", r2), TuplesKt.to("icon_order", r16)});
        Lazy r20 = ExecutorHelper.a;
        b r21 = new b(r19);
        Intrinsics.checkNotNullParameter(r21, "runnable");
        ((ExecutorService) ExecutorHelper.a.getValue()).execute(new com.bytedance.android.livesdk.room.Task.execute.a(r21));
        return;
    L16:
        r18 = "";
        goto L17
    }

    private final void logDebugInfo(Function0<String> r2) {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        ALogger.d(this.TAG, (String) r2.invoke());
        return;
    }

    private final void onSchedule(long r6) {
        com.bytedance.android.livesdk.chatroom.viewmodel.c r2 = null;
        PriorityQueue<com.bytedance.android.livesdk.chatroom.viewmodel.c> r3 = null;
        if (this.enableAnim == true) goto L11;
        PriorityQueue<com.bytedance.android.livesdk.chatroom.viewmodel.c> r7 = this.list;
        if ((!r7.isEmpty()) == false) goto L7;
        r3 = r7;
    L7:
        if (r3 == null) goto L36;
        r3.clear();
        return;
    L36:
        return;
    L11:
        if (this.list.size() != 0) goto L16;
        logDebugInfo(AnonymousClass2.INSTANCE);
        x2 r0 = this.scheduler;
        if (r0 == null) goto L16;
        r0.b();
    L16:
        if (this.mutex == false) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.c r1 = this.list.peek();
        if (r1 != null) goto L20;
        return;
    L20:
        if (r1.a(r6) == false) goto L38;
        logDebugInfo(AnimationCenterScheduler$onSchedule$3$1.INSTANCE);
        logAnimationOnce(r1);
        return;
    L38:
        return;
    L22:
        Iterator<T> r4 = this.list.iterator();
    L24:
        if (r4.hasNext() == false) goto L28;
        final com.bytedance.android.livesdk.chatroom.viewmodel.c r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.c) r4.next();
        if (r5.a(r6) == false) goto L24;
        logDebugInfo(new AnimationCenterScheduler$onSchedule$4$1$1(r5));
        logAnimationOnce(r5);
        r2 = r5;
    L28:
        if (r2 != null) goto L30;
        return;
    L30:
        if (r2.b() != true) goto L41;
        unRegisterListener(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler
    public void enableShowAnim(boolean r1) {
        this.enableAnim = r1;
        if (r1 == true) goto L6;
        this.list.clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler
    public void registerListener(final com.bytedance.android.livesdk.chatroom.viewmodel.c r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        if ((!Intrinsics.areEqual(r6.getInfo(), com.bytedance.android.livesdk.chatroom.viewmodel.a.d.b)) == false) goto L7;
        IAnimationScheduler.M0.getClass();
        if (IAnimationScheduler.Companion.b() == true) goto L7;
        return;
    L7:
        logDebugInfo(new C04321(r6));
        SkinLoader.c.getClass();
        Object r1 = null;
        if (SkinLoader.a.b() == false) goto L18;
        Iterator<T> r0 = this.list.iterator();
    L11:
        if (r0.hasNext() == false) goto L15;
        Object r2 = r0.next();
        if (isSameListener((com.bytedance.android.livesdk.chatroom.viewmodel.c) r2, r6) == false) goto L11;
        r1 = r2;
    L15:
        com.bytedance.android.livesdk.chatroom.viewmodel.c r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.c) r1;
        if (r3 == null) goto L27;
        this.list.remove(r3);
    L27:
        this.list.add(r6);
        if (this.autoStart == false) goto L32;
        logDebugInfo(AnonymousClass6.INSTANCE);
        x2 r7 = this.scheduler;
        if (r7 == null) goto L32;
        r7.a();
    L32:
        Iterator<T> r8 = this.observerList.iterator();
    L34:
        if (r8.hasNext() == false) goto L36;
        ((com.bytedance.android.livesdk.chatroom.viewmodel.d) r8.next()).b();
        goto L34
    L36:
        return;
    L18:
        Iterator<T> r4 = this.list.iterator();
    L20:
        if (r4.hasNext() == false) goto L24;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.chatroom.viewmodel.c) r5).getInfo(), r6.getInfo()) == false) goto L20;
        r1 = r5;
    L24:
        com.bytedance.android.livesdk.chatroom.viewmodel.c r9 = (com.bytedance.android.livesdk.chatroom.viewmodel.c) r1;
        if (r9 == null) goto L27;
        this.list.remove(r9);
        goto L27
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler
    public void requestAnimationAtOnce(com.bytedance.android.livesdk.chatroom.viewmodel.a r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        com.bytedance.android.livesdk.chatroom.viewmodel.c r0 = this.list.peek();
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r0.getInfo(), r4) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L14;
        logDebugInfo(AnimationCenterScheduler$requestAnimationAtOnce$2$1.INSTANCE);
        if (r0.a(-1) == false) goto L15;
        logAnimationOnce(r0);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler
    public void unRegisterListener(final com.bytedance.android.livesdk.chatroom.viewmodel.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        logDebugInfo(new C04331(r2));
        if (this.list.remove(r2) == false) goto L8;
        Iterator<T> r3 = this.observerList.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        ((com.bytedance.android.livesdk.chatroom.viewmodel.d) r3.next()).a();
        goto L6
    L10:
        return;
    }

    public static final /* synthetic */ void access$logDebugInfo(AnimationCenterScheduler r0, Function0 r1) {
        r0.logDebugInfo(r1);
    }

    public static final /* synthetic */ void access$onSchedule(AnimationCenterScheduler r0, long r1) {
        r0.onSchedule(r1);
    }

    public static final /* synthetic */ void access$setAutoStart$p(AnimationCenterScheduler r0, boolean r1) {
        r0.autoStart = r1;
    }

    public static final /* synthetic */ void access$setScheduler$p(AnimationCenterScheduler r0, x2 r1) {
        r0.scheduler = r1;
    }

    private final boolean isSameListener(com.bytedance.android.livesdk.chatroom.viewmodel.c r1, com.bytedance.android.livesdk.chatroom.viewmodel.c r2) {
        if (r2.c() != r1.c()) goto L5;
        return true;
    L5:
        return false;
    }
}
