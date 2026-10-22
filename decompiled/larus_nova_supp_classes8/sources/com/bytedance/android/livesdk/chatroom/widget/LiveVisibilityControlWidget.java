package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControl;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widgetdescriptor.data.LandscapeInteractionModel;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/LiveVisibilityControlWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/live/room/api/visibilitycontrol/c;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveVisibilityControlWidget extends LiveRecyclableWidget implements Observer<KVData>, com.bytedance.android.live.room.api.visibilitycontrol.c {
    public final String a;
    public WidgetManager b;
    public boolean c;
    public boolean d;
    public final List<com.bytedance.android.live.room.api.visibilitycontrol.d> e;
    public final List<com.bytedance.android.live.room.api.visibilitycontrol.d> f;
    public final List<com.bytedance.android.live.room.api.visibilitycontrol.d> g;
    public final List<com.bytedance.android.live.room.api.visibilitycontrol.d> h;
    public final List<com.bytedance.android.live.room.api.visibilitycontrol.d> i;
    public final List<com.bytedance.android.live.room.api.visibilitycontrol.d> j;
    public final Map<LiveVisibilityControl.KEY, com.bytedance.android.live.room.api.visibilitycontrol.d> k;
    public Observable<Unit> l;
    public Disposable m;
    public IVisibilityControlBrickService n;
    public IVisibilityControlService o;
    public LiveVisibilityControlContext p;
    public CompositeDisposable q;
    public int r;
    public int s;
    public int t;
    public int u;
    public final List<Animator> v;
    public boolean w;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveVisibilityControlContext a;
        public final /* synthetic */ LiveVisibilityControlWidget b;

        public b(LiveVisibilityControlContext r1, LiveVisibilityControlWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r18) {
            Boolean r1 = (Boolean) r18;
            ALogger.d("visibilityControlTag", "in LiveVisibility, subscribe value is  " + r1);
            LiveVisibilityControlWidget r2 = this.b;
            if (r2.c == true) goto L5;
            r2.d = true;
            return;
        L5:
            Boolean r3 = Boolean.FALSE;
            if (Intrinsics.areEqual(r1, r3) == false) goto L11;
            if (((Boolean) this.a.isLocked().getValue()).booleanValue() == true) goto L11;
            LiveVisibilityControlWidget.Lq(this.b.g);
            LiveVisibilityControlWidget.Lq(this.b.h);
            LiveVisibilityControlWidget.Lq(this.b.i);
            LiveVisibilityControlWidget.Lq(this.b.j);
            this.b.Kq();
        L11:
            if (((Number) this.a.getCustomAnimDuration().getValue()).longValue() == (-1)) goto L13;
            long r4 = ((Number) this.a.getCustomAnimDuration().getValue()).longValue();
            this.a.getCustomAnimDuration().setValue(-1L);
        L14:
            LiveVisibilityControlWidget r11 = this.b;
            boolean r12 = r1.booleanValue();
            if (r11.isViewValid() == false) goto L31;
            String r5 = r11.a;
            StringBuilder r6 = new StringBuilder(" start changeInteractionVisibility to ");
            r6.append(r12);
            r6.append(",lock state=");
            LiveVisibilityControlContext r7 = r11.p;
            if (r7 == null) goto L22;
            com.bytedance.live.datacontext.m r8 = r7.isLocked();
            if (r8 == null) goto L22;
            Boolean r9 = (Boolean) r8.getValue();
        L23:
            r6.append(r9);
            ALogger.d(r5, r6.toString());
            ((ArrayList) r11.v).clear();
            long r10 = r4;
            r11.Fq(r11.e, r12, false, r10);
            r11.Cq(r11.f, r12, false, r10);
            r11.Jq(r11.g, r12, false, r10);
            r11.Eq(r11.h, r12, false, r10);
            r11.Gq(r11.i, r12, false, r10);
            r11.Iq(r11.j, r12, false, r10);
            AnimatorSet r13 = new AnimatorSet();
            r13.playTogether(r11.v);
            r13.addListener(new f1(r11, r12, r13));
            r13.start();
            if (r3.l(((Widget) r11).context) == false) goto L31;
            Context r14 = ((Widget) r11).context;
            if (r12 == false) goto L28;
            String r15 = "已显示播放控制栏";
        L29:
            r3.q(r14, r15);
            goto L31
        L28:
            r15 = "已隐藏播放控制栏";
        L22:
            r9 = null;
        L31:
            if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L34;
            this.b.Mq();
        L34:
            if (Intrinsics.areEqual(r1, r3) == false) goto L38;
            this.a.getPlayerViewVisibleTriggeredByUser().setValue(r3);
            return;
        L38:
            return;
        L13:
            r4 = 200;
            goto L14
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveVisibilityControlWidget a;

        public c(LiveVisibilityControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Unit r3 = (Unit) r2;
            ALogger.d(this.a.a, "receive resetHideTaskEvent");
            this.a.Mq();
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ LiveVisibilityControlWidget a;

        public d(LiveVisibilityControlWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 == null) goto L8;
            boolean r4 = r3.booleanValue();
            IVisibilityControlService r0 = this.a.o;
            if (r0 == null) goto L9;
            r0.setLockStatus(r4);
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ LiveVisibilityControlWidget a;

        public e(LiveVisibilityControlWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L8;
            IVisibilityControlService r3 = this.a.o;
            if (r3 == null) goto L9;
            r3.setVisibilityStatus(false);
            return;
        L9:
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ LiveVisibilityControlWidget a;

        public f(LiveVisibilityControlWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            LiveVisibilityControlWidget r5 = this.a;
            if (r5.w == true) goto L5;
            return;
        L5:
            if (com.bytedance.android.live.core.utils.z.m(((Widget) r5).dataCenter, true) == false) goto L12;
            VSDataContext r6 = VSDataContext.a.c(VSDataContext.Companion, ((Widget) this.a).dataCenter);
            if (r6 == null) goto L19;
            com.bytedance.live.datacontext.m r7 = r6.isVerticalVideo();
            if (r7 != null) goto L11;
            return;
        L11:
            if (((Boolean) r7.getValue()).booleanValue() == true) goto L12;
            return;
        L19:
            return;
        L12:
            LiveVisibilityControlWidget r8 = this.a;
            IVisibilityControlBrickService r0 = r8.n;
            if (r0 == null) goto L22;
            IVisibilityControlService r9 = r0.provideVisibilityControlService(((Widget) r8).dataCenter);
            if (r9 == null) goto L23;
            r9.setVisibilityStatus(false);
            return;
        L23:
            return;
        }
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void Kq() {
        WidgetInfo r0 = getWidgetInfo(ShadowPlayerWidget.class);
        if (r0 == null) goto L6;
        int[] r1 = r0.getLocationOnScreen();
        int r2 = r1[0];
        this.t = r2;
        this.r = r1[1];
        this.u = r2 + r0.getContentViewWidth();
        this.s = this.r + r0.getContentViewHeight();
        return;
    }

    public final void Mq() {
        ALogger.d(this.a, "--resetHideViewTask");
        Disposable r0 = null;
        this.l = null;
        IVisibilityControlService r1 = this.o;
        if (r1 == null) goto L6;
        Observable<Unit> r2 = r1.startVisibilityTimer();
        if (r2 == null) goto L6;
    L7:
        this.l = r2;
        Disposable r3 = this.m;
        if (r3 == null) goto L10;
        r3.dispose();
    L10:
        Observable<Unit> r4 = this.l;
        if (r4 == null) goto L13;
        r0 = RxUtilKt.n(r4, new LiveVisibilityControlWidget$resetHideViewTask$1(this));
    L13:
        this.m = r0;
        return;
    L6:
        r2 = Observable.timer(5000, TimeUnit.MILLISECONDS).map(i1.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        goto L7
    }

    public final void onUnload() {
        String r0 = this.a;
        StringBuilder r1 = new StringBuilder("start onUnload: dataCenter:");
        r1.append(((Widget) this).dataCenter.hashCode());
        r1.append(", viewControlService:");
        IVisibilityControlBrickService r2 = this.n;
        if (r2 == null) goto L5;
        IVisibilityControlService r3 = r2.provideVisibilityControlService(((Widget) this).dataCenter);
    L7:
        if (r3 == null) goto L9;
        int r4 = r3.hashCode();
    L10:
        r1.append(r4);
        ALogger.d(r0, r1.toString());
        ((Widget) this).dataCenter.removeObserver(this);
        this.w = false;
        this.b = null;
        ((LinkedHashMap) this.k).clear();
        ((ArrayList) this.e).clear();
        ((ArrayList) this.f).clear();
        ((ArrayList) this.g).clear();
        ((ArrayList) this.h).clear();
        ((ArrayList) this.i).clear();
        ((ArrayList) this.j).clear();
        this.p = null;
        IVisibilityControlBrickService r5 = this.n;
        if (r5 == null) goto L15;
        IVisibilityControlService r6 = r5.provideVisibilityControlService(((Widget) this).dataCenter);
        if (r6 == null) goto L15;
        r6.clearControlWidget();
    L15:
        this.n = null;
        ((ArrayList) this.v).clear();
        Disposable r7 = this.m;
        if (r7 != null) goto L18;
    L23:
        this.m = null;
        this.q.dispose();
        return;
    L18:
        if (r7.isDisposed() == false) goto L21;
        r7 = null;
    L21:
        if (r7 == null) goto L23;
        r7.dispose();
        goto L23
    L9:
        r4 = 0;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    public LiveVisibilityControlWidget() {
        this.a = "PlayerVisibilityControllerWidget[" + hashCode() + ']';
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new LinkedHashMap();
        this.q = new CompositeDisposable();
        this.v = new ArrayList();
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        this.w = false;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        Mq();
        LiveVisibilityControlContext r0 = this.p;
        if (r0 == null) goto L5;
        r0.getPlayerViewVisibleTriggeredByUser().setValue(Boolean.FALSE);
    L5:
        this.w = true;
    }

    public static void Lq(List r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$refreshViewPosition");
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((com.bytedance.android.live.room.api.visibilitycontrol.d) r2.next()).a();
        goto L4
    }

    public final void addControlItem(com.bytedance.android.live.room.api.visibilitycontrol.d r9) {
        Intrinsics.checkNotNullParameter(r9, "item");
        ALogger.d(this.a, "start addControl Item for " + r9.f.getDescribe());
        removeControlItem(r9.f);
        switch(e1.b[r9.getType().ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L11;
        };
    L5:
        ((ArrayList) this.f).add(r9);
        goto L11
    L6:
        ((ArrayList) this.e).add(r9);
        goto L11
    L7:
        ((ArrayList) this.j).add(r9);
        goto L11
    L8:
        ((ArrayList) this.i).add(r9);
        goto L11
    L9:
        ((ArrayList) this.h).add(r9);
        goto L11
    L10:
        ((ArrayList) this.g).add(r9);
    L11:
        View r0 = r9.h;
        r0.setAlpha(1.0f);
        r0.setTranslationY(0.0f);
        r0.setTranslationX(0.0f);
        this.k.put(r9.f, r9);
        LiveVisibilityControlContext r1 = this.p;
        if (r1 == null) goto L18;
        com.bytedance.live.datacontext.m r2 = r1.getViewVisibleMutable();
        if (r2 == null) goto L18;
        boolean r3 = true;
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L18;
    L19:
        boolean r4 = !r3;
        Integer r5 = (Integer) r9.e.getValue();
        if (r5 != null) goto L23;
    L25:
        ((ArrayList) this.v).clear();
        switch(e1.a[r9.getType().ordinal()]) {
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            default: goto L34;
        };
    L28:
        Cq(CollectionsKt.listOf(r9), r3, false, 0);
        goto L34
    L29:
        Fq(CollectionsKt.listOf(r9), r3, false, 0);
        goto L34
    L30:
        Iq(CollectionsKt.listOf(r9), r3, false, 0);
        goto L34
    L31:
        Gq(CollectionsKt.listOf(r9), r3, false, 0);
        goto L34
    L32:
        Eq(CollectionsKt.listOf(r9), r3, false, 0);
        goto L34
    L33:
        Jq(CollectionsKt.listOf(r9), r3, false, 0);
    L34:
        AnimatorSet r6 = new AnimatorSet();
        r6.playTogether(this.v);
        r6.start();
        ALogger.d(this.a, "add control item and init it's status Item:[" + r9.f.getDescribe() + "] Visibility to [" + r3 + ']');
        return;
    L23:
        if (r5.intValue() != r4) goto L25;
        return;
    L18:
        r3 = false;
        goto L19
    }

    public final void onChanged(Object r14) {
        KVData r15 = (KVData) r14;
        if (r15 == null) goto L52;
        String r16 = r15.getKey();
        if (r16.hashCode() == (-1836833765)) goto L8;
        return;
    L8:
        if (r16.equals("cmd_widget_loaded") == false) goto L53;
        Kq();
        WidgetManager r17 = this.b;
        if (r17 == null) goto L54;
        Iterator r18 = r17.widgetViewGroupHashMap.entrySet().iterator();
    L13:
        if (r18.hasNext() == false) goto L22;
        Map.Entry r0 = (Map.Entry) r18.next();
        Widget r1 = (Widget) r0.getKey();
        LiveVisibilityControl r2 = r1.getClass().getAnnotation(LiveVisibilityControl.class);
        if (r2 == null) goto L13;
        ViewGroup r6 = (ViewGroup) r0.getValue();
        if (r6 == null) goto L13;
        LiveVisibilityControl.KEY r4 = r2.key();
        if ((r1 instanceof com.bytedance.android.live.room.api.visibilitycontrol.a) == true) goto L21;
        r1 = null;
    L21:
        addControlItem(new com.bytedance.android.live.room.api.visibilitycontrol.d(r4, (com.bytedance.android.live.room.api.visibilitycontrol.a) r1, r6, r2.type(), r2.style(), r2.attachMarginDp(), r2.needDynamicControl(), r2.ignoreLock(), r2.reverse()));
        goto L13
    L22:
        LiveVisibilityControlContext r19 = this.p;
        if (r19 == null) goto L29;
        ALogger.d(this.a, "initViewList: tmp list size:" + r19.getTmpControlItemList().size());
        Iterator r3 = r19.getTmpControlItemList().iterator();
    L26:
        if (r3.hasNext() == false) goto L28;
        addControlItem((com.bytedance.android.live.room.api.visibilitycontrol.d) r3.next());
        goto L26
    L28:
        r19.getTmpControlItemList().clear();
    L29:
        this.c = true;
        RoomContext.a r5 = RoomContext.Companion;
        RoomContext r7 = RoomContext.a.c(r5, ((Widget) this).dataCenter, 0, 2);
        if (r7 != null) goto L32;
    L38:
        ALogger.d(this.a, "init complete. size: \ndirect[" + ((ArrayList) this.e).size() + "]\nalpha[" + ((ArrayList) this.f).size() + "]\ntop[" + ((ArrayList) this.g).size() + "]\nbottom[" + ((ArrayList) this.h).size() + "]\nleft[" + ((ArrayList) this.i).size() + "]\nright[" + ((ArrayList) this.j).size() + "]\n");
        if (this.d == false) goto L55;
        LiveVisibilityControlContext r110 = this.p;
        if (r110 == null) goto L56;
        r110.setViewVisibleValue(((Boolean) r110.getViewVisibleMutable().getValue()).booleanValue());
        ALogger.w(this.a, "beforeInitStatusChangeFlag == true, refresh status");
        return;
    L56:
        return;
    L55:
        return;
    L32:
        if (r7.isVSRoom() != true) goto L38;
        RoomContext r111 = RoomContext.a.c(r5, ((Widget) this).dataCenter, 0, 2);
        if (r111 == null) goto L38;
        com.bytedance.live.datacontext.k r112 = r111.getMatchPlayerControlInitComplete();
        if (r112 == null) goto L38;
        r112.post(Boolean.TRUE);
        goto L38
    L54:
        return;
    L53:
        return;
    }

    public final void onLoad(Object[] r5) {
        IVisibilityControlBrickService r6 = jc1.k.f(IVisibilityControlBrickService.class);
        this.n = r6;
        LiveVisibilityControlContext r0 = null;
        if (r6 == null) goto L5;
        IVisibilityControlService r7 = r6.provideVisibilityControlService(((Widget) this).dataCenter);
    L6:
        this.o = r7;
        if (r7 == null) goto L9;
        r7.registerControlWidget(this);
    L9:
        String r8 = this.a;
        StringBuilder r1 = new StringBuilder("start onLoad: dataCenter:");
        r1.append(((Widget) this).dataCenter.hashCode());
        r1.append(", viewControlService:");
        IVisibilityControlBrickService r2 = this.n;
        if (r2 == null) goto L14;
        IVisibilityControlService r3 = r2.provideVisibilityControlService(((Widget) this).dataCenter);
        if (r3 == null) goto L14;
        Integer r4 = Integer.valueOf(r3.hashCode());
    L15:
        r1.append(r4);
        ALogger.d(r8, r1.toString());
        this.c = false;
        this.d = false;
        IVisibilityControlBrickService r9 = this.n;
        if (r9 == null) goto L20;
        IVisibilityControlService r10 = r9.provideVisibilityControlService(((Widget) this).dataCenter);
        if (r10 == null) goto L20;
        WidgetManager r11 = r10.getWidgetManager();
    L21:
        this.b = r11;
        this.w = false;
        this.q = new CompositeDisposable();
        ((ArrayList) this.v).clear();
        IVisibilityControlBrickService r12 = this.n;
        if (r12 == null) goto L26;
        IVisibilityControlService r13 = r12.provideVisibilityControlService(((Widget) this).dataCenter);
        if (r13 == null) goto L26;
        r0 = r13.provideContext();
    L26:
        this.p = r0;
        if (r0 == null) goto L34;
        r0.setViewVisibleValue(r0.getInitVisible());
        Disposable r14 = r0.getViewVisibleMutable().a().subscribe(new b(r0, this));
        if (r14 == null) goto L31;
        RxUtilKt.c(r14, this.q);
    L31:
        Disposable r15 = r0.getResetHideTaskEvent().onEvent().subscribe(new c(this));
        if (r15 == null) goto L34;
        RxUtilKt.c(r15, this.q);
    L34:
        LandscapeInteractionModel r16 = getViewModel(LandscapeInteractionModel.class);
        r16.isLocked().observe(this, new d(this));
        r16.isInZoomState().observe(this, new e(this));
        ((Widget) this).dataCenter.observe("cmd_widget_loaded", this);
        com.bytedance.android.livesdk.f.d().a.observe(this, new f(this));
        return;
    L20:
        r11 = null;
    L14:
        r4 = null;
        goto L15
    L5:
        r7 = null;
        goto L6
    }

    public final void removeControlItem(LiveVisibilityControl.KEY r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        com.bytedance.android.live.room.api.visibilitycontrol.d r4 = (com.bytedance.android.live.room.api.visibilitycontrol.d) ((LinkedHashMap) this.k).get(r3);
        if (r4 == null) goto L15;
        LiveVisibilityControl.Type r0 = r4.getType();
        switch(e1.c[r0.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        ((ArrayList) this.f).remove(r4);
        return;
    L9:
        ((ArrayList) this.e).remove(r4);
        return;
    L10:
        ((ArrayList) this.j).remove(r4);
        return;
    L11:
        ((ArrayList) this.i).remove(r4);
        return;
    L12:
        ((ArrayList) this.h).remove(r4);
        return;
    L13:
        ((ArrayList) this.g).remove(r4);
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    public final NextLiveData<Integer> wd(LiveVisibilityControl.KEY r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        com.bytedance.android.live.room.api.visibilitycontrol.d r3 = (com.bytedance.android.live.room.api.visibilitycontrol.d) ((LinkedHashMap) this.k).get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.e;
    }

    public final void Gc(LiveVisibilityControl.KEY r7, boolean r8, long r9) {
        Intrinsics.checkNotNullParameter(r7, "key");
        com.bytedance.android.live.room.api.visibilitycontrol.d r0 = (com.bytedance.android.live.room.api.visibilitycontrol.d) ((LinkedHashMap) this.k).get(r7);
        if (r0 != null) goto L5;
        return;
    L5:
        ((ArrayList) this.v).clear();
        switch(e1.d[r0.getType().ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L14;
        };
    L8:
        Cq(CollectionsKt.listOf(r0), r8, true, r9);
        goto L14
    L9:
        Fq(CollectionsKt.listOf(r0), r8, true, r9);
        goto L14
    L10:
        Iq(CollectionsKt.listOf(r0), r8, true, r9);
        goto L14
    L11:
        Gq(CollectionsKt.listOf(r0), r8, true, r9);
        goto L14
    L12:
        Eq(CollectionsKt.listOf(r0), r8, true, r9);
        goto L14
    L13:
        Jq(CollectionsKt.listOf(r0), r8, true, r9);
    L14:
        AnimatorSet r1 = new AnimatorSet();
        r1.playTogether(this.v);
        r1.start();
        ALogger.d(this.a, "start change Item:[" + r7.getDescribe() + "] Visibility to [" + r8 + ']');
    }

    public static final Animator wq(LiveVisibilityControlWidget r2, View r3, float r4, long r5) {
        r2.getClass();
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r3, "alpha", new float[]{r3.getAlpha(), r4});
        r6.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r6.setDuration(r5);
        return r6;
    }

    public final void Bq(List<com.bytedance.android.live.room.api.visibilitycontrol.d> r8, Function1<? super com.bytedance.android.live.room.api.visibilitycontrol.d, Unit> r9, boolean r10, boolean r11) {
        ArrayList r0 = new ArrayList();
        r0.addAll(r8);
        LiveVisibilityControlContext r12 = this.p;
        List r1 = r0;
        if (r12 == null) goto L16;
        com.bytedance.live.datacontext.m r13 = r12.isLocked();
        r1 = r0;
        if (r13 == null) goto L16;
        r1 = r0;
        r1 = r0;
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L16;
        if (r10 == false) goto L16;
        ArrayList r14 = new ArrayList();
        Iterator r2 = r0.iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        if (((com.bytedance.android.live.room.api.visibilitycontrol.d) r3).m == false) goto L11;
        r14.add(r3);
        goto L11
    L15:
        r1 = CollectionsKt.toMutableList(r14);
    L16:
        Iterator r15 = r1.iterator();
    L18:
        if (r15.hasNext() == false) goto L36;
        com.bytedance.android.live.room.api.visibilitycontrol.d r4 = (com.bytedance.android.live.room.api.visibilitycontrol.d) r15.next();
        if (r4.l == false) goto L21;
        if (r11 == true) goto L23;
        com.bytedance.android.live.room.api.visibilitycontrol.a r5 = r4.g;     // Catch: Exception -> L30
        if ((r5 instanceof com.bytedance.android.live.room.api.visibilitycontrol.a) == false) goto L32;
        if (r5 == null) goto L29;
        boolean r6 = r5.Uh(r4.f);     // Catch: Exception -> L30
    L33:
        if (r6 == true) goto L34;
        ALogger.i(this.a, "dynamic check failed, skip action [" + r10 + "] for " + r4.f.getDescribe());
        goto L18
    L34:
        ALogger.i(this.a, "dynamic check success, start do action [" + r10 + "] for " + r4.f.getDescribe());
        r9.invoke(r4);
        goto L18
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.api.visibilitycontrol.ILiveVisibilityControlFlag");     // Catch: Exception -> L30
    L32:
        r6 = true;
    L30:
        e = move-exception;
        ALogger.e(this.a, "canHandleByAnnotation: " + e);
        goto L32
    L23:
        r9.invoke(r4);
        ALogger.w(this.a, "skip dynamic check for " + r4.f.getDescribe() + " when visible [" + r10 + ']');
        goto L18
    L21:
        ALogger.i(this.a, "start do action [" + r10 + "] for " + r4.f.getDescribe());
        r9.invoke(r4);
        goto L18
    }

    public final void Cq(List<com.bytedance.android.live.room.api.visibilitycontrol.d> r2, boolean r3, boolean r4, long r5) {
        if (((ArrayList) this.f).isEmpty() == false) goto L5;
        return;
    L5:
        Bq(r2, new LiveVisibilityControlWidget$handleAlphaViews$2(new LiveVisibilityControlWidget$handleAlphaViews$1(this, r3, r5)), r3, r4);
    }

    public final void Eq(List<com.bytedance.android.live.room.api.visibilitycontrol.d> r2, boolean r3, boolean r4, long r5) {
        if (((ArrayList) this.h).isEmpty() == false) goto L5;
        return;
    L5:
        Bq(r2, new LiveVisibilityControlWidget$handleBottomViews$2(new LiveVisibilityControlWidget$handleBottomViews$1(this, r3, r5)), r3, r4);
    }

    public final void Fq(List<com.bytedance.android.live.room.api.visibilitycontrol.d> r2, boolean r3, boolean r4, long r5) {
        if (((ArrayList) this.e).isEmpty() == false) goto L5;
        return;
    L5:
        Bq(r2, new LiveVisibilityControlWidget$handleDirectHideViews$2(new LiveVisibilityControlWidget$handleDirectHideViews$1(this, r3, r5)), r3, r4);
    }

    public final void Gq(List<com.bytedance.android.live.room.api.visibilitycontrol.d> r2, boolean r3, boolean r4, long r5) {
        if (((ArrayList) this.i).isEmpty() == false) goto L5;
        return;
    L5:
        Bq(r2, new LiveVisibilityControlWidget$handleLeftViews$2(new LiveVisibilityControlWidget$handleLeftViews$1(this, r3, r5)), r3, r4);
    }

    public final void Iq(List<com.bytedance.android.live.room.api.visibilitycontrol.d> r2, boolean r3, boolean r4, long r5) {
        if (((ArrayList) this.j).isEmpty() == false) goto L5;
        return;
    L5:
        Bq(r2, new LiveVisibilityControlWidget$handleRightViews$2(new LiveVisibilityControlWidget$handleRightViews$1(this, r3, r5)), r3, r4);
    }

    public final void Jq(List<com.bytedance.android.live.room.api.visibilitycontrol.d> r2, boolean r3, boolean r4, long r5) {
        if (((ArrayList) this.g).isEmpty() == false) goto L5;
        return;
    L5:
        Bq(r2, new LiveVisibilityControlWidget$handleTopViews$2(new LiveVisibilityControlWidget$handleTopViews$1(this, r3, r5)), r3, r4);
    }

    public static final Animator Aq(LiveVisibilityControlWidget r1, View r2, float r3, float r4, long r5) {
        r1.getClass();
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r2, "translationY", new float[]{r3, r4});
        r6.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r6.setDuration(r5);
        return r6;
    }

    public static final Animator zq(LiveVisibilityControlWidget r1, View r2, float r3, float r4, long r5) {
        r1.getClass();
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r2, "translationX", new float[]{r3, r4});
        r6.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r6.setDuration(r5);
        return r6;
    }

    public static final Animator xq(LiveVisibilityControlWidget r1, View r2, float r3, float r4, float r5, long r6) {
        r1.getClass();
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{r3, r4});
        r7.addUpdateListener(new g1(r5, r2));
        r7.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r7.setDuration(r6);
        return r7;
    }

    public static final Animator yq(LiveVisibilityControlWidget r1, View r2, float r3, float r4, float r5, long r6) {
        r1.getClass();
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{r3, r4});
        r7.addUpdateListener(new h1(r5, r2));
        r7.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r7.setDuration(r6);
        return r7;
    }
}
