package com.ss.android.lark.custom.repeat.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/custom/repeat/entity/RruleListItem;", "Ljava/io/Serializable;", "rrule", BuildConfig.FLAVOR, "parsedText", "displayText", "extraTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRrule", "()Ljava/lang/String;", "getParsedText", "getDisplayText", "getExtraTag", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "custom-repeat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RruleListItem implements Serializable {
    private final String displayText;
    private final String extraTag;
    private final String parsedText;
    private final String rrule;

    public static /* synthetic */ RruleListItem copy$default(RruleListItem r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.rrule;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.parsedText;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.displayText;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.extraTag;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.rrule;
    }

    public final String component2() {
        return this.parsedText;
    }

    public final String component3() {
        return this.displayText;
    }

    public final String component4() {
        return this.extraTag;
    }

    public final RruleListItem copy(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "rrule");
        Intrinsics.checkNotNullParameter(r3, "parsedText");
        Intrinsics.checkNotNullParameter(r4, "displayText");
        Intrinsics.checkNotNullParameter(r5, "extraTag");
        return new RruleListItem(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RruleListItem) == true) goto L8;
        return false;
    L8:
        RruleListItem r6 = (RruleListItem) r5;
        if (Intrinsics.areEqual(this.rrule, r6.rrule) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parsedText, r6.parsedText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displayText, r6.displayText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extraTag, r6.extraTag) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.rrule.hashCode() * 31) + this.parsedText.hashCode()) * 31) + this.displayText.hashCode()) * 31) + this.extraTag.hashCode();
    }

    public String toString() {
        return "RruleListItem(rrule=" + this.rrule + ", parsedText=" + this.parsedText + ", displayText=" + this.displayText + ", extraTag=" + this.extraTag + ')';
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final String getExtraTag() {
        return this.extraTag;
    }

    public final String getParsedText() {
        return this.parsedText;
    }

    public final String getRrule() {
        return this.rrule;
    }

    public RruleListItem(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "rrule");
        Intrinsics.checkNotNullParameter(r3, "parsedText");
        Intrinsics.checkNotNullParameter(r4, "displayText");
        Intrinsics.checkNotNullParameter(r5, "extraTag");
        this.rrule = r2;
        this.parsedText = r3;
        this.displayText = r4;
        this.extraTag = r5;
    }

    public /* synthetic */ RruleListItem(String r1, String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = r2;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = BuildConfig.FLAVOR;
    L8:
        this(r1, r2, r3, r4);
    }
}
