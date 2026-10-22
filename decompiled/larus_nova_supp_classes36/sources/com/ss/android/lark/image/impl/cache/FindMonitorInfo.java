package com.ss.android.lark.image.impl.cache;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/image/impl/cache/FindMonitorInfo;", "", "scene", "", "hasCache", "", "cacheKey", "cacheLevel", "cacheSize", "", "costTime", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JJ)V", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getHasCache", "()Z", "setHasCache", "(Z)V", "getCacheKey", "setCacheKey", "getCacheLevel", "setCacheLevel", "getCacheSize", "()J", "setCacheSize", "(J)V", "getCostTime", "setCostTime", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FindMonitorInfo {
    private String cacheKey;
    private String cacheLevel;
    private long cacheSize;
    private long costTime;
    private boolean hasCache;
    private String scene;

    public FindMonitorInfo() {
        this(null, false, null, null, 0, 0, 63, null);
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final String getCacheLevel() {
        return this.cacheLevel;
    }

    public final long getCacheSize() {
        return this.cacheSize;
    }

    public final long getCostTime() {
        return this.costTime;
    }

    public final boolean getHasCache() {
        return this.hasCache;
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setCacheKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cacheKey = r2;
    }

    public final void setCacheLevel(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cacheLevel = r2;
    }

    public final void setCacheSize(long r1) {
        this.cacheSize = r1;
    }

    public final void setCostTime(long r1) {
        this.costTime = r1;
    }

    public final void setHasCache(boolean r1) {
        this.hasCache = r1;
    }

    public final void setScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scene = r2;
    }

    public FindMonitorInfo(String r2, boolean r3, String r4, String r5, long r6, long r8) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r4, "cacheKey");
        Intrinsics.checkNotNullParameter(r5, "cacheLevel");
        this.scene = r2;
        this.hasCache = r3;
        this.cacheKey = r4;
        this.cacheLevel = r5;
        this.cacheSize = r6;
        this.costTime = r8;
    }

    public /* synthetic */ FindMonitorInfo(String r6, boolean r7, String r8, String r9, long r10, long r12, int r14, DefaultConstructorMarker r15) {
        String r0 = "";
        if ((r14 & 1) == 0) goto L5;
        String r16 = "";
    L7:
        if ((r14 & 2) == 0) goto L9;
        boolean r1 = false;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r2 = "";
    L15:
        if ((r14 & 8) != 0) goto L19;
        r0 = r9;
    L19:
        if ((r14 & 16) == 0) goto L21;
        long r3 = 0;
    L23:
        if ((r14 & 32) == 0) goto L25;
        long r13 = 0;
    L26:
        this(r16, r1, r2, r0, r3, r13);
        return;
    L25:
        r13 = r12;
        goto L26
    L21:
        r3 = r10;
        goto L23
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r16 = r6;
        goto L7
    }
}
