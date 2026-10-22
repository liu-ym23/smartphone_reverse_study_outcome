package qa;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class f1 extends i1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f10397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10401g;

    public f1(Context r8, boolean r10, int r11, int r12) {
        this.f10397c = r8;
        this.f10398d = r10;
        this.f10399e = r11;
        this.f10400f = r12;
        this.f10396b = "carrierLocKey";
        this.f10401g = 0;
    }

    @Override // qa.i1
    public final void b(int r8) {
        if (k4.n(this.f10397c) != 1) goto L5;
        return;
    L5:
        String r10 = t4.a(System.currentTimeMillis(), "yyyyMMdd");
        Context r11 = this.f10397c;
        String r12 = this.f10396b;
        Vector<s4> r13 = n.f10841b;
        String r14 = r11.getSharedPreferences("AMSKLG_CFG", 0).getString(r12, "");
        if (TextUtils.isEmpty(r14) == true) goto L16;
        String[] r15 = r14.split("\\|");
        if (r15 != null) goto L10;
    L15:
        Context r16 = this.f10397c;
        String r17 = this.f10396b;
        SharedPreferences.Editor r18 = r16.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r18.remove(r17);
        r18.apply();
        goto L16
    L10:
        if (r15.length < 2) goto L15;
        if (r10.equals(r15[0]) == false) goto L16;
        r8 = r8 + Integer.parseInt(r15[1]);
    L16:
        Context r19 = this.f10397c;
        String r20 = this.f10396b;
        String r21 = r10 + "|" + r8;
        SharedPreferences.Editor r22 = r19.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r22.putString(r20, r21);
        r22.apply();
    }

    @Override // qa.i1
    public final boolean c() {
        if (k4.n(this.f10397c) != 1) goto L6;
        return true;
    L6:
        if (this.f10398d == true) goto L8;
        return false;
    L8:
        Context r8 = this.f10397c;
        String r10 = this.f10396b;
        Vector<s4> r11 = n.f10841b;
        String r12 = r8.getSharedPreferences("AMSKLG_CFG", 0).getString(r10, "");
        if (TextUtils.isEmpty(r12) == false) goto L11;
        return true;
    L11:
        String[] r13 = r12.split("\\|");
        if (r13 != null) goto L14;
    L22:
        Context r14 = this.f10397c;
        String r15 = this.f10396b;
        SharedPreferences.Editor r16 = r14.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r16.remove(r15);
        r16.apply();
        return true;
    L14:
        if (r13.length < 2) goto L22;
        String r17 = r13[0];
        if (t4.a(System.currentTimeMillis(), "yyyyMMdd").equals(r17) == true) goto L19;
    L21:
        return true;
    L19:
        if (Integer.parseInt(r13[1]) < this.f10400f) goto L21;
        return false;
    }

    @Override // qa.i1
    public final int d() {
        if (k4.n(this.f10397c) == 1) goto L6;
        int r8 = this.f10399e;
        if (r8 <= 0) goto L6;
    L11:
        i1 r10 = this.f10519a;
        if (r10 != null) goto L14;
        return r8;
    L14:
        return Math.max(r8, r10.d());
    L6:
        r8 = this.f10401g;
        if (r8 <= 0) goto L10;
        if (r8 < Integer.MAX_VALUE) goto L11;
    L10:
        r8 = Integer.MAX_VALUE;
        goto L11
    }

    public f1(Context r8, boolean r10, int r11, int r12, String r13, int r14) {
        this.f10397c = r8;
        this.f10398d = r10;
        this.f10399e = r11;
        this.f10400f = r12;
        this.f10396b = r13;
        this.f10401g = r14;
    }
}
