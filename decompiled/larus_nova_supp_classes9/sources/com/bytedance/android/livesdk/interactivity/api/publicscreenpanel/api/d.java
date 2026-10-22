package com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/api/d;", "Lcom/bytedance/android/live/base/model/Extra;", BuildConfig.FLAVOR, "maxNum", "I", "a", "()I", "setMaxNum", "(I)V", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d extends Extra {

    @SerializedName("max_num")
    private int maxNum;

    public d() {
    }

    public final int a() {
        return this.maxNum;
    }
}
