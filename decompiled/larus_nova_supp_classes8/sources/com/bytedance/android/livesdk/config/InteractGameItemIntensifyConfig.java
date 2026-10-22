package com.bytedance.android.livesdk.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J1\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/config/InteractGameItemIntensifyConfig;", "", "validTime", "", "isClicked", "", "lastShowTime", "", "alreadyShowCount", "", "(Ljava/lang/String;ZJI)V", "getAlreadyShowCount", "()I", "setAlreadyShowCount", "(I)V", "()Z", "setClicked", "(Z)V", "getLastShowTime", "()J", "setLastShowTime", "(J)V", "getValidTime", "()Ljava/lang/String;", "setValidTime", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractGameItemIntensifyConfig {
    private int alreadyShowCount;
    private boolean isClicked;
    private long lastShowTime;
    private String validTime;

    public InteractGameItemIntensifyConfig() {
        this(null, false, 0, 0, 15, null);
    }

    public static /* synthetic */ InteractGameItemIntensifyConfig copy$default(InteractGameItemIntensifyConfig r3, String r4, boolean r5, long r6, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.validTime;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.isClicked;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.lastShowTime;
    L11:
        long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.alreadyShowCount;
    L14:
        String r7 = r4;
        return r3.copy(r7, r11, r0, r8);
    }

    public final String component1() {
        return this.validTime;
    }

    public final boolean component2() {
        return this.isClicked;
    }

    public final long component3() {
        return this.lastShowTime;
    }

    public final int component4() {
        return this.alreadyShowCount;
    }

    public final InteractGameItemIntensifyConfig copy(String r8, boolean r9, long r10, int r12) {
        Intrinsics.checkNotNullParameter(r8, "validTime");
        return new InteractGameItemIntensifyConfig(r8, r9, r10, r12);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof InteractGameItemIntensifyConfig) == false) goto L14;
        InteractGameItemIntensifyConfig r7 = (InteractGameItemIntensifyConfig) r6;
        if (Intrinsics.areEqual(this.validTime, r7.validTime) == true) goto L8;
        return false;
    L8:
        if (this.isClicked == r7.isClicked) goto L10;
        return false;
    L10:
        if (this.lastShowTime == r7.lastShowTime) goto L12;
        return false;
    L12:
        if (this.alreadyShowCount == r7.alreadyShowCount) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r0 = this.validTime;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.isClicked;
        ?? r4 = r3;
        if (r3 == false) goto L9;
        r4 = 1;
    L9:
        int r5 = (r2 + r4) * 31;
        long r6 = this.lastShowTime;
        return ((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + this.alreadyShowCount;
    L5:
        r1 = 0;
        goto L6
    }

    public String toString() {
        return "InteractGameItemIntensifyConfig(validTime=" + this.validTime + ", isClicked=" + this.isClicked + ", lastShowTime=" + this.lastShowTime + ", alreadyShowCount=" + this.alreadyShowCount + ")";
    }

    public final int getAlreadyShowCount() {
        return this.alreadyShowCount;
    }

    public final long getLastShowTime() {
        return this.lastShowTime;
    }

    public final String getValidTime() {
        return this.validTime;
    }

    public final boolean isClicked() {
        return this.isClicked;
    }

    public final void setAlreadyShowCount(int r1) {
        this.alreadyShowCount = r1;
    }

    public final void setClicked(boolean r1) {
        this.isClicked = r1;
    }

    public final void setLastShowTime(long r1) {
        this.lastShowTime = r1;
    }

    public final void setValidTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.validTime = r2;
    }

    public InteractGameItemIntensifyConfig(String r2, boolean r3, long r4, int r6) {
        Intrinsics.checkNotNullParameter(r2, "validTime");
        this.validTime = r2;
        this.isClicked = r3;
        this.lastShowTime = r4;
        this.alreadyShowCount = r6;
    }

    public /* synthetic */ InteractGameItemIntensifyConfig(String r4, boolean r5, long r6, int r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L5;
        r4 = "";
    L5:
        int r0 = 0;
        if ((r9 & 2) == 0) goto L8;
        boolean r11 = false;
    L10:
        if ((r9 & 4) == 0) goto L12;
        r6 = 0;
    L12:
        long r1 = r6;
        if ((r9 & 8) != 0) goto L16;
        r0 = r8;
    L16:
        this(r4, r11, r1, r0);
        return;
    L8:
        r11 = r5;
        goto L10
    }
}
