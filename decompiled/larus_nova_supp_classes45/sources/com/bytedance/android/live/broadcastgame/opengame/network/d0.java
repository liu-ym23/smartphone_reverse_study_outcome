package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.open.api.GetMineUnencryptedInfoResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/d0;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/network/d0$a;", "userInfo", "Lcom/bytedance/android/live/broadcastgame/opengame/network/d0$a;", "a", "()Lcom/bytedance/android/live/broadcastgame/opengame/network/d0$a;", "setUserInfo", "(Lcom/bytedance/android/live/broadcastgame/opengame/network/d0$a;)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d0 implements vh7.h {

    @SerializedName("user_unencrypted_info")
    protected a userInfo;

    @ProtoMessage("webcast.open.api.GetMineUnencryptedInfoResponse.Data.UserUnencryptedInfo")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/d0$a;", "", "", "open_id", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setOpen_id", "(Ljava/lang/String;)V", "nick_name", "b", "setNick_name", "avatar_url", "a", "setAvatar_url", "role", "d", "setRole", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("avatar_url")
        protected String avatar_url;

        @SerializedName("nick_name")
        protected String nick_name;

        @SerializedName("open_id")
        protected String open_id;

        @SerializedName("role")
        protected String role;

        public final String toString() {
            return "open id: " + this.open_id + ", name: " + this.nick_name + ", avatar: " + this.avatar_url + ", role: " + this.role;
        }

        public a() {
            this.open_id = "";
            this.nick_name = "";
            this.avatar_url = "";
            this.role = "";
        }

        public final String a() {
            return this.avatar_url;
        }

        public final String b() {
            return this.nick_name;
        }

        public final String c() {
            return this.open_id;
        }

        public final String d() {
            return this.role;
        }

        public a(am3.g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            this.open_id = am3.h.c(r5);
            goto L3
        L8:
            if (r2 != 2) goto L10;
            this.nick_name = am3.h.c(r5);
            goto L3
        L10:
            if (r2 != 3) goto L12;
            this.avatar_url = am3.h.c(r5);
            goto L3
        L12:
            if (r2 != 4) goto L13;
            this.role = am3.h.c(r5);
            goto L3
        L13:
            am3.h.e(r5);
            goto L3
        L18:
            r5.d(r0);
            if (this.open_id != null) goto L22;
            this.open_id = "";
        L22:
            if (this.nick_name != null) goto L25;
            this.nick_name = "";
        L25:
            if (this.avatar_url != null) goto L28;
            this.avatar_url = "";
        L28:
            if (this.role != null) goto L46;
            this.role = "";
            return;
        }
    }

    public d0() {
    }

    public d0(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.userInfo = new a(r5);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }

    public final a a() {
        return this.userInfo;
    }
}
