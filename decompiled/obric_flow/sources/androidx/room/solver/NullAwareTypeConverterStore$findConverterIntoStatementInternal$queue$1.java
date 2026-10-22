package androidx.room.solver;

import androidx.room.compiler.processing.XType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class NullAwareTypeConverterStore$findConverterIntoStatementInternal$queue$1 extends FunctionReferenceImpl implements Function1<XType, Boolean> {
    public NullAwareTypeConverterStore$findConverterIntoStatementInternal$queue$1(Object r10) {
        super(1, r10, NullAwareTypeConverterStore.class, "isColumnType", "isColumnType(Landroidx/room/compiler/processing/XType;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        return Boolean.valueOf(NullAwareTypeConverterStore.access$isColumnType((NullAwareTypeConverterStore) this.receiver, r5));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(XType r5) {
        return invoke2(r5);
    }
}
