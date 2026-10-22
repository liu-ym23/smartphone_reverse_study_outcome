package com.ss.android.lark.log.alog;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.impl.preload.ImagePreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/log/alog/ReportConfig;", "", "duration", "", "maxTagF", "", "maxFreq", "maxCost", "maxLogSize", "maxLogSubSize", "<init>", "(JIIIII)V", "getDuration", "()J", "setDuration", "(J)V", "getMaxTagF", "()I", "setMaxTagF", "(I)V", "getMaxFreq", "setMaxFreq", "getMaxCost", "setMaxCost", "getMaxLogSize", "setMaxLogSize", "getMaxLogSubSize", "setMaxLogSubSize", "lark-logger_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ReportConfig {
    private long duration;
    private int maxCost;
    private int maxFreq;
    private int maxLogSize;
    private int maxLogSubSize;
    private int maxTagF;

    public ReportConfig() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getMaxCost() {
        return this.maxCost;
    }

    public final int getMaxFreq() {
        return this.maxFreq;
    }

    public final int getMaxLogSize() {
        return this.maxLogSize;
    }

    public final int getMaxLogSubSize() {
        return this.maxLogSubSize;
    }

    public final int getMaxTagF() {
        return this.maxTagF;
    }

    public final void setDuration(long r1) {
        this.duration = r1;
    }

    public final void setMaxCost(int r1) {
        this.maxCost = r1;
    }

    public final void setMaxFreq(int r1) {
        this.maxFreq = r1;
    }

    public final void setMaxLogSize(int r1) {
        this.maxLogSize = r1;
    }

    public final void setMaxLogSubSize(int r1) {
        this.maxLogSubSize = r1;
    }

    public final void setMaxTagF(int r1) {
        this.maxTagF = r1;
    }

    public ReportConfig(long r1, int r3, int r4, int r5, int r6, int r7) {
        this.duration = r1;
        this.maxTagF = r3;
        this.maxFreq = r4;
        this.maxCost = r5;
        this.maxLogSize = r6;
        this.maxLogSubSize = r7;
    }

    public /* synthetic */ ReportConfig(long r8, int r10, int r11, int r12, int r13, int r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L5;
        long r0 = 1000;
    L7:
        if ((r15 & 2) == 0) goto L9;
        int r2 = 100;
    L11:
        if ((r15 & 4) == 0) goto L13;
        int r3 = 500;
    L15:
        if ((r15 & 8) == 0) goto L17;
        int r4 = ImagePreloadConfig.DEFAULT_PRELOAD_CACHE_COUNT;
    L19:
        if ((r15 & 16) == 0) goto L21;
        int r5 = 4096;
    L23:
        if ((r15 & 32) == 0) goto L25;
        int r6 = 50;
    L26:
        this(r0, r2, r3, r4, r5, r6);
        return;
    L25:
        r6 = r14;
        goto L26
    L21:
        r5 = r13;
        goto L23
    L17:
        r4 = r12;
        goto L19
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L11
    L5:
        r0 = r8;
        goto L7
    }
}
