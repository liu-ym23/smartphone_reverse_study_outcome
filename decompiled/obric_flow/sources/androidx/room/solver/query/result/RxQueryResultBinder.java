package androidx.room.solver.query.result;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.RxType;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/room/solver/query/result/RxQueryResultBinder;", "Landroidx/room/solver/query/result/BaseObservableQueryResultBinder;", "Landroidx/room/solver/RxType;", "rxType", "Landroidx/room/compiler/processing/XType;", "typeArg", "", "", "queryTableNames", "Landroidx/room/solver/query/result/QueryResultAdapter;", "adapter", "<init>", "(Landroidx/room/solver/RxType;Landroidx/room/compiler/processing/XType;Ljava/util/Set;Landroidx/room/solver/query/result/QueryResultAdapter;)V", "roomSQLiteQueryVar", "", "canReleaseQuery", "Lcom/squareup/javapoet/m;", "dbField", "inTransaction", "Landroidx/room/solver/CodeGenScope;", "scope", "", "convertAndReturn", "(Ljava/lang/String;ZLcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;)V", "Landroidx/room/solver/RxType;", "Landroidx/room/compiler/processing/XType;", "getTypeArg", "()Landroidx/room/compiler/processing/XType;", "Ljava/util/Set;", "getQueryTableNames", "()Ljava/util/Set;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RxQueryResultBinder extends BaseObservableQueryResultBinder {
    private final Set<String> queryTableNames;
    private final RxType rxType;
    private final XType typeArg;

    public RxQueryResultBinder(RxType r5, XType r10, Set<String> r11, QueryResultAdapter r12) {
        Intrinsics.checkNotNullParameter(r5, "rxType");
        Intrinsics.checkNotNullParameter(r10, "typeArg");
        Intrinsics.checkNotNullParameter(r11, "queryTableNames");
        super(r12);
        this.rxType = r5;
        this.typeArg = r10;
        this.queryTableNames = r11;
    }

    @Override // androidx.room.solver.query.result.QueryResultBinder
    public void convertAndReturn(final String r18, boolean r19, final m r20, final boolean r21, final CodeGenScope r22) {
        Intrinsics.checkNotNullParameter(r18, "roomSQLiteQueryVar");
        Intrinsics.checkNotNullParameter(r20, "dbField");
        Intrinsics.checkNotNullParameter(r22, "scope");
        y r5 = Javapoet_extKt.CallableTypeSpecBuilder(this.typeArg.getTypeName(), new RxQueryResultBinder$convertAndReturn$callableImpl$1(this, r18, r20, r21, r22));
        if (r19 == false) goto L5;
        r5.b(createFinalizeMethod(r18));
    L5:
        z r10 = r5.e();
        g r11 = r22.builder();
        String r12 = CollectionsKt.q(this.queryTableNames, ",", null, null, 0, null, RxQueryResultBinder$convertAndReturn$1$tableNamesList$1.INSTANCE, 30);
        String r13 = Javapoet_extKt.getT();
        String r14 = Javapoet_extKt.getN();
        String r15 = Javapoet_extKt.getN();
        String r16 = Javapoet_extKt.getL();
        String r17 = Javapoet_extKt.getT();
        String r110 = Javapoet_extKt.getL();
        String r111 = Javapoet_extKt.getL();
        StringBuilder r23 = a.y("return ", r13, ".", r14, "(");
        a.C(r23, r15, ", ", r16, ", new ");
        a.C(r23, r17, "{", r110, "}, ");
        String r112 = j0.q(r23, r111, ")");
        e r24 = this.rxType.getVersion().getRxRoomClassName();
        String r25 = this.rxType.getFactoryMethodName();
        if (r21 == false) goto L9;
        String r26 = "true";
    L8:
        String r27 = r26;
        r11.c(r112, new Object[]{r24, r25, r20, r27, Javapoet_extKt.getArrayTypeName(Reflection.getOrCreateKotlinClass(String.class)), r12, r10});
        return;
    L9:
        r26 = "false";
        goto L8
    }

    public final Set<String> getQueryTableNames() {
        return this.queryTableNames;
    }

    public final XType getTypeArg() {
        return this.typeArg;
    }
}
