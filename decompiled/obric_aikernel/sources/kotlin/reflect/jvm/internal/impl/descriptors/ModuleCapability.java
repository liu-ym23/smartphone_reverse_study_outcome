package kotlin.reflect.jvm.internal.impl.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ModuleCapability<T> {
    private final String name;

    public ModuleCapability(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        this.name = r10;
    }

    public String toString() {
        return this.name;
    }
}
