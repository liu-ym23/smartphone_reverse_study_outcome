package vu8;

import com.bytedance.common.utility.StringUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final String a;
    public final String b;

    public final boolean a(a r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        if (StringUtils.equal(this.a, r3.a) == true) goto L5;
    L7:
        return false;
    L5:
        if (StringUtils.equal(this.b, r3.b) == false) goto L7;
        return true;
    }

    public a(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
