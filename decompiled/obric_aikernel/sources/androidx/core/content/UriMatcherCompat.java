package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class UriMatcherCompat {
    private UriMatcherCompat() {
    }

    public static /* synthetic */ boolean a(UriMatcher r10, Uri r11) {
        return lambda$asPredicate$0(r10, r11);
    }

    @NonNull
    public static Predicate<Uri> asPredicate(@NonNull final UriMatcher r10) {
        return new w(r10);
    }

    private static /* synthetic */ boolean lambda$asPredicate$0(UriMatcher r10, Uri r11) {
        if (r10.match(r11) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}
