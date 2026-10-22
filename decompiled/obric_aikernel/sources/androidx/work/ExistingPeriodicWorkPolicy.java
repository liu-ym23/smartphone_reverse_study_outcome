package androidx.work;

import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes.dex */
public final enum ExistingPeriodicWorkPolicy extends Enum<ExistingPeriodicWorkPolicy> {
    private static final /* synthetic */ ExistingPeriodicWorkPolicy[] $VALUES = null;
    public static final ExistingPeriodicWorkPolicy CANCEL_AND_REENQUEUE = null;
    public static final ExistingPeriodicWorkPolicy KEEP = null;

    @Deprecated(message = "Deprecated in favor of the UPDATE policy. UPDATE policy has very similar behavior: next run of the worker with the same unique name, going to have new specification. However, UPDATE has better defaults: unlike REPLACE policy UPDATE won't cancel the worker if it is currently running and new worker specification will be used only on the next run. Also it preserves original enqueue time, so unlike REPLACE period isn't reset. If you want to preserve previous behavior, CANCEL_AND_REENQUEUE should be used.", replaceWith = @ReplaceWith(expression = "UPDATE", imports = {}))
    public static final ExistingPeriodicWorkPolicy REPLACE = null;
    public static final ExistingPeriodicWorkPolicy UPDATE = null;

    private static final /* synthetic */ ExistingPeriodicWorkPolicy[] $values() {
        return new ExistingPeriodicWorkPolicy[]{REPLACE, KEEP, UPDATE, CANCEL_AND_REENQUEUE};
    }

    static {
        REPLACE = new ExistingPeriodicWorkPolicy("REPLACE", 0);
        KEEP = new ExistingPeriodicWorkPolicy("KEEP", 1);
        UPDATE = new ExistingPeriodicWorkPolicy("UPDATE", 2);
        CANCEL_AND_REENQUEUE = new ExistingPeriodicWorkPolicy("CANCEL_AND_REENQUEUE", 3);
        $VALUES = $values();
    }

    private ExistingPeriodicWorkPolicy(String r10, int r11) {
        super(r10, r11);
    }

    public static ExistingPeriodicWorkPolicy valueOf(String r10) {
        return (ExistingPeriodicWorkPolicy) Enum.valueOf(ExistingPeriodicWorkPolicy.class, r10);
    }

    public static ExistingPeriodicWorkPolicy[] values() {
        return (ExistingPeriodicWorkPolicy[]) $VALUES.clone();
    }
}
