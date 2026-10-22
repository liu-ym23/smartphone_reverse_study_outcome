package com.larus.bot.impl.feature.edit.feature.avatar.avatarchoose;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.databinding.LarusDialogAvatarChooserBinding;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u001f\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010(\u001a\u00020\u0010H\u0016J&\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J3\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u00172#\u00104\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0019J\b\u00105\u001a\u00020\u001dH\u0002J\b\u00106\u001a\u00020\u001dH\u0002J\b\u00107\u001a\u00020\u001dH\u0002J\u0010\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u0010H\u0002J\b\u0010:\u001a\u00020\u001dH\u0002J&\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00172\f\u0010?\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J\u0010\u0010@\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u0010H\u0002J\b\u0010A\u001a\u00020\u001dH\u0002J\b\u0010B\u001a\u00020\u001dH\u0002J\b\u0010C\u001a\u00020\u001dH\u0002J\b\u0010D\u001a\u00020\u001dH\u0002J\b\u0010E\u001a\u00020\u001dH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u0018\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/avatar/avatarchoose/AvatarChooserFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusDialogAvatarChooserBinding;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "avatarChooserViewModel", "Lcom/larus/bot/impl/feature/edit/feature/avatar/avatarchoose/BotAvatarChooserViewModel;", "getAvatarChooserViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/avatar/avatarchoose/BotAvatarChooserViewModel;", "avatarChooserViewModel$delegate", "Lkotlin/Lazy;", "currentSelectIndex", "", "lightLoadingAnimation", "Landroid/animation/ObjectAnimator;", "avatarList", "", "Lcom/larus/bot/impl/bean/BotAvatarIconData;", "prompt", "", "avatarChooserListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "selectedAvatar", "", "behaviorCallback", "com/larus/bot/impl/feature/edit/feature/avatar/avatarchoose/AvatarChooserFragment$behaviorCallback$1", "Lcom/larus/bot/impl/feature/edit/feature/avatar/avatarchoose/AvatarChooserFragment$behaviorCallback$1;", "avatarTopLeftImgControlListener", "Lkotlin/Lazy;", "Lcom/facebook/drawee/controller/BaseControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "avatarTopRightImgControlListener", "avatarBottomLeftImgControlListener", "avatarBottomRightImgControlListener", "getTheme", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setUp", "currentPrompt", "chooseListener", "initView", "disableSubmit", "enableSubmit", "checkSelectedAvatar", "index", "initObserver", "setAvatarUrl", "avatarView", "Lcom/facebook/drawee/view/SimpleDraweeView;", ShareType.URL, "controllerListener", "onAvatarImgLoadFinish", "showLoading", "hideLoading", "showLoadingFail", "hideLoadingFail", "requireAvatarList", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarChooserFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int q = 0;
    public LarusDialogAvatarChooserBinding d;
    public BottomSheetBehavior<View> e;
    public final Lazy f;
    public int g;
    public ObjectAnimator h;
    public List<BotAvatarIconData> i;
    public String j;
    public Function1<? super BotAvatarIconData, Unit> k;
    public final f l;
    public final Lazy<BaseControllerListener<ImageInfo>> m;
    public final Lazy<BaseControllerListener<ImageInfo>> n;
    public final Lazy<BaseControllerListener<ImageInfo>> o;
    public final Lazy<BaseControllerListener<ImageInfo>> p;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ AvatarChooserFragment a;

        public b(AvatarChooserFragment r1) {
            this.a = r1;
        }

        public final void onFailure(String r4, Throwable r5) {
            super.onFailure(r4, r5);
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("avatarBottomLeft onFailure: id=");
            r1.append(r4);
            r1.append(", error=");
            if (r5 == null) goto L5;
            String r6 = r5.getMessage();
        L6:
            r1.append(r6);
            r0.i("AvatarChooserFragment", r1.toString());
            AvatarChooserFragment.T90(this.a, 2);
            return;
        L5:
            r6 = null;
            goto L6
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, (ImageInfo) r2, r3);
            FLogger.a.i("AvatarChooserFragment", "avatarBottomLeft onFinalImageSet");
            AvatarChooserFragment.T90(this.a, 2);
            LarusDialogAvatarChooserBinding r4 = this.a.d;
            if (r4 == null) goto L6;
            r4.b.setEnabled(true);
            return;
        }
    }

    public static final class c extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ AvatarChooserFragment a;

        public c(AvatarChooserFragment r1) {
            this.a = r1;
        }

        public final void onFailure(String r4, Throwable r5) {
            super.onFailure(r4, r5);
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("avatarBottomRight onFailure: id=");
            r1.append(r4);
            r1.append(", error=");
            if (r5 == null) goto L5;
            String r6 = r5.getMessage();
        L6:
            r1.append(r6);
            r0.i("AvatarChooserFragment", r1.toString());
            AvatarChooserFragment.T90(this.a, 3);
            return;
        L5:
            r6 = null;
            goto L6
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, (ImageInfo) r2, r3);
            FLogger.a.i("AvatarChooserFragment", "avatarBottomRight onFinalImageSet");
            AvatarChooserFragment.T90(this.a, 3);
            LarusDialogAvatarChooserBinding r4 = this.a.d;
            if (r4 == null) goto L6;
            r4.c.setEnabled(true);
            return;
        }
    }

    public static final class d extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ AvatarChooserFragment a;

        public d(AvatarChooserFragment r1) {
            this.a = r1;
        }

        public final void onFailure(String r4, Throwable r5) {
            super.onFailure(r4, r5);
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("avatarTopLeft onFailure: id=");
            r1.append(r4);
            r1.append(", error=");
            if (r5 == null) goto L5;
            String r6 = r5.getMessage();
        L6:
            r1.append(r6);
            r0.i("AvatarChooserFragment", r1.toString());
            AvatarChooserFragment.T90(this.a, 0);
            return;
        L5:
            r6 = null;
            goto L6
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, (ImageInfo) r2, r3);
            FLogger.a.i("AvatarChooserFragment", "avatarTopLeft onFinalImageSet");
            AvatarChooserFragment.T90(this.a, 0);
            LarusDialogAvatarChooserBinding r4 = this.a.d;
            if (r4 == null) goto L6;
            r4.k.setEnabled(true);
            return;
        }
    }

    public static final class e extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ AvatarChooserFragment a;

        public e(AvatarChooserFragment r1) {
            this.a = r1;
        }

        public final void onFailure(String r4, Throwable r5) {
            super.onFailure(r4, r5);
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("avatarTopRight onFailure: id=");
            r1.append(r4);
            r1.append(", error=");
            if (r5 == null) goto L5;
            String r6 = r5.getMessage();
        L6:
            r1.append(r6);
            r0.i("AvatarChooserFragment", r1.toString());
            AvatarChooserFragment.T90(this.a, 1);
            return;
        L5:
            r6 = null;
            goto L6
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, (ImageInfo) r2, r3);
            FLogger.a.i("AvatarChooserFragment", "avatarTopRight onFinalImageSet");
            AvatarChooserFragment.T90(this.a, 1);
            LarusDialogAvatarChooserBinding r4 = this.a.d;
            if (r4 == null) goto L6;
            r4.l.setEnabled(true);
            return;
        }
    }

    public static final class f extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ AvatarChooserFragment a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public f(AvatarChooserFragment r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 1) goto L8;
            BottomSheetBehavior<View> r4 = this.a.e;
            if (r4 == null) goto L9;
            r4.setState(4);
            return;
        L9:
            return;
        }
    }

    public static final class g implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public g(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final void V90() {
        LarusDialogAvatarChooserBinding r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.n.isEnabled() == true) goto L9;
        r0.n.setEnabled(true);
        r0.n.setAlpha(1.0f);
        return;
    }

    public final BotAvatarChooserViewModel W90() {
        return (BotAvatarChooserViewModel) this.f.getValue();
    }

    public AvatarChooserFragment() {
        final Function0<Fragment> r0 = new AvatarChooserFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotAvatarChooserViewModel.class), new AvatarChooserFragment$special$$inlined$viewModels$default$2(r0), new AvatarChooserFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = -1;
        this.l = new f(this);
        this.m = LazyKt.lazy(new i(this));
        this.n = LazyKt.lazy(new j(this));
        this.o = LazyKt.lazy(new k(this));
        this.p = LazyKt.lazy(new l(this));
    }

    public static void S90(AvatarChooserFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void U90(int r5) {
        LarusDialogAvatarChooserBinding r0 = this.d;
        if (r0 != null) goto L5;
    L17:
        this.g = r5;
        return;
    L5:
        if (r5 != 0) goto L7;
        r0.i.setVisibility(0);
        r0.j.setVisibility(8);
        r0.g.setVisibility(8);
        r0.h.setVisibility(8);
        V90();
        goto L17
    L7:
        if (r5 != 1) goto L9;
        r0.i.setVisibility(8);
        r0.j.setVisibility(0);
        r0.g.setVisibility(8);
        r0.h.setVisibility(8);
        V90();
        goto L17
    L9:
        if (r5 != 2) goto L11;
        r0.i.setVisibility(8);
        r0.j.setVisibility(8);
        r0.g.setVisibility(0);
        r0.h.setVisibility(8);
        V90();
        goto L17
    L11:
        if (r5 != 3) goto L17;
        r0.i.setVisibility(8);
        r0.j.setVisibility(8);
        r0.g.setVisibility(8);
        r0.h.setVisibility(0);
        V90();
        goto L17
    }

    public static final void T90(AvatarChooserFragment r0, int r1) {
        r0.W90().updateAvatarListLoadingState(r1);
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        Dialog r5 = getDialog();
        if (r5 == null) goto L5;
        r5.setOnShowListener(new com.larus.bot.impl.feature.edit.feature.avatar.avatarchoose.a(this));
    L5:
        Dialog r6 = getDialog();
        if (r6 == null) goto L8;
        r6.setOnCancelListener(new h(this));
    L8:
        LarusDialogAvatarChooserBinding r7 = this.d;
        if (r7 == null) goto L13;
        r7.k.setEnabled(false);
        e1.d(r7.k, new m(this));
        r7.l.setEnabled(false);
        e1.d(r7.l, new n(this));
        r7.b.setEnabled(false);
        e1.d(r7.b, new o(this));
        r7.c.setEnabled(false);
        e1.d(r7.c, new p(this));
        e1.d(r7.m, new com.larus.bot.impl.feature.edit.feature.avatar.avatarchoose.b(this));
        e1.d(r7.n, new com.larus.bot.impl.feature.edit.feature.avatar.avatarchoose.c(this));
        e1.d(r7.f, new com.larus.bot.impl.feature.edit.feature.avatar.avatarchoose.d(this));
        LarusDialogAvatarChooserBinding r8 = this.d;
        if (r8 == null) goto L13;
        r8.n.setEnabled(false);
        r8.n.setAlpha(0.3f);
    L13:
        W90().getGenBotAvatarList().observe(getViewLifecycleOwner(), new g(new com.larus.bot.impl.feature.edit.feature.avatar.avatarchoose.e(this)));
        W90().getAvatarImgLoadingState().observe(getViewLifecycleOwner(), new g(new com.larus.bot.impl.feature.edit.feature.avatar.avatarchoose.f(this)));
        String r9 = this.j;
        if (r9 == null) goto L17;
        W90().requireBotAvatarList(r9);
        return;
    }

    public static void X90(SimpleDraweeView r2, String r3, final BaseControllerListener r4) {
        ImageLoaderKt.y(r2, r3, "bot_create.avatar_ai", new com.larus.bot.impl.feature.edit.feature.avatar.avatarchoose.g(r4), 4);
    }

    public final View onCreateView(LayoutInflater r20, ViewGroup r21, Bundle r22) {
        Intrinsics.checkNotNullParameter(r20, "inflater");
        ConstraintLayout r0 = r20.inflate(2131562032, r21, false);
        int r1 = 2131363648;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r0, 2131363648);
        if (r5 == null) goto L33;
        r1 = 2131363649;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(r0, 2131363649);
        if (r6 == null) goto L33;
        r1 = 2131363708;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131363708);
        if (r7 == null) goto L33;
        r1 = 2131363714;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131363714);
        if (r8 == null) goto L33;
        r1 = 2131363726;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r0, 2131363726);
        if (r9 == null) goto L33;
        r1 = 2131363730;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r0, 2131363730);
        if (r10 == null) goto L33;
        r1 = 2131363731;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r0, 2131363731);
        if (r11 == null) goto L33;
        r1 = 2131363732;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r0, 2131363732);
        if (r12 == null) goto L33;
        r1 = 2131363733;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r0, 2131363733);
        if (r13 == null) goto L33;
        r1 = 2131363745;
        SimpleDraweeView r14 = ViewBindings.findChildViewById(r0, 2131363745);
        if (r14 == null) goto L33;
        r1 = 2131363746;
        SimpleDraweeView r15 = ViewBindings.findChildViewById(r0, 2131363746);
        if (r15 == null) goto L33;
        r1 = 2131364673;
        RoundTextView r16 = ViewBindings.findChildViewById(r0, 2131364673);
        if (r16 == null) goto L33;
        r1 = 2131364848;
        RoundTextView r17 = ViewBindings.findChildViewById(r0, 2131364848);
        if (r17 == null) goto L33;
        r1 = 2131377861;
        View r18 = ViewBindings.findChildViewById(r0, 2131377861);
        if (r18 == null) goto L33;
        ConstraintLayout r2 = r0;
        this.d = new LarusDialogAvatarChooserBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
        return r2;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
