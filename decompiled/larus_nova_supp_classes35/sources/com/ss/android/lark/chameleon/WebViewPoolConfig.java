package com.ss.android.lark.chameleon;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0000J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chameleon/WebViewPoolConfig;", "Ljava/io/Serializable;", "initialSize", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "coreSize", "maxSize", "maxUseCount", "<init>", "(IIII)V", "getInitialSize", "()I", "setInitialSize", "(I)V", "getCoreSize", "setCoreSize", "getMaxSize", "setMaxSize", "getMaxUseCount", "setMaxUseCount", "copy", "toString", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "component1", "component2", "component3", "component4", "equals", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "other", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "hashCode", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebViewPoolConfig implements Serializable {
    private int coreSize;
    private int initialSize;
    private int maxSize;
    private int maxUseCount;

    public WebViewPoolConfig() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ WebViewPoolConfig copy$default(WebViewPoolConfig r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.initialSize;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.coreSize;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.maxSize;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.maxUseCount;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.initialSize;
    }

    public final int component2() {
        return this.coreSize;
    }

    public final int component3() {
        return this.maxSize;
    }

    public final int component4() {
        return this.maxUseCount;
    }

    public final WebViewPoolConfig copy(int r2, int r3, int r4, int r5) {
        return new WebViewPoolConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WebViewPoolConfig) == true) goto L8;
        return false;
    L8:
        WebViewPoolConfig r6 = (WebViewPoolConfig) r5;
        if (this.initialSize == r6.initialSize) goto L12;
        return false;
    L12:
        if (this.coreSize == r6.coreSize) goto L15;
        return false;
    L15:
        if (this.maxSize == r6.maxSize) goto L18;
        return false;
    L18:
        if (this.maxUseCount == r6.maxUseCount) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.initialSize * 31) + this.coreSize) * 31) + this.maxSize) * 31) + this.maxUseCount;
    }

    public final WebViewPoolConfig copy() {
        return new WebViewPoolConfig(this.initialSize, this.coreSize, this.maxSize, this.maxUseCount);
    }

    public String toString() {
        return "WebViewPoolConfig{initialSize=" + this.initialSize + ", coreSize=" + this.coreSize + ", maxSize=" + this.maxSize + ", maxUseCount=" + this.maxUseCount + '}';
    }

    public final int getCoreSize() {
        return this.coreSize;
    }

    public final int getInitialSize() {
        return this.initialSize;
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    public final int getMaxUseCount() {
        return this.maxUseCount;
    }

    public final void setCoreSize(int r1) {
        this.coreSize = r1;
    }

    public final void setInitialSize(int r1) {
        this.initialSize = r1;
    }

    public final void setMaxSize(int r1) {
        this.maxSize = r1;
    }

    public final void setMaxUseCount(int r1) {
        this.maxUseCount = r1;
    }

    public WebViewPoolConfig(int r1, int r2, int r3, int r4) {
        this.initialSize = r1;
        this.coreSize = r2;
        this.maxSize = r3;
        this.maxUseCount = r4;
    }

    public /* synthetic */ WebViewPoolConfig(int r2, int r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 1;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 1;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = Integer.MAX_VALUE;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 10;
    L14:
        this(r2, r3, r4, r5);
    }
}
