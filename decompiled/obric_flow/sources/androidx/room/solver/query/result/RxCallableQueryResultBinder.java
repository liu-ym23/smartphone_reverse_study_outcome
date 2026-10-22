package androidx.room.solver.query.result;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.AndroidTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.RxType;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.i;
import com.squareup.javapoet.m;
import com.squareup.javapoet.s;
import com.squareup.javapoet.t;
import com.squareup.javapoet.y;
import com.squareup.javapoet.z;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ3\u0010\u0014\u001a\u00020\u0013*\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u001a\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Landroidx/room/solver/query/result/RxCallableQueryResultBinder;", "Landroidx/room/solver/query/result/QueryResultBinder;", "Landroidx/room/solver/RxType;", "rxType", "Landroidx/room/compiler/processing/XType;", "typeArg", "Landroidx/room/solver/query/result/QueryResultAdapter;", "adapter", "<init>", "(Landroidx/room/solver/RxType;Landroidx/room/compiler/processing/XType;Landroidx/room/solver/query/result/QueryResultAdapter;)V", "Lcom/squareup/javapoet/s;", "", "roomSQLiteQueryVar", "Lcom/squareup/javapoet/m;", "dbField", "", "inTransaction", "Landroidx/room/solver/CodeGenScope;", "scope", "", "fillInCallMethod", "(Lcom/squareup/javapoet/s;Ljava/lang/String;Lcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;)V", "Lcom/squareup/javapoet/t;", "createFinalizeMethod", "(Ljava/lang/String;)Lcom/squareup/javapoet/t;", "canReleaseQuery", "convertAndReturn", "(Ljava/lang/String;ZLcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;)V", "Landroidx/room/solver/RxType;", "Landroidx/room/compiler/processing/XType;", "getTypeArg", "()Landroidx/room/compiler/processing/XType;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RxCallableQueryResultBinder extends QueryResultBinder {
    private final RxType rxType;
    private final XType typeArg;

    public RxCallableQueryResultBinder(RxType r5, XType r10, QueryResultAdapter r11) {
        Intrinsics.checkNotNullParameter(r5, "rxType");
        Intrinsics.checkNotNullParameter(r10, "typeArg");
        super(r11);
        this.rxType = r5;
        this.typeArg = r10;
    }

    public static final /* synthetic */ void access$fillInCallMethod(RxCallableQueryResultBinder r5, s r10, String r11, m r12, boolean r13, CodeGenScope r14) {
        r5.fillInCallMethod(r10, r11, r12, r13, r14);
    }

    private final t createFinalizeMethod(String r5) {
        s r10 = t.e("finalize");
        r10.l(new Modifier[]{Modifier.PROTECTED});
        r10.h();
        r10.o(j0.j(Javapoet_extKt.getL(), ".release()"), new Object[]{r5});
        return r10.r();
    }

    private final void fillInCallMethod(s r18, String r19, m r20, boolean r21, CodeGenScope r22) {
        CodeGenScope r5 = r22.fork();
        if (r21 == false) goto L6;
        TransactionWrapper r10 = TransactionWrapperKt.transactionWrapper(r18, r20);
    L5:
        TransactionWrapper r11 = r10;
        if (r11 == null) goto L9;
        r11.beginTransactionWithControlFlow();
    L9:
        QueryResultAdapter r12 = getAdapter();
        if (r12 == null) goto L14;
        boolean r13 = true;
        if (r12.shouldCopyCursor() != true) goto L14;
    L15:
        String r14 = r22.getTmpVar("_result");
        String r15 = r22.getTmpVar("_cursor");
        String r16 = Javapoet_extKt.getT();
        String r17 = Javapoet_extKt.getL();
        String r23 = Javapoet_extKt.getT();
        String r24 = Javapoet_extKt.getN();
        String r110 = Javapoet_extKt.getL();
        String r111 = Javapoet_extKt.getL();
        String r112 = Javapoet_extKt.getL();
        StringBuilder r25 = a.y("final ", r16, " ", r17, " = ");
        a.C(r25, r23, ".query(", r24, ", ");
        a.C(r25, r110, ", ", r111, ", ");
        String r113 = j0.q(r25, r112, ")");
        e r26 = XTypeNameKt.toJavaPoet(AndroidTypeNames.INSTANCE.getCURSOR());
        e r27 = RoomTypeNames.INSTANCE.getDB_UTIL();
        if (r13 == false) goto L19;
        String r28 = "true";
    L20:
        r18.o(r113, new Object[]{r26, r15, r27, r20, r19, r28, "null"});
        g r29 = r18.e;
        r29.e("try", new Object[0]);
        QueryResultAdapter r30 = getAdapter();
        if (r30 == null) goto L23;
        r30.convert(r14, r15, r5);
    L23:
        g r31 = r5.builder();
        r31.getClass();
        r29.a(new i(r31));
        if (this.rxType.getCanBeNull() == true) goto L26;
        r29.e(j0.k("if(", Javapoet_extKt.getL(), " == null)"), new Object[]{r14});
        String r32 = Javapoet_extKt.getT();
        String r33 = Javapoet_extKt.getS();
        String r34 = Javapoet_extKt.getL();
        r18.o(j0.q(a.y("throw new ", r32, "(", r33, " + "), r34, ".getSql())"), new Object[]{this.rxType.getVersion().getEmptyResultExceptionClassName(), "Query returned empty result set: ", r19});
        r18.s();
    L26:
        if (r11 == null) goto L28;
        r11.commitTransaction();
    L28:
        r18.o(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r14});
        r29.h("finally", new Object[0]);
        r18.o(j0.j(Javapoet_extKt.getL(), ".close()"), new Object[]{r15});
        r18.s();
        if (r11 == null) goto L32;
        r11.endTransactionWithControlFlow();
        return;
    L32:
        return;
    L19:
        r28 = "false";
    L14:
        r13 = false;
        goto L15
    L6:
        r10 = null;
        goto L5
    }

    @Override // androidx.room.solver.query.result.QueryResultBinder
    public void convertAndReturn(final String r10, boolean r11, final m r12, final boolean r13, final CodeGenScope r14) {
        Intrinsics.checkNotNullParameter(r10, "roomSQLiteQueryVar");
        Intrinsics.checkNotNullParameter(r12, "dbField");
        Intrinsics.checkNotNullParameter(r14, "scope");
        y r15 = Javapoet_extKt.CallableTypeSpecBuilder(this.typeArg.getTypeName(), new RxCallableQueryResultBinder$convertAndReturn$callable$1(this, r10, r12, r13, r14));
        if (r11 == false) goto L5;
        r15.b(createFinalizeMethod(r10));
    L5:
        z r16 = r15.e();
        g r17 = r14.builder();
        if (this.rxType.isSingle() == false) goto L8;
        r17.c(j0.l("return ", Javapoet_extKt.getT(), ".createSingle(", Javapoet_extKt.getL(), ")"), new Object[]{this.rxType.getVersion().getRxRoomClassName(), r16});
        return;
    L8:
        r17.c(j0.l("return ", Javapoet_extKt.getT(), ".fromCallable(", Javapoet_extKt.getL(), ")"), new Object[]{this.rxType.getClassName(), r16});
    }

    public final XType getTypeArg() {
        return this.typeArg;
    }
}
