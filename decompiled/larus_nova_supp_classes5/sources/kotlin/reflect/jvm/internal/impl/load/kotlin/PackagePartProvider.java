package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface PackagePartProvider {

    public static final class Empty implements PackagePartProvider {
        public static final Empty INSTANCE = null;

        static {
            INSTANCE = new Empty();
        }

        private Empty() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider
        public List<String> findPackageParts(String r2) {
            Intrinsics.checkNotNullParameter(r2, "packageFqName");
            return CollectionsKt.emptyList();
        }
    }

    List<String> findPackageParts(String r1);
}
