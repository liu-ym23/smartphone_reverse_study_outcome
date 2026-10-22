package androidx.room.ext;

import ai.j0;
import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/room/ext/RoomPagingTypeNames;", "", "<init>", "()V", "Lcom/squareup/javapoet/e;", "LIMIT_OFFSET_PAGING_SOURCE", "Lcom/squareup/javapoet/e;", "getLIMIT_OFFSET_PAGING_SOURCE", "()Lcom/squareup/javapoet/e;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RoomPagingTypeNames {
    public static final RoomPagingTypeNames INSTANCE = null;
    private static final e LIMIT_OFFSET_PAGING_SOURCE = null;

    static {
        INSTANCE = new RoomPagingTypeNames();
        LIMIT_OFFSET_PAGING_SOURCE = e.o(j0.j(Package_extKt.getROOM_PACKAGE(), ".paging"), "LimitOffsetPagingSource", new String[0]);
    }

    private RoomPagingTypeNames() {
    }

    public final e getLIMIT_OFFSET_PAGING_SOURCE() {
        return LIMIT_OFFSET_PAGING_SOURCE;
    }
}
