package qa;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class n4 extends m0 {
    @Override // qa.m0
    public String e() {
        boolean r8 = TextUtils.isEmpty(c());
        String r10 = c();
        if (r8 == false) goto L5;
        return r10;
    L5:
        Uri r11 = Uri.parse(r10);
        if (r11.getAuthority().startsWith("dualstack-") == false) goto L9;
        return r10;
    L9:
        if (r11.getAuthority().startsWith("restsdk.amap.com") == false) goto L13;
        Uri.Builder r12 = r11.buildUpon();
        String r13 = "dualstack-arestapi.amap.com";
    L12:
        return r12.authority(r13).build().toString();
    L13:
        r12 = r11.buildUpon();
        r13 = "dualstack-" + r11.getAuthority();
        goto L12
    }
}
