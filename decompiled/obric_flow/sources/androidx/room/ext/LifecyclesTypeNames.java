package androidx.room.ext;

import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/room/ext/LifecyclesTypeNames;", "", "<init>", "()V", "Lcom/squareup/javapoet/e;", "LIVE_DATA", "Lcom/squareup/javapoet/e;", "getLIVE_DATA", "()Lcom/squareup/javapoet/e;", "COMPUTABLE_LIVE_DATA", "getCOMPUTABLE_LIVE_DATA", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LifecyclesTypeNames {
    private static final e COMPUTABLE_LIVE_DATA = null;
    public static final LifecyclesTypeNames INSTANCE = null;
    private static final e LIVE_DATA = null;

    static {
        INSTANCE = new LifecyclesTypeNames();
        LIVE_DATA = e.o(Package_extKt.getLIFECYCLE_PACKAGE(), "LiveData", new String[0]);
        COMPUTABLE_LIVE_DATA = e.o(Package_extKt.getLIFECYCLE_PACKAGE(), "ComputableLiveData", new String[0]);
    }

    private LifecyclesTypeNames() {
    }

    public final e getCOMPUTABLE_LIVE_DATA() {
        return COMPUTABLE_LIVE_DATA;
    }

    public final e getLIVE_DATA() {
        return LIVE_DATA;
    }
}
