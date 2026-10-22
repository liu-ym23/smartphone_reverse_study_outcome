package com.bytedance.android.livesdk.floatview;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s2;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.LiveMultiTabHandler;
import com.bytedance.android.livesdk.config.bx;
import com.bytedance.android.livesdk.config.gu0;
import com.bytedance.android.livesdk.config.o81;
import com.bytedance.android.livesdk.config.pl;
import com.bytedance.android.livesdk.config.sl;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.CommerceFragmentDispatcher;
import com.bytedance.android.livesdkapi.depend.model.FloatWindowBusinessLine;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.IDialogFragmentLifecycle;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.LiveBizWindowAbilityCenter;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.model.LiveBizWindowAbilityEnv;
import com.bytedance.android.livesdkapi.util.LiveMultiTabFloatWindowStore;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class NewVideoInnerFloatManager implements IVideoFloatManager {
    public static final q p = null;
    public static final Lazy q = null;
    public static final Lazy r = null;
    public final o81 a;
    public VideoFloatWindowView b;
    public VideoFloatWindowView c;
    public final List<IVideoFloatManager.VideoFloatManagerListener> d;
    public boolean e;
    public int f;
    public final List<InnerContextEntity> g;
    public int h;
    public final List<Integer> i;
    public InnerContextEntity.InnerFloatExtra j;
    public final Lazy k;
    public final Lazy l;
    public final LiveBizWindowAbilityEnv m;
    public final LiveBizWindowAbilityCenter n;
    public boolean o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/floatview/NewVideoInnerFloatManager$ActionType;", "", "SHOW", "CLICK", "MUTECLICK", "CLOSE", "RETURNCLICK", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType CLICK = null;
        public static final ActionType CLOSE = null;
        public static final ActionType MUTECLICK = null;
        public static final ActionType RETURNCLICK = null;
        public static final ActionType SHOW = null;
        public static final /* synthetic */ ActionType[] a = null;

        static {
            ActionType r1 = new ActionType("SHOW", 0);
            SHOW = r1;
            ActionType r2 = new ActionType("CLICK", 1);
            CLICK = r2;
            ActionType r3 = new ActionType("MUTECLICK", 2);
            MUTECLICK = r3;
            ActionType r4 = new ActionType("CLOSE", 3);
            CLOSE = r4;
            ActionType r5 = new ActionType("RETURNCLICK", 4);
            RETURNCLICK = r5;
            a = new ActionType[]{r1, r2, r3, r4, r5};
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) r27.a.a(ActionType.class, r1);
        }

        public static ActionType[] values() {
            return (ActionType[]) a.clone();
        }

        public ActionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a extends h {
        public final void b() {
            q r0 = NewVideoInnerFloatManager.p;
            VideoFloatWindowView r1 = b.a().b;
            if (r1 != null) goto L5;
        L6:
            VideoFloatWindowView r2 = b.a().b;
            if (r2 == null) goto L18;
            LivePlayerView r3 = r2.getMLivePlayerView$livesdk_saasRelease();
            if (r3 == null) goto L19;
            ILivePlayerClient r4 = r3.getClient();
            if (r4 != null) goto L13;
            return;
        L13:
            if (r4.isPlaying() == true) goto L21;
        L14:
            VideoFloatWindowView r5 = b.a().b;
            if (r5 == null) goto L22;
            r5.g();
            return;
        L22:
            return;
        L21:
            return;
        L19:
            return;
        L18:
            return;
        L5:
            if (r1.r == true) goto L14;
            goto L6
        }

        public a() {
        }

        public final void a(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            q r0 = NewVideoInnerFloatManager.p;
            b.a().n(new InnerContextEntity(r3));
        }

        public final void c(Context r3) {
            ALogger.i("NewVideoInnerFloatManager", "onBackToDesktop");
            Lazy r1 = LiveMultiTabHandler.a;
            IHostBusiness r2 = jc1.k.f(IHostBusiness.class);
            if (r2 == null) goto L7;
            ILiveMultiTabDepend r4 = r2.getLiveMultiTabDepend();
            if (r4 == null) goto L7;
            boolean r5 = r4.floatWindowPauseWhenBackground();
        L8:
            if (r5 == false) goto L16;
            q r6 = NewVideoInnerFloatManager.p;
            if (b.a().l() == false) goto L16;
            VideoFloatWindowView r7 = b.a().b;
            if (r7 == null) goto L14;
            r7.e();
        L14:
            ALogger.i("NewVideoInnerFloatManager", "moreLive pausePullStream");
            return;
        L16:
            if (NetworkUtils.isNetworkAvailable(r3) == true) goto L18;
            return;
        L18:
            if (NetworkUtils.isWifi(r3) == true) goto L26;
            q r8 = NewVideoInnerFloatManager.p;
            VideoFloatWindowView r9 = b.a().b;
            if (r9 == null) goto L22;
            r9.e();
        L22:
            ALogger.i("NewVideoInnerFloatManager", "4g pausePullStream");
            return;
        L26:
            return;
        L7:
            r5 = false;
            goto L8
        }

        public final void onPause(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            q r0 = NewVideoInnerFloatManager.p;
            b.a().m("onContextPause = " + r4);
            VideoFloatWindowView r1 = b.a().b;
            Context r2 = null;
            if (r1 == null) goto L5;
            Object r3 = r1.getParent();
        L7:
            if ((r3 instanceof View) == true) goto L9;
            r3 = null;
        L9:
            View r5 = (View) r3;
            if (r5 == null) goto L13;
            r2 = r5.getContext();
        L13:
            if (Intrinsics.areEqual(s2.a(r2), r4) == false) goto L18;
            VideoFloatWindowView r6 = b.a().b;
            if (r6 == null) goto L19;
            r6.onPause();
            return;
        L19:
            return;
        L18:
            return;
        L5:
            r3 = null;
            goto L7
        }

        public final void onResume(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            q r0 = NewVideoInnerFloatManager.p;
            b.a().m("onContextResume = " + r4);
            VideoFloatWindowView r1 = b.a().b;
            Context r2 = null;
            if (r1 == null) goto L5;
            Object r3 = r1.getParent();
        L7:
            if ((r3 instanceof View) == true) goto L9;
            r3 = null;
        L9:
            View r5 = (View) r3;
            if (r5 == null) goto L13;
            r2 = r5.getContext();
        L13:
            if (Intrinsics.areEqual(s2.a(r2), r4) == false) goto L18;
            VideoFloatWindowView r6 = b.a().b;
            if (r6 == null) goto L19;
            r6.onResume();
            return;
        L19:
            return;
        L18:
            return;
        L5:
            r3 = null;
            goto L7
        }

        public final void onStart(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            q r0 = NewVideoInnerFloatManager.p;
            NewVideoInnerFloatManager r1 = b.a();
            InnerContextEntity r2 = ox1.d.a(r4, b.a().j);
            if ((r4 instanceof LifecycleOwner) == true) goto L5;
            r4 = null;
        L5:
            r1.o(r2, (LifecycleOwner) r4);
        }

        public final void onStop(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            q r0 = NewVideoInnerFloatManager.p;
            b.a().p(new InnerContextEntity(r3));
        }
    }

    public static final class b {
        public static NewVideoInnerFloatManager a() {
            return (NewVideoInnerFloatManager) NewVideoInnerFloatManager.r.getValue();
        }
    }

    public static void g() {
        com.bytedance.android.livesdk.floatview.inner.b.b("start commerce window", 0, true);
    }

    static {
        p = new q(jc1.a.b(), new a());
        q = LazyKt.lazy(NewVideoInnerFloatManager$Companion$fragmentLifecycleListener$2.INSTANCE);
        r = LazyKt.lazy(NewVideoInnerFloatManager$Companion$instance$2.INSTANCE);
    }

    public static RelativeLayout.LayoutParams h() {
        RelativeLayout.LayoutParams r0 = new RelativeLayout.LayoutParams(1, 1);
        r0.addRule(12);
        r0.addRule(11);
        r0.bottomMargin = (int) t6.a(jc1.a.b(), 86.0f);
        return r0;
    }

    public final void d() {
        if (bx.a.getValue().a() == false) goto L13;
        VideoFloatWindowView r0 = this.b;
        if (r0 == null) goto L11;
        InnerContextEntity r1 = r0.getContainContext();
        if (r1 == null) goto L9;
        FrameLayout r2 = r1.getRootView();
    L10:
        f(r2);
        goto L11
    L9:
        r2 = null;
    L11:
        e();
        this.f = 0;
        this.b = null;
        return;
    }

    public final void e() {
        ((ArrayList) this.g).clear();
        InnerContextEntity.InnerFloatExtra r0 = this.j;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.h = 0;
        this.f = 0;
    }

    public final boolean l() {
        InnerContextEntity.InnerFloatExtra r0 = this.j;
        if (r0 == null) goto L7;
        FloatWindowBusinessLine r1 = r0.getBusinessLine();
        if (r1 == null) goto L7;
        String r2 = r1.getValue();
    L9:
        return Intrinsics.areEqual(r2, FloatWindowBusinessLine.MoreAnchor.getValue());
    L7:
        r2 = null;
        goto L9
    }

    public final void q() {
        VideoFloatWindowView r0 = this.b;
        if (r0 == null) goto L32;
        InnerContextEntity r4 = r0.l;
        if (r4 == null) goto L24;
        InnerContextEntity.InnerFloatExtra r5 = r4.getEnterExtra();
        if (r5 == null) goto L24;
        if (r5.getWhetherUnMuteWhenStop() != true) goto L24;
        LivePlayerView r6 = r0.i;
        if (r6 == null) goto L22;
        ILivePlayerClient r7 = r6.getClient();
        if (r7 == null) goto L22;
        if (r7.isMute() != true) goto L22;
        LivePlayerView r8 = r0.i;
        if (r8 == null) goto L24;
        ILivePlayerClient r9 = r8.getClient();
        if (r9 == null) goto L24;
        r9.unmute("VideoFloatWindowView.resumeNormal");
    L22:
        if (Intrinsics.areEqual(r0.t, Boolean.TRUE) == false) goto L24;
        xs2.b.a().post(new h1(48));
    L24:
        InnerContextEntity r1 = r0.l;
        if (r1 == null) goto L31;
        InnerContextEntity.InnerFloatExtra r2 = r1.getEnterExtra();
        if (r2 == null) goto L31;
        if (r2.getForceResumeWhenStop() != true) goto L31;
        xs2.b.a().post(new h1(42));
        return;
    L31:
        xs2.b.a().post(new h1(33));
        return;
    L32:
        InnerContextEntity.InnerFloatExtra r3 = this.j;
        if (r3 != null) goto L35;
    L37:
        xs2.b.a().post(new h1(33));
        return;
    L35:
        if (r3.getForceResumeWhenStop() != true) goto L37;
        xs2.b.a().post(new h1(42));
    }

    public final void r() {
        ALogger.i("NewVideoInnerFloatManager", "stopFloatNow");
        q();
        VideoFloatWindowView r0 = this.b;
        if (r0 == null) goto L14;
        InnerContextEntity r1 = r0.getContainContext();
        if (r1 == null) goto L7;
        FrameLayout r2 = r1.getRootView();
    L8:
        f(r2);
        if (l() == true) goto L14;
        InnerContextEntity r3 = r0.getContainContext();
        if (r3 == null) goto L14;
        List<Integer> r4 = this.i;
        ArrayList r5 = (ArrayList) r4;
        r5.remove(Integer.valueOf(r3.hashCode()));
        ((ArrayList) this.g).remove(r3);
        goto L14
    L7:
        r2 = null;
    L14:
        if (this.f != 2) goto L17;
        this.f = 3;
        return;
    }

    public final void s() {
        ALogger.i("NewVideoInnerFloatManager", "stopShowFloat");
        q();
        VideoFloatWindowView r0 = this.b;
        if (r0 == null) goto L9;
        InnerContextEntity r1 = r0.getContainContext();
        if (r1 == null) goto L7;
        FrameLayout r2 = r1.getRootView();
    L8:
        f(r2);
        goto L9
    L7:
        r2 = null;
    L9:
        e();
        this.f = 0;
        t(this.d, ActionType.CLOSE, false);
        LiveMultiTabFloatWindowStore r3 = LiveMultiTabFloatWindowStore.INSTANCE;
        r3.setTabChange(false);
        r3.setMoreLiveToLiveTab(false);
    }

    public NewVideoInnerFloatManager() {
        if (p.a() == false) goto L8;
        IHostApp r0 = jc1.k.f(IHostApp.class);
        if (r0 == null) goto L7;
        r0.registerLiveLifeCycleListener(p);
    L7:
        CommerceFragmentDispatcher.INSTANCE.registerListener((IDialogFragmentLifecycle) q.getValue());
    L9:
        this.a = gu0.a.getValue();
        this.d = new ArrayList();
        new HashSet();
        this.g = new ArrayList();
        this.i = new ArrayList();
        this.k = LazyKt.lazy(NewVideoInnerFloatManager$accessList$2.INSTANCE);
        this.l = LazyKt.lazy(NewVideoInnerFloatManager$transCheckWhiteList$2.INSTANCE);
        LiveBizWindowAbilityEnv r1 = new LiveBizWindowAbilityEnv();
        r1.setShowingOnToolbar(NewVideoInnerFloatManager$abilityEnv$1$1.INSTANCE);
        Unit r2 = Unit.INSTANCE;
        this.m = r1;
        this.n = new LiveBizWindowAbilityCenter(r1);
        return;
    L8:
        ALogger.i("NewVideoInnerFloatManager", "isFloatInsideWindowOpen is false");
        goto L9
    }

    public static boolean j() {
        VideoFloatWindowView r0 = b.a().b;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.s != true) goto L7;
        return true;
    }

    public final boolean i() {
        if (b.a().b == null) goto L7;
        if (this.e == false) goto L7;
    L8:
        return true;
    L7:
        if (this.f == 4) goto L8;
        return false;
    }

    public static final void a(NewVideoInnerFloatManager r5) {
        int r0 = ((ArrayList) r5.g).size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L13;
        InnerContextEntity r1 = (InnerContextEntity) ListProtector.get(r5.g, r0);
        if (r1.getType() != 2) goto L12;
        Activity r2 = r1.getActivity();
        if (r2 == null) goto L12;
        if (((ArrayList) r5.g).contains(new InnerContextEntity(r2)) == true) goto L3;
    L12:
        r1.finish();
        goto L3
    }

    public static void c(FloatWindowBusinessLine r1) {
        if (pl.a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L10;
        if (r1 != null) goto L11;
        f2.c("debug：请在小窗api入参InnerContextEntity.InnerFloatExtra中补充参数businessLine，如有疑问请联系liusihao.0908", 0);
        return;
    L11:
        return;
    }

    public static boolean k(Activity r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        IHostApp r1 = jc1.k.f(IHostApp.class);
        Object r2 = null;
        if (r1 == null) goto L8;
        List r3 = r1.getAllLiveActivity();
    L9:
        if (r3 == null) goto L17;
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        Object r5 = r4.next();
        if (((Class) r5).isAssignableFrom(r6.getClass()) == false) goto L12;
        r2 = r5;
    L16:
        r2 = (Class) r2;
    L17:
        if (r2 == null) goto L23;
        return true;
    L23:
        return false;
    L8:
        r3 = null;
        goto L9
    }

    public final void f(FrameLayout r4) {
        VideoFloatWindowView r0 = this.b;
        if (r0 == null) goto L17;
        m("detach " + r0.getContainContext());
        this.e = false;
        VideoFloatWindowView r1 = this.b;
        if (r1 == null) goto L7;
        ViewParent r2 = r1.getParent();
    L9:
        if (Intrinsics.areEqual(r4, r2) == false) goto L18;
        r0.stop();
        if (r4 == null) goto L14;
        r4.removeView(this.b);
    L14:
        if (bx.a.getValue().a() == true) goto L19;
        this.b = null;
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void layoutParams(RelativeLayout.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        VideoFloatWindowView r0 = this.b;
        if (r0 == null) goto L8;
        FrameLayout r1 = r0.getVideoContainer();
        if (r1 == null) goto L9;
        r3.width = 1;
        r3.height = 1;
        r1.setLayoutParams(r3);
        return;
    L9:
        return;
    }

    public final void m(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        ALogger.i("NewVideoInnerFloatManager", "state = " + this.f + "  " + r3);
    }

    public final void n(InnerContextEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        m("onContextDestroy = " + r3);
        if (((ArrayList) this.g).contains(r3) == false) goto L6;
        ((ArrayList) this.g).remove(r3);
    L6:
        if (((ArrayList) this.i).contains(Integer.valueOf(r3.hashCode())) == false) goto L9;
        ((ArrayList) this.i).remove(Integer.valueOf(r3.hashCode()));
    L9:
        if (this.h != r3.hashCode()) goto L12;
        e();
        return;
    }

    public final void p(InnerContextEntity r7) {
        Intrinsics.checkNotNullParameter(r7, "entity");
        m("onContextStop = " + r7);
        int r0 = this.f;
        if (r0 == 2) goto L6;
        if (r0 == 4) goto L6;
        return;
    L6:
        q r1 = p;
        if (r1.a == true) goto L16;
        if (r0 != 4) goto L16;
        if (((ArrayList) b.a().g).contains(r7) == false) goto L16;
        if (((ArrayList) b.a().g).size() > 1) goto L14;
    L15:
        q();
        this.f = 0;
        b.a().e = false;
        goto L16
    L14:
        if (r7.hashCode() == this.h) goto L15;
    L16:
        VideoFloatWindowView r2 = b.a().b;
        if (r2 == null) goto L37;
        InnerContextEntity r3 = r2.getContainContext();
        if (r3 != null) goto L21;
        return;
    L21:
        if (r3.equals(r7) != true) goto L39;
        StringBuilder r4 = new StringBuilder("equal ");
        VideoFloatWindowView r5 = b.a().b;
        String r6 = null;
        if (r5 == null) goto L25;
        InnerContextEntity r8 = r5.getContainContext();
    L26:
        r4.append(r8);
        r4.append("  ");
        r4.append(r7);
        m(r4.toString());
        if (r1.a == false) goto L29;
        return;
    L29:
        if (((ArrayList) b.a().g).size() != 1) goto L41;
        Activity r9 = jc1.k.n(IHostApp.class).getTopActivity();
        if (r9 == null) goto L34;
        r6 = r9.getClass().getSimpleName();
    L34:
        if ((!Intrinsics.areEqual(r6, jc1.k.n(IHostApp.class).getTimingCloseActivityName())) == false) goto L42;
        q();
        b.a().f(r7.getRootView());
        b.a().e = false;
        this.f = 0;
        m("onContextDetach and resume " + r7);
        return;
    L42:
        return;
    L41:
        return;
    L25:
        r8 = null;
        goto L26
    L39:
        return;
    }

    public final void b(final InnerContextEntity r14, LifecycleOwner r15) {
        ALogger.i("NewVideoInnerFloatManager", "attachEntity success");
        b.a().e = true;
        InnerContextEntity.InnerFloatExtra r0 = this.j;
        if (r0 == null) goto L6;
        String r1 = r0.getRequestPage();
        if (r1 == null) goto L6;
    L7:
        r14.setRequestPage(r1);
        final NewVideoInnerFloatManager r2 = b.a();
        final FrameLayout r3 = r14.getRootView();
        r2.getClass();
        r2.m("attach " + r14);
        if (r3 == null) goto L150;
        String r4 = null;
        int r5 = 0;
        if (r2.b != null) goto L51;
        VideoFloatWindowView r6 = r2.c;
        if (r6 == null) goto L16;
        Context r7 = r6.getContext();
    L18:
        if ((!Intrinsics.areEqual(r7, r3.getContext())) == false) goto L20;
        r2.c = null;
    L20:
        VideoFloatWindowView r8 = r2.c;
        if (r8 == null) goto L23;
        r2.b = r8;
    L24:
        VideoFloatWindowView r9 = r2.b;
        if (r9 == null) goto L35;
        FrameLayout r10 = r9.getVideoContainer();
        if (r10 == null) goto L35;
        InnerContextEntity.InnerFloatExtra r11 = r2.j;
        if (r11 == null) goto L33;
        RelativeLayout.LayoutParams r12 = r11.getParams();
        if (r12 == null) goto L33;
    L34:
        r10.setLayoutParams(r12);
    L33:
        r12 = h();
    L35:
        VideoFloatWindowView r13 = r2.b;
        if (r13 == null) goto L48;
        DragRelativeLayout r16 = r13.getDragLayoutView();
        if (r16 == null) goto L48;
        InnerContextEntity.InnerFloatExtra r17 = r2.j;
        if (r17 == null) goto L42;
        int r18 = UtilityKotlinExtentionsKt.i(r17.getFloatViewHorizontalMargin());
    L43:
        a1.m(r16, r18);
        InnerContextEntity.InnerFloatExtra r19 = r2.j;
        if (r19 == null) goto L46;
        int r20 = UtilityKotlinExtentionsKt.i(r19.getFloatViewHorizontalMargin());
    L47:
        a1.n(r16, r20);
        goto L48
    L46:
        r20 = 0;
        goto L47
    L42:
        r18 = 0;
    L48:
        VideoFloatWindowView r21 = r2.b;
        if (r21 == null) goto L51;
        r21.setFloatViewListener(new NewVideoInnerFloatManager$setVideoFloatManagerListener$1(r2));
        goto L51
    L23:
        r2.b = new VideoFloatWindowView(r3.getContext(), 1);
        goto L24
    L16:
        r7 = null;
    L51:
        VideoFloatWindowView r22 = r2.b;
        if (r22 == null) goto L54;
        r22.setContainContext(r14);
    L54:
        VideoFloatWindowView r23 = r2.b;
        if (r23 == null) goto L57;
        Room r24 = r23.getCurRoomData();
    L59:
        if (r24 != null) goto L62;
    L79:
        boolean r25 = true;
    L81:
        if (r25 == false) goto L85;
        r2.m("data changed");
        VideoFloatWindowView r26 = r2.b;
        if (r26 == null) goto L85;
        r26.stop();
    L85:
        VideoFloatWindowView r27 = r2.b;
        if (r27 == null) goto L88;
        ViewParent r28 = r27.getParent();
    L89:
        if (r28 == r3) goto L128;
        VideoFloatWindowView r29 = r2.b;
        if (r29 == null) goto L93;
        ViewParent r30 = r29.getParent();
    L95:
        if ((r30 instanceof ViewGroup) == true) goto L97;
        r30 = null;
    L97:
        ViewGroup r31 = (ViewGroup) r30;
        if (r31 == null) goto L100;
        r31.removeView(r2.b);
    L100:
        InnerContextEntity.InnerFloatExtra r32 = r14.getEnterExtra();
        if (r32 != null) goto L103;
    L127:
        r3.addView(r2.b);
        r2.m("change to " + r14);
        goto L128
    L103:
        if (r32.getEnableChangePosition() != true) goto L127;
        VideoFloatWindowView r33 = r2.b;
        if (r33 == null) goto L115;
        FrameLayout r34 = r33.getVideoContainer();
        if (r34 == null) goto L115;
        InnerContextEntity.InnerFloatExtra r35 = r14.getEnterExtra();
        if (r35 == null) goto L113;
        RelativeLayout.LayoutParams r36 = r35.getParams();
        if (r36 == null) goto L113;
    L114:
        r34.setLayoutParams(r36);
    L113:
        r36 = h();
    L115:
        VideoFloatWindowView r37 = r2.b;
        if (r37 == null) goto L127;
        DragRelativeLayout r38 = r37.getDragLayoutView();
        if (r38 == null) goto L127;
        InnerContextEntity.InnerFloatExtra r39 = r2.j;
        if (r39 == null) goto L122;
        int r40 = UtilityKotlinExtentionsKt.i(r39.getFloatViewHorizontalMargin());
    L123:
        a1.m(r38, r40);
        InnerContextEntity.InnerFloatExtra r41 = r2.j;
        if (r41 == null) goto L126;
        r5 = UtilityKotlinExtentionsKt.i(r41.getFloatViewHorizontalMargin());
    L126:
        a1.n(r38, r5);
        goto L127
    L122:
        r40 = 0;
        goto L123
    L93:
        r30 = null;
    L128:
        Function1<Room, Unit> r42 = new NewVideoInnerFloatManager$attach$3(r2, r14, r3);
        Intrinsics.checkNotNullParameter(r42, "action");
        if (r14.getDataSource() != null) goto L137;
        RoomContext r110 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r110 == null) goto L140;
        com.bytedance.live.datacontext.m r111 = r110.getRoom();
        if (r111 == null) goto L140;
        Room r112 = (Room) r111.getValue();
        if (r112 == null) goto L140;
        r42.invoke(r112);
    L140:
        List<String> r113 = p.c;
        VideoFloatWindowView r114 = b.a().b;
        if (r114 == null) goto L146;
        InnerContextEntity r115 = r114.getContainContext();
        if (r115 == null) goto L146;
        r4 = r115.getRequestPage();
    L146:
        if (CollectionsKt.contains(r113, r4) == false) goto L148;
        com.bytedance.android.livesdk.log.u.l().c(am2.r.class).getMap().put("data_type", "commerce_data");
    L149:
        xs2.b.a().post(new u22.e());
        goto L150
    L148:
        com.bytedance.android.livesdk.log.u.l().c(am2.r.class).getMap().remove("data_type");
        goto L149
    L137:
        InnerContextEntity.FloatWindowDataSource r116 = r14.getDataSource();
        if (r116 == null) goto L140;
        r116.runAfterDataReady(r15, r42);
        goto L140
    L88:
        r28 = null;
        goto L89
    L62:
        if (r14.getDataSource() != null) goto L71;
        RoomContext r43 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r43 == null) goto L68;
        com.bytedance.live.datacontext.m r44 = r43.getRoom();
        if (r44 == null) goto L68;
        Room r45 = (Room) r44.getValue();
    L69:
        r25 = !Intrinsics.areEqual(r45, r24);
    L68:
        r45 = null;
        goto L69
    L71:
        if ((r14.getDataSource() instanceof ox1.b) == false) goto L80;
        long r46 = r24.id;
        InnerContextEntity.FloatWindowDataSource r47 = r14.getDataSource();
        if ((r47 instanceof ox1.b) == true) goto L75;
        r47 = null;
    L75:
        ox1.b r48 = (ox1.b) r47;
        if (r48 == null) goto L79;
        if (r46 != r48.c) goto L79;
    L80:
        r25 = false;
        goto L81
    L57:
        r24 = null;
    L150:
        this.f = 2;
        return;
    L6:
        r1 = "";
        goto L7
    }

    public final void o(InnerContextEntity r10, LifecycleOwner r11) {
        Intrinsics.checkNotNullParameter(r10, "entity");
        m("onContextStart = " + r10);
        if (((ArrayList) this.i).contains(Integer.valueOf(r10.hashCode())) == true) goto L5;
        ((ArrayList) this.i).add(Integer.valueOf(r10.hashCode()));
    L5:
        boolean r2 = false;
        Activity r3 = null;
        if (this.h == r10.hashCode()) goto L8;
    L17:
        WeakReference r0 = r10.getActivityRef();
        if (r0 == null) goto L20;
        Activity r1 = (Activity) r0.get();
    L22:
        if (k(r1) == true) goto L25;
    L55:
        WeakReference r4 = r10.getActivityRef();
        if (r4 == null) goto L58;
        Activity r5 = (Activity) r4.get();
    L60:
        if (k(r5) == true) goto L129;
        IHostApp r6 = jc1.k.f(IHostApp.class);
        if (r6 == null) goto L65;
        String r7 = r6.getTimingCloseActivityName();
    L66:
        if (r7 == null) goto L83;
        WeakReference r8 = r10.getActivityRef();
        if (r8 == null) goto L76;
        Activity r9 = (Activity) r8.get();
        if (r9 == null) goto L76;
        String r12 = r9.getLocalClassName();
        if (r12 == null) goto L76;
        if (StringsKt.contains$default(r12, r7, false, 2, null) != true) goto L76;
        boolean r13 = true;
    L77:
        if (r13 == true) goto L80;
        r7 = null;
    L80:
        if (r7 == null) goto L83;
    L76:
        r13 = false;
    L83:
        if (sl.a.getValue().booleanValue() == false) goto L123;
        List r14 = (List) this.l.getValue();
        if (r14 == null) goto L102;
        List r15 = r14;
        InnerContextEntity.InnerFloatExtra r16 = r10.getEnterExtra();
        if (r16 == null) goto L89;
        String r17 = r16.getRequestPage();
    L91:
        if (CollectionsKt.contains(r15, r17) != true) goto L102;
        WeakReference r18 = r10.getActivityRef();
        if (r18 == null) goto L95;
        Activity r19 = (Activity) r18.get();
    L96:
        if (r19 == null) goto L98;
        int r20 = r19.hashCode();
    L100:
        if (r20 != this.h) goto L102;
        boolean r21 = true;
    L103:
        if (r21 == true) goto L123;
        WeakReference r22 = r10.getActivityRef();
        if (r22 == null) goto L123;
        Activity r23 = (Activity) r22.get();
        if (r23 == null) goto L123;
        int r24 = l.a;
        Intrinsics.checkNotNullParameter(r23, "activity");
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L116
        int r26 = r23.getWindow().getAttributes().flags;     // Catch: Throwable -> L116
        if ((67108864 & r26) == 0) goto L112;
    L115:
        boolean r27 = true;
    L119:
        if (r27 == false) goto L121;
        r3 = r23;
    L121:
        if (r3 == null) goto L123;
    L112:
        if ((r26 & 134217728) != 0) goto L115;
        if (r23.getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsTranslucent}).getBoolean(0, false) == true) goto L115;
    L118:
        r27 = false;
    L116:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L118
    L98:
        r20 = 0;
        goto L100
    L95:
        r19 = null;
        goto L96
    L89:
        r17 = null;
    L102:
        r21 = false;
    L123:
        int r29 = this.h;
        if (r29 == 0) goto L129;
        int r30 = ((ArrayList) this.i).indexOf(Integer.valueOf(r29));
        int r31 = ((ArrayList) this.i).indexOf(Integer.valueOf(r10.hashCode()));
        if (r31 <= 0) goto L130;
        if (r30 > r31) goto L129;
    L130:
        if (r2 == false) goto L133;
        ALogger.i("NewVideoInnerFloatManager", "attachEntity fail: shouldIgnoreStart");
        return;
    L133:
        int r32 = this.f;
        if (r32 == 1) goto L144;
        if (r32 == 2) goto L144;
        if (r32 == 3) goto L139;
        return;
    L139:
        if ((!((ArrayList) this.g).isEmpty()) == false) goto L150;
        List<InnerContextEntity> r33 = this.g;
        if (Intrinsics.areEqual(r10, (InnerContextEntity) ListProtector.get(r33, ((ArrayList) r33).size() - 1)) == false) goto L151;
        List<InnerContextEntity> r110 = this.g;
        b((InnerContextEntity) ListProtector.get(r110, ((ArrayList) r110).size() - 1), r11);
        return;
    L151:
        return;
    L150:
        return;
    L144:
        if (((ArrayList) this.g).contains(r10) == true) goto L146;
        ((ArrayList) this.g).add(r10);
    L146:
        b(r10, r11);
        return;
    L65:
        r7 = null;
    L129:
        r2 = true;
        goto L130
    L58:
        r5 = null;
        goto L60
    L25:
        if (this.f != 2) goto L27;
    L36:
        int r34 = ((ArrayList) this.i).indexOf(Integer.valueOf(this.h));
        int r35 = ((ArrayList) this.i).indexOf(Integer.valueOf(r10.hashCode()));
        if (r35 <= 0) goto L55;
        if (r35 <= r34) goto L55;
        VideoFloatWindowView r36 = this.b;
        if (r36 == null) goto L46;
        InnerContextEntity r37 = r36.getContainContext();
        if (r37 == null) goto L44;
        FrameLayout r38 = r37.getRootView();
    L45:
        f(r38);
        goto L46
    L44:
        r38 = null;
    L46:
        this.e = false;
        this.f = 0;
        VideoFloatWindowView r39 = this.b;
        if (r39 != null) goto L49;
    L51:
        boolean r40 = false;
    L52:
        if (r40 == false) goto L54;
        q();
    L54:
        m("onContextStart and start " + r10);
        goto L55
    L49:
        if (r39.n() != true) goto L51;
        r40 = true;
        goto L52
    L27:
        if (l() == false) goto L33;
        int r41 = this.f;
        if (r41 == 2) goto L32;
        if (r41 != 3) goto L33;
    L32:
        boolean r42 = false;
    L34:
        if (r42 == false) goto L36;
    L33:
        r42 = true;
        goto L34
    L20:
        r1 = null;
        goto L22
    L8:
        if (((ArrayList) this.g).contains(r10) == true) goto L17;
        VideoFloatWindowView r43 = this.b;
        if (r43 == null) goto L16;
        q();
        InnerContextEntity r44 = r43.getContainContext();
        if (r44 == null) goto L14;
        FrameLayout r45 = r44.getRootView();
    L15:
        f(r45);
        goto L16
    L14:
        r45 = null;
    L16:
        this.e = false;
        this.f = 0;
        m("onContextResume and resume " + r10);
        goto L17
    }

    public static void t(List r1, ActionType r2, boolean r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList(r1);
        int r4 = i.a[r2.ordinal()];
        if (r4 != 1) goto L7;
        Iterator r5 = r0.iterator();
    L41:
        if (r5.hasNext() == false) goto L75;
        IVideoFloatManager.VideoFloatManagerListener r6 = (IVideoFloatManager.VideoFloatManagerListener) r5.next();
        if (r6 == null) goto L41;
        r6.onShow();
        goto L41
    L75:
        return;
    L7:
        if (r4 != 2) goto L9;
        Iterator r7 = r0.iterator();
    L35:
        if (r7.hasNext() == false) goto L74;
        IVideoFloatManager.VideoFloatManagerListener r8 = (IVideoFloatManager.VideoFloatManagerListener) r7.next();
        if (r8 == null) goto L35;
        r8.onClick();
        goto L35
    L74:
        return;
    L9:
        if (r4 != 3) goto L11;
        Iterator r9 = r0.iterator();
    L29:
        if (r9.hasNext() == false) goto L73;
        IVideoFloatManager.VideoFloatManagerListener r10 = (IVideoFloatManager.VideoFloatManagerListener) r9.next();
        if (r10 == null) goto L29;
        r10.onMuteButtonClick(r3);
        goto L29
    L73:
        return;
    L11:
        if (r4 != 4) goto L13;
        Iterator r11 = r0.iterator();
    L23:
        if (r11.hasNext() == false) goto L72;
        IVideoFloatManager.VideoFloatManagerListener r12 = (IVideoFloatManager.VideoFloatManagerListener) r11.next();
        if (r12 == null) goto L23;
        r12.onClose(r3);
        goto L23
    L72:
        return;
    L13:
        if (r4 != 5) goto L45;
        Iterator r13 = r0.iterator();
    L17:
        if (r13.hasNext() == false) goto L71;
        IVideoFloatManager.VideoFloatManagerListener r14 = (IVideoFloatManager.VideoFloatManagerListener) r13.next();
        if (r14 == null) goto L17;
        r14.onReturnClick();
        goto L17
    L71:
        return;
    }
}
