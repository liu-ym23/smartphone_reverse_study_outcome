package com.ss.android.lark.inline.ai.api.ui;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001'B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020\u0005H\u0016J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J=\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/Operate;", "Ljava/io/Serializable;", "type", "", "icon", "", "text", "btnType", "disabled", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getIcon", "()I", "setIcon", "(I)V", "getText", "setText", "getBtnType", "setBtnType", "getDisabled", "()Z", "setDisabled", "(Z)V", "toString", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "component1", "component2", "component3", "component4", "component5", "copy", "BtnType", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class Operate implements Serializable {
    private String btnType;
    private boolean disabled;
    private int icon;
    private String text;
    private String type;

    public static /* synthetic */ Operate copy$default(Operate r3, String r4, int r5, String r6, String r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.type;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.icon;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.text;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.btnType;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.disabled;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.type;
    }

    public final int component2() {
        return this.icon;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.btnType;
    }

    public final boolean component5() {
        return this.disabled;
    }

    public final Operate copy(String r8, int r9, String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "type");
        Intrinsics.checkNotNullParameter(r10, "text");
        return new Operate(r8, r9, r10, r11, r12);
    }

    public int hashCode() {
        int r0 = ((((this.type.hashCode() * 31) + this.icon) * 31) + this.text.hashCode()) * 31;
        String r1 = this.btnType;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.disabled == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "Operate(type='" + this.type + "', icon=" + this.icon + ", text='" + this.text + "', btnType=" + this.btnType + ", disabled=" + this.disabled + ')';
    }

    public final String getBtnType() {
        return this.btnType;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof Operate) == false) goto L16;
        Operate r5 = (Operate) r4;
        if (Intrinsics.areEqual(this.type, r5.type) == true) goto L7;
        return false;
    L7:
        if (this.icon == r5.icon) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.text, r5.text) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.btnType, r5.btnType) == true) goto L13;
        return false;
    L13:
        if (this.disabled != r5.disabled) goto L21;
        return true;
    L21:
        return false;
    L16:
        return false;
    }

    public final void setBtnType(String r1) {
        this.btnType = r1;
    }

    public final void setDisabled(boolean r1) {
        this.disabled = r1;
    }

    public final void setIcon(int r1) {
        this.icon = r1;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.text = r2;
    }

    public final void setType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.type = r2;
    }

    public Operate(String r2, int r3, String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r4, "text");
        this.type = r2;
        this.icon = r3;
        this.text = r4;
        this.btnType = r5;
        this.disabled = r6;
    }

    public /* synthetic */ Operate(String r7, int r8, String r9, String r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        String r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        boolean r5 = false;
    L9:
        this(r7, r8, r9, r4, r5);
        return;
    L8:
        r5 = r11;
        goto L9
    }
}
