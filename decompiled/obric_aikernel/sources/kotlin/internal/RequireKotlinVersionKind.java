package kotlin.internal;

import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.2")
public final enum RequireKotlinVersionKind extends Enum<RequireKotlinVersionKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RequireKotlinVersionKind[] $VALUES = null;
    public static final RequireKotlinVersionKind API_VERSION = null;
    public static final RequireKotlinVersionKind COMPILER_VERSION = null;
    public static final RequireKotlinVersionKind LANGUAGE_VERSION = null;

    private static final /* synthetic */ RequireKotlinVersionKind[] $values() {
        return new RequireKotlinVersionKind[]{LANGUAGE_VERSION, COMPILER_VERSION, API_VERSION};
    }

    static {
        LANGUAGE_VERSION = new RequireKotlinVersionKind("LANGUAGE_VERSION", 0);
        COMPILER_VERSION = new RequireKotlinVersionKind("COMPILER_VERSION", 1);
        API_VERSION = new RequireKotlinVersionKind("API_VERSION", 2);
        RequireKotlinVersionKind[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = EnumEntriesKt.enumEntries(r10);
    }

    private RequireKotlinVersionKind(String r10, int r11) {
        super(r10, r11);
    }

    public static EnumEntries<RequireKotlinVersionKind> getEntries() {
        return $ENTRIES;
    }

    public static RequireKotlinVersionKind valueOf(String r10) {
        return (RequireKotlinVersionKind) Enum.valueOf(RequireKotlinVersionKind.class, r10);
    }

    public static RequireKotlinVersionKind[] values() {
        return (RequireKotlinVersionKind[]) $VALUES.clone();
    }
}
