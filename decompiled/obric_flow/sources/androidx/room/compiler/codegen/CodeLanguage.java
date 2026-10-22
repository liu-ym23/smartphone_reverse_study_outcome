package androidx.room.compiler.codegen;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/room/compiler/codegen/CodeLanguage;", "", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum CodeLanguage extends Enum<CodeLanguage> {
    private static final /* synthetic */ CodeLanguage[] $VALUES = null;
    public static final CodeLanguage JAVA = null;
    public static final CodeLanguage KOTLIN = null;

    private static final /* synthetic */ CodeLanguage[] $values() {
        return new CodeLanguage[]{JAVA, KOTLIN};
    }

    static {
        JAVA = new CodeLanguage("JAVA", 0);
        KOTLIN = new CodeLanguage("KOTLIN", 1);
        $VALUES = $values();
    }

    private CodeLanguage(String r5, int r10) {
        super(r5, r10);
    }

    public static CodeLanguage valueOf(String r5) {
        return (CodeLanguage) Enum.valueOf(CodeLanguage.class, r5);
    }

    public static CodeLanguage[] values() {
        return (CodeLanguage[]) $VALUES.clone();
    }
}
