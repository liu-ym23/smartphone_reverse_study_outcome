package iq1;

import com.bytedance.android.livesdk.chatroom.vs_base.log.d;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashSet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public final HashSet<String> a;
    public final DataCenter b;

    public a(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
        this.a = new HashSet();
    }

    public final void a(String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        if (h.d(this.b, true) == false) goto L5;
        String r0 = "portrait";
    L6:
        String r1 = r4 + '_' + r0;
        if (this.a.contains(r1) == true) goto L10;
        this.a.add(r1);
        d.a(this.b).d(r4, r5, new Object[0]);
        return;
    L10:
        return;
    L5:
        r0 = "landscape";
        goto L6
    }
}
