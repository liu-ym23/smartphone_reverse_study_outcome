package i4;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f8237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8239f;

    public i(long r10, j r11, String r12, String r13) {
        this(null, -1, r12, r13, r10, r11);
    }

    public final void a(i r8) {
        String r10 = r8.f8235b;
        if (TextUtils.equals(this.f8235b, r10) == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f8238e) == false) goto L11;
        if (TextUtils.isEmpty(r8.f8238e) == true) goto L11;
        this.f8238e = r8.f8238e;
    L11:
        if (this.f8239f >= 0) goto L16;
        int r11 = r8.f8239f;
        if (r11 < 0) goto L16;
        this.f8239f = r11;
    L16:
        if (TextUtils.isEmpty(this.f8234a) == false) goto L21;
        if (TextUtils.isEmpty(r8.f8234a) == true) goto L21;
        this.f8234a = r8.f8234a;
    L21:
        if (this.f8236c > 0) goto L26;
        long r12 = r8.f8236c;
        if (r12 <= 0) goto L26;
        this.f8236c = r12;
    L26:
        if (this.f8237d != null) goto L31;
        j r13 = r8.f8237d;
        if (r13 == null) goto L32;
        this.f8237d = r13;
        return;
    L32:
        return;
    }

    public i(String r8, int r10, String r11, String r12, long r13, j r14) {
        this.f8238e = r8;
        this.f8239f = r10;
        this.f8234a = r11;
        this.f8235b = r12;
        this.f8236c = r13;
        this.f8237d = r14;
    }
}
