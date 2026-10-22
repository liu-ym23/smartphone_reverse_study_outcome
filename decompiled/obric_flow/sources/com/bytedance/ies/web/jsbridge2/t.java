package com.bytedance.ies.web.jsbridge2;

import android.os.SystemClock;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f6309c;
    public long d;
    public HashMap e;
    public final SimpleDateFormat f;

    public t() {
        this.f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ROOT);
    }

    public final void a(String r5, Object r10) {
        if (this.e != null) goto L5;
        this.e = new HashMap();
    L5:
        this.e.put(r5, r10);
    }

    public final void b(String r5, List r10) {
        this.f6308b = this.f.format(new Date());
        this.d = SystemClock.elapsedRealtime();
        this.f6309c = System.currentTimeMillis();
        this.f6307a = r5;
        TimeLineEvent r11 = new TimeLineEvent(this, null);
        if (r10 == null) goto L6;
        r10.add(r11);
        return;
    }
}
