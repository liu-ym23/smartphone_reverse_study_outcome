package com.bytedance.android.livesdk.guardbox.api;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.growth.anchortool.MGetRedDotResponse.ResponseData")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/guardbox/api/b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "redDots", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("red_dots")
    protected Map<String, Boolean> redDots;

    public b() {
    }

    public b(g r11) {
        this.redDots = new HashMap();
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L25;
        if (r2 != 1) goto L7;
        long r5 = r11.c();
        String r3 = null;
        Boolean r7 = null;
    L9:
        int r8 = r11.f();
        if (r8 == (-1)) goto L17;
        if (r8 != 1) goto L13;
        r3 = am3.h.c(r11);
        goto L9
    L13:
        if (r8 != 2) goto L14;
        r7 = Boolean.valueOf(am3.h.a(r11));
        goto L9
    L14:
        am3.h.e(r11);
        goto L9
    L17:
        r11.d(r5);
        Map<String, Boolean> r4 = this.redDots;
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

    public final Map<String, Boolean> a() {
        return this.redDots;
    }
}
