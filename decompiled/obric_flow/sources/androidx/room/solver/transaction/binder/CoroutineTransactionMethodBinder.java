package androidx.room.solver.transaction.binder;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.KotlinTypeNames;
import androidx.room.ext.RoomTypeNames;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.transaction.result.TransactionMethodAdapter;
import com.squareup.javapoet.b0;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.i;
import com.squareup.javapoet.m;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJE\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/room/solver/transaction/binder/CoroutineTransactionMethodBinder;", "Landroidx/room/solver/transaction/binder/TransactionMethodBinder;", "Landroidx/room/solver/transaction/result/TransactionMethodAdapter;", "adapter", "", "continuationParamName", "", "useLambdaSyntax", "<init>", "(Landroidx/room/solver/transaction/result/TransactionMethodAdapter;Ljava/lang/String;Z)V", "Landroidx/room/compiler/processing/XType;", "returnType", "", "parameterNames", "Lcom/squareup/javapoet/e;", "daoName", "daoImplName", "Lcom/squareup/javapoet/m;", "dbField", "Landroidx/room/solver/CodeGenScope;", "scope", "", "executeAndReturn", "(Landroidx/room/compiler/processing/XType;Ljava/util/List;Lcom/squareup/javapoet/e;Lcom/squareup/javapoet/e;Lcom/squareup/javapoet/m;Landroidx/room/solver/CodeGenScope;)V", "Ljava/lang/String;", "Z", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CoroutineTransactionMethodBinder extends TransactionMethodBinder {
    private final String continuationParamName;
    private final boolean useLambdaSyntax;

    public CoroutineTransactionMethodBinder(TransactionMethodAdapter r5, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "adapter");
        Intrinsics.checkNotNullParameter(r10, "continuationParamName");
        super(r5);
        this.continuationParamName = r10;
        this.useLambdaSyntax = r11;
    }

    @Override // androidx.room.solver.transaction.binder.TransactionMethodBinder
    public void executeAndReturn(XType r18, List<String> r19, e r20, e r21, m r22, CodeGenScope r23) {
        Intrinsics.checkNotNullParameter(r18, "returnType");
        Intrinsics.checkNotNullParameter(r19, "parameterNames");
        Intrinsics.checkNotNullParameter(r20, "daoName");
        Intrinsics.checkNotNullParameter(r21, "daoImplName");
        Intrinsics.checkNotNullParameter(r22, "dbField");
        Intrinsics.checkNotNullParameter(r23, "scope");
        final CodeGenScope r5 = r23.fork();
        TransactionMethodAdapter.createDelegateToSuperCode$default(getAdapter(), r18, CollectionsKt.plus(r19, "__cont"), r20, r21, null, !this.useLambdaSyntax, r5, 16, null);
        if (this.useLambdaSyntax == false) goto L5;
        String r10 = a.p("(", Javapoet_extKt.getL(), ") -> ", Javapoet_extKt.getL());
        g r11 = r5.builder();
        r11.getClass();
        Object r12 = i.d(r10, new Object[]{"__cont", new i(r11)});
    L6:
        r23.builder().c(a.u(a.y("return ", Javapoet_extKt.getT(), ".withTransaction(", Javapoet_extKt.getN(), ", "), Javapoet_extKt.getL(), ", ", Javapoet_extKt.getN(), ")"), new Object[]{RoomTypeNames.INSTANCE.getROOM_DB_KT(), r22, r12, this.continuationParamName});
        return;
    L5:
        r12 = Javapoet_extKt.Function1TypeSpecBuilder(v.n(KotlinTypeNames.INSTANCE.getCONTINUATION(), new x[]{b0.p(r18.getTypeName())}), "__cont", e.B, new CoroutineTransactionMethodBinder$executeAndReturn$functionImpl$1(r5)).e();
        goto L6
    }
}
