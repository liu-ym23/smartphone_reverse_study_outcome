package okhttp3;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f20674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20675b;

    public l(String r5, Map r10) {
        Intrinsics.checkNotNullParameter(r5, "scheme");
        Intrinsics.checkNotNullParameter(r10, "authParams");
        this.f20675b = r5;
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        String r15 = (String) r13.getValue();
        if (r14 == null) goto L8;
        String r16 = r14.toLowerCase(Locale.US);
    L9:
        r11.put(r16, r15);
        goto L4
    L8:
        r16 = null;
        goto L9
    L10:
        this.f20674a = Collections.unmodifiableMap(r11);
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof l) == false) goto L9;
        l r10 = (l) r5;
        if (Intrinsics.areEqual(r10.f20675b, this.f20675b) == false) goto L9;
        if (Intrinsics.areEqual(r10.f20674a, this.f20674a) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(899, 31, this.f20675b);
        return this.f20674a.hashCode() + r5;
    }

    public final String toString() {
        return this.f20675b + " authParams=" + this.f20674a;
    }
}
