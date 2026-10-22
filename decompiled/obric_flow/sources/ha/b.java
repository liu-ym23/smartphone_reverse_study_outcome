package ha;

import com.bytedance.framwork.core.sdkmonitor.e;
import com.bytedance.framwork.core.sdkmonitor.f;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f17291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f17292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17293c;
    public int d;
    public String e;
    public int f;
    public volatile long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f17294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f17295i;

    public final void a() {
        int r5 = this.d;
        if (r5 != 0) goto L5;
        this.f17292b = 300000;
        this.d++;
    L11:
        e r10 = f.b(this.e);
        long r11 = this.f17292b;
        ea.b r12 = r10.d;
        r12.f16800h = false;
        r12.f16802j = System.currentTimeMillis();
        r12.f16803k = r11;
        return;
    L5:
        if (r5 != 1) goto L8;
        this.f17292b = 900000;
        this.d++;
        goto L11
    L8:
        if (r5 != 2) goto L10;
        this.f17292b = 1800000;
        this.d++;
        goto L11
    L10:
        this.f17292b = 1800000;
        this.d++;
        goto L11
    }
}
