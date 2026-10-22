package com.obric.assistant.activation.presentation.runtime.precheck;

import android.content.Context;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricChildListeningPrecheck {
    public final Function0<fba.b> a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/activation/presentation/runtime/precheck/ObricChildListeningPrecheck$Reason;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "NONE", "HOST_STATE_MISSING", "NOT_LOGGED_IN", "USER_GUIDE_NOT_COMPLETED", "SCREEN_OFF_DISABLED", "SCREEN_LANDSCAPE", "IN_CALL", "MIC_PERMISSION_MISSING", "MIC_IN_USE", "NETWORK_UNAVAILABLE", "KEYGUARD_BLOCKED", "OVERLAY_PERMISSION_MISSING", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Reason extends Enum<Reason> {
        public static final Reason HOST_STATE_MISSING = null;
        public static final Reason IN_CALL = null;
        public static final Reason KEYGUARD_BLOCKED = null;
        public static final Reason MIC_IN_USE = null;
        public static final Reason MIC_PERMISSION_MISSING = null;
        public static final Reason NETWORK_UNAVAILABLE = null;
        public static final Reason NONE = null;
        public static final Reason NOT_LOGGED_IN = null;
        public static final Reason OVERLAY_PERMISSION_MISSING = null;
        public static final Reason SCREEN_LANDSCAPE = null;
        public static final Reason SCREEN_OFF_DISABLED = null;
        public static final Reason USER_GUIDE_NOT_COMPLETED = null;
        public static final /* synthetic */ Reason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Reason> getEntries() {
            return b;
        }

        static {
            Reason r0 = new Reason("NONE", 0);
            NONE = r0;
            Reason r1 = new Reason("HOST_STATE_MISSING", 1);
            HOST_STATE_MISSING = r1;
            Reason r3 = new Reason("NOT_LOGGED_IN", 2);
            NOT_LOGGED_IN = r3;
            Reason r5 = new Reason("USER_GUIDE_NOT_COMPLETED", 3);
            USER_GUIDE_NOT_COMPLETED = r5;
            Reason r7 = new Reason("SCREEN_OFF_DISABLED", 4);
            SCREEN_OFF_DISABLED = r7;
            Reason r9 = new Reason("SCREEN_LANDSCAPE", 5);
            SCREEN_LANDSCAPE = r9;
            Reason r11 = new Reason("IN_CALL", 6);
            IN_CALL = r11;
            Reason r13 = new Reason("MIC_PERMISSION_MISSING", 7);
            MIC_PERMISSION_MISSING = r13;
            Reason r15 = new Reason("MIC_IN_USE", 8);
            MIC_IN_USE = r15;
            Reason r14 = new Reason("NETWORK_UNAVAILABLE", 9);
            NETWORK_UNAVAILABLE = r14;
            Reason r12 = new Reason("KEYGUARD_BLOCKED", 10);
            KEYGUARD_BLOCKED = r12;
            Reason r10 = new Reason("OVERLAY_PERMISSION_MISSING", 11);
            OVERLAY_PERMISSION_MISSING = r10;
            Reason[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
        }

        public static Reason[] values() {
            return (Reason[]) a.clone();
        }

        public static Reason valueOf(String r1) {
            return (Reason) r27.a.a(Reason.class, r1);
        }

        public Reason(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/activation/presentation/runtime/precheck/ObricChildListeningPrecheck$Status;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "NOT_STARTED", "PASSED", "BLOCKED", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final Status BLOCKED = null;
        public static final Status NOT_STARTED = null;
        public static final Status PASSED = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("NOT_STARTED", 0);
            NOT_STARTED = r0;
            Status r1 = new Status("PASSED", 1);
            PASSED = r1;
            Status r3 = new Status("BLOCKED", 2);
            BLOCKED = r3;
            Status[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public static final b c = null;
        public static final b d = null;
        public final Status a;
        public final Reason b;

        public static final class a {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Result(status=" + this.a + ", reason=" + this.b + ')';
        }

        static {
            c = new b(Status.NOT_STARTED);
            d = new b(Status.PASSED);
        }

        public /* synthetic */ b(Status r2) {
            this(r2, Reason.NONE);
        }

        public b(Status r2, Reason r3) {
            Intrinsics.checkNotNullParameter(r2, "status");
            Intrinsics.checkNotNullParameter(r3, "reason");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public ObricChildListeningPrecheck() {
        throw null;
    }

    public ObricChildListeningPrecheck(final Context r3) {
        Function0<fba.b> r0 = new fba.a(r3);
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r0, "runtimeFactsProvider");
        this.a = r0;
    }
}
