package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class UriMatcherCompat {
    private UriMatcherCompat() {
    }

    public static /* synthetic */ boolean a(UriMatcher r5, Uri r10) {
        return lambda$asPredicate$0(r5, r10);
    }

    @NonNull
    public static Predicate<Uri> asPredicate(@NonNull UriMatcher r5) {
        return new c(r5, 1);
    }

    private static /* synthetic */ boolean lambda$asPredicate$0(UriMatcher r5, Uri r10) {
        if (r5.match(r10) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}
