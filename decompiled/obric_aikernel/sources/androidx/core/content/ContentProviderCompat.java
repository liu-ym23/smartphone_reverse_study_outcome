package androidx.core.content;

import android.content.ContentProvider;
import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ContentProviderCompat {
    private ContentProviderCompat() {
    }

    @NonNull
    public static Context requireContext(@NonNull ContentProvider r10) {
        Context r11 = r10.getContext();
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalStateException("Cannot find context from the provider.");
    }
}
