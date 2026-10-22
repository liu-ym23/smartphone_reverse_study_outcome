package com.ss.android.lark.integrator.flow.chat.forward;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.biz.im.api.extension.message.ContentListener;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ProfileContent;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardCommonConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardConfirmDialogConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardSelectConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.configuration.targetconfig.BotConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$ThreadType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.DisableConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.messageforward.SingleMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.SingleSource;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.feature.forward.doubao.u;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MessageForward {

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J.\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u001c\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/integrator/flow/chat/forward/MessageForward$MessageForwardOnForwardContentListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "forwardContent", "Lcom/ss/android/lark/forwardv3/messageforward/SingleMessageForwardContent;", "contentListener", "Lcom/ss/android/lark/biz/im/api/extension/message/ContentListener;", "<init>", "(Lcom/ss/android/lark/forwardv3/messageforward/SingleMessageForwardContent;Lcom/ss/android/lark/biz/im/api/extension/message/ContentListener;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "writeToParcel", "", "flags", "", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "errorTitle", "errorMessage", "describeContents", "CREATOR", "officesdk-im-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class MessageForwardOnForwardContentListener implements OnForwardContentListener {
        public static final a CREATOR = null;
        public final SingleMessageForwardContent a;
        public final ContentListener b;

        public static final class a implements Parcelable.Creator<MessageForwardOnForwardContentListener> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final MessageForwardOnForwardContentListener createFromParcel(Parcel r4) {
                Intrinsics.checkNotNullParameter(r4, "parcel");
                Intrinsics.checkNotNullParameter(r4, "parcel");
                SingleMessageForwardContent r0 = (SingleMessageForwardContent) r4.readParcelable(MessageForwardOnForwardContentListener.class.getClassLoader());
                ContentListener r5 = r4.readSerializable();
                if ((r5 instanceof ContentListener) == false) goto L5;
                ContentListener r6 = r5;
            L7:
                return new MessageForwardOnForwardContentListener(r0, r6);
            L5:
                r6 = null;
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final MessageForwardOnForwardContentListener[] newArray(int r1) {
                return new MessageForwardOnForwardContentListener[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
        public final void onFailed(String r3) {
            Log.e("MessageForward", "forward failed error title: null");
            ContentListener r0 = this.b;
            if (r0 == null) goto L6;
            r0.onFailed(null, r3);
            return;
        }

        public MessageForwardOnForwardContentListener(SingleMessageForwardContent r1, ContentListener r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            r2.writeParcelable(this.a, r3);
            r2.writeSerializable(this.b);
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
        public final boolean m(Activity r1, Map<String, ? extends ForwardTargetBaseInfoNew> r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "result");
            ContentListener r4 = this.b;
            if (r4 == null) goto L7;
            r4.onSuccess(r2);
            return true;
        L7:
            return true;
        }
    }

    static {
    }

    public MessageForward() {
    }

    public static void a(Context r6, int r7, Message r8, String r9, boolean r10, ContentListener r11) {
        String r0 = "";
        Intrinsics.checkNotNullParameter("", "favoriteId");
        StringBuilder r2 = new StringBuilder("start forward single message:\nfrom: ");
        SingleSource.Companion.getClass();
        switch(r7) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L6;
            case 12: goto L5;
            default: goto L17;
        };
    L5:
        String r3 = "IMAGE_DETAIL";
    L18:
        r2.append(r3);
        r2.append("\n messageId: ");
        if (r8 == null) goto L21;
        String r4 = r8.getId();
    L22:
        r2.append(r4);
        r2.append("\n messageType: ");
        if (r8 == null) goto L27;
        Message.Type r5 = r8.getType();
        if (r5 == null) goto L27;
        Integer r12 = Integer.valueOf(r5.getNumber());
    L28:
        r2.append(r12);
        r2.append("\nmessage is onTimeDel: ");
        if (r8 == null) goto L31;
        Boolean r13 = Boolean.valueOf(r8.isOnTimeDel());
    L32:
        r2.append(r13);
        Log.i("MessageForward", r2.toString());
        if (r6 == null) goto L55;
        if (r8 == null) goto L55;
        ForwardDataUtils.g(r8);
        SingleMessageForwardContent.a r14 = new SingleMessageForwardContent.a();
        r14.a = r7;
        if (r9 != null) goto L39;
        r9 = "";
    L39:
        Intrinsics.checkNotNullParameter(r9, "originMergeForwardId");
        r14.b = r9;
        Intrinsics.checkNotNullParameter("", "favoriteId");
        r14.c = "";
        r14.d = r10;
        SingleMessageForwardContent r15 = new SingleMessageForwardContent();
        r15.a = r14.a;
        String r16 = r14.b;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r15.b = r16;
        String r17 = r14.c;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r15.c = r17;
        r15.d = r14.d;
        ForwardCommonConfig.a r18 = new ForwardCommonConfig.a();
        if (r8.getType() == Message.Type.SHARE_CALENDAR_EVENT) goto L42;
        boolean r19 = true;
    L43:
        r18.b = r19;
        r18.f = new MessageForwardOnForwardContentListener(r15, r11);
        ForwardCommonConfig r20 = r18.a();
        IncludeConfig.a r110 = new IncludeConfig.a();
        EntityItem.a r111 = new EntityItem.a();
        r111.f(new UserConfig.a().a());
        r110.a(r111.c());
        EntityItem.a r112 = new EntityItem.a();
        r112.d(new GroupConfig.a().a());
        r110.a(r112.c());
        EntityItem.a r113 = new EntityItem.a();
        ThreadConfig.a r1 = new ThreadConfig.a();
        r1.b(Condition$ThreadType.MSG_THREAD);
        r113.e(r1.a());
        r110.a(r113.c());
        EntityItem.a r114 = new EntityItem.a();
        r114.b(new BotConfig());
        r110.a(r114.c());
        IncludeConfig r115 = r110.b();
        DisableConfig.a r116 = new DisableConfig.a();
        ForwardTargetConfig.a r21 = new ForwardTargetConfig.a();
        Intrinsics.checkNotNullParameter(r115, "includeConfig");
        r21.d = r115;
        DisableConfig r117 = r116.b();
        Intrinsics.checkNotNullParameter(r117, "disableConfig");
        r21.e = r117;
        r21.b = false;
        r21.c = true;
        ForwardTargetConfig r118 = r21.a();
        ForwardTemplateNew.a r119 = new ForwardTemplateNew.a();
        r119.g = 1;
        r119.f = r15;
        Intrinsics.checkNotNullParameter(r20, "forwardCommonConfig");
        r119.c = r20;
        Intrinsics.checkNotNullParameter(r118, "forwardTargetConfig");
        r119.a = r118;
        ForwardConfirmDialogConfig.a r22 = new ForwardConfirmDialogConfig.a();
        if (r8.getType() != Message.Type.SHARE_USER_CARD) goto L48;
        ProfileContent r23 = r8.getContent();
        if (r23 == null) goto L48;
        BasicDialogContentConfig.a r120 = new BasicDialogContentConfig.a();
        String r24 = r23.getDisplayName();
        if (r24 == null) goto L53;
        r0 = r24;
    L53:
        String r25 = d.j(2131892097, "user_name", r0);
        Intrinsics.checkNotNullParameter(r25, "content");
        r120.c = r25;
        Image r26 = new Image();
        r26.setKey(r23.getAvatarKey());
        r26.setToken(r23.getId());
        r120.f = 0;
        r120.g = null;
        r120.h = r26;
        r120.i = null;
        r120.k = !r8.isOnTimeDel();
        BasicDialogContentConfig r27 = r120.a();
    L54:
        r22.d = r27;
        ForwardConfirmDialogConfig r28 = r22.a();
        Intrinsics.checkNotNullParameter(r28, "forwardConfirmDialogConfig");
        r119.e = r28;
        ForwardSelectConfig.a r29 = new ForwardSelectConfig.a();
        r29.b = false;
        r29.a = false;
        ForwardSelectConfig r30 = r29.a();
        Intrinsics.checkNotNullParameter(r30, "forwardSelectConfig");
        r119.b = r30;
        u.a(r6, r119.a(), 0, null, 12);
        return;
    L48:
        r27 = null;
        goto L54
    L42:
        r19 = false;
    L55:
        Log.e("MessageForward", "context is null or message is null");
        return;
    L31:
        r13 = null;
    L27:
        r12 = null;
        goto L28
    L21:
        r4 = null;
        goto L22
    L6:
        r3 = "CUSTOM_STICKER_DETAIL";
        goto L18
    L7:
        r3 = "NORMAL_THREAD";
        goto L18
    L8:
        r3 = "MSG_THREAD";
        goto L18
    L9:
        r3 = "CHAT_THREAD";
        goto L18
    L10:
        r3 = "STICKER_DETAIL";
        goto L18
    L11:
        r3 = "LOCATION_DETAIL";
        goto L18
    L12:
        r3 = "FILE_DETAIL";
        goto L18
    L13:
        r3 = "FAVORITE";
        goto L18
    L14:
        r3 = "FLAG";
        goto L18
    L15:
        r3 = "PIN";
        goto L18
    L16:
        r3 = "NORMAL_CHAT";
        goto L18
    L17:
        r3 = "UNKNOWN";
        goto L18
    }
}
