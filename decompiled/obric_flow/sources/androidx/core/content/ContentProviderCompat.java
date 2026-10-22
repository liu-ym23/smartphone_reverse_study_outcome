package androidx.core.content;

import android.content.ContentProvider;
import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ContentProviderCompat {
    private ContentProviderCompat() {
    }

    @NonNull
    public static Context requireContext(@NonNull ContentProvider r5) {
        Context r10 = r5.getContext();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Cannot find context from the provider.");
    }
}
