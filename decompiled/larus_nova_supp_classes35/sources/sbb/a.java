package sbb;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a {
    public final String a;
    public final b b;

    public a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "domainConfigParser");
        this.a = "BaseDocUrlParser";
        this.b = r2;
    }

    public final String a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "path");
        b r0 = this.b;     // Catch: Exception -> L11
        if (r0 == null) goto L17;
        Matcher r1 = r0.b.matcher(r4);     // Catch: Exception -> L11
        if (r1.find() == true) goto L8;
        return null;
    L8:
        if (r1.end() <= r1.start()) goto L19;
        return r4.substring(r1.start() + 1, r1.end());
    L19:
        return null;
    L17:
        return null;
    L11:
        e = move-exception;
        Log.e(this.a, e);
        return null;
    }

    public final String b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "path");
        b r0 = this.b;
        if (r0 == null) goto L20;
        Matcher r1 = r0.a.matcher(r5);
        if (r1.find() == true) goto L7;
        return null;
    L7:
        if (r1.end() <= r1.start()) goto L26;
        Intrinsics.checkNotNull(r1);
        String r6 = r5.substring(r1.start() + 1, r1.end() - 1);
        e r2 = e.e;
        String r3 = r2.getType();
        if (TextUtils.isEmpty(r6) == false) goto L11;
        Log.i(this.a, "getProductTypeName()....originType is empty");
        return r3;
    L11:
        b r4 = this.b;
        if (r4 == null) goto L23;
        String r7 = r4.c.get(r6);
        if (r7 != null) goto L17;
        r7 = r2.getType();
    L17:
        if (TextUtils.isEmpty(r7) == false) goto L24;
        Log.i(this.a, "getProductTypeName()...originType = " + r6);
        return r2.getType();
    L24:
        return r7;
    L23:
        return r3;
    L26:
        return null;
    L20:
        return null;
    }
}
