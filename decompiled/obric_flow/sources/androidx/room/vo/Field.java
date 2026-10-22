package androidx.room.vo;

import ai.j0;
import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.processing.XFieldElement;
import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XType;
import androidx.room.migration.bundle.FieldBundle;
import androidx.room.parser.Collate;
import androidx.room.parser.SQLTypeAffinity;
import androidx.room.solver.types.CursorValueReader;
import androidx.room.solver.types.StatementValueBinder;
import androidx.room.writer.DaoWriter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 o2\u00020\u0001:\u0001oBi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0002\u0010\u0013J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0011HÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\t\u0010[\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010^\u001a\u00020\u0005HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010a\u001a\u00020\u0011HÆ\u0003Ju\u0010b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011HÆ\u0001J\u000e\u0010c\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\u0011J\u0013\u0010e\u001a\u00020\u00112\b\u0010f\u001a\u0004\u0018\u00010gHÖ\u0003J\b\u0010h\u001a\u00020\u0005H\u0016J\u0006\u0010i\u001a\u00020\u0005J\t\u0010j\u001a\u00020kHÖ\u0001J\u0006\u0010l\u001a\u00020mJ\t\u0010n\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R!\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b-\u0010.R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001bR+\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u000507j\b\u0012\u0004\u0012\u00020\u0005`88FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u00100\u001a\u0004\b9\u0010:R\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b<\u00102R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001b\u0010?\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u00100\u001a\u0004\b@\u0010\u001bR\u001a\u0010B\u001a\u00020CX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR!\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00050,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u00100\u001a\u0004\bI\u0010.R\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u001b\u0010S\u001a\u00020T8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u00100\u001a\u0004\bU\u0010V¨\u0006p"}, d2 = {"Landroidx/room/vo/Field;", "Landroidx/room/vo/HasSchemaIdentity;", "element", "Landroidx/room/compiler/processing/XFieldElement;", "name", "", "type", "Landroidx/room/compiler/processing/XType;", "affinity", "Landroidx/room/parser/SQLTypeAffinity;", "collate", "Landroidx/room/parser/Collate;", "columnName", "defaultValue", "parent", "Landroidx/room/vo/EmbeddedField;", "indexed", "", "nonNull", "(Landroidx/room/compiler/processing/XFieldElement;Ljava/lang/String;Landroidx/room/compiler/processing/XType;Landroidx/room/parser/SQLTypeAffinity;Landroidx/room/parser/Collate;Ljava/lang/String;Ljava/lang/String;Landroidx/room/vo/EmbeddedField;ZZ)V", "getAffinity", "()Landroidx/room/parser/SQLTypeAffinity;", "setAffinity", "(Landroidx/room/parser/SQLTypeAffinity;)V", "getCollate", "()Landroidx/room/parser/Collate;", "getColumnName", "()Ljava/lang/String;", "cursorValueReader", "Landroidx/room/solver/types/CursorValueReader;", "getCursorValueReader", "()Landroidx/room/solver/types/CursorValueReader;", "setCursorValueReader", "(Landroidx/room/solver/types/CursorValueReader;)V", "getDefaultValue", "getElement", "()Landroidx/room/compiler/processing/XFieldElement;", "getter", "Landroidx/room/vo/FieldGetter;", "getGetter", "()Landroidx/room/vo/FieldGetter;", "setGetter", "(Landroidx/room/vo/FieldGetter;)V", "getterNameWithVariations", "", "getGetterNameWithVariations", "()Ljava/util/List;", "getterNameWithVariations$delegate", "Lkotlin/Lazy;", "getIndexed", "()Z", "setIndexed", "(Z)V", "getName", "nameWithVariations", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getNameWithVariations", "()Ljava/util/ArrayList;", "nameWithVariations$delegate", "getNonNull", "getParent", "()Landroidx/room/vo/EmbeddedField;", "pathWithDotNotation", "getPathWithDotNotation", "pathWithDotNotation$delegate", "setter", "Landroidx/room/vo/FieldSetter;", "getSetter", "()Landroidx/room/vo/FieldSetter;", "setSetter", "(Landroidx/room/vo/FieldSetter;)V", "setterNameWithVariations", "getSetterNameWithVariations", "setterNameWithVariations$delegate", "statementBinder", "Landroidx/room/solver/types/StatementValueBinder;", "getStatementBinder", "()Landroidx/room/solver/types/StatementValueBinder;", "setStatementBinder", "(Landroidx/room/solver/types/StatementValueBinder;)V", "getType", "()Landroidx/room/compiler/processing/XType;", "typeName", "Landroidx/room/compiler/codegen/XTypeName;", "getTypeName", "()Landroidx/room/compiler/codegen/XTypeName;", "typeName$delegate", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "databaseDefinition", "autoIncrementPKey", "equals", "other", "", "getIdKey", "getPath", "hashCode", "", "toBundle", "Landroidx/room/migration/bundle/FieldBundle;", "toString", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Field implements HasSchemaIdentity {
    public static final Companion Companion = null;
    private SQLTypeAffinity affinity;
    private final Collate collate;
    private final String columnName;
    private CursorValueReader cursorValueReader;
    private final String defaultValue;
    private final XFieldElement element;
    public FieldGetter getter;
    private final Lazy getterNameWithVariations$delegate;
    private boolean indexed;
    private final String name;
    private final Lazy nameWithVariations$delegate;
    private final boolean nonNull;
    private final EmbeddedField parent;
    private final Lazy pathWithDotNotation$delegate;
    public FieldSetter setter;
    private final Lazy setterNameWithVariations$delegate;
    private StatementValueBinder statementBinder;
    private final XType type;
    private final Lazy typeName$delegate;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Landroidx/room/vo/Field$Companion;", "", "()V", "calcNonNull", "", "type", "Landroidx/room/compiler/processing/XType;", "parent", "Landroidx/room/vo/EmbeddedField;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final boolean calcNonNull(XType r5, EmbeddedField r10) {
            Intrinsics.checkNotNullParameter(r5, "type");
            if (XNullability.NONNULL != r5.getNullability()) goto L8;
            if (r10 != null) goto L6;
        L7:
            return true;
        L6:
            if (r10.isNonNullRecursively() == true) goto L7;
        L8:
            return false;
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Field(XFieldElement r5, String r10, XType r11, SQLTypeAffinity r12, Collate r13, String r14, String r15, EmbeddedField r16, boolean r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r14, "columnName");
        this.element = r5;
        this.name = r10;
        this.type = r11;
        this.affinity = r12;
        this.collate = r13;
        this.columnName = r14;
        this.defaultValue = r15;
        this.parent = r16;
        this.indexed = r17;
        this.nonNull = r18;
        this.typeName$delegate = LazyKt.lazy(new Field$typeName$2(this));
        this.pathWithDotNotation$delegate = LazyKt.lazy(new Field$pathWithDotNotation$2(this));
        this.nameWithVariations$delegate = LazyKt.lazy(new Field$nameWithVariations$2(this));
        this.getterNameWithVariations$delegate = LazyKt.lazy(new Field$getterNameWithVariations$2(this));
        this.setterNameWithVariations$delegate = LazyKt.lazy(new Field$setterNameWithVariations$2(this));
    }

    public static final /* synthetic */ String access$getPathWithDotNotation(Field r5) {
        return r5.getPathWithDotNotation();
    }

    public static /* synthetic */ Field copy$default(Field r11, XFieldElement r12, String r13, XType r14, SQLTypeAffinity r15, Collate r16, String r17, String r18, EmbeddedField r19, boolean r20, boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        XFieldElement r5 = r11.element;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r10 = r11.name;
    L11:
        if ((r22 & 4) == 0) goto L13;
        XType r24 = r11.type;
    L15:
        if ((r22 & 8) == 0) goto L17;
        SQLTypeAffinity r25 = r11.affinity;
    L19:
        if ((r22 & 16) == 0) goto L21;
        Collate r26 = r11.collate;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r27 = r11.columnName;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r28 = r11.defaultValue;
    L31:
        if ((r22 & 128) == 0) goto L33;
        EmbeddedField r29 = r11.parent;
    L35:
        if ((r22 & 256) == 0) goto L37;
        boolean r110 = r11.indexed;
    L39:
        if ((r22 & 512) == 0) goto L41;
        boolean r30 = r11.nonNull;
    L43:
        return r11.copy(r5, r10, r24, r25, r26, r27, r28, r29, r110, r30);
    L41:
        r30 = r21;
        goto L43
    L37:
        r110 = r20;
        goto L39
    L33:
        r29 = r19;
        goto L35
    L29:
        r28 = r18;
        goto L31
    L25:
        r27 = r17;
        goto L27
    L21:
        r26 = r16;
        goto L23
    L17:
        r25 = r15;
        goto L19
    L13:
        r24 = r14;
        goto L15
    L9:
        r10 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    private final String getPathWithDotNotation() {
        return (String) this.pathWithDotNotation$delegate.getValue();
    }

    public final XFieldElement component1() {
        return this.element;
    }

    public final boolean component10() {
        return this.nonNull;
    }

    public final String component2() {
        return this.name;
    }

    public final XType component3() {
        return this.type;
    }

    public final SQLTypeAffinity component4() {
        return this.affinity;
    }

    public final Collate component5() {
        return this.collate;
    }

    public final String component6() {
        return this.columnName;
    }

    public final String component7() {
        return this.defaultValue;
    }

    public final EmbeddedField component8() {
        return this.parent;
    }

    public final boolean component9() {
        return this.indexed;
    }

    public final Field copy(XFieldElement r13, String r14, XType r15, SQLTypeAffinity r16, Collate r17, String r18, String r19, EmbeddedField r20, boolean r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r13, "element");
        Intrinsics.checkNotNullParameter(r14, "name");
        Intrinsics.checkNotNullParameter(r15, "type");
        Intrinsics.checkNotNullParameter(r18, "columnName");
        return new Field(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public final String databaseDefinition(boolean r5) {
        StringBuilder r10 = new StringBuilder("");
        if (r5 == false) goto L6;
        r10.append(" PRIMARY KEY AUTOINCREMENT");
    L6:
        if (this.nonNull == false) goto L8;
        r10.append(" NOT NULL");
    L8:
        Collate r11 = this.collate;
        if (r11 == null) goto L11;
        r10.append(" COLLATE " + r11.name());
    L11:
        String r12 = this.defaultValue;
        if (r12 == null) goto L14;
        r10.append(" DEFAULT " + r12);
    L14:
        String r13 = this.columnName;
        SQLTypeAffinity r14 = this.affinity;
        if (r14 != null) goto L18;
        r14 = SQLTypeAffinity.TEXT;
    L18:
        return "`" + r13 + "` " + r14.name() + r10;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Field) == true) goto L8;
        return false;
    L8:
        Field r10 = (Field) r5;
        if (Intrinsics.areEqual(this.element, r10.element) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L18;
        return false;
    L18:
        if (this.affinity == r10.affinity) goto L21;
        return false;
    L21:
        if (this.collate == r10.collate) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.columnName, r10.columnName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.defaultValue, r10.defaultValue) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.parent, r10.parent) == true) goto L33;
        return false;
    L33:
        if (this.indexed == r10.indexed) goto L36;
        return false;
    L36:
        if (this.nonNull == r10.nonNull) goto L38;
        return false;
    L38:
        return true;
    }

    public final SQLTypeAffinity getAffinity() {
        return this.affinity;
    }

    public final Collate getCollate() {
        return this.collate;
    }

    public final String getColumnName() {
        return this.columnName;
    }

    public final CursorValueReader getCursorValueReader() {
        return this.cursorValueReader;
    }

    public final String getDefaultValue() {
        return this.defaultValue;
    }

    public final XFieldElement getElement() {
        return this.element;
    }

    public final FieldGetter getGetter() {
        FieldGetter r5 = this.getter;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("getter");
        return null;
    }

    public final List<String> getGetterNameWithVariations() {
        return (List) this.getterNameWithVariations$delegate.getValue();
    }

    @Override // androidx.room.vo.HasSchemaIdentity
    public String getIdKey() {
        StringBuilder r5 = new StringBuilder();
        String r10 = this.columnName;
        SQLTypeAffinity r11 = this.affinity;
        if (r11 == null) goto L6;
        String r12 = r11.name();
        if (r12 == null) goto L6;
    L7:
        r5.append(r10 + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r12 + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + this.nonNull);
        String r13 = this.defaultValue;
        if (r13 == null) goto L11;
        r5.append("-defaultValue=" + r13);
    L11:
        return r5.toString();
    L6:
        r12 = "TEXT";
        goto L7
    }

    public final boolean getIndexed() {
        return this.indexed;
    }

    public final String getName() {
        return this.name;
    }

    public final ArrayList<String> getNameWithVariations() {
        return (ArrayList) this.nameWithVariations$delegate.getValue();
    }

    public final boolean getNonNull() {
        return this.nonNull;
    }

    public final EmbeddedField getParent() {
        return this.parent;
    }

    public final String getPath() {
        EmbeddedField r5 = this.parent;
        if (r5 != null) goto L6;
        return this.name;
    L6:
        return j0.D(r5.getField().getPath(), " > ", this.name);
    }

    public final FieldSetter getSetter() {
        FieldSetter r5 = this.setter;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("setter");
        return null;
    }

    public final List<String> getSetterNameWithVariations() {
        return (List) this.setterNameWithVariations$delegate.getValue();
    }

    public final StatementValueBinder getStatementBinder() {
        return this.statementBinder;
    }

    public final XType getType() {
        return this.type;
    }

    public final XTypeName getTypeName() {
        return (XTypeName) this.typeName$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r5 = (this.type.hashCode() + androidx.constraintlayout.motion.widget.a.c(this.element.hashCode() * 31, 31, this.name)) * 31;
        SQLTypeAffinity r10 = this.affinity;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        Collate r14 = this.collate;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = androidx.constraintlayout.motion.widget.a.c((r13 + r15) * 31, 31, this.columnName);
        String r17 = this.defaultValue;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        EmbeddedField r20 = this.parent;
        if (r20 == null) goto L18;
        r11 = r20.hashCode();
    L18:
        int r21 = (r19 + r11) * 31;
        boolean r22 = this.indexed;
        ?? r23 = 1;
        ?? r24 = r22;
        if (r22 == false) goto L21;
        r24 = 1;
    L21:
        int r25 = (r21 + r24) * 31;
        boolean r26 = this.nonNull;
        if (r26 == true) goto L26;
        r23 = r26;
    L26:
        return r25 + r23;
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final void setAffinity(SQLTypeAffinity r5) {
        this.affinity = r5;
    }

    public final void setCursorValueReader(CursorValueReader r5) {
        this.cursorValueReader = r5;
    }

    public final void setGetter(FieldGetter r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.getter = r5;
    }

    public final void setIndexed(boolean r5) {
        this.indexed = r5;
    }

    public final void setSetter(FieldSetter r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.setter = r5;
    }

    public final void setStatementBinder(StatementValueBinder r5) {
        this.statementBinder = r5;
    }

    public final FieldBundle toBundle() {
        String r5 = getPathWithDotNotation();
        String r10 = this.columnName;
        SQLTypeAffinity r11 = this.affinity;
        if (r11 == null) goto L8;
        String r12 = r11.name();
        if (r12 == null) goto L8;
    L7:
        String r13 = r12;
        return new FieldBundle(r5, r10, r13, this.nonNull, this.defaultValue);
    L8:
        r12 = "TEXT";
        goto L7
    }

    public String toString() {
        return "Field(element=" + this.element + ", name=" + this.name + ", type=" + this.type + ", affinity=" + this.affinity + ", collate=" + this.collate + ", columnName=" + this.columnName + ", defaultValue=" + this.defaultValue + ", parent=" + this.parent + ", indexed=" + this.indexed + ", nonNull=" + this.nonNull + ")";
    }

    public /* synthetic */ Field(XFieldElement r15, String r16, XType r17, SQLTypeAffinity r18, Collate r19, String r20, String r21, EmbeddedField r22, boolean r23, boolean r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 16) == 0) goto L5;
        Collate r10 = null;
    L7:
        if ((r25 & 32) == 0) goto L9;
        String r11 = r16;
    L11:
        if ((r25 & 64) == 0) goto L13;
        String r12 = null;
    L15:
        if ((r25 & 128) == 0) goto L17;
        EmbeddedField r13 = null;
    L19:
        if ((r25 & 256) == 0) goto L21;
        boolean r14 = false;
    L23:
        if ((r25 & 512) == 0) goto L25;
        boolean r110 = Companion.calcNonNull(r17, r13);
    L26:
        this(r15, r16, r17, r18, r10, r11, r12, r13, r14, r110);
        return;
    L25:
        r110 = r24;
        goto L26
    L21:
        r14 = r23;
        goto L23
    L17:
        r13 = r22;
        goto L19
    L13:
        r12 = r21;
        goto L15
    L9:
        r11 = r20;
        goto L11
    L5:
        r10 = r19;
        goto L7
    }
}
