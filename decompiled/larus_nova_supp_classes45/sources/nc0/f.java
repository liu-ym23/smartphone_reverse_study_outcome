package nc0;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements lc0.a {
    public final kc0.e a;

    @Override // lc0.a
    public final boolean V() {
        return this.a.V();
    }

    @Override // lc0.a
    public final boolean a() {
        return this.a.a();
    }

    @Override // lc0.a
    public final boolean c() {
        return this.a.c();
    }

    @Override // lc0.a
    public final Map<String, String> e() {
        return this.a.e();
    }

    @Override // lc0.a
    public final String g() {
        return this.a.g();
    }

    @Override // lc0.a
    public final String getConnectionType() {
        return this.a.getConnectionType();
    }

    @Override // lc0.a
    public final int getCurrentMode() {
        return this.a.getCurrentMode();
    }

    @Override // lc0.a
    public final int getMixStreamType() {
        return this.a.getMixStreamType();
    }

    @Override // lc0.a
    public final Map<String, String> h() {
        return this.a.h();
    }

    @Override // lc0.a
    public final boolean i() {
        return this.a.i();
    }

    @Override // lc0.a
    public final void m() {
        this.a.m();
    }

    @Override // lc0.a
    public final boolean p() {
        return this.a.p();
    }

    public f(kc0.e r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }

    @Override // lc0.a
    public final void b(int r2) {
        this.a.b(r2);
    }

    @Override // lc0.a
    public final void f(boolean r2) {
        this.a.f(r2);
    }

    @Override // lc0.a
    public final void unLoadOtherWidget(int r2) {
        this.a.unLoadOtherWidget(r2);
    }

    @Override // lc0.a
    public final void d(String r2, HashMap<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.a.d(r2, r3);
    }

    @Override // lc0.a
    public final boolean j(String r1, int r2, String r3, String r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r1, "guideType");
        Intrinsics.checkNotNullParameter(r3, "toUserGroup");
        Intrinsics.checkNotNullParameter(r4, "page");
        return this.a.r5(r1, r3, r4, r5);
    }
}
