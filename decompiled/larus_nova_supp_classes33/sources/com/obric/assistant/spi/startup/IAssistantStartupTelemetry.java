package com.obric.assistant.spi.startup;

import android.os.SystemClock;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JP\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH&J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H&J\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\fH&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u0003H&J\"\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0018H&J&\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016J@\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH&J@\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\n\u0010 \u001a\u0004\u0018\u00010\u0003H&¨\u0006!"}, d2 = {"Lcom/obric/assistant/spi/startup/IAssistantStartupTelemetry;", "", "begin", "", "spec", "Lcom/obric/assistant/spi/startup/AssistantStartupAttemptSpec;", "updateAttempt", "", "attemptId", "action", "target", "requiredMilestones", "", "attributes", "", "replaceRequiredMilestone", "oldMilestone", "newMilestone", "addRequiredMilestones", "milestones", "activeAttemptIdRequiring", "milestone", "markReady", "timestampElapsedRealtimeMs", "", "markFirstFrame", "source", "finish", WindowEvent.Params.RESULT, WindowEvent.Params.REASON, "reportDetachedResult", "discard", "activeAttemptId", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAssistantStartupTelemetry {

    public static final class a {
        public static /* synthetic */ void b(AssistantStartupTelemetry r3, String r4) {
            r3.k(r4, SystemClock.elapsedRealtime(), "main_view");
        }

        public static /* synthetic */ boolean c(AssistantStartupTelemetry r2, String r3, String r4) {
            return r2.d(r3, r4, SystemClock.elapsedRealtime());
        }

        public static /* synthetic */ boolean d(AssistantStartupTelemetry r7, uga.a r8, String r9, String r10) {
            return r7.e(r8, r9, r10, SystemClock.elapsedRealtime(), MapsKt.emptyMap());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean a(IAssistantStartupTelemetry r9, String r10, String r11, String r12, Map r13, int r14) {
            if ((r14 & 8) == 0) goto L5;
            long r0 = SystemClock.elapsedRealtime();
        L6:
            long r6 = r0;
            if ((r14 & 16) == 0) goto L10;
            r13 = MapsKt.emptyMap();
        L10:
            return r9.j(r10, r11, r12, r6, r13);
        L5:
            r0 = 0;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void e(AssistantStartupTelemetry r6, String r7, String r8, Set r9, Map r10, int r11) {
            if ((r11 & 4) == 0) goto L5;
            String r3 = null;
        L7:
            if ((r11 & 8) == 0) goto L9;
            Set r4 = null;
        L11:
            if ((r11 & 16) == 0) goto L13;
            r10 = MapsKt.emptyMap();
        L13:
            r6.g(r7, null, r3, r4, r10);
            return;
        L9:
            r4 = r9;
            goto L11
        L5:
            r3 = r8;
            goto L7
        }
    }

    String a(uga.a r1);

    boolean b(String r1, Set<String> r2);

    boolean c(String r1, String r2, String r3);

    boolean d(String r1, String r2, long r3);

    boolean e(uga.a r1, String r2, String r3, long r4, Map<String, String> r6);

    boolean f(String r1);

    boolean g(String r1, String r2, String r3, Set<String> r4, Map<String, String> r5);

    String h();

    String i(String r1);

    boolean j(String r1, String r2, String r3, long r4, Map<String, String> r6);

    boolean k(String r1, long r2, String r4);
}
