package androidx.room.compiler.processing.javac.kotlin;

import androidx.room.jarjarred.kotlinx.metadata.jvm.KotlinClassHeader;
import androidx.room.jarjarred.kotlinx.metadata.jvm.KotlinClassMetadata;
import java.util.Iterator;
import java.util.List;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 E2\u00020\u0001:\u0001EB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\rJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\rJ\r\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\rJ\r\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\rJ\r\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\rJ\r\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\rJ\r\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\rJ\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00180,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010/R!\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010(\u001a\u0004\b2\u0010/R!\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010(\u001a\u0004\b5\u0010/R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010(\u001a\u0004\b9\u0010:R\u0018\u0010>\u001a\u00020\b*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010B\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0013\u0010D\u001a\u0004\u0018\u00010?8F¢\u0006\u0006\u001a\u0004\bC\u0010A¨\u0006F"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/KotlinMetadataElement;", "", "Ljavax/lang/model/element/Element;", "element", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$Class;", "classMetadata", "<init>", "(Ljavax/lang/model/element/Element;Ljava/lang/Object;)V", "", "findPrimaryConstructorSignature", "()Ljava/lang/String;", "", "isObject", "()Z", "isCompanionObject", "isAnnotationClass", "isClass", "isInterface", "isDataClass", "isValueClass", "isFunctionalInterface", "isExpect", "Ljavax/lang/model/element/ExecutableElement;", "method", "Landroidx/room/compiler/processing/javac/kotlin/KmFunction;", "getFunctionMetadata", "(Ljavax/lang/model/element/ExecutableElement;)Landroidx/room/compiler/processing/javac/kotlin/KmFunction;", "Landroidx/room/compiler/processing/javac/kotlin/KmConstructor;", "getConstructorMetadata", "(Ljavax/lang/model/element/ExecutableElement;)Landroidx/room/compiler/processing/javac/kotlin/KmConstructor;", "propertyName", "Landroidx/room/compiler/processing/javac/kotlin/KmProperty;", "getPropertyMetadata", "(Ljava/lang/String;)Landroidx/room/compiler/processing/javac/kotlin/KmProperty;", "Ljavax/lang/model/element/Element;", "getElement", "()Ljavax/lang/model/element/Element;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KotlinClassMetadata$Class;", "Landroidx/room/compiler/processing/javac/kotlin/KmClassTypeInfo;", "typeInfo$delegate", "Lkotlin/Lazy;", "getTypeInfo", "()Landroidx/room/compiler/processing/javac/kotlin/KmClassTypeInfo;", "typeInfo", "", "functionList$delegate", "getFunctionList", "()Ljava/util/List;", "functionList", "constructorList$delegate", "getConstructorList", "constructorList", "propertyList$delegate", "getPropertyList", "propertyList", "Landroidx/room/compiler/processing/javac/kotlin/KotlinMetadataClassFlags;", "classFlags$delegate", "getClassFlags", "()Landroidx/room/compiler/processing/javac/kotlin/KotlinMetadataClassFlags;", "classFlags", "getDescriptor", "(Ljavax/lang/model/element/ExecutableElement;)Ljava/lang/String;", "descriptor", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "getKmType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "kmType", "getSuperType", "superType", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KotlinMetadataElement {
    public static final Companion Companion = null;
    private final Lazy classFlags$delegate;
    private final KotlinClassMetadata.Class classMetadata;
    private final Lazy constructorList$delegate;
    private final Element element;
    private final Lazy functionList$delegate;
    private final Lazy propertyList$delegate;
    private final Lazy typeInfo$delegate;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\t"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/KotlinMetadataElement$Companion;", "", "()V", "createFor", "Landroidx/room/compiler/processing/javac/kotlin/KotlinMetadataElement;", "element", "Ljavax/lang/model/element/Element;", "getMetadataAnnotation", "Lkotlin/Metadata;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private final Metadata getMetadataAnnotation(Element r5) {
            if (r5 == null) goto L6;
            Metadata r10 = (Metadata) r5.getAnnotation(Metadata.class);
            if (r10 == null) goto L9;
            return r10;
        L9:
            return getMetadataAnnotation(r5.getEnclosingElement());
        L6:
            return null;
        }

        public final KotlinMetadataElement createFor(Element r11) {
            Intrinsics.checkNotNullParameter(r11, "element");
            Metadata r10 = getMetadataAnnotation(r11);
            if (r10 == null) goto L7;
            KotlinClassMetadata r12 = KotlinClassMetadata.Companion.read(new KotlinClassHeader(Integer.valueOf(r10.k()), r10.mv(), r10.d1(), r10.d2(), r10.xs(), r10.pn(), Integer.valueOf(r10.xi())));
            if ((r12 instanceof KotlinClassMetadata.Class) == false) goto L7;
            KotlinClassMetadata.Class r13 = (KotlinClassMetadata.Class) r12;
        L8:
            if (r13 != null) goto L10;
            return null;
        L10:
            return new KotlinMetadataElement(r11, r13);
        L7:
            r13 = null;
            goto L8
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KotlinMetadataElement(Element r5, KotlinClassMetadata.Class r10) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, "classMetadata");
        this.element = r5;
        this.classMetadata = r10;
        this.typeInfo$delegate = LazyKt.lazy(new KotlinMetadataElement$typeInfo$2(this));
        this.functionList$delegate = LazyKt.lazy(new KotlinMetadataElement$functionList$2(this));
        this.constructorList$delegate = LazyKt.lazy(new KotlinMetadataElement$constructorList$2(this));
        this.propertyList$delegate = LazyKt.lazy(new KotlinMetadataElement$propertyList$2(this));
        this.classFlags$delegate = LazyKt.lazy(new KotlinMetadataElement$classFlags$2(this));
    }

    public static final /* synthetic */ KotlinClassMetadata.Class access$getClassMetadata$p(KotlinMetadataElement r5) {
        return r5.classMetadata;
    }

    private final KotlinMetadataClassFlags getClassFlags() {
        return (KotlinMetadataClassFlags) this.classFlags$delegate.getValue();
    }

    private final List<KmConstructor> getConstructorList() {
        return (List) this.constructorList$delegate.getValue();
    }

    private final String getDescriptor(ExecutableElement r5) {
        return JvmDescriptorUtilsKt.descriptor(r5);
    }

    private final List<KmFunction> getFunctionList() {
        return (List) this.functionList$delegate.getValue();
    }

    private final List<KmProperty> getPropertyList() {
        return (List) this.propertyList$delegate.getValue();
    }

    private final KmClassTypeInfo getTypeInfo() {
        return (KmClassTypeInfo) this.typeInfo$delegate.getValue();
    }

    public final String findPrimaryConstructorSignature() {
        Iterator<T> r5 = getConstructorList().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r10 = r5.next();
        if (((KmConstructor) r10).isPrimary() == false) goto L4;
    L9:
        KmConstructor r11 = (KmConstructor) r10;
        if (r11 != null) goto L12;
        return null;
    L12:
        return r11.getDescriptor();
    L8:
        r10 = null;
        goto L9
    }

    public final KmConstructor getConstructorMetadata(ExecutableElement r5) {
        Intrinsics.checkNotNullParameter(r5, "method");
        if (r5.getKind() != ElementKind.CONSTRUCTOR) goto L14;
        String r10 = getDescriptor(r5);
        Iterator<T> r11 = getConstructorList().iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((KmConstructor) r12).getDescriptor(), r10) == false) goto L6;
    L12:
        return (KmConstructor) r12;
    L10:
        r12 = null;
        goto L12
    L14:
        throw new IllegalStateException("must pass an element type of constructor");
    }

    public final Element getElement() {
        return this.element;
    }

    public final KmFunction getFunctionMetadata(ExecutableElement r5) {
        Intrinsics.checkNotNullParameter(r5, "method");
        if (r5.getKind() != ElementKind.METHOD) goto L36;
        String r10 = getDescriptor(r5);
        Iterator<T> r11 = getFunctionList().iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((KmFunction) r12).getDescriptor(), r10) == false) goto L6;
    L11:
        KmFunction r13 = (KmFunction) r12;
        if (r13 == null) goto L14;
        return r13;
    L14:
        Iterator<T> r14 = getPropertyList().iterator();
    L16:
        if (r14.hasNext() == false) goto L46;
        KmProperty r15 = (KmProperty) r14.next();
        KmFunction r16 = r15.getGetter();
        if (r16 == null) goto L20;
        String r17 = r16.getDescriptor();
    L22:
        if (Intrinsics.areEqual(r17, r10) == false) goto L24;
        KmFunction r18 = r15.getGetter();
    L32:
        if (r18 == null) goto L16;
        return r18;
    L24:
        KmFunction r19 = r15.getSetter();
        if (r19 == null) goto L27;
        String r20 = r19.getDescriptor();
    L29:
        if (Intrinsics.areEqual(r20, r10) == false) goto L31;
        r18 = r15.getSetter();
        goto L32
    L31:
        r18 = null;
        goto L32
    L27:
        r20 = null;
        goto L29
    L20:
        r17 = null;
        goto L22
    L46:
        return null;
    L10:
        r12 = null;
        goto L11
    L36:
        throw new IllegalStateException("must pass an element type of method");
    }

    public final KmType getKmType() {
        return getTypeInfo().getKmType();
    }

    public final KmProperty getPropertyMetadata(String r5) {
        Intrinsics.checkNotNullParameter(r5, "propertyName");
        Iterator<T> r10 = getPropertyList().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((KmProperty) r11).getName(), r5) == false) goto L4;
    L10:
        return (KmProperty) r11;
    L8:
        r11 = null;
        goto L10
    }

    public final KmType getSuperType() {
        return getTypeInfo().getSuperType();
    }

    public final boolean isAnnotationClass() {
        return getClassFlags().isAnnotationClass();
    }

    public final boolean isClass() {
        return getClassFlags().isClass();
    }

    public final boolean isCompanionObject() {
        return getClassFlags().isCompanionObject();
    }

    public final boolean isDataClass() {
        return getClassFlags().isDataClass();
    }

    public final boolean isExpect() {
        return getClassFlags().isExpect();
    }

    public final boolean isFunctionalInterface() {
        return getClassFlags().isFunctionalInterface();
    }

    public final boolean isInterface() {
        return getClassFlags().isInterface();
    }

    public final boolean isObject() {
        return getClassFlags().isObject();
    }

    public final boolean isValueClass() {
        return getClassFlags().isValueClass();
    }
}
