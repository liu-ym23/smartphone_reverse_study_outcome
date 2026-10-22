package androidx.room.writer;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.ext.SupportDbTypeNames;
import androidx.room.solver.CodeGenScope;
import androidx.room.vo.FieldWithIndex;
import androidx.room.vo.Fields;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/room/writer/EntityDeletionAdapterWriter;", "", "", "tableName", "Lcom/squareup/javapoet/x;", "pojoTypeName", "Landroidx/room/vo/Fields;", "fields", "<init>", "(Ljava/lang/String;Lcom/squareup/javapoet/x;Landroidx/room/vo/Fields;)V", "Landroidx/room/writer/TypeWriter;", "typeWriter", "dbParam", "Lcom/squareup/javapoet/z;", "createAnonymous", "(Landroidx/room/writer/TypeWriter;Ljava/lang/String;)Lcom/squareup/javapoet/z;", "Ljava/lang/String;", "getTableName", "()Ljava/lang/String;", "Lcom/squareup/javapoet/x;", "getPojoTypeName", "()Lcom/squareup/javapoet/x;", "Landroidx/room/vo/Fields;", "getFields", "()Landroidx/room/vo/Fields;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityDeletionAdapterWriter {
    public static final Companion Companion = null;
    private final Fields fields;
    private final x pojoTypeName;
    private final String tableName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/writer/EntityDeletionAdapterWriter$Companion;", "", "()V", "create", "Landroidx/room/writer/EntityDeletionAdapterWriter;", "entity", "Landroidx/room/vo/ShortcutEntity;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final EntityDeletionAdapterWriter create(ShortcutEntity r5) {
            Intrinsics.checkNotNullParameter(r5, "entity");
            if (r5.isPartialEntity() == false) goto L5;
            Fields r10 = r5.getPojo().getFields();
        L7:
            return new EntityDeletionAdapterWriter(r5.getTableName(), XTypeNameKt.toJavaPoet(r5.getPojo().getTypeName()), r10, null);
        L5:
            r10 = r5.getPrimaryKey().getFields();
            goto L7
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ EntityDeletionAdapterWriter(String r5, x r10, Fields r11, DefaultConstructorMarker r12) {
        this(r5, r10, r11);
    }

    public final z createAnonymous(TypeWriter r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "typeWriter");
        Intrinsics.checkNotNullParameter(r15, "dbParam");
        y r16 = z.a(String.valueOf(Javapoet_extKt.getL()), new Object[]{r15});
        r16.f(v.n(RoomTypeNames.INSTANCE.getDELETE_OR_UPDATE_ADAPTER(), new x[]{this.pojoTypeName}));
        s r5 = t.e("createQuery");
        r5.h();
        r5.v(e.o("java.lang", "String", new String[0]));
        r5.l(new Modifier[]{Modifier.PUBLIC});
        r5.o(j0.C("return ", Javapoet_extKt.getS()), new Object[]{a.p("DELETE FROM `", this.tableName, "` WHERE ", CollectionsKt.q(this.fields.getColumnNames$room_compiler(), " AND ", null, null, 0, null, EntityDeletionAdapterWriter$createAnonymous$1$1$query$1.INSTANCE, 30))});
        r16.b(r5.r());
        s r10 = t.e("bind");
        CodeGenScope r11 = new CodeGenScope(r14);
        r10.h();
        r10.m(u.a(SupportDbTypeNames.INSTANCE.getSQLITE_STMT(), "stmt", new Modifier[0]).n());
        r10.m(u.a(this.pojoTypeName, "value", new Modifier[0]).n());
        r10.v(x.d);
        r10.l(new Modifier[]{Modifier.PUBLIC});
        FieldReadWriteWriter.Companion.bindToStatement("value", "stmt", FieldWithIndex.Companion.byOrder(this.fields), r11);
        r10.j(r11.builder().f());
        r16.b(r10.r());
        return r16.e();
    }

    public final Fields getFields() {
        return this.fields;
    }

    public final x getPojoTypeName() {
        return this.pojoTypeName;
    }

    public final String getTableName() {
        return this.tableName;
    }

    private EntityDeletionAdapterWriter(String r5, x r10, Fields r11) {
        this.tableName = r5;
        this.pojoTypeName = r10;
        this.fields = r11;
    }
}
