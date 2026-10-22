package j5;

import android.text.TextUtils;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class g implements e.c<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f8662a;

    public g(e r8) {
        this.f8662a = r8;
    }

    @Override // j5.e.c
    public final boolean a(String r8, String r10) {
        return x0.e(r8, r10);
    }

    @Override // j5.e.c
    public final String b(String r8, String r10, e r11) {
        return (String) r11.g(r8, r10, new g(r11));
    }

    @Override // j5.e.c
    public final boolean c(String r8) {
        String r10 = r8;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(r10, "unknown") == true) goto L7;
        return true;
    }

    @Override // j5.e.c
    public final void d(String r8) {
        e r10 = this.f8662a;
        r10.b("serial_number", r8);
    }

    @Override // j5.e.c
    public final String e() {
        return this.f8662a.c("serial_number");
    }
}
