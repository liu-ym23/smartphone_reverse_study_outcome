package to1;

import com.bytedance.android.live.core.activity.BannerFullMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ h a;
    public final /* synthetic */ IRoom b;

    public g(h r1, IRoom r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        h r0 = this.a;
        if (r7 == null) goto L6;
        String r2 = r7.getMessage();
        if (r2 == null) goto L6;
    L7:
        String r4 = null;
        r0.b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.d(false, null, r2));
        if (r7 == null) goto L10;
        String r1 = r7.getLocalizedMessage();
    L11:
        IRoom r3 = this.b;
        if (r3 == null) goto L14;
        Long r5 = Long.valueOf(r3.getId());
    L15:
        String r8 = String.valueOf(r5);
        BannerFullMonitor.BannerType r9 = BannerFullMonitor.BannerType.TOP_RIGHT;
        if (r7 == null) goto L18;
        r4 = r7.getMessage();
    L18:
        BannerFullMonitor.b(-1, r1, r8, r9, r4);
        return;
    L14:
        r5 = null;
        goto L15
    L10:
        r1 = null;
    L6:
        r2 = "";
        goto L7
    }
}
