package androidx.room.solver.binderprovider;

import androidx.room.compiler.processing.XRawType;
import androidx.room.compiler.processing.XType;
import androidx.room.processor.Context;
import androidx.room.solver.ObservableQueryResultBinderProvider;
import androidx.room.solver.QueryResultBinderProvider;
import androidx.room.solver.RxType;
import androidx.room.solver.query.result.QueryResultAdapter;
import androidx.room.solver.query.result.QueryResultBinder;
import androidx.room.solver.query.result.RxQueryResultBinder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0014J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0014J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0010H\u0002R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/room/solver/binderprovider/RxQueryResultBinderProvider;", "Landroidx/room/solver/ObservableQueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "rxType", "Landroidx/room/solver/RxType;", "(Landroidx/room/processor/Context;Landroidx/room/solver/RxType;)V", "rawRxType", "Landroidx/room/compiler/processing/XRawType;", "getRawRxType", "()Landroidx/room/compiler/processing/XRawType;", "rawRxType$delegate", "Lkotlin/Lazy;", "create", "Landroidx/room/solver/query/result/QueryResultBinder;", "typeArg", "Landroidx/room/compiler/processing/XType;", "resultAdapter", "Landroidx/room/solver/query/result/QueryResultAdapter;", "tableNames", "", "", "extractTypeArg", "declared", "matches", "", "matchesRxType", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RxQueryResultBinderProvider extends ObservableQueryResultBinderProvider {
    public static final Companion Companion = null;
    private final Lazy rawRxType$delegate;
    private final RxType rxType;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/room/solver/binderprovider/RxQueryResultBinderProvider$Companion;", "", "()V", "getAll", "", "Landroidx/room/solver/QueryResultBinderProvider;", "context", "Landroidx/room/processor/Context;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final List<QueryResultBinderProvider> getAll(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            List r10 = CollectionsKt.listOf(new RxType[]{RxType.RX2_FLOWABLE, RxType.RX2_OBSERVABLE, RxType.RX3_FLOWABLE, RxType.RX3_OBSERVABLE});
            ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
            Iterator r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            RxType r13 = (RxType) r12.next();
            r11.add(QueryResultBinderProviderWithRequiredArtifactKt.requireArtifact(new RxQueryResultBinderProvider(r5, r13, null), r5, r13.getVersion().getRxRoomClassName(), r13.getVersion().getMissingArtifactMessage()));
            goto L4
        L6:
            return r11;
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ RxQueryResultBinderProvider(Context r5, RxType r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    public static final /* synthetic */ RxType access$getRxType$p(RxQueryResultBinderProvider r5) {
        return r5.rxType;
    }

    private final XRawType getRawRxType() {
        return (XRawType) this.rawRxType$delegate.getValue();
    }

    private final boolean matchesRxType(XType r5) {
        if (getRawRxType() != null) goto L6;
        return false;
    L6:
        XRawType r10 = r5.getRawType();
        XRawType r11 = getRawRxType();
        Intrinsics.checkNotNull(r11);
        return r10.isAssignableFrom(r11);
    }

    @Override // androidx.room.solver.ObservableQueryResultBinderProvider
    public QueryResultBinder create(XType r5, QueryResultAdapter r10, Set<String> r11) {
        Intrinsics.checkNotNullParameter(r5, "typeArg");
        Intrinsics.checkNotNullParameter(r11, "tableNames");
        return new RxQueryResultBinder(this.rxType, r5, r11, r10);
    }

    @Override // androidx.room.solver.ObservableQueryResultBinderProvider
    public XType extractTypeArg(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        return (XType) CollectionsKt.first(r5.getTypeArguments());
    }

    @Override // androidx.room.solver.QueryResultBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        if (r5.getTypeArguments().size() == 1) goto L5;
    L7:
        return false;
    L5:
        if (matchesRxType(r5) == false) goto L7;
        return true;
    }

    private RxQueryResultBinderProvider(final Context r5, RxType r10) {
        super(r5);
        this.rxType = r10;
        this.rawRxType$delegate = LazyKt.lazy(new RxQueryResultBinderProvider$rawRxType$2(r5, this));
    }
}
