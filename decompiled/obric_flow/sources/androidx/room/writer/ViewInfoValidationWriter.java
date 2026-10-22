package androidx.room.writer;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.ext.String_extKt;
import androidx.room.vo.DatabaseView;
import com.squareup.javapoet.u;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/room/writer/ViewInfoValidationWriter;", "Landroidx/room/writer/ValidationWriter;", "Landroidx/room/vo/DatabaseView;", "view", "<init>", "(Landroidx/room/vo/DatabaseView;)V", "Lcom/squareup/javapoet/u;", "dbParam", "Landroidx/room/writer/ValidationWriter$CountingCodeGenScope;", "scope", "", "write", "(Lcom/squareup/javapoet/u;Landroidx/room/writer/ValidationWriter$CountingCodeGenScope;)V", "Landroidx/room/vo/DatabaseView;", "getView", "()Landroidx/room/vo/DatabaseView;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewInfoValidationWriter extends ValidationWriter {
    private final DatabaseView view;

    public ViewInfoValidationWriter(DatabaseView r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.view = r5;
    }

    public final DatabaseView getView() {
        return this.view;
    }

    @Override // androidx.room.writer.ValidationWriter
    public void write(u r18, ValidationWriter.CountingCodeGenScope r19) {
        Intrinsics.checkNotNullParameter(r18, "dbParam");
        Intrinsics.checkNotNullParameter(r19, "scope");
        String r5 = String_extKt.capitalize(String_extKt.stripNonJava(this.view.getViewName()), Locale.US);
        ValidationWriter.CodeBlockWrapper r10 = r19.builder();
        String r11 = r19.getTmpVar("_info" + r5);
        String r12 = Javapoet_extKt.getT();
        String r13 = Javapoet_extKt.getL();
        String r14 = Javapoet_extKt.getT();
        String r15 = Javapoet_extKt.getS();
        String r16 = Javapoet_extKt.getS();
        StringBuilder r17 = a.y("final ", r12, " ", r13, " = new ");
        a.C(r17, r14, "(", r15, ", ");
        String r20 = j0.q(r17, r16, ")");
        RoomTypeNames r21 = RoomTypeNames.INSTANCE;
        r10.addStatement(r20, new Object[]{r21.getVIEW_INFO(), r11, r21.getVIEW_INFO(), this.view.getViewName(), this.view.getCreateViewQuery()});
        String r22 = r19.getTmpVar("_existing" + r5);
        String r23 = Javapoet_extKt.getT();
        String r24 = Javapoet_extKt.getL();
        String r25 = Javapoet_extKt.getT();
        String r110 = Javapoet_extKt.getN();
        String r111 = Javapoet_extKt.getS();
        StringBuilder r26 = a.y("final ", r23, " ", r24, " = ");
        a.C(r26, r25, ".read(", r110, ", ");
        r10.addStatement(j0.q(r26, r111, ")"), new Object[]{r21.getVIEW_INFO(), r22, r21.getVIEW_INFO(), r18, this.view.getViewName()});
        ValidationWriter.CodeBlockWrapper r27 = r10.beginControlFlow(j0.l("if (! ", Javapoet_extKt.getL(), ".equals(", Javapoet_extKt.getL(), "))"), new Object[]{r11, r22});
        String r28 = Javapoet_extKt.getT();
        String r29 = Javapoet_extKt.getS();
        String r30 = Javapoet_extKt.getL();
        String r112 = Javapoet_extKt.getS();
        String r113 = Javapoet_extKt.getL();
        StringBuilder r31 = a.y("return new ", r28, "(false, ", r29, " + ");
        a.C(r31, r30, " + ", r112, " + ");
        r27.addStatement(j0.q(r31, r113, ")"), new Object[]{r21.getOPEN_HELPER_VALIDATION_RESULT(), androidx.room.jarjarred.org.antlr.runtime.a.q(this.view.getViewName(), "(", this.view.getElement().getQualifiedName(), ").\n Expected:\n"), r11, "\n Found:\n", r22});
        r10.endControlFlow();
    }
}
