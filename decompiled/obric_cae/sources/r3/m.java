package r3;

import android.text.TextUtils;
import com.obric.cae.cloud.applog.ByteIOUtils;
import x4.b0;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f11429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f11430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f11431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f11432h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f11433i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b0 f11434j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11435k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11436l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f11437m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11438n;

    public m() {
        this.f11426b = true;
        this.f11428d = 0;
        this.f11435k = true;
        this.f11436l = false;
        this.f11438n = false;
        if (TextUtils.isEmpty(ByteIOUtils.APP_ID) == true) goto L11;
        if (TextUtils.isEmpty(ByteIOUtils.APP_CHANNEL) == true) goto L9;
        this.f11425a = ByteIOUtils.APP_ID;
        this.f11427c = ByteIOUtils.APP_CHANNEL;
        return;
    L9:
        throw new IllegalStateException("Channel must not be empty!");
    L11:
        throw new IllegalStateException("App id must not be empty!");
    }

    public final String a() {
        if (TextUtils.isEmpty(null) == false) goto L10;
        StringBuilder r8 = new StringBuilder();
        String r10 = this.f11425a;
        if (r10 == null) goto L7;
        String r11 = r10.toString();
    L9:
        return android.aimedia.a.i(r8, r11, "@bd_tea_agent.db");
    L7:
        r11 = "";
        goto L9
    L10:
        return null;
    }
}
