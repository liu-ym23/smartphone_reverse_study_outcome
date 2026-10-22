package yj0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public d(a r1, String r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        Intrinsics.checkNotNullParameter(r7, "throwable");
        ALogger.stacktrace(6, this.a.h, r7.getStackTrace());
        String r0 = this.b;
        long r1 = this.c;
        InteractLinkFullLinkMonitor.W(r0, System.currentTimeMillis() - r1, r7);
        ALogger.i("video_talk", "video ktv resetSilenceStatus failed");
        String r2 = this.b;
        int r3 = x.a;
        Intrinsics.checkNotNullParameter(r2, "targetId");
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("target_user_id", r2);
        x.X(r7, r4);
        x.t0("resume_last_silence_failed", r4);
        a.InterfaceC0294a r5 = (a.InterfaceC0294a) ((q46.b) this.a).a;
        if (r5 == null) goto L6;
        r5.F(this.b, r7);
        return;
    }
}
