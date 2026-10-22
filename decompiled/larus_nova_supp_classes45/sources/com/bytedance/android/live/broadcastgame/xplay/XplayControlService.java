package com.bytedance.android.live.broadcastgame.xplay;

import android.content.Context;
import android.util.LruCache;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.control.report.ReportPicUploader;
import com.bytedance.android.live.broadcastgame.opengame.dialog.control.OpenControlDialogManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.miniplay.SupportLiveScene;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.message.model.sc;
import com.bytedance.android.livesdk.wrds.interact.InteractControlSyncModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayControlService;", "Lcom/bytedance/android/scope/o;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/live/broadcastgame/xplay/c;", "a", "b", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XplayControlService implements com.bytedance.android.scope.o, Observer<KVData>, com.bytedance.android.live.broadcastgame.xplay.c {
    public InteractControlSyncModel a;
    public final c b;
    public com.bytedance.android.livesdk.wrds.interact.a.a c;
    public final LinkedList<Pair<String, com.bytedance.android.livesdk.wrds.interact.a.a>> d;
    public final LinkedList<Pair<String, com.bytedance.android.livesdk.wrds.interact.a.a>> e;
    public final Lazy f;
    public final b g;
    public vlc.d h;
    public final CompositeDisposable i;
    public final d j;
    public final com.bytedance.android.live.broadcastgame.api.xplay.p k;
    public final k20.e l;

    public static final class a {
    }

    public final class b {
        public b() {
        }
    }

    public static final class c extends OpenControlDialogManager {
        public final /* synthetic */ XplayControlService d;

        @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.OpenControlDialogManager
        public final void a() {
            super.a();
            XplayControlService.c(this.d);
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.dialog.control.OpenControlDialogManager
        public final void b() {
            super.b();
            XplayControlService.c(this.d);
        }

        public c(XplayControlService r1, Context r2) {
            this.d = r1;
            super(r2);
        }
    }

    public static final class d implements vlc.l {
        public final /* synthetic */ XplayControlService a;

        public d(XplayControlService r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r4) {
            if ((r4 instanceof sc) == false) goto L10;
            XplayControlService r0 = this.a;
            sc r5 = (sc) r4;
            String r1 = r5.roomId;
            if (r0.k.d == false) goto L7;
            List r6 = r5.anchorOperationList;
        L8:
            XplayControlService.a(r0, r1, r6);
            return;
        L7:
            r6 = r5.audienceOperationList;
            goto L8
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ XplayControlService a;

        public e(XplayControlService r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.livesdk.wrds.interact.a r5 = (com.bytedance.android.livesdk.wrds.interact.a) r4;
            XplayControlService r0 = this.a;
            String r1 = r5.roomId;
            if (r0.k.d == false) goto L5;
            List r6 = r5.anchorOperationList;
        L6:
            XplayControlService.a(r0, r1, r6);
            return;
        L5:
            r6 = r5.audienceOperationList;
            goto L6
        }
    }

    static {
    }

    public final void g() {
        if ((!this.d.isEmpty()) == false) goto L8;
        Pair<String, com.bytedance.android.livesdk.wrds.interact.a.a> r0 = this.d.pop();
        if (r0 == null) goto L9;
        f((String) r0.getFirst(), (com.bytedance.android.livesdk.wrds.interact.a.a) r0.getSecond());
        return;
    L9:
        return;
    }

    public final void onStart() {
        RoomContext r0 = (RoomContext) this.f.getValue();
        if (r0 == null) goto L11;
        InteractControlSyncModel r1 = dc2.b.a(n3.g(r0), XplayControlService$onStart$1$1.INSTANCE);
        this.a = r1;
        dc2.c r2 = r1.getInteractControlData();
        if (r2 == null) goto L11;
        Observable r3 = r2.d;
        if (r3 == null) goto L11;
        Disposable r4 = r3.subscribe(new e(this));
        if (r4 == null) goto L11;
        RxUtilKt.c(r4, this.i);
    L11:
        DataCenter r5 = this.k.i;
        vlc.d r6 = null;
        if (r5 == null) goto L14;
        r6 = (vlc.d) r5.get("data_message_manager", null);
    L14:
        this.h = r6;
        if (r6 == null) goto L17;
        r6.addMessageListener(MessageType.INTERACT_OPEN_PLATFORM_CONTROL_MESSAGE.getIntType(), this.j);
    L17:
        DataCenter r7 = this.k.i;
        if (r7 == null) goto L20;
        r7.observe("data_live_mode", this);
    L20:
        DataCenter r8 = this.k.i;
        if (r8 == null) goto L24;
        r8.observe("data_link_state", this);
        return;
    }

    public final void onStop() {
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
        f((String) r2.getFirst(), (com.bytedance.android.livesdk.wrds.interact.a.a) r2.getSecond());
    L11:
        this.e.clear();
        DataCenter r3 = this.k.i;
        if (r3 == null) goto L14;
        r3.removeObserver(this);
    L14:
        this.i.dispose();
        vlc.d r4 = this.h;
        if (r4 == null) goto L19;
        r4.removeMessageListener(this.j);
        return;
    }

    public static final void c(XplayControlService r2) {
        com.bytedance.android.livesdk.wrds.interact.a.a r0 = r2.c;
        if (r0 == null) goto L5;
        Integer r1 = r0.operationType;
    L6:
        if (r1 != null) goto L9;
    L17:
        r2.g();
        return;
    L9:
        if (r1.intValue() != 3) goto L17;
        com.bytedance.android.livesdk.wrds.interact.a.a r3 = r2.c;
        if (r3 == null) goto L15;
        com.bytedance.android.livesdk.wrds.interact.a.b r4 = r3.popBoxContent;
        if (r4 == null) goto L15;
        String r5 = r4.a();
    L16:
        r2.d(r5);
    L15:
        r5 = "unknown";
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public final void d(String r6) {
        boolean r1 = true;
        if ((!Intrinsics.areEqual(r6, "live_scene_limit")) == true) goto L5;
    L7:
        k20.e r0 = this.l;
        if (r6.length() == 0) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        r6 = "control";
    L13:
        r0.a(r6);
        com.bytedance.android.live.broadcastgame.opengame.behavior.e.a r7 = com.bytedance.android.live.broadcastgame.opengame.behavior.e.a;
        DataCenter r2 = this.k.i;
        PluginType r3 = PluginType.SONIC_GAME;
        Map r4 = MapsKt.emptyMap();
        r7.getClass();
        com.bytedance.android.live.broadcastgame.opengame.behavior.e.a.a(r2, r3, r4);
        return;
    L5:
        if ((!Intrinsics.areEqual(r6, "anchor_close")) == false) goto L7;
        LruCache<String, byte[]> r5 = ReportPicUploader.a;
        String r8 = this.k.h.b;
        Intrinsics.checkNotNullParameter(r8, "appId");
        Intrinsics.checkNotNullParameter(r6, "reason");
        Intrinsics.checkNotNullParameter("barrage", "gameTye");
        ReportPicUploader.c.put(r8, new ReportPicUploader.a(r6, "barrage"));
        goto L7
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r6 = r5.getKey();
    L6:
        if (r6 == null) goto L33;
        int r0 = r6.hashCode();
        if (r0 == 872172481) goto L17;
        if (r0 == 1691407041) goto L14;
        return;
    L14:
        if (r6.equals("data_live_mode") == false) goto L29;
    L18:
        int r7 = com.bytedance.android.live.broadcastgame.api.interactgame.j.a();
        if (this.k.h.m.contains(Integer.valueOf(r7)) == false) goto L21;
        return;
    L21:
        if (r7 != SupportLiveScene.AUDIO_SINGLE_BROADCAST.getValue()) goto L23;
        d("live_scene_limit");
        return;
    L23:
        com.bytedance.android.livesdk.wrds.interact.a.b r8 = new com.bytedance.android.livesdk.wrds.interact.a.b();
        if (this.k.d == false) goto L26;
        r8.iconType = 3;
        r8.description = com.bytedance.android.live.core.utils.s1.B(2131920916);
        r8.largeType = 3;
    L27:
        Intrinsics.checkNotNullParameter("live_scene_limit", "value");
        r8.mControlType = "live_scene_limit";
        r8.countDownSec = 45;
        r8.title = com.bytedance.android.live.core.utils.s1.B(2131920918);
        r8.buttonDesc = com.bytedance.android.live.core.utils.s1.B(2131920914);
        com.bytedance.android.livesdk.wrds.interact.a.a r1 = new com.bytedance.android.livesdk.wrds.interact.a.a();
        r1.popBoxContent = r8;
        r1.appId = this.k.h.b;
        r1.operationType = 3;
        r1.b(1);
        f(String.valueOf(this.k.b), r1);
        return;
    L26:
        r8.description = com.bytedance.android.live.core.utils.s1.B(2131920917);
        r8.largeType = 2;
        goto L27
    L29:
        return;
    L17:
        if (r6.equals("data_link_state") == true) goto L18;
        return;
    L33:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public XplayControlService(com.bytedance.android.live.broadcastgame.api.xplay.p r2, k20.e r3) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        Intrinsics.checkNotNullParameter(r3, "xplayTerminateService");
        this.k = r2;
        this.l = r3;
        this.b = new c(this, r2.getContext());
        this.d = new LinkedList();
        this.e = new LinkedList();
        this.f = LazyKt.lazy(new XplayControlService$roomContext$2(this));
        this.g = new b();
        this.i = new CompositeDisposable();
        this.j = new d(this);
    }

    public final void f(String r11, com.bytedance.android.livesdk.wrds.interact.a.a r12) {
        String r2 = null;
        if ((!Intrinsics.areEqual(String.valueOf(this.k.b), r11)) == true) goto L5;
    L6:
        String r0 = this.k.h.b;
        if (r12 == null) goto L9;
        String r3 = r12.appId;
    L11:
        if ((!Intrinsics.areEqual(r0, r3)) == false) goto L13;
    L64:
        g();
        int r1 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        StringBuilder r4 = new StringBuilder("process InteractControlData error dataRoomId:");
        r4.append(r11);
        r4.append(", dataAppId:");
        if (r12 == null) goto L67;
        r2 = r12.appId;
    L67:
        r4.append(r2);
        com.bytedance.android.live.broadcastgame.opengame.q.h(r4.toString());
        return;
    L13:
        if (r12.operationType == null) goto L64;
        if (r12.popBoxContent == null) goto L64;
        Integer r5 = r12.a();
        if (r5 != null) goto L21;
    L23:
        com.bytedance.android.live.broadcastgame.opengame.dialog.control.a r6 = this.b.a;
        if (r6 != null) goto L26;
    L50:
        this.g.getClass();
        this.c = r12;
        final com.bytedance.android.livesdk.wrds.interact.a.b r13 = r12.popBoxContent;
        if (r13 == null) goto L53;
        UtilityKotlinExtentionsKt.s(0, false, false, new XplayControlService$processInteractControlDataAndShow$$inlined$let$lambda$1(r13, this), 7);
    L53:
        Integer r14 = r12.operationType;
        if (r14 != null) goto L57;
        return;
    L57:
        if (r14.intValue() != 2) goto L69;
        com.bytedance.android.livesdk.wrds.interact.a.b r15 = r12.popBoxContent;
        if (r15 == null) goto L61;
        String r16 = r15.a();
    L62:
        d(r16);
        return;
    L61:
        r16 = "unknown";
        goto L62
    L69:
        return;
    L26:
        if (r6.isShowing() != true) goto L50;
        com.bytedance.android.livesdk.wrds.interact.a.a r7 = this.c;
        if (r7 == null) goto L33;
        com.bytedance.android.livesdk.wrds.interact.a.b r8 = r7.popBoxContent;
        if (r8 == null) goto L33;
        String r9 = r8.a();
    L35:
        if (Intrinsics.areEqual(r9, "live_scene_limit") == false) goto L48;
        com.bytedance.android.livesdk.wrds.interact.a.a r17 = this.c;
        if (r17 == null) goto L41;
        com.bytedance.android.livesdk.wrds.interact.a.b r18 = r17.popBoxContent;
        if (r18 == null) goto L41;
        String r19 = r18.a();
    L42:
        com.bytedance.android.livesdk.wrds.interact.a.b r21 = r12.popBoxContent;
        if (r21 == null) goto L46;
        r2 = r21.a();
    L46:
        if (Intrinsics.areEqual(r19, r2) == false) goto L48;
        return;
    L41:
        r19 = null;
    L48:
        this.d.add(TuplesKt.to(r11, r12));
        return;
    L33:
        r9 = null;
        goto L35
    L21:
        if (r5.intValue() != 2) goto L23;
        r12.operationType = 1;
        goto L23
    L9:
        r3 = null;
        goto L11
    L5:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L64;
        goto L6
    }

    public static final void a(XplayControlService r4, String r5, List r6) {
        if ((!Intrinsics.areEqual(String.valueOf(r4.k.b), r5)) == true) goto L5;
    L7:
        if (r6 == null) goto L34;
        Iterator r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L35;
        com.bytedance.android.livesdk.wrds.interact.a.a r0 = (com.bytedance.android.livesdk.wrds.interact.a.a) r7.next();
        Integer r2 = r0.a();
        if (r2 == null) goto L17;
        if (r2.intValue() != 1) goto L17;
        r4.f(r5, r0);
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
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L7;
        int r8 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.h("enqueue operationList error dataRoomId:" + r5);
    }
}
