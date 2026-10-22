package com.larus.dora.obric.onboarding;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/onboarding/ObricDoraGEnvAuthResult;", "", "<init>", "(Ljava/lang/String;I)V", "AUTHORIZED", "CANCELED", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricDoraGEnvAuthResult extends Enum<ObricDoraGEnvAuthResult> {
    public static final ObricDoraGEnvAuthResult AUTHORIZED = null;
    public static final ObricDoraGEnvAuthResult CANCELED = null;
    public static final ObricDoraGEnvAuthResult FAILED = null;
    public static final /* synthetic */ ObricDoraGEnvAuthResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricDoraGEnvAuthResult> getEntries() {
        return b;
    }

    static {
        ObricDoraGEnvAuthResult r0 = new ObricDoraGEnvAuthResult("AUTHORIZED", 0);
        AUTHORIZED = r0;
        ObricDoraGEnvAuthResult r1 = new ObricDoraGEnvAuthResult("CANCELED", 1);
        CANCELED = r1;
        ObricDoraGEnvAuthResult r3 = new ObricDoraGEnvAuthResult("FAILED", 2);
        FAILED = r3;
        ObricDoraGEnvAuthResult[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ObricDoraGEnvAuthResult[] values() {
        return (ObricDoraGEnvAuthResult[]) a.clone();
    }

    public static ObricDoraGEnvAuthResult valueOf(String r1) {
        return (ObricDoraGEnvAuthResult) r27.a.a(ObricDoraGEnvAuthResult.class, r1);
    }

    public ObricDoraGEnvAuthResult(String r1, int r2) {
        super(r1, r2);
    }
}
