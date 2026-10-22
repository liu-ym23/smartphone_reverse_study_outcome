package ce;

import ai.j0;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1180c;
    public JSONObject d;
    public int e;
    public String f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f1182i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1183j;

    public d() {
        this.f1183j = true;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("JsMsg{type='");
        r5.append(this.f1178a);
        r5.append("', callback_id='");
        r5.append(this.f1179b);
        r5.append("', func='");
        r5.append(this.f1180c);
        r5.append("', params=");
        r5.append(this.d);
        r5.append(", version=");
        r5.append(this.e);
        r5.append(", namespace=");
        r5.append(this.f);
        r5.append(", iFrameUrl=");
        r5.append(this.g);
        r5.append(", safeV1AuthUrl=");
        r5.append(this.f1181h);
        r5.append(", permissionGroup=");
        if (TextUtils.isEmpty(this.f1182i) == false) goto L5;
        String r10 = "";
    L7:
        return j0.p(r5, r10, '}');
    L5:
        r10 = this.f1182i;
        goto L7
    }
}
