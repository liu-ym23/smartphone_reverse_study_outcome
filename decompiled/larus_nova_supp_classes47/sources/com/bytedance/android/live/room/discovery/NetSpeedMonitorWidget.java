package com.bytedance.android.live.room.discovery;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.iq0;
import com.bytedance.android.livesdk.config.vh;
import com.bytedance.android.livesdk.config.wh;
import com.bytedance.android.livesdk.config.y71;
import com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zg1.q3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0004\u000b\f\r\u000eB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/room/discovery/NetSpeedMonitorWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lo70/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "a", "b", "c", "d", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NetSpeedMonitorWidget extends LiveRecyclableWidget implements o70.a, Observer<KVData> {
    public static final TokenCert m = null;
    public NetSpeedImageView a;
    public NetSpeedTextView b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final CompositeDisposable f;
    public boolean g;
    public final LiveNetworkBroadcastReceiver h;
    public final f i;
    public boolean j;
    public boolean k;
    public final e l;

    public static final class a {
        public long a;
        public long b;

        /* JADX INFO: renamed from: com.bytedance.android.live.room.discovery.NetSpeedMonitorWidget$a$a, reason: collision with other inner class name */
        public static final class C0206a {
        }

        static {
        }

        public a() {
        }
    }

    public static final class b {
    }

    public final class c {
        public String a;
        public final /* synthetic */ NetSpeedMonitorWidget b;

        public final String a() {
            if (jc1.k.n(IInteractService.class).getInteractAudienceService().P() == false) goto L5;
            return DataType.TRUE;
        L5:
            DataCenter r0 = ((Widget) this.b).dataCenter;
            int r2 = 0;
            if (r0 == null) goto L10;
            Integer r1 = (Integer) r0.get("data_link_state", 0);
            if (r1 == null) goto L10;
            r2 = r1.intValue();
        L10:
            if (r2 != 0) goto L12;
            return DataType.FALSE;
        L12:
            if (r2 == 2) goto L16;
            return DataType.TRUE;
        L16:
            return DataType.FALSE;
        }

        public c(NetSpeedMonitorWidget r1) {
            this.b = r1;
        }
    }

    public static final class d {
        public int a;

        public static final class a {
        }

        static {
        }

        public final String toString() {
            int r0 = this.a;
            if (r0 != 1) goto L5;
            return "good";
        L5:
            if (r0 == 2) goto L7;
            return "stuck";
        L7:
            return "bad";
        }

        public d() {
            this.a = 1;
        }
    }

    public static final class e implements r81.a {
        public final /* synthetic */ NetSpeedMonitorWidget a;

        @Override // r81.a
        public final void onLowMemory() {
            RoomContext r0 = RoomContext.a.c(RoomContext.Companion, ((Widget) this.a).dataCenter, 0, 2);
            if (r0 == null) goto L10;
            com.bytedance.live.datacontext.i r1 = r0.isLiveEnd();
            if (r1 != null) goto L7;
            return;
        L7:
            if (((Boolean) r1.getValue()).booleanValue() == true) goto L12;
            ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).handleLowMemory();
            return;
        L12:
            return;
        }

        public e(NetSpeedMonitorWidget r1) {
            this.a = r1;
        }
    }

    public static final class f implements LiveNetworkBroadcastReceiver.a {
        public final /* synthetic */ NetSpeedMonitorWidget a;

        public f(NetSpeedMonitorWidget r1) {
            this.a = r1;
        }

        public final void a(NetworkUtils.NetworkType r3) {
            NetSpeedMonitorWidget r0 = this.a;
            if (r3 != NetworkUtils.NetworkType.NONE) goto L5;
            boolean r4 = true;
        L6:
            r0.g = r4;
            return;
        L5:
            r4 = false;
            goto L6
        }
    }

    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(new Class[]{p0.class, zg1.m0.class});
    }

    public final int getLayoutId() {
        return 2131568015;
    }

    public final String getSpm() {
        return "a100.a100.a233";
    }

    static {
        m = TokenCert.Companion.with("bpea-bpea-live_netspeedmonitor_get_network_type");
    }

    public final void onUnload() {
        LiveNetworkBroadcastReceiver r0 = this.h;
        r0.c(this.i);
        r0.d();
        r81.b r1 = r81.b.b;
        jc1.a.b().unregisterComponentCallbacks(r1);
        r81.b.a = null;
    }

    public NetSpeedMonitorWidget() {
        this.c = LazyKt.lazy(NetSpeedMonitorWidget$status$2.INSTANCE);
        this.d = LazyKt.lazy(NetSpeedMonitorWidget$reminder$2.INSTANCE);
        this.e = LazyKt.lazy(new NetSpeedMonitorWidget$logger$2(this));
        this.f = new CompositeDisposable();
        this.h = new LiveNetworkBroadcastReceiver();
        this.i = new f(this);
        this.l = new e(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f.clear();
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 == null) goto L42;
        String r0 = r7.getKey();
        int r1 = r0.hashCode();
        int r2 = 0;
        if (r1 == (-738124344)) goto L23;
        if (r1 == 1060055221) goto L10;
        return;
    L10:
        if (r0.equals("data_keyboard_status") == false) goto L43;
        Boolean r3 = Boolean.TRUE;
        Boolean r8 = (Boolean) r7.getData(r3);
        if (r8 == null) goto L15;
        r3 = r8;
    L15:
        boolean r9 = r3.booleanValue();
        this.j = r9;
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L44;
        if (r9 == false) goto L19;
    L20:
        r2 = 8;
    L21:
        r4.setVisibility(r2);
        return;
    L19:
        if (this.k == false) goto L21;
    L44:
        return;
    L43:
        return;
    L23:
        if (r0.equals("cmd_official_inspector") == false) goto L46;
        com.bytedance.android.live.room.discovery.inspector.a r10 = (com.bytedance.android.live.room.discovery.inspector.a) r7.getData();
        if (r10 == null) goto L51;
        int r12 = r10.getType();
        if (r12 != 0) goto L30;
        this.k = true;
        View r13 = ((Widget) this).contentView;
        if (r13 == null) goto L49;
        r13.setVisibility(8);
        return;
    L49:
        return;
    L30:
        if (r12 != 2) goto L52;
        this.k = false;
        View r14 = ((Widget) this).contentView;
        if (r14 != null) goto L35;
        return;
    L35:
        if (this.j == false) goto L37;
        r2 = 8;
    L37:
        r14.setVisibility(r2);
        return;
    L52:
        return;
    L51:
        return;
    L46:
        return;
    }

    public void onEvent(o70.b r14) {
        Intrinsics.checkNotNullParameter(r14, "event");
        if ((r14 instanceof p0) == false) goto L46;
        int r15 = ((p0) r14).a;
        if (this.g == false) goto L7;
        r15 = 3;
    L7:
        if (r15 == 0) goto L57;
        ((d) this.c.getValue()).a = r15;
        ((c) this.e.getValue()).a = ((d) this.c.getValue()).toString();
        AppCompatTextView r0 = this.b;
        if (r0 == null) goto L18;
        if (r15 == 1) goto L17;
        if (r15 == 2) goto L16;
        if (r15 != 3) goto L18;
        r0.setText(2131911620);
        goto L18
    L16:
        r0.setText(2131911618);
        goto L18
    L17:
        r0.setText(2131911619);
    L18:
        NetSpeedImageView r1 = this.a;
        if (r1 == null) goto L27;
        if (r15 == 1) goto L26;
        if (r15 == 2) goto L25;
        if (r15 != 3) goto L27;
        r1.setImageResource(2131251523);
        goto L27
    L25:
        r1.setImageResource(2131251521);
        goto L27
    L26:
        r1.setImageResource(2131251522);
    L27:
        a r2 = (a) this.d.getValue();
        Function0<Unit> r4 = new NetSpeedMonitorWidget$onNetworkStatus$1(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "closure");
        if (r15 == 3) goto L30;
        r2.b = 0;
    L41:
        if (UIUtils.isViewVisible(((Widget) this).containerView) == false) goto L53;
        c r16 = (c) this.e.getValue();
        String r3 = r16.a;
        if (r3 == null) goto L54;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_netspeed_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("net_speed", r3), TuplesKt.to("is_connection", r16.a())}), new Object[]{Room.class});
        return;
    L54:
        return;
    L53:
        return;
    L30:
        long r7 = System.currentTimeMillis();
        if (r2.b != 0) goto L34;
        r2.b = r7;
    L34:
        if ((r7 - r2.b) < 9000) goto L41;
        if ((r7 - r2.a) < TimeUnit.MINUTES.toMillis(1)) goto L41;
        r2.a = r7;
        r2.b = 0;
        f2.b(2131911617, 1);
        r4.invoke();
        goto L41
    L57:
        return;
    L46:
        if ((r14 instanceof zg1.m0) == false) goto L56;
        boolean r17 = ((zg1.m0) r14).a;
        View r5 = ((Widget) this).contentView;
        if (r17 == false) goto L50;
        float r18 = 0.0f;
    L51:
        r5.setAlpha(r18);
        return;
    L50:
        r18 = 1.0f;
        goto L51
    }

    public final void onInit(Object[] r2) {
        this.a = (NetSpeedImageView) findViewById(2131374797);
        this.b = (NetSpeedTextView) findViewById(2131388734);
        Disposable r3 = xs2.b.a().b(q3.class).subscribe(new m0(this));
        this.f.add(r3);
    }

    public final void onLoad(Object[] r9) {
        LiveNetworkBroadcastReceiver r10 = this.h;
        Context r0 = ((Widget) this).context;
        TokenCert r1 = m;
        r10.b(r0, r1);
        r10.a(this.i, r1);
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L5;
        r12.observe("data_keyboard_status", this);
    L5:
        DataCenter r13 = ((Widget) this).dataCenter;
        if (r13 == null) goto L8;
        r13.observe("cmd_official_inspector", this);
    L8:
        boolean r2 = false;
        LiveMode r5 = null;
        if (((Boolean) wh.a.getValue()).booleanValue() == true) goto L11;
    L35:
        boolean r14 = false;
    L36:
        iq0 r6 = iq0.a;
        if (((y71) r6.getValue()).b() == true) goto L39;
    L54:
        if (r14 == true) goto L56;
        if (r2 == true) goto L56;
        return;
    L56:
        r81.b r15 = r81.b.b;
        e r3 = this.l;
        Intrinsics.checkNotNullParameter(r3, "callback");
        jc1.a.b().registerComponentCallbacks(r15);
        r81.b.a = new WeakReference(r3);
        return;
    L39:
        if (((y71) r6.getValue()).a() == false) goto L54;
        RoomContext.a r7 = RoomContext.Companion;
        RoomContext r8 = RoomContext.a.c(r7, ((Widget) this).dataCenter, 0, 2);
        if (r8 == null) goto L46;
        com.bytedance.live.datacontext.i r16 = r8.getLiveMode();
        if (r16 == null) goto L46;
        r5 = (LiveMode) r16.getValue();
    L46:
        if (r5 != LiveMode.SCREEN_RECORD) goto L54;
        RoomContext r4 = RoomContext.a.c(r7, ((Widget) this).dataCenter, 0, 2);
        if (r4 == null) goto L54;
        com.bytedance.live.datacontext.i r17 = r4.isAnchor();
        if (r17 == null) goto L54;
        if (((Boolean) r17.getValue()).booleanValue() != true) goto L54;
        r2 = true;
        goto L54
    L11:
        if (((Boolean) vh.a.getValue()).booleanValue() == false) goto L35;
        RoomContext.a r18 = RoomContext.Companion;
        RoomContext r19 = RoomContext.a.c(r18, ((Widget) this).dataCenter, 0, 2);
        if (r19 == null) goto L17;
        com.bytedance.live.datacontext.i r20 = r19.getLiveMode();
        if (r20 == null) goto L17;
        LiveMode r22 = (LiveMode) r20.getValue();
    L19:
        if (r22 == LiveMode.VIDEO) goto L28;
        RoomContext r23 = RoomContext.a.c(r18, ((Widget) this).dataCenter, 0, 2);
        if (r23 == null) goto L25;
        com.bytedance.live.datacontext.i r24 = r23.getLiveMode();
        if (r24 == null) goto L25;
        LiveMode r25 = (LiveMode) r24.getValue();
    L27:
        if (r25 != LiveMode.MEDIA) goto L35;
    L25:
        r25 = null;
    L28:
        RoomContext r26 = RoomContext.a.c(r18, ((Widget) this).dataCenter, 0, 2);
        if (r26 == null) goto L35;
        com.bytedance.live.datacontext.i r27 = r26.isAnchor();
        if (r27 == null) goto L35;
        if (((Boolean) r27.getValue()).booleanValue() != true) goto L35;
        r14 = true;
    L17:
        r22 = null;
        goto L19
    }
}
