package qa;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public final class h1 extends i1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f10495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f10497e;

    public h1(Context r8, int r10, String r11, i1 r12) {
        super(r12);
        this.f10494b = r10;
        this.f10496d = r11;
        this.f10497e = r8;
    }

    @Override // qa.i1
    public final void a() {
        super.a();
        long r8 = System.currentTimeMillis();
        this.f10495c = r8;
        String r10 = String.valueOf(r8);
        Vector<s4> r11 = n.f10841b;
        SharedPreferences.Editor r12 = this.f10497e.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r12.putString(this.f10496d, r10);
        r12.apply();
    }

    @Override // qa.i1
    public final boolean c() {
        long r8 = 0;
        if (this.f10495c != 0) goto L10;
        Vector<s4> r10 = n.f10841b;
        String r11 = this.f10497e.getSharedPreferences("AMSKLG_CFG", 0).getString(this.f10496d, "");
        if (TextUtils.isEmpty(r11) == true) goto L8;
        r8 = Long.parseLong(r11);
    L8:
        this.f10495c = r8;
    L10:
        if ((System.currentTimeMillis() - this.f10495c) >= this.f10494b) goto L12;
        return false;
    L12:
        return true;
    }
}
