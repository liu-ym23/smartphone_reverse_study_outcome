package androidx.room.solver.shortcut.binderprovider;

import androidx.room.compiler.processing.XRawType;
import androidx.room.compiler.processing.XType;
import androidx.room.processor.Context;
import androidx.room.solver.RxType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/room/solver/shortcut/binderprovider/RxCompletableUpsertMethodBinderProvider;", "Landroidx/room/solver/shortcut/binderprovider/RxCallableUpsertMethodBinderProvider;", "context", "Landroidx/room/processor/Context;", "rxType", "Landroidx/room/solver/RxType;", "(Landroidx/room/processor/Context;Landroidx/room/solver/RxType;)V", "completableType", "Landroidx/room/compiler/processing/XRawType;", "getCompletableType", "()Landroidx/room/compiler/processing/XRawType;", "completableType$delegate", "Lkotlin/Lazy;", "extractTypeArg", "Landroidx/room/compiler/processing/XType;", "declared", "isCompletable", "", "matches", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class RxCompletableUpsertMethodBinderProvider extends RxCallableUpsertMethodBinderProvider {
    private final Lazy completableType$delegate;

    public RxCompletableUpsertMethodBinderProvider(final Context r5, final RxType r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "rxType");
        super(r5, r10);
        this.completableType$delegate = LazyKt.lazy(new RxCompletableUpsertMethodBinderProvider$completableType$2(r5, r10));
    }

    private final XRawType getCompletableType() {
        return (XRawType) this.completableType$delegate.getValue();
    }

    private final boolean isCompletable(XType r5) {
        if (getCompletableType() != null) goto L6;
        return false;
    L6:
        XRawType r10 = r5.getRawType();
        XRawType r11 = getCompletableType();
        Intrinsics.checkNotNull(r11);
        return r10.isAssignableFrom(r11);
    }

    @Override // androidx.room.solver.shortcut.binderprovider.RxCallableUpsertMethodBinderProvider
    public XType extractTypeArg(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        return getContext().getCOMMON_TYPES().getVOID();
    }

    @Override // androidx.room.solver.shortcut.binderprovider.RxCallableUpsertMethodBinderProvider, androidx.room.solver.shortcut.binderprovider.InsertOrUpsertMethodBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        return isCompletable(r5);
    }
}
