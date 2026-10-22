package androidx.room.ext;

import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/room/ext/GuavaBaseTypeNames;", "", "<init>", "()V", "Lcom/squareup/javapoet/e;", "kotlin.jvm.PlatformType", "OPTIONAL", "Lcom/squareup/javapoet/e;", "getOPTIONAL", "()Lcom/squareup/javapoet/e;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GuavaBaseTypeNames {
    public static final GuavaBaseTypeNames INSTANCE = null;
    private static final e OPTIONAL = null;

    static {
        INSTANCE = new GuavaBaseTypeNames();
        OPTIONAL = e.o("com.google.common.base", "Optional", new String[0]);
    }

    private GuavaBaseTypeNames() {
    }

    public final e getOPTIONAL() {
        return OPTIONAL;
    }
}
