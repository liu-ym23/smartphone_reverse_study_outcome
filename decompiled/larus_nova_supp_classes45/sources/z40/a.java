package z40;

import com.bytedance.android.livesdk.utils.a2;
import com.bytedance.android.livesdk.utils.b2;
import com.bytedance.android.livesdk.utils.f2;
import com.bytedance.android.livesdk.utils.g2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a<INTENT, STATE extends g2> implements f2<INTENT, STATE> {
    public a2<? extends DataContext> a;
    public DataCenter b;
    public b2<INTENT, STATE> c;

    public a() {
    }

    public final void b(com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        b2<INTENT, STATE> r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }
}
