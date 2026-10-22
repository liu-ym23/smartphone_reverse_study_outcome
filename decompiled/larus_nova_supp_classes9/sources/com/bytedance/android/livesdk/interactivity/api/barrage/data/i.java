package com.bytedance.android.livesdk.interactivity.api.barrage.data;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/i;", BuildConfig.FLAVOR, "Lpy/k;", "background", "Lpy/k;", "a", "()Lpy/k;", "setBackground", "(Lpy/k;)V", BuildConfig.FLAVOR, "backgroundHeight", "J", "b", "()J", "setBackgroundHeight", "(J)V", "backgroundWidth", "c", "setBackgroundWidth", "isDynamicEgg", "e", "setDynamicEgg", "useRate", "d", "setUseRate", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i implements vh7.h {
    public static final /* synthetic */ int a = 0;

    @SerializedName("background")
    protected py.k background;

    @SerializedName("background_hight")
    protected long backgroundHeight;

    @SerializedName("background_width")
    protected long backgroundWidth;

    @SerializedName("is_dynamic_egg")
    protected long isDynamicEgg;

    @SerializedName("use_rate")
    protected long useRate;

    public static final class a {
    }

    static {
    }

    public i() {
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

    public final long d() {
        return this.useRate;
    }

    public final long e() {
        return this.isDynamicEgg;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public i(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.background = vh7.f.a(r5, py.k.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.backgroundHeight = r5.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.backgroundWidth = r5.j();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.useRate = r5.j();
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.isDynamicEgg = r5.j();
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }
}
