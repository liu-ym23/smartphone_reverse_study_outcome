package com.larus.dispatcher.askhuman.handler;

import com.larus.browsertakeover.api.BrowserTakeoverOpenResult;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class BrowserTakeoverEntryMonitor {
    public static final /* synthetic */ int e = 0;
    public final String a;
    public final String b;
    public final AtomicBoolean c;
    public BrowserTakeoverOpenResult d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/larus/dispatcher/askhuman/handler/BrowserTakeoverEntryMonitor$Reason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NONE", "ALREADY_OPEN", "PC_UNAVAILABLE", "ACTIVITY_UNAVAILABLE", "INVALID_REQUEST", "TARGET_UNAVAILABLE", "DEVICE_ID_MISSING", "INVALID_APP_ID", "DEVICE_CACHE_ERROR", "DEVICE_CACHE_MISSING", "DEVICE_NOT_FOUND", "DEVICE_AMBIGUOUS", "DEVICE_OFFLINE", "NOT_AUTHORIZED", "CONTROL_DISABLED", "CAPABILITY_MISSING", "EXPERIMENT_DISABLED", "TARGET_DISABLED", "SESSION_BUSY", "PAGE_OPEN_FAILED", "SERVICE_UNAVAILABLE", "OPEN_REJECTED", "PC_GUIDE_UNAVAILABLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Reason extends Enum<Reason> {
        public static final Reason ACTIVITY_UNAVAILABLE = null;
        public static final Reason ALREADY_OPEN = null;
        public static final Reason CAPABILITY_MISSING = null;
        public static final Reason CONTROL_DISABLED = null;
        public static final Reason DEVICE_AMBIGUOUS = null;
        public static final Reason DEVICE_CACHE_ERROR = null;
        public static final Reason DEVICE_CACHE_MISSING = null;
        public static final Reason DEVICE_ID_MISSING = null;
        public static final Reason DEVICE_NOT_FOUND = null;
        public static final Reason DEVICE_OFFLINE = null;
        public static final Reason EXPERIMENT_DISABLED = null;
        public static final Reason INVALID_APP_ID = null;
        public static final Reason INVALID_REQUEST = null;
        public static final Reason NONE = null;
        public static final Reason NOT_AUTHORIZED = null;
        public static final Reason OPEN_REJECTED = null;
        public static final Reason PAGE_OPEN_FAILED = null;
        public static final Reason PC_GUIDE_UNAVAILABLE = null;
        public static final Reason PC_UNAVAILABLE = null;
        public static final Reason SERVICE_UNAVAILABLE = null;
        public static final Reason SESSION_BUSY = null;
        public static final Reason TARGET_DISABLED = null;
        public static final Reason TARGET_UNAVAILABLE = null;
        public static final /* synthetic */ Reason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<Reason> getEntries() {
            return b;
        }

        static {
            Reason r0 = new Reason("NONE", 0, "none");
            NONE = r0;
            Reason r1 = new Reason("ALREADY_OPEN", 1, "already_open");
            ALREADY_OPEN = r1;
            Reason r2 = new Reason("PC_UNAVAILABLE", 2, "pc_unavailable");
            PC_UNAVAILABLE = r2;
            Reason r4 = new Reason("ACTIVITY_UNAVAILABLE", 3, "activity_unavailable");
            ACTIVITY_UNAVAILABLE = r4;
            Reason r6 = new Reason("INVALID_REQUEST", 4, "invalid_request");
            INVALID_REQUEST = r6;
            Reason r8 = new Reason("TARGET_UNAVAILABLE", 5, "target_unavailable");
            TARGET_UNAVAILABLE = r8;
            Reason r10 = new Reason("DEVICE_ID_MISSING", 6, "device_id_missing");
            DEVICE_ID_MISSING = r10;
            Reason r12 = new Reason("INVALID_APP_ID", 7, "invalid_app_id");
            INVALID_APP_ID = r12;
            Reason r14 = new Reason("DEVICE_CACHE_ERROR", 8, "device_cache_error");
            DEVICE_CACHE_ERROR = r14;
            Reason r13 = new Reason("DEVICE_CACHE_MISSING", 9, "device_cache_missing");
            DEVICE_CACHE_MISSING = r13;
            Reason r11 = new Reason("DEVICE_NOT_FOUND", 10, "device_not_found");
            DEVICE_NOT_FOUND = r11;
            Reason r9 = new Reason("DEVICE_AMBIGUOUS", 11, "device_ambiguous");
            DEVICE_AMBIGUOUS = r9;
            Reason r7 = new Reason("DEVICE_OFFLINE", 12, "device_offline");
            DEVICE_OFFLINE = r7;
            Reason r5 = new Reason("NOT_AUTHORIZED", 13, "not_authorized");
            NOT_AUTHORIZED = r5;
            Reason r3 = new Reason("CONTROL_DISABLED", 14, "control_disabled");
            CONTROL_DISABLED = r3;
            Reason r15 = new Reason("CAPABILITY_MISSING", 15, "capability_missing");
            CAPABILITY_MISSING = r15;
            Reason r16 = new Reason("EXPERIMENT_DISABLED", 16, "experiment_disabled");
            EXPERIMENT_DISABLED = r16;
            Reason r17 = new Reason("TARGET_DISABLED", 17, "target_disabled");
            TARGET_DISABLED = r17;
            Reason r18 = new Reason("SESSION_BUSY", 18, "session_busy");
            SESSION_BUSY = r18;
            Reason r20 = new Reason("PAGE_OPEN_FAILED", 19, "page_open_failed");
            PAGE_OPEN_FAILED = r20;
            Reason r21 = new Reason("SERVICE_UNAVAILABLE", 20, "service_unavailable");
            SERVICE_UNAVAILABLE = r21;
            Reason r22 = new Reason("OPEN_REJECTED", 21, "open_rejected");
            OPEN_REJECTED = r22;
            Reason r23 = new Reason("PC_GUIDE_UNAVAILABLE", 22, "pc_guide_unavailable");
            PC_GUIDE_UNAVAILABLE = r23;
            Reason[] r24 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16, r17, r18, r20, r21, r22, r23};
            a = r24;
            b = EnumEntriesKt.enumEntries(r24);
        }

        public static Reason[] values() {
            return (Reason[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static Reason valueOf(String r1) {
            return (Reason) r27.a.a(Reason.class, r1);
        }

        public Reason(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BrowserTakeoverOpenResult.values().length];
            r0[BrowserTakeoverOpenResult.ACTIVITY_UNAVAILABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[BrowserTakeoverOpenResult.EXPERIMENT_DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[BrowserTakeoverOpenResult.TARGET_DISABLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[BrowserTakeoverOpenResult.INVALID_REQUEST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[BrowserTakeoverOpenResult.SESSION_BUSY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[BrowserTakeoverOpenResult.PAGE_OPEN_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[BrowserTakeoverOpenResult.SERVICE_UNAVAILABLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
    }

    public BrowserTakeoverEntryMonitor(String r2) {
        this.a = r2;
        this.b = UUID.randomUUID().toString();
        this.c = new AtomicBoolean(false);
    }

    public final void a(boolean r2, Reason r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        if (r2 == false) goto L5;
        String r0 = "fallback";
    L6:
        if (r2 == true) goto L9;
        r3 = Reason.PC_GUIDE_UNAVAILABLE;
    L9:
        b(r0, r3);
        return;
    L5:
        r0 = "fail";
        goto L6
    }

    public final void b(String r6, Reason r7) {
        if (this.c.compareAndSet(false, true) == true) goto L13;
        return;
    L13:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        com.larus.platform.service.o r1 = com.larus.platform.service.o.a;     // Catch: Throwable -> L10
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L10
        String r3 = this.a;     // Catch: Throwable -> L10
        if (r3 == null) goto L8;
        r2.put("target", r3);     // Catch: Throwable -> L10
    L8:
        r2.put("result", r6);     // Catch: Throwable -> L10
        r2.put("reason", r7.getValue());     // Catch: Throwable -> L10
        r2.put("takeover_id", this.b);     // Catch: Throwable -> L10
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r1.reportEvent("browser_takeover_entry", r2);     // Catch: Throwable -> L10
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
