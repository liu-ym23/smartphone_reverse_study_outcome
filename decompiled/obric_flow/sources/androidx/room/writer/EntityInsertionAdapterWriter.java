package androidx.room.writer;

import ai.j0;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.ext.SupportDbTypeNames;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.types.StatementValueBinder;
import androidx.room.vo.Field;
import androidx.room.vo.FieldWithIndex;
import androidx.room.vo.HasFieldsKt;
import androidx.room.vo.Pojo;
import androidx.room.vo.ShortcutEntity;
import com.squareup.javapoet.e;
import com.squareup.javapoet.s;
import com.squareup.javapoet.t;
import com.squareup.javapoet.u;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import com.squareup.javapoet.y;
import com.squareup.javapoet.z;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B+\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012¨\u0006\u0019"}, d2 = {"Landroidx/room/writer/EntityInsertionAdapterWriter;", "", "", "tableName", "Landroidx/room/vo/Pojo;", "pojo", "primitiveAutoGenerateColumn", "onConflict", "<init>", "(Ljava/lang/String;Landroidx/room/vo/Pojo;Ljava/lang/String;Ljava/lang/String;)V", "Landroidx/room/writer/TypeWriter;", "typeWriter", "dbParam", "Lcom/squareup/javapoet/z;", "createAnonymous", "(Landroidx/room/writer/TypeWriter;Ljava/lang/String;)Lcom/squareup/javapoet/z;", "Ljava/lang/String;", "getTableName", "()Ljava/lang/String;", "Landroidx/room/vo/Pojo;", "getPojo", "()Landroidx/room/vo/Pojo;", "getPrimitiveAutoGenerateColumn", "getOnConflict", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityInsertionAdapterWriter {
    public static final Companion Companion = null;
    private final String onConflict;
    private final Pojo pojo;
    private final String primitiveAutoGenerateColumn;
    private final String tableName;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/room/writer/EntityInsertionAdapterWriter$Companion;", "", "()V", "create", "Landroidx/room/writer/EntityInsertionAdapterWriter;", "entity", "Landroidx/room/vo/ShortcutEntity;", "onConflict", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final EntityInsertionAdapterWriter create(ShortcutEntity r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "entity");
            Intrinsics.checkNotNullParameter(r11, "onConflict");
            String r5 = null;
            if (r10.getPrimaryKey().getAutoGenerateId() == false) goto L13;
            Field r12 = (Field) CollectionsKt.firstOrNull(r10.getPrimaryKey().getFields());
            if (r12 == null) goto L13;
            StatementValueBinder r13 = r12.getStatementBinder();
            if (r13 == null) goto L13;
            XType r14 = r13.typeMirror();
            if (r14 == null) goto L13;
            if (r14.getNullability() != XNullability.NONNULL) goto L13;
        L14:
            String r15 = r10.getTableName();
            Pojo r16 = r10.getPojo();
            if (r12 == null) goto L18;
            r5 = r12.getColumnName();
        L18:
            return new EntityInsertionAdapterWriter(r15, r16, r5, r11, null);
        L13:
            r12 = null;
            goto L14
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ EntityInsertionAdapterWriter(String r5, Pojo r10, String r11, String r12, DefaultConstructorMarker r13) {
        this(r5, r10, r11, r12);
    }

    public final z createAnonymous(TypeWriter r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "typeWriter");
        Intrinsics.checkNotNullParameter(r19, "dbParam");
        y r5 = z.a(String.valueOf(Javapoet_extKt.getL()), new Object[]{r19});
        r5.f(v.n(RoomTypeNames.INSTANCE.getINSERTION_ADAPTER(), new x[]{XTypeNameKt.toJavaPoet(this.pojo.getTypeName())}));
        s r10 = t.e("createQuery");
        r10.h();
        r10.l(new Modifier[]{Modifier.PUBLIC});
        r10.v(e.o("java.lang", "String", new String[0]));
        StringBuilder r11 = new StringBuilder();
        if (this.onConflict.length() <= 0) goto L5;
        r11.append(j0.l("INSERT OR ", this.onConflict, " INTO `", this.tableName, "`"));
    L6:
        r11.append(" (" + CollectionsKt.q(HasFieldsKt.getColumnNames(this.pojo), ",", null, null, 0, null, EntityInsertionAdapterWriter$createAnonymous$1$1$query$1$1.INSTANCE, 30) + ")");
        r11.append(" VALUES (");
        r10.o(j0.C("return ", Javapoet_extKt.getS()), new Object[]{j0.q(r11, CollectionsKt.q(this.pojo.getFields(), ",", null, null, 0, null, new EntityInsertionAdapterWriter$createAnonymous$1$1$query$1$2(this), 30), ")")});
        r5.b(r10.r());
        s r12 = t.e("bind");
        CodeGenScope r13 = new CodeGenScope(r18);
        r12.h();
        r12.l(new Modifier[]{Modifier.PUBLIC});
        r12.v(x.d);
        r12.m(u.a(SupportDbTypeNames.INSTANCE.getSQLITE_STMT(), "stmt", new Modifier[0]).n());
        r12.m(u.a(XTypeNameKt.toJavaPoet(this.pojo.getTypeName()), "value", new Modifier[0]).n());
        FieldReadWriteWriter.Companion.bindToStatement("value", "stmt", FieldWithIndex.Companion.byOrder(this.pojo.getFields()), r13);
        r12.j(r13.builder().f());
        r5.b(r12.r());
        return r5.e();
    L5:
        r11.append("INSERT INTO `" + this.tableName + "`");
        goto L6
    }

    public final String getOnConflict() {
        return this.onConflict;
    }

    public final Pojo getPojo() {
        return this.pojo;
    }

    public final String getPrimitiveAutoGenerateColumn() {
        return this.primitiveAutoGenerateColumn;
    }

    public final String getTableName() {
        return this.tableName;
    }

    private EntityInsertionAdapterWriter(String r5, Pojo r10, String r11, String r12) {
        this.tableName = r5;
        this.pojo = r10;
        this.primitiveAutoGenerateColumn = r11;
        this.onConflict = r12;
    }
}
