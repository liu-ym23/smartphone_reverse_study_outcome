package androidx.room.writer;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.codegen.CodeLanguage;
import androidx.room.compiler.codegen.XClassName;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.codegen.XTypeSpec;
import androidx.room.compiler.processing.MethodSpecHelper;
import androidx.room.ext.AndroidTypeNames;
import androidx.room.ext.CommonTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.ext.String_extKt;
import androidx.room.ext.SupportDbTypeNames;
import androidx.room.solver.CodeGenScope;
import androidx.room.vo.AutoMigration;
import androidx.room.vo.DaoMethod;
import androidx.room.vo.Database;
import androidx.room.vo.DatabaseView;
import androidx.room.vo.Entity;
import com.squareup.javapoet.b0;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.i;
import com.squareup.javapoet.m;
import com.squareup.javapoet.s;
import com.squareup.javapoet.t;
import com.squareup.javapoet.u;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import com.squareup.javapoet.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\nJ\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\nJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Landroidx/room/writer/DatabaseWriter;", "Landroidx/room/writer/TypeWriter;", "Landroidx/room/vo/Database;", "database", "Landroidx/room/compiler/codegen/CodeLanguage;", "codeLanguage", "<init>", "(Landroidx/room/vo/Database;Landroidx/room/compiler/codegen/CodeLanguage;)V", "Lcom/squareup/javapoet/t;", "createCreateTypeConvertersMap", "()Lcom/squareup/javapoet/t;", "createCreateAutoMigrationSpecsSet", "createClearAllTables", "createCreateInvalidationTracker", "Lcom/squareup/javapoet/y;", "builder", "", "addDaoImpls", "(Lcom/squareup/javapoet/y;)V", "Lcom/squareup/javapoet/m;", "field", "Landroidx/room/vo/DaoMethod;", "method", "createDaoGetter", "(Lcom/squareup/javapoet/m;Landroidx/room/vo/DaoMethod;)Lcom/squareup/javapoet/t;", "createCreateOpenHelper", "getAutoMigrations", "Landroidx/room/compiler/codegen/XTypeSpec$Builder;", "createTypeSpecBuilder", "()Landroidx/room/compiler/codegen/XTypeSpec$Builder;", "Landroidx/room/vo/Database;", "getDatabase", "()Landroidx/room/vo/Database;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DatabaseWriter extends TypeWriter {
    private final Database database;

    public DatabaseWriter(Database r5, CodeLanguage r10) {
        Intrinsics.checkNotNullParameter(r5, "database");
        Intrinsics.checkNotNullParameter(r10, "codeLanguage");
        super(r10);
        this.database = r5;
    }

    public static final /* synthetic */ void access$addDaoImpls(DatabaseWriter r5, y r10) {
        r5.addDaoImpls(r10);
    }

    public static final /* synthetic */ t access$createClearAllTables(DatabaseWriter r5) {
        return r5.createClearAllTables();
    }

    public static final /* synthetic */ t access$createCreateAutoMigrationSpecsSet(DatabaseWriter r5) {
        return r5.createCreateAutoMigrationSpecsSet();
    }

    public static final /* synthetic */ t access$createCreateInvalidationTracker(DatabaseWriter r5) {
        return r5.createCreateInvalidationTracker();
    }

    public static final /* synthetic */ t access$createCreateOpenHelper(DatabaseWriter r5) {
        return r5.createCreateOpenHelper();
    }

    public static final /* synthetic */ t access$createCreateTypeConvertersMap(DatabaseWriter r5) {
        return r5.createCreateTypeConvertersMap();
    }

    public static final /* synthetic */ t access$getAutoMigrations(DatabaseWriter r5) {
        return r5.getAutoMigrations();
    }

    private final void addDaoImpls(y r10) {
        CodeGenScope r5 = new CodeGenScope(this);
        Iterator<T> r11 = this.database.getDaoMethods().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        DaoMethod r12 = (DaoMethod) r11.next();
        m r13 = m.a(XTypeNameKt.toJavaPoet(r12.getDao().getTypeName()), r5.getTmpVar("_" + String_extKt.stripNonJava(String_extKt.decapitalize(XTypeNameKt.toJavaPoet(r12.getDao().getTypeName()).q(), Locale.US))), new Modifier[]{Modifier.PRIVATE, Modifier.VOLATILE}).c();
        r10.a(r13);
        r10.b(createDaoGetter(r13, r12));
        goto L4
    }

    private final t createClearAllTables() {
        CodeGenScope r5 = new CodeGenScope(this);
        s r10 = t.e("clearAllTables");
        r10.o("super.assertNotMainThread()", new Object[0]);
        String r11 = r5.getTmpVar("_db");
        r10.o(j0.l("final ", Javapoet_extKt.getT(), " ", Javapoet_extKt.getL(), " = super.getOpenHelper().getWritableDatabase()"), new Object[]{SupportDbTypeNames.INSTANCE.getDB(), r11});
        String r12 = r5.getTmpVar("_supportsDeferForeignKeys");
        if (this.database.getEnableForeignKeys() == false) goto L5;
        String r13 = Javapoet_extKt.getL();
        String r14 = Javapoet_extKt.getL();
        String r15 = j0.q(a.y("boolean ", r13, " = ", r14, ".VERSION.SDK_INT >= "), Javapoet_extKt.getL(), ".VERSION_CODES.LOLLIPOP");
        AndroidTypeNames r16 = AndroidTypeNames.INSTANCE;
        r10.o(r15, new Object[]{r12, r16.getBUILD(), r16.getBUILD()});
    L5:
        r10.h();
        r10.l(new Modifier[]{Modifier.PUBLIC});
        r10.v(x.d);
        r10.q("try", new Object[0]);
        if (this.database.getEnableForeignKeys() == false) goto L8;
        r10.q(j0.k("if (!", Javapoet_extKt.getL(), ")"), new Object[]{r12});
        r10.o(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getL(), ".execSQL(", Javapoet_extKt.getS(), ")"), new Object[]{r11, "PRAGMA foreign_keys = FALSE"});
        r10.s();
    L8:
        r10.o("super.beginTransaction()", new Object[0]);
        if (this.database.getEnableForeignKeys() == false) goto L11;
        r10.q(j0.k("if (", Javapoet_extKt.getL(), ")"), new Object[]{r12});
        r10.o(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getL(), ".execSQL(", Javapoet_extKt.getS(), ")"), new Object[]{r11, "PRAGMA defer_foreign_keys = TRUE"});
        r10.s();
    L11:
        Iterator r17 = CollectionsKt.sortedWith(this.database.getEntities(), new EntityDeleteComparator()).iterator();
    L13:
        if (r17.hasNext() == false) goto L15;
        r10.o(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getL(), ".execSQL(", Javapoet_extKt.getS(), ")"), new Object[]{r11, j0.k("DELETE FROM `", ((Entity) r17.next()).getTableName(), "`")});
        goto L13
    L15:
        r10.o("super.setTransactionSuccessful()", new Object[0]);
        r10.t("finally", new Object[0]);
        r10.o("super.endTransaction()", new Object[0]);
        if (this.database.getEnableForeignKeys() == false) goto L18;
        r10.q(j0.k("if (!", Javapoet_extKt.getL(), ")"), new Object[]{r12});
        r10.o(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getL(), ".execSQL(", Javapoet_extKt.getS(), ")"), new Object[]{r11, "PRAGMA foreign_keys = TRUE"});
        r10.s();
    L18:
        r10.o(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getL(), ".query(", Javapoet_extKt.getS(), ").close()"), new Object[]{r11, "PRAGMA wal_checkpoint(FULL)"});
        r10.q(j0.k("if (!", Javapoet_extKt.getL(), ".inTransaction())"), new Object[]{r11});
        r10.o(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getL(), ".execSQL(", Javapoet_extKt.getS(), ")"), new Object[]{r11, "VACUUM"});
        r10.s();
        r10.s();
        return r10.r();
    }

    private final t createCreateAutoMigrationSpecsSet() {
        CodeGenScope r5 = new CodeGenScope(this);
        s r10 = t.e("getRequiredAutoMigrationSpecs");
        r10.h();
        r10.l(new Modifier[]{Modifier.PUBLIC});
        e r11 = CommonTypeNames.INSTANCE.getSET();
        e r12 = e.n(Class.class);
        RoomTypeNames r13 = RoomTypeNames.INSTANCE;
        r10.v(v.n(r11, new x[]{v.n(r12, new x[]{b0.o(r13.getAUTO_MIGRATION_SPEC())})}));
        String r14 = r5.getTmpVar("_autoMigrationSpecsSet");
        v r15 = v.n(e.n(HashSet.class), new x[]{v.n(e.n(Class.class), new x[]{b0.o(r13.getAUTO_MIGRATION_SPEC())})});
        String r16 = Javapoet_extKt.getT();
        String r17 = Javapoet_extKt.getL();
        r10.o(j0.q(a.y("final ", r16, " ", r17, " = new "), Javapoet_extKt.getT(), "()"), new Object[]{r15, r14, r15});
        List<AutoMigration> r18 = this.database.getAutoMigrations();
        ArrayList r19 = new ArrayList(CollectionsKt.h(r18));
        Iterator<T> r110 = r18.iterator();
    L4:
        if (r110.hasNext() == false) goto L9;
        AutoMigration r20 = (AutoMigration) r110.next();
        if (r20.isSpecProvided() == false) goto L8;
        r10.o(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getL(), ".add(", Javapoet_extKt.getT(), ".class)"), new Object[]{r14, r20.getSpecClassName()});
    L8:
        r19.add(Unit.INSTANCE);
        goto L4
    L9:
        r10.o(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r14});
        return r10.r();
    }

    private final t createCreateInvalidationTracker() {
        CodeGenScope r5 = new CodeGenScope(this);
        s r10 = t.e("createInvalidationTracker");
        r10.h();
        r10.l(new Modifier[]{Modifier.PROTECTED});
        r10.v(RoomTypeNames.INSTANCE.getINVALIDATION_TRACKER());
        e r11 = Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(HashMap.class));
        CommonTypeNames r12 = CommonTypeNames.INSTANCE;
        v r13 = v.n(r11, new x[]{r12.getSTRING(), r12.getSTRING()});
        String r14 = CollectionsKt.q(this.database.getEntities(), ",", null, null, 0, null, DatabaseWriter$createCreateInvalidationTracker$1$tableNames$1.INSTANCE, 30);
        List<Entity> r15 = this.database.getEntities();
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L4:
        if (r17.hasNext() == false) goto L8;
        Object r18 = r17.next();
        if (((Entity) r18).getShadowTableName() == null) goto L4;
        r16.add(r18);
        goto L4
    L8:
        ArrayList r19 = new ArrayList(CollectionsKt.h(r16));
        Iterator r110 = r16.iterator();
    L10:
        if (r110.hasNext() == false) goto L12;
        Entity r111 = (Entity) r110.next();
        r19.add(TuplesKt.to(r111.getTableName(), r111.getShadowTableName()));
        goto L10
    L12:
        String r112 = Javapoet_extKt.getT();
        String r113 = Javapoet_extKt.getL();
        r10.o(a.u(a.y("final ", r112, " ", r113, " = new "), Javapoet_extKt.getT(), "(", Javapoet_extKt.getL(), ")"), new Object[]{r13, "_shadowTablesMap", r13, Integer.valueOf(r19.size())});
        Iterator r20 = r19.iterator();
    L14:
        if (r20.hasNext() == false) goto L16;
        Pair r21 = (Pair) r20.next();
        String r22 = (String) r21.component1();
        String r23 = (String) r21.component2();
        StringBuilder r24 = androidx.room.jarjarred.org.antlr.runtime.a.y(Javapoet_extKt.getL(), ".put(", Javapoet_extKt.getS(), ", ", Javapoet_extKt.getS());
        r24.append(")");
        r10.o(r24.toString(), new Object[]{"_shadowTablesMap", r22, r23});
        r20 = r20;
        r14 = r14;
        goto L14
    L16:
        String r25 = r14;
        String r26 = r5.getTmpVar("_viewTables");
        e r27 = Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(HashSet.class));
        CommonTypeNames r28 = CommonTypeNames.INSTANCE;
        v r29 = v.n(r27, new x[]{r28.getSTRING()});
        v r30 = v.n(Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(HashMap.class)), new x[]{r28.getSTRING(), v.n(r28.getSET(), new x[]{r28.getSTRING()})});
        String r31 = Javapoet_extKt.getT();
        String r32 = Javapoet_extKt.getL();
        String r33 = Javapoet_extKt.getT();
        r10.o(a.t(androidx.room.jarjarred.org.antlr.runtime.a.y(r31, " ", r32, " = new ", r33), "(", Javapoet_extKt.getL(), ")"), new Object[]{r30, r26, r30, Integer.valueOf(this.database.getViews().size())});
        Iterator<DatabaseView> r34 = this.database.getViews().iterator();
    L18:
        if (r34.hasNext() == false) goto L24;
        DatabaseView r35 = r34.next();
        String r36 = r5.getTmpVar("_tables");
        String r37 = Javapoet_extKt.getT();
        String r38 = Javapoet_extKt.getL();
        String r114 = Javapoet_extKt.getT();
        r10.o(a.t(androidx.room.jarjarred.org.antlr.runtime.a.y(r37, " ", r38, " = new ", r114), "(", Javapoet_extKt.getL(), ")"), new Object[]{r29, r36, r29, Integer.valueOf(r35.getTables().size())});
        Iterator<String> r39 = r35.getTables().iterator();
    L21:
        if (r39.hasNext() == false) goto L23;
        r10.o(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getL(), ".add(", Javapoet_extKt.getS(), ")"), new Object[]{r36, r39.next()});
        r34 = r34;
        goto L21
    L23:
        Iterator<DatabaseView> r210 = r34;
        StringBuilder r40 = androidx.room.jarjarred.org.antlr.runtime.a.y(Javapoet_extKt.getL(), ".put(", Javapoet_extKt.getS(), ", ", Javapoet_extKt.getL());
        r40.append(")");
        r10.o(r40.toString(), new Object[]{r26, r35.getViewName().toLowerCase(Locale.US), r36});
        r34 = r210;
        goto L18
    L24:
        String r41 = Javapoet_extKt.getT();
        String r42 = Javapoet_extKt.getL();
        r10.o(a.u(a.y("return new ", r41, "(this, ", r42, ", "), Javapoet_extKt.getL(), ", ", Javapoet_extKt.getL(), ")"), new Object[]{RoomTypeNames.INSTANCE.getINVALIDATION_TRACKER(), "_shadowTablesMap", r26, r25});
        return r10.r();
    }

    private final t createCreateOpenHelper() {
        CodeGenScope r5 = new CodeGenScope(this);
        s r10 = t.e("createOpenHelper");
        r10.l(new Modifier[]{Modifier.PROTECTED});
        r10.h();
        r10.v(SupportDbTypeNames.INSTANCE.getSQLITE_OPEN_HELPER());
        u r11 = u.a(RoomTypeNames.INSTANCE.getROOM_DB_CONFIG(), "configuration", new Modifier[0]).n();
        r10.m(r11);
        String r12 = r5.getTmpVar("_helper");
        CodeGenScope r13 = r5.fork();
        new SQLiteOpenHelperWriter(this.database).write(r12, r11, r13);
        r10.j(r13.builder().f());
        r10.o(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r12});
        return r10.r();
    }

    private final t createCreateTypeConvertersMap() {
        CodeGenScope r5 = new CodeGenScope(this);
        s r10 = t.e("getRequiredTypeConverters");
        r10.h();
        r10.l(new Modifier[]{Modifier.PROTECTED});
        CommonTypeNames r11 = CommonTypeNames.INSTANCE;
        r10.v(v.n(r11.getMAP(), new x[]{v.n(e.n(Class.class), new x[]{b0.n()}), v.n(r11.getLIST(), new x[]{v.n(e.n(Class.class), new x[]{b0.n()})})}));
        String r12 = r5.getTmpVar("_typeConvertersMap");
        v r13 = v.n(e.n(HashMap.class), new x[]{v.n(e.n(Class.class), new x[]{b0.n()}), v.n(e.n(List.class), new x[]{v.n(e.n(Class.class), new x[]{b0.n()})})});
        String r14 = Javapoet_extKt.getT();
        String r15 = Javapoet_extKt.getL();
        r10.o(j0.q(a.y("final ", r14, " ", r15, " = new "), Javapoet_extKt.getT(), "()"), new Object[]{r13, r12, r13});
        Iterator<T> r16 = this.database.getDaoMethods().iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        DaoMethod r17 = (DaoMethod) r16.next();
        String r18 = Javapoet_extKt.getL();
        String r19 = Javapoet_extKt.getT();
        String r20 = Javapoet_extKt.getT();
        r10.o(a.t(androidx.room.jarjarred.org.antlr.runtime.a.y(r18, ".put(", r19, ".class, ", r20), ".", Javapoet_extKt.getL(), "())"), new Object[]{r12, XTypeNameKt.toJavaPoet(r17.getDao().getTypeName()), XTypeNameKt.toJavaPoet(r17.getDao().getImplTypeName()), DaoWriter.GET_LIST_OF_TYPE_CONVERTERS_METHOD});
        goto L4
    L6:
        r10.o(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r12});
        return r10.r();
    }

    private final t createDaoGetter(m r10, DaoMethod r11) {
        s r5 = MethodSpecHelper.overridingWithFinalParams(r11.getElement(), this.database.getElement().getType());
        g r12 = r5.e;
        r12.e(j0.k("if (", Javapoet_extKt.getN(), " != null)"), new Object[]{r10});
        r5.o(j0.C("return ", Javapoet_extKt.getN()), new Object[]{r10});
        g r13 = r5.e;
        r13.h("else", new Object[0]);
        r13.e("synchronized(this)", new Object[0]);
        r13.e(j0.k("if(", Javapoet_extKt.getN(), " == null)"), new Object[]{r10});
        r5.o(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getN(), " = new ", Javapoet_extKt.getT(), "(this)"), new Object[]{r10, XTypeNameKt.toJavaPoet(r11.getDao().getImplTypeName())});
        r5.s();
        r5.o(j0.C("return ", Javapoet_extKt.getN()), new Object[]{r10});
        r5.s();
        r5.s();
        return new t(r5);
    }

    private final t getAutoMigrations() {
        s r5 = t.e("getAutoMigrations");
        r5.l(new Modifier[]{Modifier.PUBLIC});
        r5.h();
        CommonTypeNames r10 = CommonTypeNames.INSTANCE;
        e r11 = r10.getMAP();
        e r12 = e.n(Class.class);
        RoomTypeNames r13 = RoomTypeNames.INSTANCE;
        jk.a r14 = u.a(v.n(r11, new x[]{v.n(r12, new x[]{b0.o(r13.getAUTO_MIGRATION_SPEC())}), r13.getAUTO_MIGRATION_SPEC()}), "autoMigrationSpecsMap", new Modifier[0]);
        r14.j();
        r5.m(r14.n());
        r5.v(v.n(r10.getLIST(), new x[]{r13.getMIGRATION()}));
        List<AutoMigration> r15 = this.database.getAutoMigrations();
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L4:
        if (r17.hasNext() == false) goto L10;
        AutoMigration r18 = (AutoMigration) r17.next();
        XClassName r19 = r18.getImplTypeName(this.database.getTypeName());
        if (r18.isSpecProvided() == false) goto L8;
        i r20 = i.d(j0.l("new ", Javapoet_extKt.getT(), "(autoMigrationSpecsMap.get(", Javapoet_extKt.getT(), ".class))"), new Object[]{XTypeNameKt.toJavaPoet(r19), r18.getSpecClassName()});
    L9:
        r16.add(r20);
        goto L4
    L8:
        r20 = i.d(j0.k("new ", Javapoet_extKt.getT(), "()"), new Object[]{XTypeNameKt.toJavaPoet(r19)});
        goto L9
    L10:
        r5.o(j0.l("return ", Javapoet_extKt.getT(), ".asList(", Javapoet_extKt.getL(), ")"), new Object[]{CommonTypeNames.INSTANCE.getARRAYS(), i.c("," + Javapoet_extKt.getW(), r16)});
        return r5.r();
    }

    @Override // androidx.room.writer.TypeWriter
    public XTypeSpec.Builder createTypeSpecBuilder() {
        XTypeSpec.Builder r5 = XTypeSpec.Companion.classBuilder(getCodeLanguage(), this.database.getImplTypeName());
        XTypeSpec.Builder.Companion.apply(r5, new AnonymousClass1(this), AnonymousClass2.INSTANCE);
        return r5;
    }

    public final Database getDatabase() {
        return this.database;
    }
}
