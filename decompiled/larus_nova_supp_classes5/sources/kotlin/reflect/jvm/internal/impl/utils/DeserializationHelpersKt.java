package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DeserializationHelpersKt {
    public static final JvmMetadataVersion jvmMetadataVersionOrDefault(DeserializationConfiguration r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        BinaryVersion r2 = r1.getBinaryVersion();
        if ((r2 instanceof JvmMetadataVersion) == false) goto L5;
        JvmMetadataVersion r3 = (JvmMetadataVersion) r2;
    L6:
        if (r3 == null) goto L8;
        return r3;
    L8:
        return JvmMetadataVersion.INSTANCE;
    L5:
        r3 = null;
        goto L6
    }
}
