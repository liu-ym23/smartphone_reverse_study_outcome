package cp1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements g.b<e> {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
    public final String debugName() {
        return "DynamicController";
    }

    public a(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.b
    public final boolean a(a2 r2) {
        e r3 = (e) r2;
        Intrinsics.checkNotNullParameter(r3, "button");
        h r4 = r3.j;
        if (r4 != null) goto L5;
    L7:
        return false;
    L5:
        if (r4.a != 2) goto L7;
        return true;
    }
}
