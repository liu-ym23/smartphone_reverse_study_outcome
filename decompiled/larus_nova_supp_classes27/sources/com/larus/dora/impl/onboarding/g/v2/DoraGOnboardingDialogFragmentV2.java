package com.larus.dora.impl.onboarding.g.v2;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingDialogBinding;
import com.larus.dora.impl.onboarding.g.DoraGOnboardingShimmerTextView;
import com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment;
import com.larus.dora.impl.onboarding.i0;
import com.larus.dora.impl.onboarding.q0;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.dora.impl.util.DoraVideoType;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.utils.e1;
import com.larus.utils.j0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0013H\u0002J\f\u0010\u0018\u001a\u00020\u0015*\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006*"}, d2 = {"Lcom/larus/dora/impl/onboarding/g/v2/DoraGOnboardingDialogFragmentV2;", "Lcom/larus/dora/impl/onboarding/g/v2/base/DoraGOnboardingDialogBaseFragment;", "<init>", "()V", "playTipsRunnable", "Ljava/lang/Runnable;", "scanForALongTimeInMillis", "", "getScanForALongTimeInMillis", "()J", "productType", "Lcom/bytedance/dora/annotation/ProductNameType;", "scanProductTypes", "", "productTypeDisplayName", "", "sku", "getTip", "index", "", "playTips", "", "Lcom/larus/dora/impl/onboarding/g/DoraGOnboardingShimmerTextView;", "tipIndex", "playTimeoutTip", "cancelPlayTips", "handleMovie", "state", "Lcom/larus/dora/impl/onboarding/OnboardingUiState;", "handleBottomTips", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "handleUnbind", "device", "Lcom/bytedance/dora/device/DoraDevice;", "shouldAuthDevice", "", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOnboardingDialogFragmentV2 extends DoraGOnboardingDialogBaseFragment {
    public static final /* synthetic */ int o = 0;
    public d m;
    public final long n;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final String pa0() {
        return "";
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final String la0() {
        int r0 = j0.a;
        return j0.d(2131903932);
    }

    public final void ra0() {
        Runnable r0 = this.m;
        if (r0 == null) goto L11;
        LarusDoraGOnboardingDialogBinding r1 = this.d;
        if (r1 == null) goto L9;
        AppCompatTextView r2 = r1.c;
        if (r2 == null) goto L9;
        r2.removeCallbacks(r0);
    L9:
        this.m = null;
        g49.d.a("DoraGOnboardingDialogFragment", "cancelPlayTips");
        return;
    }

    public DoraGOnboardingDialogFragmentV2() {
        this.n = 40000;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final ProductNameType ka0() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getInt("key_dora_product_id", ProductNameType.DORA_G.id));
    L6:
        ProductNameType r2 = ProductNameType.DORA_G2;
        int r3 = r2.id;
        if (r1 != null) goto L10;
    L12:
        ProductNameType r4 = ProductNameType.DORA_G_AIR;
        int r5 = r4.id;
        if (r1 != null) goto L16;
    L18:
        ProductNameType r6 = ProductNameType.DORA_G_PIN;
        int r7 = r6.id;
        if (r1 == null) goto L25;
        if (r1.intValue() != r7) goto L25;
        return r6;
    L25:
        return ProductNameType.DORA_G;
    L16:
        if (r1.intValue() != r5) goto L18;
        return r4;
    L10:
        if (r1.intValue() != r3) goto L12;
        return r2;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List] */
    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final Collection<ProductNameType> na0() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L17;
        int[] r1 = r0.getIntArray("key_dora_scan_product_ids");
        if (r1 == null) goto L17;
        ArrayList r2 = new ArrayList(r1.length);
        int r3 = r1.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L9;
        r2.add(ProductNameType.getProduct(r1[r4]));
        r4 = r4 + 1;
        goto L7
    L9:
        List r5 = CollectionsKt.filterNotNull(r2);
        if (r5 == null) goto L17;
        HashSet r6 = new HashSet();
        ?? r7 = new ArrayList();
        Iterator r8 = r5.iterator();
    L13:
        if (r8.hasNext() == false) goto L18;
        Object r9 = r8.next();
        if (r6.add(Integer.valueOf(((ProductNameType) r9).id)) == false) goto L13;
        r7.add(r9);
    L18:
        if (r7 != 0) goto L20;
        r7 = CollectionsKt.emptyList();
    L20:
        Collection<ProductNameType> r10 = (Collection) r7;
        if (r10.isEmpty() == false) goto L24;
        r10 = CollectionsKt.toList(super.na0());
    L24:
        return r10;
    L17:
        r7 = 0;
        goto L18
    }

    public final void onDestroyView() {
        ra0();
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        LarusDoraGOnboardingDialogBinding r0 = this.d;
        if (r0 == null) goto L7;
        DoraMovieView r1 = r0.h;
        if (r1 == null) goto L7;
        r1.g();
        r1.f();
    L7:
        boolean r2 = com.larus.dora.impl.onboarding.d.a;
        com.larus.dora.impl.onboarding.d.a = false;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final long Y90() {
        return this.n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.larus.dora.impl.onboarding.g.DoraGOnboardingShimmerTextView] */
    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final void da0(q0 r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        LarusDoraGOnboardingDialogBinding r0 = this.d;
        if (r0 == null) goto L14;
        ?? r1 = r0.c;
        if (r1 != 0) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r3, q0.e.a) == false) goto L10;
        e1.x(r1);
        ta0(r1, 0);
        return;
    L10:
        if (Intrinsics.areEqual(r3, q0.f.a) == false) goto L12;
        e1.x(r1);
        ra0();
        r1.x();
        int r4 = j0.a;
        r1.setText(j0.d(2131902831));
        g49.d.a("DoraGOnboardingDialogFragment", "playTimeoutTip: " + r1.getText());
        r1.setAnimRepeatCount(-1);
        r1.y();
        return;
    L12:
        e1.o(r1);
        ra0();
        r1.x();
        return;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final void ea0(q0 r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        if (Intrinsics.areEqual(r4, q0.f.a) == true) goto L5;
        return;
    L5:
        LarusDoraGOnboardingDialogBinding r5 = this.d;
        if (r5 == null) goto L9;
        DoraMovieView r0 = r5.h;
        r0.f();
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r5.h, "alpha", new float[]{0.0f, 1.0f});
        r6.setDuration(300);
        r6.setInterpolator(new DecelerateInterpolator());
        r6.start();
        Intrinsics.checkNotNull(r0);
        i0.b(r0, DoraVideoType.DORA_G_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX_TIMEOUT, com.larus.dora.impl.util.u.a.b("larus_dora_g_onboarding_unboxing_timeout"), DoraSKU.WHITE);
        g49.d.a("DoraGOnboardingDialogFragment", "--UNBOXING");
        r0.b();
        return;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final void ga0(final DoraDevice r6) {
        Intrinsics.checkNotNullParameter(r6, "device");
        if (o59.a.v(r6) == true) goto L7;
        super.ga0(r6);
        return;
    L7:
        if (r6.isFactory() == false) goto L9;
        X90().replaceBindAndConnect(r6);
        return;
    L9:
        CommonDialog r0 = n69.c.a;
        n69.c.b(getContext(), getChildFragmentManager(), new com.larus.dora.impl.onboarding.g.v2.a(this, r6), new b(this, r6), new c(this, r6));
    }

    public final String sa0(int r2) {
        int r3 = r2 % 3;
        if (r3 != 0) goto L5;
        int r4 = j0.a;
        return j0.d(2131902830);
    L5:
        if (r3 != 1) goto L7;
        int r5 = j0.a;
        return j0.d(2131902828);
    L7:
        if (r3 == 2) goto L9;
        return "";
    L9:
        int r6 = j0.a;
        return j0.d(2131902829);
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        LarusDoraGOnboardingDialogBinding r4 = this.d;
        if (r4 == null) goto L5;
        final DoraMovieView r5 = r4.h;
        r5.post(new e(r5));
    L5:
        com.larus.dora.impl.onboarding.d.a = true;
        int r6 = j49.a.a;
        j49.a.g(this.i, "connection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.impl.onboarding.g.v2.d, java.lang.Runnable] */
    public final void ta0(final DoraGOnboardingShimmerTextView r4, final int r5) {
        ra0();
        g49.d.a("DoraGOnboardingDialogFragment", "playTips: " + r5 + ", " + sa0(r5));
        r4.setText(sa0(r5));
        r4.setAnimRepeatCount(3);
        r4.y();
        ?? r0 = new d(this, r5, r4);
        this.m = r0;
        r4.postDelayed(r0, 8000);
    }
}
