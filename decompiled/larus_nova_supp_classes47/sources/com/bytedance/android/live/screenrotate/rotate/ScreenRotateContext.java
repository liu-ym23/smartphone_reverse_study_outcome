package com.bytedance.android.live.screenrotate.rotate;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.screenrotation.rotate.RotateInnerRequest;
import com.bytedance.android.live.screenrotate.monitor.ScreenRotateMonitor;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ig1;
import com.bytedance.android.livesdk.config.jg1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.util.IScreenRotateMonitor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u001b\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0005\u001a\u00020\u0003R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R&\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010%8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/screenrotate/rotate/ScreenRotateContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lz71/a;", "", "onRelease", "initialize", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/live/room/api/screenrotation/rotate/d;", "rotateSession$delegate", "Lkotlin/Lazy;", "getRotateSession", "()Lcom/bytedance/android/live/room/api/screenrotation/rotate/d;", "rotateSession", "Lcom/bytedance/android/live/room/api/screenrotation/rotate/c;", "handleRegistry", "Lcom/bytedance/android/live/room/api/screenrotation/rotate/c;", "getHandleRegistry", "()Lcom/bytedance/android/live/room/api/screenrotation/rotate/c;", "Lcom/bytedance/android/livesdkapi/util/IScreenRotateMonitor;", "monitor", "Lcom/bytedance/android/livesdkapi/util/IScreenRotateMonitor;", "getMonitor", "()Lcom/bytedance/android/livesdkapi/util/IScreenRotateMonitor;", "", "La81/b;", "Lio/reactivex/disposables/Disposable;", "configChangeListeners", "Ljava/util/Map;", "getConfigChangeListeners", "()Ljava/util/Map;", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "getRoomContext", "()Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/android/livesdk/chatroom/RoomContext;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScreenRotateContext extends DataContext implements z71.a {
    public static final Companion Companion = null;
    private static final String LOG_TAG = "ScreenRotateContext";
    private final CompositeDisposable cd;
    private final Map<a81.b, Disposable> configChangeListeners;
    private final DataCenter dataCenter;
    private final com.bytedance.android.live.room.api.screenrotation.rotate.c handleRegistry;
    private final IScreenRotateMonitor monitor;
    private final RoomContext roomContext;
    private final Lazy rotateSession$delegate;

    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public static z71.a a(RoomContext r2) {
            if (r2 == null) goto L6;
            z71.a r3 = z71.b.a(r2);
            if (r3 == null) goto L6;
        L10:
            if (r3 != null) goto L13;
            ALogger.e(ScreenRotateContext.LOG_TAG, "get screen rotate context fail");
            return null;
        L13:
            return r3;
        L6:
            DataContext r4 = com.bytedance.live.datacontext.d.d(ScreenRotateContext.class);
            if ((r4 instanceof z71.a) == true) goto L9;
            r4 = null;
        L9:
            r3 = (z71.a) r4;
            goto L10
        }

        @JvmStatic
        public static z71.a b(DataCenter r4) {
            RoomContext r5 = RoomContext.a.c(RoomContext.Companion, r4, 0, 2);
            if (r5 == null) goto L6;
            z71.a r6 = z71.b.a(r5);
            if (r6 == null) goto L6;
        L10:
            if (r6 != null) goto L13;
            ALogger.e(ScreenRotateContext.LOG_TAG, "get screen rotate context fail");
            return null;
        L13:
            return r6;
        L6:
            DataContext r7 = com.bytedance.live.datacontext.d.d(ScreenRotateContext.class);
            if ((r7 instanceof z71.a) == true) goto L9;
            r7 = null;
        L9:
            r6 = (z71.a) r7;
            goto L10
        }

        @JvmStatic
        public static Object c(RoomContext r4, DataCenter r5, final Function1 r6) {
            Intrinsics.checkNotNullParameter(r6, "action");
            final Ref.ObjectRef r0 = new Ref.ObjectRef();
            r0.element = null;
            ScreenRotateContext.Companion.getClass();
            z71.a r7 = a(r4);
            if (r7 != null) goto L5;
            r7 = b(r5);
        L5:
            if (r7 == null) goto L9;
            Object r8 = r6.invoke(r7);
            if (r8 == null) goto L9;
            r0.element = r8;
        L15:
            return r0.element;
        L9:
            RoomContext r9 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r9 == null) goto L15;
            j r10 = r9.getRotateContext();
            if (r10 == null) goto L15;
            r10.c(new ScreenRotateContext$Companion$useShare$$inlined$run$lambda$1(r0, r6));
            Unit r12 = Unit.INSTANCE;
            goto L15
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ ScreenRotateContext a;

        public a(ScreenRotateContext r1) {
            this.a = r1;
        }

        public final void run() {
            ScreenRotateContext.access$onRelease(this.a);
        }
    }

    @JvmStatic
    public static final z71.a getCtx(RoomContext r1) {
        Companion.getClass();
        return Companion.a(r1);
    }

    @JvmStatic
    public static final z71.a getCtx(DataCenter r1) {
        Companion.getClass();
        return Companion.b(r1);
    }

    @JvmStatic
    public static final <R> R useShare(RoomContext r1, DataCenter r2, Function1<? super z71.a, ? extends R> r3) {
        Companion.getClass();
        return (R) Companion.c(r1, r2, r3);
    }

    @Override // z71.a
    public com.bytedance.android.live.room.api.screenrotation.rotate.d getRotateSession() {
        return (com.bytedance.android.live.room.api.screenrotation.rotate.d) this.rotateSession$delegate.getValue();
    }

    static {
        Companion = new Companion();
    }

    public final void initialize() {
        SimpleAlogArgsBuilder r0 = new SimpleAlogArgsBuilder();
        r0.d(LOG_TAG);
        r0.c("rotate context init");
        f81.a.a(r0.b());
        Companion.getClass();
        com.bytedance.live.datacontext.b.a(this, ScreenRotateContext.class);
        com.bytedance.android.live.room.api.screenrotation.rotate.c r1 = getHandleRegistry();
        getRoomContext();
        getDataCenter();
        r1.d();
        RxUtilKt.c(getOnCleared().observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)), this.cd);
    }

    private final void onRelease() {
        getHandleRegistry().release();
        PublishSubject<RotateInnerRequest<?>> r0 = d.a;
        IScreenRotateMonitor r1 = getMonitor();
        if (r1 == null) goto L5;
        r1.release();
    L5:
        getConfigChangeListeners().clear();
    }

    @Override // z71.a
    public Map<a81.b, Disposable> getConfigChangeListeners() {
        return this.configChangeListeners;
    }

    @Override // z71.a
    public DataCenter getDataCenter() {
        return this.dataCenter;
    }

    @Override // z71.a
    public com.bytedance.android.live.room.api.screenrotation.rotate.c getHandleRegistry() {
        return this.handleRegistry;
    }

    @Override // z71.a
    public IScreenRotateMonitor getMonitor() {
        return this.monitor;
    }

    public RoomContext getRoomContext() {
        return this.roomContext;
    }

    public static final /* synthetic */ void access$onRelease(ScreenRotateContext r0) {
        r0.onRelease();
    }

    @JvmStatic
    private static final void shareThis(z71.a r1) {
        Companion.getClass();
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.b.a((DataContext) r1, ScreenRotateContext.class);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.datacontext.DataContext");
    }

    public ScreenRotateContext(RoomContext r2, DataCenter r3) {
        this.roomContext = r2;
        this.dataCenter = r3;
        this.cd = new CompositeDisposable();
        this.rotateSession$delegate = LazyKt.lazy(new ScreenRotateContext$rotateSession$2(this));
        this.handleRegistry = new b();
        if (((jg1) ig1.a.getValue()).a() == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        Boolean r5 = Boolean.valueOf(r4);
        ScreenRotateMonitor r0 = null;
        if (r5.booleanValue() == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L14;
        r5.booleanValue();
        r0 = new ScreenRotateMonitor();
    L14:
        this.monitor = r0;
        this.configChangeListeners = new ConcurrentHashMap();
        return;
    L5:
        if (PadConfigUtils.c() == true) goto L7;
        r4 = true;
        goto L8
    }
}
