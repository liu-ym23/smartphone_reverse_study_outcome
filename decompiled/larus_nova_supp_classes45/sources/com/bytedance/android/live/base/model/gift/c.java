package com.bytedance.android.live.base.model.gift;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.gift.ExhibitionGiftItem")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/base/model/gift/c;", "", "Lcom/bytedance/android/live/base/model/gift/d;", "exhibitionGift", "Lcom/bytedance/android/live/base/model/gift/d;", "getExhibitionGift", "()Lcom/bytedance/android/live/base/model/gift/d;", "setExhibitionGift", "(Lcom/bytedance/android/live/base/model/gift/d;)V", "", "lightenCount", "J", "getLightenCount", "()J", "setLightenCount", "(J)V", "receiveCount", "getReceiveCount", "setReceiveCount", "", "isLight", "Z", "()Z", "setLight", "(Z)V", "Lcom/bytedance/android/live/base/model/gift/g;", "namingUser", "Lcom/bytedance/android/live/base/model/gift/g;", "getNamingUser", "()Lcom/bytedance/android/live/base/model/gift/g;", "setNamingUser", "(Lcom/bytedance/android/live/base/model/gift/g;)V", "Lcom/bytedance/android/live/base/model/gift/b;", "advancedTask", "Lcom/bytedance/android/live/base/model/gift/b;", "getAdvancedTask", "()Lcom/bytedance/android/live/base/model/gift/b;", "setAdvancedTask", "(Lcom/bytedance/android/live/base/model/gift/b;)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements vh7.h {

    @SerializedName("advanced_task")
    protected b advancedTask;

    @SerializedName("gift")
    protected d exhibitionGift;

    @SerializedName("is_lighted")
    protected boolean isLight;

    @SerializedName("lighted_threshold")
    protected long lightenCount;

    @SerializedName("naming_user")
    protected g namingUser;

    @SerializedName("received_count")
    protected long receiveCount;

    public c() {
    }

    public c(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L13;
        switch(r2) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.advancedTask = new b(r5);
        goto L3
    L8:
        this.namingUser = new g(r5);
        goto L3
    L9:
        this.isLight = am3.h.a(r5);
        goto L3
    L10:
        this.receiveCount = r5.j();
        goto L3
    L11:
        this.lightenCount = r5.j();
        goto L3
    L12:
        this.exhibitionGift = new d(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L13:
        r5.d(r0);
    }
}
