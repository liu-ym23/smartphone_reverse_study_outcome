package ta;

import android.os.Bundle;
import ge.p;

/* JADX INFO: loaded from: classes.dex */
public final class c extends he.j implements p<Bundle, String, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12330a = null;

    static {
        f12330a = new c();
    }

    public c() {
        super(2);
    }

    @Override // ge.p
    public final Object invoke(Bundle r8, String r10) {
        Bundle r11 = r8;
        String r12 = r10;
        he.i.f(r11, "bundle");
        he.i.f(r12, "key");
        return r11.get(r12);
    }
}
