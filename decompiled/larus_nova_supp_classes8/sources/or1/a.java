package or1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.episode.BaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a, com.bytedance.android.scope.o {
    public a() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a
    public final boolean enable() {
        int r0 = ft1.b.a;
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a
    public final void a(int r1) {
        ft1.d.d(r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a
    public final void c(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        Map<String, String> r0 = ft1.d.a;
        ft1.d.c(r2, hashCode());
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a
    public final Map<String, String> d(Episode r5) {
        Intrinsics.checkNotNullParameter(r5, "episode");
        int r0 = ft1.c.a;
        LinkedHashMap r1 = new LinkedHashMap();
        String r2 = r5.seasonId;     // Catch: Exception -> L36
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        r1.put("live_season_id", r2);     // Catch: Exception -> L36
        r1.put("live_room_id", String.valueOf(r5.roomId));     // Catch: Exception -> L36
        r1.put("live_anchor_id", EpisodeExtKt.getOwnerIdString(r5));     // Catch: Exception -> L36
        EpisodeMod r3 = r5.episodeMod;     // Catch: Exception -> L36
        if (r3 == null) goto L11;
        String r4 = ft1.c.a(Integer.valueOf(((BaseEpisodeMod) r3).episodeStage));     // Catch: Exception -> L36
        if (r4 == null) goto L11;
        r1.put("live_episode_stage", r4);     // Catch: Exception -> L36
    L11:
        EpisodeMod r6 = r5.episodeMod;     // Catch: Exception -> L36
        String r7 = null;
        if (r6 == null) goto L14;
        Integer r8 = Integer.valueOf(((BaseEpisodeMod) r6).episodeSubType);     // Catch: Exception -> L36
    L15:
        int r9 = EpisodeMod.EpisodeSubType.UNKNOWN;     // Catch: Exception -> L36
        if (r8 != null) goto L19;
    L21:
        int r10 = EpisodeMod.EpisodeSubType.NORMAL;     // Catch: Exception -> L36
        if (r8 != null) goto L25;
    L27:
        int r11 = EpisodeMod.EpisodeSubType.GUIDE;     // Catch: Exception -> L36
        if (r8 != null) goto L31;
    L33:
        if (r7 == null) goto L38;
        r1.put("live_episode_sub_type", r7);     // Catch: Exception -> L36
        Unit r12 = Unit.INSTANCE;     // Catch: Exception -> L36
    L38:
        return r1;
    L31:
        if (r8.intValue() != r11) goto L33;
        r7 = "GUIDE";
        goto L33
    L25:
        if (r8.intValue() != r10) goto L27;
        r7 = "NORMAL";
        goto L33
    L19:
        if (r8.intValue() != r9) goto L21;
    L14:
        r8 = null;
    L36:
        e = move-exception;
        ALogger.e("LiveCrashTag", "get episode info map error:" + e.toString());
        Unit r13 = Unit.INSTANCE;
        goto L38
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a
    public final void f(int r1) {
        ft1.d.a(r1);
    }
}
