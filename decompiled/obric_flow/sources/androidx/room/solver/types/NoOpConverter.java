package androidx.room.solver.types;

import ai.j0;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0014J \u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0014¨\u0006\f"}, d2 = {"Landroidx/room/solver/types/NoOpConverter;", "Landroidx/room/solver/types/TypeConverter;", "type", "Landroidx/room/compiler/processing/XType;", "(Landroidx/room/compiler/processing/XType;)V", "doConvert", "", "inputVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "", "outputVarName", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NoOpConverter extends TypeConverter {
    public NoOpConverter(XType r10) {
        Intrinsics.checkNotNullParameter(r10, "type");
        super(r10, r10, null, 4, null);
    }

    @Override // androidx.room.solver.types.TypeConverter
    public String doConvert(String r5, CodeGenScope r10) {
        Intrinsics.checkNotNullParameter(r5, "inputVarName");
        Intrinsics.checkNotNullParameter(r10, "scope");
        return r5;
    }

    @Override // androidx.room.solver.types.TypeConverter
    public void doConvert(String r5, String r10, CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r5, "inputVarName");
        a.k(r10, "outputVarName", "scope", r11).c(j0.D(Javapoet_extKt.getL(), " = ", Javapoet_extKt.getL()), new Object[]{r10, r5});
    }
}
