package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class InvalidModuleExceptionKt {
    private static final ModuleCapability<InvalidModuleNotifier> INVALID_MODULE_NOTIFIER_CAPABILITY = null;

    static {
        INVALID_MODULE_NOTIFIER_CAPABILITY = new ModuleCapability("InvalidModuleNotifier");
    }

    public static final void moduleInvalidated(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        InvalidModuleNotifier r11 = (InvalidModuleNotifier) r10.getCapability(INVALID_MODULE_NOTIFIER_CAPABILITY);
        if (r11 == null) goto L5;
        r11.notifyModuleInvalidated(r10);
        Unit r12 = Unit.INSTANCE;
    L6:
        if (r12 == null) goto L9;
        return;
    L9:
        throw new InvalidModuleException("Accessing invalid module descriptor " + r10);
    L5:
        r12 = null;
        goto L6
    }
}
