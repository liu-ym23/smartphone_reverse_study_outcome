package kotlin.reflect.jvm.internal.impl.descriptors;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ModuleCapability<T> {
    private final String name;

    public String toString() {
        return this.name;
    }

    public ModuleCapability(String r2) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        this.name = r2;
    }
}
