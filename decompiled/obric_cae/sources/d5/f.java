package d5;

import android.text.TextUtils;
import org.json.JSONObject;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public final class f extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0 f6790e;

    public f(j0 r8) {
        super(true, true);
        this.f6790e = r8;
    }

    @Override // d5.d
    public final boolean a(JSONObject r8) {
        String r10 = x4.m.b(this.f6790e);
        if (TextUtils.isEmpty(r10) == true) goto L6;
        r8.put("cdid", r10);
        return true;
    L6:
        return false;
    }

    @Override // d5.d
    public final void b(JSONObject r8) {
        r8.remove("cdid");
    }
}
