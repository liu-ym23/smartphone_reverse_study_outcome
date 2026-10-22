package lq1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.view.IReplayWidgetView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a<T extends IReplayWidgetView> {
    public T a;
    public DataCenter b;
    public d c;

    public a() {
    }

    public void f() {
        this.b = null;
        if ((this instanceof l) == false) goto L7;
        d r1 = this.c;
        if (r1 == null) goto L7;
        r1.removeMessageListener((l) this);
    L7:
        this.a = null;
    }

    public final void e(T r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a = r2;
        DataCenter r3 = r2.getDataCenter();
        this.b = r3;
        if (r3 == null) goto L5;
        d r4 = (d) r3.get("data_message_manager");
    L6:
        this.c = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }
}
