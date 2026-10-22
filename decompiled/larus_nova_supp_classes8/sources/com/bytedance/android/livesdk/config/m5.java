package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/config/m5;", "", "", "disableShowAvatar", "Z", "a", "()Z", "", "othersDiggFrq", "J", "b", "()J", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m5 {

    @SerializedName("disable_show_avatar")
    private final boolean disableShowAvatar;

    @SerializedName("others_digg_frq")
    private final long othersDiggFrq;

    public m5() {
        this(0);
    }

    public final boolean a() {
        return this.disableShowAvatar;
    }

    public final long b() {
        return this.othersDiggFrq;
    }

    public m5(int r3) {
        this.disableShowAvatar = false;
        this.othersDiggFrq = 200;
    }
}
