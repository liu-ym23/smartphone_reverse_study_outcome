package i1;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    e(int r10, Set<String> r11, Map<String, List<Set<String>>> r12, Map<String, List<Map<String, Object>>> r13) {
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
    L18:
        return false;
    L10:
        if (TextUtils.isEmpty(r10.b()) == true) goto L18;
        if ((Long.parseLong(r10.b()) % WorkRequest.MIN_BACKOFF_MILLIS) < this.f9363a) goto L17;
        return true;
    L17:
        return false;
    }
}
