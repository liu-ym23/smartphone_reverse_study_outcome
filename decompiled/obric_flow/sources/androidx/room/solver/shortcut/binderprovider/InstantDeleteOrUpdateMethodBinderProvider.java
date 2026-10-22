package androidx.room.solver.shortcut.binderprovider;

import androidx.room.compiler.processing.XType;
import androidx.room.processor.Context;
import androidx.room.solver.shortcut.binder.DeleteOrUpdateMethodBinder;
import androidx.room.solver.shortcut.binder.InstantDeleteOrUpdateMethodBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/room/solver/shortcut/binderprovider/InstantDeleteOrUpdateMethodBinderProvider;", "Landroidx/room/solver/shortcut/binderprovider/DeleteOrUpdateMethodBinderProvider;", "context", "Landroidx/room/processor/Context;", "(Landroidx/room/processor/Context;)V", "matches", "", "declared", "Landroidx/room/compiler/processing/XType;", "provide", "Landroidx/room/solver/shortcut/binder/DeleteOrUpdateMethodBinder;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InstantDeleteOrUpdateMethodBinderProvider implements DeleteOrUpdateMethodBinderProvider {
    private final Context context;

    public InstantDeleteOrUpdateMethodBinderProvider(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
    }

    @Override // androidx.room.solver.shortcut.binderprovider.DeleteOrUpdateMethodBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        return true;
    }

    @Override // androidx.room.solver.shortcut.binderprovider.DeleteOrUpdateMethodBinderProvider
    public DeleteOrUpdateMethodBinder provide(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        return new InstantDeleteOrUpdateMethodBinder(this.context.getTypeAdapterStore().findDeleteOrUpdateAdapter(r5));
    }
}
