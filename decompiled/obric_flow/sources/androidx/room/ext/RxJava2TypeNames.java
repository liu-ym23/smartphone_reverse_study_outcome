package androidx.room.ext;

import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001f\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u001f\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u001f\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/room/ext/RxJava2TypeNames;", "", "<init>", "()V", "Lcom/squareup/javapoet/e;", "kotlin.jvm.PlatformType", "FLOWABLE", "Lcom/squareup/javapoet/e;", "getFLOWABLE", "()Lcom/squareup/javapoet/e;", "OBSERVABLE", "getOBSERVABLE", "MAYBE", "getMAYBE", "SINGLE", "getSINGLE", "COMPLETABLE", "getCOMPLETABLE", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RxJava2TypeNames {
    private static final e COMPLETABLE = null;
    private static final e FLOWABLE = null;
    public static final RxJava2TypeNames INSTANCE = null;
    private static final e MAYBE = null;
    private static final e OBSERVABLE = null;
    private static final e SINGLE = null;

    static {
        INSTANCE = new RxJava2TypeNames();
        FLOWABLE = e.o("io.reactivex", "Flowable", new String[0]);
        OBSERVABLE = e.o("io.reactivex", "Observable", new String[0]);
        MAYBE = e.o("io.reactivex", "Maybe", new String[0]);
        SINGLE = e.o("io.reactivex", "Single", new String[0]);
        COMPLETABLE = e.o("io.reactivex", "Completable", new String[0]);
    }

    private RxJava2TypeNames() {
    }

    public final e getCOMPLETABLE() {
        return COMPLETABLE;
    }

    public final e getFLOWABLE() {
        return FLOWABLE;
    }

    public final e getMAYBE() {
        return MAYBE;
    }

    public final e getOBSERVABLE() {
        return OBSERVABLE;
    }

    public final e getSINGLE() {
        return SINGLE;
    }
}
