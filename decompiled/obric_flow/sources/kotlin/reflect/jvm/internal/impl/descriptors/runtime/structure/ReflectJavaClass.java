package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nReflectJavaClass.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaClass.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaClass\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,201:1\n179#2,2:202\n1#3:204\n1549#4:205\n1620#4,3:206\n11335#5:209\n11670#5,3:210\n11335#5:214\n11670#5,3:215\n11335#5:218\n11670#5,3:219\n26#6:213\n*S KotlinDebug\n*F\n+ 1 ReflectJavaClass.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaClass\n*L\n51#1:202,2\n64#1:205\n64#1:206,3\n111#1:209\n111#1:210,3\n124#1:214\n124#1:215,3\n131#1:218\n131#1:219,3\n124#1:213\n*E\n"})
public final class ReflectJavaClass extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaClass {
    private final Class<?> klass;

    public ReflectJavaClass(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        this.klass = r5;
    }

    public static final /* synthetic */ boolean access$isEnumValuesOrValueOf(ReflectJavaClass r5, Method r10) {
        return r5.isEnumValuesOrValueOf(r10);
    }

    private final boolean isEnumValuesOrValueOf(Method r5) {
        String r10 = r5.getName();
        if (Intrinsics.areEqual(r10, "values") == false) goto L8;
        if (r5.getParameterTypes().length != 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (Intrinsics.areEqual(r10, "valueOf") == true) goto L10;
        return false;
    L10:
        return Arrays.equals(r5.getParameterTypes(), new Class[]{String.class});
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof ReflectJavaClass) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.klass, ((ReflectJavaClass) r5).klass) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ JavaAnnotation findAnnotation(FqName r5) {
        return findAnnotation(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public /* bridge */ /* synthetic */ AnnotatedElement getElement() {
        return getElement();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public /* bridge */ /* synthetic */ Collection getFields() {
        return getFields();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public FqName getFqName() {
        return ReflectClassUtilKt.getClassId(this.klass).asSingleFqName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public /* bridge */ /* synthetic */ Collection getInnerClassNames() {
        return getInnerClassNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public LightClassOriginKind getLightClassOriginKind() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public /* bridge */ /* synthetic */ Collection getMethods() {
        return getMethods();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return this.klass.getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public Name getName() {
        return Name.identifier(this.klass.getSimpleName());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public /* bridge */ /* synthetic */ JavaClass getOuterClass() {
        return getOuterClass();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public Collection<JavaClassifierType> getPermittedTypes() {
        Class<?>[] r5 = Java16SealedRecordLoader.INSTANCE.loadGetPermittedSubclasses(this.klass);
        if (r5 == null) goto L8;
        ArrayList r10 = new ArrayList(r5.length);
        int r11 = r5.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L10;
        r10.add(new ReflectJavaClassifierType(r5[r12]));
        r12 = r12 + 1;
        goto L5
    L10:
        return r10;
    L8:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public Collection<JavaRecordComponent> getRecordComponents() {
        Object[] r5 = Java16SealedRecordLoader.INSTANCE.loadGetRecordComponents(this.klass);
        int r10 = 0;
        if (r5 != null) goto L5;
        r5 = new Object[0];
    L5:
        ArrayList r11 = new ArrayList(r5.length);
        int r12 = r5.length;
    L6:
        if (r10 >= r12) goto L8;
        r11.add(new ReflectJavaRecordComponent(r5[r10]));
        r10 = r10 + 1;
        goto L6
    L8:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public Collection<JavaClassifierType> getSupertypes() {
        Type r5 = Object.class;
        if (Intrinsics.areEqual(this.klass, r5) == true) goto L5;
        SpreadBuilder r10 = new SpreadBuilder(2);
        Type r11 = this.klass.getGenericSuperclass();
        if (r11 == null) goto L10;
        r5 = r11;
    L10:
        r10.add(r5);
        r10.addSpread(this.klass.getGenericInterfaces());
        List r12 = CollectionsKt.listOf(r10.toArray(new Type[r10.size()]));
        ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
        Iterator r14 = r12.iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        r13.add(new ReflectJavaClassifierType((Type) r14.next()));
        goto L12
    L14:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Class<?>>[] r5 = this.klass.getTypeParameters();
        ArrayList r10 = new ArrayList(r5.length);
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.add(new ReflectJavaTypeParameter(r5[r12]));
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public Visibility getVisibility() {
        int r5 = getModifiers();
        if (Modifier.isPublic(r5) == false) goto L6;
        return Visibilities.Public.INSTANCE;
    L6:
        if (Modifier.isPrivate(r5) == false) goto L9;
        return Visibilities.Private.INSTANCE;
    L9:
        if (Modifier.isProtected(r5) == false) goto L15;
        if (Modifier.isStatic(r5) == false) goto L19;
        return JavaVisibilities.ProtectedStaticVisibility.INSTANCE;
    L19:
        return JavaVisibilities.ProtectedAndPackage.INSTANCE;
    L15:
        return JavaVisibilities.PackageVisibility.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean hasDefaultConstructor() {
        return false;
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isAnnotationType() {
        return this.klass.isAnnotation();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isEnum() {
        return this.klass.isEnum();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isInterface() {
        return this.klass.isInterface();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isRecord() {
        Boolean r5 = Java16SealedRecordLoader.INSTANCE.loadIsRecord(this.klass);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isSealed() {
        Boolean r5 = Java16SealedRecordLoader.INSTANCE.loadIsSealed(this.klass);
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    public String toString() {
        return ReflectJavaClass.class.getName() + ": " + this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public ReflectJavaAnnotation findAnnotation(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        AnnotatedElement r10 = getElement();
        if (r10 == null) goto L7;
        Annotation[] r11 = r10.getDeclaredAnnotations();
        if (r11 == null) goto L7;
        return ReflectJavaAnnotationOwnerKt.findAnnotation(r11, r5);
    L7:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public List<ReflectJavaAnnotation> getAnnotations() {
        AnnotatedElement r5 = getElement();
        if (r5 == null) goto L9;
        Annotation[] r10 = r5.getDeclaredAnnotations();
        if (r10 == null) goto L9;
        List<ReflectJavaAnnotation> r11 = ReflectJavaAnnotationOwnerKt.getAnnotations(r10);
        if (r11 == null) goto L9;
        return r11;
    L9:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<ReflectJavaConstructor> getConstructors() {
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(ArraysKt.asSequence(this.klass.getDeclaredConstructors()), ReflectJavaClass$constructors$1.INSTANCE), ReflectJavaClass$constructors$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public Class<?> getElement() {
        return this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<ReflectJavaField> getFields() {
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(ArraysKt.asSequence(this.klass.getDeclaredFields()), ReflectJavaClass$fields$1.INSTANCE), ReflectJavaClass$fields$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<Name> getInnerClassNames() {
        return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filterNot(ArraysKt.asSequence(this.klass.getDeclaredClasses()), ReflectJavaClass$innerClassNames$1.INSTANCE), ReflectJavaClass$innerClassNames$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<ReflectJavaMethod> getMethods() {
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filter(ArraysKt.asSequence(this.klass.getDeclaredMethods()), new ReflectJavaClass$methods$1(this)), ReflectJavaClass$methods$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public ReflectJavaClass getOuterClass() {
        Class<?> r5 = this.klass.getDeclaringClass();
        if (r5 != null) goto L7;
        return null;
    L7:
        return new ReflectJavaClass(r5);
    }
}
