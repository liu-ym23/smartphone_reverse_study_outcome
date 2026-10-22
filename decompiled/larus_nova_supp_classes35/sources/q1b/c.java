package q1b;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class c implements a {
    public final m a;
    public final l b;

    @Override // q1b.a
    public final l g() {
        return this.b;
    }

    @Override // q1b.a
    public final m r9() {
        return this.a;
    }

    @Inject
    public c(m r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "p");
        Intrinsics.checkNotNullParameter(r3, "r");
        this.a = r2;
        this.b = r3;
    }
}
