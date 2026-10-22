package com.ss.android.lark.coremdbiz.facade.node;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/coremdbiz/facade/node/MarkdownAtUser;", "Ljava/io/Serializable;", "userId", BuildConfig.FLAVOR, "content", "isOutChatUser", BuildConfig.FLAVOR, "isAnonymous", "isHighLight", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZZ)V", "getUserId", "()Ljava/lang/String;", "getContent", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownAtUser implements Serializable {
    private final String content;
    private final boolean isAnonymous;
    private final boolean isHighLight;
    private final boolean isOutChatUser;
    private final String userId;

    public MarkdownAtUser() {
        this(null, null, false, false, false, 31, null);
    }

    public static /* synthetic */ MarkdownAtUser copy$default(MarkdownAtUser r3, String r4, String r5, boolean r6, boolean r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.userId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.content;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.isOutChatUser;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.isAnonymous;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.isHighLight;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.content;
    }

    public final boolean component3() {
        return this.isOutChatUser;
    }

    public final boolean component4() {
        return this.isAnonymous;
    }

    public final boolean component5() {
        return this.isHighLight;
    }

    public final MarkdownAtUser copy(String r8, String r9, boolean r10, boolean r11, boolean r12) {
        return new MarkdownAtUser(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MarkdownAtUser) == true) goto L8;
        return false;
    L8:
        MarkdownAtUser r6 = (MarkdownAtUser) r5;
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (this.isOutChatUser == r6.isOutChatUser) goto L18;
        return false;
    L18:
        if (this.isAnonymous == r6.isAnonymous) goto L21;
        return false;
    L21:
        if (this.isHighLight == r6.isHighLight) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.userId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.content;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (r3 + r1) * 31;
        int r6 = 1231;
        if (this.isOutChatUser == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r5 + r7) * 31;
        if (this.isAnonymous == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        if (this.isHighLight == true) goto L23;
        r6 = 1237;
    L23:
        return r10 + r6;
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MarkdownAtUser(userId=" + this.userId + ", content=" + this.content + ", isOutChatUser=" + this.isOutChatUser + ", isAnonymous=" + this.isAnonymous + ", isHighLight=" + this.isHighLight + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final boolean isAnonymous() {
        return this.isAnonymous;
    }

    public final boolean isHighLight() {
        return this.isHighLight;
    }

    public final boolean isOutChatUser() {
        return this.isOutChatUser;
    }

    public MarkdownAtUser(String r1, String r2, boolean r3, boolean r4, boolean r5) {
        this.userId = r1;
        this.content = r2;
        this.isOutChatUser = r3;
        this.isAnonymous = r4;
        this.isHighLight = r5;
    }

    public /* synthetic */ MarkdownAtUser(String r4, String r5, boolean r6, boolean r7, boolean r8, int r9, DefaultConstructorMarker r10) {
        String r0 = null;
        if ((r9 & 1) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r9 & 2) != 0) goto L11;
        r0 = r5;
    L11:
        if ((r9 & 4) == 0) goto L13;
        boolean r1 = false;
    L15:
        if ((r9 & 8) == 0) goto L17;
        boolean r2 = false;
    L19:
        if ((r9 & 16) == 0) goto L21;
        boolean r12 = false;
    L22:
        this(r11, r0, r1, r2, r12);
        return;
    L21:
        r12 = r8;
        goto L22
    L17:
        r2 = r7;
        goto L19
    L13:
        r1 = r6;
        goto L15
    L5:
        r11 = r4;
        goto L7
    }
}
