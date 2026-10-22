package androidx.core.content;

import android.content.ClipData;
import android.content.ComponentName;
import android.net.Uri;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f453a;

    public /* synthetic */ d(int r5) {
        this.f453a = r5;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object r5) {
        switch(this.f453a) {
            case 0: goto L27;
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L17;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L9;
            case 10: goto L7;
            default: goto L5;
        };
    L5:
        return Predicate.e(r5);
    L7:
        return IntentSanitizer.Builder.o(r5);
    L9:
        return IntentSanitizer.Builder.q((ClipData) r5);
    L11:
        return IntentSanitizer.Builder.m((Uri) r5);
    L13:
        return IntentSanitizer.Builder.a((ComponentName) r5);
    L15:
        return IntentSanitizer.Builder.f((String) r5);
    L17:
        return IntentSanitizer.Builder.k((String) r5);
    L19:
        return IntentSanitizer.Builder.b((String) r5);
    L21:
        return IntentSanitizer.Builder.l((Uri) r5);
    L23:
        return IntentSanitizer.Builder.p((String) r5);
    L25:
        return IntentSanitizer.Builder.i(r5);
    L27:
        return IntentSanitizer.Builder.j((ComponentName) r5);
    }
}
