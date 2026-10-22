package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public final class DeserializationHelpersKt {
    public static final JvmMetadataVersion jvmMetadataVersionOrDefault(DeserializationConfiguration r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        BinaryVersion r10 = r5.getBinaryVersion();
        if ((r10 instanceof JvmMetadataVersion) == false) goto L5;
        JvmMetadataVersion r11 = (JvmMetadataVersion) r10;
    L6:
        if (r11 == null) goto L8;
        return r11;
    L8:
        return JvmMetadataVersion.INSTANCE;
    L5:
        r11 = null;
        goto L6
    }
}
