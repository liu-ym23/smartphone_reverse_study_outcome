package androidx.room.solver.transaction.binder;

import ai.j0;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.Xtype_extKt;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.transaction.result.TransactionMethodAdapter;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.i;
import com.squareup.javapoet.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JE\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/room/solver/transaction/binder/InstantTransactionMethodBinder;", "Landroidx/room/solver/transaction/binder/TransactionMethodBinder;", "Landroidx/room/solver/transaction/result/TransactionMethodAdapter;", "adapter", "<init>", "(Landroidx/room/solver/transaction/result/TransactionMethodAdapter;)V", "Landroidx/room/compiler/processing/XType;", "returnType", "", "", "parameterNames", "Lcom/squareup/javapoet/e;", "daoName", "daoImplName", "Lcom/squareup/javapoet/m;", "dbField", "Landroidx/room/solver/CodeGenScope;", "scope", "", "executeAndReturn", "(Landroidx/room/compiler/processing/XType;Ljava/util/List;Lcom/squareup/javapoet/e;Lcom/squareup/javapoet/e;Lcom/squareup/javapoet/m;Landroidx/room/solver/CodeGenScope;)V", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InstantTransactionMethodBinder extends TransactionMethodBinder {
    public InstantTransactionMethodBinder(TransactionMethodAdapter r5) {
        Intrinsics.checkNotNullParameter(r5, "adapter");
        super(r5);
    }

    @Override // androidx.room.solver.transaction.binder.TransactionMethodBinder
    public void executeAndReturn(XType r17, List<String> r18, e r19, e r20, m r21, CodeGenScope r22) {
        Intrinsics.checkNotNullParameter(r17, "returnType");
        Intrinsics.checkNotNullParameter(r18, "parameterNames");
        Intrinsics.checkNotNullParameter(r19, "daoName");
        Intrinsics.checkNotNullParameter(r20, "daoImplName");
        Intrinsics.checkNotNullParameter(r21, "dbField");
        Intrinsics.checkNotNullParameter(r22, "scope");
        g r5 = r22.builder();
        r5.c(j0.j(Javapoet_extKt.getN(), ".beginTransaction()"), new Object[]{r21});
        r5.e("try", new Object[0]);
        boolean r14 = Xtype_extKt.isNotVoid(r17);
        if (r14 == false) goto L6;
        String r10 = r22.getTmpVar("_result");
    L5:
        String r15 = r10;
        CodeGenScope r11 = r22.fork();
        TransactionMethodAdapter.createDelegateToSuperCode$default(getAdapter(), r17, r18, r19, r20, r15, false, r11, 32, null);
        g r12 = r11.builder();
        r12.getClass();
        r5.c("$L", new Object[]{new i(r12)});
        r5.c(j0.j(Javapoet_extKt.getN(), ".setTransactionSuccessful()"), new Object[]{r21});
        if (r14 == false) goto L10;
        r5.c(j0.C("return ", Javapoet_extKt.getN()), new Object[]{r15});
    L10:
        r5.h("finally", new Object[0]);
        r5.c(j0.j(Javapoet_extKt.getN(), ".endTransaction()"), new Object[]{r21});
        r5.g();
        return;
    L6:
        r10 = null;
        goto L5
    }
}
