package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class InvalidModuleExceptionKt {
    private static final ModuleCapability<InvalidModuleNotifier> INVALID_MODULE_NOTIFIER_CAPABILITY = null;

    static {
        INVALID_MODULE_NOTIFIER_CAPABILITY = new ModuleCapability("InvalidModuleNotifier");
    }

    public static final void moduleInvalidated(ModuleDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        InvalidModuleNotifier r10 = (InvalidModuleNotifier) r5.getCapability(INVALID_MODULE_NOTIFIER_CAPABILITY);
        if (r10 == null) goto L5;
        r10.notifyModuleInvalidated(r5);
        Unit r11 = Unit.INSTANCE;
    L6:
        if (r11 == null) goto L9;
        return;
    L9:
        throw new InvalidModuleException("Accessing invalid module descriptor " + r5);
    L5:
        r11 = null;
        goto L6
    }
}
