package bu;

import kotlinx.metadata.internal.metadata.ProtoBuf$Annotation;
import kotlinx.metadata.internal.metadata.ProtoBuf$Class;
import kotlinx.metadata.internal.metadata.ProtoBuf$Constructor;
import kotlinx.metadata.internal.metadata.ProtoBuf$Function;
import kotlinx.metadata.internal.metadata.ProtoBuf$Package;
import kotlinx.metadata.internal.metadata.ProtoBuf$Property;
import kotlinx.metadata.internal.metadata.ProtoBuf$Type;
import kotlinx.metadata.internal.metadata.ProtoBuf$TypeParameter;
import kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf$JvmMethodSignature;
import kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf$JvmPropertySignature;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.WireFormat$FieldType;
import kotlinx.metadata.internal.protobuf.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f998a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f999b = null;

    static {
        ProtoBuf$Constructor r5 = ProtoBuf$Constructor.getDefaultInstance();
        JvmProtoBuf$JvmMethodSignature r10 = JvmProtoBuf$JvmMethodSignature.getDefaultInstance();
        JvmProtoBuf$JvmMethodSignature r11 = JvmProtoBuf$JvmMethodSignature.getDefaultInstance();
        WireFormat$FieldType r12 = WireFormat$FieldType.MESSAGE;
        GeneratedMessageLite.newSingularGeneratedExtension(r5, r10, r11, null, 100, r12, JvmProtoBuf$JvmMethodSignature.class);
        GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Function.getDefaultInstance(), JvmProtoBuf$JvmMethodSignature.getDefaultInstance(), JvmProtoBuf$JvmMethodSignature.getDefaultInstance(), null, 100, r12, JvmProtoBuf$JvmMethodSignature.class);
        ProtoBuf$Function r13 = ProtoBuf$Function.getDefaultInstance();
        WireFormat$FieldType r18 = WireFormat$FieldType.INT32;
        GeneratedMessageLite.newSingularGeneratedExtension(r13, 0, null, null, 101, r18, Integer.class);
        GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Property.getDefaultInstance(), JvmProtoBuf$JvmPropertySignature.getDefaultInstance(), JvmProtoBuf$JvmPropertySignature.getDefaultInstance(), null, 100, r12, JvmProtoBuf$JvmPropertySignature.class);
        GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Property.getDefaultInstance(), 0, null, null, 101, r18, Integer.class);
        GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Type.getDefaultInstance(), ProtoBuf$Annotation.getDefaultInstance(), null, 100, r12, false, ProtoBuf$Annotation.class);
        GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Type.getDefaultInstance(), Boolean.FALSE, null, null, 101, WireFormat$FieldType.BOOL, Boolean.class);
        GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$TypeParameter.getDefaultInstance(), ProtoBuf$Annotation.getDefaultInstance(), null, 100, r12, false, ProtoBuf$Annotation.class);
        GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Class.getDefaultInstance(), 0, null, null, 101, r18, Integer.class);
        f998a = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Class.getDefaultInstance(), ProtoBuf$Property.getDefaultInstance(), null, 102, r12, false, ProtoBuf$Property.class);
        GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Class.getDefaultInstance(), 0, null, null, 103, r18, Integer.class);
        GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Class.getDefaultInstance(), 0, null, null, 104, r18, Integer.class);
        GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Package.getDefaultInstance(), 0, null, null, 101, r18, Integer.class);
        f999b = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Package.getDefaultInstance(), ProtoBuf$Property.getDefaultInstance(), null, 102, r12, false, ProtoBuf$Property.class);
    }
}
