package androidx.room.solver.query.result;

import ai.j0;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.PagingTypeNames;
import androidx.room.solver.CodeGenScope;
import com.squareup.javapoet.g;
import com.squareup.javapoet.m;
import com.squareup.javapoet.s;
import com.squareup.javapoet.t;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import com.squareup.javapoet.y;
import com.squareup.javapoet.z;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/room/solver/query/result/DataSourceFactoryQueryResultBinder;", "Landroidx/room/solver/query/result/QueryResultBinder;", "Landroidx/room/solver/query/result/PositionalDataSourceQueryResultBinder;", "positionalDataSourceQueryResultBinder", "<init>", "(Landroidx/room/solver/query/result/PositionalDataSourceQueryResultBinder;)V", "", "roomSQLiteQueryVar", "Lcom/squareup/javapoet/m;", "dbField", "", "inTransaction", "Landroidx/room/solver/CodeGenScope;", "scope", "Lcom/squareup/javapoet/t;", "createCreateMethod", "(Ljava/lang/String;Lcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;)Lcom/squareup/javapoet/t;", "canReleaseQuery", "", "convertAndReturn", "(Ljava/lang/String;ZLcom/squareup/javapoet/m;ZLandroidx/room/solver/CodeGenScope;)V", "Landroidx/room/solver/query/result/PositionalDataSourceQueryResultBinder;", "getPositionalDataSourceQueryResultBinder", "()Landroidx/room/solver/query/result/PositionalDataSourceQueryResultBinder;", "Lcom/squareup/javapoet/x;", "typeName", "Lcom/squareup/javapoet/x;", "getTypeName", "()Lcom/squareup/javapoet/x;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DataSourceFactoryQueryResultBinder extends QueryResultBinder {
    private final PositionalDataSourceQueryResultBinder positionalDataSourceQueryResultBinder;
    private final x typeName;

    public DataSourceFactoryQueryResultBinder(PositionalDataSourceQueryResultBinder r5) {
        Intrinsics.checkNotNullParameter(r5, "positionalDataSourceQueryResultBinder");
        super(r5.getListAdapter());
        this.positionalDataSourceQueryResultBinder = r5;
        this.typeName = r5.getItemTypeName();
    }

    private final t createCreateMethod(String r10, m r11, boolean r12, CodeGenScope r13) {
        s r5 = t.e("create");
        r5.h();
        r5.l(new Modifier[]{Modifier.PUBLIC});
        r5.v(this.positionalDataSourceQueryResultBinder.getTypeName());
        CodeGenScope r14 = r13.fork();
        this.positionalDataSourceQueryResultBinder.convertAndReturn(r10, true, r11, r12, r14);
        r5.j(r14.builder().f());
        return r5.r();
    }

    @Override // androidx.room.solver.query.result.QueryResultBinder
    public void convertAndReturn(String r10, boolean r11, m r12, boolean r13, CodeGenScope r14) {
        Intrinsics.checkNotNullParameter(r10, "roomSQLiteQueryVar");
        Intrinsics.checkNotNullParameter(r12, "dbField");
        Intrinsics.checkNotNullParameter(r14, "scope");
        g r15 = r14.builder();
        y r5 = z.a("", new Object[0]);
        r5.f(v.n(PagingTypeNames.INSTANCE.getDATA_SOURCE_FACTORY(), new x[]{Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(Integer.class)), this.typeName}));
        r5.b(createCreateMethod(r10, r12, r13, r14));
        r15.c(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r5.e()});
    }

    public final PositionalDataSourceQueryResultBinder getPositionalDataSourceQueryResultBinder() {
        return this.positionalDataSourceQueryResultBinder;
    }

    public final x getTypeName() {
        return this.typeName;
    }
}
