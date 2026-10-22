package oh;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f20577a;

    public e() {
        this.f20577a = new HashMap();
    }

    public final void a(zg.c r5) {
        c r10 = c.f20573c;
        com.bytedance.pia.core.utils.j.A("[EnvService] initialize cost: start=" + r10.f20574a + ", end=" + r10.f20575b + ".");
        String r11 = r5.f23441a;
        if (TextUtils.isEmpty(r11) == true) goto L7;
        this.f20577a.put(r11, r5);
        return;
    L7:
        throw null;
    }
}
