package to1;

import com.bytedance.android.live.core.activity.BannerFullMonitor;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdkapi.banner.BannerData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ h a;
    public final /* synthetic */ IRoom b;

    public f(h r1, IRoom r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        BannerData r9 = (BannerData) r8;
        BannerInRoomCollection r0 = null;
        if (r9 == null) goto L7;
        BannerInRoomCollection r1 = r9.getData();
        if (r1 == null) goto L7;
        BannerInRoomCollection.BannerInfo r2 = r1.getActivityTopRightBanner();
    L8:
        if (r2 == null) goto L13;
        if (r9 == null) goto L11;
        String r3 = r9.getLogId();
    L12:
        r2.logId = r3;
        goto L13
    L11:
        r3 = null;
    L13:
        h r4 = this.a;
        if (r2 == null) goto L16;
        boolean r5 = true;
    L17:
        r4.b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.d(r5, r2, ""));
        IRoom r6 = this.b;
        if (r6 == null) goto L20;
        Long r7 = Long.valueOf(r6.getId());
    L21:
        String r10 = String.valueOf(r7);
        BannerFullMonitor.BannerType r11 = BannerFullMonitor.BannerType.TOP_RIGHT;
        StringBuilder r12 = new StringBuilder("data= ");
        if (r9 == null) goto L24;
        r0 = r9.getData();
    L24:
        r12.append(r0);
        BannerFullMonitor.b(0, "", r10, r11, r12.toString());
        return;
    L20:
        r7 = null;
        goto L21
    L16:
        r5 = false;
    L7:
        r2 = null;
        goto L8
    }
}
