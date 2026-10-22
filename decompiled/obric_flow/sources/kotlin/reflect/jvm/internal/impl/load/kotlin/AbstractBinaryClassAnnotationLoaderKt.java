package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;

/* JADX INFO: loaded from: classes3.dex */
public final class AbstractBinaryClassAnnotationLoaderKt {
    public static final MemberSignature getPropertySignature(ProtoBuf.Property r5, NameResolver r10, TypeTable r11, boolean r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r5, "proto");
        Intrinsics.checkNotNullParameter(r10, "nameResolver");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        JvmProtoBuf.JvmPropertySignature r15 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(r5, JvmProtoBuf.propertySignature);
        if (r15 != null) goto L5;
        return null;
    L5:
        if (r12 == false) goto L11;
        JvmMemberSignature.Field r16 = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(r5, r10, r11, r14);
        if (r16 != null) goto L10;
        return null;
    L10:
        return MemberSignature.Companion.fromJvmMemberSignature(r16);
    L11:
        if (r13 == true) goto L13;
    L16:
        return null;
    L13:
        if (r15.hasSyntheticMethod() == false) goto L16;
        return MemberSignature.Companion.fromMethod(r10, r15.getSyntheticMethod());
    }

    public static /* synthetic */ MemberSignature getPropertySignature$default(ProtoBuf.Property r10, NameResolver r11, TypeTable r12, boolean r13, boolean r14, boolean r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r16 & 16) == 0) goto L9;
        boolean r18 = false;
    L11:
        if ((r16 & 32) == 0) goto L14;
        r15 = true;
    L14:
        return getPropertySignature(r10, r11, r12, r5, r18, r15);
    L9:
        r18 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }
}
