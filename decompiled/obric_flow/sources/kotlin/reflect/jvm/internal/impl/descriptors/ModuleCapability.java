package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ModuleCapability<T> {
    private final String name;

    public ModuleCapability(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.name = r5;
    }

    public String toString() {
        return this.name;
    }
}
