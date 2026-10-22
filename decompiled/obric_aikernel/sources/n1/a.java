package n1;

import androidx.annotation.NonNull;
import com.bytedance.applog.c;
import java.util.Collections;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f11161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f11165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final g1.b f11166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f11167i;

    public a(c r10, g1.b r11, long r12) {
        this.f11159a = 0;
        this.f11161c = 0;
        this.f11162d = 0;
        this.f11163e = 0;
        this.f11164f = 0;
        this.f11165g = r10;
        this.f11166h = r11;
        this.f11167i = r12;
    }

    private int b(h1.b r10) {
        if (r10 != null) goto L4;
        return 12;
    L4:
        if ((-1) != r10.f()) goto L7;
        return 12;
    L7:
        if (r10.f() != 0) goto L10;
        return Integer.MAX_VALUE;
    L10:
        return 60;
    }

    public boolean a(int r11) {
        if (this.f11159a <= 0) goto L11;
        long r10 = System.currentTimeMillis();
        long r12 = this.f11161c;
        long r13 = this.f11167i;
        if (r10 >= (r12 + r13)) goto L10;
        int r14 = this.f11162d;
        if (r14 < this.f11160b) goto L9;
        return true;
    L9:
        this.f11162d = r14 + 1;
        goto L11
    L10:
        this.f11161c = r12 + (((r10 - r12) / r13) * r13);
        this.f11162d = 1;
    L11:
        int r15 = this.f11159a;
        if (r15 < 10000) goto L14;
        return true;
    L14:
        if (r15 <= 0) goto L20;
        if (r15 >= 10000) goto L20;
        if (new Random().nextInt(10000) >= this.f11159a) goto L20;
        return true;
    L20:
        if (this.f11163e <= 0) goto L23;
        if (1 != r11) goto L23;
    L26:
        return true;
    L23:
        if (this.f11164f > 0) goto L25;
        return false;
    L25:
        if (3 == r11) goto L26;
        return false;
    }

    public void c(@NonNull JSONObject r10, long r11, h1.b r12) {
        this.f11167i = r11;
        int r13 = r10.optInt("backoff_ratio", 0);
        this.f11159a = r13;
        if (r13 >= 0) goto L5;
    L6:
        this.f11159a = 0;
    L7:
        int r14 = r10.optInt("max_request_frequency", b(r12));
        this.f11160b = r14;
        if (r14 > 0) goto L10;
        this.f11160b = 12;
    L10:
        int r15 = this.f11159a;
        if (r15 > 0) goto L13;
    L15:
        if (r15 != 0) goto L17;
        this.f11161c = 0;
        this.f11162d = 0;
    L17:
        this.f11163e = r10.optInt("disable_session_start_request", 0);
        this.f11164f = r10.optInt("disable_session_end_request", 0);
        if (this.f11159a != 0) goto L22;
        int r16 = this.f11160b;
        if (r16 <= 0) goto L22;
        this.f11166h.Q(r12, r16);
    L22:
        this.f11165g.P().o(Collections.singletonList("BackoffController"), "parseBackoffControllerFromResp mEventInterval: " + this.f11167i + ", mBackoffRatio: " + this.f11159a + ", mMaxRequestFrequency: " + this.f11160b + ", mBackoffWindowStartTime: " + this.f11161c + ", mBackoffWindowSendCount: " + this.f11162d + ", mDisableSessionStartRequest: " + this.f11163e + ", mDisableSessionEndRequest: " + this.f11164f, new Object[0]);
        return;
    L13:
        if (this.f11161c != 0) goto L15;
        this.f11161c = System.currentTimeMillis();
        this.f11162d = 1;
        goto L17
    L5:
        if (r13 <= 10000) goto L7;
        goto L6
    }
}
