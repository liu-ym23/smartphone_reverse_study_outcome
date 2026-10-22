package androidx.room.writer;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.ext.CommonTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.ext.String_extKt;
import androidx.room.vo.Field;
import androidx.room.vo.FtsEntity;
import com.squareup.javapoet.u;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/room/writer/FtsTableInfoValidationWriter;", "Landroidx/room/writer/ValidationWriter;", "Landroidx/room/vo/FtsEntity;", "entity", "<init>", "(Landroidx/room/vo/FtsEntity;)V", "Lcom/squareup/javapoet/u;", "dbParam", "Landroidx/room/writer/ValidationWriter$CountingCodeGenScope;", "scope", "", "write", "(Lcom/squareup/javapoet/u;Landroidx/room/writer/ValidationWriter$CountingCodeGenScope;)V", "Landroidx/room/vo/FtsEntity;", "getEntity", "()Landroidx/room/vo/FtsEntity;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FtsTableInfoValidationWriter extends ValidationWriter {
    private final FtsEntity entity;

    public FtsTableInfoValidationWriter(FtsEntity r5) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        this.entity = r5;
    }

    public final FtsEntity getEntity() {
        return this.entity;
    }

    @Override // androidx.room.writer.ValidationWriter
    public void write(u r19, ValidationWriter.CountingCodeGenScope r20) {
        Intrinsics.checkNotNullParameter(r19, "dbParam");
        Intrinsics.checkNotNullParameter(r20, "scope");
        String r5 = String_extKt.capitalize(String_extKt.stripNonJava(this.entity.getTableName()), Locale.US);
        String r10 = r20.getTmpVar("_info" + r5);
        ValidationWriter.CodeBlockWrapper r11 = r20.builder();
        String r12 = r20.getTmpVar("_columns" + r5);
        v r13 = v.n(Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(HashSet.class)), new x[]{CommonTypeNames.INSTANCE.getSTRING()});
        r11.addStatement(a.u(a.y("final ", Javapoet_extKt.getT(), " ", Javapoet_extKt.getL(), " = new "), Javapoet_extKt.getT(), "(", Javapoet_extKt.getL(), ")"), new Object[]{r13, r12, r13, Integer.valueOf(this.entity.getFields().size())});
        Iterator r14 = this.entity.getNonHiddenFields().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r11.addStatement(androidx.room.jarjarred.org.antlr.runtime.a.q(Javapoet_extKt.getL(), ".add(", Javapoet_extKt.getS(), ")"), new Object[]{r12, ((Field) r14.next()).getColumnName()});
        r14 = r14;
        goto L4
    L6:
        String r15 = Javapoet_extKt.getT();
        String r16 = Javapoet_extKt.getL();
        String r17 = Javapoet_extKt.getT();
        String r18 = Javapoet_extKt.getS();
        String r21 = Javapoet_extKt.getL();
        String r22 = Javapoet_extKt.getS();
        StringBuilder r23 = a.y("final ", r15, " ", r16, " = new ");
        a.C(r23, r17, "(", r18, ", ");
        String r24 = a.u(r23, r21, ", ", r22, ")");
        RoomTypeNames r25 = RoomTypeNames.INSTANCE;
        r11.addStatement(r24, new Object[]{r25.getFTS_TABLE_INFO(), r10, r25.getFTS_TABLE_INFO(), this.entity.getTableName(), r12, this.entity.getCreateTableQuery()});
        String r26 = r20.getTmpVar("_existing" + r5);
        String r27 = Javapoet_extKt.getT();
        String r28 = Javapoet_extKt.getL();
        String r29 = Javapoet_extKt.getT();
        String r30 = Javapoet_extKt.getN();
        String r31 = Javapoet_extKt.getS();
        StringBuilder r32 = a.y("final ", r27, " ", r28, " = ");
        a.C(r32, r29, ".read(", r30, ", ");
        r11.addStatement(j0.q(r32, r31, ")"), new Object[]{r25.getFTS_TABLE_INFO(), r26, r25.getFTS_TABLE_INFO(), r19, this.entity.getTableName()});
        ValidationWriter.CodeBlockWrapper r33 = r11.beginControlFlow(j0.l("if (!", Javapoet_extKt.getL(), ".equals(", Javapoet_extKt.getL(), "))"), new Object[]{r10, r26});
        String r34 = Javapoet_extKt.getT();
        String r35 = Javapoet_extKt.getS();
        String r36 = Javapoet_extKt.getL();
        String r37 = Javapoet_extKt.getS();
        String r38 = Javapoet_extKt.getL();
        StringBuilder r39 = a.y("return new ", r34, "(false, ", r35, " + ");
        a.C(r39, r36, " + ", r37, " + ");
        r33.addStatement(j0.q(r39, r38, ")"), new Object[]{r25.getOPEN_HELPER_VALIDATION_RESULT(), androidx.room.jarjarred.org.antlr.runtime.a.q(this.entity.getTableName(), "(", this.entity.getElement().getQualifiedName(), ").\n Expected:\n"), r10, "\n Found:\n", r26});
        r11.endControlFlow();
    }
}
