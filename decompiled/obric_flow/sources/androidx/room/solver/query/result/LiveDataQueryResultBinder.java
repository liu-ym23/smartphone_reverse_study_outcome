package androidx.room.solver.query.result;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.c;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/room/solver/query/result/LiveDataQueryResultBinder;", "Landroidx/room/solver/query/result/BaseObservableQueryResultBinder;", "Landroidx/room/compiler/processing/XType;", "typeArg", "", "", "tableNames", "Landroidx/room/solver/query/result/QueryResultAdapter;", "adapter", "<init>", "(Landroidx/room/compiler/processing/XType;Ljava/util/Set;Landroidx/room/solver/query/result/QueryResultAdapter;)V", "roomSQLiteQueryVar", "", "canReleaseQuery", "Lcom/squareup/javapoet/m;", "dbField", "inTransaction", "Landroidx/room/solver/CodeGenScope;", "scope", "", "convertAndReturn", "(Ljava/lang/String;ZLcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;)V", "Landroidx/room/compiler/processing/XType;", "getTypeArg", "()Landroidx/room/compiler/processing/XType;", "Ljava/util/Set;", "getTableNames", "()Ljava/util/Set;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LiveDataQueryResultBinder extends BaseObservableQueryResultBinder {
    private final Set<String> tableNames;
    private final XType typeArg;

    public LiveDataQueryResultBinder(XType r5, Set<String> r10, QueryResultAdapter r11) {
        Intrinsics.checkNotNullParameter(r5, "typeArg");
        Intrinsics.checkNotNullParameter(r10, "tableNames");
        super(r11);
        this.typeArg = r5;
        this.tableNames = r10;
    }

    @Override // androidx.room.solver.query.result.QueryResultBinder
    public void convertAndReturn(final String r10, boolean r11, final m r12, final boolean r13, final CodeGenScope r14) {
        Intrinsics.checkNotNullParameter(r10, "roomSQLiteQueryVar");
        Intrinsics.checkNotNullParameter(r12, "dbField");
        Intrinsics.checkNotNullParameter(r14, "scope");
        y r5 = Javapoet_extKt.CallableTypeSpecBuilder(this.typeArg.getTypeName(), new LiveDataQueryResultBinder$convertAndReturn$callableImpl$1(this, r10, r12, r13, r14));
        if (r11 == false) goto L5;
        r5.b(createFinalizeMethod(r10));
    L5:
        z r15 = r5.e();
        g r16 = r14.builder();
        String r17 = CollectionsKt.q(this.tableNames, ",", null, null, 0, null, LiveDataQueryResultBinder$convertAndReturn$1$tableNamesList$1.INSTANCE, 30);
        String r18 = Javapoet_extKt.getN();
        String r19 = Javapoet_extKt.getT();
        String r20 = Javapoet_extKt.getL();
        String r21 = Javapoet_extKt.getL();
        String r22 = Javapoet_extKt.getL();
        StringBuilder r110 = a.y("return ", r18, ".getInvalidationTracker().createLiveData(new ", r19, "{");
        a.C(r110, r20, "}, ", r21, ", ");
        String r111 = j0.q(r110, r22, ")");
        c r23 = Javapoet_extKt.getArrayTypeName(Reflection.getOrCreateKotlinClass(String.class));
        if (r13 == false) goto L8;
        String r112 = "true";
    L9:
        r16.c(r111, new Object[]{r12, r23, r17, r112, r15});
        return;
    L8:
        r112 = "false";
        goto L9
    }

    public final Set<String> getTableNames() {
        return this.tableNames;
    }

    public final XType getTypeArg() {
        return this.typeArg;
    }
}
