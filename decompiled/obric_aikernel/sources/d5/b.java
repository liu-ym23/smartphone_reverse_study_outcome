package d5;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f8496a;

    public b() {
        this.f8496a = new CopyOnWriteArraySet();
    }

    public void a(JSONObject r10) {
        this.f8496a.clear();
        JSONArray r11 = r10.optJSONArray("dl");
        if (r11 == null) goto L11;
        int r12 = 0;
    L6:
        if (r12 >= r11.length()) goto L15;
        String r13 = r11.optString(r12);
        if (TextUtils.isEmpty(r13) == true) goto L10;
        this.f8496a.add(r13);
    L10:
        r12 = r12 + 1;
        goto L6
    L15:
        return;
    }

    public boolean b() {
        if (this.f8496a.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void c(n4.c r10) {
        if (TTHttpCallPriorityControl.k(this.f8496a, r10.A()) == true) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d("RequestDropController", "check drop and match " + r10.A());
    L8:
        throw new DroppedByThrottleControlException();
    }
}
