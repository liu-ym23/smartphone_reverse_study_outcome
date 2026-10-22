package com.bytedance.android.live.room.navi.userinfo_p.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.f0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.navi.userinfo_p.utils.RoomUserInfoUtil;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.common.h;
import com.bytedance.android.livesdk.common.i;
import com.bytedance.android.livesdk.performance.p;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zg1.f;
import zg1.n3;
import zg1.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u00020\u0004:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\tJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\nH\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/widget/LiveRoomUserInfoPlatformWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/common/i;", "Lzg1/n3;", "event", "", "onEvent", "Lzg1/x0;", "Lzg1/f;", "<init>", "()V", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomUserInfoPlatformWidget extends MiddlewareRoomRecyclableWidget implements Observer<KVData>, i {
    public static final /* synthetic */ int g = 0;
    public UserInfoElementManager a;
    public Boolean b;
    public final CompositeDisposable c;
    public ViewGroup d;
    public View e;
    public ValueAnimator f;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ LiveRoomUserInfoPlatformWidget a;

        public b(LiveRoomUserInfoPlatformWidget r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            if (r2 == null) goto L16;
            View r0 = ((Widget) this.a).contentView;
            if (r0 == null) goto L12;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            if (r1 == null) goto L12;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L11;
            r1.width = ((Integer) r3).intValue();
            goto L12
        L11:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L12:
            View r4 = ((Widget) this.a).contentView;
            if (r4 == null) goto L17;
            r4.requestLayout();
            return;
        L17:
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ LiveRoomUserInfoPlatformWidget a;

        public c(LiveRoomUserInfoPlatformWidget r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            View r3 = ((Widget) this.a).contentView;
            if (r3 == null) goto L7;
            ViewGroup.LayoutParams r4 = r3.getLayoutParams();
            if (r4 == null) goto L7;
            r4.width = -2;
        L7:
            View r5 = ((Widget) this.a).contentView;
            if (r5 == null) goto L11;
            r5.requestLayout();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            View r3 = ((Widget) this.a).contentView;
            if (r3 == null) goto L7;
            ViewGroup.LayoutParams r4 = r3.getLayoutParams();
            if (r4 == null) goto L7;
            r4.width = -2;
        L7:
            View r5 = ((Widget) this.a).contentView;
            if (r5 == null) goto L11;
            r5.requestLayout();
            return;
        }
    }

    public static final class d extends com.bytedance.android.live.core.tetris.task.a {
        public final /* synthetic */ LiveRoomUserInfoPlatformWidget c;

        public final void run() {
            LiveRoomUserInfoPlatformWidget r0 = this.c;
            int r1 = LiveRoomUserInfoPlatformWidget.g;
            UserInfoElementManager r2 = r0.a;
            if (r2 == null) goto L5;
            r2.i();
        L5:
            r0.runWithRoomEntered(new com.bytedance.android.live.room.navi.userinfo_p.widget.b(r0));
            b(true);
        }

        public d(LiveRoomUserInfoPlatformWidget r1) {
            this.c = r1;
            super("live_room_user_info_widget");
        }
    }

    public final class e implements Consumer {
        public final /* synthetic */ Function1 a;

        public e(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final /* synthetic */ String Lg() {
        return h.b(this);
    }

    public final /* synthetic */ String cg() {
        return h.c(this);
    }

    public final String getSpm() {
        return "a100.a100.a126";
    }

    public final String nc() {
        return "LiveRoomUserInfoPlatformWidget";
    }

    public final /* synthetic */ boolean nq() {
        return h.a();
    }

    public final Animator startShowAnimation() {
        return null;
    }

    public final int supportClearScene() {
        return 282;
    }

    public final int getLayoutId() {
        if (RoomUserInfoUtil.c(((Widget) this).dataCenter) == false) goto L5;
        return 2131566983;
    L5:
        return 2131566991;
    }

    public final void onUnload() {
        this.c.clear();
        this.b = Boolean.FALSE;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        UserInfoElementManager r1 = this.a;
        if (r1 == null) goto L8;
        r1.h();
    L8:
        ValueAnimator r2 = this.f;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        this.f = null;
    }

    public LiveRoomUserInfoPlatformWidget() {
        this.b = Boolean.FALSE;
        this.c = new CompositeDisposable();
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget*/.onDestroy();
        if (isInitialized() == true) goto L9;
        UserInfoElementManager r0 = this.a;
        if (r0 == null) goto L7;
        r0.a();
    L7:
        this.a = null;
        return;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        if (r3.l(((Widget) this).context) == false) goto L6;
        r3.p(this.e);
        return;
    }

    public final View getContentView() {
        return ((Widget) this).contentView;
    }

    public final Boolean uk() {
        return this.b;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (isViewValid() == false) goto L26;
        if (r5 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r5.getKey()) == true) goto L31;
        String r0 = r5.getKey();
        int r1 = r0.hashCode();
        if (r1 == 294674590) goto L17;
        if (r1 == 1060055221) goto L14;
        return;
    L14:
        if (r0.equals("data_keyboard_status") == false) goto L28;
    L18:
        Boolean r6 = (Boolean) r5.getData();
        if (r6 == null) goto L30;
        ViewGroup r2 = ((Widget) this).containerView;
        if (r6.booleanValue() == false) goto L23;
        int r7 = 8;
    L24:
        UIUtils.setViewVisibility(r2, r7);
        return;
    L23:
        r7 = 0;
        goto L24
    L30:
        return;
    L28:
        return;
    L17:
        if (r0.equals("data_keyboard_status_douyin") == true) goto L18;
        return;
    L31:
        return;
    }

    public final void onEnterClear(int r4) {
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L12;
        if (r4 != 8) goto L7;
    L10:
        r0.setVisibility(8);
        goto L12
    L7:
        if (r4 == 16) goto L10;
        if (r4 == 256) goto L10;
    L12:
        if (p.a() == true) goto L14;
        return;
    L14:
        View r1 = ((Widget) this).contentView;
        if (r1 != null) goto L17;
        return;
    L17:
        if (r4 == 2) goto L19;
        return;
    L19:
        if (2 == r1.getLayerType()) goto L24;
        ((Widget) this).contentView.setLayerType(2, null);
        ALogger.i("ttlive_widget", "LiveRoomUserInfoWidget Set LAYER_TYPE_HARDWARE");
        return;
    }

    public final void onEvent(f r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        View r5 = ((Widget) this).contentView;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.d == null) goto L22;
        int r6 = r5.getWidth();
        ViewGroup r0 = this.d;
        Intrinsics.checkNotNull(r0);
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{r6, r6 - r0.getWidth()});
        this.f = r7;
        if (r7 == null) goto L10;
        r7.setDuration(300);
    L10:
        ValueAnimator r8 = this.f;
        if (r8 == null) goto L13;
        r8.addUpdateListener(new b(this));
    L13:
        ValueAnimator r9 = this.f;
        if (r9 == null) goto L16;
        r9.addListener(new c(this));
    L16:
        ValueAnimator r10 = this.f;
        if (r10 == null) goto L21;
        r10.start();
        return;
    L21:
        return;
    }

    public final void onExitClear(int r4) {
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L12;
        if (r4 != 8) goto L7;
    L10:
        r0.setVisibility(0);
        goto L12
    L7:
        if (r4 == 16) goto L10;
        if (r4 == 256) goto L10;
    L12:
        if (p.a() == true) goto L14;
        return;
    L14:
        View r1 = ((Widget) this).contentView;
        if (r1 != null) goto L17;
        return;
    L17:
        if (r4 == 2) goto L19;
        return;
    L19:
        if (2 != r1.getLayerType()) goto L24;
        ((Widget) this).contentView.setLayerType(0, null);
        ALogger.i("ttlive_widget", "LiveRoomUserInfoWidget Set LAYER_TYPE_NONE");
        return;
    }

    public final void onInit(Object[] r3) {
        UserInfoElementManager r4 = new UserInfoElementManager(this);
        r4.f();
        Unit r0 = Unit.INSTANCE;
        this.a = r4;
        View r5 = ((Widget) this).contentView;
        View r1 = null;
        if (r5 == null) goto L5;
        ViewGroup r6 = (ViewGroup) r5.findViewById(2131371703);
    L6:
        this.d = r6;
        View r7 = ((Widget) this).contentView;
        if (r7 == null) goto L9;
        HSImageView r8 = r7.findViewById(2131374209);
    L9:
        View r9 = ((Widget) this).contentView;
        if (r9 == null) goto L12;
        r1 = r9.findViewById(2131362578);
    L12:
        this.e = r1;
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void onLoad(Object[] r5) {
        UserInfoElementManager r6 = this.a;
        if (r6 == null) goto L5;
        r6.g();
    L5:
        ((Widget) this).dataCenter.observeForever("data_keyboard_status", this).observeForever("data_keyboard_status_douyin", this);
        boolean r7 = isScreenPortrait();
        int r0 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((!r7) == false) goto L12;
        o r8 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r8 == null) goto L12;
        m r9 = r8.G2();
        if (r9 == null) goto L12;
        onEvent((x0) r9.getValue());
        ((ObservableSubscribeProxy) r9.a().observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new com.bytedance.android.live.room.navi.userinfo_p.widget.a(this));
    L12:
        wq(f.class, new LiveRoomUserInfoPlatformWidget$initEvents$2(this));
        r r10 = z51.a.e(((Widget) this).dataCenter);
        if (r10 == null) goto L18;
        if (r10.isInVrLandscape(((Widget) this).dataCenter) != true) goto L18;
        wq(n3.class, new LiveRoomUserInfoPlatformWidget$initEvents$3(this));
    L18:
        if (((Boolean) f0.a.getValue()).booleanValue() == false) goto L24;
        final d r12 = new d(this);
        o r2 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r2 == null) goto L28;
        j r3 = r2.B2();
        if (r3 == null) goto L28;
        r3.c(new AnonymousClass1(this, r12));
    L28:
        ALogger.d("LiveRoomUserInfoPlatformWidget", "LiveRoomUserInfoPlatformWidget = " + System.currentTimeMillis());
        r r13 = z51.a.e(((Widget) this).dataCenter);
        if (r13 != null) goto L31;
        return;
    L31:
        if (r13.isInVrLandscape(((Widget) this).dataCenter) != true) goto L45;
        View r14 = ((Widget) this).contentView;
        if (r14 == null) goto L46;
        o r1 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r1 == null) goto L41;
        m r4 = r1.A1();
        if (r4 == null) goto L41;
        if (((Boolean) r4.getValue()).booleanValue() != true) goto L41;
        int r15 = 8;
    L42:
        r14.setVisibility(r15);
        return;
    L41:
        r15 = 0;
        goto L42
    L46:
        return;
    L45:
        return;
    L24:
        UserInfoElementManager r16 = this.a;
        if (r16 == null) goto L27;
        r16.i();
    L27:
        runWithRoomEntered(new com.bytedance.android.live.room.navi.userinfo_p.widget.b(this));
        goto L28
    }

    public final void qo(Boolean r1) {
        this.b = r1;
    }

    public final void onEvent(x0 r3) {
        if (isScreenPortrait() == false) goto L5;
        return;
    L5:
        if (((Widget) this).contentView == null) goto L15;
        ((Widget) this).containerView.setClipChildren(false);
        ((Widget) this).containerView.setClipToPadding(false);
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L11;
        Boolean r0 = Boolean.FALSE;
        if (Intrinsics.areEqual((Boolean) r4.get("data_longer_video_within_live_type", r0), r0) == true) goto L11;
        return;
    L11:
        UIUtils.updateLayoutMargin(((Widget) this).contentView, s1.f(2.0f), -3, -3, -3);
        return;
    }

    public final void onEvent(n3 r3) {
        r r0 = z51.a.e(((Widget) this).dataCenter);
        if (r0 != null) goto L5;
    L7:
        View r1 = ((Widget) this).contentView;
        if (r1 == null) goto L16;
        if (r3 != null) goto L11;
    L13:
        int r4 = 0;
    L14:
        r1.setVisibility(r4);
        return;
    L11:
        if (r3.a != true) goto L13;
        r4 = 8;
        goto L14
    L16:
        return;
    L5:
        if (r0.isInVrLandscape(((Widget) this).dataCenter) == true) goto L7;
    }

    public final <T> void wq(Class<T> r3, Function1<? super T, Unit> r4) {
        RxUtilKt.c(RxBusAbility.INSTANCE.getRxBus(((Widget) this).dataCenter).b(r3).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r4)), this.c);
    }
}
