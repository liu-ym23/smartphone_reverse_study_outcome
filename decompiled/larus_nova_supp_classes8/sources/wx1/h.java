package wx1;

import android.os.SystemClock;
import bw.p;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ g a;
    public final /* synthetic */ PublishSubject b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;
    public final /* synthetic */ long f;

    public h(g r1, PublishSubject r2, String r3, long r4, long r6) {
        this.a = r1;
        this.b = r2;
        this.c = 1;
        this.d = r3;
        this.e = r4;
        this.f = r6;
    }

    public final void accept(Object r20) {
        FollowPair r1 = (FollowPair) r20;
        Intrinsics.checkNotNullParameter(r1, "pair");
        p r2 = this.a.g;
        int r3 = r1.followStatus;
        r2.q(r1.getUserIdString());
        com.bytedance.android.gamecp.host_api.model.user.FollowPair r4 = new com.bytedance.android.gamecp.host_api.model.user.FollowPair();
        r4.followStatus = r1.followStatus;
        r1.getUserIdString();
        r1.getRoomId();
        r1.getFromLabel();
        r1.getUrl();
        r1.getSecUserId();
        this.b.onNext(r4);
        int r5 = this.c;
        int r6 = r1.followStatus;
        String r7 = this.a.a.getId();
        String r8 = this.d;
        long r9 = this.e;
        long r16 = SystemClock.uptimeMillis() - this.f;
        if (r5 != 1) goto L5;
        String r10 = "ttlive_follow";
    L6:
        HashMap r11 = new HashMap();
        r11.put("proponent_id", r7);
        r11.put("adopter_id", r8);
        r11.put("follow_status", Integer.valueOf(r6));
        r11.put("room_id", Long.valueOf(r9));
        if (com.bytedance.android.livesdk.gamecp.b.a() == null) goto L10;
        com.bytedance.android.livesdk.gamecp.b.a().o(true, r10.concat("_all"), r10.concat("_error"), 0, r16, r11);
        return;
    L10:
        return;
    L5:
        r10 = "ttlive_unfollow";
        goto L6
    }
}
