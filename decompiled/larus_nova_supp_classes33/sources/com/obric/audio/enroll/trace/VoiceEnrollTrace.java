package com.obric.audio.enroll.trace;

import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class VoiceEnrollTrace {
    public static final CoroutineScope a = null;
    public static String b;
    public static boolean c;
    public static final Object d = null;
    public static final List<a> e = null;
    public static boolean f;
    public static final b g = null;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            String r1 = this.e;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "PendingEnrollResult(eventName=" + this.a + ", voiceWakeupSwitch=" + this.b + ", audioCollectSwitch=" + this.c + ", isSuccess=" + this.d + ", enterFrom=" + this.e + ')';
        }

        public a(String r2, String r3, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            Intrinsics.checkNotNullParameter(r3, "voiceWakeupSwitch");
            Intrinsics.checkNotNullParameter(r4, "audioCollectSwitch");
            Intrinsics.checkNotNullParameter(r5, "isSuccess");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class b implements f09.a.b {
        public b() {
        }

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
        }

        public final void onAppForeground() {
            CoroutineScope r0 = VoiceEnrollTrace.a;
            Object r1 = VoiceEnrollTrace.d;
            monitor-enter(r1);
            List<a> r2 = VoiceEnrollTrace.e;     // Catch: Throwable -> L15
            if (((ArrayList) r2).isEmpty() == false) goto L7;
            List r3 = CollectionsKt.emptyList();     // Catch: Throwable -> L15
        L9:
            monitor-exit(r1);
            if (r3.isEmpty() == true) goto L19;
            FLogger.a.i("VoiceEnrollTrace", "report pending enroll results when app foreground, size = " + r3.size());
            BuildersKt.launch$default(VoiceEnrollTrace.a, null, null, new VoiceEnrollTrace$reportPendingEnrollResults$1(r3, null), 3, null);
            return;
        L19:
            return;
        L7:
            List r4 = CollectionsKt.toList(r2);     // Catch: Throwable -> L15
            ((ArrayList) r2).clear();     // Catch: Throwable -> L15
            r3 = r4;
        L15:
            th = move-exception;
            throw th;
        }
    }

    public VoiceEnrollTrace() {
    }

    static {
        a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        d = new Object();
        e = new ArrayList();
        g = new b();
    }

    public static final void a(a r3) {
        JSONObject r0 = new JSONObject();
        r0.put("voice_wakeup_switch", r3.b);
        r0.put("audio_collect_switch", r3.c);
        r0.put("is_success", r3.d);
        String r1 = r3.e;
        if (r1 == null) goto L5;
        r0.put("enter_from", r1);
    L5:
        IApplog.a.reportEvent(r3.a, r0);
    }

    public static void c(String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "currentPage");
        if (Intrinsics.areEqual(r12, r11) == false) goto L5;
        return;
    L5:
        if (c == true) goto L10;
        BuildersKt.launch$default(a, null, null, new VoiceEnrollTrace$trackEnterPage$1(r11, r12, r13, null, null), 3, null);
        return;
    }

    public static void d(String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "currentPage");
        FLogger.a.i("VoiceEnrollTrace", "trackPageClick, currentPage = " + r11 + ", actionType = " + r12 + ", enterFrom = " + r13 + ", extraParams = null");
        if (c == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(a, null, null, new VoiceEnrollTrace$trackPageClick$1(r11, r12, r13, null, null), 3, null);
    }

    public static void b(final String r7, String r8, String r9, String r10, String r11) {
        a r6 = new a(r7, r8, r9, r10, r11);
        AppHost.Companion r12 = AppHost.a;
        if (r12.a().isAppBackground() == true) goto L6;
        BuildersKt.launch$default(a, null, null, new VoiceEnrollTrace$reportEnrollResultWhenForeground$1(r6, null), 3, null);
        return;
    L6:
        Object r13 = d;
        monitor-enter(r13);
        List<a> r14 = e;     // Catch: Throwable -> L16
        CollectionsKt.removeAll(r14, new com.obric.audio.enroll.trace.a(r7));     // Catch: Throwable -> L16
        ((ArrayList) r14).add(r6);     // Catch: Throwable -> L16
        if (f == true) goto L12;
        r12.a().j(g);     // Catch: Throwable -> L16
        f = true;     // Catch: Throwable -> L16
    L12:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r13);
        FLogger.a.i("VoiceEnrollTrace", "delay report " + r7 + " until app foreground");
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
