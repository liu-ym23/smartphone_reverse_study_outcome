package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaClass extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaClass {
    private final Class<?> klass;

    public ReflectJavaClass(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "klass");
        this.klass = r10;
    }

    public static final /* synthetic */ boolean access$isEnumValuesOrValueOf(ReflectJavaClass r10, Method r11) {
        return r10.isEnumValuesOrValueOf(r11);
    }

    private final boolean isEnumValuesOrValueOf(Method r10) {
        String r11 = r10.getName();
        if (Intrinsics.areEqual(r11, "values") == false) goto L8;
        Class<?>[] r12 = r10.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r12, "method.parameterTypes");
        if (r12.length != 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (Intrinsics.areEqual(r11, "valueOf") == false) goto L11;
        return Arrays.equals(r10.getParameterTypes(), new Class[]{String.class});
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof ReflectJavaClass) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.klass, ((ReflectJavaClass) r10).klass) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public ReflectJavaAnnotation findAnnotation(FqName r10) {
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ JavaAnnotation findAnnotation(FqName r10) {
        return findAnnotation(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<ReflectJavaConstructor> getConstructors() {
        Constructor<?>[] r10 = this.klass.getDeclaredConstructors();
        Intrinsics.checkNotNullExpressionValue(r10, "klass.declaredConstructors");
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(ArraysKt.asSequence(r10), ReflectJavaClass$constructors$1.INSTANCE), ReflectJavaClass$constructors$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public Class<?> getElement() {
        return this.klass;
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
    public List<ReflectJavaField> getFields() {
        Field[] r10 = this.klass.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(r10, "klass.declaredFields");
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(ArraysKt.asSequence(r10), ReflectJavaClass$fields$1.INSTANCE), ReflectJavaClass$fields$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public FqName getFqName() {
        FqName r10 = ReflectClassUtilKt.getClassId(this.klass).asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r10, "klass.classId.asSingleFqName()");
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public /* bridge */ /* synthetic */ Collection getInnerClassNames() {
        return getInnerClassNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<Name> getInnerClassNames() {
        Class<?>[] r10 = this.klass.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(r10, "klass.declaredClasses");
        return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filterNot(ArraysKt.asSequence(r10), ReflectJavaClass$innerClassNames$1.INSTANCE), ReflectJavaClass$innerClassNames$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public LightClassOriginKind getLightClassOriginKind() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public /* bridge */ /* synthetic */ Collection getMethods() {
        return getMethods();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public List<ReflectJavaMethod> getMethods() {
        Method[] r10 = this.klass.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(r10, "klass.declaredMethods");
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filter(ArraysKt.asSequence(r10), new ReflectJavaClass$methods$1(this)), ReflectJavaClass$methods$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return this.klass.getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public Name getName() {
        Name r10 = Name.identifier(this.klass.getSimpleName());
        Intrinsics.checkNotNullExpressionValue(r10, "identifier(klass.simpleName)");
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public ReflectJavaClass getOuterClass() {
        Class<?> r10 = this.klass.getDeclaringClass();
        if (r10 != null) goto L7;
        return null;
    L7:
        return new ReflectJavaClass(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public /* bridge */ /* synthetic */ JavaClass getOuterClass() {
        return getOuterClass();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public Collection<JavaClassifierType> getPermittedTypes() {
        Class<?>[] r10 = Java16SealedRecordLoader.INSTANCE.loadGetPermittedSubclasses(this.klass);
        if (r10 == null) goto L8;
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = 0;
        int r13 = r10.length;
    L5:
        if (r12 >= r13) goto L10;
        r11.add(new ReflectJavaClassifierType(r10[r12]));
        r12 = r12 + 1;
        goto L5
    L10:
        return r11;
    L8:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public Collection<JavaRecordComponent> getRecordComponents() {
        Object[] r10 = Java16SealedRecordLoader.INSTANCE.loadGetRecordComponents(this.klass);
        int r11 = 0;
        if (r10 != null) goto L5;
        r10 = new Object[0];
    L5:
        ArrayList r12 = new ArrayList(r10.length);
        int r13 = r10.length;
    L6:
        if (r11 >= r13) goto L8;
        r12.add(new ReflectJavaRecordComponent(r10[r11]));
        r11 = r11 + 1;
        goto L6
    L8:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public Collection<JavaClassifierType> getSupertypes() {
        Type r10 = Object.class;
        if (Intrinsics.areEqual(this.klass, r10) == true) goto L5;
        SpreadBuilder r11 = new SpreadBuilder(2);
        Type r12 = this.klass.getGenericSuperclass();
        if (r12 == null) goto L10;
        r10 = r12;
    L10:
        r11.add(r10);
        Type[] r13 = this.klass.getGenericInterfaces();
        Intrinsics.checkNotNullExpressionValue(r13, "klass.genericInterfaces");
        r11.addSpread(r13);
        List r14 = CollectionsKt.listOf(r11.toArray(new Type[r11.size()]));
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        r15.add(new ReflectJavaClassifierType((Type) r16.next()));
        goto L12
    L14:
        return r15;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Class<?>>[] r10 = this.klass.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r10, "klass.typeParameters");
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(new ReflectJavaTypeParameter(r10[r13]));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public Visibility getVisibility() {
        return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
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
        return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isAnnotationType() {
        return this.klass.isAnnotation();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isEnum() {
        return this.klass.isEnum();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isInterface() {
        return this.klass.isInterface();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isRecord() {
        Boolean r10 = Java16SealedRecordLoader.INSTANCE.loadIsRecord(this.klass);
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isSealed() {
        Boolean r10 = Java16SealedRecordLoader.INSTANCE.loadIsSealed(this.klass);
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
    }

    public String toString() {
        return ReflectJavaClass.class.getName() + ": " + this.klass;
    }
}
