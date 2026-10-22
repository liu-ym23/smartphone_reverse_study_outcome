package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XVariableElement;
import androidx.room.compiler.processing.javac.kotlin.KmType;
import com.google.auto.common.o0;
import javax.lang.model.element.Element;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacVariableElement;", "Landroidx/room/compiler/processing/javac/JavacElement;", "Landroidx/room/compiler/processing/XVariableElement;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "element", "Ljavax/lang/model/element/VariableElement;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/element/VariableElement;)V", "getElement", "()Ljavax/lang/model/element/VariableElement;", "kotlinType", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "getKotlinType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "name", "", "getName", "()Ljava/lang/String;", "type", "Landroidx/room/compiler/processing/javac/JavacType;", "getType", "()Landroidx/room/compiler/processing/javac/JavacType;", "type$delegate", "Lkotlin/Lazy;", "asMemberOf", "other", "Landroidx/room/compiler/processing/XType;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JavacVariableElement extends JavacElement implements XVariableElement {
    private final VariableElement element;
    private final Lazy type$delegate;

    public JavacVariableElement(final JavacProcessingEnv r5, VariableElement r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "element");
        super(r5, (Element) r10);
        this.element = r10;
        this.type$delegate = LazyKt.lazy(new JavacVariableElement$type$2(r5, this));
    }

    @Override // androidx.room.compiler.processing.XVariableElement
    public /* bridge */ /* synthetic */ XType asMemberOf(XType r5) {
        return asMemberOf(r5);
    }

    @Override // androidx.room.compiler.processing.javac.JavacElement
    public /* bridge */ /* synthetic */ Element getElement() {
        return m59getElement();
    }

    public abstract KmType getKotlinType();

    @Override // androidx.room.compiler.processing.XElement
    public String getName() {
        return m59getElement().getSimpleName().toString();
    }

    @Override // androidx.room.compiler.processing.XVariableElement
    public /* bridge */ /* synthetic */ XType getType() {
        return getType();
    }

    @Override // androidx.room.compiler.processing.XVariableElement
    public JavacType asMemberOf(XType r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        XType r5 = getClosestMemberContainer().getType();
        if (r5 == null) goto L8;
        if (r5.isSameType(r10) != true) goto L8;
        return getType();
    L8:
        if ((r10 instanceof JavacDeclaredType) == false) goto L34;
        TypeMirror r11 = o0.e(getEnv$room_compiler_processing().getTypeUtils(), ((JavacDeclaredType) r10).getTypeMirror(), m59getElement());
        JavacProcessingEnv r12 = getEnv$room_compiler_processing();
        KmType r13 = getKotlinType();
        XNullability r14 = ElementExtKt.getNullability(m59getElement());
        TypeKind r15 = r11.getKind();
        if (r15 != null) goto L12;
        int r16 = -1;
    L13:
        if (r16 != 1) goto L15;
        if (r13 != null) goto L41;
        if (r14 == null) goto L32;
        JavacType r17 = new JavacArrayType(r12, o0.a(r11), r14, null);
    L37:
        return r17;
    L32:
        return new JavacArrayType(r12, o0.a(r11));
    L41:
        return new JavacArrayType(r12, o0.a(r11), r13);
    L15:
        if (r16 == 2) goto L22;
        if (r13 != null) goto L36;
        if (r14 == null) goto L38;
        r17 = new DefaultJavacType(r12, r11, r14);
        goto L37
    L38:
        return new DefaultJavacType(r12, r11);
    L36:
        return new DefaultJavacType(r12, r11, r13);
    L22:
        if (r13 != null) goto L39;
        if (r14 == null) goto L40;
        r17 = new JavacDeclaredType(r12, o0.b(r11), r14);
        goto L37
    L40:
        return new JavacDeclaredType(r12, o0.b(r11));
    L39:
        return new JavacDeclaredType(r12, o0.b(r11), r13);
    L12:
        r16 = JavacProcessingEnv.WhenMappings.$EnumSwitchMapping$0[r15.ordinal()];
        goto L13
    L34:
        throw new IllegalStateException("Check failed.");
    }

    /* JADX INFO: renamed from: getElement, reason: collision with other method in class */
    public VariableElement m59getElement() {
        return this.element;
    }

    @Override // androidx.room.compiler.processing.XVariableElement
    public JavacType getType() {
        return (JavacType) this.type$delegate.getValue();
    }
}
