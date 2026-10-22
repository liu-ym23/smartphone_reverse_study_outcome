package androidx.room.solver.query.result;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.ext.AndroidTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.i;
import com.squareup.javapoet.m;
import com.squareup.javapoet.s;
import com.squareup.javapoet.t;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\t\u0010\nJ?\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/room/solver/query/result/BaseObservableQueryResultBinder;", "Landroidx/room/solver/query/result/QueryResultBinder;", "Landroidx/room/solver/query/result/QueryResultAdapter;", "adapter", "<init>", "(Landroidx/room/solver/query/result/QueryResultAdapter;)V", "", "roomSQLiteQueryVar", "Lcom/squareup/javapoet/t;", "createFinalizeMethod", "(Ljava/lang/String;)Lcom/squareup/javapoet/t;", "Lcom/squareup/javapoet/s;", "builder", "Lcom/squareup/javapoet/m;", "dbField", "", "inTransaction", "Landroidx/room/solver/CodeGenScope;", "scope", "cancellationSignalVar", "", "createRunQueryAndReturnStatements", "(Lcom/squareup/javapoet/s;Ljava/lang/String;Lcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;Ljava/lang/String;)V", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class BaseObservableQueryResultBinder extends QueryResultBinder {
    public BaseObservableQueryResultBinder(QueryResultAdapter r5) {
        super(r5);
    }

    public final t createFinalizeMethod(String r5) {
        Intrinsics.checkNotNullParameter(r5, "roomSQLiteQueryVar");
        s r10 = t.e("finalize");
        r10.l(new Modifier[]{Modifier.PROTECTED});
        r10.h();
        r10.o(j0.j(Javapoet_extKt.getL(), ".release()"), new Object[]{r5});
        return r10.r();
    }

    public final void createRunQueryAndReturnStatements(s r17, String r18, m r19, boolean r20, CodeGenScope r21, String r22) {
        Intrinsics.checkNotNullParameter(r17, "builder");
        Intrinsics.checkNotNullParameter(r18, "roomSQLiteQueryVar");
        Intrinsics.checkNotNullParameter(r19, "dbField");
        Intrinsics.checkNotNullParameter(r21, "scope");
        Intrinsics.checkNotNullParameter(r22, "cancellationSignalVar");
        if (r20 == false) goto L6;
        TransactionWrapper r5 = TransactionWrapperKt.transactionWrapper(r17, r19);
    L5:
        TransactionWrapper r10 = r5;
        QueryResultAdapter r11 = getAdapter();
        if (r11 == null) goto L12;
        boolean r12 = true;
        if (r11.shouldCopyCursor() != true) goto L12;
    L13:
        String r13 = r21.getTmpVar("_result");
        String r14 = r21.getTmpVar("_cursor");
        if (r10 == null) goto L16;
        r10.beginTransactionWithControlFlow();
    L16:
        String r15 = Javapoet_extKt.getT();
        String r16 = Javapoet_extKt.getL();
        String r23 = Javapoet_extKt.getT();
        String r110 = Javapoet_extKt.getN();
        String r111 = Javapoet_extKt.getL();
        String r112 = Javapoet_extKt.getL();
        String r113 = Javapoet_extKt.getL();
        StringBuilder r24 = a.y("final ", r15, " ", r16, " = ");
        a.C(r24, r23, ".query(", r110, ", ");
        a.C(r24, r111, ", ", r112, ", ");
        String r114 = j0.q(r24, r113, ")");
        e r25 = XTypeNameKt.toJavaPoet(AndroidTypeNames.INSTANCE.getCURSOR());
        e r26 = RoomTypeNames.INSTANCE.getDB_UTIL();
        if (r12 == false) goto L20;
        String r27 = "true";
    L21:
        r17.o(r114, new Object[]{r25, r14, r26, r19, r18, r27, r22});
        g r28 = r17.e;
        r28.e("try", new Object[0]);
        CodeGenScope r29 = r21.fork();
        QueryResultAdapter r30 = getAdapter();
        if (r30 == null) goto L24;
        r30.convert(r13, r14, r29);
    L24:
        g r31 = r29.builder();
        r31.getClass();
        r28.a(new i(r31));
        if (r10 == null) goto L27;
        r10.commitTransaction();
    L27:
        r17.o(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r13});
        r28.h("finally", new Object[0]);
        r17.o(j0.j(Javapoet_extKt.getL(), ".close()"), new Object[]{r14});
        r17.s();
        if (r10 == null) goto L31;
        r10.endTransactionWithControlFlow();
        return;
    L31:
        return;
    L20:
        r27 = "false";
    L12:
        r12 = false;
        goto L13
    L6:
        r5 = null;
        goto L5
    }
}
