package com.larus.bmhome.chat.component.ext;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.bean.ChatMsgDeleteScene;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.trace.ChatMessageTrace;
import com.larus.bmhome.tipoff.TipOffDialogFragment;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatFragmentDelegateDialogExtKt {
    public static void a(CommonDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, null);
    }

    public static void b(FragmentManager r11, Message r12, Integer r13, int r14) {
        String r1 = null;
        if ((r14 & 8) == 0) goto L5;
        Boolean r0 = Boolean.FALSE;
    L7:
        if ((r14 & 16) == 0) goto L9;
        r13 = null;
    L9:
        Intrinsics.checkNotNullParameter(r11, "fm");
        Intrinsics.checkNotNullParameter(r12, "chatMessage");
        DialogFragment r2 = r11.findFragmentByTag("dislikeDialogClose");
        if ((r2 instanceof DialogFragment) == false) goto L12;
        DialogFragment r3 = r2;
    L13:
        if (r3 != null) goto L72;
        e0 r4 = (e0) AuthModelDelegate.b.e().getValue();
        if (r4 == null) goto L23;
        LaunchInfo r5 = r4.a;
    L24:
        ArrayList r6 = new ArrayList();
        boolean r7 = false;
        if (r5 == null) goto L38;
        List r8 = r5.G0();
        if (r8 == null) goto L38;
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L30:
        if (r10.hasNext() == false) goto L37;
        Object r15 = r10.next();
        if (((FeedbackMeta) r15).c() != MsgFeedbackType.MsgFeedbackTypeDislike.value) goto L34;
        boolean r16 = true;
    L35:
        if (r16 == false) goto L30;
        r9.add(r15);
        goto L30
    L34:
        r16 = false;
        goto L35
    L37:
        r6.addAll(r9);
    L38:
        Bundle r17 = new Bundle();
        r17.putString("message_id", r12.getMessageId());
        Map r18 = r12.getExt();
        if (r18 == null) goto L41;
        String r19 = (String) r18.get("inner_log_id");
    L42:
        r17.putString("message_log_id", r19);
        Integer r20 = r12.getFeedback();
        if (r20 == null) goto L45;
        int r21 = r20.intValue();
    L46:
        r17.putInt("last_feedback", r21);
        if (r13 == null) goto L49;
        r17.putInt("feedback_scene", r13.intValue());
    L49:
        r17.putString("section_id", r12.getSectionId());
        IObricChatUIService r110 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r110 != null) goto L52;
    L54:
        if (r7 == true) goto L85;
        IAIChatService.Companion r111 = IAIChatService.a;
        if (r5 == null) goto L58;
        r1 = r5.H0();
    L58:
        if (r0 == null) goto L60;
        r17.putBoolean("direct_report_reason", r0.booleanValue());
    L60:
        r17.putBoolean("is_multiple_selection", true);
        Unit r112 = Unit.INSTANCE;
        DialogFragment r113 = r111.k7(r6, r1, r17);
        if (r113.isAdded() == true) goto L86;
        LandscapeRestrictionOperation r114 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L68
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r113, "dislikeDialogClose", r114);     // Catch: Exception -> L68
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r11, r113, r114) == true) goto L88;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L71
    L66:
        r113.show(r11, "dislikeDialogClose");     // Catch: Exception -> L68
        return;
    L88:
        return;
    L68:
        e = move-exception;
        FLogger.a.e("DislikeDialog", "find dislike dialog exception: " + e);
        return;
    L86:
        return;
    L85:
        return;
    L52:
        if (r110.N(r11, r12, r17) != true) goto L54;
        r7 = true;
        goto L54
    L45:
        r21 = MsgFeedbackType.MsgFeedbackTypeDefault.value;
        goto L46
    L41:
        r19 = null;
        goto L42
    L23:
        r5 = null;
        goto L24
    L72:
        r3.dismiss();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r115 = DialogFragmentLancet.sLastShowStack;
        if (r115 == null) goto L83;
        com.bytedance.crash.d.d(r115, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L83:
        return;
    L12:
        r3 = null;
        goto L13
    L5:
        r0 = null;
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x016c -> B:47:0x0176). Please report as a decompilation issue!!! */
    public static final Object c(List<Message> r26, String r27, JSONObject r28, ChatMsgDeleteScene r29, Integer r30, Continuation<? super Unit> r31) {
        if ((r31 instanceof ChatFragmentDelegateDialogExtKt$reportDeleteMessages$1) == false) goto L7;
        ChatFragmentDelegateDialogExtKt$reportDeleteMessages$1 r1 = (ChatFragmentDelegateDialogExtKt$reportDeleteMessages$1) r31;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L18;
        if (r4 == 3) goto L17;
        if (r4 != 4) goto L16;
        String r5 = (String) r1.L$5;
        List r6 = (List) r1.L$4;
        Integer r7 = (Integer) r1.L$3;
        JSONObject r8 = (JSONObject) r1.L$2;
        String r9 = (String) r1.L$1;
        List<Message> r10 = (List) r1.L$0;
        ResultKt.throwOnFailure(r0);
        List<Message> r15 = r10;
    L83:
        ChatMessageTrace r11 = ChatMessageTrace.a;
        ChatMessageTrace.d(r15, r9, r7, !r6.isEmpty(), r5, r8);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Iterator r12 = (Iterator) r1.L$8;
        String r13 = (String) r1.L$7;
        List r14 = (List) r1.L$6;
        String r16 = (String) r1.L$5;
        List r17 = (List) r1.L$4;
        Integer r18 = (Integer) r1.L$3;
        JSONObject r19 = (JSONObject) r1.L$2;
        String r110 = (String) r1.L$1;
        r15 = (List) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L74:
        if (r12.hasNext() == false) goto L78;
        Message r20 = (Message) r12.next();
        ye8.b r21 = ChatInputService.b.f();
        r1.L$0 = r15;
        r1.L$1 = r110;
        r1.L$2 = r19;
        r1.L$3 = r18;
        r1.L$4 = r17;
        r1.L$5 = r16;
        r1.L$6 = r14;
        r1.L$7 = r13;
        r1.L$8 = r12;
        r1.label = 3;
        if (r21.a(r20, r1) != r3) goto L74;
        return r3;
    L78:
        Object r22 = r3;
        r5 = r13;
        r6 = r14;
        String r111 = r16;
        List r23 = r17;
        r7 = r18;
        r8 = r19;
        r9 = r110;
    L80:
        RepoDispatcher.a.getClass();
        ChatRepo r112 = RepoDispatcher.d;
        r1.L$0 = r15;
        r1.L$1 = r9;
        r1.L$2 = r8;
        r1.L$3 = r7;
        r1.L$4 = r6;
        r1.L$5 = r5;
        r1.L$6 = null;
        r1.L$7 = null;
        r1.L$8 = null;
        r1.label = 4;
        if (r112.C1(r111, r23, true, false, r1) != r22) goto L83;
        return r22;
    L18:
        String r24 = (String) r1.L$7;
        List r25 = (List) r1.L$6;
        List r32 = (List) r1.L$5;
        Integer r113 = (Integer) r1.L$4;
        ChatMsgDeleteScene r114 = (ChatMsgDeleteScene) r1.L$3;
        JSONObject r115 = (JSONObject) r1.L$2;
        String r116 = (String) r1.L$1;
        List<Message> r117 = (List) r1.L$0;
        ResultKt.throwOnFailure(r0);
        List r118 = r25;
        r15 = r117;
        r110 = r116;
        r19 = r115;
        r18 = r113;
        r16 = r24;
    L70:
        Pair r33 = (Pair) r0;
        r6 = (List) r33.component1();
        r13 = (String) r33.component2();
        FLogger.a.i("DeleteMessagesDialog", "delete msg from cvs id: " + r16 + ", origin size: " + r15.size() + ", real size: " + r32.size() + ", scene: " + r114 + ", success: " + r6 + ", errMsg: " + r13);
        if ((!r6.isEmpty()) == false) goto L79;
        r14 = r6;
        r17 = r118;
        r12 = r15.iterator();
        goto L74
    L79:
        r22 = r3;
        r5 = r13;
        r111 = r16;
        r7 = r18;
        r8 = r19;
        r9 = r110;
        r23 = r118;
        goto L80
    L19:
        Message r34 = (Message) r1.L$8;
        Iterator r35 = (Iterator) r1.L$7;
        List r119 = (List) r1.L$6;
        List r120 = (List) r1.L$5;
        Integer r121 = (Integer) r1.L$4;
        ChatMsgDeleteScene r122 = (ChatMsgDeleteScene) r1.L$3;
        JSONObject r123 = (JSONObject) r1.L$2;
        String r124 = (String) r1.L$1;
        List<Message> r36 = (List) r1.L$0;
        ResultKt.throwOnFailure(r0);
        ChatFragmentDelegateDialogExtKt$reportDeleteMessages$1 r125 = r1;
        String r37 = r124;
        Object r126 = r3;
        JSONObject r38 = r123;
    L47:
        List r39 = (List) r0;
        if (r39.isEmpty() == false) goto L50;
        r120.add(r34);
    L51:
        List<Message> r40 = r36;
        Integer r41 = r121;
        ChatMsgDeleteScene r42 = r122;
        List r127 = r119;
        List r128 = r120;
    L22:
        if (r35.hasNext() == false) goto L53;
        Message r129 = (Message) r35.next();
        if (com.larus.bmhome.chat.bean.d.v0(r129) == true) goto L22;
        String r130 = r129.getMessageId();
        boolean r131 = false;
        if (r130 != null) goto L28;
    L31:
        boolean r132 = true;
    L32:
        if (r132 == true) goto L33;
        if (com.larus.bmhome.chat.bean.d.C0(r129) == true) goto L36;
        r128.add(r129);
        goto L22
    L36:
        String r133 = r129.getReplyId();
        if (r133 != null) goto L39;
    L40:
        r131 = true;
    L41:
        if (r131 == false) goto L43;
        r128.add(r129);
        goto L22
    L43:
        RepoDispatcher.a.getClass();
        ChatRepo r134 = RepoDispatcher.d;
        r125.L$0 = r40;
        r125.L$1 = r37;
        r125.L$2 = r38;
        r125.L$3 = r42;
        r125.L$4 = r41;
        r125.L$5 = r128;
        r125.L$6 = r127;
        r125.L$7 = r35;
        r125.L$8 = r129;
        r125.label = 1;
        r134.getClass();
        Object r135 = ChatRepo.c(r129, r125);
        if (r135 != r126) goto L46;
        return r126;
    L46:
        Integer r210 = r41;
        r36 = r40;
        r0 = r135;
        r120 = r128;
        r122 = r42;
        r34 = r129;
        r119 = r127;
        r121 = r210;
        goto L47
    L39:
        if (StringsKt.isBlank(r133) == false) goto L41;
    L33:
        r127.add(r129);
        goto L22
    L28:
        if (r130.length() == 0) goto L31;
        r132 = false;
        goto L32
    L53:
        Iterator<T> r43 = r40.iterator();
    L55:
        if (r43.hasNext() == false) goto L59;
        Object r136 = r43.next();
        if ((!com.larus.bmhome.chat.bean.d.v0((Message) r136)) == false) goto L55;
    L60:
        Message r137 = (Message) r136;
        if (r137 == null) goto L63;
        String r44 = r137.getConversationId();
    L64:
        if (r44 != null) goto L66;
        r44 = "";
    L66:
        String r138 = r44;
        RepoDispatcher.a.getClass();
        ChatRepo r45 = RepoDispatcher.d;
        r125.L$0 = r40;
        r125.L$1 = r37;
        r125.L$2 = r38;
        r125.L$3 = r42;
        r125.L$4 = r41;
        r125.L$5 = r128;
        r125.L$6 = r127;
        r125.L$7 = r138;
        r125.L$8 = null;
        r125.label = 2;
        r118 = r127;
        List r139 = r128;
        Object r46 = r126;
        Object r47 = r45.C1(r138, r128, false, true, r125);
        if (r47 != r46) goto L69;
        return r46;
    L69:
        r110 = r37;
        r19 = r38;
        r114 = r42;
        r3 = r46;
        r16 = r138;
        r18 = r41;
        r1 = r125;
        r15 = r40;
        r0 = r47;
        r32 = r139;
        goto L70
    L63:
        r44 = null;
        goto L64
    L59:
        r136 = null;
        goto L60
    L50:
        r120.addAll(r39);
        goto L51
    L20:
        ResultKt.throwOnFailure(r0);
        ArrayList r48 = new ArrayList();
        r128 = r48;
        r125 = r1;
        r126 = r3;
        r127 = new ArrayList();
        r35 = r26.iterator();
        r40 = r26;
        r37 = r27;
        r38 = r28;
        r42 = r29;
        r41 = r30;
    L7:
        r1 = new ChatFragmentDelegateDialogExtKt$reportDeleteMessages$1(r31);
        goto L8
    }

    public static final void d(FragmentManager r24, List<Message> r25, RecommendFrom r26, String r27, int r28, String r29, String r30, String r31, SearchMobParam r32, String r33, Integer r34) {
        Intrinsics.checkNotNullParameter(r24, "fm");
        Intrinsics.checkNotNullParameter(r25, "messages");
        Intrinsics.checkNotNullParameter(r29, "conversationId");
        Intrinsics.checkNotNullParameter(r30, "severIndex");
        Message r5 = (Message) CollectionsKt.last(r25);
        boolean r6 = true;
        if (r34 == null) goto L6;
        int r9 = r34.intValue();
    L10:
        if (com.larus.bmhome.chat.bean.d.b0(r5) == false) goto L16;
        String r7 = com.larus.im.bean.message.a.D(r5);
        if (r7 != null) goto L19;
        r7 = r5.getMessageId();
        if (r7 != null) goto L19;
    L18:
        r7 = "";
    L19:
        String r10 = r7;
        String r18 = r5.getSenderId();
        Intrinsics.checkNotNullParameter(r10, "entityId");
        TipOffDialogParams r8 = new TipOffDialogParams(r9, r10, null, null, "", "", 0, null, null, r18, null, null, null, null, null);
        r8.c = r26;
        r8.d = r27;
        r8.g = r28;
        Intrinsics.checkNotNullParameter(r29, "conversationId");
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        r8.e = r29;
        Intrinsics.checkNotNullParameter(r30, "serverIndex");
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        r8.f = r30;
        r8.i = r31;
        r8.h = r32;
        Map r2 = r5.getExt();
        if (r2 == null) goto L32;
        String r3 = (String) r2.get("asr_log_id");
        if (r3 == null) goto L32;
        if (r3.length() <= 0) goto L26;
        boolean r11 = true;
    L27:
        if (r11 == true) goto L30;
        r3 = null;
    L30:
        if (r3 == null) goto L32;
        Map r4 = MapsKt.mapOf(TuplesKt.to("asr_log_id", r3));
    L33:
        r8.o = r4;
        r8.k = r33;
        if (r25.size() <= 1) goto L42;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r25.iterator();
    L37:
        if (r13.hasNext() == false) goto L41;
        String r14 = ((Message) r13.next()).getMessageId();
        if (r14 == null) goto L37;
        r12.add(r14);
        goto L37
    L41:
        Intrinsics.checkNotNullParameter(r12, "batchIds");
        r8.m = r12;
    L42:
        IObricChatUIService r15 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r15 != null) goto L45;
    L47:
        r6 = false;
    L48:
        if (r6 == true) goto L63;
        TipOffDialogFragment.a r1 = new TipOffDialogFragment.a();
        Intrinsics.checkNotNullParameter(r8, "builder");
        r1.a = r8;
        TipOffDialogFragment r16 = r1.a();
        LandscapeRestrictionOperation r17 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r16, null, r17);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r24, r16, r17) == true) goto L64;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L55
    L53:
        r16.show(r24, null);
        return;
    L64:
        return;
    L63:
        return;
    L45:
        if (r15.a(r24, r8, r25) != true) goto L47;
    L26:
        r11 = false;
    L32:
        r4 = null;
        goto L33
    L16:
        r7 = r5.getMessageId();
        if (r7 != null) goto L19;
    L6:
        if (r25.size() <= 1) goto L8;
        r9 = 18;
        goto L10
    L8:
        r9 = 2;
        goto L10
    }
}
