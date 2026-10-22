package androidx.room.solver.binderprovider;

import androidx.room.processor.Context;
import androidx.room.solver.QueryResultBinderProvider;
import com.squareup.javapoet.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a)\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/room/solver/QueryResultBinderProvider;", "Landroidx/room/processor/Context;", "context", "Lcom/squareup/javapoet/x;", "requiredType", "", "missingArtifactErrorMsg", "requireArtifact", "(Landroidx/room/solver/QueryResultBinderProvider;Landroidx/room/processor/Context;Lcom/squareup/javapoet/x;Ljava/lang/String;)Landroidx/room/solver/QueryResultBinderProvider;", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class QueryResultBinderProviderWithRequiredArtifactKt {
    public static final QueryResultBinderProvider requireArtifact(QueryResultBinderProvider r5, Context r10, x r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "requiredType");
        Intrinsics.checkNotNullParameter(r12, "missingArtifactErrorMsg");
        return new QueryResultBinderProviderWithRequiredArtifact(r10, r11, r12, r5);
    }
}
