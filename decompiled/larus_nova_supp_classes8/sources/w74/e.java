package w74;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public final String a;
    public final List<Pair<String, String>> b;
    public final String c;

    public final String toString() {
        return "DeviceResponse{\n body=" + this.c + "\n headers=" + this.b + "\n code=200\n url='" + this.a + "'}";
    }

    public e(String r1, List r2, String r3) {
        this.a = r1;
        if (r2 != null) goto L5;
        this.b = new ArrayList();
    L6:
        this.c = r3;
        return;
    L5:
        this.b = Collections.unmodifiableList(new ArrayList(r2));
        goto L6
    }
}
