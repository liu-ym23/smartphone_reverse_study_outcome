package u82;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaAnchorLinkUserListContract$View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        ALogger.stacktrace(6, this.a.b, r5.getStackTrace());
        MediaAnchorLinkUserListContract$View r0 = (MediaAnchorLinkUserListContract$View) this.a.c;
        if (r0 == null) goto L6;
        r0.Y90(r5);
        return;
    }
}
