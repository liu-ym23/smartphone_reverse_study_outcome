package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.InternalXAnnotationValue;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.compat.XConverters;
import javax.lang.model.element.AnnotationValue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\u0002\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacAnnotationValue;", "Landroidx/room/compiler/processing/InternalXAnnotationValue;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "method", "Landroidx/room/compiler/processing/XMethodElement;", "annotationValue", "Ljavax/lang/model/element/AnnotationValue;", "valueType", "Landroidx/room/compiler/processing/XType;", "valueProvider", "Lkotlin/Function0;", "", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Landroidx/room/compiler/processing/XMethodElement;Ljavax/lang/model/element/AnnotationValue;Landroidx/room/compiler/processing/XType;Lkotlin/jvm/functions/Function0;)V", "getAnnotationValue", "()Ljavax/lang/model/element/AnnotationValue;", "getEnv", "()Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "name", "", "getName", "()Ljava/lang/String;", "value", "getValue", "()Ljava/lang/Object;", "value$delegate", "Lkotlin/Lazy;", "getValueType", "()Landroidx/room/compiler/processing/XType;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacAnnotationValue extends InternalXAnnotationValue {
    private final AnnotationValue annotationValue;
    private final JavacProcessingEnv env;
    private final XMethodElement method;
    private final Lazy value$delegate;
    private final Function0<Object> valueProvider;
    private final XType valueType;

    public /* synthetic */ JavacAnnotationValue(final JavacProcessingEnv r10, final XMethodElement r11, final AnnotationValue r12, XType r13, Function0 r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 8) == 0) goto L5;
        r13 = r11.getReturnType();
    L5:
        XType r5 = r13;
        if ((r15 & 16) == 0) goto L8;
        r14 = new AnonymousClass1(r12, r10, r11);
    L8:
        this(r10, r11, r12, r5, r14);
    }

    public static final /* synthetic */ Function0 access$getValueProvider$p(JavacAnnotationValue r5) {
        return r5.valueProvider;
    }

    public final AnnotationValue getAnnotationValue() {
        return this.annotationValue;
    }

    public final JavacProcessingEnv getEnv() {
        return this.env;
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public String getName() {
        return XConverters.toJavac(this.method).getSimpleName().toString();
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public Object getValue() {
        return this.value$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XAnnotationValue
    public XType getValueType() {
        return this.valueType;
    }

    public JavacAnnotationValue(JavacProcessingEnv r5, XMethodElement r10, AnnotationValue r11, XType r12, Function0<? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "method");
        Intrinsics.checkNotNullParameter(r11, "annotationValue");
        Intrinsics.checkNotNullParameter(r12, "valueType");
        Intrinsics.checkNotNullParameter(r13, "valueProvider");
        this.env = r5;
        this.method = r10;
        this.annotationValue = r11;
        this.valueType = r12;
        this.valueProvider = r13;
        this.value$delegate = LazyKt.lazy(new JavacAnnotationValue$value$2(this));
    }
}
