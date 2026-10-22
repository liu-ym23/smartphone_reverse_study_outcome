package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/ek1;", "", "", "enableExternalRender", "Z", "c", "()Z", "setEnableExternalRender", "(Z)V", "enablePostProcessor", "d", "setEnablePostProcessor", "", "sharpness", "F", "e", "()F", "setSharpness", "(F)V", "brightness", "a", "setBrightness", "contrast", "b", "setContrast", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ek1 {

    @SerializedName("brightness")
    private float brightness;

    @SerializedName("contrast")
    private float contrast;

    @SerializedName("enable_external_render")
    private boolean enableExternalRender;

    @SerializedName("enable_render_processor")
    private boolean enablePostProcessor;

    @SerializedName("sharpness")
    private float sharpness;

    public ek1() {
    }

    public final float a() {
        return this.brightness;
    }

    public final float b() {
        return this.contrast;
    }

    public final boolean c() {
        return this.enableExternalRender;
    }

    public final boolean d() {
        return this.enablePostProcessor;
    }

    public final float e() {
        return this.sharpness;
    }
}
