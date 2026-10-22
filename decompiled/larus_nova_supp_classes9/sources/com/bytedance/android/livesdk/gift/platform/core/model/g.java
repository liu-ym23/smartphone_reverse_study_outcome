package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR0\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/g;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "predictDict", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "setPredictDict", "(Ljava/util/Map;)V", "<init>", "()V", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g implements vh7.h {

    @SerializedName("predict_dict")
    protected Map<String, String> predictDict;

    public g() {
    }

    public g(am3.g r11) {
        this.predictDict = new HashMap();
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L25;
        if (r2 != 1) goto L7;
        long r5 = r11.c();
        String r3 = null;
        String r7 = null;
    L9:
        int r8 = r11.f();
        if (r8 == (-1)) goto L17;
        if (r8 != 1) goto L13;
        r3 = am3.h.c(r11);
        goto L9
    L13:
        if (r8 != 2) goto L14;
        r7 = am3.h.c(r11);
        goto L9
    L14:
        am3.h.e(r11);
        goto L9
    L17:
        r11.d(r5);
        Map<String, String> r4 = this.predictDict;
        if (r3 == null) goto L24;
        if (r7 == null) goto L22;
        r4.put(r3, r7);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.e(r11);
        goto L3
    L25:
        r11.d(r0);
    }

    public final Map<String, String> a() {
        return this.predictDict;
    }
}
