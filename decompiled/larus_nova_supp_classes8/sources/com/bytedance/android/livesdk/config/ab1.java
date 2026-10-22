package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0002\u0007\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/config/ab1;", "", "", "enable", "Z", "getEnable", "()Z", "a", "(Z)V", "Lcom/bytedance/android/livesdk/config/ab1$b;", "chatChannel", "Lcom/bytedance/android/livesdk/config/ab1$b;", "getChatChannel", "()Lcom/bytedance/android/livesdk/config/ab1$b;", "setChatChannel", "(Lcom/bytedance/android/livesdk/config/ab1$b;)V", "share", "getShare", "setShare", "gift", "getGift", "setGift", "more", "getMore", "setMore", "<init>", "()V", "b", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ab1 {

    @SerializedName("chat_channel")
    private b chatChannel;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("gift")
    private b gift;

    @SerializedName("more")
    private b more;

    @SerializedName("share")
    private b share;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/ab1$b;", "", "", "isVisible", "Z", "()Z", "setVisible", "(Z)V", "", "order", "I", "getOrder", "()I", "a", "(I)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("isVisible")
        private boolean isVisible;

        @SerializedName("order")
        private int order;

        public b() {
            this.isVisible = true;
        }

        public final void a(int r1) {
            this.order = r1;
        }
    }

    static {
    }

    public final void a() {
        this.enable = true;
    }

    public ab1() {
        b r0 = new b();
        r0.a(0);
        Unit r1 = Unit.INSTANCE;
        this.chatChannel = r0;
        b r2 = new b();
        r2.a(1);
        this.share = r2;
        b r3 = new b();
        r3.a(2);
        this.gift = r3;
        b r4 = new b();
        r4.a(3);
        this.more = r4;
    }
}
