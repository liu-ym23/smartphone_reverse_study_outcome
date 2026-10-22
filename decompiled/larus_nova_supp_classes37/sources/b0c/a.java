package b0c;

import com.larksuite.framework.utils.b;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import e0c.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final String a(User r2) {
        if (r2 == null) goto L5;
        String r3 = r2.localizedDisplayName(((zzb.a) k.a(b.a, zzb.a.class)).getLanguageSetting());
        if (r3 == null) goto L5;
        return r3;
    L5:
        return "";
    }
}
