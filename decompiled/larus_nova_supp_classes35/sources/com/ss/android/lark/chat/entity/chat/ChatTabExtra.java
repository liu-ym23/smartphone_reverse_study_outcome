package com.ss.android.lark.chat.entity.chat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatTabExtra;", "Ljava/io/Serializable;", "badge", BuildConfig.FLAVOR, "count", "<init>", "(II)V", "getBadge", "()I", "setBadge", "(I)V", "getCount", "setCount", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTabExtra implements Serializable {
    public static final a Companion = null;
    private int badge;
    private int count;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ChatTabExtra() {
        int r2 = 0;
        this(r2, r2, 3, null);
    }

    @JvmStatic
    public static final boolean badgeValid(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ ChatTabExtra copy$default(ChatTabExtra r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.badge;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.count;
    L9:
        return r0.copy(r1, r2);
    }

    @JvmStatic
    public static final boolean countValid(int r1) {
        Companion.getClass();
        if (r1 <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public final int component1() {
        return this.badge;
    }

    public final int component2() {
        return this.count;
    }

    public final ChatTabExtra copy(int r2, int r3) {
        return new ChatTabExtra(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatTabExtra) == true) goto L8;
        return false;
    L8:
        ChatTabExtra r6 = (ChatTabExtra) r5;
        if (this.badge == r6.badge) goto L12;
        return false;
    L12:
        if (this.count == r6.count) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.badge * 31) + this.count;
    }

    public String toString() {
        return "ChatTabExtra(badge=" + this.badge + ", count=" + this.count + ')';
    }

    public final int getBadge() {
        return this.badge;
    }

    public final int getCount() {
        return this.count;
    }

    public final void setBadge(int r1) {
        this.badge = r1;
    }

    public final void setCount(int r1) {
        this.count = r1;
    }

    public ChatTabExtra(int r1, int r2) {
        this.badge = r1;
        this.count = r2;
    }

    public /* synthetic */ ChatTabExtra(int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        this(r2, r3);
    }
}
