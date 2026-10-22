package androidx.room.processor;

import androidx.room.SkipQueryVerification;
import androidx.room.b;
import androidx.room.compiler.codegen.XClassName;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.log.RLog;
import androidx.room.migration.bundle.DatabaseBundle;
import androidx.room.migration.bundle.SchemaBundle;
import androidx.room.parser.Table;
import androidx.room.util.SchemaFileResolver;
import androidx.room.verifier.DatabaseVerificationErrors;
import androidx.room.verifier.DatabaseVerifier;
import androidx.room.verifier.QueryResultInfo;
import androidx.room.vo.AutoMigration;
import androidx.room.vo.Dao;
import androidx.room.vo.DaoMethod;
import androidx.room.vo.Database;
import androidx.room.vo.DatabaseView;
import androidx.room.vo.DeleteOrUpdateShortcutMethod;
import androidx.room.vo.Entity;
import androidx.room.vo.Field;
import androidx.room.vo.ForeignKey;
import androidx.room.vo.FtsEntity;
import androidx.room.vo.HasFieldsKt;
import androidx.room.vo.Index;
import androidx.room.vo.InsertOrUpsertShortcutMethod;
import androidx.room.vo.ShortcutEntity;
import com.squareup.javapoet.e;
import com.squareup.javapoet.x;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0013J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J$\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0\u001c2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0\u001cJ\u001e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020'0\u001cH\u0002J\u001e\u0010.\u001a\u00020+2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020'0\u001cH\u0002J,\u0010/\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00052\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u001c2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020'0\u001cH\u0002J\u001e\u00102\u001a\u00020+2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020'0\u001cH\u0002J,\u00103\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0\u001cH\u0002J$\u00104\u001a\u00020+2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0!2\u0006\u00106\u001a\u000207H\u0002R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u00068"}, d2 = {"Landroidx/room/processor/DatabaseProcessor;", "", "baseContext", "Landroidx/room/processor/Context;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XTypeElement;)V", "context", "getContext", "()Landroidx/room/processor/Context;", "getElement", "()Landroidx/room/compiler/processing/XTypeElement;", "roomDatabaseType", "Landroidx/room/compiler/processing/XType;", "getRoomDatabaseType", "()Landroidx/room/compiler/processing/XType;", "roomDatabaseType$delegate", "Lkotlin/Lazy;", "doProcess", "Landroidx/room/vo/Database;", "getValidatedSchemaFile", "Ljava/io/File;", "version", "", "schemaFolderPath", "Ljava/nio/file/Path;", "process", "processAutoMigrations", "", "Landroidx/room/vo/AutoMigration;", "latestDbSchema", "Landroidx/room/migration/bundle/DatabaseBundle;", "processDatabaseViews", "", "Landroidx/room/vo/DatabaseView;", "dbAnnotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "Landroidx/room/Database;", "processEntities", "Landroidx/room/vo/Entity;", "resolveDatabaseViews", "views", "validateExternalContentFts", "", "dbElement", "entities", "validateForeignKeys", "validateUniqueDaoClasses", "daoMethods", "Landroidx/room/vo/DaoMethod;", "validateUniqueIndices", "validateUniqueTableAndViewNames", "verifyDatabaseViews", "map", "dbVerifier", "Landroidx/room/verifier/DatabaseVerifier;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DatabaseProcessor {
    private final Context context;
    private final XTypeElement element;
    private final Lazy roomDatabaseType$delegate;

    public DatabaseProcessor(Context r5, XTypeElement r10) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        Intrinsics.checkNotNullParameter(r10, "element");
        this.element = r10;
        this.context = Context.fork$default(r5, r10, null, 2, null);
        this.roomDatabaseType$delegate = LazyKt.lazy(new DatabaseProcessor$roomDatabaseType$2(this));
    }

    public static /* synthetic */ boolean a(Object r5, Function1 r10) {
        return resolveDatabaseViews$lambda$40(r10, r5);
    }

    private final Database doProcess() {
        XAnnotationBox<androidx.room.Database> r5 = this.element.getAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.Database.class));
        Intrinsics.checkNotNull(r5);
        List<Entity> r10 = processEntities(r5, this.element);
        Map<XTypeElement, DatabaseView> r11 = processDatabaseViews(r5);
        validateForeignKeys(this.element, r10);
        validateExternalContentFts(this.element, r10);
        this.context.getChecker().check(getRoomDatabaseType().isAssignableFrom(this.element.getType()), this.element, ProcessorErrors.INSTANCE.getDB_MUST_EXTEND_ROOM_DB(), new Object[0]);
        List<DatabaseView> r12 = resolveDatabaseViews(CollectionsKt.toList(r11.values()));
        if (this.element.hasAnnotation(Reflection.getOrCreateKotlinClass(SkipQueryVerification.class)) == false) goto L5;
        final DatabaseVerifier r13 = null;
    L6:
        if (r13 == null) goto L8;
        this.context.attachDatabaseVerifier(r13);
        verifyDatabaseViews(r11, r13);
    L8:
        validateUniqueTableAndViewNames(this.element, r10, r12);
        final XType r14 = this.element.getType();
        List<DaoMethod> r15 = SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filterNot(SequencesKt.filter(this.element.getAllMethods(), DatabaseProcessor$doProcess$daoMethods$1.INSTANCE), DatabaseProcessor$doProcess$daoMethods$2.INSTANCE), new DatabaseProcessor$doProcess$daoMethods$3(this, r14, r13)));
        validateUniqueDaoClasses(this.element, r15, r10);
        validateUniqueIndices(this.element, r10);
        if (r10 != null) goto L11;
    L13:
        Iterator<T> r16 = r10.iterator();
    L15:
        if (r16.hasNext() == false) goto L12;
        if (((Entity) r16.next()).getForeignKeys().isEmpty() == true) goto L15;
        boolean r17 = true;
    L19:
        int r18 = r5.getValue().version();
        XTypeElement r19 = this.element;
        Database r20 = new Database(r19, r19.getType(), r10, r12, r15, r18, r5.getValue().exportSchema(), r17);
        r20.setAutoMigrations(processAutoMigrations(this.element, r20.getBundle()));
        return r20;
    L12:
        r17 = false;
        goto L19
    L11:
        if (r10.isEmpty() == false) goto L13;
    L5:
        r13 = DatabaseVerifier.Companion.create(this.context, this.element, r10, r12);
        goto L6
    }

    private final File getValidatedSchemaFile(int r10, Path r11) {
        File r5 = SchemaFileResolver.Companion.getRESOLVER().getFile(r11.resolve(r10 + ".json"));
        if (r5.exists() == true) goto L7;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.autoMigrationSchemasNotFound(r10 + ".json", r11.toString()), new Object[]{this.element});
        return null;
    L7:
        if (r5.length() > 0) goto L10;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.autoMigrationSchemaIsEmpty(r10 + ".json", r11.toString()), new Object[]{this.element});
        return null;
    L10:
        return r5;
    }

    private final List<AutoMigration> processAutoMigrations(XTypeElement r13, DatabaseBundle r14) {
        XAnnotationBox r5 = r13.getAnnotation(Reflection.getOrCreateKotlinClass(androidx.room.Database.class));
        Intrinsics.checkNotNull(r5);
        XAnnotationBox[] r10 = r5.getAsAnnotationBoxArray("autoMigrations");
        if (r10.length != 0) goto L6;
    L13:
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
        int r15 = 0;
    L14:
        if (r15 >= r12) goto L47;
        XAnnotationBox r16 = r10[r15];
        String r17 = this.context.getSchemaOutFolderPath();
        Intrinsics.checkNotNull(r17);
        Path r18 = b.d(r17, new String[]{r13.getClassName().A});
        androidx.room.AutoMigration r19 = (androidx.room.AutoMigration) r16.getValue();
        File r20 = getValidatedSchemaFile(r19.from(), r18);
        AutoMigration r21 = null;
        if (r20 == null) goto L44;
        FileInputStream r110 = new FileInputStream(r20);
        Object r22 = processAutoMigrations$lambda$3$deserializeSchemaFile(r18, r110, r19.from());     // Catch: Throwable -> L39
        CloseableKt.closeFinally(r110, null);
        if (r19.to() != r14.getVersion()) goto L22;
        Object r23 = r14;
    L28:
        if ((r22 instanceof DatabaseBundle) == true) goto L30;
    L33:
        this.context.getLogger().e(r13, ProcessorErrors.INSTANCE.autoMigrationSchemasMustBeRoomGenerated(r19.from(), r19.to()), new Object[0]);
        goto L44
    L30:
        if ((r23 instanceof DatabaseBundle) == false) goto L33;
        Context r24 = this.context;
        XType r25 = r16.getAsType("spec");
        Intrinsics.checkNotNull(r25);
        r21 = new AutoMigrationProcessor(r24, r25, (DatabaseBundle) r22, (DatabaseBundle) r23).process();
        goto L44
    L22:
        File r111 = getValidatedSchemaFile(r19.to(), r18);
        if (r111 == null) goto L44;
        FileInputStream r112 = new FileInputStream(r111);
        r23 = processAutoMigrations$lambda$3$deserializeSchemaFile(r18, r112, r19.to());     // Catch: Throwable -> L34
        CloseableKt.closeFinally(r112, null);
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.closeFinally(r112, th);
        throw th;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r110, th);
        throw th;
    L44:
        if (r21 == null) goto L46;
        r11.add(r21);
    L46:
        r15 = r15 + 1;
        goto L14
    L47:
        return r11;
    L6:
        if (((androidx.room.Database) r5.getValue()).exportSchema() == true) goto L10;
        this.context.getLogger().e(r13, ProcessorErrors.INSTANCE.getAUTO_MIGRATION_FOUND_BUT_EXPORT_SCHEMA_OFF(), new Object[0]);
        return CollectionsKt.emptyList();
    L10:
        if (this.context.getSchemaOutFolderPath() != null) goto L13;
        this.context.getLogger().e(r13, ProcessorErrors.INSTANCE.getAUTO_MIGRATION_SCHEMA_OUT_FOLDER_NULL(), new Object[0]);
        return CollectionsKt.emptyList();
    }

    private static final Object processAutoMigrations$lambda$3$deserializeSchemaFile(Path r5, FileInputStream r10, int r11) {
        return SchemaBundle.Companion.deserialize(r10).getDatabase();
    L5:
        return ProcessorErrors.INSTANCE.invalidAutoMigrationSchema(r11 + ".json", r5.toString());
    }

    private final Map<XTypeElement, DatabaseView> processDatabaseViews(XAnnotationBox<androidx.room.Database> r10) {
        List<XType> r11 = r10.getAsTypeList("views");
        ArrayList r5 = new ArrayList();
        Iterator<T> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        XType r13 = (XType) r12.next();
        XTypeElement r14 = r13.getTypeElement();
        if (r14 != null) goto L8;
        this.context.getLogger().e(this.element, ProcessorErrors.INSTANCE.invalidViewTypeInDatabaseAnnotation(r13.getTypeName()), new Object[0]);
        Pair r15 = null;
    L9:
        if (r15 == null) goto L4;
        r5.add(r15);
        goto L4
    L8:
        r15 = TuplesKt.to(r14, new DatabaseViewProcessor(this.context, r14, null, 4, null).process());
        goto L9
    L12:
        return MapsKt.toMap(r5);
    }

    private final List<Entity> processEntities(XAnnotationBox<androidx.room.Database> r10, XTypeElement r11) {
        List<XType> r12 = r10.getAsTypeList("entities");
        this.context.getChecker().check(!r12.isEmpty(), r11, ProcessorErrors.INSTANCE.getDATABASE_ANNOTATION_MUST_HAVE_LIST_OF_ENTITIES(), new Object[0]);
        ArrayList r5 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        XType r14 = (XType) r13.next();
        XTypeElement r15 = r14.getTypeElement();
        Entity r16 = null;
        if (r15 != null) goto L8;
        this.context.getLogger().e(r11, ProcessorErrors.INSTANCE.invalidEntityTypeInDatabaseAnnotation(r14.getTypeName()), new Object[0]);
    L9:
        if (r16 == null) goto L4;
        r5.add(r16);
        goto L4
    L8:
        r16 = EntityProcessorKt.EntityProcessor$default(this.context, r15, null, 4, null).process();
        goto L9
    L11:
        return r5;
    }

    private static final boolean resolveDatabaseViews$isTable(List<String> r5, String r10) {
        if (r5 != null) goto L5;
    L7:
        Iterator<T> r11 = r5.iterator();
    L9:
        if (r11.hasNext() == false) goto L18;
        if (StringsKt.l((String) r11.next(), r10) == false) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return true;
    }

    private static final boolean resolveDatabaseViews$lambda$40(Function1 r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "$tmp0");
        return ((Boolean) r5.invoke(r10)).booleanValue();
    }

    private final void validateExternalContentFts(XTypeElement r10, List<? extends Entity> r11) {
        List r5 = CollectionsKt.l(r11, FtsEntity.class);
        ArrayList r12 = new ArrayList();
        Iterator r13 = r5.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        Object r14 = r13.next();
        FtsEntity r15 = (FtsEntity) r14;
        if (r15.getFtsOptions().getContentEntity() == null) goto L4;
        if (r11.contains(r15.getFtsOptions().getContentEntity()) == true) goto L4;
        r12.add(r14);
        goto L4
    L11:
        Iterator r16 = r12.iterator();
    L13:
        if (r16.hasNext() == false) goto L15;
        FtsEntity r17 = (FtsEntity) r16.next();
        RLog r18 = this.context.getLogger();
        ProcessorErrors r19 = ProcessorErrors.INSTANCE;
        String r20 = r17.getElement().getQualifiedName();
        Entity r21 = r17.getFtsOptions().getContentEntity();
        Intrinsics.checkNotNull(r21);
        r18.e(r10, r19.missingExternalContentEntity(r20, r21.getElement().getQualifiedName()), new Object[0]);
        goto L13
    }

    private final void validateForeignKeys(XTypeElement r18, List<? extends Entity> r19) {
        LinkedHashMap r5 = new LinkedHashMap(androidx.constraintlayout.motion.widget.a.e(r19, 16));
        Iterator<T> r10 = r19.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Object r11 = r10.next();
        r5.put(((Entity) r11).getTableName(), r11);
        goto L4
    L6:
        Iterator r12 = r19.iterator();
    L8:
        if (r12.hasNext() == false) goto L37;
        Entity r13 = (Entity) r12.next();
        Iterator<T> r14 = r13.getForeignKeys().iterator();
    L11:
        if (r14.hasNext() == false) goto L8;
        ForeignKey r15 = (ForeignKey) r14.next();
        Entity r16 = (Entity) r5.get(r15.getParentTable());
        if (r16 != null) goto L15;
        this.context.getLogger().e(r18, ProcessorErrors.INSTANCE.foreignKeyMissingParentEntityInDatabase(r15.getParentTable(), r13.getElement().getQualifiedName()), new Object[0]);
        Iterator r17 = r12;
    L35:
        r12 = r17;
        goto L11
    L15:
        List<String> r20 = r15.getParentColumns();
        ArrayList r110 = new ArrayList();
        Iterator<T> r21 = r20.iterator();
    L17:
        if (r21.hasNext() == false) goto L25;
        String r111 = (String) r21.next();
        Field r112 = HasFieldsKt.findFieldByColumnName(r16, r111);
        if (r112 != null) goto L22;
        this.context.getLogger().e(r13.getElement(), ProcessorErrors.INSTANCE.foreignKeyParentColumnDoesNotExist(r16.getElement().getQualifiedName(), r111, HasFieldsKt.getColumnNames(r16)), new Object[0]);
    L22:
        if (r112 == null) goto L24;
        r110.add(r112);
    L24:
        r12 = r12;
        goto L17
    L25:
        r17 = r12;
        if (r110.size() != r15.getParentColumns().size()) goto L35;
        if (r16.isUnique(r15.getParentColumns()) == true) goto L35;
        RLog r22 = this.context.getLogger();
        XTypeElement r23 = r16.getElement();
        ProcessorErrors r24 = ProcessorErrors.INSTANCE;
        String r25 = r16.getElement().getQualifiedName();
        String r113 = r13.getElement().getQualifiedName();
        List<String> r114 = r15.getParentColumns();
        List<Field> r26 = r15.getChildFields();
        ArrayList r115 = new ArrayList(CollectionsKt.h(r26));
        Iterator<T> r27 = r26.iterator();
    L32:
        if (r27.hasNext() == false) goto L34;
        r115.add(((Field) r27.next()).getColumnName());
        goto L32
    L34:
        r22.e(r23, r24.foreignKeyMissingIndexInParent(r25, r114, r113, r115), new Object[0]);
        goto L35
    }

    private final void validateUniqueDaoClasses(final XTypeElement r10, List<DaoMethod> r11, List<? extends Entity> r12) {
        ArrayList r5 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r5.add(XTypeNameKt.toJavaPoet(((Entity) r13.next()).getTypeName()));
        goto L4
    L6:
        final Set r14 = CollectionsKt.toSet(r5);
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator<T> r16 = r11.iterator();
    L8:
        if (r16.hasNext() == false) goto L13;
        Object r17 = r16.next();
        XClassName r18 = ((DaoMethod) r17).getDao().getTypeName();
        Object r19 = r15.get(r18);
        if (r19 != null) goto L12;
        r19 = new ArrayList();
        r15.put(r18, r19);
    L12:
        ((List) r19).add(r17);
        goto L8
    L13:
        Iterator r20 = r15.entrySet().iterator();
    L15:
        if (r20.hasNext() == false) goto L27;
        Map.Entry r21 = (Map.Entry) r20.next();
        if (((List) r21.getValue()).size() <= 1) goto L15;
        ProcessorErrors r22 = ProcessorErrors.INSTANCE;
        e r23 = XTypeNameKt.toJavaPoet((XClassName) r21.getKey());
        Iterable r24 = (Iterable) r21.getValue();
        ArrayList r25 = new ArrayList(CollectionsKt.h(r24));
        Iterator r26 = r24.iterator();
    L20:
        if (r26.hasNext() == false) goto L22;
        r25.add(((DaoMethod) r26.next()).getElement().getJvmName());
        goto L20
    L22:
        String r27 = r22.duplicateDao(r23, r25);
        Iterator r28 = ((Iterable) r21.getValue()).iterator();
    L24:
        if (r28.hasNext() == false) goto L26;
        DaoMethod r29 = (DaoMethod) r28.next();
        this.context.getLogger().e(r29.getElement(), ProcessorErrors.INSTANCE.getDAO_METHOD_CONFLICTS_WITH_OTHERS(), new Object[0]);
        goto L24
    L26:
        this.context.getLogger().e(r10, r27, new Object[0]);
        goto L15
    L27:
        Function3<XElement, Dao, x, Unit> r30 = new DatabaseProcessor$validateUniqueDaoClasses$check$1(r14, this, r10);
        Iterator<T> r31 = r11.iterator();
    L29:
        if (r31.hasNext() == false) goto L44;
        DaoMethod r32 = (DaoMethod) r31.next();
        Iterator<T> r33 = r32.getDao().getDeleteOrUpdateShortcutMethods().iterator();
    L32:
        if (r33.hasNext() == false) goto L37;
        DeleteOrUpdateShortcutMethod r110 = (DeleteOrUpdateShortcutMethod) r33.next();
        Iterator<Map.Entry<String, ShortcutEntity>> r34 = r110.getEntities().entrySet().iterator();
    L35:
        if (r34.hasNext() == false) goto L32;
        Map.Entry<String, ShortcutEntity> r35 = r34.next();
        r30.invoke(r110.getElement(), r32.getDao(), r35.getValue().getEntityTypeName());
        goto L35
    L37:
        Iterator<T> r36 = r32.getDao().getInsertOrUpsertShortcutMethods().iterator();
    L39:
        if (r36.hasNext() == false) goto L29;
        InsertOrUpsertShortcutMethod r111 = (InsertOrUpsertShortcutMethod) r36.next();
        Iterator<Map.Entry<String, ShortcutEntity>> r37 = r111.getEntities().entrySet().iterator();
    L42:
        if (r37.hasNext() == false) goto L39;
        Map.Entry<String, ShortcutEntity> r38 = r37.next();
        r30.invoke(r111.getElement(), r32.getDao(), r38.getValue().getEntityTypeName());
        goto L42
    }

    private final void validateUniqueIndices(XTypeElement r10, List<? extends Entity> r11) {
        ArrayList r5 = new ArrayList();
        Iterator<T> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        Entity r13 = (Entity) r12.next();
        List<Index> r14 = r13.getIndices();
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator<T> r16 = r14.iterator();
    L7:
        if (r16.hasNext() == false) goto L9;
        r15.add(new Pair(((Index) r16.next()).getName(), r13));
        goto L7
    L9:
        CollectionsKt.a(r5, r15);
        goto L4
    L10:
        LinkedHashMap r17 = new LinkedHashMap();
        Iterator r18 = r5.iterator();
    L12:
        if (r18.hasNext() == false) goto L17;
        Object r19 = r18.next();
        String r20 = (String) ((Pair) r19).getFirst();
        Object r21 = r17.get(r20);
        if (r21 != null) goto L16;
        r21 = new ArrayList();
        r17.put(r20, r21);
    L16:
        ((List) r21).add(r19);
        goto L12
    L17:
        LinkedHashMap r22 = new LinkedHashMap();
        Iterator r110 = r17.entrySet().iterator();
    L19:
        if (r110.hasNext() == false) goto L23;
        Map.Entry r23 = (Map.Entry) r110.next();
        if (((List) r23.getValue()).size() <= 1) goto L19;
        r22.put(r23.getKey(), r23.getValue());
        goto L19
    L23:
        Iterator r111 = r22.entrySet().iterator();
    L25:
        if (r111.hasNext() == false) goto L39;
        Map.Entry r24 = (Map.Entry) r111.next();
        Iterable r25 = (Iterable) r24.getValue();
        HashSet r26 = new HashSet();
        ArrayList r27 = new ArrayList();
        Iterator r28 = r25.iterator();
    L28:
        if (r28.hasNext() == false) goto L33;
        Object r29 = r28.next();
        if (r26.add(XTypeNameKt.toJavaPoet(((Entity) ((Pair) r29).getSecond()).getTypeName())) == false) goto L28;
        r27.add(r29);
        goto L28
    L33:
        if (r27.size() <= 1) goto L25;
        RLog r30 = this.context.getLogger();
        ProcessorErrors r31 = ProcessorErrors.INSTANCE;
        String r32 = (String) r24.getKey();
        Iterable r33 = (Iterable) r24.getValue();
        ArrayList r34 = new ArrayList(CollectionsKt.h(r33));
        Iterator r35 = r33.iterator();
    L36:
        if (r35.hasNext() == false) goto L38;
        Pair r36 = (Pair) r35.next();
        r34.add(XTypeNameKt.toJavaPoet(((Entity) r36.getSecond()).getTypeName()) + " > " + r36.getFirst());
        goto L36
    L38:
        r30.e(r10, r31.duplicateIndexInDatabase(r32, r34), new Object[0]);
        goto L25
    }

    private final void validateUniqueTableAndViewNames(XTypeElement r10, List<? extends Entity> r11, List<DatabaseView> r12) {
        ArrayList r5 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Entity r14 = (Entity) r13.next();
        r5.add(new Triple(r14.getTableName().toLowerCase(Locale.US), XTypeNameKt.toJavaPoet(r14.getTypeName()).toString(), r14.getElement()));
        goto L4
    L6:
        ArrayList r15 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r16 = r12.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        DatabaseView r17 = (DatabaseView) r16.next();
        r15.add(new Triple(r17.getViewName().toLowerCase(Locale.US), XTypeNameKt.toJavaPoet(r17.getTypeName()).toString(), r17.getElement()));
        goto L8
    L10:
        List r18 = CollectionsKt.plus(r5, r15);
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator r20 = r18.iterator();
    L12:
        if (r20.hasNext() == false) goto L17;
        Object r21 = r20.next();
        String r22 = (String) ((Triple) r21).component1();
        Object r23 = r19.get(r22);
        if (r23 != null) goto L16;
        r23 = new ArrayList();
        r19.put(r22, r23);
    L16:
        ((List) r23).add(r21);
        goto L12
    L17:
        LinkedHashMap r24 = new LinkedHashMap();
        Iterator r25 = r19.entrySet().iterator();
    L19:
        if (r25.hasNext() == false) goto L23;
        Map.Entry r26 = (Map.Entry) r25.next();
        if (((List) r26.getValue()).size() <= 1) goto L19;
        r24.put(r26.getKey(), r26.getValue());
        goto L19
    L23:
        Iterator r27 = r24.entrySet().iterator();
    L25:
        if (r27.hasNext() == false) goto L35;
        Map.Entry r28 = (Map.Entry) r27.next();
        ProcessorErrors r29 = ProcessorErrors.INSTANCE;
        String r30 = (String) r28.getKey();
        Iterable r31 = (Iterable) r28.getValue();
        ArrayList r32 = new ArrayList(CollectionsKt.h(r31));
        Iterator r33 = r31.iterator();
    L28:
        if (r33.hasNext() == false) goto L30;
        r32.add((String) ((Triple) r33.next()).component2());
        goto L28
    L30:
        String r34 = r29.duplicateTableNames(r30, r32);
        Iterator r35 = ((Iterable) r28.getValue()).iterator();
    L32:
        if (r35.hasNext() == false) goto L34;
        XTypeElement r36 = (XTypeElement) ((Triple) r35.next()).component3();
        this.context.getLogger().e(r36, r34, new Object[0]);
        goto L32
    L34:
        this.context.getLogger().e(r10, r34, new Object[0]);
        goto L25
    }

    private final void verifyDatabaseViews(Map<XTypeElement, DatabaseView> r5, DatabaseVerifier r10) {
        Iterator<Map.Entry<XTypeElement, DatabaseView>> r11 = r5.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        Map.Entry<XTypeElement, DatabaseView> r12 = r11.next();
        XTypeElement r13 = r12.getKey();
        DatabaseView r14 = r12.getValue();
        if (r13.hasAnnotation(Reflection.getOrCreateKotlinClass(SkipQueryVerification.class)) == true) goto L4;
        r14.getQuery().setResultInfo(r10.analyze(r14.getQuery().getOriginal()));
        QueryResultInfo r15 = r14.getQuery().getResultInfo();
        if (r15 == null) goto L11;
        SQLException r16 = r15.getError();
    L12:
        if (r16 == null) goto L4;
        RLog r17 = this.context.getLogger();
        DatabaseVerificationErrors r18 = DatabaseVerificationErrors.INSTANCE;
        QueryResultInfo r19 = r14.getQuery().getResultInfo();
        Intrinsics.checkNotNull(r19);
        SQLException r20 = r19.getError();
        Intrinsics.checkNotNull(r20);
        r17.e(r13, r18.cannotVerifyQuery(r20), new Object[0]);
        goto L4
    L11:
        r16 = null;
        goto L12
    }

    public final Context getContext() {
        return this.context;
    }

    public final XTypeElement getElement() {
        return this.element;
    }

    public final XType getRoomDatabaseType() {
        return (XType) this.roomDatabaseType$delegate.getValue();
    }

    public final Database process() {
        Database r5 = doProcess();     // Catch: Throwable -> L7
        DatabaseVerifier r10 = this.context.getDatabaseVerifier();
        if (r10 == null) goto L6;
        r10.closeConnection(this.context);
    L6:
        return r5;
    L7:
        th = move-exception;
        DatabaseVerifier r11 = this.context.getDatabaseVerifier();
        if (r11 == null) goto L11;
        r11.closeConnection(this.context);
    L11:
        throw th;
    }

    public final List<DatabaseView> resolveDatabaseViews(List<DatabaseView> r12) {
        Intrinsics.checkNotNullParameter(r12, "views");
        if (r12.isEmpty() == true) goto L5;
        ArrayList r5 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r10 = r12.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r5.add(((DatabaseView) r10.next()).getViewName());
        goto L8
    L10:
        Iterator<DatabaseView> r11 = r12.iterator();
    L12:
        if (r11.hasNext() == false) goto L18;
        DatabaseView r13 = r11.next();
        Set<String> r14 = r13.getTables();
        Set<Table> r15 = r13.getQuery().getTables();
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L15:
        if (r17.hasNext() == false) goto L17;
        r16.add(((Table) r17.next()).component1());
        goto L15
    L17:
        r14.addAll(r16);
        goto L12
    L18:
        List r18 = CollectionsKt.toMutableList(r12);
        LinkedHashMap r19 = new LinkedHashMap();
        ArrayList r20 = new ArrayList();
    L19:
        Iterator r21 = r19.entrySet().iterator();
    L21:
        if (r21.hasNext() == false) goto L28;
        Map.Entry r22 = (Map.Entry) r21.next();
        final String r23 = (String) r22.getKey();
        Set r24 = (Set) r22.getValue();
        Iterator r25 = r18.iterator();
    L24:
        if (r25.hasNext() == false) goto L21;
        DatabaseView r26 = (DatabaseView) r25.next();
        Set<String> r27 = r26.getTables();
        final Function1<String, Boolean> r28 = new AnonymousClass2(r23);
        if (r27.removeIf(new a(r28)) == false) goto L24;
        r26.getTables().addAll(r24);
        goto L24
    L28:
        ArrayList r29 = new ArrayList();
        Iterator r30 = r18.iterator();
    L30:
        if (r30.hasNext() == false) goto L43;
        Object r31 = r30.next();
        Set<String> r32 = ((DatabaseView) r31).getTables();
        if ((r32 instanceof Collection) == true) goto L34;
    L36:
        Iterator<T> r33 = r32.iterator();
    L38:
        if (r33.hasNext() == false) goto L42;
        if (resolveDatabaseViews$isTable(r5, (String) r33.next()) == true) goto L38;
    L42:
        r29.add(r31);
        goto L30
    L34:
        if (r32.isEmpty() == false) goto L36;
    L43:
        Iterator r34 = r29.iterator();
        int r35 = 0;
    L45:
        if (r34.hasNext() == false) goto L47;
        DatabaseView r36 = (DatabaseView) r34.next();
        r19.put(r36.getViewName(), r36.getTables());
        r18.remove(r36);
        r20.add(r36);
        r35 = r35 + 1;
        goto L45
    L47:
        if (r35 == 0) goto L48;
        if (r18.isEmpty() == false) goto L19;
    L55:
        return r20;
    L48:
        RLog r37 = this.context.getLogger();
        XTypeElement r110 = this.element;
        ProcessorErrors r38 = ProcessorErrors.INSTANCE;
        ArrayList r39 = new ArrayList(CollectionsKt.h(r18));
        Iterator r111 = r18.iterator();
    L50:
        if (r111.hasNext() == false) goto L52;
        r39.add(((DatabaseView) r111.next()).getViewName());
        goto L50
    L52:
        r37.e(r110, r38.viewCircularReferenceDetected(r39), new Object[0]);
        goto L55
    L5:
        return CollectionsKt.emptyList();
    }
}
