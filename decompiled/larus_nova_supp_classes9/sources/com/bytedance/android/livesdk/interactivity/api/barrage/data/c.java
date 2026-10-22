package com.bytedance.android.livesdk.interactivity.api.barrage.data;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/c;", BuildConfig.FLAVOR, "Lpy/k;", "background", "Lpy/k;", "a", "()Lpy/k;", "setBackground", "(Lpy/k;)V", BuildConfig.FLAVOR, "backgroundHeight", "J", "b", "()J", "setBackgroundHeight", "(J)V", "backgroundWidth", "c", "setBackgroundWidth", "isDynamicEgg", "f", "setDynamicEgg", "useRate", "e", "setUseRate", BuildConfig.FLAVOR, "showAlone", "Z", "d", "()Z", "setShowAlone", "(Z)V", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements vh7.h {

    @SerializedName("background")
    protected py.k background;

    @SerializedName("background_hight")
    protected long backgroundHeight;

    @SerializedName("background_width")
    protected long backgroundWidth;

    @SerializedName("is_dynamic_egg")
    protected long isDynamicEgg;

    @SerializedName("show_alone")
    protected boolean showAlone;

    @SerializedName("use_rate")
    protected long useRate;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public final py.k a() {
        return this.background;
    }

    public final long b() {
        return this.backgroundHeight;
    }

    public final long c() {
        return this.backgroundWidth;
    }

    public final boolean d() {
        return this.showAlone;
    }

    public final long e() {
        return this.useRate;
    }

    public final long f() {
        return this.isDynamicEgg;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
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
        this.showAlone = am3.h.a(r5);
        goto L3
    L8:
        this.isDynamicEgg = r5.j();
        goto L3
    L9:
        this.useRate = r5.j();
        goto L3
    L10:
        this.backgroundWidth = r5.j();
        goto L3
    L11:
        this.backgroundHeight = r5.j();
        goto L3
    L12:
        this.background = vh7.f.a(r5, py.k.class);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L13:
        r5.d(r0);
    }
}
