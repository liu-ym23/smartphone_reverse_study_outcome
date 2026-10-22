package k70;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[Lifecycle.State.values().length];
        a = r0;
        r0[Lifecycle.State.INITIALIZED.ordinal()] = 1;
        r0[Lifecycle.State.DESTROYED.ordinal()] = 2;
        r0[Lifecycle.State.CREATED.ordinal()] = 3;
        r0[Lifecycle.State.STARTED.ordinal()] = 4;
        r0[Lifecycle.State.RESUMED.ordinal()] = 5;
    }
}
