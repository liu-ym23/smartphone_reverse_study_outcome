package com.ss.android.lark.integrator.flow.chat.forward;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.biz.im.api.extension.message.ContentListener;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.flow.forward.ForwardTools;
import com.ss.android.lark.forwardv3.configuration.ForwardCommonConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardSelectConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.configuration.targetconfig.BotConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$ThreadType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.messageforward.MergeMessageForwardContent;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.mergeforward.a;
import com.suite.lark.platform.feature.forward.doubao.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MergeForward {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ.\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/integrator/flow/chat/forward/MergeForward$MergeForwardOnForwardContentListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "contentListener", "Lcom/ss/android/lark/biz/im/api/extension/message/ContentListener;", "<init>", "(Lcom/ss/android/lark/biz/im/api/extension/message/ContentListener;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "onSuccess", "", "activity", "Landroid/app/Activity;", "result", "", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "allowToast", "onFailed", "", "errorTitle", "errorMessage", "writeToParcel", "flags", "", "describeContents", "CREATOR", "officesdk-im-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class MergeForwardOnForwardContentListener implements OnForwardContentListener {
        public static final a CREATOR = null;
        public final ContentListener a;

        public static final class a implements Parcelable.Creator<MergeForwardOnForwardContentListener> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final MergeForwardOnForwardContentListener createFromParcel(Parcel r3) {
                Intrinsics.checkNotNullParameter(r3, "parcel");
                Intrinsics.checkNotNullParameter(r3, "parcel");
                ContentListener r4 = r3.readSerializable();
                if ((r4 instanceof ContentListener) == false) goto L5;
                ContentListener r5 = r4;
            L7:
                return new MergeForwardOnForwardContentListener(r5);
            L5:
                r5 = null;
                goto L7
            }

            @Override // android.os.Parcelable.Creator
            public final MergeForwardOnForwardContentListener[] newArray(int r1) {
                return new MergeForwardOnForwardContentListener[r1];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public MergeForwardOnForwardContentListener(ContentListener r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
        public final void onFailed(String r3) {
            ContentListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onFailed(null, r3);
            return;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            r1.writeSerializable(this.a);
        }

        @Override // com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener
        public final boolean m(Activity r1, Map<String, ? extends ForwardTargetBaseInfoNew> r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "result");
            ContentListener r4 = this.a;
            if (r4 == null) goto L7;
            r4.onSuccess(r2);
            return true;
        L7:
            return true;
        }
    }

    static {
    }

    public MergeForward() {
    }

    public static IncludeConfig a() {
        IncludeConfig.a r0 = new IncludeConfig.a();
        EntityItem.a r1 = new EntityItem.a();
        r1.f(new UserConfig.a().a());
        r0.a(r1.c());
        EntityItem.a r2 = new EntityItem.a();
        r2.d(new GroupConfig.a().a());
        r0.a(r2.c());
        EntityItem.a r3 = new EntityItem.a();
        ThreadConfig.a r4 = new ThreadConfig.a();
        r4.b(Condition$ThreadType.MSG_THREAD);
        r3.e(r4.a());
        r0.a(r3.c());
        EntityItem.a r5 = new EntityItem.a();
        r5.b(new BotConfig());
        r0.a(r5.c());
        return r0.b();
    }

    public static void b(Context r7, Chat r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "threadId");
        Intrinsics.checkNotNullParameter(r10, "threadOwnerChatterId");
        if (r7 == null) goto L16;
        if (r8 == null) goto L17;
        MergeForwardContent r1 = new MergeForwardContent();
        r1.setType(r8.getType());
        r1.setFromPrivateTopic(true);
        r1.setReplyInThread(true);
        r1.setThreadId(r9);
        ChatChatter r11 = ImSdkService.d().H5(r8.getId(), r10);
        ChatterNameDisplayRule r3 = ChatterNameDisplayRule.ALIAS_NICKNAME_NAME;
        r1.setThreadOwnerDisplayName(ForwardTools.a(r11, r3));
        if (r8.getType() != Chat.Type.P2P) goto L13;
        r1.setP2pCreatorName(m.b(ImSdkService.d().zb(), r3, false));
        if (TextUtils.equals(ChatCoreModule.a().getPassportDependency().userId(), r8.getP2pChatterId()) == false) goto L11;
        String r12 = "";
    L12:
        r1.setP2pPartnerName(r12);
    L14:
        Message r13 = new Message();
        r13.setChatId(r8.getId());
        r13.setType(Message.Type.MERGE_FORWARD);
        r13.setMessageContent(r1);
        r13.setOnTimeDel(false);
        MergeMessageForwardContent.a r4 = new MergeMessageForwardContent.a();
        r4.a = 6;
        Intrinsics.checkNotNullParameter("", "originMergeForwardId");
        r4.b = "";
        String r2 = a.a(r1);
        Intrinsics.checkNotNullParameter(r2, "quasiTitle");
        r4.d = r2;
        r4.e = true;
        Intrinsics.checkNotNullParameter(r9, "threadId");
        r4.f = r9;
        String r14 = r8.getId();
        Intrinsics.checkNotNullParameter(r14, "chatId");
        r4.g = r14;
        MergeMessageForwardContent r15 = r4.a();
        ForwardDataUtils.g(r13);
        ForwardTemplateNew.a r16 = new ForwardTemplateNew.a();
        r16.g = 1;
        r16.f = r15;
        ForwardCommonConfig.a r17 = new ForwardCommonConfig.a();
        r17.f = new MergeForwardOnForwardContentListener(null);
        ForwardCommonConfig r18 = r17.a();
        Intrinsics.checkNotNullParameter(r18, "forwardCommonConfig");
        r16.c = r18;
        ForwardSelectConfig.a r19 = new ForwardSelectConfig.a();
        r19.b = false;
        r19.a = false;
        ForwardSelectConfig r20 = r19.a();
        Intrinsics.checkNotNullParameter(r20, "forwardSelectConfig");
        r16.b = r20;
        ForwardTemplateNew r21 = r16.a();
        r21.setType(1);
        ForwardTargetConfig r22 = r21.getForwardTargetConfig();
        r22.d = a();
        r21.getForwardTargetConfig().c = true;
        u.a(r7, r21, -1, null, 8);
        return;
    L11:
        r12 = ForwardTools.a(ImSdkService.d().l7(r8.getP2pChatterId()), r3);
        goto L12
    L13:
        r1.setGroupChatName(r8.getName());
        goto L14
    L17:
        return;
    }

    public static void c(Context r8, Chat r9, ArrayList r10, int r11, ContentListener r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "chat");
        Intrinsics.checkNotNullParameter(r10, "messageIds");
        Map<String, Message> r1 = ImSdkService.f().ta(r10);
        ArrayList r2 = new ArrayList(r1.size());
        Iterator<Map.Entry<String, Message>> r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(r3.next().getValue());
        goto L4
    L6:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        Object r6 = r5.next();
        if (((Message) r6).isOnTimeDel() == false) goto L8;
        r4.add(r6);
        goto L8
    L12:
        MergeForwardContent r7 = new MergeForwardContent();
        r7.setType(r9.getType());
        r7.setFromPrivateTopic(false);
        r7.setMessages(r2);
        if (r9.getType() != Chat.Type.P2P) goto L19;
        Chatter r13 = ImSdkService.d().zb();
        ChatterNameDisplayRule r14 = ChatterNameDisplayRule.ALIAS_NICKNAME_NAME;
        r7.setP2pCreatorName(m.b(r13, r14, false));
        if (TextUtils.equals(ChatCoreModule.a().getPassportDependency().userId(), r9.getP2pChatterId()) == false) goto L17;
        String r15 = "";
    L18:
        r7.setP2pPartnerName(r15);
    L20:
        Message r16 = new Message();
        r16.setChatId(r9.getId());
        r16.setType(Message.Type.MERGE_FORWARD);
        r16.setOnTimeDel(!CollectionUtils.isEmpty(r4));
        r16.setMessageContent(r7);
        MergeMessageForwardContent.a r17 = new MergeMessageForwardContent.a();
        Intrinsics.checkNotNullParameter(r10, "messageIds");
        r17.c = r10;
        Intrinsics.checkNotNullParameter("", "originMergeForwardId");
        r17.b = "";
        r17.e = false;
        String r18 = r9.getId();
        Intrinsics.checkNotNullParameter(r18, "chatId");
        r17.g = r18;
        String r19 = a.a(r7);
        Intrinsics.checkNotNullParameter(r19, "quasiTitle");
        r17.d = r19;
        MergeMessageForwardContent r20 = r17.a();
        ForwardDataUtils.g(r16);
        ForwardTemplateNew.a r110 = new ForwardTemplateNew.a();
        r110.g = 1;
        r110.f = r20;
        ForwardCommonConfig.a r21 = new ForwardCommonConfig.a();
        r21.f = new MergeForwardOnForwardContentListener(r12);
        ForwardCommonConfig r22 = r21.a();
        Intrinsics.checkNotNullParameter(r22, "forwardCommonConfig");
        r110.c = r22;
        ForwardSelectConfig.a r23 = new ForwardSelectConfig.a();
        r23.b = false;
        r23.a = false;
        ForwardSelectConfig r24 = r23.a();
        Intrinsics.checkNotNullParameter(r24, "forwardSelectConfig");
        r110.b = r24;
        ForwardTemplateNew r25 = r110.a();
        r25.setType(3);
        r25.getForwardTargetConfig().d = a();
        r25.getForwardTargetConfig().c = true;
        u.a(r8, r25, r11, null, 8);
        return;
    L17:
        r15 = ForwardTools.a(ImSdkService.d().l7(r9.getP2pChatterId()), r14);
        goto L18
    L19:
        r7.setGroupChatName(r9.getName());
        goto L20
    }
}
