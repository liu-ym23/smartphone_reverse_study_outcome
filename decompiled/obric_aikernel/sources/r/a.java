package r;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f12508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f12509g;

    public a() {
    }

    public long b() {
        int r10 = this.f12507e;
        if (r10 == 1) goto L9;
        if (r10 == 0) goto L9;
        return (this.f12510a + System.currentTimeMillis()) - SystemClock.elapsedRealtime();
    L9:
        return this.f12510a;
    }

    public boolean c() {
        int r10 = this.f12507e;
        if (r10 == 2) goto L7;
        if (r10 == 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Nullable
    public JSONObject d() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L4
        r10.put("start_time", this.f12510a);     // Catch: Throwable -> L4
        r10.put("end_time", this.f12511b);     // Catch: Throwable -> L4
        r10.put("thread_name", this.f12512c);     // Catch: Throwable -> L4
        r10.put("thread_stack", a());     // Catch: Throwable -> L4
        r10.put("interval", this.f12508f);     // Catch: Throwable -> L4
        r10.put(WsConstants.KEY_CONNECTION_TYPE, this.f12507e);     // Catch: Throwable -> L4
        r10.put("intent_info", this.f12509g);     // Catch: Throwable -> L4
        return r10;
    L4:
        return null;
    }

    public String toString() {
        return "AlarmInfo{type=" + this.f12507e + ", interval=" + this.f12508f + ", intentInfo=" + this.f12509g + ", startTime=" + this.f12510a + ", endTime=" + this.f12511b + ", threadName=" + this.f12512c + ", threadStack=" + a() + '}';
    }
}
