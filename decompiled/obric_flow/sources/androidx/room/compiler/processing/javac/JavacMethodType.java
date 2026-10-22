package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XMethodType;
import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XSuspendMethodType;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.javac.kotlin.KmFunction;
import androidx.room.compiler.processing.javac.kotlin.KmType;
import com.google.auto.common.o0;
import com.squareup.javapoet.a0;
import java.util.List;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0003\u001b\u001c\u001dB!\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R)\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019\u0082\u0001\u0002\u001e\u001f¨\u0006 "}, d2 = {"Landroidx/room/compiler/processing/javac/JavacMethodType;", "Landroidx/room/compiler/processing/javac/JavacExecutableType;", "Landroidx/room/compiler/processing/XMethodType;", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "env", "Landroidx/room/compiler/processing/javac/JavacMethodElement;", "element", "Ljavax/lang/model/type/ExecutableType;", "executableType", "<init>", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Landroidx/room/compiler/processing/javac/JavacMethodElement;Ljavax/lang/model/type/ExecutableType;)V", "Landroidx/room/compiler/processing/javac/JavacMethodElement;", "getElement", "()Landroidx/room/compiler/processing/javac/JavacMethodElement;", "Landroidx/room/compiler/processing/javac/JavacType;", "returnType$delegate", "Lkotlin/Lazy;", "getReturnType", "()Landroidx/room/compiler/processing/javac/JavacType;", "returnType", "", "Lcom/squareup/javapoet/a0;", "kotlin.jvm.PlatformType", "typeVariableNames$delegate", "getTypeVariableNames", "()Ljava/util/List;", "typeVariableNames", "Companion", "NormalMethodType", "SuspendMethodType", "Landroidx/room/compiler/processing/javac/JavacMethodType$NormalMethodType;", "Landroidx/room/compiler/processing/javac/JavacMethodType$SuspendMethodType;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JavacMethodType extends JavacExecutableType implements XMethodType {
    public static final Companion Companion = null;
    private final JavacMethodElement element;
    private final Lazy returnType$delegate;
    private final Lazy typeVariableNames$delegate;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacMethodType$Companion;", "", "()V", "create", "Landroidx/room/compiler/processing/javac/JavacMethodType;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "element", "Landroidx/room/compiler/processing/javac/JavacMethodElement;", "executableType", "Ljavax/lang/model/type/ExecutableType;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final JavacMethodType create(JavacProcessingEnv r5, JavacMethodElement r10, ExecutableType r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "element");
            Intrinsics.checkNotNullParameter(r11, "executableType");
            if (r10.isSuspendFunction() == false) goto L6;
            return new SuspendMethodType(r5, r10, r11);
        L6:
            return new NormalMethodType(r5, r10, r11);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacMethodType$NormalMethodType;", "Landroidx/room/compiler/processing/javac/JavacMethodType;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "element", "Landroidx/room/compiler/processing/javac/JavacMethodElement;", "executableType", "Ljavax/lang/model/type/ExecutableType;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Landroidx/room/compiler/processing/javac/JavacMethodElement;Ljavax/lang/model/type/ExecutableType;)V", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class NormalMethodType extends JavacMethodType {
        public NormalMethodType(JavacProcessingEnv r5, JavacMethodElement r10, ExecutableType r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "element");
            Intrinsics.checkNotNullParameter(r11, "executableType");
            super(r5, r10, r11, null);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacMethodType$SuspendMethodType;", "Landroidx/room/compiler/processing/javac/JavacMethodType;", "Landroidx/room/compiler/processing/XSuspendMethodType;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "element", "Landroidx/room/compiler/processing/javac/JavacMethodElement;", "executableType", "Ljavax/lang/model/type/ExecutableType;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Landroidx/room/compiler/processing/javac/JavacMethodElement;Ljavax/lang/model/type/ExecutableType;)V", "getSuspendFunctionReturnType", "Landroidx/room/compiler/processing/XType;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SuspendMethodType extends JavacMethodType implements XSuspendMethodType {
        public SuspendMethodType(JavacProcessingEnv r5, JavacMethodElement r10, ExecutableType r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "element");
            Intrinsics.checkNotNullParameter(r11, "executableType");
            super(r5, r10, r11, null);
        }

        @Override // androidx.room.compiler.processing.XSuspendMethodType
        public XType getSuspendFunctionReturnType() {
            TypeMirror r5 = (TypeMirror) CollectionsKt.first(o0.b((TypeMirror) CollectionsKt.last(getExecutableType().getParameterTypes())).getTypeArguments());
            TypeMirror r10 = TypeMirrorExtKt.extendsBound(r5);
            if (r10 == null) goto L6;
            r5 = r10;
        L6:
            JavacProcessingEnv r11 = getEnv();
            KmFunction r12 = getElement().getKotlinMetadata();
            if (r12 == null) goto L9;
            KmType r13 = r12.getReturnType();
        L10:
            XNullability r14 = ElementExtKt.getNullability(getElement().m56getElement());
            TypeKind r15 = r5.getKind();
            if (r15 != null) goto L13;
            int r16 = -1;
        L15:
            if (r16 != 1) goto L17;
            if (r13 != null) goto L40;
            if (r14 == null) goto L34;
            XType r17 = new JavacArrayType(r11, o0.a(r5), r14, null);
        L36:
            return r17;
        L34:
            return new JavacArrayType(r11, o0.a(r5));
        L40:
            return new JavacArrayType(r11, o0.a(r5), r13);
        L17:
            if (r16 == 2) goto L24;
            if (r13 != null) goto L35;
            if (r14 == null) goto L37;
            r17 = new DefaultJavacType(r11, r5, r14);
            goto L36
        L37:
            return new DefaultJavacType(r11, r5);
        L35:
            return new DefaultJavacType(r11, r5, r13);
        L24:
            if (r13 != null) goto L38;
            if (r14 == null) goto L39;
            r17 = new JavacDeclaredType(r11, o0.b(r5), r14);
            goto L36
        L39:
            return new JavacDeclaredType(r11, o0.b(r5));
        L38:
            return new JavacDeclaredType(r11, o0.b(r5), r13);
        L13:
            r16 = JavacProcessingEnv.WhenMappings.$EnumSwitchMapping$0[r15.ordinal()];
            goto L15
        L9:
            r13 = null;
            goto L10
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ JavacMethodType(JavacProcessingEnv r5, JavacMethodElement r10, ExecutableType r11, DefaultConstructorMarker r12) {
        this(r5, r10, r11);
    }

    @Override // androidx.room.compiler.processing.javac.JavacExecutableType
    public /* bridge */ /* synthetic */ JavacExecutableElement getElement() {
        return getElement();
    }

    @Override // androidx.room.compiler.processing.XMethodType
    public /* bridge */ /* synthetic */ XType getReturnType() {
        return getReturnType();
    }

    @Override // androidx.room.compiler.processing.XMethodType
    public List<a0> getTypeVariableNames() {
        return (List) this.typeVariableNames$delegate.getValue();
    }

    private JavacMethodType(final JavacProcessingEnv r5, JavacMethodElement r10, final ExecutableType r11) {
        super(r5, r10, r11);
        this.element = r10;
        this.returnType$delegate = LazyKt.lazy(new JavacMethodType$returnType$2(r5, r11, this));
        this.typeVariableNames$delegate = LazyKt.lazy(new JavacMethodType$typeVariableNames$2(r11));
    }

    @Override // androidx.room.compiler.processing.javac.JavacExecutableType
    public JavacMethodElement getElement() {
        return this.element;
    }

    @Override // androidx.room.compiler.processing.XMethodType
    public JavacType getReturnType() {
        return (JavacType) this.returnType$delegate.getValue();
    }
}
