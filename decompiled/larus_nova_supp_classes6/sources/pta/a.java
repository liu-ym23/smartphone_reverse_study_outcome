package pta;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.n;
import com.bytedance.bdinstall.o0;
import i84.h;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class a {
    public static C0006a a;

    /* JADX INFO: renamed from: pta.a$a, reason: collision with other inner class name */
    public static class C0006a extends e<String> {
        public C0006a() {
        }

        @Override // pta.e
        public final String a(Object[] r4) {
            if (r4[0] != null) goto L5;
            return null;
        L5:
            String r1 = h.c();
            SharedPreferences r5 = ((Context) r4[0]).getSharedPreferences(r1, 0);
            String r0 = r5.getString("cdid", "");
            if (TextUtils.isEmpty(r0) == false) goto L9;
            r0 = UUID.randomUUID().toString();
            r5.edit().putString("cdid", r0).apply();
        L9:
            return r0;
        }
    }

    static {
        a = new C0006a();
    }

    public static String a(Context r3) {
        o0 r0 = i.b.a;
        if (r0 == null) goto L5;
        String r1 = n.b(r0);
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return a.b(new Object[]{r3});
    L5:
        r1 = null;
        goto L6
    }
}
