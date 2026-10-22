package qh0;

import android.app.Activity;
import com.bytedance.android.live.liveinteract.utils.e0;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ h b;

    public i(Activity r1, h r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r4;
        SimpleDateFormat r0 = e0.a;
        Activity r1 = this.a;
        if (this.b.c != 1) goto L5;
        String r2 = "video_live_link";
    L6:
        e0.c(r1, r5, r2);
        return;
    L5:
        r2 = "radio_live_link";
        goto L6
    }
}
