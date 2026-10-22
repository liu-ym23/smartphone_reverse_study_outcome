package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.gl;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m1 {
    public static final void a(LivePlayerWidget r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$changeSrState");
        Pair<Integer, Integer> r0 = r3.P1;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r3.Q1 != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNull(r0);
        int r1 = ((Number) r0.getFirst()).intValue();
        Pair<Integer, Integer> r2 = r3.Q1;
        Intrinsics.checkNotNull(r2);
        if (r1 > ((Number) r2.getFirst()).intValue()) goto L19;
        Pair<Integer, Integer> r4 = r3.P1;
        Intrinsics.checkNotNull(r4);
        int r5 = ((Number) r4.getSecond()).intValue();
        Pair<Integer, Integer> r6 = r3.Q1;
        Intrinsics.checkNotNull(r6);
        if (r5 > ((Number) r6.getSecond()).intValue()) goto L19;
        AbsLivePlayerView r7 = r3.R8();
        if (r7 == null) goto L18;
        ILivePlayerClient r8 = r7.getClient();
        if (r8 == null) goto L18;
        r8.setEnableSr(true);
    L18:
        ALogger.d("VerticleSrOptimize", "开启超分");
        return;
    L19:
        AbsLivePlayerView r9 = r3.R8();
        if (r9 == null) goto L24;
        ILivePlayerClient r10 = r9.getClient();
        if (r10 == null) goto L24;
        r10.setEnableSr(false);
    L24:
        ALogger.d("VerticleSrOptimize", "关闭超分");
    }

    public static final boolean b(LivePlayerWidget r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$enableVerticalSrOptimize");
        if (PadConfigUtils.c() == false) goto L5;
        return false;
    L5:
        Integer r0 = (Integer) gl.a.getValue();
        if (r0 != null) goto L9;
    L11:
        if (r0 != null) goto L14;
        return false;
    L14:
        if (r0.intValue() != 1) goto L20;
        Room r6 = r5.U2.w();
        if (r6 != null) goto L18;
        return false;
    L18:
        return r6.isMergeVSRoom();
    L20:
        return false;
    L9:
        if (r0.intValue() != 2) goto L11;
        return true;
    }

    public static final void c(LivePlayerWidget r2, Pair<Integer, Integer> r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$handleViewSizeChange");
        Intrinsics.checkNotNullParameter(r3, "size");
        if (((Number) r3.getFirst()).intValue() > 0) goto L5;
        return;
    L5:
        if (((Number) r3.getSecond()).intValue() <= 0) goto L10;
        r2.Q1 = r3;
        ALogger.d("VerticleSrOptimize", "handleViewSizeChange=" + r3 + ",ori=" + r4);
        a(r2);
        return;
    }
}
