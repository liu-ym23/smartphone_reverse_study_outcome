package com.larus.uaigc.createpage.processor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.j4;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.j;
import com.larus.platform.exp.o;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.applet.IAICreationAppletHostService;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.createpage.component.sendmessage.CreationSendUiEvent;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.createpage.CreationHalfChatFragment;
import com.larus.uaigc.createpage.CreationHalfFragment;
import com.larus.uaigc.createpage.CreationHostUiPolicy;
import com.larus.uaigc.createpage.component.input.CreationInputComponent;
import com.larus.uaigc.createpage.component.input.z;
import com.larus.uaigc.service.CreationDoSameNotifyInfo;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ic8.l0;
import ic8.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import ny9.i;
import ny9.s;
import ny9.u;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreatePageSendMessageProcessor implements ny9.d {
    public static final Set<String> h = null;
    public final BaseContentWidget a;
    public final s b;
    public final ICoreInputAbility c;
    public final uy9.a d;
    public final u e;
    public final Function0<Unit> f;
    public boolean g;

    public static final class a {
    }

    static {
        h = SetsKt.setOf(new String[]{"shoot", "shoot_ocr"});
    }

    public final boolean B() {
        s r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L15;
        int r2 = CreationHostUiPolicy.f;
        s r3 = this.b;
        if (r3 == null) goto L12;
        Bundle r4 = r3.a;
    L14:
        if (CreationHostUiPolicy.a.a(r4).d == true) goto L15;
        return false;
    L12:
        r4 = null;
    L15:
        return true;
    L5:
        if (r0.j() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean C() {
        cy9.a r0 = cy9.a.a;
        s r1 = this.b;
        if (r1 == null) goto L5;
        Bundle r2 = r1.a;
    L6:
        Bundle r3 = r0.c(r2);
        if (r3 == null) goto L11;
        r2 = r3;
    L11:
        return cy9.a.i(r2, "suppress_action_bar_item_id_on_send");
    L5:
        r2 = null;
        goto L6
    }

    public final boolean l() {
        s r0 = this.b;
        if (r0 == null) goto L10;
        Bundle r1 = r0.a;
        if (r1 == null) goto L7;
        boolean r2 = r1.getBoolean("ignore_side_bar");
    L8:
        if (r2 != true) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        return false;
    L13:
        uy9.a r4 = this.d;
        if (r4 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == false) goto L21;
        return false;
    L21:
        s r6 = this.b;
        if (r6 == null) goto L29;
        Bundle r7 = r6.b();
        if (r7 == null) goto L26;
        boolean r8 = r7.getBoolean("open_new_chat_page_on_send_with_clear_top");
    L27:
        if (r8 != true) goto L29;
        boolean r9 = true;
    L30:
        if (r9 == false) goto L32;
        return true;
    L32:
        int r10 = com.larus.uaigc.applet.a.a;
        Context r11 = this.a.getContext();
        Intrinsics.checkNotNullParameter(r11, "currentContext");
        j4 r12 = IAICreationAppletHostService.a.v(r11);
        if (r12 != this.a.getContext()) goto L35;
    L38:
        AppHost.Companion r13 = AppHost.a;
        Activity r14 = (Activity) CollectionsKt.lastOrNull(r13.a().g());
        if (r14 != null) goto L41;
        return false;
    L41:
        j4 r15 = r13.a().a(r14, null);
        if (r15 != null) goto L45;
        return false;
    L45:
        if ((r15 instanceof j4) == true) goto L47;
    L49:
        return false;
    L47:
        if (r15.B0() == false) goto L49;
        return true;
    L35:
        if ((r12 instanceof j4) == false) goto L38;
        return r12.B0();
    L26:
        r8 = false;
    L29:
        r9 = false;
        goto L30
    L16:
        if (r4.JS() != true) goto L18;
        r5 = true;
        goto L19
    L7:
        r2 = false;
    L10:
        r3 = false;
        goto L11
    }

    public final void A(String r3) {
        s r0 = this.b;
        if (r0 == null) goto L7;
        ICoreInputAbility.SendMessageTrackExtMap r1 = r0.n();
        if (r1 == null) goto L7;
        Map<String, String> r2 = r1.a;
    L8:
        Map<String, String> r4 = u(r2);
        if (r4 == null) goto L15;
        IAIChatUgcAIGCService.Companion r5 = IAIChatUgcAIGCService.a;
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        r5.c(r3, r4);
        return;
    L15:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final Object j(Continuation<? super e> r45) {
        if ((r45 instanceof CreatePageSendMessageProcessor$ensureConversationRemoteBeforeSend$1) == false) goto L7;
        CreatePageSendMessageProcessor$ensureConversationRemoteBeforeSend$1 r2 = (CreatePageSendMessageProcessor$ensureConversationRemoteBeforeSend$1) r45;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        CreatePageSendMessageProcessor$ensureConversationRemoteBeforeSend$1 r13 = r2;
        Object r1 = r13.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r10 = false;
        switch(r13.label) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        String r5 = (String) r13.L$0;
        ResultKt.throwOnFailure(r1);
    L128:
        e r6 = (e) r1;
        if (r6 != null) goto L132;
        FLogger.a.e("CreatePageSendMessageProcessor", "create remote conversation before send failed, localCvsId=" + r5);
        return 0;
    L132:
        FLogger.a.i("CreatePageSendMessageProcessor", "create remote conversation before send success, localCvsId=" + r5 + ", remoteCvsId=" + r6.a);
        return r6;
    L13:
        e r7 = (e) r13.L$1;
        String r8 = (String) r13.L$0;
        ResultKt.throwOnFailure(r1);
        String r12 = r8;
    L100:
        String r9 = (String) r1;
        if (r9 != null) goto L108;
        s r11 = this.b;
        if (r11 == null) goto L107;
        ChatParam r14 = r11.c();
        if (r14 == null) goto L107;
        r9 = r14.b;
    L107:
        String r15 = null;
    L109:
        if (r15 != null) goto L111;
    L112:
        r10 = true;
    L113:
        if (r10 == false) goto L116;
        FLogger.a.e("CreatePageSendMessageProcessor", "create remote conversation before send failed, botId is empty");
        return null;
    L116:
        IConversationRepoService r16 = RepoDispatcherDelegate.b.f();
        Integer r17 = r7.v;
        if (r17 == null) goto L119;
        int r18 = r17.intValue();
    L120:
        e r19 = (e) AuthModelDelegate.b.y().getValue();
        if (r19 == null) goto L123;
        String r20 = r19.a;
    L124:
        r13.L$0 = r12;
        r13.L$1 = null;
        r13.label = 7;
        String r21 = r12;
        Object r22 = IConversationRepoService.a.a(r16, r15, r18, r20, null, false, null, null, null, null, r13, 504);
        if (r22 != r4) goto L127;
        return r4;
    L127:
        r5 = r21;
        r1 = r22;
        goto L128
    L123:
        r20 = null;
        goto L124
    L119:
        r18 = 2;
        goto L120
    L111:
        if (r15.length() != 0) goto L113;
    L108:
        r15 = r9;
        goto L109
    L14:
        ResultKt.throwOnFailure(r1);
    L95:
        return (e) r1;
    L15:
        ResultKt.throwOnFailure(r1);
    L82:
        return (e) r1;
    L16:
        String r23 = (String) r13.L$0;
        ResultKt.throwOnFailure(r1);
    L74:
        String r43 = r23;
        r7 = (e) r1;
        String r24 = r43;
    L75:
        LocalSubConvHelper r25 = LocalSubConvHelper.a;
        if (LocalSubConvHelper.h(r24, r7) == false) goto L83;
        if (r7 != null) goto L135;
        r13.L$0 = null;
        r13.label = 4;
        r1 = k(r24, r13);
        if (r1 != r4) goto L82;
        return r4;
    L135:
        return r7;
    L83:
        if (r7 != null) goto L85;
    L87:
        boolean r26 = false;
    L88:
        if (r26 == true) goto L96;
        FLogger.a.i("CreatePageSendMessageProcessor", "skip create remote conversation before send, target is not sub conversation: " + r24);
        if (r7 != null) goto L136;
        r13.L$0 = null;
        r13.label = 5;
        r1 = k(r24, r13);
        if (r1 != r4) goto L95;
        return r4;
    L136:
        return r7;
    L96:
        r13.L$0 = r24;
        r13.L$1 = r7;
        r13.label = 6;
        Object r27 = r25.f(r7, r13);
        if (r27 != r4) goto L99;
        return r4;
    L99:
        r12 = r24;
        r1 = r27;
        goto L100
    L85:
        if (n.D(r7) != true) goto L87;
        r26 = true;
        goto L88
    L17:
        String r28 = (String) r13.L$0;
        ResultKt.throwOnFailure(r1);
        String r29 = r28;
    L63:
        e r30 = (e) r1;
        if (r30 != null) goto L67;
        r30 = new e(r29, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 0, -2, 63);
    L67:
        return r30;
    L18:
        ResultKt.throwOnFailure(r1);
    L54:
        return r1;
    L19:
        ResultKt.throwOnFailure(r1);
        s r31 = this.b;
        if (r31 == null) goto L31;
        ChatParam r32 = r31.c();
        if (r32 == null) goto L31;
        r24 = r32.a;
        if (r24 == null) goto L31;
        if (o0.d(r24) == true) goto L29;
        r24 = null;
    L29:
        if (r24 == null) goto L31;
    L39:
        if (r24 == null) goto L43;
        LocalSubConvHelper r33 = LocalSubConvHelper.a;
        if (LocalSubConvHelper.i(r24) == true) goto L43;
    L44:
        if (r24 != null) goto L46;
    L49:
        boolean r34 = true;
    L50:
        if (r34 == false) goto L56;
        r13.label = 1;
        r1 = k(null, r13);
        if (r1 != r4) goto L54;
        return r4;
    L56:
        if (j.f(r24) == true) goto L68;
        FLogger.a.i("CreatePageSendMessageProcessor", "skip create remote conversation, current conversation is remote");
        e r35 = IAIChatControlTraceService.a.h(IAIChatControlTraceService.a, r24);
        if (r35 != null) goto L134;
        IConversationRepoService r36 = RepoDispatcherDelegate.b.f();
        r13.L$0 = r24;
        r13.label = 2;
        Object r37 = IConversationRepoService.a.c(r36, r24, false, null, r13, 4);
        if (r37 != r4) goto L62;
        return r4;
    L62:
        r29 = r24;
        r1 = r37;
        goto L63
    L134:
        return r35;
    L68:
        r7 = IAIChatControlTraceService.a.h(IAIChatControlTraceService.a, r24);
        if (r7 != null) goto L75;
        IConversationRepoService r38 = RepoDispatcherDelegate.b.f();
        r13.L$0 = r24;
        r13.label = 3;
        Object r39 = IConversationRepoService.a.c(r38, r24, true, null, r13, 4);
        if (r39 != r4) goto L73;
        return r4;
    L73:
        r23 = r24;
        r1 = r39;
        goto L74
    L46:
        if (r24.length() == 0) goto L49;
        r34 = false;
    L43:
        r24 = null;
    L31:
        u r40 = this.e;
        if (r40 == null) goto L38;
        r24 = r40.Y1();
        if (r24 == null) goto L38;
        if (o0.d(r24) == true) goto L39;
    L38:
        r24 = null;
        goto L39
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r2 = new CreatePageSendMessageProcessor$ensureConversationRemoteBeforeSend$1(this, r45);
        goto L8
    }

    public final ICoreInputAbility.OnSendParams r(ICoreInputAbility.OnSendParams r39) {
        if (C() == true) goto L6;
        return r39;
    L6:
        return ICoreInputAbility.OnSendParams.copy$default(r39, null, null, null, null, null, s(r39.getActionBarInstructionMap()), null, null, 0, false, null, false, false, false, null, null, null, null, false, null, s(r39.messageExt), null, null, null, null, null, null, null, null, null, null, null, null, -1048609, 1, null);
    }

    public final Map<String, String> s(Map<String, String> r2) {
        if (C() == false) goto L8;
        if (r2 == null) goto L9;
        Map<String, String> r3 = MapsKt.toMutableMap(r2);
        r3.remove("action_bar_item_id");
        r3.remove("actionbar_item_id");
        return r3;
    L9:
        return r2;
    L8:
        return r2;
    }

    public final ICoreInputAbility.SendMessageTrackExtMap t(ICoreInputAbility.SendMessageTrackExtMap r2) {
        if (r2 == null) goto L4;
        Map<String, String> r0 = r2.a;
    L5:
        Map<String, String> r1 = u(r0);
        if (r1 != null) goto L9;
        return r2;
    L9:
        return new ICoreInputAbility.SendMessageTrackExtMap(r1);
    L4:
        r0 = null;
        goto L5
    }

    public final Map<String, String> u(Map<String, String> r2) {
        if (C() == false) goto L8;
        if (r2 == null) goto L9;
        Map<String, String> r3 = MapsKt.toMutableMap(r2);
        r3.remove("action_bar_item_id");
        r3.remove("actionbar_item_id");
        return r3;
    L9:
        return r2;
    L8:
        return r2;
    }

    public final ICoreInputAbility.OnSendParams c(ICoreInputAbility.OnSendParams r38, String r39) {
        if (r39 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        ICoreInputAbility.OnSendParams r1 = r38;
    L12:
        return r(r1);
    L10:
        r1 = ICoreInputAbility.OnSendParams.copy$default(r38, null, null, null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, r39, null, null, null, null, -268435457, 1, null);
        goto L12
    L4:
        if (r39.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void i(ICoreInputAbility.OnSendParams r2, e r3) {
        ICoreInputAbility r0 = this.c;
        if (r0 == null) goto L18;
        r0.PZ(r3);
    L18:
        ICoreInputAbility r1 = this.c;     // Catch: Throwable -> L13
        if (r1 == null) goto L9;
        r1.E0(r2);     // Catch: Throwable -> L13
    L9:
        ICoreInputAbility r4 = this.c;
        if (r4 == null) goto L20;
        r4.PZ(null);
        return;
    L20:
        return;
    L13:
        th = move-exception;
        ICoreInputAbility r5 = this.c;
        if (r5 == null) goto L17;
        r5.PZ(null);
    L17:
        throw th;
    }

    public final Object k(String r13, Continuation<? super e> r14) {
        if ((r14 instanceof CreatePageSendMessageProcessor$findSendConversation$1) == false) goto L7;
        CreatePageSendMessageProcessor$findSendConversation$1 r0 = (CreatePageSendMessageProcessor$findSendConversation$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L21;
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L18;
        if (r2 == 3) goto L17;
        if (r2 != 4) goto L16;
        ResultKt.throwOnFailure(r15);
    L52:
        e r16 = (e) r15;
        if (r16 != null) goto L58;
        AuthModelDelegate r17 = AuthModelDelegate.b;
        e r18 = (e) r17.y().getValue();
        if (r18 == null) goto L57;
        return r18;
    L57:
        return (e) r17.u().getValue();
    L58:
        return r16;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r15);
    L48:
        return r15;
    L18:
        ResultKt.throwOnFailure(r15);
    L40:
        e r19 = (e) r15;
        if (r19 == null) goto L44;
        return r19;
    L44:
        if (o.a() == false) goto L49;
        LocalSubConvHelper r110 = LocalSubConvHelper.a;
        String r111 = AccountService.a.getSecUserId();
        r0.label = 3;
        r15 = r110.c(r111, null, r0);
        if (r15 != r7) goto L48;
        return r7;
    L49:
        IConversationRepoService r112 = RepoDispatcherDelegate.b.f();
        r0.label = 4;
        r15 = r112.f(r0);
        if (r15 != r7) goto L52;
        return r7;
    L19:
        r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L20:
        String r3 = r13;
        e r113 = (e) r15;
        if (r113 == null) goto L37;
        return r113;
    L37:
        IConversationRepoService r4 = RepoDispatcherDelegate.b.f();
        r0.L$0 = null;
        r0.label = 2;
        r15 = IConversationRepoService.a.c(r4, r3, true, null, r0, 4);
        if (r15 != r7) goto L40;
        return r7;
    L21:
        ResultKt.throwOnFailure(r15);
        if (r13 == null) goto L44;
        if (o0.d(r13) == true) goto L27;
        r13 = null;
    L27:
        if (r13 == null) goto L44;
        e r114 = IAIChatControlTraceService.a.h(IAIChatControlTraceService.a, r13);
        if (r114 == null) goto L31;
        return r114;
    L31:
        IConversationRepoService r5 = RepoDispatcherDelegate.b.f();
        r0.L$0 = r13;
        r0.label = 1;
        r15 = IConversationRepoService.a.c(r5, r13, false, null, r0, 4);
        if (r15 != r7) goto L20;
        return r7;
    L7:
        r0 = new CreatePageSendMessageProcessor$findSendConversation$1(this, r14);
        goto L8
    }

    public final void z(int r6, Intent r7) {
        i r0 = s1a.a.c(this.a);
        i r2 = null;
        if ((r0 instanceof i) == false) goto L5;
        i r1 = r0;
    L6:
        if (r1 != null) goto L10;
        FragmentActivity r3 = s1a.a.getActivity(this.a);
        if ((r3 instanceof i) == false) goto L12;
        r2 = (i) r3;
    L12:
        if (r2 == null) goto L15;
        FLogger.a.i("CreatePageSendMessageProcessor", "set creation result to half host, resultCode=" + r6);
        r2.Dc(r6, r7);
        return;
    L15:
        FLogger.a.i("CreatePageSendMessageProcessor", "set creation result to activity, resultCode=" + r6);
        s1a.a.getActivity(this.a).setResult(r6, r7);
        return;
    L10:
        r2 = r1;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final Object m(ICoreInputAbility.OnSendParams r13, String r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof CreatePageSendMessageProcessor$originalSendWithOnSendParams$1) == false) goto L7;
        CreatePageSendMessageProcessor$originalSendWithOnSendParams$1 r0 = (CreatePageSendMessageProcessor$originalSendWithOnSendParams$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        CreatePageSendMessageProcessor$originalSendWithOnSendParams$1 r10 = r0;
        Object r16 = r10.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r10.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r16);
    L31:
        if (((Boolean) r16).booleanValue() == false) goto L33;
        this.f.invoke();
        return Unit.INSTANCE;
    L33:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
    L55:
        this.f.invoke();
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r16);
        ICoreInputAbility.OnSendParams r17 = c(r13, r14);
        if (B() == false) goto L21;
        r10.label = 1;
        if (p(this, r17, null, null, null, null, false, null, r14, r10, 126) != r2) goto L55;
        return r2;
    L21:
        int r18 = CreationHostUiPolicy.f;
        s r19 = this.b;
        ICoreInputAbility.SendMessageTrackExtMap r4 = null;
        if (r19 == null) goto L24;
        Bundle r110 = r19.a;
    L26:
        if (CreationHostUiPolicy.a.a(r110).a == false) goto L36;
        r10.label = 2;
        r16 = y(r17, r14, r10);
        if (r16 != r2) goto L31;
        return r2;
    L36:
        s r111 = this.b;
        if (r111 == null) goto L43;
        Bundle r112 = r111.a;
        if (r112 == null) goto L41;
        boolean r113 = r112.getBoolean("need_finish_current_create_page");
    L42:
        Boolean r114 = Boxing.boxBoolean(r113);
    L44:
        Intent r5 = new Intent();
        r5.putExtra("auto_send_message_params", r17);
        r5.putExtra("end_modify", true);
        r5.putExtra("result_from", "creation");
        r5.putExtra("arg_need_finish_page", r114);
        Pair[] r115 = new Pair[1];
        u r116 = this.e;
        if (r116 == null) goto L47;
        Bundle r117 = r116.c;
    L48:
        r115[0] = TuplesKt.to("instruction_hit_point_params", r117);
        r5.putExtra("instruction_hit_point_params", f.c(r115));
        s r118 = this.b;
        if (r118 == null) goto L51;
        r4 = r118.n();
    L51:
        ICoreInputAbility.SendMessageTrackExtMap r119 = t(r4);
        if (r119 == null) goto L54;
        r5.putExtra("actionbar_instruction_send_message_track_ext_map", r119);
    L54:
        Unit r120 = Unit.INSTANCE;
        z(-1, r5);
        goto L55
    L47:
        r117 = null;
        goto L48
    L41:
        r113 = false;
        goto L42
    L43:
        r114 = null;
        goto L44
    L24:
        r110 = null;
    L7:
        r0 = new CreatePageSendMessageProcessor$originalSendWithOnSendParams$1(this, r15);
        goto L8
    }

    public final Object n(boolean r9, final Function2<? super Context, ? super Boolean, Unit> r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof CreatePageSendMessageProcessor$routeNativeBelowCreationHostIfNeeded$1) == false) goto L7;
        CreatePageSendMessageProcessor$routeNativeBelowCreationHostIfNeeded$1 r0 = (CreatePageSendMessageProcessor$routeNativeBelowCreationHostIfNeeded$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r12);
    L32:
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L27:
        if (ICreationWorkflowService.a.a0(this.a.getContext(), 300, new b(r10)) == false) goto L34;
        this.g = true;
        r0.L$0 = null;
        r0.label = 2;
        if (DelayKt.delay(300, r0) != r2) goto L32;
        return r2;
    L34:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r12);
        if (r9 == false) goto L19;
        ICoreInputAbility r13 = this.c;
        if (r13 == null) goto L23;
        r13.qp(false);
        Boxing.boxBoolean(true);
    L23:
        r0.L$0 = r10;
        r0.label = 1;
        if (DelayKt.delay(120, r0) != r2) goto L27;
        return r2;
    L19:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new CreatePageSendMessageProcessor$routeNativeBelowCreationHostIfNeeded$1(this, r11);
        goto L8
    }

    public final Object v(CreationSendMessageConfig r7, String r8, Continuation<? super Boolean> r9) {
        if ((r9 instanceof CreatePageSendMessageProcessor$sendCreationMessageOrLog$1) == false) goto L7;
        CreatePageSendMessageProcessor$sendCreationMessageOrLog$1 r0 = (CreatePageSendMessageProcessor$sendCreationMessageOrLog$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (String) r0.L$1;
        r7 = (CreationSendMessageConfig) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L17:
        boolean r11 = ((Boolean) r10).booleanValue();
        String r5 = null;
        if (r11 == true) goto L26;
        FLogger r6 = FLogger.a;
        StringBuilder r12 = new StringBuilder("sendCreationMessage rejected, scene=");
        r12.append(r8);
        r12.append(", cvsId=");
        String r13 = r7.getCvsId();
        if (r13 != null) goto L24;
        e r14 = r7.getConversation();
        if (r14 == null) goto L25;
        r5 = r14.a;
    L25:
        r12.append(r5);
        r12.append(", botId=");
        r12.append(r7.getBotId());
        r12.append(", traceId=");
        r12.append(r7.getCreationSendTraceId());
        r6.e("CreatePageSendMessageProcessor", r12.toString());
    L53:
        return Boxing.boxBoolean(r11);
    L24:
        r5 = r13;
        goto L25
    L26:
        u r15 = r7.getHitPointData();
        if (r15 == null) goto L29;
        String r16 = r15.o();
    L33:
        String r17 = r7.getScene();
        Set<String> r18 = h;
        if (CollectionsKt.contains(r18, r16) == false) goto L36;
    L39:
        if (r4 == false) goto L53;
        e r19 = r7.getConversation();
        if (r19 == null) goto L50;
        String r20 = r19.a;
        if (r20 == null) goto L50;
        if (o0.d(r20) == false) goto L48;
        r5 = r20;
    L48:
        if (r5 == null) goto L50;
    L51:
        int r21 = com.larus.uaigc.applet.a.a;
        boolean r22 = IAICreationAppletHostService.a.b(r5);
        FLogger.a.i("CreatePageSendMessageProcessor", "set camera result for AI creation applet send, handled=" + r22 + ", referenceScene=" + r16 + ", sendScene=" + r17);
    L50:
        r5 = r7.getCvsId();
        goto L51
    L36:
        if (CollectionsKt.contains(r18, r17) == true) goto L39;
        r4 = false;
        goto L39
    L29:
        u r23 = this.e;
        if (r23 == null) goto L32;
        r16 = r23.o();
        goto L33
    L32:
        r16 = null;
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        ICreationWorkflowService.Companion r24 = ICreationWorkflowService.a;
        r0.L$0 = r7;
        r0.L$1 = r8;
        r0.label = 1;
        r10 = r24.W(r7, r0);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new CreatePageSendMessageProcessor$sendCreationMessageOrLog$1(this, r9);
        goto L8
    }

    public final Object x(ICoreInputAbility.OnSendParams r13, String r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof CreatePageSendMessageProcessor$sendWithOnSendParams$1) == false) goto L7;
        CreatePageSendMessageProcessor$sendWithOnSendParams$1 r0 = (CreatePageSendMessageProcessor$sendWithOnSendParams$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        CreatePageSendMessageProcessor$sendWithOnSendParams$1 r10 = r0;
        Object r16 = r10.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r10.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L20;
        if (r3 == 3) goto L19;
        if (r3 == 4) goto L18;
        if (r3 != 5) goto L17;
        ResultKt.throwOnFailure(r16);
    L80:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r14 = (String) r10.L$1;
        r13 = (ICoreInputAbility.OnSendParams) r10.L$0;
        ResultKt.throwOnFailure(r16);
    L69:
        e r17 = (e) r16;
        if (r17 == null) goto L72;
        A(r17.a);
        i(c(r13, r14), r17);
        Intent r18 = new Intent();
        r18.putExtra("creation_dosame_notify_info", this.b.e());
        Unit r19 = Unit.INSTANCE;
        z(372, r18);
        this.f.invoke();
    L75:
        return Unit.INSTANCE;
    L72:
        return Unit.INSTANCE;
    L19:
        r14 = (String) r10.L$1;
        r13 = (ICoreInputAbility.OnSendParams) r10.L$0;
        ResultKt.throwOnFailure(r16);
    L57:
        e r110 = (e) r16;
        if (r110 == null) goto L60;
        A(r110.a);
        i(c(r13, r14), r110);
        Intent r111 = new Intent();
        r111.putExtra("creation_dosame_notify_info", this.b.e());
        Unit r112 = Unit.INSTANCE;
        z(371, r111);
        this.f.invoke();
        goto L75
    L60:
        return Unit.INSTANCE;
    L20:
        ResultKt.throwOnFailure(r16);
    L49:
        return Unit.INSTANCE;
    L21:
        ResultKt.throwOnFailure(r16);
    L39:
        this.f.invoke();
        return Unit.INSTANCE;
    L22:
        ResultKt.throwOnFailure(r16);
        s r113 = this.b;
        if (r113 == null) goto L30;
        Bundle r114 = r113.a;
        if (r114 == null) goto L27;
        boolean r115 = r114.getBoolean("is_send_from_detail");
    L28:
        if (r115 != true) goto L30;
        boolean r116 = true;
    L31:
        if (r116 == false) goto L76;
        Integer r117 = this.b.d();
        if (B() == true) goto L35;
    L41:
        if (r117 != null) goto L44;
    L50:
        if (r117 != null) goto L53;
    L62:
        if (r117 == null) goto L75;
        if (r117.intValue() != 2) goto L75;
        r10.L$0 = r13;
        r10.L$1 = r14;
        r10.label = 4;
        r16 = j(r10);
        if (r16 != r2) goto L69;
        return r2;
    L53:
        if (r117.intValue() != 1) goto L62;
        r10.L$0 = r13;
        r10.L$1 = r14;
        r10.label = 3;
        r16 = j(r10);
        if (r16 != r2) goto L57;
        return r2;
    L44:
        if (r117.intValue() != 0) goto L50;
        r10.label = 2;
        if (m(r13, r14, r10) != r2) goto L49;
        return r2;
    L35:
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{Boxing.boxInt(1), Boxing.boxInt(2)}), r117) == true) goto L41;
        ICoreInputAbility.OnSendParams r118 = c(r13, r14);
        r10.label = 1;
        if (p(this, r118, null, null, null, null, false, null, r14, r10, 126) != r2) goto L39;
        return r2;
    L76:
        r10.label = 5;
        if (m(r13, r14, r10) != r2) goto L80;
        return r2;
    L27:
        r115 = false;
    L30:
        r116 = false;
    L7:
        r0 = new CreatePageSendMessageProcessor$sendWithOnSendParams$1(this, r15);
        goto L8
    }

    public final Object y(ICoreInputAbility.OnSendParams r16, String r17, Continuation<? super Boolean> r18) {
        if ((r18 instanceof CreatePageSendMessageProcessor$sendWithOnSendParamsThroughHost$1) == false) goto L7;
        CreatePageSendMessageProcessor$sendWithOnSendParamsThroughHost$1 r1 = (CreatePageSendMessageProcessor$sendWithOnSendParamsThroughHost$1) r18;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        CreatePageSendMessageProcessor$sendWithOnSendParamsThroughHost$1 r8 = r1;
        Object r0 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        CreationSendMessageConfig r4 = (CreationSendMessageConfig) r8.L$2;
        e r5 = (e) r8.L$1;
        ICoreInputAbility.OnSendParams r6 = (ICoreInputAbility.OnSendParams) r8.L$0;
        ResultKt.throwOnFailure(r0);
        ICoreInputAbility.OnSendParams r13 = r6;
    L29:
        if (((Boolean) r0).booleanValue() == false) goto L31;
        MutableSharedFlow<CreationSendUiEvent> r7 = ty9.a.a;
        ICoreInputAbility.OnSendParams r10 = r13;
        ty9.a.a(g(this, r5.a, r10, null, r4.getClearInputContent(), 20));
        return Boxing.boxBoolean(true);
    L31:
        return Boxing.boxBoolean(false);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r11 = (String) r8.L$1;
        ICoreInputAbility.OnSendParams r12 = (ICoreInputAbility.OnSendParams) r8.L$0;
        ResultKt.throwOnFailure(r0);
        String r14 = r11;
        r13 = r12;
    L20:
        e r15 = (e) r0;
        if (r15 == null) goto L23;
        r4 = e(this, r13, null, r15, null, r14, 22);
        r8.L$0 = r13;
        r8.L$1 = r15;
        r8.L$2 = r4;
        r8.label = 2;
        r0 = v(r4, "sendWithOnSendParamsThroughHost", r8);
        if (r0 != r9) goto L27;
        return r9;
    L27:
        r5 = r15;
        goto L29
    L23:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r0);
        r8.L$0 = r16;
        r8.L$1 = r17;
        r8.label = 1;
        Object r19 = j(r8);
        if (r19 != r9) goto L19;
        return r9;
    L19:
        r13 = r16;
        r14 = r17;
        r0 = r19;
    L7:
        r1 = new CreatePageSendMessageProcessor$sendWithOnSendParamsThroughHost$1(this, r18);
        goto L8
    }

    public static CreationSendUiEvent f(String r20, ICoreInputAbility.OnSendParams r21, boolean r22, boolean r23) {
        AttachmentInfo r0 = null;
        if (r21 == null) goto L5;
        CustomMultiAttachmentInfo r1 = r21.getCustomMultiAttachment();
    L7:
        if (r1 == null) goto L9;
        boolean r10 = true;
    L11:
        if (r21 == null) goto L13;
        r0 = r21.getAttachment();
    L13:
        if (r0 != null) goto L17;
        if (r23 == true) goto L17;
        boolean r19 = false;
    L19:
        return new CreationSendUiEvent(r20, null, true, true, true, true, true, r10, true, true, true, true, true, r22, r19, 2, null);
    L17:
        r19 = true;
        goto L19
    L9:
        r10 = false;
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    @Override // ny9.d
    public final Object a(Bundle r17, ICoreInputAbility.OnSendParams r18, boolean r19, String r20, Continuation<? super Unit> r21) {
        if ((r21 instanceof CreatePageSendMessageProcessor$sendWithCreationMessage$1) == false) goto L7;
        Continuation<? super e> r1 = (CreatePageSendMessageProcessor$sendWithCreationMessage$1) r21;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Continuation<? super e> r8 = r1;
        Object r0 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        boolean r10 = false;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L20;
        if (r3 == 3) goto L19;
        if (r3 == 4) goto L18;
        if (r3 != 5) goto L17;
        CreationSendMessageConfig r4 = (CreationSendMessageConfig) r8.L$3;
        e r5 = (e) r8.L$2;
        ICoreInputAbility.OnSendParams r6 = (ICoreInputAbility.OnSendParams) r8.L$1;
        Bundle r7 = (Bundle) r8.L$0;
        ResultKt.throwOnFailure(r0);
    L78:
        if (((Boolean) r0).booleanValue() == true) goto L82;
        return Unit.INSTANCE;
    L82:
        if (r7.getSerializable("image_edit_data.with_mask") == null) goto L84;
        boolean r11 = true;
    L85:
        Bundle r12 = new Bundle(r7);
        r12.remove("image_edit_data.with_mask");
        CreationSendUiEvent r13 = f(r5.a, r6, r4.getClearInputContent(), r11);
        Intent r14 = new Intent();
        s r15 = this.b;
        Bundle r16 = null;
        if (r15 == null) goto L91;
        Bundle r22 = r15.a;
        if (r22 == null) goto L90;
        r10 = r22.getBoolean("need_finish_current_create_page");
    L90:
        Serializable r23 = Boxing.boxBoolean(r10);
    L92:
        r14.putExtra("arg_need_finish_page", r23);
        r14.putExtra("end_modify", true);
        r14.putExtra("result_from", "creation");
        r12.putSerializable("creation_send_ui_event", r13);
        r14.putExtras(r12);
        r14.putExtra("creation_message_sent", true);
        r14.putExtra("argConversationId", r5.a);
        Unit r24 = Unit.INSTANCE;
        z(-1, r14);
        int r25 = CreationHostUiPolicy.f;
        s r26 = this.b;
        if (r26 == null) goto L96;
        r16 = r26.a;
    L96:
        if (CreationHostUiPolicy.a.a(r16).a == false) goto L98;
        ty9.a.a(r13);
    L98:
        this.f.invoke();
        return Unit.INSTANCE;
    L91:
        r23 = null;
        goto L92
    L84:
        r11 = false;
        goto L85
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        boolean r27 = r8.Z$0;
        String r28 = (String) r8.L$2;
        ICoreInputAbility.OnSendParams r29 = (ICoreInputAbility.OnSendParams) r8.L$1;
        Bundle r30 = (Bundle) r8.L$0;
        ResultKt.throwOnFailure(r0);
        String r31 = r28;
        ICoreInputAbility.OnSendParams r110 = r29;
        Bundle r111 = r30;
    L69:
        e r112 = (e) r0;
        if (r112 == null) goto L72;
        r4 = e(this, r110, Boxing.boxBoolean(r27), r112, r111, r31, 2);
        r8.L$0 = r111;
        r8.L$1 = r110;
        r8.L$2 = r112;
        r8.L$3 = r4;
        r8.label = 5;
        r0 = v(r4, "sendWithCreationMessage", r8);
        if (r0 != r9) goto L76;
        return r9;
    L76:
        r7 = r111;
        r6 = r110;
        r5 = r112;
        goto L78
    L72:
        return Unit.INSTANCE;
    L19:
        ResultKt.throwOnFailure(r0);
    L62:
        if (((Boolean) r0).booleanValue() == true) goto L98;
        return Unit.INSTANCE;
    L20:
        ResultKt.throwOnFailure(r0);
    L50:
        return Unit.INSTANCE;
    L21:
        ResultKt.throwOnFailure(r0);
    L41:
        return Unit.INSTANCE;
    L22:
        ResultKt.throwOnFailure(r0);
        s r32 = this.b;
        if (r32 == null) goto L30;
        Bundle r33 = r32.a;
        if (r33 == null) goto L27;
        boolean r34 = r33.getBoolean("is_send_from_detail");
    L28:
        if (r34 != true) goto L30;
        boolean r35 = true;
    L31:
        if (r35 == false) goto L51;
        Integer r36 = this.b.d();
        if (r36 != null) goto L36;
    L42:
        if (r36 == null) goto L51;
        if (r36.intValue() != 2) goto L51;
        r8.label = 2;
        if (w(r18, r17, r19, 372, r20, r8) != r9) goto L50;
        return r9;
    L36:
        if (r36.intValue() != 1) goto L42;
        r8.label = 1;
        if (w(r18, r17, r19, 371, r20, r8) != r9) goto L41;
        return r9;
    L51:
        s r37 = this.b;
        if (r37 != null) goto L54;
    L56:
        boolean r38 = false;
    L57:
        if (r38 == false) goto L65;
        r8.label = 3;
        r0 = q(r18, r17, r17, r19, r20, r8);
        if (r0 != r9) goto L62;
        return r9;
    L65:
        r8.L$0 = r17;
        r8.L$1 = r18;
        r8.L$2 = r20;
        r8.Z$0 = r19;
        r8.label = 4;
        Object r39 = j(r8);
        if (r39 != r9) goto L68;
        return r9;
    L68:
        r111 = r17;
        r110 = r18;
        r0 = r39;
        r31 = r20;
        r27 = r19;
        goto L69
    L54:
        if (r37.j() != true) goto L56;
        r38 = true;
        goto L57
    L27:
        r34 = false;
    L30:
        r35 = false;
    L7:
        r1 = new CreatePageSendMessageProcessor$sendWithCreationMessage$1(this, r21);
        goto L8
    }

    public CreatePageSendMessageProcessor(CreationInputComponent r2, s r3, ICoreInputAbility r4, uy9.a r5, u r6, z r7) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(r7, "onSendFinish");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public static /* synthetic */ CreationSendUiEvent g(CreatePageSendMessageProcessor r2, String r3, ICoreInputAbility.OnSendParams r4, Bundle r5, boolean r6, int r7) {
        Serializable r1 = null;
        if ((r7 & 4) == 0) goto L5;
        r5 = null;
    L5:
        boolean r0 = false;
        if ((r7 & 16) == 0) goto L11;
        if (r5 == null) goto L9;
        r1 = r5.getSerializable("image_edit_data.with_mask");
    L9:
        if (r1 == null) goto L11;
        r0 = true;
    L11:
        r2.getClass();
        return f(r3, r4, r6, r0);
    }

    public final CreationSendMessageConfig d(ICoreInputAbility.OnSendParams r67, String r68, Boolean r69, e r70, Bundle r71, String r72) {
        String r3 = null;
        if (r67 == null) goto L5;
        ICoreInputAbility.OnSendParams r4 = r(r67);
    L6:
        CreationSendMessageConfig.Companion.getClass();
        CreationSendMessageConfig.a r5 = new CreationSendMessageConfig.a();
        if (r70 == null) goto L10;
        String r6 = r70.a;
        if (r6 == null) goto L10;
    L16:
        r5.l(r6);
        if (r68 != null) goto L24;
        s r7 = this.b;
        if (r7 == null) goto L23;
        ChatParam r8 = r7.c();
        if (r8 == null) goto L23;
        String r9 = r8.b;
    L25:
        r5.f(r9);
        r5.j(r70);
        if (r4 == null) goto L28;
        String r1 = r4.getContent();
    L29:
        r5.i(r1);
        if (r4 == null) goto L32;
        String r2 = r4.getScene();
    L33:
        r5.s(r2);
        if (r4 == null) goto L36;
        String r10 = r4.getTxtScene();
    L37:
        r5.u(r10);
        if (r4 == null) goto L40;
        String r11 = r4.getEnterMethod();
    L41:
        r5.m(r11);
        if (r4 == null) goto L44;
        String r12 = r4.getPreviousPage();
    L45:
        r5.r(r12);
        if (r4 == null) goto L48;
        Integer r13 = Integer.valueOf(r4.getActionInstruction());
    L49:
        r5.d(r13);
        if (r4 == null) goto L52;
        Map r14 = r4.getActionBarInstructionMap();
    L53:
        r5.c(r14);
        if (r4 == null) goto L56;
        AttachmentInfo r15 = r4.getAttachment();
    L57:
        r5.e(r15);
        if (r4 == null) goto L60;
        CustomMultiAttachmentInfo r16 = r4.getCustomMultiAttachment();
    L61:
        r5.k(r16);
        if (r71 == null) goto L64;
        Serializable r17 = r71.getSerializable("image_edit_data.with_mask");
    L66:
        if ((r17 instanceof ImageEditDataWithMask) == false) goto L68;
        ImageEditDataWithMask r19 = (ImageEditDataWithMask) r17;
    L69:
        CreationSendMessageConfig r18 = CreationSendMessageConfig.copy$default(r5.a, null, null, null, null, null, null, null, null, null, null, null, null, r19, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134213631, null);
        r5.a = r18;
        r5.a = CreationSendMessageConfig.copy$default(r18, null, null, null, null, null, null, null, null, null, null, null, null, null, r69, null, null, null, null, null, null, null, false, null, null, false, false, null, 134209535, null);
        r5.n(this.e);
        if (r4 == null) goto L72;
        Map r20 = r4.messageExt;
    L73:
        r5.q(r20);
        s r21 = this.b;
        if (r21 == null) goto L78;
        ICoreInputAbility.SendMessageTrackExtMap r22 = r21.n();
        if (r22 == null) goto L78;
        Map<String, String> r23 = r22.a;
    L79:
        r5.t(u(r23));
        if (r72 != null) goto L84;
        if (r4 == null) goto L83;
        String r25 = r4.getCreationSendTraceId();
    L85:
        r5.a = CreationSendMessageConfig.copy$default(r5.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r25, null, null, false, null, null, false, false, null, 133955583, null);
        boolean r24 = false;
        if (r4 != null) goto L88;
    L90:
        boolean r26 = false;
    L91:
        r5.p(r26);
        if (r4 == null) goto L94;
        String r27 = r4.getLocalInterceptInfo();
    L95:
        r5.o(r27);
        if (r4 != null) goto L98;
    L100:
        boolean r32 = false;
    L101:
        r5.a = CreationSendMessageConfig.copy$default(r5.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, r32, false, null, 117440511, null);
        if (r4 != null) goto L104;
    L106:
        r5.h(r24);
        if (r4 == null) goto L109;
        r3 = r4.getLyricCreateType();
    L109:
        r5.a = CreationSendMessageConfig.copy$default(r5.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, false, r3, 67108863, null);
        if (r4 == null) goto L113;
        ChatPageContext r28 = r4.chatPageContext;
        if (r28 == null) goto L113;
    L114:
        r5.g(r28);
        return r5.a;
    L113:
        r28 = (ChatPageContext) s1a.d.a(this.a).a(ChatPageContext.class);
        goto L114
    L104:
        if (r4.clearInputContent != true) goto L106;
        r24 = true;
        goto L106
    L98:
        if (r4.isReedit() != true) goto L100;
        r32 = true;
        goto L101
    L94:
        r27 = null;
        goto L95
    L88:
        if (r4.getLocalIntercepted() != true) goto L90;
        r26 = true;
        goto L91
    L83:
        r25 = null;
        goto L85
    L84:
        r25 = r72;
    L78:
        r23 = null;
        goto L79
    L72:
        r20 = null;
        goto L73
    L68:
        r19 = null;
        goto L69
    L64:
        r17 = null;
        goto L66
    L60:
        r16 = null;
        goto L61
    L56:
        r15 = null;
        goto L57
    L52:
        r14 = null;
        goto L53
    L48:
        r13 = null;
        goto L49
    L44:
        r12 = null;
        goto L45
    L40:
        r11 = null;
        goto L41
    L36:
        r10 = null;
        goto L37
    L32:
        r2 = null;
        goto L33
    L28:
        r1 = null;
    L23:
        r9 = null;
        goto L25
    L24:
        r9 = r68;
    L10:
        s r29 = this.b;
        if (r29 == null) goto L15;
        ChatParam r30 = r29.c();
        if (r30 == null) goto L15;
        r6 = r30.a;
    L15:
        r6 = null;
        goto L16
    L5:
        r4 = null;
        goto L6
    }

    public final Object h(boolean r17, boolean r18, e r19, ICoreInputAbility.OnSendParams r20, boolean r21, Continuation<? super Boolean> r22) {
        if ((r22 instanceof CreatePageSendMessageProcessor$closeExistingChatHostBelowCreationHostIfNeeded$1) == false) goto L7;
        CreatePageSendMessageProcessor$closeExistingChatHostBelowCreationHostIfNeeded$1 r3 = (CreatePageSendMessageProcessor$closeExistingChatHostBelowCreationHostIfNeeded$1) r22;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L74:
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r1 = r3.Z$0;
        final Context r7 = (Context) r3.L$2;
        ICoreInputAbility.OnSendParams r10 = (ICoreInputAbility.OnSendParams) r3.L$1;
        e r11 = (e) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L67:
        if (ICreationWorkflowService.a.a0(this.a.getContext(), 0, new com.larus.uaigc.createpage.processor.a(r7)) == false) goto L69;
        MutableSharedFlow<CreationSendUiEvent> r8 = ty9.a.a;
        ty9.a.a(g(this, r11.a, r10, null, r1, 20));
        this.g = true;
        r3.L$0 = null;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.label = 2;
        if (DelayKt.delay(300, r3) != r5) goto L74;
        return r5;
    L69:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r2);
        if (r17 == false) goto L78;
        if (r18 == true) goto L78;
        int r9 = com.larus.uaigc.applet.a.a;
        Context r12 = this.a.getContext();
        Intrinsics.checkNotNullParameter(r12, "currentContext");
        r7 = IAICreationAppletHostService.a.v(r12);
        if (r7 == this.a.getContext()) goto L76;
        if ((r7 instanceof d4) == false) goto L76;
        d4 r13 = (d4) r7;
        String r14 = r19.a;
        if (r14 != null) goto L28;
    L31:
        boolean r15 = true;
    L32:
        if (r15 == false) goto L34;
        boolean r16 = false;
    L56:
        if (r16 == false) goto L58;
        ICoreInputAbility r23 = this.c;
        if (r23 == null) goto L62;
        r23.qp(false);
        Boxing.boxBoolean(true);
    L62:
        r3.L$0 = r19;
        r3.L$1 = r20;
        r3.L$2 = r7;
        r3.Z$0 = r21;
        r3.label = 1;
        if (DelayKt.delay(120, r3) != r5) goto L65;
        return r5;
    L65:
        r11 = r19;
        r1 = r21;
        r10 = r20;
        goto L67
    L58:
        return Boxing.boxBoolean(false);
    L34:
        t1a.b r24 = r13.getVContext();
        if (r24 == null) goto L54;
        y r110 = r24.getAbility(y.class);
        if (r110 == null) goto L47;
        String r111 = r110.Y1();
        if (r111 == null) goto L47;
        if (o0.d(r111) == true) goto L45;
        r111 = null;
    L45:
        if (r111 == null) goto L47;
    L55:
        FLogger.a.i("CreatePageSendMessageProcessor", "check existing chat host below creation host, target=" + r14 + ", current=" + r111);
        r16 = Intrinsics.areEqual(r14, r111);
    L47:
        de8.c r25 = r24.a(de8.c.class);
        if (r25 == null) goto L54;
        r111 = r25.h();
        if (r111 == null) goto L54;
        if (o0.d(r111) == true) goto L55;
    L54:
        r111 = null;
        goto L55
    L28:
        if (r14.length() == 0) goto L31;
        r15 = false;
    L76:
        return Boxing.boxBoolean(false);
    L78:
        return Boxing.boxBoolean(false);
    L7:
        r3 = new CreatePageSendMessageProcessor$closeExistingChatHostBelowCreationHostIfNeeded$1(this, r22);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v12, types: [int] */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v19, types: [int] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v11, types: [int] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v8 */
    public final Object q(ICoreInputAbility.OnSendParams r26, Bundle r27, Bundle r28, boolean r29, String r30, Continuation<? super Boolean> r31) {
        CreatePageSendMessageProcessor r11 = this;
        if ((r31 instanceof CreatePageSendMessageProcessor$routeToChatPageOptAndWait$1) == false) goto L7;
        CreatePageSendMessageProcessor$routeToChatPageOptAndWait$1 r1 = (CreatePageSendMessageProcessor$routeToChatPageOptAndWait$1) r31;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        CreatePageSendMessageProcessor$routeToChatPageOptAndWait$1 r12 = r1;
        Object r0 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r12.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r0);
        boolean r16 = true;
    L156:
        return Boxing.boxBoolean(r16);
    L13:
        boolean r3 = r12.Z$2;
        int r4 = r12.I$0;
        boolean r5 = r12.Z$1;
        CreationSendMessageConfig r6 = (CreationSendMessageConfig) r12.L$6;
        String r7 = (String) r12.L$5;
        e r8 = (e) r12.L$4;
        String r9 = (String) r12.L$3;
        Bundle r10 = (Bundle) r12.L$2;
        Bundle r14 = (Bundle) r12.L$1;
        ICoreInputAbility.OnSendParams r15 = (ICoreInputAbility.OnSendParams) r12.L$0;
        ResultKt.throwOnFailure(r0);
        boolean r17 = r3;
        String r18 = r7;
        Bundle r19 = r14;
        Object r20 = r13;
        r16 = true;
        boolean r110 = r5;
        e r21 = r8;
        Bundle r22 = r10;
        ?? r23 = r4;
    L124:
        if (((Boolean) r0).booleanValue() == true) goto L126;
        if (r23 == 0) goto L129;
        int r24 = com.larus.uaigc.applet.a.a;
        Context r25 = r11.a.getContext();
        Intrinsics.checkNotNullParameter(r25, "currentContext");
        Context r32 = IAICreationAppletHostService.a.v(r25);
    L130:
        Context r33 = r32;
        if (r23 != 0) goto L133;
    L135:
        boolean r111 = false;
    L136:
        Object r34 = r20;
        E(r33, r15, r17, r111, r19, r22, r21, r18, r6.getClearInputContent());
        ICoreInputAbility r35 = r11.c;
        if (r35 == null) goto L140;
        r35.qp(false);
        Boxing.boxBoolean(r16);
    L140:
        if (r110 == false) goto L146;
        if (r111 == false) goto L146;
        r12.L$0 = null;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.L$3 = null;
        r12.L$4 = null;
        r12.L$5 = null;
        r12.L$6 = null;
        r12.label = 6;
        if (DelayKt.delay(300, r12) != r34) goto L156;
        return r34;
    L146:
        if (r110 == false) goto L151;
        if (r17 == false) goto L151;
        r12.L$0 = null;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.L$3 = null;
        r12.L$4 = null;
        r12.L$5 = null;
        r12.L$6 = null;
        r12.label = 7;
        if (DelayKt.delay(300, r12) != r34) goto L156;
        return r34;
    L151:
        if (r17 == true) goto L156;
        r12.L$0 = null;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.L$3 = null;
        r12.L$4 = null;
        r12.L$5 = null;
        r12.L$6 = null;
        r12.label = 8;
        if (DelayKt.delay(500, r12) != r34) goto L156;
        return r34;
    L133:
        if (r33 == r11.a.getContext()) goto L135;
        r111 = true;
        goto L136
    L129:
        r32 = r11.a.getContext();
        goto L130
    L126:
        return Boxing.boxBoolean(r16);
    L14:
        boolean r36 = r12.Z$2;
        int r37 = r12.I$0;
        boolean r38 = r12.Z$1;
        boolean r39 = r12.Z$0;
        CreationSendMessageConfig r40 = (CreationSendMessageConfig) r12.L$6;
        String r41 = (String) r12.L$5;
        e r42 = (e) r12.L$4;
        String r43 = (String) r12.L$3;
        Bundle r44 = (Bundle) r12.L$2;
        Bundle r112 = (Bundle) r12.L$1;
        ICoreInputAbility.OnSendParams r113 = (ICoreInputAbility.OnSendParams) r12.L$0;
        ResultKt.throwOnFailure(r0);
        boolean r114 = r38;
        Bundle r45 = r112;
        r17 = r36;
        ICoreInputAbility.OnSendParams r46 = r113;
        ?? r115 = r37;
        boolean r47 = r39;
        Bundle r48 = r44;
        CreationSendMessageConfig r49 = r40;
        String r50 = r43;
        String r51 = r41;
        e r52 = r42;
    L112:
        if (((Boolean) r0).booleanValue() == true) goto L114;
        r16 = true;
        if (r115 == 0) goto L118;
        boolean r53 = true;
    L119:
        final ICoreInputAbility.OnSendParams r210 = r46;
        Object r116 = r13;
        final Bundle r211 = r45;
        final boolean r54 = r17;
        final Bundle r212 = r48;
        final String r310 = r50;
        final e r117 = r52;
        final boolean r55 = r47;
        final String r118 = r51;
        final CreationSendMessageConfig r213 = r49;
        r110 = r114;
        Function2<? super Context, ? super Boolean, Unit> r56 = new c(this, r210, r54, r211, r212, r55, r310, r117, r118, r213);
        r12.L$0 = r210;
        r12.L$1 = r211;
        r12.L$2 = r212;
        r12.L$3 = r310;
        r21 = r117;
        r12.L$4 = r21;
        r18 = r118;
        r12.L$5 = r18;
        r12.L$6 = r213;
        r12.Z$0 = r47;
        r12.Z$1 = r110;
        r12.I$0 = r115;
        r12.Z$2 = r17;
        r12.label = 5;
        r11 = this;
        Object r57 = r11.n(r53, r56, r12);
        r20 = r116;
        if (r57 != r20) goto L122;
        return r20;
    L122:
        r6 = r213;
        r22 = r212;
        r15 = r210;
        r19 = r211;
        r0 = r57;
        r23 = r115;
        goto L124
    L118:
        r53 = false;
        goto L119
    L114:
        return Boxing.boxBoolean(true);
    L15:
        boolean r58 = r12.Z$2;
        int r59 = r12.I$0;
        boolean r60 = r12.Z$1;
        boolean r61 = r12.Z$0;
        CreationSendMessageConfig r62 = (CreationSendMessageConfig) r12.L$6;
        String r63 = (String) r12.L$5;
        e r64 = (e) r12.L$4;
        String r65 = (String) r12.L$3;
        Bundle r66 = (Bundle) r12.L$2;
        Bundle r119 = (Bundle) r12.L$1;
        ICoreInputAbility.OnSendParams r120 = (ICoreInputAbility.OnSendParams) r12.L$0;
        ResultKt.throwOnFailure(r0);
        String r121 = r63;
        String r67 = r65;
        boolean r68 = r58;
        ?? r69 = r59;
        ICoreInputAbility.OnSendParams r70 = r120;
        boolean r122 = r61;
        Object r71 = r13;
        e r123 = r64;
        CreationSendMessageConfig r72 = r62;
        Bundle r73 = r66;
        boolean r124 = r60;
        Bundle r74 = r119;
    L101:
        if (((Boolean) r0).booleanValue() == false) goto L103;
        if (r69 == 0) goto L106;
        boolean r75 = true;
    L107:
        boolean r125 = r72.getClearInputContent();
        r12.L$0 = r70;
        r12.L$1 = r74;
        r12.L$2 = r73;
        r12.L$3 = r67;
        r12.L$4 = r123;
        r12.L$5 = r121;
        r12.L$6 = r72;
        r12.Z$0 = r122;
        r12.Z$1 = r124;
        r12.I$0 = r69;
        r12.Z$2 = r68;
        r12.label = 4;
        ICoreInputAbility.OnSendParams r126 = r70;
        Bundle r127 = r74;
        e r76 = r123;
        e r214 = r123;
        r13 = r71;
        Bundle r215 = r73;
        String r128 = r67;
        r0 = h(r75, r68, r76, r126, r125, r12);
        if (r0 != r13) goto L110;
        return r13;
    L110:
        r52 = r214;
        r50 = r128;
        r46 = r126;
        r45 = r127;
        r48 = r215;
        boolean r216 = r68;
        r49 = r72;
        r51 = r121;
        r114 = r124;
        r17 = r216;
        boolean r217 = r122;
        r115 = r69;
        r47 = r217;
        goto L112
    L106:
        r75 = false;
        goto L107
    L103:
        return Boxing.boxBoolean(false);
    L16:
        int r77 = r12.I$1;
        boolean r78 = r12.Z$2;
        int r79 = r12.I$0;
        boolean r80 = r12.Z$1;
        boolean r81 = r12.Z$0;
        e r82 = (e) r12.L$4;
        String r83 = (String) r12.L$3;
        Bundle r84 = (Bundle) r12.L$2;
        Bundle r85 = (Bundle) r12.L$1;
        ICoreInputAbility.OnSendParams r129 = (ICoreInputAbility.OnSendParams) r12.L$0;
        ResultKt.throwOnFailure(r0);
        ?? r86 = r79;
    L80:
        String r87 = (String) r0;
        if (r87 == null) goto L83;
        r122 = r81;
        String r88 = r83;
        e r89 = r82;
        String r90 = r87;
        Bundle r218 = r84;
        r68 = r78;
        ICoreInputAbility.OnSendParams r91 = r129;
        r124 = r80;
        Bundle r92 = r218;
        Bundle r219 = r85;
        ?? r93 = r86;
        Bundle r94 = r219;
    L86:
        if (r77 == 0) goto L95;
        s r95 = r11.b;
        if (r95 == null) goto L95;
        ChatParam r96 = r95.c();
        if (r96 == null) goto L95;
        String r97 = r96.b;
        if (r97 == null) goto L95;
        String r130 = r97;
    L96:
        ICoreInputAbility.OnSendParams r131 = r91;
        Bundle r132 = r94;
        Bundle r220 = r92;
        String r221 = r88;
        String r133 = r90;
        CreationSendMessageConfig r98 = d(r91, r130, Boxing.boxBoolean(r122), r89, r220, r221);
        r12.L$0 = r131;
        r12.L$1 = r132;
        r12.L$2 = r220;
        r12.L$3 = r221;
        r12.L$4 = r89;
        r12.L$5 = r133;
        r12.L$6 = r98;
        r12.Z$0 = r122;
        r12.Z$1 = r124;
        r12.I$0 = r93 == true ? 1 : 0;
        r12.Z$2 = r68;
        r12.label = 3;
        Object r99 = v(r98, "routeToChatPageOptAndWait", r12);
        r71 = r13;
        if (r99 != r71) goto L99;
        return r71;
    L99:
        r74 = r132;
        r123 = r89;
        r72 = r98;
        r73 = r220;
        r0 = r99;
        r70 = r131;
        r121 = r133;
        r67 = r221;
        r69 = r93;
    L95:
        r130 = r90;
        goto L96
    L83:
        return Boxing.boxBoolean(false);
    L17:
        r77 = r12.I$1;
        r78 = r12.Z$2;
        int r100 = r12.I$0;
        r80 = r12.Z$1;
        r81 = r12.Z$0;
        r90 = (String) r12.L$4;
        String r101 = (String) r12.L$3;
        Bundle r102 = (Bundle) r12.L$2;
        r85 = (Bundle) r12.L$1;
        r129 = (ICoreInputAbility.OnSendParams) r12.L$0;
        ResultKt.throwOnFailure(r0);
        String r103 = r101;
        Bundle r104 = r102;
        ?? r105 = r100;
    L70:
        e r106 = (e) r0;
        if (r106 != null) goto L75;
        return Boxing.boxBoolean(false);
    L75:
        if (o.a() == false) goto L85;
        LocalSubConvHelper r107 = LocalSubConvHelper.a;
        r12.L$0 = r129;
        r12.L$1 = r85;
        r12.L$2 = r104;
        r12.L$3 = r103;
        r12.L$4 = r106;
        r12.Z$0 = r81;
        r12.Z$1 = r80;
        r12.I$0 = r105;
        r12.Z$2 = r78;
        r12.I$1 = r77;
        r12.label = 2;
        Object r108 = r107.f(r106, r12);
        if (r108 != r13) goto L79;
        return r13;
    L79:
        r82 = r106;
        r0 = r108;
        String r222 = r103;
        r84 = r104;
        r83 = r222;
        r86 = r105;
        goto L80
    L85:
        r122 = r81;
        r88 = r103;
        r68 = r78;
        r91 = r129;
        r124 = r80;
        r92 = r104;
        r89 = r106;
        Bundle r223 = r85;
        r93 = r105;
        r94 = r223;
        goto L86
    L18:
        ResultKt.throwOnFailure(r0);
        int r109 = CreationHostUiPolicy.f;
        s r134 = r11.b;
        if (r134 == null) goto L21;
        Bundle r135 = r134.a;
    L22:
        CreationHostUiPolicy r136 = CreationHostUiPolicy.a.a(r135);
        if (r136.a == false) goto L25;
    L28:
        boolean r137 = true;
    L29:
        if (r137 == false) goto L48;
        s r138 = r11.b;
        if (r138 != null) goto L33;
    L35:
        boolean r139 = false;
    L36:
        if (r139 == true) goto L45;
        s r140 = r11.b;
        if (r140 == null) goto L40;
        Bundle r141 = r140.a;
    L42:
        if (CreationHostUiPolicy.a.a(r141).d == true) goto L45;
        boolean r142 = false;
    L46:
        if (r142 == false) goto L48;
        ?? r143 = 1;
    L49:
        r78 = l();
        FLogger.a.i("CreatePageSendMessageProcessor", "route send creation message to chat page, useHostRoute=" + r137 + ", openBelowHost=" + r143 + ", openInSideBar=" + r78);
        e0 r144 = (e0) AuthModelDelegate.b.e().getValue();
        if (r144 == null) goto L54;
        LaunchInfo r145 = r144.a;
        if (r145 == null) goto L54;
        r90 = r145.W();
    L55:
        s r146 = r11.b;
        if (r146 != null) goto L58;
    L60:
        boolean r147 = false;
    L61:
        if (r147 == true) goto L63;
    L65:
        int r148 = 0;
    L66:
        r12.L$0 = r26;
        r12.L$1 = r27;
        r104 = r28;
        r12.L$2 = r104;
        r103 = r30;
        r12.L$3 = r103;
        r12.L$4 = r90;
        r12.Z$0 = r29;
        r12.Z$1 = r137;
        r12.I$0 = r143;
        r12.Z$2 = r78;
        r12.I$1 = r148;
        r12.label = 1;
        Object r149 = r11.j(r12);
        if (r149 != r13) goto L69;
        return r13;
    L69:
        r80 = r137;
        r0 = r149;
        r129 = r26;
        int r224 = r148;
        r105 = r143;
        r77 = r224;
        r85 = r27;
        r81 = r29;
        goto L70
    L63:
        if (z2.a.f1().d() == false) goto L65;
        r148 = 1;
        goto L66
    L58:
        if (r146.A() != true) goto L60;
        r147 = true;
    L54:
        r90 = null;
        goto L55
    L40:
        r141 = null;
    L45:
        r142 = true;
        goto L46
    L33:
        if (r138.j() != true) goto L35;
        r139 = true;
    L48:
        r143 = 0;
        goto L49
    L25:
        if (r136.d == true) goto L28;
        r137 = false;
        goto L29
    L21:
        r135 = null;
        goto L22
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r1 = new CreatePageSendMessageProcessor$routeToChatPageOptAndWait$1(r11, r31);
        goto L8
    }

    public final Object w(ICoreInputAbility.OnSendParams r15, Bundle r16, boolean r17, int r18, String r19, Continuation<? super Unit> r20) {
        if ((r20 instanceof CreatePageSendMessageProcessor$sendWithCreationMessageAndSetDoSameLandingResult$1) == false) goto L7;
        CreatePageSendMessageProcessor$sendWithCreationMessageAndSetDoSameLandingResult$1 r1 = (CreatePageSendMessageProcessor$sendWithCreationMessageAndSetDoSameLandingResult$1) r20;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        CreatePageSendMessageProcessor$sendWithCreationMessageAndSetDoSameLandingResult$1 r8 = r1;
        Object r0 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        CreationDoSameNotifyInfo r11 = null;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        int r4 = r8.I$0;
        ResultKt.throwOnFailure(r0);
    L29:
        if (((Boolean) r0).booleanValue() == false) goto L31;
        Intent r5 = new Intent();
        s r6 = this.b;
        if (r6 == null) goto L35;
        r11 = r6.e();
    L35:
        r5.putExtra("creation_dosame_notify_info", r11);
        Unit r7 = Unit.INSTANCE;
        z(r4, r5);
        this.f.invoke();
        return Unit.INSTANCE;
    L31:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r10 = r8.I$0;
        boolean r12 = r8.Z$0;
        String r13 = (String) r8.L$2;
        Bundle r14 = (Bundle) r8.L$1;
        ICoreInputAbility.OnSendParams r21 = (ICoreInputAbility.OnSendParams) r8.L$0;
        ResultKt.throwOnFailure(r0);
        int r110 = r10;
        ICoreInputAbility.OnSendParams r22 = r21;
        String r23 = r13;
    L20:
        e r24 = (e) r0;
        if (r24 == null) goto L23;
        CreationSendMessageConfig r25 = e(this, r22, Boxing.boxBoolean(r12), r24, r14, r23, 2);
        r8.L$0 = null;
        r8.L$1 = null;
        r8.L$2 = null;
        r8.I$0 = r110;
        r8.label = 2;
        r0 = v(r25, "sendWithCreationMessageAndSetDoSameLandingResult", r8);
        if (r0 != r9) goto L27;
        return r9;
    L27:
        r4 = r110;
        goto L29
    L23:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r0);
        r8.L$0 = r15;
        r8.L$1 = r16;
        r8.L$2 = r19;
        r8.Z$0 = r17;
        r8.I$0 = r18;
        r8.label = 1;
        Object r26 = j(r8);
        if (r26 != r9) goto L19;
        return r9;
    L19:
        r110 = r18;
        r23 = r19;
        r22 = r15;
        r0 = r26;
        r12 = r17;
        r14 = r16;
    L7:
        r1 = new CreatePageSendMessageProcessor$sendWithCreationMessageAndSetDoSameLandingResult$1(this, r20);
        goto L8
    }

    public static /* synthetic */ CreationSendMessageConfig e(CreatePageSendMessageProcessor r7, ICoreInputAbility.OnSendParams r8, Boolean r9, e r10, Bundle r11, String r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        Boolean r3 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        e r4 = null;
    L11:
        if ((r13 & 16) == 0) goto L13;
        Bundle r5 = null;
    L15:
        if ((r13 & 32) == 0) goto L17;
        String r6 = null;
    L19:
        return r7.d(r8, null, r3, r4, r5, r6);
    L17:
        r6 = r12;
        goto L19
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    @Override // ny9.d
    public final Object b(Bundle r14, String r15, String r16, boolean r17, String r18, Map<String, String> r19, String r20, Continuation<? super Unit> r21) {
        if ((r21 instanceof CreatePageSendMessageProcessor$sendWithData$1) == false) goto L7;
        CreatePageSendMessageProcessor$sendWithData$1 r1 = (CreatePageSendMessageProcessor$sendWithData$1) r21;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        CreatePageSendMessageProcessor$sendWithData$1 r9 = r1;
        Object r0 = r9.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r9.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L38:
        this.f.invoke();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (B() == false) goto L19;
        r9.label = 1;
        if (p(this, null, r16, r15, r14, r18, r17, r19, r20, r9, 1) != r12) goto L38;
        return r12;
    L19:
        s r4 = this.b;
        ICoreInputAbility.SendMessageTrackExtMap r5 = null;
        if (r4 == null) goto L26;
        Bundle r6 = r4.a;
        if (r6 == null) goto L24;
        boolean r7 = r6.getBoolean("need_finish_current_create_page");
    L25:
        Boolean r8 = Boxing.boxBoolean(r7);
    L27:
        Intent r10 = new Intent();
        r10.putExtra("actionbar_instruction_template", r15);
        r10.putExtra("arg_need_finish_page", r8);
        r10.putExtra("end_modify", true);
        r10.putExtra("result_from", "creation");
        r10.putExtra("actionbar_instruction_prompt", r18);
        Pair[] r11 = new Pair[1];
        u r13 = this.e;
        if (r13 == null) goto L30;
        Bundle r22 = r13.c;
    L31:
        r11[0] = TuplesKt.to("instruction_hit_point_params", r22);
        r10.putExtra("instruction_hit_point_params", f.c(r11));
        r10.putExtra("actionbar_file_path", r16);
        r10.putExtra("actionbar_has_image_preprocessed", r17);
        Map<String, String> r23 = s(r19);
        if (r23 != null) goto L34;
        r23 = MapsKt.emptyMap();
    L34:
        r10.putExtra("actionbar_instruction_message_ext_map", new ICoreInputAbility.MessageExtMap(r23));
        s r24 = this.b;
        if (r24 == null) goto L37;
        r5 = r24.n();
    L37:
        r10.putExtra("actionbar_instruction_send_message_track_ext_map", t(r5));
        r10.putExtra("creation_send_trace_id", r20);
        r10.putExtras(r14);
        Unit r25 = Unit.INSTANCE;
        z(-1, r10);
        goto L38
    L30:
        r22 = null;
        goto L31
    L24:
        r7 = false;
        goto L25
    L26:
        r8 = null;
    L7:
        r1 = new CreatePageSendMessageProcessor$sendWithData$1(this, r21);
        goto L8
    }

    public final void E(Context r17, ICoreInputAbility.OnSendParams r18, boolean r19, boolean r20, Bundle r21, Bundle r22, e r23, String r24, boolean r25) {
        FLogger.a.i("CreatePageSendMessageProcessor", "open chat page opt, openInSideBar=" + r19 + ", openBelowApplet=" + r20 + ", routeContext=" + r17.getClass().getSimpleName());
        s r1 = this.b;
        boolean r10 = true;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
    L12:
        boolean r12 = false;
    L13:
        String r3 = null;
        if (o.a() == true) goto L21;
        e r4 = (e) AuthModelDelegate.b.y().getValue();
        if (r4 == null) goto L21;
        ConversationPage r5 = r4.g;
        if (r5 == null) goto L21;
        List r13 = r5.getPageList();
    L22:
        boolean r14 = l0.a(r13);
        Pair[] r15 = new Pair[4];
        if (r12 == false) goto L30;
        s r6 = this.b;
        if (r6 == null) goto L30;
        ChatParam r7 = r6.c();
        if (r7 == null) goto L30;
        String r8 = r7.b;
        if (r8 == null) goto L30;
    L31:
        r15[0] = TuplesKt.to("argBotId", r8);
        CreationHalfFragment r9 = s1a.a.c(this.a);
        if ((r9 instanceof CreationHalfFragment) == false) goto L34;
        CreationHalfFragment r11 = r9;
    L35:
        if (r11 == null) goto L50;
        Bundle r16 = r11.getArguments();
        if (r16 == null) goto L39;
        ChatParam r26 = (ChatParam) r16.getParcelable("chat_param");
    L41:
        if ((r26 instanceof ChatParam) == true) goto L44;
        r26 = null;
    L44:
        if (r26 == null) goto L46;
        String r27 = r26.c;
    L47:
        if (r27 == null) goto L50;
        r3 = r27;
    L53:
        r15[1] = TuplesKt.to("argPreviousPage", r3);
        if (r19 == false) goto L56;
        String r0 = "1";
    L57:
        r15[2] = TuplesKt.to("is_side_bar", r0);
        r15[3] = TuplesKt.to("creation_send_ui_event", g(this, r23.a, r18, r22, r25, 16));
        Bundle r28 = f.c(r15);
        if (r21 == null) goto L60;
        r21.remove("image_edit_data.with_mask");
        r28.putAll(r21);
    L60:
        if (r20 == false) goto L63;
        r28.putBoolean("route_native_below_ai_creation_applet", true);
        r28.putBoolean("disable_activity_transition", true);
    L63:
        if (o0.d(r23.a) == false) goto L65;
        r28.putString("argConversationId", r23.a);
    L65:
        if (r12 == false) goto L67;
        String r29 = "//flow/chat_page_double_tab";
    L70:
        com.bytedance.router.i r30 = SmartRouter.buildRoute(r17, r29);
        r30.c.putExtras(r28);
        if (r20 == false) goto L73;
        int r31 = 2130772399;
    L74:
        r30.d = r31;
        r30.e = 2130772399;
        if (r13 == null) goto L94;
        if (r14 == false) goto L94;
        AuthModelDelegate r32 = AuthModelDelegate.b;
        e r33 = (e) r32.y().getValue();
        if (r33 == null) goto L84;
        ConversationPage r34 = r33.g;
        if (r34 == null) goto L84;
        Integer r35 = r34.getDefaultStatus();
        if (r35 == null) goto L84;
        int r36 = r35.intValue();
    L85:
        e r37 = (e) r32.y().getValue();
        if (r37 == null) goto L92;
        ConversationPage r38 = r37.g;
        if (r38 == null) goto L92;
        Integer r39 = r38.getPagePosition();
        if (r39 == null) goto L92;
        int r40 = r39.intValue();
    L93:
        ArrayList r41 = new ArrayList();
        r41.addAll(r13);
        Unit r42 = Unit.INSTANCE;
        r30.c.putExtra("argument_multi_tab_list", r41);
        r30.c.putExtra("argument_multi_tab_default_tab", r36);
        r30.h("argument_multi_tab_title_style", r40);
    L92:
        r40 = 0;
    L84:
        r36 = PageType.Chat.getType();
    L94:
        s r43 = this.b;
        if (r43 == null) goto L102;
        Bundle r44 = r43.b();
        if (r44 == null) goto L99;
        boolean r45 = r44.getBoolean("open_new_chat_page_on_send_with_clear_top");
    L100:
        if (r45 != true) goto L102;
    L103:
        if (r10 == false) goto L105;
        r30.a(67108864);
    L105:
        r30.d();
        return;
    L99:
        r45 = false;
    L102:
        r10 = false;
        goto L103
    L73:
        r31 = 2130772401;
        goto L74
    L67:
        if (r14 == false) goto L69;
        r29 = "//flow/chat_multi_tab";
        goto L70
    L69:
        r29 = "//flow/chat_page";
        goto L70
    L56:
        r0 = "0";
        goto L57
    L46:
        r27 = null;
        goto L47
    L39:
        r26 = null;
    L50:
        u r46 = this.e;
        if (r46 == null) goto L53;
        r3 = r46.q();
        goto L53
    L34:
        r11 = null;
    L30:
        r8 = r24;
    L21:
        r13 = null;
        goto L22
    L10:
        if (z2.a.f1().d() == false) goto L12;
        r12 = true;
        goto L13
    L5:
        if (r1.A() != true) goto L7;
        r2 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.larus.uaigc.createpage.processor.CreatePageSendMessageProcessor] */
    public final Object o(final ICoreInputAbility.OnSendParams r21, final String r22, final String r23, final Bundle r24, final String r25, final boolean r26, final Map<String, String> r27, final String r28, Continuation<? super Unit> r29) {
        if ((r29 instanceof CreatePageSendMessageProcessor$routeToChatPageAndWait$1) == false) goto L7;
        CreatePageSendMessageProcessor$routeToChatPageAndWait$1 r1 = (CreatePageSendMessageProcessor$routeToChatPageAndWait$1) r29;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        CreatePageSendMessageProcessor$routeToChatPageAndWait$1 r13 = r1;
        Object r0 = r13.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r13.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        ResultKt.throwOnFailure(r0);
    L92:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r0);
    L86:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r0);
    L78:
        return Unit.INSTANCE;
    L19:
        boolean r4 = r13.Z$2;
        int r5 = r13.I$0;
        boolean r6 = r13.Z$1;
        boolean r7 = r13.Z$0;
        String r8 = (String) r13.L$6;
        Map<String, String> r9 = (Map) r13.L$5;
        String r10 = (String) r13.L$4;
        Bundle r11 = (Bundle) r13.L$3;
        String r12 = (String) r13.L$2;
        String r15 = (String) r13.L$1;
        ICoreInputAbility.OnSendParams r16 = (ICoreInputAbility.OnSendParams) r13.L$0;
        ResultKt.throwOnFailure(r0);
        boolean r17 = r6;
        String r18 = r8;
        Bundle r19 = r11;
        String r20 = r15;
        boolean r30 = r7;
        Map<String, String> r110 = r9;
        String r31 = r12;
        Object r111 = r14;
        boolean r112 = r4;
    L56:
        if (((Boolean) r0).booleanValue() == true) goto L58;
        if (r5 == 0) goto L61;
        int r32 = com.larus.uaigc.applet.a.a;
        Context r33 = this.a.getContext();
        Intrinsics.checkNotNullParameter(r33, "currentContext");
        Context r34 = IAICreationAppletHostService.a.v(r33);
    L62:
        Context r35 = r34;
        if (r5 != 0) goto L65;
    L67:
        boolean r113 = false;
    L68:
        Object r114 = r111;
        D(r35, r16, r20, r31, r112, r113, r19, r10, r30, r110, r18);
        ICoreInputAbility r36 = this.c;
        if (r36 == null) goto L72;
        r36.qp(false);
        Boxing.boxBoolean(true);
    L72:
        if (r17 == false) goto L80;
        if (r113 == false) goto L80;
        r13.L$0 = null;
        r13.L$1 = null;
        r13.L$2 = null;
        r13.L$3 = null;
        r13.L$4 = null;
        r13.L$5 = null;
        r13.L$6 = null;
        r13.label = 2;
        if (DelayKt.delay(300, r13) != r114) goto L78;
        return r114;
    L80:
        if (r17 == false) goto L87;
        if (r112 == false) goto L87;
        r13.L$0 = null;
        r13.L$1 = null;
        r13.L$2 = null;
        r13.L$3 = null;
        r13.L$4 = null;
        r13.L$5 = null;
        r13.L$6 = null;
        r13.label = 3;
        if (DelayKt.delay(300, r13) != r114) goto L86;
        return r114;
    L87:
        if (r112 == true) goto L94;
        r13.L$0 = null;
        r13.L$1 = null;
        r13.L$2 = null;
        r13.L$3 = null;
        r13.L$4 = null;
        r13.L$5 = null;
        r13.L$6 = null;
        r13.label = 4;
        if (DelayKt.delay(500, r13) != r114) goto L92;
        return r114;
    L94:
        return Unit.INSTANCE;
    L65:
        if (r35 == this.a.getContext()) goto L67;
        r113 = true;
        goto L68
    L61:
        r34 = this.a.getContext();
        goto L62
    L58:
        return Unit.INSTANCE;
    L20:
        ResultKt.throwOnFailure(r0);
        int r37 = CreationHostUiPolicy.f;
        s r38 = this.b;
        if (r38 == null) goto L23;
        Bundle r39 = r38.a;
    L24:
        CreationHostUiPolicy r40 = CreationHostUiPolicy.a.a(r39);
        if (r40.a == false) goto L27;
    L30:
        boolean r115 = true;
    L31:
        if (r115 == false) goto L50;
        s r41 = this.b;
        if (r41 != null) goto L35;
    L37:
        boolean r42 = false;
    L38:
        if (r42 == true) goto L47;
        s r43 = this.b;
        if (r43 == null) goto L42;
        Bundle r44 = r43.a;
    L44:
        if (CreationHostUiPolicy.a.a(r44).d == true) goto L47;
        boolean r45 = false;
    L48:
        if (r45 == false) goto L50;
        ?? r116 = 1;
    L51:
        final boolean r117 = l();
        FLogger.a.i("CreatePageSendMessageProcessor", "route send to chat page, useHostRoute=" + r115 + ", openBelowHost=" + r116 + ", openInSideBar=" + r117);
        r112 = r117;
        Function2 r46 = new d(this, r21, r22, r23, r117, r24, r25, r26, r27, r28);
        r13.L$0 = r21;
        r13.L$1 = r22;
        r13.L$2 = r23;
        r13.L$3 = r24;
        r13.L$4 = r25;
        r13.L$5 = r27;
        r13.L$6 = r28;
        r13.Z$0 = r26;
        r13.Z$1 = r115;
        r13.I$0 = r116;
        r13.Z$2 = r112;
        r13.label = 1;
        Object r47 = n(r116, r46, r13);
        r111 = r14;
        if (r47 != r111) goto L54;
        return r111;
    L54:
        r18 = r28;
        r30 = r26;
        r17 = r115;
        r19 = r24;
        r110 = r27;
        r20 = r22;
        ?? r118 = r116;
        r16 = r21;
        r0 = r47;
        r10 = r25;
        r31 = r23;
        r5 = r118 == true ? 1 : 0;
        goto L56
    L42:
        r44 = null;
    L47:
        r45 = true;
        goto L48
    L35:
        if (r41.j() != true) goto L37;
        r42 = true;
    L50:
        r116 = 0;
        goto L51
    L27:
        if (r40.d == true) goto L30;
        r115 = false;
        goto L31
    L23:
        r39 = null;
    L7:
        r1 = new CreatePageSendMessageProcessor$routeToChatPageAndWait$1(this, r29);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object p(CreatePageSendMessageProcessor r13, ICoreInputAbility.OnSendParams r14, String r15, String r16, Bundle r17, String r18, boolean r19, Map r20, String r21, ContinuationImpl r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        ICoreInputAbility.OnSendParams r4 = null;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r23 & 8) == 0) goto L17;
        Bundle r7 = null;
    L19:
        if ((r23 & 16) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r23 & 32) == 0) goto L25;
        boolean r9 = false;
    L27:
        if ((r23 & 64) == 0) goto L29;
        Map r10 = null;
    L31:
        if ((r23 & 128) == 0) goto L33;
        String r11 = null;
    L35:
        return r13.o(r4, r5, r6, r7, r8, r9, r10, r11, r22);
    L33:
        r11 = r21;
        goto L35
    L29:
        r10 = r20;
        goto L31
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r7 = r17;
        goto L19
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    public final void D(Context r17, ICoreInputAbility.OnSendParams r18, String r19, String r20, boolean r21, boolean r22, Bundle r23, String r24, boolean r25, Map<String, String> r26, String r27) {
        FLogger.a.i("CreatePageSendMessageProcessor", "open chat page, openInSideBar=" + r21 + ", openBelowApplet=" + r22 + ", routeContext=" + r17.getClass().getSimpleName());
        AuthModelDelegate r5 = AuthModelDelegate.b;
        e0 r6 = (e0) r5.e().getValue();
        if (r6 == null) goto L7;
        LaunchInfo r7 = r6.a;
        if (r7 == null) goto L7;
        String r8 = r7.W();
    L8:
        s r9 = this.b;
        boolean r10 = true;
        if (r9 != null) goto L11;
    L13:
        boolean r11 = false;
    L14:
        if (r11 == true) goto L16;
    L18:
        boolean r12 = false;
    L20:
        if (o.a() == true) goto L27;
        e r13 = (e) r5.y().getValue();
        if (r13 == null) goto L27;
        ConversationPage r14 = r13.g;
        if (r14 == null) goto L27;
        List r15 = r14.getPageList();
    L28:
        boolean r16 = l0.a(r15);
        if (r18 == null) goto L31;
        ICoreInputAbility.OnSendParams r1 = r(r18);
    L32:
        Map<String, String> r110 = s(r26);
        s r111 = this.b;
        if (r111 == null) goto L35;
        ICoreInputAbility.SendMessageTrackExtMap r112 = r111.n();
    L36:
        ICoreInputAbility.SendMessageTrackExtMap r113 = t(r112);
        Pair[] r114 = new Pair[12];
        if (r12 == false) goto L46;
        s r28 = this.b;
        if (r28 == null) goto L46;
        ChatParam r29 = r28.c();
        if (r29 == null) goto L46;
        String r30 = r29.b;
        if (r30 == null) goto L46;
        r8 = r30;
    L46:
        r114[0] = TuplesKt.to("argBotId", r8);
        r114[1] = TuplesKt.to("auto_send_message_params", r1);
        CreationHalfChatFragment r2 = s1a.a.c(this.a);
        if ((r2 instanceof CreationHalfChatFragment) == false) goto L49;
        CreationHalfChatFragment r3 = r2;
    L51:
        if (r3 == null) goto L64;
        Bundle r4 = r3.getArguments();
        if (r4 == null) goto L55;
        ChatParam r31 = (ChatParam) r4.getParcelable("chat_param");
    L57:
        if ((r31 instanceof ChatParam) == true) goto L60;
        r31 = null;
    L60:
        if (r31 == null) goto L62;
        String r32 = r31.c;
    L63:
        if (r32 == null) goto L64;
    L85:
        r114[2] = TuplesKt.to("argPreviousPage", r32);
        if (r21 == false) goto L88;
        String r33 = "1";
    L89:
        r114[3] = TuplesKt.to("is_side_bar", r33);
        r114[4] = TuplesKt.to("actionbar_instruction_template", r20);
        r114[5] = TuplesKt.to("actionbar_instruction_prompt", r24);
        r114[6] = TuplesKt.to("actionbar_file_path", r19);
        r114[7] = TuplesKt.to("actionbar_has_image_preprocessed", Boolean.valueOf(r25));
        Pair[] r34 = new Pair[1];
        u r35 = this.e;
        if (r35 == null) goto L92;
        Bundle r36 = r35.c;
    L93:
        r34[0] = TuplesKt.to("instruction_hit_point_params", r36);
        r114[8] = TuplesKt.to("instruction_hit_point_params", f.c(r34));
        if (r110 != null) goto L96;
        r110 = MapsKt.emptyMap();
    L96:
        r114[9] = TuplesKt.to("actionbar_instruction_message_ext_map", new ICoreInputAbility.MessageExtMap(r110));
        r114[10] = TuplesKt.to("actionbar_instruction_send_message_track_ext_map", r113);
        r114[11] = TuplesKt.to("creation_send_trace_id", r27);
        Bundle r37 = f.c(r114);
        if (r23 == null) goto L99;
        r37.putAll(r23);
    L99:
        if (r22 == false) goto L101;
        r37.putBoolean("route_native_below_ai_creation_applet", true);
        r37.putBoolean("disable_activity_transition", true);
    L101:
        s r38 = this.b;
        if (r38 == null) goto L106;
        ChatParam r39 = r38.c();
        if (r39 == null) goto L106;
        String r40 = r39.a;
    L108:
        if (o0.d(r40) == false) goto L116;
        s r41 = this.b;
        if (r41 == null) goto L114;
        ChatParam r42 = r41.c();
        if (r42 == null) goto L114;
        String r43 = r42.a;
    L115:
        r37.putString("argConversationId", r43);
    L114:
        r43 = null;
    L116:
        if (r12 == false) goto L118;
        String r44 = "//flow/chat_page_double_tab";
    L121:
        com.bytedance.router.i r45 = SmartRouter.buildRoute(r17, r44);
        r45.c.putExtras(r37);
        if (r22 == false) goto L124;
        int r46 = 2130772399;
    L125:
        r45.d = r46;
        r45.e = 2130772399;
        if (r15 == null) goto L145;
        if (r16 == false) goto L145;
        e r47 = (e) r5.y().getValue();
        if (r47 == null) goto L135;
        ConversationPage r48 = r47.g;
        if (r48 == null) goto L135;
        Integer r49 = r48.getDefaultStatus();
        if (r49 == null) goto L135;
        int r50 = r49.intValue();
    L136:
        e r51 = (e) r5.y().getValue();
        if (r51 == null) goto L143;
        ConversationPage r52 = r51.g;
        if (r52 == null) goto L143;
        Integer r53 = r52.getPagePosition();
        if (r53 == null) goto L143;
        int r54 = r53.intValue();
    L144:
        ArrayList r55 = new ArrayList();
        r55.addAll(r15);
        Unit r56 = Unit.INSTANCE;
        r45.c.putExtra("argument_multi_tab_list", r55);
        r45.c.putExtra("argument_multi_tab_default_tab", r50);
        r45.h("argument_multi_tab_title_style", r54);
    L143:
        r54 = 0;
    L135:
        r50 = PageType.Chat.getType();
    L145:
        s r57 = this.b;
        if (r57 == null) goto L153;
        Bundle r58 = r57.b();
        if (r58 == null) goto L150;
        boolean r59 = r58.getBoolean("open_new_chat_page_on_send_with_clear_top");
    L151:
        if (r59 != true) goto L153;
    L154:
        if (r10 == false) goto L156;
        r45.a(67108864);
    L156:
        r45.d();
        return;
    L150:
        r59 = false;
    L153:
        r10 = false;
        goto L154
    L124:
        r46 = 2130772401;
        goto L125
    L118:
        if (r16 == false) goto L120;
        r44 = "//flow/chat_multi_tab";
        goto L121
    L120:
        r44 = "//flow/chat_page";
    L106:
        r40 = null;
        goto L108
    L92:
        r36 = null;
        goto L93
    L88:
        r33 = "0";
        goto L89
    L62:
        r32 = null;
        goto L63
    L55:
        r31 = null;
    L64:
        CreationHalfFragment r60 = s1a.a.c(this.a);
        if ((r60 instanceof CreationHalfFragment) == false) goto L67;
        CreationHalfFragment r61 = r60;
    L68:
        if (r61 == null) goto L79;
        Bundle r62 = r61.getArguments();
        if (r62 == null) goto L72;
        ChatParam r63 = (ChatParam) r62.getParcelable("chat_param");
    L74:
        if ((r63 instanceof ChatParam) == true) goto L77;
        r63 = null;
    L77:
        if (r63 == null) goto L79;
        r32 = r63.c;
    L80:
        if (r32 != null) goto L85;
        u r64 = this.e;
        if (r64 == null) goto L84;
        r32 = r64.q();
        goto L85
    L84:
        r32 = null;
        goto L85
    L72:
        r63 = null;
    L79:
        r32 = null;
        goto L80
    L67:
        r61 = null;
        goto L68
    L49:
        r3 = null;
        goto L51
    L35:
        r112 = null;
        goto L36
    L31:
        r1 = null;
    L27:
        r15 = null;
        goto L28
    L16:
        if (z2.a.f1().d() == false) goto L18;
        r12 = true;
        goto L20
    L11:
        if (r9.A() != true) goto L13;
        r11 = true;
    L7:
        r8 = null;
        goto L8
    }
}
