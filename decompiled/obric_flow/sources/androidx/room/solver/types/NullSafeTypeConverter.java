package androidx.room.solver.types;

import ai.j0;
import androidx.annotation.VisibleForTesting;
import androidx.room.compiler.processing.XNullability;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"Landroidx/room/solver/types/NullSafeTypeConverter;", "Landroidx/room/solver/types/TypeConverter;", "delegate", "(Landroidx/room/solver/types/TypeConverter;)V", "getDelegate$room_compiler", "()Landroidx/room/solver/types/TypeConverter;", "doConvert", "", "inputVarName", "", "outputVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NullSafeTypeConverter extends TypeConverter {
    private final TypeConverter delegate;

    public NullSafeTypeConverter(@VisibleForTesting TypeConverter r5) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        super(r5.getFrom().makeNullable(), r5.getTo().makeNullable(), r5.getCost().plus(TypeConverter.Cost.Companion.getNULL_SAFE()));
        this.delegate = r5;
        if (r5.getFrom().getNullability() != XNullability.NONNULL) goto L6;
        return;
    L6:
        throw new IllegalStateException("NullableWrapper can ony be used if the input type is non-nullable");
    }

    @Override // androidx.room.solver.types.TypeConverter
    public void doConvert(String r5, String r10, CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r5, "inputVarName");
        g r12 = a.k(r10, "outputVarName", "scope", r11);
        r12.e(j0.k("if(", Javapoet_extKt.getL(), " == null)"), new Object[]{r5});
        r12.c(j0.j(Javapoet_extKt.getL(), " = null"), new Object[]{r10});
        r12.h("else", new Object[0]);
        this.delegate.convert(r5, r10, r11);
        r12.g();
    }

    public final TypeConverter getDelegate$room_compiler() {
        return this.delegate;
    }
}
