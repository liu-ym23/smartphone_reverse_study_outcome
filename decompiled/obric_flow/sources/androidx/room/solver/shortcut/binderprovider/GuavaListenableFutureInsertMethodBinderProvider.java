package androidx.room.solver.shortcut.binderprovider;

import androidx.room.compiler.processing.XType;
import androidx.room.ext.GuavaUtilConcurrentTypeNames;
import androidx.room.processor.Context;
import androidx.room.processor.ProcessorErrors;
import androidx.room.solver.shortcut.binder.CallableInsertMethodBinder;
import androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder;
import androidx.room.solver.shortcut.result.InsertOrUpsertMethodAdapter;
import androidx.room.vo.ShortcutQueryParameter;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/room/solver/shortcut/binderprovider/GuavaListenableFutureInsertMethodBinderProvider;", "Landroidx/room/solver/shortcut/binderprovider/InsertOrUpsertMethodBinderProvider;", "context", "Landroidx/room/processor/Context;", "(Landroidx/room/processor/Context;)V", "hasGuavaRoom", "", "getHasGuavaRoom", "()Z", "hasGuavaRoom$delegate", "Lkotlin/Lazy;", "matches", "declared", "Landroidx/room/compiler/processing/XType;", "provide", "Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", LynxResourceModule.PARAMS_KEY, "", "Landroidx/room/vo/ShortcutQueryParameter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GuavaListenableFutureInsertMethodBinderProvider implements InsertOrUpsertMethodBinderProvider {
    private final Context context;
    private final Lazy hasGuavaRoom$delegate;

    public GuavaListenableFutureInsertMethodBinderProvider(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
        this.hasGuavaRoom$delegate = LazyKt.lazy(new GuavaListenableFutureInsertMethodBinderProvider$hasGuavaRoom$2(this));
    }

    public static final /* synthetic */ Context access$getContext$p(GuavaListenableFutureInsertMethodBinderProvider r5) {
        return r5.context;
    }

    private final boolean getHasGuavaRoom() {
        return ((Boolean) this.hasGuavaRoom$delegate.getValue()).booleanValue();
    }

    @Override // androidx.room.solver.shortcut.binderprovider.InsertOrUpsertMethodBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        if (r5.getTypeArguments().size() == 1) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r5.getRawType().getTypeName(), GuavaUtilConcurrentTypeNames.INSTANCE.getLISTENABLE_FUTURE()) == false) goto L7;
        return true;
    }

    @Override // androidx.room.solver.shortcut.binderprovider.InsertOrUpsertMethodBinderProvider
    public InsertOrUpsertMethodBinder provide(XType r5, List<ShortcutQueryParameter> r10) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        if (getHasGuavaRoom() == true) goto L5;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.getMISSING_ROOM_GUAVA_ARTIFACT(), new Object[0]);
    L5:
        XType r11 = (XType) CollectionsKt.first(r5.getTypeArguments());
        InsertOrUpsertMethodAdapter r12 = this.context.getTypeAdapterStore().findInsertAdapter(r11, r10);
        return CallableInsertMethodBinder.Companion.createInsertBinder(r11, r12, AnonymousClass1.INSTANCE);
    }
}
