package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/g1;", "", "Lcom/bytedance/android/livesdk/config/r91;", "announce", "Lcom/bytedance/android/livesdk/config/r91;", "getAnnounce", "()Lcom/bytedance/android/livesdk/config/r91;", "setAnnounce", "(Lcom/bytedance/android/livesdk/config/r91;)V", "announcePanel", "b", "setAnnouncePanel", "aiGuestList", "a", "setAiGuestList", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g1 {
    public static final r91 a = null;
    public static final r91 b = null;
    public static final r91 c = null;

    @SerializedName("ai_guest_list")
    private r91 aiGuestList;

    @SerializedName("announce")
    private r91 announce;

    @SerializedName("announce_panel")
    private r91 announcePanel;

    public static final class a {
    }

    static {
        a = new r91("sslocal://webcast_lynxview?mask_alpha=0.5&type=popup&gravity=bottom&hide_loading=0&show_error=1&radius=20&height_percent=52", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/gecko-internal/webcast/mono/lynx/chatroom_lynx_douyin/pages/announce/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D");
        b = new r91("sslocal://webcast_lynxview?mask_alpha=0.5&type=popup&gravity=bottom&hide_loading=0&show_error=1&radius=20&height_percent=52", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/gecko-internal/webcast/mono/lynx/chatroom_lynx_douyin/pages/announce_panel/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D");
        c = new r91("sslocal://webcast_lynxview?mask_alpha=0.5&type=popup&gravity=bottom&hide_loading=0&show_error=1&radius=12&height=487&group=livelinkmic&business_type=livelinkmic", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/chatroom_lynx_douyin/pages/ai_guest_list/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%2C%22localCache%3Achat_room_lynx-ai_guest_list-%7Broom_id%7D%22%5D");
    }

    public g1() {
        this.announce = a;
        this.announcePanel = b;
        this.aiGuestList = c;
    }

    public final r91 a() {
        return this.aiGuestList;
    }

    public final r91 b() {
        return this.announcePanel;
    }
}
