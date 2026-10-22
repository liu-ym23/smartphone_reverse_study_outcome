package com.bytedance.android.live.messagewindow.framework.context;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.f;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import d71.d;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import q71.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001WB\u0017\u0012\u0006\u0010M\u001a\u00020\u0001\u0012\u0006\u0010P\u001a\u00020O¢\u0006\u0004\bT\u0010UJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J0\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\u0006\u0010\f\u001a\u00020\u0003J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001e\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J,\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0006\u001a\u00020\u00052\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00030\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u001a\u0010\u001f\u001a\u00020\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R<\u0010\u0011\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R!\u0010D\u001a\b\u0012\u0004\u0012\u00020?0>8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR*\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010/R,\u0010F\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070E0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010/R\u001a\u0010H\u001a\u00020G8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010IR\u0014\u0010M\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010P\u001a\u00020O8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S¨\u0006X"}, d2 = {"Lcom/bytedance/android/live/messagewindow/framework/context/CardContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/messagewindow/framework/context/c;", "", "doOnRelease", "Lcom/bytedance/android/live/room/api/messagewindow/container/MsgWindowPosition;", "position", "Lw61/a;", "Lv61/a;", "container", "Lq71/d;", "ensureContainer", "initialize", "Le71/a;", "windowManager", "Ld71/d;", "Ld71/b;", "recordManager", "Li71/a;", "scheduler", "provideWindowContainer", "windowContainer", "Lkotlin/Function1;", "action", "Lio/reactivex/disposables/Disposable;", "useContainer", "Lq71/a;", "stateDispatcher", "Lcom/bytedance/android/live/room/api/messagewindow/monitor/i;", "monitor", "Lcom/bytedance/android/livesdk/chatroom/o;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/o;", "getRoomContext", "()Lcom/bytedance/android/livesdk/chatroom/o;", "msgManager", "Le71/a;", "getMsgManager", "()Le71/a;", "setMsgManager", "(Le71/a;)V", "Lq71/a;", "getStateDispatcher", "()Lq71/a;", "setStateDispatcher", "(Lq71/a;)V", "", "Ljava/util/Map;", "getRecordManager", "()Ljava/util/Map;", "setRecordManager", "(Ljava/util/Map;)V", "Li71/a;", "getScheduler", "()Li71/a;", "setScheduler", "(Li71/a;)V", "Lcom/bytedance/android/live/room/api/messagewindow/monitor/i;", "getMonitor", "()Lcom/bytedance/android/live/room/api/messagewindow/monitor/i;", "setMonitor", "(Lcom/bytedance/android/live/room/api/messagewindow/monitor/i;)V", "Lcom/bytedance/live/datacontext/j;", "Ly61/a;", "commonCardContext$delegate", "Lcom/bytedance/live/datacontext/p;", "getCommonCardContext", "()Lcom/bytedance/live/datacontext/j;", "commonCardContext", "Lq71/e;", "containerOpt", "Lio/reactivex/disposables/CompositeDisposable;", "containerCd", "Lio/reactivex/disposables/CompositeDisposable;", "getContainerCd", "()Lio/reactivex/disposables/CompositeDisposable;", "cd", "roomContextProxy", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/live/datacontext/DataContext;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardContext extends DataContext implements com.bytedance.android.live.messagewindow.framework.context.c {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private static final String SHARE_TAG = "CardContextShared";
    private final CompositeDisposable cd;
    private final p commonCardContext$delegate;
    private Map<MsgWindowPosition, w61.a<v61.a>> container;
    private final CompositeDisposable containerCd;
    private final Map<MsgWindowPosition, e<w61.a<v61.a>>> containerOpt;
    private final DataCenter dataCenter;
    private i monitor;
    private e71.a msgManager;
    private Map<MsgWindowPosition, d<v61.a, d71.b>> recordManager;
    private final o roomContext;
    private final DataContext roomContextProxy;
    private i71.a scheduler;
    private q71.a stateDispatcher;

    public static final class a {
        public a() {
        }

        public static com.bytedance.android.live.messagewindow.framework.context.c a(DataCenter r4) {
            CommonCardContext.Companion.getClass();
            DataContext r0 = com.bytedance.live.datacontext.d.d(CommonCardContext.b.a(r4, CardContext.SHARE_TAG));
            if ((r0 instanceof com.bytedance.android.live.messagewindow.framework.context.c) == true) goto L5;
            r0 = null;
        L5:
            com.bytedance.android.live.messagewindow.framework.context.c r1 = (com.bytedance.android.live.messagewindow.framework.context.c) r0;
            if (r1 != null) goto L24;
            r r5 = z51.a.e(r4);
            if (r5 == null) goto L19;
            j r6 = r5.i();
            if (r6 == null) goto L19;
            ViewModel r7 = (ViewModel) r6.getValue();
            if (r7 == null) goto L19;
            if ((r7 instanceof com.bytedance.android.live.messagewindow.framework.context.c) == true) goto L16;
            r7 = null;
        L16:
            com.bytedance.android.live.messagewindow.framework.context.c r8 = (com.bytedance.android.live.messagewindow.framework.context.c) r7;
            if (r8 == null) goto L19;
            r1 = r8;
        L19:
            if (r1 != null) goto L24;
            i r9 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r9 == null) goto L24;
            CardAlogParamsBuilder r2 = new CardAlogParamsBuilder();
            r2.d("CardContextShare");
            r2.c("the card context is null");
            r2.c(v71.a.g(null));
            Unit r3 = Unit.INSTANCE;
            r9.d(r2.b());
        L24:
            return r1;
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ CardContext a;

        public b(CardContext r1) {
            this.a = r1;
        }

        public final void run() {
            CardContext.access$getCd$p(this.a).clear();
            Map r0 = CardContext.access$getContainer$p(this.a);
            if (r0 == null) goto L10;
            Iterator r1 = r0.entrySet().iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            w61.a r2 = (w61.a) ((Map.Entry) r1.next()).getValue();
            if (r2 == null) goto L6;
            r2.Qg();
        L10:
            Map r3 = CardContext.access$getContainerOpt$p(this.a);
            if (r3 == null) goto L20;
            Iterator r4 = r3.entrySet().iterator();
        L14:
            if (r4.hasNext() == false) goto L20;
            e r5 = (e) ((Map.Entry) r4.next()).getValue();
            if (r5 == null) goto L14;
            w61.a r6 = (w61.a) sh6.c.b((sh6.b) r5.a.a);
            if (r6 == null) goto L14;
            r6.Qg();
        L20:
            Map<MsgWindowPosition, d<v61.a, d71.b>> r7 = this.a.getRecordManager();
            if (r7 == null) goto L28;
            Iterator<Map.Entry<MsgWindowPosition, d<v61.a, d71.b>>> r8 = r7.entrySet().iterator();
        L24:
            if (r8.hasNext() == false) goto L28;
            d<v61.a, d71.b> r9 = r8.next().getValue();
            if (r9 == null) goto L24;
            r9.release();
        L28:
            this.a.getStateDispatcher().release();
            i r10 = this.a.getMonitor();
            if (r10 == null) goto L49;
            CardAlogParamsBuilder r11 = new CardAlogParamsBuilder();
            r11.c("CardContext onCleared");
            Unit r12 = Unit.INSTANCE;
            r10.d(r11.b());
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ Function1 b;

        public c(Ref.ObjectRef r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            w61.a r3 = (w61.a) r2;
            Disposable r0 = (Disposable) this.a.element;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            this.b.invoke(r3);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(CardContext.class, "commonCardContext", "getCommonCardContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    @Override // com.bytedance.android.live.messagewindow.framework.context.c
    public j<y61.a> getCommonCardContext() {
        return (j) this.commonCardContext$delegate.a(this, $$delegatedProperties[0]);
    }

    public final void initialize() {
        CommonCardContext.b r0 = CommonCardContext.Companion;
        DataCenter r1 = getDataCenter();
        r0.getClass();
        com.bytedance.live.datacontext.b.a(this, CommonCardContext.b.a(r1, SHARE_TAG));
        j<y61.a> r2 = getCommonCardContext();
        if (r2 == null) goto L5;
        CommonCardContext r3 = new CommonCardContext(this.roomContextProxy, getDataCenter());
        com.bytedance.live.datacontext.b.a(r3, CommonCardContext.b.a(r3.getDataCenter(), CommonCardContext.TAG));
        Unit r4 = Unit.INSTANCE;
        r2.d(r3);
    L5:
        i r5 = this.monitor;
        if (r5 == null) goto L8;
        CardAlogParamsBuilder r6 = new CardAlogParamsBuilder();
        r6.c("initCardContext and shared");
        Unit r7 = Unit.INSTANCE;
        r5.d(r6.b());
    L8:
        f r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_context_init");
        i r9 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r9 == null) goto L11;
        r9.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r8));
    L11:
        this.cd.clear();
        doOnRelease();
    }

    private final void doOnRelease() {
        RxUtilKt.c(getOnCleared().subscribe(new b(this)), this.cd);
    }

    /* JADX INFO: renamed from: stateDispatcher, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ q71.b m546stateDispatcher() {
        return stateDispatcher();
    }

    public CompositeDisposable getContainerCd() {
        return this.containerCd;
    }

    public DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final i getMonitor() {
        return this.monitor;
    }

    public final e71.a getMsgManager() {
        return this.msgManager;
    }

    public final Map<MsgWindowPosition, d<v61.a, d71.b>> getRecordManager() {
        return this.recordManager;
    }

    public o getRoomContext() {
        return this.roomContext;
    }

    public final i71.a getScheduler() {
        return this.scheduler;
    }

    public final q71.a getStateDispatcher() {
        return this.stateDispatcher;
    }

    public i monitor() {
        return this.monitor;
    }

    public i71.a scheduler() {
        return this.scheduler;
    }

    public e71.a windowManager() {
        return this.msgManager;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.context.c
    public q71.a stateDispatcher() {
        return this.stateDispatcher;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(CardContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ Map access$getContainer$p(CardContext r0) {
        return r0.container;
    }

    public static final /* synthetic */ Map access$getContainerOpt$p(CardContext r0) {
        return r0.containerOpt;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.context.c
    public d<v61.a, d71.b> recordManager(MsgWindowPosition r2) {
        Intrinsics.checkNotNullParameter(r2, "position");
        d<v61.a, d71.b> r3 = this.recordManager.get(r2);
        if (r3 != null) goto L13;
        IPlatformCardService.Companion.getClass();
        IPlatformCardService r4 = IPlatformCardService.a.a();
        if (r4 == null) goto L11;
        q71.a r0 = this.stateDispatcher;
        if (r0 == null) goto L10;
        return r4.newRecordManager(((jm0.a) r0).b);
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.messagewindow.framework.state.CardStateDispatcher");
    L11:
        return null;
    L13:
        return r3;
    }

    public final void setMonitor(i r1) {
        this.monitor = r1;
    }

    public final void setMsgManager(e71.a r1) {
        this.msgManager = r1;
    }

    public final void setRecordManager(Map<MsgWindowPosition, d<v61.a, d71.b>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.recordManager = r2;
    }

    public final void setScheduler(i71.a r1) {
        this.scheduler = r1;
    }

    public final void setStateDispatcher(q71.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.stateDispatcher = r2;
    }

    public w61.a<v61.a> windowContainer(MsgWindowPosition r12) {
        Intrinsics.checkNotNullParameter(r12, "position");
        Object r0 = null;
        q71.d r2 = ensureContainer$default(this, r12, null, 2, null);
        if (m71.e.a() == false) goto L7;
        if (r2 == null) goto L6;
        w61.a<v61.a> r3 = (w61.a) sh6.c.b((sh6.b) ((e) r2).a.a);
    L8:
        if (r3 == null) goto L10;
        return r3;
    L10:
        r r4 = z51.a.d(this.roomContextProxy);
        int r13 = com.bytedance.android.live.messagewindow.framework.context.a.a[r12.ordinal()];
        boolean r5 = true;
        if (r13 == 1) goto L74;
        if (r13 != 2) goto L14;
        if (r4 == null) goto L49;
        n r14 = r4.m();
        if (r14 == null) goto L49;
        Pair r15 = (Pair) r14.getValue();
    L50:
        if (r15 == null) goto L103;
        n r16 = r4.m();
        if (r16 == null) goto L103;
        Pair r17 = (Pair) r16.getValue();
        if (r17 == null) goto L103;
        if (((Number) r17.getFirst()).longValue() == a0.n(getDataCenter()).getId()) goto L58;
    L60:
        r5 = false;
    L61:
        if (r5 == true) goto L64;
        r17 = null;
    L64:
        if (r17 == null) goto L103;
        Object r18 = r17.getSecond();
        if ((r18 instanceof w61.a) == false) goto L69;
        r0 = r18;
    L69:
        r3 = (w61.a) r0;
        if (m71.e.a() == false) goto L73;
        if (r2 == null) goto L103;
        r2.b(r3);
        goto L103
    L73:
        this.container.put(MsgWindowPosition.TOP_RIGHT, r3);
        goto L103
    L58:
        if ((r17.getSecond() instanceof w61.a) == false) goto L60;
    L103:
        return r3;
    L49:
        r15 = null;
        goto L50
    L14:
        if (r13 != 3) goto L103;
        if (r4 == null) goto L20;
        n r19 = r4.M();
        if (r19 == null) goto L20;
        Pair r110 = (Pair) r19.getValue();
    L21:
        if (r110 == null) goto L103;
        n r111 = r4.M();
        if (r111 == null) goto L103;
        Pair r112 = (Pair) r111.getValue();
        if (r112 == null) goto L103;
        if (((Number) r112.getFirst()).longValue() == a0.n(getDataCenter()).getId()) goto L29;
    L31:
        r5 = false;
    L32:
        if (r5 == true) goto L35;
        r112 = null;
    L35:
        if (r112 == null) goto L103;
        Object r113 = r112.getSecond();
        if ((r113 instanceof w61.a) == false) goto L40;
        r0 = r113;
    L40:
        r3 = (w61.a) r0;
        if (m71.e.a() == false) goto L44;
        if (r2 == null) goto L103;
        r2.b(r3);
        goto L103
    L44:
        this.container.put(MsgWindowPosition.BOTTOM_RIGHT, r3);
        goto L103
    L29:
        if ((r112.getSecond() instanceof w61.a) == false) goto L31;
    L20:
        r110 = null;
        goto L21
    L74:
        if (r4 == null) goto L78;
        n r114 = r4.y();
        if (r114 == null) goto L78;
        Pair r115 = (Pair) r114.getValue();
    L79:
        if (r115 == null) goto L103;
        n r116 = r4.y();
        if (r116 == null) goto L103;
        Pair r117 = (Pair) r116.getValue();
        if (r117 == null) goto L103;
        if (((Number) r117.getFirst()).longValue() == a0.n(getDataCenter()).getId()) goto L87;
    L89:
        r5 = false;
    L90:
        if (r5 == true) goto L93;
        r117 = null;
    L93:
        if (r117 == null) goto L103;
        Object r118 = r117.getSecond();
        if ((r118 instanceof w61.a) == false) goto L98;
        r0 = r118;
    L98:
        r3 = (w61.a) r0;
        if (m71.e.a() == false) goto L102;
        if (r2 == null) goto L103;
        r2.b(r3);
        goto L103
    L102:
        this.container.put(MsgWindowPosition.TOP_LEFT, r3);
        goto L103
    L87:
        if ((r117.getSecond() instanceof w61.a) == false) goto L89;
    L78:
        r115 = null;
        goto L79
    L6:
        r3 = null;
        goto L8
    L7:
        r3 = this.container.get(r12);
        goto L8
    }

    public CardContext(DataContext r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "roomContextProxy");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        this.roomContextProxy = r5;
        this.dataCenter = r6;
        this.roomContext = k.n(IRoomContextService.class).getRoomDataContext(r5);
        IPlatformCardService.Companion.getClass();
        IPlatformCardService r7 = IPlatformCardService.a.a();
        i r8 = null;
        if (r7 == null) goto L5;
        e71.a r9 = r7.newCardManager(this);
    L6:
        this.msgManager = r9;
        this.stateDispatcher = new jm0.a();
        Pair[] r10 = new Pair[3];
        MsgWindowPosition r0 = MsgWindowPosition.BOTTOM_RIGHT;
        IPlatformCardService r1 = IPlatformCardService.a.a();
        if (r1 == null) goto L13;
        q71.a r3 = this.stateDispatcher;
        if (r3 == null) goto L12;
        d r2 = r1.newRecordManager(((jm0.a) r3).b);
    L14:
        r10[0] = TuplesKt.to(r0, r2);
        MsgWindowPosition r4 = MsgWindowPosition.TOP_LEFT;
        IPlatformCardService r11 = IPlatformCardService.a.a();
        if (r11 == null) goto L21;
        q71.a r12 = this.stateDispatcher;
        if (r12 == null) goto L20;
        d r13 = r11.newRecordManager(((jm0.a) r12).b);
    L22:
        r10[1] = TuplesKt.to(r4, r13);
        MsgWindowPosition r14 = MsgWindowPosition.TOP_RIGHT;
        IPlatformCardService r15 = IPlatformCardService.a.a();
        if (r15 == null) goto L29;
        q71.a r16 = this.stateDispatcher;
        if (r16 == null) goto L28;
        d r17 = r15.newRecordManager(((jm0.a) r16).b);
    L30:
        r10[2] = TuplesKt.to(r14, r17);
        this.recordManager = MapsKt.mutableMapOf(r10);
        IPlatformCardService r18 = IPlatformCardService.a.a();
        if (r18 == null) goto L33;
        i71.a r19 = r18.newCardScheduler(this);
    L34:
        this.scheduler = r19;
        IPlatformCardService r20 = IPlatformCardService.a.a();
        if (r20 == null) goto L37;
        r8 = r20.cardMonitor();
    L37:
        this.monitor = r8;
        this.commonCardContext$delegate = ConstantKt.c(this);
        this.container = new LinkedHashMap();
        this.containerOpt = new LinkedHashMap();
        this.containerCd = new CompositeDisposable();
        this.cd = new CompositeDisposable();
        return;
    L33:
        r19 = null;
        goto L34
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.messagewindow.framework.state.CardStateDispatcher");
    L29:
        r17 = null;
        goto L30
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.messagewindow.framework.state.CardStateDispatcher");
    L21:
        r13 = null;
        goto L22
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.messagewindow.framework.state.CardStateDispatcher");
    L13:
        r2 = null;
        goto L14
    L5:
        r9 = null;
        goto L6
    }

    public static final /* synthetic */ void access$setContainer$p(CardContext r0, Map r1) {
        r0.container = r1;
    }

    private final q71.d<w61.a<v61.a>> ensureContainer(MsgWindowPosition r2, w61.a<v61.a> r3) {
        if (m71.e.a() == false) goto L8;
        e<w61.a<v61.a>> r0 = this.containerOpt.get(r2);
        if (r0 != null) goto L10;
        r0 = new q71.d(r3);
        this.containerOpt.put(r2, r0);
    L10:
        return (q71.d) r0;
    L8:
        return null;
    }

    public void provideWindowContainer(MsgWindowPosition r2, w61.a<v61.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "position");
        if (m71.e.a() == false) goto L7;
        q71.d<w61.a<v61.a>> r4 = ensureContainer(r2, r3);
        if (r4 == null) goto L9;
        r4.b(r3);
        return;
    L9:
        return;
    L7:
        this.container.put(r2, r3);
    }

    public Disposable useContainer(MsgWindowPosition r4, Function1<? super w61.a<v61.a>, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "position");
        Intrinsics.checkNotNullParameter(r5, "action");
        int r0 = v71.a.a;
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = null;
        w61.a<v61.a> r2 = windowContainer(r4);
        if (r2 != null) goto L5;
    L10:
        q71.d r6 = ensureContainer$default(this, r4, null, 2, null);
        if (r6 == null) goto L19;
        Observable r7 = ((e) r6).b;
        if (r7 == null) goto L20;
        Disposable r8 = r7.subscribe(new c(r1, r5));
        if (r8 == null) goto L21;
        r1.element = r8;
        return r8;
    L21:
        return null;
    L20:
        return null;
    L19:
        return null;
    L5:
        if (((Unit) r5.invoke(r2)) == null) goto L10;
        Disposable r3 = Disposables.empty();
        if (r3 == null) goto L10;
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ q71.d ensureContainer$default(CardContext r0, MsgWindowPosition r1, w61.a r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.ensureContainer(r1, r2);
    }
}
