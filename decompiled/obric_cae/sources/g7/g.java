package g7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f7730c;

    public g(JSONObject r8) {
        super(e.a.f7727b);
        this.f7730c = new HashMap();
        if (r8 != null) goto L5;
        return;
    L5:
        Iterator<String> r10 = r8.keys();
    L7:
        if (r10.hasNext() == false) goto L13;
        String r11 = r10.next();
        String r12 = r8.optString(r11);
        if (TextUtils.isEmpty(r11) == true) goto L7;
        if (TextUtils.isEmpty(r12) == true) goto L7;
        this.f7730c.put(r11, r12);
        goto L7
    }

    @Override // g7.e
    public final String a(Uri r8) {
        String r10 = r8.getHost();
        String r11 = r8.toString();
        String r12 = (String) this.f7730c.get(r10);
        if (TextUtils.isEmpty(r12) == true) goto L6;
        Logger.d("g", "replace host " + r12 + " for " + r10);
        return r11.replaceFirst(r10, r12);
    L6:
        return r11;
    }

    @Override // g7.e
    public final void b() {
    }
}
