package j7;

import ai.j0;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements p7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f18266b;

    public /* synthetic */ a(int r5) {
        this.f18265a = r5;
    }

    @Override // p7.b
    public final boolean a() {
        switch(this.f18265a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L4;
        };
    L4:
        return true;
    L7:
        return !TextUtils.isEmpty((String) this.f18266b);
    L9:
        return !TextUtils.isEmpty((String) this.f18266b);
    }

    public String toString() {
        switch(this.f18265a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        return j0.q(new StringBuilder("CommonLog{logType='"), (String) this.f18266b, "'}");
    L9:
        return j0.q(new StringBuilder("CommonEvent{serviceName='"), (String) this.f18266b, "'}");
    }

    public a(String r5, int r10, JSONObject r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        this.f18265a = 0;
        this.f18266b = r5;
    }
}
