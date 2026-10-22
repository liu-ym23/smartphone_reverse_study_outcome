package androidx.room.solver.prepared.binder;

import androidx.room.solver.CodeGenScope;
import androidx.room.solver.prepared.result.PreparedQueryResultAdapter;
import com.squareup.javapoet.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005JB\u0010\u0010\u001a\u00020\u000f2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/room/solver/prepared/binder/PreparedQueryResultBinder;", "", "Landroidx/room/solver/prepared/result/PreparedQueryResultAdapter;", "adapter", "<init>", "(Landroidx/room/solver/prepared/result/PreparedQueryResultAdapter;)V", "Lkotlin/Function1;", "Landroidx/room/solver/CodeGenScope;", "", "Lkotlin/ExtensionFunctionType;", "prepareQueryStmtBlock", "preparedStmtField", "Lcom/squareup/javapoet/m;", "dbField", "scope", "", "executeAndReturn", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lcom/squareup/javapoet/m;Landroidx/room/solver/CodeGenScope;)V", "Landroidx/room/solver/prepared/result/PreparedQueryResultAdapter;", "getAdapter", "()Landroidx/room/solver/prepared/result/PreparedQueryResultAdapter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class PreparedQueryResultBinder {
    private final PreparedQueryResultAdapter adapter;

    public PreparedQueryResultBinder(PreparedQueryResultAdapter r5) {
        this.adapter = r5;
    }

    public abstract void executeAndReturn(Function1<? super CodeGenScope, String> r5, String r10, m r11, CodeGenScope r12);

    public final PreparedQueryResultAdapter getAdapter() {
        return this.adapter;
    }
}
