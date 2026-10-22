package androidx.room.ext;

import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001f\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u001f\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u001f\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\tR\u001f\u0010\u0012\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\tR\u001f\u0010\u0014\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\tR\u001f\u0010\u0016\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0017\u0010\tR\u001f\u0010\u0018\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0019\u0010\t¨\u0006\u001a"}, d2 = {"Landroidx/room/ext/CommonTypeNames;", "", "<init>", "()V", "Lcom/squareup/javapoet/e;", "kotlin.jvm.PlatformType", "ARRAYS", "Lcom/squareup/javapoet/e;", "getARRAYS", "()Lcom/squareup/javapoet/e;", "LIST", "getLIST", "MAP", "getMAP", "SET", "getSET", "STRING", "getSTRING", "INTEGER", "getINTEGER", "OPTIONAL", "getOPTIONAL", "ILLEGAL_ARG_EXCEPTION", "getILLEGAL_ARG_EXCEPTION", "UUID", "getUUID", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CommonTypeNames {
    private static final e ARRAYS = null;
    private static final e ILLEGAL_ARG_EXCEPTION = null;
    public static final CommonTypeNames INSTANCE = null;
    private static final e INTEGER = null;
    private static final e LIST = null;
    private static final e MAP = null;
    private static final e OPTIONAL = null;
    private static final e SET = null;
    private static final e STRING = null;
    private static final e UUID = null;

    static {
        INSTANCE = new CommonTypeNames();
        ARRAYS = e.o("java.util", "Arrays", new String[0]);
        LIST = e.o("java.util", "List", new String[0]);
        MAP = e.o("java.util", "Map", new String[0]);
        SET = e.o("java.util", "Set", new String[0]);
        STRING = e.o("java.lang", "String", new String[0]);
        INTEGER = e.o("java.lang", "Integer", new String[0]);
        OPTIONAL = e.o("java.util", "Optional", new String[0]);
        ILLEGAL_ARG_EXCEPTION = e.o("java.lang", "IllegalArgumentException", new String[0]);
        UUID = e.o("java.util", "UUID", new String[0]);
    }

    private CommonTypeNames() {
    }

    public final e getARRAYS() {
        return ARRAYS;
    }

    public final e getILLEGAL_ARG_EXCEPTION() {
        return ILLEGAL_ARG_EXCEPTION;
    }

    public final e getINTEGER() {
        return INTEGER;
    }

    public final e getLIST() {
        return LIST;
    }

    public final e getMAP() {
        return MAP;
    }

    public final e getOPTIONAL() {
        return OPTIONAL;
    }

    public final e getSET() {
        return SET;
    }

    public final e getSTRING() {
        return STRING;
    }

    public final e getUUID() {
        return UUID;
    }
}
