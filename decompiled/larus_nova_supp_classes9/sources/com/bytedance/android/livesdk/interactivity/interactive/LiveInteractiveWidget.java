package com.bytedance.android.livesdk.interactivity.interactive;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.interactivity.interactive.episode.EpisodeInteractiveDialog;
import com.bytedance.android.livesdk.interactivity.interactive.episode.EpisodeInteractiveWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IBannerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class LiveInteractiveWidget extends LiveRecyclableWidget implements b, vlc.l {
    public final CompositeDisposable a;
    public LiveInteractiveHelper b;
    public final AtomicBoolean c;
    public IBannerInfo d;
    public vlc.d e;
    public a f;

    public interface a {
        void onDegrade();
    }

    public final int getLayoutId() {
        return 2131566848;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.b
    public final String getTag() {
        return "VSInteractionWidget";
    }

    public final void onInit(Object[] r1) {
    }

    public void onUnload() {
        zq(false);
        LiveInteractiveHelper r1 = this.b;
        if (r1 == null) goto L8;
        r1.p(false);
        LiveInteractiveHelper r2 = this.b;
        LiveInteractivePresenter r3 = r2.d;
        if (r3 == null) goto L7;
        r3.detachView();
    L7:
        r2.i.clear();
        this.b.release();
        this.c.set(false);
    L8:
        this.a.clear();
    }

    public int xq() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.b
    public final void ol() {
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTranslationX(0.0f);
    }

    public LiveInteractiveHelper wq() {
        return new LiveInteractiveHelper(isScreenPortrait(), ((Widget) this).dataCenter, ((Widget) this).context, this);
    }

    public LiveInteractiveWidget() {
        this.a = new CompositeDisposable();
        this.c = new AtomicBoolean(false);
        this.d = null;
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        o82.h.b("on pause");
        LiveInteractiveHelper r0 = this.b;
        if (r0 == null) goto L6;
        r0.m(false);
        return;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        o82.h.b("on resume");
        LiveInteractiveHelper r0 = this.b;
        if (r0 == null) goto L6;
        r0.m(true);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.b
    public final <T> AutoDisposeConverter<T> s7() {
        return autoDispose();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.b
    public final boolean isVisible() {
        return ((Widget) this).isViewValid;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.b
    public final LifecycleRegistry u9() {
        return ((Widget) this).lifecycleRegistry;
    }

    public void onLoad(Object[] r11) {
        km1.a r1 = null;
        IRoom r4 = (IRoom) ((Widget) this).dataCenter.get("data_room", null);
        if (r4 != null) goto L7;
        ALogger.e("VSInteractionWidget", "room is null");
        return;
    L7:
        if ((!(this instanceof EpisodeInteractiveWidget)) == false) goto L9;
        yq("ugc Live room", null);
    L9:
        EpisodeInteractiveContext r13 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.t(((Widget) this).dataCenter, this).c();
        if (r13 != null) goto L13;
        r13 = null;
    L13:
        if (r13 == null) goto L15;
        r1 = (km1.a) r13.getLiveInteractiveInfo().getValue();
    L15:
        System.currentTimeMillis();
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().k(((Widget) this).dataCenter, r4, r1, this, new n0(this), new s0(this), new t0(this));
        zq(true);
        if (xq() != 1) goto L18;
        ((Widget) this).contentView.setVisibility(8);
    L18:
        this.f = new b1(this);
        DataCenter r14 = ((Widget) this).dataCenter;
        int r0 = lk1.b.a;
        lk1.c.i2.getClass();
        com.bytedance.android.live.core.arch.mvvm.d r15 = lk1.c.a.a(r14).observeStatusChanged("room_auth_interactive_component");
        if (r15 == null) goto L24;
        Disposable r16 = r15.observeOn(AndroidSchedulers.mainThread()).subscribe(new o0(this));
        if (r16 == null) goto L25;
        this.a.add(r16);
        return;
    L25:
        return;
    }

    public final void onMessage(final tlc.d r4) {
        if ((com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.t(((Widget) this).dataCenter, this).j0() instanceof IRoom) == true) goto L5;
    L10:
        o82.i.d(r4, new u0(this, r4), new v0(this, r4), new w0(this, r4));
        return;
    L5:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.t(((Widget) this).dataCenter, this).j0().getRoomAuthStatus() == null) goto L10;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.t(((Widget) this).dataCenter, this).j0().getRoomAuthStatus().castToOrNull(ju2.d.class).isEnableEpisodeInteractive() == true) goto L10;
        o82.h.b("abandon Interact Message cuzz of auth.interactiveComponent is hidden");
    }

    public final void zq(boolean r4) {
        vlc.d r0 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        this.e = r0;
        if (r0 == null) goto L8;
        if (r4 == false) goto L6;
        ku2.d r5 = ku2.e.a;
        r0.addMessageListener(xq1.b.a(ku2.e.i), this);
        this.e.addMessageListener(xq1.b.a(ku2.e.g), this);
        this.e.addMessageListener(xq1.b.a(ku2.e.h), this);
        return;
    L6:
        ku2.d r6 = ku2.e.a;
        r0.removeMessageListener(xq1.b.a(ku2.e.i), this);
        this.e.removeMessageListener(xq1.b.a(ku2.e.g), this);
        this.e.removeMessageListener(xq1.b.a(ku2.e.h), this);
        return;
    }

    public final void yq(String r10, tlc.d r11) {
        if (this.c.get() == true) goto L79;
        o82.h.b("initInteractiveHelper enterFrom:".concat(r10));
        zq(false);
        this.c.set(true);
        LiveInteractiveHelper r0 = wq();
        this.b = r0;
        r0.l(this.d);
        ViewModel r1 = null;
        this.d = null;
        LiveInteractiveHelper r2 = this.b;
        int r3 = xq();
        LiveInteractivePresenter r4 = r2.e();
        r2.d = r4;
        if (r4 == null) goto L7;
        r4.g0(r2);
    L7:
        vr1.u r5 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r2.o, null, 2);
        if (r5 == null) goto L10;
        ViewModel r6 = r5.c();
    L12:
        if ((r6 instanceof EpisodeInteractiveContext) == true) goto L14;
        r6 = null;
    L14:
        EpisodeInteractiveContext r7 = (EpisodeInteractiveContext) r6;
        if (r7 == null) goto L19;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.x<String, String>> r8 = r7.getInteractiveStorage();
        if (r8 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.x<String, String> r9 = (com.bytedance.android.livesdk.chatroom.x) r8.getValue();
    L20:
        r2.e = r9;
        r2.b = r3;
        o82.h.b("initHelper[" + r2.hashCode() + "],type = " + r3);
        if (fq1.t.a() != null) goto L23;
    L25:
        View r13 = ((Widget) this).contentView;
        if (r13 == null) goto L69;
        LiveInteractiveHelper r14 = this.b;
        if (r14.b != 0) goto L30;
        View r15 = r13;
    L31:
        r14.f = r15;
        o82.h.b("initContentView[" + r14.hashCode() + "],showType=" + r14.b + ", this.contentView:" + r14.f + ", contentView from param:" + r13);
        if (r14.b != 1) goto L38;
        FragmentActivity r16 = r14.p;
        if (r16 == null) goto L37;
        EpisodeInteractiveDialog r17 = new EpisodeInteractiveDialog(r16, r14.o, o82.i.b(), o82.i.a());
        r14.g = r17;
        r17.c = r14.f;
        goto L38
    L37:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L38:
        View r18 = r14.f;
        if (r18 == null) goto L41;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
    L43:
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == true) goto L45;
        r19 = null;
    L45:
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r19;
        if (r20 != null) goto L48;
        r20 = new ViewGroup.MarginLayoutParams(o82.i.b(), o82.i.a());
    L48:
        r20.height = o82.i.a();
        r20.width = o82.i.b();
        o82.h.b("setHybridComponent[" + r14.hashCode() + "]; height=" + r20.height + ", width=" + r20.width + ", view=" + r13.hashCode());
        View r21 = r14.f;
        if (r21 == null) goto L51;
        r21.setLayoutParams(r20);
    L51:
        vr1.u r23 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r14.o, null, 2);
        if (r23 == null) goto L54;
        ViewModel r24 = r23.c();
    L56:
        if ((r24 instanceof EpisodeInteractiveContext) == false) goto L59;
        r1 = r24;
    L59:
        EpisodeInteractiveContext r25 = (EpisodeInteractiveContext) r1;
        if (r25 == null) goto L68;
        com.bytedance.live.datacontext.m<Boolean> r26 = r25.getEnableInteractive();
        if (r26 == null) goto L68;
        Observable r27 = r26.a();
        if (r27 == null) goto L68;
        ObservableSubscribeProxy r28 = (ObservableSubscribeProxy) r27.as(r14.q.s7());
        if (r28 == null) goto L68;
        r28.subscribe(new b0(r14));
    L68:
        r14.a.setValue(Boolean.TRUE);
        goto L69
    L54:
        r24 = null;
        goto L56
    L41:
        r19 = null;
        goto L43
    L30:
        r15 = new BannerFrameLayout(r14.p);
    L69:
        final LiveInteractiveHelper r29 = this.b;
        boolean r30 = this instanceof EpisodeInteractiveWidget;
        r29.getClass();
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L77;
        r29.h = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().J(r29.o, r30, new LiveInteractiveHelper$initInteractiveCard$1(r29), new LiveInteractiveHelper$initInteractiveCard$2(r29));
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L77;
        View r31 = r29.f;
        if (r31 == null) goto L77;
        UtilityKotlinExtentionsKt.t(r31);
    L77:
        this.b.p(false);
        o82.i.d(r11, new y0(this), new z0(this), new a1(this));
        return;
    L23:
        if (fq1.t.a().x(this) == null) goto L25;
        com.bytedance.android.live.core.utils.rxutils.autodispose.v r33 = fq1.t.a().x(this);
        final LiveInteractiveHelper r34 = this.b;
        Objects.requireNonNull(r34);
        r33.subscribe(new x0(r34));
    L19:
        r9 = null;
        goto L20
    L10:
        r6 = null;
        goto L12
    }
}
