package androidx.room.solver.query.result;

import ai.j0;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.AndroidTypeNames;
import androidx.room.ext.CommonTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Landroidx/room/solver/query/result/MultiTypedPagingSourceQueryResultBinder;", "Landroidx/room/solver/query/result/QueryResultBinder;", "Landroidx/room/solver/query/result/ListQueryResultAdapter;", "listAdapter", "", "", "tableNames", "Lcom/squareup/javapoet/e;", "className", "<init>", "(Landroidx/room/solver/query/result/ListQueryResultAdapter;Ljava/util/Set;Lcom/squareup/javapoet/e;)V", "Landroidx/room/solver/CodeGenScope;", "scope", "Lcom/squareup/javapoet/t;", "createConvertRowsMethod", "(Landroidx/room/solver/CodeGenScope;)Lcom/squareup/javapoet/t;", "roomSQLiteQueryVar", "", "canReleaseQuery", "Lcom/squareup/javapoet/m;", "dbField", "inTransaction", "", "convertAndReturn", "(Ljava/lang/String;ZLcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;)V", "Landroidx/room/solver/query/result/ListQueryResultAdapter;", "Ljava/util/Set;", "Lcom/squareup/javapoet/x;", "itemTypeName", "Lcom/squareup/javapoet/x;", "Lcom/squareup/javapoet/v;", "pagingSourceTypeName", "Lcom/squareup/javapoet/v;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MultiTypedPagingSourceQueryResultBinder extends QueryResultBinder {
    private final x itemTypeName;
    private final ListQueryResultAdapter listAdapter;
    private final v pagingSourceTypeName;
    private final Set<String> tableNames;

    public MultiTypedPagingSourceQueryResultBinder(ListQueryResultAdapter r5, Set<String> r10, e r11) {
        Intrinsics.checkNotNullParameter(r10, "tableNames");
        Intrinsics.checkNotNullParameter(r11, "className");
        super(r5);
        this.listAdapter = r5;
        this.tableNames = r10;
        if (r5 == null) goto L12;
        List<RowAdapter> r12 = r5.getRowAdapters();
        if (r12 == null) goto L12;
        RowAdapter r13 = (RowAdapter) CollectionsKt.firstOrNull(r12);
        if (r13 == null) goto L12;
        XType r14 = r13.getOut();
        if (r14 == null) goto L12;
        x r15 = r14.getTypeName();
        if (r15 == null) goto L12;
    L13:
        this.itemTypeName = r15;
        this.pagingSourceTypeName = v.n(r11, new x[]{r15});
        return;
    L12:
        r15 = x.f15028m;
        goto L13
    }

    private final t createConvertRowsMethod(CodeGenScope r5) {
        s r10 = t.e("convertRows");
        r10.h();
        r10.l(new Modifier[]{Modifier.PROTECTED});
        r10.v(v.n(CommonTypeNames.INSTANCE.getLIST(), new x[]{this.itemTypeName}));
        u r11 = u.a(XTypeNameKt.toJavaPoet(AndroidTypeNames.INSTANCE.getCURSOR()), "cursor", new Modifier[0]).n();
        r10.m(r11);
        String r12 = r5.getTmpVar("_result");
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
        g r15 = r14.builder();
        String r16 = CollectionsKt.q(this.tableNames, ", ", null, null, 0, null, MultiTypedPagingSourceQueryResultBinder$convertAndReturn$1$tableNamesList$1.INSTANCE, 30);
        y r17 = z.a(Javapoet_extKt.getL() + ", " + Javapoet_extKt.getN() + ", " + Javapoet_extKt.getL(), new Object[]{r10, r12, r16});
        r17.d(this.pagingSourceTypeName);
        r17.b(createConvertRowsMethod(r14));
        r15.c(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r17.e()});
    }
}
