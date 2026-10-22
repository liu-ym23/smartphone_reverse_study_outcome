package androidx.room;

import java.lang.ref.WeakReference;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class InvalidationTracker$WeakObserver extends InvalidationTracker$Observer {
    final WeakReference<InvalidationTracker$Observer> mDelegateRef;
    final InvalidationTracker mTracker;

    @Override // androidx.room.InvalidationTracker$Observer
    public void onInvalidated(Set<String> r2) {
        InvalidationTracker$Observer r0 = this.mDelegateRef.get();
        if (r0 != null) goto L5;
        this.mTracker.removeObserver(this);
        return;
    L5:
        r0.onInvalidated(r2);
    }

    public InvalidationTracker$WeakObserver(InvalidationTracker r2, InvalidationTracker$Observer r3) {
        super(r3.mTables);
        this.mTracker = r2;
        this.mDelegateRef = new WeakReference(r3);
    }
}
