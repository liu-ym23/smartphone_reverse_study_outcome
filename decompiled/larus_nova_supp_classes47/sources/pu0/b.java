package pu0;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lpu0/b;", "", "", "giftId", "J", "getGiftId", "()J", "b", "(J)V", "Lpu0/h;", "giftIconRect", "Lpu0/h;", "getGiftIconRect", "()Lpu0/h;", "a", "(Lpu0/h;)V", "<init>", "()V", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.live_pet.GiftTrayEvent")
public final class b {

    @SerializedName("gift_icon_rect")
    private h giftIconRect;

    @SerializedName("gift_id")
    private long giftId;

    public b() {
    }

    public final void a(h r1) {
        this.giftIconRect = r1;
    }

    public final void b(long r1) {
        this.giftId = r1;
    }
}
