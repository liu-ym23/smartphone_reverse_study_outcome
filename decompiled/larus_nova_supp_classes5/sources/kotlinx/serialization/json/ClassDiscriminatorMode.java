package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/serialization/json/ClassDiscriminatorMode;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ALL_JSON_OBJECTS", "POLYMORPHIC", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ClassDiscriminatorMode extends Enum<ClassDiscriminatorMode> {
    public static final ClassDiscriminatorMode ALL_JSON_OBJECTS = null;
    public static final ClassDiscriminatorMode NONE = null;
    public static final ClassDiscriminatorMode POLYMORPHIC = null;
    public static final /* synthetic */ ClassDiscriminatorMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ClassDiscriminatorMode> getEntries() {
        return b;
    }

    static {
        ClassDiscriminatorMode r0 = new ClassDiscriminatorMode("NONE", 0);
        NONE = r0;
        ClassDiscriminatorMode r1 = new ClassDiscriminatorMode("ALL_JSON_OBJECTS", 1);
        ALL_JSON_OBJECTS = r1;
        ClassDiscriminatorMode r3 = new ClassDiscriminatorMode("POLYMORPHIC", 2);
        POLYMORPHIC = r3;
        ClassDiscriminatorMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ClassDiscriminatorMode[] values() {
        return (ClassDiscriminatorMode[]) a.clone();
    }

    public static ClassDiscriminatorMode valueOf(String r1) {
        return (ClassDiscriminatorMode) a.a(ClassDiscriminatorMode.class, r1);
    }

    public ClassDiscriminatorMode(String r1, int r2) {
        super(r1, r2);
    }
}
