package com.bytedance.android.livesdk.interactivity.seek.v2;

import android.content.Context;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.LayerHostMediaLayout;
import im2.n;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class b implements q52.a {
    public final List<vlc.j> A;
    public final String a;
    public final HashMap<String, String> b;
    public final im2.d c;
    public final n d;
    public final bc2.a e;
    public final bc2.e f;
    public boolean g;
    public final VideoContext h;
    public String i;
    public final c j;
    public final f k;
    public final List<com.ss.ugc.live.sdk.msg.dispatch.a> l;
    public final Set<String> m;
    public final d n;
    public final g o;
    public final e p;
    public final Lazy q;
    public final DataCenter r;
    public final long s;
    public final String t;
    public final String u;
    public final boolean v;
    public final long w;
    public final int x;
    public final long y;
    public final List<vlc.b> z;

    public static final class a {
    }

    static {
    }

    public String f() {
        if (((Boolean) this.q.getValue()).booleanValue() == false) goto L7;
        return "https://" + k.n(IHostNetwork.class).getHostDomain() + "/webcast/im/fetch/traceable/";
    L7:
        return "https://" + k.n(IHostNetwork.class).getHostDomain() + "/webcast/im/fetch/";
    }

    public HashMap<String, String> h() {
        IHostContext r0 = k.n(IHostContext.class);
        HashMap<String, String> r2 = new HashMap(k.n(INetworkService.class).getCommonParams());
        r2.put("room_id", String.valueOf(this.s));
        r2.put("rid", String.valueOf(this.s));
        r2.put("aid", String.valueOf(r0.hostAppId()));
        r2.put("user_id", this.t);
        r2.put("identity", this.a);
        r2.put("live_id", String.valueOf(k.n(IHostContext.class).liveId()));
        String r1 = this.u;
        if (r1 == null) goto L5;
        r2.put("room_tag", r1);
    L5:
        r2.put("episode_id", String.valueOf(this.w));
        r2.put("episode_stage", String.valueOf(this.x));
        r2.put("season_id", String.valueOf(this.y));
        r2.put("get_history", "2");
        if (this.x != EpisodeMod.EpisodeStageType.REPLAY) goto L13;
        DataCenter r3 = this.r;
        Room r4 = z.a;
        Intrinsics.checkNotNullParameter(r3, "$this$episode");
        EpisodeBasicInfo r5 = ((Episode) r3.get("data_vs_episode_data", z.b)).episodeBasicInfo;
        if (r5 == null) goto L11;
        String r6 = String.valueOf(r5.getReplayCameraId());
        if (r6 == null) goto L11;
    L12:
        r2.put("camera_id", r6);
    L11:
        r6 = "0";
    L13:
        VSDataContext.Companion.getClass();
        VSDataContext r7 = VSDataContext.a.a();
        if (r7 != null) goto L16;
    L29:
        boolean r8 = false;
    L30:
        if (r8 == false) goto L34;
        r2.put("system_type", "3");
        if (this.g == false) goto L34;
        this.g = false;
    L34:
        r2.putAll(this.b);
        return r2;
    L16:
        if (((Boolean) r7.isVSVideo().getValue()).booleanValue() == false) goto L29;
        if (this.g == true) goto L28;
        VideoContext r9 = this.h;
        if (r9 == null) goto L29;
        LayerHostMediaLayout r10 = r9.c;
        if (r10 != null) goto L25;
        int r11 = 0;
    L27:
        if (r11 != 0) goto L29;
    L25:
        r11 = r10.getCurrentPosition();
    L28:
        r8 = true;
        goto L30
    }

    public final List<cmc.b<?>> e() {
        return CollectionsKt.emptyList();
    }

    public final amc.b b() {
        return this.n;
    }

    public final com.ss.ugc.live.sdk.msg.b c() {
        return this.p;
    }

    public final amc.i d() {
        return this.o;
    }

    public final n g() {
        return this.d;
    }

    public final vlc.c getLogger() {
        return this.e;
    }

    public final bc2.e getMonitor() {
        return this.f;
    }

    public final amc.g getNetworkConfig() {
        return this.k;
    }

    public final long getRoomId() {
        return this.s;
    }

    @Override // q52.a
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cursor");
        this.i = r2;
    }

    public b(DataCenter r2, Context r3, long r4, String r6, boolean r7, long r8, int r10, long r11, List r13) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "userId");
        this.r = r2;
        this.s = r4;
        this.t = r6;
        this.u = "format";
        this.v = r7;
        this.w = r8;
        this.x = r10;
        this.y = r11;
        this.z = r13;
        this.A = null;
        this.a = "audience";
        this.b = new HashMap();
        this.c = new im2.d(false);
        this.d = new n();
        this.e = new bc2.a("Seek");
        this.f = new bc2.e();
        this.g = true;
        this.h = VideoContext.n0(r3);
        this.i = "0";
        this.j = new c(this);
        this.k = new f(this);
        this.l = CollectionsKt.emptyList();
        this.m = CollectionsKt.toSet(d4.m());
        this.n = new d(this);
        this.o = new g();
        this.p = new e(this);
        this.q = LazyKt.lazy(SeekMessageConfig$useTraceable$2.INSTANCE);
    }
}
