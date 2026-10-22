package androidx.room.processor;

import ai.j0;
import androidx.room.ColumnInfo;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XFieldElement;
import androidx.room.compiler.processing.XType;
import androidx.room.parser.Collate;
import androidx.room.parser.SQLTypeAffinity;
import androidx.room.preconditions.Checks;
import androidx.room.solver.types.ColumnTypeAdapter;
import androidx.room.vo.EmbeddedField;
import androidx.room.vo.Field;
import com.squareup.javapoet.x;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001*Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00126\u0010\f\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\r¢\u0006\u0002\u0010\u0015J&\u0010#\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010\u00122\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(H\u0002J\u0006\u0010)\u001a\u00020\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 RA\u0010\f\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Landroidx/room/processor/FieldProcessor;", "", "baseContext", "Landroidx/room/processor/Context;", "containing", "Landroidx/room/compiler/processing/XType;", "element", "Landroidx/room/compiler/processing/XFieldElement;", "bindingScope", "Landroidx/room/processor/FieldProcessor$BindingScope;", "fieldParent", "Landroidx/room/vo/EmbeddedField;", "onBindingError", "Lkotlin/Function2;", "Landroidx/room/vo/Field;", "Lkotlin/ParameterName;", "name", "field", "", "errorMsg", "", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XFieldElement;Landroidx/room/processor/FieldProcessor$BindingScope;Landroidx/room/vo/EmbeddedField;Lkotlin/jvm/functions/Function2;)V", "getBindingScope", "()Landroidx/room/processor/FieldProcessor$BindingScope;", "getContaining", "()Landroidx/room/compiler/processing/XType;", "context", "getContext", "()Landroidx/room/processor/Context;", "getElement", "()Landroidx/room/compiler/processing/XFieldElement;", "getFieldParent", "()Landroidx/room/vo/EmbeddedField;", "getOnBindingError", "()Lkotlin/jvm/functions/Function2;", "extractDefaultValue", "value", "affinity", "Landroidx/room/parser/SQLTypeAffinity;", "fieldNonNull", "", "process", "BindingScope", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FieldProcessor {
    private final BindingScope bindingScope;
    private final XType containing;
    private final Context context;
    private final XFieldElement element;
    private final EmbeddedField fieldParent;
    private final Function2<Field, String, Unit> onBindingError;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/room/processor/FieldProcessor$BindingScope;", "", "(Ljava/lang/String;I)V", "TWO_WAY", "BIND_TO_STMT", "READ_FROM_CURSOR", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum BindingScope extends Enum<BindingScope> {
        private static final /* synthetic */ BindingScope[] $VALUES = null;
        public static final BindingScope BIND_TO_STMT = null;
        public static final BindingScope READ_FROM_CURSOR = null;
        public static final BindingScope TWO_WAY = null;

        private static final /* synthetic */ BindingScope[] $values() {
            return new BindingScope[]{TWO_WAY, BIND_TO_STMT, READ_FROM_CURSOR};
        }

        static {
            TWO_WAY = new BindingScope("TWO_WAY", 0);
            BIND_TO_STMT = new BindingScope("BIND_TO_STMT", 1);
            READ_FROM_CURSOR = new BindingScope("READ_FROM_CURSOR", 2);
            $VALUES = $values();
        }

        private BindingScope(String r5, int r10) {
            super(r5, r10);
        }

        public static BindingScope valueOf(String r5) {
            return (BindingScope) Enum.valueOf(BindingScope.class, r5);
        }

        public static BindingScope[] values() {
            return (BindingScope[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[BindingScope.values().length];
            r5[BindingScope.TWO_WAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[BindingScope.BIND_TO_STMT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[BindingScope.READ_FROM_CURSOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FieldProcessor(Context r5, XType r10, XFieldElement r11, BindingScope r12, EmbeddedField r13, Function2<? super Field, ? super String, Unit> r14) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        Intrinsics.checkNotNullParameter(r10, "containing");
        Intrinsics.checkNotNullParameter(r11, "element");
        Intrinsics.checkNotNullParameter(r12, "bindingScope");
        Intrinsics.checkNotNullParameter(r14, "onBindingError");
        this.containing = r10;
        this.element = r11;
        this.bindingScope = r12;
        this.fieldParent = r13;
        this.onBindingError = r14;
        this.context = Context.fork$default(r5, r11, null, 2, null);
    }

    private final String extractDefaultValue(String r10, SQLTypeAffinity r11, boolean r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String r5 = StringsKt.trim(r10).toString().toLowerCase(Locale.ENGLISH);
        if (r11 != SQLTypeAffinity.TEXT) goto L17;
        if (Intrinsics.areEqual(r10, "[value-unspecified]") == false) goto L11;
    L9:
        r10 = null;
    L22:
        if (Intrinsics.areEqual(r5, "null") == false) goto L25;
        if (r12 == false) goto L25;
        this.context.getLogger().e(this.element, ProcessorErrors.DEFAULT_VALUE_NULLABILITY, new Object[0]);
    L25:
        return r10;
    L11:
        if (StringsKt.P(r5, "(") == true) goto L22;
        if (FieldProcessorKt.getSQLITE_VALUE_CONSTANTS().contains(r5) == true) goto L22;
        r10 = j0.k("'", StringsKt.trim(r10, new char[]{'\''}), "'");
        goto L22
    L17:
        if (Intrinsics.areEqual(r10, "[value-unspecified]") == true) goto L9;
        if (Intrinsics.areEqual(r5, "") == false) goto L22;
        goto L9
    }

    public final BindingScope getBindingScope() {
        return this.bindingScope;
    }

    public final XType getContaining() {
        return this.containing;
    }

    public final Context getContext() {
        return this.context;
    }

    public final XFieldElement getElement() {
        return this.element;
    }

    public final EmbeddedField getFieldParent() {
        return this.fieldParent;
    }

    public final Function2<Field, String, Unit> getOnBindingError() {
        return this.onBindingError;
    }

    public final Field process() {
        XType r10 = this.element.asMemberOf(this.containing);
        x r5 = r10.getTypeName();
        XAnnotationBox r11 = this.element.getAnnotation(Reflection.getOrCreateKotlinClass(ColumnInfo.class));
        String r12 = null;
        if (r11 == null) goto L5;
        ColumnInfo r13 = (ColumnInfo) r11.getValue();
    L6:
        String r14 = this.element.getName();
        if (r13 != null) goto L9;
    L11:
        String r15 = r14;
    L12:
        EmbeddedField r16 = this.fieldParent;
        if (r16 == null) goto L16;
        String r17 = r16.getPrefix();
        if (r17 == null) goto L16;
    L17:
        String r18 = j0.j(r17, r15);
        SQLTypeAffinity.Companion r19 = SQLTypeAffinity.Companion;     // Catch: NumberFormatException -> L24
        if (r13 == null) goto L21;
        Integer r20 = Integer.valueOf(r13.typeAffinity());     // Catch: NumberFormatException -> L24
    L22:
        SQLTypeAffinity r21 = r19.fromAnnotationValue(r20);     // Catch: NumberFormatException -> L24
    L25:
        Checks r22 = this.context.getChecker();
        XFieldElement r23 = this.element;
        ProcessorErrors r110 = ProcessorErrors.INSTANCE;
        r22.notBlank(r18, r23, r110.getCOLUMN_NAME_CANNOT_BE_EMPTY(), new Object[0]);
        this.context.getChecker().notUnbound(r5, this.element, r110.getCANNOT_USE_UNBOUND_GENERICS_IN_ENTITY_FIELDS(), new Object[0]);
        ColumnTypeAdapter r24 = this.context.getTypeAdapterStore().findColumnTypeAdapter(r10, r21, false);
        if (r24 == null) goto L31;
        SQLTypeAffinity r25 = r24.getTypeAffinity();
        if (r25 == null) goto L31;
        SQLTypeAffinity r111 = r25;
    L32:
        boolean r112 = Field.Companion.calcNonNull(r10, this.fieldParent);
        XFieldElement r26 = this.element;
        Collate.Companion r27 = Collate.Companion;
        if (r13 == null) goto L35;
        Integer r113 = Integer.valueOf(r13.collate());
    L36:
        Collate r28 = r27.fromAnnotationValue(r113);
        if (r13 == null) goto L39;
        r12 = r13.defaultValue();
    L39:
        String r114 = extractDefaultValue(r12, r111, r112);
        EmbeddedField r115 = this.fieldParent;
        if (r13 == null) goto L42;
        boolean r29 = r13.index();
    L43:
        Field r116 = new Field(r26, r14, r10, r21, r28, r18, r114, r115, r29, r112);
        int r30 = WhenMappings.$EnumSwitchMapping$0[this.bindingScope.ordinal()];
        if (r30 != 1) goto L46;
        r116.setStatementBinder(r24);
        r116.setCursorValueReader(r24);
        r116.setAffinity(r111);
        if (r24 != null) goto L67;
        this.onBindingError.mo2invoke(r116, r110.getCANNOT_FIND_COLUMN_TYPE_ADAPTER());
        return r116;
    L67:
        return r116;
    L46:
        if (r30 != 2) goto L48;
        r116.setStatementBinder(this.context.getTypeAdapterStore().findStatementValueBinder(r116.getType(), r116.getAffinity()));
        if (r116.getStatementBinder() != null) goto L65;
        this.onBindingError.mo2invoke(r116, r110.getCANNOT_FIND_STMT_BINDER());
        return r116;
    L65:
        return r116;
    L48:
        if (r30 != 3) goto L62;
        r116.setCursorValueReader(this.context.getTypeAdapterStore().findCursorValueReader(r116.getType(), r116.getAffinity()));
        if (r116.getCursorValueReader() != null) goto L63;
        this.onBindingError.mo2invoke(r116, r110.getCANNOT_FIND_CURSOR_READER());
        return r116;
    L63:
        return r116;
    L62:
        return r116;
    L42:
        r29 = false;
        goto L43
    L35:
        r113 = null;
    L31:
        r111 = r21;
        goto L32
    L21:
        r20 = null;
    L24:
        r21 = null;
    L16:
        r17 = "";
        goto L17
    L9:
        if (Intrinsics.areEqual(r13.name(), "[field-name]") == true) goto L11;
        r15 = r13.name();
        goto L12
    L5:
        r13 = null;
        goto L6
    }
}
