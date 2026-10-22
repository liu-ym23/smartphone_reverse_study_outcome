package nta;

import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class c {
    public c a;

    public c() {
    }

    public abstract void a(String r1);

    public abstract String c(String r1);

    public void b(String r2) {
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final String d(String r6, String r7) {
        c r0 = this.a;
        String r1 = c("device_id");
        boolean r2 = !TextUtils.isEmpty(r6);
        boolean r4 = !TextUtils.isEmpty(r1);
        if (r2 == true) goto L6;
        if (r4 == false) goto L6;
        r6 = r1;
    L6:
        if (r0 == null) goto L10;
        r6 = r0.d(r6, r7);
        if (StringUtils.equal(r6, r1) == true) goto L21;
        a(r6);
    L21:
        return r6;
    L10:
        if (r2 == true) goto L13;
        if (r4 == true) goto L13;
        r6 = r7;
        boolean r8 = true;
    L14:
        if (r8 == true) goto L16;
    L17:
        if (r2 == false) goto L21;
        if (StringUtils.equal(r6, r1) == true) goto L21;
    L20:
        a(r6);
        goto L21
    L16:
        if ((!TextUtils.isEmpty(r6)) == true) goto L20;
    L13:
        r8 = false;
        goto L14
    }
}
