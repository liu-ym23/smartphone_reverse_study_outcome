package com.bytedance.android.live.broadcastgame.opengame.control;

import android.app.Dialog;
import android.content.Context;
import android.util.LruCache;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.api.interactgame.j;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.control.report.ReportPicUploader;
import com.bytedance.android.live.broadcastgame.opengame.dialog.control.OpenControlDialogManager;
import com.bytedance.android.live.broadcastgame.opengame.message.c0;
import com.bytedance.android.live.broadcastgame.opengame.message.i0;
import com.bytedance.android.live.broadcastgame.opengame.panel.i;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.g;
import com.bytedance.android.live.broadcastgame.opengame.runtime.p;
import com.bytedance.android.live.broadcastgame.opengame.runtime.q;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.message.model.sc;
import com.bytedance.android.livesdk.wrds.interact.InteractControlSyncModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\b\tB\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/control/OpenPlatformControlService;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "d", "e", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformControlService implements y10.a, i, p, Observer<KVData> {
    public static final /* synthetic */ int j = 0;
    public final InteractControlSyncModel a;
    public final f b;
    public com.bytedance.android.livesdk.wrds.interact.a.a c;
    public final LinkedList<Pair<String, com.bytedance.android.livesdk.wrds.interact.a.a>> d;
    public final LinkedList<Pair<String, com.bytedance.android.livesdk.wrds.interact.a.a>> e;
    public final Lazy f;
    public final e g;
    public final PluginContext h;
    public final /* synthetic */ i20.a i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ OpenPlatformControlService a;

        public a(OpenPlatformControlService r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.livesdk.wrds.interact.a r5 = (com.bytedance.android.livesdk.wrds.interact.a) r4;
            OpenPlatformControlService r0 = this.a;
            String r1 = r5.roomId;
            if (r0.h.o == false) goto L5;
            List r6 = r5.anchorOperationList;
        L6:
            OpenPlatformControlService.d(r0, r1, r6);
            return;
        L5:
            r6 = r5.audienceOperationList;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ OpenPlatformControlService a;

        public b(OpenPlatformControlService r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            OpenPlatformControlService r0 = this.a;
            sc r5 = ((i0.a) r4).a;
            String r1 = r5.roomId;
            if (r0.h.o == false) goto L5;
            List r6 = r5.anchorOperationList;
        L6:
            OpenPlatformControlService.d(r0, r1, r6);
            return;
        L5:
            r6 = r5.audienceOperationList;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class d {
    }

    public final class e {
        public Disposable a;
        public a b;
        public final /* synthetic */ OpenPlatformControlService c;

        public final class a extends Dialog {
            public final TextView a;
            public final TextView b;

            public a(Context r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                super(r2, 2131954708);
                setCancelable(false);
                setCanceledOnTouchOutside(false);
                setContentView(2131565417);
                this.a = (TextView) findViewById(2131389683);
                this.b = (TextView) findViewById(2131389684);
            }
        }

        public e(OpenPlatformControlService r1) {
            this.c = r1;
        }
    }

    public static final class f extends OpenControlDialogManager {
        public final /* synthetic */ OpenPlatformControlService d;

        @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.OpenControlDialogManager
        public final void a() {
            super.a();
            OpenPlatformControlService.e(this.d);
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.OpenControlDialogManager
        public final void b() {
            super.b();
            OpenPlatformControlService.e(this.d);
        }

        public f(OpenPlatformControlService r1, Context r2) {
            this.d = r1;
            super(r2);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void a() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void b() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void c() {
    }

    @Override // y10.a
    public final void g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onBackPressed() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onPanelCancel() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
    }

    public final void i() {
        if ((!this.d.isEmpty()) == false) goto L8;
        Pair<String, com.bytedance.android.livesdk.wrds.interact.a.a> r0 = this.d.pop();
        if (r0 == null) goto L9;
        h((String) r0.getFirst(), (com.bytedance.android.livesdk.wrds.interact.a.a) r0.getSecond());
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        InteractControlSyncModel r0 = this.a;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.d.clear();
        if ((!this.e.isEmpty()) == false) goto L11;
        Iterator<T> r1 = this.e.iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        Pair r2 = (Pair) r1.next();
        h((String) r2.getFirst(), (com.bytedance.android.livesdk.wrds.interact.a.a) r2.getSecond());
    L11:
        this.e.clear();
        DataCenter r3 = this.h.i;
        if (r3 == null) goto L14;
        r3.removeObserver(this);
    L14:
        this.i.b();
    }

    public OpenPlatformControlService(PluginContext r6) {
        Intrinsics.checkNotNullParameter(r6, "pluginContext");
        i20.a r0 = new i20.a();
        this.i = r0;
        this.h = r6;
        this.b = new f(this, r6.i());
        this.d = new LinkedList();
        this.e = new LinkedList();
        Lazy r1 = LazyKt.lazy(new OpenPlatformControlService$roomContext$2(this));
        this.f = r1;
        this.g = new e(this);
        RoomContext r2 = (RoomContext) r1.getValue();
        if (r2 == null) goto L11;
        InteractControlSyncModel r3 = dc2.b.a(n3.g(r2), OpenPlatformControlService$1$1.INSTANCE);
        this.a = r3;
        dc2.c r4 = r3.getInteractControlData();
        if (r4 == null) goto L11;
        Observable r5 = r4.d;
        if (r5 == null) goto L11;
        Disposable r7 = r5.subscribe(new a(this));
        if (r7 == null) goto L11;
        Intrinsics.checkNotNullParameter(r7, "$this$autoDispose");
        r0.a(r7);
    L11:
        c0 r8 = r6.l;
        if (r8 == null) goto L18;
        Observable r9 = r8.a(i0.a.class);
        if (r9 == null) goto L18;
        Disposable r11 = r9.subscribe(new b(this), c.a);
        if (r11 == null) goto L18;
        Intrinsics.checkNotNullParameter(r11, "$this$autoDispose");
        r0.a(r11);
    L18:
        DataCenter r12 = r6.i;
        if (r12 == null) goto L21;
        r12.observe("data_live_mode", this);
    L21:
        DataCenter r13 = r6.i;
        if (r13 == null) goto L25;
        r13.observe("data_link_state", this);
        return;
    }

    public static final void e(OpenPlatformControlService r2) {
        com.bytedance.android.livesdk.wrds.interact.a.a r0 = r2.c;
        if (r0 == null) goto L5;
        Integer r1 = r0.operationType;
    L6:
        if (r1 != null) goto L9;
    L17:
        r2.i();
        return;
    L9:
        if (r1.intValue() != 3) goto L17;
        com.bytedance.android.livesdk.wrds.interact.a.a r3 = r2.c;
        if (r3 == null) goto L15;
        com.bytedance.android.livesdk.wrds.interact.a.b r4 = r3.popBoxContent;
        if (r4 == null) goto L15;
        String r5 = r4.a();
    L16:
        r2.f(r5);
    L15:
        r5 = "unknown";
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public final void f(String r7) {
        boolean r1 = true;
        if ((!Intrinsics.areEqual(r7, "live_scene_limit")) == true) goto L5;
    L7:
        q r0 = this.h.k;
        if (r7.length() == 0) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        r7 = "control";
    L13:
        r0.b(r7);
        PluginType r8 = this.h.m();
        if (r8 == null) goto L17;
        com.bytedance.android.live.broadcastgame.opengame.behavior.e.a r2 = com.bytedance.android.live.broadcastgame.opengame.behavior.e.a;
        DataCenter r3 = this.h.i;
        Map r4 = MapsKt.emptyMap();
        r2.getClass();
        com.bytedance.android.live.broadcastgame.opengame.behavior.e.a.a(r3, r8, r4);
        return;
    L17:
        return;
    L5:
        if ((!Intrinsics.areEqual(r7, "anchor_close")) == false) goto L7;
        int r5 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        PluginContext r6 = this.h;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenPlatformControlService", new Object[]{"add to black list, reason: ", r7, ", name: ", r6.m.b(r6.o), ", appid: ", this.h.m.i});
        String r9 = ((BootInfoService) this.h.o(BootInfoService.class)).e();
        LruCache<String, byte[]> r11 = ReportPicUploader.a;
        String r12 = this.h.m.i;
        Intrinsics.checkNotNullParameter(r12, "appId");
        Intrinsics.checkNotNullParameter(r7, "reason");
        Intrinsics.checkNotNullParameter(r9, "gameTye");
        ReportPicUploader.c.put(r12, new ReportPicUploader.a(r7, r9));
        goto L7
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        InteractControlSyncModel r3 = this.a;
        if (r3 == null) goto L5;
        r3.release();
    L5:
        this.d.clear();
        this.i.b();
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 == null) goto L5;
        String r7 = r6.getKey();
    L6:
        if (r7 == null) goto L39;
        int r0 = r7.hashCode();
        if (r0 == 872172481) goto L17;
        if (r0 == 1691407041) goto L14;
        return;
    L14:
        if (r7.equals("data_live_mode") == true) goto L19;
        return;
    L19:
        if (this.h.m.o == PluginType.MINI_APP) goto L41;
        int r8 = j.a();
        g r1 = ((BootInfoService) this.h.o(BootInfoService.class)).c();
        if (r1 == null) goto L28;
        com.bytedance.android.live.broadcastgame.opengame.runtime.j r2 = r1.b;
        if (r2 == null) goto L28;
        List<Integer> r3 = r2.e;
        if (r3 == null) goto L28;
        boolean r9 = r3.contains(Integer.valueOf(r8));
    L29:
        if (r9 == true) goto L38;
        com.bytedance.android.livesdk.wrds.interact.a.b r11 = new com.bytedance.android.livesdk.wrds.interact.a.b();
        if (this.h.o == false) goto L33;
        r11.iconType = 3;
        r11.description = s1.B(2131920916);
        r11.largeType = 3;
    L34:
        Intrinsics.checkNotNullParameter("live_scene_limit", "value");
        r11.mControlType = "live_scene_limit";
        r11.countDownSec = 45;
        r11.title = s1.B(2131920918);
        r11.buttonDesc = s1.B(2131920914);
        com.bytedance.android.livesdk.wrds.interact.a.a r4 = new com.bytedance.android.livesdk.wrds.interact.a.a();
        r4.popBoxContent = r11;
        r4.appId = this.h.m.i;
        r4.operationType = 3;
        r4.b(1);
        h(String.valueOf(this.h.m.a), r4);
        return;
    L33:
        r11.description = s1.B(2131920917);
        r11.largeType = 2;
        goto L34
    L38:
        return;
    L28:
        r9 = true;
        goto L29
    L41:
        return;
    L17:
        if (r7.equals("data_link_state") == true) goto L19;
        return;
    L39:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final void h(String r11, final com.bytedance.android.livesdk.wrds.interact.a.a r12) {
        String r2 = null;
        if ((!Intrinsics.areEqual(String.valueOf(this.h.m.a), r11)) == true) goto L5;
    L6:
        String r0 = this.h.m.i;
        if (r12 == null) goto L9;
        String r3 = r12.appId;
    L11:
        if ((!Intrinsics.areEqual(r0, r3)) == false) goto L13;
    L68:
        i();
        int r1 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        StringBuilder r4 = new StringBuilder("process InteractControlData error dataRoomId:");
        r4.append(r11);
        r4.append(", dataAppId:");
        if (r12 == null) goto L71;
        r2 = r12.appId;
    L71:
        r4.append(r2);
        com.bytedance.android.live.broadcastgame.opengame.q.h(r4.toString());
        return;
    L13:
        if (r12.operationType == null) goto L68;
        if (r12.popBoxContent == null) goto L68;
        Integer r5 = r12.a();
        if (r5 != null) goto L21;
    L23:
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r6 = this.b.a;
        if (r6 != null) goto L26;
    L27:
        e.a r7 = this.g.b;
        if (r7 == null) goto L30;
        boolean r8 = r7.isShowing();
    L31:
        if (r8 == false) goto L54;
    L32:
        com.bytedance.android.livesdk.wrds.interact.a.a r9 = this.c;
        if (r9 == null) goto L37;
        com.bytedance.android.livesdk.wrds.interact.a.b r13 = r9.popBoxContent;
        if (r13 == null) goto L37;
        String r14 = r13.a();
    L39:
        if (Intrinsics.areEqual(r14, "live_scene_limit") == false) goto L52;
        com.bytedance.android.livesdk.wrds.interact.a.a r15 = this.c;
        if (r15 == null) goto L45;
        com.bytedance.android.livesdk.wrds.interact.a.b r16 = r15.popBoxContent;
        if (r16 == null) goto L45;
        String r17 = r16.a();
    L46:
        com.bytedance.android.livesdk.wrds.interact.a.b r18 = r12.popBoxContent;
        if (r18 == null) goto L50;
        r2 = r18.a();
    L50:
        if (Intrinsics.areEqual(r17, r2) == false) goto L52;
        return;
    L45:
        r17 = null;
    L52:
        this.d.add(TuplesKt.to(r11, r12));
        return;
    L37:
        r14 = null;
        goto L39
    L54:
        this.c = r12;
        final com.bytedance.android.livesdk.wrds.interact.a.b r19 = r12.popBoxContent;
        if (r19 == null) goto L57;
        UtilityKotlinExtentionsKt.s(0, false, false, new OpenPlatformControlService$processInteractControlDataAndShow$$inlined$let$lambda$1(r19, this, r12), 7);
    L57:
        Integer r110 = r12.operationType;
        if (r110 != null) goto L61;
        return;
    L61:
        if (r110.intValue() != 2) goto L73;
        com.bytedance.android.livesdk.wrds.interact.a.b r111 = r12.popBoxContent;
        if (r111 == null) goto L65;
        String r112 = r111.a();
    L66:
        f(r112);
        return;
    L65:
        r112 = "unknown";
        goto L66
    L73:
        return;
    L30:
        r8 = false;
        goto L31
    L26:
        if (r6.isShowing() == true) goto L32;
    L21:
        if (r5.intValue() != 2) goto L23;
        r12.operationType = 1;
        goto L23
    L9:
        r3 = null;
        goto L11
    L5:
        if (v.a() == false) goto L68;
        goto L6
    }

    public static final void d(OpenPlatformControlService r4, String r5, List r6) {
        if ((!Intrinsics.areEqual(String.valueOf(r4.h.m.a), r5)) == true) goto L5;
    L7:
        if (r6 == null) goto L34;
        Iterator r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L35;
        com.bytedance.android.livesdk.wrds.interact.a.a r0 = (com.bytedance.android.livesdk.wrds.interact.a.a) r7.next();
        Integer r2 = r0.a();
        if (r2 == null) goto L17;
        if (r2.intValue() != 1) goto L17;
        r4.h(r5, r0);
    L17:
        if (r2 == null) goto L10;
        if (r2.intValue() != 2) goto L10;
        r4.e.add(TuplesKt.to(r5, r0));
        goto L10
    L35:
        return;
    L34:
        return;
    L5:
        if (v.a() == true) goto L7;
        int r8 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.h("enqueue operationList error dataRoomId:" + r5);
    }
}
