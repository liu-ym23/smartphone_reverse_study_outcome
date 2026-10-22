package com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel;

import android.content.Context;
import androidx.lifecycle.FlowLiveDataConversions;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CommonButtonV2VMDependencyImpl implements com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.b {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public static final class a {
    }

    public static final class b implements IIMCallback<List<? extends Message>> {
        public final /* synthetic */ Function0<Unit> a;

        public final boolean mustInMain() {
            return true;
        }

        public b(Function0<Unit> r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Function0<Unit> r3 = this.a;
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }

        public final void onSuccess(Object r2) {
            Intrinsics.checkNotNullParameter((List) r2, "result");
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/bmhome/chat/standarduikit/commonbuttonv2/viewmodel/CommonButtonV2VMDependencyImpl$sendCreationMsg$relyInfo$1$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/CreationBtnReplayInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TypeToken<wj8.b> {
        public c() {
        }
    }

    static {
    }

    public CommonButtonV2VMDependencyImpl() {
        this.a = LazyKt.lazy(new com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.c());
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.b
    public final void a(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r2) {
        Intrinsics.checkNotNullParameter(r2, "vmData");
        Map<String, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d> r0 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d r1 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a(r2.g);
        if (r1 == null) goto L6;
        r1.d(r2);
        return;
    }

    public final Object c(Continuation<? super wc9.e> r6) {
        if ((r6 instanceof CommonButtonV2VMDependencyImpl$getMainBotConversation$1) == false) goto L7;
        CommonButtonV2VMDependencyImpl$getMainBotConversation$1 r0 = (CommonButtonV2VMDependencyImpl$getMainBotConversation$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L23:
        return (wc9.e) r7;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        ILaunchCacheService r8 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r8 == null) goto L19;
        wc9.e r9 = r8.b();
        if (r9 == null) goto L19;
        return r9;
    L19:
        Flow r10 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.y());
        CommonButtonV2VMDependencyImpl$getMainBotConversation$cvs$2 r4 = new CommonButtonV2VMDependencyImpl$getMainBotConversation$cvs$2(null);
        r0.label = 1;
        r7 = kotlinx.coroutines.flow.e.t(r10, r4, r0);
        if (r7 != r2) goto L23;
        return r2;
    L7:
        r0 = new CommonButtonV2VMDependencyImpl$getMainBotConversation$1(this, r6);
        goto L8
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.b
    public final void b(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r9, Context r10) {
        Intrinsics.checkNotNullParameter(r9, "vmData");
        Map<String, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d> r0 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d r1 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a(r9.g);
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L9:
        if (r3 == false) goto L12;
        FLogger.a.i("CommonButtonV2", "[onClickCommonButton] scene(" + r9.g + ") is intercepted");
        return;
    L12:
        Integer r4 = r9.f;
        String r5 = "";
        if (r4 != null) goto L16;
    L17:
        Message r6 = r9.i;
        if (r6 == null) goto L23;
        Intrinsics.checkNotNullParameter(r6, "message");
        IChatRepoService r7 = zh8.a.a;
        String r8 = r6.getLocalMessageId();
        if (r8 != null) goto L22;
        r8 = "";
    L22:
        r7.r1(r8, new f());
    L23:
        FLogger.a.i("CommonButtonV2", "onClick, data=" + r9);
        Integer r11 = r9.f;
        if (r11 == null) goto L44;
        if (r11.intValue() != 1) goto L44;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d r12 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a(r9.g);
        String r13 = r9.e;
        if (r13 == null) goto L33;
        r5 = r13;
    L33:
        if (r5.length() <= 0) goto L35;
        r2 = true;
    L35:
        if (r2 == false) goto L41;
        if (r10 == null) goto L41;
        i r14 = SmartRouter.buildRoute(r10, r5);
        if (r12 == null) goto L40;
        Intrinsics.checkNotNull(r14);
        r12.h(r14, r9);
    L40:
        r14.d();
    L41:
        if (r12 == null) goto L66;
        r12.a(r9);
        return;
    L66:
        return;
    L44:
        if (r11 != null) goto L47;
    L58:
        if (r11 != null) goto L61;
        return;
    L61:
        if (r11.intValue() != 2) goto L70;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO())), null, null, new CommonButtonV2VMDependencyImpl$onClickCommonButton$4(this, r9, null), 3, null);
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d r15 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a(r9.g);
        if (r15 == null) goto L71;
        r15.a(r9);
        return;
    L71:
        return;
    L70:
        return;
    L47:
        if (r11.intValue() != 3) goto L58;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d r16 = com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.e.a(r9.g);
        Message r17 = r9.i;
        if (r17 == null) goto L55;
        IChatRepoService r18 = zh8.a.a;
        String r19 = r17.getLocalMessageId();
        if (r19 == null) goto L54;
        r5 = r19;
    L54:
        r18.r1(r5, new e());
    L55:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO())), null, null, new CommonButtonV2VMDependencyImpl$onClickCommonButton$3(this, r9, null), 3, null);
        if (r16 == null) goto L68;
        r16.a(r9);
        return;
    L68:
        return;
    L16:
        if (r4.intValue() == 1) goto L23;
    L5:
        if (r1.f(r9) != true) goto L7;
        r3 = true;
        goto L9
    }

    public final Object d(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r29, boolean r30, Function0<Unit> r31, Continuation<? super Unit> r32) {
        if ((r32 instanceof CommonButtonV2VMDependencyImpl$sendCreationMsg$1) == false) goto L7;
        CommonButtonV2VMDependencyImpl$sendCreationMsg$1 r3 = (CommonButtonV2VMDependencyImpl$sendCreationMsg$1) r32;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L19;
        if (r6 == 1) goto L18;
        if (r6 == 2) goto L17;
        if (r6 != 3) goto L16;
        boolean r0 = r3.Z$0;
        Message r7 = (Message) r3.L$5;
        wj8.b r8 = (wj8.b) r3.L$4;
        String r9 = (String) r3.L$3;
        wc9.e r10 = (wc9.e) r3.L$2;
        Function0<Unit> r12 = (Function0) r3.L$1;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r11 = (com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r14 = r9;
    L14:
        wc9.e r13 = r10;
        Message r15 = (Message) r2;
        LinkedHashMap r16 = new LinkedHashMap();
        if (r7 == null) goto L73;
        Map r17 = r7.getExt();
        if (r17 == null) goto L73;
        String r18 = (String) r17.get("action_bar_instruction");
        if (r18 == null) goto L73;
    L74:
        r16.put("action_bar_instruction", r18);
        Map<String, String> r19 = r11.h;
        if (r19 == null) goto L78;
        String r20 = r19.get("creation_btn_rely_info");
        if (r20 == null) goto L78;
    L79:
        r16.put("creation_btn_rely_info", r20);
        r16.put("enter_method_trace", "chat_video_guide_button");
        if (r8 == null) goto L86;
        Long r21 = r8.c();
        if (r21 == null) goto L86;
        if (qq9.a.a(r21) != true) goto L86;
        boolean r22 = true;
    L87:
        if (r22 == false) goto L134;
        List<Long> r23 = r8.a();
        if (r23 == null) goto L95;
        Long r24 = (Long) CollectionsKt.firstOrNull(r23);
        if (r24 == null) goto L95;
        if (qq9.a.a(r24) != true) goto L95;
        boolean r25 = true;
    L96:
        if (r25 == false) goto L134;
        ArrayList r26 = new ArrayList();
        if (r15 == null) goto L100;
        NestedFileContent r27 = com.larus.bmhome.chat.bean.d.f(r15);
    L101:
        NestedFileContent r110 = r27;
        int r28 = wf9.b.a;
        ai8.f r33 = new ai8.f(r110, com.flow.kmp.common.util.i.a(), null, null, r16, null, false, MessageStatus.MessageStatus_INVISIBLE, r11.q, null, 620);
        if (r0 == true) goto L104;
        String r34 = r11.b;
    L125:
        if (r34 != null) goto L127;
        String r111 = "";
    L128:
        int r35 = wf9.b.a;
        String r112 = com.flow.kmp.common.util.i.a();
        if (r0 == false) goto L131;
        MessageStatus r36 = MessageStatus.MessageStatus_INVISIBLE;
    L132:
        ai8.h r37 = new ai8.h(r111, r112, r36, null, r16, null, false, false, r11.q, null, 744);
        r26.add(r33);
        r26.add(r37);
        u1.a.e(RepoDispatcherDelegate.b.e().u1(), r13, r14, "router_auto_send", r26, "router_auto_send", new b(r12), false, false, null, 448);
        FLogger.a.i("CommonButtonV2VMDependencyImpl", "sendCreationMsg, isHiddenMsg: " + r0);
        goto L134
    L131:
        r36 = MessageStatus.MessageStatus_AVAILABLE;
        goto L132
    L127:
        r111 = r34;
        goto L128
    L104:
        if (r7 == null) goto L124;
        List r38 = r7.getContentBlock();
        if (r38 == null) goto L124;
        Iterator r39 = r38.iterator();
    L109:
        if (r39.hasNext() == false) goto L116;
        Object r40 = r39.next();
        if (((Block) r40).getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L113;
        boolean r113 = true;
    L114:
        if (r113 == false) goto L109;
    L117:
        Block r41 = (Block) r40;
        if (r41 == null) goto L124;
        BlockContent r42 = r41.getContent();
        if (r42 == null) goto L124;
        TextBlock r43 = r42.getTextBlock();
        if (r43 == null) goto L124;
        r34 = r43.text;
        goto L125
    L113:
        r113 = false;
        goto L114
    L116:
        r40 = null;
    L124:
        r34 = null;
        goto L125
    L100:
        r27 = new NestedFileContent(null, null, false, null, 15, null);
    L95:
        r25 = false;
    L134:
        return Unit.INSTANCE;
    L86:
        r22 = false;
    L78:
        r20 = "";
    L73:
        r18 = "";
        goto L74
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r0 = r3.Z$0;
        r8 = (wj8.b) r3.L$4;
        String r44 = (String) r3.L$3;
        wc9.e r114 = (wc9.e) r3.L$2;
        Function0<Unit> r115 = (Function0) r3.L$1;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r116 = (com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a) r3.L$0;
        ResultKt.throwOnFailure(r2);
        r14 = r44;
        r10 = r114;
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r117 = r116;
    L57:
        Message r45 = (Message) r2;
        IChatRepoService r46 = RepoDispatcherDelegate.b.e();
        if (r8 == null) goto L62;
        List<Long> r118 = r8.a();
        if (r118 == null) goto L62;
        Long r119 = (Long) CollectionsKt.firstOrNull(r118);
    L63:
        String r120 = String.valueOf(r119);
        r3.L$0 = r117;
        r3.L$1 = r115;
        r3.L$2 = r10;
        r3.L$3 = r14;
        r3.L$4 = r8;
        r3.L$5 = r45;
        r3.Z$0 = r0;
        r3.label = 3;
        Object r47 = r46.E1(r120, r3);
        if (r47 != r5) goto L66;
        return r5;
    L66:
        r7 = r45;
        r2 = r47;
        r11 = r117;
        r12 = r115;
    L62:
        r119 = null;
        goto L63
    L18:
        boolean r1 = r3.Z$0;
        Function0<Unit> r48 = (Function0) r3.L$1;
        r117 = (com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L25:
        wc9.e r121 = (wc9.e) r2;
        boolean r49 = r1;
    L27:
        if (r121 != null) goto L32;
        if (r48 == null) goto L31;
        r48.invoke();
    L31:
        return Unit.INSTANCE;
    L32:
        String r50 = r117.l;
        if (r50 != null) goto L37;
        r50 = r121.a;
        if (r50 != null) goto L37;
        r14 = "";
    L135:
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L44
        Gson r52 = (Gson) this.a.getValue();     // Catch: Throwable -> L44
        Map<String, String> r122 = r117.h;     // Catch: Throwable -> L44
        if (r122 == null) goto L41;
        String r123 = r122.get("creation_btn_rely_info");     // Catch: Throwable -> L44
    L42:
        Object r53 = Result.constructor-impl((wj8.b) r52.fromJson(r123, new c().getType()));     // Catch: Throwable -> L44
    L47:
        if (Result.isFailure-impl(r53) == false) goto L49;
        r53 = null;
    L49:
        wj8.b r54 = (wj8.b) r53;
        IChatRepoService r55 = RepoDispatcherDelegate.b.e();
        if (r54 == null) goto L52;
        Long r124 = r54.c();
    L53:
        String r125 = String.valueOf(r124);
        r3.L$0 = r117;
        r3.L$1 = r48;
        r3.L$2 = r121;
        r3.L$3 = r14;
        r3.L$4 = r54;
        r3.Z$0 = r49;
        r3.label = 2;
        Object r56 = r55.E1(r125, r3);
        if (r56 != r5) goto L56;
        return r5;
    L56:
        r10 = r121;
        r115 = r48;
        r8 = r54;
        r0 = r49;
        r2 = r56;
        goto L57
    L52:
        r124 = null;
        goto L53
    L41:
        r123 = null;
    L44:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        r53 = Result.constructor-impl(ResultKt.createFailure(th));
    L37:
        r14 = r50;
        goto L135
    L19:
        ResultKt.throwOnFailure(r2);
        wc9.e r58 = r29.k;
        if (r58 != null) goto L26;
        r3.L$0 = r29;
        r48 = r31;
        r3.L$1 = r48;
        r3.Z$0 = r30;
        r3.label = 1;
        r2 = c(r3);
        if (r2 != r5) goto L24;
        return r5;
    L24:
        r117 = r29;
        r1 = r30;
        goto L25
    L26:
        r48 = r31;
        r121 = r58;
        r49 = r30;
        r117 = r29;
    L7:
        r3 = new CommonButtonV2VMDependencyImpl$sendCreationMsg$1(this, r32);
        goto L8
    }
}
