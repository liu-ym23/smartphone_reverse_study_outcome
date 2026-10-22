package kotlin.reflect.jvm.internal.impl.types.checker;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.DynamicType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RawTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContextKt;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public interface ClassicTypeSystemContext extends TypeSystemCommonBackendContext, TypeSystemInferenceExtensionContext {

    public static final class DefaultImpls {
        public static boolean areEqualTypeConstructors(ClassicTypeSystemContext r10, TypeConstructorMarker r11, TypeConstructorMarker r12) {
            Intrinsics.checkNotNullParameter(r11, "c1");
            Intrinsics.checkNotNullParameter(r12, "c2");
            if ((r11 instanceof TypeConstructor) == false) goto L11;
            if ((r12 instanceof TypeConstructor) == false) goto L9;
            return Intrinsics.areEqual(r11, r12);
        L9:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r12 + ", " + Reflection.getOrCreateKotlinClass(r12.getClass())).toString());
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static int argumentsCount(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof KotlinType) == false) goto L7;
            return ((KotlinType) r11).getArguments().size();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static TypeArgumentListMarker asArgumentList(ClassicTypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof SimpleType) == false) goto L7;
            return (TypeArgumentListMarker) r11;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static CapturedTypeMarker asCapturedType(ClassicTypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof SimpleType) == false) goto L13;
            if ((r11 instanceof SimpleTypeWithEnhancement) == false) goto L8;
            return r10.asCapturedType(((SimpleTypeWithEnhancement) r11).getOrigin());
        L8:
            if ((r11 instanceof NewCapturedType) == true) goto L15;
            return null;
        L15:
            return (NewCapturedType) r11;
        L13:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static DefinitelyNotNullTypeMarker asDefinitelyNotNullType(ClassicTypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof SimpleType) == false) goto L10;
            if ((r11 instanceof DefinitelyNotNullType) == true) goto L11;
            return null;
        L11:
            return (DefinitelyNotNullType) r11;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static DynamicTypeMarker asDynamicType(ClassicTypeSystemContext r10, FlexibleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof FlexibleType) == false) goto L10;
            if ((r11 instanceof DynamicType) == true) goto L11;
            return null;
        L11:
            return (DynamicType) r11;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static FlexibleTypeMarker asFlexibleType(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof KotlinType) == false) goto L10;
            UnwrappedType r12 = ((KotlinType) r11).unwrap();
            if ((r12 instanceof FlexibleType) == true) goto L11;
            return null;
        L11:
            return (FlexibleType) r12;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static RawTypeMarker asRawType(ClassicTypeSystemContext r10, FlexibleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof FlexibleType) == false) goto L10;
            if ((r11 instanceof RawType) == true) goto L11;
            return null;
        L11:
            return (RawType) r11;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static SimpleTypeMarker asSimpleType(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof KotlinType) == false) goto L10;
            UnwrappedType r12 = ((KotlinType) r11).unwrap();
            if ((r12 instanceof SimpleType) == true) goto L11;
            return null;
        L11:
            return (SimpleType) r12;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static TypeArgumentMarker asTypeArgument(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof KotlinType) == false) goto L7;
            return TypeUtilsKt.asTypeProjection((KotlinType) r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static SimpleTypeMarker captureFromArguments(ClassicTypeSystemContext r10, SimpleTypeMarker r11, CaptureStatus r12) {
            Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
            Intrinsics.checkNotNullParameter(r12, "status");
            if ((r11 instanceof SimpleType) == false) goto L7;
            return NewCapturedTypeKt.captureFromArguments((SimpleType) r11, r12);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static CaptureStatus captureStatus(ClassicTypeSystemContext r10, CapturedTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof NewCapturedType) == false) goto L7;
            return ((NewCapturedType) r11).getCaptureStatus();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static KotlinTypeMarker createFlexibleType(ClassicTypeSystemContext r10, SimpleTypeMarker r11, SimpleTypeMarker r12) {
            Intrinsics.checkNotNullParameter(r11, "lowerBound");
            Intrinsics.checkNotNullParameter(r12, "upperBound");
            if ((r11 instanceof SimpleType) == false) goto L11;
            if ((r12 instanceof SimpleType) == false) goto L9;
            return KotlinTypeFactory.flexibleType((SimpleType) r11, (SimpleType) r12);
        L9:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(ClassicTypeSystemContext r10, SimpleTypeMarker r11, TypeConstructorMarker r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            Intrinsics.checkNotNullParameter(r12, "constructor");
            return TypeSystemInferenceExtensionContext.DefaultImpls.fastCorrespondingSupertypes(r10, r11, r12);
        }

        public static TypeArgumentMarker get(ClassicTypeSystemContext r10, TypeArgumentListMarker r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.get(r10, r11, r12);
        }

        public static TypeArgumentMarker getArgument(ClassicTypeSystemContext r10, KotlinTypeMarker r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof KotlinType) == false) goto L7;
            return ((KotlinType) r11).getArguments().get(r12);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static TypeArgumentMarker getArgumentOrNull(ClassicTypeSystemContext r10, SimpleTypeMarker r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.getArgumentOrNull(r10, r11, r12);
        }

        public static List<TypeArgumentMarker> getArguments(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof KotlinType) == false) goto L7;
            return ((KotlinType) r11).getArguments();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static FqNameUnsafe getClassFqNameUnsafe(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L7;
            ClassifierDescriptor r12 = ((TypeConstructor) r11).mo1323getDeclarationDescriptor();
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return DescriptorUtilsKt.getFqNameUnsafe((ClassDescriptor) r12);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static TypeParameterMarker getParameter(ClassicTypeSystemContext r10, TypeConstructorMarker r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L7;
            TypeParameterDescriptor r13 = ((TypeConstructor) r11).getParameters().get(r12);
            Intrinsics.checkNotNullExpressionValue(r13, "this.parameters[index]");
            return r13;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static List<TypeParameterMarker> getParameters(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L7;
            List<TypeParameterDescriptor> r12 = ((TypeConstructor) r11).getParameters();
            Intrinsics.checkNotNullExpressionValue(r12, "this.parameters");
            return r12;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static PrimitiveType getPrimitiveArrayType(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L7;
            ClassifierDescriptor r12 = ((TypeConstructor) r11).mo1323getDeclarationDescriptor();
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return KotlinBuiltIns.getPrimitiveArrayType((ClassDescriptor) r12);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static PrimitiveType getPrimitiveType(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L7;
            ClassifierDescriptor r12 = ((TypeConstructor) r11).mo1323getDeclarationDescriptor();
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return KotlinBuiltIns.getPrimitiveType((ClassDescriptor) r12);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static KotlinTypeMarker getRepresentativeUpperBound(ClassicTypeSystemContext r10, TypeParameterMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeParameterDescriptor) == false) goto L7;
            return TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static KotlinTypeMarker getType(ClassicTypeSystemContext r10, TypeArgumentMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeProjection) == false) goto L7;
            return ((TypeProjection) r11).getType().unwrap();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static TypeParameterMarker getTypeParameter(ClassicTypeSystemContext r10, TypeVariableTypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof NewTypeVariableConstructor) == false) goto L7;
            return ((NewTypeVariableConstructor) r11).getOriginalTypeParameter();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static TypeParameterMarker getTypeParameterClassifier(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L10;
            ClassifierDescriptor r12 = ((TypeConstructor) r11).mo1323getDeclarationDescriptor();
            if ((r12 instanceof TypeParameterDescriptor) == true) goto L11;
            return null;
        L11:
            return (TypeParameterDescriptor) r12;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static KotlinTypeMarker getUnsubstitutedUnderlyingType(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof KotlinType) == false) goto L7;
            return InlineClassesUtilsKt.unsubstitutedUnderlyingType((KotlinType) r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static List<KotlinTypeMarker> getUpperBounds(ClassicTypeSystemContext r10, TypeParameterMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeParameterDescriptor) == false) goto L7;
            List<KotlinType> r12 = ((TypeParameterDescriptor) r11).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(r12, "this.upperBounds");
            return r12;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static TypeVariance getVariance(ClassicTypeSystemContext r10, TypeArgumentMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeProjection) == false) goto L7;
            Variance r12 = ((TypeProjection) r11).getProjectionKind();
            Intrinsics.checkNotNullExpressionValue(r12, "this.projectionKind");
            return TypeSystemContextKt.convertVariance(r12);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static TypeVariance getVariance(ClassicTypeSystemContext r10, TypeParameterMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeParameterDescriptor) == false) goto L7;
            Variance r12 = ((TypeParameterDescriptor) r11).getVariance();
            Intrinsics.checkNotNullExpressionValue(r12, "this.variance");
            return TypeSystemContextKt.convertVariance(r12);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean hasAnnotation(ClassicTypeSystemContext r10, KotlinTypeMarker r11, FqName r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            Intrinsics.checkNotNullParameter(r12, "fqName");
            if ((r11 instanceof KotlinType) == false) goto L7;
            return ((KotlinType) r11).getAnnotations().hasAnnotation(r12);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean hasFlexibleNullability(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.hasFlexibleNullability(r10, r11);
        }

        public static boolean hasRecursiveBounds(ClassicTypeSystemContext r10, TypeParameterMarker r11, TypeConstructorMarker r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeParameterDescriptor) == false) goto L13;
            if (r12 != null) goto L6;
            boolean r13 = true;
        L7:
            if (r13 == false) goto L11;
            return TypeUtilsKt.hasTypeParameterRecursiveBounds$default((TypeParameterDescriptor) r11, (TypeConstructor) r12, null, 4, null);
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        L6:
            r13 = r12 instanceof TypeConstructor;
            goto L7
        L13:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean identicalArguments(ClassicTypeSystemContext r10, SimpleTypeMarker r11, SimpleTypeMarker r12) {
            Intrinsics.checkNotNullParameter(r11, "a");
            Intrinsics.checkNotNullParameter(r12, "b");
            if ((r11 instanceof SimpleType) == false) goto L14;
            if ((r12 instanceof SimpleType) == false) goto L12;
            if (((SimpleType) r11).getArguments() != ((SimpleType) r12).getArguments()) goto L9;
            return true;
        L9:
            return false;
        L12:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r12 + ", " + Reflection.getOrCreateKotlinClass(r12.getClass())).toString());
        L14:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static KotlinTypeMarker intersectTypes(ClassicTypeSystemContext r10, List<? extends KotlinTypeMarker> r11) {
            Intrinsics.checkNotNullParameter(r11, "types");
            return IntersectionTypeKt.intersectTypes(r11);
        }

        public static boolean isAnyConstructor(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L7;
            return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) r11, StandardNames.FqNames.any);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean isCapturedType(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isCapturedType(r10, r11);
        }

        public static boolean isClassType(ClassicTypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isClassType(r10, r11);
        }

        public static boolean isClassTypeConstructor(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L7;
            return ((TypeConstructor) r11).mo1323getDeclarationDescriptor() instanceof ClassDescriptor;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean isCommonFinalClassConstructor(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L20;
            ClassifierDescriptor r12 = ((TypeConstructor) r11).mo1323getDeclarationDescriptor();
            if ((r12 instanceof ClassDescriptor) == false) goto L7;
            ClassDescriptor r13 = (ClassDescriptor) r12;
        L9:
            if (r13 != null) goto L12;
            return false;
        L12:
            if (ModalityUtilsKt.isFinalClass(r13) == true) goto L14;
            return false;
        L14:
            if (r13.getKind() != ClassKind.ENUM_ENTRY) goto L16;
            return false;
        L16:
            if (r13.getKind() == ClassKind.ANNOTATION_CLASS) goto L23;
            return true;
        L23:
            return false;
        L7:
            r13 = null;
            goto L9
        L20:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean isDefinitelyNotNullType(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isDefinitelyNotNullType(r10, r11);
        }

        public static boolean isDenotable(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L7;
            return ((TypeConstructor) r11).isDenotable();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean isDynamic(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isDynamic(r10, r11);
        }

        public static boolean isError(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof KotlinType) == false) goto L7;
            return KotlinTypeKt.isError((KotlinType) r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean isInlineClass(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L13;
            ClassifierDescriptor r12 = ((TypeConstructor) r11).mo1323getDeclarationDescriptor();
            ValueClassRepresentation<SimpleType> r13 = null;
            if ((r12 instanceof ClassDescriptor) == false) goto L7;
            ClassDescriptor r14 = (ClassDescriptor) r12;
        L8:
            if (r14 == null) goto L11;
            r13 = r14.getValueClassRepresentation();
        L11:
            return r13 instanceof InlineClassRepresentation;
        L7:
            r14 = null;
            goto L8
        L13:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean isIntegerLiteralType(ClassicTypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isIntegerLiteralType(r10, r11);
        }

        public static boolean isIntegerLiteralTypeConstructor(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L7;
            return r11 instanceof IntegerLiteralTypeConstructor;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean isIntersection(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L7;
            return r11 instanceof IntersectionTypeConstructor;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isMarkedNullable(r10, r11);
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof SimpleType) == false) goto L7;
            return ((SimpleType) r11).isMarkedNullable();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean isNotNullTypeParameter(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return r11 instanceof NotNullTypeParameter;
        }

        public static boolean isNothing(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isNothing(r10, r11);
        }

        public static boolean isNothingConstructor(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L7;
            return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) r11, StandardNames.FqNames.nothing);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean isNullableType(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof KotlinType) == false) goto L7;
            return TypeUtils.isNullableType((KotlinType) r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean isOldCapturedType(ClassicTypeSystemContext r10, CapturedTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return r11 instanceof CapturedType;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isPrimitiveType(ClassicTypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof KotlinType) == false) goto L7;
            return KotlinBuiltIns.isPrimitiveType((KotlinType) r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean isProjectionNotNull(ClassicTypeSystemContext r10, CapturedTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof NewCapturedType) == false) goto L7;
            return ((NewCapturedType) r11).isProjectionNotNull();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isSingleClassifierType(ClassicTypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof SimpleType) == false) goto L24;
            if (KotlinTypeKt.isError((KotlinType) r11) == true) goto L21;
            SimpleType r12 = (SimpleType) r11;
            if ((r12.getConstructor().mo1323getDeclarationDescriptor() instanceof TypeAliasDescriptor) == true) goto L21;
            if (r12.getConstructor().mo1323getDeclarationDescriptor() == null) goto L11;
        L20:
            return true;
        L11:
            if ((r11 instanceof CapturedType) == true) goto L20;
            if ((r11 instanceof NewCapturedType) == true) goto L20;
            if ((r11 instanceof DefinitelyNotNullType) == true) goto L20;
            if ((r12.getConstructor() instanceof IntegerLiteralTypeConstructor) == true) goto L20;
            if (isSingleClassifierTypeWithEnhancement(r10, r11) == true) goto L20;
        L21:
            return false;
        L24:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        private static boolean isSingleClassifierTypeWithEnhancement(ClassicTypeSystemContext r10, SimpleTypeMarker r11) {
            if ((r11 instanceof SimpleTypeWithEnhancement) == true) goto L5;
        L7:
            return false;
        L5:
            if (r10.isSingleClassifierType(((SimpleTypeWithEnhancement) r11).getOrigin()) == false) goto L7;
            return true;
        }

        public static boolean isStarProjection(ClassicTypeSystemContext r10, TypeArgumentMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeProjection) == false) goto L7;
            return ((TypeProjection) r11).isStarProjection();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isStubType(ClassicTypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof SimpleType) == false) goto L7;
            return TypeUtilsKt.isStubType((KotlinType) r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isStubTypeForBuilderInference(ClassicTypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof SimpleType) == false) goto L7;
            return TypeUtilsKt.isStubTypeForBuilderInference((KotlinType) r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static boolean isTypeVariableType(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof UnwrappedType) == true) goto L5;
        L7:
            return false;
        L5:
            if ((((UnwrappedType) r11).getConstructor() instanceof NewTypeVariableConstructor) == false) goto L7;
            return true;
        }

        public static boolean isUnderKotlinPackage(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L12;
            ClassifierDescriptor r12 = ((TypeConstructor) r11).mo1323getDeclarationDescriptor();
            if (r12 == null) goto L10;
            if (KotlinBuiltIns.isUnderKotlinPackage(r12) != true) goto L10;
            return true;
        L10:
            return false;
        L12:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static SimpleTypeMarker lowerBound(ClassicTypeSystemContext r10, FlexibleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof FlexibleType) == false) goto L7;
            return ((FlexibleType) r11).getLowerBound();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static SimpleTypeMarker lowerBoundIfFlexible(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.lowerBoundIfFlexible(r10, r11);
        }

        public static KotlinTypeMarker lowerType(ClassicTypeSystemContext r10, CapturedTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof NewCapturedType) == false) goto L7;
            return ((NewCapturedType) r11).getLowerType();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static KotlinTypeMarker makeDefinitelyNotNullOrNotNull(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof UnwrappedType) == false) goto L7;
            return ClassicTypeSystemContextKt.access$makeDefinitelyNotNullOrNotNullInternal((UnwrappedType) r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static KotlinTypeMarker makeNullable(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemCommonBackendContext.DefaultImpls.makeNullable(r10, r11);
        }

        public static TypeCheckerState newTypeCheckerState(ClassicTypeSystemContext r10, boolean r11, boolean r12) {
            return ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(r11, r12, r10, null, null, 24, null);
        }

        public static SimpleTypeMarker original(ClassicTypeSystemContext r10, DefinitelyNotNullTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof DefinitelyNotNullType) == false) goto L7;
            return ((DefinitelyNotNullType) r11).getOriginal();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static int parametersCount(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L7;
            return ((TypeConstructor) r11).getParameters().size();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static Collection<KotlinTypeMarker> possibleIntegerTypes(ClassicTypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            TypeConstructorMarker r12 = r10.typeConstructor(r11);
            if ((r12 instanceof IntegerLiteralTypeConstructor) == false) goto L7;
            return ((IntegerLiteralTypeConstructor) r12).getPossibleTypes();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static TypeArgumentMarker projection(ClassicTypeSystemContext r10, CapturedTypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof NewCapturedTypeConstructor) == false) goto L7;
            return ((NewCapturedTypeConstructor) r11).getProjection();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static int size(ClassicTypeSystemContext r10, TypeArgumentListMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.size(r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(final ClassicTypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
            if ((r11 instanceof SimpleType) == false) goto L7;
            final TypeSubstitutor r12 = TypeConstructorSubstitution.Companion.create((KotlinType) r11).buildSubstitutor();
            return new ClassicTypeSystemContext$substitutionSupertypePolicy$2(r10, r12);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static Collection<KotlinTypeMarker> supertypes(ClassicTypeSystemContext r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof TypeConstructor) == false) goto L7;
            Collection<KotlinType> r12 = ((TypeConstructor) r11).mo1324getSupertypes();
            Intrinsics.checkNotNullExpressionValue(r12, "this.supertypes");
            return r12;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static CapturedTypeConstructorMarker typeConstructor(ClassicTypeSystemContext r10, CapturedTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof NewCapturedType) == false) goto L7;
            return ((NewCapturedType) r11).getConstructor();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.typeConstructor(r10, r11);
        }

        public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof SimpleType) == false) goto L7;
            return ((SimpleType) r11).getConstructor();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static SimpleTypeMarker upperBound(ClassicTypeSystemContext r10, FlexibleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof FlexibleType) == false) goto L7;
            return ((FlexibleType) r11).getUpperBound();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static SimpleTypeMarker upperBoundIfFlexible(ClassicTypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.upperBoundIfFlexible(r10, r11);
        }

        public static KotlinTypeMarker withNullability(ClassicTypeSystemContext r10, KotlinTypeMarker r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof SimpleTypeMarker) == false) goto L6;
            return r10.withNullability((SimpleTypeMarker) r11, r12);
        L6:
            if ((r11 instanceof FlexibleTypeMarker) == false) goto L10;
            FlexibleTypeMarker r13 = (FlexibleTypeMarker) r11;
            return r10.createFlexibleType(r10.withNullability(r10.lowerBound(r13), r12), r10.withNullability(r10.upperBound(r13), r12));
        L10:
            throw new IllegalStateException("sealed".toString());
        }

        public static SimpleTypeMarker withNullability(ClassicTypeSystemContext r10, SimpleTypeMarker r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof SimpleType) == false) goto L7;
            return ((SimpleType) r11).makeNullableAsSpecified(r12);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    CapturedTypeMarker asCapturedType(SimpleTypeMarker r10);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker asSimpleType(KotlinTypeMarker r10);

    KotlinTypeMarker createFlexibleType(SimpleTypeMarker r10, SimpleTypeMarker r11);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    boolean isSingleClassifierType(SimpleTypeMarker r10);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker lowerBound(FlexibleTypeMarker r10);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    TypeConstructorMarker typeConstructor(SimpleTypeMarker r10);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker upperBound(FlexibleTypeMarker r10);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker withNullability(SimpleTypeMarker r10, boolean r11);
}
