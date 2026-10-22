package f0;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import he.i;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final void a(Bundle r8, String r10, Size r11) {
        i.f(r8, "bundle");
        i.f(r10, "key");
        r8.putSize(r10, r11);
    }

    public static final void b(Bundle r8, String r10, SizeF r11) {
        i.f(r8, "bundle");
        i.f(r10, "key");
        r8.putSizeF(r10, r11);
    }
}
