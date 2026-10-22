package androidx.room.ext;

import androidx.room.compiler.codegen.XClassName;
import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Landroidx/room/ext/AndroidTypeNames;", "", "<init>", "()V", "Landroidx/room/compiler/codegen/XClassName;", "CURSOR", "Landroidx/room/compiler/codegen/XClassName;", "getCURSOR", "()Landroidx/room/compiler/codegen/XClassName;", "Lcom/squareup/javapoet/e;", "BUILD", "Lcom/squareup/javapoet/e;", "getBUILD", "()Lcom/squareup/javapoet/e;", "CANCELLATION_SIGNAL", "getCANCELLATION_SIGNAL", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidTypeNames {
    private static final e BUILD = null;
    private static final e CANCELLATION_SIGNAL = null;
    private static final XClassName CURSOR = null;
    public static final AndroidTypeNames INSTANCE = null;

    static {
        INSTANCE = new AndroidTypeNames();
        CURSOR = XClassName.Companion.get("android.database", new String[]{"Cursor"});
        BUILD = e.o("android.os", "Build", new String[0]);
        CANCELLATION_SIGNAL = e.o("android.os", "CancellationSignal", new String[0]);
    }

    private AndroidTypeNames() {
    }

    public final e getBUILD() {
        return BUILD;
    }

    public final e getCANCELLATION_SIGNAL() {
        return CANCELLATION_SIGNAL;
    }

    public final XClassName getCURSOR() {
        return CURSOR;
    }
}
