package androidx.room.solver.shortcut.binderprovider;

import androidx.room.compiler.processing.XType;
import androidx.room.processor.Context;
import androidx.room.solver.RxType;
import androidx.room.solver.shortcut.binder.CallableUpsertMethodBinder;
import androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder;
import androidx.room.solver.shortcut.result.InsertOrUpsertMethodAdapter;
import androidx.room.vo.ShortcutQueryParameter;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/room/solver/shortcut/binderprovider/RxCallableUpsertMethodBinderProvider;", "Landroidx/room/solver/shortcut/binderprovider/InsertOrUpsertMethodBinderProvider;", "context", "Landroidx/room/processor/Context;", "rxType", "Landroidx/room/solver/RxType;", "(Landroidx/room/processor/Context;Landroidx/room/solver/RxType;)V", "getContext", "()Landroidx/room/processor/Context;", "extractTypeArg", "Landroidx/room/compiler/processing/XType;", "declared", "matches", "", "matchesRxType", "provide", "Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", LynxResourceModule.PARAMS_KEY, "", "Landroidx/room/vo/ShortcutQueryParameter;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class RxCallableUpsertMethodBinderProvider implements InsertOrUpsertMethodBinderProvider {
    public static final Companion Companion = null;
    private final Context context;
    private final RxType rxType;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/room/solver/shortcut/binderprovider/RxCallableUpsertMethodBinderProvider$Companion;", "", "()V", "getAll", "", "Landroidx/room/solver/shortcut/binderprovider/RxCallableUpsertMethodBinderProvider;", "context", "Landroidx/room/processor/Context;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final List<RxCallableUpsertMethodBinderProvider> getAll(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return CollectionsKt.listOf(new RxCallableUpsertMethodBinderProvider[]{new RxCallableUpsertMethodBinderProvider(r10, RxType.RX2_SINGLE), new RxCallableUpsertMethodBinderProvider(r10, RxType.RX2_MAYBE), new RxCompletableUpsertMethodBinderProvider(r10, RxType.RX2_COMPLETABLE), new RxCallableUpsertMethodBinderProvider(r10, RxType.RX3_SINGLE), new RxCallableUpsertMethodBinderProvider(r10, RxType.RX3_MAYBE), new RxCompletableUpsertMethodBinderProvider(r10, RxType.RX3_COMPLETABLE)});
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RxCallableUpsertMethodBinderProvider(Context r5, RxType r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "rxType");
        this.context = r5;
        this.rxType = r10;
    }

    public static final /* synthetic */ RxType access$getRxType$p(RxCallableUpsertMethodBinderProvider r5) {
        return r5.rxType;
    }

    private final boolean matchesRxType(XType r5) {
        return Intrinsics.areEqual(r5.getRawType().getTypeName(), this.rxType.getClassName());
    }

    public XType extractTypeArg(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        return (XType) CollectionsKt.first(r5.getTypeArguments());
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.room.solver.shortcut.binderprovider.InsertOrUpsertMethodBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        if (r5.getTypeArguments().size() == 1) goto L5;
    L7:
        return false;
    L5:
        if (matchesRxType(r5) == false) goto L7;
        return true;
    }

    @Override // androidx.room.solver.shortcut.binderprovider.InsertOrUpsertMethodBinderProvider
    public InsertOrUpsertMethodBinder provide(XType r5, List<ShortcutQueryParameter> r10) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        XType r11 = extractTypeArg(r5);
        InsertOrUpsertMethodAdapter r12 = this.context.getTypeAdapterStore().findUpsertAdapter(r11, r10);
        return CallableUpsertMethodBinder.Companion.createUpsertBinder(r11, r12, new AnonymousClass1(this));
    }
}
