package com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.room.y;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import com.bytedance.android.livesdk.chatroom.event.ToolbarClearScreenEvent;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.q;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.n;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.p;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.LiveRecordWidget;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.landscape.r;
import com.bytedance.android.livesdk.clearscreen.h;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.config.bl;
import com.bytedance.android.livesdk.utils.t3;
import com.bytedance.android.livesdk.viewmodel.DrawCleanScreenViewModel;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenManagerAbility;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.chatroom.clearscreen.IClearScreenManagerFactory;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zg1.l0;
import zg1.n0;
import zg1.o0;
import zg1.o2;
import zg1.p0;
import zg1.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/clearscreen/ClearScreenCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/clearscreen/b;", "Len1/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lzg1/n0;", "event", "", "onEvent", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ClearScreenCompositeWidget extends MiddlewareRoomWidget implements com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b, en1.a, Observer<KVData> {
    public static final /* synthetic */ int f = 0;
    public final int a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c b;
    public com.bytedance.android.livesdk.chatroom.ui.framework.d c;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a d;
    public final CompositeDisposable e;

    public static final class a {
    }

    public static final class b implements IClearScreenManagerFactory {
        public b() {
        }

        public final jg1.b create(String r2) {
            return new h(r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ClearScreenCompositeWidget a;

        public c(ClearScreenCompositeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.Eq(((n.a) ((h80.c) r2).a()).a);
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ ClearScreenCompositeWidget a;

        public d(ClearScreenCompositeWidget r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            ClearScreenCompositeWidget r4 = this.a;
            int r0 = ClearScreenCompositeWidget.f;
            com.bytedance.android.livesdk.chatroom.ui.framework.a r5 = r4.d;
            if (r5 == null) goto L7;
            Intrinsics.checkNotNullParameter(r5, "$this$getClearScreenWaterInterface");
            Element<?> r6 = r5.w8(d90.d.a.H0);
            if (r6 == null) goto L7;
            com.bytedance.android.livesdk.chatroom.tetris.portrait.a r7 = (com.bytedance.android.livesdk.chatroom.tetris.portrait.a) r6.f(com.bytedance.android.livesdk.chatroom.tetris.portrait.a.class);
        L8:
            if (r7 != null) goto L10;
        L13:
            xs2.b.a().post(new s(true));
            IPerformanceManager r8 = k.f(IPerformanceManager.class);
            if (r8 == null) goto L17;
            r8.onEnterFullScreenClean();
            return;
        L17:
            return;
        L10:
            if (wt2.a.e(Boolean.valueOf(this.a.isAnchor())) == true) goto L12;
            r7.t(0);
            goto L13
        L12:
            r7.i();
        L7:
            r7 = null;
            goto L8
        }
    }

    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ ClearScreenCompositeWidget a;

        public e(ClearScreenCompositeWidget r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            this.a.F5(0);
            xs2.b.a().post(new s(false));
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ Room b;

        public f(View r1, Room r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            this.a.setVisibility(8);
            Room r5 = this.b;
            if (r5 == null) goto L6;
            en1.b.j.excActionBySetting(String.valueOf(r5.getRoomId()));
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/l0;", "p1", "", "invoke", "(Lzg1/l0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<l0, Unit> {
        public AnonymousClass2(ClearScreenCompositeWidget r8) {
            super(1, r8, ClearScreenCompositeWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/HideScreenByLongPressEvent;)V", 0);
        }

        public final void invoke(l0 r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            ClearScreenCompositeWidget r0 = (ClearScreenCompositeWidget) ((CallableReference) this).receiver;
            int r1 = ClearScreenCompositeWidget.f;
            r0.getClass();
            r3.getClass();
            r0.Bq(false, false, false);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((l0) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget$onCreate$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/o0;", "p1", "", "invoke", "(Lzg1/o0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<o0, Unit> {
        public AnonymousClass3(ClearScreenCompositeWidget r8) {
            super(1, r8, ClearScreenCompositeWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/HideTopIndicatorEvent;)V", 0);
        }

        public final void invoke(o0 r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            ClearScreenCompositeWidget r0 = (ClearScreenCompositeWidget) ((CallableReference) this).receiver;
            int r1 = ClearScreenCompositeWidget.f;
            DataCenter r2 = ((Widget) r0).dataCenter;
            if (r2 == null) goto L8;
            LayerEventDispatcher r4 = o70.c.a(Integer.valueOf(r2.hashCode()));
            if (r4 == null) goto L9;
            r3.getClass();
            r4.b(new yn1.c());
            return;
        L9:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((o0) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget$onCreate$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/o2;", "p1", "", "invoke", "(Lzg1/o2;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<o2, Unit> {
        public AnonymousClass4(ClearScreenCompositeWidget r8) {
            super(1, r8, ClearScreenCompositeWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/RecordClearScreenEvent;)V", 0);
        }

        public final void invoke(o2 r4) {
            Intrinsics.checkNotNullParameter(r4, "p1");
            ClearScreenCompositeWidget r0 = (ClearScreenCompositeWidget) ((CallableReference) this).receiver;
            com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = r0.b;
            if (r1 == null) goto L5;
            boolean r2 = r1.hq();
        L6:
            if (r2 == false) goto L9;
            r0.Bq(r4.a, true, false);
            return;
        L9:
            return;
        L5:
            r2 = false;
            goto L6
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((o2) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public void Eq(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
    }

    public void F5(int r1) {
    }

    public void f7() {
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public void rf() {
    }

    public final View Aq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Fo();
    }

    public final void Kf() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.c;
        View r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.getRootView();
    L6:
        if (r2 == null) goto L8;
        r2.setAlpha(1.0f);
    L8:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r3 = this.c;
        if (r3 == null) goto L11;
        r1 = r3.Co();
    L11:
        if (r1 == null) goto L13;
        r1.setVisibility(8);
    L13:
        ALogger.i("ClearScreenCompositeWidget", "hideInteractionAlpha");
        return;
    L5:
        r2 = null;
        goto L6
    }

    public void Rf() {
        int r0 = gs1.a.a;
        h r1 = gs1.a.a(a0.p(getDataCenter()));
        if (r1 == null) goto L5;
        r1.b(com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.d.b);
    L5:
        xs2.b.a().post(new ToolbarClearScreenEvent(true, false));
    }

    public final boolean g1() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.b;
        if (r0 != null) goto L5;
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = this.b;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.V9() != true) goto L11;
        return true;
    L5:
        if (r0.dg() != true) goto L6;
        return true;
    }

    public final Room getRoom() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L7;
        return null;
    L7:
        return z.o(r0);
    }

    public final boolean isAnchor() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.dg();
    }

    public final boolean pX() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) r0.get("DATA_IS_HIDE_INTERACTION", Boolean.FALSE)).booleanValue() == false) goto L7;
        return true;
    }

    public ClearScreenCompositeWidget() {
        this.a = 200;
        this.e = new CompositeDisposable();
    }

    public void Hc() {
        xs2.b.a().post(new ToolbarClearScreenEvent(false, false));
        int r0 = gs1.a.a;
        h r1 = gs1.a.a(a0.p(getDataCenter()));
        if (r1 == null) goto L6;
        r1.a(ClearScreenConst.InteractType.AUDIENCE_PS_CONFIG_DIALOG_SHOW);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        h70.b r0 = getComponentContext();
        n r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = ho1.a.d(r0);
    L6:
        this.b = r2;
        h70.b r3 = getComponentContext();
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r4 = ho1.a.i(r3);
    L10:
        this.c = r4;
        h70.b r5 = getComponentContext();
        if (r5 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r6 = ho1.a.c(r5);
    L14:
        this.d = r6;
        ClearScreenManagerAbility.INSTANCE.setFactory(new b());
        if (isAnchor() == false) goto L17;
    L18:
        gs1.b.b(false);
    L19:
        Fq(l0.class, new AnonymousClass5.a(new AnonymousClass2(this)));
        Fq(o0.class, new AnonymousClass5.a(new AnonymousClass3(this)));
        Fq(o2.class, new AnonymousClass5.a(new AnonymousClass4(this)));
        int r7 = y.a;
        y.a(((Widget) this).dataCenter, this.e, "ClearScreenCompositeWidget->rxbus", new AnonymousClass5(this));
        ((Widget) this).dataCenter.observeForever("cmd_p2_widget_loaded", this);
        h70.b r8 = getComponentContext();
        if (r8 == null) goto L22;
        r1 = ho1.a.e(r8);
    L22:
        if (r1 == null) goto L28;
        PropertyOwner r9 = r1.sa();
        if (r9 == null) goto L28;
        Disposable r10 = r9.subscribe(new c(this));
        if (r10 == null) goto L28;
        RxUtilKt.c(r10, this.e);
    L28:
        h70.b r11 = getComponentContext();
        if (r11 == null) goto L34;
        IAbilityCenter r12 = r11.a();
        if (r12 == null) goto L35;
        r12.registerAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b.class, this);
        return;
    L35:
        return;
    L34:
        return;
    L17:
        if (g1() == true) goto L19;
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public void onDestroy() {
        super.onDestroy();
        if (pX() == true) goto L5;
    L7:
        t3.c(false, "AbsInteractionFragment_onDestroy");
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L12;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L12;
        r1.unregisterAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b.class);
    L12:
        this.e.dispose();
        ((Widget) this).dataCenter.removeObserver(this);
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L15;
        r2.put("cmd_all_widget_loaded", Boolean.FALSE);
    L15:
        this.b = null;
        this.c = null;
        this.d = null;
        return;
    L5:
        if (wt2.a.e(Boolean.valueOf(isAnchor())) == true) goto L7;
        p.b.getClass();
        p.a.a("exit_room");
        goto L7
    }

    public final RoomContext zq() {
        MiddlewareRoomContext r0 = getMiddlewareRoomContext();
        if ((r0 instanceof RoomContext) == true) goto L6;
        r0 = null;
    L6:
        return (RoomContext) r0;
    }

    public void Cq(ToolbarClearScreenEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "t");
        StringBuilder r0 = new StringBuilder("接收到ToolbarClearScreenEvent，此时clear值为");
        r0.append(r9.b);
        r0.append("roomId:");
        Room r1 = getRoom();
        r r2 = null;
        if (r1 == null) goto L5;
        Long r3 = Long.valueOf(r1.getRoomId());
    L6:
        r0.append(r3);
        ALogger.d("ClearScreenManager", r0.toString());
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L18;
        RoomContext r4 = zq();
        if (r4 == null) goto L13;
        com.bytedance.live.datacontext.n r5 = r4.isRoomVisible();
        if (r5 == null) goto L13;
        Boolean r6 = (Boolean) r5.getValue();
    L15:
        if (Intrinsics.areEqual(r6, Boolean.FALSE) == false) goto L18;
        return;
    L13:
        r6 = null;
    L18:
        if (g1() == true) goto L23;
        if (VrUtils.t(((Widget) this).dataCenter, false) == true) goto L23;
        return;
    L23:
        if (ClearScreenHelper.i(getDataCenter()) == false) goto L32;
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 != null) goto L27;
    L31:
        gs1.b.b(false);
        goto L32
    L27:
        if (((Boolean) r7.get("cmd_all_widget_loaded", Boolean.FALSE)).booleanValue() == true) goto L31;
        if (r9.a == ToolbarClearScreenEvent.Source.SlideRoom) goto L31;
        gs1.b.b(r9.b);
    L32:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r8 = this.c;
        if (r8 == null) goto L35;
        ViewGroup r10 = r8.Wa();
    L36:
        Intrinsics.checkNotNull(r10);
        Room r11 = getRoom();
        boolean r12 = RTLUtil.isAppRTL(getContext());
        int r13 = r10.getWidth();
        if (r12 == false) goto L40;
        r13 = -r13;
    L40:
        if (r9.b == false) goto L54;
        ViewPropertyAnimator r14 = r10.animate();
        if (r9.c == false) goto L44;
        r14.alpha(0.0f);
    L53:
        r14.setDuration(this.a).setInterpolator(new om3.c()).setListener(new d(this)).start();
        sq(true);
        F5(8);
    L71:
        ((Widget) this).dataCenter.put("data_hide_screen", Boolean.valueOf(pX()));
        com.bytedance.android.livesdk.sharedpref.e r15 = com.bytedance.android.livesdk.sharedpref.b.V;
        Boolean r16 = Boolean.valueOf(pX());
        r15.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r15, r16);
        return;
    L44:
        r14.x(r13);
        if (VrUtils.u(((Widget) this).dataCenter, false) == false) goto L53;
        if (com.bytedance.android.livesdk.utils.landscape.e.b(false, r11) == false) goto L53;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r17 = this.c;
        if (r17 == null) goto L51;
        r2 = com.bytedance.android.livesdk.chatroom.ui.framework.base.s.a(r17);
    L51:
        if (r2 == null) goto L53;
        r14.x(r2.a.getWidth());
        goto L53
    L54:
        ViewPropertyAnimator r18 = r10.animate();
        if (r9.c == false) goto L57;
        r18.alpha(1.0f);
    L58:
        r18.setDuration(this.a).setInterpolator(new om3.c()).setListener(new e(this)).start();
        IPerformanceManager r19 = k.f(IPerformanceManager.class);
        if (r19 == null) goto L61;
        r19.onLeaveFullScreenClean();
    L61:
        sq(false);
        com.bytedance.android.livesdk.chatroom.ui.framework.a r20 = this.d;
        if (r20 == null) goto L66;
        Intrinsics.checkNotNullParameter(r20, "$this$getClearScreenWaterInterface");
        Element<?> r21 = r20.w8(d90.d.a.H0);
        if (r21 == null) goto L66;
        r2 = (com.bytedance.android.livesdk.chatroom.tetris.portrait.a) r21.f(com.bytedance.android.livesdk.chatroom.tetris.portrait.a.class);
    L66:
        if (r2 == null) goto L71;
        if (wt2.a.e(Boolean.valueOf(isAnchor())) == true) goto L70;
        r2.t(8);
        goto L71
    L70:
        r2.i();
        goto L71
    L57:
        r18.x(0.0f);
        goto L58
    L35:
        r10 = null;
        goto L36
    L5:
        r3 = null;
        goto L6
    }

    public final void nk(float r5) {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.c;
        View r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.getRootView();
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r3 = this.c;
        if (r3 == null) goto L9;
        r1 = r3.Co();
    L9:
        Room r4 = getRoom();
        if (r2 == null) goto L15;
        r2.setAlpha(r5);
        ALogger.i("ClearScreenCompositeWidget", "setInteractionAlpha alpha=" + r5);
        if (r1 == null) goto L16;
        r1.setVisibility(0);
        r1.setOnClickListener(new f(r1, r4));
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public void onChanged(KVData r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L30;
        if (r3 == null) goto L9;
        String r4 = r3.getKey();
    L10:
        if (r4 != null) goto L13;
        return;
    L13:
        if (r4.hashCode() == 1440046856) goto L16;
        return;
    L16:
        if (r4.equals("cmd_p2_widget_loaded") == false) goto L26;
        RoomContext r5 = zq();
        if (r5 == null) goto L27;
        com.bytedance.live.datacontext.n r6 = r5.getDrawCleanScreenViewModel();
        if (r6 == null) goto L28;
        DrawCleanScreenViewModel r7 = (DrawCleanScreenViewModel) r6.getValue();
        if (r7 == null) goto L29;
        r7.changeRoomClear("cmd_p2_widget_loaded");
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L9:
        r4 = null;
        goto L10
    }

    public final void onEvent(n0 r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L8;
        LayerEventDispatcher r1 = o70.c.a(Integer.valueOf(r0.hashCode()));
        if (r1 == null) goto L9;
        r1.b(new bh1.a(r4.a, isAnchor()));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b
    public final void sq(boolean r4) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L9;
        r0.put("DATA_IS_HIDE_INTERACTION", Boolean.valueOf(r4));
        ILinkServiceExternal r1 = k.f(ILinkServiceExternal.class);
        if (r1 == null) goto L7;
        r1.updateInteractLayoutShow(r4);
    L7:
        t3.c(r4, "setHideInteractLayout");
        return;
    }

    public void yq(boolean r4) {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.c;
        if (r0 == null) goto L5;
        ViewGroup r1 = r0.Wa();
    L6:
        Intrinsics.checkNotNull(r1);
        ViewPropertyAnimator r2 = r1.animate();
        if (r4 == false) goto L9;
        r2.alpha(1.0f);
    L10:
        r2.setDuration(this.a).setInterpolator(new om3.c()).setListener(new com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.a()).start();
        sq(false);
        F5(0);
        ((Widget) this).dataCenter.put("data_hide_screen", Boolean.valueOf(pX()));
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.b.V;
        Boolean r3 = Boolean.valueOf(pX());
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r3);
        return;
    L9:
        r2.x(0.0f);
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }

    public static final void wq(ClearScreenCompositeWidget r3, p0 r4) {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r5 = r3.c;
        if (r5 == null) goto L5;
        View r6 = r5.getRootView();
    L6:
        if (r6 == null) goto L19;
        if (r4 == null) goto L20;
        float r0 = 1 - r4.a;
        if (r0 >= 0.0f) goto L12;
        r0 = 0.0f;
    L12:
        if (r0 <= 1.0f) goto L14;
        r0 = 1.0f;
    L14:
        r6.setAlpha(r0);
        if (Math.abs(r4.a - 1.0f) >= 1.0E-5f) goto L17;
        r6.setVisibility(8);
        return;
    L17:
        r6.setVisibility(0);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final <T> void Fq(Class<T> r3, Consumer<T> r4) {
        ((ObservableSubscribeProxy) RxBusAbility.INSTANCE.getRxBus(a0.p(((Widget) this).dataCenter)).b(r3).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r4);
    }

    public final void I4(boolean r2, boolean r3) {
        q r0 = ho1.a.f(getComponentContext());
        if (r0 == null) goto L6;
        r0.I4(r2, r3);
        return;
    }

    public static final void xq(ClearScreenCompositeWidget r1, Class r2, AnonymousClass5.a r3) {
        r1.getClass();
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r1))).subscribe(r3);
    }

    public void Bq(boolean r5, boolean r6, boolean r7) {
        if (g1() == true) goto L6;
        if (r6 == true) goto L6;
        return;
    L6:
        sq(r5);
        com.bytedance.android.livesdk.chatroom.ui.framework.d r8 = this.c;
        if (r8 == null) goto L9;
        ViewGroup r9 = r8.Wa();
    L10:
        Intrinsics.checkNotNull(r9);
        boolean r0 = RTLUtil.isAppRTL(getContext());
        int r1 = r9.getWidth();
        if (r0 == false) goto L13;
        r1 = -r1;
    L13:
        r9.setVisibility(8);
        if (r5 == false) goto L22;
        if (r6 == true) goto L17;
    L18:
        r9.setX(r1);
    L19:
        ((Widget) this).dataCenter.put("cmd_show_screen", Boolean.FALSE);
        s r10 = new s(true);
        xs2.b.a().post(r10);
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L30;
        LayerEventDispatcher r3 = o70.c.a(Integer.valueOf(r2.hashCode()));
        Intrinsics.checkNotNull(r3);
        r3.b(r10);
    L30:
        if (bl.a.getValue().booleanValue() == false) goto L38;
        if (r6 == true) goto L33;
    L34:
        if (r6 == true) goto L39;
        if (r5 == true) goto L40;
    L36:
        xs2.b.a().post(new ToolbarClearScreenEvent(((Boolean) com.bytedance.android.livesdk.sharedpref.b.V.getValue()).booleanValue(), false));
        return;
    L40:
        return;
    L39:
        return;
    L33:
        if (LiveRecordWidget.L == false) goto L36;
    L38:
        return;
    L17:
        if (g1() == false) goto L19;
    L22:
        if (r6 == true) goto L24;
    L25:
        r9.setX(0.0f);
    L26:
        r9.setVisibility(0);
        ((Widget) this).dataCenter.put("cmd_show_screen", Boolean.TRUE);
        s r11 = new s(false);
        xs2.b.a().post(r11);
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L30;
        LayerEventDispatcher r12 = o70.c.a(Integer.valueOf(r4.hashCode()));
        Intrinsics.checkNotNull(r12);
        r12.b(r11);
        goto L30
    L24:
        if (g1() == false) goto L26;
    L9:
        r9 = null;
        goto L10
    }
}
