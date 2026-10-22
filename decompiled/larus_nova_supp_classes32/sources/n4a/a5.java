package n4a;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.loc.bo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class a5 extends bo {
    public a5() {
    }

    @Override // com.loc.bo
    public String e() {
        if (TextUtils.isEmpty(c()) == true) goto L5;
        String r0 = c();
        Uri r1 = UriProtector.parse(r0);
        if (r1.getAuthority().startsWith("dualstack-") == false) goto L10;
        return r0;
    L10:
        if (r1.getAuthority().startsWith("restsdk.amap.com") == false) goto L14;
        Uri.Builder r2 = r1.buildUpon();
        String r3 = "dualstack-arestapi.amap.com";
    L13:
        return r2.authority(r3).build().toString();
    L14:
        r2 = r1.buildUpon();
        r3 = "dualstack-" + r1.getAuthority();
        goto L13
    L5:
        return c();
    }
}
