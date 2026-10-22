package com.bytedance.android.livesdk.chatroom.vs.widget.landscape;

import android.content.Context;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.danmaku.VSDanmakuContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.vs.gesture.VSGestureViewManagerHelper;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdk.widget.gesture.BrightnessView;
import com.bytedance.android.livesdk.widget.gesture.IndicatorView;
import com.bytedance.android.livesdk.widget.gesture.VolumeView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fjc.g;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import pm1.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/widget/landscape/MatchRoomLandscapeGestureWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/view/View$OnTouchListener;", "Lp70/d;", "<init>", "()V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchRoomLandscapeGestureWidget extends LiveRecyclableWidget implements Observer<KVData>, View.OnTouchListener, p70.d {
    public static final int G = 0;
    public final b A;
    public ko1.c B;
    public boolean C;
    public boolean D;
    public double E;
    public long F;
    public IRoom a;
    public IndicatorView b;
    public MatchRoomGestureHelper c;
    public VelocityTracker d;
    public boolean e;
    public int f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public long n;
    public BrightnessView o;
    public VolumeView p;
    public RelativeLayout q;
    public GestureDetector r;
    public com.bytedance.android.livesdk.chatroom.vsplayer.api.c s;
    public WeakReference<View> t;
    public WeakReference<View> u;
    public Disposable v;
    public final c w;
    public final boolean x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements p70.c<ah1.e> {
        public final /* synthetic */ MatchRoomLandscapeGestureWidget a;

        public final Class<? extends p70.a<ah1.e>> b() {
            return ah1.b.class;
        }

        public b(MatchRoomLandscapeGestureWidget r1) {
            this.a = r1;
        }

        public final boolean a(Object r8) {
            ah1.e r9 = (ah1.e) r8;
            Intrinsics.checkNotNullParameter(r9, "param");
            boolean r1 = false;
            if (this.a.x == true) goto L6;
            return false;
        L6:
            if (r9.b.getAction() != 0) goto L18;
            MatchRoomLandscapeGestureWidget r0 = this.a;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r2 = r0.s;
            if (r2 == null) goto L16;
            VSPlayerViewControlContext r3 = r2.provideContext();
            if (r3 == null) goto L16;
            m<Boolean> r4 = r3.getPlayerViewIsInZoom();
            if (r4 == null) goto L16;
            Boolean r5 = (Boolean) r4.getValue();
            if (r5 == null) goto L16;
            boolean r6 = r5.booleanValue();
        L17:
            r0.z = r6;
        L16:
            r6 = false;
        L18:
            MatchRoomLandscapeGestureWidget r7 = this.a;
            if (r7.z == true) goto L87;
            MotionEvent r10 = r9.b;
            Intrinsics.checkNotNullParameter(r10, "event");
            if (r7.D == false) goto L27;
            int r11 = r10.getAction() & 255;
            if (r11 == 1) goto L26;
            if (r11 == 3) goto L26;
        L81:
            r1 = true;
        L84:
            if (r1 == false) goto L87;
            return true;
        L26:
            r7.C = false;
            r7.D = false;
            goto L81
        L27:
            IRoom r12 = r7.a;
            if (r12 == null) goto L84;
            if (r12.isMergeVSRoom() != true) goto L84;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r13 = r7.s;
            if (r13 != null) goto L35;
        L37:
            boolean r14 = false;
        L38:
            if (r14 == true) goto L84;
            if (RoomKt.hasMultiCamera(r7.a) == false) goto L42;
        L44:
            WeakReference<View> r15 = r7.u;
            if (r15 == null) goto L49;
            View r16 = r15.get();
            if (r16 == null) goto L49;
            float r17 = r16.getScaleX();
        L51:
            if (r17 != 1.0f) goto L84;
            int r18 = r10.getAction() & 255;
            if (r18 != 1) goto L56;
        L82:
            r7.C = false;
            r7.D = false;
        L83:
            r1 = r7.D;
            goto L84
        L56:
            if (r18 == 2) goto L69;
            if (r18 == 3) goto L82;
            if (r18 != 5) goto L83;
            int r19 = r10.getPointerCount();
            if (r19 == 2) goto L64;
        L66:
            if (r19 < 3) goto L83;
            r7.C = true;
            goto L83
        L64:
            if (r7.C == true) goto L66;
            r7.E = MatchRoomLandscapeGestureWidget.wq(r10);
            goto L83
        L69:
            if (r10.getPointerCount() != 2) goto L83;
            if (r7.C == true) goto L83;
            if ((MatchRoomLandscapeGestureWidget.wq(r10) - r7.E) >= (-30)) goto L83;
            Context r20 = ((Widget) r7).context;
            DataCenter r21 = ((Widget) r7).dataCenter;
            if (r20 == null) goto L80;
            if (r21 == null) goto L80;
            nm1.a r22 = (nm1.a) h.d.c(nm1.a.class);
            if (r22 == null) goto L80;
            r22.a(((Widget) r7).context, ((Widget) r7).dataCenter);
        L80:
            r7.D = true;
        L49:
            r17 = 1.0f;
            goto L51
        L42:
            if (lu2.c.b(r7.a) == true) goto L44;
        L35:
            if (r13.getLockStatus() != true) goto L37;
            r14 = true;
        L87:
            return this.a.onTouch(r9.a, r9.b);
        }
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ MatchRoomLandscapeGestureWidget a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
        }

        public c(MatchRoomLandscapeGestureWidget r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r5) {
            Intrinsics.checkNotNullParameter(r5, "e");
            ReplayDataContext.a r6 = ReplayDataContext.Companion;
            DataCenter r0 = ((Widget) this.a).dataCenter;
            r6.getClass();
            ReplayDataContext r7 = ReplayDataContext.a.b(r0);
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r1 = null;
            if (r7 == null) goto L11;
            j<VSDanmakuContext> r8 = r7.getVsDanmakuContext();
            if (r8 == null) goto L11;
            VSDanmakuContext r9 = (VSDanmakuContext) r8.getValue();
            if (r9 == null) goto L11;
            m r10 = r9.isDanmakuHandlePopupShow();
            if (r10 == null) goto L11;
            Boolean r11 = (Boolean) r10.getValue();
        L12:
            Logger.d("LandscapeGestureWidget", "onSingleTapConfirmed start danmakuPopShow=" + r11);
            if (Intrinsics.areEqual(r.b().F(((Widget) this.a).dataCenter), Boolean.FALSE) == true) goto L15;
            return false;
        L15:
            if ((!Intrinsics.areEqual(r11, Boolean.TRUE)) == false) goto L28;
            Logger.d("LandscapeGestureWidget", "onSingleTapConfirmed changeVisibilityStatus");
            IVSPlayerService r12 = (IVSPlayerService) k.f(IVSPlayerService.class);
            if (r12 == null) goto L19;
            r1 = r12.provideVSPlayerViewControlService(((Widget) this.a).dataCenter);
        L19:
            if (r1 == null) goto L21;
            r1.changeVisibilityStatus();
        L21:
            if (r1 != null) goto L23;
            return false;
        L23:
            if (r1.getVisibilityStatus() != true) goto L30;
            r1.markVisibilityStatusChangeByUser();
            return false;
        L30:
            return false;
        L28:
            return false;
        L11:
            r11 = null;
            goto L12
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ MatchRoomLandscapeGestureWidget a;

        public d(MatchRoomLandscapeGestureWidget r1) {
            this.a = r1;
        }

        public final void a() {
            IVSPlayerService r1 = (IVSPlayerService) k.f(IVSPlayerService.class);
            if (r1 == null) goto L11;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r2 = r1.provideVSPlayerViewControlService(((Widget) this.a).dataCenter);
            if (r2 == null) goto L12;
            MatchRoomLandscapeGestureWidget r3 = this.a;
            BrightnessView r7 = r3.o;
            VolumeView r4 = r3.p;
            if (r7 == null) goto L13;
            if (r4 == null) goto L14;
            PlayerViewControl.KEY r5 = PlayerViewControl.KEY.BrightnessView;
            PlayerViewControl.Type r13 = PlayerViewControl.Type.TOP;
            PlayerViewControl.Style r14 = PlayerViewControl.Style.ATTACH;
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r2, r5, r13, r14, r7, 20.0f, false, false, null, 480);
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r2, PlayerViewControl.KEY.VolumeView, r13, r14, r4, 20.0f, false, false, null, 480);
            return;
        L14:
            return;
        L13:
            return;
        L12:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ MatchRoomLandscapeGestureWidget a;

        public e(MatchRoomLandscapeGestureWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.y = !((Boolean) r2).booleanValue();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.vs.widget.landscape.MatchRoomLandscapeGestureWidget$onLoad$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "p2", "p3", "Landroid/view/KeyEvent;", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function3<Integer, Integer, KeyEvent, Unit> {
        public AnonymousClass2(MatchRoomLandscapeGestureWidget r8) {
            super(3, r8, MatchRoomLandscapeGestureWidget.class, "onActivityKeyEvent", "onActivityKeyEvent(IILandroid/view/KeyEvent;)V", 0);
        }

        public final void invoke(int r2, int r3, KeyEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "p3");
            MatchRoomLandscapeGestureWidget r5 = (MatchRoomLandscapeGestureWidget) ((CallableReference) this).receiver;
            int r0 = MatchRoomLandscapeGestureWidget.G;
            r5.getClass();
            if (r2 == 0) goto L6;
            return;
        L6:
            if (r3 != 24) goto L8;
            VolumeView r6 = r5.p;
            if (r6 == null) goto L19;
            r6.a();
        L19:
            VolumeView r7 = r5.p;
            if (r7 == null) goto L25;
            r7.e();
            return;
        L25:
            return;
        L8:
            if (r3 != 25) goto L27;
            VolumeView r8 = r5.p;
            if (r8 == null) goto L13;
            r8.f();
        L13:
            VolumeView r9 = r5.p;
            if (r9 == null) goto L23;
            r9.e();
            return;
        L23:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            invoke(((Number) r1).intValue(), ((Number) r2).intValue(), (KeyEvent) r3);
            return Unit.INSTANCE;
        }
    }

    public final int getLayoutId() {
        return 2131566882;
    }

    public final void onInit(Object[] r1) {
    }

    static {
        G = s1.f(15.0f);
    }

    public final Set<p70.c<?>> ud() {
        return SetsKt.setOf(this.A);
    }

    public MatchRoomLandscapeGestureWidget() {
        this.w = new c(this);
        this.x = true;
        this.y = true;
        this.A = new b(this);
    }

    public final void onUnload() {
        VSGestureViewManagerHelper.b();
        this.B = null;
        VolumeView r1 = this.p;
        if (r1 == null) goto L5;
        r1.hide();
    L5:
        BrightnessView r2 = this.o;
        if (r2 == null) goto L8;
        r2.hide();
    L8:
        Disposable r3 = this.v;
        if (r3 == null) goto L11;
        r3.dispose();
    L11:
        this.v = null;
    }

    public static double wq(MotionEvent r4) {
        if (r4.getPointerCount() != 2) goto L5;
        float r1 = r4.getX(0) - r4.getX(1);
        float r0 = r4.getY(0) - r4.getY(1);
        return Math.sqrt((r1 * r1) + (r0 * r0));
    L5:
        return 0.0d;
    }

    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        KVData r2 = (KVData) r1;
    }

    public final void onLoad(Object[] r6) {
        this.c = new MatchRoomGestureHelper(((Widget) this).dataCenter, ((Widget) this).context, ((Widget) this).contentView);
        IVSPlayerService r7 = (IVSPlayerService) k.f(IVSPlayerService.class);
        m<Boolean> r0 = null;
        if (r7 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r8 = r7.provideVSPlayerViewControlService(((Widget) this).dataCenter);
    L6:
        this.s = r8;
        this.q = (RelativeLayout) findViewById(2131392947);
        BrightnessView r9 = findViewById(2131392887);
        this.o = r9;
        if (r9 == null) goto L9;
        r9.h(g.getActivity(getContext()).getWindow());
    L9:
        BrightnessView r10 = this.o;
        if (r10 == null) goto L12;
        r10.g(((Widget) this).dataCenter);
    L12:
        this.p = findViewById(2131392976);
        this.r = new GestureDetector(((Widget) this).context, this.w);
        VolumeView r11 = this.p;
        if (r11 == null) goto L15;
        r11.post(new d(this));
    L15:
        r.f().q(this, new AnonymousClass2(this));
        r.f().F(((Widget) this).dataCenter);
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L68;
        IRoom r13 = (IRoom) r12.get("data_room");
        if (r13 == null) goto L69;
        this.a = r13;
        BrightnessView r1 = this.o;
        if (r1 == null) goto L23;
        Intrinsics.checkNotNullParameter(r13, "room");
        r1.p = r13;
    L23:
        boolean r2 = true;
        if (r3.l(((Widget) this).context) == false) goto L29;
        RelativeLayout r14 = this.q;
        if (r14 == null) goto L28;
        r14.setFocusable(true);
    L28:
        r3.c(this.q, s1.B(2131921595), true);
    L29:
        Pair<WeakReference<View>, WeakReference<View>> r15 = r.p().getLivePlayerView();
        this.t = (WeakReference) r15.getFirst();
        this.u = (WeakReference) r15.getSecond();
        IPlayerProgressService r16 = k.n(rk1.a.class).M4(((Widget) this).dataCenter);
        if (r16 == null) goto L38;
        PlayerProgressServiceContext r17 = r16.provideContext(((Widget) this).dataCenter);
        if (r17 == null) goto L38;
        m r18 = r17.getDisableSeek();
        if (r18 == null) goto L38;
        if (((Boolean) r18.getValue()).booleanValue() == true) goto L38;
    L39:
        this.y = r2;
        IPlayerProgressService r19 = k.n(rk1.a.class).M4(((Widget) this).dataCenter);
        if (r19 == null) goto L48;
        PlayerProgressServiceContext r20 = r19.provideContext(((Widget) this).dataCenter);
        if (r20 == null) goto L48;
        m r21 = r20.getDisableSeek();
        if (r21 == null) goto L48;
        Observable r22 = r21.a();
        if (r22 == null) goto L48;
        Disposable r23 = r22.subscribe(new e(this));
    L49:
        this.v = r23;
        WeakReference<View> r24 = this.u;
        if (r24 == null) goto L66;
        View r25 = r24.get();
        if (r25 == null) goto L66;
        ko1.c r3 = VSGestureViewManagerHelper.a;
        DataCenter r4 = ((Widget) this).dataCenter;
        Context r5 = ((Widget) this).context;
        WeakReference<View> r26 = this.t;
        if (r26 == null) goto L56;
        View r27 = r26.get();
    L57:
        if (r27 == null) goto L65;
        ViewGroup r28 = (ViewGroup) r27;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r29 = this.s;
        if (r29 == null) goto L63;
        VSPlayerViewControlContext r30 = r29.provideContext();
        if (r30 == null) goto L63;
        r0 = r30.getPlayerViewIsInZoom();
    L63:
        r0 = VSGestureViewManagerHelper.a(r4, r5, r25, r28, r0);
        goto L66
    L65:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L56:
        r27 = null;
    L66:
        this.B = r0;
        return;
    L48:
        r23 = null;
    L38:
        r2 = false;
        goto L39
    L69:
        return;
    L68:
        return;
    L5:
        r8 = null;
        goto L6
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r18, MotionEvent r19) {
        Intrinsics.checkNotNullParameter(r18, "view");
        Intrinsics.checkNotNullParameter(r19, "event");
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        boolean r6 = false;
        Logger.d("LandscapeGestureWidget", String.format("onTouchEvent, Event={%f, %f}, action=%d", Arrays.copyOf(new Object[]{Float.valueOf(r19.getX()), Float.valueOf(r19.getY()), Integer.valueOf(r19.getAction())}, 3)));
        if (this.x == true) goto L6;
        return false;
    L6:
        if (r.A().d(((Widget) this).dataCenter) == false) goto L8;
        return false;
    L8:
        GestureDetector r4 = this.r;
        if (r4 == null) goto L11;
        r4.onTouchEvent(r19);
    L11:
        int r3 = r18.getWidth() / 2;
        int r5 = r19.getAction();
        long r9 = 0;
        if (r5 != 0) goto L14;
        this.f = 0;
        this.n = System.currentTimeMillis();
        ALogger.d("VSLandscapeGestureWidget", "Down!Interval:" + (this.n - this.F));
        this.F = this.n;
        this.g = r19.getX();
        this.h = r19.getY();
        this.m = 0.0f;
        this.l = r19.getX();
        r19.getY();
        r19.getX();
        s1.y();
        r19.getX();
        s1.y();
        float r7 = r3;
        if (r19.getX() >= r7) goto L112;
        boolean r8 = true;
    L113:
        if (r8 == false) goto L118;
        this.b = this.o;
        VolumeView r10 = this.p;
        if (r10 == null) goto L118;
        r10.hide();
    L118:
        if (r19.getX() <= r7) goto L120;
        r6 = true;
    L120:
        this.e = r6;
        if (r6 == false) goto L125;
        this.b = this.p;
        BrightnessView r11 = this.o;
        if (r11 == null) goto L125;
        r11.hide();
    L125:
        MatchRoomGestureHelper r12 = this.c;
        if (r12 == null) goto L135;
        IPlayerProgressService r13 = r12.a();
        if (r13 == null) goto L132;
        Long r14 = r13.getCurrentDisplayTimeInContext();
        if (r14 == null) goto L132;
        r9 = r14.longValue();
    L132:
        r12.a = r9;
        IPlayerProgressService r15 = r12.a();
        if (r15 == null) goto L135;
        r15.onProgressGestureStartTouch();
    L135:
        ko1.c r16 = this.B;
        if (r16 == null) goto L138;
        r16.c(r19);
    L138:
        return true;
    L112:
        r8 = false;
        goto L113
    L14:
        if (r5 == 1) goto L86;
        if (r5 == 2) goto L18;
        if (r5 == 3) goto L86;
    L18:
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r17 = this.s;
        if (r17 != null) goto L21;
    L23:
        boolean r20 = false;
    L24:
        if (r20 == false) goto L27;
        return false;
    L27:
        if (this.z == true) goto L78;
        if (r19.getPointerCount() != 1) goto L78;
        this.i = r19.getX() - this.g;
        this.j = r19.getY() - this.h;
        this.l = r19.getX() - this.k;
        this.k = r19.getX();
        float r21 = Math.abs(this.j);
        float r22 = G;
        if (r21 >= r22) goto L36;
        if (Math.abs(this.i) >= r22) goto L36;
        return false;
    L36:
        if (this.f == 0) goto L38;
    L42:
        int r23 = this.f;
        if (r23 == 1) goto L58;
        if (r23 != 2) goto L138;
        if (Math.abs(this.j - this.m) <= r22) goto L138;
        if ((this.j - this.m) >= 0) goto L53;
        IndicatorView r1 = this.b;
        if (r1 == null) goto L56;
        r1.a();
    L56:
        this.m = this.j;
        goto L138
    L53:
        IndicatorView r24 = this.b;
        if (r24 == null) goto L56;
        r24.f();
        goto L56
    L58:
        if (this.y == true) goto L61;
        Logger.d("LandscapeGestureWidget", "handleGestureSeek return");
        goto L138
    L61:
        if (this.d != null) goto L63;
        this.d = VelocityTracker.obtain();
    L63:
        VelocityTracker r25 = this.d;
        if (r25 == null) goto L138;
        r25.computeCurrentVelocity(BubbleId.PadCast);
        r25.addMovement(r19);
        MatchRoomGestureHelper r26 = this.c;
        if (r26 == null) goto L138;
        float r27 = this.l;
        float r28 = r25.getXVelocity();
        float r29 = s1.e(1.0f);
        int r30 = (int) (r26.c() / ((long) 60));
        float r110 = r26.b + (r27 / r29);
        r26.b = r110 % 0.1f;
        int r31 = RangesKt.coerceAtMost((int) (((Math.pow(((int) (((double) r110) / 0.1d)) * (r28 / r29), 2.0d) / ((double) 2000000)) + ((double) 3)) * ((double) 20)), r30);
        long r111 = r26.a;
        if (r27 > 0) goto L71;
        r31 = -r31;
    L71:
        r26.a = r111 + ((long) r31);
        if (r26.c() <= r26.b()) goto L74;
        r26.a = RangesKt.coerceIn(r26.a, r26.b(), RangesKt.coerceAtLeast(r26.c(), 0));
    L74:
        IPlayerProgressService r32 = r26.a();
        if (r32 == null) goto L138;
        r32.onProgressGestureTracking(r26.a, r26.c());
        goto L138
    L38:
        if (Math.abs(this.i) <= Math.abs(this.j)) goto L40;
        int r33 = 1;
    L41:
        this.f = r33;
        goto L42
    L40:
        r33 = 2;
    L78:
        if (this.z == false) goto L80;
    L81:
        this.f = 5;
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter).F0(PaidInteractEntry.CONTROL_ENTRY_PLAYER_SCALE_GESTURE) == false) goto L138;
        ko1.c r34 = this.B;
        if (r34 == null) goto L138;
        r34.c(r19);
        goto L138
    L80:
        if (r19.getPointerCount() != 2) goto L138;
    L21:
        if (r17.getLockStatus() != true) goto L23;
        r20 = true;
    L86:
        MatchRoomGestureHelper r35 = this.c;
        if (r35 == null) goto L91;
        IPlayerProgressService r36 = r35.a();
        if (r36 == null) goto L91;
        r36.onProgressGestureEndTouch();
    L91:
        int r37 = this.f;
        if (r37 == 2) goto L101;
        if (r37 != 5) goto L138;
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter).F0(PaidInteractEntry.CONTROL_ENTRY_PLAYER_SCALE_GESTURE) == false) goto L100;
        ko1.c r38 = this.B;
        if (r38 == null) goto L100;
        r38.c(r19);
    L100:
        return true;
    L101:
        HashMap r39 = new HashMap();
        r39.put("vs_screen_type", "landscape");
        if (this.e == false) goto L104;
        String r40 = "voice_adjust_gesture";
    L105:
        r.l().q(((Widget) this).dataCenter, r40, r39);
        IndicatorView r41 = this.b;
        if (r41 == null) goto L108;
        r41.e();
    L108:
        return true;
    L104:
        r40 = "bright_adjust_gesture";
        goto L105
    }
}
