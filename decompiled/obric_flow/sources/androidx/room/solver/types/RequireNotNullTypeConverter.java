package androidx.room.solver.types;

import ai.j0;
import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0014J \u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0014¨\u0006\f"}, d2 = {"Landroidx/room/solver/types/RequireNotNullTypeConverter;", "Landroidx/room/solver/types/TypeConverter;", "from", "Landroidx/room/compiler/processing/XType;", "(Landroidx/room/compiler/processing/XType;)V", "doConvert", "", "inputVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "", "outputVarName", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RequireNotNullTypeConverter extends TypeConverter {
    public RequireNotNullTypeConverter(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "from");
        super(r5, r5.makeNonNullable(), TypeConverter.Cost.Companion.getREQUIRE_NOT_NULL());
        if (r5.getNullability() == XNullability.NONNULL) goto L6;
        return;
    L6:
        throw new IllegalStateException("No reason to null check a non-null input");
    }

    @Override // androidx.room.solver.types.TypeConverter
    public String doConvert(String r10, CodeGenScope r11) {
        g r12 = a.k(r10, "inputVarName", "scope", r11);
        r12.e(j0.k("if(", Javapoet_extKt.getL(), " == null)"), new Object[]{r10});
        r12.c(j0.l("throw new ", Javapoet_extKt.getT(), "(", Javapoet_extKt.getS(), ")"), new Object[]{IllegalStateException.class, "Expected non-null " + getFrom().getTypeName() + ", but it was null."});
        r12.g();
        return r10;
    }

    @Override // androidx.room.solver.types.TypeConverter
    public void doConvert(String r10, String r11, CodeGenScope r12) {
        Intrinsics.checkNotNullParameter(r10, "inputVarName");
        g r13 = a.k(r11, "outputVarName", "scope", r12);
        r13.e(j0.k("if(", Javapoet_extKt.getL(), " == null)"), new Object[]{r10});
        r13.c(j0.l("throw new ", Javapoet_extKt.getT(), "(", Javapoet_extKt.getS(), ")"), new Object[]{IllegalStateException.class, "Expected non-null " + getFrom().getTypeName() + ", but it was null."});
        r13.h("else", new Object[0]);
        r13.c(j0.D(Javapoet_extKt.getL(), " = ", Javapoet_extKt.getL()), new Object[]{r11, r10});
        r13.g();
    }
}
