package androidx.room.writer;

import ai.j0;
import androidx.annotation.VisibleForTesting;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.ext.SupportDbTypeNames;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import androidx.room.vo.Database;
import androidx.room.vo.DatabaseView;
import androidx.room.vo.Entity;
import androidx.room.vo.FtsEntity;
import com.bytedance.android.anniex.base.service.f;
import com.squareup.javapoet.g;
import com.squareup.javapoet.s;
import com.squareup.javapoet.t;
import com.squareup.javapoet.u;
import com.squareup.javapoet.y;
import com.squareup.javapoet.z;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0013J#\u0010\u001b\u001a\u00020\u001a*\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010 \u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00182\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b*\u0010%J\u0017\u0010+\u001a\u00020\u00182\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b+\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Landroidx/room/writer/SQLiteOpenHelperWriter;", "", "Landroidx/room/vo/Database;", "database", "<init>", "(Landroidx/room/vo/Database;)V", "Landroidx/room/solver/CodeGenScope;", "scope", "Lcom/squareup/javapoet/z;", "createOpenCallback", "(Landroidx/room/solver/CodeGenScope;)Lcom/squareup/javapoet/z;", "", "Lcom/squareup/javapoet/t;", "createValidateMigration", "(Landroidx/room/solver/CodeGenScope;)Ljava/util/List;", "createOnCreate", "(Landroidx/room/solver/CodeGenScope;)Lcom/squareup/javapoet/t;", "createOnOpen", "createCreateAllTables", "()Lcom/squareup/javapoet/t;", "createDropAllTables", "createOnPreMigrate", "createOnPostMigrate", "Lcom/squareup/javapoet/s;", "", "methodName", "", "invokeCallbacks", "(Lcom/squareup/javapoet/s;Landroidx/room/solver/CodeGenScope;Ljava/lang/String;)V", "outVar", "Lcom/squareup/javapoet/u;", "configuration", "write", "(Ljava/lang/String;Lcom/squareup/javapoet/u;Landroidx/room/solver/CodeGenScope;)V", "Landroidx/room/vo/Entity;", "entity", "createTableQuery", "(Landroidx/room/vo/Entity;)Ljava/lang/String;", "Landroidx/room/vo/DatabaseView;", "view", "createViewQuery", "(Landroidx/room/vo/DatabaseView;)Ljava/lang/String;", "createDropTableQuery", "createDropViewQuery", "Landroidx/room/vo/Database;", "getDatabase", "()Landroidx/room/vo/Database;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SQLiteOpenHelperWriter {
    private final Database database;

    public SQLiteOpenHelperWriter(Database r5) {
        Intrinsics.checkNotNullParameter(r5, "database");
        this.database = r5;
    }

    private final t createCreateAllTables() {
        s r5 = t.e("createAllTables");
        r5.l(new Modifier[]{Modifier.PUBLIC});
        r5.h();
        r5.n(SupportDbTypeNames.INSTANCE.getDB(), "_db", new Modifier[0]);
        Iterator<T> r10 = this.database.getBundle().buildCreateQueries().iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        r5.o(j0.k("_db.execSQL(", Javapoet_extKt.getS(), ")"), new Object[]{(String) r10.next()});
        goto L4
    L7:
        return r5.r();
    }

    private final t createDropAllTables(CodeGenScope r10) {
        s r5 = t.e("dropAllTables");
        r5.l(new Modifier[]{Modifier.PUBLIC});
        r5.h();
        r5.n(SupportDbTypeNames.INSTANCE.getDB(), "_db", new Modifier[0]);
        Iterator<T> r11 = this.database.getEntities().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r5.o(j0.k("_db.execSQL(", Javapoet_extKt.getS(), ")"), new Object[]{createDropTableQuery((Entity) r11.next())});
        goto L4
    L6:
        Iterator<T> r12 = this.database.getViews().iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r5.o(j0.k("_db.execSQL(", Javapoet_extKt.getS(), ")"), new Object[]{createDropViewQuery((DatabaseView) r12.next())});
        goto L8
    L10:
        invokeCallbacks(r5, r10, "onDestructiveMigration");
        return r5.r();
    }

    private final t createOnCreate(CodeGenScope r10) {
        s r5 = t.e("onCreate");
        r5.l(new Modifier[]{Modifier.PUBLIC});
        r5.h();
        r5.n(SupportDbTypeNames.INSTANCE.getDB(), "_db", new Modifier[0]);
        invokeCallbacks(r5, r10, "onCreate");
        return r5.r();
    }

    private final t createOnOpen(CodeGenScope r10) {
        s r5 = t.e("onOpen");
        r5.l(new Modifier[]{Modifier.PUBLIC});
        r5.h();
        r5.n(SupportDbTypeNames.INSTANCE.getDB(), "_db", new Modifier[0]);
        r5.o("mDatabase = _db", new Object[0]);
        if (this.database.getEnableForeignKeys() == false) goto L5;
        r5.o(j0.k("_db.execSQL(", Javapoet_extKt.getS(), ")"), new Object[]{"PRAGMA foreign_keys = ON"});
    L5:
        r5.o("internalInitInvalidationTracker(_db)", new Object[0]);
        invokeCallbacks(r5, r10, "onOpen");
        return r5.r();
    }

    private final t createOnPostMigrate() {
        s r5 = t.e("onPostMigrate");
        r5.l(new Modifier[]{Modifier.PUBLIC});
        r5.h();
        r5.n(SupportDbTypeNames.INSTANCE.getDB(), "_db", new Modifier[0]);
        List r10 = CollectionsKt.l(this.database.getEntities(), FtsEntity.class);
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (((FtsEntity) r13).getFtsOptions().getContentEntity() == null) goto L4;
        r11.add(r13);
        goto L4
    L8:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r11.iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        CollectionsKt.a(r14, ((FtsEntity) r15.next()).getContentSyncTriggerCreateQueries());
        goto L10
    L12:
        Iterator r16 = r14.iterator();
    L14:
        if (r16.hasNext() == false) goto L17;
        r5.o(j0.k("_db.execSQL(", Javapoet_extKt.getS(), ")"), new Object[]{(String) r16.next()});
        goto L14
    L17:
        return r5.r();
    }

    private final t createOnPreMigrate() {
        s r5 = t.e("onPreMigrate");
        r5.l(new Modifier[]{Modifier.PUBLIC});
        r5.h();
        r5.n(SupportDbTypeNames.INSTANCE.getDB(), "_db", new Modifier[0]);
        r5.o(a.q(Javapoet_extKt.getT(), ".dropFtsSyncTriggers(", Javapoet_extKt.getL(), ")"), new Object[]{RoomTypeNames.INSTANCE.getDB_UTIL(), "_db"});
        return r5.r();
    }

    private final z createOpenCallback(CodeGenScope r5) {
        y r10 = z.a(Javapoet_extKt.getL(), new Object[]{Integer.valueOf(this.database.getVersion())});
        r10.f(RoomTypeNames.INSTANCE.getOPEN_HELPER_DELEGATE());
        r10.b(createCreateAllTables());
        r10.b(createDropAllTables(r5.fork()));
        r10.b(createOnCreate(r5.fork()));
        r10.b(createOnOpen(r5.fork()));
        r10.b(createOnPreMigrate());
        r10.b(createOnPostMigrate());
        List<t> r11 = createValidateMigration(r5.fork());
        if (r11 == null) goto L5;
        boolean r12 = true;
    L6:
        f.r(r12, "methodSpecs == null", new Object[0]);
        Iterator<T> r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L11;
        r10.b((t) r13.next());
        goto L8
    L11:
        return r10.e();
    L5:
        r12 = false;
        goto L6
    }

    private final List<t> createValidateMigration(CodeGenScope r14) {
        ArrayList r5 = new ArrayList();
        ArrayDeque r10 = new ArrayDeque(this.database.getEntities());
        ArrayDeque r11 = new ArrayDeque(this.database.getViews());
        u r13 = u.a(SupportDbTypeNames.INSTANCE.getDB(), "_db", new Modifier[0]).n();
    L4:
        if (r10.isEmpty() == true) goto L6;
    L19:
        boolean r12 = r5.isEmpty();
        String r15 = "onValidateSchema";
        if (r12 == true) goto L23;
        r15 = j0.g(r5.size() + 1, "onValidateSchema");
    L23:
        s r16 = t.e(r15);
        if (r12 == false) goto L26;
        r16.l(new Modifier[]{Modifier.PUBLIC});
        r16.h();
    L27:
        r16.v(RoomTypeNames.INSTANCE.getOPEN_HELPER_VALIDATION_RESULT());
        r16.m(r13);
        int r17 = 0;
    L29:
        if (r10.isEmpty() == true) goto L37;
        if (r17 >= 1000) goto L37;
        CodeGenScope r18 = r14.fork();
        Entity r19 = (Entity) r10.poll();
        if ((r19 instanceof FtsEntity) == false) goto L34;
        ValidationWriter r110 = new FtsTableInfoValidationWriter((FtsEntity) r19);
    L35:
        r110.write(r13, r18);
        r16.j(r18.builder().f());
        r17 = r17 + r110.statementCount();
        goto L29
    L34:
        r110 = new TableInfoValidationWriter(r19);
    L37:
        if (r11.isEmpty() == true) goto L40;
        if (r17 >= 1000) goto L40;
        CodeGenScope r20 = r14.fork();
        ViewInfoValidationWriter r111 = new ViewInfoValidationWriter((DatabaseView) r11.poll());
        r111.write(r13, r20);
        r16.j(r20.builder().f());
        r17 = r17 + r111.statementCount();
    L40:
        if (r12 == true) goto L42;
        r16.o(j0.k("return new ", Javapoet_extKt.getT(), "(true, null)"), new Object[]{RoomTypeNames.INSTANCE.getOPEN_HELPER_VALIDATION_RESULT()});
    L42:
        r5.add(r16.r());
        goto L4
    L26:
        r16.l(new Modifier[]{Modifier.PRIVATE});
        goto L27
    L6:
        if (r11.isEmpty() == false) goto L19;
        if (r5.size() <= 1) goto L16;
        s r21 = ((t) r5.get(0)).f();
        String r112 = r14.getTmpVar("_result");
        r21.o(j0.D(Javapoet_extKt.getT(), " ", Javapoet_extKt.getL()), new Object[]{RoomTypeNames.INSTANCE.getOPEN_HELPER_VALIDATION_RESULT(), r112});
        Iterator r22 = CollectionsKt.i(r5, 1).iterator();
    L12:
        if (r22.hasNext() == false) goto L14;
        StringBuilder r23 = a.y(Javapoet_extKt.getL(), " = ", ((t) r22.next()).f15010a, "(", Javapoet_extKt.getN());
        r23.append(")");
        r21.o(r23.toString(), new Object[]{r112, r13});
        r21.q(j0.k("if (!", Javapoet_extKt.getL(), ".isValid)"), new Object[]{r112});
        r21.o(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r112});
        r21.s();
        goto L12
    L14:
        r21.o(j0.k("return new ", Javapoet_extKt.getT(), "(true, null)"), new Object[]{RoomTypeNames.INSTANCE.getOPEN_HELPER_VALIDATION_RESULT()});
        Unit r113 = Unit.INSTANCE;
        r5.set(0, r21.r());
    L18:
        return r5;
    L16:
        if (r5.size() != 1) goto L18;
        s r114 = ((t) r5.get(0)).f();
        r114.o(j0.k("return new ", Javapoet_extKt.getT(), "(true, null)"), new Object[]{RoomTypeNames.INSTANCE.getOPEN_HELPER_VALIDATION_RESULT()});
        Unit r115 = Unit.INSTANCE;
        r5.set(0, r114.r());
        goto L18
    }

    private final void invokeCallbacks(s r10, CodeGenScope r11, String r12) {
        String r13 = r11.getTmpVar("_i");
        String r14 = r11.getTmpVar("_size");
        g r5 = r10.e;
        r5.e("if (mCallbacks != null)", new Object[0]);
        String r15 = Javapoet_extKt.getN();
        String r16 = Javapoet_extKt.getN();
        String r17 = Javapoet_extKt.getN();
        String r18 = Javapoet_extKt.getN();
        String r19 = Javapoet_extKt.getN();
        StringBuilder r20 = androidx.constraintlayout.motion.widget.a.y("for (int ", r15, " = 0, ", r16, " = mCallbacks.size(); ");
        androidx.constraintlayout.motion.widget.a.C(r20, r17, " < ", r18, "; ");
        g r21 = r10.e;
        r21.e(j0.q(r20, r19, "++)"), new Object[]{r13, r14, r13, r14, r13});
        r10.o(j0.l("mCallbacks.get(", Javapoet_extKt.getN(), ").", Javapoet_extKt.getN(), "(_db)"), new Object[]{r13, r12});
        r10.s();
        r10.s();
    }

    @VisibleForTesting
    public final String createDropTableQuery(Entity r5) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        return j0.k("DROP TABLE IF EXISTS `", r5.getTableName(), "`");
    }

    @VisibleForTesting
    public final String createDropViewQuery(DatabaseView r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        return j0.k("DROP VIEW IF EXISTS `", r5.getViewName(), "`");
    }

    @VisibleForTesting
    public final String createTableQuery(Entity r5) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        return r5.getCreateTableQuery();
    }

    @VisibleForTesting
    public final String createViewQuery(DatabaseView r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        return r5.getCreateViewQuery();
    }

    public final Database getDatabase() {
        return this.database;
    }

    public final void write(String r17, u r18, CodeGenScope r19) {
        Intrinsics.checkNotNullParameter(r17, "outVar");
        Intrinsics.checkNotNullParameter(r18, "configuration");
        Intrinsics.checkNotNullParameter(r19, "scope");
        g r10 = r19.builder();
        String r11 = r19.getTmpVar("_sqliteConfig");
        String r12 = r19.getTmpVar("_openCallback");
        String r5 = Javapoet_extKt.getT();
        String r13 = Javapoet_extKt.getL();
        String r14 = Javapoet_extKt.getT();
        String r15 = Javapoet_extKt.getN();
        String r16 = Javapoet_extKt.getL();
        String r20 = Javapoet_extKt.getS();
        String r110 = Javapoet_extKt.getS();
        StringBuilder r21 = androidx.constraintlayout.motion.widget.a.y("final ", r5, " ", r13, " = new ");
        androidx.constraintlayout.motion.widget.a.C(r21, r14, "(", r15, ", ");
        androidx.constraintlayout.motion.widget.a.C(r21, r16, ", ", r20, ", ");
        String r22 = j0.q(r21, r110, ")");
        SupportDbTypeNames r111 = SupportDbTypeNames.INSTANCE;
        r10.c(r22, new Object[]{r111.getSQLITE_OPEN_HELPER_CALLBACK(), r12, RoomTypeNames.INSTANCE.getOPEN_HELPER(), r18, createOpenCallback(r19), this.database.getIdentityHash(), this.database.getLegacyIdentityHash()});
        String r23 = Javapoet_extKt.getT();
        String r24 = Javapoet_extKt.getL();
        String r25 = Javapoet_extKt.getT();
        String r26 = Javapoet_extKt.getN();
        String r27 = Javapoet_extKt.getN();
        String r28 = Javapoet_extKt.getL();
        StringBuilder r29 = androidx.constraintlayout.motion.widget.a.y("\n                    final ", r23, " ", r24, " = ");
        androidx.constraintlayout.motion.widget.a.C(r29, r25, ".builder(", r26, ".context)\n                    .name(");
        r29.append(r27);
        r29.append(".name)\n                    .callback(");
        r29.append(r28);
        r29.append(")\n                    .build()\n                ");
        r10.c(StringsKt.trimIndent(r29.toString()), new Object[]{r111.getSQLITE_OPEN_HELPER_CONFIG(), r11, r111.getSQLITE_OPEN_HELPER_CONFIG(), r18, r18, r12});
        String r30 = Javapoet_extKt.getT();
        String r31 = Javapoet_extKt.getN();
        String r32 = Javapoet_extKt.getN();
        String r33 = Javapoet_extKt.getL();
        r10.c(androidx.constraintlayout.motion.widget.a.u(androidx.constraintlayout.motion.widget.a.y("final ", r30, " ", r31, " = "), r32, ".sqliteOpenHelperFactory.create(", r33, ")"), new Object[]{r111.getSQLITE_OPEN_HELPER(), r17, r18, r11});
    }
}
