package androidx.compose.runtime.snapshots;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"sync", "", "modificationError", "", "validateRange", "", "index", "", "size", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SnapshotStateListKt {
    private static final Object sync = null;

    static {
        sync = new Object();
    }

    public static final /* synthetic */ Object access$getSync$p() {
        return sync;
    }

    public static final /* synthetic */ Void access$modificationError() {
        return modificationError();
    }

    public static final /* synthetic */ void access$validateRange(int r5, int r10) {
        validateRange(r5, r10);
    }

    private static final Void modificationError() {
        throw new IllegalStateException("Cannot modify a state list through an iterator");
    }

    private static final void validateRange(int r5, int r10) {
        if (r5 < 0) goto L6;
        if (r5 >= r10) goto L6;
        return;
    L6:
        throw new IndexOutOfBoundsException("index (" + r5 + ") is out of bound of [0, " + r10 + ')');
    }
}
