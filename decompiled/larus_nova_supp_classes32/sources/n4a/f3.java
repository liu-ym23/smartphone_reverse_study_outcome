package n4a;

import android.os.SystemClock;
import com.amap.api.location.AMapLocation;
import com.loc.es;
import com.obric.assistant.AutoEndConversationTime;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f3 {
    public es a;
    public long b;
    public long c;
    public boolean d;
    public int e;
    public long f;
    public AMapLocation g;
    public long h;

    public f3() {
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.d = true;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = 0;
    }

    public final void b() {
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.g = null;
        this.h = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(es r3) {
        if (j4.m(r3) == true) goto L5;
        return;
    L5:
        if (this.d == true) goto L7;
    L13:
        int r0 = this.e;
    L14:
        r3.setLocationType(r0);
        return;
    L7:
        if (com.loc.h.e(r3.getTime()) == false) goto L13;
        if (r3.getLocationType() != 5) goto L11;
    L12:
        r0 = 4;
        goto L14
    L11:
        if (r3.getLocationType() == 6) goto L12;
    }

    public final AMapLocation a(AMapLocation r6) {
        if (j4.l(r6) == true) goto L5;
        return r6;
    L5:
        long r0 = SystemClock.elapsedRealtime() - this.h;
        this.h = SystemClock.elapsedRealtime();
        if (r0 <= 5000) goto L8;
        return r6;
    L8:
        AMapLocation r1 = this.g;
        if (r1 != null) goto L13;
        this.g = r6;
        return r6;
    L13:
        if (1 == r1.getLocationType()) goto L19;
        if ("gps".equalsIgnoreCase(this.g.getProvider()) == true) goto L19;
        this.g = r6;
        return r6;
    L19:
        if (this.g.getAltitude() == r6.getAltitude()) goto L21;
    L24:
        long r2 = Math.abs(r6.getTime() - this.g.getTime());
        if (AutoEndConversationTime.AFTER_30_SECONDS >= r2) goto L29;
        this.g = r6;
        return r6;
    L29:
        if (j4.a(r6, this.g) > (((((this.g.getSpeed() + r6.getSpeed()) * r2) / 2000.0f) + ((this.g.getAccuracy() + r6.getAccuracy()) * 2.0f)) + 3000.0f)) goto L31;
        this.g = r6;
        return r6;
    L31:
        return this.g;
    L21:
        if (this.g.getLongitude() != r6.getLongitude()) goto L24;
        this.g = r6;
        return r6;
    }
}
