package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ProtoEnumFlagsUtilsKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;

        static {
            int[] r0 = new int[ProtoBuf$MemberKind.values().length];
            r0[ProtoBuf$MemberKind.DECLARATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L56:
            r0[ProtoBuf$MemberKind.FAKE_OVERRIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L64:
            r0[ProtoBuf$MemberKind.DELEGATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L44:
            r0[ProtoBuf$MemberKind.SYNTHESIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L10:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[CallableMemberDescriptor.Kind.values().length];
            r1[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L58:
            r1[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L38:
            r1[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L46:
            r1[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L15:
            $EnumSwitchMapping$1 = r1;
            int[] r2 = new int[ProtoBuf$Visibility.values().length];
            r2[ProtoBuf$Visibility.INTERNAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L40:
            r2[ProtoBuf$Visibility.PRIVATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L48:
            r2[ProtoBuf$Visibility.PRIVATE_TO_THIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L54:
            r2[ProtoBuf$Visibility.PROTECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L62:
            r2[ProtoBuf$Visibility.PUBLIC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L42:
            r2[ProtoBuf$Visibility.LOCAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L22:
            $EnumSwitchMapping$2 = r2;
        }
    }

    public static final DescriptorVisibility descriptorVisibility(ProtoEnumFlags r1, ProtoBuf$Visibility r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != null) goto L5;
        int r3 = -1;
    L6:
        switch(r3) {
            case 1: goto L14;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            default: goto L15;
        };
    L15:
        return DescriptorVisibilities.PRIVATE;
    L16:
        return DescriptorVisibilities.LOCAL;
    L17:
        return DescriptorVisibilities.PUBLIC;
    L18:
        return DescriptorVisibilities.PROTECTED;
    L19:
        return DescriptorVisibilities.PRIVATE_TO_THIS;
    L20:
        return DescriptorVisibilities.PRIVATE;
    L14:
        return DescriptorVisibilities.INTERNAL;
    L5:
        r3 = WhenMappings.$EnumSwitchMapping$2[r2.ordinal()];
        goto L6
    }

    public static final CallableMemberDescriptor.Kind memberKind(ProtoEnumFlags r1, ProtoBuf$MemberKind r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != null) goto L5;
        int r3 = -1;
    L7:
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L23;
        if (r3 == 3) goto L22;
        if (r3 == 4) goto L21;
        return CallableMemberDescriptor.Kind.DECLARATION;
    L21:
        return CallableMemberDescriptor.Kind.SYNTHESIZED;
    L22:
        return CallableMemberDescriptor.Kind.DELEGATION;
    L23:
        return CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
    L19:
        return CallableMemberDescriptor.Kind.DECLARATION;
    L5:
        r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        goto L7
    }
}
