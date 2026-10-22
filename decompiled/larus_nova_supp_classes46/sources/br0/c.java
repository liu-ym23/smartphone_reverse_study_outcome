package br0;

import android.os.Bundle;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.MiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.minigameanchor.api.MiniGameAnchorApi;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.livesdk.k1;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.LiveMgInstantPlayConfig;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends lr0.a {
    public long b;
    public final MiniGameContext c;

    public c(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
        this.c = r2;
    }

    public final Bundle onEvent(Bundle r11) {
        ALogger.d("OnInstantPlayUploadProgressEventListener", "onEvent");
        Room r2 = this.c.getRoom();
        LiveMode r3 = null;
        if (r2 == null) goto L5;
        LiveMode r4 = r2.getStreamType();
    L7:
        if (r4 == LiveMode.VIDEO) goto L15;
        Room r5 = this.c.getRoom();
        if (r5 == null) goto L12;
        r3 = r5.getStreamType();
    L12:
        if (r3 == LiveMode.THIRD_PARTY) goto L15;
        boolean r6 = false;
    L16:
        if (r6 == true) goto L19;
        Bundle r12 = new Bundle();
        r12.putBoolean("is_video_live", false);
        return r12;
    L19:
        MiniGameDataContext.Companion.getClass();
        MiniGameDataContext r7 = MiniGameDataContext.a.a();
        if (r7 == null) goto L83;
        com.bytedance.live.datacontext.m<Integer> r8 = r7.getInstantPlayOpenStatus();
        if (r8 == null) goto L83;
        if (((Number) r8.getValue()).intValue() != 1) goto L83;
        MiniGameDataContext r9 = MiniGameDataContext.a.a();
        if (r9 == null) goto L81;
        com.bytedance.live.datacontext.m<Integer> r10 = r9.getInstantPlayToggleStatus();
        if (r10 == null) goto L81;
        if (((Number) r10.getValue()).intValue() != 1) goto L81;
        long r13 = System.currentTimeMillis() - this.b;
        k1 r14 = k1.a;
        if (r13 >= ((LiveMgInstantPlayConfig) r14.getValue()).getAnchorUploadLimitTime()) goto L37;
        Bundle r15 = new Bundle();
        r15.putBoolean("is_time_limit", true);
        return r15;
    L37:
        String r16 = "";
        if (r11 == null) goto L41;
        String r17 = r11.getString("data", "");
        if (r17 == null) goto L41;
    L42:
        ALogger.d("OnInstantPlayUploadProgressEventListener", "data: ".concat(r17));
        if (r17.getBytes(Charsets.UTF_8).length <= (((LiveMgInstantPlayConfig) r14.getValue()).getAnchorUploadLimitSize() * 1024)) goto L46;
        Bundle r18 = new Bundle();
        r18.putBoolean("is_size_limit", true);
        return r18;
    L46:
        this.b = System.currentTimeMillis();
        ALogger.d("OnInstantPlayUploadProgressEventListener", "request");     // Catch: Exception -> L78
        Lazy r19 = LiveOpenPlatformMgClient.c;     // Catch: Exception -> L78
        MiniGameAnchorApi r20 = (MiniGameAnchorApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAnchorApi.class);     // Catch: Exception -> L78
        MiniGameDataContext r21 = MiniGameDataContext.a.a();     // Catch: Exception -> L78
        if (r21 == null) goto L53;
        com.bytedance.live.datacontext.m<String> r22 = r21.getGameId();     // Catch: Exception -> L78
        if (r22 == null) goto L53;
        String r23 = (String) r22.getValue();     // Catch: Exception -> L78
        if (r23 == null) goto L53;
    L54:
        Room r24 = this.c.getRoom();     // Catch: Exception -> L78
        if (r24 == null) goto L62;
        User r25 = r24.getOwner();     // Catch: Exception -> L78
        if (r25 == null) goto L62;
        String r26 = r25.getUserId();     // Catch: Exception -> L78
        if (r26 == null) goto L62;
        r16 = r26;
    L62:
        yq0.c r110 = (yq0.c) r20.instantPlayUploadProgress(r23, r17, r16).compose(RxUtil.rxSchedulerHelper()).blockingFirst();     // Catch: Exception -> L78
        Integer r27 = r110.a();     // Catch: Exception -> L78
        if (r27 != null) goto L66;
    L69:
        Integer r111 = r110.a();     // Catch: Exception -> L78
        if (r111 != null) goto L73;
    L76:
        Bundle r112 = new Bundle();     // Catch: Exception -> L78
        r112.putBoolean("is_server_success", false);     // Catch: Exception -> L78
        return r112;
    L73:
        if (r111.intValue() != 0) goto L76;
        Bundle r113 = new Bundle();     // Catch: Exception -> L78
        r113.putBoolean("is_server_success", true);     // Catch: Exception -> L78
        return r113;
    L66:
        if (r27.intValue() != 28006069) goto L69;
        Bundle r114 = new Bundle();     // Catch: Exception -> L78
        r114.putBoolean("is_size_limit", true);     // Catch: Exception -> L78
        return r114;
    L53:
        r23 = "";
    L78:
        e = move-exception;
        ALogger.d("OnInstantPlayUploadProgressEventListener", "request exception " + e.getMessage());
        Bundle r115 = new Bundle();
        r115.putBoolean("is_server_success", false);
        return r115;
    L41:
        r17 = "";
    L81:
        Bundle r116 = new Bundle();
        r116.putBoolean("is_toggle", false);
        return r116;
    L83:
        Bundle r117 = new Bundle();
        r117.putBoolean("is_open", false);
        return r117;
    L15:
        r6 = true;
        goto L16
    L5:
        r4 = null;
        goto L7
    }
}
