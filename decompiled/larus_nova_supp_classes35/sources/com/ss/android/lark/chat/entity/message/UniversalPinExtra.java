package com.ss.android.lark.chat.entity.message;

import com.bytedance.lark.pb.im.v1.ChatPinInfo;
import com.bytedance.lark.pb.im.v1.UniversalChatPin;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0018B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/UniversalPinExtra;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "pinId", BuildConfig.FLAVOR, "pinChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", IPortraitService.TYPE, "Lcom/ss/android/lark/chat/entity/message/UniversalPinExtraType;", "<init>", "(Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;Lcom/ss/android/lark/chat/entity/message/UniversalPinExtraType;)V", "getPinId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPinChatter", "()Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "getType", "()Lcom/ss/android/lark/chat/entity/message/UniversalPinExtraType;", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "toString", BuildConfig.FLAVOR, "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UniversalPinExtra implements Serializable, b<UniversalPinExtra> {
    public static final a Companion = null;
    private final ChatChatter pinChatter;
    private final Long pinId;
    private final UniversalPinExtraType type;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.chat.entity.message.UniversalPinExtra$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0096a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[UniversalChatPin.Type.values().length];
                r0[UniversalChatPin.Type.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[UniversalChatPin.Type.URL_PIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[UniversalChatPin.Type.MESSAGE_PIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[UniversalChatPin.Type.ANNOUNCEMENT_PIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public a() {
        }

        public static UniversalPinExtra a(ChatPinInfo r2, String r3, com.ss.android.lark.chat.entity.chatter.a r4) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Intrinsics.checkNotNullParameter(r3, "chatId");
            Intrinsics.checkNotNullParameter(r4, "chatChatters");
            ChatChatter r5 = r4.b(r3, r2.chatter_id.toString());
            UniversalChatPin.Type r6 = r2.type;
            if (r6 != null) goto L5;
            int r7 = -1;
        L7:
            if (r7 != 1) goto L9;
        L17:
            return null;
        L9:
            if (r7 == 2) goto L17;
            if (r7 == 3) goto L20;
            if (r7 != 4) goto L17;
            return new AnnouncementUniversalPinExtra(r2.pin_id, r5);
        L20:
            return new MessageUniversalPinExtra(r2.message_id.longValue(), r2.pin_id, r5);
        L5:
            r7 = C0096a.a[r6.ordinal()];
            goto L7
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        return "pinChatter=" + this.pinChatter + ", pinId= " + this.pinId;
    }

    public final ChatChatter getPinChatter() {
        return this.pinChatter;
    }

    public final Long getPinId() {
        return this.pinId;
    }

    public final UniversalPinExtraType getType() {
        return this.type;
    }

    public boolean isContentSame(UniversalPinExtra r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        Class<?> r1 = getClass();
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(r1, r2) == true) goto L12;
        return false;
    L12:
        ChatChatter r3 = this.pinChatter;
        if (r3 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.pinId, r5.pinId) == true) goto L23;
        return false;
    L23:
        return true;
    L15:
        if (r3.isContentSame(r5.pinChatter) == true) goto L17;
        r4 = true;
        goto L18
    L8:
        r2 = null;
        goto L10
    }

    public boolean isItemSame(UniversalPinExtra r2) {
        Long r0 = this.pinId;
        if (r2 == null) goto L5;
        Long r3 = r2.pinId;
    L7:
        return Intrinsics.areEqual(r0, r3);
    L5:
        r3 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((UniversalPinExtra) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((UniversalPinExtra) r1);
    }

    public UniversalPinExtra(Long r2, ChatChatter r3, UniversalPinExtraType r4) {
        Intrinsics.checkNotNullParameter(r4, IPortraitService.TYPE);
        this.pinId = r2;
        this.pinChatter = r3;
        this.type = r4;
    }

    public /* synthetic */ UniversalPinExtra(Long r1, ChatChatter r2, UniversalPinExtraType r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = UniversalPinExtraType.UNKNOWN;
    L5:
        this(r1, r2, r3);
    }
}
