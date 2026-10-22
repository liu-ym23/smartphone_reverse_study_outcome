package kotlin.reflect.jvm.internal.impl.incremental.components;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface LookupTracker {

    public static final class DO_NOTHING implements LookupTracker {
        public static final DO_NOTHING INSTANCE = null;

        static {
            INSTANCE = new DO_NOTHING();
        }

        private DO_NOTHING() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public boolean getRequiresPosition() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public void record(String r2, Position r3, String r4, ScopeKind r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "filePath");
            Intrinsics.checkNotNullParameter(r3, "position");
            Intrinsics.checkNotNullParameter(r4, "scopeFqName");
            Intrinsics.checkNotNullParameter(r5, "scopeKind");
            Intrinsics.checkNotNullParameter(r6, DBDefinition.NAME);
        }
    }

    boolean getRequiresPosition();

    void record(String r1, Position r2, String r3, ScopeKind r4, String r5);
}
