package com.bytedance.ai.ex.widget.preload;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/ex/widget/preload/MiniAppWidgetTemplatePreloadResult;", "", "ready", "", "preloadToken", "", "errorMessage", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "getReady", "()Z", "getPreloadToken", "()Ljava/lang/String;", "getErrorMessage", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MiniAppWidgetTemplatePreloadResult {
    private final String errorMessage;
    private final String preloadToken;
    private final boolean ready;

    public MiniAppWidgetTemplatePreloadResult(boolean r5, String r10, String r11) {
        this.ready = r5;
        this.preloadToken = r10;
        this.errorMessage = r11;
    }

    public static /* synthetic */ MiniAppWidgetTemplatePreloadResult copy$default(MiniAppWidgetTemplatePreloadResult r5, boolean r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.ready;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.preloadToken;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.errorMessage;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final boolean component1() {
        return this.ready;
    }

    public final String component2() {
        return this.preloadToken;
    }

    public final String component3() {
        return this.errorMessage;
    }

    public final MiniAppWidgetTemplatePreloadResult copy(boolean r5, String r10, String r11) {
        return new MiniAppWidgetTemplatePreloadResult(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MiniAppWidgetTemplatePreloadResult) == true) goto L8;
        return false;
    L8:
        MiniAppWidgetTemplatePreloadResult r10 = (MiniAppWidgetTemplatePreloadResult) r5;
        if (this.ready == r10.ready) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.preloadToken, r10.preloadToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.errorMessage, r10.errorMessage) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getPreloadToken() {
        return this.preloadToken;
    }

    public final boolean getReady() {
        return this.ready;
    }

    public int hashCode() {
        int r5 = Boolean.hashCode(this.ready) * 31;
        String r10 = this.preloadToken;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.errorMessage;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("MiniAppWidgetTemplatePreloadResult(ready=");
        r5.append(this.ready);
        r5.append(", preloadToken=");
        r5.append(this.preloadToken);
        r5.append(", errorMessage=");
        return j0.p(r5, this.errorMessage, ')');
    }

    public /* synthetic */ MiniAppWidgetTemplatePreloadResult(boolean r5, String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = null;
    L8:
        this(r5, r10, r11);
    }
}
