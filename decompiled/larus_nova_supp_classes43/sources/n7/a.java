package n7;

import android.content.Context;
import com.bytedance.android.annie.param.k;
import com.bytedance.ies.bullet.web.pia.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import o7.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends s26.a implements b {
    public final String b0() {
        return l.b(new StringBuilder());
    }

    public a() {
    }

    public final String J(String r10) {
        Intrinsics.checkNotNullParameter(r10, "currentTemplateUrl");
        return l.c(r10, null, "");
    }

    public final Map T(Context r10, String r11, String r12) {
        k r13 = com.bytedance.android.annie.a.a(r10, r11, false, r12, "host");
        LinkedHashMap r14 = new LinkedHashMap();
        r14.putAll(com.bytedance.android.annie.param.b.b(r13));
        return r14;
    }
}
