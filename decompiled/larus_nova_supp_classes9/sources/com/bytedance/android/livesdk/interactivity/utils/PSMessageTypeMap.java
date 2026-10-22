package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PSMessageTypeMap {
    public static final Boolean a = null;

    static {
        a = (Boolean) PublicScreenABHelper.M.getValue();
    }

    public static List b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "messageMethod");
        if (Intrinsics.areEqual(a, Boolean.FALSE) == false) goto L20;
        if (Intrinsics.areEqual(r10, MessageType.FANS_CLUB.getWsMethod()) == false) goto L7;
    L18:
        return null;
    L7:
        if (Intrinsics.areEqual(r10, MessageType.GIFT.getWsMethod()) == true) goto L18;
        if (Intrinsics.areEqual(r10, MessageType.GIFT_GROUP.getWsMethod()) == true) goto L18;
        if (Intrinsics.areEqual(r10, MessageType.LIKE_MESSAGE.getWsMethod()) == true) goto L18;
        if (Intrinsics.areEqual(r10, MessageType.MEMBER.getWsMethod()) == true) goto L18;
        if (Intrinsics.areEqual(r10, MessageType.SOCIAL.getWsMethod()) == true) goto L18;
        if (Intrinsics.areEqual(r10, MessageType.LUCKY_BOX.getWsMethod()) == true) goto L18;
    L20:
        if (Intrinsics.areEqual(r10, MessageType.CHAT.getWsMethod()) == false) goto L22;
    L59:
        List r1 = CollectionsKt.mutableListOf(new PanelItemSymbol[]{PanelItemSymbol.OPEN_PROFILE_SYMBOL, PanelItemSymbol.PIN_COMMENT_SYMBOL, PanelItemSymbol.REPLY, PanelItemSymbol.MARK_USER, PanelItemSymbol.LINK_MIC, PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL, PanelItemSymbol.SECRET_CHAT, PanelItemSymbol.COMMENT_CONTROL_MODE, PanelItemSymbol.CREATE_CHAT_CHANNEL, PanelItemSymbol.PUBLIC_SCREEN_HELPER});
        a(r1, PanelItemSymbol.REPLY_AND_PIN_SYMBOL, PSMessageTypeMap$getItemMap$1$1.INSTANCE);
        return r1;
    L22:
        if (Intrinsics.areEqual(r10, MessageType.SCREEN.getWsMethod()) == true) goto L59;
        if (Intrinsics.areEqual(r10, MessageType.PRIVILEGE_BARRAGE.getWsMethod()) == true) goto L59;
        if (Intrinsics.areEqual(r10, MessageType.VIDEO_SHARE_MESSAGE.getWsMethod()) == false) goto L30;
        List r2 = CollectionsKt.mutableListOf(new PanelItemSymbol[]{PanelItemSymbol.OPEN_PROFILE_SYMBOL, PanelItemSymbol.REPLY, PanelItemSymbol.OPEN_VIDEO_SYMBOL, PanelItemSymbol.MARK_USER, PanelItemSymbol.LINK_MIC, PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL, PanelItemSymbol.CREATE_CHAT_CHANNEL});
        a(r2, PanelItemSymbol.PIN_COMMENT_SYMBOL, PSMessageTypeMap$getItemMap$2$1.INSTANCE);
        return r2;
    L30:
        if (Intrinsics.areEqual(r10, MessageType.ITEM_SHARE_MESSAGE.getWsMethod()) == false) goto L33;
        List r3 = CollectionsKt.mutableListOf(new PanelItemSymbol[]{PanelItemSymbol.OPEN_PROFILE_SYMBOL, PanelItemSymbol.REPLY, PanelItemSymbol.OPEN_MICROAPP_SYMBOL, PanelItemSymbol.MARK_USER, PanelItemSymbol.LINK_MIC, PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL, PanelItemSymbol.CREATE_CHAT_CHANNEL});
        a(r3, PanelItemSymbol.PIN_COMMENT_SYMBOL, PSMessageTypeMap$getItemMap$3$1.INSTANCE);
        return r3;
    L33:
        if (Intrinsics.areEqual(r10, MessageType.ROOM.getWsMethod()) == false) goto L36;
        List r4 = CollectionsKt.mutableListOf(new PanelItemSymbol[]{PanelItemSymbol.OPEN_PROFILE_SYMBOL, PanelItemSymbol.MARK_USER, PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL, PanelItemSymbol.CREATE_CHAT_CHANNEL});
        a(r4, PanelItemSymbol.PIN_ROOMMESSAGE, PSMessageTypeMap$getItemMap$4$1.INSTANCE);
        return r4;
    L36:
        if (Intrinsics.areEqual(r10, MessageType.FANS_CLUB.getWsMethod()) == false) goto L39;
        return CollectionsKt.listOf(new PanelItemSymbol[]{PanelItemSymbol.OPEN_PROFILE_SYMBOL, PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL, PanelItemSymbol.MARK_USER, PanelItemSymbol.CREATE_CHAT_CHANNEL});
    L39:
        if (Intrinsics.areEqual(r10, MessageType.GIFT.getWsMethod()) == true) goto L71;
        if (Intrinsics.areEqual(r10, MessageType.GIFT_GROUP.getWsMethod()) == true) goto L71;
        if (Intrinsics.areEqual(r10, MessageType.LIKE_MESSAGE.getWsMethod()) == false) goto L47;
        return CollectionsKt.listOf(new PanelItemSymbol[]{PanelItemSymbol.OPEN_PROFILE_SYMBOL, PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL, PanelItemSymbol.MARK_USER, PanelItemSymbol.CREATE_CHAT_CHANNEL});
    L47:
        if (Intrinsics.areEqual(r10, MessageType.MEMBER.getWsMethod()) == false) goto L50;
        return CollectionsKt.listOf(new PanelItemSymbol[]{PanelItemSymbol.OPEN_PROFILE_SYMBOL, PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL, PanelItemSymbol.MARK_USER, PanelItemSymbol.CREATE_CHAT_CHANNEL});
    L50:
        if (Intrinsics.areEqual(r10, MessageType.SOCIAL.getWsMethod()) == false) goto L53;
        return CollectionsKt.listOf(new PanelItemSymbol[]{PanelItemSymbol.OPEN_PROFILE_SYMBOL, PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL, PanelItemSymbol.MARK_USER, PanelItemSymbol.CREATE_CHAT_CHANNEL});
    L53:
        if (Intrinsics.areEqual(r10, MessageType.LUCKY_BOX.getWsMethod()) == false) goto L56;
        return CollectionsKt.listOf(new PanelItemSymbol[]{PanelItemSymbol.OPEN_PROFILE_SYMBOL, PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL, PanelItemSymbol.MARK_USER, PanelItemSymbol.CREATE_CHAT_CHANNEL});
    L56:
        if (Intrinsics.areEqual(r10, MessageType.SECRET_CHAT.getWsMethod()) == true) goto L70;
        return null;
    L70:
        return CollectionsKt.listOf(new PanelItemSymbol[]{PanelItemSymbol.OPEN_PROFILE_SYMBOL, PanelItemSymbol.MARK_USER, PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL, PanelItemSymbol.SECRET_CHAT, PanelItemSymbol.CREATE_CHAT_CHANNEL});
    L71:
        return CollectionsKt.listOf(new PanelItemSymbol[]{PanelItemSymbol.OPEN_PROFILE_SYMBOL, PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL, PanelItemSymbol.MARK_USER, PanelItemSymbol.CREATE_CHAT_CHANNEL});
    }

    public static void a(List r0, PanelItemSymbol r1, Function0 r2) {
        if (((Boolean) r2.invoke()).booleanValue() == false) goto L6;
        r0.add(r1);
        return;
    }
}
