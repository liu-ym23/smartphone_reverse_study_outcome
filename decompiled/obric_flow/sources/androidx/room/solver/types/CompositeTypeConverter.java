package androidx.room.solver.types;

import androidx.room.solver.CodeGenScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0014J \u0010\b\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006¨\u0006\u000f"}, d2 = {"Landroidx/room/solver/types/CompositeTypeConverter;", "Landroidx/room/solver/types/TypeConverter;", "conv1", "conv2", "(Landroidx/room/solver/types/TypeConverter;Landroidx/room/solver/types/TypeConverter;)V", "getConv1", "()Landroidx/room/solver/types/TypeConverter;", "getConv2", "doConvert", "", "inputVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "", "outputVarName", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CompositeTypeConverter extends TypeConverter {
    private final TypeConverter conv1;
    private final TypeConverter conv2;

    public CompositeTypeConverter(TypeConverter r5, TypeConverter r10) {
        Intrinsics.checkNotNullParameter(r5, "conv1");
        Intrinsics.checkNotNullParameter(r10, "conv2");
        super(r5.getFrom(), r10.getTo(), r5.getCost().plus(r10.getCost()));
        this.conv1 = r5;
        this.conv2 = r10;
    }

    @Override // androidx.room.solver.types.TypeConverter
    public void doConvert(String r5, String r10, CodeGenScope r11) {
        Intrinsics.checkNotNullParameter(r5, "inputVarName");
        Intrinsics.checkNotNullParameter(r10, "outputVarName");
        Intrinsics.checkNotNullParameter(r11, "scope");
        r11.builder();
        String r12 = this.conv1.convert(r5, r11);
        this.conv2.convert(r12, r10, r11);
    }

    public final TypeConverter getConv1() {
        return this.conv1;
    }

    public final TypeConverter getConv2() {
        return this.conv2;
    }

    @Override // androidx.room.solver.types.TypeConverter
    public String doConvert(String r5, CodeGenScope r10) {
        Intrinsics.checkNotNullParameter(r5, "inputVarName");
        Intrinsics.checkNotNullParameter(r10, "scope");
        r10.builder();
        String r11 = this.conv1.convert(r5, r10);
        return this.conv2.convert(r11, r10);
    }
}
