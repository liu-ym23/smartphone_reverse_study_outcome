package com.obric.assistant.complex_task;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.require.IMainBotService;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.multitask_management.api.CancelFrom;
import com.larus.multitask_management.api.IMultiTaskHostAbility;
import com.larus.multitask_management.api.customize.ITaskActionHandler;
import com.larus.platform.IFlowMessageService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.chat.IObricChatPageStateService;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.special_input.ObricComplexTaskPanelType;
import com.obric.assistant.special_input.util.SpecialTrackEventUtilsKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import io.ktor.http.Url;
import io.ktor.http.l0;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kl9.u;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u001a\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u001c\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/assistant/complex_task/MultiComplexTaskActionHandler;", "Lcom/larus/multitask_management/api/customize/ITaskActionHandler;", "<init>", "()V", "TAG", NameKeys.UnloadStrategy_No_Strategy, "scope", "Lkotlinx/coroutines/CoroutineScope;", "scrollToLatestMessage", NameKeys.UnloadStrategy_No_Strategy, "messageId", "forceOpen", NameKeys.UnloadStrategy_No_Strategy, "getVContextLoose", "Lcom/larus/ui/arch/context/external/VContext;", "activity", "Landroidx/fragment/app/FragmentActivity;", "findMainBotActivity", "getWindowChatListAbility", "Lcom/obric/assistant/ability/IObricChatListAbility;", "doScrollToMessage", "chatListAbility", "showToast", "handleSchema", "schema", "resolveSourceFrom", LynxResourceModule.URI_KEY, "Lio/ktor/http/Url;", "taskBasicInfo", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "resolveInstructionType", "taskInfo", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiComplexTaskActionHandler implements ITaskActionHandler {
    public final String b;
    public final CoroutineScope c;

    /* JADX INFO: renamed from: com.obric.assistant.complex_task.MultiComplexTaskActionHandler$handleSchema$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.complex_task.MultiComplexTaskActionHandler$handleSchema$4", f = "MultiComplexTaskActionHandler.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $taskId;
        int label;

        public AnonymousClass4(String r1, Continuation<? super AnonymousClass4> r2) {
            this.$taskId = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass4(this.$taskId, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L13:
            Boolean r6 = (Boolean) r5;
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            pd6.b r7 = pd6.c.a;
            il9.a r8 = pd6.c.a(Reflection.getOrCreateKotlinClass(il9.a.class));
            if (r8 == null) goto L15;
            String r2 = this.$taskId;
            CancelFrom r3 = CancelFrom.MANUAL;
            this.label = 1;
            r5 = r8.a1(r2, r3, this);
            if (r5 != r0) goto L13;
            return r0;
        }
    }

    public MultiComplexTaskActionHandler() {
        this.b = "ComplexTaskActionHandler";
        this.c = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static t1a.b u(FragmentActivity r3) {
        if (com.obric.assistant.chat.p.e(r3) == true) goto L44;
        Iterator r4 = r3.getSupportFragmentManager().getFragments().iterator();
    L7:
        if (r4.hasNext() == false) goto L27;
        Fragment r0 = (Fragment) r4.next();
        if (r0.isAdded() == false) goto L7;
        if (r0.isVisible() == false) goto L7;
        Intrinsics.checkNotNull(r0);
        t1a.b r1 = s1a.a.g(r0);
        if (r1.getAbility(laa.d.class) != null) goto L15;
        Iterator r2 = r0.getChildFragmentManager().getFragments().iterator();
    L18:
        if (r2.hasNext() == false) goto L7;
        Fragment r5 = (Fragment) r2.next();
        if (r5.isAdded() == false) goto L18;
        if (r5.isVisible() == false) goto L18;
        Intrinsics.checkNotNull(r5);
        t1a.b r6 = s1a.a.g(r5);
        if (r6.getAbility(laa.d.class) == null) goto L18;
        return r6;
    L15:
        return r1;
    L27:
        return null;
    L44:
        return com.obric.assistant.chat.p.a(r3);
    }

    public final boolean handleSchema(String r18) {
        Intrinsics.checkNotNullParameter(r18, "schema");
        Url r1 = l0.b(r18);
        if (Intrinsics.areEqual(r1.b, "task_management") == false) goto L162;
        String r2 = r1.e.get("task_instance_id");
        if (r2 != null) goto L7;
        return false;
    L7:
        pd6.b r4 = pd6.c.a;
        il9.a r5 = pd6.c.a(Reflection.getOrCreateKotlinClass(il9.a.class));
        if (r5 == null) goto L10;
        u r6 = r5.J0(r2);
    L11:
        if (r6 == null) goto L13;
        String r7 = r6.c;
    L14:
        Map r8 = MultiComplexTaskManager.a;
        DMTaskInfo r9 = MultiComplexTaskManager.b(r6);
        String r10 = r1.e.get("source_page");
        if (Intrinsics.areEqual(r10, "multi_task_manage") == false) goto L19;
        String r11 = "async_task_management_page";
    L17:
        String r13 = r11;
        if (r6 == null) goto L32;
        Map r12 = r6.s;
        if (r12 == null) goto L32;
        String r14 = (String) r12.get("original_msg_id");
        if (r14 == null) goto L32;
    L37:
        if (r9 == null) goto L39;
        final String r15 = com.obric.assistant.utils.f.a(r9);
    L42:
        FLogger r16 = FLogger.a;
        r16.w(this.b, "handleSchema start, omniTaskId: " + r7);
        if (Intrinsics.areEqual(r1.a(), "/cancel_queue") == false) goto L45;
    L47:
        String r3 = r1.a();
        switch(r3.hashCode()) {
            case -1390952366: goto L152;
            case -1090099604: goto L144;
            case 48051141: goto L132;
            case 427095661: goto L117;
            case 647881075: goto L99;
            case 983915603: goto L81;
            case 1911658683: goto L66;
            case 2136530028: goto L51;
            default: goto L172;
        };
    L172:
        return false;
    L51:
        if (r3.equals("/open_voice") == false) goto L173;
        r16.i(this.b, "handleSchema TASK_MANAGEMENT_SCHEMA_PATH_OPEN_VOICE");
        if (r9 != null) goto L57;
        t19.s.a.g(AppHost.a.getApplication(), 2131912636, false);
        return true;
    L57:
        IMultiTaskHostAbility r17 = pd6.c.a(Reflection.getOrCreateKotlinClass(IMultiTaskHostAbility.class));
        if (r17 == null) goto L60;
        r17.m();
    L60:
        ISpecialInputTask r19 = com.obric.assistant.special_input.c.a();
        if (r19 == null) goto L165;
        ISpecialInputTask.a.a(r19, com.obric.assistant.special_input.util.j.d(ObricComplexTaskPanelType.CLARIFYING.getValue(), true, MapsKt.mapOf(TuplesKt.to("source_from", r13)), null, null, 24), true, false, false, new p(this, r15), 12);
        return true;
    L165:
        return true;
    L173:
        return false;
    L66:
        if (r3.equals("/cancel_queue") == false) goto L174;
        r16.i(this.b, "handleSchema TASK_MANAGEMENT_SCHEMA_PATH_CANCEL_QUEUE");
        ConcurrentHashMap r20 = (ConcurrentHashMap) MultiComplexTaskManager.a;
        int r21 = r20.size() - (r20.containsKey(r2) ? 1 : 0);
        SpecialTrackEventUtilsKt.h(r13.concat("_cancel"), k0(r9, r6), r7, r14);
        s.b("obric_omni_asynctask_item_cancel", r7, r14, r21);
        IMultiTaskHostAbility r22 = pd6.c.a(Reflection.getOrCreateKotlinClass(IMultiTaskHostAbility.class));
        if (r22 == null) goto L72;
        r22.m();
    L72:
        if (MultiComplexTaskManager.d(r6, r9, CancelFrom.MANUAL) == false) goto L75;
        return true;
    L75:
        IObricNetworkService r23 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r23 == null) goto L166;
        r23.h(new JSONObject().put("task_id", r7).put("scene", "cancel_queue").toString(), null);
        return true;
    L166:
        return true;
    L174:
        return false;
    L81:
        if (r3.equals("/stop_task") == false) goto L175;
        r16.i(this.b, "handleSchema TASK_MANAGEMENT_SCHEMA_PATH_STOP_TASK");
        ConcurrentHashMap r24 = (ConcurrentHashMap) MultiComplexTaskManager.a;
        int r25 = r24.size() - (r24.containsKey(r2) ? 1 : 0);
        SpecialTrackEventUtilsKt.h(r13.concat("_stop"), k0(r9, r6), r7, r14);
        s.b("obric_omni_asynctask_item_stop", r7, r14, r25);
        IMultiTaskHostAbility r26 = pd6.c.a(Reflection.getOrCreateKotlinClass(IMultiTaskHostAbility.class));
        if (r26 == null) goto L87;
        r26.m();
    L87:
        if (MultiComplexTaskManager.d(r6, r9, CancelFrom.MANUAL) == false) goto L90;
        return true;
    L90:
        if (r14 == null) goto L167;
        Long r27 = StringsKt.toLongOrNull(r14);
        if (r27 == null) goto L168;
        long r28 = r27.longValue();
        IObricNetworkService r29 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r29 == null) goto L169;
        r29.q(r28, "queue_interrupt_task");
        return true;
    L169:
        return true;
    L168:
        return true;
    L167:
        return true;
    L175:
        return false;
    L99:
        if (r3.equals("/resend_query") == false) goto L176;
        r16.i(this.b, "handleSchema TASK_MANAGEMENT_SCHEMA_PATH_RESEND_QUERY");
        if (r14 != null) goto L104;
    L107:
        boolean r30 = true;
    L108:
        if (r30 == false) goto L111;
        return true;
    L111:
        BuildersKt.launch$default(this.c, null, null, new AnonymousClass4(r2, null), 3, null);
        IFlowMessageService r31 = (IFlowMessageService) ServiceManager.get().getService(IFlowMessageService.class);
        if (r31 == null) goto L114;
        r31.g(r14, true, null, NameKeys.UnloadStrategy_No_Strategy);
        return true;
    L114:
        return true;
    L104:
        if (r14.length() == 0) goto L107;
        r30 = false;
        goto L108
    L176:
        return false;
    L117:
        if (r3.equals("/open_keyboard") == false) goto L177;
        r16.i(this.b, "handleSchema TASK_MANAGEMENT_SCHEMA_PATH_OPEN_KEYBOARD");
        if (r9 != null) goto L123;
        t19.s.a.g(AppHost.a.getApplication(), 2131912636, false);
        return true;
    L123:
        IMultiTaskHostAbility r32 = pd6.c.a(Reflection.getOrCreateKotlinClass(IMultiTaskHostAbility.class));
        if (r32 == null) goto L126;
        r32.m();
    L126:
        ISpecialInputTask r33 = com.obric.assistant.special_input.c.a();
        if (r33 == null) goto L170;
        ISpecialInputTask.a.a(r33, com.obric.assistant.special_input.util.j.d(ObricComplexTaskPanelType.CLARIFYING.getValue(), false, MapsKt.mapOf(TuplesKt.to("source_from", r13)), null, null, 24), true, false, false, new o(this, r15), 12);
        return true;
    L170:
        return true;
    L177:
        return false;
    L132:
        if (r3.equals("/open_virtual") == false) goto L178;
        r16.i(this.b, "handleSchema TASK_MANAGEMENT_SCHEMA_PATH_OPEN_VIRTUAL");
        if (r9 != null) goto L138;
        t19.s.a.g(AppHost.a.getApplication(), 2131912636, false);
        return true;
    L138:
        IMultiTaskHostAbility r34 = pd6.c.a(Reflection.getOrCreateKotlinClass(IMultiTaskHostAbility.class));
        if (r34 == null) goto L141;
        r34.m();
    L141:
        sea.g r110 = sea.g.a;
        sea.b.a.getClass();
        sea.g.h(r110, false, r13, sea.b.a(r9), null, 8);
        return true;
    L178:
        return false;
    L144:
        if (r3.equals("/anchor_message") == false) goto L179;
        r16.i(this.b, "handleSchema TASK_MANAGEMENT_SCHEMA_PATH_ANCHOR_MESSAGE");
        IMultiTaskHostAbility r35 = pd6.c.a(Reflection.getOrCreateKotlinClass(IMultiTaskHostAbility.class));
        if (r35 == null) goto L149;
        r35.m();
    L149:
        z0(r15, true);
        return true;
    L179:
        return false;
    L152:
        if (r3.equals("/start_immediately") == false) goto L180;
        r16.i(this.b, "handleSchema TASK_MANAGEMENT_SCHEMA_PATH_START_IMMEDIATELY");
        IMultiTaskHostAbility r36 = pd6.c.a(Reflection.getOrCreateKotlinClass(IMultiTaskHostAbility.class));
        if (r36 == null) goto L157;
        r36.m();
    L157:
        IObricNetworkService r37 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r37 == null) goto L171;
        r37.h(new JSONObject().put("next_task_id", r7).put("scene", "jump_queue").toString(), null);
        return true;
    L171:
        return true;
    L180:
        return false;
    L45:
        if (Intrinsics.areEqual(r1.a(), "/stop_task") == true) goto L47;
        s.a(r7, r14, ((ConcurrentHashMap) MultiComplexTaskManager.a).size(), r6);
        goto L47
    L39:
        r15 = (String) ((ConcurrentHashMap) MultiComplexTaskManager.a).get(r2);
        if (r15 != null) goto L42;
        r15 = r14;
    L32:
        if (r9 == null) goto L36;
        IMMessage r38 = r9.getMessage();
        if (r38 == null) goto L36;
        r14 = r38.getMessageId();
    L36:
        r14 = (String) ((ConcurrentHashMap) MultiComplexTaskManager.b).get(r2);
        goto L37
    L19:
        if (Intrinsics.areEqual(r10, "task_float_window") == false) goto L21;
        r11 = "async_task_management_float_page";
        goto L17
    L21:
        if (r6 == null) goto L26;
        Map r39 = r6.s;
        if (r39 == null) goto L26;
        r11 = (String) r39.get("source_from");
        if (r11 != null) goto L17;
    L26:
        r11 = "async_task_management_capsule";
        goto L17
    L13:
        r7 = null;
        goto L14
    L10:
        r6 = null;
        goto L11
    L162:
        return false;
    }

    public static String k0(DMTaskInfo r2, u r3) {
        if (r3 == null) goto L8;
        Map r4 = r3.s;
        if (r4 == null) goto L8;
        String r5 = (String) r4.get("o_omni_instruction_type");
        if (r5 == null) goto L8;
        return r5;
    L8:
        String r6 = null;
        if (r2 == null) goto L15;
        IMMessage r1 = r2.getMessage();
        if (r1 == null) goto L15;
        Map r7 = r1.getExt();
        if (r7 == null) goto L15;
        String r8 = (String) r7.get("o_omni_instruction_type");
    L16:
        if (r8 != null) goto L24;
        if (r2 == null) goto L21;
        Map r9 = r2.getExt();
        if (r9 == null) goto L21;
        r6 = (String) r9.get("o_omni_instruction_type");
    L21:
        if (r6 != null) goto L26;
        return NameKeys.UnloadStrategy_No_Strategy;
    L26:
        return r6;
    L24:
        return r8;
    L15:
        r8 = null;
        goto L16
    }

    public final void z0(String r11, boolean r12) {
        ObricFloatChatPageState r0 = (ObricFloatChatPageState) waa.a.b.getValue();
        ObricFloatChatPageData.Companion.getClass();
        boolean r2 = false;
        laa.c r4 = null;
        if ((r0 instanceof vda.e) == false) goto L5;
    L7:
        IObricChatPageStateService r13 = (IObricChatPageStateService) ServiceManager.get().getService(IObricChatPageStateService.class);
        if (r13 == null) goto L10;
        r13.a();
    L10:
        IAssistantChatWindow r14 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r14 != null) goto L14;
    L21:
        laa.c r15 = null;
    L22:
        if (r15 == null) goto L31;
        if (r11 != null) goto L25;
    L26:
        r2 = true;
    L27:
        if (r2 == false) goto L29;
        r15.kc();
        return;
    L29:
        r15.vC(r11);
        return;
    L25:
        if (r11.length() != 0) goto L27;
    L31:
        Iterator r16 = AppHost.a.a().g().iterator();
    L33:
        if (r16.hasNext() == false) goto L51;
        Object r1 = r16.next();
        FragmentActivity r3 = (Activity) r1;
        if ((r3 instanceof FragmentActivity) == false) goto L37;
        FragmentActivity r5 = r3;
    L38:
        if (r5 == null) goto L48;
        t1a.b r6 = u(r5);
        if (r6 == null) goto L43;
        laa.d r7 = (laa.d) r6.getAbility(laa.d.class);
    L44:
        if (r7 == null) goto L48;
        if (r7.Da() != true) goto L48;
        boolean r8 = true;
    L49:
        if (r8 == false) goto L33;
    L53:
        if ((r1 instanceof FragmentActivity) == false) goto L55;
        FragmentActivity r9 = (FragmentActivity) r1;
    L56:
        if (r9 == null) goto L74;
        t1a.b r17 = u(r9);
        if (r17 == null) goto L60;
        r4 = (laa.c) r17.getAbility(laa.c.class);
    L60:
        FLogger r18 = FLogger.a;
        String r10 = this.b;
        StringBuilder r19 = new StringBuilder("scrollToLatestMessage: host=");
        r19.append(r9.getClass().getSimpleName());
        r19.append(", hasChatList=");
        if (r4 == null) goto L63;
        boolean r20 = true;
    L64:
        r19.append(r20);
        r18.i(r10, r19.toString());
        if (r11 != null) goto L67;
    L68:
        r2 = true;
    L69:
        if (r2 == false) goto L72;
        if (r4 == null) goto L88;
        r4.kc();
        return;
    L88:
        return;
    L72:
        if (r4 == null) goto L90;
        r4.vC(r11);
        return;
    L90:
        return;
    L67:
        if (r11.length() != 0) goto L69;
    L63:
        r20 = false;
        goto L64
    L74:
        if (r11 != null) goto L76;
    L77:
        r2 = true;
    L78:
        if (r2 == true) goto L80;
        sea.e.e(r11, "complex_task_action_handler");
    L80:
        MainBotServiceDelegate.b.c(AppHost.a.getApplication(), new IMainBotService.a(new Bundle(), 0, null, 0, 0, 0, 67108864, 14));
        return;
    L76:
        if (r11.length() != 0) goto L78;
    L55:
        r9 = null;
        goto L56
    L43:
        r7 = null;
    L48:
        r8 = false;
        goto L49
    L37:
        r5 = null;
        goto L38
    L51:
        r1 = null;
        goto L53
    L14:
        if (r14.isWindowMode() == false) goto L21;
        if (r14.isShowing() == false) goto L21;
        t1a.b r110 = r14.provideWindowVContext();
        if (r110 == null) goto L21;
        r15 = (laa.c) r110.getAbility(laa.c.class);
        goto L22
    L5:
        if ((r0 instanceof vda.a) == false) goto L31;
        if (r12 == false) goto L31;
        goto L7
    }
}
