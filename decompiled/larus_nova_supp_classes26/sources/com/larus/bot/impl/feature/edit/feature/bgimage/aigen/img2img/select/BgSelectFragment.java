package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bot.impl.databinding.LarusPageBotBgSelectBinding;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.widget.BgSelectViewPagerContainer;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.FragmentExtKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
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
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u000e\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u001aJ\b\u0010+\u001a\u00020\u0018H\u0002J\n\u0010,\u001a\u0004\u0018\u00010\u001cH\u0002J\u000f\u0010-\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010.J\u000f\u0010/\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010.J\b\u00100\u001a\u00020\u0018H\u0002J\u0017\u00101\u001a\u0004\u0018\u00010\u00182\u0006\u00102\u001a\u000203H\u0002¢\u0006\u0002\u00104J\u0085\u0001\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010(2\b\u0010;\u001a\u0004\u0018\u00010(2\b\u0010<\u001a\u0004\u0018\u00010(2\b\u0010=\u001a\u0004\u0018\u00010(2\b\u0010>\u001a\u0004\u0018\u00010&2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010(2\b\u0010B\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0002\u0010EJ\b\u0010F\u001a\u00020\u0018H\u0002J\b\u0010G\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusPageBotBgSelectBinding;", "viewModel", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IBgSelectViewModel;", "getViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IBgSelectViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "pictureSaveActionSheet", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/PictureSaveActionSheet;", "adapter", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectAdapter;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onDestroy", "autoLogEnterPage", "", "getCurrentPageName", "", "onResult", "data", "initView", "initTitle", "initBottomButtons", "()Lkotlin/Unit;", "initViewPager", "bindObservers", "refreshUIState", "state", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectUIState;", "(Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectUIState;)Lkotlin/Unit;", "openPreviewPage", "avatarInfo", "Lcom/larus/bot/impl/bean/BotAvatarIconData;", "bgImage", "Lcom/larus/im/bean/bot/BgImage;", "botName", "botDescription", "userBotGender", "userBotType", "needUpdateBotInfo", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "creationId", "createWay", "originAvatarImageUri", "originBackgroundImageUri", "(Lcom/larus/bot/impl/bean/BotAvatarIconData;Lcom/larus/im/bean/bot/BgImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "performManualBack", "showQuitConfirmDialog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BgSelectFragment extends TraceFragment {
    public static final /* synthetic */ int k = 0;
    public LarusPageBotBgSelectBinding e;
    public final Lazy f;
    public PictureSaveActionSheet g;
    public BgSelectAdapter h;
    public final Lazy i;
    public FragmentExtKt.addOnBackPressed.callback.1 j;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "";
    }

    public final q U90() {
        return (q) this.f.getValue();
    }

    public final void onDestroy() {
        FragmentExtKt.addOnBackPressed.callback.1 r0 = this.j;
        if (r0 == null) goto L5;
        r0.remove();
    L5:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public BgSelectFragment() {
        final Function0<Fragment> r0 = new BgSelectFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BgSelectViewModel.class), new BgSelectFragment$special$$inlined$viewModels$default$2(r0), new BgSelectFragment$special$$inlined$viewModels$default$3(r0, this));
        this.i = LazyKt.lazy(new e(this));
    }

    public final void V90() {
        Context r0 = getContext();
        if (r0 == null) goto L14;
        CommonDialog.a r1 = new CommonDialog.a();
        r1.i(r0.getString(2131909224));
        CommonDialog.a.f(r1, new h(this), r0.getString(2131905462), false, 12);
        CommonDialog.a.e(r1, new i(), r0.getString(2131909223), 4);
        CommonDialog r2 = r1.c();
        FragmentManager r3 = getChildFragmentManager();
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r4);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r4) == true) goto L15;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r2.show(r3, null);
        return;
    L15:
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        U90().dispatchUIAction(new j.b(getArguments()));
        this.j = com.larus.utils.v.a(this, new c(this));
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        LarusPageBotBgSelectBinding r13 = this.e;
        if (r13 == null) goto L5;
        NovaTitleBarEx.Y5(r13.e, r13.a.getContext().getString(2131901082), null, null, 6);
        NovaTitleBarEx.b6(r13.e, 2131243589, false, null, null, new d(this), 14);
    L5:
        final LarusPageBotBgSelectBinding r14 = this.e;
        if (r14 == null) goto L8;
        e1.d(r14.d, new f(this, r14));
        e1.d(r14.b, new g(this));
        Unit r15 = Unit.INSTANCE;
    L8:
        LarusPageBotBgSelectBinding r16 = this.e;
        if (r16 == null) goto L23;
        BgSelectAdapter r0 = new BgSelectAdapter();
        r0.b = new b(this);
        this.h = r0;
        r16.f.getViewPager().setAdapter(this.h);
        r16.f.getViewPager().setOffscreenPageLimit(3);
        r16.f.getViewPager().registerOnPageChangeCallback(new BgSelectFragment$initViewPager$1$2(this));
        IndefinitePagerIndicator r1 = r16.c;
        ViewPager2 r17 = r16.f.getViewPager();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r17, "viewPager2");
        IndefinitePagerIndicator.InternalPageChangeCallback r2 = r1.b;
        if (r2 == null) goto L15;
        ViewPager2 r3 = r1.a;
        if (r3 == null) goto L15;
        r3.unregisterOnPageChangeCallback(r2);
    L15:
        r1.a = r17;
        IndefinitePagerIndicator.InternalPageChangeCallback r18 = new IndefinitePagerIndicator.InternalPageChangeCallback(r1);
        r1.b = r18;
        ViewPager2 r4 = r1.a;
        if (r4 == null) goto L18;
        r4.registerOnPageChangeCallback(r18);
    L18:
        ViewPager2 r19 = r1.a;
        if (r19 == null) goto L21;
        int r110 = r19.getCurrentItem();
    L22:
        r1.o = r110;
        Unit r111 = Unit.INSTANCE;
        goto L23
    L21:
        r110 = 0;
    L23:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new BgSelectFragment$bindObservers$1(this, null), 3, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(U90().getUiEvent(), new BgSelectFragment$bindObservers$2(this, null)), LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()));
        if (U90().getBotCreateTrace().c() == null) goto L50;
        String r112 = U90().getBotCreateTrace().c();
        String r113 = U90().getBotCreateTrace().b();
        Boolean r5 = Boolean.valueOf(U90().getBotCreateTrace().a.getBoolean("if_base_image"));
        String r6 = U90().getBotCreateTrace().e();
        String r7 = U90().getBotCreateTrace().d();
        String r8 = U90().getBotCreateTrace().a();
        JSONObject r9 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r112 != null) goto L48;
    L30:
        if (r113 == null) goto L32;
        r9.put("create_way", r113);     // Catch: JSONException -> L28
    L32:
        if (r5 != null) goto L34;
    L38:
        if (r6 == null) goto L40;
        r9.put("visual_style_status", r6);     // Catch: JSONException -> L28
    L40:
        if (r7 == null) goto L42;
        r9.put("description_status", r7);     // Catch: JSONException -> L28
    L42:
        if (r8 == null) goto L46;
        r9.put("enter_method", r8);     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_image_ai_choose_page_enter " + e.getLocalizedMessage());
    L46:
        TrackParams r114 = new TrackParams().merge(r9);
        by7.a r115 = new by7.a("bot_image_ai_choose_page_enter");
        r115.a.merge(r114);
        r115.b();
        return;
    L34:
        if (r5.booleanValue() == false) goto L36;
        String r116 = "1";
    L37:
        r9.put("if_base_image", r116);     // Catch: JSONException -> L28
        goto L38
    L36:
        r116 = TriggerSendLoading.NO_LOADING;
        goto L37
    L48:
        r9.put("creation_id", r112);     // Catch: JSONException -> L28
        goto L30
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131562999, r9, false);
        int r12 = 2131367647;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r11, 2131367647);
        if (r2 == null) goto L15;
        r12 = 2131375226;
        IndefinitePagerIndicator r3 = (IndefinitePagerIndicator) ViewBindings.findChildViewById(r11, 2131375226);
        if (r3 == null) goto L15;
        r12 = 2131384478;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r11, 2131384478);
        if (r4 == null) goto L15;
        r12 = 2131388772;
        NovaTitleBarEx r5 = (NovaTitleBarEx) ViewBindings.findChildViewById(r11, 2131388772);
        if (r5 == null) goto L15;
        r12 = 2131392571;
        BgSelectViewPagerContainer r6 = (BgSelectViewPagerContainer) ViewBindings.findChildViewById(r11, 2131392571);
        if (r6 == null) goto L15;
        ConstraintLayout r13 = r11;
        this.e = new LarusPageBotBgSelectBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
