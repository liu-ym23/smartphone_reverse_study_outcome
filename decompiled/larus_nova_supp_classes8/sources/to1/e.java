package to1;

import com.bytedance.android.live.base.model.message.h1;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerViewIntent;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ ActivityTopBannerViewIntent.a b;

    public e(a r1, ActivityTopBannerViewIntent.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        JSONObject r7 = (JSONObject) r6;
        a r0 = this.a;
        h1 r1 = this.b.a;
        r0.getClass();
        BannerInRoomCollection.BannerInfo r2 = new BannerInRoomCollection.BannerInfo();
        String r3 = r1.getH5Url();
        String r4 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r2.setH5Url(r3);
        String r5 = r1.getLynxUrl();
        if (r5 == null) goto L9;
        r4 = r5;
    L9:
        r2.lynxUrl = r4;
        r2.setContainerType(r1.getContainerType());
        r2.setBannerList(null);
        String r8 = r2.getUrl();
        boolean r9 = false;
        if (r8 != null) goto L12;
    L15:
        boolean r10 = true;
    L16:
        if (r10 == false) goto L24;
        String r11 = r2.lynxUrl;
        if (r11 != null) goto L20;
    L21:
        r9 = true;
    L22:
        if (r9 == false) goto L24;
        r2 = null;
        goto L24
    L20:
        if (r11.length() != 0) goto L22;
    L24:
        if (r2 == null) goto L26;
        r2.isLoadMessageBanner = true;
        r2.loadMessageBannerJson = r7;
        this.a.b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.h(r2, this.b.a.getOperationType()));
        return;
    L26:
        this.a.b(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f("H5_roomStatusChange", r7));
        return;
    L12:
        if (r8.length() == 0) goto L15;
        r10 = false;
        goto L16
    }
}
