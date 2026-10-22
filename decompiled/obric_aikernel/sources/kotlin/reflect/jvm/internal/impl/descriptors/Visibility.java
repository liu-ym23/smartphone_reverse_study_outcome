package kotlin.reflect.jvm.internal.impl.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Visibility {
    private final boolean isPublicAPI;
    private final String name;

    protected Visibility(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        this.name = r10;
        this.isPublicAPI = r11;
    }

    public Integer compareTo(Visibility r10) {
        Intrinsics.checkNotNullParameter(r10, "visibility");
        return Visibilities.INSTANCE.compareLocal$compiler_common(this, r10);
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
