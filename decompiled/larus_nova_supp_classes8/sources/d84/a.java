package d84;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public final String a;
    public final int b;
    public final List<Pair<String, String>> c;
    public final String d;

    public final String toString() {
        return "DeviceResponse{\n body=" + this.d + "\n headers=" + this.c + "\n code=" + this.b + "\n url='" + this.a + "'}";
    }

    public a(String r1, int r2, List<Pair<String, String>> r3, String r4) {
        this.a = r1;
        this.b = r2;
        if (r3 != null) goto L5;
        this.c = new ArrayList();
    L6:
        this.d = r4;
        return;
    L5:
        this.c = Collections.unmodifiableList(new ArrayList(r3));
        goto L6
    }
}
