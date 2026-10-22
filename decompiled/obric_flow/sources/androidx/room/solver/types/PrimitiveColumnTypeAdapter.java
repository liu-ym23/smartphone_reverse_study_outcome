package androidx.room.solver.types;

import androidx.room.compiler.codegen.CodeLanguage;
import androidx.room.compiler.codegen.XCodeBlock;
import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XType;
import androidx.room.parser.SQLTypeAffinity;
import androidx.room.solver.CodeGenScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/room/solver/types/PrimitiveColumnTypeAdapter;", "Landroidx/room/solver/types/ColumnTypeAdapter;", "out", "Landroidx/room/compiler/processing/XType;", "typeAffinity", "Landroidx/room/parser/SQLTypeAffinity;", "primitive", "Landroidx/room/solver/types/PrimitiveColumnTypeAdapter$Companion$Primitive;", "(Landroidx/room/compiler/processing/XType;Landroidx/room/parser/SQLTypeAffinity;Landroidx/room/solver/types/PrimitiveColumnTypeAdapter$Companion$Primitive;)V", "cursorGetter", "", "getPrimitive", "()Landroidx/room/solver/types/PrimitiveColumnTypeAdapter$Companion$Primitive;", "stmtSetter", "bindToStmt", "", "stmtName", "indexVarName", "valueVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "readFromCursor", "outVarName", "cursorVarName", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PrimitiveColumnTypeAdapter extends ColumnTypeAdapter {
    public static final Companion Companion = null;
    private final String cursorGetter;
    private final Companion.Primitive primitive;
    private final String stmtSetter;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\r"}, d2 = {"Landroidx/room/solver/types/PrimitiveColumnTypeAdapter$Companion;", "", "()V", "createPrimitiveAdapters", "", "Landroidx/room/solver/types/PrimitiveColumnTypeAdapter;", "processingEnvironment", "Landroidx/room/compiler/processing/XProcessingEnv;", "getAffinity", "Landroidx/room/parser/SQLTypeAffinity;", "primitive", "Landroidx/room/solver/types/PrimitiveColumnTypeAdapter$Companion$Primitive;", "Primitive", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Landroidx/room/solver/types/PrimitiveColumnTypeAdapter$Companion$Primitive;", "", "typeName", "Landroidx/room/compiler/codegen/XTypeName;", "cursorGetter", "", "stmtSetter", "(Ljava/lang/String;ILandroidx/room/compiler/codegen/XTypeName;Ljava/lang/String;Ljava/lang/String;)V", "getCursorGetter", "()Ljava/lang/String;", "getStmtSetter", "getTypeName", "()Landroidx/room/compiler/codegen/XTypeName;", "INT", "SHORT", "BYTE", "LONG", "CHAR", "FLOAT", "DOUBLE", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final enum Primitive extends Enum<Primitive> {
            private static final /* synthetic */ Primitive[] $VALUES = null;
            public static final Primitive BYTE = null;
            public static final Primitive CHAR = null;
            public static final Primitive DOUBLE = null;
            public static final Primitive FLOAT = null;
            public static final Primitive INT = null;
            public static final Primitive LONG = null;
            public static final Primitive SHORT = null;
            private final String cursorGetter;
            private final String stmtSetter;
            private final XTypeName typeName;

            private static final /* synthetic */ Primitive[] $values() {
                return new Primitive[]{INT, SHORT, BYTE, LONG, CHAR, FLOAT, DOUBLE};
            }

            static {
                XTypeName.Companion r10 = XTypeName.Companion;
                INT = new Primitive("INT", 0, r10.getPRIMITIVE_INT(), "getInt", "bindLong");
                SHORT = new Primitive("SHORT", 1, r10.getPRIMITIVE_SHORT(), "getShort", "bindLong");
                BYTE = new Primitive("BYTE", 2, r10.getPRIMITIVE_BYTE(), "getShort", "bindLong");
                LONG = new Primitive("LONG", 3, r10.getPRIMITIVE_LONG(), "getLong", "bindLong");
                CHAR = new Primitive("CHAR", 4, r10.getPRIMITIVE_CHAR(), "getInt", "bindLong");
                FLOAT = new Primitive("FLOAT", 5, r10.getPRIMITIVE_FLOAT(), "getFloat", "bindDouble");
                DOUBLE = new Primitive("DOUBLE", 6, r10.getPRIMITIVE_DOUBLE(), "getDouble", "bindDouble");
                $VALUES = $values();
            }

            private Primitive(String r5, int r10, XTypeName r11, String r12, String r13) {
                super(r5, r10);
                this.typeName = r11;
                this.cursorGetter = r12;
                this.stmtSetter = r13;
            }

            public static Primitive valueOf(String r5) {
                return (Primitive) Enum.valueOf(Primitive.class, r5);
            }

            public static Primitive[] values() {
                return (Primitive[]) $VALUES.clone();
            }

            public final String getCursorGetter() {
                return this.cursorGetter;
            }

            public final String getStmtSetter() {
                return this.stmtSetter;
            }

            public final XTypeName getTypeName() {
                return this.typeName;
            }
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r5 = new int[Primitive.values().length];
                r5[Primitive.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r5[Primitive.SHORT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r5[Primitive.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r5[Primitive.LONG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r5[Primitive.CHAR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r5[Primitive.FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r5[Primitive.DOUBLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                $EnumSwitchMapping$0 = r5;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private final SQLTypeAffinity getAffinity(Primitive r5) {
            switch(WhenMappings.$EnumSwitchMapping$0[r5.ordinal()]) {
                case 1: goto L8;
                case 2: goto L8;
                case 3: goto L8;
                case 4: goto L8;
                case 5: goto L8;
                case 6: goto L9;
                case 7: goto L9;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L9:
            return SQLTypeAffinity.REAL;
        L8:
            return SQLTypeAffinity.INTEGER;
        }

        public final List<PrimitiveColumnTypeAdapter> createPrimitiveAdapters(XProcessingEnv r10) {
            Intrinsics.checkNotNullParameter(r10, "processingEnvironment");
            Primitive[] r11 = Primitive.values();
            ArrayList r5 = new ArrayList(r11.length);
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            Primitive r14 = r11[r13];
            r5.add(new PrimitiveColumnTypeAdapter(r10.requireType(r14.getTypeName()), PrimitiveColumnTypeAdapter.Companion.getAffinity(r14), r14));
            r13 = r13 + 1;
            goto L3
        L5:
            return r5;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r5 = new int[Companion.Primitive.values().length];
            r5[Companion.Primitive.BYTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r5[Companion.Primitive.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            $EnumSwitchMapping$0 = r5;
            int[] r10 = new int[CodeLanguage.values().length];
            r10[CodeLanguage.JAVA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r10[CodeLanguage.KOTLIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            $EnumSwitchMapping$1 = r10;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PrimitiveColumnTypeAdapter(XType r5, SQLTypeAffinity r10, Companion.Primitive r11) {
        Intrinsics.checkNotNullParameter(r5, "out");
        Intrinsics.checkNotNullParameter(r10, "typeAffinity");
        Intrinsics.checkNotNullParameter(r11, "primitive");
        super(r5, r10);
        this.primitive = r11;
        this.cursorGetter = r11.getCursorGetter();
        this.stmtSetter = r11.getStmtSetter();
    }

    @Override // androidx.room.solver.types.StatementValueBinder
    public void bindToStmt(String r5, String r10, String r11, CodeGenScope r12) {
        Intrinsics.checkNotNullParameter(r5, "stmtName");
        Intrinsics.checkNotNullParameter(r10, "indexVarName");
        Intrinsics.checkNotNullParameter(r11, "valueVarName");
        Intrinsics.checkNotNullParameter(r12, "scope");
        r12.getBuilder().addStatement("%L.%L(%L, %L)", new Object[]{r5, this.stmtSetter, r10, r11});
    }

    public final Companion.Primitive getPrimitive() {
        return this.primitive;
    }

    @Override // androidx.room.solver.types.CursorValueReader
    public void readFromCursor(String r10, String r11, String r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r10, "outVarName");
        Intrinsics.checkNotNullParameter(r11, "cursorVarName");
        Intrinsics.checkNotNullParameter(r12, "indexVarName");
        Intrinsics.checkNotNullParameter(r13, "scope");
        XCodeBlock.Builder r5 = r13.getBuilder();
        XCodeBlock.Companion r14 = XCodeBlock.Companion;
        XCodeBlock r15 = r14.of(r13.getLanguage(), "%L.%L(%L)", new Object[]{r11, this.cursorGetter, r12});
        Companion.Primitive r16 = this.primitive;
        int r17 = WhenMappings.$EnumSwitchMapping$0[r16.ordinal()];
        if (r17 == 1) goto L7;
        if (r17 == 2) goto L6;
        String r18 = null;
    L8:
        if (r18 == null) goto L18;
        CodeLanguage r19 = r15.getLanguage();
        int r20 = WhenMappings.$EnumSwitchMapping$1[r19.ordinal()];
        if (r20 == 1) goto L17;
        if (r20 != 2) goto L16;
        XCodeBlock r21 = r14.of(r15.getLanguage(), "%L.%L()", new Object[]{r15, r18});
    L14:
        r15 = r21;
        goto L18
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r21 = r14.ofCast(r15.getLanguage(), getOut().asTypeName(), r15);
    L18:
        r5.addStatement("%L = %L", new Object[]{r10, r15});
        return;
    L6:
        r18 = "toChar";
        goto L8
    L7:
        r18 = "toByte";
        goto L8
    }
}
