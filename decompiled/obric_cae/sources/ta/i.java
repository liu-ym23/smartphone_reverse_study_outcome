package ta;

import android.os.Bundle;
import ge.p;

/* JADX INFO: loaded from: classes.dex */
public final class i extends he.j implements p<Bundle, String, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f12363a = null;

    static {
        f12363a = new i();
    }

    public i() {
        super(2);
    }

    @Override // ge.p
    public final Object invoke(Bundle r8, String r10) {
        Bundle r11 = r8;
        String r12 = r10;
        he.i.f(r11, "b");
        he.i.f(r12, "k");
        return r11.get(r12);
    }
}
