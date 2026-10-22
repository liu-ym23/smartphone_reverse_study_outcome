package kotlin.reflect.jvm.internal.impl.types.checker;

import androidx.core.app.NotificationCompat;
import java.util.Collection;
import java.util.List;
import kotlin.collections.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
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

    @SourceDebugExtension({"SMAP\nClassicTypeSystemContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassicTypeSystemContext.kt\norg/jetbrains/kotlin/types/checker/ClassicTypeSystemContext$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ClassicTypeSystemContext.kt\norg/jetbrains/kotlin/types/checker/ClassicTypeSystemContextKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n+ 6 TypeUtils.kt\norg/jetbrains/kotlin/types/typeUtil/TypeUtilsKt\n*L\n1#1,951:1\n1#2:952\n945#3:953\n945#3:954\n945#3:955\n945#3:956\n945#3:957\n945#3:958\n945#3:959\n945#3:960\n945#3:961\n945#3:962\n945#3:963\n945#3:964\n945#3:965\n945#3:966\n945#3:967\n945#3:968\n945#3:969\n945#3:970\n945#3:971\n945#3:972\n945#3:973\n945#3:974\n945#3:975\n945#3:976\n945#3:977\n945#3:978\n945#3:979\n945#3:980\n945#3:981\n945#3:982\n945#3:983\n945#3:984\n945#3:985\n945#3:986\n945#3:987\n945#3:988\n945#3:989\n945#3:990\n945#3:991\n945#3:992\n945#3:993\n945#3:994\n945#3:995\n945#3:996\n945#3:997\n945#3:998\n945#3:999\n945#3:1000\n945#3:1001\n945#3:1002\n945#3:1003\n945#3:1004\n945#3:1005\n945#3:1006\n945#3:1007\n945#3:1008\n945#3:1009\n945#3:1010\n945#3:1011\n945#3:1012\n945#3:1013\n945#3:1014\n945#3:1015\n945#3:1016\n945#3:1017\n945#3:1018\n945#3:1019\n945#3:1020\n945#3:1021\n945#3:1022\n945#3:1023\n945#3:1024\n945#3:1025\n945#3:1029\n945#3:1030\n945#3:1031\n945#3:1032\n945#3:1033\n945#3:1034\n945#3:1035\n945#3:1036\n945#3:1042\n945#3:1043\n945#3:1044\n945#3:1045\n945#3:1046\n945#3:1047\n945#3:1054\n945#3:1055\n945#3:1056\n945#3:1071\n945#3:1072\n945#3:1073\n945#3:1074\n945#3:1075\n945#3:1076\n945#3:1090\n945#3:1091\n945#3:1092\n945#3:1093\n945#3:1094\n945#3:1095\n945#3:1096\n945#3:1097\n945#3:1098\n945#3:1099\n945#3:1100\n945#3:1101\n945#3:1102\n945#3:1103\n945#3:1104\n945#3:1105\n945#3:1106\n945#3:1107\n945#3:1108\n945#3:1109\n945#3:1110\n945#3:1111\n945#3:1112\n945#3:1113\n945#3:1114\n945#3:1115\n945#3:1116\n819#4:1026\n847#4,2:1027\n766#4:1039\n857#4,2:1040\n1549#4:1050\n1620#4,3:1051\n1549#4:1057\n1620#4,3:1058\n2661#4,7:1061\n819#4:1068\n847#4,2:1069\n819#4:1077\n847#4,2:1078\n1549#4:1080\n1620#4,3:1081\n1271#4,2:1084\n1285#4,4:1086\n20#5,2:1037\n280#6,2:1048\n*S KotlinDebug\n*F\n+ 1 ClassicTypeSystemContext.kt\norg/jetbrains/kotlin/types/checker/ClassicTypeSystemContext$DefaultImpls\n*L\n40#1:953\n45#1:954\n58#1:955\n63#1:956\n69#1:957\n75#1:958\n80#1:959\n85#1:960\n90#1:961\n95#1:962\n100#1:963\n105#1:964\n110#1:965\n119#1:966\n125#1:967\n130#1:968\n135#1:969\n136#1:970\n141#1:971\n146#1:972\n151#1:973\n156#1:974\n161#1:975\n166#1:976\n171#1:977\n176#1:978\n184#1:979\n189#1:980\n194#1:981\n199#1:982\n204#1:983\n209#1:984\n214#1:985\n219#1:986\n224#1:987\n229#1:988\n230#1:989\n235#1:990\n241#1:991\n246#1:992\n251#1:993\n256#1:994\n261#1:995\n266#1:996\n271#1:997\n276#1:998\n281#1:999\n286#1:1000\n287#1:1001\n293#1:1002\n294#1:1003\n299#1:1004\n304#1:1005\n309#1:1006\n315#1:1007\n323#1:1008\n329#1:1009\n334#1:1010\n339#1:1011\n344#1:1012\n349#1:1013\n354#1:1014\n368#1:1015\n378#1:1016\n383#1:1017\n409#1:1018\n414#1:1019\n419#1:1020\n420#1:1021\n460#1:1022\n466#1:1023\n471#1:1024\n476#1:1025\n482#1:1029\n487#1:1030\n504#1:1031\n510#1:1032\n515#1:1033\n520#1:1034\n527#1:1035\n538#1:1036\n561#1:1042\n566#1:1043\n571#1:1044\n578#1:1045\n583#1:1046\n589#1:1047\n595#1:1054\n617#1:1055\n618#1:1056\n674#1:1071\n679#1:1072\n684#1:1073\n689#1:1074\n694#1:1075\n699#1:1076\n737#1:1090\n742#1:1091\n747#1:1092\n752#1:1093\n757#1:1094\n762#1:1095\n767#1:1096\n772#1:1097\n777#1:1098\n782#1:1099\n787#1:1100\n792#1:1101\n797#1:1102\n802#1:1103\n807#1:1104\n812#1:1105\n817#1:1106\n822#1:1107\n827#1:1108\n836#1:1109\n837#1:1110\n848#1:1111\n853#1:1112\n858#1:1113\n863#1:1114\n881#1:1115\n888#1:1116\n477#1:1026\n477#1:1027,2\n546#1:1039\n546#1:1040,2\n591#1:1050\n591#1:1051,3\n660#1:1057\n660#1:1058,3\n660#1:1061,7\n666#1:1068\n666#1:1069,2\n700#1:1077\n700#1:1078,2\n725#1:1080\n725#1:1081,3\n726#1:1084,2\n726#1:1086,4\n540#1:1037,2\n591#1:1048,2\n*E\n"})
    public static final class DefaultImpls {
        public static boolean areEqualTypeConstructors(ClassicTypeSystemContext r5, TypeConstructorMarker r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r10, "c1");
            Intrinsics.checkNotNullParameter(r11, "c2");
            if ((r10 instanceof TypeConstructor) == false) goto L11;
            if ((r11 instanceof TypeConstructor) == false) goto L9;
            return Intrinsics.areEqual(r10, r11);
        L9:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static int argumentsCount(ClassicTypeSystemContext r5, KotlinTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof KotlinType) == false) goto L7;
            return ((KotlinType) r10).getArguments().size();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static TypeArgumentListMarker asArgumentList(ClassicTypeSystemContext r5, SimpleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof SimpleType) == true) goto L5;
            StringBuilder r11 = a.i("ClassicTypeSystemContext couldn't handle: ", r10, ", ");
            r11.append(Reflection.getOrCreateKotlinClass(r10.getClass()));
            throw new IllegalArgumentException(r11.toString().toString());
        L5:
            return (TypeArgumentListMarker) r10;
        }

        public static CapturedTypeMarker asCapturedType(ClassicTypeSystemContext r5, SimpleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof SimpleType) == true) goto L5;
            StringBuilder r11 = a.i("ClassicTypeSystemContext couldn't handle: ", r10, ", ");
            r11.append(Reflection.getOrCreateKotlinClass(r10.getClass()));
            throw new IllegalArgumentException(r11.toString().toString());
        L5:
            if ((r10 instanceof SimpleTypeWithEnhancement) == false) goto L8;
            return r5.asCapturedType(((SimpleTypeWithEnhancement) r10).getOrigin());
        L8:
            if ((r10 instanceof NewCapturedType) == true) goto L15;
            return null;
        L15:
            return (NewCapturedType) r10;
        }

        public static DefinitelyNotNullTypeMarker asDefinitelyNotNullType(ClassicTypeSystemContext r5, SimpleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof SimpleType) == true) goto L5;
            StringBuilder r11 = a.i("ClassicTypeSystemContext couldn't handle: ", r10, ", ");
            r11.append(Reflection.getOrCreateKotlinClass(r10.getClass()));
            throw new IllegalArgumentException(r11.toString().toString());
        L5:
            if ((r10 instanceof DefinitelyNotNullType) == true) goto L11;
            return null;
        L11:
            return (DefinitelyNotNullType) r10;
        }

        public static DynamicTypeMarker asDynamicType(ClassicTypeSystemContext r5, FlexibleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof FlexibleType) == false) goto L10;
            if ((r10 instanceof DynamicType) == true) goto L11;
            return null;
        L11:
            return (DynamicType) r10;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static FlexibleTypeMarker asFlexibleType(ClassicTypeSystemContext r5, KotlinTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof KotlinType) == false) goto L10;
            UnwrappedType r11 = ((KotlinType) r10).unwrap();
            if ((r11 instanceof FlexibleType) == true) goto L11;
            return null;
        L11:
            return (FlexibleType) r11;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static RawTypeMarker asRawType(ClassicTypeSystemContext r5, FlexibleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof FlexibleType) == false) goto L10;
            if ((r10 instanceof RawType) == true) goto L11;
            return null;
        L11:
            return (RawType) r10;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static SimpleTypeMarker asSimpleType(ClassicTypeSystemContext r5, KotlinTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof KotlinType) == false) goto L10;
            UnwrappedType r11 = ((KotlinType) r10).unwrap();
            if ((r11 instanceof SimpleType) == true) goto L11;
            return null;
        L11:
            return (SimpleType) r11;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static TypeArgumentMarker asTypeArgument(ClassicTypeSystemContext r5, KotlinTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof KotlinType) == false) goto L7;
            return TypeUtilsKt.asTypeProjection((KotlinType) r10);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static SimpleTypeMarker captureFromArguments(ClassicTypeSystemContext r5, SimpleTypeMarker r10, CaptureStatus r11) {
            Intrinsics.checkNotNullParameter(r10, "type");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_STATUS);
            if ((r10 instanceof SimpleType) == true) goto L5;
            StringBuilder r12 = a.i("ClassicTypeSystemContext couldn't handle: ", r10, ", ");
            r12.append(Reflection.getOrCreateKotlinClass(r10.getClass()));
            throw new IllegalArgumentException(r12.toString().toString());
        L5:
            return NewCapturedTypeKt.captureFromArguments((SimpleType) r10, r11);
        }

        public static CaptureStatus captureStatus(ClassicTypeSystemContext r5, CapturedTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof NewCapturedType) == false) goto L7;
            return ((NewCapturedType) r10).getCaptureStatus();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static KotlinTypeMarker createFlexibleType(ClassicTypeSystemContext r5, SimpleTypeMarker r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r10, "lowerBound");
            Intrinsics.checkNotNullParameter(r11, "upperBound");
            if ((r10 instanceof SimpleType) == false) goto L11;
            if ((r11 instanceof SimpleType) == false) goto L9;
            return KotlinTypeFactory.flexibleType((SimpleType) r10, (SimpleType) r11);
        L9:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r5 + ", " + Reflection.getOrCreateKotlinClass(r5.getClass())).toString());
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r5 + ", " + Reflection.getOrCreateKotlinClass(r5.getClass())).toString());
        }

        public static TypeArgumentMarker getArgument(ClassicTypeSystemContext r5, KotlinTypeMarker r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof KotlinType) == false) goto L7;
            return ((KotlinType) r10).getArguments().get(r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static List<TypeArgumentMarker> getArguments(ClassicTypeSystemContext r5, KotlinTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof KotlinType) == false) goto L7;
            return ((KotlinType) r10).getArguments();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static FqNameUnsafe getClassFqNameUnsafe(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L7;
            ClassifierDescriptor r11 = ((TypeConstructor) r10).mo1402getDeclarationDescriptor();
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return DescriptorUtilsKt.getFqNameUnsafe((ClassDescriptor) r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static TypeParameterMarker getParameter(ClassicTypeSystemContext r5, TypeConstructorMarker r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L7;
            return ((TypeConstructor) r10).getParameters().get(r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static List<TypeParameterMarker> getParameters(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L7;
            return ((TypeConstructor) r10).getParameters();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static PrimitiveType getPrimitiveArrayType(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L7;
            ClassifierDescriptor r11 = ((TypeConstructor) r10).mo1402getDeclarationDescriptor();
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return KotlinBuiltIns.getPrimitiveArrayType((ClassDescriptor) r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static PrimitiveType getPrimitiveType(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L7;
            ClassifierDescriptor r11 = ((TypeConstructor) r10).mo1402getDeclarationDescriptor();
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return KotlinBuiltIns.getPrimitiveType((ClassDescriptor) r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static KotlinTypeMarker getRepresentativeUpperBound(ClassicTypeSystemContext r5, TypeParameterMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeParameterDescriptor) == false) goto L7;
            return TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) r10);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static KotlinTypeMarker getType(ClassicTypeSystemContext r5, TypeArgumentMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeProjection) == false) goto L7;
            return ((TypeProjection) r10).getType().unwrap();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static TypeParameterMarker getTypeParameter(ClassicTypeSystemContext r5, TypeVariableTypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof NewTypeVariableConstructor) == false) goto L7;
            return ((NewTypeVariableConstructor) r10).getOriginalTypeParameter();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static TypeParameterMarker getTypeParameterClassifier(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L10;
            ClassifierDescriptor r11 = ((TypeConstructor) r10).mo1402getDeclarationDescriptor();
            if ((r11 instanceof TypeParameterDescriptor) == true) goto L11;
            return null;
        L11:
            return (TypeParameterDescriptor) r11;
        L10:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static KotlinTypeMarker getUnsubstitutedUnderlyingType(ClassicTypeSystemContext r5, KotlinTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof KotlinType) == false) goto L7;
            return InlineClassesUtilsKt.unsubstitutedUnderlyingType((KotlinType) r10);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static List<KotlinTypeMarker> getUpperBounds(ClassicTypeSystemContext r5, TypeParameterMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeParameterDescriptor) == false) goto L7;
            return ((TypeParameterDescriptor) r10).getUpperBounds();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static TypeVariance getVariance(ClassicTypeSystemContext r5, TypeArgumentMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeProjection) == false) goto L7;
            return TypeSystemContextKt.convertVariance(((TypeProjection) r10).getProjectionKind());
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static boolean hasAnnotation(ClassicTypeSystemContext r5, KotlinTypeMarker r10, FqName r11) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            Intrinsics.checkNotNullParameter(r11, "fqName");
            if ((r10 instanceof KotlinType) == false) goto L7;
            return ((KotlinType) r10).getAnnotations().hasAnnotation(r11);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static boolean hasRecursiveBounds(ClassicTypeSystemContext r5, TypeParameterMarker r10, TypeConstructorMarker r11) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeParameterDescriptor) == false) goto L13;
            if (r11 != null) goto L6;
            boolean r12 = true;
        L7:
            if (r12 == false) goto L11;
            return TypeUtilsKt.hasTypeParameterRecursiveBounds$default((TypeParameterDescriptor) r10, (TypeConstructor) r11, null, 4, null);
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        L6:
            r12 = r11 instanceof TypeConstructor;
            goto L7
        L13:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static boolean identicalArguments(ClassicTypeSystemContext r5, SimpleTypeMarker r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r10, "a");
            Intrinsics.checkNotNullParameter(r11, "b");
            if ((r10 instanceof SimpleType) == true) goto L5;
            StringBuilder r12 = a.i("ClassicTypeSystemContext couldn't handle: ", r10, ", ");
            r12.append(Reflection.getOrCreateKotlinClass(r10.getClass()));
            throw new IllegalArgumentException(r12.toString().toString());
        L5:
            if ((r11 instanceof SimpleType) == true) goto L7;
            StringBuilder r13 = a.i("ClassicTypeSystemContext couldn't handle: ", r11, ", ");
            r13.append(Reflection.getOrCreateKotlinClass(r11.getClass()));
            throw new IllegalArgumentException(r13.toString().toString());
        L7:
            if (((SimpleType) r10).getArguments() != ((SimpleType) r11).getArguments()) goto L9;
            return true;
        L9:
            return false;
        }

        public static KotlinTypeMarker intersectTypes(ClassicTypeSystemContext r5, List<? extends KotlinTypeMarker> r10) {
            Intrinsics.checkNotNullParameter(r10, "types");
            return IntersectionTypeKt.intersectTypes(r10);
        }

        public static boolean isAnyConstructor(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L7;
            return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) r10, StandardNames.FqNames.any);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static boolean isClassTypeConstructor(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L7;
            return ((TypeConstructor) r10).mo1402getDeclarationDescriptor() instanceof ClassDescriptor;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static boolean isCommonFinalClassConstructor(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L20;
            ClassifierDescriptor r11 = ((TypeConstructor) r10).mo1402getDeclarationDescriptor();
            if ((r11 instanceof ClassDescriptor) == false) goto L7;
            ClassDescriptor r12 = (ClassDescriptor) r11;
        L9:
            if (r12 != null) goto L12;
            return false;
        L12:
            if (ModalityUtilsKt.isFinalClass(r12) == true) goto L14;
            return false;
        L14:
            if (r12.getKind() != ClassKind.ENUM_ENTRY) goto L16;
            return false;
        L16:
            if (r12.getKind() == ClassKind.ANNOTATION_CLASS) goto L23;
            return true;
        L23:
            return false;
        L7:
            r12 = null;
            goto L9
        L20:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static boolean isDenotable(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L7;
            return ((TypeConstructor) r10).isDenotable();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static boolean isError(ClassicTypeSystemContext r5, KotlinTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof KotlinType) == false) goto L7;
            return KotlinTypeKt.isError((KotlinType) r10);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static boolean isInlineClass(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L13;
            ClassifierDescriptor r11 = ((TypeConstructor) r10).mo1402getDeclarationDescriptor();
            ValueClassRepresentation<SimpleType> r12 = null;
            if ((r11 instanceof ClassDescriptor) == false) goto L7;
            ClassDescriptor r13 = (ClassDescriptor) r11;
        L8:
            if (r13 == null) goto L11;
            r12 = r13.getValueClassRepresentation();
        L11:
            return r12 instanceof InlineClassRepresentation;
        L7:
            r13 = null;
            goto L8
        L13:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static boolean isIntegerLiteralTypeConstructor(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L7;
            return r10 instanceof IntegerLiteralTypeConstructor;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static boolean isIntersection(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L7;
            return r10 instanceof IntersectionTypeConstructor;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext r5, SimpleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof SimpleType) == true) goto L5;
            StringBuilder r11 = a.i("ClassicTypeSystemContext couldn't handle: ", r10, ", ");
            r11.append(Reflection.getOrCreateKotlinClass(r10.getClass()));
            throw new IllegalArgumentException(r11.toString().toString());
        L5:
            return ((SimpleType) r10).isMarkedNullable();
        }

        public static boolean isNotNullTypeParameter(ClassicTypeSystemContext r5, KotlinTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            return r10 instanceof NotNullTypeParameter;
        }

        public static boolean isNothingConstructor(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L7;
            return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) r10, StandardNames.FqNames.nothing);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static boolean isNullableType(ClassicTypeSystemContext r5, KotlinTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof KotlinType) == false) goto L7;
            return TypeUtils.isNullableType((KotlinType) r10);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static boolean isOldCapturedType(ClassicTypeSystemContext r5, CapturedTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            return r10 instanceof CapturedType;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isPrimitiveType(ClassicTypeSystemContext r5, SimpleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof KotlinType) == true) goto L5;
            StringBuilder r11 = a.i("ClassicTypeSystemContext couldn't handle: ", r10, ", ");
            r11.append(Reflection.getOrCreateKotlinClass(r10.getClass()));
            throw new IllegalArgumentException(r11.toString().toString());
        L5:
            return KotlinBuiltIns.isPrimitiveType((KotlinType) r10);
        }

        public static boolean isProjectionNotNull(ClassicTypeSystemContext r5, CapturedTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof NewCapturedType) == false) goto L7;
            return ((NewCapturedType) r10).isProjectionNotNull();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isSingleClassifierType(ClassicTypeSystemContext r5, SimpleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof SimpleType) == true) goto L5;
            StringBuilder r11 = a.i("ClassicTypeSystemContext couldn't handle: ", r10, ", ");
            r11.append(Reflection.getOrCreateKotlinClass(r10.getClass()));
            throw new IllegalArgumentException(r11.toString().toString());
        L5:
            if (KotlinTypeKt.isError((KotlinType) r10) == true) goto L21;
            SimpleType r12 = (SimpleType) r10;
            if ((r12.getConstructor().mo1402getDeclarationDescriptor() instanceof TypeAliasDescriptor) == true) goto L21;
            if (r12.getConstructor().mo1402getDeclarationDescriptor() == null) goto L11;
        L20:
            return true;
        L11:
            if ((r10 instanceof CapturedType) == true) goto L20;
            if ((r10 instanceof NewCapturedType) == true) goto L20;
            if ((r10 instanceof DefinitelyNotNullType) == true) goto L20;
            if ((r12.getConstructor() instanceof IntegerLiteralTypeConstructor) == true) goto L20;
            if (isSingleClassifierTypeWithEnhancement(r5, r10) == true) goto L20;
        L21:
            return false;
        }

        private static boolean isSingleClassifierTypeWithEnhancement(ClassicTypeSystemContext r5, SimpleTypeMarker r10) {
            if ((r10 instanceof SimpleTypeWithEnhancement) == true) goto L5;
        L7:
            return false;
        L5:
            if (r5.isSingleClassifierType(((SimpleTypeWithEnhancement) r10).getOrigin()) == false) goto L7;
            return true;
        }

        public static boolean isStarProjection(ClassicTypeSystemContext r5, TypeArgumentMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeProjection) == false) goto L7;
            return ((TypeProjection) r10).isStarProjection();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isStubType(ClassicTypeSystemContext r5, SimpleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof SimpleType) == true) goto L5;
            StringBuilder r11 = a.i("ClassicTypeSystemContext couldn't handle: ", r10, ", ");
            r11.append(Reflection.getOrCreateKotlinClass(r10.getClass()));
            throw new IllegalArgumentException(r11.toString().toString());
        L5:
            return TypeUtilsKt.isStubType((KotlinType) r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isStubTypeForBuilderInference(ClassicTypeSystemContext r5, SimpleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof SimpleType) == true) goto L5;
            StringBuilder r11 = a.i("ClassicTypeSystemContext couldn't handle: ", r10, ", ");
            r11.append(Reflection.getOrCreateKotlinClass(r10.getClass()));
            throw new IllegalArgumentException(r11.toString().toString());
        L5:
            return TypeUtilsKt.isStubTypeForBuilderInference((KotlinType) r10);
        }

        public static boolean isTypeVariableType(ClassicTypeSystemContext r5, KotlinTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof UnwrappedType) == true) goto L5;
        L7:
            return false;
        L5:
            if ((((UnwrappedType) r10).getConstructor() instanceof NewTypeVariableConstructor) == false) goto L7;
            return true;
        }

        public static boolean isUnderKotlinPackage(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L11;
            ClassifierDescriptor r11 = ((TypeConstructor) r10).mo1402getDeclarationDescriptor();
            if (r11 != null) goto L7;
            return false;
        L7:
            if (KotlinBuiltIns.isUnderKotlinPackage(r11) == true) goto L9;
            return false;
        L9:
            return true;
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static SimpleTypeMarker lowerBound(ClassicTypeSystemContext r5, FlexibleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof FlexibleType) == false) goto L7;
            return ((FlexibleType) r10).getLowerBound();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static KotlinTypeMarker lowerType(ClassicTypeSystemContext r5, CapturedTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof NewCapturedType) == false) goto L7;
            return ((NewCapturedType) r10).getLowerType();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static KotlinTypeMarker makeDefinitelyNotNullOrNotNull(ClassicTypeSystemContext r5, KotlinTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof UnwrappedType) == false) goto L7;
            return ClassicTypeSystemContextKt.access$makeDefinitelyNotNullOrNotNullInternal((UnwrappedType) r10);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static TypeCheckerState newTypeCheckerState(ClassicTypeSystemContext r10, boolean r11, boolean r12) {
            return ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(r11, r12, r10, null, null, 24, null);
        }

        public static SimpleTypeMarker original(ClassicTypeSystemContext r5, DefinitelyNotNullTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof DefinitelyNotNullType) == false) goto L7;
            return ((DefinitelyNotNullType) r10).getOriginal();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static int parametersCount(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L7;
            return ((TypeConstructor) r10).getParameters().size();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static Collection<KotlinTypeMarker> possibleIntegerTypes(ClassicTypeSystemContext r5, SimpleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            TypeConstructorMarker r11 = r5.typeConstructor(r10);
            if ((r11 instanceof IntegerLiteralTypeConstructor) == true) goto L5;
            StringBuilder r12 = a.i("ClassicTypeSystemContext couldn't handle: ", r10, ", ");
            r12.append(Reflection.getOrCreateKotlinClass(r10.getClass()));
            throw new IllegalArgumentException(r12.toString().toString());
        L5:
            return ((IntegerLiteralTypeConstructor) r11).getPossibleTypes();
        }

        public static TypeArgumentMarker projection(ClassicTypeSystemContext r5, CapturedTypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof NewCapturedTypeConstructor) == false) goto L7;
            return ((NewCapturedTypeConstructor) r10).getProjection();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(final ClassicTypeSystemContext r5, SimpleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "type");
            if ((r10 instanceof SimpleType) == false) goto L6;
            final TypeSubstitutor r11 = TypeConstructorSubstitution.Companion.create((KotlinType) r10).buildSubstitutor();
            return new ClassicTypeSystemContext$substitutionSupertypePolicy$2(r5, r11);
        L6:
            StringBuilder r12 = a.i("ClassicTypeSystemContext couldn't handle: ", r10, ", ");
            r12.append(Reflection.getOrCreateKotlinClass(r10.getClass()));
            throw new IllegalArgumentException(r12.toString().toString());
        }

        public static Collection<KotlinTypeMarker> supertypes(ClassicTypeSystemContext r5, TypeConstructorMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeConstructor) == false) goto L7;
            return ((TypeConstructor) r10).mo1403getSupertypes();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext r5, SimpleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof SimpleType) == true) goto L5;
            StringBuilder r11 = a.i("ClassicTypeSystemContext couldn't handle: ", r10, ", ");
            r11.append(Reflection.getOrCreateKotlinClass(r10.getClass()));
            throw new IllegalArgumentException(r11.toString().toString());
        L5:
            return ((SimpleType) r10).getConstructor();
        }

        public static SimpleTypeMarker upperBound(ClassicTypeSystemContext r5, FlexibleTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof FlexibleType) == false) goto L7;
            return ((FlexibleType) r10).getUpperBound();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static SimpleTypeMarker withNullability(ClassicTypeSystemContext r5, SimpleTypeMarker r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof SimpleType) == true) goto L5;
            StringBuilder r12 = a.i("ClassicTypeSystemContext couldn't handle: ", r10, ", ");
            r12.append(Reflection.getOrCreateKotlinClass(r10.getClass()));
            throw new IllegalArgumentException(r12.toString().toString());
        L5:
            return ((SimpleType) r10).makeNullableAsSpecified(r11);
        }

        public static TypeVariance getVariance(ClassicTypeSystemContext r5, TypeParameterMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof TypeParameterDescriptor) == false) goto L7;
            return TypeSystemContextKt.convertVariance(((TypeParameterDescriptor) r10).getVariance());
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static CapturedTypeConstructorMarker typeConstructor(ClassicTypeSystemContext r5, CapturedTypeMarker r10) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof NewCapturedType) == false) goto L7;
            return ((NewCapturedType) r10).getConstructor();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r10 + ", " + Reflection.getOrCreateKotlinClass(r10.getClass())).toString());
        }

        public static KotlinTypeMarker withNullability(ClassicTypeSystemContext r5, KotlinTypeMarker r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "$receiver");
            if ((r10 instanceof SimpleTypeMarker) == false) goto L6;
            return r5.withNullability((SimpleTypeMarker) r10, r11);
        L6:
            if ((r10 instanceof FlexibleTypeMarker) == false) goto L10;
            FlexibleTypeMarker r12 = (FlexibleTypeMarker) r10;
            return r5.createFlexibleType(r5.withNullability(r5.lowerBound(r12), r11), r5.withNullability(r5.upperBound(r12), r11));
        L10:
            throw new IllegalStateException("sealed");
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    CapturedTypeMarker asCapturedType(SimpleTypeMarker r5);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker asSimpleType(KotlinTypeMarker r5);

    KotlinTypeMarker createFlexibleType(SimpleTypeMarker r5, SimpleTypeMarker r10);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    boolean isSingleClassifierType(SimpleTypeMarker r5);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker lowerBound(FlexibleTypeMarker r5);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    TypeConstructorMarker typeConstructor(SimpleTypeMarker r5);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker upperBound(FlexibleTypeMarker r5);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker withNullability(SimpleTypeMarker r5, boolean r10);
}
