package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/e0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "hintStyle", "I", "getHintStyle", "()I", "setHintStyle", "(I)V", "dayMaxCount", "d", "setDayMaxCount", "totalMaxCount", "e", "setTotalMaxCount", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 {

    @SerializedName("day_max_count")
    private int dayMaxCount;

    @SerializedName("hint_style")
    private int hintStyle;

    @SerializedName("totalMaxCount")
    private int totalMaxCount;

    public final boolean a() {
        if ((this.hintStyle & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        if ((this.hintStyle & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean c() {
        if ((this.hintStyle & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public e0() {
        this.dayMaxCount = 3;
        this.totalMaxCount = 12;
    }

    public final int d() {
        return this.dayMaxCount;
    }

    public final int e() {
        return this.totalMaxCount;
    }
}
