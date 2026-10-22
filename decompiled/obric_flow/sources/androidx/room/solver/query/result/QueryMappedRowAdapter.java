package androidx.room.solver.query.result;

import androidx.room.compiler.processing.XType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/room/solver/query/result/QueryMappedRowAdapter;", "Landroidx/room/solver/query/result/RowAdapter;", "out", "Landroidx/room/compiler/processing/XType;", "(Landroidx/room/compiler/processing/XType;)V", "mapping", "Landroidx/room/solver/query/result/QueryMappedRowAdapter$Mapping;", "getMapping", "()Landroidx/room/solver/query/result/QueryMappedRowAdapter$Mapping;", "Mapping", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class QueryMappedRowAdapter extends RowAdapter {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/room/solver/query/result/QueryMappedRowAdapter$Mapping;", "", "()V", "usedColumns", "", "", "getUsedColumns", "()Ljava/util/List;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Mapping {
        public Mapping() {
        }

        public abstract List<String> getUsedColumns();
    }

    public QueryMappedRowAdapter(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "out");
        super(r5);
    }

    public abstract Mapping getMapping();
}
