package com.bytedance.sdk.xbridge.cn.runtime.depend;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/PopupConfig;", "", "disableMaskClickClose", "", "enablePullDownClose", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDisableMaskClickClose", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnablePullDownClose", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/sdk/xbridge/cn/runtime/depend/PopupConfig;", "equals", "", "other", "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PopupConfig {
    private final Integer disableMaskClickClose;
    private final Integer enablePullDownClose;

    /* JADX WARN: Multi-variable type inference failed */
    public PopupConfig() {
        Object[] r5 = 0 == true ? 1 : 0;
        this(null, r5, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PopupConfig copy$default(PopupConfig r5, Integer r10, Integer r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.disableMaskClickClose;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.enablePullDownClose;
    L9:
        return r5.copy(r10, r11);
    }

    public final Integer component1() {
        return this.disableMaskClickClose;
    }

    public final Integer component2() {
        return this.enablePullDownClose;
    }

    public final PopupConfig copy(Integer r5, Integer r10) {
        return new PopupConfig(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PopupConfig) == true) goto L8;
        return false;
    L8:
        PopupConfig r10 = (PopupConfig) r5;
        if (Intrinsics.areEqual(this.disableMaskClickClose, r10.disableMaskClickClose) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enablePullDownClose, r10.enablePullDownClose) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final Integer getDisableMaskClickClose() {
        return this.disableMaskClickClose;
    }

    public final Integer getEnablePullDownClose() {
        return this.enablePullDownClose;
    }

    public int hashCode() {
        Integer r5 = this.disableMaskClickClose;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        Integer r13 = this.enablePullDownClose;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public String toString() {
        return "PopupConfig(disableMaskClickClose=" + this.disableMaskClickClose + ", enablePullDownClose=" + this.enablePullDownClose + ')';
    }

    public PopupConfig(Integer r5, Integer r10) {
        this.disableMaskClickClose = r5;
        this.enablePullDownClose = r10;
    }

    public /* synthetic */ PopupConfig(Integer r5, Integer r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = null;
    L8:
        this(r5, r10);
    }
}
