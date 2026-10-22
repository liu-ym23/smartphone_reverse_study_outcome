package u4;

import com.bytedance.keva.KevaImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONObject;
import r3.c;
import y3.i;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f12461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d4.c f12462h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f12463i;

    public a(c r8, d4.c r10, long r11) {
        this.f12455a = 0;
        this.f12457c = 0;
        this.f12458d = 0;
        this.f12459e = 0;
        this.f12460f = 0;
        this.f12461g = r8;
        this.f12462h = r10;
        this.f12463i = r11;
    }

    public final boolean a(int r11) {
        if (this.f12455a <= 0) goto L11;
        long r8 = System.currentTimeMillis();
        long r10 = this.f12457c;
        long r12 = this.f12463i;
        if (r8 >= (r10 + r12)) goto L10;
        int r13 = this.f12458d;
        if (r13 < this.f12456b) goto L9;
        return true;
    L9:
        this.f12458d = r13 + 1;
        goto L11
    L10:
        this.f12457c = (((r8 - r10) / r12) * r12) + r10;
        this.f12458d = 1;
    L11:
        int r14 = this.f12455a;
        if (r14 < 10000) goto L14;
        return true;
    L14:
        if (r14 <= 0) goto L20;
        if (r14 >= 10000) goto L20;
        if (new Random().nextInt(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) >= this.f12455a) goto L20;
        return true;
    L20:
        if (this.f12459e <= 0) goto L23;
        if (1 != r11) goto L23;
    L26:
        return true;
    L23:
        if (this.f12460f > 0) goto L25;
        return false;
    L25:
        if (3 == r11) goto L26;
        return false;
    }

    public final void b(JSONObject r8, long r10, m4.b r11) {
        this.f12463i = r10;
        int r12 = r8.optInt("backoff_ratio", 0);
        this.f12455a = r12;
        if (r12 >= 0) goto L5;
    L6:
        this.f12455a = 0;
    L8:
        if (r11 == null) goto L10;
        r11.getClass();
        int r13 = Integer.MAX_VALUE;
    L11:
        int r14 = r8.optInt("max_request_frequency", r13);
        this.f12456b = r14;
        if (r14 > 0) goto L14;
        this.f12456b = 12;
    L14:
        int r15 = this.f12455a;
        if (r15 > 0) goto L17;
    L19:
        if (r15 != 0) goto L21;
        this.f12457c = 0;
        this.f12458d = 0;
    L21:
        this.f12459e = r8.optInt("disable_session_start_request", 0);
        this.f12460f = r8.optInt("disable_session_end_request", 0);
        if (this.f12455a != 0) goto L45;
        int r16 = this.f12456b;
        if (r16 <= 0) goto L45;
        y3.c r17 = this.f12462h.f6769m;
        if (r17 == null) goto L45;
        ArrayList r18 = r17.f13944t;
        if (r18 == null) goto L45;
        if (r18.isEmpty() == true) goto L45;
        Iterator r19 = r17.f13944t.iterator();
    L33:
        if (r19.hasNext() == false) goto L45;
        y3.a r20 = (y3.a) r19.next();
        if ((r20 instanceof i) == false) goto L33;
        i r21 = (i) r20;
        if (r11 != null) goto L39;
        r21.getClass();
        goto L33
    L39:
        if (r11 != r21.f13967h) goto L33;
        Iterator<b> r22 = r21.f13966g.values().iterator();
    L42:
        if (r22.hasNext() == false) goto L33;
        r22.next().f12473i[0][2] = r16;
    L45:
        this.f12461g.H.l(0, Collections.singletonList("BackoffController"), "parseBackoffControllerFromResp mEventInterval: " + this.f12463i + ", mBackoffRatio: " + this.f12455a + ", mMaxRequestFrequency: " + this.f12456b + ", mBackoffWindowStartTime: " + this.f12457c + ", mBackoffWindowSendCount: " + this.f12458d + ", mDisableSessionStartRequest: " + this.f12459e + ", mDisableSessionEndRequest: " + this.f12460f, new Object[0]);
        return;
    L17:
        if (this.f12457c != 0) goto L19;
        this.f12457c = System.currentTimeMillis();
        this.f12458d = 1;
        goto L21
    L10:
        r13 = 12;
        goto L11
    L5:
        if (r12 <= 10000) goto L8;
        goto L6
    }
}
