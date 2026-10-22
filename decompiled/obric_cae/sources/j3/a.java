package j3;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements k3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8578a;

    public a(String r8, int r10, JSONObject r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        this.f8578a = r8;
    }

    @Override // k3.c
    public final boolean isValid() {
        return !TextUtils.isEmpty(this.f8578a);
    }

    public final String toString() {
        return android.aimedia.a.i(new StringBuilder("CommonEvent{serviceName='"), this.f8578a, "'}");
    }
}
