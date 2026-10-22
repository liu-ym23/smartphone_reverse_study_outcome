package ir1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import mq1.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static <T extends c> T a(Class<T> r1) {
        d0 r0 = ReplayRoomFragmentScopeUtil.b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.c(r1);
    }
}
