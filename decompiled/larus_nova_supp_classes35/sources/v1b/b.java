package v1b;

import com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonWebViewManager;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class b implements a {
    public final ChameleonWebViewManager a;

    @Override // v1b.a
    public final void destroyAll() {
        this.a.b();
    }

    @Inject
    public b() {
        this.a = new ChameleonWebViewManager();
    }

    @Override // v1b.a
    public final ChameleonWebViewManager F2() {
        return this.a;
    }
}
