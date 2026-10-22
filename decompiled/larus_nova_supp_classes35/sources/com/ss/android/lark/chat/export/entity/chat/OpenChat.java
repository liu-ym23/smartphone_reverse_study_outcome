package com.ss.android.lark.chat.export.entity.chat;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\tH&J\b\u0010\u000f\u001a\u00020\tH&J\b\u0010\u0010\u001a\u00020\tH&J\b\u0010\u0011\u001a\u00020\tH&J\b\u0010\u0012\u001a\u00020\tH&J\b\u0010\u0013\u001a\u00020\tH&J\b\u0010\u0014\u001a\u00020\tH&J\b\u0010\u0015\u001a\u00020\tH&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\tH&J\b\u0010\u0018\u001a\u00020\tH&J\b\u0010\u0019\u001a\u00020\tH&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u001b\u001a\u00020\tH&¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/export/entity/chat/OpenChat;", "Ljava/io/Serializable;", "getId", BuildConfig.FLAVOR, "getName", "getAvatarKey", "getUserCount", BuildConfig.FLAVOR, "isMeeting", BuildConfig.FLAVOR, "isCustomerService", "isOnCall", "isSecret", "isP2PChat", "isAIChat", "isAIMainChat", "isAIBotChat", "isGroup", "isMember", "isCrossTenant", "isCrossWithKa", "isSoloChat", "getP2pChatterId", "isAllowPost", "isOnlyManagerCreateVC", "isAdmin", "getGroupOwnerId", "needEnterChatApply", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OpenChat extends Serializable {
    String getAvatarKey();

    String getGroupOwnerId();

    String getId();

    String getName();

    String getP2pChatterId();

    int getUserCount();

    boolean isAIBotChat();

    boolean isAIChat();

    boolean isAIMainChat();

    boolean isAdmin();

    boolean isAllowPost();

    boolean isCrossTenant();

    boolean isCrossWithKa();

    boolean isCustomerService();

    boolean isGroup();

    boolean isMeeting();

    boolean isMember();

    boolean isOnCall();

    boolean isOnlyManagerCreateVC();

    boolean isP2PChat();

    boolean isSecret();

    boolean isSoloChat();

    boolean needEnterChatApply();
}
