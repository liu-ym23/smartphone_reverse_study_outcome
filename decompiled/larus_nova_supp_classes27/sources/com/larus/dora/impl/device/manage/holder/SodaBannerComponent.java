package com.larus.dora.impl.device.manage.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementSodaBannerBinding;
import com.larus.dora.impl.device.manage.LifecycleUIComponent;
import com.larus.dora.impl.device.manage.b1;
import com.larus.dora.impl.device.manage.p0;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\rH\u0016J\u0006\u0010!\u001a\u00020\rJ\u0006\u0010\"\u001a\u00020\rJ\b\u0010#\u001a\u00020\rH\u0002J\b\u0010$\u001a\u00020\rH\u0002J\b\u0010%\u001a\u00020\rH\u0016J\b\u0010&\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006("}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/SodaBannerComponent;", "Lcom/larus/dora/impl/device/manage/LifecycleUIComponent;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementSodaBannerBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementSodaBannerBinding;", "currentBannerType", "", "onBannerClosed", "Lkotlin/Function1;", "", "getOnBannerClosed", "()Lkotlin/jvm/functions/Function1;", "setOnBannerClosed", "(Lkotlin/jvm/functions/Function1;)V", "onCreateAndSetupView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onBind", "data", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "requestUpdateTopMarginByPreviousItem", "updateTopMarginByPreviousItem", "updateTopMargin", "useCompactTopMargin", "", "onStart", "showBanner", "hideBanner", "closeBanner", "openSodaVipApplet", "onDestroy", "onStop", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SodaBannerComponent extends LifecycleUIComponent {
    public static final /* synthetic */ int g = 0;
    public LarusItemDoraGDeviceManagementSodaBannerBinding d;
    public final int e;
    public Function1<? super Integer, Unit> f;

    public static final class a {
    }

    static {
    }

    public final LarusItemDoraGDeviceManagementSodaBannerBinding h() {
        LarusItemDoraGDeviceManagementSodaBannerBinding r0 = this.d;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public SodaBannerComponent() {
        this.e = 1;
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onDestroy() {
        super.onDestroy();
        g49.d.d("SodaBannerComponent", "onDestroy");
        this.d = null;
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onStart() {
        super.onStart();
        LarusItemDoraGDeviceManagementSodaBannerBinding r0 = this.d;
        if (r0 == null) goto L8;
        ItemGroup r1 = r0.a;
        if (r1 == null) goto L9;
        r1.post(new m0(this));
        return;
    L9:
        return;
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onStop() {
        super.onStop();
        g49.d.d("SodaBannerComponent", "onStop");
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void b(p0 r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        if ((r3 instanceof b1) == false) goto L5;
        b1 r4 = (b1) r3;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        g49.d.d("SodaBannerComponent", "onBind: item=" + r4);
        if (r4.e == false) goto L15;
        e1.x(h().a);
        LarusItemDoraGDeviceManagementSodaBannerBinding r5 = this.d;
        if (r5 == null) goto L17;
        ItemGroup r6 = r5.a;
        if (r6 == null) goto L18;
        r6.post(new m0(this));
        return;
    L18:
        return;
    L17:
        return;
    L15:
        e1.o(h().a);
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final View c(LayoutInflater r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r6, "container");
        g49.d.d("SodaBannerComponent", "onCreateAndSetupView");
        ItemGroup r7 = r5.inflate(2131562559, r6, false);
        int r8 = 2131386967;
        LinearLayoutCompat r0 = ViewBindings.findChildViewById(r7, 2131386967);
        if (r0 == null) goto L19;
        ItemGroup r9 = r7;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r7, 2131386969);
        if (r2 != null) goto L7;
        r8 = 2131386969;
        goto L19
    L7:
        if (((ImageView) ViewBindings.findChildViewById(r7, 2131386970)) != null) goto L9;
        r8 = 2131386970;
        goto L19
    L9:
        if (ViewBindings.findChildViewById(r7, 2131386971) != null) goto L11;
        r8 = 2131386971;
        goto L19
    L11:
        if (((DoraTextView) ViewBindings.findChildViewById(r7, 2131386972)) == null) goto L14;
        this.d = new LarusItemDoraGDeviceManagementSodaBannerBinding(r9, r0, r2);
        e1.d(h().b, new k0(this));
        h().c.setOnClickListener(new l0(this));
        return h().a;
    L14:
        r8 = 2131386972;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r8)));
    }
}
