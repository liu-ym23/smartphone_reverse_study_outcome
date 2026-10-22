package androidx.compose.runtime;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/InvalidationResult;", "", "(Ljava/lang/String;I)V", "IGNORED", "SCHEDULED", "DEFERRED", "IMMINENT", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum InvalidationResult extends Enum<InvalidationResult> {
    private static final /* synthetic */ InvalidationResult[] $VALUES = null;
    public static final InvalidationResult DEFERRED = null;
    public static final InvalidationResult IGNORED = null;
    public static final InvalidationResult IMMINENT = null;
    public static final InvalidationResult SCHEDULED = null;

    private static final /* synthetic */ InvalidationResult[] $values() {
        return new InvalidationResult[]{IGNORED, SCHEDULED, DEFERRED, IMMINENT};
    }

    static {
        IGNORED = new InvalidationResult("IGNORED", 0);
        SCHEDULED = new InvalidationResult("SCHEDULED", 1);
        DEFERRED = new InvalidationResult("DEFERRED", 2);
        IMMINENT = new InvalidationResult("IMMINENT", 3);
        $VALUES = $values();
    }

    private InvalidationResult(String r5, int r10) {
        super(r5, r10);
    }

    public static InvalidationResult valueOf(String r5) {
        return (InvalidationResult) Enum.valueOf(InvalidationResult.class, r5);
    }

    public static InvalidationResult[] values() {
        return (InvalidationResult[]) $VALUES.clone();
    }
}
