package androidx.room.writer;

import ai.j0;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.ext.SupportDbTypeNames;
import androidx.room.solver.CodeGenScope;
import androidx.room.vo.Field;
import androidx.room.vo.FieldWithIndex;
import androidx.room.vo.Fields;
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
import java.util.ArrayList;
import java.util.Iterator;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013¨\u0006\u001c"}, d2 = {"Landroidx/room/writer/EntityUpdateAdapterWriter;", "", "", "tableName", "Landroidx/room/vo/Pojo;", "pojo", "Landroidx/room/vo/Fields;", "primaryKeyFields", "onConflict", "<init>", "(Ljava/lang/String;Landroidx/room/vo/Pojo;Landroidx/room/vo/Fields;Ljava/lang/String;)V", "Landroidx/room/writer/TypeWriter;", "typeWriter", "dbParam", "Lcom/squareup/javapoet/z;", "createAnonymous", "(Landroidx/room/writer/TypeWriter;Ljava/lang/String;)Lcom/squareup/javapoet/z;", "Ljava/lang/String;", "getTableName", "()Ljava/lang/String;", "Landroidx/room/vo/Pojo;", "getPojo", "()Landroidx/room/vo/Pojo;", "Landroidx/room/vo/Fields;", "getPrimaryKeyFields", "()Landroidx/room/vo/Fields;", "getOnConflict", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityUpdateAdapterWriter {
    public static final Companion Companion = null;
    private final String onConflict;
    private final Pojo pojo;
    private final Fields primaryKeyFields;
    private final String tableName;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/room/writer/EntityUpdateAdapterWriter$Companion;", "", "()V", "create", "Landroidx/room/writer/EntityUpdateAdapterWriter;", "entity", "Landroidx/room/vo/ShortcutEntity;", "onConflict", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final EntityUpdateAdapterWriter create(ShortcutEntity r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "entity");
            Intrinsics.checkNotNullParameter(r11, "onConflict");
            return new EntityUpdateAdapterWriter(r10.getTableName(), r10.getPojo(), r10.getPrimaryKey().getFields(), r11, null);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ EntityUpdateAdapterWriter(String r5, Pojo r10, Fields r11, String r12, DefaultConstructorMarker r13) {
        this(r5, r10, r11, r12);
    }

    public final z createAnonymous(TypeWriter r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "typeWriter");
        Intrinsics.checkNotNullParameter(r15, "dbParam");
        y r16 = z.a(String.valueOf(Javapoet_extKt.getL()), new Object[]{r15});
        r16.f(v.n(RoomTypeNames.INSTANCE.getDELETE_OR_UPDATE_ADAPTER(), new x[]{XTypeNameKt.toJavaPoet(this.pojo.getTypeName())}));
        s r5 = t.e("createQuery");
        r5.h();
        int r10 = 0;
        r5.l(new Modifier[]{Modifier.PUBLIC});
        r5.v(e.o("java.lang", "String", new String[0]));
        String r11 = CollectionsKt.q(HasFieldsKt.getColumnNames(this.pojo), ",", null, null, 0, null, EntityUpdateAdapterWriter$createAnonymous$1$1$pojoCols$1.INSTANCE, 30);
        String r12 = CollectionsKt.q(this.primaryKeyFields.getColumnNames$room_compiler(), " AND ", null, null, 0, null, EntityUpdateAdapterWriter$createAnonymous$1$1$pkFieldsCols$1.INSTANCE, 30);
        StringBuilder r13 = new StringBuilder();
        if (this.onConflict.length() <= 0) goto L5;
        r13.append(j0.l("UPDATE OR ", this.onConflict, " `", this.tableName, "` SET"));
    L6:
        r13.append(" " + r11);
        r13.append(" WHERE");
        r13.append(" " + r12);
        r5.o(j0.C("return ", Javapoet_extKt.getS()), new Object[]{r13.toString()});
        r16.b(r5.r());
        s r17 = t.e("bind");
        CodeGenScope r18 = new CodeGenScope(r14);
        r17.h();
        r17.l(new Modifier[]{Modifier.PUBLIC});
        r17.v(x.d);
        r17.m(u.a(SupportDbTypeNames.INSTANCE.getSQLITE_STMT(), "stmt", new Modifier[0]).n());
        r17.m(u.a(XTypeNameKt.toJavaPoet(this.pojo.getTypeName()), "value", new Modifier[0]).n());
        FieldReadWriteWriter.Companion.bindToStatement("value", "stmt", FieldWithIndex.Companion.byOrder(this.pojo.getFields()), r18);
        int r19 = this.pojo.getFields().size();
        Fields r110 = this.primaryKeyFields;
        ArrayList r20 = new ArrayList(CollectionsKt.h(r110));
        Iterator<Field> r111 = r110.iterator();
    L8:
        if (r111.hasNext() == false) goto L13;
        Field r21 = r111.next();
        int r22 = r10 + 1;
        if (r10 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        r20.add(new FieldWithIndex(r21, String.valueOf((r10 + r19) + 1), true));
        r10 = r22;
        goto L8
    L13:
        FieldReadWriteWriter.Companion.bindToStatement("value", "stmt", r20, r18);
        r17.j(r18.builder().f());
        r16.b(r17.r());
        return r16.e();
    L5:
        r13.append("UPDATE `" + this.tableName + "` SET");
        goto L6
    }

    public final String getOnConflict() {
        return this.onConflict;
    }

    public final Pojo getPojo() {
        return this.pojo;
    }

    public final Fields getPrimaryKeyFields() {
        return this.primaryKeyFields;
    }

    public final String getTableName() {
        return this.tableName;
    }

    private EntityUpdateAdapterWriter(String r5, Pojo r10, Fields r11, String r12) {
        this.tableName = r5;
        this.pojo = r10;
        this.primaryKeyFields = r11;
        this.onConflict = r12;
    }
}
