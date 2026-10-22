package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ixigua.lib.track.TrackParams;
import com.larus.bot.impl.databinding.LarusDialogBotEditBgImageChooseBinding;
import com.larus.bot.impl.databinding.LarusLayoutBotEditErrorLayBinding;
import com.larus.utils.e1;
import com.zhpan.bannerview.indicator.DrawableIndicator;
import com.zhpan.indicator.base.BaseIndicatorView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000b\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u0010\"\u001a\u0004\u0018\u00010\t2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\b\u0010*\u001a\u00020\u001fH\u0002J\u000f\u0010+\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010,J\u000f\u0010-\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010,J\u000f\u0010.\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010,J\n\u0010/\u001a\u0004\u0018\u000100H\u0002J\b\u00101\u001a\u00020\u001fH\u0002J\u0017\u00102\u001a\u0004\u0018\u00010\u001f2\u0006\u00103\u001a\u000204H\u0002¢\u0006\u0002\u00105Jw\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010<2\b\u0010>\u001a\u0004\u0018\u00010<2\b\u0010?\u001a\u0004\u0018\u00010<2\b\u0010@\u001a\u0004\u0018\u00010\u00162\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010<2\b\u0010D\u001a\u0004\u0018\u00010<2\b\u0010E\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010FR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0019\u0010\u001a¨\u0006H"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/Text2BgImgChooseDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/ixigua/lib/track/ITrackNode;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusDialogBotEditBgImageChooseBinding;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "behaviorCallback", "com/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/Text2BgImgChooseDialog$behaviorCallback$1", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/Text2BgImgChooseDialog$behaviorCallback$1;", "adapter", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/Text2BgImageAdapter;", "viewModel", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/IAIGenBgImageViewModel;", "getViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/IAIGenBgImageViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "hasIndicatorBindViewpager", "", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "getTheme", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "initView", "initErrorLay", "()Lkotlin/Unit;", "initConfirmBtn", "initViewPager", "initIndicator", "Lcom/zhpan/indicator/base/BaseIndicatorView;", "bindObservers", "refreshState", "state", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/AIGenBgImageUIState;", "(Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/AIGenBgImageUIState;)Lkotlin/Unit;", "openPreviewPage", "avatarInfo", "Lcom/larus/bot/impl/bean/BotAvatarIconData;", "bgImage", "Lcom/larus/im/bean/bot/BgImage;", "botName", "", "botDescription", "userBotGender", "userBotType", "needUpdateBotInfo", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "creationId", "createWay", "hasOriginAvatar", "(Lcom/larus/bot/impl/bean/BotAvatarIconData;Lcom/larus/im/bean/bot/BgImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Text2BgImgChooseDialog extends BottomSheetDialogFragment implements by7.e {
    public static final /* synthetic */ int k = 0;
    public LarusDialogBotEditBgImageChooseBinding d;
    public BottomSheetBehavior<View> e;
    public final b f;
    public Text2BgImageAdapter g;
    public final Lazy h;
    public boolean i;
    public final Lazy j;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ Text2BgImgChooseDialog a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(Text2BgImgChooseDialog r1) {
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

    static {
    }

    public final void fillTrackParams(TrackParams r1) {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final d S90() {
        return (d) this.h.getValue();
    }

    public Text2BgImgChooseDialog() {
        this.f = new b(this);
        final Function0<Fragment> r0 = new Text2BgImgChooseDialog$special$$inlined$viewModels$default$1(this);
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AIGenBgImageViewModel.class), new Text2BgImgChooseDialog$special$$inlined$viewModels$default$2(r0), new Text2BgImgChooseDialog$special$$inlined$viewModels$default$3(r0, this));
        this.j = LazyKt.lazy(new o(this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.d = null;
    }

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        S90().dispatchUIAction(new com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.a.c(getArguments()));
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        Dialog r9 = getDialog();
        if (r9 == null) goto L5;
        r9.setOnShowListener(new p(this));
    L5:
        Dialog r10 = getDialog();
        if (r10 == null) goto L8;
        r10.setOnCancelListener(new q());
    L8:
        LarusDialogBotEditBgImageChooseBinding r11 = this.d;
        if (r11 == null) goto L11;
        e1.d(r11.c.a, new s(this));
        Unit r12 = Unit.INSTANCE;
    L11:
        LarusDialogBotEditBgImageChooseBinding r13 = this.d;
        if (r13 == null) goto L18;
        DrawableIndicator r14 = r13.d;
        int r0 = c7.b(6);
        if (r0 < 0) goto L16;
        r14.g = r0;
        r14.postInvalidate();
    L17:
        r13.d.d(2131243595, 2131243594);
        int r15 = c7.b(8);
        DrawableIndicator r1 = r13.d;
        r1.getClass();
        r1.l = new DrawableIndicator.a(r15, r15, r15, r15);
        r1.c();
        r1.postInvalidate();
        ((BaseIndicatorView) r13.d).a.c = 2;
        goto L18
    L16:
        r14.getClass();
    L18:
        LarusDialogBotEditBgImageChooseBinding r16 = this.d;
        if (r16 == null) goto L21;
        Text2BgImageAdapter r17 = new Text2BgImageAdapter();
        r17.c = new t(this);
        r17.b = new u(this);
        this.g = r17;
        r16.e.setAdapter(r17);
        r16.e.setOffscreenPageLimit(3);
        r16.e.registerOnPageChangeCallback(new Text2BgImgChooseDialog$initViewPager$1$2(this));
        Unit r18 = Unit.INSTANCE;
    L21:
        LarusDialogBotEditBgImageChooseBinding r19 = this.d;
        if (r19 == null) goto L24;
        e1.d(r19.b, new r(this));
        Unit r20 = Unit.INSTANCE;
    L24:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new Text2BgImgChooseDialog$bindObservers$1(this, null), 3, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(S90().getUiEvent(), new Text2BgImgChooseDialog$bindObservers$2(this, null)), LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()));
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131562038, r8, false);
        int r11 = 2131367647;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r10, 2131367647);
        if (r2 == null) goto L13;
        r11 = 2131371759;
        View r12 = ViewBindings.findChildViewById(r10, 2131371759);
        if (r12 == null) goto L13;
        LarusLayoutBotEditErrorLayBinding r3 = LarusLayoutBotEditErrorLayBinding.a(r12);
        r11 = 2131375226;
        DrawableIndicator r4 = ViewBindings.findChildViewById(r10, 2131375226);
        if (r4 == null) goto L13;
        r11 = 2131392567;
        ViewPager2 r5 = ViewBindings.findChildViewById(r10, 2131392567);
        if (r5 == null) goto L13;
        LinearLayout r13 = (LinearLayout) r10;
        this.d = new LarusDialogBotEditBgImageChooseBinding(r13, r2, r3, r4, r5);
        return r13;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
