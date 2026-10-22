package si0;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService;
import com.bytedance.android.live.broadcastgame.api.xplay.f;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.utils.l;
import com.bytedance.android.live.liveinteract.utils.n;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements si0.b {
    public boolean a;
    public ViewGroup b;
    public ViewGroup c;
    public ViewGroup d;
    public final b e;
    public final CompositeDisposable f;
    public final ne0.c g;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            ALogger.i("XplayController", "update linkPlayerState: " + ((Integer) r5));
            if (this.a.a == true) goto L5;
            return;
        L5:
            if (hd0.c.f().h() == true) goto L9;
            ALogger.i("XplayController", "user leave -> stopPlugin");
            n.a.a(qi0.d.a, false, "onUserLeaveStopPlugin", null, 12);
            this.a.f("multilink userLeave");
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;

        public c(int r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            e r9 = (e) r8;
            ALogger.i("XplayController", "xplay_init_callback_result, success");
            qi0.d.a.a(false, "xplay_init_callback_result", 0, "initStatus: " + this.a + ", lodId = " + r9.logId);
            IInteractService r0 = (IInteractService) k.f(IInteractService.class);
            if (r0 == null) goto L8;
            l r1 = r0.getLinkMicGameFullLinkMonitor();
            if (r1 == null) goto L9;
            LinkMonitorData r2 = LinkMonitorData.XplayInitCallBack;
            long r3 = System.currentTimeMillis() - this.b;
            String r5 = r9.logId;
            HashMap r6 = new HashMap();
            r6.put("xplay_init_callback_status", Integer.valueOf(this.a));
            Unit r10 = Unit.INSTANCE;
            r1.c(r2, r3, r5, r6);
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: si0.d$d, reason: collision with other inner class name */
    public static final class C0271d<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;

        public C0271d(int r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            Throwable r4 = (Throwable) r8;
            StringBuilder r9 = new StringBuilder("xplay_init_callback_result, failed, lodId = ");
            qi0.d r0 = qi0.d.a;
            r9.append(qi0.d.b(r4));
            ALogger.e("XplayController", r9.toString());
            r0.a(false, "xplay_init_callback_result", -1, "initStatus: " + this.a + ", lodId = " + qi0.d.b(r4));
            IInteractService r10 = (IInteractService) k.f(IInteractService.class);
            if (r10 == null) goto L8;
            l r1 = r10.getLinkMicGameFullLinkMonitor();
            if (r1 == null) goto L9;
            LinkMonitorData r2 = LinkMonitorData.XplayInitCallBack;
            long r3 = System.currentTimeMillis() - this.b;
            HashMap r5 = new HashMap();
            r5.put("xplay_init_callback_status", Integer.valueOf(this.a));
            Unit r11 = Unit.INSTANCE;
            r1.a(r2, r3, r4, r5);
            return;
        L9:
            return;
        }
    }

    static {
    }

    @Override // si0.b
    public final void d() {
    }

    @Override // si0.b
    public final void onDestroy() {
        ALogger.i("XplayController", "onDestroy");
        if (this.a == false) goto L5;
        ALogger.i("XplayController", "onDestroy -> stopPlugin");
        n.a.a(qi0.d.a, false, "onXplayControllerDestroy", null, 12);
        f("multilink onDestroy");
    L5:
        hd0.c.f().e(this.e);
        this.f.clear();
    }

    @Override // si0.b
    public final void onCreate() {
        hd0.c.f().c(this.e);
    }

    @Override // si0.b
    public final void a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        Intrinsics.checkNotNullParameter(r2, "parentView");
    }

    @Override // si0.b
    public final void b(boolean r5) {
        ALogger.i("XplayController", "updateGameState, isGameStart: " + r5);
        if (r5 == false) goto L5;
        return;
    L5:
        if (this.a == false) goto L9;
        ALogger.i("XplayController", "updateGameState -> stopPlugin");
        n.a.a(qi0.d.a, false, "onGameEndStopPlugin", null, 12);
        f("multilink game stop");
        return;
    }

    public final void e(int r12) {
        ALogger.i("XplayController", "notifyServerXplayInitCallback, status: " + r12);
        n.a.a(qi0.d.a, false, "notifyServerXplayInitCallback", "initStatus: " + r12, 4);
        long r6 = je0.d.a0();
        long r0 = System.currentTimeMillis();
        LinkApi r5 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        int r9 = LinkApi.XplayInitCallbackScene.SCENE_DANMU.getValue();
        JSONObject r2 = new JSONObject();
        Unit r3 = Unit.INSTANCE;
        RxUtilKt.c(r5.xplayInitCallback(r6, r12, r9, r2.toString()).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r12, r0), new C0271d(r12, r0)), this.f);
    }

    public final void f(String r6) {
        n.a.a(qi0.d.a, false, "stopPlugin", "source: ".concat(r6), 4);
        ViewGroup r0 = this.b;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        ViewGroup r1 = this.b;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        ViewGroup r2 = this.c;
        if (r2 == null) goto L11;
        r2.removeAllViews();
    L11:
        ViewGroup r3 = this.c;
        if (r3 == null) goto L14;
        r3.setVisibility(8);
    L14:
        IMiddlewareInteractGameService r4 = k.f(IMiddlewareInteractGameService.class);
        if (r4 == null) goto L18;
        r4.stopRunningPlugin(r6);
        return;
    }

    @Override // si0.b
    public final void c(si0.b.a r24, f r25) {
        Intrinsics.checkNotNullParameter(r24, "info");
        ALogger.i("XplayController", "onXplayVisibilityChange, isVisible: " + r24.a);
        qi0.d r3 = qi0.d.a;
        n.a.a(r3, false, "onXplayVisibilityChange", "isVisible: " + r24.a, 4);
        this.a = false;
        this.b = r24.b;
        this.c = r24.c;
        boolean r1 = r24.a;
        if (r25 == null) goto L7;
        com.bytedance.android.live.broadcastgame.api.xplay.d r7 = (com.bytedance.android.live.broadcastgame.api.xplay.d) r25.getService(com.bytedance.android.live.broadcastgame.api.xplay.d.class);
        if (r7 == null) goto L7;
        ViewGroup r8 = r7.j();
    L8:
        if (r25 == null) goto L12;
        com.bytedance.android.live.broadcastgame.api.xplay.d r9 = (com.bytedance.android.live.broadcastgame.api.xplay.d) r25.getService(com.bytedance.android.live.broadcastgame.api.xplay.d.class);
        if (r9 == null) goto L12;
        ViewGroup r10 = r9.a();
    L13:
        this.d = r8;
        ViewGroup r11 = this.b;
        if (r11 != null) goto L16;
    L58:
        ALogger.e("XplayController", "onXplayVisibilityChange failed, cause: xPlayH5Container is null");
        n.a.a(r3, false, "onXplayVisibilityChangeFailed", "xplayContainer is null", 4);
        if (r1 == false) goto L65;
        l.a.a(qi0.a.j, LinkMonitorData.XplayShow, null, null, 1, null, "show_xplay_failed_cause_xplay_container_null", null, null, null, 470);
        return;
    L65:
        return;
    L16:
        if (this.c == null) goto L58;
        if (r8 != null) goto L23;
        ALogger.e("XplayController", "onXplayVisibilityChange failed, cause: xplayView is null");
        n.a.a(r3, false, "onXplayVisibilityChangeFailed", "xplayView is null, xplayInstance: " + r25, 4);
        if (r1 == false) goto L62;
        l.a.a(qi0.a.j, LinkMonitorData.XplayShow, null, null, 2, null, "show_xplay_failed_cause_xplay_view_null", null, null, null, 470);
        return;
    L62:
        return;
    L23:
        int r2 = 8;
        if (r1 == false) goto L26;
        int r4 = 0;
    L27:
        r11.setVisibility(r4);
        ViewGroup r5 = this.c;
        if (r5 == null) goto L33;
        if (r1 == false) goto L31;
        r2 = 0;
    L31:
        r5.setVisibility(r2);
    L33:
        if (r1 == false) goto L50;
        l.a.a(qi0.a.j, LinkMonitorData.XplayShow, null, null, 0, null, null, null, null, null, 510);
        this.a = true;
        if ((true ^ Intrinsics.areEqual(UtilityKotlinExtentionsKt.p(r8), this.b)) == false) goto L63;
        n.a.a(r3, false, "showXplayView", null, 12);
        ViewGroup r6 = UtilityKotlinExtentionsKt.p(r8);
        if (r6 == null) goto L39;
        r6.removeView(r8);
    L39:
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewGroup r12 = this.b;
        if (r12 == null) goto L42;
        r12.addView(r8);
    L42:
        if (r10 == null) goto L49;
        ViewGroup r13 = UtilityKotlinExtentionsKt.p(r10);
        if (r13 == null) goto L46;
        r13.removeView(r10);
    L46:
        ViewGroup r14 = this.c;
        if (r14 == null) goto L49;
        r14.addView(r10);
    L49:
        e(LinkApi.XplayInitCallbackStatus.STATUS_SUCCESS.getValue());
        return;
    L63:
        return;
    L50:
        n.a.a(r3, false, "removeXplayView", null, 12);
        ViewGroup r15 = this.b;
        if (r15 == null) goto L53;
        r15.removeAllViews();
    L53:
        ViewGroup r16 = this.c;
        if (r16 == null) goto L56;
        r16.removeAllViews();
    L56:
        e(LinkApi.XplayInitCallbackStatus.STATUS_FAIL.getValue());
        return;
    L26:
        r4 = 8;
    L12:
        r10 = null;
    L7:
        r8 = null;
        goto L8
    }

    public d(Context r2, ne0.c r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "mStore");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.g = r3;
        this.e = new b(this);
        this.f = new CompositeDisposable();
    }
}
