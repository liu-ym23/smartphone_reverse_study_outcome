package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.live.lynx.api.Jsb2MethodFinder;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.config.l01;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.interactivity.interactive.j0;
import com.bytedance.android.livesdk.landscape.ILandscapeSpiltManager;
import com.bytedance.android.livesdk.log.e0;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdkapi.banner.BannerData;
import com.bytedance.android.livesdkapi.banner.IBannerManager;
import com.bytedance.android.livesdkapi.depend.model.live.IBannerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p implements com.bytedance.android.scope.o, vr1.j {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ km1.a a;
        public final /* synthetic */ Function1 b;

        public a(km1.a r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            BannerData r3 = (BannerData) r2;
            km1.a r0 = this.a;
            if (r0 != null) goto L5;
            BannerInRoomCollection.BannerInfo r4 = r3.getData().getActivityVSInteractive();
        L6:
            if (r4 == null) goto L9;
            this.b.invoke(r4);
            return;
        L9:
            return;
        L5:
            r4 = r0.a;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Function1 r0 = this.a;
            r0.invoke((Throwable) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            zg1.l r3 = (zg1.l) r2;
            Intrinsics.checkNotNullParameter(r3, "bottomPanelDismissEvent");
            this.a.invoke(r3.a);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public d(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ILandscapeSpiltManager.State r3 = (ILandscapeSpiltManager.State) r2;
            if (r3 != ILandscapeSpiltManager.State.HIDE) goto L5;
        L6:
            this.a.invoke();
            return;
        L5:
            if (r3 == ILandscapeSpiltManager.State.SHOW_ANIMATING) goto L6;
        }
    }

    public p() {
    }

    @Override // vr1.j
    public final void K() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.j
    public final Jsb2MethodFinder A() {
        return new Jsb2MethodFinder();
    }

    @Override // vr1.j
    public final boolean q() {
        return l01.a.getValue().booleanValue();
    }

    @Override // vr1.j
    public final MutableLiveData<String> getSeiUpdate() {
        ILivePlayerClient r0 = LivePlatformPlayerManager.f();
        if (r0 == null) goto L7;
        IRoomEventHub r1 = r0.getEventHub();
        if (r1 == null) goto L7;
        return r1.getSeiUpdate();
    L7:
        return null;
    }

    @Override // vr1.j
    public final boolean h() {
        return v71.a.d();
    }

    @Override // vr1.j
    public final Disposable F(Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        return xs2.b.a().b(zg1.l.class).subscribe(new c(r3));
    }

    @Override // vr1.j
    public final Map<String, String> I(DataCenter r8) {
        HashMap r0 = new HashMap();
        if (r8 != null) goto L5;
        return r0;
    L5:
        com.bytedance.android.livesdk.log.g r9 = com.bytedance.android.livesdk.log.u.l();
        com.bytedance.android.livesdk.log.filter.o r1 = r9.c(n0.class);
        if (r1 == null) goto L8;
        r1.a(r0);
    L8:
        com.bytedance.android.livesdk.log.filter.o r10 = r9.c(Room.class);
        if (r10 == null) goto L11;
        r10.a(r0);
    L11:
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r2 = r0.entrySet().iterator();
    L13:
        if (r2.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) r2.next();
        if (StringsKt.contains$default((String) r3.getKey(), "vs", false, 2, null) == false) goto L13;
        r11.put(r3.getKey(), r3.getValue());
        goto L13
    L18:
        return MapsKt.toMutableMap(r11);
    }

    @Override // vr1.j
    public final SSWebView d(Object r3) {
        if ((r3 instanceof AnnieXWebKit) == true) goto L5;
        r3 = null;
    L5:
        AnnieXWebKit r4 = (AnnieXWebKit) r3;
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.e;
    }

    @Override // vr1.j
    public final void f(j0 r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        LivePlatformPlayerManager.j(new o(r2));
    }

    @Override // vr1.j
    public final com.bytedance.live.datacontext.m<Boolean> g(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        IVSPlayerService r0 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r0 == null) goto L9;
        IPlayerProgressService r1 = r0.provideVSProgressService(r2);
        if (r1 == null) goto L9;
        PlayerProgressServiceContext r3 = r1.provideContext(r2);
        if (r3 == null) goto L9;
        return r3.getVsRoomEnableSeek();
    L9:
        return null;
    }

    @Override // vr1.j
    public final void n(Object r3) {
        xs2.b.a().post(new t32.a(r3));
    }

    @Override // vr1.j
    public final void o(DataCenter r5) {
        Intrinsics.checkNotNullParameter("activity_interactive", "source");
        if (r5 == null) goto L5;
        int r6 = r5.hashCode();
    L6:
        LayerEventDispatcher r7 = o70.c.a(Integer.valueOf(r6));
        if (r7 == null) goto L10;
        r7.b(new o42.c(true, false, "activity_interactive"));
        return;
    L10:
        return;
    L5:
        r6 = 0;
        goto L6
    }

    @Override // vr1.j
    public final void s(Object r2) {
        if ((r2 instanceof AnnieXWebKit) == true) goto L5;
        r2 = null;
    L5:
        AnnieXWebKit r3 = (AnnieXWebKit) r2;
        if (r3 == null) goto L9;
        r3.f();
        return;
    }

    @Override // vr1.j
    public final void w(Window r1) {
        IESStatusBarUtil.hideNavigation(r1);
    }

    @Override // vr1.j
    public final com.bytedance.live.datacontext.m<Boolean> y(DataCenter r2) {
        IVSPlayerService r0 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r3 = r0.provideVSPlayerViewControlService(r2);
        if (r3 == null) goto L9;
        VSPlayerViewControlContext r4 = r3.provideContext();
        if (r4 == null) goto L9;
        return r4.getPlayerViewVisible();
    L9:
        return null;
    }

    @Override // vr1.j
    public final Uri E(Uri r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return com.bytedance.android.livesdk.vs.d.a(r2, r3);
    }

    @Override // vr1.j
    public final void i(Object r2, Object r3) {
        if ((r3 instanceof com.bytedance.android.live.lynx.api.a) == true) goto L5;
        return;
    L5:
        if ((r2 instanceof AnnieXWebKit) == false) goto L11;
        WebBDXBridge r4 = ((AnnieXWebKit) r2).l;
        if (r4 == null) goto L12;
        r4.e((MethodFinder) r3, 0);
        return;
    L12:
        return;
    }

    @Override // vr1.j
    public final <P, R> void a(Object r2, String r3, com.bytedance.ies.web.jsbridge2.g<P, R> r4) {
        Intrinsics.checkNotNullParameter(r3, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r4, "method");
        if ((r2 instanceof com.bytedance.android.live.lynx.api.a) == false) goto L6;
        int r0 = com.bytedance.android.live.lynx.api.a.d;
        ((com.bytedance.android.live.lynx.api.a) r2).l(r3, r4, null);
        return;
    }

    @Override // vr1.j
    public final void dataMapping(String r1, String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        Map r4 = e0.a;
    }

    @Override // vr1.j
    public final HybridCard getHybridCard(Context r2, Uri r3, b7.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        Intrinsics.checkNotNullParameter(r4, "lifeCycle");
        return jc1.k.n(IBrowserService.class).getHybridCard(r2, r3, r4);
    }

    @Override // vr1.j
    public final void j(DataCenter r5, CompositeDisposable r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "action");
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        ILandscapeSpiltManager r0 = null;
        if (r8 == null) goto L7;
        com.bytedance.live.datacontext.n r9 = r8.getLandscapeSpiltManager();
        if (r9 == null) goto L7;
        ILandscapeSpiltManager r10 = (ILandscapeSpiltManager) r9.getValue();
    L9:
        if ((r10 instanceof ILandscapeSpiltManager) == false) goto L12;
        r0 = r10;
    L12:
        if (r0 == null) goto L19;
        PropertyOwner r11 = r0.getState();
        if (r11 == null) goto L20;
        Disposable r12 = r11.subscribe(new d(r7));
        if (r12 == null) goto L21;
        RxUtilKt.c(r12, r6);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r10 = null;
        goto L9
    }

    @Override // vr1.j
    public final void x(Object r2, String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        if ((r2 instanceof AnnieXWebKit) == true) goto L5;
        r2 = null;
    L5:
        AnnieXWebKit r5 = (AnnieXWebKit) r2;
        if (r5 == null) goto L9;
        r5.p(r3, r4);
        return;
    }

    @Override // vr1.j
    public final v61.a J(final DataCenter r3, final boolean r4, final Function0 r5, final Function0 r6) {
        IMsgWindowService r0 = jc1.k.f(IMsgWindowService.class);
        if (r0 == null) goto L9;
        u61.a r1 = r0.cardBuilder();
        if (r1 == null) goto L9;
        cm0.a r7 = r1.a(new VSInteractiveService$getInteractiveCard$1(r4, r3, r5, r6));
        if (r7 == null) goto L9;
        return r7.b();
    L9:
        return null;
    }

    @Override // vr1.j
    public final AnnieXWebKit c(Context r5, Uri r6, Object r7, Map r8, Function1 r9, Function2 r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "uri");
        Intrinsics.checkNotNullParameter("LiveInteractiveHelper", "scene");
        Intrinsics.checkNotNullParameter(r8, "commonGlobalProps");
        if ((r7 instanceof com.bytedance.android.live.lynx.api.a) == false) goto L12;
        String r0 = com.bytedance.ies.bullet.service.router.d.a(r6, "url");
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        jc1.k.n(IBrowserService.class).initAnnie();
        int r2 = h7.b.a;
        h7.b.b(r5, r6, "LiveInteractiveHelper");
        com.bytedance.android.anniex.assemble.a.a.c(r5);
        AnnieXWebModel r11 = ib.d.b(new ib.d("webcast"), String.valueOf(r0), r8);
        AnnieXWebKit r12 = ib.c.a(r5, "webcast");
        com.bytedance.android.live.lynx.api.a r13 = (com.bytedance.android.live.lynx.api.a) r7;
        WebBDXBridge r1 = r12.l;
        if (r1 == null) goto L10;
        r1.e(r13, 0);
    L10:
        r12.i(r5, new pr1.a(r9, r10), r11, new m16.b());
        return r12;
    L12:
        return null;
    }

    @Override // vr1.j
    public final void k(DataCenter r3, IRoom r4, km1.a r5, LifecycleOwner r6, Function1<? super IBannerInfo, Unit> r7, Function1<? super Throwable, Unit> r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r7, "onBannerData");
        Intrinsics.checkNotNullParameter(r8, "onBannerDataError");
        Intrinsics.checkNotNullParameter(r9, "onBannerObservableEmpty");
        Intrinsics.checkNotNull(r3);
        IBannerManager r10 = (IBannerManager) r3.get("data_in_room_banner_manager", null);
        if (r10 == null) goto L7;
        Observable r11 = r10.observeBanner(r4.getRoomId(), 7);
        if (r11 == null) goto L9;
        ((ObservableSubscribeProxy) r11.as(AutoDispose.bind(r6))).subscribe(new a(r5, r7), new b(r8));
        return;
    L9:
        return;
    L7:
        r9.invoke();
    }
}
