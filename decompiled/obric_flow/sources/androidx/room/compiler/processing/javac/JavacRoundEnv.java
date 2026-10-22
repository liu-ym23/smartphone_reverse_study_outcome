package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XRoundEnv;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017H\u0016J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\r2\u0006\u0010\u001c\u001a\u00020\u0015H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacRoundEnv;", "Landroidx/room/compiler/processing/XRoundEnv;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "delegate", "Ljavax/annotation/processing/RoundEnvironment;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/annotation/processing/RoundEnvironment;)V", "getDelegate", "()Ljavax/annotation/processing/RoundEnvironment;", "isProcessingOver", "", "()Z", "rootElements", "", "Landroidx/room/compiler/processing/XElement;", "getRootElements", "()Ljava/util/Set;", "rootElements$delegate", "Lkotlin/Lazy;", "getElementsAnnotatedWith", "annotationQualifiedName", "", "klass", "Lkotlin/reflect/KClass;", "", "wrapAnnotatedElements", "elements", "Ljavax/lang/model/element/Element;", "annotationName", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacRoundEnv implements XRoundEnv {
    private final RoundEnvironment delegate;
    private final JavacProcessingEnv env;
    private final Lazy rootElements$delegate;

    public JavacRoundEnv(JavacProcessingEnv r5, RoundEnvironment r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.env = r5;
        this.delegate = r10;
        this.rootElements$delegate = LazyKt.lazy(new JavacRoundEnv$rootElements$2(this));
    }

    public static final /* synthetic */ JavacProcessingEnv access$getEnv$p(JavacRoundEnv r5) {
        return r5.env;
    }

    private final Set<XElement> wrapAnnotatedElements(Set<? extends Element> r5, String r10) {
        Set<? extends Element> r11 = r5;
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        Element r14 = (Element) r13.next();
        r12.add(this.env.wrapAnnotatedElement$room_compiler_processing(r14, r10));
        goto L4
    L7:
        return CollectionsKt.toSet(r12);
    }

    public final RoundEnvironment getDelegate() {
        return this.delegate;
    }

    @Override // androidx.room.compiler.processing.XRoundEnv
    public Set<XElement> getElementsAnnotatedWith(KClass<? extends Annotation> r5) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        return wrapAnnotatedElements(this.delegate.getElementsAnnotatedWith(JvmClassMappingKt.getJavaClass(r5)), JvmClassMappingKt.getJavaClass(r5).getCanonicalName());
    }

    @Override // androidx.room.compiler.processing.XRoundEnv
    public Set<XElement> getRootElements() {
        return (Set) this.rootElements$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XRoundEnv
    public boolean isProcessingOver() {
        return this.delegate.processingOver();
    }

    @Override // androidx.room.compiler.processing.XRoundEnv
    public Set<XElement> getElementsAnnotatedWith(String r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationQualifiedName");
        if (Intrinsics.areEqual(r5, XPath.WILDCARD) == true) goto L5;
        TypeElement r10 = this.env.getElementUtils().getTypeElement(r5);
        if (r10 != null) goto L11;
        return SetsKt.emptySet();
    L11:
        return wrapAnnotatedElements(this.delegate.getElementsAnnotatedWith(r10), r5);
    L5:
        return SetsKt.emptySet();
    }
}
