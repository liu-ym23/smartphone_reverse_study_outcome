package qa;

import android.os.SystemClock;
import com.amap.api.location.AMapLocation;
import com.loc.es;
import com.obric.cae.cloud.CloudServiceConstants;

/* JADX INFO: loaded from: classes.dex */
public final class w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public es f11174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f11179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AMapLocation f11180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f11181h;

    public w2() {
        this.f11174a = null;
        this.f11175b = 0;
        this.f11176c = 0;
        this.f11177d = true;
        this.f11178e = 0;
        this.f11179f = 0;
        this.f11180g = null;
        this.f11181h = 0;
    }

    public final AMapLocation a(AMapLocation r8) {
        if (y3.k(r8) == true) goto L5;
        return r8;
    L5:
        long r10 = SystemClock.elapsedRealtime() - this.f11181h;
        this.f11181h = SystemClock.elapsedRealtime();
        if (r10 <= 5000) goto L8;
        return r8;
    L8:
        AMapLocation r11 = this.f11180g;
        if (r11 != null) goto L13;
        this.f11180g = r8;
        return r8;
    L13:
        if (1 == r11.f3649z) goto L19;
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equalsIgnoreCase(r11.getProvider()) == true) goto L19;
        this.f11180g = r8;
        return r8;
    L19:
        if (this.f11180g.getAltitude() == r8.C) goto L21;
    L24:
        long r12 = Math.abs(r8.getTime() - this.f11180g.getTime());
        if (30000 >= r12) goto L28;
        this.f11180g = r8;
        return r8;
    L28:
        float r13 = ((r8.D + this.f11180g.getSpeed()) * r12) / 2000.0f;
        if (y3.a(r8, this.f11180g) > ((((r8.getAccuracy() + this.f11180g.getAccuracy()) * 2.0f) + r13) + 3000.0f)) goto L31;
        this.f11180g = r8;
        return r8;
    L31:
        return this.f11180g;
    L21:
        if (this.f11180g.getLongitude() != r8.B) goto L24;
        this.f11180g = r8;
        return r8;
    }

    public final void b() {
        this.f11174a = null;
        this.f11175b = 0;
        this.f11176c = 0;
        this.f11180g = null;
        this.f11181h = 0;
    }

    public final void c(es r8) {
        if (y3.l(r8) == true) goto L5;
        return;
    L5:
        if (this.f11177d == true) goto L7;
    L13:
        int r10 = this.f11178e;
    L14:
        r8.x(r10);
        return;
    L7:
        if (s3.e(r8.getTime()) == false) goto L13;
        int r11 = r8.f3649z;
        if (r11 != 5) goto L11;
    L12:
        r10 = 4;
        goto L14
    L11:
        if (r11 == 6) goto L12;
    }
}
