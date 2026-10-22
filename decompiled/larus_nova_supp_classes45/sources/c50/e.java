package c50;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.core.cmc.setting.CMCSettings;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public final HashMap<String, Integer> a;
    public final HashMap<Integer, d> b;
    public final f50.a c;
    public final d50.a d;
    public final a e;

    public class a implements f {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }
    }

    public e(c50.a r8) {
        this.a = new HashMap();
        HashMap<Integer, d> r3 = new HashMap();
        this.b = r3;
        this.c = null;
        this.e = new a(this);
        SettingKey<e50.a> r0 = CMCSettings.LIVE_CMC_CONFIG;
        f50.a r4 = new f50.a(r0.getValue().mEnableLog, r0.getValue().mSimpleLog);
        this.c = r4;
        e50.a r1 = r0.getValue();
        int r2 = r1.mDispatcherType;
        long r5 = r1.mDispatcherTaskInnerDelay;
        if (r2 != 1) goto L6;
        d50.a r6 = new d50.c(r8, r3, r4, r5);
    L9:
        this.d = r6;
        return;
    L6:
        if (r2 != 2) goto L8;
        r6 = new d50.d(r8, r3, r4, r5);
        goto L9
    L8:
        r6 = new d50.b(r8, r3, r4);
        goto L9
    }

    public final int a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return -1;
    L6:
        Integer r0 = this.a.get(r5);
        if (r0 != null) goto L9;
        int r1 = (int) ((SystemClock.elapsedRealtime() * 100) + ((long) (r5.hashCode() % 100)));
        d r2 = new d(r5, r1, this.e);
        this.a.put(r5, Integer.valueOf(r1));
        this.b.put(Integer.valueOf(r1), r2);
        return r1;
    L9:
        return r0.intValue();
    }

    public final boolean b(String r11, Runnable r12, long r13) {
        if (this.c.a == false) goto L7;
    L7:
        if (r12 != null) goto L9;
    L35:
        return false;
    L9:
        if (TextUtils.isEmpty(r11) == true) goto L35;
        int r14 = a(r11);
        d r1 = this.b.get(Integer.valueOf(r14));
        int r2 = -1;
        if (r14 == (-1)) goto L35;
        if (r1 == null) goto L35;
        c r15 = new c(r1.a, r1.b, r12, r1.c, r13);
        int r16 = r1.d.size() - 1;
    L17:
        if (r16 < 0) goto L24;
        c r17 = (c) ListProtector.get(r1.d, r16);
        if (r17 == null) goto L23;
        if (r17.c > r15.c) goto L23;
        r2 = r16 + 1;
    L23:
        r16 = r16 - 1;
    L24:
        if (r2 >= 0) goto L26;
    L29:
        r1.d.add(r15);
    L31:
        if (this.d.c(r15) == true) goto L34;
        r1.d.remove(r15);
        return false;
    L34:
        return true;
    L26:
        if (r2 == r1.d.size()) goto L29;
        ListProtector.add(r1.d, r2, r15);
        goto L31
    }
}
