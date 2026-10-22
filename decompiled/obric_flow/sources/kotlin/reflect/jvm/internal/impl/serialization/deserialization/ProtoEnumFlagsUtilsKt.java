package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: loaded from: classes3.dex */
public final class ProtoEnumFlagsUtilsKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;

        static {
            int[] r5 = new int[ProtoBuf.MemberKind.values().length];
            r5[ProtoBuf.MemberKind.DECLARATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L56:
            r5[ProtoBuf.MemberKind.FAKE_OVERRIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L64:
            r5[ProtoBuf.MemberKind.DELEGATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L44:
            r5[ProtoBuf.MemberKind.SYNTHESIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L10:
            $EnumSwitchMapping$0 = r5;
            int[] r10 = new int[CallableMemberDescriptor.Kind.values().length];
            r10[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L58:
            r10[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L38:
            r10[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L46:
            r10[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L15:
            $EnumSwitchMapping$1 = r10;
            int[] r11 = new int[ProtoBuf.Visibility.values().length];
            r11[ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L40:
            r11[ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L48:
            r11[ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L54:
            r11[ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L62:
            r11[ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L42:
            r11[ProtoBuf.Visibility.LOCAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L22:
            $EnumSwitchMapping$2 = r11;
        }
    }

    public static final DescriptorVisibility descriptorVisibility(ProtoEnumFlags r5, ProtoBuf.Visibility r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 != null) goto L5;
        int r11 = -1;
    L6:
        switch(r11) {
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
        r11 = WhenMappings.$EnumSwitchMapping$2[r10.ordinal()];
        goto L6
    }

    public static final CallableMemberDescriptor.Kind memberKind(ProtoEnumFlags r5, ProtoBuf.MemberKind r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 != null) goto L5;
        int r11 = -1;
    L7:
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L23;
        if (r11 == 3) goto L22;
        if (r11 == 4) goto L21;
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
        r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        goto L7
    }
}
