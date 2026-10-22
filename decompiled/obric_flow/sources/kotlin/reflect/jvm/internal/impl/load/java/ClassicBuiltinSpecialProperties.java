package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nClassicBuiltinSpecialProperties.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassicBuiltinSpecialProperties.kt\norg/jetbrains/kotlin/load/java/ClassicBuiltinSpecialProperties\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n1#2:37\n1747#3,3:38\n*S KotlinDebug\n*F\n+ 1 ClassicBuiltinSpecialProperties.kt\norg/jetbrains/kotlin/load/java/ClassicBuiltinSpecialProperties\n*L\n33#1:38,3\n*E\n"})
public final class ClassicBuiltinSpecialProperties {
    public static final ClassicBuiltinSpecialProperties INSTANCE = null;

    static {
        INSTANCE = new ClassicBuiltinSpecialProperties();
    }

    private ClassicBuiltinSpecialProperties() {
    }

    private final boolean hasBuiltinSpecialPropertyFqNameImpl(CallableMemberDescriptor r5) {
        if (CollectionsKt.contains(BuiltinSpecialProperties.INSTANCE.getSPECIAL_FQ_NAMES(), DescriptorUtilsKt.fqNameOrNull(r5)) == false) goto L8;
        if (r5.getValueParameters().isEmpty() == false) goto L8;
        return true;
    L8:
        if (KotlinBuiltIns.isBuiltIn(r5) == true) goto L10;
        return false;
    L10:
        Collection<? extends CallableMemberDescriptor> r10 = r5.getOverriddenDescriptors();
        if (r10.isEmpty() == true) goto L18;
        Iterator<T> r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L18;
        CallableMemberDescriptor r12 = (CallableMemberDescriptor) r11.next();
        if (INSTANCE.hasBuiltinSpecialPropertyFqName(r12) == false) goto L15;
        return true;
    L18:
        return false;
    }

    public final String getBuiltinSpecialPropertyGetterName(CallableMemberDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KotlinBuiltIns.isBuiltIn(r5);
        CallableMemberDescriptor r10 = DescriptorUtilsKt.firstOverridden$default(DescriptorUtilsKt.getPropertyIfAccessor(r5), false, ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1.INSTANCE, 1, null);
        if (r10 != null) goto L5;
        return null;
    L5:
        Name r11 = BuiltinSpecialProperties.INSTANCE.getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP().get(DescriptorUtilsKt.getFqNameSafe(r10));
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.asString();
    }

    public final boolean hasBuiltinSpecialPropertyFqName(CallableMemberDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "callableMemberDescriptor");
        if (BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES().contains(r5.getName()) == true) goto L7;
        return false;
    L7:
        return hasBuiltinSpecialPropertyFqNameImpl(r5);
    }
}
