package androidx.room.solver.query.result;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.AndroidTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomCoroutinesTypeNames;
import androidx.room.ext.RoomTypeNames;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.i;
import com.squareup.javapoet.m;
import com.squareup.javapoet.s;
import com.squareup.javapoet.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJG\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u0018\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/room/solver/query/result/CoroutineResultBinder;", "Landroidx/room/solver/query/result/QueryResultBinder;", "Landroidx/room/compiler/processing/XType;", "typeArg", "", "continuationParamName", "Landroidx/room/solver/query/result/QueryResultAdapter;", "adapter", "<init>", "(Landroidx/room/compiler/processing/XType;Ljava/lang/String;Landroidx/room/solver/query/result/QueryResultAdapter;)V", "Lcom/squareup/javapoet/s;", "builder", "roomSQLiteQueryVar", "", "canReleaseQuery", "Lcom/squareup/javapoet/m;", "dbField", "inTransaction", "Landroidx/room/solver/CodeGenScope;", "scope", "cancellationSignalVar", "", "createRunQueryAndReturnStatements", "(Lcom/squareup/javapoet/s;Ljava/lang/String;ZLcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;Ljava/lang/String;)V", "convertAndReturn", "(Ljava/lang/String;ZLcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;)V", "Landroidx/room/compiler/processing/XType;", "getTypeArg", "()Landroidx/room/compiler/processing/XType;", "Ljava/lang/String;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CoroutineResultBinder extends QueryResultBinder {
    private final String continuationParamName;
    private final XType typeArg;

    public CoroutineResultBinder(XType r5, String r10, QueryResultAdapter r11) {
        Intrinsics.checkNotNullParameter(r5, "typeArg");
        Intrinsics.checkNotNullParameter(r10, "continuationParamName");
        super(r11);
        this.typeArg = r5;
        this.continuationParamName = r10;
    }

    public static final /* synthetic */ void access$createRunQueryAndReturnStatements(CoroutineResultBinder r5, s r10, String r11, boolean r12, m r13, boolean r14, CodeGenScope r15, String r16) {
        r5.createRunQueryAndReturnStatements(r10, r11, r12, r13, r14, r15, r16);
    }

    private final void createRunQueryAndReturnStatements(s r17, String r18, boolean r19, m r20, boolean r21, CodeGenScope r22, String r23) {
        if (r21 == false) goto L6;
        TransactionWrapper r5 = TransactionWrapperKt.transactionWrapper(r17, r20);
    L5:
        TransactionWrapper r10 = r5;
        QueryResultAdapter r11 = getAdapter();
        if (r11 == null) goto L12;
        boolean r12 = true;
        if (r11.shouldCopyCursor() != true) goto L12;
    L13:
        String r13 = r22.getTmpVar("_result");
        String r14 = r22.getTmpVar("_cursor");
        if (r10 == null) goto L16;
        r10.beginTransactionWithControlFlow();
    L16:
        String r15 = Javapoet_extKt.getT();
        String r16 = Javapoet_extKt.getL();
        String r24 = Javapoet_extKt.getT();
        String r25 = Javapoet_extKt.getN();
        String r26 = Javapoet_extKt.getL();
        String r110 = Javapoet_extKt.getL();
        String r111 = Javapoet_extKt.getL();
        StringBuilder r27 = a.y("final ", r15, " ", r16, " = ");
        a.C(r27, r24, ".query(", r25, ", ");
        a.C(r27, r26, ", ", r110, ", ");
        String r28 = j0.q(r27, r111, ")");
        e r29 = XTypeNameKt.toJavaPoet(AndroidTypeNames.INSTANCE.getCURSOR());
        e r30 = RoomTypeNames.INSTANCE.getDB_UTIL();
        if (r12 == false) goto L20;
        String r31 = "true";
    L21:
        r17.o(r28, new Object[]{r29, r14, r30, r20, r18, r31, r23});
        g r32 = r17.e;
        r32.e("try", new Object[0]);
        CodeGenScope r33 = r22.fork();
        QueryResultAdapter r34 = getAdapter();
        if (r34 == null) goto L24;
        r34.convert(r13, r14, r33);
    L24:
        g r35 = r33.builder();
        r35.getClass();
        r32.a(new i(r35));
        if (r10 == null) goto L27;
        r10.commitTransaction();
    L27:
        r17.o(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r13});
        r32.h("finally", new Object[0]);
        r17.o(j0.j(Javapoet_extKt.getL(), ".close()"), new Object[]{r14});
        if (r19 == false) goto L30;
        r17.o(j0.j(Javapoet_extKt.getL(), ".release()"), new Object[]{r18});
    L30:
        r17.s();
        if (r10 == null) goto L34;
        r10.endTransactionWithControlFlow();
        return;
    L34:
        return;
    L20:
        r31 = "false";
    L12:
        r12 = false;
        goto L13
    L6:
        r5 = null;
        goto L5
    }

    @Override // androidx.room.solver.query.result.QueryResultBinder
    public void convertAndReturn(final String r15, final boolean r16, final m r17, final boolean r18, final CodeGenScope r19) {
        Intrinsics.checkNotNullParameter(r15, "roomSQLiteQueryVar");
        Intrinsics.checkNotNullParameter(r17, "dbField");
        Intrinsics.checkNotNullParameter(r19, "scope");
        String r10 = r19.getTmpVar("_cancellationSignal");
        g r5 = r19.builder();
        String r11 = Javapoet_extKt.getT();
        String r12 = Javapoet_extKt.getL();
        String r13 = Javapoet_extKt.getT();
        r5.c(j0.q(a.y("final ", r11, " ", r12, " = "), r13, ".createCancellationSignal()"), new Object[]{AndroidTypeNames.INSTANCE.getCANCELLATION_SIGNAL(), r10, RoomTypeNames.INSTANCE.getDB_UTIL()});
        z r14 = Javapoet_extKt.CallableTypeSpecBuilder(this.typeArg.getTypeName(), new CoroutineResultBinder$convertAndReturn$callableImpl$1(this, r15, r16, r17, r18, r19)).e();
        g r20 = r19.builder();
        String r21 = Javapoet_extKt.getT();
        String r22 = Javapoet_extKt.getN();
        String r23 = Javapoet_extKt.getL();
        String r24 = Javapoet_extKt.getL();
        String r25 = Javapoet_extKt.getL();
        String r26 = Javapoet_extKt.getN();
        StringBuilder r27 = a.y("return ", r21, ".execute(", r22, ", ");
        a.C(r27, r23, ", ", r24, ", ");
        String r28 = a.u(r27, r25, ", ", r26, ")");
        e r29 = RoomCoroutinesTypeNames.INSTANCE.getCOROUTINES_ROOM();
        if (r18 == false) goto L6;
        String r30 = "true";
    L5:
        String r31 = r30;
        r20.c(r28, new Object[]{r29, r17, r31, r10, r14, this.continuationParamName});
        return;
    L6:
        r30 = "false";
        goto L5
    }

    public final XType getTypeArg() {
        return this.typeArg;
    }
}
