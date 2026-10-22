package androidx.room.compiler.codegen.java;

import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\b\"\"\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\"\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/squareup/javapoet/e;", "kotlin.jvm.PlatformType", "NULLABLE_ANNOTATION", "Lcom/squareup/javapoet/e;", "getNULLABLE_ANNOTATION", "()Lcom/squareup/javapoet/e;", "NONNULL_ANNOTATION", "getNONNULL_ANNOTATION", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ClassNamesKt {
    private static final e NONNULL_ANNOTATION = null;
    private static final e NULLABLE_ANNOTATION = null;

    static {
        NULLABLE_ANNOTATION = e.o("androidx.annotation", "Nullable", new String[0]);
        NONNULL_ANNOTATION = e.o("androidx.annotation", "NonNull", new String[0]);
    }

    public static final e getNONNULL_ANNOTATION() {
        return NONNULL_ANNOTATION;
    }

    public static final e getNULLABLE_ANNOTATION() {
        return NULLABLE_ANNOTATION;
    }
}
