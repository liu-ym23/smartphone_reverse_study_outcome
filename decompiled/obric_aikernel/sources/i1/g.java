package i1;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class g extends a {
    g(int r10, Set<String> r11, Map<String, List<Set<String>>> r12, Map<String, List<Map<String, Object>>> r13) {
        super(r10, r11, r12, r13);
    }

    @Override // i1.a
    boolean d(i r10) {
        int r11 = a();
        if (r11 >= 0) goto L6;
        return true;
    L6:
        if (r11 <= 0) goto L8;
        return false;
    L8:
        if (r10 != null) goto L10;
    L16:
        return false;
    L10:
        if (TextUtils.isEmpty(r10.a()) == true) goto L16;
        if (TextUtils.isEmpty(r10.b()) == true) goto L16;
        return !j1.c.a(r10.a() + ":" + r10.b(), WorkRequest.MIN_BACKOFF_MILLIS, this.f9363a);
    }
}
