package com.bytedance.ai.uiu.objects;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/uiu/objects/UIUContextPluginParams;", "", "pageSetting", "Lcom/bytedance/ai/uiu/objects/PageSetting;", "cardId", "", "<init>", "(Lcom/bytedance/ai/uiu/objects/PageSetting;Ljava/lang/String;)V", "getPageSetting", "()Lcom/bytedance/ai/uiu/objects/PageSetting;", "setPageSetting", "(Lcom/bytedance/ai/uiu/objects/PageSetting;)V", "getCardId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UIUContextPluginParams {
    private final String cardId;
    private PageSetting pageSetting;

    public static /* synthetic */ UIUContextPluginParams copy$default(UIUContextPluginParams r0, PageSetting r1, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.pageSetting;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.cardId;
    L9:
        return r0.copy(r1, r10);
    }

    public final PageSetting component1() {
        return this.pageSetting;
    }

    public final String component2() {
        return this.cardId;
    }

    public final UIUContextPluginParams copy(PageSetting r10, String r11) {
        return new UIUContextPluginParams(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof UIUContextPluginParams) == true) goto L8;
        return false;
    L8:
        UIUContextPluginParams r11 = (UIUContextPluginParams) r10;
        if (this.pageSetting == r11.pageSetting) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cardId, r11.cardId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        PageSetting r0 = this.pageSetting;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.cardId;
        if (r12 == null) goto L11;
        r1 = r12.hashCode();
    L11:
        return r11 + r1;
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "UIUContextPluginParams(pageSetting=" + this.pageSetting + ", cardId=" + this.cardId + ')';
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final PageSetting getPageSetting() {
        return this.pageSetting;
    }

    public final void setPageSetting(PageSetting r1) {
        this.pageSetting = r1;
    }

    public UIUContextPluginParams(PageSetting r1, String r10) {
        this.pageSetting = r1;
        this.cardId = r10;
    }
}
