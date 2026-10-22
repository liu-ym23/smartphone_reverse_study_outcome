package androidx.room.solver.types;

import ai.j0;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0014J \u0010\u0006\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\r"}, d2 = {"Landroidx/room/solver/types/UpCastTypeConverter;", "Landroidx/room/solver/types/TypeConverter;", "upCastFrom", "Landroidx/room/compiler/processing/XType;", "upCastTo", "(Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XType;)V", "doConvert", "", "inputVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "", "outputVarName", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UpCastTypeConverter extends TypeConverter {
    public UpCastTypeConverter(XType r5, XType r10) {
        Intrinsics.checkNotNullParameter(r5, "upCastFrom");
        Intrinsics.checkNotNullParameter(r10, "upCastTo");
        super(r5, r10, TypeConverter.Cost.Companion.getUP_CAST());
    }

    @Override // androidx.room.solver.types.TypeConverter
    public void doConvert(String r5, String r10, CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r5, "inputVarName");
        a.k(r10, "outputVarName", "scope", r11).c(j0.D(Javapoet_extKt.getL(), " = ", Javapoet_extKt.getL()), new Object[]{r10, r5});
    }

    @Override // androidx.room.solver.types.TypeConverter
    public String doConvert(String r5, CodeGenScope r10) {
        Intrinsics.checkNotNullParameter(r5, "inputVarName");
        Intrinsics.checkNotNullParameter(r10, "scope");
        if (getTo().getTypeName().j() == true) goto L5;
        return r5;
    L5:
        if (getFrom().getTypeName().k() == true) goto L7;
        return r5;
    L7:
        return super.doConvert(r5, r10);
    }
}
