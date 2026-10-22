package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/SmartReplyEntryInfo;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "hasPreGenerated", BuildConfig.FLAVOR, "aiMessageId", BuildConfig.FLAVOR, "recommendContent", BuildConfig.FLAVOR, "<init>", "(ZLjava/lang/String;Ljava/lang/CharSequence;)V", "getHasPreGenerated", "()Z", "getAiMessageId", "()Ljava/lang/String;", "getRecommendContent", "()Ljava/lang/CharSequence;", "component1", "component2", "component3", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SmartReplyEntryInfo implements Serializable, Cloneable {
    public final transient CharSequence a;
    private final String aiMessageId;
    private final boolean hasPreGenerated;

    public static /* synthetic */ SmartReplyEntryInfo copy$default(SmartReplyEntryInfo r0, boolean r1, String r2, CharSequence r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.hasPreGenerated;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.aiMessageId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.a;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.hasPreGenerated;
    }

    public final String component2() {
        return this.aiMessageId;
    }

    public final CharSequence component3() {
        return this.a;
    }

    public final SmartReplyEntryInfo copy(boolean r2, String r3, CharSequence r4) {
        Intrinsics.checkNotNullParameter(r3, "aiMessageId");
        return new SmartReplyEntryInfo(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SmartReplyEntryInfo) == true) goto L8;
        return false;
    L8:
        SmartReplyEntryInfo r6 = (SmartReplyEntryInfo) r5;
        if (this.hasPreGenerated == r6.hasPreGenerated) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aiMessageId, r6.aiMessageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.hasPreGenerated == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.aiMessageId.hashCode()) * 31;
        CharSequence r2 = this.a;
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
        return "SmartReplyEntryInfo(hasPreGenerated=" + this.hasPreGenerated + ", aiMessageId=" + this.aiMessageId + ", recommendContent=" + this.a + ')';
    }

    public Object clone() {
        return super.clone();
    }

    public final String getAiMessageId() {
        return this.aiMessageId;
    }

    public final boolean getHasPreGenerated() {
        return this.hasPreGenerated;
    }

    public final CharSequence getRecommendContent() {
        return this.a;
    }

    public SmartReplyEntryInfo(boolean r2, String r3, CharSequence r4) {
        Intrinsics.checkNotNullParameter(r3, "aiMessageId");
        this.hasPreGenerated = r2;
        this.aiMessageId = r3;
        this.a = r4;
    }

    public /* synthetic */ SmartReplyEntryInfo(boolean r1, String r2, CharSequence r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
