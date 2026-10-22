package androidx.room.solver.shortcut.binderprovider;

import androidx.room.compiler.processing.XType;
import androidx.room.solver.shortcut.binder.DeleteOrUpdateMethodBinder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/room/solver/shortcut/binderprovider/DeleteOrUpdateMethodBinderProvider;", "", "matches", "", "declared", "Landroidx/room/compiler/processing/XType;", "provide", "Landroidx/room/solver/shortcut/binder/DeleteOrUpdateMethodBinder;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface DeleteOrUpdateMethodBinderProvider {
    boolean matches(XType r5);

    DeleteOrUpdateMethodBinder provide(XType r5);
}
