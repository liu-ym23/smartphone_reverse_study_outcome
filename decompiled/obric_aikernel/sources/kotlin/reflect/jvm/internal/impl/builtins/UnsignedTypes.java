package kotlin.reflect.jvm.internal.impl.builtins;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
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
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* JADX INFO: loaded from: classes3.dex */
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
        UnsignedType[] r10 = UnsignedType.values();
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r11.add(r10[r14].getTypeName());
        r14 = r14 + 1;
        goto L3
    L5:
        unsignedTypeNames = CollectionsKt.toSet(r11);
        UnsignedArrayType[] r15 = UnsignedArrayType.values();
        ArrayList r16 = new ArrayList(r15.length);
        int r17 = r15.length;
        int r18 = 0;
    L6:
        if (r18 >= r17) goto L8;
        r16.add(r15[r18].getTypeName());
        r18 = r18 + 1;
        goto L6
    L8:
        unsignedArrayTypeNames = CollectionsKt.toSet(r16);
        arrayClassIdToUnsignedClassId = new HashMap();
        unsignedClassIdToArrayClassId = new HashMap();
        unsignedArrayTypeToArrayCall = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(UnsignedArrayType.UBYTEARRAY, Name.identifier("ubyteArrayOf")), TuplesKt.to(UnsignedArrayType.USHORTARRAY, Name.identifier("ushortArrayOf")), TuplesKt.to(UnsignedArrayType.UINTARRAY, Name.identifier("uintArrayOf")), TuplesKt.to(UnsignedArrayType.ULONGARRAY, Name.identifier("ulongArrayOf"))});
        UnsignedType[] r19 = UnsignedType.values();
        LinkedHashSet r20 = new LinkedHashSet();
        int r21 = r19.length;
        int r22 = 0;
    L9:
        if (r22 >= r21) goto L11;
        r20.add(r19[r22].getArrayClassId().getShortClassName());
        r22 = r22 + 1;
        goto L9
    L11:
        arrayClassesShortNames = r20;
        UnsignedType[] r23 = UnsignedType.values();
        int r24 = r23.length;
    L12:
        if (r13 >= r24) goto L14;
        UnsignedType r25 = r23[r13];
        arrayClassIdToUnsignedClassId.put(r25.getArrayClassId(), r25.getClassId());
        unsignedClassIdToArrayClassId.put(r25.getClassId(), r25.getArrayClassId());
        r13 = r13 + 1;
        goto L12
    }

    private UnsignedTypes() {
    }

    @JvmStatic
    public static final boolean isUnsignedType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        if (TypeUtils.noExpectedType(r10) == false) goto L5;
        return false;
    L5:
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if (r11 != null) goto L9;
        return false;
    L9:
        return INSTANCE.isUnsignedClass(r11);
    }

    public final ClassId getUnsignedClassIdByArrayClassId(ClassId r10) {
        Intrinsics.checkNotNullParameter(r10, "arrayClassId");
        return arrayClassIdToUnsignedClassId.get(r10);
    }

    public final boolean isShortNameOfUnsignedArray(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return arrayClassesShortNames.contains(r10);
    }

    public final boolean isUnsignedClass(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        DeclarationDescriptor r11 = r10.getContainingDeclaration();
        if ((r11 instanceof PackageFragmentDescriptor) == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r11).getFqName(), StandardNames.BUILT_INS_PACKAGE_FQ_NAME) == false) goto L9;
        if (unsignedTypeNames.contains(r10.getName()) == false) goto L9;
        return true;
    }
}
