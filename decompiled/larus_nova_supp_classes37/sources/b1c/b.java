package b1c;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final Context a;

    public b(Context r1) {
        this.a = r1;
    }

    public final String a(String r3) {
        String r0 = z.c(this.a);
        if (TextUtils.isEmpty(r3) == false) goto L10;
        if (TextUtils.isEmpty(r0) == false) goto L10;
        throw new IllegalArgumentException("shared preference name should be passed!");
    L10:
        if (TextUtils.isEmpty(r3) == false) goto L14;
        return r0 + ":unknown";
    L14:
        if (TextUtils.isEmpty(r0) == false) goto L17;
        return r3;
    L17:
        return r0 + ":" + r3;
    }
}
