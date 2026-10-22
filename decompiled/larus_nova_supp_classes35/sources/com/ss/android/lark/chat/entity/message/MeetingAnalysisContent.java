package com.ss.android.lark.chat.entity.message;

import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0000H\u0016J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MeetingAnalysisContent;", "Lcom/larksuite/framework/utils/diff/Diffable;", "Ljava/io/Serializable;", "content", BuildConfig.FLAVOR, "jumpUrl", "buttons", "Ljava/util/LinkedList;", "Lcom/ss/android/lark/chat/entity/message/Button;", "richText", "Lcom/ss/android/lark/widget/richtext/RichText;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Lcom/ss/android/lark/widget/richtext/RichText;)V", "getContent", "()Ljava/lang/String;", "getJumpUrl", "getButtons", "()Ljava/util/LinkedList;", "getRichText", "()Lcom/ss/android/lark/widget/richtext/RichText;", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "component1", "component2", "component3", "component4", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MeetingAnalysisContent implements b<MeetingAnalysisContent>, Serializable {
    private final LinkedList<Button> buttons;
    private final String content;
    private final String jumpUrl;
    private final RichText richText;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MeetingAnalysisContent copy$default(MeetingAnalysisContent r0, String r1, String r2, LinkedList r3, RichText r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.content;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.jumpUrl;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.buttons;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.richText;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.content;
    }

    public final String component2() {
        return this.jumpUrl;
    }

    public final LinkedList<Button> component3() {
        return this.buttons;
    }

    public final RichText component4() {
        return this.richText;
    }

    public final MeetingAnalysisContent copy(String r2, String r3, LinkedList<Button> r4, RichText r5) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "jumpUrl");
        return new MeetingAnalysisContent(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MeetingAnalysisContent) == true) goto L8;
        return false;
    L8:
        MeetingAnalysisContent r6 = (MeetingAnalysisContent) r5;
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpUrl, r6.jumpUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.buttons, r6.buttons) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.richText, r6.richText) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.content.hashCode() * 31) + this.jumpUrl.hashCode()) * 31;
        LinkedList<Button> r1 = this.buttons;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        RichText r5 = this.richText;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "MeetingAnalysisContent(content=" + this.content + ", jumpUrl=" + this.jumpUrl + ", buttons=" + this.buttons + ", richText=" + this.richText + ')';
    }

    public final LinkedList<Button> getButtons() {
        return this.buttons;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final RichText getRichText() {
        return this.richText;
    }

    public boolean isContentSame(MeetingAnalysisContent r4) {
        String r0 = this.content;
        if (r4 == null) goto L5;
        String r1 = r4.content;
    L7:
        if (Intrinsics.areEqual(r0, r1) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jumpUrl, r4.jumpUrl) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.buttons, r4.buttons) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.richText, r4.richText) == true) goto L18;
        return false;
    L18:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((MeetingAnalysisContent) r1);
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((MeetingAnalysisContent) r1);
    }

    public boolean isItemSame(MeetingAnalysisContent r1) {
        return Intrinsics.areEqual(this, r1);
    }

    public MeetingAnalysisContent(String r2, String r3, LinkedList<Button> r4, RichText r5) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "jumpUrl");
        this.content = r2;
        this.jumpUrl = r3;
        this.buttons = r4;
        this.richText = r5;
    }
}
