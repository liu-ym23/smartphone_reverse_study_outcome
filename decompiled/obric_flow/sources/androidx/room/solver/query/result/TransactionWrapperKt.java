package androidx.room.solver.query.result;

import com.squareup.javapoet.g;
import com.squareup.javapoet.m;
import com.squareup.javapoet.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/squareup/javapoet/s;", "Lcom/squareup/javapoet/m;", "dbField", "Landroidx/room/solver/query/result/TransactionWrapper;", "transactionWrapper", "(Lcom/squareup/javapoet/s;Lcom/squareup/javapoet/m;)Landroidx/room/solver/query/result/TransactionWrapper;", "Lcom/squareup/javapoet/g;", "(Lcom/squareup/javapoet/g;Lcom/squareup/javapoet/m;)Landroidx/room/solver/query/result/TransactionWrapper;", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TransactionWrapperKt {
    public static final TransactionWrapper transactionWrapper(final s r5, final m r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "dbField");
        return new AnonymousClass1(r5, r10);
    }

    public static final TransactionWrapper transactionWrapper(final g r5, final m r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "dbField");
        return new AnonymousClass2(r5, r10);
    }
}
