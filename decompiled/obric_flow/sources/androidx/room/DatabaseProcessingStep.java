package androidx.room;

import androidx.room.compiler.codegen.CodeLanguage;
import androidx.room.compiler.codegen.XClassName;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XProcessingEnvConfig;
import androidx.room.compiler.processing.XProcessingStep;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.log.RLog;
import androidx.room.processor.Context;
import androidx.room.processor.ProcessorErrors;
import androidx.room.util.SchemaFileResolver;
import androidx.room.vo.DaoMethod;
import androidx.room.vo.Warning;
import androidx.room.writer.AutoMigrationWriter;
import androidx.room.writer.DaoWriter;
import androidx.room.writer.DatabaseWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J$\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0002J8\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00040\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0017"}, d2 = {"Landroidx/room/DatabaseProcessingStep;", "Landroidx/room/compiler/processing/XProcessingStep;", "()V", "annotations", "", "", "prepareDaosForWriting", "", "databases", "", "Landroidx/room/vo/Database;", "daoMethods", "Landroidx/room/vo/DaoMethod;", "process", "Landroidx/room/compiler/processing/XTypeElement;", "env", "Landroidx/room/compiler/processing/XProcessingEnv;", "elementsByAnnotation", "", "Landroidx/room/compiler/processing/XElement;", "isLastRound", "", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DatabaseProcessingStep implements XProcessingStep {
    public static final Companion Companion = null;
    private static final XProcessingEnvConfig ENV_CONFIG = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/DatabaseProcessingStep$Companion;", "", "()V", "ENV_CONFIG", "Landroidx/room/compiler/processing/XProcessingEnvConfig;", "getENV_CONFIG$room_compiler", "()Landroidx/room/compiler/processing/XProcessingEnvConfig;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final XProcessingEnvConfig getENV_CONFIG$room_compiler() {
            return DatabaseProcessingStep.access$getENV_CONFIG$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        ENV_CONFIG = XProcessingEnvConfig.copy$default(XProcessingEnvConfig.Companion.getDEFAULT(), true, false, 2, null);
    }

    public DatabaseProcessingStep() {
    }

    public static final /* synthetic */ XProcessingEnvConfig access$getENV_CONFIG$cp() {
        return ENV_CONFIG;
    }

    private final void prepareDaosForWriting(List<androidx.room.vo.Database> r10, List<DaoMethod> r11) {
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        Object r5 = r13.next();
        XClassName r14 = ((DaoMethod) r5).getDao().getTypeName();
        Object r15 = r12.get(r14);
        if (r15 != null) goto L8;
        r15 = new ArrayList();
        r12.put(r14, r15);
    L8:
        ((List) r15).add(r5);
        goto L4
    L9:
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator r17 = r12.entrySet().iterator();
    L11:
        if (r17.hasNext() == false) goto L15;
        Map.Entry r18 = (Map.Entry) r17.next();
        if (((List) r18.getValue()).size() <= 1) goto L11;
        r16.put(r18.getKey(), r18.getValue());
        goto L11
    L15:
        Iterator r19 = r16.entrySet().iterator();
    L17:
        if (r19.hasNext() == false) goto L45;
        Iterable r110 = (Iterable) ((Map.Entry) r19.next()).getValue();
        LinkedHashMap r20 = new LinkedHashMap();
        Iterator r111 = r110.iterator();
    L20:
        if (r111.hasNext() == false) goto L32;
        Object r21 = r111.next();
        DaoMethod r22 = (DaoMethod) r21;
        Iterator<T> r23 = r10.iterator();
    L23:
        if (r23.hasNext() == false) goto L31;
        androidx.room.vo.Database r24 = (androidx.room.vo.Database) r23.next();
        if (r24.getDaoMethods().contains(r22) == false) goto L23;
        String r25 = (String) CollectionsKt.last(r24.getTypeName().getSimpleNames());
        Object r26 = r20.get(r25);
        if (r26 != null) goto L29;
        r26 = new ArrayList();
        r20.put(r25, r26);
    L29:
        ((List) r26).add(r21);
        goto L20
    L31:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L32:
        Iterator r112 = r20.entrySet().iterator();
    L34:
        if (r112.hasNext() == false) goto L17;
        Map.Entry r27 = (Map.Entry) r112.next();
        String r28 = (String) r27.getKey();
        List r29 = (List) r27.getValue();
        if (r29.size() == 1) goto L37;
        Iterator r30 = r29.iterator();
        int r31 = 0;
    L40:
        if (r30.hasNext() == false) goto L34;
        Object r32 = r30.next();
        int r33 = r31 + 1;
        if (r31 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        ((DaoMethod) r32).getDao().setSuffix(r28 + "_" + r31);
        r31 = r33;
        goto L40
    L37:
        ((DaoMethod) CollectionsKt.first(r29)).getDao().setSuffix(r28);
        goto L34
    }

    @Override // androidx.room.compiler.processing.XProcessingStep
    public Set<String> annotations() {
        String r5 = Reflection.getOrCreateKotlinClass(Database.class).getQualifiedName();
        Intrinsics.checkNotNull(r5);
        return SetsKt.mutableSetOf(new String[]{r5});
    }

    @Override // androidx.room.compiler.processing.XProcessingStep
    public Set<XTypeElement> process(XProcessingEnv r10, Map<String, ? extends Set<? extends XElement>> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "env");
        Intrinsics.checkNotNullParameter(r11, "elementsByAnnotation");
        XProcessingEnvConfig r5 = r10.getConfig();
        XProcessingEnvConfig r13 = ENV_CONFIG;
        if (Intrinsics.areEqual(r5, r13) == false) goto L67;
        Context r14 = new Context(r10);
        LinkedHashSet r15 = new LinkedHashSet();
        Set<? extends XElement> r16 = r11.get(Reflection.getOrCreateKotlinClass(Database.class).getQualifiedName());
        Map r17 = null;
        if (r16 == null) goto L29;
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r16.iterator();
    L8:
        if (r19.hasNext() == false) goto L12;
        Object r20 = r19.next();
        if ((r20 instanceof XTypeElement) == false) goto L8;
        r18.add(r20);
        goto L8
    L12:
        ArrayList r21 = new ArrayList();
        Iterator r22 = r18.iterator();
    L14:
        if (r22.hasNext() == false) goto L30;
        final XTypeElement r23 = (XTypeElement) r22.next();
        if (r12 == true) goto L18;
    L21:
        Pair r24 = r14.collectLogs(new DatabaseProcessingStep$process$databases$1$1(r23));
        androidx.room.vo.Database r25 = (androidx.room.vo.Database) r24.component1();
        RLog.CollectingMessager r26 = (RLog.CollectingMessager) r24.component2();
        if (r26.hasMissingTypeErrors() == false) goto L26;
        if (r12 == false) goto L25;
        r26.writeTo(r14, RLog.Companion.getMissingTypeErrorFilter());
    L20:
        r25 = null;
    L27:
        if (r25 == null) goto L14;
        r21.add(r25);
        goto L14
    L25:
        r15.add(r23);
        goto L20
    L26:
        RLog.CollectingMessager.writeTo$default(r26, r14, null, 2, null);
        goto L27
    L18:
        if (r23.validate() == true) goto L21;
        r14.reportMissingTypeReference(r23.getQualifiedName());
    L30:
        if (r21 == null) goto L40;
        ArrayList r110 = new ArrayList();
        Iterator r27 = r21.iterator();
    L33:
        if (r27.hasNext() == false) goto L39;
        androidx.room.vo.Database r28 = (androidx.room.vo.Database) r27.next();
        List<DaoMethod> r29 = r28.getDaoMethods();
        ArrayList r30 = new ArrayList(CollectionsKt.h(r29));
        Iterator<T> r31 = r29.iterator();
    L36:
        if (r31.hasNext() == false) goto L38;
        r30.add(TuplesKt.to((DaoMethod) r31.next(), r28));
        goto L36
    L38:
        CollectionsKt.a(r110, r30);
        goto L33
    L39:
        r17 = MapsKt.toMap(r110);
    L40:
        if (r17 == null) goto L45;
        prepareDaosForWriting(r21, CollectionsKt.toList(r17.keySet()));
        Iterator r32 = r17.entrySet().iterator();
    L43:
        if (r32.hasNext() == false) goto L45;
        Map.Entry r111 = (Map.Entry) r32.next();
        new DaoWriter(((DaoMethod) r111.getKey()).getDao(), ((androidx.room.vo.Database) r111.getValue()).getElement(), CodeLanguage.JAVA).write(r14.getProcessingEnv());
    L45:
        if (r21 == null) goto L65;
        Iterator r33 = r21.iterator();
    L48:
        if (r33.hasNext() == false) goto L65;
        androidx.room.vo.Database r34 = (androidx.room.vo.Database) r33.next();
        new DatabaseWriter(r34, CodeLanguage.JAVA).write(r14.getProcessingEnv());
        if (r34.getExportSchema() == false) goto L61;
        String r112 = r14.getSchemaOutFolderPath();
        if (r112 != null) goto L54;
        r14.getLogger().w(Warning.MISSING_SCHEMA_LOCATION, r34.getElement(), ProcessorErrors.INSTANCE.getMISSING_SCHEMA_EXPORT_DIRECTORY(), new Object[0]);
        goto L61
    L54:
        File r113 = SchemaFileResolver.Companion.getRESOLVER().getFile(b.d(r112, new String[0]));
        if (r113.exists() == true) goto L57;
        r113.mkdirs();
    L57:
        File r35 = new File(r113, r34.getElement().getQualifiedName());
        if (r35.exists() == true) goto L60;
        r35.mkdirs();
    L60:
        r34.exportSchema(new File(r35, r34.getVersion() + ".json"));
    L61:
        Iterator<T> r114 = r34.getAutoMigrations().iterator();
    L63:
        if (r114.hasNext() == false) goto L48;
        new AutoMigrationWriter(r34.getElement(), (androidx.room.vo.AutoMigration) r114.next(), r14.getCodeLanguage()).write(r14.getProcessingEnv());
    L65:
        return r15;
    L29:
        r21 = null;
        goto L30
    L67:
        throw new IllegalStateException(("Room Processor expected " + r13 + " but was invoked with a different configuration:" + r10.getConfig()).toString());
    }
}
