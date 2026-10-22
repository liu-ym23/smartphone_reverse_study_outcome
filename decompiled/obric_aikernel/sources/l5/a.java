package l5;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import g5.c;
import h5.b;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PowerManager f10907c;

    public a(Context r10, c r11) {
        super(r10, r11);
        this.f10907c = (PowerManager) this.f9182a.getSystemService("power");
    }

    public int c() {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        PowerManager r10 = this.f10907c;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.getCurrentThermalStatus();
    L8:
        return -1;
    }
}
