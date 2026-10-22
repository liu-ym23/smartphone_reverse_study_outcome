package io.noties.markwon.g;

import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a {
    public static int a(int r1, int r2) {
        return (r1 & ViewCompat.MEASURED_SIZE_MASK) | (r2 << 24);
    }
}
