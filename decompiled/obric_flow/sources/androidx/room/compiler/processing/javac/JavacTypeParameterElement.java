package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeParameterElement;
import androidx.room.compiler.processing.javac.kotlin.KmType;
import com.squareup.javapoet.a0;
import java.util.List;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeParameterElement;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacTypeParameterElement;", "Landroidx/room/compiler/processing/javac/JavacElement;", "Landroidx/room/compiler/processing/XTypeParameterElement;", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "env", "Landroidx/room/compiler/processing/XElement;", "enclosingElement", "Ljavax/lang/model/element/TypeParameterElement;", "element", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "kotlinType", "<init>", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Landroidx/room/compiler/processing/XElement;Ljavax/lang/model/element/TypeParameterElement;Landroidx/room/compiler/processing/javac/kotlin/KmType;)V", "Landroidx/room/compiler/processing/XElement;", "getEnclosingElement", "()Landroidx/room/compiler/processing/XElement;", "Ljavax/lang/model/element/TypeParameterElement;", "getElement", "()Ljavax/lang/model/element/TypeParameterElement;", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "Lcom/squareup/javapoet/a0;", "typeVariableName$delegate", "Lkotlin/Lazy;", "getTypeVariableName", "()Lcom/squareup/javapoet/a0;", "typeVariableName", "", "Landroidx/room/compiler/processing/XType;", "bounds$delegate", "getBounds", "()Ljava/util/List;", "bounds", "", "getName", "()Ljava/lang/String;", "name", "getFallbackLocationText", "fallbackLocationText", "Landroidx/room/compiler/processing/XMemberContainer;", "getClosestMemberContainer", "()Landroidx/room/compiler/processing/XMemberContainer;", "closestMemberContainer", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacTypeParameterElement extends JavacElement implements XTypeParameterElement {
    private final Lazy bounds$delegate;
    private final TypeParameterElement element;
    private final XElement enclosingElement;
    private final KmType kotlinType;
    private final Lazy typeVariableName$delegate;

    public JavacTypeParameterElement(final JavacProcessingEnv r5, XElement r10, TypeParameterElement r11, KmType r12) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "enclosingElement");
        Intrinsics.checkNotNullParameter(r11, "element");
        super(r5, (Element) r11);
        this.enclosingElement = r10;
        this.element = r11;
        this.kotlinType = r12;
        this.typeVariableName$delegate = LazyKt.lazy(new JavacTypeParameterElement$typeVariableName$2(this));
        this.bounds$delegate = LazyKt.lazy(new JavacTypeParameterElement$bounds$2(this, r5));
    }

    public static final /* synthetic */ KmType access$getKotlinType$p(JavacTypeParameterElement r5) {
        return r5.kotlinType;
    }

    @Override // androidx.room.compiler.processing.XTypeParameterElement
    public List<XType> getBounds() {
        return (List) this.bounds$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public XMemberContainer getClosestMemberContainer() {
        return getEnclosingElement().getClosestMemberContainer();
    }

    @Override // androidx.room.compiler.processing.javac.JavacElement
    public /* bridge */ /* synthetic */ Element getElement() {
        return m58getElement();
    }

    @Override // androidx.room.compiler.processing.XElement
    public XElement getEnclosingElement() {
        return this.enclosingElement;
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getFallbackLocationText() {
        return m58getElement().getSimpleName().toString();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getName() {
        return m58getElement().getSimpleName().toString();
    }

    @Override // androidx.room.compiler.processing.XTypeParameterElement
    public a0 getTypeVariableName() {
        return (a0) this.typeVariableName$delegate.getValue();
    }

    /* JADX INFO: renamed from: getElement, reason: collision with other method in class */
    public TypeParameterElement m58getElement() {
        return this.element;
    }
}
