package com.obric.assistant.spi.startup;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uga.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0001H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016JH\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012H\u0016J \u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u001e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J \u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\"\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0016J<\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012H\u0016J<\u0010\"\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012H\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010'\u001a\u0002H&2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0082\b¢\u0006\u0002\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/assistant/spi/startup/AssistantStartupTelemetry;", "Lcom/obric/assistant/spi/startup/IAssistantStartupTelemetry;", "<init>", "()V", "TAG", "", "service", "begin", "spec", "Lcom/obric/assistant/spi/startup/AssistantStartupAttemptSpec;", "updateAttempt", "", "attemptId", "action", "target", "requiredMilestones", "", "attributes", "", "replaceRequiredMilestone", "oldMilestone", "newMilestone", "addRequiredMilestones", "milestones", "activeAttemptIdRequiring", "milestone", "markReady", "timestampElapsedRealtimeMs", "", "markFirstFrame", "source", "finish", WindowEvent.Params.RESULT, WindowEvent.Params.REASON, "reportDetachedResult", "discard", "activeAttemptId", "safely", "T", "fallback", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantStartupTelemetry implements IAssistantStartupTelemetry {
    public static final AssistantStartupTelemetry a = null;

    static {
        a = new AssistantStartupTelemetry();
    }

    private AssistantStartupTelemetry() {
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final String h() {
        a.getClass();     // Catch: Exception -> L4 CancellationException -> L6
    L10:
        return l().h();
    L6:
        e = move-exception;
        throw e;
    L4:
        return null;
    }

    public static IAssistantStartupTelemetry l() {
        return (IAssistantStartupTelemetry) ServiceManager.get().getService(IAssistantStartupTelemetry.class);
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final String a(a r4) {
        Intrinsics.checkNotNullParameter(r4, "spec");
        String r1 = r4.a;
        if (r1 != null) goto L5;
    L9:
        r1 = UUID.randomUUID().toString();
    L29:
        a.getClass();     // Catch: Exception -> L12 CancellationException -> L25
        String r5 = l().a(a.a(r4, r1));     // Catch: Exception -> L12 CancellationException -> L25
    L14:
        if ((!StringsKt.isBlank(r5)) == true) goto L16;
    L24:
        return r5;
    L16:
        if (Intrinsics.areEqual(r5, r1) == true) goto L24;
        a.getClass();     // Catch: Exception -> L27 CancellationException -> L22
        l().f(r1);     // Catch: Exception -> L27 CancellationException -> L22
    L22:
        e = move-exception;
        throw e;
    L33:
        a.getClass();     // Catch: Exception -> L28 CancellationException -> L20
        l().f(r5);     // Catch: Exception -> L28 CancellationException -> L20
    L20:
        e = move-exception;
        throw e;
    L19:
        return "";
    L25:
        e = move-exception;
        throw e;
    L12:
        r5 = "";
        goto L14
    L5:
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 != null) goto L29;
        goto L9
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "attemptId");
        a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().f(r2);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final String i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "milestone");
        a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().i(r2);
    L7:
        e = move-exception;
        throw e;
    L5:
        return null;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean b(String r2, Set<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "attemptId");
        Intrinsics.checkNotNullParameter(r3, "milestones");
        a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().b(r2, r3);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean c(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "attemptId");
        Intrinsics.checkNotNullParameter(r3, "oldMilestone");
        Intrinsics.checkNotNullParameter(r4, "newMilestone");
        a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().c(r2, r3, r4);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean d(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "attemptId");
        Intrinsics.checkNotNullParameter(r3, "milestone");
        a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().d(r2, r3, r4);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean k(String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "attemptId");
        a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().k(r2, r3, r5);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean e(a r9, String r10, String r11, long r12, Map<String, String> r14) {
        Intrinsics.checkNotNullParameter(r9, "spec");
        Intrinsics.checkNotNullParameter(r10, WindowEvent.Params.RESULT);
        Intrinsics.checkNotNullParameter(r11, WindowEvent.Params.REASON);
        Intrinsics.checkNotNullParameter(r14, "attributes");
        a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().e(r9, r10, r11, r12, r14);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean g(String r8, String r9, String r10, Set<String> r11, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r8, "attemptId");
        Intrinsics.checkNotNullParameter(r12, "attributes");
        a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().g(r8, r9, r10, r11, r12);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean j(String r9, String r10, String r11, long r12, Map<String, String> r14) {
        Intrinsics.checkNotNullParameter(r9, "attemptId");
        Intrinsics.checkNotNullParameter(r10, WindowEvent.Params.RESULT);
        Intrinsics.checkNotNullParameter(r11, WindowEvent.Params.REASON);
        Intrinsics.checkNotNullParameter(r14, "attributes");
        a.getClass();     // Catch: Exception -> L5 CancellationException -> L7
    L11:
        return l().j(r9, r10, r11, r12, r14);
    L7:
        e = move-exception;
        throw e;
    L5:
        return false;
    }
}
