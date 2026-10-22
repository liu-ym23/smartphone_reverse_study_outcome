package androidx.room.solver.query.result;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.AndroidTypeNames;
import androidx.room.ext.CommonTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.m;
import com.squareup.javapoet.s;
import com.squareup.javapoet.t;
import com.squareup.javapoet.u;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import com.squareup.javapoet.y;
import com.squareup.javapoet.z;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Landroidx/room/solver/query/result/PositionalDataSourceQueryResultBinder;", "Landroidx/room/solver/query/result/QueryResultBinder;", "Landroidx/room/solver/query/result/ListQueryResultAdapter;", "listAdapter", "", "", "tableNames", "<init>", "(Landroidx/room/solver/query/result/ListQueryResultAdapter;Ljava/util/Set;)V", "Landroidx/room/solver/CodeGenScope;", "scope", "Lcom/squareup/javapoet/t;", "createConvertRowsMethod", "(Landroidx/room/solver/CodeGenScope;)Lcom/squareup/javapoet/t;", "roomSQLiteQueryVar", "", "canReleaseQuery", "Lcom/squareup/javapoet/m;", "dbField", "inTransaction", "", "convertAndReturn", "(Ljava/lang/String;ZLcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;)V", "Landroidx/room/solver/query/result/ListQueryResultAdapter;", "getListAdapter", "()Landroidx/room/solver/query/result/ListQueryResultAdapter;", "Ljava/util/Set;", "getTableNames", "()Ljava/util/Set;", "Lcom/squareup/javapoet/x;", "itemTypeName", "Lcom/squareup/javapoet/x;", "getItemTypeName", "()Lcom/squareup/javapoet/x;", "Lcom/squareup/javapoet/v;", "typeName", "Lcom/squareup/javapoet/v;", "getTypeName", "()Lcom/squareup/javapoet/v;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PositionalDataSourceQueryResultBinder extends QueryResultBinder {
    private final x itemTypeName;
    private final ListQueryResultAdapter listAdapter;
    private final Set<String> tableNames;
    private final v typeName;

    public PositionalDataSourceQueryResultBinder(ListQueryResultAdapter r5, Set<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "tableNames");
        super(r5);
        this.listAdapter = r5;
        this.tableNames = r10;
        if (r5 == null) goto L12;
        List<RowAdapter> r11 = r5.getRowAdapters();
        if (r11 == null) goto L12;
        RowAdapter r12 = (RowAdapter) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L12;
        XType r13 = r12.getOut();
        if (r13 == null) goto L12;
        x r14 = r13.getTypeName();
        if (r14 == null) goto L12;
    L13:
        this.itemTypeName = r14;
        this.typeName = v.n(RoomTypeNames.INSTANCE.getLIMIT_OFFSET_DATA_SOURCE(), new x[]{r14});
        return;
    L12:
        r14 = x.f15028m;
        goto L13
    }

    private final t createConvertRowsMethod(CodeGenScope r5) {
        s r10 = t.e("convertRows");
        r10.h();
        r10.l(new Modifier[]{Modifier.PROTECTED});
        r10.v(v.n(CommonTypeNames.INSTANCE.getLIST(), new x[]{this.itemTypeName}));
        u r11 = u.a(XTypeNameKt.toJavaPoet(AndroidTypeNames.INSTANCE.getCURSOR()), "cursor", new Modifier[0]).n();
        r10.m(r11);
        String r12 = r5.getTmpVar("_res");
        CodeGenScope r13 = r5.fork();
        ListQueryResultAdapter r14 = this.listAdapter;
        if (r14 == null) goto L5;
        r14.convert(r12, r11.f15017a, r13);
    L5:
        r10.j(r13.builder().f());
        r10.o(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r12});
        return r10.r();
    }

    @Override // androidx.room.solver.query.result.QueryResultBinder
    public void convertAndReturn(String r10, boolean r11, m r12, boolean r13, CodeGenScope r14) {
        Intrinsics.checkNotNullParameter(r10, "roomSQLiteQueryVar");
        Intrinsics.checkNotNullParameter(r12, "dbField");
        Intrinsics.checkNotNullParameter(r14, "scope");
        String r15 = CollectionsKt.q(this.tableNames, "", null, null, 0, null, PositionalDataSourceQueryResultBinder$convertAndReturn$tableNamesList$1.INSTANCE, 30);
        String r5 = Javapoet_extKt.getN();
        String r16 = Javapoet_extKt.getL();
        String r17 = Javapoet_extKt.getL();
        String r18 = Javapoet_extKt.getL();
        String r19 = Javapoet_extKt.getL();
        y r20 = z.a(a.u(androidx.room.jarjarred.org.antlr.runtime.a.y(r5, ", ", r16, ", ", r17), ", ", r18, " ", r19), new Object[]{r12, r10, Boolean.valueOf(r13), Boolean.TRUE, r15});
        r20.f(this.typeName);
        r20.b(createConvertRowsMethod(r14));
        z r21 = r20.e();
        r14.builder().c(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r21});
    }

    public final x getItemTypeName() {
        return this.itemTypeName;
    }

    public final ListQueryResultAdapter getListAdapter() {
        return this.listAdapter;
    }

    public final Set<String> getTableNames() {
        return this.tableNames;
    }

    public final v getTypeName() {
        return this.typeName;
    }
}
