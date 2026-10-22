package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ResolutionAnchorProviderKt {
    private static final ModuleCapability<ResolutionAnchorProvider> RESOLUTION_ANCHOR_PROVIDER_CAPABILITY = null;

    static {
        RESOLUTION_ANCHOR_PROVIDER_CAPABILITY = new ModuleCapability("ResolutionAnchorProvider");
    }

    public static final ModuleDescriptor getResolutionAnchorIfAny(ModuleDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ResolutionAnchorProvider r0 = (ResolutionAnchorProvider) r1.getCapability(RESOLUTION_ANCHOR_PROVIDER_CAPABILITY);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getResolutionAnchor(r1);
    }
}
