package com.obric.assistant.component;

import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import be8.a;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.a2;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.c2;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.s0;
import com.larus.bmhome.actionbar.model.u0;
import com.larus.bmhome.actionbar.model.u1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.actionbar.model.z1;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.taskskill.service.SkillServiceDelegate;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.api.m4;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.x1;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.task.skill.m;
import com.obric.assistant.task.skill.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import va8.c0;
import va8.o0;
import va8.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004*\u0002AD\u0018\u0000 t2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001tB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00109\u001a\u00020+H\u0002J\b\u0010:\u001a\u00020+H\u0002J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020-H\u0002J4\u0010F\u001a\u00020>2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0H2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u000100H\u0016J\u0018\u0010F\u001a\u00020>2\u000e\u0010G\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010HH\u0016J4\u0010O\u001a\u00020>2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0H2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u000100H\u0016J&\u0010P\u001a\u00020+2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u000100H\u0002J\u0012\u0010Q\u001a\u00020>2\b\u0010R\u001a\u0004\u0018\u00010IH\u0002J\u0012\u0010S\u001a\u00020+2\b\u0010R\u001a\u0004\u0018\u00010IH\u0002J\u0017\u0010T\u001a\u00020+2\b\u0010U\u001a\u0004\u0018\u00010VH\u0002¢\u0006\u0002\u0010WJ\u0012\u0010T\u001a\u00020+2\b\u0010?\u001a\u0004\u0018\u00010-H\u0002J\u0010\u0010X\u001a\u00020>2\u0006\u0010Y\u001a\u00020-H\u0002J\b\u0010Z\u001a\u00020>H\u0016J\b\u0010[\u001a\u00020>H\u0016J\b\u0010\\\u001a\u00020>H\u0016J\b\u0010]\u001a\u00020+H\u0002J\u0010\u0010^\u001a\u00020>2\u0006\u0010_\u001a\u000200H\u0002J\u0014\u0010`\u001a\u00020>2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010IH\u0002J\b\u0010a\u001a\u00020>H\u0002J\u0018\u0010b\u001a\u00020>2\u0006\u0010c\u001a\u0002002\u0006\u0010_\u001a\u000200H\u0002J\"\u0010d\u001a\u00020>2\u0006\u0010_\u001a\u0002002\b\u0010R\u001a\u0004\u0018\u00010I2\u0006\u0010P\u001a\u00020+H\u0002J$\u0010e\u001a\u00020-2\b\u0010R\u001a\u0004\u0018\u00010I2\b\u0010f\u001a\u0004\u0018\u00010-2\u0006\u0010P\u001a\u00020+H\u0002J \u0010g\u001a\u00020-2\u0006\u0010R\u001a\u00020I2\u0006\u0010f\u001a\u00020-2\u0006\u0010h\u001a\u00020-H\u0002J7\u0010i\u001a\u00020+*\u0016\u0012\u0004\u0012\u00020k\u0018\u00010jj\n\u0012\u0004\u0012\u00020k\u0018\u0001`l2\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010m\u001a\u00020+H\u0002¢\u0006\u0002\u0010nJ \u0010o\u001a\u00020>2\b\u0010c\u001a\u0004\u0018\u0001002\f\u0010p\u001a\b\u0012\u0004\u0012\u00020k0qH\u0016J\u0018\u0010r\u001a\u00020>2\u0006\u0010R\u001a\u00020I2\u0006\u0010s\u001a\u00020-H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0016\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020-0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010BR\u0010\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010E¨\u0006u"}, d2 = {"Lcom/obric/assistant/component/ObricSkillComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/ability/IObricSkillAbility;", "Lcom/larus/bmhome/view/actionbar/CustomActionBarExtCallback;", "<init>", "()V", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "Lkotlin/Lazy;", "chatSenderCoreAbility", "Lcom/larus/bmhome/ability/IChatSenderCoreAbility;", "getChatSenderCoreAbility", "()Lcom/larus/bmhome/ability/IChatSenderCoreAbility;", "chatSenderCoreAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "skillAbility", "Lcom/larus/bmhome/chat/component/skill/ISkillAbility;", "getSkillAbility", "()Lcom/larus/bmhome/chat/component/skill/ISkillAbility;", "skillAbility$delegate", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "clickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "clickTalkAbility$delegate", "continuousTalkCtrlAbility", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "getContinuousTalkCtrlAbility", "()Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "continuousTalkCtrlAbility$delegate", "fullObricHostCallbacksRegistered", "", "pendingBackgroundResetReplyMode", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "_replyModeRestoredConversationId", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "replyModeRestoredConversationId", "Lkotlinx/coroutines/flow/StateFlow;", "getReplyModeRestoredConversationId", "()Lkotlinx/coroutines/flow/StateFlow;", "actionBarCoreAbility", "Lcom/larus/bmhome/ability/ICustomActionBarCoreAbility;", "getActionBarCoreAbility", "()Lcom/larus/bmhome/ability/ICustomActionBarCoreAbility;", "isAttachmentLocalFilePathExtEnabled", "shouldUploadAttachmentLocalFilePathExt", "taskModeStatusObserver", "Landroidx/lifecycle/Observer;", "setCurrentTaskModeStatus", "", "replyOption", "minorStatusCallback", "com/obric/assistant/component/ObricSkillComponent$minorStatusCallback$1", "Lcom/obric/assistant/component/ObricSkillComponent$minorStatusCallback$1;", "backgroundResetConversationListener", "com/obric/assistant/component/ObricSkillComponent$backgroundResetConversationListener$1", "Lcom/obric/assistant/component/ObricSkillComponent$backgroundResetConversationListener$1;", "buildObricActionBarMenuItems", "itemList", "", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "cvs", "Lcom/larus/im/bean/conversation/Conversation;", "bot", "Lcom/larus/im/bean/bot/BotModel;", "chatType", "beforeActionBarItemsRender", "isMainConversation", "syncPhoneOperationModeBeforeRender", "item", "isTaskSkillModeAvailable", "isPhoneOperationReplyMode", "itemId", "", "(Ljava/lang/Integer;)Z", "enterPhoneOperationMode", "option", "onParentViewCreated", "onStop", "onDestroy", "isFullObricPageHost", "protectTaskSkillStateForHostSwitch", "reason", "exitPhoneOperationModeForMinorMode", "refreshActionBar", "applyPendingBackgroundResetIfReady", "conversationId", "resetNonQuickModeIfBackgroundTimedOut", "resolveAvailableDefaultReplyMode", "savedDefault", "resolveAvailableDefaultReplyOptionV2", "defaultStatus", "isAvailableReplyMode", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/actionbar/model/SwitchMenuItem;", "Lkotlin/collections/ArrayList;", "isLocalPcMode", "(Ljava/util/ArrayList;Ljava/lang/Integer;Z)Z", "filterObricSwitchMenuItemsIfNeeded", "menuItems", "", "onActionBarSecondMenuClick", "targetOption", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSkillComponent extends BaseContentWidget implements laa.i, rs8.f {
    public static final a A = null;
    public static final ModelItemIdentity B = null;
    public static final Lazy<Gson> C = null;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public boolean t;
    public ReplyOption u;
    public final StateFlowImpl v;
    public final b1 w;
    public final e4 x;
    public final c y;
    public final b z;

    public static final class b implements y.a<wc9.e> {
        public final /* synthetic */ ObricSkillComponent a;

        public b(ObricSkillComponent r1) {
            this.a = r1;
        }

        public final void c(Object r3) {
            wc9.e r4 = (wc9.e) r3;
            Intrinsics.checkNotNullParameter(r4, "new");
            if (StringsKt.isBlank(r4.a) == true) goto L7;
            ObricSkillComponent r0 = this.a;
            String r5 = r4.a;
            a r1 = ObricSkillComponent.A;
            r0.Y2(r5, "conversationReady");
            return;
        }
    }

    public static final class c implements m4 {
        public final /* synthetic */ ObricSkillComponent a;

        public final void b1() {
        }

        public final void S1() {
            t0.e(new i4(this.a));
        }

        public c(ObricSkillComponent r1) {
            this.a = r1;
        }
    }

    public static final class d implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class e implements Function0<s> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(s.class));
        }
    }

    public static final class f implements Function0<y> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(y.class));
        }
    }

    public static final class g implements Function0<a> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(a.class));
        }
    }

    public static final class h implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class i implements Function0<maa.e> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(maa.e.class));
        }
    }

    public static final class j implements Function0<com.obric.audio.continuous_talk.c> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.c.class));
        }
    }

    public final void g8(int r1) {
    }

    public final void q0() {
    }

    static {
        A = new a();
        B = new ModelItemIdentity(null, 10000, 1, null);
        C = LazyKt.lazy(new d4());
    }

    public final void B2() {
        FLogger r0 = FLogger.a;
        r0.i("ObricSkillComponent", "onParentViewCreated: " + hashCode());
        if (s1a.a.e(this) == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        r0.i("ObricSkillComponent", "onParentViewCreated: input-only host, skip O skill callbacks");
        return;
    L12:
        this.t = true;
        com.larus.bmhome.instruction.g r2 = vc();
        if (r2 == null) goto L15;
        r2.QX(this);
    L15:
        s r3 = (s) this.n.getValue();
        if (r3 == null) goto L18;
        r3.Wt(MapsKt.mapOf(TuplesKt.to("o_omni_local_file_path", new o0(new onParentViewCreated.1(A), new f4(this)))));
    L18:
        com.larus.bmhome.instruction.g r4 = vc();
        if (r4 == null) goto L25;
        MutableLiveData r5 = r4.zU();
        if (r5 == null) goto L25;
        LiveData r6 = Transformations.distinctUntilChanged(r5);
        if (r6 == null) goto L25;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r6.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), this.x);
    L25:
        y r7 = u0();
        if (r7 == null) goto L28;
        r7.rh(new g4(), this.z);
    L28:
        AccountService.a.H(this.y);
        if (x1.a.a() == false) goto L32;
        h3(null);
        return;
    L32:
        return;
    L5:
        if (((laa.d) this.q.getValue()) != null) goto L8;
        r1 = false;
        goto L9
    }

    public final void KY() {
        FLogger.a.i("ObricSkillComponent", "refreshActionBar");
        c0 r0 = s1a.d.a(this).getAbility(c0.class);
        if (r0 == null) goto L6;
        r0.KY();
        return;
    }

    public final void onDestroy() {
        FLogger.a.i("ObricSkillComponent", "onDestroy: " + hashCode());
        this.v.setValue(null);
        if (this.t == true) goto L5;
        return;
    L5:
        this.t = false;
        AccountService.a.C(this.y);
        y r0 = u0();
        if (r0 == null) goto L8;
        r0.lQ(this.z);
    L8:
        this.u = null;
        com.larus.bmhome.instruction.g r1 = vc();
        if (r1 == null) goto L11;
        r1.LB(this);
    L11:
        com.larus.bmhome.instruction.g r2 = vc();
        if (r2 == null) goto L17;
        MutableLiveData r3 = r2.zU();
        if (r3 == null) goto L18;
        r3.removeObserver(this.x);
        return;
    L18:
        return;
    }

    public final void onStop() {
        if (this.t == false) goto L15;
        y r0 = u0();
        if (r0 == null) goto L7;
        String r1 = r0.Y1();
    L8:
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        if (StringsKt.isBlank(r1) == false) goto L13;
        FLogger.a.i("ObricSkillComponent", "protectTaskSkillStateForHostSwitch skipped, reason=onStop");
        return;
    L13:
        SkillServiceDelegate.a.p(r1);
        FLogger.a.i("ObricSkillComponent", "protectTaskSkillStateForHostSwitch, reason=onStop, conversationId=".concat(r1));
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final y u0() {
        return (y) this.o.getValue();
    }

    public final com.larus.bmhome.instruction.g vc() {
        return (com.larus.bmhome.instruction.g) this.m.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [com.obric.assistant.component.e4] */
    public ObricSkillComponent() {
        this.m = LazyKt.lazy(new d(this));
        this.n = LazyKt.lazy(new e(this));
        this.o = LazyKt.lazy(new f(this));
        this.p = LazyKt.lazy(new g(this));
        this.q = LazyKt.lazy(new h(this));
        this.r = LazyKt.lazy(new i(this));
        this.s = LazyKt.lazy(new j(this));
        StateFlowImpl r0 = j1.a(null);
        this.v = r0;
        this.w = kotlinx.coroutines.flow.e.b(r0);
        this.x = new e4(this);
        this.y = new c(this);
        this.z = new b(this);
    }

    public final b1 gJ() {
        return this.w;
    }

    public final void h3(z0 r6) {
        com.larus.bmhome.instruction.g r0 = vc();
        if (r0 != null) goto L6;
        FLogger.a.w("ObricSkillComponent", "exitPhoneOperationModeForMinorMode skip, ability is null");
        return;
    L6:
        ReplyOption r2 = r0.Ql();
        if (n.b(r2) == true) goto L10;
        FLogger.a.i("ObricSkillComponent", "exitPhoneOperationModeForMinorMode skip, status=" + r2);
        return;
    L10:
        FLogger.a.i("ObricSkillComponent", "exitPhoneOperationModeForMinorMode");
        com.larus.bmhome.instruction.g.a.b(r0, r6, r2.copy(wa8.t0.a, null, null), false, 4);
        com.obric.assistant.task.skill.f.c();
        com.larus.bmhome.view.actionbar.api.a.b("task_skill_action_bar_filter");
        KY();
    }

    public final void z1(List<z0> r5) {
        String r1 = null;
        this.v.setValue(null);
        FLogger.a.i("ObricSkillComponent", "buildObricActionBarMenuItems, itemList: " + r5);
        y r0 = u0();
        if (r0 == null) goto L5;
        r1 = r0.Y1();
    L5:
        if (r1 != null) goto L7;
    L9:
        if (r5 == null) goto L30;
        Iterator<T> r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L31;
        z0 r2 = (z0) r6.next();
        p0 r3 = r2.o;
        if (r3 == null) goto L21;
        Integer r4 = r3.a;
        int r7 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r4 == null) goto L21;
        if (r4.intValue() != r7) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L12;
        AtomicBoolean r9 = m.a;
        m.g(getContext(), r2);
        return;
    L21:
        r8 = false;
        goto L22
    L31:
        return;
    L30:
        return;
    L7:
        if (com.larus.bmhome.utils.i.g(r1) == true) goto L9;
    }

    public final void F(String r2, List<b2> r3) {
        Intrinsics.checkNotNullParameter(r3, "menuItems");
        if (r2 != null) goto L5;
        return;
    L5:
        if (com.larus.bmhome.utils.i.g(r2) == true) goto L10;
        CollectionsKt.removeAll(r3, new h4(this));
        return;
    }

    public final void Y2(String r8, String r9) {
        ReplyOption r0 = this.u;
        if (r0 != null) goto L5;
        return;
    L5:
        com.larus.bmhome.instruction.g r1 = vc();
        if (r1 != null) goto L10;
        FLogger.a.w("ObricSkillComponent", "applyPendingBackgroundResetIfReady skip, ability is null, reason=".concat(r9));
        return;
    L10:
        if (n.b(r0) == true) goto L12;
    L14:
        FLogger.a.i("ObricSkillComponent", "applyPendingBackgroundResetIfReady, reason=" + r9 + ", conversationId=" + r8 + ", targetReplyMode=" + r0);
        com.larus.bmhome.instruction.g.a.b(r1, null, r0, false, 5);
        this.u = null;
        if (n.b(r0) == false) goto L17;
        com.obric.assistant.task.skill.f.b(r0);
    L18:
        com.larus.bmhome.view.actionbar.api.a.b("task_skill_action_bar_filter");
        Lazy r10 = com.obric.assistant.actionbar.n.a;
        com.obric.assistant.actionbar.n.a("reset:".concat(r9));
        KY();
        return;
    L17:
        com.obric.assistant.task.skill.f.c();
        goto L18
    L12:
        if (com.larus.bmhome.utils.i.g(r8) == true) goto L14;
        r0 = new ReplyOption(wa8.t0.a, null, null);
        goto L14
    }

    public final void l0(z0 r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "item");
    }

    public final void w1(z0 r9, ReplyOption r10) {
        Intrinsics.checkNotNullParameter(r9, "item");
        Intrinsics.checkNotNullParameter(r10, "targetOption");
        com.larus.bmhome.instruction.g r0 = vc();
        if (r0 == null) goto L5;
        ReplyOption r1 = r0.Fe(r9);
    L7:
        if (Intrinsics.areEqual(r1, r10) == false) goto L10;
        FLogger.a.i("ObricSkillComponent", "onActionBarSecondMenuClick skip, itemId=" + r9.a + ", current=" + r1 + ", target=" + r10);
        return;
    L10:
        FLogger.a.i("ObricSkillComponent", "onActionBarSecondMenuClick close voice, itemId=" + r9.a + ", current=" + r1 + ", target=" + r10);
        com.obric.audio.continuous_talk.c r11 = (com.obric.audio.continuous_talk.c) this.s.getValue();
        boolean r12 = true;
        if (r11 != null) goto L13;
    L15:
        boolean r13 = false;
    L16:
        if (r13 == false) goto L21;
        com.obric.audio.continuous_talk.c r2 = (com.obric.audio.continuous_talk.c) this.s.getValue();
        if (r2 == null) goto L32;
        com.obric.audio.continuous_talk.c.a.a(r2, null, null, false, true, 7);
        return;
    L32:
        return;
    L21:
        maa.e r14 = (maa.e) this.r.getValue();
        if (r14 != null) goto L24;
    L26:
        r12 = false;
    L27:
        if (r12 == false) goto L33;
        maa.e r15 = (maa.e) this.r.getValue();
        if (r15 == null) goto L34;
        maa.e.a.a(r15, null, null, false, 7);
        return;
    L34:
        return;
    L33:
        return;
    L24:
        if (r14.gn() != true) goto L26;
    L13:
        if (r11.m0() != true) goto L15;
        r13 = true;
        goto L16
    L5:
        r1 = null;
        goto L7
    }

    public static boolean m3(ArrayList r4, Integer r5, boolean r6) {
        if (r5 == null) goto L58;
        r5.intValue();
        if (r4 == null) goto L59;
        Iterator r7 = r4.iterator();
    L7:
        Object r2 = null;
        if (r7.hasNext() == false) goto L15;
        Object r1 = r7.next();
        ModelItemIdentity r3 = ((b2) r1).b();
        if (r3 == null) goto L13;
        r2 = Integer.valueOf(r3.getDeprecatedItemId());
    L13:
        if (Intrinsics.areEqual(r2, r5) == false) goto L7;
        r2 = r1;
    L15:
        b2 r8 = (b2) r2;
        if (r8 == null) goto L62;
        List r9 = r8.j;
        if (r9 == null) goto L40;
        List r10 = r9;
        if ((r10 instanceof Collection) == true) goto L23;
    L25:
        Iterator r11 = r10.iterator();
    L27:
        if (r11.hasNext() == false) goto L37;
        Integer r12 = ((c2) r11.next()).getType();
        if (r12 != null) goto L32;
    L34:
        boolean r13 = false;
    L35:
        if (r13 == false) goto L27;
        boolean r14 = false;
    L38:
        if (r14 == true) goto L40;
        boolean r15 = true;
    L41:
        if (r15 == true) goto L60;
        if (r6 == false) goto L48;
        Integer r16 = r8.l;
        int r17 = AgentMode.MOA.getValue();
        if (r16 != null) goto L47;
        return false;
    L47:
        if (r16.intValue() == r17) goto L48;
        return false;
    L48:
        return true;
    L60:
        return false;
    L32:
        if (r12.intValue() != 5) goto L34;
        r13 = true;
    L37:
        r14 = true;
        goto L38
    L23:
        if (r10.isEmpty() == false) goto L25;
    L40:
        r15 = false;
        goto L41
    L62:
        return false;
    L59:
        return false;
    L58:
        return false;
    }

    public final void R0(List<z0> r3, wc9.e r4, BotModel r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "itemList");
        this.v.setValue(null);
        FLogger.a.i("ObricSkillComponent", "buildObricActionBarMenuItems, itemList: " + r3);
        if (r4 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L11;
        return;
    L11:
        Iterator<T> r8 = r3.iterator();
    L13:
        if (r8.hasNext() == false) goto L31;
        z0 r9 = (z0) r8.next();
        p0 r0 = r9.o;
        if (r0 == null) goto L22;
        Integer r1 = r0.a;
        int r2 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r1 == null) goto L22;
        if (r1.intValue() != r2) goto L22;
        boolean r10 = true;
    L23:
        if (r10 == false) goto L13;
        AtomicBoolean r11 = m.a;
        m.g(getContext(), r9);
        return;
    L22:
        r10 = false;
        goto L23
    L31:
        return;
    L5:
        if (com.larus.bmhome.utils.i.h(r4) == true) goto L8;
        r7 = false;
        goto L9
    }

    public final void t1(List<z0> r20, wc9.e r21, BotModel r22, String r23) {
        Intrinsics.checkNotNullParameter(r20, "itemList");
        String r4 = null;
        this.v.setValue(null);
        FLogger.a.i("ObricSkillComponent", "beforeActionBarItemsRender, itemList.size: " + r20.size());
        Iterator<T> r1 = r20.iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        Object r3 = r1.next();
        p0 r8 = ((z0) r3).o;
        if (r8 == null) goto L13;
        Integer r9 = r8.a;
        int r10 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r9 == null) goto L13;
        if (r9.intValue() != r10) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == false) goto L4;
    L17:
        z0 r5 = (z0) r3;
        if (r21 != null) goto L20;
    L23:
        boolean r2 = true;
    L24:
        ReplyOption r12 = this.u;
        if (r12 != null) goto L40;
        Lazy r13 = com.obric.assistant.actionbar.n.a;
        Intrinsics.checkNotNullParameter("beforeActionBarItemsRender", "reason");
        long r14 = com.obric.assistant.actionbar.n.b;
        if (com.obric.assistant.actionbar.n.c == false) goto L29;
    L35:
        FLogger.a.i("ObricOfficeTaskModeBackgroundResetManager", "shouldResetAfterBackground, reason=beforeActionBarItemsRender, shouldReset=" + com.obric.assistant.actionbar.n.c);
    L37:
        if (com.obric.assistant.actionbar.n.c == true) goto L40;
        boolean r15 = false;
    L41:
        if (r15 == false) goto L333;
        ReplyOption r16 = RepoDispatcherDelegate.b.c().S();
        if (r5 == null) goto L50;
        p0 r17 = r5.o;
        if (r17 == null) goto L50;
        a2 r18 = r17.d();
        if (r18 == null) goto L50;
        ArrayList r19 = r18.a;
    L51:
        if (r5 == null) goto L55;
        p0 r110 = r5.o;
        if (r110 == null) goto L55;
        ReplyOption r111 = r110.a();
    L56:
        if (r16 != null) goto L58;
        ReplyOption r112 = r111;
    L59:
        if (r2 == false) goto L61;
    L63:
        if (r5 == null) goto L67;
        p0 r113 = r5.o;
        if (r113 == null) goto L67;
        boolean r114 = Intrinsics.areEqual(r113.k, Boolean.TRUE);
    L68:
        if (r114 == false) goto L250;
        p0 r115 = r5.o;
        if (r115 == null) goto L76;
        s0 r116 = r115.j;
        if (r116 == null) goto L76;
        u0 r117 = r116.a;
        if (r117 == null) goto L76;
        List r118 = r117.a;
    L77:
        if (r118 != null) goto L79;
        r118 = CollectionsKt.emptyList();
    L79:
        p0 r119 = r5.o;
        if (r119 == null) goto L86;
        s0 r120 = r119.j;
        if (r120 == null) goto L86;
        a2 r121 = r120.b;
        if (r121 == null) goto L86;
        List r122 = r121.a;
    L87:
        if (r122 != null) goto L90;
        r122 = CollectionsKt.emptyList();
    L90:
        if (r118.isEmpty() == false) goto L92;
    L249:
        boolean r123 = true;
    L294:
        y r6 = u0();
        if (r6 == null) goto L299;
        wc9.e r7 = r6.h();
        if (r7 == null) goto L299;
        String r24 = r7.a;
    L300:
        if (r24 != null) goto L302;
    L305:
        if (r123 == false) goto L313;
        if (r12 != null) goto L308;
        ReplyOption r25 = r111;
    L309:
        this.u = r25;
        FLogger r26 = FLogger.a;
        StringBuilder r27 = new StringBuilder("resetNonQuickModeIfBackgroundTimedOut defer, reason=beforeActionBarItemsRender, targetReplyMode=");
        if (r12 != null) goto L312;
        r12 = r111;
    L312:
        r27.append(r12);
        r26.i("ObricSkillComponent", r27.toString());
    L323:
        r4 = null;
        goto L333
    L308:
        r25 = r12;
        goto L309
    L313:
        if (r12 == null) goto L316;
        Y2(r24, "beforeActionBarItemsRender");
        goto L323
    L316:
        if (n.b(r111) == true) goto L318;
    L320:
        com.larus.bmhome.instruction.g r28 = vc();
        if (r28 != null) goto L324;
        this.u = r111;
        FLogger.a.w("ObricSkillComponent", "resetNonQuickModeIfBackgroundTimedOut skip, ability is null, reason=beforeActionBarItemsRender");
        goto L323
    L324:
        if (r5 == null) goto L327;
        ReplyOption r29 = r28.Fe(r5);
        if (r29 == null) goto L327;
    L328:
        FLogger.a.i("ObricSkillComponent", "resetNonQuickModeIfBackgroundTimedOut, reason=beforeActionBarItemsRender, currentStatus=" + r29 + ", targetReplyMode=" + r111 + ", conversationId=" + r24);
        com.larus.bmhome.instruction.g.a.b(r28, r5, r111, false, 4);
        r4 = null;
        this.u = null;
        if (n.b(r111) == false) goto L331;
        com.obric.assistant.task.skill.f.b(r111);
    L332:
        com.larus.bmhome.view.actionbar.api.a.b("task_skill_action_bar_filter");
        com.obric.assistant.actionbar.n.a("reset:beforeActionBarItemsRender");
        KY();
        goto L333
    L331:
        com.obric.assistant.task.skill.f.c();
    L327:
        r29 = r28.Ql();
        goto L328
    L318:
        if (com.larus.bmhome.utils.i.g(r24) == true) goto L320;
        r111 = new ReplyOption(wa8.t0.a, null, null);
        goto L320
    L302:
        if (StringsKt.isBlank(r24) == true) goto L305;
        r123 = false;
    L299:
        r24 = null;
        goto L300
    L92:
        if (r122.isEmpty() == true) goto L249;
        if (n.b(r112) == true) goto L97;
    L99:
        a r124 = (a) this.p.getValue();
        if (r124 == null) goto L104;
        MutableLiveData r125 = r124.Zo();
        if (r125 == null) goto L104;
        boolean r126 = Intrinsics.areEqual(r125.getValue(), Boolean.TRUE);
    L105:
        String r127 = r112.getModeId();
        if (r127 == null) goto L115;
        Iterator r128 = r118.iterator();
    L109:
        if (r128.hasNext() == false) goto L113;
        Object r129 = r128.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.t0) r129).a, r127) == false) goto L109;
    L114:
        com.larus.bmhome.actionbar.model.t0 r30 = (com.larus.bmhome.actionbar.model.t0) r129;
    L116:
        List r130 = r122;
        Iterator r131 = r130.iterator();
    L118:
        if (r131.hasNext() == false) goto L123;
        Object r132 = r131.next();
        if (Intrinsics.areEqual(((b2) r132).b(), r112.getModel()) == false) goto L118;
    L124:
        b2 r133 = (b2) r132;
        if (r30 == null) goto L133;
        if (r126 == false) goto L132;
        Integer r31 = r30.j;
        int r32 = AgentMode.MOA.getValue();
        if (r31 == null) goto L133;
        if (r31.intValue() != r32) goto L133;
    L132:
        boolean r33 = true;
    L134:
        if (r133 == null) goto L141;
        z1 r34 = r133.n;
        if (r34 == null) goto L138;
        boolean r35 = Intrinsics.areEqual(r34.b, Boolean.TRUE);
    L139:
        if (r35 == true) goto L141;
        boolean r36 = true;
    L142:
        if (r33 == false) goto L189;
        if (r36 == false) goto L189;
        if (r30 == null) goto L166;
        List r37 = r30.n;
        if (r37 == null) goto L166;
        List r38 = r37;
        if ((r38 instanceof Collection) == true) goto L150;
    L152:
        Iterator r39 = r38.iterator();
    L154:
        if (r39.hasNext() == false) goto L162;
        ModelItemIdentity r40 = ((com.larus.bmhome.actionbar.model.o1) r39.next()).a();
        if (r133 == null) goto L158;
        ModelItemIdentity r41 = r133.b();
    L160:
        if (Intrinsics.areEqual(r40, r41) == false) goto L154;
        boolean r42 = true;
    L164:
        if (r42 != true) goto L166;
        boolean r43 = true;
    L167:
        if (r43 == false) goto L179;
        Integer r44 = r112.getReasoningEffort();
        if (r44 != null) goto L175;
        if (r133 == null) goto L174;
        u1 r45 = r133.t;
        if (r45 == null) goto L174;
        r44 = r45.b;
    L174:
        Integer r134 = null;
    L176:
        ReplyOption r46 = ReplyOption.copy$default(r112, null, null, r134, 3, null);
    L177:
        r111 = r46;
        r123 = true;
    L245:
        r112 = r111;
    L247:
        if (n.b(r112) == false) goto L272;
        r111 = ReplyOption.copy$default(r112, null, null, null, 3, null);
    L272:
        r111 = r112;
    L175:
        r134 = r44;
        goto L176
    L179:
        if (r133 == null) goto L181;
        String r47 = r133.s;
    L182:
        if (r133 == null) goto L186;
        u1 r48 = r133.t;
        if (r48 == null) goto L186;
        Integer r135 = r48.b;
    L187:
        r46 = ReplyOption.copy$default(r112, null, r47, r135, 1, null);
    L186:
        r135 = null;
        goto L187
    L181:
        r47 = null;
        goto L182
    L158:
        r41 = null;
    L162:
        r42 = false;
        goto L164
    L150:
        if (r38.isEmpty() == false) goto L152;
    L166:
        r43 = false;
    L189:
        if (r33 == true) goto L214;
        if (r36 == true) goto L214;
        Iterator r49 = r130.iterator();
    L193:
        if (r49.hasNext() == false) goto L201;
        Object r50 = r49.next();
        z1 r51 = ((b2) r50).n;
        if (r51 == null) goto L197;
        boolean r52 = Intrinsics.areEqual(r51.b, Boolean.TRUE);
    L198:
        r123 = true;
        if ((!r52) == false) goto L193;
    L202:
        b2 r53 = (b2) r50;
        if (r53 == null) goto L245;
        ModelItemIdentity r54 = r53.b();
        if (r54 == null) goto L211;
        String r136 = r53.s;
        u1 r55 = r53.t;
        if (r55 == null) goto L209;
        Integer r56 = r55.b;
    L210:
        ReplyOption r57 = new ReplyOption(r54, r136, r56);
    L212:
        if (r57 == null) goto L245;
        r112 = r57;
        goto L247
    L209:
        r56 = null;
        goto L210
    L211:
        r57 = null;
        goto L212
    L197:
        r52 = false;
        goto L198
    L201:
        r123 = true;
        r50 = null;
    L214:
        r123 = true;
        if (r33 == false) goto L217;
        if (r30 == null) goto L230;
        com.larus.bmhome.actionbar.model.o1 r58 = r30.m;
        if (r58 == null) goto L230;
        ModelItemIdentity r59 = r58.a();
    L231:
        ModelItemIdentity r137 = r59;
        Iterator r60 = r130.iterator();
    L233:
        if (r60.hasNext() == false) goto L237;
        Object r61 = r60.next();
        if (Intrinsics.areEqual(((b2) r61).b(), r137) == false) goto L233;
    L238:
        b2 r62 = (b2) r61;
        if (r62 == null) goto L243;
        u1 r63 = r62.t;
        if (r63 == null) goto L243;
        Integer r138 = r63.b;
    L244:
        r111 = ReplyOption.copy$default(r112, r137, null, r138, 2, null);
    L243:
        r138 = null;
        goto L244
    L237:
        r61 = null;
    L230:
        r59 = r112.getModel();
        goto L231
    L217:
        if (r133 == null) goto L219;
        String r64 = r133.s;
    L220:
        if (r133 == null) goto L224;
        u1 r65 = r133.t;
        if (r65 == null) goto L224;
        Integer r139 = r65.b;
    L225:
        r111 = ReplyOption.copy$default(r112, null, r64, r139, 1, null);
    L224:
        r139 = null;
        goto L225
    L219:
        r64 = null;
        goto L220
    L138:
        r35 = false;
    L141:
        r36 = false;
    L133:
        r33 = false;
        goto L134
    L123:
        r132 = null;
        goto L124
    L113:
        r129 = null;
        goto L114
    L115:
        r30 = null;
    L104:
        r126 = false;
        goto L105
    L97:
        if (m.h(r5) == true) goto L99;
        r111 = new ReplyOption(wa8.t0.a, null, null);
    L86:
        r122 = null;
    L76:
        r118 = null;
        goto L77
    L250:
        r123 = true;
        if (r19 != null) goto L253;
    L256:
        boolean r66 = true;
    L257:
        if (r66 == true) goto L294;
        if (n.b(r112) == true) goto L262;
    L264:
        a r67 = (a) this.p.getValue();
        if (r67 == null) goto L269;
        MutableLiveData r68 = r67.Zo();
        if (r68 == null) goto L269;
        boolean r69 = Intrinsics.areEqual(r68.getValue(), Boolean.TRUE);
    L271:
        if (m3(r19, Integer.valueOf(r112.getModel().getDeprecatedItemId()), r69) == true) goto L272;
        if (Intrinsics.areEqual(r111, r112) == false) goto L276;
    L278:
        Iterator r70 = r19.iterator();
    L280:
        if (r70.hasNext() == false) goto L288;
        Object r71 = r70.next();
        ModelItemIdentity r140 = ((b2) r71).b();
        if (r140 == null) goto L284;
        Integer r141 = Integer.valueOf(r140.getDeprecatedItemId());
    L286:
        if (m3(r19, r141, r69) == false) goto L280;
    L289:
        b2 r72 = (b2) r71;
        if (r72 == null) goto L294;
        ModelItemIdentity r73 = r72.b();
        if (r73 == null) goto L294;
        r111 = new ReplyOption(r73, null, null);
        goto L294
    L284:
        r141 = null;
        goto L286
    L288:
        r71 = null;
        goto L289
    L276:
        if (m3(r19, Integer.valueOf(r111.getModel().getDeprecatedItemId()), r69) == false) goto L278;
    L269:
        r69 = false;
        goto L271
    L262:
        if (m.h(r5) == false) goto L264;
    L253:
        if (r19.isEmpty() == true) goto L256;
        r66 = false;
    L67:
        r114 = false;
        goto L68
    L61:
        if (n.b(r112) == false) goto L63;
        r111 = new ReplyOption(wa8.t0.a, null, null);
        goto L249
    L58:
        r112 = r16;
    L55:
        r111 = new ReplyOption(wa8.t0.a, null, null);
    L50:
        r19 = null;
    L333:
        if (r2 == true) goto L345;
        StateFlowImpl r74 = this.v;
        if (r21 == null) goto L340;
        String r75 = r21.a;
        if (r75 == null) goto L340;
        r4 = r75;
    L343:
        r74.setValue(r4);
        return;
    L340:
        y r76 = u0();
        if (r76 == null) goto L343;
        r4 = r76.Y1();
        goto L343
    L345:
        com.larus.bmhome.instruction.g r77 = vc();
        if (r77 == null) goto L362;
        if (r5 == null) goto L351;
        ReplyOption r78 = r77.Fe(r5);
        if (r78 == null) goto L351;
    L353:
        if (n.b(r78) == false) goto L358;
        if (x1.a.a() == false) goto L358;
        h3(r5);
    L358:
        if (n.b(r78) == false) goto L360;
        com.obric.assistant.task.skill.f.b(r78);
        goto L362
    L360:
        com.obric.assistant.task.skill.f.c();
    L351:
        r78 = r77.Ql();
    L362:
        if (x1.a.a() == false) goto L364;
        h3(r5);
    L364:
        StateFlowImpl r79 = this.v;
        if (r21 == null) goto L370;
        String r80 = r21.a;
        if (r80 == null) goto L370;
        r4 = r80;
    L373:
        r79.setValue(r4);
        return;
    L370:
        y r81 = u0();
        if (r81 == null) goto L373;
        r4 = r81.Y1();
        goto L373
    L29:
        if (r14 <= 0) goto L35;
        long r142 = SystemClock.elapsedRealtime() - r14;
        if (r142 < ((Number) com.obric.assistant.actionbar.n.a.getValue()).longValue()) goto L33;
        boolean r143 = true;
    L34:
        com.obric.assistant.actionbar.n.c = r143;
        FLogger.a.i("ObricOfficeTaskModeBackgroundResetManager", "shouldResetAfterBackground calculate, reason=beforeActionBarItemsRender, elapsed=" + r142 + ", shouldReset=" + com.obric.assistant.actionbar.n.c);
        goto L37
    L33:
        r143 = false;
    L40:
        r15 = true;
        goto L41
    L20:
        if (com.larus.bmhome.utils.i.h(r21) == true) goto L23;
        r2 = false;
    L13:
        r11 = false;
        goto L14
    L16:
        r3 = null;
        goto L17
    }

    public final void D(View r1, ImageView r2, TextView r3, z0 r4, t1 r5) {
        Intrinsics.checkNotNullParameter(r1, "root");
        Intrinsics.checkNotNullParameter(r2, "icon");
        Intrinsics.checkNotNullParameter(r3, "nameView");
        Intrinsics.checkNotNullParameter(r5, "customActionBarHolderCallback");
    }
}
