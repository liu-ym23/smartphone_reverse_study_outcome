package androidx.room.solver.types;

import ai.j0;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.g;
import com.squareup.javapoet.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0004¢\u0006\u0004\b\r\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/room/solver/types/SingleStatementTypeConverter;", "Landroidx/room/solver/types/TypeConverter;", "Landroidx/room/compiler/processing/XType;", "from", "to", "<init>", "(Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XType;)V", "", "inputVarName", "outputVarName", "Landroidx/room/solver/CodeGenScope;", "scope", "", "doConvert", "(Ljava/lang/String;Ljava/lang/String;Landroidx/room/solver/CodeGenScope;)V", "(Ljava/lang/String;Landroidx/room/solver/CodeGenScope;)Ljava/lang/String;", "Lcom/squareup/javapoet/i;", "buildStatement", "(Ljava/lang/String;Landroidx/room/solver/CodeGenScope;)Lcom/squareup/javapoet/i;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class SingleStatementTypeConverter extends TypeConverter {
    public SingleStatementTypeConverter(XType r10, XType r11) {
        Intrinsics.checkNotNullParameter(r10, "from");
        Intrinsics.checkNotNullParameter(r11, "to");
        super(r10, r11, null, 4, null);
    }

    public abstract i buildStatement(String r5, CodeGenScope r10);

    @Override // androidx.room.solver.types.TypeConverter
    public final void doConvert(String r5, String r10, CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r5, "inputVarName");
        a.k(r10, "outputVarName", "scope", r11).c(j0.D(Javapoet_extKt.getL(), " = ", Javapoet_extKt.getL()), new Object[]{r10, buildStatement(r5, r11)});
    }

    @Override // androidx.room.solver.types.TypeConverter
    public final String doConvert(String r10, CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r10, "inputVarName");
        Intrinsics.checkNotNullParameter(r11, "scope");
        String r5 = r11.getTmpVar();
        g r12 = r11.builder();
        String r13 = Javapoet_extKt.getT();
        String r14 = Javapoet_extKt.getL();
        String r15 = Javapoet_extKt.getL();
        StringBuilder r16 = androidx.constraintlayout.motion.widget.a.y("final ", r13, " ", r14, " = ");
        r16.append(r15);
        r12.c(r16.toString(), new Object[]{getTo().getTypeName(), r5, buildStatement(r10, r11)});
        return r5;
    }
}
