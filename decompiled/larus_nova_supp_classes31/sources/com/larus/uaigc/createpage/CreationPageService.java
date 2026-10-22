package com.larus.uaigc.createpage;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.CustomInputInitData;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.uaigc.applet.IAICreationAppletHostService;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u009d\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00072\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u001c2\b\u0010)\u001a\u0004\u0018\u00010\u001c2\u0006\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0002\u00102JW\u00103\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\b\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u00112\b\u0010;\u001a\u0004\u0018\u00010\u00112\b\u0010<\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u0004\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010BJ\u000e\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001c0DH\u0016J\n\u0010E\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010F\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010G\u001a\u0004\u0018\u000101H\u0002J \u0010H\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010<\u001a\u0004\u0018\u00010\u0011H\u0082@¢\u0006\u0002\u0010IJ4\u0010J\u001a\u00020\u00052$\u0010K\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010M\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050N\u0012\u0006\u0012\u0004\u0018\u00010O0LH\u0082@¢\u0006\u0002\u0010P¨\u0006Q"}, d2 = {"Lcom/larus/uaigc/createpage/CreationPageService;", "Lcom/larus/bmhome/community/ICreationPageService;", "<init>", "()V", "startCreationActivity", "", "isHalfScreenPage", "", "activity", "Landroid/app/Activity;", "item", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "openNewChatPageOnSend", "openNewChatPageOnSendWithClearTop", "template", "", "userPrompt", "refImageUrl", "refImage", "Lcom/larus/im/bean/message/Image;", "refCreateRefInfoList", "", "Lcom/larus/platform/model/creation/ResourceExt;", "refImageAlbumPath", "whiteIndexList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isReedit", "hitPointData", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "extraBundle", "Landroid/os/Bundle;", "cleaInput", "msgExtMap", "", "selectStartPosition", "selectEndPosition", "isEnterTemplate", "customInputInitData", "Lcom/larus/platform/api/creation/CustomInputInitData;", "ignoreSideBar", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "compactForsetiFragment", "Landroidx/fragment/app/Fragment;", "(ZLandroid/app/Activity;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Lcom/larus/bmhome/chat/ChatParam;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Image;Ljava/util/List;Ljava/lang/String;Ljava/util/ArrayList;ZLcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;Lcom/ixigua/lib/track/ITrackNode;Landroid/os/Bundle;ZLjava/util/Map;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/larus/platform/api/creation/CustomInputInitData;ZLcom/larus/bmhome/chat/bean/ChatPageContext;Landroidx/fragment/app/Fragment;)V", "openCreationPage", "position", "itemId", "", "instructionType", "lifecycleCoroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "previousPage", "currentPage", "enterMethod", "(Ljava/lang/Integer;Landroid/app/Activity;Ljava/lang/Long;ILandroidx/lifecycle/LifecycleCoroutineScope;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "updateActionBar", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "fetchWhiteAvatarTUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAvatarCreatedStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getIpaMainUrl", "getWhiteTUrl", "getCurBottomTabMainBotFrag", "handleOpenSchema", "(Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainBotConversationInfo", "callback", "Lkotlin/Function2;", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationPageService implements ICreationPageService {
    public CreationPageService() {
    }

    public final String d() {
        DigitalAvatarInfoManager.a.getClass();
        return (String) DigitalAvatarInfoManager.b.getValue();
    }

    public final StateFlowImpl e() {
        DigitalAvatarInfoManager.a.getClass();
        return DigitalAvatarInfoManager.c;
    }

    public final String g() {
        DigitalAvatarInfoManager.a.getClass();
        return DigitalAvatarInfoManager.e();
    }

    public final void b(GlobalScope r4) {
        Intrinsics.checkNotNullParameter(r4, "coroutineScope");
        IActionBarService r0 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r0 == null) goto L12;
        com.larus.bmhome.chat.api.e0 r1 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r1 == null) goto L9;
        LaunchInfo r2 = r1.a;
        if (r2 == null) goto L9;
        String r3 = r2.W();
    L10:
        r0.d(r4, r3, new t0());
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final Object c(Continuation<? super String> r2) {
        return DigitalAvatarInfoManager.d(DigitalAvatarInfoManager.a, r2);
    }

    public final Object i(Function2<? super wc9.e, ? super Continuation<? super Unit>, ? extends Object> r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof CreationPageService$getMainBotConversationInfo$1) == false) goto L7;
        CreationPageService$getMainBotConversationInfo$1 r0 = (CreationPageService$getMainBotConversationInfo$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r10);
    L36:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r8 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L31:
        wc9.e r11 = (wc9.e) r10;
    L32:
        r0.L$0 = null;
        r0.label = 3;
        if (r8.invoke(r11, r0) != r2) goto L36;
        return r2;
    L17:
        r8 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L23:
        r11 = (wc9.e) r10;
        goto L32
    L18:
        ResultKt.throwOnFailure(r10);
        if (com.larus.platform.exp.o.a() == false) goto L24;
        LocalSubConvHelper r12 = LocalSubConvHelper.a;
        String r4 = AccountService.a.getSecUserId();
        r0.L$0 = r8;
        r0.label = 1;
        r10 = r12.c(r4, null, r0);
        if (r10 != r2) goto L23;
        return r2;
    L24:
        ILaunchCacheService r13 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r13 == null) goto L28;
        r11 = r13.b();
        if (r11 != null) goto L32;
    L28:
        Flow r14 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.y());
        CreationPageService$getMainBotConversationInfo$cvs$1 r5 = new CreationPageService$getMainBotConversationInfo$cvs$1(null);
        r0.L$0 = r8;
        r0.label = 2;
        r10 = kotlinx.coroutines.flow.e.t(r14, r5, r0);
        if (r10 != r2) goto L31;
        return r2;
    L7:
        r0 = new CreationPageService$getMainBotConversationInfo$1(this, r9);
        goto L8
    }

    public static final Object h(CreationPageService r9, com.larus.bmhome.actionbar.model.z0 r10, String r11, Continuation r12) {
        r9.getClass();
        if ((r12 instanceof CreationPageService$handleOpenSchema$1) == false) goto L7;
        CreationPageService$handleOpenSchema$1 r0 = (CreationPageService$handleOpenSchema$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L37:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Ref.ObjectRef r14 = (Ref.ObjectRef) r0.L$3;
        String r15 = (String) r0.L$2;
        r11 = (String) r0.L$1;
        com.larus.bmhome.actionbar.model.z0 r4 = (com.larus.bmhome.actionbar.model.z0) r0.L$0;
        ResultKt.throwOnFailure(r13);
        String r16 = r15;
        r10 = r4;
    L26:
        com.larus.bmhome.actionbar.model.e0 r5 = r10.m;
        if (r5 == null) goto L36;
        String r6 = r5.a;
        if (r6 == null) goto L36;
        FLogger.a.i("CreationPageService", "[handleOpenSchema] schemaUrl=".concat(r6));
        Bundle r17 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("enter_from", "chat"), TuplesKt.to("enter_method", r11), TuplesKt.to("conversation_id", r14.element), TuplesKt.to("argConversationId", r14.element), TuplesKt.to("bot_id", r16), TuplesKt.to("need_router_to_chat", Boxing.boxBoolean(true))});
        MainCoroutineDispatcher r18 = Dispatchers.getMain();
        CreationPageService$handleOpenSchema$3 r19 = new CreationPageService$handleOpenSchema$3(r6, r10, r17, null);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.label = 2;
        if (BuildersKt.withContext(r18, r19, r0) != r2) goto L37;
        return r2;
    L36:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r13);
        com.larus.bmhome.chat.api.e0 r110 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r110 == null) goto L21;
        LaunchInfo r111 = r110.a;
        if (r111 == null) goto L21;
        r16 = r111.W();
    L22:
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = "";
        CreationPageService$handleOpenSchema$2 r8 = new CreationPageService$handleOpenSchema$2(r7, null);
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.L$2 = r16;
        r0.L$3 = r7;
        r0.label = 1;
        if (r9.i(r8, r0) == r2) goto L38;
        r14 = r7;
        goto L26
    L38:
        return r2;
    L21:
        r16 = null;
    L7:
        r0 = new CreationPageService$handleOpenSchema$1(r9, r12);
        goto L8
    }

    public final void f(Integer r16, FragmentActivity r17, Long r18, int r19, LifecycleCoroutineScope r20, String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r17, "activity");
        Intrinsics.checkNotNullParameter(r20, "lifecycleCoroutineScope");
        com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L7;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L7;
        String r2 = r1.W();
    L8:
        List r3 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r2);
        boolean r4 = false;
        if (r3 == null) goto L21;
        Iterator r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.z0) r6).a, r18) == false) goto L12;
    L17:
        com.larus.bmhome.actionbar.model.z0 r7 = (com.larus.bmhome.actionbar.model.z0) r6;
        if (r7 == null) goto L21;
        com.larus.bmhome.actionbar.model.z0 r8 = r7;
    L40:
        if (r16 == null) goto L42;
        String r9 = r16.toString();
    L43:
        if (r8 == null) goto L47;
        com.larus.bmhome.actionbar.model.r r10 = r8.q;
        if (r10 == null) goto L47;
        Integer r11 = r10.a;
    L49:
        if (r11 != null) goto L52;
    L55:
        if (r11 != null) goto L58;
    L60:
        if (r11 != null) goto L63;
    L65:
        if (r11 != null) goto L68;
    L70:
        String r12 = "";
    L54:
        String r13 = r12;
        if (r8 == null) goto L73;
        boolean r14 = true;
    L74:
        tx9.c0.o(r9, r13, r22, Boolean.valueOf(r14), "create_function_area", 96);
        if (r8 != null) goto L79;
        t19.s r15 = t19.s.a;
        String r24 = AppHost.a.getApplication().getString(2131897500);
        r15.getClass();
        t19.s.c(r17, r24);
        return;
    L79:
        if (z2.a.enableChatWithTab() == false) goto L101;
        IFlowSdkDepend r25 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r25 == null) goto L84;
        r25.f0();
        Fragment r26 = com.larus.home.impl.sdk.i.a.a();
    L85:
        if (r26 == null) goto L91;
        t1a.b r27 = s1a.a.g(r26);
        if (r27 == null) goto L91;
        com.larus.bmhome.chat.component.cvs.y r28 = r27.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r28 == null) goto L91;
        String r29 = r28.getBotId();
    L92:
        com.larus.bmhome.chat.api.e0 r110 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r110 == null) goto L97;
        LaunchInfo r111 = r110.a;
        if (r111 == null) goto L97;
        String r112 = r111.W();
    L99:
        if (Intrinsics.areEqual(r29, r112) == false) goto L101;
    L102:
        if (r26 == null) goto L107;
        com.larus.bmhome.instruction.g r30 = s1a.a.g(r26).getAbility(com.larus.bmhome.instruction.g.class);
        if (r30 == null) goto L154;
        r30.j90(r8);
        return;
    L154:
        return;
    L107:
        Integer r31 = r8.g;
        int r32 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        if (r31 != null) goto L111;
    L113:
        com.larus.bmhome.actionbar.model.r r33 = r8.q;
        if (r33 == null) goto L121;
        Integer r34 = r33.a;
        if (r34 == null) goto L121;
        if (r34.intValue() != 4) goto L121;
        boolean r35 = true;
    L122:
        if (r35 == true) goto L144;
        com.larus.bmhome.actionbar.model.r r36 = r8.q;
        if (r36 == null) goto L131;
        Integer r37 = r36.a;
        if (r37 == null) goto L131;
        if (r37.intValue() != 18) goto L131;
        boolean r38 = true;
    L132:
        if (r38 == true) goto L144;
        com.larus.bmhome.actionbar.model.r r39 = r8.q;
        if (r39 == null) goto L141;
        Integer r40 = r39.a;
        if (r40 == null) goto L141;
        if (r40.intValue() != 28) goto L141;
        r4 = true;
    L141:
        if (r4 == true) goto L144;
        BuildersKt.launch$default(r20, null, null, new CreationPageService$openCreationPage$3(this, r17, r8, r21, r22, r23, null), 3, null);
        return;
    L131:
        r38 = false;
    L144:
        BuildersKt.launch$default(r20, null, null, new CreationPageService$openCreationPage$2(this, r8, r17, r21, r22, r23, null), 3, null);
        return;
    L121:
        r35 = false;
        goto L122
    L111:
        if (r31.intValue() != r32) goto L113;
        BuildersKt.launch$default(r20, null, null, new CreationPageService$openCreationPage$1(this, r8, r23, null), 3, null);
        return;
    L97:
        r112 = null;
    L91:
        r29 = null;
        goto L92
    L84:
        r26 = null;
    L101:
        r26 = null;
        goto L102
    L73:
        r14 = false;
        goto L74
    L68:
        if (r11.intValue() != 11) goto L70;
        r12 = "avatar";
        goto L54
    L63:
        if (r11.intValue() != 1) goto L65;
        r12 = "music";
        goto L54
    L58:
        if (r11.intValue() != 18) goto L60;
        r12 = "video";
        goto L54
    L52:
        if (r11.intValue() != 4) goto L55;
        r12 = "image";
    L47:
        r11 = null;
        goto L49
    L42:
        r9 = null;
        goto L43
    L16:
        r6 = null;
    L21:
        if (r3 == null) goto L39;
        Iterator r41 = r3.iterator();
    L24:
        if (r41.hasNext() == false) goto L37;
        Object r42 = r41.next();
        com.larus.bmhome.actionbar.model.r r43 = ((com.larus.bmhome.actionbar.model.z0) r42).q;
        if (r43 == null) goto L34;
        Integer r44 = r43.a;
        if (r44 == null) goto L34;
        if (r44.intValue() != r19) goto L34;
        boolean r45 = true;
    L35:
        if (r45 == false) goto L24;
    L38:
        r8 = (com.larus.bmhome.actionbar.model.z0) r42;
    L34:
        r45 = false;
        goto L35
    L37:
        r42 = null;
        goto L38
    L39:
        r8 = null;
    L7:
        r2 = null;
        goto L8
    }

    public final void a(boolean r55, Activity r56, com.larus.bmhome.actionbar.model.z0 r57, ChatParam r58, boolean r59, boolean r60, String r61, String r62, String r63, Image r64, List<ResourceExt> r65, String r66, ArrayList<Integer> r67, boolean r68, zs8.a r69, by7.e r70, Bundle r71, boolean r72, Map<String, String> r73, Integer r74, Integer r75, boolean r76, CustomInputInitData r77, boolean r78, ChatPageContext r79, Fragment r80) {
        Intrinsics.checkNotNullParameter(r56, "activity");
        Intrinsics.checkNotNullParameter(r57, "item");
        Intrinsics.checkNotNullParameter(r65, "refCreateRefInfoList");
        Intrinsics.checkNotNullParameter(r67, "whiteIndexList");
        ny9.b r14 = new ny9.b(r55, r56, r57, r58, r59, r60, r61, r62, r63, null, r65, null, r67, null, r64, null, null, r66, null, false, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, null, null, null, null, null, null, null, null, null, null, null, null, null, r79, null, r80, null, null, false, -2146588160, 241663);
        if (IAICreationAppletHostService.a.f(r14, true) == false) goto L5;
        return;
    L5:
        s0.a.getClass();
        s0.d(r14);
    }
}
