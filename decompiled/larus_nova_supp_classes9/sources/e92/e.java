package e92;

import am2.x;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ k a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public e(k r1, String r2) {
        this.a = r1;
        this.b = r2;
        this.c = "connection_manage_setting";
    }

    public final void accept(Object r6) {
        FollowPair r7 = (FollowPair) r6;
        this.a.c = false;
        int r8 = w82.b.a;
        w82.b.b(this.b, this.c, true);
        String r9 = this.b;
        this.a.getClass();
        String r1 = this.c;
        Intrinsics.checkNotNullParameter(r9, "userID");
        Intrinsics.checkNotNullParameter(r1, "requestPage");
        HashMap r3 = new HashMap();
        r3.put("follow_anchor_id", r9.toString());
        r3.put("follow_identity", "anchor");
        r3.put("request_page", r1);
        r3.put("connection_type", "manual_link");
        w82.b.c(r3);
        u.l().sendLog("livesdk_connection_counterpart_follow", r3, new Object[]{Room.class, x.class});
    }
}
