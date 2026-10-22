package androidx.room;

import java.util.Arrays;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class InvalidationTracker$Observer {
    final String[] mTables;

    public boolean isRemote() {
        return false;
    }

    public abstract void onInvalidated(Set<String> r1);

    public InvalidationTracker$Observer(String[] r2) {
        this.mTables = (String[]) Arrays.copyOf(r2, r2.length);
    }

    public InvalidationTracker$Observer(String r2, String... r3) {
        String[] r0 = (String[]) Arrays.copyOf(r3, r3.length + 1);
        this.mTables = r0;
        r0[r3.length] = r2;
    }
}
