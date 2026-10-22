package com.obric.assistant.spi.startup;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uga.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016JH\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010H\u0016J \u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u001e\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J \u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\"\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0016J<\u0010\u001d\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010H\u0016J<\u0010 \u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006#"}, d2 = {"Lcom/obric/assistant/spi/startup/DefaultAssistantStartupTelemetry;", "Lcom/obric/assistant/spi/startup/IAssistantStartupTelemetry;", "<init>", "()V", "begin", "", "spec", "Lcom/obric/assistant/spi/startup/AssistantStartupAttemptSpec;", "updateAttempt", "", "attemptId", "action", "target", "requiredMilestones", "", "attributes", "", "replaceRequiredMilestone", "oldMilestone", "newMilestone", "addRequiredMilestones", "milestones", "activeAttemptIdRequiring", "milestone", "markReady", "timestampElapsedRealtimeMs", "", "markFirstFrame", "source", "finish", WindowEvent.Params.RESULT, WindowEvent.Params.REASON, "reportDetachedResult", "discard", "activeAttemptId", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultAssistantStartupTelemetry implements IAssistantStartupTelemetry {
    public DefaultAssistantStartupTelemetry() {
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final String a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        return "";
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean b(String r2, Set<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "attemptId");
        Intrinsics.checkNotNullParameter(r3, "milestones");
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean c(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "attemptId");
        Intrinsics.checkNotNullParameter(r3, "oldMilestone");
        Intrinsics.checkNotNullParameter(r4, "newMilestone");
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean d(String r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "attemptId");
        Intrinsics.checkNotNullParameter(r2, "milestone");
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean e(a r1, String r2, String r3, long r4, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r1, "spec");
        Intrinsics.checkNotNullParameter(r2, WindowEvent.Params.RESULT);
        Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.REASON);
        Intrinsics.checkNotNullParameter(r6, "attributes");
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "attemptId");
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean g(String r1, String r2, String r3, Set<String> r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r1, "attemptId");
        Intrinsics.checkNotNullParameter(r5, "attributes");
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final String h() {
        return null;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final String i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "milestone");
        return null;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean j(String r1, String r2, String r3, long r4, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r1, "attemptId");
        Intrinsics.checkNotNullParameter(r2, WindowEvent.Params.RESULT);
        Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.REASON);
        Intrinsics.checkNotNullParameter(r6, "attributes");
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean k(String r1, long r2, String r4) {
        Intrinsics.checkNotNullParameter(r1, "attemptId");
        return false;
    }
}
