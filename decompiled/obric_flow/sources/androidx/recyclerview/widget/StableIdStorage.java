package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;

/* JADX INFO: loaded from: classes.dex */
interface StableIdStorage {

    public static class IsolatedStableIdStorage implements StableIdStorage {
        long mNextStableId;

        public class WrapperStableIdLookup implements StableIdLookup {
            private final LongSparseArray<Long> mLocalToGlobalLookup;
            final /* synthetic */ IsolatedStableIdStorage this$0;

            public WrapperStableIdLookup(IsolatedStableIdStorage r5) {
                this.this$0 = r5;
                this.mLocalToGlobalLookup = new LongSparseArray();
            }

            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long r5) {
                Long r10 = this.mLocalToGlobalLookup.get(r5);
                if (r10 != null) goto L6;
                r10 = Long.valueOf(this.this$0.obtainId());
                this.mLocalToGlobalLookup.put(r5, r10);
            L6:
                return r10.longValue();
            }
        }

        public IsolatedStableIdStorage() {
            this.mNextStableId = 0;
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        @NonNull
        public StableIdLookup createStableIdLookup() {
            return new WrapperStableIdLookup(this);
        }

        public long obtainId() {
            long r5 = this.mNextStableId;
            this.mNextStableId = 1 + r5;
            return r5;
        }
    }

    public static class NoStableIdStorage implements StableIdStorage {
        private final StableIdLookup mNoIdLookup;

        public NoStableIdStorage() {
            this.mNoIdLookup = new AnonymousClass1(this);
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mNoIdLookup;
        }
    }

    public static class SharedPoolStableIdStorage implements StableIdStorage {
        private final StableIdLookup mSameIdLookup;

        public SharedPoolStableIdStorage() {
            this.mSameIdLookup = new AnonymousClass1(this);
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mSameIdLookup;
        }
    }

    public interface StableIdLookup {
        long localToGlobal(long r5);
    }

    @NonNull
    StableIdLookup createStableIdLookup();
}
