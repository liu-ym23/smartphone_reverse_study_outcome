package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class UriMatcherCompat {
    private UriMatcherCompat() {
    }

    public static Predicate<Uri> asPredicate(final UriMatcher r1) {
        return new $$Lambda$UriMatcherCompat$ak8EzdVzS74T_K7b7pKPTuokBDk(r1);
    }

    static /* synthetic */ boolean lambda$asPredicate$0(UriMatcher r0, Uri r1) {
        if (r0.match(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}
