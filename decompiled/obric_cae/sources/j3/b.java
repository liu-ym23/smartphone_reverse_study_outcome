package j3;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements k3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8579a;

    public b(String r8, JSONObject r10) {
        this.f8579a = r8;
    }

    @Override // k3.c
    public final boolean isValid() {
        return !TextUtils.isEmpty(this.f8579a);
    }

    public final String toString() {
        return android.aimedia.a.i(new StringBuilder("CommonLog{logType='"), this.f8579a, "'}");
    }
}
