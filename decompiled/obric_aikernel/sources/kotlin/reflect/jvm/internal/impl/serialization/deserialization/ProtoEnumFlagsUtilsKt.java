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
            int[] r10 = new int[ProtoBuf.MemberKind.values().length];
            r10[ProtoBuf.MemberKind.DECLARATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L56:
            r10[ProtoBuf.MemberKind.FAKE_OVERRIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L64:
            r10[ProtoBuf.MemberKind.DELEGATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L44:
            r10[ProtoBuf.MemberKind.SYNTHESIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L10:
            $EnumSwitchMapping$0 = r10;
            int[] r11 = new int[CallableMemberDescriptor.Kind.values().length];
            r11[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L58:
            r11[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L38:
            r11[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L46:
            r11[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L15:
            $EnumSwitchMapping$1 = r11;
            int[] r12 = new int[ProtoBuf.Visibility.values().length];
            r12[ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L40:
            r12[ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L48:
            r12[ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L54:
            r12[ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L62:
            r12[ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L42:
            r12[ProtoBuf.Visibility.LOCAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L22:
            $EnumSwitchMapping$2 = r12;
        }
    }

    public static final DescriptorVisibility descriptorVisibility(ProtoEnumFlags r10, ProtoBuf.Visibility r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 != null) goto L5;
        int r12 = -1;
    L6:
        String r13 = "PRIVATE";
        switch(r12) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L13;
        };
    L9:
        DescriptorVisibility r14 = DescriptorVisibilities.LOCAL;
        r13 = "LOCAL";
    L15:
        Intrinsics.checkNotNullExpressionValue(r14, r13);
        return r14;
    L10:
        r14 = DescriptorVisibilities.PUBLIC;
        r13 = "PUBLIC";
        goto L15
    L11:
        r14 = DescriptorVisibilities.PROTECTED;
        r13 = "PROTECTED";
        goto L15
    L12:
        r14 = DescriptorVisibilities.PRIVATE_TO_THIS;
        r13 = "PRIVATE_TO_THIS";
        goto L15
    L13:
        r14 = DescriptorVisibilities.PRIVATE;
        goto L15
    L14:
        r14 = DescriptorVisibilities.INTERNAL;
        r13 = "INTERNAL";
        goto L15
    L5:
        r12 = WhenMappings.$EnumSwitchMapping$2[r11.ordinal()];
        goto L6
    }

    public static final CallableMemberDescriptor.Kind memberKind(ProtoEnumFlags r10, ProtoBuf.MemberKind r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 != null) goto L5;
        int r12 = -1;
    L7:
        if (r12 == 1) goto L19;
        if (r12 == 2) goto L22;
        if (r12 == 3) goto L21;
        if (r12 != 4) goto L19;
        return CallableMemberDescriptor.Kind.SYNTHESIZED;
    L21:
        return CallableMemberDescriptor.Kind.DELEGATION;
    L22:
        return CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
    L19:
        return CallableMemberDescriptor.Kind.DECLARATION;
    L5:
        r12 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        goto L7
    }
}
