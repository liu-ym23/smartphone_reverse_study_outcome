package androidx.room.vo;

import androidx.room.compiler.codegen.XClassName;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.migration.bundle.DatabaseBundle;
import androidx.room.migration.bundle.SchemaBundle;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0002\u0010\u0012J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0003J\t\u0010C\u001a\u00020\u000eHÆ\u0003J\t\u0010D\u001a\u00020\u0010HÆ\u0003J\t\u0010E\u001a\u00020\u0010HÆ\u0003Jk\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010HÆ\u0001J\u0013\u0010G\u001a\u00020\u00102\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u000f\u001a\u00020I2\u0006\u0010J\u001a\u00020KJ\t\u0010L\u001a\u00020\u000eHÖ\u0001J\t\u0010M\u001a\u00020'HÖ\u0001R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u001b\u0010&\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u001e\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u001e\u001a\u0004\b,\u0010)R\u001b\u0010.\u001a\u00020/8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u001e\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u001e\u001a\u0004\b4\u0010)R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001b\u00108\u001a\u00020/8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u001e\u001a\u0004\b9\u00101R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0016¨\u0006N"}, d2 = {"Landroidx/room/vo/Database;", "", "element", "Landroidx/room/compiler/processing/XTypeElement;", "type", "Landroidx/room/compiler/processing/XType;", "entities", "", "Landroidx/room/vo/Entity;", "views", "Landroidx/room/vo/DatabaseView;", "daoMethods", "Landroidx/room/vo/DaoMethod;", "version", "", "exportSchema", "", "enableForeignKeys", "(Landroidx/room/compiler/processing/XTypeElement;Landroidx/room/compiler/processing/XType;Ljava/util/List;Ljava/util/List;Ljava/util/List;IZZ)V", "autoMigrations", "Landroidx/room/vo/AutoMigration;", "getAutoMigrations", "()Ljava/util/List;", "setAutoMigrations", "(Ljava/util/List;)V", "bundle", "Landroidx/room/migration/bundle/DatabaseBundle;", "getBundle", "()Landroidx/room/migration/bundle/DatabaseBundle;", "bundle$delegate", "Lkotlin/Lazy;", "getDaoMethods", "getElement", "()Landroidx/room/compiler/processing/XTypeElement;", "getEnableForeignKeys", "()Z", "getEntities", "getExportSchema", "identityHash", "", "getIdentityHash", "()Ljava/lang/String;", "identityHash$delegate", "implClassName", "getImplClassName", "implClassName$delegate", "implTypeName", "Landroidx/room/compiler/codegen/XClassName;", "getImplTypeName", "()Landroidx/room/compiler/codegen/XClassName;", "implTypeName$delegate", "legacyIdentityHash", "getLegacyIdentityHash", "legacyIdentityHash$delegate", "getType", "()Landroidx/room/compiler/processing/XType;", "typeName", "getTypeName", "typeName$delegate", "getVersion", "()I", "getViews", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "file", "Ljava/io/File;", "hashCode", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Database {
    public List<AutoMigration> autoMigrations;
    private final Lazy bundle$delegate;
    private final List<DaoMethod> daoMethods;
    private final XTypeElement element;
    private final boolean enableForeignKeys;
    private final List<Entity> entities;
    private final boolean exportSchema;
    private final Lazy identityHash$delegate;
    private final Lazy implClassName$delegate;
    private final Lazy implTypeName$delegate;
    private final Lazy legacyIdentityHash$delegate;
    private final XType type;
    private final Lazy typeName$delegate;
    private final int version;
    private final List<DatabaseView> views;

    /* JADX WARN: Multi-variable type inference failed */
    public Database(XTypeElement r5, XType r10, List<? extends Entity> r11, List<DatabaseView> r12, List<DaoMethod> r13, int r14, boolean r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "entities");
        Intrinsics.checkNotNullParameter(r12, "views");
        Intrinsics.checkNotNullParameter(r13, "daoMethods");
        this.element = r5;
        this.type = r10;
        this.entities = r11;
        this.views = r12;
        this.daoMethods = r13;
        this.version = r14;
        this.exportSchema = r15;
        this.enableForeignKeys = r16;
        this.typeName$delegate = LazyKt.lazy(new Database$typeName$2(this));
        this.implClassName$delegate = LazyKt.lazy(new Database$implClassName$2(this));
        this.implTypeName$delegate = LazyKt.lazy(new Database$implTypeName$2(this));
        this.bundle$delegate = LazyKt.lazy(new Database$bundle$2(this));
        this.identityHash$delegate = LazyKt.lazy(new Database$identityHash$2(this));
        this.legacyIdentityHash$delegate = LazyKt.lazy(new Database$legacyIdentityHash$2(this));
    }

    public static final /* synthetic */ String access$getImplClassName(Database r5) {
        return r5.getImplClassName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Database copy$default(Database r10, XTypeElement r11, XType r12, List r13, List r14, List r15, int r16, boolean r17, boolean r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        XTypeElement r5 = r10.element;
    L7:
        if ((r19 & 2) == 0) goto L9;
        XType r20 = r10.type;
    L11:
        if ((r19 & 4) == 0) goto L13;
        List r21 = r10.entities;
    L15:
        if ((r19 & 8) == 0) goto L17;
        List r22 = r10.views;
    L19:
        if ((r19 & 16) == 0) goto L21;
        List r23 = r10.daoMethods;
    L23:
        if ((r19 & 32) == 0) goto L25;
        int r24 = r10.version;
    L27:
        if ((r19 & 64) == 0) goto L29;
        boolean r25 = r10.exportSchema;
    L31:
        if ((r19 & 128) == 0) goto L33;
        boolean r26 = r10.enableForeignKeys;
    L35:
        return r10.copy(r5, r20, r21, r22, r23, r24, r25, r26);
    L33:
        r26 = r18;
        goto L35
    L29:
        r25 = r17;
        goto L31
    L25:
        r24 = r16;
        goto L27
    L21:
        r23 = r15;
        goto L23
    L17:
        r22 = r14;
        goto L19
    L13:
        r21 = r13;
        goto L15
    L9:
        r20 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    private final String getImplClassName() {
        return (String) this.implClassName$delegate.getValue();
    }

    public final XTypeElement component1() {
        return this.element;
    }

    public final XType component2() {
        return this.type;
    }

    public final List<Entity> component3() {
        return this.entities;
    }

    public final List<DatabaseView> component4() {
        return this.views;
    }

    public final List<DaoMethod> component5() {
        return this.daoMethods;
    }

    public final int component6() {
        return this.version;
    }

    public final boolean component7() {
        return this.exportSchema;
    }

    public final boolean component8() {
        return this.enableForeignKeys;
    }

    public final Database copy(XTypeElement r11, XType r12, List<? extends Entity> r13, List<DatabaseView> r14, List<DaoMethod> r15, int r16, boolean r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r11, "element");
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r13, "entities");
        Intrinsics.checkNotNullParameter(r14, "views");
        Intrinsics.checkNotNullParameter(r15, "daoMethods");
        return new Database(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Database) == true) goto L8;
        return false;
    L8:
        Database r10 = (Database) r5;
        if (Intrinsics.areEqual(this.element, r10.element) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.entities, r10.entities) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.views, r10.views) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.daoMethods, r10.daoMethods) == true) goto L24;
        return false;
    L24:
        if (this.version == r10.version) goto L27;
        return false;
    L27:
        if (this.exportSchema == r10.exportSchema) goto L30;
        return false;
    L30:
        if (this.enableForeignKeys == r10.enableForeignKeys) goto L32;
        return false;
    L32:
        return true;
    }

    public final void exportSchema(File r5) {
        Intrinsics.checkNotNullParameter(r5, "file");
        SchemaBundle r10 = new SchemaBundle(1, getBundle());
        if (r5.exists() == true) goto L20;
    L18:
        SchemaBundle.Companion.serialize(r10, r5);
        return;
    L20:
        FileInputStream r11 = new FileInputStream(r5);     // Catch: Throwable -> L16
        SchemaBundle r12 = SchemaBundle.Companion.deserialize(r11);     // Catch: Throwable -> L11
        goto L17
    L7:
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L16
        if (r12.isSchemaEqual2(r10) == false) goto L18;
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L17:
        throw new IllegalStateException(StringsKt.trimIndent("\n                    Cannot parse existing schema file: " + r5.getAbsolutePath() + ".\n                    If you've modified the file, you might've broken the JSON format, try\n                    deleting the file and re-running the compiler.\n                    If you've not modified the file, please file a bug at\n                    https://issuetracker.google.com/issues/new?component=413107&template=1096568\n                    with a sample app to reproduce the issue.\n                    "));
    }

    public final List<AutoMigration> getAutoMigrations() {
        List<AutoMigration> r5 = this.autoMigrations;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("autoMigrations");
        return null;
    }

    public final DatabaseBundle getBundle() {
        return (DatabaseBundle) this.bundle$delegate.getValue();
    }

    public final List<DaoMethod> getDaoMethods() {
        return this.daoMethods;
    }

    public final XTypeElement getElement() {
        return this.element;
    }

    public final boolean getEnableForeignKeys() {
        return this.enableForeignKeys;
    }

    public final List<Entity> getEntities() {
        return this.entities;
    }

    public final boolean getExportSchema() {
        return this.exportSchema;
    }

    public final String getIdentityHash() {
        return (String) this.identityHash$delegate.getValue();
    }

    public final XClassName getImplTypeName() {
        return (XClassName) this.implTypeName$delegate.getValue();
    }

    public final String getLegacyIdentityHash() {
        return (String) this.legacyIdentityHash$delegate.getValue();
    }

    public final XType getType() {
        return this.type;
    }

    public final XClassName getTypeName() {
        return (XClassName) this.typeName$delegate.getValue();
    }

    public final int getVersion() {
        return this.version;
    }

    public final List<DatabaseView> getViews() {
        return this.views;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int r5 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.version, androidx.constraintlayout.motion.widget.a.f(this.daoMethods, androidx.constraintlayout.motion.widget.a.f(this.views, androidx.constraintlayout.motion.widget.a.f(this.entities, (this.type.hashCode() + (this.element.hashCode() * 31)) * 31, 31), 31), 31), 31);
        boolean r10 = this.exportSchema;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L5;
        r12 = 1;
    L5:
        int r13 = (r5 + r12) * 31;
        boolean r14 = this.enableForeignKeys;
        if (r14 == true) goto L10;
        r11 = r14;
    L10:
        return r13 + r11;
    }

    public final void setAutoMigrations(List<AutoMigration> r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.autoMigrations = r5;
    }

    public String toString() {
        return "Database(element=" + this.element + ", type=" + this.type + ", entities=" + this.entities + ", views=" + this.views + ", daoMethods=" + this.daoMethods + ", version=" + this.version + ", exportSchema=" + this.exportSchema + ", enableForeignKeys=" + this.enableForeignKeys + ")";
    }
}
