package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.LandscapeRootViewChangeManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.config.nt;
import com.bytedance.android.livesdk.message.model.wd;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/LandscapeCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Ljo1/h;", "Lcom/bytedance/android/livesdkapi/eventbus/HorizontalPlayEvent;", "event", "", "onEvent", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeCompositeWidget extends MiddlewareRoomWidget implements jo1.h {
    public LandscapeRootViewChangeManager a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c b;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a c;
    public final CompositeDisposable d;

    public static final class a implements Runnable {
        public final /* synthetic */ LandscapeCompositeWidget a;

        public a(LandscapeCompositeWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(this.a.getComponentContext());     // Catch: Throwable -> L12
            if (r0 == null) goto L7;
            Fragment r1 = r0.getFragment();     // Catch: Throwable -> L12
            if (r1 == null) goto L7;
            Fragment r2 = r1.getParentFragment();     // Catch: Throwable -> L12
        L9:
            if ((r2 instanceof ILiveRoomPlayFragment) == false) goto L15;
            ((ILiveRoomPlayFragment) r2).getRealAction().preInitLandscapeRoomUIContext();     // Catch: Throwable -> L12
            return;
        L15:
            return;
        L7:
            r2 = null;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LandscapeCompositeWidget a;

        public b(LandscapeCompositeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            HorizontalPlayEvent r3 = (HorizontalPlayEvent) r2;
            if (r3 == null) goto L6;
            this.a.onEvent(r3);
            return;
        }
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public final boolean wq() {
        if (this.a == null) goto L5;
        return true;
    L5:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.b;
        View r2 = null;
        if (r0 == null) goto L8;
        Room r1 = r0.getRoom();
    L10:
        if (r1 != null) goto L12;
    L14:
        DataCenter r6 = ((Widget) this).dataCenter;
        RoomContext r7 = xq();
        com.bytedance.android.livesdk.chatroom.ui.framework.d r3 = ho1.a.i(getComponentContext());
        if (r3 == null) goto L17;
        r2 = r3.Fo();
    L17:
        View r5 = r2;
        if (r6 == null) goto L32;
        if (r7 == null) goto L32;
        if (r5 == null) goto L32;
        a r9 = new a(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = this.b;
        if (r4 == null) goto L29;
        Bundle r8 = r4.Wl();
        if (r8 == null) goto L29;
        if (r8.getBoolean("extra_longer_video_with_live", false) != true) goto L29;
        boolean r10 = true;
    L30:
        this.a = new LandscapeRootViewChangeManager(r5, r6, r7, r10, r9);
        return true;
    L29:
        r10 = false;
    L32:
        return false;
    L12:
        if (r1.isMergeVSRoom() == false) goto L14;
        return false;
    L8:
        r1 = null;
        goto L10
    }

    public final RoomContext xq() {
        DataContext r0 = this.dataContext;
        if ((r0 instanceof RoomContext) == true) goto L6;
        r0 = null;
    L6:
        return (RoomContext) r0;
    }

    public final ViewTreeObserver yq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.b;
        if (r0 == null) goto L15;
        FragmentActivity r1 = r0.p0();
        if (r1 == null) goto L15;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L15;
        View r3 = r2.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L13;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L13;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L13:
        if (r3 == null) goto L15;
        return r3.getViewTreeObserver();
    L15:
        return null;
    }

    public LandscapeCompositeWidget() {
        this.d = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L5;
        ho1.a.p(r0, jo1.h.class, this);
    L5:
        this.b = ho1.a.d(getComponentContext());
        this.c = ho1.a.c(getComponentContext());
        wd r1 = new wd();
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.b;
        Room r3 = null;
        if (r2 == null) goto L8;
        Room r4 = r2.getRoom();
    L10:
        if (com.bytedance.android.livesdk.utils.landscape.e.b(false, r4) == false) goto L12;
        r1.a = 0;
    L13:
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L17;
        r5.put("cmd_normal_gift_layout_bottom_margin_update", r1);
    L17:
        if (wq() == false) goto L29;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r6 = ho1.a.i(getComponentContext());
        if (r6 == null) goto L29;
        View r7 = r6.Fo();
        if (r7 == null) goto L29;
        LandscapeRootViewChangeManager r8 = this.a;
        if (r8 == null) goto L25;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r8.r = r7;
    L25:
        LandscapeRootViewChangeManager r9 = this.a;
        if (r9 == null) goto L29;
        Message.obtain(r9.g, r9.b).sendToTarget();
    L29:
        if (wq() == false) goto L38;
        LandscapeRootViewChangeManager r10 = this.a;
        if (r10 == null) goto L33;
        LandscapeRootViewChangeManager.b r11 = r10.q;
    L34:
        ViewTreeObserver r12 = yq();
        if (r12 == null) goto L38;
        if (r11 == null) goto L38;
        r12.addOnGlobalLayoutListener(r11);
        goto L38
    L33:
        r11 = null;
    L38:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r13 = this.b;
        if (r13 == null) goto L41;
        r3 = r13.getRoom();
    L41:
        if (r3 != null) goto L44;
    L52:
        ((ObservableSubscribeProxy) xs2.b.a().b(HorizontalPlayEvent.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new b(this));
        if (((Boolean) LiveInfraSettingKeys.LIVE_ENABLE_LANDSCAPE_LOG_FIX.getValue()).booleanValue() == false) goto L62;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r14 = this.c;
        if (r14 == null) goto L63;
        PropertyOwner r15 = r14.getLoadState();
        if (r15 == null) goto L64;
        Disposable r16 = com.bytedance.android.livesdk.chatroom.ui.framework.b.e(r15, new AnonymousClass2(this));
        if (r16 == null) goto L65;
        RxUtilKt.c(r16, this.d);
        return;
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    L44:
        if (r3.isMergeVSRoom() == true) goto L48;
        if (m50.a.getValue().k() == false) goto L48;
    L51:
        boolean r17 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.t(true);
        MatchRoomLandScapeAnimUtil.y = VSMediaUIConfigHelper.b(((Widget) this).dataCenter);
    L48:
        if (r3.isMergeVSRoom() == false) goto L52;
        if (nt.a.getValue().booleanValue() == false) goto L52;
    L12:
        r1.a = s1.j(2131168951);
        goto L13
    L8:
        r4 = null;
        goto L10
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L5;
        ho1.a.q(r0, jo1.h.class);
    L5:
        LandscapeRootViewChangeManager r1 = this.a;
        if (r1 == null) goto L12;
        LandscapeRootViewChangeManager.b r2 = r1.q;
        if (r2 == null) goto L12;
        ViewTreeObserver r3 = yq();
        if (r3 == null) goto L12;
        r3.removeOnGlobalLayoutListener(r2);
    L12:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = this.b;
        if (r4 == null) goto L15;
        Room r5 = r4.getRoom();
    L16:
        if (r5 != null) goto L19;
    L27:
        CompositeDisposable r6 = this.d;
        if (r6 == null) goto L30;
        r6.dispose();
    L30:
        this.b = null;
        return;
    L19:
        if (r5.isMergeVSRoom() == true) goto L23;
        if (m50.a.getValue().k() == false) goto L23;
    L26:
        boolean r7 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.t(false);
        com.bytedance.android.livesdk.f.d().a.removeObserver(MatchRoomLandScapeAnimUtil.p);
    L23:
        if (r5.isMergeVSRoom() == false) goto L27;
        if (nt.a.getValue().booleanValue() == false) goto L27;
    L15:
        r5 = null;
        goto L16
    }

    @Override // jo1.h
    public final LandscapeRootViewChangeManager ok() {
        return this.a;
    }

    public final void onEvent(HorizontalPlayEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L14;
        int r4 = r3.what;
        if (r4 != 3) goto L10;
        ((Widget) this).dataCenter.put("cmd_clear_gift_message", new com.bytedance.android.livesdk.chatroom.model.q());
        return;
    L10:
        if (r4 != 4) goto L16;
        ((Widget) this).dataCenter.put("cmd_resume_gift_message", new com.bytedance.android.livesdk.chatroom.model.q());
        return;
    L16:
        return;
    }

    @Override // jo1.h
    public final void onPageScrollStateChanged(int r3) {
        LandscapeRootViewChangeManager r0 = this.a;
        if (r0 == null) goto L10;
        boolean r1 = true;
        if (r3 == 1) goto L8;
        r1 = false;
    L8:
        r0.f = r1;
        return;
    }
}
