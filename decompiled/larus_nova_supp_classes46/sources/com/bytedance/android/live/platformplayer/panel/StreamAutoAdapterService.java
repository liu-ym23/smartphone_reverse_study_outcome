package com.bytedance.android.live.platformplayer.panel;

import am2.x;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.g6;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.nk;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.GameOpenPanelContentAdapterConfig;
import com.bytedance.android.livesdkapi.model.StreamAutoAdapterConfig;
import com.bytedance.android.livesdkapi.player.LiveZygoteBaseEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class StreamAutoAdapterService implements com.bytedance.android.live.platformplayer.service.b {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static d d;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static c g;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static DataCenter j;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static long m;
    public static volatile boolean n;
    public static final StreamAutoAdapterService o = null;

    public StreamAutoAdapterService() {
    }

    public static StreamAutoAdapterConfig b() {
        return (StreamAutoAdapterConfig) k.getValue();
    }

    static {
        o = new StreamAutoAdapterService();
        a = LazyKt.lazy(StreamAutoAdapterService$panelObserver$2.INSTANCE);
        b = LazyKt.lazy(StreamAutoAdapterService$msgHandler$2.INSTANCE);
        c = LazyKt.lazy(StreamAutoAdapterService$playerViewHandler$2.INSTANCE);
        e = LazyKt.lazy(StreamAutoAdapterService$gamePlayerViewHandler$2.INSTANCE);
        f = LazyKt.lazy(StreamAutoAdapterService$statusController$2.INSTANCE);
        h = LazyKt.lazy(StreamAutoAdapterService$normalPanelConsumer$2.INSTANCE);
        i = LazyKt.lazy(StreamAutoAdapterService$gamePanelConsumer$2.INSTANCE);
        k = LazyKt.lazy(StreamAutoAdapterService$config$2.INSTANCE);
        l = LazyKt.lazy(StreamAutoAdapterService$gameConfig$2.INSTANCE);
    }

    public static void g(ds0.b r4) {
        Intrinsics.checkNotNullParameter(r4, "panelEvent");
        if (Intrinsics.areEqual(r4.b, "close") == false) goto L5;
        return;
    L5:
        j0 r0 = j0.l();
        HashMap r1 = new HashMap();
        r1.put("panel_scene", r4.getType().getIdentifier());
        r1.put("strategy_type", "1");
        Unit r5 = Unit.INSTANCE;
        r0.sendLog("livesdk_live_screen_adaptive_strategy", r1, new Object[]{IRoom.class, x.class});
    }

    public final void c(ds0.b r6) {
        Intrinsics.checkNotNullParameter(r6, "panelEvent");
        if (n == true) goto L6;
        g(r6);
        return;
    L6:
        Lazy r0 = f;
        s r1 = (s) r0.getValue();
        if (((Boolean) r1.i.getValue()).booleanValue() == false) goto L10;
        r1.a(r1.h);
    L10:
        if (r1.g.length() <= 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L16;
        e("in " + ((s) r0.getValue()).g + " disable stream auto adapter");
        return;
    L16:
        DataCenter r3 = j;
        if (r3 == null) goto L21;
        Boolean r4 = (Boolean) r3.get("data_is_portrait", Boolean.TRUE);
        if (r4 == null) goto L21;
        boolean r5 = r4.booleanValue();
    L22:
        c r7 = g;
        if (r7 == null) goto L41;
        Lazy r8 = b;
        boolean r9 = !r5;
        if (r7.b(r6, ((f) r8.getValue()).b, r9) != true) goto L42;
        String r10 = null;
        if (Intrinsics.areEqual(r6.b, "open") == false) goto L34;
        d r11 = d;
        if (r11 == null) goto L43;
        nk r12 = ((f) r8.getValue()).b;
        DataCenter r13 = j;
        if (r13 == null) goto L33;
        r10 = a0.p(r13);
    L33:
        r11.F(r12, r6, r10, Boolean.valueOf(r9));
        return;
    L43:
        return;
    L34:
        d r14 = d;
        if (r14 == null) goto L45;
        DataCenter r15 = j;
        if (r15 == null) goto L39;
        r10 = a0.p(r15);
    L39:
        r14.G(r6, r10, Boolean.valueOf(r9));
        return;
    L45:
        return;
    L42:
        return;
    L41:
        return;
    L21:
        r5 = true;
        goto L22
    L12:
        r2 = false;
        goto L13
    }

    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        ALogger.i("stream_auto_adapter", r2);
    }

    @Override // com.bytedance.android.live.platformplayer.service.b
    public final void w1(ds0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "panelEvent");
        if (r2.h == false) goto L5;
        c(r2);
        return;
    L5:
        xs2.b.a().post(r2);
    }

    public static void d(LivePanelType r4, float r5) {
        Intrinsics.checkNotNullParameter(r4, "panelType");
        if (n == true) goto L5;
        return;
    L5:
        DataCenter r0 = j;
        if (r0 == null) goto L10;
        Boolean r1 = (Boolean) r0.get("data_is_portrait", Boolean.TRUE);
        if (r1 == null) goto L10;
        boolean r2 = r1.booleanValue();
    L11:
        c r3 = g;
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.a(r4, !r2) != true) goto L20;
        d r6 = d;
        if (r6 == null) goto L21;
        r6.E(r5);
        return;
    L21:
        return;
    L20:
        return;
    L10:
        r2 = true;
        goto L11
    }

    public final void i(DataCenter r12, LivePlayerView r13) {
        e("onRoomEnter");
        if (b().getEnable() == true) goto L5;
        return;
    L5:
        if (r12 == null) goto L108;
        if (r13 == null) goto L109;
        j = r12;
        NextLiveData r1 = null;
        if (((LiveMode) r12.get("data_live_mode", null)) != LiveMode.AUDIO) goto L13;
        e("audio room disable stream auto adapter function");
        return;
    L13:
        if (PadConfigUtils.a() == false) goto L16;
        e("pad disable stream auto adapter function");
        return;
    L16:
        boolean r2 = false;
        if (b().getInterceptFold() == true) goto L19;
    L21:
        boolean r0 = false;
    L22:
        if (r0 == false) goto L25;
        e("normal intercept fold screen");
        return;
    L25:
        IRoom r3 = (IRoom) r12.get("data_room", null);
        if (r3 != null) goto L29;
        return;
    L29:
        if (r3.isGameRoom() == 1) goto L31;
    L35:
        boolean r4 = false;
    L36:
        if (r4 == false) goto L38;
    L40:
        boolean r5 = false;
    L42:
        if (r3.getRoomAuthStatus().getStreamAdaptation() != 2) goto L46;
        if (r5 == false) goto L46;
        e("mode normal, room auth disable stream auto adapter function");
        return;
    L46:
        if (r4 == true) goto L48;
        if (r5 == true) goto L48;
    L49:
        n = r2;
        if (n == true) goto L53;
        e("mode game or normal disable, return");
        return;
    L53:
        m = r3.getRoomId();
        e("onRoomEnter dataCenter@" + r12.hashCode() + ", playerView@" + r13.hashCode());
        o r6 = (o) a.getValue();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        r12.observe("cmd_gift_dialog_switch", r6.c);
        f r7 = (f) b.getValue();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        e r8 = new e(r7);
        r7.a.put(Integer.valueOf(r12.hashCode()), r8);
        vlc.d r9 = (vlc.d) r12.get("data_message_manager", null);
        if (r9 == null) goto L57;
        r9.addMessageListener("WebcastRoomStreamAdaptationMessage", r8);
    L57:
        if ((r9 instanceof xlc.a) == true) goto L59;
        r9 = null;
    L59:
        xlc.a r10 = (xlc.a) r9;
        if (r10 == null) goto L62;
        tlc.d r11 = r10.l("WebcastRoomStreamAdaptationMessage");
    L63:
        if (r11 != null) goto L85;
        IRoom r14 = (IRoom) r12.get("data_room", null);
        com.bytedance.android.livesdk.message.cache.a r15 = com.bytedance.android.livesdk.message.cache.a.e;
        if (r14 == null) goto L68;
        String r16 = String.valueOf(r14.getRoomId());
        if (r16 == null) goto L68;
    L69:
        Intrinsics.checkNotNullParameter(r16, "key");
        com.bytedance.android.livesdk.message.cache.a.a r17 = (com.bytedance.android.livesdk.message.cache.a.a) com.bytedance.android.livesdk.message.cache.a.a.get(r16);
        if (r17 != null) goto L72;
        Object r18 = null;
    L76:
        if (r18 == null) goto L85;
        if ((r18 instanceof tlc.d) == true) goto L80;
        r18 = null;
    L80:
        r11 = (tlc.d) r18;
        goto L85
    L72:
        monitor-enter(r15);
        r15.b(r17);     // Catch: Throwable -> L81
        r15.a(r17);     // Catch: Throwable -> L81
        monitor-exit(r15);
        r18 = r17.b;
    L81:
        th = move-exception;
        throw th;
    L68:
        r16 = "";
    L85:
        if ((r11 instanceof nk) == true) goto L87;
        r11 = null;
    L87:
        nk r19 = (nk) r11;
        if (r19 == null) goto L90;
        r7.c.e("load msg from message manager wrds cache");
        r7.a(r19);
    L90:
        if (r4 == false) goto L92;
        d = (a) e.getValue();
        g = (GamePanelEventConsumer) i.getValue();
    L94:
        d r20 = d;
        if (r20 == null) goto L97;
        r20.H(r13);
    L97:
        s r21 = (s) f.getValue();
        r21.getClass();
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        Intrinsics.checkNotNullParameter(r13, "playerView");
        r21.a = new WeakReference(r12);
        r21.b = new WeakReference(r13);
        r12.observe("data_link_state", r21.j, true);
        LifecycleOwner r22 = r12.lifecycleOwner;
        if (r22 == null) goto L104;
        LiveZygoteBaseEventHub r110 = (LiveZygoteBaseEventHub) r12.get("zygote_event_hub", null);
        if (r110 == null) goto L102;
        r1 = r110.getSwitchStreamDataEvent();
    L102:
        if (r1 == null) goto L104;
        r1.observe(r22, new p(r21));
    L104:
        r13.getClient().getEventHub().getSeiUpdate().observe(r13.getClient().getLifecycleOwner(), r21.k);
        return;
    L92:
        if (r5 == false) goto L94;
        d = (t) c.getValue();
        g = (NormalPanelEventConsumer) h.getValue();
        goto L94
    L62:
        r11 = null;
    L48:
        r2 = true;
        goto L49
    L38:
        if (b().getEnable() == false) goto L40;
        r5 = true;
        goto L42
    L31:
        if (((GameOpenPanelContentAdapterConfig) l.getValue()).getSwitch() == false) goto L35;
        if (FoldScreenUtils.f() == true) goto L35;
        r4 = true;
        goto L36
    L19:
        if (FoldScreenUtils.f() == false) goto L21;
        r0 = true;
        goto L22
    L109:
        return;
    }

    public final void j(long r4, DataCenter r6) {
        if (r4 == m) goto L6;
        return;
    L6:
        if (((Boolean) g6.a.getValue()).booleanValue() == false) goto L9;
        j = null;
    L9:
        if (n == true) goto L11;
        return;
    L11:
        StringBuilder r5 = new StringBuilder("onRoomExit dataCenter@");
        if (r6 == null) goto L14;
        int r1 = r6.hashCode();
    L15:
        r5.append(r1);
        r5.append('}');
        e(r5.toString());
        o r7 = (o) a.getValue();
        if (r6 == null) goto L18;
        r6.removeObserver("cmd_gift_dialog_switch", r7.c);
    L19:
        ((t) c.getValue()).D();
        d r8 = d;
        if (r8 == null) goto L22;
        r8.D();
    L22:
        s r9 = (s) f.getValue();
        DataCenter r2 = r9.a.get();
        if (r2 == null) goto L25;
        r2.removeObserver(r9.j);
    L25:
        r9.g = "";
        r9.h = null;
        f r10 = (f) b.getValue();
        if (r6 != null) goto L28;
        r10.getClass();
    L32:
        c r11 = g;
        if (r11 == null) goto L35;
        r11.clear();
    L35:
        n = false;
        return;
    L28:
        vlc.l r3 = r10.a.remove(Integer.valueOf(r6.hashCode()));
        vlc.d r12 = (vlc.d) r6.get("data_message_manager", null);
        if (r12 == null) goto L31;
        r12.removeMessageListener(r3);
    L31:
        r10.b = null;
        goto L32
    L18:
        r7.getClass();
        goto L19
    L14:
        r1 = 0;
        goto L15
    }
}
