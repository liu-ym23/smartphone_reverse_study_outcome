package androidx.room.solver.types;

import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XType;
import com.squareup.javapoet.x;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/room/solver/types/PrimitiveBooleanToIntConverter;", "", "()V", "create", "", "Landroidx/room/solver/types/TypeConverter;", "processingEnvironment", "Landroidx/room/compiler/processing/XProcessingEnv;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PrimitiveBooleanToIntConverter {
    public static final PrimitiveBooleanToIntConverter INSTANCE = null;

    static {
        INSTANCE = new PrimitiveBooleanToIntConverter();
    }

    private PrimitiveBooleanToIntConverter() {
    }

    public final List<TypeConverter> create(XProcessingEnv r5) {
        Intrinsics.checkNotNullParameter(r5, "processingEnvironment");
        final XType r10 = r5.requireType(x.e);
        final XType r11 = r5.requireType(x.f15023h);
        return CollectionsKt.listOf(new SingleStatementTypeConverter[]{new AnonymousClass1(r10, r11), new AnonymousClass2(r11, r10)});
    }
}
