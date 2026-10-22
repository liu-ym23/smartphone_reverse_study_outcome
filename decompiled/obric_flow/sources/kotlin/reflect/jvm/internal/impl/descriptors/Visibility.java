package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Visibility {
    private final boolean isPublicAPI;
    private final String name;

    public Visibility(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.name = r5;
        this.isPublicAPI = r10;
    }

    public Integer compareTo(Visibility r5) {
        Intrinsics.checkNotNullParameter(r5, "visibility");
        return Visibilities.INSTANCE.compareLocal$compiler_common(this, r5);
    }

    public String getInternalDisplayName() {
        return this.name;
    }

    public final boolean isPublicAPI() {
        return this.isPublicAPI;
    }

    public Visibility normalize() {
        return this;
    }

    public final String toString() {
        return getInternalDisplayName();
    }
}
