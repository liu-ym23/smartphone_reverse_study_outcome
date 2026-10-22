package qvb;

import com.larksuite.framework.utils.NetworkUtils;
import com.larksuite.framework.utils.k0;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.i;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final a a = null;
    public static final AtomicReference<C0181a> b = null;
    public static final Set<String> c = null;

    /* JADX INFO: renamed from: qvb.a$a, reason: collision with other inner class name */
    public static final class C0181a {
        public final String a;
        public final MmRecordingCommonParam b;
        public final String c;
        public final String d;
        public final RecordingSessionType e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0181a) == true) goto L8;
            return false;
        L8:
            C0181a r6 = (C0181a) r5;
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
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            RecordingSessionType r1 = this.e;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "AlertContext(sessionId=" + this.a + ", commonParam=" + this.b + ", conversationId=" + this.c + ", messageId=" + this.d + ", sessionType=" + this.e + ')';
        }

        public C0181a(String r2, MmRecordingCommonParam r3, String r4, String r5, RecordingSessionType r6) {
            Intrinsics.checkNotNullParameter(r2, "sessionId");
            Intrinsics.checkNotNullParameter(r3, "commonParam");
            Intrinsics.checkNotNullParameter(r4, "conversationId");
            Intrinsics.checkNotNullParameter(r5, "messageId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = new AtomicReference(null);
        c = SetsKt.setOf(new String[]{"rtc", "audio", "upload"});
    }

    public final void h(String r16) {
        if (r16 != null) goto L5;
        String r4 = "";
    L6:
        c(this, "subtitle", "error", null, r4, null, null, null, null, null, null, null, Boolean.valueOf(NetworkUtils.d(LarkContext.getApplication())), null, 6132);
        return;
    L5:
        r4 = r16;
        goto L6
    }

    public static void a(String r8, MmRecordingCommonParam r9, DoubaoBizInfo r10, RecordingSessionType r11) {
        Intrinsics.checkNotNullParameter(r8, "sessionId");
        Intrinsics.checkNotNullParameter(r9, "commonParam");
        AtomicReference<C0181a> r0 = b;
        String r1 = null;
        if (r10 == null) goto L5;
        String r2 = r10.getConversationId();
    L7:
        if (r2 != null) goto L9;
        String r4 = "";
    L10:
        if (r10 == null) goto L12;
        r1 = r10.getMessageId();
    L12:
        if (r1 != null) goto L14;
        String r5 = "";
    L15:
        r0.set(new C0181a(r8, r9, r4, r5, r11));
        return;
    L14:
        r5 = r1;
        goto L15
    L9:
        r4 = r2;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public static void g(String r15, String r16, String r17, int r18) {
        a r0 = a;
        if ((r18 & 4) == 0) goto L5;
        String r5 = "";
    L7:
        if ((r18 & 8) == 0) goto L9;
        String r2 = "error";
    L10:
        Intrinsics.checkNotNullParameter(r15, "errorMsg");
        Intrinsics.checkNotNullParameter(r5, "responseName");
        Intrinsics.checkNotNullParameter(r2, "severity");
        c(r0, "state_sync", r2, null, r15, r5, null, null, null, null, null, null, Boolean.valueOf(NetworkUtils.d(LarkContext.getApplication())), null, 6112);
        return;
    L9:
        r2 = r17;
        goto L10
    L5:
        r5 = r16;
        goto L7
    }

    public final void d(Integer r17, String r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r18, "errorMsg");
        Intrinsics.checkNotNullParameter(r19, "responseName");
        Intrinsics.checkNotNullParameter(r20, "severity");
        c(this, "entry", r20, r17, r18, r19, null, null, null, null, null, null, Boolean.valueOf(NetworkUtils.d(LarkContext.getApplication())), null, 6112);
    }

    public static void b(Integer r15, String r16, String r17, String r18, int r19) {
        a r0 = a;
        if ((r19 & 1) == 0) goto L5;
        Integer r3 = null;
    L7:
        if ((r19 & 4) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r19 & 8) == 0) goto L13;
        String r2 = "error";
    L14:
        Intrinsics.checkNotNullParameter(r16, "errorMsg");
        Intrinsics.checkNotNullParameter(r5, "responseName");
        Intrinsics.checkNotNullParameter(r2, "severity");
        c(r0, "audio", r2, r3, r16, r5, null, null, null, null, null, null, Boolean.valueOf(NetworkUtils.d(LarkContext.getApplication())), null, 6112);
        return;
    L13:
        r2 = r18;
        goto L14
    L9:
        r5 = r17;
        goto L11
    L5:
        r3 = r15;
        goto L7
    }

    public static /* synthetic */ void e(Integer r2, String r3, String r4, String r5, int r6) {
        a r0 = a;
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = "";
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = "warn";
    L11:
        r0.d(r2, r3, r4, r5);
    }

    public final void f(String r17, Integer r18, Integer r19, String r20, Integer r21, String r22) {
        Intrinsics.checkNotNullParameter(r17, "requestPath");
        Intrinsics.checkNotNullParameter(r22, "errorMessage");
        boolean r0 = NetworkUtils.d(LarkContext.getApplication());
        if (r20 != null) goto L5;
        String r10 = "";
    L6:
        c(this, "request", "error", null, null, null, r17, r18, r19, r10, r21, r22, Boolean.valueOf(r0), null, 4124);
        return;
    L5:
        r10 = r20;
        goto L6
    }

    public static void c(a r33, String r34, String r35, Integer r36, String r37, String r38, String r39, Integer r40, Integer r41, String r42, Integer r43, String r44, Boolean r45, Long r46, int r47) {
        if ((r47 & 4) == 0) goto L5;
        Integer r4 = null;
    L7:
        if ((r47 & 8) == 0) goto L9;
        String r6 = "";
    L11:
        if ((r47 & 16) == 0) goto L13;
        String r13 = "";
    L15:
        if ((r47 & 32) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r47 & 64) == 0) goto L21;
        Integer r8 = null;
    L23:
        if ((r47 & 128) == 0) goto L25;
        Integer r9 = null;
    L27:
        if ((r47 & 256) == 0) goto L29;
        String r10 = "";
    L31:
        if ((r47 & 512) == 0) goto L33;
        Integer r11 = null;
    L35:
        if ((r47 & 1024) == 0) goto L37;
        String r12 = "";
    L39:
        if ((r47 & 2048) == 0) goto L41;
        Boolean r14 = null;
    L43:
        if ((r47 & 4096) == 0) goto L45;
        Long r15 = null;
    L46:
        r33.getClass();
        C0181a r0 = b.get();
        if (r0 != null) goto L51;
        r0 = new C0181a("", new MmRecordingCommonParam(null, null, false, null, null, null, k0.a(16), null, null, null, null, 1983, null), "", "", null);
        lvb.a.h("MmRecordingErrorTracker", "[createFallbackAlertContext] context missing, fallbackTraceId=" + r0.b.getRecordingTraceId());
    L51:
        if (r0.e == RecordingSessionType.PRE_MEETING_NATIVE_RECORDING) goto L53;
    L55:
        List<String> r1 = i.b;
        MmRecordingCommonParam r2 = r0.b;
        MmRecordingSource r3 = r2.getSource();
        if (r3 == null) goto L58;
        String r5 = r3.getValue();
    L59:
        if (r5 != null) goto L61;
        String r16 = "";
    L62:
        i.a.c(r2, r16, r34, r35, r4, r6, r7, r8, r9, r10, r11, r12, r14, r13, r15, 24576);
        return;
    L61:
        r16 = r5;
        goto L62
    L58:
        r5 = null;
        goto L59
    L53:
        if (c.contains(r34) == true) goto L55;
        lvb.a.e("MmRecordingErrorTracker", "[trackContextException] skip pre-meeting diagnosis, stage=" + r34 + ", errorMsg=" + r6);
        return;
    L45:
        r15 = r46;
        goto L46
    L41:
        r14 = r45;
        goto L43
    L37:
        r12 = r44;
        goto L39
    L33:
        r11 = r43;
        goto L35
    L29:
        r10 = r42;
        goto L31
    L25:
        r9 = r41;
        goto L27
    L21:
        r8 = r40;
        goto L23
    L17:
        r7 = r39;
        goto L19
    L13:
        r13 = r38;
        goto L15
    L9:
        r6 = r37;
        goto L11
    L5:
        r4 = r36;
        goto L7
    }
}
