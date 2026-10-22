package com.bytedance.android.livesdk.interactivity.interactive.episode;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.f;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXHelper;
import com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXWidget;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import nm1.m;
import org.json.JSONObject;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/episode/EpisodeInteractiveAnnieXWidget;", "Lcom/bytedance/android/livesdk/interactivity/interactive/LiveInteractiveAnnieXWidget;", "<init>", "()V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodeInteractiveAnnieXWidget extends LiveInteractiveAnnieXWidget {
    public static final /* synthetic */ int n = 0;
    public final EpisodeInteractiveAnnieXWidget$matchRoomTabChangeObserver$1 g;
    public final EpisodeInteractiveAnnieXWidget$matchRoomLandscapeDialogObserver$1 h;
    public Disposable i;
    public Disposable j;
    public Disposable k;
    public final Function1<Integer, Unit> l;
    public com.bytedance.android.livesdk.interactivity.interactive.episode.d m;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ EpisodeInteractiveAnnieXWidget a;

        public b(EpisodeInteractiveAnnieXWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            if (h.d(((Widget) this.a).dataCenter, true) == false) goto L5;
            return;
        L5:
            if (r4.booleanValue() == false) goto L9;
            EpisodeInteractiveAnnieXWidget r5 = this.a;
            int r0 = EpisodeInteractiveAnnieXWidget.n;
            LiveInteractiveAnnieXHelper r6 = r5.b;
            if (r6 == null) goto L12;
            r6.p(true);
            return;
        L12:
            return;
        L9:
            EpisodeInteractiveAnnieXWidget.Aq(this.a);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ EpisodeInteractiveAnnieXWidget a;

        public c(EpisodeInteractiveAnnieXWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Long r11 = (Long) r10;
            m r0 = s.g();
            u r13 = r.u(((Widget) this.a).dataCenter, null, 2);
            if (r13 == null) goto L9;
            com.bytedance.live.datacontext.m r14 = r13.cameraId();
            if (r14 == null) goto L9;
            Long r15 = (Long) r14.getValue();
            if (r15 == null) goto L9;
            long r3 = r15.longValue();
        L10:
            u r16 = r.u(((Widget) this.a).dataCenter, null, 2);
            if (r16 == null) goto L17;
            Room r17 = r16.j0();
            if (r17 == null) goto L17;
            IEpisodeExtraInfo r18 = r17.getEpisodeComponentData();
            if (r18 == null) goto L17;
            Long r19 = Long.valueOf(r18.getDefaultCameraId());
        L18:
            u r5 = r.u(((Widget) this.a).dataCenter, null, 2);
            if (r5 == null) goto L21;
            Room r6 = r5.j0();
        L22:
            u r1 = r.u(((Widget) this.a).dataCenter, null, 2);
            if (r1 != null) goto L25;
        L27:
            boolean r8 = false;
        L28:
            boolean r110 = r0.q(r3, r19, r6, r8);
            if (r110 == false) goto L35;
            EpisodeInteractiveAnnieXWidget r2 = this.a;
            int r4 = EpisodeInteractiveAnnieXWidget.n;
            LiveInteractiveAnnieXHelper r7 = r2.b;
            if (r7 == null) goto L35;
            if (r7.l != 1) goto L35;
            o82.h.b("setHybridComponentGone, interactive component should not show in current camera.");
            this.a.b.p(false);
            return;
        L35:
            if (r110 == true) goto L39;
            o82.h.b("setHybridComponentVisible, cuz supportInSubCamera = false and  current in main Camera");
            EpisodeInteractiveAnnieXWidget.Aq(this.a);
            return;
        L39:
            return;
        L25:
            if (r1.e0() != true) goto L27;
            r8 = true;
            goto L28
        L21:
            r6 = null;
        L17:
            r19 = null;
        L9:
            r3 = 0;
            goto L10
        }
    }

    public static final class d implements LiveInteractiveAnnieXWidget.a {
        public final /* synthetic */ EpisodeInteractiveAnnieXWidget a;

        @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXWidget.a
        public final void onDegrade() {
            EpisodeInteractiveAnnieXWidget r0 = this.a;
            int r1 = EpisodeInteractiveAnnieXWidget.n;
            LiveInteractiveAnnieXHelper r2 = r0.b;
            if (r2 == null) goto L6;
            r2.p(false);
            o82.h.b("liveRefinedDegrade: set gone cuzz of auth interactiveComponent hide");
        L6:
            if (this.a.isScreenPortrait() == false) goto L8;
            y3.f(((Widget) this.a).dataCenter).f(ToolbarButton.VS_INTERACTIVE.extended(), this.a.m);
            return;
        L8:
            y3.i(((Widget) this.a).dataCenter).f(ToolbarButton.VS_INTERACTIVE.extended(), this.a.m);
        }

        public d(EpisodeInteractiveAnnieXWidget r1) {
            this.a = r1;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ EpisodeInteractiveAnnieXWidget a;

        public e(EpisodeInteractiveAnnieXWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L5
            r0.put("type", "digg");     // Catch: Exception -> L5
            r0.put("data", BuildConfig.FLAVOR);     // Catch: Exception -> L5
            EpisodeInteractiveAnnieXWidget r1 = this.a;     // Catch: Exception -> L5
            int r2 = EpisodeInteractiveAnnieXWidget.n;     // Catch: Exception -> L5
            r1.b.o("digg", r0);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            ALogger.e("EpisodeInteractiveAnnieXWidget", " error: " + e.getMessage());
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXWidget
    public final LiveInteractiveAnnieXHelper wq() {
        return new EpisodeInteractiveAnnieXHelper(isScreenPortrait(), ((Widget) this).dataCenter, ((Widget) this).context, this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXWidget
    public final int xq() {
        return ((Number) VSSettingKeys.VS_LIVE_INTERACTIVE_CONTAINER_SHOW_TYPE.getValue()).intValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.livesdk.interactivity.interactive.episode.EpisodeInteractiveAnnieXWidget$matchRoomTabChangeObserver$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.interactivity.interactive.episode.EpisodeInteractiveAnnieXWidget$matchRoomLandscapeDialogObserver$1] */
    public EpisodeInteractiveAnnieXWidget() {
        this.g = new EpisodeInteractiveAnnieXWidget$matchRoomTabChangeObserver$1(this);
        this.h = new EpisodeInteractiveAnnieXWidget$matchRoomLandscapeDialogObserver$1(this);
        this.l = new EpisodeInteractiveAnnieXWidget$roomCleanModeObserver$1(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXWidget
    public final void onUnload() {
        super.onUnload();
        f.d().a.removeObserver(this.h);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this.g);
    L5:
        Disposable r1 = this.i;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        Disposable r2 = this.j;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        Disposable r3 = this.k;
        if (r3 == null) goto L15;
        r3.dispose();
        return;
    }

    public static final void Aq(EpisodeInteractiveAnnieXWidget r3) {
        DataCenter r0 = ((Widget) r3).dataCenter;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((Boolean) r0.get("match_is_public_interact_tab", Boolean.TRUE)).booleanValue() == false) goto L17;
        LiveInteractiveAnnieXHelper r1 = r3.b;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.c() != true) goto L19;
        LiveInteractiveAnnieXHelper r4 = r3.b;
        if (r4.m == 1) goto L13;
        return;
    L13:
        if (r4.l != 0) goto L21;
        r4.s(true);
        return;
    L21:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXWidget
    public final void onLoad(Object[] r6) {
        super.onLoad(r6);
        this.m = new com.bytedance.android.livesdk.interactivity.interactive.episode.d();
        if (isScreenPortrait() == false) goto L5;
        y3.f(((Widget) this).dataCenter).k(ToolbarButton.VS_INTERACTIVE, this.m);
    L6:
        Disposable r2 = null;
        if (xq() != 1) goto L17;
        u r7 = r.u(((Widget) this).dataCenter, null, 2);
        if (r7 == null) goto L15;
        com.bytedance.live.datacontext.m r8 = r7.U();
        if (r8 == null) goto L15;
        Observable r9 = r8.a();
        if (r9 == null) goto L15;
        Disposable r10 = RxUtilKt.n(r9, this.l);
    L16:
        this.i = r10;
    L15:
        r10 = null;
    L17:
        s.i().a();
        if (MultiTabManagerImpl.e.i(((Widget) this).dataCenter) == true) goto L20;
    L24:
        u r11 = r.u(((Widget) this).dataCenter, null, 2);
        if (r11 == null) goto L31;
        com.bytedance.live.datacontext.m r13 = r11.x1();
        if (r13 == null) goto L31;
        Observable r14 = r13.a();
        if (r14 == null) goto L31;
        Disposable r15 = r14.subscribe(new b(this));
    L32:
        this.j = r15;
        if (h.d(((Widget) this).dataCenter, true) == true) goto L35;
        f.d().a.observe(this, this.h);
    L35:
        u r16 = r.u(((Widget) this).dataCenter, null, 2);
        if (r16 == null) goto L44;
        com.bytedance.live.datacontext.m r17 = r16.cameraId();
        if (r17 == null) goto L44;
        Observable r18 = r17.a();
        if (r18 == null) goto L44;
        ObservableSubscribeProxy r19 = (ObservableSubscribeProxy) r18.as(autoDispose());
        if (r19 == null) goto L44;
        r19.subscribe(new c(this));
    L44:
        this.f = new d(this);
        DiggContext.a r20 = DiggContext.Companion;
        DataCenter r0 = ((Widget) this).dataCenter;
        r20.getClass();
        DiggContext r21 = DiggContext.a.a(r0);
        if (r21 == null) goto L51;
        com.bytedance.live.datacontext.m<Long> r23 = r21.getDiggTime();
        if (r23 == null) goto L51;
        Observable r24 = r23.a();
        if (r24 == null) goto L51;
        r2 = r24.subscribe(new e(this));
    L51:
        this.k = r2;
        return;
    L31:
        r15 = null;
        goto L32
    L20:
        if (h.d(((Widget) this).dataCenter, true) == false) goto L24;
        DataCenter r25 = ((Widget) this).dataCenter;
        if (r25 == null) goto L24;
        r25.observe("match_is_channel_chat_or_public_interact_tab", this.g);
        goto L24
    L5:
        y3.i(((Widget) this).dataCenter).k(ToolbarButton.VS_INTERACTIVE, this.m);
        goto L6
    }
}
