package com.ss.android.lark.inline.ai.api.ui;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0019\u001a\u00020\u0005H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006#"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/Tips;", "Ljava/io/Serializable;", "show", "", "text", "", "icon", "", "url", "<init>", "(ZLjava/lang/String;ILjava/lang/String;)V", "getShow", "()Z", "setShow", "(Z)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getIcon", "()I", "setIcon", "(I)V", "getUrl", "setUrl", "toString", "component1", "component2", "component3", "component4", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class Tips implements Serializable {
    private int icon;
    private boolean show;
    private String text;
    private String url;

    public static /* synthetic */ Tips copy$default(Tips r0, boolean r1, String r2, int r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.show;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.text;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.icon;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.url;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.show;
    }

    public final String component2() {
        return this.text;
    }

    public final int component3() {
        return this.icon;
    }

    public final String component4() {
        return this.url;
    }

    public final Tips copy(boolean r2, String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "text");
        return new Tips(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Tips) == true) goto L8;
        return false;
    L8:
        Tips r6 = (Tips) r5;
        if (this.show == r6.show) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L15;
        return false;
    L15:
        if (this.icon == r6.icon) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.show == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((r0 * 31) + this.text.hashCode()) * 31) + this.icon) * 31;
        String r2 = this.url;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return r1 + r3;
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "Tips(show=" + this.show + ", text='" + this.text + "', icon=" + this.icon + ", url=" + this.url + ')';
    }

    public final int getIcon() {
        return this.icon;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final String getText() {
        return this.text;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setIcon(int r1) {
        this.icon = r1;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.text = r2;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public Tips(boolean r2, String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "text");
        this.show = r2;
        this.text = r3;
        this.icon = r4;
        this.url = r5;
    }

    public /* synthetic */ Tips(boolean r1, String r2, int r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = null;
    L8:
        this(r1, r2, r3, r4);
    }
}
