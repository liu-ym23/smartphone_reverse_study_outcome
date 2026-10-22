package com.bytedance.android.livesdk.interactivity.api.message;

import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.c;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.d;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.e;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.f;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.g;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.h;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.i;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.j;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.k;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.l;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.m;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.n;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.o;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.message.p;
import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageInject;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import y32.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\u0001\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018j\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/message/InteractivityMessageType;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdkapi/message/ExternalMessageInject$InjectInfo;", "toInjectInfo", "Lcom/bytedance/android/livesdkapi/message/ExternalMessageType;", "externalMessageType", "Lcom/bytedance/android/livesdkapi/message/ExternalMessageType;", "getExternalMessageType", "()Lcom/bytedance/android/livesdkapi/message/ExternalMessageType;", BuildConfig.FLAVOR, "messageIntType", "I", "getMessageIntType", "()I", BuildConfig.FLAVOR, "messageMethod", "Ljava/lang/String;", "getMessageMethod", "()Ljava/lang/String;", "Ljava/lang/Class;", "Lcom/bytedance/android/livesdkapi/message/ExternalBaseMessage;", "messageType", "Ljava/lang/Class;", "getMessageType", "()Ljava/lang/Class;", "Companion", "a", "RoomChannelAccess", "RoomChannelAccessReply", "RoomChannelRole", "RoomChannelChat", "RoomChannelEmojiChat", "RoomChannelGift", "RoomChannelDisband", "RoomChannelKickOut", "RoomChannelState", "RoomChannelSystem", "RoomChannelAsset", "RoomChannelSocialGroup", "AnswerReview", "PlatformAdvise", "RoomChannelEncrypt", "RoomChannelInteractivityEmojiChat", "RoomChannelSecretChatCreate", "RoomChannelSecretChatStatus", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InteractivityMessageType extends Enum<InteractivityMessageType> {
    public static final InteractivityMessageType AnswerReview = null;
    public static final a Companion = null;
    public static final InteractivityMessageType PlatformAdvise = null;
    public static final InteractivityMessageType RoomChannelAccess = null;
    public static final InteractivityMessageType RoomChannelAccessReply = null;
    public static final InteractivityMessageType RoomChannelAsset = null;
    public static final InteractivityMessageType RoomChannelChat = null;
    public static final InteractivityMessageType RoomChannelDisband = null;
    public static final InteractivityMessageType RoomChannelEmojiChat = null;
    public static final InteractivityMessageType RoomChannelEncrypt = null;
    public static final InteractivityMessageType RoomChannelGift = null;
    public static final InteractivityMessageType RoomChannelInteractivityEmojiChat = null;
    public static final InteractivityMessageType RoomChannelKickOut = null;
    public static final InteractivityMessageType RoomChannelRole = null;
    public static final InteractivityMessageType RoomChannelSecretChatCreate = null;
    public static final InteractivityMessageType RoomChannelSecretChatStatus = null;
    public static final InteractivityMessageType RoomChannelSocialGroup = null;
    public static final InteractivityMessageType RoomChannelState = null;
    public static final InteractivityMessageType RoomChannelSystem = null;
    public static final /* synthetic */ InteractivityMessageType[] a = null;
    public static final ArrayList<ExternalMessageInject.InjectInfo> b = null;
    private final ExternalMessageType externalMessageType;
    private final int messageIntType;
    private final String messageMethod;
    private final Class<? extends ExternalBaseMessage> messageType;

    public static final class a {
        public a() {
        }
    }

    public static final ArrayList<ExternalMessageInject.InjectInfo> getInjectInfoList() {
        return b;
    }

    public static InteractivityMessageType valueOf(String r1) {
        return (InteractivityMessageType) r27.a.a(InteractivityMessageType.class, r1);
    }

    public static InteractivityMessageType[] values() {
        return (InteractivityMessageType[]) a.clone();
    }

    static {
        int r4 = b.a;
        b.a = r4 + 1;
        InteractivityMessageType r7 = new InteractivityMessageType("RoomChannelAccess", 0, r4, "WebcastRoomChannelAccessMessage", com.bytedance.android.livesdk.interactivity.api.chatchannel.message.b.class);
        RoomChannelAccess = r7;
        int r1 = 0;
        int r11 = b.a;
        b.a = r11 + 1;
        InteractivityMessageType r2 = new InteractivityMessageType("RoomChannelAccessReply", 1, r11, "WebcastReplyRoomChannelMessage", com.bytedance.android.livesdk.interactivity.api.chatchannel.message.a.class);
        RoomChannelAccessReply = r2;
        int r8 = b.a;
        b.a = r8 + 1;
        InteractivityMessageType r3 = new InteractivityMessageType("RoomChannelRole", 2, r8, "WebcastRoomChannelRoleMessage", k.class);
        RoomChannelRole = r3;
        int r9 = b.a;
        b.a = r9 + 1;
        InteractivityMessageType r5 = new InteractivityMessageType("RoomChannelChat", 3, r9, "WebcastRoomChannelChatMessage", d.class);
        RoomChannelChat = r5;
        int r10 = b.a;
        b.a = r10 + 1;
        InteractivityMessageType r6 = new InteractivityMessageType("RoomChannelEmojiChat", 4, r10, "WebcastRoomChannelEmojiChatMessage", g.class);
        RoomChannelEmojiChat = r6;
        int r13 = b.a;
        b.a = r13 + 1;
        InteractivityMessageType r14 = new InteractivityMessageType("RoomChannelGift", 5, r13, "WebcastRoomChannelGiftMessage", h.class);
        RoomChannelGift = r14;
        int r15 = b.a;
        b.a = r15 + 1;
        InteractivityMessageType r16 = new InteractivityMessageType("RoomChannelDisband", 6, r15, "WebcastRoomChannelDisbandMessage", f.class);
        RoomChannelDisband = r16;
        int r17 = b.a;
        b.a = r17 + 1;
        InteractivityMessageType r18 = new InteractivityMessageType("RoomChannelKickOut", 7, r17, "WebcastRoomChannelKickOutMessage", j.class);
        RoomChannelKickOut = r18;
        int r19 = b.a;
        b.a = r19 + 1;
        InteractivityMessageType r20 = new InteractivityMessageType("RoomChannelState", 8, r19, "WebcastRoomChannelStateMessage", o.class);
        RoomChannelState = r20;
        int r21 = b.a;
        b.a = r21 + 1;
        InteractivityMessageType r23 = new InteractivityMessageType("RoomChannelSystem", 9, r21, "WebcastRoomChannelSystemMessage", p.class);
        RoomChannelSystem = r23;
        int r24 = b.a;
        b.a = r24 + 1;
        InteractivityMessageType r25 = new InteractivityMessageType("RoomChannelAsset", 10, r24, "WebcastRoomChannelAssetMessage", c.class);
        RoomChannelAsset = r25;
        int r26 = b.a;
        b.a = r26 + 1;
        InteractivityMessageType r27 = new InteractivityMessageType("RoomChannelSocialGroup", 11, r26, "WebcastRoomChannelSaveGroupMessage", n.class);
        RoomChannelSocialGroup = r27;
        int r28 = b.a;
        b.a = r28 + 1;
        InteractivityMessageType r29 = new InteractivityMessageType("AnswerReview", 12, r28, "WebcastAnswerReviewMessage", com.bytedance.android.livesdk.interactivity.api.message.model.a.class);
        AnswerReview = r29;
        int r30 = b.a;
        b.a = r30 + 1;
        InteractivityMessageType r31 = new InteractivityMessageType("PlatformAdvise", 13, r30, "WebcastPlatformAdviseMessage", com.bytedance.android.livesdk.interactivity.api.message.model.b.class);
        PlatformAdvise = r31;
        int r33 = b.a;
        b.a = r33 + 1;
        InteractivityMessageType r34 = new InteractivityMessageType("RoomChannelEncrypt", 14, r33, "WebcastRoomChannelCipherMessage", e.class);
        RoomChannelEncrypt = r34;
        int r35 = b.a;
        b.a = r35 + 1;
        InteractivityMessageType r36 = new InteractivityMessageType("RoomChannelInteractivityEmojiChat", 15, r35, "WebcastRoomChannelInteractiveEmojiChatMessage", i.class);
        RoomChannelInteractivityEmojiChat = r36;
        int r37 = b.a;
        b.a = r37 + 1;
        InteractivityMessageType r38 = new InteractivityMessageType("RoomChannelSecretChatCreate", 16, r37, "WebcastRoomSecretCreateMessage", l.class);
        RoomChannelSecretChatCreate = r38;
        int r39 = b.a;
        b.a = r39 + 1;
        InteractivityMessageType r40 = new InteractivityMessageType("RoomChannelSecretChatStatus", 17, r39, "WebcastRoomChannelSecretStatusMessage", m.class);
        RoomChannelSecretChatStatus = r40;
        a = new InteractivityMessageType[]{r7, r2, r3, r5, r6, r14, r16, r18, r20, r23, r25, r27, r29, r31, r34, r36, r38, r40};
        Companion = new a();
        b = new ArrayList();
        InteractivityMessageType[] r0 = values();
        int r41 = r0.length;
    L3:
        if (r1 >= r41) goto L5;
        b.add(r0[r1].toInjectInfo());
        r1 = r1 + 1;
        goto L3
    }

    public final ExternalMessageInject.InjectInfo toInjectInfo() {
        return new ExternalMessageInject.InjectInfo(this.messageMethod, this.messageType);
    }

    public static final /* synthetic */ ArrayList access$getInjectInfoList$cp() {
        return b;
    }

    public final ExternalMessageType getExternalMessageType() {
        return this.externalMessageType;
    }

    public final int getMessageIntType() {
        return this.messageIntType;
    }

    public final String getMessageMethod() {
        return this.messageMethod;
    }

    public final Class<? extends ExternalBaseMessage> getMessageType() {
        return this.messageType;
    }

    public InteractivityMessageType(String r1, int r2, int r3, String r4, Class r5) {
        super(r1, r2);
        this.messageIntType = r3;
        this.messageMethod = r4;
        this.messageType = r5;
        this.externalMessageType = ExternalMessageType.EXTERNAL_LIVE_INTERACTIVITY;
    }
}
