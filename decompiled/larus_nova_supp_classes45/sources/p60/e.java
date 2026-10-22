package p60;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements c {
    public static final Map<String, c> b = null;
    public c a;

    public static final class a {
        public static final e a = null;

        static {
            a = new e();
        }
    }

    public e() {
    }

    static {
        HashMap r0 = new HashMap();
        b = r0;
        r0.put(RomUtils.ROM_VIVO, new g());
        r0.put("MEIZU", new d());
        r0.put("HUAWEI", new b());
        r0.put("XIAOMI", new h());
        r0.put(RomUtils.ROM_OPPO, new f());
    }

    public final c c() {
        if (this.a != null) goto L10;
        this.a = new p60.a();
        String r0 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r0) == true) goto L10;
        String r1 = r0.toUpperCase();
        Map<String, c> r2 = b;
        if (((HashMap) r2).containsKey(r1) == false) goto L10;
        this.a = (c) ((HashMap) r2).get(r1);
    L10:
        return this.a;
    }

    @Override // p60.c
    public final boolean b() {
        return c().b();
    }

    @Override // p60.c
    public final Intent a(Context r2) {
        return c().a(r2);
    }
}
