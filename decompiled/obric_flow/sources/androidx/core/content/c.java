package androidx.core.content;

import android.content.ComponentName;
import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f452b;

    public /* synthetic */ c(Object r5, int r10) {
        this.f451a = r10;
        this.f452b = r5;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object r5) {
        int r10 = this.f451a;
        Object r11 = this.f452b;
        switch(r10) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return Predicate.a((Predicate) r11, r5);
    L7:
        return Predicate.c(r11, r5);
    L9:
        return UriMatcherCompat.a((UriMatcher) r11, (Uri) r5);
    L11:
        return ((ComponentName) r11).equals((ComponentName) r5);
    }
}
