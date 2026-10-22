package androidx.room.compiler.processing.javac;

import ai.j0;
import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationValue;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XMessager;
import javax.annotation.processing.Messager;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacProcessingEnvMessager;", "Landroidx/room/compiler/processing/XMessager;", "delegate", "Ljavax/annotation/processing/Messager;", "(Ljavax/annotation/processing/Messager;)V", "getDelegate", "()Ljavax/annotation/processing/Messager;", "onPrintMessage", "", "kind", "Ljavax/tools/Diagnostic$Kind;", "msg", "", "element", "Landroidx/room/compiler/processing/XElement;", "annotation", "Landroidx/room/compiler/processing/XAnnotation;", "annotationValue", "Landroidx/room/compiler/processing/XAnnotationValue;", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacProcessingEnvMessager extends XMessager {
    public static final Companion Companion = null;
    private final Messager delegate;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacProcessingEnvMessager$Companion;", "", "()V", "isFromCompiledClass", "", "Ljavax/lang/model/element/Element;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ boolean access$isFromCompiledClass(Companion r5, Element r10) {
            return r5.isFromCompiledClass(r10);
        }

        private final boolean isFromCompiledClass(Element r5) {
            String r10 = isFromCompiledClass$getClassFileString(r5);     // Catch: Throwable -> L9
            if (StringsKt.g(r10, ".jar") == true) goto L7;
            if (StringsKt.g(r10, ".class") == true) goto L7;
            return false;
        L7:
            return true;
        L13:
            return false;
        }

        private static final String isFromCompiledClass$getClassFileString(Object r5) {
            return r5.getClass().getDeclaredField("classfile").get(r5).toString();
        L5:
            return isFromCompiledClass$getClassFileString(r5.getClass().getSuperclass().getDeclaredField("owner").get(r5));
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public JavacProcessingEnvMessager(Messager r5) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        this.delegate = r5;
    }

    public final Messager getDelegate() {
        return this.delegate;
    }

    @Override // androidx.room.compiler.processing.XMessager
    public void onPrintMessage(Diagnostic.Kind r10, String r11, XElement r12, XAnnotation r13, XAnnotationValue r14) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "msg");
        if (r12 != null) goto L6;
        this.delegate.printMessage(r10, r11);
        return;
    L6:
        JavacElement r15 = (JavacElement) r12;
        Element r5 = r15.getElement();
        if (Companion.access$isFromCompiledClass(Companion, r5) == false) goto L9;
        StringBuilder r16 = j0.w(r11, " - ");
        r16.append(r15.getFallbackLocationText());
        r11 = r16.toString();
    L9:
        String r17 = r11;
        if (r13 != null) goto L13;
        this.delegate.printMessage(r10, r17, r5);
        return;
    L13:
        AnnotationMirror r18 = ((JavacAnnotation) r13).getMirror();
        if (r14 != null) goto L17;
        this.delegate.printMessage(r10, r17, r5, r18);
        return;
    L17:
        AnnotationValue r19 = ((JavacAnnotationValue) r14).getAnnotationValue();
        this.delegate.printMessage(r10, r17, r5, r18, r19);
    }
}
