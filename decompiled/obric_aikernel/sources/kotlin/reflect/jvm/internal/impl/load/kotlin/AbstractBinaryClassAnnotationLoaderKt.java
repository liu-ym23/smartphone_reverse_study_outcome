package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* JADX INFO: loaded from: classes3.dex */
public final class AbstractBinaryClassAnnotationLoaderKt {
    public static final MemberSignature getPropertySignature(ProtoBuf.Property r10, NameResolver r11, TypeTable r12, boolean r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "proto");
        Intrinsics.checkNotNullParameter(r11, "nameResolver");
        Intrinsics.checkNotNullParameter(r12, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> r16 = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(r16, "propertySignature");
        JvmProtoBuf.JvmPropertySignature r17 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(r10, r16);
        if (r17 != null) goto L5;
        return null;
    L5:
        if (r13 == false) goto L11;
        JvmMemberSignature.Field r18 = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(r10, r11, r12, r15);
        if (r18 != null) goto L10;
        return null;
    L10:
        return MemberSignature.Companion.fromJvmMemberSignature(r18);
    L11:
        if (r14 == true) goto L13;
    L16:
        return null;
    L13:
        if (r17.hasSyntheticMethod() == false) goto L16;
        MemberSignature.Companion r19 = MemberSignature.Companion;
        JvmProtoBuf.JvmMethodSignature r20 = r17.getSyntheticMethod();
        Intrinsics.checkNotNullExpressionValue(r20, "signature.syntheticMethod");
        return r19.fromMethod(r11, r20);
    }

    public static /* synthetic */ MemberSignature getPropertySignature$default(ProtoBuf.Property r10, NameResolver r11, TypeTable r12, boolean r13, boolean r14, boolean r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        boolean r18 = false;
    L7:
        if ((r16 & 16) == 0) goto L9;
        boolean r19 = false;
    L11:
        if ((r16 & 32) == 0) goto L14;
        r15 = true;
    L14:
        return getPropertySignature(r10, r11, r12, r18, r19, r15);
    L9:
        r19 = r14;
        goto L11
    L5:
        r18 = r13;
        goto L7
    }
}
