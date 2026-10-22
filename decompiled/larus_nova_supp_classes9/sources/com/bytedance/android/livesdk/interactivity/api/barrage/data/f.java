package com.bytedance.android.livesdk.interactivity.api.barrage.data;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/f;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "headSize", "J", "e", "()J", "setHeadSize", "(J)V", "fontSize", "d", "setFontSize", BuildConfig.FLAVOR, "fontColor", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setFontColor", "(Ljava/lang/String;)V", "Lpy/i;", "background", "Lpy/i;", "a", "()Lpy/i;", "setBackground", "(Lpy/i;)V", "backgroundHeight", "b", "setBackgroundHeight", "backgroundWidth", "getBackgroundWidth", "setBackgroundWidth", "useRate", "f", "setUseRate", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f implements vh7.h {

    @SerializedName("background")
    protected py.i background;

    @SerializedName("background_hight")
    protected long backgroundHeight;

    @SerializedName("background_width")
    protected long backgroundWidth;

    @SerializedName("content_color")
    protected String fontColor;

    @SerializedName("content_size")
    protected long fontSize;

    @SerializedName("head_size")
    protected long headSize;

    @SerializedName("use_rate")
    protected long useRate;

    public f() {
    }

    public final py.i a() {
        return this.background;
    }

    public final long b() {
        return this.backgroundHeight;
    }

    public final String c() {
        return this.fontColor;
    }

    public final long d() {
        return this.fontSize;
    }

    public final long e() {
        return this.headSize;
    }

    public final long f() {
        return this.useRate;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.i] */
    public f(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.useRate = r5.j();
        goto L3
    L8:
        this.backgroundWidth = r5.j();
        goto L3
    L9:
        this.backgroundHeight = r5.j();
        goto L3
    L10:
        this.background = vh7.f.a(r5, py.i.class);
        goto L3
    L11:
        this.fontColor = am3.h.c(r5);
        goto L3
    L12:
        this.fontSize = r5.j();
        goto L3
    L13:
        this.headSize = r5.j();
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L14:
        r5.d(r0);
    }
}
