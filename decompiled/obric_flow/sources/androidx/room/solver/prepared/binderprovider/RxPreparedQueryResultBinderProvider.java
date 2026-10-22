package androidx.room.solver.prepared.binderprovider;

import androidx.room.compiler.processing.XType;
import androidx.room.parser.ParsedQuery;
import androidx.room.processor.Context;
import androidx.room.solver.RxType;
import androidx.room.solver.prepared.binder.CallablePreparedQueryResultBinder;
import androidx.room.solver.prepared.binder.PreparedQueryResultBinder;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/room/solver/prepared/binderprovider/RxPreparedQueryResultBinderProvider;", "Landroidx/room/solver/prepared/binderprovider/PreparedQueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "rxType", "Landroidx/room/solver/RxType;", "(Landroidx/room/processor/Context;Landroidx/room/solver/RxType;)V", "getContext", "()Landroidx/room/processor/Context;", "hasRxJavaArtifact", "", "getHasRxJavaArtifact", "()Z", "hasRxJavaArtifact$delegate", "Lkotlin/Lazy;", "extractTypeArg", "Landroidx/room/compiler/processing/XType;", "declared", "matches", "matchesRxType", "provide", "Landroidx/room/solver/prepared/binder/PreparedQueryResultBinder;", "query", "Landroidx/room/parser/ParsedQuery;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class RxPreparedQueryResultBinderProvider implements PreparedQueryResultBinderProvider {
    public static final Companion Companion = null;
    private final Context context;
    private final Lazy hasRxJavaArtifact$delegate;
    private final RxType rxType;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/room/solver/prepared/binderprovider/RxPreparedQueryResultBinderProvider$Companion;", "", "()V", "getAll", "", "Landroidx/room/solver/prepared/binderprovider/RxPreparedQueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final List<RxPreparedQueryResultBinderProvider> getAll(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            return CollectionsKt.listOf(new RxPreparedQueryResultBinderProvider[]{new RxPreparedQueryResultBinderProvider(r10, RxType.RX2_SINGLE), new RxPreparedQueryResultBinderProvider(r10, RxType.RX2_MAYBE), new RxCompletablePreparedQueryResultBinderProvider(r10, RxType.RX2_COMPLETABLE), new RxPreparedQueryResultBinderProvider(r10, RxType.RX3_SINGLE), new RxPreparedQueryResultBinderProvider(r10, RxType.RX3_MAYBE), new RxCompletablePreparedQueryResultBinderProvider(r10, RxType.RX3_COMPLETABLE)});
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RxPreparedQueryResultBinderProvider(Context r5, RxType r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "rxType");
        this.context = r5;
        this.rxType = r10;
        this.hasRxJavaArtifact$delegate = LazyKt.lazy(new RxPreparedQueryResultBinderProvider$hasRxJavaArtifact$2(this));
    }

    public static final /* synthetic */ RxType access$getRxType$p(RxPreparedQueryResultBinderProvider r5) {
        return r5.rxType;
    }

    private final boolean getHasRxJavaArtifact() {
        return ((Boolean) this.hasRxJavaArtifact$delegate.getValue()).booleanValue();
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

    @Override // androidx.room.solver.prepared.binderprovider.PreparedQueryResultBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        if (r5.getTypeArguments().size() == 1) goto L5;
    L7:
        return false;
    L5:
        if (matchesRxType(r5) == false) goto L7;
        return true;
    }

    @Override // androidx.room.solver.prepared.binderprovider.PreparedQueryResultBinderProvider
    public PreparedQueryResultBinder provide(XType r5, ParsedQuery r10) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        Intrinsics.checkNotNullParameter(r10, "query");
        if (getHasRxJavaArtifact() == true) goto L5;
        this.context.getLogger().e(this.rxType.getVersion().getMissingArtifactMessage(), new Object[0]);
    L5:
        XType r11 = extractTypeArg(r5);
        return CallablePreparedQueryResultBinder.Companion.createPreparedBinder(r11, this.context.getTypeAdapterStore().findPreparedQueryResultAdapter(r11, r10), new AnonymousClass1(this));
    }
}
