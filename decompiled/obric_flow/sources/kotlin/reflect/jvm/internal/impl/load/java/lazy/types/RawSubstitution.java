package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErasureProjectionComputer;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nRawSubstitution.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RawSubstitution.kt\norg/jetbrains/kotlin/load/java/lazy/types/RawSubstitution\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,95:1\n1549#2:96\n1620#2,3:97\n*S KotlinDebug\n*F\n+ 1 RawSubstitution.kt\norg/jetbrains/kotlin/load/java/lazy/types/RawSubstitution\n*L\n73#1:96\n73#1:97,3\n*E\n"})
public final class RawSubstitution extends TypeSubstitution {
    public static final Companion Companion = null;
    private static final JavaTypeAttributes lowerTypeAttr = null;
    private static final JavaTypeAttributes upperTypeAttr = null;
    private final RawProjectionComputer projectionComputer;
    private final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        TypeUsage r5 = TypeUsage.COMMON;
        lowerTypeAttr = JavaTypeAttributesKt.toAttributes$default(r5, false, true, null, 5, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
        upperTypeAttr = JavaTypeAttributesKt.toAttributes$default(r5, false, true, null, 5, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RawSubstitution() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ Pair access$eraseInflexibleBasedOnClassDescriptor(RawSubstitution r5, SimpleType r10, ClassDescriptor r11, JavaTypeAttributes r12) {
        return r5.eraseInflexibleBasedOnClassDescriptor(r10, r11, r12);
    }

    private final Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor(final SimpleType r17, final ClassDescriptor r18, final JavaTypeAttributes r19) {
        if (r17.getConstructor().getParameters().isEmpty() == false) goto L7;
        return TuplesKt.to(r17, Boolean.FALSE);
    L7:
        if (KotlinBuiltIns.isArray(r17) == false) goto L11;
        TypeProjection r5 = r17.getArguments().get(0);
        List r10 = CollectionsKt.listOf(new TypeProjectionImpl(r5.getProjectionKind(), eraseType(r5.getType(), r19)));
        return TuplesKt.to(KotlinTypeFactory.simpleType$default(r17.getAttributes(), r17.getConstructor(), r10, r17.isMarkedNullable(), null, 16, null), Boolean.FALSE);
    L11:
        if (KotlinTypeKt.isError(r17) == true) goto L13;
        MemberScope r11 = r18.getMemberScope(this);
        TypeAttributes r12 = r17.getAttributes();
        TypeConstructor r13 = r18.getTypeConstructor();
        List<TypeParameterDescriptor> r14 = r18.getTypeConstructor().getParameters();
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator<T> r16 = r14.iterator();
    L16:
        if (r16.hasNext() == false) goto L19;
        TypeParameterDescriptor r20 = (TypeParameterDescriptor) r16.next();
        r15.add(ErasureProjectionComputer.computeProjection$default(this.projectionComputer, r20, r19, this.typeParameterUpperBoundEraser, null, 8, null));
        goto L16
    L19:
        return TuplesKt.to(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r12, r13, r15, r17.isMarkedNullable(), r11, new AnonymousClass2(r18, this, r17, r19)), Boolean.TRUE);
    L13:
        return TuplesKt.to(ErrorUtils.createErrorType(ErrorTypeKind.ERROR_RAW_TYPE, new String[]{r17.getConstructor().toString()}), Boolean.FALSE);
    }

    private final KotlinType eraseType(KotlinType r5, JavaTypeAttributes r10) {
        ClassifierDescriptor r11 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if ((r11 instanceof TypeParameterDescriptor) == false) goto L6;
        return eraseType(this.typeParameterUpperBoundEraser.getErasedUpperBound((TypeParameterDescriptor) r11, r10.markIsRaw(true)), r10);
    L6:
        if ((r11 instanceof ClassDescriptor) == false) goto L19;
        ClassifierDescriptor r12 = FlexibleTypesKt.upperIfFlexible(r5).getConstructor().mo1402getDeclarationDescriptor();
        if ((r12 instanceof ClassDescriptor) == false) goto L17;
        Pair<SimpleType, Boolean> r13 = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.lowerIfFlexible(r5), (ClassDescriptor) r11, lowerTypeAttr);
        SimpleType r14 = r13.component1();
        boolean r15 = r13.component2().booleanValue();
        Pair<SimpleType, Boolean> r16 = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.upperIfFlexible(r5), (ClassDescriptor) r12, upperTypeAttr);
        SimpleType r17 = r16.component1();
        boolean r18 = r16.component2().booleanValue();
        if (r15 == true) goto L15;
        if (r18 == true) goto L15;
        return KotlinTypeFactory.flexibleType(r14, r17);
    L15:
        return new RawTypeImpl(r14, r17);
    L17:
        throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + r12 + "\" while for lower it's \"" + r11 + Typography.quote).toString());
    L19:
        throw new IllegalStateException(("Unexpected declaration kind: " + r11).toString());
    }

    public static /* synthetic */ KotlinType eraseType$default(RawSubstitution r10, KotlinType r11, JavaTypeAttributes r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = new JavaTypeAttributes(TypeUsage.COMMON, null, false, false, null, null, 62, null);
    L6:
        return r10.eraseType(r11, r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public /* bridge */ /* synthetic */ TypeProjection mo1407get(KotlinType r5) {
        return mo1407get(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    public RawSubstitution(TypeParameterUpperBoundEraser r5) {
        RawProjectionComputer r10 = new RawProjectionComputer();
        this.projectionComputer = r10;
        if (r5 != null) goto L5;
        r5 = new TypeParameterUpperBoundEraser(r10, null, 2, null);
    L5:
        this.typeParameterUpperBoundEraser = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjectionImpl mo1407get(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return new TypeProjectionImpl(eraseType$default(this, r5, null, 2, null));
    }

    public /* synthetic */ RawSubstitution(TypeParameterUpperBoundEraser r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
