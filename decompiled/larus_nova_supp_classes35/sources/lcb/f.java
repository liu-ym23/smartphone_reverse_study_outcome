package lcb;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class f implements mcb.c {

    @Inject
    public String a;

    @Inject
    public mcb.b b;

    @Inject
    public j c;

    @Override // mcb.c
    public final String a(String r3) {
        Log.d("UserDomainConfigService", "getDomain called, alias: ".concat(r3));
        return this.b.e0(this.a, r3);
    }

    @Override // mcb.c
    public final List<String> b(String r3) {
        Log.d("UserDomainConfigService", "getDomains called, alias: " + r3);
        return this.b.A(this.a, r3);
    }

    @Inject
    public f(j r3, mcb.b r4) {
        Log.i("UserDomainConfigService", "UserDomainConfigService start");
        this.c = r3;
        this.b = r4;
        Log.i("UserDomainConfigService", "UserDomainConfigService finish");
        if (TextUtils.isEmpty(this.a) == false) goto L5;
        Log.w("UserDomainConfigService", "wtf, invalid uid within user-state-framework.");
        return;
    L5:
        Log.i("UserDomainConfigService", "uid info:" + this.a);
    }
}
