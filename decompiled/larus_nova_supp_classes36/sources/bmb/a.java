package bmb;

import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.k;
import e0c.l;
import f0c.h;
import jdb.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final l a;
    public final g b;

    /* JADX INFO: renamed from: bmb.a$a, reason: collision with other inner class name */
    public static final class C0011a implements c {
        public C0011a() {
        }

        public final void afterUserOffline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final void afterUserOnline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final /* synthetic */ Object generatedComponent() {
            return DwarfComponentProvider.-CC.$default$generatedComponent(this);
        }

        public final /* synthetic */ m getPassport() {
            return d0c.b.a(this);
        }

        public final void onUserOffline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final void onUserOnline(h r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final UserSession e9() {
            return ((j) k.a(LarkContext.getApplication(), j.class)).f();
        }

        public final l provideComponent() {
            UserSession r0 = e9();
            return ((v) k.a(LarkContext.getApplication(), v.class)).c(r0);
        }

        /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
        public final /* bridge */ /* synthetic */ Object m0provideComponent() {
            return provideComponent();
        }
    }

    public static final class b {
    }

    static {
    }

    public a() {
        C0011a r0 = new C0011a();
        Intrinsics.checkNotNullParameter(r0, "userScopeView");
        l r1 = r0.provideComponent();
        this.a = r1;
        r0.e9();
        Intrinsics.checkNotNullParameter(dn4.a.class, "userScopeApi");
        this.b = ((dn4.a) k.b(r1, dn4.a.class)).a();
    }
}
