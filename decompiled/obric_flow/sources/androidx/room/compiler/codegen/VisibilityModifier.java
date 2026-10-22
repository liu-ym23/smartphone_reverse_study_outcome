package androidx.room.compiler.codegen;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/room/compiler/codegen/VisibilityModifier;", "", "(Ljava/lang/String;I)V", "PUBLIC", "PROTECTED", "PRIVATE", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum VisibilityModifier extends Enum<VisibilityModifier> {
    private static final /* synthetic */ VisibilityModifier[] $VALUES = null;
    public static final VisibilityModifier PRIVATE = null;
    public static final VisibilityModifier PROTECTED = null;
    public static final VisibilityModifier PUBLIC = null;

    private static final /* synthetic */ VisibilityModifier[] $values() {
        return new VisibilityModifier[]{PUBLIC, PROTECTED, PRIVATE};
    }

    static {
        PUBLIC = new VisibilityModifier("PUBLIC", 0);
        PROTECTED = new VisibilityModifier("PROTECTED", 1);
        PRIVATE = new VisibilityModifier("PRIVATE", 2);
        $VALUES = $values();
    }

    private VisibilityModifier(String r5, int r10) {
        super(r5, r10);
    }

    public static VisibilityModifier valueOf(String r5) {
        return (VisibilityModifier) Enum.valueOf(VisibilityModifier.class, r5);
    }

    public static VisibilityModifier[] values() {
        return (VisibilityModifier[]) $VALUES.clone();
    }
}
