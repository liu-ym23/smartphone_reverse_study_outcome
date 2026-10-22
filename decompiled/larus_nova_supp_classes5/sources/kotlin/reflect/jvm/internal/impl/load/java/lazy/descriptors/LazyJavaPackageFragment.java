package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.utils.DeserializationHelpersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class LazyJavaPackageFragment extends PackageFragmentDescriptorImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final Annotations annotations;
    private final NotNullLazyValue binaryClasses$delegate;
    private final LazyJavaResolverContext c;
    private final JavaPackage jPackage;
    private final JvmMetadataVersion jvmMetadataVersion;
    private final NotNullLazyValue partToFacade$delegate;
    private final JvmPackageScope scope;
    private final NotNullLazyValue<List<FqName>> subPackages;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    }

    public static /* synthetic */ Map accessor$LazyJavaPackageFragment$lambda0(LazyJavaPackageFragment r0) {
        return binaryClasses_delegate$lambda$2(r0);
    }

    public static /* synthetic */ List accessor$LazyJavaPackageFragment$lambda1(LazyJavaPackageFragment r0) {
        return subPackages$lambda$3(r0);
    }

    public static /* synthetic */ HashMap accessor$LazyJavaPackageFragment$lambda2(LazyJavaPackageFragment r0) {
        return partToFacade_delegate$lambda$4(r0);
    }

    public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm() {
        return (Map) StorageKt.getValue(this.binaryClasses$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }

    public final List<FqName> getSubPackageFqNames$descriptors_jvm() {
        return (List) this.subPackages.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "Lazy Java package fragment: " + getFqName() + " of module " + this.c.getComponents().getModule();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public /* bridge */ /* synthetic */ MemberScope getMemberScope() {
        return getMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public JvmPackageScope getMemberScope() {
        return this.scope;
    }

    private static final Map binaryClasses_delegate$lambda$2(LazyJavaPackageFragment r6) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        List<String> r0 = r6.c.getComponents().getPackagePartProvider().findPackageParts(r6.getFqName().asString());
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        String r3 = (String) r2.next();
        ClassId r4 = ClassId.Companion.topLevel(JvmClassName.byInternalName(r3).getFqNameForTopLevelClassMaybeWithDollars());
        KotlinJvmBinaryClass r5 = KotlinClassFinderKt.findKotlinClass(r6.c.getComponents().getKotlinClassFinder(), r4, r6.jvmMetadataVersion);
        if (r5 == null) goto L8;
        Pair r7 = TuplesKt.to(r3, r5);
    L9:
        if (r7 == null) goto L4;
        r1.add(r7);
        goto L4
    L8:
        r7 = null;
        goto L9
    L12:
        return MapsKt.toMap(r1);
    }

    private static final HashMap partToFacade_delegate$lambda$4(LazyJavaPackageFragment r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, KotlinJvmBinaryClass>> r6 = r5.getBinaryClasses$descriptors_jvm().entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L15;
        Map.Entry<String, KotlinJvmBinaryClass> r1 = r6.next();
        String r2 = r1.getKey();
        KotlinJvmBinaryClass r3 = r1.getValue();
        JvmClassName r4 = JvmClassName.byInternalName(r2);
        KotlinClassHeader r7 = r3.getClassHeader();
        KotlinClassHeader.Kind r8 = r7.getKind();
        int r9 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];
        if (r9 != 1) goto L8;
        String r10 = r7.getMultifileClassName();
        if (r10 == null) goto L4;
        r0.put(r4, JvmClassName.byInternalName(r10));
        goto L4
    L8:
        if (r9 != 2) goto L4;
        r0.put(r4, r4);
        goto L4
    L15:
        return r0;
    }

    private static final List subPackages$lambda$3(LazyJavaPackageFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Collection<JavaPackage> r3 = r2.jPackage.getSubPackages();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(((JavaPackage) r4.next()).getFqName());
        goto L4
    L6:
        return r0;
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(JavaClass r2) {
        Intrinsics.checkNotNullParameter(r2, "jClass");
        return this.scope.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(r2);
    }

    public LazyJavaPackageFragment(LazyJavaResolverContext r9, JavaPackage r10) {
        Intrinsics.checkNotNullParameter(r9, "outerContext");
        Intrinsics.checkNotNullParameter(r10, "jPackage");
        super(r9.getModule(), r10.getFqName());
        this.jPackage = r10;
        LazyJavaResolverContext r0 = ContextKt.childForClassOrPackage$default(r9, this, null, 0, 6, null);
        this.c = r0;
        this.jvmMetadataVersion = DeserializationHelpersKt.jvmMetadataVersionOrDefault(r9.getComponents().getDeserializedDescriptorResolver().getComponents().getConfiguration());
        this.binaryClasses$delegate = r0.getStorageManager().createLazyValue(new LazyJavaPackageFragment$$Lambda$0(this));
        this.scope = new JvmPackageScope(r0, r10, this);
        this.subPackages = r0.getStorageManager().createRecursionTolerantLazyValue(new LazyJavaPackageFragment$$Lambda$1(this), CollectionsKt.emptyList());
        if (r0.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations() == false) goto L5;
        Annotations r11 = Annotations.Companion.getEMPTY();
    L6:
        this.annotations = r11;
        this.partToFacade$delegate = r0.getStorageManager().createLazyValue(new LazyJavaPackageFragment$$Lambda$2(this));
        return;
    L5:
        r11 = LazyJavaAnnotationsKt.resolveAnnotations(r0, r10);
        goto L6
    }
}
