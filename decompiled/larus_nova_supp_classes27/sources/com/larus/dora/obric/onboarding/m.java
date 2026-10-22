package com.larus.dora.obric.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingEnvObserveContentBinding;
import com.larus.dora.impl.device.settings.lab.env.auth.EnvAuthViewModel;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.resource.DoraResourceType;
import com.larus.dora.impl.view.DoraTextViewWithAnim;
import com.larus.image.loader.ImageLoaderKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.button.OButton;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m {
    public static final a j = null;
    public final AppCompatActivity a;
    public final String b;
    public final Function0<Unit> c;
    public final Function1<ObricDoraGEnvAuthResult, Unit> d;
    public final EnvAuthViewModel e;
    public boolean f;
    public Job g;
    public final h h;
    public final OSheet i;

    public static final class a {
        public a() {
        }

        public static boolean a(a r1, Context r2, String r3, com.larus.dora.obric.device_management.device_home.z0 r4, int r5) {
            if ((r5 & 8) == 0) goto L5;
            r4 = null;
        L5:
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "context");
            if ((r2 instanceof AppCompatActivity) == false) goto L8;
            AppCompatActivity r6 = (AppCompatActivity) r2;
        L10:
            if (r6 != null) goto L22;
            g49.d.e("ObricDoraGEnvAuthSheet", "context is not AppCompatActivity, fallback to onboarding page");
            return false;
        L22:
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L14
            m.a(new m(r6, r3, null, r4));     // Catch: Throwable -> L14
            Object r8 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L14
        L16:
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L21;
            g49.d.c("ObricDoraGEnvAuthSheet", "show env auth sheet failed, fallback to onboarding page", r9);
            r8 = Boolean.FALSE;
        L21:
            return ((Boolean) r8).booleanValue();
        L14:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L16
        L8:
            r6 = null;
            goto L10
        }
    }

    static {
        j = new a();
    }

    public static final void a(final m r7) {
        r7.g = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r7.a), null, null, new ObricDoraGEnvAuthSheet$observeAuthResult$1(r7, null), 3, null);
        r7.i.setOnDismissListener(new i(r7));
        OSheet r8 = r7.i;
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r8);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextViewWithAnim] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.dora.obric.onboarding.j] */
    public m(AppCompatActivity r9, String r10, Function0<Unit> r11, Function1<? super ObricDoraGEnvAuthResult, Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        this.a = r9;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        View r13 = LayoutInflater.from(r9).inflate(2131563987, null, false);
        int r14 = 2131381187;
        OButton r1 = ViewBindings.findChildViewById(r13, 2131381187);
        if (r1 == null) goto L14;
        r14 = 2131381188;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(r13, 2131381188);
        if (r2 == null) goto L14;
        r14 = 2131381189;
        ?? r3 = (DoraTextViewWithAnim) ViewBindings.findChildViewById(r13, 2131381189);
        if (r3 == 0) goto L14;
        ScrollView r15 = (ScrollView) r13;
        ObricDoraGOnboardingEnvObserveContentBinding r16 = new ObricDoraGOnboardingEnvObserveContentBinding(r15, r1, r2, r3);
        this.e = (EnvAuthViewModel) new ViewModelProvider(r9).get(EnvAuthViewModel.class);
        this.h = new h(new j(this));
        final OSheet r4 = new OSheet(r9, 0, false, 30);
        OSheetBase.DefaultImpls.q(r4, OSheet.HeightMode.FULL_HEIGHT);
        ImageLoaderKt.s(r16.b, com.larus.dora.impl.resource.j0.g(com.larus.dora.impl.resource.j0.a, r9, DoraResourceDeviceType.G2, DoraResourceType.DRAWABLE, "obric_onboarding_service_recommendation_icon"), null);
        r1.setOnClickListener(new k(this));
        r3.setOnClickListener(new l(this, r4));
        r15.setVisibility(0);
        View r17 = r15.getChildAt(0);
        if (r17 == null) goto L11;
        Resources r18 = r9.getResources();
        r17.setPadding(r17.getPaddingLeft(), (int) ((68 * WindowDisplayMetricsOverride.apply(r18, r18.getDisplayMetrics()).density) + 0.5f), r17.getPaddingRight(), r17.getPaddingBottom());
    L11:
        FrameLayout r110 = new FrameLayout(r9);
        r110.addView(r15, new FrameLayout.LayoutParams(-1, -1));
        OSheetBase.DefaultImpls.j(r4, r110);
        this.i = r4;
        return;
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
