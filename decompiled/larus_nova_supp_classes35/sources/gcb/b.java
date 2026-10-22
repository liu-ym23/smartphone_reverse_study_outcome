package gcb;

import android.text.TextUtils;
import com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static String a(String r2) {
        String r0 = jcb.b.c().a("docs_main_domain");
        if (TextUtils.isEmpty(r2) == false) goto L6;
        r2 = "www";
    L6:
        return r2 + '.' + r0;
    }

    public static String b(String r2) {
        String r0 = jcb.b.c().a(IDomainConfigService.DomainAlias.DOCS_MG_MAIN_DOMAIN);
        if (TextUtils.isEmpty(r0) == false) goto L6;
        r0 = jcb.b.c().a("docs_main_domain");
    L6:
        if (TextUtils.isEmpty(r2) == false) goto L9;
        r2 = "www";
    L9:
        return r2 + '.' + r0;
    }
}
