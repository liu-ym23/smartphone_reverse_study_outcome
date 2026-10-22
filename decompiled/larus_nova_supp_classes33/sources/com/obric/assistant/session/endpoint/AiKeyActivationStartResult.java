package com.obric.assistant.session.endpoint;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/session/endpoint/AiKeyActivationStartResult;", "", "<init>", "(Ljava/lang/String;I)V", "STARTED", "DEFERRED", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AiKeyActivationStartResult extends Enum<AiKeyActivationStartResult> {
    public static final AiKeyActivationStartResult DEFERRED = null;
    public static final AiKeyActivationStartResult FAILED = null;
    public static final AiKeyActivationStartResult STARTED = null;
    public static final /* synthetic */ AiKeyActivationStartResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AiKeyActivationStartResult> getEntries() {
        return b;
    }

    static {
        AiKeyActivationStartResult r0 = new AiKeyActivationStartResult("STARTED", 0);
        STARTED = r0;
        AiKeyActivationStartResult r1 = new AiKeyActivationStartResult("DEFERRED", 1);
        DEFERRED = r1;
        AiKeyActivationStartResult r3 = new AiKeyActivationStartResult("FAILED", 2);
        FAILED = r3;
        AiKeyActivationStartResult[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AiKeyActivationStartResult[] values() {
        return (AiKeyActivationStartResult[]) a.clone();
    }

    public static AiKeyActivationStartResult valueOf(String r1) {
        return (AiKeyActivationStartResult) r27.a.a(AiKeyActivationStartResult.class, r1);
    }

    public AiKeyActivationStartResult(String r1, int r2) {
        super(r1, r2);
    }
}
