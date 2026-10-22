package com.bytedance.android.livesdk.dispatch;

import android.net.Uri;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public String a;
    public String b;
    public final Uri c;

    public final void a() {
        String r1 = this.c.getPath();
        if (r1 == null) goto L13;
        List r2 = StringsKt.split$default(r1, new String[]{"/"}, false, 0, 6, null);
        if (r2 == null) goto L13;
        if (r2.size() < 3) goto L11;
        this.a = (String) ListProtector.get(r2, 1);
        this.b = (String) ListProtector.get(r2, 2);
        return;
    L11:
        throw new Exception("schema error!!! schema is " + this.c.toString());
    L13:
        throw new Exception("schema error!!! schema is " + this.c.toString());
    }

    public a(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        this.c = r2;
        this.a = "";
        this.b = "";
    }
}
