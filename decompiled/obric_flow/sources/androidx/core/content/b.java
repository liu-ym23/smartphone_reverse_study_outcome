package androidx.core.content;

import android.content.ComponentName;
import android.net.Uri;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f450b;

    public /* synthetic */ b(String r5, int r10) {
        this.f449a = r10;
        this.f450b = r5;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object r5) {
        int r10 = this.f449a;
        String r11 = this.f450b;
        switch(r10) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            default: goto L5;
        };
    L5:
        return IntentSanitizer.Builder.h((Uri) r5, r11);
    L7:
        return IntentSanitizer.Builder.d((Uri) r5, r11);
    L9:
        return IntentSanitizer.Builder.n((Uri) r5, r11);
    L11:
        return IntentSanitizer.Builder.c(r11, (ComponentName) r5);
    L13:
        return r11.equals((String) r5);
    L15:
        return IntentSanitizer.Builder.g((Uri) r5, r11);
    }
}
