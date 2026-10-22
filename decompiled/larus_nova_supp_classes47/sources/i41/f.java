package i41;

import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ a a;

    public f(a r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        jy0.b.b("link", "", r6);
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a.k;
        if (r0 == null) goto L5;
        v r1 = r0.getMultiLinkMonitor();
    L6:
        if (r1 == null) goto L9;
        r1.G("get_ban_record_failed", r6, new JSONObject(), null);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
