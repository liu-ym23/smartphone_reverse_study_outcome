package androidx.room.solver.shortcut.binderprovider;

import androidx.room.compiler.processing.XType;
import androidx.room.processor.Context;
import androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder;
import androidx.room.solver.shortcut.binder.InstantUpsertMethodBinder;
import androidx.room.vo.ShortcutQueryParameter;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/room/solver/shortcut/binderprovider/InstantUpsertMethodBinderProvider;", "Landroidx/room/solver/shortcut/binderprovider/InsertOrUpsertMethodBinderProvider;", "context", "Landroidx/room/processor/Context;", "(Landroidx/room/processor/Context;)V", "matches", "", "declared", "Landroidx/room/compiler/processing/XType;", "provide", "Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", LynxResourceModule.PARAMS_KEY, "", "Landroidx/room/vo/ShortcutQueryParameter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InstantUpsertMethodBinderProvider implements InsertOrUpsertMethodBinderProvider {
    private final Context context;

    public InstantUpsertMethodBinderProvider(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
    }

    @Override // androidx.room.solver.shortcut.binderprovider.InsertOrUpsertMethodBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        return true;
    }

    @Override // androidx.room.solver.shortcut.binderprovider.InsertOrUpsertMethodBinderProvider
    public InsertOrUpsertMethodBinder provide(XType r5, List<ShortcutQueryParameter> r10) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        return new InstantUpsertMethodBinder(this.context.getTypeAdapterStore().findUpsertAdapter(r5, r10));
    }
}
