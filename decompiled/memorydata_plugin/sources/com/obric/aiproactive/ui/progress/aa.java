package com.obric.aiproactive.ui.progress;

import com.ttnet.org.chromium.base.TimeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH\u0000¨\u0006\u000e"}, d2 = {"buildAgentRunControlsUi", "Lcom/obric/aiproactive/ui/progress/AgentRunControlsUi;", "runState", "", "supportsCancel", "", "buildAgentRunHeaderUi", "Lcom/obric/aiproactive/ui/progress/AgentRunHeaderUi;", "run", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "nowMillis", "", "formatAgentRunDuration", "durationMillis", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class aa {
    public static final b a(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "runState");
        boolean r1 = false;
        if (Intrinsics.areEqual(r3, "running") == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        if (r4 == false) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L16;
        AgentRunStatusAction r6 = AgentRunStatusAction.STOP;
    L29:
        if (r6 == AgentRunStatusAction.HIDDEN) goto L32;
        r1 = true;
    L32:
        return new b(r1, r6);
    L16:
        if (Intrinsics.areEqual(r3, "succeeded") == false) goto L19;
        r6 = AgentRunStatusAction.COMPLETED;
        goto L29
    L19:
        if (Intrinsics.areEqual(r3, "failed") == false) goto L21;
    L27:
        r6 = AgentRunStatusAction.FAILED;
        goto L29
    L21:
        if (Intrinsics.areEqual(r3, "timed_out") == true) goto L27;
        if (Intrinsics.areEqual(r3, "cancelled") == false) goto L26;
        r6 = AgentRunStatusAction.STOPPED;
        goto L29
    L26:
        r6 = AgentRunStatusAction.HIDDEN;
    L12:
        r5 = false;
        goto L13
    L5:
        if (Intrinsics.areEqual(r3, "waiting") == true) goto L8;
        r0 = false;
        goto L9
    }

    public static final g a(com.obric.aiproactive.api.g r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "run");
        String r0 = r2.c();
        if (Intrinsics.areEqual(r0, "running") == true) goto L9;
        if (Intrinsics.areEqual(r0, "waiting") == true) goto L9;
        r3 = r2.e();
    L9:
        return new g("任务详情", "豆包手机助手 · 耗时" + a(RangesKt.coerceAtLeast(r3 - r2.d(), 0)));
    }

    public static final String a(long r8) {
        long r9 = RangesKt.coerceAtLeast(r8, 0) / 1000;
        long r4 = r9 / TimeUtils.SECONDS_PER_HOUR;
        long r2 = (r9 % TimeUtils.SECONDS_PER_HOUR) / 60;
        long r10 = r9 % 60;
        if (r4 <= 0) goto L7;
        StringBuilder r11 = new StringBuilder().append(r4).append("小时").append(r2).append(20998);
    L11:
        return r11.toString();
    L7:
        if (r2 <= 0) goto L9;
        StringBuilder r0 = new StringBuilder().append(r2).append(20998);
    L10:
        r11 = r0.append(r10).append(31186);
        goto L11
    L9:
        r0 = new StringBuilder();
        goto L10
    }
}
