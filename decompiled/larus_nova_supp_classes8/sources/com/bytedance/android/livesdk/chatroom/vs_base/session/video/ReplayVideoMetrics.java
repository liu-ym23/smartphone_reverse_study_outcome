package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import am2.b0;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.q;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.metrics.ReplayUILatch;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.room.error.IEndReason;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;
import fq1.j;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mq1.x;
import nic.p;
import org.json.JSONException;
import org.json.JSONObject;
import vr1.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ReplayVideoMetrics implements jm1.b {
    public final Bundle a;
    public final a0 b;
    public final wr1.c c;
    public final com.bytedance.android.livesdk.chatroom.vs_base.log.g d;
    public final wr1.d e;
    public final String f;
    public final String g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final com.bytedance.android.livesdk.chatroom.vs_base.session.video.h l;
    public final ReplayEventHub m;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.vs_base.session.video.ReplayVideoMetrics$10, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/livesdk/chatroom/vs_base/session/video/ReplayVideoMetrics$Behavior;", "Lkotlin/ParameterName;", LiveEndPageData.TAG_NAME, "behavior", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass10 extends FunctionReferenceImpl implements Function1<Behavior, Unit> {
        public AnonymousClass10(ReplayVideoMetrics r8) {
            super(1, r8, ReplayVideoMetrics.class, "handleBackgroundBehavior", "handleBackgroundBehavior(Lcom/bytedance/android/livesdk/chatroom/vs_base/session/video/ReplayVideoMetrics$Behavior;)V", 0);
        }

        public final void invoke(Behavior r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            ReplayVideoMetrics r0 = (ReplayVideoMetrics) ((CallableReference) this).receiver;
            r0.getClass();
            int r4 = com.bytedance.android.livesdk.chatroom.vs_base.session.video.d.a[r3.ordinal()];
            if (r4 != 1) goto L5;
            r0.k = true;
            return;
        L5:
            if (r4 != 2) goto L11;
            r0.k = false;
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Behavior) r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/session/video/ReplayVideoMetrics$Behavior;", "", "BACKGROUND", "RESET", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Behavior extends Enum<Behavior> {
        public static final Behavior BACKGROUND = null;
        public static final Behavior RESET = null;
        public static final /* synthetic */ Behavior[] a = null;

        static {
            Behavior r1 = new Behavior("BACKGROUND", 0);
            BACKGROUND = r1;
            Behavior r2 = new Behavior("RESET", 1);
            RESET = r2;
            a = new Behavior[]{r1, r2};
        }

        public static Behavior valueOf(String r1) {
            return (Behavior) r27.a.a(Behavior.class, r1);
        }

        public static Behavior[] values() {
            return (Behavior[]) a.clone();
        }

        public Behavior(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a<T> implements Observer {
        public final /* synthetic */ ReplayVideoMetrics a;

        public a(ReplayVideoMetrics r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Boolean r6 = (Boolean) r5;
            if (r6 == null) goto L11;
            r6.booleanValue();
            if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L12;
            ReplayVideoMetrics r7 = this.a;
            r7.e.b(r7.a);
            r7.a.remove("previous_page");
            com.bytedance.android.livesdk.chatroom.vs_base.log.g r0 = r7.d;
            r0.e = false;
            long r1 = SystemClock.elapsedRealtime();
            r0.k = r1;
            if (r0.m == false) goto L9;
            r0.l = r1;
        L9:
            r0.i = true;
            r0.a.post(r0.n);
            r7.e.a(r7.l.k);
            ReplayUILatch.MAIN_UI.setStartTime(Long.valueOf(this.a.a.getLong(VSConstants.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME, -1)));
            this.a.e.f();
            return;
        L12:
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ReplayVideoMetrics a;

        public b(ReplayVideoMetrics r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Map r2 = (Map) r1;
            this.a.b.h();
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ReplayVideoMetrics a;

        public c(ReplayVideoMetrics r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Boolean r6 = (Boolean) r5;
            if (r6 == null) goto L15;
            r6.booleanValue();
            String r7 = (String) this.a.m.e.getValue();
            if (r7 != null) goto L7;
        L13:
            ReplayVideoMetrics r8 = this.a;
            r8.b.c(104, (String) r8.m.e.getValue(), this.a.l.w);
            return;
        L7:
            if (StringsKt.isBlank(r7) != true) goto L13;
            if (Intrinsics.areEqual((Boolean) this.a.m.f.getValue(), Boolean.TRUE) == true) goto L17;
            ReplayVideoMetrics r9 = this.a;
            r9.b.g(r9.l.w);
            this.a.b.c(j.a().j0(), "room cancel", this.a.l.w);
            return;
        L17:
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ReplayVideoMetrics a;

        public d(ReplayVideoMetrics r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Pair r7 = (Pair) r6;
            if (r7 != null) goto L5;
            return;
        L5:
            if (((Boolean) r7.getFirst()).booleanValue() != true) goto L13;
            r.o().onModuleStart(VSConstants.PERFORMANCE_MANAGER_MODULE_REPLAY, null);
            this.a.e.d(j.a().j(), ((Number) r7.getSecond()).longValue());
            this.a.e.d(j.a().getPlaying(), ((Number) r7.getSecond()).longValue());
            ReplayVideoMetrics r8 = this.a;
            r8.h = true;
            r8.c(true, false);
            wr1.c r9 = this.a.c;
            r9.f(false);
            r9.b();
            r9.e(j.a().K());
            r9.e(j.a().i());
            r9.d();
            r9.c();
            com.bytedance.android.livesdk.chatroom.vs_base.log.g r10 = this.a.d;
            if (r10.f == true) goto L14;
            r10.f = true;
            r10.k = SystemClock.elapsedRealtime();
            return;
        L14:
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ReplayVideoMetrics a;

        public e(ReplayVideoMetrics r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            String r6 = (String) r5;
            if (r6 == null) goto L10;
            this.a.e.cancelTrace();
            Type r0 = new com.bytedance.android.livesdk.chatroom.vs_base.session.video.c().getType();
            String r1 = (String) ((Map) GsonProtectorUtils.fromJson(new Gson(), r6, r0)).get("error_code");
            if (r1 == null) goto L9;
            this.a.b.d(CastIntegerProtector.valueOf(r1).intValue(), r6, this.a.l.w);
            return;
        L9:
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ ReplayVideoMetrics a;

        public f(ReplayVideoMetrics r1) {
            this.a = r1;
        }

        public final void onChanged(Object r18) {
            Episode r0 = (Episode) r18;
            fq1.r.a().d("ttlive_room_exit", "startInteraction real cause show interaction; id" + this.a.l.w);
            rq1.a.C0414a r1 = rq1.a.a;
            com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r2 = this.a.l;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "session");
            JSONObject r6 = new JSONObject();
            boolean r8 = true;
            com.bytedance.android.livesdk.chatroom.vs_base.session.video.a r9 = r2.c;     // Catch: JSONException -> L42
            r6.putOpt(VSConstants.EXTRA_VS_ENTER_METHOD, r9.e);     // Catch: JSONException -> L42
            r6.putOpt(VSConstants.EXTRA_LOG_ACTION_TYPE, r9.a);     // Catch: JSONException -> L42
            r6.putOpt(VSConstants.EXTRA_VS_REQUEST_ID, r9.f);     // Catch: JSONException -> L42
            r6.putOpt("room_id", String.valueOf(r2.w));     // Catch: JSONException -> L42
            Episode r10 = r2.f;     // Catch: JSONException -> L42
            if (r10 == null) goto L6;
            String r11 = EpisodeExtKt.getOwnerIdString(r10);     // Catch: JSONException -> L42
        L7:
            r6.putOpt("anchor_id", r11);     // Catch: JSONException -> L42
            Serializable r12 = r2.A.getSerializable("live_effect_ad_log_extra_map");     // Catch: JSONException -> L42
            if ((r12 instanceof Map) == true) goto L10;
            r12 = null;
        L10:
            Map r13 = (Map) r12;     // Catch: JSONException -> L42
            if (r13 != null) goto L13;
            r13 = MapsKt.emptyMap();     // Catch: JSONException -> L42
        L13:
            String r14 = "";
            if ((!r13.isEmpty()) == false) goto L16;
            r14 = "effective_ad";
        L25:
            Object r15 = r13.get("value");     // Catch: JSONException -> L42
            if ((r15 instanceof String) == true) goto L28;
            r15 = null;
        L28:
            String r16 = (String) r15;     // Catch: JSONException -> L42
            Object r17 = r13.get("log_extra");     // Catch: JSONException -> L42
            if ((r17 instanceof String) == true) goto L31;
            r17 = null;
        L31:
            String r19 = (String) r17;     // Catch: JSONException -> L42
            Object r110 = r13.get("ad_id");     // Catch: JSONException -> L42
            if ((r110 instanceof String) == true) goto L34;
            r110 = null;
        L34:
            String r111 = (String) r110;     // Catch: JSONException -> L42
            String r112 = VSConstants.EXTRA_VS_ENTER_FROM_MERGE;     // Catch: JSONException -> L42
            com.bytedance.android.livesdk.chatroom.vs_base.session.video.a r113 = r2.c;     // Catch: JSONException -> L42
            String r7 = r113.c;     // Catch: JSONException -> L42
            String r114 = r113.d;     // Catch: JSONException -> L42
            if (TextUtils.isEmpty(r114) == true) goto L37;
            r7 = r114;
        L37:
            r6.putOpt(r112, r7);     // Catch: JSONException -> L42
            String r20 = r2.A.getString("live.intent.extra.ENTER_AWEME_ID");     // Catch: JSONException -> L42
            Object r21 = r13.get("direct_live_ad");     // Catch: JSONException -> L42
            if ((r21 instanceof String) == true) goto L40;
            r21 = null;
        L40:
            rq1.b.a(r6, "direct_live_ad", (String) r21);     // Catch: JSONException -> L42
            rq1.b.a(r6, "is_other_channel", r14);     // Catch: JSONException -> L42
            rq1.b.a(r6, "video_id", r20);     // Catch: JSONException -> L42
            rq1.b.a(r6, "value", r16);     // Catch: JSONException -> L42
            rq1.b.a(r6, "creative_id", r16);     // Catch: JSONException -> L42
            rq1.b.a(r6, "log_extra", r19);     // Catch: JSONException -> L42
            rq1.b.a(r6, "ad_id", r111);     // Catch: JSONException -> L42
        L45:
            if (r2.j != 1) goto L47;
            String r3 = "0";
        L48:
            r6.putOpt("screen_type", r3);
            if (r2.j == 1) goto L52;
            r8 = false;
        L52:
            r6.putOpt("is_portrait", Boolean.valueOf(r8));
            FragmentActivity r4 = this.a.l.getContext();
            if ((r4 instanceof FragmentActivity) == true) goto L55;
            FragmentActivity r22 = null;
        L56:
            FragmentActivity r23 = r22;
            if (r23 == null) goto L66;
            j.a().Y(r23, r6.toString());
            DataCenter r5 = this.a.l.y;
            if (r5 == null) goto L65;
            r5.put("log_enter_params", r6.toString());
            return;
        L65:
            return;
        L66:
            return;
        L55:
            r22 = r4;
            goto L56
        L47:
            r3 = "1";
            goto L48
        L16:
            Serializable r24 = r2.A.getSerializable("live_douplus_log_extra");     // Catch: JSONException -> L42
            if ((r24 instanceof Map) == true) goto L19;
            r24 = null;
        L19:
            r13 = (Map) r24;     // Catch: JSONException -> L42
            if (r13 != null) goto L23;
            r13 = MapsKt.emptyMap();     // Catch: JSONException -> L42
        L23:
            if ((!r13.isEmpty()) == false) goto L25;
            r14 = "dou_plus";
            goto L25
        L6:
            r11 = null;
        L42:
            e = move-exception;
            ALogger.d("VSRoomSessionAdInfoProvider", String.valueOf(e.getMessage()));
            goto L45
        }
    }

    public static final class g<T> implements Observer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ ReplayVideoMetrics a;

        public h(ReplayVideoMetrics r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L6;
            this.a.c.a(j.a().R());
            return;
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ ReplayVideoMetrics a;

        public i(ReplayVideoMetrics r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Pair r6 = (Pair) r5;
            if (r6 != null) goto L5;
            return;
        L5:
            if (((Boolean) r6.getFirst()).booleanValue() != true) goto L9;
            this.a.e.d(j.a().e0(), ((Number) r6.getSecond()).longValue());
            return;
        }
    }

    public final void b() {
        com.bytedance.android.livesdk.chatroom.vs_base.log.g r0 = this.d;
        r0.e = true;
        r0.k = -1;
        r0.l = -1;
        r0.m = false;
        r0.h = false;
        r0.f = false;
        r0.i = true;
        r0.j = 0;
        r0.c = false;
        r0.b = false;
        r0.d = false;
        r0.a.removeCallbacksAndMessages(null);
        this.c.reset();
    }

    public final void a(Bundle r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        o r0 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.l.y).c(b0.class);
        if (r0 != null) goto L7;
        return;
    L7:
        String r1 = this.g;
        String r2 = this.f;
        r0.remove("request_id");
        if (r.d().g(r8) == true) goto L10;
        r0.remove("live_window_mode");
    L10:
        r0.remove("log_pb");
        r0.remove("starlight_rank");
        if (TextUtils.isEmpty(r1) == false) goto L13;
        r1 = r8.getString(VSConstants.EXTRA_ENTER_LOG_PB);
    L13:
        r0.c("log_pb", r1);
        if (TextUtils.isEmpty(r2) == false) goto L16;
        r2 = r8.getString(VSConstants.EXTRA_ENTER_REQUEST_ID);
    L16:
        r0.c("request_id", r2);
        if (TextUtils.isEmpty(r2) == true) goto L20;
        ((ar1.c) r0).b.put("request_id", r2);
    L20:
        if (TextUtils.isEmpty(r1) == true) goto L22;
        ((ar1.c) r0).b.put("log_pb", r1);
    L22:
        int r3 = this.l.getContext().getSharedPreferences("feed_live_span", 0).getInt("span_count", 0);
        if (r3 <= 0) goto L28;
        if (r3 <= 1) goto L26;
        String r4 = "live_small_picture";
    L27:
        r0.c("live_window_mode", r4);
        goto L28
    L26:
        r4 = "live_big_picture";
    L28:
        r0.remove("card_id");
        r0.remove("card_position");
        String r5 = r8.getString("card_id");
        String r6 = null;
        if (r5 != null) goto L31;
    L36:
        String r9 = r8.getString("card_position");
        if (r9 != null) goto L39;
        return;
    L39:
        if ((!StringsKt.isBlank(r9)) == false) goto L41;
        r6 = r9;
    L41:
        if (r6 == null) goto L45;
        r0.c("card_position", r6);
        return;
    L45:
        return;
    L31:
        if ((!StringsKt.isBlank(r5)) == true) goto L34;
        r5 = null;
    L34:
        if (r5 == null) goto L36;
        r0.c("card_id", r5);
        goto L36
    }

    public final void m00(Episode r2) {
        Intrinsics.checkNotNullParameter(r2, "episode");
        this.b.b();
        this.c.e(j.a().R());
    }

    public ReplayVideoMetrics(com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r6, ReplayEventHub r7) {
        Intrinsics.checkNotNullParameter(r6, "session");
        Intrinsics.checkNotNullParameter(r7, "hub");
        this.l = r6;
        this.m = r7;
        Bundle r0 = r6.A;
        this.a = r0;
        a0 r1 = j.a().N();
        this.b = r1;
        this.c = j.a().n();
        wr1.d r2 = j.a().E(r0);
        this.e = r2;
        com.bytedance.android.livesdk.chatroom.vs_base.session.video.a r3 = r6.c;
        this.f = r3.f;
        this.g = r3.g;
        Bundle r4 = r0.getBundle(VSConstants.EXTRA_ENTER_LIVE_EXTRA);
        this.d = new com.bytedance.android.livesdk.chatroom.vs_base.log.g(r6.y);
        r1.a(j.a().d());
        a(r4);
        r7.h.observeForever(new a(this));
        r2.f();
        r7.l.observeForever(new b(this));
        r7.x.observeForever(new c(this));
        r7.c.observeForever(new d(this));
        r7.e.observeForever(new e(this));
        r7.q.observeForever(new f(this));
        r7.t.observeForever(g.a);
        r7.y.observeForever(new h(this));
        r7.A.observeForever(new i(this));
        r7.B = new AnonymousClass10(this);
        LifecycleOwner r8 = r6.z;
        if (r8 == null) goto L7;
        r7.z.observe(r8, new com.bytedance.android.livesdk.chatroom.vs_base.session.video.e(this));
        r7.f.observe(r8, new com.bytedance.android.livesdk.chatroom.vs_base.session.video.f(this));
        return;
    }

    public final void c(boolean r18, boolean r19) {
        if (r18 == false) goto L5;
        this.i = r18;
    L5:
        if (r19 == false) goto L8;
        this.j = r19;
    L8:
        if (this.i == true) goto L10;
        return;
    L10:
        if (this.j == true) goto L12;
        return;
    L12:
        if (this.h == false) goto L151;
        Pair[] r2 = new Pair[1];
        if (this.k == false) goto L16;
        Object r3 = "1";
    L17:
        r2[0] = TuplesKt.to("is_from_background", r3);
        Map<String, String> r4 = MapsKt.mutableMapOf(r2);
        x r5 = q.d();
        if (r5 == null) goto L25;
        lm1.c r6 = r5.a();
        if (r6 == null) goto L25;
        if (r6.a(this.l.w) != true) goto L25;
        r4.put("hit_show_preload_cache", "1");
    L25:
        if (this.l.l == false) goto L27;
        r4.put("is_video_player_prepared", "1");
    L27:
        com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r7 = this.l;
        if (r7.n == false) goto L30;
    L31:
        r4.put("is_preload", "1");
        this.l.A.remove("live.intent.extra.EXTRA_VS_HIT_CACHE_WHEN_PREPARE");
    L33:
        if (this.l.o == false) goto L35;
        r4.put("is_vs_video_pre_play", "1");
    L35:
        ReplayDataContext.a r8 = ReplayDataContext.Companion;
        DataCenter r9 = this.l.y;
        r8.getClass();
        ReplayDataContext r10 = ReplayDataContext.a.b(r9);
        if (r10 == null) goto L42;
        m<Boolean> r11 = r10.getHasSwitched();
        if (r11 == null) goto L42;
        if (((Boolean) r11.getValue()).booleanValue() != true) goto L42;
        r4.put("play_scene", "switch");
    L44:
        if (((Number) this.l.y.get("replay_enter_api_duration", -1L)).longValue() <= 0) goto L46;
        r4.put("enter_api_duration", String.valueOf(((Number) this.l.y.get("replay_enter_api_duration", -1L)).longValue()));
    L46:
        r4.put("replay_schema_pre_request_status", this.l.c.j);
        VideoContext r12 = VideoContext.n0(this.l.getContext());
        if (r12 == null) goto L141;
        p r13 = r12.p0();
        if (r13 == null) goto L141;
        VideoInfo r14 = r13.b();
        if (r14 == null) goto L56;
        Resolution r15 = r14.getResolution();
        if (r15 == null) goto L56;
        String r16 = r15.toString(VideoRef.TYPE_VIDEO);
        if (r16 == null) goto L56;
    L57:
        r4.put("vs_resolution", r16);
        if (this.l.k == false) goto L60;
        r4.put("start_position", String.valueOf(r13.getCurrentPosition() / BubbleId.PadCast));
    L61:
        ReplayDataContext r17 = ReplayDataContext.a.b(this.l.y);
        o r20 = null;
        if (r17 == null) goto L66;
        m<Integer> r21 = r17.getSeekType();
        if (r21 == null) goto L66;
        Integer r22 = (Integer) r21.getValue();
    L67:
        if (r22 != null) goto L70;
    L71:
        if (r22 != null) goto L74;
    L102:
        VideoEngineInfos r1 = r13.c("firstframe_split");
        if (r1 == null) goto L141;
        Object r23 = r1.getObject();
        if (r23 == null) goto L141;
        if ((r23 instanceof JSONObject) == false) goto L141;
        JSONObject r24 = (JSONObject) r23;
        r24.put("try_play", this.e.g(j.a().e0()));
        r24.put("on_render_start", this.e.g(j.a().j()));
        int r25 = com.bytedance.android.livesdk.chatroom.vs_base.session.video.b.j;
        Intrinsics.checkNotNullParameter(r24, "jsonObject");
        com.bytedance.android.livesdk.chatroom.vs_base.session.video.b r26 = new com.bytedance.android.livesdk.chatroom.vs_base.session.video.b();
        r26.a = r24.optLong("try_play");
        r26.b = r24.optLong("format_open_input");
        r26.c = r24.optLong("tran_connect");
        r26.d = r24.optLong("http_response");
        r26.e = r24.optLong("receive_first_video_frame");
        r26.f = r24.optLong("decode_first_video_frame");
        r26.g = r24.optLong("render_first_video_frame");
        r26.h = r24.optLong("prepared");
        r26.i = r24.optLong("on_render_start");
        Intrinsics.checkNotNullParameter(r4, "map");
        long r27 = r26.b;
        long r28 = r27 - r26.a;
        if (r28 < 0) goto L111;
        int r29 = (int) r28;
    L112:
        long r110 = r26.c;
        long r111 = r110 - r27;
        if (r111 < 0) goto L115;
        int r30 = (int) r111;
    L116:
        long r112 = r26.d;
        long r113 = r112 - r110;
        if (r113 < 0) goto L119;
        int r114 = (int) r113;
    L120:
        long r31 = r26.e;
        long r115 = r31 - r112;
        if (r115 < 0) goto L123;
        int r116 = (int) r115;
    L124:
        long r117 = r26.f;
        long r32 = r117 - r31;
        if (r32 < 0) goto L127;
        int r33 = (int) r32;
    L128:
        long r34 = r26.g;
        long r118 = r34 - r117;
        if (r118 < 0) goto L131;
        int r119 = (int) r118;
    L132:
        long r120 = r26.h - r27;
        if (r120 < 0) goto L135;
        int r35 = (int) r120;
    L136:
        long r121 = r26.i - r34;
        if (r121 < 0) goto L139;
        int r36 = (int) r121;
    L140:
        r4.put("try_play_to_open", String.valueOf(r29));
        r4.put("open_to_tcp_cnt", String.valueOf(r30));
        r4.put("tcp_cnt_to_http_res", String.valueOf(r114));
        r4.put("http_res_to_rev_ff", String.valueOf(r116));
        r4.put("rev_ff_to_decode_ff", String.valueOf(r33));
        r4.put("decode_ff_to_render_ff", String.valueOf(r119));
        r4.put("open_to_prepared", String.valueOf(r35));
        r4.put("render_ff_to_render_start", String.valueOf(r36));
    L142:
        this.e.e(r4);
        this.k = false;
        this.h = false;
        return;
    L139:
        r36 = -1;
        goto L140
    L135:
        r35 = -1;
        goto L136
    L131:
        r119 = -1;
        goto L132
    L127:
        r33 = -1;
        goto L128
    L123:
        r116 = -1;
        goto L124
    L119:
        r114 = -1;
        goto L120
    L115:
        r30 = -1;
        goto L116
    L111:
        r29 = -1;
        goto L112
    L74:
        if (r22.intValue() != 1) goto L102;
    L75:
        VideoInfo r37 = r13.b();
        if (r37 == null) goto L78;
        HashMap r38 = r37.mPacketOffset;
    L80:
        if (r38 != null) goto L82;
    L85:
        r4.put("highlight_match", "0");
        long r39 = r13.d() / ((long) BubbleId.PadCast);
        JSONObject r122 = new JSONObject();
        r122.put("scene", "enter");     // Catch: JSONException -> L144
        r122.put("enter_from_merge", this.l.c.c);     // Catch: JSONException -> L144
        r122.put("enter_method", this.l.c.e);     // Catch: JSONException -> L144
        r122.put("highlight_location", r39);     // Catch: JSONException -> L144
        r122.put("pkt_offset", String.valueOf(r38));     // Catch: JSONException -> L144
        o r40 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.l.y).c(am2.a0.class);     // Catch: JSONException -> L144
        if ((r40 instanceof ar1.b) == false) goto L90;
        r20 = r40;
    L90:
        ar1.b r41 = (ar1.b) r20;     // Catch: JSONException -> L144
        if (r41 == null) goto L101;
        Map<String, String> r42 = r41.b;     // Catch: JSONException -> L144
        if (r42 == null) goto L101;
        Set<Map.Entry<String, String>> r43 = r42.entrySet();     // Catch: JSONException -> L144
        if (r43 == null) goto L101;
        Iterator<T> r44 = r43.iterator();     // Catch: JSONException -> L144
    L98:
        if (r44.hasNext() == false) goto L101;
        Map.Entry r45 = (Map.Entry) r44.next();     // Catch: JSONException -> L144
        r122.put((String) r45.getKey(), r45.getValue());     // Catch: JSONException -> L144
    L101:
        LiveSlardarMonitor.monitorStatus("ttlive_vs_video_highlight_preload_error", 1, r122);
        goto L102
    L82:
        if (r38.containsKey(Double.valueOf(r13.d() / ((long) BubbleId.PadCast))) == false) goto L85;
        r4.put("highlight_match", "1");
        goto L102
    L78:
        r38 = null;
        goto L80
    L70:
        if (r22.intValue() == 2) goto L75;
    L66:
        r22 = null;
        goto L67
    L60:
        r4.put("start_position", String.valueOf(r13.d() / ((long) BubbleId.PadCast)));
    L56:
        r16 = "";
    L141:
        r4 = r4;
    L42:
        r4.put("play_scene", "enter");
        goto L44
    L30:
        if (r7.A.getBoolean("live.intent.extra.EXTRA_VS_HIT_CACHE_WHEN_PREPARE", false) == false) goto L33;
    L16:
        r3 = "0";
        goto L17
    }

    public final void fX(long r6, String r8, boolean r9, Episode r10, ls2.e r11) {
        Intrinsics.checkNotNullParameter(r8, "userId");
        Intrinsics.checkNotNullParameter(r11, "error");
        this.k = false;
        IEndReason r0 = r11.getReasonV2Ext();
        fq1.q r1 = fq1.r.a();
        StringBuilder r2 = new StringBuilder();
        if (r0 == null) goto L5;
        String r4 = r0.toString();
    L6:
        r2.append(r4);
        r2.append(" cause to room exit; id");
        r2.append(r6);
        r1.d("ttlive_room_exit", r2.toString());
        if (Intrinsics.areEqual(r0, EndReason.PLAYER_ERROR.INSTANCE) == false) goto L10;
        this.h = false;
        j.a().k("player error", 207, j.a().d());
        this.b.f(r6);
        this.b.c(j.a().a(), "ttplayer init failed", r6);
        this.e.cancelTrace();
        TimeCostUtil.Tag r7 = TimeCostUtil.Tag.StartLivePlay;
        TimeCostUtil.a("error", "ttplayer init failed");
        TimeCostUtil.Tag r12 = TimeCostUtil.Tag.ScrollWatchLivePlay;
        TimeCostUtil.a("error", "ttplayer init failed");
        com.bytedance.android.live.core.performance.a r13 = com.bytedance.android.live.core.performance.a.a;
        r7.name();
        r13.getClass();
        r12.name();
        return;
    L10:
        if (Intrinsics.areEqual(r0, EndReason.ENTER_FAILED.INSTANCE) == false) goto L21;
        int r14 = r11.getRoomErrorCodeV2();
        if (r14 != 203) goto L14;
        String r15 = "rd_info_by_user_failed";
    L18:
        if (r15 == null) goto L63;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.l.y).d(r15, null, new Object[0]);
        return;
    L63:
        return;
    L14:
        if (r14 == 205) goto L16;
        r15 = null;
        goto L18
    L16:
        r15 = "rd_enter_room_failed";
        goto L18
    L21:
        if ((r0 instanceof EndReason.LIVE_END) == false) goto L27;
        if (r9 == false) goto L24;
        this.b.c(j.a().A(), "leave for profile", r6);
    L25:
        b();
        return;
    L24:
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.l.y).d("rd_enter_room_live_end", null, new Object[0]);
        this.b.c(j.a().c(), "frame_fail", r6);
        j.a().k("room finish", 201, j.a().d());
        goto L25
    L27:
        if ((r0 instanceof EndReason.FETCH_FAILED) == false) goto L32;
        if (r9 == false) goto L30;
        this.b.c(j.a().A(), "leave for profile", r6);
        return;
    L30:
        this.b.e(j.a().I(), new JSONObject(), r6);
        j.a().k("pull url invalid", 204, j.a().d());
        return;
    L32:
        if (Intrinsics.areEqual(r0, EndReason.EMPTY_URL.INSTANCE) == false) goto L35;
        this.b.c(j.a().X(), "empty url", r6);
        return;
    L35:
        if (Intrinsics.areEqual(r0, EndReason.PING_KICK_OUT.INSTANCE) == false) goto L38;
        this.b.c(j.a().f0(), "ping kick out", r6);
        b();
        return;
    L38:
        if (Intrinsics.areEqual(r0, EndReason.PING_LOST_FOCUS.INSTANCE) == false) goto L41;
        this.b.c(j.a().f(), "isn't resumed and lost audio", r6);
        return;
    L41:
        if (Intrinsics.areEqual(r0, EndReason.MEDIA_END.INSTANCE) == false) goto L44;
        b();
        return;
    L44:
        if (Intrinsics.areEqual(r0, EndReason.USER_CLOSE.INSTANCE) == false) goto L47;
        this.b.c(j.a().S(), "user close", r6);
        b();
        return;
    L47:
        if (Intrinsics.areEqual(r0, EndReason.USER_KICK_OUT.INSTANCE) == false) goto L50;
        this.b.c(j.a().x(), "this user is kicked out by other device", r6);
        b();
        return;
    L50:
        if (Intrinsics.areEqual(r0, EndReason.WATCHER_KIT_OUT.INSTANCE) == false) goto L53;
        new Handler(Looper.getMainLooper()).postDelayed(new com.bytedance.android.livesdk.chatroom.vs_base.session.video.g(this, r6), 2500);
        return;
    L53:
        if (Intrinsics.areEqual(r0, EndReason.JUMP_TO_OTHER.INSTANCE) == false) goto L56;
        b();
        this.b.c(j.a().s(), "jump to other room", r6);
        return;
    L56:
        if (Intrinsics.areEqual(r0, EndReason.JUMP_TO_OTHER_MIX_ROOM.INSTANCE) == false) goto L59;
        b();
        this.b.c(j.a().h(), "jump to other mix room", r6);
        return;
    L59:
        if (Intrinsics.areEqual(r0, EndReason.STOP_WITHOUT_RELEASE_PLAYER.INSTANCE) == false) goto L77;
        b();
        this.b.c(j.a().y(), "change page", r6);
        return;
    L77:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
