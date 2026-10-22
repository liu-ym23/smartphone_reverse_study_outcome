package com.bytedance.android.live.broadcastgame.widget;

import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.broadcastgame.InteractGameService;
import com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget;
import com.bytedance.android.live.broadcastgame.api.e;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.broadcastgame.api.xplay.n;
import com.bytedance.android.live.broadcastgame.f0;
import com.bytedance.android.live.broadcastgame.opengame.h;
import com.bytedance.android.live.broadcastgame.opengame.k;
import com.bytedance.android.live.broadcastgame.opengame.test.OpenGameTestHelper;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.GameHonorEffectWidget;
import com.bytedance.android.live.broadcastgame.xplay.perf.XplayPerfPanelView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import i10.f;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/widget/AnchorGameWidget;", "Lcom/bytedance/android/live/broadcastgame/api/IAnchorGameWidget;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorGameWidget extends IAnchorGameWidget {
    public e a;
    public f0 b;
    public h c;
    public k d;
    public InteractGameSEIWidget e;
    public com.bytedance.android.live.broadcastgame.api.openplatform.b f;
    public j20.c g;
    public final CompositeDisposable h;
    public com.bytedance.android.live.pushstream.d i;
    public final Room j;
    public final FragmentManager k;

    public final int getLayoutId() {
        return 2131565136;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void Aq() {
        Intrinsics.checkNotNullParameter("key_game_in_cast", "key");
        InteractGameSEIWidget r6 = this.e;
        if (r6 == null) goto L8;
        Intrinsics.checkNotNullParameter("key_game_in_cast", "key");
        com.bytedance.android.live.pushstream.d r0 = r6.a;
        if (r0 == null) goto L9;
        r0.c1("key_game_in_cast", null, 1, true, true);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void Cq() {
        com.bytedance.android.live.broadcastgame.api.openplatform.b r0 = this.f;
        if (r0 == null) goto L6;
        r0.d(null, null);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void Fq() {
        com.bytedance.android.live.broadcastgame.api.openplatform.b r0 = this.f;
        if (r0 == null) goto L6;
        r0.stopGameCastToAudience();
        return;
    }

    public final com.bytedance.android.live.pushstream.d Iq() {
        if (this.i != null) goto L15;
        if (z.i(((Widget) this).dataCenter) == false) goto L7;
        com.bytedance.android.live.pushstream.d r0 = jc1.k.n(IPushStreamService.class).getRecordLiveStream(((Widget) this).context);
    L13:
        this.i = r0;
        goto L15
    L7:
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r1 == null) goto L12;
        j r2 = r1.getLiveStream();
        if (r2 == null) goto L12;
        r0 = (com.bytedance.android.live.pushstream.d) r2.getValue();
    L12:
        r0 = null;
    L15:
        return this.i;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        WidgetManager r0 = ((Widget) this).subWidgetManager;
        if (r0 == null) goto L10;
        List r1 = r0.widgets;
        if (r1 == null) goto L10;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r0.unload((Widget) r2.next());
    L10:
        com.bytedance.android.live.broadcastgame.api.openplatform.b r3 = this.f;
        if (r3 == null) goto L13;
        r3.onDestroy();
    L13:
        h r4 = this.c;
        if (r4 == null) goto L16;
        r4.release();
    L16:
        k r5 = this.d;
        if (r5 == null) goto L19;
        r5.release();
    L19:
        j20.c r6 = this.g;
        if (r6 == null) goto L26;
        View r7 = r6.getView();
        if (r7 == null) goto L26;
        ViewGroup r8 = ((Widget) this).containerView;
        if (r8 == null) goto L26;
        r8.removeView(r7);
    L26:
        this.g = null;
        this.h.dispose();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final String wq() {
        com.bytedance.android.live.broadcastgame.api.openplatform.b r0 = this.f;
        if (r0 == null) goto L6;
        String r1 = r0.getGameCategory();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void xq() {
        com.bytedance.android.live.broadcastgame.api.openplatform.b r0 = this.f;
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    public final void Gq() {
        enableSubWidgetManager();
        if (Iq() != null) goto L6;
        return;
    L6:
        if (isScreenPortrait() == false) goto L13;
        ((Widget) this).subWidgetManager.load(new InteractGameStartupWidget(this.f));
        if (tb1.c.a == false) goto L14;
        InteractGameSEIWidget r0 = new InteractGameSEIWidget(Iq());
        this.e = r0;
        ((Widget) this).subWidgetManager.load(r0);
        com.bytedance.android.live.pushstream.d r1 = Iq();
        if (r1 == null) goto L15;
        WidgetManager r2 = ((Widget) this).subWidgetManager;
        long r3 = this.j.id;
        r2.load(2131371495, new LiveGameControlWidget(r1, this.k));
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onPause() {
        super.onPause();
        n.b.b(true);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onResume() {
        super.onResume();
        n.b.b(false);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void Eq(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        com.bytedance.android.live.broadcastgame.api.openplatform.b r0 = this.f;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r9) {
        com.bytedance.android.live.pushstream.d r1 = Iq();
        boolean r11 = false;
        XplayPerfPanelView r7 = null;
        if (r1 == null) goto L29;
        f0 r0 = this.b;
        if (r0 == null) goto L7;
        com.bytedance.android.live.broadcastgame.opengame.a r2 = r0.c(r1, ((Widget) this).context, ((Widget) this).dataCenter, this.j.id, ((Widget) this).containerView);
    L8:
        this.f = r2;
        String r3 = jc1.k.n(IHostContext.class).getChannel();
        ALogger.d("AnchorGameWidget", "当前channel = [" + r3 + ']');
        if (StringsKt.contains$default(r3, "lark_inhouse", false, 2, null) == true) goto L11;
        LocalTestManager.a(new Class[]{wy.a.class});
    L19:
        if (StringsKt.contains$default(r3, "live_open_platform", false, 2, null) == false) goto L21;
    L22:
        f0 r4 = this.b;
        if (r4 == null) goto L25;
        com.bytedance.android.live.broadcastgame.opengame.test.c r5 = r4.e();
    L26:
        this.d = r5;
        if (r5 == null) goto L29;
        r5.a(((Widget) this).containerView, ((Widget) this).context);
        goto L29
    L25:
        r5 = null;
        goto L26
    L21:
        if (v.a() == false) goto L29;
    L11:
        f0 r6 = this.b;
        if (r6 == null) goto L14;
        OpenGameTestHelper r8 = r6.g();
    L15:
        this.c = r8;
        if (r8 == null) goto L19;
        r8.a(((Widget) this).containerView, ((Widget) this).context);
        goto L19
    L14:
        r8 = null;
        goto L15
    L7:
        r2 = null;
    L29:
        enableSubWidgetManager();
        ((Widget) this).subWidgetManager.load(2131381526, new GameHonorEffectWidget());
        if (z.g(((Widget) this).dataCenter) == false) goto L33;
        Gq();
    L39:
        if (v.a() == false) goto L62;
        f0 r12 = this.b;
        if (r12 == null) goto L53;
        XplayPerfPanelView r13 = r12.d(((Widget) this).containerView);
        if (r13 == null) goto L53;
        XplayExternalContext r14 = XplayExternalContext.Companion.getContext();
        if (r14 == null) goto L52;
        m<Boolean> r15 = r14.getOpenPerfDetect();
        if (r15 == null) goto L52;
        Boolean r16 = (Boolean) r15.getValue();
        if (r16 == null) goto L52;
        r11 = r16.booleanValue();
    L52:
        r13.setPerformancePanelVisible(r11);
        Unit r17 = Unit.INSTANCE;
        r7 = r13;
    L53:
        this.g = r7;
        XplayExternalContext r18 = XplayExternalContext.Companion.getContext();
        if (r18 == null) goto L62;
        m<Boolean> r19 = r18.getOpenPerfDetect();
        if (r19 == null) goto L62;
        Observable r21 = r19.a();
        if (r21 == null) goto L62;
        Disposable r22 = r21.subscribe(new a(this));
        if (r22 == null) goto L62;
        RxUtilKt.c(r22, this.h);
    L62:
        n.b.k(((Widget) this).context);
        return;
    L33:
        if (z.k(((Widget) this).dataCenter) == false) goto L36;
        Gq();
        goto L39
    L36:
        if (z.i(((Widget) this).dataCenter) == false) goto L39;
        enableSubWidgetManager();
        ((Widget) this).subWidgetManager.load(new InteractGameStartupWidget(this.f));
        InteractGameSEIWidget r23 = new InteractGameSEIWidget(Iq());
        this.e = r23;
        ((Widget) this).subWidgetManager.load(r23);
        goto L39
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void zq(boolean r2) {
        com.bytedance.android.live.broadcastgame.api.openplatform.b r0 = this.f;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void yq(boolean r2, Surface r3, int r4) {
        com.bytedance.android.live.broadcastgame.api.openplatform.b r0 = this.f;
        if (r0 == null) goto L6;
        r0.notifyStartLinkCastResult(r2, r3, r4);
        return;
    }

    public AnchorGameWidget(com.bytedance.android.live.pushstream.d r2, Room r3, Fragment r4, FragmentManager r5) {
        Intrinsics.checkNotNullParameter(r3, NewBroadcastMonitor.PAGE.ROOM);
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "fragmentManager");
        this.i = r2;
        this.j = r3;
        this.k = r5;
        this.h = new CompositeDisposable();
        InteractGameService.Companion.getClass();
        f r6 = (f) InteractGameService.access$getDiComponent$cp();
        r6.getClass();
        f r7 = r6.a;
        this.a = (e) r7.b.get();
        this.b = (f0) r7.d.get();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.IAnchorGameWidget
    public final void Bq(String r7, String r8, int r9, boolean r11) {
        Intrinsics.checkNotNullParameter(r7, "key");
        InteractGameSEIWidget r1 = this.e;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r7, "key");
        com.bytedance.android.live.pushstream.d r0 = r1.a;
        if (r0 == null) goto L9;
        r0.c1(r7, r8, r9, r11, true);
        return;
    L9:
        return;
    }
}
