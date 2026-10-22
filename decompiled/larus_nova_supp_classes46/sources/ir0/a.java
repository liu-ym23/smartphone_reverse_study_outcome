package ir0;

import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.MiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.minigameaudience.api.MiniGameAudienceApi;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.livesdk.k1;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.LiveMgInstantPlayConfig;
import com.bytedance.live.datacontext.m;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends lr0.a {
    public final MiniGameContext b;

    public a(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Bundle onEvent(Bundle r10) {
        ALogger.d("OnInstantPlaySyncProgressEventListener", "onEvent");
        Room r0 = this.b.getRoom();
        LiveMode r1 = null;
        if (r0 == null) goto L5;
        LiveMode r2 = r0.getStreamType();
    L7:
        if (r2 == LiveMode.VIDEO) goto L15;
        Room r3 = this.b.getRoom();
        if (r3 == null) goto L12;
        r1 = r3.getStreamType();
    L12:
        if (r1 == LiveMode.THIRD_PARTY) goto L15;
        boolean r4 = false;
    L16:
        if (r4 == true) goto L19;
        Bundle r11 = new Bundle();
        r11.putBoolean("is_video_live", false);
        return r11;
    L19:
        MiniGameDataContext.Companion.getClass();
        MiniGameDataContext r5 = MiniGameDataContext.a.a();
        if (r5 == null) goto L56;
        m<Integer> r6 = r5.getInstantPlayOpenStatus();
        if (r6 == null) goto L56;
        if (((Number) r6.getValue()).intValue() != 1) goto L56;
        MiniGameDataContext r7 = MiniGameDataContext.a.a();
        if (r7 == null) goto L54;
        m<Integer> r8 = r7.getInstantPlayToggleStatus();
        if (r8 == null) goto L54;
        if (((Number) r8.getValue()).intValue() != 1) goto L54;
        String r9 = "";
        if (((LiveMgInstantPlayConfig) k1.a.getValue()).getOpen() == true) goto L58;
        Bundle r12 = new Bundle();
        r12.putBoolean("is_server_success", true);
        r12.putString("data", "");
        return r12;
    L58:
        ALogger.d("OnInstantPlaySyncProgressEventListener", "request");     // Catch: Exception -> L51
        Lazy r13 = LiveOpenPlatformMgClient.c;     // Catch: Exception -> L51
        MiniGameAudienceApi r14 = (MiniGameAudienceApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAudienceApi.class);     // Catch: Exception -> L51
        long r15 = this.b.getRoomId();     // Catch: Exception -> L51
        MiniGameDataContext r16 = MiniGameDataContext.a.a();     // Catch: Exception -> L51
        if (r16 == null) goto L45;
        m<String> r17 = r16.getGameId();     // Catch: Exception -> L51
        if (r17 == null) goto L45;
        String r18 = (String) r17.getValue();     // Catch: Exception -> L51
        if (r18 == null) goto L45;
        r9 = r18;
    L45:
        Response r19 = (Response) r14.instantPlayGetProgress(r15, r9).compose(RxUtil.rxSchedulerHelper()).blockingFirst();     // Catch: Exception -> L51
        if (r19.statusCode != 0) goto L49;
        Bundle r20 = new Bundle();     // Catch: Exception -> L51
        r20.putBoolean("is_server_success", true);     // Catch: Exception -> L51
        r20.putString("data", ((fr0.a) r19.data).a());     // Catch: Exception -> L51
        return r20;
    L49:
        Bundle r21 = new Bundle();     // Catch: Exception -> L51
        r21.putBoolean("is_server_success", false);     // Catch: Exception -> L51
        return r21;
    L51:
        e = move-exception;
        ALogger.d("OnInstantPlaySyncProgressEventListener", "request exception " + e.getMessage());
        Bundle r110 = new Bundle();
        r110.putBoolean("is_server_success", false);
        return r110;
    L54:
        Bundle r111 = new Bundle();
        r111.putBoolean("is_toggle", false);
        return r111;
    L56:
        Bundle r112 = new Bundle();
        r112.putBoolean("is_open", false);
        return r112;
    L15:
        r4 = true;
        goto L16
    L5:
        r2 = null;
        goto L7
    }
}
