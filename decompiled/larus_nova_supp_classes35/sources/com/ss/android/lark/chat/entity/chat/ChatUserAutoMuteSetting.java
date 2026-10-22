package com.ss.android.lark.chat.entity.chat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012*\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u001a\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003Ja\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032,\b\u0002\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R5\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatUserAutoMuteSetting;", "Ljava/io/Serializable;", "autoMuteConfig", "Lcom/ss/android/lark/chat/entity/chat/AutoMuteConfig;", "botAutoMute", "Ljava/util/LinkedHashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/LinkedHashMap;", "noticeType", "Lcom/bytedance/lark/pb/basic/v1/ChatUserAutoMuteSetting$NoticeType;", "updateTime", "showTopBanner", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/chat/entity/chat/AutoMuteConfig;Ljava/util/LinkedHashMap;Lcom/bytedance/lark/pb/basic/v1/ChatUserAutoMuteSetting$NoticeType;JZ)V", "getAutoMuteConfig", "()Lcom/ss/android/lark/chat/entity/chat/AutoMuteConfig;", "getBotAutoMute", "()Ljava/util/LinkedHashMap;", "getNoticeType", "()Lcom/bytedance/lark/pb/basic/v1/ChatUserAutoMuteSetting$NoticeType;", "getUpdateTime", "()J", "getShowTopBanner", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatUserAutoMuteSetting implements Serializable {
    private final AutoMuteConfig autoMuteConfig;
    private final LinkedHashMap<Long, AutoMuteConfig> botAutoMute;
    private final com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting.NoticeType noticeType;
    private final boolean showTopBanner;
    private final long updateTime;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatUserAutoMuteSetting copy$default(ChatUserAutoMuteSetting r4, AutoMuteConfig r5, LinkedHashMap r6, com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting.NoticeType r7, long r8, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.autoMuteConfig;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.botAutoMute;
    L8:
        LinkedHashMap r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.noticeType;
    L11:
        com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting.NoticeType r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.updateTime;
    L14:
        long r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.showTopBanner;
    L17:
        AutoMuteConfig r9 = r5;
        return r4.copy(r9, r13, r0, r1, r10);
    }

    public final AutoMuteConfig component1() {
        return this.autoMuteConfig;
    }

    public final LinkedHashMap<Long, AutoMuteConfig> component2() {
        return this.botAutoMute;
    }

    public final com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting.NoticeType component3() {
        return this.noticeType;
    }

    public final long component4() {
        return this.updateTime;
    }

    public final boolean component5() {
        return this.showTopBanner;
    }

    public final ChatUserAutoMuteSetting copy(AutoMuteConfig r9, LinkedHashMap<Long, AutoMuteConfig> r10, com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting.NoticeType r11, long r12, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "noticeType");
        return new ChatUserAutoMuteSetting(r9, r10, r11, r12, r14);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ChatUserAutoMuteSetting) == true) goto L8;
        return false;
    L8:
        ChatUserAutoMuteSetting r9 = (ChatUserAutoMuteSetting) r8;
        if (Intrinsics.areEqual(this.autoMuteConfig, r9.autoMuteConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botAutoMute, r9.botAutoMute) == true) goto L15;
        return false;
    L15:
        if (this.noticeType == r9.noticeType) goto L18;
        return false;
    L18:
        if (this.updateTime == r9.updateTime) goto L21;
        return false;
    L21:
        if (this.showTopBanner == r9.showTopBanner) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        AutoMuteConfig r0 = this.autoMuteConfig;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        LinkedHashMap<Long, AutoMuteConfig> r4 = this.botAutoMute;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (((r3 + r1) * 31) + this.noticeType.hashCode()) * 31;
        long r6 = this.updateTime;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        if (this.showTopBanner == false) goto L13;
        int r8 = 1231;
    L15:
        return r7 + r8;
    L13:
        r8 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ChatUserAutoMuteSetting(autoMuteConfig=" + this.autoMuteConfig + ", botAutoMute=" + this.botAutoMute + ", noticeType=" + this.noticeType + ", updateTime=" + this.updateTime + ", showTopBanner=" + this.showTopBanner + ')';
    }

    public final AutoMuteConfig getAutoMuteConfig() {
        return this.autoMuteConfig;
    }

    public final LinkedHashMap<Long, AutoMuteConfig> getBotAutoMute() {
        return this.botAutoMute;
    }

    public final com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting.NoticeType getNoticeType() {
        return this.noticeType;
    }

    public final boolean getShowTopBanner() {
        return this.showTopBanner;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public ChatUserAutoMuteSetting(AutoMuteConfig r2, LinkedHashMap<Long, AutoMuteConfig> r3, com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting.NoticeType r4, long r5, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "noticeType");
        this.autoMuteConfig = r2;
        this.botAutoMute = r3;
        this.noticeType = r4;
        this.updateTime = r5;
        this.showTopBanner = r7;
    }
}
