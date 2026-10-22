package n4a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Vector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g1 extends h1 {
    public final int b;
    public long c;
    public final String d;
    public final Context e;

    public g1(Context r1, int r2, String r3, h1 r4) {
        super(r4);
        this.b = r2;
        this.d = r3;
        this.e = r1;
    }

    @Override // n4a.h1
    public final boolean c() {
        long r3 = 0;
        if (this.c != 0) goto L10;
        String r0 = this.d;
        Context r1 = this.e;
        Vector<e5> r5 = p.b;
        String r2 = r1.getSharedPreferences("AMSKLG_CFG", 0).getString(r0, NameKeys.UnloadStrategy_No_Strategy);
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r3 = CastLongProtector.parseLong(r2);
    L8:
        this.c = r3;
    L10:
        if ((System.currentTimeMillis() - this.c) >= this.b) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // n4a.h1
    public final void a() {
        super.a();
        String r0 = this.d;
        long r1 = System.currentTimeMillis();
        this.c = r1;
        Context r3 = this.e;
        String r2 = String.valueOf(r1);
        Vector<e5> r4 = p.b;
        SharedPreferences.Editor r5 = r3.getSharedPreferences("AMSKLG_CFG", 0).edit();
        r5.putString(r0, r2);
        r5.apply();
    }
}
