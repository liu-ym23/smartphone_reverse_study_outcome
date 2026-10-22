package kotlin.reflect.jvm.internal.impl.incremental.components;

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
        public void record(String r5, Position r10, String r11, ScopeKind r12, String r13) {
            Intrinsics.checkNotNullParameter(r5, "filePath");
            Intrinsics.checkNotNullParameter(r10, "position");
            Intrinsics.checkNotNullParameter(r11, "scopeFqName");
            Intrinsics.checkNotNullParameter(r12, "scopeKind");
            Intrinsics.checkNotNullParameter(r13, "name");
        }
    }

    boolean getRequiresPosition();

    void record(String r5, Position r10, String r11, ScopeKind r12, String r13);
}
