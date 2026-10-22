package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class ResolutionAnchorProviderKt {
    private static final ModuleCapability<ResolutionAnchorProvider> RESOLUTION_ANCHOR_PROVIDER_CAPABILITY = null;

    static {
        RESOLUTION_ANCHOR_PROVIDER_CAPABILITY = new ModuleCapability("ResolutionAnchorProvider");
    }

    public static final ModuleDescriptor getResolutionAnchorIfAny(ModuleDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ResolutionAnchorProvider r10 = (ResolutionAnchorProvider) r5.getCapability(RESOLUTION_ANCHOR_PROVIDER_CAPABILITY);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getResolutionAnchor(r5);
    }
}
