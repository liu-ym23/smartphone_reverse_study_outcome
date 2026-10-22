package androidx.room.solver.shortcut.binder;

import androidx.room.solver.CodeGenScope;
import androidx.room.solver.shortcut.result.InsertOrUpsertMethodAdapter;
import androidx.room.vo.ShortcutQueryParameter;
import com.squareup.javapoet.m;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005JM\u0010\u0012\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b0\t2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", "", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter;", "adapter", "<init>", "(Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter;)V", "", "Landroidx/room/vo/ShortcutQueryParameter;", "parameters", "", "", "Lkotlin/Pair;", "Lcom/squareup/javapoet/m;", "adapters", "dbField", "Landroidx/room/solver/CodeGenScope;", "scope", "", "convertAndReturn", "(Ljava/util/List;Ljava/util/Map;Lcom/squareup/javapoet/m;Landroidx/room/solver/CodeGenScope;)V", "Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter;", "getAdapter", "()Landroidx/room/solver/shortcut/result/InsertOrUpsertMethodAdapter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class InsertOrUpsertMethodBinder {
    private final InsertOrUpsertMethodAdapter adapter;

    public InsertOrUpsertMethodBinder(InsertOrUpsertMethodAdapter r5) {
        this.adapter = r5;
    }

    public abstract void convertAndReturn(List<ShortcutQueryParameter> r5, Map<String, ? extends Pair<m, ? extends Object>> r10, m r11, CodeGenScope r12);

    public final InsertOrUpsertMethodAdapter getAdapter() {
        return this.adapter;
    }
}
