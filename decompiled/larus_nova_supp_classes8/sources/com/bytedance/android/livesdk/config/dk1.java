package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/config/dk1;", "", "", "x", "F", "d", "()F", "i", "(F)V", "y", "e", "j", "w", "c", "h", "b", "g", "", "enable", "Z", "a", "()Z", "f", "(Z)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class dk1 {

    @SerializedName("open")
    private boolean enable;

    @SerializedName("h")
    private float h;

    @SerializedName("w")
    private float w;

    @SerializedName("x")
    private float x;

    @SerializedName("y")
    private float y;

    public dk1() {
    }

    public final boolean a() {
        return this.enable;
    }

    public final float b() {
        return this.h;
    }

    public final float c() {
        return this.w;
    }

    public final float d() {
        return this.x;
    }

    public final float e() {
        return this.y;
    }

    public final void f(boolean r1) {
        this.enable = r1;
    }

    public final void g(float r1) {
        this.h = r1;
    }

    public final void h(float r1) {
        this.w = r1;
    }

    public final void i(float r1) {
        this.x = r1;
    }

    public final void j(float r1) {
        this.y = r1;
    }
}
