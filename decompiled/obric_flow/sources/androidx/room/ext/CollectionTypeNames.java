package androidx.room.ext;

import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Landroidx/room/ext/CollectionTypeNames;", "", "<init>", "()V", "Lcom/squareup/javapoet/e;", "ARRAY_MAP", "Lcom/squareup/javapoet/e;", "getARRAY_MAP", "()Lcom/squareup/javapoet/e;", "LONG_SPARSE_ARRAY", "getLONG_SPARSE_ARRAY", "INT_SPARSE_ARRAY", "getINT_SPARSE_ARRAY", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CollectionTypeNames {
    private static final e ARRAY_MAP = null;
    public static final CollectionTypeNames INSTANCE = null;
    private static final e INT_SPARSE_ARRAY = null;
    private static final e LONG_SPARSE_ARRAY = null;

    static {
        INSTANCE = new CollectionTypeNames();
        ARRAY_MAP = e.o(Package_extKt.getCOLLECTION_PACKAGE(), "ArrayMap", new String[0]);
        LONG_SPARSE_ARRAY = e.o(Package_extKt.getCOLLECTION_PACKAGE(), "LongSparseArray", new String[0]);
        INT_SPARSE_ARRAY = e.o(Package_extKt.getCOLLECTION_PACKAGE(), "SparseArrayCompat", new String[0]);
    }

    private CollectionTypeNames() {
    }

    public final e getARRAY_MAP() {
        return ARRAY_MAP;
    }

    public final e getINT_SPARSE_ARRAY() {
        return INT_SPARSE_ARRAY;
    }

    public final e getLONG_SPARSE_ARRAY() {
        return LONG_SPARSE_ARRAY;
    }
}
