package com.obric.assistant.chat.component.bottom.attachment;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.view.resourcebar.ResourceBar;
import com.larus.common_ui.view.SuggestedActionBar;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.task.skill.m;
import com.obric.assistant.window.materials.MaterialSceneType;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.b1;
import laa.j;
import v19.i5;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0019\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\\B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020DH\u0016J\u0010\u0010F\u001a\u00020D2\u0006\u0010G\u001a\u000200H\u0016J\b\u0010H\u001a\u00020DH\u0016J\u0010\u0010I\u001a\u00020D2\u0006\u0010J\u001a\u000200H\u0016J\b\u0010K\u001a\u00020DH\u0016J\b\u0010L\u001a\u00020DH\u0002J\b\u0010M\u001a\u00020DH\u0002J\b\u0010N\u001a\u00020DH\u0002J\b\u0010O\u001a\u00020DH\u0002J\b\u0010P\u001a\u00020DH\u0002J\u0010\u0010Q\u001a\u00020D2\u0006\u0010R\u001a\u00020<H\u0002J\u0010\u0010S\u001a\u00020D2\u0006\u0010R\u001a\u00020<H\u0002J\b\u0010T\u001a\u000200H\u0002J\b\u0010U\u001a\u000200H\u0002J\b\u0010V\u001a\u000200H\u0016J\b\u0010W\u001a\u00020DH\u0002J\b\u0010X\u001a\u000200H\u0002J\b\u0010Y\u001a\u000200H\u0002J\b\u0010Z\u001a\u00020DH\u0002J\u0010\u0010[\u001a\u00020D2\u0006\u0010G\u001a\u000200H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0004\n\u0002\u00109R\u000e\u0010:\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u0002060@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/obric/assistant/chat/component/bottom/attachment/ConfigAttachmentPanelComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "Lcom/obric/assistant/chat/bottom/sub/IObricAttachmentPanelAbility;", "<init>", "()V", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatPageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getChatPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "chatPageStateAbility$delegate", "continuousTalkCtrlAbility", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "getContinuousTalkCtrlAbility", "()Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "continuousTalkCtrlAbility$delegate", "continuousTalkUIAbility", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkAbility;", "getContinuousTalkUIAbility", "()Lcom/obric/audio/continuous_talk/IObricContinuousTalkAbility;", "continuousTalkUIAbility$delegate", "suggestedActionAbility", "Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "getSuggestedActionAbility", "()Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "suggestedActionAbility$delegate", "specialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "specialInputAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "isAttachmentPanelHiddenByFullScreenIme", NameKeys.UnloadStrategy_No_Strategy, "isSuggestedActionBarHiddenByFullScreenIme", "isSuggestedActionBarDividerHiddenByFullScreenIme", "attachmentSuggestedActionSceneFilterApplied", "taskModeStatusLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "currentTaskModeStatus", NameKeys.UnloadStrategy_No_Strategy, "Ljava/lang/Integer;", "skillExtensionUsable", "pendingSkillBarRefreshReason", NameKeys.UnloadStrategy_No_Strategy, "phoneOperationSkillBarRefreshRunnable", "Ljava/lang/Runnable;", "taskModeStatusObserver", "Landroidx/lifecycle/Observer;", "phoneOperationModeChangeListener", "Lcom/obric/assistant/task/skill/ObricTaskSkillModeController$ModeChangeListener;", "onParentViewCreated", NameKeys.UnloadStrategy_No_Strategy, "onFragmentViewDestroyed", "onChatStyleChanged", "isChatWindow", "onInitAndShowMultiAttachmentArea", "hideInputAboveLayoutUiForFullScreenIme", "forceHideAttachmentPanel", "restoreInputAboveLayoutUiAfterFullScreenIme", "hideAttachmentPanelForFullScreenIme", "hideSuggestedActionBarForFullScreenIme", "restoreAttachmentPanelAfterFullScreenIme", "restoreSuggestedActionBarAfterFullScreenIme", "observePhoneOperationAttachmentSkillBarState", "scheduleRefreshPhoneOperationAttachmentSkillBar", "reason", "refreshPhoneOperationAttachmentSkillBar", "isPhoneOperationAttachmentScene", "hasVisibleAttachment", "isPhoneOperationAttachmentSkillBarTakenOver", "ensureAttachmentSuggestedActionSceneFilter", "shouldSuppressPublicAttachmentSuggestedAction", "isPhoneOperationModeActive", "clearAttachmentSuggestedActionSceneFilter", "setMultiAttachmentAreaBackground", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConfigAttachmentPanelComponent extends ComponentFeature implements hca.b, ada.a {
    public static final /* synthetic */ int A = 0;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public LiveData<ReplyOption> t;
    public Integer u;
    public boolean v;
    public String w;
    public final com.obric.assistant.chat.component.bottom.attachment.a x;
    public final com.obric.assistant.chat.component.bottom.attachment.b y;
    public final com.obric.assistant.chat.component.bottom.attachment.c z;

    public static final class a {
    }

    public static final class b implements Function0<g1> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(g1.class));
        }
    }

    public static final class c implements Function0<o> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(o.class));
        }
    }

    public static final class d implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
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

    public static final class e implements Function0<com.obric.audio.continuous_talk.c> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
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

    public static final class f implements Function0<com.obric.audio.continuous_talk.b> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.b.class));
        }
    }

    public static final class g implements Function0<bc8.a> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(bc8.a.class));
        }
    }

    public static final class h implements Function0<j> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(j.class));
        }
    }

    public static final class i implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
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

    static {
    }

    @Override // ada.a
    public final void be() {
    }

    public final void A2() {
        CopyOnWriteArraySet r0 = com.obric.assistant.task.skill.f.a;
        com.obric.assistant.chat.component.bottom.attachment.c r1 = this.z;
        Intrinsics.checkNotNullParameter(r1, "listener");
        com.obric.assistant.task.skill.f.a.remove(r1);
        laa.d r2 = (laa.d) this.j.getValue();
        if (r2 == null) goto L5;
        r2.AN(this);
    L5:
        LiveData<ReplyOption> r3 = this.t;
        if (r3 == null) goto L8;
        r3.removeObserver(this.y);
    L8:
        this.t = null;
        bc8.a r4 = aE();
        if (r4 == null) goto L13;
        SuggestedActionBar r5 = r4.JU();
        if (r5 == null) goto L13;
        r5.removeCallbacks(this.x);
    L13:
        this.u = null;
        this.v = false;
        if (this.s == false) goto L21;
        g1 r6 = f70();
        if (r6 == null) goto L19;
        r6.yQ(null);
    L19:
        this.s = false;
        return;
    }

    public final void B2() {
        FLogger r0 = FLogger.a;
        r0.i("ConfigAttachmentPanelComponent", "onParentViewCreated");
        if (((laa.d) this.j.getValue()) != null) goto L5;
        r0.w("ConfigAttachmentPanelComponent", "onParentViewCreated: not found chatPageStateAbility");
    L5:
        laa.d r1 = (laa.d) this.j.getValue();
        if (r1 == null) goto L9;
        r1.HU(this);
    L9:
        if (this.s == true) goto L15;
        g1 r2 = f70();
        if (r2 == null) goto L15;
        r2.yQ(new com.obric.assistant.chat.component.bottom.attachment.d(this));
        this.s = true;
    L15:
        com.larus.bmhome.instruction.g r3 = (com.larus.bmhome.instruction.g) this.o.getValue();
        if (r3 == null) goto L22;
        ReplyOption r4 = r3.Ql();
        if (r4 == null) goto L22;
        ModelItemIdentity r5 = r4.getModel();
        if (r5 == null) goto L22;
        Integer r6 = Integer.valueOf(r5.getDeprecatedItemId());
    L23:
        this.u = r6;
        this.v = com.obric.assistant.special_input.j.b();
        com.larus.bmhome.instruction.g r7 = (com.larus.bmhome.instruction.g) this.o.getValue();
        if (r7 == null) goto L28;
        MutableLiveData r8 = r7.zU();
        if (r8 == null) goto L28;
        LiveData<ReplyOption> r9 = Transformations.distinctUntilChanged(r8);
    L29:
        this.t = r9;
        if (r9 == null) goto L32;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r9.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), this.y);
    L32:
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), null, null, new ConfigAttachmentPanelComponent$observePhoneOperationAttachmentSkillBarState$1(this, null), 3, null);
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), null, null, new ConfigAttachmentPanelComponent$observePhoneOperationAttachmentSkillBarState$2(this, null), 3, null);
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), null, null, new ConfigAttachmentPanelComponent$observePhoneOperationAttachmentSkillBarState$3(this, null), 3, null);
        CopyOnWriteArraySet r10 = com.obric.assistant.task.skill.f.a;
        com.obric.assistant.task.skill.f.a(this.z);
        F2("view_created");
        return;
    L28:
        r9 = null;
    L22:
        r6 = null;
        goto L23
    }

    @Override // ada.a
    public final void BH() {
        FLogger r0 = FLogger.a;
        r0.i("ConfigAttachmentPanelComponent", "hideInputAboveLayoutUiForFullScreenIme: forceHideAttachmentPanel = true");
        g1 r2 = f70();
        View r3 = null;
        if (r2 == null) goto L5;
        ViewGroup r4 = r2.YK();
    L6:
        boolean r5 = false;
        if (r4 != null) goto L9;
    L11:
        boolean r6 = false;
    L13:
        if (r6 == true) goto L15;
    L18:
        bc8.a r7 = aE();
        if (r7 == null) goto L21;
        SuggestedActionBar r8 = r7.JU();
    L22:
        if (r8 != null) goto L24;
    L26:
        boolean r9 = false;
    L27:
        if (r9 == true) goto L29;
    L31:
        bc8.a r1 = aE();
        if (r1 == null) goto L34;
        r3 = r1.y8();
    L34:
        if (r3 != null) goto L36;
    L38:
        if (r5 == true) goto L40;
        return;
    L40:
        if (this.r == true) goto L44;
        r3.setVisibility(8);
        this.r = true;
        return;
    L44:
        return;
    L36:
        if (r3.getVisibility() != 0) goto L38;
        r5 = true;
        goto L38
    L29:
        if (this.q == true) goto L31;
        r0.i("ConfigAttachmentPanelComponent", "hideSuggestedActionBarForFullScreenIme");
        r8.setVisibility(8);
        this.q = true;
        goto L31
    L24:
        if (r8.getVisibility() != 0) goto L26;
        r9 = true;
        goto L27
    L21:
        r8 = null;
        goto L22
    L15:
        if (this.p == true) goto L18;
        r0.i("ConfigAttachmentPanelComponent", "hideAttachmentPanelForFullScreenIme");
        r4.setVisibility(8);
        this.p = true;
        goto L18
    L9:
        if (r4.getVisibility() != 0) goto L11;
        r6 = true;
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    @Override // ada.a
    public final void HJ() {
        if (this.p == false) goto L12;
        FLogger.a.i("ConfigAttachmentPanelComponent", "restoreAttachmentPanelAfterFullScreenIme");
        g1 r0 = f70();
        if (r0 == null) goto L10;
        ViewGroup r1 = r0.YK();
        if (r1 == null) goto L10;
        r1.setVisibility(0);
    L10:
        this.p = false;
    L12:
        if (this.q == false) goto L20;
        FLogger.a.i("ConfigAttachmentPanelComponent", "restoreSuggestedActionBarAfterFullScreenIme");
        bc8.a r2 = aE();
        if (r2 == null) goto L18;
        SuggestedActionBar r3 = r2.JU();
        if (r3 == null) goto L18;
        r3.setVisibility(0);
    L18:
        this.q = false;
    L20:
        if (this.r == false) goto L28;
        bc8.a r4 = aE();
        if (r4 == null) goto L26;
        View r5 = r4.y8();
        if (r5 == null) goto L26;
        r5.setVisibility(0);
    L26:
        this.r = false;
        return;
    }

    public final boolean L2() {
        AtomicBoolean r0 = m.a;
        if (m.j(this.u) == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L27;
        j r2 = (j) this.n.getValue();
        if (r2 == null) goto L17;
        b1 r3 = r2.O4();
        if (r3 == null) goto L17;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == true) goto L27;
        g1 r5 = f70();
        if (r5 == null) goto L24;
        b1 r6 = r5.Ry();
        if (r6 == null) goto L24;
        boolean r7 = ((Boolean) r6.getValue()).booleanValue();
    L25:
        if (r7 == false) goto L27;
        boolean r8 = true;
    L28:
        if (r8 == true) goto L36;
        j r9 = (j) this.n.getValue();
        if (r9 != null) goto L32;
    L34:
        boolean r10 = false;
    L35:
        if (r10 == true) goto L36;
        return false;
    L32:
        if (r9.J70() != true) goto L34;
        r10 = true;
    L36:
        return true;
    L24:
        r7 = false;
    L17:
        r4 = false;
    L27:
        r8 = false;
        goto L28
    L5:
        if (com.obric.assistant.task.skill.f.d() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final bc8.a aE() {
        return (bc8.a) this.m.getValue();
    }

    @Override // ada.a
    public final void b4() {
        FLogger r0 = FLogger.a;
        r0.i("ConfigAttachmentPanelComponent", "onInitAndShowMultiAttachmentArea");
        if (((laa.d) this.j.getValue()) != null) goto L5;
        r0.w("ConfigAttachmentPanelComponent", "onInitAndShowMultiAttachmentArea: not found chatPageStateAbility");
    L5:
        g1 r2 = f70();
        boolean r3 = false;
        if (r2 == null) goto L10;
        ViewGroup r4 = r2.YK();
        if (r4 == null) goto L10;
        r4.setVisibility(0);
    L10:
        laa.d r5 = (laa.d) this.j.getValue();
        if (r5 != null) goto L13;
    L15:
        boolean r6 = false;
    L16:
        r0.i("ConfigAttachmentPanelComponent", "setMultiAttachmentAreaBackground: isChatWindow = " + r6);
        if (f70() != null) goto L19;
        r0.w("ConfigAttachmentPanelComponent", "setMultiAttachmentAreaBackground: not found attachmentPanelAbility");
    L42:
        F2("attachment_panel_shown");
        com.obric.audio.continuous_talk.b r1 = (com.obric.audio.continuous_talk.b) this.l.getValue();
        if (r1 != null) goto L45;
    L47:
        if (r3 == false) goto L52;
        com.obric.audio.continuous_talk.c r7 = (com.obric.audio.continuous_talk.c) this.k.getValue();
        if (r7 == null) goto L53;
        com.obric.audio.continuous_talk.c.a.a(r7, null, null, false, true, 7);
        return;
    L53:
        return;
    L52:
        return;
    L45:
        if (r1.m0() != true) goto L47;
        r3 = true;
        goto L47
    L19:
        o r8 = (o) this.i.getValue();
        Boolean r9 = null;
        if (r8 == null) goto L24;
        com.larus.bmhome.chat.component.bottom.core.a r10 = r8.Uv();
        if (r10 == null) goto L24;
        ResourceBar r11 = r10.x();
    L25:
        if (r11 == null) goto L31;
        Lazy r12 = bia.g.a;
        Boolean r13 = Boolean.valueOf(bia.g.a(r11, s1a.a.e(this), MaterialSceneType.INPUT));
        if (r13.booleanValue() == false) goto L29;
        r9 = r13;
    L29:
        if (r9 == null) goto L31;
        r9.booleanValue();
    L31:
        if (r6 == false) goto L42;
        boolean r14 = v19.h.a;
        boolean r15 = v19.h.b(getContext());
        r0.i("ConfigAttachmentPanelComponent", "setMultiAttachmentAreaBackground: isNightMode = " + r15);
        if (r15 == false) goto L39;
        float[] r16 = {i5.q(), i5.q(), i5.q(), i5.q(), 0.0f, 0.0f, 0.0f, 0.0f};
        GradientDrawable r17 = new GradientDrawable();
        r17.setShape(0);
        r17.setCornerRadii(r16);
        r17.setColor(ContextCompat.getColor(getContext(), 2131100491));
        if (r11 == null) goto L38;
        r11.setBackground(r17);
    L38:
        r0.i("ConfigAttachmentPanelComponent", "use custom background");
        goto L42
    L39:
        if (r11 == null) goto L41;
        r11.setBackgroundResource(2131238608);
    L41:
        r0.i("ConfigAttachmentPanelComponent", "use default background");
    L24:
        r11 = null;
        goto L25
    L13:
        if (r5.aF() != true) goto L15;
        r6 = true;
        goto L16
    }

    public final g1 f70() {
        return (g1) this.h.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [com.obric.assistant.chat.component.bottom.attachment.a] */
    /* JADX WARN: Type inference failed for: r0v18, types: [com.obric.assistant.chat.component.bottom.attachment.b] */
    /* JADX WARN: Type inference failed for: r0v19, types: [com.obric.assistant.chat.component.bottom.attachment.c] */
    public ConfigAttachmentPanelComponent() {
        this.h = LazyKt.lazy(new b(this));
        this.i = LazyKt.lazy(new c(this));
        this.j = LazyKt.lazy(new d(this));
        this.k = LazyKt.lazy(new e(this));
        this.l = LazyKt.lazy(new f(this));
        this.m = LazyKt.lazy(new g(this));
        this.n = LazyKt.lazy(new h(this));
        this.o = LazyKt.lazy(new i(this));
        this.w = "unknown";
        this.x = new com.obric.assistant.chat.component.bottom.attachment.a(this);
        this.y = new com.obric.assistant.chat.component.bottom.attachment.b(this);
        this.z = new com.obric.assistant.chat.component.bottom.attachment.c(this);
    }

    public final void F2(String r3) {
        if (this.s == true) goto L9;
        g1 r0 = f70();
        if (r0 == null) goto L9;
        r0.yQ(new com.obric.assistant.chat.component.bottom.attachment.d(this));
        this.s = true;
    L9:
        this.w = r3;
        bc8.a r4 = aE();
        if (r4 == null) goto L12;
        SuggestedActionBar r5 = r4.JU();
    L13:
        if (r5 != null) goto L18;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r6 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r6 == null) goto L20;
        r6.post(this.x);
        return;
    L20:
        return;
    L18:
        r5.removeCallbacks(this.x);
        r5.post(this.x);
        return;
    L12:
        r5 = null;
        goto L13
    }

    public final void r2(boolean r4) {
        FLogger.a.i("ConfigAttachmentPanelComponent", "onChatStyleChanged: isChatWindow = " + r4);
    }

    public final void x1(ObricFloatChatPageState r2) {
        Intrinsics.checkNotNullParameter(r2, "pageState");
    }
}
