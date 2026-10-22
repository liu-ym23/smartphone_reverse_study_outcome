package com.ss.android.lark.feed.app.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/TextWithEmojiProperty;", "Lcom/ss/android/lark/feed/app/entity/DigestElement;", "content", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "isItemSame", BuildConfig.FLAVOR, "other", "isContentSame", "component1", "copy", "equals", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextWithEmojiProperty extends DigestElement {
    private final String content;

    public static /* synthetic */ TextWithEmojiProperty copy$default(TextWithEmojiProperty r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.content;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.content;
    }

    public final TextWithEmojiProperty copy(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        return new TextWithEmojiProperty(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof TextWithEmojiProperty) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.content, ((TextWithEmojiProperty) r4).content) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public String toString() {
        return "TextWithEmojiProperty(content=" + this.content + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public TextWithEmojiProperty(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(null);
        this.content = r2;
    }

    public boolean isContentSame(DigestElement r2) {
        Intrinsics.checkNotNullParameter(r2, "other");
        if ((r2 instanceof TextWithEmojiProperty) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.content, ((TextWithEmojiProperty) r2).content);
    }

    @Override // com.ss.android.lark.feed.app.entity.DigestElement
    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((DigestElement) r1);
    }

    @Override // com.ss.android.lark.feed.app.entity.DigestElement
    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((DigestElement) r1);
    }

    public boolean isItemSame(DigestElement r1) {
        return Intrinsics.areEqual(this, r1);
    }
}
