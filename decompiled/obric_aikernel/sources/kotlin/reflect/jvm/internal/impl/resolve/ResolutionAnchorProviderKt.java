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

    public static final ModuleDescriptor getResolutionAnchorIfAny(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ResolutionAnchorProvider r11 = (ResolutionAnchorProvider) r10.getCapability(RESOLUTION_ANCHOR_PROVIDER_CAPABILITY);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.getResolutionAnchor(r10);
    }
}
