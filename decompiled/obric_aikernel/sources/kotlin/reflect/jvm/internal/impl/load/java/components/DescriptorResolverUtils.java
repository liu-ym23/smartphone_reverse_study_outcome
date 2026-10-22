package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;

/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorResolverUtils {
    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 18) goto L5;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r10 == 18) goto L9;
        int r12 = 3;
    L10:
        Object[] r13 = new Object[r12];
        switch(r10) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L12;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L12;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L12;
            case 20: goto L13;
            default: goto L12;
        };
    L12:
        r13[0] = ActivityLifecycle.NAME;
    L21:
        if (r10 == 18) goto L23;
        r13[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
    L24:
        switch(r10) {
            case 6: goto L28;
            case 7: goto L28;
            case 8: goto L28;
            case 9: goto L28;
            case 10: goto L28;
            case 11: goto L28;
            case 12: goto L27;
            case 13: goto L27;
            case 14: goto L27;
            case 15: goto L27;
            case 16: goto L27;
            case 17: goto L27;
            case 18: goto L29;
            case 19: goto L26;
            case 20: goto L26;
            default: goto L25;
        };
    L25:
        r13[2] = "resolveOverridesForNonStaticMembers";
        goto L29
    L26:
        r13[2] = "getAnnotationParameterByName";
        goto L29
    L27:
        r13[2] = "resolveOverrides";
        goto L29
    L28:
        r13[2] = "resolveOverridesForStaticMembers";
    L29:
        String r14 = String.format(r11, r13);
        if (r10 == 18) goto L33;
        throw new IllegalArgumentException(r14);
    L33:
        throw new IllegalStateException(r14);
    L23:
        r13[1] = "resolveOverrides";
        goto L24
    L13:
        r13[0] = "annotationClass";
        goto L21
    L14:
        r13[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        goto L21
    L15:
        r13[0] = "overridingUtil";
        goto L21
    L16:
        r13[0] = "errorReporter";
        goto L21
    L17:
        r13[0] = "classDescriptor";
        goto L21
    L18:
        r13[0] = "membersFromCurrent";
        goto L21
    L19:
        r13[0] = "membersFromSupertypes";
        goto L21
    L9:
        r12 = 2;
        goto L10
    L5:
        r11 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public static ValueParameterDescriptor getAnnotationParameterByName(Name r10, ClassDescriptor r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(19);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(20);
    L6:
        Collection<ClassConstructorDescriptor> r12 = r11.getConstructors();
        if (r12.size() == 1) goto L9;
        return null;
    L9:
        Iterator<ValueParameterDescriptor> r13 = r12.iterator().next().getValueParameters().iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        ValueParameterDescriptor r14 = r13.next();
        if (r14.getName().equals(r10) == false) goto L11;
        return r14;
    L15:
        return null;
    }

    private static <D extends CallableMemberDescriptor> Collection<D> resolveOverrides(Name r10, Collection<D> r11, Collection<D> r12, ClassDescriptor r13, final ErrorReporter r14, OverridingUtil r15, final boolean r16) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        if (r13 != null) goto L10;
        $$$reportNull$$$0(15);
    L10:
        if (r14 != null) goto L12;
        $$$reportNull$$$0(16);
    L12:
        if (r15 != null) goto L14;
        $$$reportNull$$$0(17);
    L14:
        final LinkedHashSet r17 = new LinkedHashSet();
        r15.generateOverridesInFunctionGroup(r10, r11, r12, r13, new AnonymousClass1(r14, r17, r16));
        return r17;
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForNonStaticMembers(Name r10, Collection<D> r11, Collection<D> r12, ClassDescriptor r13, ErrorReporter r14, OverridingUtil r15) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r13 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r14 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        if (r15 != null) goto L15;
        $$$reportNull$$$0(5);
    L15:
        return resolveOverrides(r10, r11, r12, r13, r14, r15, false);
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForStaticMembers(Name r10, Collection<D> r11, Collection<D> r12, ClassDescriptor r13, ErrorReporter r14, OverridingUtil r15) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(8);
    L8:
        if (r13 != null) goto L10;
        $$$reportNull$$$0(9);
    L10:
        if (r14 != null) goto L12;
        $$$reportNull$$$0(10);
    L12:
        if (r15 != null) goto L15;
        $$$reportNull$$$0(11);
    L15:
        return resolveOverrides(r10, r11, r12, r13, r14, r15, true);
    }
}
