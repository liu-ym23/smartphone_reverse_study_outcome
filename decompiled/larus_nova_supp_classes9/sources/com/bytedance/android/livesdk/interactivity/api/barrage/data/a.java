package com.bytedance.android.livesdk.interactivity.api.barrage.data;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "contentColor", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setContentColor", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "fontSize", "J", "c", "()J", "setFontSize", "(J)V", "Lpy/i;", "background", "Lpy/i;", "a", "()Lpy/i;", "setBackground", "(Lpy/i;)V", "backgroundHeight", "getBackgroundHeight", "setBackgroundHeight", "backgroundWidth", "getBackgroundWidth", "setBackgroundWidth", "useRate", "d", "setUseRate", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements vh7.h {

    @SerializedName("background")
    protected py.i background;

    @SerializedName("background_hight")
    protected long backgroundHeight;

    @SerializedName("background_width")
    protected long backgroundWidth;

    @SerializedName("content_color")
    protected String contentColor;

    @SerializedName("font_size")
    protected long fontSize;

    @SerializedName("use_rate")
    protected long useRate;

    public a() {
    }

    public final py.i a() {
        return this.background;
    }

    public final String b() {
        return this.contentColor;
    }

    public final long c() {
        return this.fontSize;
    }

    public final long d() {
        return this.useRate;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.i] */
    public a(am3.g r5) {
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
        this.fontSize = r5.j();
        goto L3
    L8:
        this.useRate = r5.j();
        goto L3
    L9:
        this.backgroundWidth = r5.j();
        goto L3
    L10:
        this.backgroundHeight = r5.j();
        goto L3
    L11:
        this.background = vh7.f.a(r5, py.i.class);
        goto L3
    L12:
        this.contentColor = am3.h.c(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L13:
        r5.d(r0);
    }
}
