package ep1;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.Panel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static c a(Panel r4) {
        Intrinsics.checkNotNullParameter(r4, "panel");
        if (r4 == Panel.BEAUTY) goto L5;
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L17;
        if (((Boolean) r5.isAnchor().getValue()).booleanValue() == false) goto L17;
        if (r5.isBroadcastMedia() == true) goto L17;
        if (tb1.c.a == false) goto L17;
        return new a();
    L17:
        return new e();
    L5:
        return new b();
    }
}
