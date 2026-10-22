package androidx.room.compiler.processing.javac;

import ai.j0;
import androidx.room.compiler.processing.XFiler;
import androidx.room.compiler.processing.XProcessingEnv;
import com.squareup.javapoet.o;
import com.squareup.kotlinpoet.i;
import javax.annotation.processing.Filer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacFiler;", "Landroidx/room/compiler/processing/XFiler;", "Landroidx/room/compiler/processing/XProcessingEnv;", "processingEnv", "Ljavax/annotation/processing/Filer;", "delegate", "<init>", "(Landroidx/room/compiler/processing/XProcessingEnv;Ljavax/annotation/processing/Filer;)V", "Lcom/squareup/javapoet/o;", "javaFile", "Landroidx/room/compiler/processing/XFiler$Mode;", "mode", "", "write", "(Lcom/squareup/javapoet/o;Landroidx/room/compiler/processing/XFiler$Mode;)V", "Lcom/squareup/kotlinpoet/i;", "fileSpec", "(Lcom/squareup/kotlinpoet/i;Landroidx/room/compiler/processing/XFiler$Mode;)V", "Landroidx/room/compiler/processing/XProcessingEnv;", "Ljavax/annotation/processing/Filer;", "getDelegate", "()Ljavax/annotation/processing/Filer;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacFiler implements XFiler {
    private final Filer delegate;
    private final XProcessingEnv processingEnv;

    public JavacFiler(XProcessingEnv r5, Filer r10) {
        Intrinsics.checkNotNullParameter(r5, "processingEnv");
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.processingEnv = r5;
        this.delegate = r10;
    }

    public final Filer getDelegate() {
        return this.delegate;
    }

    @Override // androidx.room.compiler.processing.XFiler
    public void write(o r5, XFiler.Mode r10) {
        Intrinsics.checkNotNullParameter(r5, "javaFile");
        Intrinsics.checkNotNullParameter(r10, "mode");
        r5.d(this.delegate);
    }

    @Override // androidx.room.compiler.processing.XFiler
    public void write(i r5, XFiler.Mode r10) {
        Intrinsics.checkNotNullParameter(r5, "fileSpec");
        Intrinsics.checkNotNullParameter(r10, "mode");
        if (this.processingEnv.getOptions().containsKey("kapt.kotlin.generated") == false) goto L6;
        r5.c(this.delegate);
        return;
    L6:
        String r11 = StringsKt.E(r5.f15155c, '.', '/');
        StringBuilder r12 = new StringBuilder("Could not generate kotlin file ");
        r12.append(r11);
        r12.append('/');
        throw new IllegalArgumentException(j0.q(r12, r5.d, ".kt. The annotation processing environment is not set to generate Kotlin files.").toString());
    }
}
