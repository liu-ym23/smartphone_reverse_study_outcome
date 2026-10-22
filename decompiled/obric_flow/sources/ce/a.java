package ce;

import android.webkit.ValueCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f1173b;

    public a(b r5, String r10) {
        this.f1173b = r5;
        this.f1172a = r10;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r5) {
        String r10 = (String) r5;
        String r11 = this.f1172a;
        b r12 = this.f1173b;
        r12.getClass();
        r12.c(new JSONObject("{a=" + r10 + "}").optString("a", ""), r11);     // Catch: JSONException -> L5
        return;
    }
}
