package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageSenderAppInfo;", "Ljava/io/Serializable;", "isAgent", BuildConfig.FLAVOR, "avatarUrl", BuildConfig.FLAVOR, "<init>", "(ZLjava/lang/String;)V", "()Z", "getAvatarUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageSenderAppInfo implements Serializable {
    private final String avatarUrl;
    private final boolean isAgent;

    public MessageSenderAppInfo() {
        String r0 = null;
        boolean r2 = false;
        this(r2, r0, 3, r0);
    }

    public static /* synthetic */ MessageSenderAppInfo copy$default(MessageSenderAppInfo r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.isAgent;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.avatarUrl;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.isAgent;
    }

    public final String component2() {
        return this.avatarUrl;
    }

    public final MessageSenderAppInfo copy(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "avatarUrl");
        return new MessageSenderAppInfo(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MessageSenderAppInfo) == true) goto L8;
        return false;
    L8:
        MessageSenderAppInfo r6 = (MessageSenderAppInfo) r5;
        if (this.isAgent == r6.isAgent) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatarUrl, r6.avatarUrl) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.isAgent == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.avatarUrl.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public String toString() {
        return "MessageSenderAppInfo(isAgent=" + this.isAgent + ", avatarUrl=" + this.avatarUrl + ')';
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final boolean isAgent() {
        return this.isAgent;
    }

    public MessageSenderAppInfo(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "avatarUrl");
        this.isAgent = r2;
        this.avatarUrl = r3;
    }

    public /* synthetic */ MessageSenderAppInfo(boolean r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = BuildConfig.FLAVOR;
    L8:
        this(r1, r2);
    }
}
