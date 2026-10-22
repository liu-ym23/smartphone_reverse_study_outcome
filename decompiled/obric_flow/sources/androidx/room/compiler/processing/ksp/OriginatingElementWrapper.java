package androidx.room.compiler.processing.ksp;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.type.TypeMirror;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0001%B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J9\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t\u0018\u00010\u000b2\u0006\u0010\f\u001a\u0002H\tH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J+\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\n\b\u0000\u0010\u0011*\u0004\u0018\u00010\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0011\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J-\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00110\u001a\"\n\b\u0000\u0010\u0011*\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0014H\u0016¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\b\u0010#\u001a\u00020$H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002&'¨\u0006("}, d2 = {"Landroidx/room/compiler/processing/ksp/OriginatingElementWrapper;", "Ljavax/lang/model/element/Element;", "elementSimpleName", "", "(Ljava/lang/String;)V", "getElementSimpleName", "()Ljava/lang/String;", "accept", "R", "P", "v", "Ljavax/lang/model/element/ElementVisitor;", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "(Ljavax/lang/model/element/ElementVisitor;Ljava/lang/Object;)Ljava/lang/Object;", "asType", "Ljavax/lang/model/type/TypeMirror;", "getAnnotation", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "annotationType", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "getAnnotationMirrors", "", "Ljavax/lang/model/element/AnnotationMirror;", "getAnnotationsByType", "", "(Ljava/lang/Class;)[Ljava/lang/annotation/Annotation;", "getEnclosedElements", "getEnclosingElement", "getKind", "Ljavax/lang/model/element/ElementKind;", "getModifiers", "", "Ljavax/lang/model/element/Modifier;", "getSimpleName", "Ljavax/lang/model/element/Name;", "NameImpl", "Landroidx/room/compiler/processing/ksp/KSClassDeclarationAsOriginatingElement;", "Landroidx/room/compiler/processing/ksp/KSFileAsOriginatingElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class OriginatingElementWrapper implements Element {
    private final String elementSimpleName;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0003J\u0019\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0096\u0001R\u0012\u0010\u0006\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/room/compiler/processing/ksp/OriginatingElementWrapper$NameImpl;", "Ljavax/lang/model/element/Name;", "", "str", "", "(Ljava/lang/String;)V", "length", "", "getLength", "()I", "contentEquals", "", "cs", "get", "", "index", "subSequence", "startIndex", "endIndex", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class NameImpl implements Name, CharSequence {
        private final String str;

        public NameImpl(String r5) {
            Intrinsics.checkNotNullParameter(r5, "str");
            this.str = r5;
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ char charAt(int r5) {
            return get(r5);
        }

        public boolean contentEquals(CharSequence r5) {
            Intrinsics.checkNotNullParameter(r5, "cs");
            return Intrinsics.areEqual(this.str, r5.toString());
        }

        public char get(int r5) {
            return this.str.charAt(r5);
        }

        public int getLength() {
            return this.str.length();
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ int length() {
            return getLength();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int r5, int r10) {
            return this.str.subSequence(r5, r10);
        }
    }

    public /* synthetic */ OriginatingElementWrapper(String r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    public <R, P> R accept(ElementVisitor<R, P> r5, P r10) {
        return null;
    }

    public TypeMirror asType() {
        throw new UnsupportedOperationException(Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + " cannot be converted to a type");
    }

    public <A extends Annotation> A getAnnotation(Class<A> r5) {
        return null;
    }

    public List<AnnotationMirror> getAnnotationMirrors() {
        return CollectionsKt.emptyList();
    }

    public <A extends Annotation> A[] getAnnotationsByType(Class<A> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationType");
        return (A[]) ((Annotation[]) new Object[0]);
    }

    public final String getElementSimpleName() {
        return this.elementSimpleName;
    }

    public List<Element> getEnclosedElements() {
        return CollectionsKt.emptyList();
    }

    public Element getEnclosingElement() {
        return null;
    }

    public ElementKind getKind() {
        return ElementKind.OTHER;
    }

    public Set<Modifier> getModifiers() {
        return SetsKt.emptySet();
    }

    public Name getSimpleName() {
        return new NameImpl(this.elementSimpleName);
    }

    private OriginatingElementWrapper(String r5) {
        this.elementSimpleName = r5;
    }
}
