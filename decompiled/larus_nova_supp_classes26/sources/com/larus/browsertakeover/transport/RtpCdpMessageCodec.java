package com.larus.browsertakeover.transport;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class RtpCdpMessageCodec {
    public static final RtpCdpMessageCodec a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/browsertakeover/transport/RtpCdpMessageCodec$Reason;", "", "<init>", "(Ljava/lang/String;I)V", "EMPTY", "TOO_LARGE", "INVALID_MJPEG_ENVELOPE", "INVALID_UTF8", "INVALID_JSON", "UNSUPPORTED_ENVELOPE", "INVALID_CDP_EVENT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Reason extends Enum<Reason> {
        public static final Reason EMPTY = null;
        public static final Reason INVALID_CDP_EVENT = null;
        public static final Reason INVALID_JSON = null;
        public static final Reason INVALID_MJPEG_ENVELOPE = null;
        public static final Reason INVALID_UTF8 = null;
        public static final Reason TOO_LARGE = null;
        public static final Reason UNSUPPORTED_ENVELOPE = null;
        public static final /* synthetic */ Reason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Reason> getEntries() {
            return b;
        }

        static {
            Reason r0 = new Reason("EMPTY", 0);
            EMPTY = r0;
            Reason r1 = new Reason("TOO_LARGE", 1);
            TOO_LARGE = r1;
            Reason r3 = new Reason("INVALID_MJPEG_ENVELOPE", 2);
            INVALID_MJPEG_ENVELOPE = r3;
            Reason r5 = new Reason("INVALID_UTF8", 3);
            INVALID_UTF8 = r5;
            Reason r7 = new Reason("INVALID_JSON", 4);
            INVALID_JSON = r7;
            Reason r9 = new Reason("UNSUPPORTED_ENVELOPE", 5);
            UNSUPPORTED_ENVELOPE = r9;
            Reason r11 = new Reason("INVALID_CDP_EVENT", 6);
            INVALID_CDP_EVENT = r11;
            Reason[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
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

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.browsertakeover.transport.RtpCdpMessageCodec$a$a, reason: collision with other inner class name */
        public static final class C0070a extends a {
            public final JSONObject a;
            public final String b;

            public C0070a(JSONObject r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "event");
                Intrinsics.checkNotNullParameter(r3, "framing");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class b extends a {
            public final Reason a;

            public b(Reason r2) {
                Intrinsics.checkNotNullParameter(r2, "reason");
                this.a = r2;
            }
        }

        public a() {
        }
    }

    static {
        a = new RtpCdpMessageCodec();
    }

    public RtpCdpMessageCodec() {
    }

    public static boolean a(JSONObject r2) {
        if (r2.has("id") == false) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.opt("method"), "Page.screencastFrame") == false) goto L9;
        if ((r2.opt("params") instanceof JSONObject) == false) goto L9;
        return true;
    }

    public static JSONObject b(String r3) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        JSONTokener r2 = new JSONTokener(r3);     // Catch: Throwable -> L14
        Object r4 = r2.nextValue();     // Catch: Throwable -> L14
        if ((r4 instanceof JSONObject) == false) goto L6;
        JSONObject r5 = (JSONObject) r4;     // Catch: Throwable -> L14
    L7:
        if (r5 != null) goto L10;
    L11:
        r5 = null;
    L12:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r6) == true) goto L21;
        r0 = r6;
    L21:
        return (JSONObject) r0;
    L10:
        if (r2.nextClean() == 0) goto L12;
    L6:
        r5 = null;
    L14:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
