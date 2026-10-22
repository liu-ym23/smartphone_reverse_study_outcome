package kotlin.coroutines.intrinsics;

import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.3")
@PublishedApi
public final enum CoroutineSingletons extends Enum<CoroutineSingletons> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CoroutineSingletons[] $VALUES = null;
    public static final CoroutineSingletons COROUTINE_SUSPENDED = null;
    public static final CoroutineSingletons RESUMED = null;
    public static final CoroutineSingletons UNDECIDED = null;

    private static final /* synthetic */ CoroutineSingletons[] $values() {
        return new CoroutineSingletons[]{COROUTINE_SUSPENDED, UNDECIDED, RESUMED};
    }

    static {
        COROUTINE_SUSPENDED = new CoroutineSingletons("COROUTINE_SUSPENDED", 0);
        UNDECIDED = new CoroutineSingletons("UNDECIDED", 1);
        RESUMED = new CoroutineSingletons("RESUMED", 2);
        CoroutineSingletons[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = EnumEntriesKt.enumEntries(r10);
    }

    private CoroutineSingletons(String r10, int r11) {
        super(r10, r11);
    }

    public static EnumEntries<CoroutineSingletons> getEntries() {
        return $ENTRIES;
    }

    public static CoroutineSingletons valueOf(String r10) {
        return (CoroutineSingletons) Enum.valueOf(CoroutineSingletons.class, r10);
    }

    public static CoroutineSingletons[] values() {
        return (CoroutineSingletons[]) $VALUES.clone();
    }
}
