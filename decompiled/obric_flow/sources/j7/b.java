package j7;

import ai.j0;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements p7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f18268b;

    public b(String r5, JSONObject r10) {
        this.f18267a = r5;
        this.f18268b = r10;
    }

    @Override // p7.b
    public final boolean a() {
        return !TextUtils.isEmpty(this.f18267a);
    }

    public final String toString() {
        return j0.q(new StringBuilder("Apm5LegacyEvent{logType='"), this.f18267a, "'}");
    }
}
