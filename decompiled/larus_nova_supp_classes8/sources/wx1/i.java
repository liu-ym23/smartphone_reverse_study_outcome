package wx1;

import android.os.SystemClock;
import com.bytedance.android.gamecp.base.network.exception.ApiException;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ g a;
    public final /* synthetic */ PublishSubject b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;
    public final /* synthetic */ long f;

    public i(g r1, PublishSubject r2, String r3, long r4, long r6) {
        this.a = r1;
        this.b = r2;
        this.c = 1;
        this.d = r3;
        this.e = r4;
        this.f = r6;
    }

    public final void accept(Object r20) {
        ApiException r1 = (Throwable) r20;
        if (r1 == null) goto L5;
        this.b.onError(r1);
    L5:
        int r2 = this.c;
        String r3 = this.a.a.getId();
        String r4 = this.d;
        long r5 = this.e;
        long r16 = SystemClock.uptimeMillis() - this.f;
        if (r2 != 1) goto L8;
        String r6 = "ttlive_follow";
    L9:
        HashMap r8 = new HashMap();
        r8.put("proponent_id", r3);
        r8.put("adopter_id", r4);
        r8.put("room_id", Long.valueOf(r5));
        if (r1 == null) goto L14;
        String r7 = r1.getMessage();
        if ((r1 instanceof ApiException) == false) goto L15;
        ApiException r9 = r1;
        r8.put("error_code", Integer.valueOf(r9.getErrorCode()));
        int r15 = r9.getErrorCode();
    L16:
        r8.put("error_msg", r7);
        if (com.bytedance.android.livesdk.gamecp.b.a() == null) goto L20;
        com.bytedance.android.livesdk.gamecp.b.a().o(false, r6.concat("_all"), r6.concat("_error"), r15, r16, r8);
        return;
    L20:
        return;
    L15:
        r15 = 1;
        goto L16
    L14:
        r7 = "";
        goto L15
    L8:
        r6 = "ttlive_unfollow";
        goto L9
    }
}
