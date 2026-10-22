package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/config/y1;", "", "", "x", "F", "c", "()F", "g", "(F)V", "y", "d", "h", "w", "b", "f", "a", "e", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y1 {

    @SerializedName("h")
    private float h;

    @SerializedName("w")
    private float w;

    @SerializedName("x")
    private float x;

    @SerializedName("y")
    private float y;

    public y1() {
    }

    public final void g() {
        this.x = 0.0f;
    }

    public final void f() {
        this.w = 1.0f;
    }

    public final float a() {
        return this.h;
    }

    public final float b() {
        return this.w;
    }

    public final float c() {
        return this.x;
    }

    public final float d() {
        return this.y;
    }

    public final void e(float r1) {
        this.h = r1;
    }

    public final void h(float r1) {
        this.y = r1;
    }
}
