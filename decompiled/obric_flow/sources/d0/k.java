package d0;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class k implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f16554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Map f16555c;

    public k(Map r5) {
        this.f16554b = Collections.unmodifiableMap(r5);
    }

    public final HashMap a() {
        HashMap r5 = new HashMap();
        Iterator r10 = this.f16554b.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L16;
        Map.Entry r11 = (Map.Entry) r10.next();
        List r12 = (List) r11.getValue();
        StringBuilder r13 = new StringBuilder();
        int r14 = r12.size();
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L13;
        String r16 = ((j) r12.get(r15)).f16553a;
        if (TextUtils.isEmpty(r16) == true) goto L12;
        r13.append(r16);
        if (r15 == (r12.size() - 1)) goto L12;
        r13.append(',');
    L12:
        r15 = r15 + 1;
        goto L6
    L13:
        String r17 = r13.toString();
        if (TextUtils.isEmpty(r17) == true) goto L4;
        r5.put(r11.getKey(), r17);
        goto L4
    L16:
        return r5;
    }

    public final Map b() {
        if (this.f16555c != null) goto L15;
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (this.f16555c != null) goto L10;
        this.f16555c = Collections.unmodifiableMap(a());     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
    L15:
        return this.f16555c;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof k) == true) goto L5;
        return false;
    L5:
        return this.f16554b.equals(((k) r5).f16554b);
    }

    public final int hashCode() {
        return this.f16554b.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.f16554b + '}';
    }
}
