package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bot.impl.databinding.LarusPageBotBgImageGenerateBinding;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.paintreference.PaintStyleAdapter;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.paintreference.PaintStyleViewHolder;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget.PromptInputButtonView;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget.ReferenceImageContainer;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.FragmentExtKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.yalantis.ucrop.UCropFragment;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001QB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010+\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020 H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0011H\u0016J\u0010\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020.H\u0016J\u0016\u00102\u001a\u00020 2\f\u00103\u001a\b\u0018\u000104R\u00020\u0015H\u0016J\u000e\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\"J\u0010\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020\"H\u0002J\u0012\u00109\u001a\u00020 2\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\b\u0010<\u001a\u00020 H\u0002J\b\u0010=\u001a\u00020 H\u0002J\n\u0010>\u001a\u0004\u0018\u00010$H\u0002J\b\u0010?\u001a\u00020 H\u0002J\u000f\u0010@\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0002\u0010AJ\u000f\u0010B\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0002\u0010AJ\u000f\u0010C\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0002\u0010AJ\u000f\u0010D\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0002\u0010AJ\b\u0010F\u001a\u00020 H\u0002J\u0010\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020\u0011H\u0002J\u0017\u0010I\u001a\u0004\u0018\u00010 2\u0006\u0010J\u001a\u00020KH\u0002¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020 H\u0002J\u0012\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010J\u001a\u00020PH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010E\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/Img2BgImageFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/yalantis/ucrop/UCropFragmentCallback;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusPageBotBgImageGenerateBinding;", "paintStyleAdapter", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/paintreference/PaintStyleAdapter;", "viewModel", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/IBotBgImageGenerateViewModel;", "getViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/IBotBgImageGenerateViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "pickLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "pickSDKLauncher", "Landroid/content/Intent;", "uCropFragment", "Lcom/yalantis/ucrop/UCropFragment;", "prePromptEditState", "", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onDestroy", "autoLogEnterPage", "", "getCurrentPageName", "loadingProgress", "showLoader", "onCropFinish", "result", "Lcom/yalantis/ucrop/UCropFragment$UCropResult;", "onResult", "data", "handleQuitAiGenProcess", "bundle", "refreshUCropFragment", "uri", "Landroid/net/Uri;", "initLauncher", "initView", "initTitle", "performManualBack", "initReferenceImage", "()Lkotlin/Unit;", "initPaintReferences", "initGenerateBtn", "initPromptEdit", "currentUri", "bindObservers", "showPromptGenerateDialog", "prompt", "refreshPromptEditUIState", "state", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/prompt/BgPromptGenerateUIState;", "(Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/prompt/BgPromptGenerateUIState;)Lkotlin/Unit;", "showQuitConfirmDialog", "refreshUIState", "", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/BgImageGenerateUIState;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Img2BgImageFragment extends TraceFragment implements com.yalantis.ucrop.b {
    public static final /* synthetic */ int o = 0;
    public LarusPageBotBgImageGenerateBinding e;
    public PaintStyleAdapter f;
    public final Lazy g;
    public ActivityResultLauncher<String> h;
    public ActivityResultLauncher<Intent> i;
    public UCropFragment j;
    public int k;
    public FragmentExtKt.addOnBackPressed.callback.1 l;
    public final Lazy m;
    public Uri n;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "";
    }

    public final i V90() {
        return (i) this.g.getValue();
    }

    public final void onDestroy() {
        FragmentExtKt.addOnBackPressed.callback.1 r0 = this.l;
        if (r0 == null) goto L5;
        r0.remove();
    L5:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public Img2BgImageFragment() {
        final Function0<Fragment> r0 = new Img2BgImageFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotBgImageGenerateViewModel.class), new Img2BgImageFragment$special$$inlined$viewModels$default$2(r0), new Img2BgImageFragment$special$$inlined$viewModels$default$3(r0, this));
        this.m = LazyKt.lazy(new p(this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
    }

    public final void H20(UCropFragment.c r3) {
        V90().dispatchUIAction(new b.f(r3));
    }

    public final void W90(Uri r7) {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L35;
        if (r7 != null) goto L6;
        FragmentTransaction r8 = getChildFragmentManager().beginTransaction();
        if (this.e == null) goto L33;
        UCropFragment r1 = this.j;
        if (r1 == null) goto L33;
        r8.remove(r1);
    L33:
        r8.commitAllowingStateLoss();
        return;
    L6:
        if (Intrinsics.areEqual(this.n, r7) == false) goto L16;
        UCropFragment r2 = this.j;
        if (r2 == null) goto L12;
        View r3 = r2.getView();
        if (r3 == null) goto L12;
        ViewParent r4 = r3.getParent();
    L13:
        if (r4 == null) goto L16;
        FLogger.a.i("BotBgImageGenerateFragment", "no need refresh crop fragment");
        return;
    L12:
        r4 = null;
    L16:
        Uri r5 = Uri.fromFile(new PolarisFileWrapper(r0.getCacheDir(), "bg_reference_bitmap_cache_cropped.jpg"));
        new Intent();
        Bundle r6 = new Bundle();
        r6.putParcelable("com.yalantis.ucrop.InputUri", r7);
        r6.putParcelable("com.yalantis.ucrop.OutputUri", r5);
        Bundle r9 = new Bundle();
        r9.putBoolean("com.yalantis.ucrop.HideBottomControls", true);
        r9.putBoolean("com.yalantis.ucrop.DisablePadding", true);
        r9.putBoolean("com.yalantis.ucrop.HideLogo", true);
        r9.putBoolean("com.yalantis.ucrop.ShowCropGrid", false);
        r9.putInt("com.yalantis.ucrop.CropFrameStrokeWidth", 0);
        r9.putInt("com.yalantis.ucrop.CropFrameColor", getResources().getColor(2131102539));
        r9.putInt("com.yalantis.ucrop.CropGridStrokeWidth", 0);
        Context r10 = getContext();
        if (r10 == null) goto L19;
        r9.putInt("com.yalantis.ucrop.UcropRootViewBackgroundColor", ContextCompat.getColor(r10, 2131102539));
    L19:
        Unit r11 = Unit.INSTANCE;
        r6.putAll(r9);
        r6.putFloat("com.yalantis.ucrop.AspectRatioX", 1.0f);
        r6.putFloat("com.yalantis.ucrop.AspectRatioY", 1.0f);
        UCropFragment r12 = new UCropFragment();
        r12.setArguments(r6);
        this.j = r12;
        FragmentTransaction r13 = getChildFragmentManager().beginTransaction();
        if (this.e == null) goto L27;
        UCropFragment r14 = this.j;
        if (r14 == null) goto L27;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r14, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131368298) == true) goto L27;
        r13.replace(2131368298, r14);
    L27:
        r13.commitAllowingStateLoss();
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        V90().dispatchUIAction(new b.e(getArguments()));
        this.l = com.larus.utils.v.a(this, new r(this));
    }

    public final void vg(boolean r4) {
        FLogger.a.i("BotBgImageGenerateFragment", "UCropFragment loadingProgress, showLoader: " + r4);
    }

    public static final void U90(Img2BgImageFragment r4, d r5) {
        LarusPageBotBgImageGenerateBinding r0 = r4.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5.b.isEmpty() == false) goto L7;
        e1.o(r0.e);
    L10:
        int r1 = r5.a;
        if (r1 != 1) goto L13;
        r4.W90(null);
        r0.f.R5(r5.a);
        Unit r6 = Unit.INSTANCE;
        return;
    L13:
        Uri r7 = r4.n;
        if (r7 == null) goto L16;
        r4.W90(r7);
        r0.f.R5(2);
        return;
    L16:
        r0.f.R5(r1);
        Unit r8 = Unit.INSTANCE;
        return;
    L7:
        PaintStyleAdapter r2 = r4.f;
        if (r2 == null) goto L10;
        List<PaintStyleViewHolder.a> r3 = r5.b;
        Intrinsics.checkNotNullParameter(r3, "data");
        r2.a = r3;
        r2.notifyDataSetChanged();
        goto L10
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        LarusPageBotBgImageGenerateBinding r13 = this.e;
        if (r13 == null) goto L5;
        NovaTitleBarEx.Y5(r13.g, r13.a.getContext().getString(2131901082), null, null, 6);
        NovaTitleBarEx.b6(r13.g, 2131243589, false, null, null, new k(this), 14);
    L5:
        final LarusPageBotBgImageGenerateBinding r14 = this.e;
        if (r14 == null) goto L8;
        ReferenceImageContainer r0 = r14.f;
        Function0<Unit> r1 = new j(this, r14);
        Function0<Unit> r15 = new m(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "onClickPlus");
        Intrinsics.checkNotNullParameter(r15, "onClickDelete");
        r0.c = r1;
        r0.d = r15;
        Unit r16 = Unit.INSTANCE;
    L8:
        LarusPageBotBgImageGenerateBinding r17 = this.e;
        if (r17 == null) goto L11;
        PaintStyleAdapter r2 = new PaintStyleAdapter();
        r2.b = new s(this);
        this.f = r2;
        r17.e.setAdapter(r2);
        r17.e.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        Unit r18 = Unit.INSTANCE;
    L11:
        LarusPageBotBgImageGenerateBinding r19 = this.e;
        if (r19 == null) goto L14;
        e1.d(r19.b, new t(this));
        e1.d(r19.c, new u(this));
        Unit r110 = Unit.INSTANCE;
    L14:
        LarusPageBotBgImageGenerateBinding r111 = this.e;
        if (r111 == null) goto L17;
        e1.d(r111.d, new q(this));
        Unit r112 = Unit.INSTANCE;
    L17:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new Img2BgImageFragment$bindObservers$1(this, null), 3, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(V90().getUiEvent(), new Img2BgImageFragment$bindObservers$2(this, null)), LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new Img2BgImageFragment$bindObservers$3(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new Img2BgImageFragment$bindObservers$4(this, null), 3, null);
        V90().dispatchUIAction(b.i.a);
        if (V90().getBotCreateTrace().c() == null) goto L34;
        String r113 = V90().getBotCreateTrace().c();
        String r114 = V90().getBotCreateTrace().b();
        String r3 = V90().getBotCreateTrace().a();
        JSONObject r4 = new JSONObject();
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r113 != null) goto L32;
    L24:
        if (r114 == null) goto L26;
        r4.put("create_way", r114);     // Catch: JSONException -> L22
    L26:
        if (r3 == null) goto L30;
        r4.put("enter_method", r3);     // Catch: JSONException -> L22
    L22:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_image_ai_creation_page_enter " + e.getLocalizedMessage());
    L30:
        TrackParams r115 = new TrackParams().merge(r4);
        by7.a r116 = new by7.a("bot_image_ai_creation_page_enter");
        r116.a.merge(r115);
        r116.b();
        return;
    L32:
        r4.put("creation_id", r113);     // Catch: JSONException -> L22
        goto L24
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        ConstraintLayout r12 = r9.inflate(2131562998, r10, false);
        int r13 = 2131368835;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r12, 2131368835);
        if (r2 == null) goto L17;
        r13 = 2131368836;
        PromptInputButtonView r3 = (PromptInputButtonView) ViewBindings.findChildViewById(r12, 2131368836);
        if (r3 == null) goto L17;
        r13 = 2131373625;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r12, 2131373625);
        if (r4 == null) goto L17;
        r13 = 2131381845;
        RecyclerView r5 = ViewBindings.findChildViewById(r12, 2131381845);
        if (r5 == null) goto L17;
        r13 = 2131384127;
        ReferenceImageContainer r6 = (ReferenceImageContainer) ViewBindings.findChildViewById(r12, 2131384127);
        if (r6 == null) goto L17;
        r13 = 2131388772;
        NovaTitleBarEx r7 = (NovaTitleBarEx) ViewBindings.findChildViewById(r12, 2131388772);
        if (r7 == null) goto L17;
        ConstraintLayout r14 = r12;
        this.e = new LarusPageBotBgImageGenerateBinding(r14, r2, r3, r4, r5, r6, r7);
        this.h = registerForActivityResult(new ActivityResultContracts.GetContent(), new n(this));
        this.i = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new o(this));
        return r14;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
