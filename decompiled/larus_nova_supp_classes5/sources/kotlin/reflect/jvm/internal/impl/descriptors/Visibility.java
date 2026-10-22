package kotlin.reflect.jvm.internal.impl.descriptors;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class Visibility {
    private final boolean isPublicAPI;
    private final String name;

    public Visibility normalize() {
        return this;
    }

    public final String toString() {
        return getInternalDisplayName();
    }

    public String getInternalDisplayName() {
        return this.name;
    }

    public final boolean isPublicAPI() {
        return this.isPublicAPI;
    }

    public Integer compareTo(Visibility r2) {
        Intrinsics.checkNotNullParameter(r2, "visibility");
        return Visibilities.INSTANCE.compareLocal$compiler_common(this, r2);
    }

    public Visibility(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        this.name = r2;
        this.isPublicAPI = r3;
    }
}
