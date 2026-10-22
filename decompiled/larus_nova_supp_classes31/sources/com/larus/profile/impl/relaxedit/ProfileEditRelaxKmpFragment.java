package com.larus.profile.impl.relaxedit;

import android.os.Bundle;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.bytedance.relax.ttmlstatic.prewarm.TtmlStaticPrewarmer;
import com.larus.common.apphost.AppHost;
import com.larus.ivykit.IvyKitInitializer;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.profile.impl.ProfileEditFragment;
import com.larus.profile.impl.a1;
import com.larus.profile.impl.lynx.avatar.ProfileAvatarLynxUI;
import com.larus.profile.impl.relaxedit.input.LynxUIInputLit;
import com.larus.profile.impl.view.ProfileEditPerfRootLayout;
import com.larus.profile.impl.viewmodel.ProfileEditViewModel;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.FragmentExtKt$addOnBackPressed$callback$1;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.q1;
import com.lynx.tasm.s0;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0002J(\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*H\u0002J\b\u0010+\u001a\u00020'H\u0016J\b\u0010,\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/profile/impl/relaxedit/ProfileEditRelaxKmpFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "lynxView", "Lcom/lynx/tasm/LynxView;", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "didFallback", "", "viewModel", "Lcom/larus/profile/impl/viewmodel/ProfileEditViewModel;", "getViewModel", "()Lcom/larus/profile/impl/viewmodel/ProfileEditViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "perfTracer", "Lcom/larus/profile/impl/ProfileEditPerfTracer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onDestroy", "removeTextViewChangeWatchers", "ensureLynxRuntimeReady", "registerHostBindingsAfterFirstDraw", "hostController", "Lcom/larus/profile/impl/relaxedit/ProfileEditHostController;", "fallbackToNative", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "", "detail", "throwable", "", "getCurrentPageName", "autoLogEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileEditRelaxKmpFragment extends TraceFragment {
    public static final List<com.lynx.tasm.behavior.a> j = null;
    public LynxView e;
    public FragmentExtKt$addOnBackPressed$callback$1 f;
    public boolean g;
    public final Lazy h;
    public a1 i;

    public static final class a extends com.lynx.tasm.behavior.a {
        public a() {
            super("x-input-ng");
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new LynxUIInputLit(r2);
        }
    }

    public static final class b extends com.lynx.tasm.behavior.a {
        public b() {
            super("profile-avatar");
        }

        public final LynxUI<?> createUI(LynxContext r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return new ProfileAvatarLynxUI(r2);
        }
    }

    public static final class c {
    }

    public static final class d extends q1 {
        public final /* synthetic */ ProfileEditRelaxKmpFragment a;

        public d(ProfileEditRelaxKmpFragment r1) {
            this.a = r1;
        }

        public final void onLoadFailed(String r4) {
            ProfileEditRelaxKmpFragment r0 = this.a;
            if (r4 != null) goto L5;
        L10:
            String r5 = null;
        L11:
            List<com.lynx.tasm.behavior.a> r2 = ProfileEditRelaxKmpFragment.j;
            r0.U90("load_failed", r5, null);
            return;
        L5:
            if ((!StringsKt.isBlank(r4)) == true) goto L8;
            r4 = null;
        L8:
            if (r4 == null) goto L10;
            r5 = "message=".concat(r4);
            goto L11
        }

        public final void onReceivedError(LynxError r7) {
            if (r7 == null) goto L5;
            String r1 = Integer.valueOf(r7.getErrorCode()).toString();
        L6:
            String r2 = "";
            if (r1 != null) goto L9;
            r1 = "";
        L9:
            if (r7 == null) goto L11;
            String r3 = r7.getLevel();
        L12:
            if (r3 == null) goto L15;
            r2 = r3;
        L15:
            if (r7 == null) goto L19;
            boolean r4 = true;
            if (r7.isFatal() != true) goto L19;
        L20:
            if (r7 == null) goto L24;
            if (r4 == true) goto L24;
            if (Intrinsics.areEqual(r2, "error") == true) goto L24;
            return;
        L24:
            ProfileEditRelaxKmpFragment r8 = this.a;
            String r5 = "code=" + r1 + " level=" + r2 + " fatal=" + r4;
            List<com.lynx.tasm.behavior.a> r6 = ProfileEditRelaxKmpFragment.j;
            r8.U90("runtime_error", r5, null);
            return;
        L19:
            r4 = false;
            goto L20
        L11:
            r3 = null;
            goto L12
        L5:
            r1 = null;
            goto L6
        }
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "profile_setting";
    }

    static {
        j = CollectionsKt.listOf(new com.lynx.tasm.behavior.a[]{new x5a.f(), new a(), new b()});
    }

    public final void onDestroy() {
        FragmentExtKt$addOnBackPressed$callback$1 r0 = this.f;
        if (r0 == null) goto L5;
        r0.remove();
    L5:
        this.f = null;
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void onDestroyView() {
        LynxView r0 = this.e;
        if (r0 == null) goto L5;
        V90(r0);
        r0.destroy();
    L5:
        this.e = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public ProfileEditRelaxKmpFragment() {
        final Function0<Fragment> r0 = new ProfileEditRelaxKmpFragment$special$$inlined$viewModels$default$1(this);
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileEditViewModel.class), new ProfileEditRelaxKmpFragment$special$$inlined$viewModels$default$2(r0), new ProfileEditRelaxKmpFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public static void V90(View r8) {
        int r1 = 0;
        if ((r8 instanceof TextView) == false) goto L20;
        CharSequence r0 = ((TextView) r8).getText();
        if ((r0 instanceof Spannable) == false) goto L7;
        Spannable r2 = (Spannable) r0;
    L8:
        if (r2 == null) goto L20;
        Object[] r3 = r2.getSpans(0, r2.length(), SpanWatcher.class);
        ArrayList r4 = new ArrayList();
        int r5 = r3.length;
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L15;
        Object r7 = r3[r6];
        if ((r7 instanceof TextWatcher) == false) goto L14;
        r4.add(r7);
    L14:
        r6 = r6 + 1;
        goto L10
    L15:
        Iterator r9 = r4.iterator();
    L17:
        if (r9.hasNext() == false) goto L20;
        r2.removeSpan((TextWatcher) r9.next());
        goto L17
    L7:
        r2 = null;
    L20:
        if ((r8 instanceof ViewGroup) == false) goto L24;
        ViewGroup r10 = (ViewGroup) r8;
        int r11 = r10.getChildCount();
    L22:
        if (r1 >= r11) goto L30;
        V90(r10.getChildAt(r1));
        r1 = r1 + 1;
        goto L22
    L30:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        AtomicBoolean r3 = a1.l;
        this.i = a1.a.a(getArguments(), "relax");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(final View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        AtomicBoolean r1 = a1.l;
        long r2 = System.currentTimeMillis();
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r14, r15);
        a1 r16 = null;
        IvyKitInitializer r3 = IvyKitInitializer.a;     // Catch: Throwable -> L23
        if (IvyKitInitializer.c() == true) goto L6;
        r3.b(AppHost.a.getApplication(), new k());     // Catch: Throwable -> L23
    L6:
        final f r4 = new f(this, requireActivity());     // Catch: Throwable -> L23
        a1 r5 = this.i;     // Catch: Throwable -> L23
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("perfTracer");     // Catch: Throwable -> L23
        r5 = null;
    L9:
        r5.j = TtmlStaticPrewarmer.b.get();     // Catch: Throwable -> L23
        long r6 = System.currentTimeMillis();     // Catch: Throwable -> L23
        LynxViewBuilder r7 = new LynxViewBuilder().addBehaviors(j).setEnableMTSModule(true).setEnableJSRuntime(false).setEnableLepusModule(false).setEmbeddedMode(29);     // Catch: Throwable -> L23
        LynxViewBuilder r8 = r7;     // Catch: Throwable -> L23
        r8.insertLynxViewConfig("enable_skip_update_viewport_on_init_when_measure_spec_empty", "1");     // Catch: Throwable -> L23
        r8.registerModule(ProfileEditHostModule.MODULE_NAME, ProfileEditHostModule.class, r4);     // Catch: Throwable -> L23
        View r9 = r7.build(requireContext());     // Catch: Throwable -> L23
        a1 r10 = this.i;     // Catch: Throwable -> L23
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("perfTracer");     // Catch: Throwable -> L23
        r10 = null;
    L12:
        r10.getClass();     // Catch: Throwable -> L23
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L23
        if (r6 > 0) goto L15;
    L17:
        long r12 = -1;
    L18:
        r10.e = r12;     // Catch: Throwable -> L23
        this.e = r9;     // Catch: Throwable -> L23
        r9.addLynxViewClient(new d(this));     // Catch: Throwable -> L23
        ((ViewGroup) r14).addView(r9, new ViewGroup.LayoutParams(-1, -1));     // Catch: Throwable -> L23
        Map<String, Object> r13 = r4.c();     // Catch: Throwable -> L23
        s0.a r17 = new s0.a();     // Catch: Throwable -> L23
        r17.a = "files/relax/pages/profile-edit/template.js";     // Catch: Throwable -> L23
        r17.d = TemplateData.createForStaticPage(r13);     // Catch: Throwable -> L23
        Object r18 = m.a;     // Catch: Throwable -> L23
        TemplateBundle r19 = m.b;     // Catch: Throwable -> L23
        if (r19 != null) goto L21;
    L25:
        r19 = null;
    L26:
        if (r19 != null) goto L42;
        Object r20 = m.a;     // Catch: Throwable -> L23
        monitor-enter(r20);     // Catch: Throwable -> L23
        TemplateBundle r21 = m.b;     // Catch: Throwable -> L35
        if (r21 != null) goto L33;
    L37:
        r21 = null;
    L38:
        if (r21 != null) goto L40;
        r21 = m.a();     // Catch: Throwable -> L35
        m.b = r21;     // Catch: Throwable -> L35
    L40:
        monitor-exit(r20);     // Catch: Throwable -> L23
        r19 = r21;
        goto L42
    L33:
        if (r21.i() == false) goto L37;
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L42:
        r17.c = r19;     // Catch: Throwable -> L23
        s0 r22 = r17.b();     // Catch: Throwable -> L23
        long r23 = System.currentTimeMillis();     // Catch: Throwable -> L23
        r9.loadTemplate(r22);     // Catch: Throwable -> L23
        a1 r24 = this.i;     // Catch: Throwable -> L23
        if (r24 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("perfTracer");     // Catch: Throwable -> L23
        r24 = null;
    L45:
        long r25 = System.currentTimeMillis() - r23;     // Catch: Throwable -> L23
        if (r25 < 0) goto L48;
        r24.f = r25;     // Catch: Throwable -> L23
    L49:
        ((ProfileEditPerfRootLayout) r14).setOnFirstDispatchDrawEndListener$impl_mainlandRelease(new h(this, r14, r4));     // Catch: Throwable -> L23
        a1 r110 = this.i;
        if (r110 == null) goto L61;
    L62:
        r16 = r110;
    L63:
        r16.b(r2);
        return;
    L61:
        Intrinsics.throwUninitializedPropertyAccessException("perfTracer");
        goto L63
    L48:
        r24.getClass();     // Catch: Throwable -> L23
        goto L49
    L21:
        if (r19.i() == false) goto L25;
    L15:
        if (r11 < r6) goto L17;
        r12 = r11 - r6;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        StringBuilder r26 = new StringBuilder("type=");     // Catch: Throwable -> L65
        r26.append(th.getClass().getSimpleName());     // Catch: Throwable -> L65
        r26.append(" message=");     // Catch: Throwable -> L65
        String r0 = th.getMessage();     // Catch: Throwable -> L65
        if (r0 != null) goto L58;
        r0 = "";
    L58:
        r26.append(r0);     // Catch: Throwable -> L65
        U90("setup_failed", r26.toString(), th);     // Catch: Throwable -> L65
        r110 = this.i;
        if (r110 != null) goto L62;
    L65:
        th = move-exception;
        a1 r27 = this.i;
        if (r27 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("perfTracer");
    L70:
        r16.b(r2);
        throw th;
    L69:
        r16 = r27;
        goto L70
    }

    public final void U90(String r5, String r6, Throwable r7) {
        if (this.g == false) goto L5;
        return;
    L5:
        if (isAdded() == false) goto L28;
        this.g = true;
        if (r6 != null) goto L10;
    L15:
        String r8 = null;
    L16:
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        FLogger.a.e("ProfileEditRelaxKmpFragment", "fallback to native ProfileEditFragment, reason=" + r5 + r8, r7);
        ProfileEditFragment r9 = new ProfileEditFragment();
        Bundle r10 = getArguments();
        if (r10 != null) goto L21;
        r10 = new Bundle();
    L21:
        AtomicBoolean r11 = a1.l;
        r10.putBoolean("profile_edit_perf_report_enabled", false);
        r9.setArguments(r10);
        FragmentTransaction r12 = getParentFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L25;
        r12 = r12.replace(2131373275, r9);
    L25:
        r12.commitAllowingStateLoss();
        return;
    L10:
        if ((true ^ StringsKt.isBlank(r6)) == true) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L15;
        r8 = ", ".concat(r6);
        goto L16
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        ConstraintLayout r4 = new ProfileEditPerfRootLayout(requireContext());
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r4.setTag(2131377847, this);
        return r4;
    }
}
