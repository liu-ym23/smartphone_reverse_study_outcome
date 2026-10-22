package androidx.room.solver.query.result;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.AndroidTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomGuavaTypeNames;
import androidx.room.ext.RoomTypeNames;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.m;
import com.squareup.javapoet.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/room/solver/query/result/GuavaListenableFutureQueryResultBinder;", "Landroidx/room/solver/query/result/BaseObservableQueryResultBinder;", "Landroidx/room/compiler/processing/XType;", "typeArg", "Landroidx/room/solver/query/result/QueryResultAdapter;", "adapter", "<init>", "(Landroidx/room/compiler/processing/XType;Landroidx/room/solver/query/result/QueryResultAdapter;)V", "", "roomSQLiteQueryVar", "", "canReleaseQuery", "Lcom/squareup/javapoet/m;", "dbField", "inTransaction", "Landroidx/room/solver/CodeGenScope;", "scope", "", "convertAndReturn", "(Ljava/lang/String;ZLcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;)V", "Landroidx/room/compiler/processing/XType;", "getTypeArg", "()Landroidx/room/compiler/processing/XType;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GuavaListenableFutureQueryResultBinder extends BaseObservableQueryResultBinder {
    private final XType typeArg;

    public GuavaListenableFutureQueryResultBinder(XType r5, QueryResultAdapter r10) {
        Intrinsics.checkNotNullParameter(r5, "typeArg");
        super(r10);
        this.typeArg = r5;
    }

    @Override // androidx.room.solver.query.result.QueryResultBinder
    public void convertAndReturn(final String r16, boolean r17, final m r18, final boolean r19, final CodeGenScope r20) {
        Intrinsics.checkNotNullParameter(r16, "roomSQLiteQueryVar");
        Intrinsics.checkNotNullParameter(r18, "dbField");
        Intrinsics.checkNotNullParameter(r20, "scope");
        final String r10 = r20.getTmpVar("_cancellationSignal");
        g r5 = r20.builder();
        String r11 = Javapoet_extKt.getT();
        String r12 = Javapoet_extKt.getL();
        String r13 = Javapoet_extKt.getT();
        r5.c(j0.q(a.y("final ", r11, " ", r12, " = "), r13, ".createCancellationSignal()"), new Object[]{AndroidTypeNames.INSTANCE.getCANCELLATION_SIGNAL(), r10, RoomTypeNames.INSTANCE.getDB_UTIL()});
        z r14 = Javapoet_extKt.CallableTypeSpecBuilder(this.typeArg.getTypeName(), new GuavaListenableFutureQueryResultBinder$convertAndReturn$callableImpl$1(this, r16, r18, r19, r20, r10)).e();
        g r15 = r20.builder();
        String r21 = Javapoet_extKt.getT();
        String r22 = Javapoet_extKt.getN();
        String r23 = Javapoet_extKt.getL();
        String r24 = Javapoet_extKt.getL();
        String r25 = Javapoet_extKt.getL();
        String r26 = Javapoet_extKt.getL();
        String r110 = Javapoet_extKt.getL();
        StringBuilder r27 = a.y("return ", r21, ".createListenableFuture(", r22, ", ");
        a.C(r27, r23, ", ", r24, ", ");
        a.C(r27, r25, ", ", r26, ", ");
        String r111 = j0.q(r27, r110, ")");
        e r28 = RoomGuavaTypeNames.INSTANCE.getGUAVA_ROOM();
        if (r19 == false) goto L6;
        String r29 = "true";
    L5:
        String r30 = r29;
        r15.c(r111, new Object[]{r28, r18, r30, r14, r16, Boolean.valueOf(r17), r10});
        return;
    L6:
        r29 = "false";
        goto L5
    }

    public final XType getTypeArg() {
        return this.typeArg;
    }
}
