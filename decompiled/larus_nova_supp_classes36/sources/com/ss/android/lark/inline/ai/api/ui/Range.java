package com.ss.android.lark.inline.ai.api.ui;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/Range;", "Ljava/io/Serializable;", "show", "", "text", "", "enable", "suffixIcon", "<init>", "(ZLjava/lang/String;ZLjava/lang/String;)V", "getShow", "()Z", "getText", "()Ljava/lang/String;", "getEnable", "getSuffixIcon", "toString", "component1", "component2", "component3", "component4", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class Range implements Serializable {
    private final boolean enable;
    private final boolean show;
    private final String suffixIcon;
    private final String text;

    public Range() {
        this(false, null, false, null, 15, null);
    }

    public static /* synthetic */ Range copy$default(Range r0, boolean r1, String r2, boolean r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.show;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.text;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.enable;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.suffixIcon;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.show;
    }

    public final String component2() {
        return this.text;
    }

    public final boolean component3() {
        return this.enable;
    }

    public final String component4() {
        return this.suffixIcon;
    }

    public final Range copy(boolean r2, String r3, boolean r4, String r5) {
        return new Range(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Range) == true) goto L8;
        return false;
    L8:
        Range r6 = (Range) r5;
        if (this.show == r6.show) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L15;
        return false;
    L15:
        if (this.enable == r6.enable) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.suffixIcon, r6.suffixIcon) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.show == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        String r3 = this.text;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        if (this.enable == true) goto L14;
        r1 = 1237;
    L14:
        int r7 = (r6 + r1) * 31;
        String r8 = this.suffixIcon;
        if (r8 == null) goto L19;
        r4 = r8.hashCode();
    L19:
        return r7 + r4;
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "Range(show=" + this.show + ", text=" + this.text + ", enable=" + this.enable + ", suffixIcon=" + this.suffixIcon + ')';
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final String getSuffixIcon() {
        return this.suffixIcon;
    }

    public final String getText() {
        return this.text;
    }

    public Range(boolean r1, String r2, boolean r3, String r4) {
        this.show = r1;
        this.text = r2;
        this.enable = r3;
        this.suffixIcon = r4;
    }

    public /* synthetic */ Range(boolean r3, String r4, boolean r5, String r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = "";
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = false;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = "";
    L14:
        this(r3, r4, r5, r6);
    }
}
