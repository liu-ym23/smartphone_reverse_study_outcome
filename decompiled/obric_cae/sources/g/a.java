package g;

import android.content.Context;
import android.content.res.Configuration;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7434a;

    public a(Context r8) {
        this.f7434a = r8;
    }

    public final int a() {
        Configuration r8 = this.f7434a.getResources().getConfiguration();
        int r10 = r8.screenWidthDp;
        int r11 = r8.screenHeightDp;
        if (r8.smallestScreenWidthDp > 600) goto L27;
        if (r10 <= 600) goto L6;
        return 5;
    L6:
        if (r10 <= 960) goto L8;
        if (r11 <= 720) goto L8;
        return 5;
    L8:
        if (r10 <= 720) goto L12;
        if (r11 <= 960) goto L12;
        return 5;
    L12:
        if (r10 < 500) goto L14;
        return 4;
    L14:
        if (r10 <= 640) goto L16;
        if (r11 <= 480) goto L16;
        return 4;
    L16:
        if (r10 <= 480) goto L20;
        if (r11 <= 640) goto L20;
        return 4;
    L20:
        if (r10 < 360) goto L23;
        return 3;
    L23:
        return 2;
    L27:
        return 5;
    }
}
