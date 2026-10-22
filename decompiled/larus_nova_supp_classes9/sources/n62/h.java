package n62;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final e b(Context r7, RoomContext r8, DataCenter r9, s22.e r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "roomContext");
        Intrinsics.checkNotNullParameter(r9, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "chatManager");
        return new e(r8, r7, r9, r10, null);
    }

    @JvmStatic
    public static final e a(Context r7, RoomContext r8, DataCenter r9, s22.e r10, i r11) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "roomContext");
        Intrinsics.checkNotNullParameter(r9, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "chatManager");
        Intrinsics.checkNotNullParameter(r11, "createConfig");
        return new e(r8, r7, r9, r10, r11);
    }
}
