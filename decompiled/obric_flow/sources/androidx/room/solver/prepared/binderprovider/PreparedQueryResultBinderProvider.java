package androidx.room.solver.prepared.binderprovider;

import androidx.room.compiler.processing.XType;
import androidx.room.parser.ParsedQuery;
import androidx.room.solver.prepared.binder.PreparedQueryResultBinder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/room/solver/prepared/binderprovider/PreparedQueryResultBinderProvider;", "", "matches", "", "declared", "Landroidx/room/compiler/processing/XType;", "provide", "Landroidx/room/solver/prepared/binder/PreparedQueryResultBinder;", "query", "Landroidx/room/parser/ParsedQuery;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PreparedQueryResultBinderProvider {
    boolean matches(XType r5);

    PreparedQueryResultBinder provide(XType r5, ParsedQuery r10);
}
