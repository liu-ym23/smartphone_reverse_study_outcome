package com.larus.bmhome.chat.component.bottom.floating;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.floating.button.BottomFloatingButton;
import com.larus.bmhome.chat.component.bottom.floating.button.ButtonType;
import com.larus.bmhome.chat.component.bottom.floating.collect.CollectFrom;
import com.larus.bmhome.chat.component.collection.o;
import com.larus.bmhome.chat.component.collection.o$a;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.layout.holder.helper.m0;
import com.larus.bmhome.chat.layout.holder.helper.q1;
import com.larus.bmhome.chat.layout.holder.helper.t;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.bmhome.chat.layout.holder.helper.u2;
import com.larus.bmhome.collection.CollectionReportDelegate;
import com.larus.bmhome.databinding.LarusPageChatBottomFloatingButtonBinding;
import com.larus.bmhome.view.FastScrollButton;
import com.larus.bmhome.view.a2;
import com.larus.bmhome.view.b2;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z1;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.SafeExtKt;
import com.larus.utils.b1;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ld8.g;
import ld8.h;
import ld8.i;
import ld8.j;
import ld8.k;
import ld8.l;
import ld8.m;
import ld8.n;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004*\u0001n\u0018\u0000 p2\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004:\u0001pB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\n\u00105\u001a\u0004\u0018\u00010)H\u0002J\u0010\u00106\u001a\u00020&2\u0006\u00107\u001a\u00020\"H\u0016J\b\u00108\u001a\u00020&H\u0016J\u0010\u00109\u001a\u0002002\u0006\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020&H\u0016J\b\u0010=\u001a\u00020&H\u0002J\b\u0010>\u001a\u00020&H\u0002J\u0018\u0010?\u001a\u00020&2\u0006\u0010:\u001a\u00020;2\u0006\u0010@\u001a\u000204H\u0016J\u0010\u0010A\u001a\u00020&2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u000204H\u0016J\u0010\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u000200H\u0002J\u0010\u0010F\u001a\u00020&2\u0006\u0010E\u001a\u000200H\u0002J\u0010\u0010G\u001a\u00020&2\u0006\u0010E\u001a\u000200H\u0002J\u0010\u0010H\u001a\u00020&2\u0006\u0010E\u001a\u000200H\u0002J\u0010\u0010I\u001a\u00020&2\u0006\u0010E\u001a\u000200H\u0002J\u0010\u0010J\u001a\u00020&2\u0006\u0010E\u001a\u000200H\u0002J\u0010\u0010K\u001a\u0002002\u0006\u0010E\u001a\u000200H\u0002J\u0012\u0010L\u001a\u00020&2\b\b\u0002\u0010M\u001a\u000204H\u0002J\b\u0010N\u001a\u00020&H\u0002J\u0010\u0010O\u001a\u00020&2\u0006\u0010E\u001a\u000200H\u0002J\b\u0010Q\u001a\u00020&H\u0002J\u0012\u0010R\u001a\u00020&2\b\b\u0002\u0010M\u001a\u000204H\u0002J\b\u0010S\u001a\u00020&H\u0002J\u0010\u0010T\u001a\u0002042\u0006\u0010U\u001a\u000200H\u0016J\u0010\u0010V\u001a\u00020&2\u0006\u0010?\u001a\u000204H\u0016J3\u0010W\u001a\u00020&2\u0006\u0010U\u001a\u0002002!\u0010W\u001a\u001d\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H\u0016J\u0018\u0010X\u001a\u0002042\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0016J\b\u0010]\u001a\u000204H\u0016J\u0012\u0010^\u001a\u0002042\b\u0010_\u001a\u0004\u0018\u00010\\H\u0016J\u0010\u0010`\u001a\u00020&2\u0006\u0010a\u001a\u00020bH\u0016J\b\u0010c\u001a\u00020\u001dH\u0016J\b\u0010d\u001a\u00020&H\u0016J\n\u0010e\u001a\u0004\u0018\u00010fH\u0016J\b\u0010g\u001a\u00020&H\u0016J\u0010\u0010h\u001a\u00020&2\u0006\u0010i\u001a\u00020\\H\u0002J,\u0010j\u001a\u00020&2\u0006\u0010Y\u001a\u00020Z2\b\u0010k\u001a\u0004\u0018\u00010l2\b\u0010_\u001a\u0004\u0018\u00010\\2\u0006\u0010:\u001a\u00020;H\u0002R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010'\u001a\u001f\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R+\u00102\u001a\u001f\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u00020nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010o¨\u0006q"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/floating/BottomFloatingButtonComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "Lcom/larus/bmhome/audio/IChatBottomFloatingApiAbility;", "<init>", "()V", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "collectionAbility", "Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "getCollectionAbility", "()Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "collectionAbility$delegate", "listComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "listComponentAbility$delegate", "shareAbility", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "getShareAbility", "()Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "shareAbility$delegate", "totalY", "", "bindingViewStub", "Landroid/view/ViewStub;", "onFastButtonClicked", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "it", "", "onBackChatButtonClicked", "binding", "Lcom/larus/bmhome/databinding/LarusPageChatBottomFloatingButtonBinding;", "getBinding", "()Lcom/larus/bmhome/databinding/LarusPageChatBottomFloatingButtonBinding;", "showAnimator", "Landroid/animation/AnimatorSet;", "hideAnimator", "currentType", "Lcom/larus/bmhome/chat/component/bottom/floating/BottomFloatingButtonType;", "lastType", "longImageButtonClickListener", "isForceHide", "", "initBinding", "onViewCreated", "view", "onAttach", "findTargetType", "action", "Lcom/larus/bmhome/chat/component/bottom/floating/BottomFloatingButtonAction;", "onDestroy", "cancelHideAnimation", "cancelShowAnimation", "show", "isForce", "hide", "setForceHide", "forceHide", "dispatchAnimation", "targetType", "dispatchTypeNone", "dispatchTypeFastScroll", "dispatchTypeBackChat", "dispatchTypeShareLongImage", "dispatchTypeShareLongImageScrolled", "dispatchTypeGuideCollect", "showFastScrollButtonWithAnimation", "isFastBackChat", "showFastScrollButtonFromShareLongImageButton", "showFloatingBottomButtonWithAnimation", "expendWidthAnimator", "showViewNewsWithAnimation", "hideFastScrollButtonWithAnimation", "hideFloatingBottomButtonWithAnimation", "isShow", "type", "resumeFastScrollButton", "onClick", "guideAddCollectIfNeed", "from", "Lcom/larus/bmhome/chat/component/bottom/floating/collect/CollectFrom;", "msgId", "", "guideLookLikeIfNeed", "guideLookCollectIfNeed", "collectId", "addFastButtonTranslationY", "y", "", "getFastButtonTranslationY", "recoverFastButtonTranslationY", "fastScrollIconLayoutTarget", "Landroid/widget/ImageView;", "hideFastScrollButton", "logFastScrollButtonState", "source", "showGuideCollectTip", "msg", "Lcom/larus/im/bean/message/Message;", "floatingBottomButtonDependency", "com/larus/bmhome/chat/component/bottom/floating/BottomFloatingButtonComponent$floatingBottomButtonDependency$1", "Lcom/larus/bmhome/chat/component/bottom/floating/BottomFloatingButtonComponent$floatingBottomButtonDependency$1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BottomFloatingButtonComponent extends BaseContentWidget implements n, xa8.a {
    public static final Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> D = null;
    public boolean A;
    public AnimatorSet B;
    public final c C;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public float q;
    public ViewStub r;
    public Function1<? super View, Unit> s;
    public Function1<? super View, Unit> t;
    public LarusPageChatBottomFloatingButtonBinding u;
    public AnimatorSet v;
    public AnimatorSet w;
    public BottomFloatingButtonType x;
    public BottomFloatingButtonType y;
    public Function1<? super View, Unit> z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[BottomFloatingButtonType.values().length];
            r0[BottomFloatingButtonType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L35:
            r0[BottomFloatingButtonType.FAST_SCROLL_BUTTON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L53:
            r0[BottomFloatingButtonType.SHARE_LONG_IMAGE_BUTTON.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[BottomFloatingButtonType.SHARE_LONG_IMAGE_BUTTON_SCROLLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L43:
            r0[BottomFloatingButtonType.ADD_COLLECT_TIP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[BottomFloatingButtonType.LOOK_COLLECT_TIP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L47:
            r0[BottomFloatingButtonType.BACK_CHAT_BUTTON.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L49:
            r0[BottomFloatingButtonType.VIEW_NEW_NEWS_BUTTON.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L37:
            r0[BottomFloatingButtonType.CHECK_FAST_SCROLL_BUTTON.ordinal()] = 9;     // Catch: NoSuchFieldError -> L27
        L41:
            r0[BottomFloatingButtonType.CHECK_SHARE_LONG_IMAGE_BUTTON.ordinal()] = 10;     // Catch: NoSuchFieldError -> L28
        L14:
            a = r0;
            int[] r1 = new int[CollectFrom.values().length];
            r1[CollectFrom.COPY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L31:
            r1[CollectFrom.LIKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L17:
            b = r1;
        }
    }

    public static final class c implements BottomFloatingButton.b {
        public md8.a a;
        public final /* synthetic */ BottomFloatingButtonComponent b;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ButtonType.values().length];
                r0[ButtonType.SHARE_LONG_IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[ButtonType.ADD_COLLECT_COPY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[ButtonType.ADD_COLLECT_LIKE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[ButtonType.LOOK_COLLECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[ButtonType.LOOK_LIKE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        @Override // com.larus.bmhome.chat.component.bottom.floating.button.BottomFloatingButton.b
        public final void a() {
            this.b.m60(BottomFloatingButtonAction.AUTO_HIDE);
        }

        public final void c() {
            FLogger.a.i("BottomFloatingButtonComponent", "collect, data:" + this.a);
            md8.a r0 = this.a;
            if (r0 == null) goto L31;
            CollectFrom r1 = r0.a;
            if (r1 == null) goto L35;
            Message r2 = r0.b;
            if (r2 == null) goto L36;
            BottomFloatingButtonComponent r3 = this.b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r4 = BottomFloatingButtonComponent.D;
            u7 r5 = (u7) r3.o.getValue();
            if (r5 == null) goto L32;
            List r6 = r5.zj();
            if (r6 == null) goto L37;
            IChatMessageShareAbility r7 = (IChatMessageShareAbility) this.b.p.getValue();
            if (r7 == null) goto L33;
            List r8 = r7.Us(r2, r6);
            if (r8 == null) goto L38;
            o r9 = (o) this.b.n.getValue();
            if (r9 == null) goto L34;
            Intrinsics.checkNotNullParameter(r1, "<this>");
            int r10 = md8.c.a[r1.ordinal()];
            if (r10 != 1) goto L25;
            String r11 = "copy";
        L29:
            final BottomFloatingButtonComponent r12 = this.b;
            o$a.b(r9, "toast_after_other_action", r11, r8, new i(r12, this));
            return;
        L25:
            if (r10 == 2) goto L27;
            r11 = "None";
            goto L29
        L27:
            r11 = "like";
            goto L29
        L34:
            return;
        L38:
            return;
        L33:
            return;
        L37:
            return;
        L32:
            return;
        L36:
            return;
        L35:
            return;
        }

        public c(BottomFloatingButtonComponent r1) {
            this.b = r1;
        }

        public final void d(String r5) {
            FLogger.a.i("BottomFloatingButtonComponent", "lookCollect");
            md8.a r0 = this.a;
            if (r0 == null) goto L27;
            CollectFrom r1 = r0.a;
            if (r1 == null) goto L30;
            CollectionReportDelegate r2 = CollectionReportDelegate.b;
            if (r5 != null) goto L10;
            r5 = r0.c;
        L10:
            Intrinsics.checkNotNullParameter(r1, "<this>");
            int r3 = md8.c.a[r1.ordinal()];
            if (r3 != 1) goto L13;
            String r4 = "copy";
        L17:
            by7.e r6 = s1a.a.c(this.b);
            if ((r6 instanceof by7.e) == false) goto L20;
            by7.e r7 = r6;
        L21:
            r2.a(r5, "collected_check", r4, r7);
            z1.a.b(s1a.a.c(this.b), "MY_COLLECT");
            BottomFloatingButtonComponent r8 = this.b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r9 = BottomFloatingButtonComponent.D;
            LarusPageChatBottomFloatingButtonBinding r10 = r8.m3();
            if (r10 == null) goto L28;
            FrameLayout r11 = r10.a;
            if (r11 == null) goto L29;
            final BottomFloatingButtonComponent r12 = this.b;
            SafeExtKt.b(r11, new k(r12), 500);
            return;
        L29:
            return;
        L28:
            return;
        L20:
            r7 = null;
            goto L21
        L13:
            if (r3 == 2) goto L15;
            r4 = "None";
            goto L17
        L15:
            r4 = "like";
            goto L17
        L30:
            return;
        }

        @Override // com.larus.bmhome.chat.component.bottom.floating.button.BottomFloatingButton.b
        public final void b(BottomFloatingButton r4, ButtonType r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            Intrinsics.checkNotNullParameter(r5, "type");
            int r6 = a.a[r5.ordinal()];
            if (r6 != 1) goto L5;
            Function1<? super View, Unit> r7 = this.b.z;
            if (r7 == null) goto L38;
            r7.invoke(r4);
            return;
        L38:
            return;
        L5:
            if (r6 == 2) goto L24;
            if (r6 == 3) goto L21;
            if (r6 != 4) goto L11;
            d(null);
            return;
        L11:
            if (r6 != 5) goto L18;
            FLogger.a.i("BottomFloatingButtonComponent", "lookLike");
            z1.a.b(s1a.a.c(this.b), "MY_LIKE");
            BottomFloatingButtonComponent r8 = this.b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r9 = BottomFloatingButtonComponent.D;
            LarusPageChatBottomFloatingButtonBinding r10 = r8.m3();
            if (r10 == null) goto L30;
            FrameLayout r11 = r10.a;
            if (r11 == null) goto L31;
            final BottomFloatingButtonComponent r12 = this.b;
            SafeExtKt.b(r11, new j(r12), 500);
            return;
        L31:
            return;
        L30:
            return;
        L18:
            throw new NoWhenBranchMatchedException();
        L21:
            if (AppHost.a.isPlugin() == true) goto L34;
            c();
            return;
        L34:
            return;
        L24:
            if (AppHost.a.isPlugin() == true) goto L36;
            c();
            return;
        }
    }

    public static final class d implements Animator.AnimatorListener {
        public final /* synthetic */ BottomFloatingButtonComponent a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ LarusPageChatBottomFloatingButtonBinding c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            BottomFloatingButtonComponent r4 = this.a;
            String r0 = "hide_fast_animation_cancel isFastBackChat=" + this.b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r1 = BottomFloatingButtonComponent.D;
            r4.B3(r0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            this.c.a.setVisibility(8);
            if (this.b == false) goto L5;
            this.c.c.setVisibility(0);
            this.c.e.setVisibility(8);
        L6:
            this.c.f.setVisibility(8);
            this.c.d.setBackground(null);
            ViewGroup.LayoutParams r4 = this.c.c.getLayoutParams();
            r4.width = i5.s0();
            this.c.c.setLayoutParams(r4);
            this.c.b.b();
            BottomFloatingButtonComponent r5 = this.a;
            r5.w = null;
            r5.B3("hide_fast_animation_end isFastBackChat=" + this.b);
            return;
        L5:
            this.c.c.setVisibility(8);
            this.c.e.setVisibility(0);
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            BottomFloatingButtonComponent r4 = this.a;
            String r0 = "hide_fast_animation_start isFastBackChat=" + this.b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r1 = BottomFloatingButtonComponent.D;
            r4.B3(r0);
        }

        public d(BottomFloatingButtonComponent r1, boolean r2, LarusPageChatBottomFloatingButtonBinding r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class e implements Animator.AnimatorListener {
        public final /* synthetic */ LarusPageChatBottomFloatingButtonBinding a;
        public final /* synthetic */ BottomFloatingButtonComponent b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.a.setVisibility(8);
            this.a.e.setVisibility(8);
            this.a.b.b();
            this.b.w = null;
        }

        public e(LarusPageChatBottomFloatingButtonBinding r1, BottomFloatingButtonComponent r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class f implements Animator.AnimatorListener {
        public final /* synthetic */ BottomFloatingButtonComponent a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ LarusPageChatBottomFloatingButtonBinding c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            BottomFloatingButtonComponent r4 = this.a;
            String r0 = "show_fast_animation_cancel isFastBackChat=" + this.b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r1 = BottomFloatingButtonComponent.D;
            r4.B3(r0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            BottomFloatingButtonComponent r4 = this.a;
            String r0 = "show_fast_animation_end isFastBackChat=" + this.b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r1 = BottomFloatingButtonComponent.D;
            r4.B3(r0);
            this.a.v = null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            BottomFloatingButtonComponent r4 = this.a;
            String r0 = "show_fast_animation_start isFastBackChat=" + this.b;
            Map<Pair<BottomFloatingButtonType, BottomFloatingButtonAction>, BottomFloatingButtonType> r1 = BottomFloatingButtonComponent.D;
            r4.B3(r0);
            this.c.a.setVisibility(0);
            if (this.b == false) goto L5;
            this.c.c.setVisibility(0);
            this.c.e.setVisibility(8);
        L6:
            this.c.b.b();
            return;
        L5:
            this.c.c.setVisibility(8);
            this.c.e.setVisibility(0);
            goto L6
        }

        public f(BottomFloatingButtonComponent r1, boolean r2, LarusPageChatBottomFloatingButtonBinding r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        BottomFloatingButtonType r2 = BottomFloatingButtonType.NONE;
        BottomFloatingButtonAction r3 = BottomFloatingButtonAction.SCROLL_UP;
        Pair r1 = new Pair(r2, r3);
        BottomFloatingButtonType r4 = BottomFloatingButtonType.FAST_SCROLL_BUTTON;
        BottomFloatingButtonAction r5 = BottomFloatingButtonAction.SCROLL_DOWN;
        BottomFloatingButtonAction r6 = BottomFloatingButtonAction.AUTO_HIDE;
        BottomFloatingButtonAction r7 = BottomFloatingButtonAction.SCREENSHOT;
        Pair r8 = new Pair(r2, r7);
        BottomFloatingButtonType r9 = BottomFloatingButtonType.SHARE_LONG_IMAGE_BUTTON;
        BottomFloatingButtonAction r10 = BottomFloatingButtonAction.SHOW_ADD_COLLECT_TIP;
        Pair r11 = new Pair(r2, r10);
        BottomFloatingButtonType r12 = BottomFloatingButtonType.ADD_COLLECT_TIP;
        BottomFloatingButtonAction r13 = BottomFloatingButtonAction.SHOW_LOOK_COLLECT_TIP;
        Pair r14 = new Pair(r2, r13);
        BottomFloatingButtonType r15 = BottomFloatingButtonType.LOOK_COLLECT_TIP;
        BottomFloatingButtonAction r16 = BottomFloatingButtonAction.BACK_CHAT;
        Pair r17 = new Pair(r2, r16);
        BottomFloatingButtonType r18 = BottomFloatingButtonType.BACK_CHAT_BUTTON;
        Pair r19 = new Pair(r4, r7);
        BottomFloatingButtonType r110 = BottomFloatingButtonType.SHARE_LONG_IMAGE_BUTTON_SCROLLED;
        Pair r20 = new Pair(r12, r6);
        BottomFloatingButtonType r21 = BottomFloatingButtonType.CHECK_FAST_SCROLL_BUTTON;
        Pair r22 = new Pair(r12, r7);
        BottomFloatingButtonType r23 = BottomFloatingButtonType.CHECK_SHARE_LONG_IMAGE_BUTTON;
        BottomFloatingButtonAction r24 = BottomFloatingButtonAction.VIEW_NEW_NEWS;
        Pair r25 = new Pair(r18, r24);
        BottomFloatingButtonType r26 = BottomFloatingButtonType.VIEW_NEW_NEWS_BUTTON;
        D = MapsKt.mapOf(new Pair[]{TuplesKt.to(r1, r4), TuplesKt.to(new Pair(r2, r5), r2), TuplesKt.to(new Pair(r2, r6), r2), TuplesKt.to(r8, r9), TuplesKt.to(r11, r12), TuplesKt.to(r14, r15), TuplesKt.to(r17, r18), TuplesKt.to(new Pair(r4, r3), r4), TuplesKt.to(new Pair(r4, r6), r4), TuplesKt.to(r19, r110), TuplesKt.to(new Pair(r4, r5), r2), TuplesKt.to(new Pair(r4, r10), r12), TuplesKt.to(new Pair(r4, r13), r15), TuplesKt.to(new Pair(r4, r16), r18), TuplesKt.to(new Pair(r9, r3), r110), TuplesKt.to(new Pair(r9, r7), r9), TuplesKt.to(new Pair(r9, r5), r9), TuplesKt.to(new Pair(r9, r6), r2), TuplesKt.to(new Pair(r9, r10), r12), TuplesKt.to(new Pair(r9, r13), r15), TuplesKt.to(new Pair(r9, r16), r110), TuplesKt.to(new Pair(r110, r3), r110), TuplesKt.to(new Pair(r110, r7), r110), TuplesKt.to(new Pair(r110, r6), r4), TuplesKt.to(new Pair(r110, r5), r9), TuplesKt.to(new Pair(r110, r10), r12), TuplesKt.to(new Pair(r110, r13), r15), TuplesKt.to(new Pair(r110, r16), r110), TuplesKt.to(new Pair(r12, r3), r12), TuplesKt.to(new Pair(r12, r5), r12), TuplesKt.to(r20, r21), TuplesKt.to(r22, r23), TuplesKt.to(new Pair(r12, r10), r12), TuplesKt.to(new Pair(r12, r13), r15), TuplesKt.to(new Pair(r12, r16), r12), TuplesKt.to(new Pair(r15, r3), r15), TuplesKt.to(new Pair(r15, r5), r15), TuplesKt.to(new Pair(r15, r6), r21), TuplesKt.to(new Pair(r15, r7), r23), TuplesKt.to(new Pair(r15, r10), r12), TuplesKt.to(new Pair(r15, r13), r15), TuplesKt.to(new Pair(r15, r16), r15), TuplesKt.to(new Pair(r18, r3), r4), TuplesKt.to(new Pair(r18, r5), r18), TuplesKt.to(new Pair(r18, r6), r18), TuplesKt.to(new Pair(r18, r7), r110), TuplesKt.to(new Pair(r18, r10), r12), TuplesKt.to(new Pair(r18, r13), r15), TuplesKt.to(new Pair(r18, r16), r18), TuplesKt.to(new Pair(r18, BottomFloatingButtonAction.HIDE_BACK_CHAT), r2), TuplesKt.to(r25, r26), TuplesKt.to(new Pair(r26, r3), r26), TuplesKt.to(new Pair(r26, r5), r26), TuplesKt.to(new Pair(r26, r24), r26)});
    }

    @Override // ld8.n
    public final void RZ() {
        B3("hide_fast_scroll_button_direct");
        LarusPageChatBottomFloatingButtonBinding r0 = m3();
        if (r0 == null) goto L6;
        r0.e.setVisibility(8);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, ld8.f] */
    public final LarusPageChatBottomFloatingButtonBinding m3() {
        if (this.u != null) goto L27;
        ViewStub r0 = this.r;
        LarusPageChatBottomFloatingButtonBinding r1 = null;
        if (r0 == null) goto L25;
        r0.setLayoutResource(2131563011);
        View r2 = r0.inflate();
        if (r2 == null) goto L25;
        ConstraintLayout.LayoutParams r3 = new ConstraintLayout.LayoutParams(-2, -2);
        r3.topToTop = 2131375324;
        r3.startToStart = 0;
        r3.endToEnd = 0;
        r2.setLayoutParams(r3);
        r2.setTranslationZ(1.0f);
        int r4 = 2131364425;
        final BottomFloatingButton r5 = (BottomFloatingButton) ViewBindings.findChildViewById(r2, 2131364425);
        if (r5 == null) goto L24;
        r4 = 2131372135;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r2, 2131372135);
        if (r11 == null) goto L24;
        r4 = 2131372136;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r2, 2131372136);
        if (r8 == null) goto L24;
        r4 = 2131372137;
        FastScrollButton r12 = ViewBindings.findChildViewById(r2, 2131372137);
        if (r12 == null) goto L24;
        r4 = 2131390200;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r2, 2131390200);
        if (r10 == null) goto L24;
        LarusPageChatBottomFloatingButtonBinding r6 = new LarusPageChatBottomFloatingButtonBinding((FrameLayout) r2, r5, r11, r8, r12, r10);
        final c r7 = this.C;
        Intrinsics.checkNotNullParameter(r7, "dependency");
        r5.a = r7;
        e1.d(r5, new com.larus.bmhome.chat.component.bottom.floating.button.b(r5, r7));
        ?? r9 = new ld8.f(this);
        Intrinsics.checkNotNullParameter(r9, "onClick");
        r12.d.setOnTouchListener(new a2(r12));
        ImageView r13 = r12.d;
        b2 r14 = new b2(r12, r9);
        Intrinsics.checkNotNullParameter(r14, "onClick");
        if (r13 == null) goto L22;
        r13.setTag(123400001, 100L);
        r13.setOnClickListener(new b1(r13, r14));
    L22:
        r11.setOnClickListener(new g(this));
        this.r = null;
        r1 = r6;
    L24:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r4)));
    L25:
        this.u = r1;
    L27:
        return this.u;
    }

    public final void onDestroy() {
        AnimatorSet r0 = this.w;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.w = null;
        AnimatorSet r1 = this.v;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.v = null;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, n.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, xa8.a.class);
    }

    public BottomFloatingButtonComponent() {
        this.m = LazyKt.lazy(new ld8.b(this));
        this.n = LazyKt.lazy(new ld8.c(this));
        this.o = LazyKt.lazy(new ld8.d(this));
        this.p = LazyKt.lazy(new ld8.e(this));
        this.q = -i5.o0();
        BottomFloatingButtonType r0 = BottomFloatingButtonType.NONE;
        this.x = r0;
        this.y = r0;
        this.C = new c(this);
    }

    @Override // ld8.n
    public final ImageView G50() {
        LarusPageChatBottomFloatingButtonBinding r0 = m3();
        if (r0 == null) goto L7;
        FastScrollButton r1 = r0.e;
        if (r1 == null) goto L7;
        return r1.d;
    L7:
        return null;
    }

    @Override // xa8.a
    public final void mD() {
        LarusPageChatBottomFloatingButtonBinding r0 = m3();
        if (r0 == null) goto L9;
        FrameLayout r1 = r0.a;
        if (r1 == null) goto L10;
        float r2 = -i5.o0();
        this.q = r2;
        r1.setTranslationY(r2);
        return;
    L10:
        return;
    }

    public final void z3() {
        LarusPageChatBottomFloatingButtonBinding r0 = m3();
        if (r0 == null) goto L6;
        FrameLayout r1 = r0.a;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r1, "translationY", new float[]{r1.getTranslationY(), 0.0f});
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r0.a, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r0.b, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r7 = new AnimatorSet();
        r7.playTogether(new Animator[]{r2, r3, r4});
        r7.setDuration(300);
        r7.addListener(new e(r0, this));
        r7.start();
        this.w = r7;
        return;
    }

    public final void B3(String r12) {
        LarusPageChatBottomFloatingButtonBinding r0 = m3();
        boolean r6 = true;
        if (r0 != null) goto L10;
        FLogger r1 = FLogger.a;
        StringBuilder r8 = new StringBuilder("component_state source=");
        r8.append(r12);
        r8.append(" binding=null currentType=");
        r8.append(this.x);
        r8.append(" lastType=");
        r8.append(this.y);
        r8.append(" forceHide=");
        r8.append(this.A);
        r8.append(" hasFastCallback=");
        if (this.s != null) goto L8;
        r6 = false;
    L8:
        r8.append(r6);
        r1.d("fast-scroll-click-chain", r8.toString());
        return;
    L10:
        View r9 = r0.e.getChildAt(0);
        FLogger r10 = FLogger.a;
        StringBuilder r11 = new StringBuilder("component_state source=");
        r11.append(r12);
        r11.append(" currentType=");
        r11.append(this.x);
        r11.append(" lastType=");
        r11.append(this.y);
        r11.append(" rootVisible=");
        if (r0.a.getVisibility() != 0) goto L13;
        boolean r13 = true;
    L14:
        r11.append(r13);
        r11.append(" rootAlpha=");
        r11.append(r0.a.getAlpha());
        r11.append(" rootTranslationY=");
        r11.append(r0.a.getTranslationY());
        r11.append(" fastVisible=");
        if (r0.e.getVisibility() != 0) goto L17;
        boolean r14 = true;
    L18:
        r11.append(r14);
        r11.append(" fastAlpha=");
        r11.append(r0.e.getAlpha());
        r11.append(" fastTranslationY=");
        r11.append(r0.e.getTranslationY());
        r11.append(" fastIsShow=");
        r11.append(r0.e.e);
        r11.append(" fastEnabled=");
        r11.append(r0.e.isEnabled());
        r11.append(" fastClickable=");
        r11.append(r0.e.isClickable());
        r11.append(" iconVisible=");
        Boolean r15 = null;
        if (r9 != null) goto L21;
        Boolean r2 = null;
    L26:
        r11.append(r2);
        r11.append(" iconAlpha=");
        if (r9 == null) goto L29;
        Float r3 = Float.valueOf(r9.getAlpha());
    L30:
        r11.append(r3);
        r11.append(" iconEnabled=");
        if (r9 == null) goto L33;
        Boolean r4 = Boolean.valueOf(r9.isEnabled());
    L34:
        r11.append(r4);
        r11.append(" iconClickable=");
        if (r9 == null) goto L37;
        r15 = Boolean.valueOf(r9.isClickable());
    L37:
        r11.append(r15);
        r11.append(" showAnimatorRunning=");
        AnimatorSet r16 = this.v;
        if (r16 != null) goto L40;
    L42:
        boolean r17 = false;
    L43:
        r11.append(r17);
        r11.append(" hideAnimatorRunning=");
        AnimatorSet r18 = this.w;
        if (r18 != null) goto L46;
    L48:
        boolean r19 = false;
    L49:
        r11.append(r19);
        r11.append(" forceHide=");
        r11.append(this.A);
        r11.append(" hasFastCallback=");
        if (this.s != null) goto L53;
        r6 = false;
    L53:
        r11.append(r6);
        r10.d("fast-scroll-click-chain", r11.toString());
        return;
    L46:
        if (r18.isRunning() != true) goto L48;
        r19 = true;
        goto L49
    L40:
        if (r16.isRunning() != true) goto L42;
        r17 = true;
        goto L43
    L33:
        r4 = null;
        goto L34
    L29:
        r3 = null;
        goto L30
    L21:
        if (r9.getVisibility() != 0) goto L23;
        boolean r5 = true;
    L24:
        r2 = Boolean.valueOf(r5);
        goto L26
    L23:
        r5 = false;
        goto L24
    L17:
        r14 = false;
        goto L18
    L13:
        r13 = false;
        goto L14
    }

    public final void C3(boolean r10) {
        LarusPageChatBottomFloatingButtonBinding r0 = m3();
        if (r0 == null) goto L10;
        FrameLayout r1 = r0.a;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r1, "translationY", new float[]{r1.getTranslationY(), this.q});
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r0.a, "alpha", new float[]{0.0f, 1.0f});
        if (r10 == false) goto L7;
        LinearLayout r4 = r0.c;
    L8:
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r4, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet r7 = new AnimatorSet();
        r7.playTogether(new Animator[]{r2, r3, r5});
        r7.setDuration(300);
        r7.addListener(new f(this, r10, r0));
        r7.start();
        this.v = r7;
        return;
    L7:
        r4 = r0.e;
        goto L8
    }

    public final void D3(BottomFloatingButtonType r13) {
        LarusPageChatBottomFloatingButtonBinding r0 = m3();
        if (r0 == null) goto L45;
        r0.a.setVisibility(0);
        r0.a.setTranslationY(this.q);
        r0.a.setAlpha(1.0f);
        r0.e.setVisibility(8);
        int r14 = b.a[r13.ordinal()];
        if (r14 != 3) goto L7;
    L35:
        ButtonType r15 = ButtonType.SHARE_LONG_IMAGE;
    L36:
        final BottomFloatingButton r1 = r0.b;
        if (r15 != null) goto L39;
        r1.getClass();
        return;
    L39:
        r1.a();
        FLogger r6 = FLogger.a;
        r6.i("BottomFloatingButton", "firstShowWithAnimation, type:" + r15);
        e1.x(r1);
        r6.i("BottomFloatingButton", "delayAutoHide");
        r1.d.removeCallbacksAndMessages(null);
        r1.d.postDelayed(new com.larus.bmhome.chat.component.bottom.floating.button.a(r1), 5000);
        Object r5 = r1.getParent();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.View");
        View r7 = (View) r5;
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r7, "translationY", new float[]{r7.getTranslationY(), -i5.o0()});
        ObjectAnimator r9 = ObjectAnimator.ofFloat(r7, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r1, "alpha", new float[]{0.0f, 1.0f});
        if (r1.b == r15) goto L43;
        r6.i("BottomFloatingButton", "updateContent, type:" + r15);
        r1.b = r15;
        r1.removeAllViews();
        r1.addView(r15.getLayout(r1.getContext()));
    L43:
        AnimatorSet r16 = new AnimatorSet();
        r16.playTogether(new Animator[]{r8, r9, r10});
        r16.setInterpolator(new LinearInterpolator());
        r16.setDuration(300);
        r16.start();
        r1.c = r16;
        return;
    L7:
        if (r14 == 4) goto L35;
        if (r14 != 5) goto L11;
        md8.a r17 = this.C.a;
        if (r17 == null) goto L26;
        CollectFrom r18 = r17.a;
    L27:
        if (r18 != null) goto L29;
        int r19 = -1;
    L30:
        if (r19 == 1) goto L34;
        if (r19 != 2) goto L14;
        r15 = ButtonType.ADD_COLLECT_LIKE;
    L14:
        r15 = null;
        goto L36
    L34:
        r15 = ButtonType.ADD_COLLECT_COPY;
        goto L36
    L29:
        r19 = b.b[r18.ordinal()];
        goto L30
    L26:
        r18 = null;
        goto L27
    L11:
        if (r14 != 6) goto L13;
        md8.a r110 = this.C.a;
        if (r110 == null) goto L18;
        CollectFrom r111 = r110.a;
    L20:
        if (r111 != CollectFrom.LIKE) goto L22;
        r15 = ButtonType.LOOK_LIKE;
        goto L36
    L22:
        r15 = ButtonType.LOOK_COLLECT;
        goto L36
    L18:
        r111 = null;
        goto L20
    L13:
        if (r14 == 10) goto L35;
    }

    @Override // ld8.n
    public final void Dm(boolean r4) {
        B3("resume_fast_scroll_request show=" + r4);
        if (r4 == false) goto L8;
        LarusPageChatBottomFloatingButtonBinding r0 = m3();
        if (r0 == null) goto L9;
        r0.a.setTranslationY(this.q);
        r0.a.setAlpha(1.0f);
        r0.e.setAlpha(1.0f);
        r0.a.setVisibility(0);
        r0.e.setVisibility(0);
        this.x = BottomFloatingButtonType.FAST_SCROLL_BUTTON;
        B3("resume_fast_scroll_applied show=" + r4);
        return;
    L9:
        return;
    }

    @Override // xa8.a
    public final void H9(boolean r4) {
        FLogger.a.d("BottomFloatingButtonComponent", "setForceHide, forceHide = " + r4);
        this.A = r4;
        BottomFloatingButtonType r5 = h3(BottomFloatingButtonAction.SCROLL_DOWN);
        AnimatorSet r0 = this.v;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.v = null;
        Y2(r5);
    }

    @Override // ld8.n
    public final void Sc(String r4) {
        FLogger.a.i("BottomFloatingButtonComponent", "guideLookCollectIfNeed, collectId:" + r4);
        E3(CollectFrom.COLLECT, null, r4, BottomFloatingButtonAction.SHOW_LOOK_COLLECT_TIP);
    }

    public final void Y2(BottomFloatingButtonType r12) {
        BottomFloatingButtonType r0 = this.x;
        int[] r1 = b.a;
        boolean r9 = false;
        boolean r10 = true;
        switch(r1[r0.ordinal()]) {
            case 1: goto L76;
            case 2: goto L67;
            case 3: goto L60;
            case 4: goto L51;
            case 5: goto L22;
            case 6: goto L22;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L86;
        };
    L22:
        int r2 = r1[r12.ordinal()];
        if (r2 == 5) goto L50;
        if (r2 == 6) goto L50;
        if (r2 != 7) goto L27;
        C3(false);
        goto L86
    L27:
        if (r2 != 9) goto L29;
        u7 r13 = (u7) this.o.getValue();
        if (r13 != null) goto L43;
    L45:
        r10 = false;
    L46:
        if (r10 == false) goto L48;
        r12 = BottomFloatingButtonType.FAST_SCROLL_BUTTON;
        C3(false);
        goto L86
    L48:
        r12 = BottomFloatingButtonType.NONE;
        z3();
        goto L86
    L43:
        if (r13.IS() != true) goto L45;
    L29:
        if (r2 != 10) goto L86;
        u7 r14 = (u7) this.o.getValue();
        if (r14 != null) goto L34;
    L36:
        if (r9 == false) goto L38;
        r12 = BottomFloatingButtonType.SHARE_LONG_IMAGE_BUTTON_SCROLLED;
    L39:
        D3(r12);
        goto L86
    L38:
        r12 = BottomFloatingButtonType.SHARE_LONG_IMAGE_BUTTON;
        goto L39
    L34:
        if (r14.IS() != true) goto L36;
        r9 = true;
    L50:
        D3(r12);
        goto L86
    L51:
        int r3 = r1[r12.ordinal()];
        if (r3 == 2) goto L57;
        if (r3 == 5) goto L56;
        if (r3 != 6) goto L86;
    L56:
        D3(r12);
        goto L86
    L57:
        final LarusPageChatBottomFloatingButtonBinding r4 = m3();
        if (r4 == null) goto L86;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r4.e, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r4.b, "alpha", new float[]{1.0f, 0.0f});
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{r4.b.getWidth(), i5.s0()});
        r7.addUpdateListener(new ld8.a(r4));
        AnimatorSet r8 = new AnimatorSet();
        r8.playTogether(new Animator[]{r5, r6, r7});
        r8.setDuration(300);
        r8.addListener(new l(r4, this));
        r8.setInterpolator(PathInterpolatorCompat.create(0.45f, 0.45f, 0.8f, 1.0f));
        r8.start();
        this.v = r8;
        goto L86
    L60:
        int r11 = r1[r12.ordinal()];
        if (r11 == 1) goto L66;
        if (r11 == 5) goto L65;
        if (r11 != 6) goto L86;
    L65:
        D3(r12);
        goto L86
    L66:
        z3();
        goto L86
    L67:
        int r15 = r1[r12.ordinal()];
        if (r15 != 1) goto L70;
        p3(false);
        goto L86
    L70:
        if (r15 == 4) goto L74;
        if (r15 == 5) goto L74;
        if (r15 != 6) goto L86;
    L74:
        D3(r12);
        goto L86
    L76:
        int r16 = r1[r12.ordinal()];
        if (r16 == 2) goto L85;
        if (r16 == 3) goto L84;
        if (r16 == 5) goto L84;
        if (r16 == 6) goto L84;
        if (r16 != 7) goto L86;
        C3(true);
    L84:
        D3(r12);
        goto L86
    L85:
        C3(false);
    L86:
        FLogger.a.i("BottomFloatingButtonComponent", "dispatchAnimation: " + this.y + " -> " + this.x + " -> " + r12);
        this.y = this.x;
        this.x = r12;
        return;
    L6:
        switch(r1[r12.ordinal()]) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L86;
            case 8: goto L8;
            default: goto L86;
        };
    L8:
        AnimatorSet r17 = this.B;
        if (r17 != null) goto L11;
    L13:
        boolean r18 = false;
    L14:
        if (r18 == true) goto L86;
        LarusPageChatBottomFloatingButtonBinding r19 = m3();
        if (r19 == null) goto L86;
        r19.d.setBackgroundResource(2131239069);
        TextView r20 = r19.f;
        final LinearLayout r21 = r19.c;
        r20.setVisibility(0);
        r20.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(r21.getHeight(), 1073741824));
        ValueAnimator r22 = ValueAnimator.ofInt(new int[]{r21.getWidth(), ((r20.getMeasuredWidth() + r21.getPaddingLeft()) + r21.getPaddingRight()) + i5.A()});
        r22.setDuration(300);
        r22.setInterpolator(new AccelerateDecelerateInterpolator());
        r22.addUpdateListener(new h(r21));
        r22.addListener(new m(r21));
        AnimatorSet r23 = new AnimatorSet();
        r23.playTogether(new Animator[]{r22});
        r23.start();
        this.B = r23;
        goto L86
    L11:
        if (r17.isRunning() != true) goto L13;
        r18 = true;
        goto L14
    L19:
        D3(r12);
        goto L86
    L20:
        C3(false);
        goto L86
    L21:
        p3(true);
        goto L86
    }

    @Override // ld8.n, xa8.a
    public final void e2(int r2) {
        this.q += r2;
        LarusPageChatBottomFloatingButtonBinding r3 = m3();
        if (r3 == null) goto L8;
        FrameLayout r4 = r3.a;
        if (r4 == null) goto L9;
        r4.setTranslationY(this.q);
        return;
    L9:
        return;
    }

    public final BottomFloatingButtonType h3(BottomFloatingButtonAction r5) {
        BottomFloatingButtonType r0 = D.get(new Pair(this.x, r5));
        if (r0 != null) goto L5;
        r0 = BottomFloatingButtonType.NONE;
    L5:
        FLogger.a.d("BottomFloatingButtonComponent", "findTargetType: action = " + r5 + ", targetType = " + r0);
        return r0;
    }

    @Override // ld8.n
    public final void m60(BottomFloatingButtonAction r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        BottomFloatingButtonType r0 = h3(r5);
        B3("hide_request action=" + r5 + " target=" + r0);
        if (uo(r0) == false) goto L6;
        B3("hide_skip_already_show action=" + r5 + " target=" + r0);
        return;
    L6:
        AnimatorSet r6 = this.v;
        if (r6 == null) goto L9;
        r6.cancel();
    L9:
        this.v = null;
        Y2(r0);
    }

    public final void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if ((r2 instanceof ViewStub) == false) goto L6;
        this.r = (ViewStub) r2;
        return;
    }

    public final void p3(boolean r10) {
        LarusPageChatBottomFloatingButtonBinding r0 = m3();
        if (r0 == null) goto L10;
        FrameLayout r1 = r0.a;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r1, "translationY", new float[]{r1.getTranslationY(), 0.0f});
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r0.a, "alpha", new float[]{1.0f, 0.0f});
        if (r10 == false) goto L7;
        LinearLayout r4 = r0.c;
    L8:
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r4, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r7 = new AnimatorSet();
        r7.playTogether(new Animator[]{r2, r3, r5});
        r7.setDuration(300);
        r7.addListener(new d(this, r10, r0));
        r7.start();
        this.w = r7;
        return;
    L7:
        r4 = r0.e;
        goto L8
    }

    @Override // ld8.n
    public final boolean uo(BottomFloatingButtonType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (this.x != r2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ld8.n
    public final void AE(BottomFloatingButtonType r4, Function1<? super View, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "onClick");
        FLogger.a.i("fast-scroll-click-chain", "component_register_on_click type=" + r4);
        int r6 = b.a[r4.ordinal()];
        if (r6 != 2) goto L5;
        this.s = r5;
        return;
    L5:
        if (r6 != 3) goto L7;
    L12:
        this.z = r5;
        return;
    L7:
        if (r6 == 4) goto L12;
        if (r6 != 7) goto L17;
        this.t = r5;
        return;
    }

    @Override // ld8.n
    public final boolean Ho(CollectFrom r19, String r20) {
        Intrinsics.checkNotNullParameter(r19, "from");
        Intrinsics.checkNotNullParameter(r20, "msgId");
        CollectFrom r3 = CollectFrom.LIKE;
        if (r19 == r3) goto L5;
    L10:
        o r4 = (o) this.n.getValue();
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        FLogger.a.i("BottomFloatingButtonComponent", "guideAddCollectIfNeed: from=" + r19 + ",msg=" + r20 + ",isCollectionMode:" + r5);
        if (r5 == true) goto L90;
        y r6 = (y) this.m.getValue();
        if (r6 == null) goto L90;
        BotModel r13 = r6.j0();
        if (r13 == null) goto L90;
        y r7 = (y) this.m.getValue();
        if (r7 == null) goto L90;
        wc9.e r14 = r7.h();
        if (r14 == null) goto L90;
        u7 r8 = (u7) this.o.getValue();
        if (r8 == null) goto L90;
        List r9 = r8.zj();
        if (r9 == null) goto L90;
        Iterator r10 = r9.iterator();
    L34:
        if (r10.hasNext() == false) goto L38;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((Message) r11).getMessageId(), r20) == false) goto L34;
    L39:
        Message r12 = (Message) r11;
        if (r12 == null) goto L90;
        int r2 = md8.b.a;
        Context r15 = getContext();
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r13, "bot");
        Intrinsics.checkNotNullParameter(r14, "conversation");
        Intrinsics.checkNotNullParameter(r12, "msg");
        if (r12.getContentType() == 1) goto L48;
        if (r12.getContentType() == 9999) goto L48;
        t0 r16 = null;
    L64:
        if (r16 == null) goto L66;
        List r17 = t0.a.a(r16, r15, r12, null, null, r13, r14, null, null, 132);
    L67:
        if (r17 == null) goto L82;
        Iterator r18 = r17.iterator();
    L70:
        if (r18.hasNext() == false) goto L80;
        Object r21 = r18.next();
        ot8.a r22 = (ot8.a) r21;
        if (r22.getId() != 2131900900) goto L74;
    L77:
        boolean r23 = true;
    L78:
        if (r23 == false) goto L70;
    L81:
        ot8.a r24 = (ot8.a) r21;
    L83:
        if (r24 == null) goto L85;
        boolean r25 = true;
    L86:
        FLogger.a.i("GuideCollectExt", "hasCollectMenuItem, msg:" + r12.getMessageId() + ",hasCollectMenuItem:" + r25);
        if (r25 == false) goto L90;
        E3(r19, r12, null, BottomFloatingButtonAction.SHOW_ADD_COLLECT_TIP);
        return true;
    L85:
        r25 = false;
        goto L86
    L74:
        if (r22.getId() == 2131380355) goto L77;
        r23 = false;
        goto L78
    L80:
        r21 = null;
        goto L81
    L82:
        r24 = null;
        goto L83
    L66:
        r17 = null;
    L48:
        if (com.larus.bmhome.chat.bean.d.z0(r12) == false) goto L54;
        if (com.larus.bmhome.chat.bean.d.Q0(r12) == false) goto L52;
        t0 r26 = new q1();
    L63:
        r16 = r26;
        goto L64
    L52:
        r26 = new m0(null);
        goto L63
    L54:
        if (com.larus.bmhome.chat.bean.d.G0(r12) == false) goto L57;
        r26 = new u2();
        goto L63
    L57:
        if (com.larus.bmhome.chat.bean.d.y0(r12) == false) goto L60;
        r26 = new t();
        goto L63
    L60:
        if (com.larus.bmhome.chat.bean.d.Q0(r12) == false) goto L62;
        r26 = new q1();
        goto L63
    L62:
        r26 = new m0(null);
        goto L63
    L38:
        r11 = null;
    L90:
        return false;
    L13:
        if (r4.i0() != true) goto L15;
        r5 = true;
        goto L16
    L5:
        if (z1.a.d() == true) goto L7;
        boolean r27 = false;
    L8:
        if (r27 == false) goto L10;
        return true;
    L7:
        FLogger.a.i("BottomFloatingButtonComponent", "guideLookLikeIfNeed");
        E3(r3, null, null, BottomFloatingButtonAction.SHOW_LOOK_COLLECT_TIP);
        r27 = true;
        goto L8
    }

    @Override // ld8.n
    public final void Ib(BottomFloatingButtonAction r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "action");
        BottomFloatingButtonType r0 = h3(r5);
        B3("show_request action=" + r5 + " target=" + r0 + " isForce=" + r6);
        if (this.A == false) goto L6;
        B3("show_drop_force_hide action=" + r5 + " target=" + r0);
        return;
    L6:
        if (r6 == false) goto L8;
    L11:
        AnimatorSet r7 = this.w;
        if (r7 == null) goto L14;
        r7.cancel();
    L14:
        this.w = null;
        Y2(r0);
        return;
    L8:
        if (uo(r0) == false) goto L11;
        B3("show_skip_already_show action=" + r5 + " target=" + r0);
    }

    public final void E3(CollectFrom r4, Message r5, String r6, BottomFloatingButtonAction r7) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("showGuideCollectTip: from:");
        r1.append(r4);
        r1.append(",msg:");
        if (r5 == null) goto L5;
        String r2 = r5.getMessageId();
    L6:
        r1.append(r2);
        r1.append(",collectId:");
        r1.append(r6);
        r1.append(",action:");
        r1.append(r7);
        r0.i("BottomFloatingButtonComponent", r1.toString());
        c r3 = this.C;
        md8.a r8 = new md8.a(r4, r5, r6);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r8, "data");
        r3.a = r8;
        Ib(r7, true);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
