package com.obric.assistant.component;

import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.MultiAttachmentInfo;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.cell.slot.MessageInBoxBottomExtWidgetSlotCell;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.common.apphost.AppHost;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.platform.IFlowMessageService;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.actionbar.service.IObricActionBarSendServiceExt;
import com.obric.assistant.actionbar.service.ObricActionBarTrackServiceExtDelegate;
import com.obric.assistant.network.api.bean.ObricOmniModel;
import com.obric.assistant.network.api.bean.ObricOmniModelConfig;
import com.obric.assistant.special_input.IObricSpecialInputService;
import com.obric.assistant.special_input.ObricComplexTaskPanelType;
import com.obric.assistant.spi.actionbar.ObricMessageBottomExtActionType;
import com.obric.assistant.task.IObricTaskStatusManager;
import com.obric.assistant.task.ObricOmniModelItem;
import com.obric.assistant.task.skill.ObricOmniModelConfigManager;
import com.obric.assistant.util.r2;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 _2\u00020\u0001:\u0001_B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016J<\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u001e\u0010\u0018\u001a\u00020\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0002J!\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010 J\u001c\u0010!\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020\u000bH\u0016J&\u0010$\u001a\u0004\u0018\u00010\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020\u000bH\u0016J(\u0010'\u001a\u00020\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00132\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J,\u0010*\u001a\u00020\u0010*\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00132\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\n\u0010/\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000bH\u0002J\b\u00102\u001a\u00020\u000bH\u0002J\b\u00103\u001a\u00020\u000bH\u0002J\u0012\u00104\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J2\u00105\u001a\u00020\u00102\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016J%\u00108\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001aH\u0016¢\u0006\u0002\u00109J\u0012\u0010:\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010;\u001a\u00020\u0005H\u0002J\u0010\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\tH\u0016J\b\u0010>\u001a\u00020\u0010H\u0016J\u001c\u0010?\u001a\u0004\u0018\u00010\u000b2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\"\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020A2\b\u0010F\u001a\u0004\u0018\u00010\u00162\u0006\u0010G\u001a\u00020HH\u0016J\u001e\u0010I\u001a\u00020\u00102\u0006\u0010B\u001a\u00020A2\u0006\u0010E\u001a\u00020AH\u0082@¢\u0006\u0002\u0010JJ\n\u0010K\u001a\u0004\u0018\u00010LH\u0002J\u0010\u0010P\u001a\u00020\u00102\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010Q\u001a\u00020\u00102\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010R\u001a\u00020\u00102\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010S\u001a\u00020\u0005H\u0016J\u0010\u0010T\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\u0005H\u0016J\u0012\u0010V\u001a\u00020\u00052\b\u0010W\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010X\u001a\u00020\u00052\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\u0010\u0010[\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u0016H\u0016J\u0018\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010^H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/obric/assistant/component/ObricActionBarSendServiceImpl;", "Lcom/obric/assistant/actionbar/service/IObricActionBarSendServiceExt;", "<init>", "()V", "isVariantInputOpen", "", "()Ljava/lang/Boolean;", "orionActionBarCallBack", "Ljava/lang/ref/WeakReference;", "Lcom/obric/assistant/chat/callback/IOrionCustomActionBarCallback;", "suggestSelector", "", "prefixFormat", "omniTaskExtParams", "", "resetSuggestSelector", "", "replaceContentOnSend", "extra", "", "content", "onSendParams", "", "sendScene", "updateMessageExtOnSendAudioMessage", "createPhoneOperationMessageExt", "", "checkJumpAddMsgExt", "onSuggestSelectorClick", "itemStatus", "", "displayText", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getObricUserInputWithFormat", "replyFormat", "userInput", "getObricEffectiveActionBarInput", "actionBarKey", "sourceInputContent", "addMessageExt", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "addComplexExt", "currentStateInfo", "Lcom/obric/aiagent/assistant/idl/bean/StateInfo;", "relatedTask", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "getTaskModeMessageExtra", "needActionBarInstructionConf", "enterMethod", "getOAutoSuggestPrefix", "getOAutoHintText", "getContentPrefix", "setSendAudioMessageExt", "fromExt", "toExt", "isSameScene", "(Ljava/util/Map;)Ljava/lang/Boolean;", "isAssistantActionBar", "isReplyScene", "registerActionBarHintChangedCallback", "obricCustomActionBarCallback", "unregisterActionBarHintChangedCallback", "modifyContent", "message", "Lcom/larus/im/bean/message/Message;", "originMessage", "Ljava/util/concurrent/atomic/AtomicReference;", "reSendMessage", "replyMessage", "chatMessageAbility", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "finalResendMessage", "(Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSpecialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "oautoConfirmCardMsg", "oautoConfirmTextMsg", "oautoTaskCardMessage", "setConfirmMessage", "setConfirmTextMessage", "setTaskCardMessage", "isRestrictInstructionInputHeight", "setRestrictInstructionInputHeight", "isRestrict", "isAudioMessage", "messageId", "isPhoneOperationSwitch", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "isActionBarShowInFront", "segment", "getPhoneOperationMenuConfig", "Lkotlin/Pair;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActionBarSendServiceImpl implements IObricActionBarSendServiceExt {
    public static final String j = null;
    public static final String k = null;
    public static final String l = null;
    public static final String m = null;
    public WeakReference<bda.a> a;
    public String b;
    public String c;
    public final Set<String> d;
    public final AtomicReference<Message> e;
    public final AtomicReference<Message> f;
    public final AtomicReference<Message> g;
    public final AtomicReference<Message> h;
    public boolean i;

    public static final class a {
    }

    public final String m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        return null;
    }

    public final Map<String, String> v() {
        boolean r0 = true;
        Map<String, String> r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("o_instruction_entry", "action_bar_option")});
        IObricTaskStatusManager r2 = (IObricTaskStatusManager) ServiceManager.get().getService(IObricTaskStatusManager.class);
        if (r2 != null) goto L5;
    L7:
        r0 = false;
    L8:
        if (r0 == false) goto L10;
        String r3 = "1";
    L11:
        r1.put("o_is_client_authenticated", r3);
        y(r1, null, null);
        return r1;
    L10:
        r3 = "0";
        goto L11
    L5:
        if (r2.a() != true) goto L7;
        goto L7
    }

    static {
        AppHost.Companion r0 = AppHost.a;
        j = r0.getApplication().getString(2131911919);
        k = r0.getApplication().getString(2131911904);
        l = r0.getApplication().getString(2131911911);
        m = r0.getApplication().getString(2131911908);
    }

    public final void h() {
        FLogger.a.i("ObricActionBarSendServiceImpl", "unregisterActionBarHintChangedCallback");
        this.a = null;
    }

    public final void q() {
        this.b = m;
    }

    public ObricActionBarSendServiceImpl() {
        this.b = m;
        Set r0 = SetsKt.setOf(new String[]{"o_omni_intention", "o_omni_task_id", "o_is_omni_agent", "o_omni_instruction_type", "o_instruction_entry", "o_task_type", "o_task_state", "mcp_message_type", "o_reference_msg_id", "o_not_interrupt", "o_complex_source_type", "o_is_client_authenticated", "is_from_obric_action_bar", "o_auto_mic"});
        AtomicBoolean r1 = com.obric.assistant.task.skill.m.a;
        this.d = SetsKt.plus(r0, SetsKt.setOf("o_complex_task_model"));
        this.e = new AtomicReference(null);
        this.f = new AtomicReference(null);
        this.g = new AtomicReference(null);
        this.h = new AtomicReference(null);
    }

    public static laa.j A() {
        t1a.b r0 = r2.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAbility(laa.j.class);
    }

    public static Boolean B() {
        laa.j r0 = A();
        if (r0 == null) goto L7;
        kotlinx.coroutines.flow.b1 r1 = r0.O4();
        if (r1 == null) goto L7;
        return (Boolean) r1.getValue();
    L7:
        return null;
    }

    public static boolean z() {
        if (Intrinsics.areEqual(B(), Boolean.TRUE) == false) goto L5;
    L7:
        return false;
    L5:
        if (com.obric.assistant.task.skill.f.d() == true) goto L7;
        return true;
    }

    public final Pair<String, String> f() {
        String r0 = FlowRuntime.a().getApplication().getString(2131911923);
        StringBuilder r1 = new StringBuilder("res://");
        gd9.i r2 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r2);
        r1.append(r2.getApplication().getPackageName());
        r1.append("/2131244375");
        return TuplesKt.to(r0, com.larus.utils.y0.k(UriProtector.parse(r1.toString())));
    }

    public final boolean p() {
        return this.i;
    }

    public final boolean a(String r4) {
        if (Intrinsics.areEqual(r4, "obric_oauto") == false) goto L5;
    L26:
        return true;
    L5:
        if (Intrinsics.areEqual(r4, "obric_mock_click") == true) goto L26;
        if (Intrinsics.areEqual(r4, "obric_omni") == true) goto L26;
        if (Intrinsics.areEqual(r4, "obric_web_perception") == true) goto L26;
        if (Intrinsics.areEqual(r4, "obric_video_perception") == true) goto L26;
        if (Intrinsics.areEqual(r4, "obric_screen_qa") == true) goto L26;
        if (Intrinsics.areEqual(r4, "obric_document_perception") == true) goto L26;
        if (Intrinsics.areEqual(r4, "obric_im_perception") == true) goto L26;
        if (Intrinsics.areEqual(r4, "obric_photo_perception") == true) goto L26;
        AppHost.Companion r0 = AppHost.a;
        if (Intrinsics.areEqual(r4, r0.getApplication().getString(2131911893)) == true) goto L26;
        if (Intrinsics.areEqual(r4, r0.getApplication().getString(2131911902)) == true) goto L26;
        return false;
    }

    public final boolean b(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "segment");
        if ((r2 instanceof qha.e) == false) goto L5;
        qha.e r3 = (qha.e) r2;
    L7:
        if (r3 != null) goto L9;
        return true;
    L9:
        return true ^ (r3 instanceof qha.j);
    L5:
        r3 = null;
        goto L7
    }

    public final Boolean g(Map<String, String> r2) {
        String r3 = r2.get("enter_method_trace");
        if (r3 == null) goto L8;
        ObricActionBarTrackType.Companion.getClass();
        if (ObricActionBarTrackType.a.b().contains(r3) == true) goto L7;
        return null;
    L7:
        return Boolean.TRUE;
    L8:
        return null;
    }

    public final boolean isAudioMessage(String r5) {
        if (r5 == null) goto L32;
        t1a.b r0 = r2.a();
        String r1 = null;
        if (r0 == null) goto L8;
        u7 r2 = r0.getAbility(u7.class);
        if (r2 == null) goto L8;
        MessageAdapter r3 = r2.MF();
    L10:
        if ((r3 instanceof com.larus.bmhome.chat.adapter.i) == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L31;
        List r4 = r3.getMessageList();
        if (r4 == null) goto L31;
        Iterator r6 = r4.iterator();
    L18:
        if (r6.hasNext() == false) goto L22;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(r5, ((ic8.v) r7).a().getMessageId()) == false) goto L18;
    L23:
        ic8.v r8 = (ic8.v) r7;
        if (r8 == null) goto L31;
        Message r9 = r8.a();
        if (r9 == null) goto L31;
        Map r10 = r9.getExt();
        if (r10 == null) goto L31;
        r1 = (String) r10.get("o_is_audio_message");
        goto L31
    L22:
        r7 = null;
    L31:
        return Intrinsics.areEqual(r1, "1");
    L8:
        r3 = null;
        goto L10
    L32:
        return false;
    }

    public final void j(bda.a r4) {
        Intrinsics.checkNotNullParameter(r4, "obricCustomActionBarCallback");
        FLogger.a.i("ObricActionBarSendServiceImpl", "registerActionBarHintChangedCallback");
        this.a = new WeakReference(r4);
    }

    public final void k(boolean r4) {
        FLogger.a.i("ObricActionBarSendServiceImpl", "setRestrictInstructionInputHeight, isRestrict = " + r4);
        this.i = r4;
    }

    public final void l(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.f.set(r2);
    }

    public final void o(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.h.set(r2);
    }

    public final void r(Map<String, String> r3) {
        if (z() == false) goto L6;
        FLogger.a.e("ObricActionBarSendServiceImpl", "special input is not open");
        return;
    L6:
        i(r3, null);
    }

    public final void t(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Map r0 = r3.getExt();
        if (r0 != null) goto L5;
    L7:
        Map r1 = r3.getExt();
        if (r1 == null) goto L18;
        String r2 = (String) r1.get("follow_up_flag");
        if (r2 != null) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r2, "GUIConfirmV2") == true) goto L15;
        r2 = null;
    L15:
        if (r2 == null) goto L20;
        this.f.set(r3);
        return;
    L20:
        return;
    L18:
        return;
    L5:
        if (((String) r0.get("is_obric_oauto_user_confirm")) == null) goto L7;
        this.g.set(r3);
        goto L7
    }

    public final boolean u(ReplyOption r1) {
        return com.obric.assistant.task.skill.n.b(r1);
    }

    public final void d(Map<String, String> r8, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r9, "toExt");
        if (r8 == null) goto L5;
        String r0 = r8.get("action_bar_key");
    L7:
        if (Intrinsics.areEqual(r0, "obric_web_perception") == false) goto L9;
    L34:
        FLogger.a.i("ObricActionBarSendServiceImpl", "setSendAudioMessageExt: is from obric action bar " + r0);
        r9.put("is_from_obric_action_bar", r0);
        return;
    L9:
        if (Intrinsics.areEqual(r0, "obric_video_perception") == true) goto L34;
        if (r8 != null) goto L13;
    L16:
        boolean r1 = true;
    L17:
        if (r1 == true) goto L31;
        Iterator<T> r2 = this.d.iterator();
    L20:
        if (r2.hasNext() == false) goto L32;
        String r3 = (String) r2.next();
        if (r8.containsKey(r3) == false) goto L20;
        String r4 = r8.get(r3);
        String r5 = "";
        if (r4 != null) goto L26;
        r4 = "";
    L26:
        r9.put(r3, r4);
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("setSendAudioMessageExt: add ");
        r7.append(r3);
        r7.append(" = ");
        String r10 = r8.get(r3);
        if (r10 == null) goto L30;
        r5 = r10;
    L30:
        r7.append(r5);
        r6.i("ObricActionBarSendServiceImpl", r7.toString());
    L32:
        r9.put("o_is_audio_message", "1");
        return;
    L31:
        FLogger.a.i("ObricActionBarSendServiceImpl", "setSendAudioMessageExt: fromExt is null or empty");
        goto L32
    L13:
        if (r8.isEmpty() == true) goto L16;
        r1 = false;
        goto L17
    L5:
        r0 = null;
        goto L7
    }

    public final void i(Map<String, String> r9, wc9.e r10) {
        String r1 = null;
        if (r10 != null) goto L5;
        t1a.b r11 = r2.a();
        if (r11 == null) goto L12;
        com.larus.bmhome.chat.component.cvs.y r12 = r11.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r12 == null) goto L12;
        wc9.e r13 = r12.h();
    L13:
        if (r13 != null) goto L15;
    L18:
        boolean r2 = false;
        if (Intrinsics.areEqual(B(), Boolean.TRUE) == false) goto L21;
    L23:
        boolean r14 = false;
    L24:
        if (r14 == true) goto L33;
        laa.j r4 = A();
        if (r4 == null) goto L33;
        kotlinx.coroutines.flow.b1 r5 = r4.i80();
        if (r5 == null) goto L33;
        laa.v r6 = (laa.v) r5.getValue();
        if (r6 == null) goto L33;
        StateInfo r7 = r6.b;
    L34:
        if (r14 == true) goto L43;
        laa.j r15 = A();
        if (r15 == null) goto L43;
        kotlinx.coroutines.flow.b1 r16 = r15.i80();
        if (r16 == null) goto L43;
        laa.v r17 = (laa.v) r16.getValue();
        if (r17 == null) goto L43;
        DMTaskState r18 = r17.a;
    L44:
        FLogger r8 = FLogger.a;
        StringBuilder r19 = new StringBuilder("addMessageExt: isVariantInputOpen = ");
        r19.append(B());
        r19.append(", currentStateInfo = ");
        if (r7 == null) goto L47;
        String r20 = com.obric.assistant.utils.m.b(r7);
    L48:
        r19.append(r20);
        r19.append(", relatedTask = ");
        if (r18 == null) goto L51;
        r1 = com.obric.assistant.utils.l.g(r18);
    L51:
        r19.append(r1);
        r8.i("ObricActionBarSendServiceImpl", r19.toString());
        if (r9 != null) goto L56;
        r8.w("ObricActionBarSendServiceImpl", "addMessageExt: extra is null");
        return;
    L56:
        if (z() == true) goto L72;
        IObricTaskStatusManager r3 = (IObricTaskStatusManager) ServiceManager.get().getService(IObricTaskStatusManager.class);
        if (r3 != null) goto L60;
    L62:
        if (r2 == false) goto L64;
        String r21 = "1";
    L65:
        r9.put("o_is_client_authenticated", r21);
        y(r9, r7, r18);
        r9.remove("action_bar_instruction");
        r9.remove("action_bar_instruction_type");
        Iterator<T> r110 = this.d.iterator();
    L67:
        if (r110.hasNext() == false) goto L76;
        String r22 = (String) r110.next();
        FLogger r23 = FLogger.a;
        StringBuilder r24 = new StringBuilder("result ");
        r24.append(r22);
        r24.append(" = ");
        String r25 = r9.get(r22);
        if (r25 != null) goto L71;
        r25 = "";
    L71:
        r24.append(r25);
        r23.i("ObricActionBarSendServiceImpl", r24.toString());
        goto L67
    L76:
        return;
    L64:
        r21 = "0";
        goto L65
    L60:
        if (r3.a() != true) goto L62;
        r2 = true;
        goto L62
    L72:
        return;
    L47:
        r20 = null;
    L43:
        r18 = null;
    L33:
        r7 = null;
        goto L34
    L21:
        if (com.obric.assistant.task.skill.f.d() == false) goto L23;
        r14 = true;
        goto L24
    L15:
        if (com.larus.bmhome.utils.i.h(r13) == true) goto L18;
        FLogger.a.i("ObricActionBarSendServiceImpl", "addMessageExt: conversation is not main bot except coco sub");
        return;
    L12:
        r13 = null;
        goto L13
    L5:
        if (com.larus.bmhome.utils.i.h(r10) == true) goto L18;
    }

    public final String n(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "userInput");
        FLogger.a.i("ObricActionBarSendServiceImpl", "getObricUserInputWithFormat, replyFormat = " + r5 + ", userInput.len = " + r6.length());
        if (Intrinsics.areEqual(this.b, l) == false) goto L5;
        String r0 = AppHost.a.getApplication().getString(2131911912);
        Intrinsics.checkNotNull(r0);
    L6:
        this.c = r0;
        this.b = m;
        if (r5 != null) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(r5, "obric_oauto") == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L23;
        String r7 = this.c;
        if (r7 == null) goto L17;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        String r8 = String.format(r7, Arrays.copyOf(new Object[]{r6}, 1));
        if (r8 == null) goto L17;
    L18:
        if (r8 != null) goto L21;
        return null;
    L21:
        return r8;
    L17:
        r8 = null;
        goto L18
    L23:
        return null;
    L5:
        r0 = AppHost.a.getApplication().getString(2131911909);
        Intrinsics.checkNotNull(r0);
        goto L6
    }

    public final void s(Integer r4, String r5) {
        String r0 = l;
        if (Intrinsics.areEqual(r5, r0) == true) goto L7;
        if (Intrinsics.areEqual(r5, AppHost.a.getApplication().getString(2131911907)) == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r5, r0) == false) goto L23;
        if (r4 != null) goto L11;
    L13:
        r5 = m;
    L14:
        this.b = r5;
        WeakReference<bda.a> r6 = this.a;
        if (r6 == null) goto L28;
        bda.a r7 = r6.get();
        if (r7 == null) goto L28;
        String r8 = this.b;
        AppHost.Companion r1 = AppHost.a;
        if (Intrinsics.areEqual(r8, r1.getApplication().getString(2131911911)) == false) goto L21;
        String r9 = r1.getApplication().getString(2131911913);
        Intrinsics.checkNotNull(r9);
    L22:
        r7.S(r9);
        goto L28
    L21:
        r9 = r1.getApplication().getString(2131911910);
        Intrinsics.checkNotNull(r9);
    L28:
        WeakReference<bda.a> r10 = this.a;
        if (r10 == null) goto L33;
        bda.a r11 = r10.get();
        if (r11 == null) goto L33;
        Pair r12 = r11.y1();
    L34:
        ObricActionBarTrackServiceExtDelegate r13 = ObricActionBarTrackServiceExtDelegate.b;
        if (r12 == null) goto L38;
        String r2 = (String) r12.getSecond();
        if (r2 == null) goto L38;
    L39:
        if (r12 == null) goto L43;
        Long r14 = (Long) r12.getFirst();
        if (r14 == null) goto L43;
        long r3 = r14.longValue();
    L44:
        r13.i(r2, r3);
        return;
    L43:
        r3 = 0;
    L38:
        r2 = "";
    L33:
        r12 = null;
        goto L34
    L11:
        if (r4.intValue() != 0) goto L13;
    L23:
        t1a.b r15 = r2.a();
        if (r15 == null) goto L28;
        laa.h r16 = r15.getAbility(laa.h.class);
        if (r16 == null) goto L28;
        r16.zG();
        goto L28
    }

    public final String w(Message r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "sendScene");
        if (Intrinsics.areEqual(r6, ObricMessageBottomExtActionType.SCENE_OBRIC_DIRECT_SEND) == true) goto L6;
        FLogger.a.i("ObricActionBarSendServiceImpl", "modifyContent, sendScene is not ObricMessageBottomExtActionType.SCENE_OBRIC_DIRECT_SEND");
        return null;
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        String r3 = "";
        if (com.larus.im.bean.message.a.b0(r5) == false) goto L13;
        String r7 = com.larus.bmhome.chat.bean.d.H(r5);
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        if (r7 != null) goto L19;
    L22:
        boolean r8 = true;
    L23:
        if (r8 == false) goto L26;
        return null;
    L26:
        if (Intrinsics.areEqual(r6, ObricMessageBottomExtActionType.SCENE_OBRIC_DIRECT_SEND) == false) goto L41;
        Message r9 = this.e.get();
        if (r9 == null) goto L41;
        if (com.larus.im.bean.message.a.b0(r9) == false) goto L35;
        String r10 = com.larus.bmhome.chat.bean.d.H(r9);
        if (r10 == null) goto L39;
    L34:
        r3 = r10;
    L39:
        Gson r11 = com.larus.utils.z.a;
        return com.larus.utils.z.c(new com.obric.assistant.component.a(StringsKt.removePrefix(StringsKt.removePrefix(r3, j), k)));
    L35:
        Gson r12 = com.larus.utils.z.a;
        com.obric.assistant.component.a r13 = (com.obric.assistant.component.a) com.larus.utils.z.a(r9.getContent(), com.obric.assistant.component.a.class);
        if (r13 == null) goto L39;
        r10 = r13.a();
        if (r10 != null) goto L34;
    L41:
        return null;
    L19:
        if (r7.length() == 0) goto L22;
        r8 = false;
        goto L23
    L13:
        Gson r1 = com.larus.utils.z.a;
        com.obric.assistant.component.a r14 = (com.obric.assistant.component.a) com.larus.utils.z.a(r5.getContent(), com.obric.assistant.component.a.class);
        if (r14 == null) goto L16;
        r7 = r14.a();
        goto L17
    L16:
        r7 = null;
        goto L17
    }

    public static void y(Map r17, StateInfo r18, DMTaskState r19) {
        ObricActionBarTrackType r2 = ObricActionBarTrackType.OBRIC_COMPLEX_TASK;
        r17.put("action_bar_key", r2.getStringValue());
        r17.put("is_from_obric_action_bar", r2.getStringValue());
        r17.put("mcp_message_type", "mcp_normal_task");
        r17.put("o_is_omni_agent", "1");
        if (r19 == null) goto L9;
        DMTaskInfo r4 = r19.getTaskInfo();
        if (r4 == null) goto L9;
        IMMessage r5 = r4.getMessage();
        if (r5 == null) goto L9;
        String r6 = r5.getMessageId();
    L10:
        boolean r7 = false;
        if (r19 == null) goto L15;
        if (r18 == null) goto L14;
        int r8 = r18.getRequestType();
    L17:
        FLogger r9 = FLogger.a;
        r9.i("ObricActionBarSendServiceImpl", "addComplexExt: requestType = " + r8);
        String r14 = "";
        if (r8 != 0) goto L110;
        r17.put("o_task_type", "complex_task");
        r17.put("o_task_state", "start_complex_task");
        r17.put("o_not_interrupt", "1");
        CharSequence r3 = (CharSequence) r17.get("o_complex_task_model");
        if (r3 != null) goto L22;
    L25:
        boolean r10 = true;
    L26:
        if (r10 == false) goto L64;
        CopyOnWriteArraySet<com.obric.assistant.task.skill.f.a> r11 = com.obric.assistant.task.skill.f.a;
        ReplyOption r12 = com.obric.assistant.task.skill.f.c.get();
        if (r12 == null) goto L61;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        ObricOmniModelConfigManager.a.getClass();
        ObricOmniModelConfig r13 = ObricOmniModelConfigManager.c();
        int r15 = r12.getModel().getDeprecatedItemId();
        AtomicBoolean r16 = com.obric.assistant.task.skill.m.a;
        if (com.obric.assistant.task.skill.m.j(Integer.valueOf(r15)) == false) goto L42;
        Iterator<T> r20 = com.obric.assistant.task.skill.a.a(r13).iterator();
    L33:
        if (r20.hasNext() == false) goto L42;
        ObricOmniModel r110 = (ObricOmniModel) r20.next();
        if (r110.getOldItemKey() == null) goto L33;
        Integer r111 = r110.getOldItemKey();
        if (r111 == null) goto L33;
        if (r111.intValue() != r15) goto L33;
        Gson r21 = com.larus.utils.z.a;
        String r22 = com.larus.utils.z.c(new ObricOmniModelItem(r110.getDisplayModel(), r110.getModel()));
    L62:
        if (r22 == null) goto L64;
        r17.put("o_complex_task_model", r22);
    L42:
        String r23 = r12.getModel().getKey();
        if (r23 != null) goto L45;
    L48:
        boolean r24 = true;
    L49:
        if (r24 == true) goto L61;
        Iterator<T> r25 = com.obric.assistant.task.skill.a.a(r13).iterator();
    L53:
        if (r25.hasNext() == false) goto L61;
        ObricOmniModel r26 = (ObricOmniModel) r25.next();
        vea.k r27 = r26.getModelItemIndex();
        if (r27 == null) goto L57;
        String r28 = r27.b();
    L59:
        if (Intrinsics.areEqual(r23, r28) == false) goto L53;
        Gson r29 = com.larus.utils.z.a;
        r22 = com.larus.utils.z.c(new ObricOmniModelItem(r26.getDisplayModel(), r26.getModel()));
        goto L62
    L57:
        r28 = null;
        goto L59
    L45:
        if (r23.length() == 0) goto L48;
        r24 = false;
    L61:
        r22 = null;
    L64:
        String r30 = (String) r17.get("o_instruction_entry");
        if (r30 == null) goto L67;
        String r31 = com.larus.utils.p0.a(r30);
    L68:
        if (r31 != null) goto L86;
        if (r18 == null) goto L73;
        Map r32 = r18.getExt();
        if (r32 == null) goto L73;
        r31 = (String) r32.get("o_instruction_entry");
    L74:
        if (r31 != null) goto L76;
    L79:
        boolean r33 = true;
    L80:
        if (r33 == true) goto L82;
    L84:
        if (r31 != null) goto L86;
        r31 = "";
        goto L86
    L82:
        if (z() == true) goto L84;
        FLogger.a.i("ObricActionBarSendServiceImpl", "addComplexExt: use default action bar as entry");
        r31 = "action_bar_option";
        goto L86
    L76:
        if (r31.length() == 0) goto L79;
        r33 = false;
    L73:
        r31 = null;
    L86:
        r17.put("o_instruction_entry", r31);
        CharSequence r34 = (CharSequence) r17.get("o_omni_instruction_type");
        if (r34 != null) goto L89;
    L92:
        boolean r35 = true;
    L93:
        if (r35 == false) goto L108;
        if (r18 == null) goto L98;
        Map r36 = r18.getExt();
        if (r36 == null) goto L98;
        String r37 = (String) r36.get("o_omni_instruction_type");
    L99:
        if (r37 == null) goto L103;
        r14 = r37;
    L103:
        if (r14.length() <= 0) goto L105;
        r7 = true;
    L105:
        if (r7 == false) goto L107;
        FLogger.a.i("ObricActionBarSendServiceImpl", "addComplexExt: use state info cmp msg type ".concat(r14));
        r17.put("o_omni_instruction_type", r14);
        return;
    L107:
        FLogger.a.i("ObricActionBarSendServiceImpl", "addComplexExt: use default cmp msg type");
        r17.put("o_omni_instruction_type", "normal");
        return;
    L98:
        r37 = null;
        goto L99
    L108:
        FLogger.a.i("ObricActionBarSendServiceImpl", "use existing entry: " + ((String) r17.get("o_omni_instruction_type")));
        return;
    L89:
        if (r34.length() == 0) goto L92;
        r35 = false;
        goto L93
    L67:
        r31 = null;
        goto L68
    L22:
        if (r3.length() == 0) goto L25;
        r10 = false;
        goto L26
    L110:
        if (r8 != 1) goto L112;
    L130:
        if (r18 == null) goto L132;
        String r38 = com.obric.assistant.utils.m.a(r18);
    L133:
        if (r38 != null) goto L135;
    L136:
        r7 = true;
    L137:
        if (r7 == false) goto L139;
        r38 = com.obric.assistant.utils.l.b(r19);
    L139:
        r17.put("o_complex_source_type", r38);
        IObricSpecialInputService r39 = (IObricSpecialInputService) ServiceManager.get().getService(IObricSpecialInputService.class);
        if (r39 == null) goto L150;
        Map<String, String> r40 = r39.g(r19);
        if (r40 == null) goto L150;
        Set<Map.Entry<String, String>> r41 = r40.entrySet();
        if (r41 == null) goto L150;
        Iterator<T> r42 = r41.iterator();
    L147:
        if (r42.hasNext() == false) goto L150;
        Map.Entry r43 = (Map.Entry) r42.next();
        r17.put(r43.getKey(), r43.getValue());
    L150:
        if (r19 == null) goto L181;
        Map r1 = r19.getExtra();
        if (r1 == null) goto L182;
        Iterator r44 = r1.entrySet().iterator();
    L155:
        if (r44.hasNext() == false) goto L183;
        Map.Entry r45 = (Map.Entry) r44.next();
        String r46 = (String) r45.getValue();
        if (r46 == null) goto L155;
        r17.put(r45.getKey(), r46);
        goto L155
    L183:
        return;
    L182:
        return;
    L181:
        return;
    L135:
        if (r38.length() != 0) goto L137;
    L132:
        r38 = null;
        goto L133
    L112:
        if (r8 == ObricComplexTaskPanelType.CLARIFYING.getValue()) goto L130;
        if (r8 != 2) goto L117;
    L120:
        if (r18 == null) goto L122;
        String r47 = com.obric.assistant.utils.m.a(r18);
    L123:
        if (r47 != null) goto L125;
        r47 = "";
    L125:
        r17.put("o_complex_source_type", r47);
        r17.put("o_task_type", "complex_task");
        r17.put("o_task_state", "addition_complex_task");
        r17.put("o_omni_intention", "task_addition");
        r17.put("o_omni_task_id", com.obric.assistant.utils.l.d(r19));
        if (r6 == null) goto L128;
        r17.put("o_reference_msg_id", r6);
    L129:
        r17.put("o_not_interrupt", "1");
        return;
    L128:
        r9.e("ObricActionBarSendServiceImpl", "addComplexExt: messageId is null");
        r17.put("o_reference_msg_id", "");
        goto L129
    L122:
        r47 = null;
        goto L123
    L117:
        if (r8 == ObricComplexTaskPanelType.ADDITION.getValue()) goto L120;
        r9.i("ObricActionBarSendServiceImpl", "addComplexExt: unexpected requestType " + r8);
        return;
    L14:
        FLogger.a.i("ObricActionBarSendServiceImpl", "addComplexExt: requestType is null, use default request type " + com.obric.assistant.special_input.v0.a + ".CREATE");
    L16:
        r8 = 0;
        goto L17
    L15:
        FLogger.a.i("ObricActionBarSendServiceImpl", "no related task, use default request type CREATE");
    L9:
        r6 = null;
        goto L10
    }

    public final void c(Message r11, gd8.g r12, MessageInBoxBottomExtWidgetSlotCell r13) {
        Intrinsics.checkNotNullParameter(r11, "replyMessage");
        Intrinsics.checkNotNullParameter(r13, "lifecycleOwner");
        IFlowMessageService r0 = (IFlowMessageService) ServiceManager.get().getService(IFlowMessageService.class);
        if (r0 == null) goto L6;
        r0.b(r11.getLocalMessageId());
    L6:
        if ((r12 instanceof gd8.g) == true) goto L9;
        r12 = null;
    L9:
        if (r12 == null) goto L14;
        String r1 = r11.getConversationId();
        if (r1 != null) goto L13;
        r1 = "";
    L13:
        r12.mh(r1, "jump_deep_thinking", OmniBreakReason.OmniBreakReason_REGENERATE_OR_SWITCH_MODE);
    L14:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r13), Dispatchers.getIO(), null, new ObricActionBarSendServiceImpl$reSendMessage$1(r11, this, null), 2, null);
    }

    public final String e(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "userInput");
        if (Intrinsics.areEqual(r4, "obric_web_perception") == false) goto L5;
    L7:
        if (r5 == null) goto L34;
        boolean r0 = true;
        if (r5.length() <= 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L34;
        if (r6.length() == 0) goto L21;
        r0 = false;
    L21:
        if (r0 == false) goto L24;
        return r5;
    L24:
        if (Intrinsics.areEqual(r6, r5) == false) goto L27;
        return null;
    L27:
        if (StringsKt.startsWith$default(r6, r5.concat("\n"), false, 2, null) == false) goto L30;
        return r6;
    L30:
        if (StringsKt.startsWith$default(r6, r5, false, 2, null) == false) goto L33;
        return r5 + '\n' + StringsKt.removePrefix(r6, r5);
    L33:
        return r5 + '\n' + r6;
    L11:
        r7 = false;
    L34:
        return null;
    L5:
        if (Intrinsics.areEqual(r4, "obric_video_perception") == true) goto L7;
        return null;
    }

    public final String x(Map<String, String> r7, String r8, Object r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "sendScene");
        AppHost.a.a().getCurrentActivity();
        String r11 = (String) ((LinkedHashMap) r7).get("action_bar_key");
        if (Intrinsics.areEqual(r11, "obric_web_perception") == false) goto L5;
    L38:
        FLogger.a.i("ObricActionBarSendServiceImpl", "replaceContentOnSend, current bar is: " + r11);
        r7.put("is_from_obric_action_bar", r11);
        return null;
    L5:
        if (Intrinsics.areEqual(r11, "obric_video_perception") == true) goto L38;
        if ((r9 instanceof ICoreInputAbility.OnSendParams) == false) goto L31;
        ICoreInputAbility.OnSendParams r12 = (ICoreInputAbility.OnSendParams) r9;
        String r13 = r12.getEnterMethod();
        if (StringsKt.isBlank(r13) == false) goto L17;
        MultiAttachmentInfo r14 = r12.getMultiAttachment();
        if (r14 == null) goto L15;
        String r15 = r14.getEnterMethod();
        if (r15 == null) goto L15;
    L16:
        r13 = r15;
    L15:
        r15 = "";
    L17:
        FLogger.a.i("ObricActionBarSendServiceImpl", "replaceContentOnSend, enterMethod: " + r13);
        ObricActionBarTrackType.Companion.getClass();
        if (ObricActionBarTrackType.a.b().contains(r13) == false) goto L31;
        r7.put("action_bar_key", r13);
        r7.put("is_from_obric_action_bar", r13);
        if (Intrinsics.areEqual(r13, ObricActionBarTrackType.OBRIC_AI_BEAUTIFY.getStringValue()) == false) goto L22;
    L27:
        boolean r16 = true;
    L28:
        if (r16 == true) goto L31;
        r7.remove("action_bar_instruction");
        r7.remove("action_bar_instruction_type");
        goto L31
    L22:
        if (Intrinsics.areEqual(r13, ObricActionBarTrackType.OBRIC_PICTURE_DYNAMIC.getStringValue()) == true) goto L27;
        if (Intrinsics.areEqual(r13, ObricActionBarTrackType.OBRIC_PHOTO_PERCEPTION.getStringValue()) == true) goto L27;
        r16 = false;
    L31:
        if (z() == false) goto L34;
        FLogger.a.e("ObricActionBarSendServiceImpl", "special input is not open");
        return null;
    L34:
        i(r7, null);
        if (r8 == null) goto L37;
        Intrinsics.checkNotNullParameter(r8, "content");
    L37:
        return null;
    }
}
