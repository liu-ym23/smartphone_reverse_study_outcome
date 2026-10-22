package com.ss.android.lark.integrator.flow.chat.forward;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.extension.message.ContentListener;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.flow.chat.multi_select.ContentListenerImpl;
import com.ss.android.lark.forwardv3.configuration.ForwardCommonConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardSelectConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.configuration.targetconfig.BotConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$GroupType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$ThreadType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.DisableConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.messageforward.OneByOneMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.OneByOneSource;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.feature.forward.doubao.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OneByOneForward {

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J.\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u001c\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/integrator/flow/chat/forward/OneByOneForward$OneByOneForwardOnForwardContentListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "forwardContent", "Lcom/ss/android/lark/forwardv3/messageforward/OneByOneMessageForwardContent;", "contentListener", "Lcom/ss/android/lark/biz/im/api/extension/message/ContentListener;", "<init>", "(Lcom/ss/android/lark/forwardv3/messageforward/OneByOneMessageForwardContent;Lcom/ss/android/lark/biz/im/api/extension/message/ContentListener;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "writeToParcel", "", "flags", "", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "errorTitle", "errorMessage", "describeContents", "CREATOR", "officesdk-im-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class OneByOneForwardOnForwardContentListener implements OnForwardContentListener {
        public static final a CREATOR = null;
        public final OneByOneMessageForwardContent a;
        public final ContentListener b;

        public static final class a implements Parcelable.Creator<OneByOneForwardOnForwardContentListener> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final OneByOneForwardOnForwardContentListener createFromParcel(Parcel r4) {
                Intrinsics.checkNotNullParameter(r4, "parcel");
                Intrinsics.checkNotNullParameter(r4, "parcel");
                OneByOneMessageForwardContent r0 = (OneByOneMessageForwardContent) r4.readParcelable(OneByOneForwardOnForwardContentListener.class.getClassLoader());
                ContentListener r5 = r4.readSerializable();
                if ((r5 instanceof ContentListener) == false) goto L5;
                ContentListener r6 = r5;
            L7:
                return new OneByOneForwardOnForwardContentListener(r0, r6);
            L5:
                r6 = null;
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final OneByOneForwardOnForwardContentListener[] newArray(int r1) {
                return new OneByOneForwardOnForwardContentListener[r1];
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
            Log.e("OneByOneForward", "forward failed error title: null");
            ContentListener r0 = this.b;
            if (r0 == null) goto L6;
            r0.onFailed(null, r3);
            return;
        }

        public OneByOneForwardOnForwardContentListener(OneByOneMessageForwardContent r1, ContentListener r2) {
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

    public static void a(Context r9, Chat r10, ArrayList r11, ContentListenerImpl r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "chat");
        Intrinsics.checkNotNullParameter(r11, "messageIds");
        Intrinsics.checkNotNullParameter("", "originMergeForwardId");
        StringBuilder r3 = new StringBuilder("start forward one by one message:\nfrom: ");
        OneByOneSource.Companion.getClass();
        r3.append("UNKNOWN");
        r3.append('\n');
        String r4 = r3.toString();
        Iterator r5 = r11.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r4 = r4 + "messageId: " + ((String) r5.next());
        goto L4
    L6:
        Log.i("OneByOneForward", r4);
        Map<String, Message> r6 = ImSdkService.f().ta(r11);
        ArrayList r7 = new ArrayList(r6.size());
        Iterator<Map.Entry<String, Message>> r8 = r6.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        r7.add(r8.next().getValue());
        goto L8
    L10:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r7.iterator();
    L12:
        if (r14.hasNext() == false) goto L16;
        Object r15 = r14.next();
        if (((Message) r15).isOnTimeDel() == false) goto L12;
        r13.add(r15);
        goto L12
    L16:
        MergeForwardContent r16 = new MergeForwardContent();
        r16.setType(r10.getType());
        r16.setFromPrivateTopic(false);
        r16.setMessages(r7);
        if (r10.getType() == Chat.Type.P2P) goto L19;
        r16.setGroupChatName(r10.getName());
    L19:
        Message r17 = new Message();
        r17.setChatId(r10.getId());
        r17.setType(Message.Type.MERGE_FORWARD);
        r17.setOnTimeDel(!CollectionUtils.isEmpty(r13));
        r17.setMessageContent(r16);
        ForwardDataUtils.g(r17);
        OneByOneMessageForwardContent.a r18 = new OneByOneMessageForwardContent.a();
        r18.a = 0;
        Intrinsics.checkNotNullParameter("", "originMergeForwardId");
        r18.b = "";
        Intrinsics.checkNotNullParameter(r11, "messageIds");
        r18.c = r11;
        String r19 = r10.getId();
        Intrinsics.checkNotNullParameter(r19, "chatId");
        r18.d = r19;
        OneByOneMessageForwardContent r110 = new OneByOneMessageForwardContent();
        r110.a = r18.a;
        String r111 = r18.b;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r110.b = r111;
        ArrayList<String> r112 = r18.c;
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r110.c = r112;
        String r113 = r18.d;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r110.d = r113;
        IncludeConfig.a r114 = new IncludeConfig.a();
        EntityItem.a r0 = new EntityItem.a();
        r0.f(new UserConfig.a().a());
        r114.a(r0.c());
        EntityItem.a r1 = new EntityItem.a();
        r1.d(new GroupConfig.a().a());
        r114.a(r1.c());
        EntityItem.a r2 = new EntityItem.a();
        ThreadConfig.a r20 = new ThreadConfig.a();
        r20.b(Condition$ThreadType.MSG_THREAD);
        r2.e(r20.a());
        r114.a(r2.c());
        EntityItem.a r21 = new EntityItem.a();
        r21.b(new BotConfig());
        r114.a(r21.c());
        IncludeConfig r115 = r114.b();
        DisableConfig.a r22 = new DisableConfig.a();
        EntityItem.a r23 = new EntityItem.a();
        GroupConfig.a r24 = new GroupConfig.a();
        Condition$GroupType r25 = Condition$GroupType.THREAD;
        Intrinsics.checkNotNullParameter(r25, "groupType");
        r24.b = r25;
        r23.d(r24.a());
        r22.a(r23.c());
        EntityItem.a r26 = new EntityItem.a();
        r26.e(new ThreadConfig.a().a());
        r22.a(r26.c());
        DisableConfig r27 = r22.b();
        ForwardCommonConfig.a r28 = new ForwardCommonConfig.a();
        r28.f = new OneByOneForwardOnForwardContentListener(r110, r12);
        ForwardCommonConfig r116 = r28.a();
        ForwardTargetConfig.a r29 = new ForwardTargetConfig.a();
        Intrinsics.checkNotNullParameter(r115, "includeConfig");
        r29.d = r115;
        Intrinsics.checkNotNullParameter(r27, "disableConfig");
        r29.e = r27;
        r29.c = true;
        ForwardTargetConfig r117 = r29.a();
        Log.i("OneByOneForward", "message is onTimeDel: " + r17.isOnTimeDel());
        ForwardTemplateNew.a r30 = new ForwardTemplateNew.a();
        r30.g = 1;
        r30.f = r110;
        Intrinsics.checkNotNullParameter(r116, "forwardCommonConfig");
        r30.c = r116;
        Intrinsics.checkNotNullParameter(r117, "forwardTargetConfig");
        r30.a = r117;
        ForwardSelectConfig.a r118 = new ForwardSelectConfig.a();
        r118.b = false;
        r118.a = false;
        ForwardSelectConfig r119 = r118.a();
        Intrinsics.checkNotNullParameter(r119, "forwardSelectConfig");
        r30.b = r119;
        u.a(r9, r30.a(), 9, null, 8);
    }
}
