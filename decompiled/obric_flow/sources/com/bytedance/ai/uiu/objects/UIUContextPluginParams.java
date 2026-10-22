package com.bytedance.ai.uiu.objects;

import ai.j0;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/uiu/objects/UIUContextPluginParams;", "", "pageSetting", "Lcom/bytedance/ai/uiu/objects/PageSetting;", "cardId", "", "<init>", "(Lcom/bytedance/ai/uiu/objects/PageSetting;Ljava/lang/String;)V", "getPageSetting", "()Lcom/bytedance/ai/uiu/objects/PageSetting;", "setPageSetting", "(Lcom/bytedance/ai/uiu/objects/PageSetting;)V", "getCardId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UIUContextPluginParams {
    private final String cardId;
    private PageSetting pageSetting;

    public UIUContextPluginParams(PageSetting r5, String r10) {
        this.pageSetting = r5;
        this.cardId = r10;
    }

    public static /* synthetic */ UIUContextPluginParams copy$default(UIUContextPluginParams r5, PageSetting r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.pageSetting;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.cardId;
    L9:
        return r5.copy(r10, r11);
    }

    public final PageSetting component1() {
        return this.pageSetting;
    }

    public final String component2() {
        return this.cardId;
    }

    public final UIUContextPluginParams copy(PageSetting r5, String r10) {
        return new UIUContextPluginParams(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UIUContextPluginParams) == true) goto L8;
        return false;
    L8:
        UIUContextPluginParams r10 = (UIUContextPluginParams) r5;
        if (this.pageSetting == r10.pageSetting) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cardId, r10.cardId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final PageSetting getPageSetting() {
        return this.pageSetting;
    }

    public int hashCode() {
        PageSetting r5 = this.pageSetting;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.cardId;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final void setPageSetting(PageSetting r5) {
        this.pageSetting = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("UIUContextPluginParams(pageSetting=");
        r5.append(this.pageSetting);
        r5.append(", cardId=");
        return j0.p(r5, this.cardId, ')');
    }
}
