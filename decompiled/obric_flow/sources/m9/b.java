package m9;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import zm.p;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f20028c;

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        if (p.f23507a != null) goto L5;
        p.f23507a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    L5:
        r5.append(p.f23507a.format(new Date(this.f20028c)));
        r5.append(" : ");
        r5.append(this.f20026a);
        r5.append(' ');
        r5.append(this.f20027b);
        return r5.toString();
    }
}
