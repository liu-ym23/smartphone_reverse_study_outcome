package n4a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Vector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e1 extends h1 {
    public String b;
    public Context c;
    public boolean d;
    public int e;
    public int f;
    public int g;

    @Override // n4a.h1
    public final int d() {
        if (x4.r(this.c) == 1) goto L6;
        int r0 = this.e;
        if (r0 <= 0) goto L6;
    L11:
        h1 r1 = this.a;
        if (r1 != null) goto L14;
        return r0;
    L14:
        return Math.max(r0, r1.d());
    L6:
        r0 = this.g;
        if (r0 <= 0) goto L10;
        if (r0 < Integer.MAX_VALUE) goto L11;
    L10:
        r0 = Integer.MAX_VALUE;
        goto L11
    }

    @Override // n4a.h1
    public final boolean c() {
        if (x4.r(this.c) != 1) goto L6;
        return true;
    L6:
        if (this.d == true) goto L8;
        return false;
    L8:
        Context r0 = this.c;
        String r3 = this.b;
        Vector<e5> r4 = p.b;
        String r1 = r0.getSharedPreferences("AMSKLG_CFG", 0).getString(r3, NameKeys.UnloadStrategy_No_Strategy);
        if (TextUtils.isEmpty(r1) == false) goto L11;
        return true;
    L11:
        String[] r2 = r1.split("\\|");
        if (r2 != null) goto L14;
    L22:
        Context r5 = this.c;
        String r6 = this.b;
        SharedPreferences.Editor r7 = r5.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r7.remove(r6);
        r7.apply();
        return true;
    L14:
        if (r2.length < 2) goto L22;
        String r8 = r2[0];
        if (f5.b(System.currentTimeMillis(), "yyyyMMdd").equals(r8) == true) goto L19;
    L21:
        return true;
    L19:
        if (CastIntegerProtector.parseInt(r2[1]) < this.f) goto L21;
        return false;
    }

    @Override // n4a.h1
    public final void b(int r8) {
        if (x4.r(this.c) != 1) goto L5;
        return;
    L5:
        String r0 = f5.b(System.currentTimeMillis(), "yyyyMMdd");
        Context r2 = this.c;
        String r3 = this.b;
        Vector<e5> r4 = p.b;
        String r5 = r2.getSharedPreferences("AMSKLG_CFG", 0).getString(r3, NameKeys.UnloadStrategy_No_Strategy);
        if (TextUtils.isEmpty(r5) == true) goto L16;
        String[] r6 = r5.split("\\|");
        if (r6 != null) goto L10;
    L15:
        Context r1 = this.c;
        String r7 = this.b;
        SharedPreferences.Editor r9 = r1.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r9.remove(r7);
        r9.apply();
        goto L16
    L10:
        if (r6.length < 2) goto L15;
        if (r0.equals(r6[0]) == false) goto L16;
        r8 = r8 + CastIntegerProtector.parseInt(r6[1]);
    L16:
        Context r10 = this.c;
        String r11 = this.b;
        String r12 = r0 + "|" + r8;
        SharedPreferences.Editor r13 = r10.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r13.putString(r11, r12);
        r13.apply();
    }

    public e1(Context r1, boolean r2, int r3, int r4) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.b = "carrierLocKey";
        this.g = 0;
    }

    public e1(Context r1, boolean r2, int r3, int r4, String r5, int r6) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.b = r5;
        this.g = r6;
    }
}
