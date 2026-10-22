package androidx.room.compiler.processing;

import com.squareup.javapoet.e;
import com.squareup.javapoet.x;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001f\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u001f\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u001f\u0010\u0011\u001a\n \u0005*\u0004\u0018\u00010\u00100\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/room/compiler/processing/KnownTypeNames;", "", "<init>", "()V", "Lcom/squareup/javapoet/x;", "kotlin.jvm.PlatformType", "BOXED_VOID", "Lcom/squareup/javapoet/x;", "getBOXED_VOID", "()Lcom/squareup/javapoet/x;", "BOXED_INT", "getBOXED_INT", "BOXED_LONG", "getBOXED_LONG", "BOXED_BYTE", "getBOXED_BYTE", "Lcom/squareup/javapoet/e;", "KOTLIN_UNIT", "Lcom/squareup/javapoet/e;", "getKOTLIN_UNIT", "()Lcom/squareup/javapoet/e;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KnownTypeNames {
    private static final x BOXED_BYTE = null;
    private static final x BOXED_INT = null;
    private static final x BOXED_LONG = null;
    private static final x BOXED_VOID = null;
    public static final KnownTypeNames INSTANCE = null;
    private static final e KOTLIN_UNIT = null;

    static {
        INSTANCE = new KnownTypeNames();
        BOXED_VOID = x.d.b();
        BOXED_INT = x.f15023h.b();
        BOXED_LONG = x.f15024i.b();
        BOXED_BYTE = x.f.b();
        KOTLIN_UNIT = e.o("kotlin", "Unit", new String[0]);
    }

    private KnownTypeNames() {
    }

    public final x getBOXED_BYTE() {
        return BOXED_BYTE;
    }

    public final x getBOXED_INT() {
        return BOXED_INT;
    }

    public final x getBOXED_LONG() {
        return BOXED_LONG;
    }

    public final x getBOXED_VOID() {
        return BOXED_VOID;
    }

    public final e getKOTLIN_UNIT() {
        return KOTLIN_UNIT;
    }
}
