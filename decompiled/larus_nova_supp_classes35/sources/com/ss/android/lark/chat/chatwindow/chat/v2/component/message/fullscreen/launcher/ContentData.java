package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0006\u0010\u0013\u001a\u00020\u000fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J+\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ContentData;", "Ljava/io/Serializable;", "originText", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/RichTextData;", "translateText", "contentType", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/RichTextData;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/RichTextData;I)V", "getOriginText", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/RichTextData;", "getTranslateText", "getContentType", "()I", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "isValid", "component1", "component2", "component3", "copy", "toString", BuildConfig.FLAVOR, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContentData implements Serializable {
    public static final a Companion = null;
    private final int contentType;
    private final RichTextData originText;
    private final RichTextData translateText;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ContentData copy$default(ContentData r0, RichTextData r1, RichTextData r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.originText;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.translateText;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.contentType;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final RichTextData component1() {
        return this.originText;
    }

    public final RichTextData component2() {
        return this.translateText;
    }

    public final int component3() {
        return this.contentType;
    }

    public final ContentData copy(RichTextData r2, RichTextData r3, int r4) {
        return new ContentData(r2, r3, r4);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.originText, this.translateText, Integer.valueOf(this.contentType)});
    }

    public String toString() {
        return "ContentData(originText=" + this.originText + ", translateText=" + this.translateText + ", contentType=" + this.contentType + ')';
    }

    public final boolean isValid() {
        RichTextData r0 = this.originText;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L19;
        RichTextData r2 = this.translateText;
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L20;
        return false;
    L20:
        return true;
    L12:
        if (r2.isValid() != true) goto L14;
        r3 = true;
        goto L15
    L19:
        return true;
    L5:
        if (r0.isValid() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final RichTextData getOriginText() {
        return this.originText;
    }

    public final RichTextData getTranslateText() {
        return this.translateText;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(ContentData.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.ContentData");
        ContentData r6 = (ContentData) r5;
        if (Intrinsics.areEqual(this.originText, r6.originText) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.translateText, r6.translateText) == true) goto L19;
        return false;
    L19:
        if (this.contentType == r6.contentType) goto L21;
        return false;
    L21:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public ContentData(RichTextData r1, RichTextData r2, int r3) {
        this.originText = r1;
        this.translateText = r2;
        this.contentType = r3;
    }
}
