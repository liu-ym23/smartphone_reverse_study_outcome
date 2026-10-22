package w32;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.n;
import kotlin.jvm.JvmStatic;
import z70.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    @JvmStatic
    public static final boolean a() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        n r1 = r0.getTemplateContext();
        if (r1 == null) goto L9;
        b r2 = (b) r1.getValue();
        if (r2 == null) goto L9;
        return r2.k();
    L9:
        return false;
    }

    static {
    }
}
