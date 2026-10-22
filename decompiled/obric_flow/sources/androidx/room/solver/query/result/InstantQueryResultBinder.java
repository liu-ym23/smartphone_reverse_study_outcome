package androidx.room.solver.query.result;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.ext.AndroidTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.solver.CodeGenScope;
import androidx.room.writer.DaoWriter;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/room/solver/query/result/InstantQueryResultBinder;", "Landroidx/room/solver/query/result/QueryResultBinder;", "Landroidx/room/solver/query/result/QueryResultAdapter;", "adapter", "<init>", "(Landroidx/room/solver/query/result/QueryResultAdapter;)V", "", "roomSQLiteQueryVar", "", "canReleaseQuery", "Lcom/squareup/javapoet/m;", "dbField", "inTransaction", "Landroidx/room/solver/CodeGenScope;", "scope", "", "convertAndReturn", "(Ljava/lang/String;ZLcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;)V", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InstantQueryResultBinder extends QueryResultBinder {
    public InstantQueryResultBinder(QueryResultAdapter r5) {
        super(r5);
    }

    @Override // androidx.room.solver.query.result.QueryResultBinder
    public void convertAndReturn(String r17, boolean r18, m r19, boolean r20, CodeGenScope r21) {
        Intrinsics.checkNotNullParameter(r17, "roomSQLiteQueryVar");
        Intrinsics.checkNotNullParameter(r19, "dbField");
        Intrinsics.checkNotNullParameter(r21, "scope");
        r21.builder().c(j0.j(Javapoet_extKt.getN(), ".assertNotSuspendingTransaction()"), new Object[]{DaoWriter.Companion.getDbField()});
        if (r20 == false) goto L6;
        TransactionWrapper r5 = TransactionWrapperKt.transactionWrapper(r21.builder(), r19);
    L5:
        TransactionWrapper r10 = r5;
        if (r10 == null) goto L9;
        r10.beginTransactionWithControlFlow();
    L9:
        g r11 = r21.builder();
        QueryResultAdapter r12 = getAdapter();
        if (r12 == null) goto L14;
        boolean r13 = true;
        if (r12.shouldCopyCursor() != true) goto L14;
    L15:
        String r14 = r21.getTmpVar("_result");
        String r15 = r21.getTmpVar("_cursor");
        String r16 = Javapoet_extKt.getT();
        String r22 = Javapoet_extKt.getL();
        String r23 = Javapoet_extKt.getT();
        String r24 = Javapoet_extKt.getN();
        String r25 = Javapoet_extKt.getL();
        String r110 = Javapoet_extKt.getL();
        String r111 = Javapoet_extKt.getL();
        StringBuilder r26 = a.y("final ", r16, " ", r22, " = ");
        a.C(r26, r23, ".query(", r24, ", ");
        a.C(r26, r25, ", ", r110, ", ");
        String r27 = j0.q(r26, r111, ")");
        e r28 = XTypeNameKt.toJavaPoet(AndroidTypeNames.INSTANCE.getCURSOR());
        e r29 = RoomTypeNames.INSTANCE.getDB_UTIL();
        if (r13 == false) goto L19;
        String r30 = "true";
    L20:
        r11.c(r27, new Object[]{r28, r15, r29, r19, r17, r30, "null"});
        r11.e("try", new Object[0]);
        QueryResultAdapter r31 = getAdapter();
        if (r31 == null) goto L23;
        r31.convert(r14, r15, r21);
    L23:
        if (r10 == null) goto L25;
        r10.commitTransaction();
    L25:
        r11.c(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r14});
        r11.h("finally", new Object[0]);
        r11.c(j0.j(Javapoet_extKt.getL(), ".close()"), new Object[]{r15});
        if (r18 == false) goto L28;
        r11.c(j0.j(Javapoet_extKt.getL(), ".release()"), new Object[]{r17});
    L28:
        r11.g();
        if (r10 == null) goto L32;
        r10.endTransactionWithControlFlow();
        return;
    L32:
        return;
    L19:
        r30 = "false";
    L14:
        r13 = false;
        goto L15
    L6:
        r5 = null;
        goto L5
    }
}
