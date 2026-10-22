package cn8;

import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.font.FontLevel;
import kc8.y;
import kotlin.Lazy;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements b {
    public final kc8.b a;

    @Override // cn8.b
    public final boolean c() {
        kc8.b r0 = this.a;
        if (r0 == null) goto L9;
        y r1 = r0.a;
        if (r1 == null) goto L9;
        q0 r2 = r1.x;
        if (r2 == null) goto L9;
        Integer r3 = r2.I7();
    L10:
        if (r3 == null) goto L12;
        return true;
    L12:
        return false;
    L9:
        r3 = null;
        goto L10
    }

    @Override // cn8.b
    public final float getFontScale() {
        Lazy r0 = we8.e.a;
        int r1 = we8.e.d;
        if (r1 != FontLevel.EXTRA_LARGE.getValue()) goto L6;
        return 1.1f;
    L6:
        if (r1 != FontLevel.SMALL.getValue()) goto L8;
        return 0.8f;
    L8:
        return 1.0f;
    }

    @Override // cn8.b
    public final boolean isDarkMode() {
        boolean r0 = h.a;
        return h.a(null);
    }

    public c(kc8.b r1) {
        this.a = r1;
    }
}
