package androidx.room.ext;

import ai.j0;
import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/room/ext/PagingTypeNames;", "", "<init>", "()V", "Lcom/squareup/javapoet/e;", "DATA_SOURCE", "Lcom/squareup/javapoet/e;", "getDATA_SOURCE", "()Lcom/squareup/javapoet/e;", "POSITIONAL_DATA_SOURCE", "getPOSITIONAL_DATA_SOURCE", "DATA_SOURCE_FACTORY", "getDATA_SOURCE_FACTORY", "PAGING_SOURCE", "getPAGING_SOURCE", "LISTENABLE_FUTURE_PAGING_SOURCE", "getLISTENABLE_FUTURE_PAGING_SOURCE", "RX2_PAGING_SOURCE", "getRX2_PAGING_SOURCE", "RX3_PAGING_SOURCE", "getRX3_PAGING_SOURCE", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PagingTypeNames {
    private static final e DATA_SOURCE = null;
    private static final e DATA_SOURCE_FACTORY = null;
    public static final PagingTypeNames INSTANCE = null;
    private static final e LISTENABLE_FUTURE_PAGING_SOURCE = null;
    private static final e PAGING_SOURCE = null;
    private static final e POSITIONAL_DATA_SOURCE = null;
    private static final e RX2_PAGING_SOURCE = null;
    private static final e RX3_PAGING_SOURCE = null;

    static {
        INSTANCE = new PagingTypeNames();
        DATA_SOURCE = e.o(Package_extKt.getPAGING_PACKAGE(), "DataSource", new String[0]);
        POSITIONAL_DATA_SOURCE = e.o(Package_extKt.getPAGING_PACKAGE(), "PositionalDataSource", new String[0]);
        DATA_SOURCE_FACTORY = e.o(Package_extKt.getPAGING_PACKAGE(), "DataSource", new String[]{"Factory"});
        PAGING_SOURCE = e.o(Package_extKt.getPAGING_PACKAGE(), "PagingSource", new String[0]);
        LISTENABLE_FUTURE_PAGING_SOURCE = e.o(Package_extKt.getPAGING_PACKAGE(), "ListenableFuturePagingSource", new String[0]);
        RX2_PAGING_SOURCE = e.o(j0.j(Package_extKt.getPAGING_PACKAGE(), ".rxjava2"), "RxPagingSource", new String[0]);
        RX3_PAGING_SOURCE = e.o(j0.j(Package_extKt.getPAGING_PACKAGE(), ".rxjava3"), "RxPagingSource", new String[0]);
    }

    private PagingTypeNames() {
    }

    public final e getDATA_SOURCE() {
        return DATA_SOURCE;
    }

    public final e getDATA_SOURCE_FACTORY() {
        return DATA_SOURCE_FACTORY;
    }

    public final e getLISTENABLE_FUTURE_PAGING_SOURCE() {
        return LISTENABLE_FUTURE_PAGING_SOURCE;
    }

    public final e getPAGING_SOURCE() {
        return PAGING_SOURCE;
    }

    public final e getPOSITIONAL_DATA_SOURCE() {
        return POSITIONAL_DATA_SOURCE;
    }

    public final e getRX2_PAGING_SOURCE() {
        return RX2_PAGING_SOURCE;
    }

    public final e getRX3_PAGING_SOURCE() {
        return RX3_PAGING_SOURCE;
    }
}
