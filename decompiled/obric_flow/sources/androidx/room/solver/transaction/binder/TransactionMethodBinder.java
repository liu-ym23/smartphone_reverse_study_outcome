package androidx.room.solver.transaction.binder;

import androidx.room.compiler.processing.XType;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.transaction.result.TransactionMethodAdapter;
import com.squareup.javapoet.e;
import com.squareup.javapoet.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JE\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/room/solver/transaction/binder/TransactionMethodBinder;", "", "Landroidx/room/solver/transaction/result/TransactionMethodAdapter;", "adapter", "<init>", "(Landroidx/room/solver/transaction/result/TransactionMethodAdapter;)V", "Landroidx/room/compiler/processing/XType;", "returnType", "", "", "parameterNames", "Lcom/squareup/javapoet/e;", "daoName", "daoImplName", "Lcom/squareup/javapoet/m;", "dbField", "Landroidx/room/solver/CodeGenScope;", "scope", "", "executeAndReturn", "(Landroidx/room/compiler/processing/XType;Ljava/util/List;Lcom/squareup/javapoet/e;Lcom/squareup/javapoet/e;Lcom/squareup/javapoet/m;Landroidx/room/solver/CodeGenScope;)V", "Landroidx/room/solver/transaction/result/TransactionMethodAdapter;", "getAdapter", "()Landroidx/room/solver/transaction/result/TransactionMethodAdapter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class TransactionMethodBinder {
    private final TransactionMethodAdapter adapter;

    public TransactionMethodBinder(TransactionMethodAdapter r5) {
        Intrinsics.checkNotNullParameter(r5, "adapter");
        this.adapter = r5;
    }

    public abstract void executeAndReturn(XType r5, List<String> r10, e r11, e r12, m r13, CodeGenScope r14);

    public final TransactionMethodAdapter getAdapter() {
        return this.adapter;
    }
}
