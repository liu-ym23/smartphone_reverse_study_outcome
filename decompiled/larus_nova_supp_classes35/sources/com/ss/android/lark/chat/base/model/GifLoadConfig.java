package com.ss.android.lark.chat.base.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@AppConfig(key = "gif_load_config")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/base/model/GifLoadConfig;", BuildConfig.FLAVOR, "width", BuildConfig.FLAVOR, "height", "size", "<init>", "(III)V", "getWidth", "()I", "getHeight", "getSize", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GifLoadConfig {

    @SerializedName("height")
    private final int height;

    @SerializedName("size")
    private final int size;

    @SerializedName("width")
    private final int width;

    public GifLoadConfig() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ GifLoadConfig copy$default(GifLoadConfig r0, int r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.width;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.height;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.size;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final int component3() {
        return this.size;
    }

    public final GifLoadConfig copy(int r2, int r3, int r4) {
        return new GifLoadConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GifLoadConfig) == true) goto L8;
        return false;
    L8:
        GifLoadConfig r6 = (GifLoadConfig) r5;
        if (this.width == r6.width) goto L12;
        return false;
    L12:
        if (this.height == r6.height) goto L15;
        return false;
    L15:
        if (this.size == r6.size) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.width * 31) + this.height) * 31) + this.size;
    }

    public String toString() {
        return "GifLoadConfig(width=" + this.width + ", height=" + this.height + ", size=" + this.size + ')';
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getWidth() {
        return this.width;
    }

    public GifLoadConfig(int r1, int r2, int r3) {
        this.width = r1;
        this.height = r2;
        this.size = r3;
    }

    public /* synthetic */ GifLoadConfig(int r2, int r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 800;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 800;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 10485760;
    L11:
        this(r2, r3, r4);
    }
}
