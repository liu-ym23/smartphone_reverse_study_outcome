package com.larus.account.saas.security.internal;

import com.google.gson.annotations.SerializedName;
import com.larus.account.saas.core.internal.network.CommonResponse;
import com.larus.account.saas.security.model.AccountSecurityEventType;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AccountSecurityReporter {
    public final AccountSecurityObservationStore a;
    public final ExecutorService b;
    public final Lazy c;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/larus/account/saas/security/internal/AccountSecurityReporter$a;", "", "", "inObservation", "Z", "b", "()Z", "", "observationRemainingSeconds", "J", "c", "()J", "chatMessageCountThreshold", "a", "account-saas-security_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {

        @SerializedName("chat_message_count_threshold")
        private final long chatMessageCountThreshold;

        @SerializedName("is_in_observation")
        private final boolean inObservation;

        @SerializedName("observation_remaining_seconds")
        private final long observationRemainingSeconds;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.inObservation == r9.inObservation) goto L12;
            return false;
        L12:
            if (this.observationRemainingSeconds == r9.observationRemainingSeconds) goto L15;
            return false;
        L15:
            if (this.chatMessageCountThreshold == r9.chatMessageCountThreshold) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public final int hashCode() {
            boolean r0 = this.inObservation;
            ?? r1 = r0;
            if (r0 == false) goto L5;
            r1 = 1;
        L5:
            long r2 = this.observationRemainingSeconds;
            int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
            long r4 = this.chatMessageCountThreshold;
            return r3 + ((int) (r4 ^ (r4 >>> 32)));
        }

        public final String toString() {
            return "AccountSecurityBehaviorResponse(inObservation=" + this.inObservation + ", observationRemainingSeconds=" + this.observationRemainingSeconds + ", chatMessageCountThreshold=" + this.chatMessageCountThreshold + ')';
        }

        public a() {
            this.inObservation = false;
            this.observationRemainingSeconds = 0;
            this.chatMessageCountThreshold = 0;
        }

        public final long a() {
            return this.chatMessageCountThreshold;
        }

        public final boolean b() {
            return this.inObservation;
        }

        public final long c() {
            return this.observationRemainingSeconds;
        }
    }

    public static final class b {
        public final e48.d a;
        public final Map<String, Object> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "BehaviorReportPlan(event=" + this.a + ", resultExtras=" + this.b + ')';
        }

        public b(e48.d r2, Map<String, ? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Intrinsics.checkNotNullParameter(r3, "resultExtras");
            this.a = r2;
            this.b = r3;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001:\u0001\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/account/saas/security/internal/AccountSecurityReporter$c;", "", "", "code", "I", "getCode", "()I", "setCode", "(I)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "Lcom/larus/account/saas/security/internal/AccountSecurityReporter$a;", "data", "Lcom/larus/account/saas/security/internal/AccountSecurityReporter$a;", "a", "()Lcom/larus/account/saas/security/internal/AccountSecurityReporter$a;", "setData", "(Lcom/larus/account/saas/security/internal/AccountSecurityReporter$a;)V", "payload", "getPayload", "setPayload", "account-saas-security_release"}, k = 1, mv = {1, 7, 1})
    public static final class c {

        @SerializedName("code")
        private int code;

        @SerializedName("data")
        private a data;

        @SerializedName("msg")
        private String msg;

        @SerializedName("payload")
        private String payload;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.code == r6.code) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.msg, r6.msg) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.data, r6.data) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.payload, r6.payload) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.code * 31;
            String r1 = this.msg;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            a r5 = this.data;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.payload;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "CommonResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", payload=" + this.payload + ')';
        }

        public c() {
            this.code = CommonResponse.CODE_UNKNOWN;
            this.msg = "";
            this.data = null;
            this.payload = null;
        }

        public final a a() {
            return this.data;
        }
    }

    public static final class d {
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AccountSecurityEventType.values().length];
            r0[AccountSecurityEventType.BROWSE_EXCESSIVE_CHAT_HISTORY.ordinal()] = 1;
            a = r0;
        }
    }

    static {
    }

    public AccountSecurityReporter(AccountSecurityObservationStore r2) {
        Intrinsics.checkNotNullParameter(r2, "store");
        this.a = r2;
        this.b = PThreadExecutorsUtils.newSingleThreadExecutor(new g());
        this.c = LazyKt.lazy(AccountSecurityReporter$isReportEnabled$2.INSTANCE);
    }

    public static void a(String r3, e48.d r4, long r5, Map r7) {
        int r0 = com.larus.account.saas.security.internal.c.a;
        com.larus.account.saas.security.internal.c.a(r3, MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("event_type", r4.a.getValue()), TuplesKt.to("duration_ms", Long.valueOf(System.currentTimeMillis() - r5))}), r7));
    }
}
