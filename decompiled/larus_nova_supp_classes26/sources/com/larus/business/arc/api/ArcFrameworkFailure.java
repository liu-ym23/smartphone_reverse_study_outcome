package com.larus.business.arc.api;

import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0087\u0081\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001eB\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001f"}, d2 = {"Lcom/larus/business/arc/api/ArcFrameworkFailure;", "", "code", "", "stage", "Lcom/larus/business/arc/api/ArcStage;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/larus/business/arc/api/ArcStage;)V", "getCode", "()Ljava/lang/String;", "getStage", "()Lcom/larus/business/arc/api/ArcStage;", "NONE", "PREPARE_INPUT_INVALID", "PREPARE_ROUTE_NOT_FOUND", "PREPARE_PLATFORM_UNSUPPORTED", "PREPARE_REGISTRY_FAILED", "PREPARE_PAYLOAD_INVALID", "PREPARE_RUNTIME_UNAVAILABLE", "PREPARE_RUNTIME_EMPTY_RESULT", "PREPARE_INTERNAL_ERROR", "EXECUTE_TIMEOUT", "EXECUTE_CANCELLED", "EXECUTE_ACTION_EXCEPTION", "EXECUTE_PLATFORM_UNAVAILABLE", "EXECUTE_PLATFORM_CALL_FAILED", "EXECUTE_PLATFORM_INVALID_RESULT", "EXECUTE_INTERNAL_ERROR", "FINALIZE_SERIALIZATION_FAILED", "FINALIZE_INTERNAL_ERROR", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ArcFrameworkFailure extends Enum<ArcFrameworkFailure> {
    public static final a Companion = null;

    @SerialName("EXECUTE_ACTION_EXCEPTION")
    public static final ArcFrameworkFailure EXECUTE_ACTION_EXCEPTION = null;

    @SerialName("EXECUTE_CANCELLED")
    public static final ArcFrameworkFailure EXECUTE_CANCELLED = null;

    @SerialName("EXECUTE_INTERNAL_ERROR")
    public static final ArcFrameworkFailure EXECUTE_INTERNAL_ERROR = null;

    @SerialName("EXECUTE_PLATFORM_CALL_FAILED")
    public static final ArcFrameworkFailure EXECUTE_PLATFORM_CALL_FAILED = null;

    @SerialName("EXECUTE_PLATFORM_INVALID_RESULT")
    public static final ArcFrameworkFailure EXECUTE_PLATFORM_INVALID_RESULT = null;

    @SerialName("EXECUTE_PLATFORM_UNAVAILABLE")
    public static final ArcFrameworkFailure EXECUTE_PLATFORM_UNAVAILABLE = null;

    @SerialName("EXECUTE_TIMEOUT")
    public static final ArcFrameworkFailure EXECUTE_TIMEOUT = null;

    @SerialName("FINALIZE_INTERNAL_ERROR")
    public static final ArcFrameworkFailure FINALIZE_INTERNAL_ERROR = null;

    @SerialName("FINALIZE_SERIALIZATION_FAILED")
    public static final ArcFrameworkFailure FINALIZE_SERIALIZATION_FAILED = null;

    @SerialName(TriggerSendLoading.NO_LOADING)
    public static final ArcFrameworkFailure NONE = null;

    @SerialName("PREPARE_INPUT_INVALID")
    public static final ArcFrameworkFailure PREPARE_INPUT_INVALID = null;

    @SerialName("PREPARE_INTERNAL_ERROR")
    public static final ArcFrameworkFailure PREPARE_INTERNAL_ERROR = null;

    @SerialName("PREPARE_PAYLOAD_INVALID")
    public static final ArcFrameworkFailure PREPARE_PAYLOAD_INVALID = null;

    @SerialName("PREPARE_PLATFORM_UNSUPPORTED")
    public static final ArcFrameworkFailure PREPARE_PLATFORM_UNSUPPORTED = null;

    @SerialName("PREPARE_REGISTRY_FAILED")
    public static final ArcFrameworkFailure PREPARE_REGISTRY_FAILED = null;

    @SerialName("PREPARE_ROUTE_NOT_FOUND")
    public static final ArcFrameworkFailure PREPARE_ROUTE_NOT_FOUND = null;

    @SerialName("PREPARE_RUNTIME_EMPTY_RESULT")
    public static final ArcFrameworkFailure PREPARE_RUNTIME_EMPTY_RESULT = null;

    @SerialName("PREPARE_RUNTIME_UNAVAILABLE")
    public static final ArcFrameworkFailure PREPARE_RUNTIME_UNAVAILABLE = null;
    public static final Lazy<juc.d<Object>> a = null;
    public static final /* synthetic */ ArcFrameworkFailure[] b = null;
    public static final /* synthetic */ EnumEntries c = null;
    private final String code;
    private final ArcStage stage;

    public static final class a {
        public a() {
        }

        public final juc.d<ArcFrameworkFailure> serializer() {
            return (juc.d) ArcFrameworkFailure.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    public static EnumEntries<ArcFrameworkFailure> getEntries() {
        return c;
    }

    static {
        ArcFrameworkFailure r0 = new ArcFrameworkFailure("NONE", 0, TriggerSendLoading.NO_LOADING, null);
        NONE = r0;
        ArcStage r2 = ArcStage.PREPARE;
        ArcFrameworkFailure r1 = new ArcFrameworkFailure("PREPARE_INPUT_INVALID", 1, "PREPARE_INPUT_INVALID", r2);
        PREPARE_INPUT_INVALID = r1;
        ArcFrameworkFailure r3 = new ArcFrameworkFailure("PREPARE_ROUTE_NOT_FOUND", 2, "PREPARE_ROUTE_NOT_FOUND", r2);
        PREPARE_ROUTE_NOT_FOUND = r3;
        ArcFrameworkFailure r6 = new ArcFrameworkFailure("PREPARE_PLATFORM_UNSUPPORTED", 3, "PREPARE_PLATFORM_UNSUPPORTED", r2);
        PREPARE_PLATFORM_UNSUPPORTED = r6;
        ArcFrameworkFailure r8 = new ArcFrameworkFailure("PREPARE_REGISTRY_FAILED", 4, "PREPARE_REGISTRY_FAILED", r2);
        PREPARE_REGISTRY_FAILED = r8;
        ArcFrameworkFailure r10 = new ArcFrameworkFailure("PREPARE_PAYLOAD_INVALID", 5, "PREPARE_PAYLOAD_INVALID", r2);
        PREPARE_PAYLOAD_INVALID = r10;
        ArcFrameworkFailure r12 = new ArcFrameworkFailure("PREPARE_RUNTIME_UNAVAILABLE", 6, "PREPARE_RUNTIME_UNAVAILABLE", r2);
        PREPARE_RUNTIME_UNAVAILABLE = r12;
        ArcFrameworkFailure r14 = new ArcFrameworkFailure("PREPARE_RUNTIME_EMPTY_RESULT", 7, "PREPARE_RUNTIME_EMPTY_RESULT", r2);
        PREPARE_RUNTIME_EMPTY_RESULT = r14;
        ArcFrameworkFailure r15 = new ArcFrameworkFailure("PREPARE_INTERNAL_ERROR", 8, "PREPARE_INTERNAL_ERROR", r2);
        PREPARE_INTERNAL_ERROR = r15;
        ArcStage r13 = ArcStage.EXECUTE;
        ArcFrameworkFailure r4 = new ArcFrameworkFailure("EXECUTE_TIMEOUT", 9, "EXECUTE_TIMEOUT", r13);
        EXECUTE_TIMEOUT = r4;
        ArcFrameworkFailure r11 = new ArcFrameworkFailure("EXECUTE_CANCELLED", 10, "EXECUTE_CANCELLED", r13);
        EXECUTE_CANCELLED = r11;
        ArcFrameworkFailure r9 = new ArcFrameworkFailure("EXECUTE_ACTION_EXCEPTION", 11, "EXECUTE_ACTION_EXCEPTION", r13);
        EXECUTE_ACTION_EXCEPTION = r9;
        ArcFrameworkFailure r5 = new ArcFrameworkFailure("EXECUTE_PLATFORM_UNAVAILABLE", 12, "EXECUTE_PLATFORM_UNAVAILABLE", r13);
        EXECUTE_PLATFORM_UNAVAILABLE = r5;
        ArcFrameworkFailure r7 = new ArcFrameworkFailure("EXECUTE_PLATFORM_CALL_FAILED", 13, "EXECUTE_PLATFORM_CALL_FAILED", r13);
        EXECUTE_PLATFORM_CALL_FAILED = r7;
        ArcFrameworkFailure r16 = new ArcFrameworkFailure("EXECUTE_PLATFORM_INVALID_RESULT", 14, "EXECUTE_PLATFORM_INVALID_RESULT", r13);
        EXECUTE_PLATFORM_INVALID_RESULT = r16;
        ArcFrameworkFailure r17 = new ArcFrameworkFailure("EXECUTE_INTERNAL_ERROR", 15, "EXECUTE_INTERNAL_ERROR", r13);
        EXECUTE_INTERNAL_ERROR = r17;
        ArcStage r18 = ArcStage.FINALIZE;
        ArcFrameworkFailure r19 = new ArcFrameworkFailure("FINALIZE_SERIALIZATION_FAILED", 16, "FINALIZE_SERIALIZATION_FAILED", r18);
        FINALIZE_SERIALIZATION_FAILED = r19;
        ArcFrameworkFailure r20 = new ArcFrameworkFailure("FINALIZE_INTERNAL_ERROR", 17, "FINALIZE_INTERNAL_ERROR", r18);
        FINALIZE_INTERNAL_ERROR = r20;
        ArcFrameworkFailure[] r21 = {r0, r1, r3, r6, r8, r10, r12, r14, r15, r4, r11, r9, r5, r7, r16, r17, r19, r20};
        b = r21;
        c = EnumEntriesKt.enumEntries(r21);
        Companion = new a();
        a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new n());
    }

    public static ArcFrameworkFailure[] values() {
        return (ArcFrameworkFailure[]) b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return a;
    }

    public final String getCode() {
        return this.code;
    }

    public final ArcStage getStage() {
        return this.stage;
    }

    public static ArcFrameworkFailure valueOf(String r1) {
        return (ArcFrameworkFailure) r27.a.a(ArcFrameworkFailure.class, r1);
    }

    public ArcFrameworkFailure(String r1, int r2, String r3, ArcStage r4) {
        super(r1, r2);
        this.code = r3;
        this.stage = r4;
    }
}
