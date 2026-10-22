package kotlin.reflect.jvm.internal.impl.incremental.components;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
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
        public void record(String r10, Position r11, String r12, ScopeKind r13, String r14) {
            Intrinsics.checkNotNullParameter(r10, "filePath");
            Intrinsics.checkNotNullParameter(r11, "position");
            Intrinsics.checkNotNullParameter(r12, "scopeFqName");
            Intrinsics.checkNotNullParameter(r13, "scopeKind");
            Intrinsics.checkNotNullParameter(r14, ActivityLifecycle.NAME);
        }
    }

    boolean getRequiresPosition();

    void record(String r10, Position r11, String r12, ScopeKind r13, String r14);
}
