package y1c;

import android.content.Context;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.g;
import com.ss.android.lark.sp.AbstractSharedPreferences;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends AbstractSharedPreferences {
    public static volatile b b;
    public String a;

    public b() {
        Context r0 = g.getContext();
        this.a = new b1c.b(r0).a("lark");
        b1c.c r3 = null;
        if (DevEnvUtil.isDebugMode(r0) == false) goto L11;
    L9:
        setBaseSharedPreferences(new h5c.a(r0.getSharedPreferences("lark", 0), r3));
        return;
    L11:
        v8b.a.a().getClass();     // Catch: GeneralSecurityException -> L6
        r3 = m4c.b.a.a.b();     // Catch: GeneralSecurityException -> L6
    L8:
        r3 = new b1c.c(r0, r3, this.a);
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public final String getSpName() {
        return this.a;
    }
}
