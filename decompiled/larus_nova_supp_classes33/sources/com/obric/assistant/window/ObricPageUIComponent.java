package com.obric.assistant.window;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.adapter.MessageModifyMode;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.common_ui.widget.BaseConstraintLayout;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.authenticationsession.SessionAuthenticationStateView;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.util.m2;
import com.obric.assistant.window.materials.MaterialSceneType;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0002\u008a\u0001\u0018\u0000 ¬\u00012\u00020\u00012\u00020\u0002:\u0002¬\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u008d\u0001\u001a\u00020l*\u00030\u008e\u0001H\u0002J\n\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0016J\u0012\u0010\u0091\u0001\u001a\u00020l2\u0007\u0010\u0092\u0001\u001a\u00020}H\u0002J\n\u0010\u0093\u0001\u001a\u00030\u0090\u0001H\u0016J\u001c\u0010\u0094\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0095\u0001\u001a\u00020s2\u0007\u0010\u0096\u0001\u001a\u00020sH\u0016J\u0013\u0010\u0097\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0098\u0001\u001a\u00020\u0006H\u0002J\u0013\u0010\u0099\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u0006H\u0002J\u0013\u0010\u009b\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u0006H\u0016J\u0013\u0010\u009d\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u009e\u0001\u001a\u00020lH\u0016J\u0013\u0010\u009f\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u009e\u0001\u001a\u00020lH\u0016J\n\u0010 \u0001\u001a\u00030\u0090\u0001H\u0016J\n\u0010¡\u0001\u001a\u00030\u0090\u0001H\u0002J\u0011\u0010¢\u0001\u001a\u0004\u0018\u00010sH\u0016¢\u0006\u0003\u0010£\u0001J\u0014\u0010¤\u0001\u001a\u00030\u0090\u00012\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0016J\u0014\u0010§\u0001\u001a\u00030\u0090\u00012\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0016J\u0013\u0010¨\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u0006H\u0002J\t\u0010©\u0001\u001a\u00020lH\u0002J\u0014\u0010ª\u0001\u001a\u00030\u0090\u00012\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0002J\n\u0010«\u0001\u001a\u00030\u0090\u0001H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010 R\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b$\u0010%R\u001d\u0010'\u001a\u0004\u0018\u00010(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\r\u001a\u0004\b)\u0010*R\u001d\u0010,\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\r\u001a\u0004\b.\u0010/R\u001d\u00101\u001a\u0004\u0018\u0001028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\r\u001a\u0004\b3\u00104R\u001d\u00106\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\r\u001a\u0004\b8\u00109R\u001d\u0010;\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\r\u001a\u0004\b=\u0010>R\u001d\u0010@\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\r\u001a\u0004\bB\u0010CR\u001d\u0010E\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\r\u001a\u0004\bG\u0010HR\u001d\u0010J\u001a\u0004\u0018\u00010K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\r\u001a\u0004\bL\u0010MR\u001d\u0010O\u001a\u0004\u0018\u00010P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\r\u001a\u0004\bQ\u0010RR\u001d\u0010T\u001a\u0004\u0018\u00010U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\r\u001a\u0004\bV\u0010WR\u001d\u0010Y\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\r\u001a\u0004\b[\u0010\\R\u001d\u0010^\u001a\u0004\u0018\u00010_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\r\u001a\u0004\b`\u0010aR\u001d\u0010c\u001a\u0004\u0018\u00010d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010\r\u001a\u0004\be\u0010fR\u001d\u0010h\u001a\u0004\u0018\u00010d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bj\u0010\r\u001a\u0004\bi\u0010fR\u000e\u0010k\u001a\u00020lX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010o\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010pR\u000e\u0010q\u001a\u00020lX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020sX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010t\u001a\u00020d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010\r\u001a\u0004\bu\u0010fR\u001b\u0010w\u001a\u00020x8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\r\u001a\u0004\by\u0010zR\u001c\u0010|\u001a\u00020}8BX\u0082\u0084\u0002¢\u0006\r\n\u0005\b\u0080\u0001\u0010\r\u001a\u0004\b~\u0010\u007fR\u001e\u0010\u0081\u0001\u001a\u00020}8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010\r\u001a\u0005\b\u0082\u0001\u0010\u007fR \u0010\u0084\u0001\u001a\u00030\u0085\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0088\u0001\u0010\r\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0013\u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001R\u000f\u0010\u008c\u0001\u001a\u00020lX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u00ad\u0001"}, d2 = {"Lcom/obric/assistant/window/ObricPageUIComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/window/ability/IObricPageUIAbility;", "<init>", "()V", "maxRadius", "", "minRadius", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "Lkotlin/Lazy;", "extraViewAbility", "Lcom/obric/assistant/window/ability/IObricWindowExtraViewAbility;", "getExtraViewAbility", "()Lcom/obric/assistant/window/ability/IObricWindowExtraViewAbility;", "extraViewAbility$delegate", "titleAbility", "Lcom/obric/assistant/window/ability/IObricTitleAbility;", "getTitleAbility", "()Lcom/obric/assistant/window/ability/IObricTitleAbility;", "titleAbility$delegate", "windowStyleAbility", "Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "getWindowStyleAbility", "()Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "windowStyleAbility$delegate", "instructionAbility", "Lcom/obric/assistant/ability/chat/instruction/IObricInstructionAbility;", "getInstructionAbility", "()Lcom/obric/assistant/ability/chat/instruction/IObricInstructionAbility;", "instructionAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "obricAttachmentPanelAbility", "Lcom/obric/assistant/chat/bottom/sub/IObricAttachmentPanelAbility;", "getObricAttachmentPanelAbility", "()Lcom/obric/assistant/chat/bottom/sub/IObricAttachmentPanelAbility;", "obricAttachmentPanelAbility$delegate", "specialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "specialInputAbility$delegate", "referenceMsgAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getReferenceMsgAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "referenceMsgAbility$delegate", "listAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "listAbility$delegate", "obricMsgAbility", "Lcom/obric/assistant/window/ability/IObricMsgAbility;", "getObricMsgAbility", "()Lcom/obric/assistant/window/ability/IObricMsgAbility;", "obricMsgAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "intercomAbility", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "getIntercomAbility", "()Lcom/obric/assistant/ability/IObricIntercomAbility;", "intercomAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "messageListParent", "Landroid/widget/FrameLayout;", "getMessageListParent", "()Landroid/widget/FrameLayout;", "messageListParent$delegate", "titleContainer", "getTitleContainer", "titleContainer$delegate", "hasTriggeredHalfThreshold", "", "lastHalfThresholdFeedbackTime", "", "lastHalfThresholdProgress", "Ljava/lang/Float;", "pendingScrollToLatestBeforeFirstHalf", "currentTopEmptyHeight", "", "topMaskContainer", "getTopMaskContainer", "topMaskContainer$delegate", "realTopView", "Landroid/widget/RelativeLayout;", "getRealTopView", "()Landroid/widget/RelativeLayout;", "realTopView$delegate", "realBottomView", "Landroid/view/View;", "getRealBottomView", "()Landroid/view/View;", "realBottomView$delegate", "obricBackgroundView", "getObricBackgroundView", "obricBackgroundView$delegate", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable$delegate", "imeListener", "com/obric/assistant/window/ObricPageUIComponent$imeListener$1", "Lcom/obric/assistant/window/ObricPageUIComponent$imeListener$1;", "isFullScreenIme", "isImeAnimation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "init", "", "isFullScreenImeVisible", "root", "onDestroy", "setTopEmptyViewHeight", "height", "maxTopEmptyHeight", "checkHalfThresholdFeedback", "thresholdProgress", "changeTopMaskProgress", "progress", "changeBackgroundAlpha", "alpha", "closeInputAboveLayoutUi", "forceCloseAttachmentPanel", "closeInputAboveLayoutUiForFullScreenIme", "updateWindowBg", "restoreInputAboveLayoutUiAfterFullScreenIme", "getTopEmptyViewHeight", "()Ljava/lang/Integer;", "prepareScrollToLatestBeforeFirstHalf", WindowEvent.Params.REASON, "", "clearPendingScrollToLatestBeforeFirstHalf", "changeChatListAlpha", "shouldScrollToLatestBeforeFirstHalf", "tryScrollToLatestBeforeFirstHalf", "onChangeToHalfThreshold", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPageUIComponent extends BaseContentWidget implements xha.c {
    public static final /* synthetic */ int U = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public boolean I;
    public long J;
    public Float K;
    public boolean L;
    public int M;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public final Lazy Q;
    public final Lazy R;
    public final ObricPageUIComponent$imeListener$1 S;
    public boolean T;
    public final float m;
    public final float n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements Function0<com.larus.bmhome.chat.component.bottom.reference.a> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.reference.a.class));
        }
    }

    public static final class c implements Function0<u7> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(u7.class));
        }
    }

    public static final class d implements Function0<xha.b> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(xha.b.class));
        }
    }

    public static final class e implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public static final class f implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class g implements Function0<laa.f> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.f.class));
        }
    }

    public static final class h implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class i implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
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

    public static final class j implements Function0<xha.e> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(xha.e.class));
        }
    }

    public static final class k implements Function0<xha.d> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(xha.d.class));
        }
    }

    public static final class l implements Function0<laa.m> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.m.class));
        }
    }

    public static final class m implements Function0<qaa.a> {
        public final /* synthetic */ AttachReceiver a;

        public m(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(qaa.a.class));
        }
    }

    public static final class n implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public n(AttachReceiver r1) {
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

    public static final class o implements Function0<com.larus.bmhome.chat.component.bottom.attachment.g1> {
        public final /* synthetic */ AttachReceiver a;

        public o(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.attachment.g1.class));
        }
    }

    public static final class p implements Function0<ada.a> {
        public final /* synthetic */ AttachReceiver a;

        public p(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ada.a.class));
        }
    }

    public static final class q implements Function0<laa.j> {
        public final /* synthetic */ AttachReceiver a;

        public q(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    static {
    }

    @Override // xha.c
    public final void Bx() {
        Intrinsics.checkNotNullParameter("on_window_pre_open", WindowEvent.Params.REASON);
        if (this.L == false) goto L5;
        FLogger.a.i("ObricPageUIComponent", "clearPendingScrollToLatestBeforeFirstHalf, reason=on_window_pre_open");
    L5:
        this.L = false;
    }

    @Override // xha.c
    public final void Eh() {
        Intrinsics.checkNotNullParameter("on_window_pre_open", WindowEvent.Params.REASON);
        this.L = true;
        FLogger.a.i("ObricPageUIComponent", "prepareScrollToLatestBeforeFirstHalf, reason=on_window_pre_open");
    }

    public final void HJ() {
        laa.j r0 = (laa.j) this.w.getValue();
        if (r0 == null) goto L5;
        r0.HY();
    L5:
        ada.a r1 = (ada.a) this.v.getValue();
        if (r1 == null) goto L9;
        r1.HJ();
        return;
    }

    public final void Y2() {
        FLogger r0 = FLogger.a;
        r0.i("ObricPageUIComponent", "closeInputAboveLayoutUiForFullScreenIme");
        laa.j r2 = (laa.j) this.w.getValue();
        boolean r3 = true;
        if (r2 == null) goto L9;
        kotlinx.coroutines.flow.b1 r4 = r2.O4();
        if (r4 == null) goto L9;
        if (((Boolean) r4.getValue()).booleanValue() != true) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L14;
        laa.j r6 = (laa.j) this.w.getValue();
        if (r6 == null) goto L24;
        r6.td();
    L24:
        ada.a r7 = (ada.a) this.v.getValue();
        if (r7 == null) goto L27;
        r7.BH();
    L27:
        com.larus.bmhome.chat.component.bottom.reference.a r8 = g5();
        if (r8 != null) goto L30;
    L32:
        r3 = false;
    L33:
        if (r3 == false) goto L41;
        r0.i("ObricPageUIComponent", "closeInputAboveLayoutUiForFullScreenIme, clearReferenceMsg");
        com.larus.bmhome.chat.component.bottom.reference.a r1 = g5();
        if (r1 == null) goto L37;
        r1.sZ();
    L37:
        com.larus.bmhome.chat.component.bottom.reference.a r9 = g5();
        if (r9 == null) goto L42;
        r9.Ek(false);
        return;
    L42:
        return;
    L41:
        return;
    L30:
        if (r8.Qj() != true) goto L32;
    L14:
        com.larus.bmhome.instruction.g r10 = (com.larus.bmhome.instruction.g) this.t.getValue();
        if (r10 != null) goto L17;
    L19:
        boolean r11 = false;
    L20:
        if (r11 == false) goto L24;
        r0.i("ObricPageUIComponent", "closeInputAboveLayoutUiForFullScreenIme, closeInstructionEditor");
        com.larus.bmhome.instruction.g r12 = (com.larus.bmhome.instruction.g) this.t.getValue();
        if (r12 == null) goto L24;
        r12.A1();
        goto L24
    L17:
        if (r10.z0() != true) goto L19;
        r11 = true;
    L9:
        r5 = false;
        goto L10
    }

    public final com.larus.bmhome.chat.component.bottom.reference.a g5() {
        return (com.larus.bmhome.chat.component.bottom.reference.a) this.x.getValue();
    }

    public final laa.d h3() {
        return (laa.d) this.o.getValue();
    }

    @Override // xha.c
    public final void init() {
        if (((ViewGroup) this.F.getValue()) != null) goto L5;
        return;
    L5:
        BaseConstraintLayout r0 = (ViewGroup) this.F.getValue();
        if (r0 != null) goto L8;
        return;
    L8:
        if ((r0 instanceof BaseConstraintLayout) == false) goto L10;
        r0.setDisableTopPadding(true);
    L10:
        r0.setBackgroundColor(0);
        r0.setClipToPadding(false);
        r0.setClipChildren(false);
        int r2 = r0.getPaddingStart();
        int r3 = r0.getPaddingEnd();
        int r4 = r0.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r0.getClass().getSimpleName() + ",source:,start:" + r2 + ",top:0,end:" + r3 + ",bottom:" + r4);
        r0.setPaddingRelative(r2, 0, r3, r4);
        FrameLayout r5 = (FrameLayout) this.H.getValue();
        if (r5 == null) goto L20;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L19;
        ViewGroup.LayoutParams r7 = (ConstraintLayout.LayoutParams) r6;
        ((ConstraintLayout.LayoutParams) r7).topToTop = -1;
        ((ConstraintLayout.LayoutParams) r7).topToBottom = p3().getId();
        FrameLayout r8 = (FrameLayout) this.H.getValue();
        if (r8 == null) goto L17;
        r8.setLayoutParams(r7);
    L17:
        r5.setLayoutParams(r7);
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L20:
        RelativeLayout r9 = p3();
        ViewGroup.LayoutParams r10 = new ConstraintLayout.LayoutParams(-1, 0);
        ((ConstraintLayout.LayoutParams) r10).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r10).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r10).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r10).bottomToTop = 2131388843;
        Unit r11 = Unit.INSTANCE;
        r0.addView(r9, 0, r10);
        View r12 = (View) this.Q.getValue();
        ViewGroup.LayoutParams r13 = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams) r13).topToBottom = p3().getId();
        ((ConstraintLayout.LayoutParams) r13).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r13).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r13).bottomToBottom = 0;
        r0.addView(r12, 0, r13);
        View r14 = m3();
        com.larus.utils.i0.a.getClass();
        ViewGroup.LayoutParams r15 = new ConstraintLayout.LayoutParams(0, com.larus.utils.i0.e());
        ((ConstraintLayout.LayoutParams) r15).topToBottom = 2131364480;
        ((ConstraintLayout.LayoutParams) r15).startToStart = 0;
        r0.addView(r14, r15);
        xha.b r1 = (xha.b) this.z.getValue();
        if (r1 == null) goto L23;
        r1.Gi();
    L23:
        xha.d r16 = (xha.d) this.q.getValue();
        if (r16 == null) goto L26;
        r16.initTitle();
    L26:
        com.larus.utils.e1.d(p3(), new i1(this));
        p3().setOnTouchListener(new y0(this));
        p3().addView(new SessionAuthenticationStateView(r0.getContext()));
        if (m3().getParent() == null) goto L31;
        ViewCompat.setWindowInsetsAnimationCallback(m3(), this.S);
        ViewCompat.setOnApplyWindowInsetsListener(m3(), new z0(this));
        return;
    }

    public final View m3() {
        return (View) this.P.getValue();
    }

    public final void onDestroy() {
        FLogger.a.i("ObricPageUIComponent", "onDestroy " + hashCode());
        ViewCompat.setWindowInsetsAnimationCallback(m3(), null);
        ViewCompat.setOnApplyWindowInsetsListener(m3(), null);
    }

    public final RelativeLayout p3() {
        return (RelativeLayout) this.O.getValue();
    }

    @Override // xha.c
    public final void sk() {
        FLogger.a.i("ObricPageUIComponent", "updateWindowBg, isLandscape: " + s1a.a.d(this));
        if (s1a.a.e(this) == true) goto L5;
        return;
    L5:
        Lazy r0 = bia.g.a;
        View r1 = (View) this.Q.getValue();
        boolean r2 = s1a.a.e(this);
        if (s1a.a.d(this) == false) goto L8;
        MaterialSceneType r3 = MaterialSceneType.WINDOW_BG_WITH_BOTTOM_RADIUS;
    L9:
        bia.g.a(r1, r2, r3);
        return;
    L8:
        r3 = MaterialSceneType.WINDOW_BG;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v54, types: [com.obric.assistant.window.ObricPageUIComponent$imeListener$1] */
    public ObricPageUIComponent() {
        this.m = i5.Q();
        this.n = i5.e0();
        this.o = LazyKt.lazy(new i(this));
        this.p = LazyKt.lazy(new j(this));
        this.q = LazyKt.lazy(new k(this));
        this.r = LazyKt.lazy(new l(this));
        this.s = LazyKt.lazy(new m(this));
        this.t = LazyKt.lazy(new n(this));
        this.u = LazyKt.lazy(new o(this));
        this.v = LazyKt.lazy(new p(this));
        this.w = LazyKt.lazy(new q(this));
        this.x = LazyKt.lazy(new b(this));
        this.y = LazyKt.lazy(new c(this));
        this.z = LazyKt.lazy(new d(this));
        this.A = LazyKt.lazy(new e(this));
        this.B = LazyKt.lazy(new f(this));
        this.C = LazyKt.lazy(new g(this));
        this.D = LazyKt.lazy(new h(this));
        this.E = LazyKt.lazy(new x0(this));
        this.F = LazyKt.lazy(new a1(this));
        this.G = LazyKt.lazy(new b1(this));
        this.H = LazyKt.lazy(new c1(this));
        this.N = LazyKt.lazy(new d1(this));
        this.O = LazyKt.lazy(new e1(this));
        this.P = LazyKt.lazy(new f1(this));
        this.Q = LazyKt.lazy(new g1(this));
        this.R = LazyKt.lazy(new h1(this));
        this.S = new ObricPageUIComponent$imeListener$1(this);
    }

    @Override // xha.c
    public final Integer w40() {
        ViewGroup.LayoutParams r0 = p3().getLayoutParams();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.height);
    }

    public static boolean z3(View r2) {
        WindowInsetsCompat r3 = ViewCompat.getRootWindowInsets(r2);
        if (r3 == null) goto L5;
        Insets r4 = r3.getInsets(WindowInsetsCompat.Type.ime());
    L7:
        if (r4 == null) goto L9;
        int r5 = r4.bottom;
    L11:
        if (r5 <= 100) goto L14;
        return true;
    L14:
        return false;
    L9:
        r5 = 0;
        goto L11
    L5:
        r4 = null;
        goto L7
    }

    @Override // xha.c
    public final void J40(boolean r6) {
        FLogger r0 = FLogger.a;
        r0.i("ObricPageUIComponent", "closeInputAboveLayoutUiOnWindowHidden");
        laa.j r2 = (laa.j) this.w.getValue();
        if (r2 == null) goto L5;
        r2.ed();
    L5:
        ICoreInputAbility r3 = (ICoreInputAbility) this.B.getValue();
        if (r3 == null) goto L8;
        MessageModifyMode r4 = r3.FF();
    L10:
        if (r4 == null) goto L14;
        r0.i("ObricPageUIComponent", "closeInputAboveLayoutUiOnWindowHidden, finishModify");
        ICoreInputAbility r5 = (ICoreInputAbility) this.B.getValue();
        if (r5 == null) goto L14;
        r5.WM(false, false);
    L14:
        com.larus.bmhome.instruction.g r7 = (com.larus.bmhome.instruction.g) this.t.getValue();
        boolean r8 = true;
        if (r7 != null) goto L17;
    L19:
        boolean r9 = false;
    L20:
        if (r9 == false) goto L24;
        r0.i("ObricPageUIComponent", "closeInputAboveLayoutUiOnWindowHidden, closeInstructionEditor");
        com.larus.bmhome.instruction.g r10 = (com.larus.bmhome.instruction.g) this.t.getValue();
        if (r10 == null) goto L24;
        r10.A1();
    L24:
        if (r6 == true) goto L41;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r11 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.u.getValue();
        if (r11 != null) goto L28;
    L30:
        boolean r12 = false;
    L31:
        if (r12 == false) goto L44;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r13 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.u.getValue();
        if (r13 == null) goto L39;
        List r14 = r13.q1();
        if (r14 == null) goto L39;
        if (r14.isEmpty() == true) goto L39;
        boolean r15 = true;
    L40:
        if (r15 == true) goto L44;
    L39:
        r15 = false;
    L44:
        com.larus.bmhome.chat.component.bottom.reference.a r16 = g5();
        if (r16 != null) goto L47;
    L49:
        r8 = false;
    L50:
        if (r8 == false) goto L58;
        r0.i("ObricPageUIComponent", "closeInputAboveLayoutUiOnWindowHidden, clearReferenceMsg");
        com.larus.bmhome.chat.component.bottom.reference.a r17 = g5();
        if (r17 == null) goto L54;
        r17.sZ();
    L54:
        com.larus.bmhome.chat.component.bottom.reference.a r18 = g5();
        if (r18 == null) goto L59;
        r18.Ek(false);
        return;
    L59:
        return;
    L58:
        return;
    L47:
        if (r16.Qj() != true) goto L49;
    L28:
        if (r11.isVisible() != true) goto L30;
        r12 = true;
    L41:
        r0.i("ObricPageUIComponent", "closeInputAboveLayoutUiOnWindowHidden, closeAttachmentPanel");
        com.larus.bmhome.chat.component.bottom.attachment.g1 r19 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.u.getValue();
        if (r19 == null) goto L44;
        r19.W0();
        goto L44
    L17:
        if (r7.z0() != true) goto L19;
        r9 = true;
        goto L20
    L8:
        r4 = null;
        goto L10
    }

    @Override // xha.c
    public final void em(float r2) {
        ((View) this.Q.getValue()).setAlpha(r2);
    }

    @Override // xha.c
    public final void xb(int r21, int r22) {
        if (r21 >= 0) goto L5;
        return;
    L5:
        int r4 = RangesKt.coerceAtLeast(r22, 0);
        this.M = RangesKt.coerceIn(r21, 0, r4);
        ViewGroup r5 = (ViewGroup) this.F.getValue();
        if (r5 == null) goto L8;
        r5.invalidateOutline();
    L8:
        int r6 = r4 - this.M;
        laa.d r7 = h3();
        if (r7 == null) goto L11;
        ObricFloatChatPageState r8 = r7.getPageState();
    L12:
        ObricFloatChatPageData.Companion.getClass();
        boolean r9 = r8 instanceof vda.c;
        laa.d r10 = h3();
        if (r10 != null) goto L15;
    L17:
        boolean r11 = false;
    L18:
        boolean r12 = r8 instanceof vda.e;
        boolean r13 = r8 instanceof vda.b;
        if (r8 == null) goto L23;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if ((r8 instanceof com.obric.assistant.data.a) != true) goto L23;
        boolean r14 = true;
    L24:
        if (r11 == true) goto L30;
        if (r9 == true) goto L30;
        if (r13 == true) goto L30;
        if (r14 == true) goto L30;
        boolean r15 = false;
    L31:
        RelativeLayout r16 = p3();
        if (this.M != 0) goto L34;
        int r17 = 8;
    L35:
        r16.setVisibility(r17);
        if (r21 > r4) goto L49;
        RelativeLayout r18 = p3();
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L48;
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r19;
        ((ViewGroup.MarginLayoutParams) r3).height = this.M;
        r18.setLayoutParams(r3);
        if (r15 == true) goto L42;
    L46:
        Pair r20 = new Pair(Float.valueOf(-i5.k0()), Float.valueOf(1.0f));
    L54:
        float r23 = ((Number) r20.component1()).floatValue();
        float r24 = ((Number) r20.component2()).floatValue();
        xha.e r110 = (xha.e) this.p.getValue();
        if (r110 == null) goto L57;
        r110.Z20(Float.valueOf(r23));
    L57:
        xha.d r25 = (xha.d) this.q.getValue();
        if (r25 == null) goto L60;
        r25.Y60(r24);
    L60:
        em(r24);
        FrameLayout r26 = (FrameLayout) this.G.getValue();
        if (r26 != null) goto L64;
        int r111 = r6;
        r8 = r8;
    L111:
        FLogger r27 = FLogger.a;
        StringBuilder r28 = new StringBuilder("setTopEmptyViewHeight alpha debug, isDragging=");
        r28.append(r9);
        r28.append(", isChatWindowState=");
        r28.append(r11);
        r28.append(", isHalfWindowState=");
        r28.append(r12);
        r28.append(", isDismiss=");
        r28.append(r13);
        r28.append(", isUnknown=");
        r28.append(r14);
        r28.append(", shouldCalculateAlphaByHeight=");
        r28.append(r15);
        r28.append(", height is ");
        r28.append(r21);
        r28.append(", maxTopEmptyHeight is ");
        r28.append(r22);
        r28.append(", safeMaxTopEmptyHeight is ");
        r28.append(r4);
        r28.append(", currentTopEmptyHeight is ");
        r28.append(this.M);
        r28.append(", diff is ");
        int r29 = r111;
        r28.append(r29);
        r28.append(", alpha is ");
        r28.append(r24);
        r27.i("ObricPageUIComponent", r28.toString());
        if (r29 >= 0) goto L114;
    L116:
        boolean r2 = false;
    L117:
        if (r2 == false) goto L119;
        float r30 = r29 / i5.k0();
    L122:
        if (r15 == true) goto L125;
        r30 = 1.0f;
    L125:
        if (r21 > m2.b) goto L127;
        r30 = 1.0f;
    L127:
        laa.d r1 = h3();
        if (r1 == null) goto L130;
        ObricFloatChatPageState r31 = r1.getPageState();
    L132:
        if (r30 > 0.0f) goto L148;
        if (r31 == null) goto L137;
        boolean r32 = true;
        if ((r31 instanceof vda.e) != true) goto L138;
        boolean r112 = true;
    L139:
        if (r112 == true) goto L148;
        if (r31 != null) goto L142;
    L144:
        boolean r33 = false;
    L145:
        if (r33 == true) goto L148;
        boolean r34 = false;
    L149:
        if (r34 == false) goto L151;
        float r35 = 0.0f;
        float r36 = RangesKt.coerceIn(r30, 0.0f, 1.0f);
    L152:
        ((FrameLayout) this.N.getValue()).setAlpha(r36);
        if (r34 == true) goto L155;
    L161:
        com.larus.utils.e1.q((FrameLayout) this.N.getValue());
    L163:
        if (r30 < 0.3f) goto L165;
        boolean r37 = true;
    L166:
        laa.m r38 = (laa.m) this.r.getValue();
        if (r38 == null) goto L169;
        r38.uA(1.0f - r30, r37);
    L169:
        qaa.a r39 = (qaa.a) this.s.getValue();
        if (r39 == null) goto L172;
        r39.j00(1.0f - r30, r37);
    L172:
        if (r12 == false) goto L179;
        if (r8 == null) goto L175;
        ObricFloatChatPageState r40 = r8.getPreviousState();
    L177:
        if ((r40 instanceof vda.b) == false) goto L179;
        boolean r41 = true;
    L180:
        if (r41 == false) goto L188;
        if (r8 != null) goto L183;
    L185:
        boolean r42 = false;
    L186:
        if (r42 == false) goto L188;
        r27.i("ObricPageUIComponent", "skip scrollToLatest when restore half window state from pop, pageState=" + r8);
    L192:
        Float r43 = this.K;
        if (r43 != null) goto L195;
    L203:
        boolean r44 = false;
    L204:
        this.K = Float.valueOf(r30);
        laa.d r45 = h3();
        if (r45 == null) goto L207;
        ObricFloatChatPageState r46 = r45.getPageState();
    L208:
        boolean r47 = r46 instanceof vda.c;
        if (r47 == true) goto L211;
    L212:
        this.I = false;
    L213:
        if (r47 == true) goto L215;
        return;
    L215:
        if (this.I == true) goto L224;
        if (r44 == false) goto L225;
        long r48 = SystemClock.elapsedRealtime();
        if ((r48 - this.J) < 300) goto L226;
        this.I = true;
        this.J = r48;
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_TICK);
        return;
    L226:
        return;
    L225:
        return;
    L224:
        return;
    L211:
        if (r30 > 0.75f) goto L213;
    L207:
        r46 = null;
        goto L208
    L195:
        if (r43.floatValue() < 1.0f) goto L197;
    L199:
        boolean r49 = false;
    L201:
        if (r49 != true) goto L203;
        r44 = true;
        goto L204
    L197:
        if (r30 < 1.0f) goto L199;
        r49 = true;
        goto L201
    L183:
        if (r8.getOnlyChangeState() != true) goto L185;
        r42 = true;
    L188:
        if (r41 == false) goto L192;
        u7 r50 = (u7) this.y.getValue();
        if (r50 == null) goto L192;
        r50.TP(false);
        goto L192
    L175:
        r40 = null;
    L179:
        r41 = false;
        goto L180
    L165:
        r37 = false;
        goto L166
    L155:
        if (r36 != r35) goto L157;
        boolean r51 = true;
    L158:
        if (r51 == true) goto L161;
        com.larus.utils.e1.x((FrameLayout) this.N.getValue());
        goto L163
    L157:
        r51 = false;
        goto L158
    L151:
        r35 = 0.0f;
        r36 = 0.0f;
        goto L152
    L142:
        if ((r31 instanceof vda.c) != r32) goto L144;
        r33 = true;
    L138:
        r112 = false;
        goto L139
    L137:
        r32 = true;
    L148:
        r34 = true;
        goto L149
    L130:
        r31 = null;
        goto L132
    L119:
        if (r29 >= 0) goto L121;
        r30 = 0.0f;
        goto L122
    L121:
        r30 = 1.0f;
        goto L122
    L114:
        if (r29 > i5.k0()) goto L116;
        r2 = true;
        goto L117
    L64:
        if (r24 > 0.0f) goto L66;
    L73:
        boolean r113 = false;
    L74:
        if (r113 == false) goto L103;
        laa.d r114 = h3();
        if (r114 == null) goto L78;
        ObricFloatChatPageState r115 = r114.getPageState();
    L79:
        boolean r52 = this.L;
        r111 = r6;
        if (r52 == true) goto L82;
    L86:
        boolean r53 = false;
    L87:
        if (r53 == false) goto L104;
        if (r52 == false) goto L104;
        this.L = false;
        va8.l r54 = (va8.l) this.E.getValue();
        if (r54 == null) goto L93;
        RecyclerView r55 = r54.getMessageList();
    L95:
        if ((r55 instanceof com.larus.bmhome.chat.api.b0) == false) goto L97;
        com.larus.bmhome.chat.api.b0 r56 = (com.larus.bmhome.chat.api.b0) r55;
    L98:
        if (r56 == null) goto L100;
        r56.setBottomReached(true);
    L100:
        FLogger.a.i("ObricPageUIComponent", "tryScrollToLatestBeforeFirstHalf, reason=change_chat_list_alpha");
        u7 r57 = (u7) this.y.getValue();
        if (r57 == null) goto L104;
        r57.TP(true);
        goto L104
    L97:
        r56 = null;
        goto L98
    L93:
        r55 = null;
    L104:
        r26.setAlpha(r24);
        if (r24 != 0.0f) goto L107;
        boolean r58 = true;
    L108:
        if (r58 == false) goto L110;
        com.larus.utils.e1.q(r26);
        goto L111
    L110:
        com.larus.utils.e1.x(r26);
        goto L111
    L107:
        r58 = false;
        goto L108
    L82:
        if ((r115 instanceof vda.e) == false) goto L84;
    L85:
        r53 = true;
        goto L87
    L84:
        if ((r115 instanceof vda.c) == false) goto L86;
    L78:
        r115 = null;
        goto L79
    L103:
        r111 = r6;
        r8 = r8;
        goto L104
    L66:
        if (r26.getVisibility() == 0) goto L68;
    L72:
        r113 = true;
        goto L74
    L68:
        if (r26.getAlpha() != 0.0f) goto L70;
        boolean r116 = true;
    L71:
        if (r116 == false) goto L73;
    L70:
        r116 = false;
        goto L71
    L42:
        if (r6 > i5.k0()) goto L46;
        if (s1a.a.d(this) == true) goto L46;
        float r117 = r6;
        r20 = new Pair(Float.valueOf(-r117), Float.valueOf(r117 / i5.k0()));
        goto L54
    L48:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L49:
        Float r118 = Float.valueOf(0.0f);
        if (s1a.a.d(this) == false) goto L52;
        float r59 = 1.0f;
    L53:
        r20 = new Pair(r118, Float.valueOf(r59));
        goto L54
    L52:
        r59 = 0.0f;
        goto L53
    L34:
        r17 = 0;
    L30:
        r15 = true;
    L23:
        r14 = false;
        goto L24
    L15:
        if (r10.aF() != true) goto L17;
        r11 = true;
        goto L18
    L11:
        r8 = null;
        goto L12
    }
}
