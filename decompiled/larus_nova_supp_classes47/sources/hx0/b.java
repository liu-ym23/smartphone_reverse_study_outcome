package hx0;

import android.text.TextUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends a<gx0.a> {
    public b() {
    }

    @Override // hx0.a
    public final void c(Map r5, gx0.a r6) {
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r6, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r5, "map");
        a(r5);
        if (TextUtils.isEmpty(r6.a) == true) goto L6;
        String r7 = r6.a;
        Intrinsics.checkNotNullParameter("exchange_reason", "key");
        Intrinsics.checkNotNullParameter(r7, "value");
        this.a.put("exchange_reason", r7);
    L6:
        if (TextUtils.isEmpty(r6.b) == true) goto L9;
        String r8 = r6.b;
        Intrinsics.checkNotNullParameter("event_module", "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        this.a.put("event_module", r8);
    L9:
        if (TextUtils.isEmpty(r6.c) == true) goto L12;
        String r9 = r6.c;
        Intrinsics.checkNotNullParameter("popup_type", "key");
        Intrinsics.checkNotNullParameter(r9, "value");
        this.a.put("popup_type", r9);
        return;
    }
}
