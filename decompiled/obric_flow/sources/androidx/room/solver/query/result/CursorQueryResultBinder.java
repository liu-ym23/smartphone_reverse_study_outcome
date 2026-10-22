package androidx.room.solver.query.result;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.ext.AndroidTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.g;
import com.squareup.javapoet.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/room/solver/query/result/CursorQueryResultBinder;", "Landroidx/room/solver/query/result/QueryResultBinder;", "<init>", "()V", "", "roomSQLiteQueryVar", "", "canReleaseQuery", "Lcom/squareup/javapoet/m;", "dbField", "inTransaction", "Landroidx/room/solver/CodeGenScope;", "scope", "", "convertAndReturn", "(Ljava/lang/String;ZLcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;)V", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CursorQueryResultBinder extends QueryResultBinder {
    public static final Companion Companion = null;
    private static final CursorQueryResultBinder$Companion$NO_OP_RESULT_ADAPTER$1 NO_OP_RESULT_ADAPTER = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/room/solver/query/result/CursorQueryResultBinder$Companion;", "", "()V", "NO_OP_RESULT_ADAPTER", "androidx/room/solver/query/result/CursorQueryResultBinder$Companion$NO_OP_RESULT_ADAPTER$1", "Landroidx/room/solver/query/result/CursorQueryResultBinder$Companion$NO_OP_RESULT_ADAPTER$1;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.room.solver.query.result.CursorQueryResultBinder$Companion$NO_OP_RESULT_ADAPTER$1] */
    static {
        Companion = new Companion(null);
        final List r5 = CollectionsKt.emptyList();
        NO_OP_RESULT_ADAPTER = new CursorQueryResultBinder$Companion$NO_OP_RESULT_ADAPTER$1(r5);
    }

    public CursorQueryResultBinder() {
        super(NO_OP_RESULT_ADAPTER);
    }

    @Override // androidx.room.solver.query.result.QueryResultBinder
    public void convertAndReturn(String r10, boolean r11, m r12, boolean r13, CodeGenScope r14) {
        Intrinsics.checkNotNullParameter(r10, "roomSQLiteQueryVar");
        Intrinsics.checkNotNullParameter(r12, "dbField");
        Intrinsics.checkNotNullParameter(r14, "scope");
        g r15 = r14.builder();
        if (r13 == false) goto L5;
        TransactionWrapper r16 = TransactionWrapperKt.transactionWrapper(r15, r12);
    L6:
        if (r16 == null) goto L8;
        r16.beginTransactionWithControlFlow();
    L8:
        String r17 = r14.getTmpVar("_tmpResult");
        String r18 = Javapoet_extKt.getT();
        String r5 = Javapoet_extKt.getL();
        String r19 = Javapoet_extKt.getN();
        String r20 = Javapoet_extKt.getL();
        r15.c(a.u(a.y("final ", r18, " ", r5, " = "), r19, ".query(", r20, ")"), new Object[]{XTypeNameKt.toJavaPoet(AndroidTypeNames.INSTANCE.getCURSOR()), r17, r12, r10});
        if (r16 == null) goto L11;
        r16.commitTransaction();
    L11:
        r15.c(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r17});
        if (r16 == null) goto L15;
        r16.endTransactionWithControlFlow();
        return;
    L15:
        return;
    L5:
        r16 = null;
        goto L6
    }
}
