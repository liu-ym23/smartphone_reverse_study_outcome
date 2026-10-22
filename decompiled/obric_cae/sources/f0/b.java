package f0;

import android.os.Bundle;
import android.os.IBinder;
import he.i;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final void a(Bundle r8, String r10, IBinder r11) {
        i.f(r8, "bundle");
        i.f(r10, "key");
        r8.putBinder(r10, r11);
    }
}
