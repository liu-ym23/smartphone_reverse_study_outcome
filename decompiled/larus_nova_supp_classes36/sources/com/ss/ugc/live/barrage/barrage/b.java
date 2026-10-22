package com.ss.ugc.live.barrage.barrage;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final List<Path> a;

    public b() {
        PorterDuffXfermode r0 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r1 = new Paint();
        r1.setColor(-1);
        r1.setAntiAlias(true);
        r1.setDither(true);
        r1.setXfermode(r0);
        this.a = new ArrayList();
    }

    public final void update(List<? extends Path> r2) {
        ((ArrayList) this.a).clear();
        ArrayList r0 = (ArrayList) this.a;
        r0.addAll(r2);
    }
}
