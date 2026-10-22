package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nUnsignedType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnsignedType.kt\norg/jetbrains/kotlin/builtins/UnsignedTypes\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,122:1\n11335#2:123\n11670#2,3:124\n11335#2:127\n11670#2,3:128\n11670#2,3:131\n*S KotlinDebug\n*F\n+ 1 UnsignedType.kt\norg/jetbrains/kotlin/builtins/UnsignedTypes\n*L\n36#1:123\n36#1:124,3\n37#1:127\n37#1:128,3\n47#1:131,3\n*E\n"})
public final class UnsignedTypes {
    public static final UnsignedTypes INSTANCE = null;
    private static final HashMap<ClassId, ClassId> arrayClassIdToUnsignedClassId = null;
    private static final Set<Name> arrayClassesShortNames = null;
    private static final Set<Name> unsignedArrayTypeNames = null;
    private static final HashMap<UnsignedArrayType, Name> unsignedArrayTypeToArrayCall = null;
    private static final HashMap<ClassId, ClassId> unsignedClassIdToArrayClassId = null;
    private static final Set<Name> unsignedTypeNames = null;

    static {
        INSTANCE = new UnsignedTypes();
        UnsignedType[] r5 = UnsignedType.values();
        ArrayList r10 = new ArrayList(r5.length);
        int r11 = r5.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r10.add(r5[r13].getTypeName());
        r13 = r13 + 1;
        goto L3
    L5:
        unsignedTypeNames = CollectionsKt.toSet(r10);
        UnsignedArrayType[] r14 = UnsignedArrayType.values();
        ArrayList r15 = new ArrayList(r14.length);
        int r16 = r14.length;
        int r17 = 0;
    L6:
        if (r17 >= r16) goto L8;
        r15.add(r14[r17].getTypeName());
        r17 = r17 + 1;
        goto L6
    L8:
        unsignedArrayTypeNames = CollectionsKt.toSet(r15);
        arrayClassIdToUnsignedClassId = new HashMap();
        unsignedClassIdToArrayClassId = new HashMap();
        unsignedArrayTypeToArrayCall = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(UnsignedArrayType.UBYTEARRAY, Name.identifier("ubyteArrayOf")), TuplesKt.to(UnsignedArrayType.USHORTARRAY, Name.identifier("ushortArrayOf")), TuplesKt.to(UnsignedArrayType.UINTARRAY, Name.identifier("uintArrayOf")), TuplesKt.to(UnsignedArrayType.ULONGARRAY, Name.identifier("ulongArrayOf"))});
        UnsignedType[] r18 = UnsignedType.values();
        LinkedHashSet r19 = new LinkedHashSet();
        int r20 = r18.length;
        int r21 = 0;
    L9:
        if (r21 >= r20) goto L11;
        r19.add(r18[r21].getArrayClassId().getShortClassName());
        r21 = r21 + 1;
        goto L9
    L11:
        arrayClassesShortNames = r19;
        UnsignedType[] r22 = UnsignedType.values();
        int r23 = r22.length;
    L12:
        if (r12 >= r23) goto L14;
        UnsignedType r24 = r22[r12];
        arrayClassIdToUnsignedClassId.put(r24.getArrayClassId(), r24.getClassId());
        unsignedClassIdToArrayClassId.put(r24.getClassId(), r24.getArrayClassId());
        r12 = r12 + 1;
        goto L12
    }

    private UnsignedTypes() {
    }

    @JvmStatic
    public static final boolean isUnsignedType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (TypeUtils.noExpectedType(r5) == false) goto L5;
        return false;
    L5:
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if (r10 != null) goto L9;
        return false;
    L9:
        return INSTANCE.isUnsignedClass(r10);
    }

    public final ClassId getUnsignedClassIdByArrayClassId(ClassId r5) {
        Intrinsics.checkNotNullParameter(r5, "arrayClassId");
        return arrayClassIdToUnsignedClassId.get(r5);
    }

    public final boolean isShortNameOfUnsignedArray(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return arrayClassesShortNames.contains(r5);
    }

    public final boolean isUnsignedClass(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        DeclarationDescriptor r10 = r5.getContainingDeclaration();
        if ((r10 instanceof PackageFragmentDescriptor) == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r10).getFqName(), StandardNames.BUILT_INS_PACKAGE_FQ_NAME) == false) goto L9;
        if (unsignedTypeNames.contains(r5.getName()) == false) goto L9;
        return true;
    }
}
