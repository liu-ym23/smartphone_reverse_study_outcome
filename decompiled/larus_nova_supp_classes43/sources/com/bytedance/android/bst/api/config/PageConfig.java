package com.bytedance.android.bst.api.config;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/bst/api/config/PageConfig;", "", "()V", "useHighFrequencyDrawEvent", "", "getUseHighFrequencyDrawEvent", "()Z", "setUseHighFrequencyDrawEvent", "(Z)V", "equals", "other", "hashCode", "", "toString", "", "api_cnRelease"}, k = 1, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class PageConfig {
    private boolean useHighFrequencyDrawEvent;

    public PageConfig() {
    }

    public int hashCode() {
        if (this.useHighFrequencyDrawEvent == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "PageConfig(useHighFrequencyDrawEvent=" + this.useHighFrequencyDrawEvent + ')';
    }

    public final boolean getUseHighFrequencyDrawEvent() {
        return this.useHighFrequencyDrawEvent;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        Class<?> r11 = r10.getClass();
    L10:
        if ((!Intrinsics.areEqual(PageConfig.class, r11)) == false) goto L12;
        return false;
    L12:
        if (r10 == null) goto L18;
        if (this.useHighFrequencyDrawEvent == ((PageConfig) r10).useHighFrequencyDrawEvent) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.bst.api.config.PageConfig");
    L8:
        r11 = null;
        goto L10
    }

    public final void setUseHighFrequencyDrawEvent(boolean r1) {
        this.useHighFrequencyDrawEvent = r1;
    }
}
