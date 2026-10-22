package com.bytedance.android.livesdk.chatroom.vs_base.log;

import android.content.Context;
import android.os.SystemClock;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayConfigSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.player.ReplayPlayerScene;
import com.bytedance.android.livesdk.chatroom.vs_base.session.video.ReplayEventHub;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.utils.e1;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeBaseInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.m;
import com.ss.android.videoshop.context.VideoContext;
import fq1.s;
import fq1.t;
import java.util.Map;
import java.util.UUID;
import jc1.k;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mq1.r;
import nic.l;
import nic.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ReplayDurationLogger {
    public String a;
    public long b;
    public long c;
    public final PlayerProgressServiceContext d;
    public final VideoContext e;
    public final com.bytedance.android.livesdk.chatroom.vs_base.log.a f;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public long k;
    public float l;
    public final Lazy m;
    public final a n;
    public final Context o;
    public final DataCenter p;

    public static final class a extends l.a {
        public long a;
        public final /* synthetic */ ReplayDurationLogger b;

        public a(ReplayDurationLogger r1) {
            this.b = r1;
        }

        public final void B(p r5, tic.a r6) {
            ReplayDurationLogger r7 = this.b;
            if (r7.k <= 0) goto L9;
            int r8 = e.a;
            DataCenter r9 = r7.p;
            String r10 = String.valueOf(System.currentTimeMillis() - this.b.k);
            Intrinsics.checkNotNullParameter(r10, "duration");
            if (r9 == null) goto L7;
            d.a(r9).d("switch_duration", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", r10)}), new Object[0]);
        L7:
            this.b.k = -1;
            return;
        }

        public final void W(oic.f r5, tic.a r6) {
            ReplayDurationLogger r7 = this.b;
            int r0 = -1;
            if (r7.g != (-1)) goto L8;
            com.bytedance.android.livesdk.chatroom.vs_base.log.a r8 = r7.f;
            if (r8 == null) goto L7;
            r0 = r8.O4();
        L7:
            r7.g = r0;
        L8:
            ReplayDurationLogger r9 = this.b;
            if (r9.b != (-1)) goto L12;
            r9.b = SystemClock.elapsedRealtime();
            return;
        }

        public final void s(oic.f r1, tic.a r2) {
            this.b.a("pause");
        }

        public final void R(oic.f r6, tic.a r7, boolean r8) {
            long r9 = SystemClock.elapsedRealtime() - this.a;
            if (((Boolean) ReplayConfigSettingKeys.LIVE_REPLAY_PERFORMANCE_TEST.getValue()).booleanValue() == false) goto L7;
            DataCenter r10 = this.b.p;
            if (r10 == null) goto L7;
            d.a(r10).d("seek_duration", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", String.valueOf(r9))}), new Object[0]);
        L7:
            this.a = 0;
            ReplayDurationLogger r11 = this.b;
            long r2 = r11.b;
            if (r2 <= 0) goto L11;
            r11.b = r2 + r9;
            return;
        }

        public final void w(oic.f r1, tic.a r2, long r3) {
            this.a = SystemClock.elapsedRealtime();
        }

        public final void q(oic.f r3, tic.a r4, int r5, int r6) {
            com.bytedance.android.livesdk.chatroom.vs_base.log.a r7 = this.b.f;
            if (r7 == null) goto L5;
            long r8 = r7.O4();
        L6:
            ReplayDurationLogger r9 = this.b;
            r9.c = Math.max(r9.c, r8);
            return;
        L5:
            r8 = r5;
            goto L6
        }
    }

    public final void b() {
        if (this.b != (-1)) goto L5;
        this.b = SystemClock.elapsedRealtime();
    L5:
        int r1 = -1;
        if (this.g != (-1)) goto L12;
        com.bytedance.android.livesdk.chatroom.vs_base.log.a r0 = this.f;
        if (r0 == null) goto L10;
        r1 = r0.O4();
    L10:
        this.g = r1;
        return;
    }

    public final void c() {
        s r0 = t.a();
        if (r0 != null) goto L5;
    L7:
        IMiddleWareHostContext r1 = k.f(IMiddleWareHostContext.class);
        if (r1 == null) goto L14;
        String r2 = r1.getServerDeviceId();
        if (r2 == null) goto L14;
        if (StringsKt.isBlank(r2) == false) goto L15;
        r2 = UUID.randomUUID().toString();
    L15:
        String r3 = r2 + "_" + String.valueOf(System.currentTimeMillis());
    L16:
        this.a = r3;
        return;
    L14:
        r2 = null;
        goto L15
    L5:
        if (r0.isLogin() != true) goto L7;
        r3 = t.a().getCurrentUserId().toString() + "_" + String.valueOf(System.currentTimeMillis());
        goto L16
    }

    public final void a(String r11) {
        if (this.b != (-1)) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.vs_base.log.a r0 = this.f;
        if (r0 == null) goto L8;
        Long r1 = Long.valueOf(r0.O4());
    L14:
        if (r1 == null) goto L16;
        long r2 = r1.longValue();
    L17:
        long r4 = SystemClock.elapsedRealtime() - this.b;
        long r3 = Math.max(r2, r4);
        this.c = Math.max(this.c, r4);
        Pair[] r6 = new Pair[8];
        r6[0] = TuplesKt.to("duration", String.valueOf(r4));
        r6[1] = TuplesKt.to("vs_start_watch_record", String.valueOf(this.g));
        r6[2] = TuplesKt.to("vs_exit_watch_record", String.valueOf(r3));
        r6[3] = TuplesKt.to("vs_max_watch_record", String.valueOf(this.c));
        DataCenter r5 = this.p;
        if (r5 != null) goto L20;
    L23:
        String r7 = "portrait";
    L24:
        r6[4] = TuplesKt.to("vs_screen_type", r7);
        r6[5] = TuplesKt.to("vs_enter_room_id", this.a);
        r6[6] = TuplesKt.to("previous_play_speed", String.valueOf(this.l));
        r6[7] = TuplesKt.to("reason", r11);
        Map<String, String> r12 = MapsKt.mutableMapOf(r6);
        fq1.a r8 = fq1.b.a();
        if (r8 == null) goto L49;
        Episode r9 = r8.a;
        if (r9 == null) goto L49;
        IMainEpisode r10 = r9.castToOrNull(IMainEpisode.class);
        if (r10 == null) goto L49;
        PrivilegeInfo r13 = r10.subscribeReplayInfo();
        if (r13 == null) goto L49;
        PrivilegeBaseInfo r14 = r13.paidLiveInfo;
        if (r14 != null) goto L35;
    L37:
        String r15 = "inactive";
    L38:
        r12.put("member_status", r15);
        fq1.a r16 = fq1.b.a();
        if (r16 == null) goto L47;
        Episode r17 = r16.a;
        if (r17 == null) goto L47;
        String r18 = EpisodeExtKt.getOwnerIdString(r17);
        if (r18 == null) goto L47;
        if (r18.equals(t.a().getCurrentUserId()) != true) goto L47;
        String r19 = "1";
    L48:
        r12.put("is_anchor", r19);
    L47:
        r19 = "0";
        goto L48
    L35:
        if (r14.hasViewRight() != true) goto L37;
        r15 = "active";
    L49:
        DataCenter r20 = this.p;
        if (r20 == null) goto L52;
        d.a(r20).d("play_time", r12, new Object[0]);
    L52:
        this.b = -1;
        this.g = -1;
        this.j = r4;
        int r110 = e1.a;
        e1.b(this.p, r4);
        return;
    L20:
        if (h.d(r5, true) == true) goto L23;
        r7 = "landscape";
        goto L24
    L16:
        r2 = 0;
        goto L17
    L8:
        PlayerProgressServiceContext r21 = this.d;
        if (r21 == null) goto L13;
        m r22 = r21.getCurrentTime();
        if (r22 == null) goto L13;
        r1 = (Long) r22.getValue();
    L13:
        r1 = null;
        goto L14
    }

    public ReplayDurationLogger(Context r4, DataCenter r5, com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r6) {
        this.o = r4;
        this.p = r5;
        this.a = "";
        this.b = -1;
        this.g = -1;
        this.j = -1;
        this.k = -1;
        this.l = 1.0f;
        Lazy r0 = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(ReplayDurationLogger$playerBrickService$2.INSTANCE);
        this.m = r0;
        this.n = new a(this);
        Boolean r1 = null;
        if (r5 == null) goto L11;
        mq1.t r2 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.e();
        if (r2 == null) goto L9;
        IReplayInnerProgressService r3 = r2.provideVSProgressService(r5);
        if (r3 == null) goto L9;
        PlayerProgressServiceContext r7 = r3.provideContext(r5);
    L10:
        this.d = r7;
    L9:
        r7 = null;
    L11:
        this.e = VideoContext.n0(r4);
        if (r5 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.vs_base.log.a r8 = (com.bytedance.android.livesdk.chatroom.vs_base.log.a) r5.get("video_watch_record_logger_key", null);
    L15:
        this.f = r8;
        if (r5 == null) goto L18;
        ReplayEventHub r9 = (ReplayEventHub) r5.get("zygote_event_hub", null);
    L19:
        if (r9 == null) goto L24;
        NextLiveData<Boolean> r10 = r9.b;
        if (r10 == null) goto L24;
        r1 = (Boolean) r10.getValue();
    L24:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L26;
        b();
    L26:
        if (r6 == null) goto L33;
        LifecycleOwner r11 = r6.z;
        if (r11 == null) goto L33;
        if (r9 == null) goto L33;
        NextLiveData<Boolean> r12 = r9.b;
        if (r12 == null) goto L33;
        r12.observe(r11, new b(this));
    L33:
        r r13 = (r) r0.getValue();
        if (r13 == null) goto L45;
        r13.g();
        com.bytedance.android.livesdk.chatroom.replay.player.m r14 = com.bytedance.android.livesdk.chatroom.replay.player.m.b;
        if (r6 == null) goto L38;
        long r15 = r6.w;
    L39:
        com.bytedance.android.livesdk.chatroom.vs_base.player.c r16 = r14.a(r15);
        if (r16 != null) goto L42;
        return;
    L42:
        if (r16.getScene() != ReplayPlayerScene.PRE_PLAY) goto L47;
        r16.k(new c(this));
        return;
    L47:
        return;
    L38:
        r15 = 0;
        goto L39
    L45:
        return;
    L18:
        r9 = null;
        goto L19
    L14:
        r8 = null;
        goto L15
    }
}
