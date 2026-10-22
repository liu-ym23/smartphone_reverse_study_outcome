package com.ss.android.lark.chat.entity.wallpaper;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J%\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003Jg\u0010(\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R-\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeListInfo;", "Ljava/io/Serializable;", "themeItems", "Ljava/util/LinkedList;", "Lcom/ss/android/lark/chat/entity/wallpaper/ThemeListItem;", "chatThemes", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lokio/ByteString;", "Lkotlin/collections/HashMap;", "nextPos", Keys.API_RETURN_KEY_HAS_MORE, BuildConfig.FLAVOR, "userUsedThemeId", "groupUsedThemeId", "<init>", "(Ljava/util/LinkedList;Ljava/util/HashMap;JZJJ)V", "getThemeItems", "()Ljava/util/LinkedList;", "getChatThemes", "()Ljava/util/HashMap;", "getNextPos", "()J", "getHasMore", "()Z", "getUserUsedThemeId", "getGroupUsedThemeId", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "component1", "component2", "component3", "component4", "component5", "component6", "copy", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatThemeListInfo implements Serializable {
    private final HashMap<Long, ByteString> chatThemes;
    private final long groupUsedThemeId;
    private final boolean hasMore;
    private final long nextPos;
    private final LinkedList<ThemeListItem> themeItems;
    private final long userUsedThemeId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatThemeListInfo copy$default(ChatThemeListInfo r10, LinkedList r11, HashMap r12, long r13, boolean r15, long r16, long r18, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        LinkedList r1 = r10.themeItems;
    L7:
        if ((r20 & 2) == 0) goto L9;
        HashMap r2 = r10.chatThemes;
    L11:
        if ((r20 & 4) == 0) goto L13;
        long r3 = r10.nextPos;
    L15:
        if ((r20 & 8) == 0) goto L17;
        boolean r5 = r10.hasMore;
    L19:
        if ((r20 & 16) == 0) goto L21;
        long r6 = r10.userUsedThemeId;
    L23:
        if ((r20 & 32) == 0) goto L25;
        long r8 = r10.groupUsedThemeId;
    L27:
        return r10.copy(r1, r2, r3, r5, r6, r8);
    L25:
        r8 = r18;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final LinkedList<ThemeListItem> component1() {
        return this.themeItems;
    }

    public final HashMap<Long, ByteString> component2() {
        return this.chatThemes;
    }

    public final long component3() {
        return this.nextPos;
    }

    public final boolean component4() {
        return this.hasMore;
    }

    public final long component5() {
        return this.userUsedThemeId;
    }

    public final long component6() {
        return this.groupUsedThemeId;
    }

    public final ChatThemeListInfo copy(LinkedList<ThemeListItem> r12, HashMap<Long, ByteString> r13, long r14, boolean r16, long r17, long r19) {
        Intrinsics.checkNotNullParameter(r12, "themeItems");
        Intrinsics.checkNotNullParameter(r13, "chatThemes");
        return new ChatThemeListInfo(r12, r13, r14, r16, r17, r19);
    }

    public int hashCode() {
        int r0 = ((this.themeItems.hashCode() * 31) + this.chatThemes.hashCode()) * 31;
        long r1 = this.nextPos;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        if (this.hasMore == false) goto L5;
        int r3 = 1231;
    L6:
        int r4 = (r2 + r3) * 31;
        long r5 = this.userUsedThemeId;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.groupUsedThemeId;
        return r6 + ((int) (r7 ^ (r7 >>> 32)));
    L5:
        r3 = 1237;
        goto L6
    }

    public String toString() {
        return "ChatThemeListInfo(themeItems=" + this.themeItems + ", chatThemes=" + this.chatThemes + ", nextPos=" + this.nextPos + ", hasMore=" + this.hasMore + ", userUsedThemeId=" + this.userUsedThemeId + ", groupUsedThemeId=" + this.groupUsedThemeId + ')';
    }

    public final HashMap<Long, ByteString> getChatThemes() {
        return this.chatThemes;
    }

    public final long getGroupUsedThemeId() {
        return this.groupUsedThemeId;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final long getNextPos() {
        return this.nextPos;
    }

    public final LinkedList<ThemeListItem> getThemeItems() {
        return this.themeItems;
    }

    public final long getUserUsedThemeId() {
        return this.userUsedThemeId;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 == null) goto L8;
        Class<?> r2 = r8.getClass();
    L10:
        if (Intrinsics.areEqual(ChatThemeListInfo.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.wallpaper.ChatThemeListInfo");
        ChatThemeListInfo r9 = (ChatThemeListInfo) r8;
        if (Intrinsics.areEqual(this.themeItems, r9.themeItems) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.chatThemes, r9.chatThemes) == true) goto L19;
        return false;
    L19:
        if (this.nextPos == r9.nextPos) goto L22;
        return false;
    L22:
        if (this.hasMore == r9.hasMore) goto L25;
        return false;
    L25:
        if (this.userUsedThemeId == r9.userUsedThemeId) goto L28;
        return false;
    L28:
        if (this.groupUsedThemeId == r9.groupUsedThemeId) goto L30;
        return false;
    L30:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public ChatThemeListInfo(LinkedList<ThemeListItem> r2, HashMap<Long, ByteString> r3, long r4, boolean r6, long r7, long r9) {
        Intrinsics.checkNotNullParameter(r2, "themeItems");
        Intrinsics.checkNotNullParameter(r3, "chatThemes");
        this.themeItems = r2;
        this.chatThemes = r3;
        this.nextPos = r4;
        this.hasMore = r6;
        this.userUsedThemeId = r7;
        this.groupUsedThemeId = r9;
    }
}
