package androidx.room.processor;

import ai.j0;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XFieldElement;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.ext.Xtype_extKt;
import androidx.room.log.RLog;
import androidx.room.parser.SQLTypeAffinity;
import androidx.room.parser.SqlParser;
import androidx.room.preconditions.Checks;
import androidx.room.processor.cache.Cache;
import androidx.room.vo.EmbeddedField;
import androidx.room.vo.Entity;
import androidx.room.vo.EntityOrView;
import androidx.room.vo.Field;
import androidx.room.vo.Fields;
import androidx.room.vo.ForeignKey;
import androidx.room.vo.HasFieldsKt;
import androidx.room.vo.Index;
import androidx.room.vo.Pojo;
import androidx.room.vo.PrimaryKey;
import androidx.room.vo.Warning;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0002\u0010\nJ,\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013H\u0002J\u001e\u0010\u0019\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0013H\u0002J$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010\u001b\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0013H\u0002J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u0013H\u0002J\b\u0010$\u001a\u00020%H\u0002J$\u0010&\u001a\u00020\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0013H\u0002J(\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00132\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020%H\u0016J$\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00132\u0006\u00102\u001a\u000203H\u0002J$\u00104\u001a\b\u0012\u0004\u0012\u00020\u00180\u00132\f\u00105\u001a\b\u0012\u0004\u0012\u00020(0\u00132\u0006\u00102\u001a\u000203H\u0002R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Landroidx/room/processor/TableEntityProcessor;", "Landroidx/room/processor/EntityProcessor;", "baseContext", "Landroidx/room/processor/Context;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "referenceStack", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XTypeElement;Ljava/util/LinkedHashSet;)V", "context", "getContext", "()Landroidx/room/processor/Context;", "getElement", "()Landroidx/room/compiler/processing/XTypeElement;", "checkIndicesForForeignKeys", "", "entityForeignKeys", "", "Landroidx/room/vo/ForeignKey;", "primaryKey", "Landroidx/room/vo/PrimaryKey;", "indices", "Landroidx/room/vo/Index;", "choosePrimaryKey", "candidates", "typeElement", "collectPrimaryKeysFromEmbeddedFields", "embeddedFields", "Landroidx/room/vo/EmbeddedField;", "collectPrimaryKeysFromEntityAnnotations", "availableFields", "Landroidx/room/vo/Field;", "collectPrimaryKeysFromPrimaryKeyAnnotations", "fields", "doProcess", "Landroidx/room/vo/Entity;", "findAndValidatePrimaryKey", "loadSuperIndices", "Landroidx/room/processor/IndexInput;", "typeMirror", "Landroidx/room/compiler/processing/XType;", "tableName", "inherit", "", "process", "validateAndCreateForeignKeyReferences", "foreignKeyInputs", "Landroidx/room/processor/ForeignKeyInput;", "pojo", "Landroidx/room/vo/Pojo;", "validateAndCreateIndices", "inputs", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TableEntityProcessor implements EntityProcessor {
    private final Context context;
    private final XTypeElement element;
    private final LinkedHashSet<String> referenceStack;

    public TableEntityProcessor(Context r5, XTypeElement r10, LinkedHashSet<String> r11) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "referenceStack");
        this.element = r10;
        this.referenceStack = r11;
        this.context = Context.fork$default(r5, r10, null, 2, null);
    }

    public static final /* synthetic */ Entity access$doProcess(TableEntityProcessor r5) {
        return r5.doProcess();
    }

    private final void checkIndicesForForeignKeys(List<ForeignKey> r10, PrimaryKey r11, List<Index> r12) {
        Iterator<T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L25;
        List<Field> r5 = ((ForeignKey) r13.next()).getChildFields();
        ArrayList r14 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r15 = r5.iterator();
    L7:
        if (r15.hasNext() == false) goto L10;
        r14.add(((Field) r15.next()).getColumnName());
        goto L7
    L10:
        if (checkIndicesForForeignKeys$covers(r14, r11.getFields()) == true) goto L4;
        if (r12 != null) goto L13;
    L15:
        Iterator<T> r16 = r12.iterator();
    L17:
        if (r16.hasNext() == false) goto L22;
        if (checkIndicesForForeignKeys$covers(r14, ((Index) r16.next()).getFields()) == false) goto L17;
    L22:
        if (r14.size() == 1) goto L23;
        this.context.getLogger().w(Warning.MISSING_INDEX_ON_FOREIGN_KEY_CHILD, this.element, ProcessorErrors.INSTANCE.foreignKeyMissingIndexInChildColumns(r14), new Object[0]);
        goto L4
    L23:
        this.context.getLogger().w(Warning.MISSING_INDEX_ON_FOREIGN_KEY_CHILD, this.element, ProcessorErrors.INSTANCE.foreignKeyMissingIndexInChildColumn((String) r14.get(0)), new Object[0]);
        goto L4
    L13:
        if (r12.isEmpty() == false) goto L15;
    }

    private static final boolean checkIndicesForForeignKeys$covers(List<String> r5, List<Field> r10) {
        if (r10.size() < r5.size()) goto L16;
        Iterable r11 = CollectionsKt.withIndex(r5);
        if ((r11 instanceof Collection) == true) goto L7;
    L9:
        Iterator r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L15;
        IndexedValue r13 = (IndexedValue) r12.next();
        if (Intrinsics.areEqual(r10.get(r13.getIndex()).getColumnName(), r13.getValue()) == true) goto L11;
    L15:
        return true;
    L7:
        if (((Collection) r11).isEmpty() == false) goto L9;
    L16:
        return false;
    }

    private final PrimaryKey choosePrimaryKey(List<PrimaryKey> r10, XTypeElement r11) {
        ArrayList r5 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((PrimaryKey) r13).getDeclaredIn(), r11) == false) goto L4;
        r5.add(r13);
        goto L4
    L9:
        if (r5.size() != 1) goto L16;
        Iterator r14 = CollectionsKt.v(r10, r5).iterator();
    L12:
        if (r14.hasNext() == false) goto L37;
        PrimaryKey r15 = (PrimaryKey) r14.next();
        this.context.getLogger().d(this.element, j0.D(r15.toHumanReadableString(), " is overridden by ", ((PrimaryKey) CollectionsKt.first(r5)).toHumanReadableString()), new Object[0]);
        goto L12
    L37:
        return (PrimaryKey) CollectionsKt.first(r5);
    L16:
        if (r5.isEmpty() == false) goto L24;
        XType r16 = r11.getSuperClass();
        if (r16 == null) goto L38;
        if (Xtype_extKt.isNotNone(r16) == false) goto L38;
        XTypeElement r17 = r16.getTypeElement();
        Intrinsics.checkNotNull(r17);
        return choosePrimaryKey(r10, r17);
    L38:
        return PrimaryKey.Companion.getMISSING();
    L24:
        RLog r18 = this.context.getLogger();
        XTypeElement r19 = this.element;
        ProcessorErrors r20 = ProcessorErrors.INSTANCE;
        ArrayList r21 = new ArrayList(CollectionsKt.h(r5));
        Iterator r22 = r5.iterator();
    L26:
        if (r22.hasNext() == false) goto L28;
        r21.add(((PrimaryKey) r22.next()).toHumanReadableString());
        goto L26
    L28:
        r18.e(r19, r20.multiplePrimaryKeyAnnotations(r21), new Object[0]);
        return PrimaryKey.Companion.getMISSING();
    }

    private final List<PrimaryKey> collectPrimaryKeysFromEmbeddedFields(List<EmbeddedField> r10) {
        ArrayList r5 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L17;
        EmbeddedField r12 = (EmbeddedField) r11.next();
        XAnnotationBox r13 = r12.getField().getElement().getAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.PrimaryKey.class));
        if (r13 == null) goto L14;
        Checks r14 = this.context.getChecker();
        boolean r15 = true;
        if (((androidx.room.PrimaryKey) r13.getValue()).autoGenerate() == true) goto L10;
    L13:
        r14.check(r15, r12.getField().getElement(), ProcessorErrors.INSTANCE.getAUTO_INCREMENT_EMBEDDED_HAS_MULTIPLE_FIELDS(), new Object[0]);
        PrimaryKey r16 = new PrimaryKey(r12.getField().getElement().getEnclosingElement(), r12.getPojo().getFields(), ((androidx.room.PrimaryKey) r13.getValue()).autoGenerate());
    L15:
        if (r16 == null) goto L4;
        r5.add(r16);
        goto L4
    L10:
        if (r12.getPojo().getFields().size() == 1) goto L13;
        r15 = false;
        goto L13
    L14:
        r16 = null;
        goto L15
    L17:
        return r5;
    }

    private final List<PrimaryKey> collectPrimaryKeysFromEntityAnnotations(XTypeElement r14, List<Field> r15) {
        XAnnotationBox r5 = r14.getAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.Entity.class));
        if (r5 == null) goto L30;
        String[] r10 = ((androidx.room.Entity) r5.getValue()).primaryKeys();
        if (r10.length != 0) goto L7;
        List r11 = CollectionsKt.emptyList();
    L29:
        if (r11 == null) goto L30;
    L31:
        XType r12 = r14.getSuperClass();
        if (r12 != null) goto L34;
    L42:
        List<PrimaryKey> r13 = CollectionsKt.emptyList();
    L44:
        return CollectionsKt.plus(r13, r11);
    L34:
        if (Xtype_extKt.isNotNone(r12) == false) goto L42;
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L37:
        if (r17.hasNext() == false) goto L41;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(((Field) r18).getElement().getEnclosingElement(), r14) == true) goto L37;
        r16.add(r18);
        goto L37
    L41:
        XTypeElement r19 = r12.getTypeElement();
        Intrinsics.checkNotNull(r19);
        r13 = collectPrimaryKeysFromEntityAnnotations(r19, r16);
        goto L44
    L7:
        ArrayList r20 = new ArrayList();
        int r21 = r10.length;
        int r22 = 0;
    L8:
        if (r22 >= r21) goto L28;
        String r23 = r10[r22];
        Iterator<T> r24 = r15.iterator();
    L11:
        if (r24.hasNext() == false) goto L15;
        Object r25 = r24.next();
        if (Intrinsics.areEqual(((Field) r25).getColumnName(), r23) == false) goto L11;
    L16:
        Field r26 = (Field) r25;
        Checks r27 = this.context.getChecker();
        if (r26 == null) goto L19;
        boolean r28 = true;
    L20:
        ProcessorErrors r29 = ProcessorErrors.INSTANCE;
        ArrayList r110 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r111 = r15.iterator();
    L22:
        if (r111.hasNext() == false) goto L24;
        r110.add(((Field) r111.next()).getColumnName());
        goto L22
    L24:
        r27.check(r28, r14, r29.primaryKeyColumnDoesNotExist(r23, r110), new Object[0]);
        if (r26 == null) goto L27;
        r20.add(r26);
    L27:
        r22 = r22 + 1;
        goto L8
    L19:
        r28 = false;
        goto L20
    L15:
        r25 = null;
        goto L16
    L28:
        r11 = CollectionsKt.listOf(new PrimaryKey(r14, new Fields(r20), false));
    L30:
        r11 = CollectionsKt.emptyList();
        goto L31
    }

    private final List<PrimaryKey> collectPrimaryKeysFromPrimaryKeyAnnotations(List<Field> r10) {
        ArrayList r5 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        Field r12 = (Field) r11.next();
        XAnnotationBox r13 = r12.getElement().getAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.PrimaryKey.class));
        PrimaryKey r14 = null;
        if (r13 != null) goto L8;
    L11:
        if (r14 == null) goto L4;
        r5.add(r14);
        goto L4
    L8:
        if (r12.getParent() == null) goto L10;
        XFieldElement r15 = r12.getParent().getMRootParent().getField().getElement();
        Context.fork$default(this.context, r15, null, 2, null).getLogger().w(Warning.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED, r15, ProcessorErrors.INSTANCE.embeddedPrimaryKeyIsDropped(this.element.getQualifiedName(), r12.getName()), new Object[0]);
        goto L11
    L10:
        r14 = new PrimaryKey(r12.getElement().getEnclosingElement(), new Fields(r12), ((androidx.room.PrimaryKey) r13.getValue()).autoGenerate());
        goto L11
    L13:
        return r5;
    }

    private final Entity doProcess() {
        Checks r5 = this.context.getChecker();
        XTypeElement r10 = this.element;
        KClass<? extends Annotation> r11 = Reflection.getOrCreateKotlinClass(androidx.room.Entity.class);
        ProcessorErrors r12 = ProcessorErrors.INSTANCE;
        r5.hasAnnotation(r10, r11, r12.getENTITY_MUST_BE_ANNOTATED_WITH_ENTITY(), new Object[0]);
        XAnnotationBox<androidx.room.Entity> r13 = this.element.getAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.Entity.class));
        if (r13 == null) goto L5;
        EntityProcessor.Companion r14 = EntityProcessor.Companion;
        String r15 = r14.extractTableName(this.element, r13.getValue());
        List<IndexInput> r16 = r14.extractIndices(r13, r15);
        boolean r17 = r13.getValue().inheritSuperIndices();
        List<ForeignKeyInput> r18 = r14.extractForeignKeys(r13);
        String r19 = r15;
    L6:
        this.context.getChecker().notBlank(r19, this.element, r12.getENTITY_TABLE_NAME_CANNOT_BE_EMPTY(), new Object[0]);
        this.context.getChecker().check(!StringsKt.M(r19, "sqlite_"), this.element, r12.getENTITY_TABLE_NAME_CANNOT_START_WITH_SQLITE(), new Object[0]);
        Pojo r20 = PojoProcessor.Companion.createFor(this.context, this.element, FieldProcessor.BindingScope.TWO_WAY, null, this.referenceStack).process();
        this.context.getChecker().check(r20.getRelations().isEmpty(), this.element, r12.getRELATION_IN_ENTITY(), new Object[0]);
        Fields r21 = r20.getFields();
        ArrayList r22 = new ArrayList();
        Iterator<Field> r23 = r21.iterator();
    L8:
        if (r23.hasNext() == false) goto L12;
        Field r24 = r23.next();
        if (r24.getIndexed() == false) goto L8;
        r22.add(r24);
        goto L8
    L12:
        ArrayList r25 = new ArrayList();
        Iterator r26 = r22.iterator();
    L14:
        if (r26.hasNext() == false) goto L26;
        Field r27 = (Field) r26.next();
        IndexInput r110 = null;
        if (r27.getParent() == null) goto L19;
        r27.setIndexed(false);
        this.context.getLogger().w(Warning.INDEX_FROM_EMBEDDED_FIELD_IS_DROPPED, r27.getElement(), ProcessorErrors.INSTANCE.droppedEmbeddedFieldIndex(r27.getPath(), this.element.getQualifiedName()), new Object[0]);
    L23:
        if (r110 == null) goto L14;
        r25.add(r110);
        goto L14
    L19:
        if (Intrinsics.areEqual(r27.getElement().getEnclosingElement(), this.element) == true) goto L22;
        if (r17 == true) goto L22;
        r27.setIndexed(false);
        this.context.getLogger().w(Warning.INDEX_FROM_PARENT_FIELD_IS_DROPPED, ProcessorErrors.INSTANCE.droppedSuperClassFieldIndex(r27.getColumnName(), this.element.getQualifiedName(), r27.getElement().getEnclosingElement().getClassName().toString()), new Object[0]);
    L22:
        r110 = new IndexInput(EntityProcessor.Companion.createIndexName(CollectionsKt.listOf(r27.getColumnName()), r19), false, CollectionsKt.listOf(r27.getColumnName()), CollectionsKt.emptyList());
        goto L23
    L26:
        List<Index> r111 = validateAndCreateIndices(CollectionsKt.plus(CollectionsKt.plus(r16, r25), loadSuperIndices(this.element.getSuperClass(), r19, r17)), r20);
        PrimaryKey r112 = findAndValidatePrimaryKey(r20.getFields(), r20.getEmbeddedFields());
        Field r28 = (Field) CollectionsKt.firstOrNull(r112.getFields());
        if (r28 == null) goto L30;
        SQLTypeAffinity r29 = r28.getAffinity();
        if (r29 == null) goto L30;
    L31:
        Checks r30 = this.context.getChecker();
        if (r112.getAutoGenerateId() == true) goto L34;
    L37:
        boolean r31 = true;
    L38:
        Field r32 = (Field) CollectionsKt.firstOrNull(r112.getFields());
        if (r32 == null) goto L42;
        XElement r33 = r32.getElement();
        if (r33 == null) goto L42;
    L43:
        ProcessorErrors r34 = ProcessorErrors.INSTANCE;
        r30.check(r31, r33, r34.getAUTO_INCREMENTED_PRIMARY_KEY_IS_NOT_INT(), new Object[0]);
        List<ForeignKey> r35 = validateAndCreateForeignKeyReferences(r18, r20);
        checkIndicesForForeignKeys(r35, r112, r111);
        this.context.getChecker().check(SqlParser.Companion.isValidIdentifier(r19), this.element, r34.getINVALID_TABLE_NAME(), new Object[0]);
        Iterator<Field> r36 = r20.getFields().iterator();
    L45:
        if (r36.hasNext() == false) goto L48;
        Field r37 = r36.next();
        this.context.getChecker().check(SqlParser.Companion.isValidIdentifier(r37.getColumnName()), r37.getElement(), ProcessorErrors.INSTANCE.getINVALID_COLUMN_NAME(), new Object[0]);
        goto L45
    L48:
        return new Entity(this.element, r19, r20.getType(), r20.getFields(), r20.getEmbeddedFields(), r112, r111, r35, r20.getConstructor(), null);
    L42:
        r33 = this.element;
        goto L43
    L34:
        if (r29 == SQLTypeAffinity.INTEGER) goto L37;
        r31 = false;
    L30:
        r29 = SQLTypeAffinity.TEXT;
        goto L31
    L5:
        String r38 = this.element.getName();
        r18 = CollectionsKt.emptyList();
        r16 = CollectionsKt.emptyList();
        r19 = r38;
        r17 = false;
        goto L6
    }

    private final PrimaryKey findAndValidatePrimaryKey(List<Field> r12, List<EmbeddedField> r13) {
        List<PrimaryKey> r14 = CollectionsKt.plus(CollectionsKt.plus(collectPrimaryKeysFromEntityAnnotations(this.element, r12), collectPrimaryKeysFromPrimaryKeyAnnotations(r12)), collectPrimaryKeysFromEmbeddedFields(r13));
        this.context.getChecker().check(!r14.isEmpty(), this.element, ProcessorErrors.INSTANCE.getMISSING_PRIMARY_KEY(), new Object[0]);
        LinkedHashSet r15 = new LinkedHashSet();
        ArrayList r5 = new ArrayList();
        Iterator<T> r10 = r14.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r11 = r10.next();
        if (((PrimaryKey) r11).getAutoGenerateId() == true) goto L4;
        r5.add(r11);
        goto L4
    L8:
        Iterator r16 = r5.iterator();
    L10:
        if (r16.hasNext() == false) goto L30;
        PrimaryKey r17 = (PrimaryKey) r16.next();
        Iterator<Field> r18 = r17.getFields().iterator();
    L13:
        if (r18.hasNext() == false) goto L10;
        Field r19 = r18.next();
        if (r17.getFields().size() > 1) goto L21;
        if (r17.getFields().size() != 1) goto L13;
        if (r19.getAffinity() == SQLTypeAffinity.INTEGER) goto L13;
    L21:
        if (r15.contains(r19) == true) goto L23;
        this.context.getChecker().check(r19.getNonNull(), r19.getElement(), ProcessorErrors.INSTANCE.primaryKeyNull(r19.getPath()), new Object[0]);
        r15.add(r19);
    L23:
        EmbeddedField r20 = r19.getParent();
    L24:
        if (r20 == null) goto L13;
        Field r21 = r20.getField();
        if (r15.contains(r21) == true) goto L28;
        this.context.getChecker().check(r21.getNonNull(), r21.getElement(), ProcessorErrors.INSTANCE.primaryKeyNull(r21.getPath()), new Object[0]);
        r15.add(r21);
    L28:
        r20 = r21.getParent();
        goto L24
    L30:
        if (r14.size() != 1) goto L34;
        return (PrimaryKey) CollectionsKt.first(r14);
    L34:
        return choosePrimaryKey(r14, this.element);
    }

    private final List<IndexInput> loadSuperIndices(XType r10, String r11, boolean r12) {
        if (r10 == null) goto L27;
        if (r10.isNone() == true) goto L27;
        XTypeElement r13 = r10.getTypeElement();
        if (r13 == null) goto L9;
        XAnnotationBox<androidx.room.Entity> r5 = r13.getAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.Entity.class));
        if (r5 == null) goto L23;
        List<IndexInput> r14 = EntityProcessor.Companion.extractIndices(r5, "super");
        if (r14.isEmpty() == false) goto L15;
        List r15 = CollectionsKt.emptyList();
    L22:
        if (r15 == null) goto L23;
    L25:
        return CollectionsKt.plus(r15, loadSuperIndices(r13.getSuperClass(), r11, r12));
    L15:
        if (r12 == false) goto L21;
        ArrayList r16 = new ArrayList(CollectionsKt.h(r14));
        Iterator<T> r17 = r14.iterator();
    L18:
        if (r17.hasNext() == false) goto L20;
        IndexInput r18 = (IndexInput) r17.next();
        r16.add(new IndexInput(EntityProcessor.Companion.createIndexName(r18.getColumnNames(), r11), r18.getUnique(), r18.getColumnNames(), r18.getOrders()));
        goto L18
    L20:
        r15 = r16;
        goto L22
    L21:
        this.context.getLogger().w(Warning.INDEX_FROM_PARENT_IS_DROPPED, r13, ProcessorErrors.INSTANCE.droppedSuperClassIndex(this.element.getQualifiedName(), r13.getQualifiedName()), new Object[0]);
        r15 = CollectionsKt.emptyList();
    L23:
        r15 = CollectionsKt.emptyList();
        goto L25
    L9:
        return CollectionsKt.emptyList();
    L27:
        return CollectionsKt.emptyList();
    }

    private final List<ForeignKey> validateAndCreateForeignKeyReferences(List<ForeignKeyInput> r17, Pojo r18) {
        ArrayList r5 = new ArrayList(CollectionsKt.h(r17));
        Iterator<T> r10 = r17.iterator();
    L4:
        if (r10.hasNext() == false) goto L41;
        ForeignKeyInput r11 = (ForeignKeyInput) r10.next();
        ForeignKey r12 = null;
        if (r11.getOnUpdate() != null) goto L10;
        this.context.getLogger().e(this.element, ProcessorErrors.INSTANCE.getINVALID_FOREIGN_KEY_ACTION(), new Object[0]);
    L39:
        r5.add(r12);
        goto L4
    L10:
        if (r11.getOnDelete() != null) goto L13;
        this.context.getLogger().e(this.element, ProcessorErrors.INSTANCE.getINVALID_FOREIGN_KEY_ACTION(), new Object[0]);
        goto L39
    L13:
        if (r11.getChildColumns().isEmpty() == false) goto L16;
        this.context.getLogger().e(this.element, ProcessorErrors.INSTANCE.getFOREIGN_KEY_EMPTY_CHILD_COLUMN_LIST(), new Object[0]);
        goto L39
    L16:
        if (r11.getParentColumns().isEmpty() == false) goto L19;
        this.context.getLogger().e(this.element, ProcessorErrors.INSTANCE.getFOREIGN_KEY_EMPTY_PARENT_COLUMN_LIST(), new Object[0]);
        goto L39
    L19:
        if (r11.getChildColumns().size() == r11.getParentColumns().size()) goto L21;
        this.context.getLogger().e(this.element, ProcessorErrors.INSTANCE.foreignKeyColumnNumberMismatch(r11.getChildColumns(), r11.getParentColumns()), new Object[0]);
        goto L39
    L21:
        XTypeElement r13 = r11.getParent().getTypeElement();
        if (r13 != null) goto L24;
        this.context.getLogger().e(this.element, ProcessorErrors.INSTANCE.getFOREIGN_KEY_CANNOT_FIND_PARENT(), new Object[0]);
        goto L39
    L24:
        XAnnotationBox r14 = r13.getAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.Entity.class));
        if (r14 != null) goto L27;
        this.context.getLogger().e(this.element, ProcessorErrors.INSTANCE.foreignKeyNotAnEntity(r13.getQualifiedName()), new Object[0]);
        goto L39
    L27:
        String r15 = EntityProcessor.Companion.extractTableName(r13, (androidx.room.Entity) r14.getValue());
        List<String> r16 = r11.getChildColumns();
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r16.iterator();
    L29:
        if (r20.hasNext() == false) goto L36;
        String r21 = (String) r20.next();
        Field r22 = HasFieldsKt.findFieldByColumnName(r18, r21);
        if (r22 != null) goto L33;
        this.context.getLogger().e(r18.getElement(), ProcessorErrors.INSTANCE.foreignKeyChildColumnDoesNotExist(r21, HasFieldsKt.getColumnNames(r18)), new Object[0]);
    L33:
        if (r22 == null) goto L29;
        r19.add(r22);
        goto L29
    L36:
        if (r19.size() != r11.getChildColumns().size()) goto L39;
        r12 = new ForeignKey(r15, r11.getParentColumns(), r19, r11.getOnDelete(), r11.getOnUpdate(), r11.getDeferred());
        goto L39
    L41:
        return CollectionsKt.m(r5);
    }

    private final List<Index> validateAndCreateIndices(List<IndexInput> r14, Pojo r15) {
        ArrayList r5 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L3:
        boolean r10 = true;
        if (r16.hasNext() == false) goto L28;
        IndexInput r11 = (IndexInput) r16.next();
        this.context.getChecker().check(!r11.getColumnNames().isEmpty(), this.element, ProcessorErrors.INSTANCE.getINDEX_COLUMNS_CANNOT_BE_EMPTY(), new Object[0]);
        List<String> r12 = r11.getColumnNames();
        ArrayList r13 = new ArrayList();
        Iterator<T> r17 = r12.iterator();
    L7:
        if (r17.hasNext() == false) goto L16;
        String r18 = (String) r17.next();
        Field r19 = HasFieldsKt.findFieldByColumnName(r15, r18);
        Checks r20 = this.context.getChecker();
        if (r19 == null) goto L11;
        boolean r21 = true;
    L12:
        r20.check(r21, this.element, ProcessorErrors.INSTANCE.indexColumnDoesNotExist(r18, HasFieldsKt.getColumnNames(r15)), new Object[0]);
        if (r19 == null) goto L7;
        r13.add(r19);
        goto L7
    L11:
        r21 = false;
        goto L12
    L16:
        if (r11.getOrders().isEmpty() == true) goto L23;
        Checks r22 = this.context.getChecker();
        if (r11.getColumnNames().size() == r11.getOrders().size()) goto L21;
        r10 = false;
    L21:
        r22.check(r10, this.element, ProcessorErrors.INSTANCE.getINVALID_INDEX_ORDERS_SIZE(), new Object[0]);
    L23:
        if (r13.isEmpty() == false) goto L25;
        Index r23 = null;
    L26:
        if (r23 == null) goto L3;
        r5.add(r23);
        goto L3
    L25:
        r23 = new Index(r11.getName(), r11.getUnique(), r13, r11.getOrders());
        goto L26
    L28:
        LinkedHashMap r110 = new LinkedHashMap();
        Iterator r24 = r5.iterator();
    L30:
        if (r24.hasNext() == false) goto L35;
        Object r25 = r24.next();
        String r26 = ((Index) r25).getName();
        Object r27 = r110.get(r26);
        if (r27 != null) goto L34;
        r27 = new ArrayList();
        r110.put(r26, r27);
    L34:
        ((List) r27).add(r25);
        goto L30
    L35:
        LinkedHashMap r28 = new LinkedHashMap();
        Iterator r111 = r110.entrySet().iterator();
    L37:
        if (r111.hasNext() == false) goto L41;
        Map.Entry r29 = (Map.Entry) r111.next();
        if (((List) r29.getValue()).size() <= 1) goto L37;
        r28.put(r29.getKey(), r29.getValue());
        goto L37
    L41:
        Iterator r112 = r28.entrySet().iterator();
    L43:
        if (r112.hasNext() == false) goto L45;
        this.context.getLogger().e(this.element, ProcessorErrors.INSTANCE.duplicateIndexInEntity((String) ((Map.Entry) r112.next()).getKey()), new Object[0]);
        goto L43
    L45:
        Iterator<T> r113 = r15.getEmbeddedFields().iterator();
    L47:
        if (r113.hasNext() == false) goto L53;
        EmbeddedField r114 = (EmbeddedField) r113.next();
        XAnnotationBox<androidx.room.Entity> r30 = r114.getPojo().getElement().getAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.Entity.class));
        if (r30 == null) goto L47;
        if (EntityProcessor.Companion.extractIndices(r30, "").isEmpty() == true) goto L47;
        this.context.getLogger().w(Warning.INDEX_FROM_EMBEDDED_ENTITY_IS_DROPPED, r114.getField().getElement(), ProcessorErrors.INSTANCE.droppedEmbeddedIndex(XTypeNameKt.toJavaPoet(r114.getPojo().getTypeName()).toString(), r114.getField().getPath(), this.element.getQualifiedName()), new Object[0]);
        goto L47
    L53:
        return r5;
    }

    public final Context getContext() {
        return this.context;
    }

    public final XTypeElement getElement() {
        return this.element;
    }

    @Override // androidx.room.processor.EntityOrViewProcessor
    public /* bridge */ /* synthetic */ EntityOrView process() {
        return process();
    }

    @Override // androidx.room.processor.EntityProcessor, androidx.room.processor.EntityOrViewProcessor
    public Entity process() {
        return this.context.getCache().getEntities().get(new Cache.EntityKey(this.element), new AnonymousClass1(this));
    }

    public /* synthetic */ TableEntityProcessor(Context r5, XTypeElement r10, LinkedHashSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = new LinkedHashSet();
    L5:
        this(r5, r10, r11);
    }
}
