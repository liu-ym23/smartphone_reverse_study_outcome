package androidx.core.content;

import android.net.Uri;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class d implements Predicate {
    public final /* synthetic */ String a;

    public /* synthetic */ d(String r1) {
        this.a = r1;
    }

    public final /* synthetic */ Predicate and(Predicate r1) {
        return Predicate.-CC.$default$and(this, r1);
    }

    public final /* synthetic */ Predicate negate() {
        return Predicate.-CC.$default$negate(this);
    }

    public final /* synthetic */ Predicate or(Predicate r1) {
        return Predicate.-CC.$default$or(this, r1);
    }

    public final boolean test(Object r2) {
        return IntentSanitizer.Builder.g(this.a, (Uri) r2);
    }
}
