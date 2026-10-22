package androidx.room.processor;

import androidx.room.DeleteColumn;
import androidx.room.DeleteTable;
import androidx.room.ProvidedAutoMigrationSpec;
import androidx.room.RenameColumn;
import androidx.room.RenameTable;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XConstructorElement;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.ext.RoomTypeNames;
import androidx.room.migration.bundle.DatabaseBundle;
import androidx.room.preconditions.Checks;
import androidx.room.util.SchemaDiffer;
import androidx.room.vo.AutoMigration;
import com.squareup.javapoet.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0013"}, d2 = {"Landroidx/room/processor/AutoMigrationProcessor;", "", "context", "Landroidx/room/processor/Context;", "spec", "Landroidx/room/compiler/processing/XType;", "fromSchemaBundle", "Landroidx/room/migration/bundle/DatabaseBundle;", "toSchemaBundle", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XType;Landroidx/room/migration/bundle/DatabaseBundle;Landroidx/room/migration/bundle/DatabaseBundle;)V", "getContext", "()Landroidx/room/processor/Context;", "getFromSchemaBundle", "()Landroidx/room/migration/bundle/DatabaseBundle;", "getSpec", "()Landroidx/room/compiler/processing/XType;", "getToSchemaBundle", "process", "Landroidx/room/vo/AutoMigration;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AutoMigrationProcessor {
    private final Context context;
    private final DatabaseBundle fromSchemaBundle;
    private final XType spec;
    private final DatabaseBundle toSchemaBundle;

    public AutoMigrationProcessor(Context r5, XType r10, DatabaseBundle r11, DatabaseBundle r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "spec");
        Intrinsics.checkNotNullParameter(r11, "fromSchemaBundle");
        Intrinsics.checkNotNullParameter(r12, "toSchemaBundle");
        this.context = r5;
        this.spec = r10;
        this.fromSchemaBundle = r11;
        this.toSchemaBundle = r12;
    }

    public final Context getContext() {
        return this.context;
    }

    public final DatabaseBundle getFromSchemaBundle() {
        return this.fromSchemaBundle;
    }

    public final XType getSpec() {
        return this.spec;
    }

    public final DatabaseBundle getToSchemaBundle() {
        return this.toSchemaBundle;
    }

    public final AutoMigration process() {
        if (this.spec.isTypeOf(Reflection.getOrCreateKotlinClass(Object.class)) == true) goto L42;
        XTypeElement r5 = this.spec.getTypeElement();
        if (r5 != null) goto L9;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.getAUTOMIGRATION_SPEC_MUST_BE_CLASS(), new Object[0]);
        return null;
    L9:
        if (r5.isInterface() == false) goto L11;
    L40:
        this.context.getLogger().e(r5, ProcessorErrors.INSTANCE.getAUTOMIGRATION_SPEC_MUST_BE_CLASS(), new Object[0]);
        return null;
    L11:
        if (r5.isAbstract() == true) goto L40;
        boolean r10 = r5.hasAnnotation(Reflection.getOrCreateKotlinClass(ProvidedAutoMigrationSpec.class));
        boolean r11 = true;
        if (r10 == true) goto L29;
        List<XConstructorElement> r12 = r5.getConstructors();
        Checks r13 = this.context.getChecker();
        if (r12.isEmpty() == false) goto L18;
    L27:
        boolean r14 = true;
    L28:
        r13.check(r14, r5, ProcessorErrors.INSTANCE.getAUTOMIGRATION_SPEC_MISSING_NOARG_CONSTRUCTOR(), new Object[0]);
        goto L29
    L18:
        if (r12.isEmpty() == true) goto L26;
        Iterator<T> r15 = r12.iterator();
    L22:
        if (r15.hasNext() == false) goto L26;
        if (((XConstructorElement) r15.next()).getParameters().isEmpty() == false) goto L22;
    L26:
        r14 = false;
    L29:
        Checks r16 = this.context.getChecker();
        if (r5.getEnclosingTypeElement() != null) goto L32;
    L35:
        ProcessorErrors r17 = ProcessorErrors.INSTANCE;
        r16.check(r11, r5, r17.getINNER_CLASS_AUTOMIGRATION_SPEC_MUST_BE_STATIC(), new Object[0]);
        if (this.context.getProcessingEnv().requireType(RoomTypeNames.INSTANCE.getAUTO_MIGRATION_SPEC()).isAssignableFrom(this.spec) == true) goto L39;
        this.context.getLogger().e(r5, r17.autoMigrationElementMustImplementSpec(r5.getClassName().f14961y), new Object[0]);
        return null;
    L39:
        Pair r18 = TuplesKt.to(r5, Boolean.valueOf(r10));
    L43:
        XTypeElement r19 = (XTypeElement) r18.component1();
        boolean r110 = ((Boolean) r18.component2()).booleanValue();
        if (this.toSchemaBundle.getVersion() > this.fromSchemaBundle.getVersion()) goto L47;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.autoMigrationToVersionMustBeGreaterThanFrom(this.toSchemaBundle.getVersion(), this.fromSchemaBundle.getVersion()), new Object[0]);
        return null;
    L47:
        if (r19 == null) goto L51;
        e r20 = r19.getClassName();
        if (r20 == null) goto L51;
        String r111 = r20.f14961y;
    L52:
        if (r19 == null) goto L58;
        List r21 = r19.getAnnotations(Reflection.getOrCreateKotlinClass(DeleteColumn.class));
        ArrayList r22 = new ArrayList(CollectionsKt.h(r21));
        Iterator r23 = r21.iterator();
    L55:
        if (r23.hasNext() == false) goto L57;
        XAnnotationBox r24 = (XAnnotationBox) r23.next();
        r22.add(new AutoMigration.DeletedColumn(((DeleteColumn) r24.getValue()).tableName(), ((DeleteColumn) r24.getValue()).columnName()));
        goto L55
    L57:
        List r112 = r22;
    L59:
        if (r19 == null) goto L65;
        List r25 = r19.getAnnotations(Reflection.getOrCreateKotlinClass(DeleteTable.class));
        ArrayList r26 = new ArrayList(CollectionsKt.h(r25));
        Iterator r27 = r25.iterator();
    L62:
        if (r27.hasNext() == false) goto L64;
        r26.add(new AutoMigration.DeletedTable(((DeleteTable) ((XAnnotationBox) r27.next()).getValue()).tableName()));
        goto L62
    L64:
        List r113 = r26;
    L66:
        if (r19 == null) goto L72;
        List r28 = r19.getAnnotations(Reflection.getOrCreateKotlinClass(RenameTable.class));
        ArrayList r29 = new ArrayList(CollectionsKt.h(r28));
        Iterator r30 = r28.iterator();
    L69:
        if (r30.hasNext() == false) goto L71;
        XAnnotationBox r31 = (XAnnotationBox) r30.next();
        r29.add(new AutoMigration.RenamedTable(((RenameTable) r31.getValue()).fromTableName(), ((RenameTable) r31.getValue()).toTableName()));
        goto L69
    L71:
        List r114 = r29;
    L73:
        if (r19 == null) goto L79;
        List r32 = r19.getAnnotations(Reflection.getOrCreateKotlinClass(RenameColumn.class));
        ArrayList r33 = new ArrayList(CollectionsKt.h(r32));
        Iterator r34 = r32.iterator();
    L76:
        if (r34.hasNext() == false) goto L78;
        XAnnotationBox r35 = (XAnnotationBox) r34.next();
        r33.add(new AutoMigration.RenamedColumn(((RenameColumn) r35.getValue()).tableName(), ((RenameColumn) r35.getValue()).fromColumnName(), ((RenameColumn) r35.getValue()).toColumnName()));
        goto L76
    L78:
        List r115 = r33;
    L86:
        return new AutoMigration(this.fromSchemaBundle.getVersion(), this.toSchemaBundle.getVersion(), r19, new SchemaDiffer(this.fromSchemaBundle, this.toSchemaBundle, r111, r115, r112, r114, r113).diffSchemas(), r110);
    L83:
        e = move-exception;
        this.context.getLogger().e(e.getErrorMessage(), new Object[0]);
        return null;
    L79:
        r115 = CollectionsKt.emptyList();
        goto L86
    L72:
        r114 = CollectionsKt.emptyList();
        goto L73
    L65:
        r113 = CollectionsKt.emptyList();
        goto L66
    L58:
        r112 = CollectionsKt.emptyList();
    L51:
        r111 = null;
        goto L52
    L32:
        if (r5.isStatic() == true) goto L35;
        r11 = false;
        goto L35
    L42:
        r18 = TuplesKt.to(null, Boolean.FALSE);
        goto L43
    }
}
