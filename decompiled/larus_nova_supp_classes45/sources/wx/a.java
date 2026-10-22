package wx;

import kotlin.jvm.internal.Intrinsics;
import nx.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends c {
    public a(String r2, JSONObject r3, com.bytedance.android.livesdk.chatroom.wornhole.a r4) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        super(r2, r4, "user_quit_room", r3);
    }
}
