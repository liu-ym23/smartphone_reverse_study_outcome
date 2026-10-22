package androidx.room.writer;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.ext.AndroidTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.ext.String_extKt;
import androidx.room.solver.CodeGenScope;
import androidx.room.vo.Entity;
import androidx.room.vo.Field;
import androidx.room.vo.FieldWithIndex;
import androidx.room.vo.Fields;
import com.bytedance.ai.event.MessageIndication;
import com.squareup.javapoet.g;
import com.squareup.javapoet.i;
import com.squareup.javapoet.s;
import com.squareup.javapoet.u;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/room/writer/EntityCursorConverterWriter;", "Landroidx/room/writer/TypeWriter$SharedMethodSpec;", "Landroidx/room/vo/Entity;", "entity", "<init>", "(Landroidx/room/vo/Entity;)V", "Landroidx/room/writer/TypeWriter;", "writer", "Lcom/squareup/javapoet/u;", "cursorParam", "Lcom/squareup/javapoet/i;", "buildConvertMethodBody", "(Landroidx/room/writer/TypeWriter;Lcom/squareup/javapoet/u;)Lcom/squareup/javapoet/i;", "", "getUniqueKey", "()Ljava/lang/String;", "methodName", "Lcom/squareup/javapoet/s;", "builder", "", MessageIndication.STATUS_PREPARE, "(Ljava/lang/String;Landroidx/room/writer/TypeWriter;Lcom/squareup/javapoet/s;)V", "Landroidx/room/vo/Entity;", "getEntity", "()Landroidx/room/vo/Entity;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityCursorConverterWriter extends TypeWriter.SharedMethodSpec {
    private final Entity entity;

    public EntityCursorConverterWriter(Entity r5) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        super(j0.C("entityCursorConverter_", String_extKt.stripNonJava(XTypeNameKt.toJavaPoet(r5.getTypeName()).toString())));
        this.entity = r5;
    }

    private final i buildConvertMethodBody(TypeWriter r18, u r19) {
        CodeGenScope r10 = new CodeGenScope(r18);
        String r11 = r10.getTmpVar("_entity");
        g r12 = r10.builder();
        r10.builder().c(a.p("final ", Javapoet_extKt.getT(), " ", Javapoet_extKt.getL()), new Object[]{XTypeNameKt.toJavaPoet(this.entity.getTypeName()), r11});
        Fields r5 = this.entity.getFields();
        ArrayList r13 = new ArrayList(CollectionsKt.h(r5));
        Iterator<Field> r14 = r5.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        Field r15 = r14.next();
        String r16 = r10.getTmpVar("_cursorIndexOf" + String_extKt.capitalize(String_extKt.stripNonJava(r15.getName()), Locale.US));
        g r17 = r10.builder();
        String r110 = Javapoet_extKt.getT();
        String r111 = Javapoet_extKt.getL();
        String r112 = Javapoet_extKt.getT();
        String r113 = Javapoet_extKt.getN();
        Iterator<Field> r114 = r14;
        String r20 = Javapoet_extKt.getS();
        g r115 = r12;
        StringBuilder r21 = a.y("final ", r110, " ", r111, " = ");
        a.C(r21, r112, ".getColumnIndex(", r113, ", ");
        r17.c(j0.q(r21, r20, ")"), new Object[]{x.f15023h, r16, RoomTypeNames.INSTANCE.getCURSOR_UTIL(), r19, r15.getColumnName()});
        r13.add(new FieldWithIndex(r15, r16, false));
        r14 = r114;
        r12 = r115;
        goto L4
    L6:
        FieldReadWriteWriter.Companion.readFromCursor(r11, this.entity, r19.f15017a, r13, r10, CollectionsKt.emptyList());
        r12.c(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r11});
        g r22 = r10.builder();
        r22.getClass();
        return new i(r22);
    }

    public final Entity getEntity() {
        return this.entity;
    }

    @Override // androidx.room.writer.TypeWriter.SharedMethodSpec
    public String getUniqueKey() {
        return j0.C("generic_entity_converter_of_", this.entity.getElement().getQualifiedName());
    }

    @Override // androidx.room.writer.TypeWriter.SharedMethodSpec
    public void prepare(String r5, TypeWriter r10, s r11) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        Intrinsics.checkNotNullParameter(r10, "writer");
        Intrinsics.checkNotNullParameter(r11, "builder");
        u r12 = u.a(XTypeNameKt.toJavaPoet(AndroidTypeNames.INSTANCE.getCURSOR()), "cursor", new Modifier[0]).n();
        r11.m(r12);
        r11.l(new Modifier[]{Modifier.PRIVATE});
        r11.v(XTypeNameKt.toJavaPoet(this.entity.getTypeName()));
        r11.j(buildConvertMethodBody(r10, r12));
    }
}
