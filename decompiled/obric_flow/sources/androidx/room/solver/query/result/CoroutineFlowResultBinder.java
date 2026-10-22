package androidx.room.solver.query.result;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomCoroutinesTypeNames;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.m;
import com.squareup.javapoet.y;
import com.squareup.javapoet.z;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/room/solver/query/result/CoroutineFlowResultBinder;", "Landroidx/room/solver/query/result/BaseObservableQueryResultBinder;", "Landroidx/room/compiler/processing/XType;", "typeArg", "", "", "tableNames", "Landroidx/room/solver/query/result/QueryResultAdapter;", "adapter", "<init>", "(Landroidx/room/compiler/processing/XType;Ljava/util/Set;Landroidx/room/solver/query/result/QueryResultAdapter;)V", "roomSQLiteQueryVar", "", "canReleaseQuery", "Lcom/squareup/javapoet/m;", "dbField", "inTransaction", "Landroidx/room/solver/CodeGenScope;", "scope", "", "convertAndReturn", "(Ljava/lang/String;ZLcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;)V", "Landroidx/room/compiler/processing/XType;", "getTypeArg", "()Landroidx/room/compiler/processing/XType;", "Ljava/util/Set;", "getTableNames", "()Ljava/util/Set;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CoroutineFlowResultBinder extends BaseObservableQueryResultBinder {
    private final Set<String> tableNames;
    private final XType typeArg;

    public CoroutineFlowResultBinder(XType r5, Set<String> r10, QueryResultAdapter r11) {
        Intrinsics.checkNotNullParameter(r5, "typeArg");
        Intrinsics.checkNotNullParameter(r10, "tableNames");
        super(r11);
        this.typeArg = r5;
        this.tableNames = r10;
    }

    @Override // androidx.room.solver.query.result.QueryResultBinder
    public void convertAndReturn(final String r18, boolean r19, final m r20, final boolean r21, final CodeGenScope r22) {
        Intrinsics.checkNotNullParameter(r18, "roomSQLiteQueryVar");
        Intrinsics.checkNotNullParameter(r20, "dbField");
        Intrinsics.checkNotNullParameter(r22, "scope");
        y r5 = Javapoet_extKt.CallableTypeSpecBuilder(this.typeArg.getTypeName(), new CoroutineFlowResultBinder$convertAndReturn$callableImpl$1(this, r18, r20, r21, r22));
        if (r19 == false) goto L5;
        r5.b(createFinalizeMethod(r18));
    L5:
        z r10 = r5.e();
        g r11 = r22.builder();
        String r12 = CollectionsKt.q(this.tableNames, ",", null, null, 0, null, CoroutineFlowResultBinder$convertAndReturn$1$tableNamesList$1.INSTANCE, 30);
        String r13 = Javapoet_extKt.getT();
        String r14 = Javapoet_extKt.getN();
        String r15 = Javapoet_extKt.getL();
        String r16 = Javapoet_extKt.getT();
        String r17 = Javapoet_extKt.getL();
        String r23 = Javapoet_extKt.getL();
        StringBuilder r24 = a.y("return ", r13, ".createFlow(", r14, ", ");
        a.C(r24, r15, ", new ", r16, "{");
        String r25 = a.u(r24, r17, "}, ", r23, ")");
        e r26 = RoomCoroutinesTypeNames.INSTANCE.getCOROUTINES_ROOM();
        if (r21 == false) goto L9;
        String r27 = "true";
    L8:
        String r28 = r27;
        r11.c(r25, new Object[]{r26, r20, r28, Javapoet_extKt.getArrayTypeName(Reflection.getOrCreateKotlinClass(String.class)), r12, r10});
        return;
    L9:
        r27 = "false";
        goto L8
    }

    public final Set<String> getTableNames() {
        return this.tableNames;
    }

    public final XType getTypeArg() {
        return this.typeArg;
    }
}
