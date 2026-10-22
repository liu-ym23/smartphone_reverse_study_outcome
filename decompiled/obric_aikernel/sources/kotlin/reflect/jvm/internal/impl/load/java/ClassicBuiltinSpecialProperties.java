package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ClassicBuiltinSpecialProperties {
    public static final ClassicBuiltinSpecialProperties INSTANCE = null;

    static {
        INSTANCE = new ClassicBuiltinSpecialProperties();
    }

    private ClassicBuiltinSpecialProperties() {
    }

    private final boolean hasBuiltinSpecialPropertyFqNameImpl(CallableMemberDescriptor r10) {
        if (CollectionsKt.contains(BuiltinSpecialProperties.INSTANCE.getSPECIAL_FQ_NAMES(), DescriptorUtilsKt.fqNameOrNull(r10)) == false) goto L8;
        if (r10.getValueParameters().isEmpty() == false) goto L8;
        return true;
    L8:
        if (KotlinBuiltIns.isBuiltIn(r10) == true) goto L10;
        return false;
    L10:
        Collection<? extends CallableMemberDescriptor> r11 = r10.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r11, "overriddenDescriptors");
        if (r11.isEmpty() == true) goto L18;
        Iterator<T> r12 = r11.iterator();
    L15:
        if (r12.hasNext() == false) goto L18;
        CallableMemberDescriptor r13 = (CallableMemberDescriptor) r12.next();
        ClassicBuiltinSpecialProperties r14 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r13, "it");
        if (r14.hasBuiltinSpecialPropertyFqName(r13) == false) goto L15;
        return true;
    L18:
        return false;
    }

    public final String getBuiltinSpecialPropertyGetterName(CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        KotlinBuiltIns.isBuiltIn(r10);
        CallableMemberDescriptor r11 = DescriptorUtilsKt.firstOverridden$default(DescriptorUtilsKt.getPropertyIfAccessor(r10), false, ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1.INSTANCE, 1, null);
        if (r11 != null) goto L5;
        return null;
    L5:
        Name r12 = BuiltinSpecialProperties.INSTANCE.getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP().get(DescriptorUtilsKt.getFqNameSafe(r11));
        if (r12 != null) goto L8;
        return null;
    L8:
        return r12.asString();
    }

    public final boolean hasBuiltinSpecialPropertyFqName(CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "callableMemberDescriptor");
        if (BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES().contains(r10.getName()) == true) goto L7;
        return false;
    L7:
        return hasBuiltinSpecialPropertyFqNameImpl(r10);
    }
}
