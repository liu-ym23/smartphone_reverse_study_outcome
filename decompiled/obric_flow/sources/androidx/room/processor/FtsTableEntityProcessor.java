package androidx.room.processor;

import ai.j0;
import androidx.room.Entity;
import androidx.room.Fts3;
import androidx.room.Fts4;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.parser.FtsVersion;
import androidx.room.parser.SQLTypeAffinity;
import androidx.room.preconditions.Checks;
import androidx.room.processor.cache.Cache;
import androidx.room.vo.EntityOrView;
import androidx.room.vo.Field;
import androidx.room.vo.Fields;
import androidx.room.vo.FtsEntity;
import androidx.room.vo.FtsOptions;
import androidx.room.vo.HasFieldsKt;
import androidx.room.vo.LanguageId;
import androidx.room.vo.Pojo;
import androidx.room.vo.PrimaryKey;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u001e\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\bH\u0002J&\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0016\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001bH\u0002J\u0016\u0010%\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020&0\u001bH\u0002J\b\u0010'\u001a\u00020\u0011H\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0011H\u0002R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/room/processor/FtsTableEntityProcessor;", "Landroidx/room/processor/EntityProcessor;", "baseContext", "Landroidx/room/processor/Context;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "referenceStack", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XTypeElement;Ljava/util/LinkedHashSet;)V", "context", "getContext", "()Landroidx/room/processor/Context;", "getElement", "()Landroidx/room/compiler/processing/XTypeElement;", "doProcess", "Landroidx/room/vo/FtsEntity;", "findAndValidateLanguageId", "Landroidx/room/vo/LanguageId;", "fields", "", "Landroidx/room/vo/Field;", "languageIdColumnName", "findAndValidatePrimaryKey", "Landroidx/room/vo/PrimaryKey;", "entityAnnotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "Landroidx/room/Entity;", "getContentEntity", "Landroidx/room/vo/Entity;", "entityType", "Landroidx/room/compiler/processing/XType;", "getFts3Options", "Landroidx/room/vo/FtsOptions;", "annotation", "Landroidx/room/Fts3;", "getFts4Options", "Landroidx/room/Fts4;", "process", "validateExternalContentEntity", "", "ftsEntity", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FtsTableEntityProcessor implements EntityProcessor {
    private final Context context;
    private final XTypeElement element;
    private final LinkedHashSet<String> referenceStack;

    public FtsTableEntityProcessor(Context r5, XTypeElement r10, LinkedHashSet<String> r11) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "referenceStack");
        this.element = r10;
        this.referenceStack = r11;
        this.context = Context.fork$default(r5, r10, null, 2, null);
    }

    public static final /* synthetic */ FtsEntity access$doProcess(FtsTableEntityProcessor r5) {
        return r5.doProcess();
    }

    private final FtsEntity doProcess() {
        Checks r5 = this.context.getChecker();
        XTypeElement r10 = this.element;
        KClass<? extends Annotation> r11 = Reflection.getOrCreateKotlinClass(Entity.class);
        ProcessorErrors r12 = ProcessorErrors.INSTANCE;
        r5.hasAnnotation(r10, r11, r12.getENTITY_MUST_BE_ANNOTATED_WITH_ENTITY(), new Object[0]);
        XAnnotationBox<Entity> r13 = this.element.getAnnotation(Reflection.getOrCreateKotlinClass(Entity.class));
        if (r13 == null) goto L6;
        EntityProcessor.Companion r14 = EntityProcessor.Companion;
        String r15 = r14.extractTableName(this.element, r13.getValue());
        this.context.getChecker().check(r14.extractIndices(r13, r15).isEmpty(), this.element, r12.getINDICES_IN_FTS_ENTITY(), new Object[0]);
        this.context.getChecker().check(r14.extractForeignKeys(r13).isEmpty(), this.element, r12.getFOREIGN_KEYS_IN_FTS_ENTITY(), new Object[0]);
    L5:
        String r16 = r15;
        Pojo r17 = PojoProcessor.Companion.createFor(this.context, this.element, FieldProcessor.BindingScope.TWO_WAY, null, this.referenceStack).process();
        this.context.getChecker().check(r17.getRelations().isEmpty(), this.element, r12.getRELATION_IN_ENTITY(), new Object[0]);
        if (this.element.hasAnnotation(Reflection.getOrCreateKotlinClass(Fts3.class)) == false) goto L10;
        FtsVersion r18 = FtsVersion.FTS3;
        XAnnotationBox<Fts3> r19 = this.element.getAnnotation(Reflection.getOrCreateKotlinClass(Fts3.class));
        Intrinsics.checkNotNull(r19);
        Pair r20 = TuplesKt.to(r18, getFts3Options(r19));
    L11:
        FtsVersion r110 = (FtsVersion) r20.component1();
        FtsOptions r111 = (FtsOptions) r20.component2();
        if (r111.getContentEntity() == null) goto L15;
        String r21 = r111.getContentEntity().getTableName();
    L14:
        String r112 = r21;
        PrimaryKey r113 = findAndValidatePrimaryKey(r13, r17.getFields());
        findAndValidateLanguageId(r17.getFields(), r111.getLanguageIdColumnName());
        List<String> r22 = CollectionsKt.v(r111.getNotIndexedColumns(), HasFieldsKt.getColumnNames(r17));
        this.context.getChecker().check(r22.isEmpty(), this.element, r12.missingNotIndexedField(r22), new Object[0]);
        Checks r23 = this.context.getChecker();
        List<Integer> r24 = r111.getPrefixSizes();
        boolean r25 = true;
        if (r24 != null) goto L19;
    L21:
        Iterator<T> r26 = r24.iterator();
    L23:
        if (r26.hasNext() == false) goto L28;
        if (((Number) r26.next()).intValue() > 0) goto L23;
        r25 = false;
    L28:
        r23.check(r25, this.element, ProcessorErrors.INSTANCE.getINVALID_FTS_ENTITY_PREFIX_SIZES(), new Object[0]);
        FtsEntity r27 = new FtsEntity(this.element, r16, r17.getType(), r17.getFields(), r17.getEmbeddedFields(), r113, r17.getConstructor(), r112, r110, r111);
        validateExternalContentEntity(r27);
        return r27;
    L19:
        if (r24.isEmpty() == false) goto L21;
    L15:
        r21 = j0.j(r16, "_content");
        goto L14
    L10:
        FtsVersion r28 = FtsVersion.FTS4;
        XAnnotationBox<Fts4> r29 = this.element.getAnnotation(Reflection.getOrCreateKotlinClass(Fts4.class));
        Intrinsics.checkNotNull(r29);
        r20 = TuplesKt.to(r28, getFts4Options(r29));
        goto L11
    L6:
        r15 = this.element.getName();
        goto L5
    }

    private final LanguageId findAndValidateLanguageId(List<Field> r5, String r10) {
        if (r10.length() == 0) goto L5;
        Iterator<T> r11 = r5.iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((Field) r12).getColumnName(), r10) == false) goto L8;
    L13:
        Field r13 = (Field) r12;
        if (r13 != null) goto L17;
        this.context.getLogger().e(this.element, ProcessorErrors.INSTANCE.missingLanguageIdField(r10), new Object[0]);
        return LanguageId.Companion.getMISSING();
    L17:
        Checks r14 = this.context.getChecker();
        if (r13.getAffinity() != SQLTypeAffinity.INTEGER) goto L20;
        boolean r15 = true;
    L21:
        r14.check(r15, r13.getElement(), ProcessorErrors.INSTANCE.getINVALID_FTS_ENTITY_LANGUAGE_ID_AFFINITY(), new Object[0]);
        return new LanguageId(r13.getElement(), r13);
    L20:
        r15 = false;
        goto L21
    L12:
        r12 = null;
        goto L13
    L5:
        return LanguageId.Companion.getMISSING();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.util.ArrayList] */
    private final PrimaryKey findAndValidatePrimaryKey(XAnnotationBox<Entity> r18, List<Field> r19) {
        boolean r5 = true;
        if (r18 == null) goto L32;
        Entity r10 = r18.getValue();
        if (r10 == null) goto L32;
        String[] r11 = r10.primaryKeys();
        if (r11 == null) goto L32;
        ?? r12 = new ArrayList();
        int r13 = r11.length;
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L33;
        String r15 = r11[r14];
        Iterator r16 = r19.iterator();
    L12:
        if (r16.hasNext() == false) goto L16;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((Field) r17).getColumnName(), r15) == false) goto L12;
    L17:
        Field r110 = (Field) r17;
        Checks r20 = this.context.getChecker();
        if (r110 == null) goto L20;
        boolean r111 = true;
    L21:
        XTypeElement r112 = this.element;
        ProcessorErrors r113 = ProcessorErrors.INSTANCE;
        ArrayList r114 = new ArrayList(CollectionsKt.h(r19));
        Iterator r115 = r19.iterator();
    L23:
        if (r115.hasNext() == false) goto L25;
        r114.add(((Field) r115.next()).getColumnName());
        goto L23
    L25:
        r20.check(r111, r112, r113.primaryKeyColumnDoesNotExist(r15, r114), new Object[0]);
        if (r110 == null) goto L28;
        PrimaryKey r21 = new PrimaryKey(r110.getElement().getEnclosingElement(), new Fields(r110), true);
    L29:
        if (r21 == null) goto L31;
        r12.add(r21);
    L31:
        r14 = r14 + 1;
        goto L9
    L28:
        r21 = null;
        goto L29
    L20:
        r111 = false;
        goto L21
    L16:
        r17 = null;
    L33:
        ArrayList r22 = new ArrayList();
        Iterator r23 = r19.iterator();
    L35:
        if (r23.hasNext() == false) goto L42;
        Field r24 = (Field) r23.next();
        if (r24.getElement().hasAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.PrimaryKey.class)) == false) goto L39;
        PrimaryKey r25 = new PrimaryKey(r24.getElement().getEnclosingElement(), new Fields(r24), true);
    L40:
        if (r25 == null) goto L35;
        r22.add(r25);
        goto L35
    L39:
        r25 = null;
        goto L40
    L42:
        List r26 = CollectionsKt.plus(r12, r22);
        if (r26.isEmpty() == false) goto L56;
        Iterator r27 = r19.iterator();
    L46:
        if (r27.hasNext() == false) goto L50;
        Object r28 = r27.next();
        if (Intrinsics.areEqual(((Field) r28).getColumnName(), "rowid") == false) goto L46;
        Object r29 = r28;
    L51:
        Field r30 = (Field) r29;
        if (r30 == null) goto L55;
        this.context.getChecker().check(r30.getElement().hasAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.PrimaryKey.class)), r30.getElement(), ProcessorErrors.INSTANCE.getMISSING_PRIMARY_KEYS_ANNOTATION_IN_ROW_ID(), new Object[0]);
    L55:
        return PrimaryKey.Companion.getMISSING();
    L50:
        r29 = null;
        goto L51
    L56:
        Checks r31 = this.context.getChecker();
        if (r26.size() != 1) goto L59;
        boolean r32 = true;
    L60:
        XTypeElement r33 = this.element;
        ProcessorErrors r34 = ProcessorErrors.INSTANCE;
        r31.check(r32, r33, r34.getTOO_MANY_PRIMARY_KEYS_IN_FTS_ENTITY(), new Object[0]);
        PrimaryKey r35 = (PrimaryKey) CollectionsKt.first(r26);
        Checks r36 = this.context.getChecker();
        boolean r37 = Intrinsics.areEqual(CollectionsKt.first(HasFieldsKt.getColumnNames(r35)), "rowid");
        XElement r38 = r35.getDeclaredIn();
        if (r38 != null) goto L63;
        r38 = this.element;
    L63:
        r36.check(r37, r38, r34.getINVALID_FTS_ENTITY_PRIMARY_KEY_NAME(), new Object[0]);
        Checks r39 = this.context.getChecker();
        if (((Field) CollectionsKt.first(r35.getFields())).getAffinity() == SQLTypeAffinity.INTEGER) goto L67;
        r5 = false;
    L67:
        XElement r40 = r35.getDeclaredIn();
        if (r40 != null) goto L70;
        r40 = this.element;
    L70:
        r39.check(r5, r40, r34.getINVALID_FTS_ENTITY_PRIMARY_KEY_AFFINITY(), new Object[0]);
        return r35;
    L59:
        r32 = false;
    L32:
        r12 = CollectionsKt.emptyList();
        goto L33
    }

    private final androidx.room.vo.Entity getContentEntity(XType r5) {
        if (r5 != null) goto L7;
        this.context.getLogger().e(this.element, ProcessorErrors.INSTANCE.getFTS_EXTERNAL_CONTENT_CANNOT_FIND_ENTITY(), new Object[0]);
        return null;
    L7:
        if (r5.isSameType(this.context.getProcessingEnv().requireType(Reflection.getOrCreateKotlinClass(Object.class))) == false) goto L9;
        return null;
    L9:
        XTypeElement r10 = r5.getTypeElement();
        if (r10 != null) goto L14;
        this.context.getLogger().e(this.element, ProcessorErrors.INSTANCE.getFTS_EXTERNAL_CONTENT_CANNOT_FIND_ENTITY(), new Object[0]);
        return null;
    L14:
        if (r10.hasAnnotation(Reflection.getOrCreateKotlinClass(Entity.class)) == true) goto L18;
        this.context.getLogger().e(r10, ProcessorErrors.INSTANCE.externalContentNotAnEntity(r10.getClassName().A), new Object[0]);
        return null;
    L18:
        return EntityProcessorKt.EntityProcessor(this.context, r10, this.referenceStack).process();
    }

    private final FtsOptions getFts3Options(XAnnotationBox<Fts3> r10) {
        return new FtsOptions(r10.getValue().tokenizer(), ArraysKt.asList(r10.getValue().tokenizerArgs()), null, "", androidx.room.FtsOptions.MatchInfo.FTS4, CollectionsKt.emptyList(), CollectionsKt.emptyList(), androidx.room.FtsOptions.Order.ASC);
    }

    private final FtsOptions getFts4Options(XAnnotationBox<Fts4> r11) {
        androidx.room.vo.Entity r5 = getContentEntity(r11.getAsType("contentEntity"));
        return new FtsOptions(r11.getValue().tokenizer(), ArraysKt.asList(r11.getValue().tokenizerArgs()), r5, r11.getValue().languageId(), r11.getValue().matchInfo(), ArraysKt.asList(r11.getValue().notIndexed()), ArraysKt.asList(r11.getValue().prefix()), r11.getValue().order());
    }

    private final void validateExternalContentEntity(FtsEntity r10) {
        androidx.room.vo.Entity r5 = r10.getFtsOptions().getContentEntity();
        if (r5 != null) goto L5;
        return;
    L5:
        List<Field> r11 = r10.getNonHiddenFields();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L20;
        Object r14 = r13.next();
        Field r15 = (Field) r14;
        Fields r16 = r5.getFields();
        if (r16 != null) goto L11;
    L13:
        Iterator<Field> r17 = r16.iterator();
    L15:
        if (r17.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(r17.next().getColumnName(), r15.getColumnName()) == false) goto L15;
    L19:
        r12.add(r14);
        goto L7
    L11:
        if (r16.isEmpty() == false) goto L13;
    L20:
        Iterator r18 = r12.iterator();
    L22:
        if (r18.hasNext() == false) goto L24;
        Field r19 = (Field) r18.next();
        this.context.getLogger().e(r19.getElement(), ProcessorErrors.INSTANCE.missingFtsContentField(this.element.getQualifiedName(), r19.getColumnName(), r5.getElement().getQualifiedName()), new Object[0]);
        goto L22
    }

    public final Context getContext() {
        return this.context;
    }

    public final XTypeElement getElement() {
        return this.element;
    }

    @Override // androidx.room.processor.EntityProcessor, androidx.room.processor.EntityOrViewProcessor
    public /* bridge */ /* synthetic */ androidx.room.vo.Entity process() {
        return process();
    }

    @Override // androidx.room.processor.EntityOrViewProcessor
    public /* bridge */ /* synthetic */ EntityOrView process() {
        return process();
    }

    @Override // androidx.room.processor.EntityProcessor, androidx.room.processor.EntityOrViewProcessor
    public FtsEntity process() {
        androidx.room.vo.Entity r5 = this.context.getCache().getEntities().get(new Cache.EntityKey(this.element), new AnonymousClass1(this));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.room.vo.FtsEntity");
        return (FtsEntity) r5;
    }

    public /* synthetic */ FtsTableEntityProcessor(Context r5, XTypeElement r10, LinkedHashSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = new LinkedHashSet();
    L5:
        this(r5, r10, r11);
    }
}
