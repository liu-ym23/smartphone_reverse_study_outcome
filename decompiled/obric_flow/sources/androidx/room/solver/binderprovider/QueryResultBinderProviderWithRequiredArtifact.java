package androidx.room.solver.binderprovider;

import androidx.room.compiler.processing.XType;
import androidx.room.parser.ParsedQuery;
import androidx.room.processor.Context;
import androidx.room.solver.QueryResultBinderProvider;
import androidx.room.solver.TypeAdapterExtras;
import androidx.room.solver.query.result.QueryResultBinder;
import com.squareup.javapoet.x;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010'\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Landroidx/room/solver/binderprovider/QueryResultBinderProviderWithRequiredArtifact;", "Landroidx/room/solver/QueryResultBinderProvider;", "Landroidx/room/processor/Context;", "context", "Lcom/squareup/javapoet/x;", "requiredType", "", "missingArtifactErrorMsg", "delegate", "<init>", "(Landroidx/room/processor/Context;Lcom/squareup/javapoet/x;Ljava/lang/String;Landroidx/room/solver/QueryResultBinderProvider;)V", "Landroidx/room/compiler/processing/XType;", "declared", "Landroidx/room/parser/ParsedQuery;", "query", "Landroidx/room/solver/TypeAdapterExtras;", "extras", "Landroidx/room/solver/query/result/QueryResultBinder;", "provide", "(Landroidx/room/compiler/processing/XType;Landroidx/room/parser/ParsedQuery;Landroidx/room/solver/TypeAdapterExtras;)Landroidx/room/solver/query/result/QueryResultBinder;", "", "matches", "(Landroidx/room/compiler/processing/XType;)Z", "Landroidx/room/processor/Context;", "getContext", "()Landroidx/room/processor/Context;", "Lcom/squareup/javapoet/x;", "getRequiredType", "()Lcom/squareup/javapoet/x;", "Ljava/lang/String;", "getMissingArtifactErrorMsg", "()Ljava/lang/String;", "Landroidx/room/solver/QueryResultBinderProvider;", "getDelegate", "()Landroidx/room/solver/QueryResultBinderProvider;", "hasRequiredArtifact$delegate", "Lkotlin/Lazy;", "getHasRequiredArtifact", "()Z", "hasRequiredArtifact", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class QueryResultBinderProviderWithRequiredArtifact implements QueryResultBinderProvider {
    private final Context context;
    private final QueryResultBinderProvider delegate;
    private final Lazy hasRequiredArtifact$delegate;
    private final String missingArtifactErrorMsg;
    private final x requiredType;

    public QueryResultBinderProviderWithRequiredArtifact(Context r5, x r10, String r11, QueryResultBinderProvider r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "requiredType");
        Intrinsics.checkNotNullParameter(r11, "missingArtifactErrorMsg");
        Intrinsics.checkNotNullParameter(r12, "delegate");
        this.context = r5;
        this.requiredType = r10;
        this.missingArtifactErrorMsg = r11;
        this.delegate = r12;
        this.hasRequiredArtifact$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new QueryResultBinderProviderWithRequiredArtifact$hasRequiredArtifact$2(this));
    }

    private final boolean getHasRequiredArtifact() {
        return ((Boolean) this.hasRequiredArtifact$delegate.getValue()).booleanValue();
    }

    public final Context getContext() {
        return this.context;
    }

    public final QueryResultBinderProvider getDelegate() {
        return this.delegate;
    }

    public final String getMissingArtifactErrorMsg() {
        return this.missingArtifactErrorMsg;
    }

    public final x getRequiredType() {
        return this.requiredType;
    }

    @Override // androidx.room.solver.QueryResultBinderProvider
    public boolean matches(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        boolean r10 = this.delegate.matches(r5);
        if (r10 == true) goto L5;
    L7:
        return r10;
    L5:
        if (getHasRequiredArtifact() == true) goto L7;
        this.context.getLogger().e(this.missingArtifactErrorMsg, new Object[0]);
        goto L7
    }

    @Override // androidx.room.solver.QueryResultBinderProvider
    public QueryResultBinder provide(XType r5, ParsedQuery r10, TypeAdapterExtras r11) {
        Intrinsics.checkNotNullParameter(r5, "declared");
        Intrinsics.checkNotNullParameter(r10, "query");
        Intrinsics.checkNotNullParameter(r11, "extras");
        return this.delegate.provide(r5, r10, r11);
    }
}
