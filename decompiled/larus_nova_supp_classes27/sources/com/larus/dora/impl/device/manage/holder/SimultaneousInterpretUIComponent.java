package com.larus.dora.impl.device.manage.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.router.SmartRouter;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementSimultaneousInterpretBinding;
import com.larus.dora.impl.device.manage.LifecycleUIComponent;
import com.larus.dora.impl.device.manage.p0;
import com.larus.dora.impl.device.manage.u0;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\nH\u0002J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\"H\u0002J\b\u0010)\u001a\u00020\u0015H\u0016J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/SimultaneousInterpretUIComponent;", "Lcom/larus/dora/impl/device/manage/LifecycleUIComponent;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementSimultaneousInterpretBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementSimultaneousInterpretBinding;", "isTranslatingLastVal", "", "Ljava/lang/Boolean;", "selectDeviceIsConnected", "avLinkService", "Lcom/larus/avlink/api/IDoraAVLinkService;", "getAvLinkService", "()Lcom/larus/avlink/api/IDoraAVLinkService;", "avLinkService$delegate", "Lkotlin/Lazy;", "translationStateListener", "Lkotlin/Function1;", "", "onCreateAndSetupView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onBind", "data", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "initView", "openSimultaneousInterpretDetail", "enterMethod", "", "autoStart", "adjustViewState", "isTranslating", "source", "reportClickEvent", "button", "onStart", "onDeviceSwitch", "event", "Lcom/larus/dora/impl/device/manage/DeviceSwitchEvent;", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimultaneousInterpretUIComponent extends LifecycleUIComponent {
    public static final /* synthetic */ int i = 0;
    public LarusItemDoraGDeviceManagementSimultaneousInterpretBinding d;
    public Boolean e;
    public Boolean f;
    public final Lazy g;
    public final f0 h;

    public static final class a {
    }

    static {
    }

    public final IDoraAVLinkService i() {
        return (IDoraAVLinkService) this.g.getValue();
    }

    public final LarusItemDoraGDeviceManagementSimultaneousInterpretBinding j() {
        LarusItemDoraGDeviceManagementSimultaneousInterpretBinding r0 = this.d;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.device.manage.holder.f0] */
    public SimultaneousInterpretUIComponent() {
        this.g = LazyKt.lazy(new e0());
        this.h = new f0(this);
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onDestroy() {
        super.onDestroy();
        IDoraAVLinkService r0 = i();
        if (r0 == null) goto L6;
        r0.C0(this.h);
        return;
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onStart() {
        super.onStart();
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r1 = false;
        if (r0 == null) goto L9;
        DeviceService r2 = r0.device();
        if (r2 == null) goto L9;
        if (r2.a() != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        String r4 = DoraConfig.c();
    L13:
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L20;
        DeviceService r6 = r5.device();
        if (r6 == null) goto L20;
        if (r6.a() != true) goto L20;
        r1 = true;
    L20:
        if (r1 == false) goto L22;
        String r7 = DoraConfig.d();
    L23:
        TextView r8 = j().f;
        IDoraAVLinkService r9 = i();
        String r10 = null;
        if (r9 == null) goto L26;
        String r11 = r9.K0(r4);
    L27:
        r8.setText(r11);
        TextView r12 = j().d;
        IDoraAVLinkService r13 = i();
        if (r13 == null) goto L30;
        r10 = r13.K0(r7);
    L30:
        r12.setText(r10);
        return;
    L26:
        r11 = null;
        goto L27
    L22:
        r7 = DoraConfig.b();
        goto L23
    L12:
        r4 = DoraConfig.a();
    L9:
        r3 = false;
        goto L10
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void b(p0 r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Boolean r1 = null;
        if ((r3 instanceof u0) == false) goto L5;
        u0 r4 = (u0) r3;
    L6:
        if (r4 == null) goto L8;
        r1 = Boolean.valueOf(r4.f);
    L8:
        this.f = r1;
        IDoraAVLinkService r5 = i();
        if (r5 == null) goto L13;
        boolean r0 = true;
        if (r5.j() != true) goto L13;
    L14:
        h(r0, "onBind");
        return;
    L13:
        r0 = false;
        goto L14
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void e(com.larus.dora.impl.device.manage.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        com.larus.dora.impl.device.manage.c r3 = r2.a;
        if (r3 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r3.f);
    L6:
        this.f = r4;
        if (Intrinsics.areEqual(this.e, Boolean.TRUE) == true) goto L10;
        h(false, "onDeviceSwitch");
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void l(String r5) {
        DoraBuryPointManager.a.L("dora_card_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("card_type", "device_management"), TuplesKt.to("card_content_type", "dora_interpretation"), TuplesKt.to("button_type", r5)}));
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final View c(LayoutInflater r9, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        Intrinsics.checkNotNullParameter(r10, "container");
        View r11 = r9.inflate(2131562558, r10, false);
        int r12 = 2131364845;
        RoundTextView r3 = (RoundTextView) ViewBindings.findChildViewById(r11, 2131364845);
        if (r3 == null) goto L20;
        r12 = 2131374794;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r11, 2131374794);
        if (r4 == null) goto L20;
        r12 = 2131374800;
        if (((ImageView) ViewBindings.findChildViewById(r11, 2131374800)) == null) goto L20;
        r12 = 2131390566;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131390566);
        if (r5 == null) goto L20;
        r12 = 2131391431;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131391431);
        if (r6 == null) goto L20;
        r12 = 2131391504;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r11, 2131391504);
        if (r7 == null) goto L20;
        RoundRelativeLayout r13 = (RoundRelativeLayout) r11;
        this.d = new LarusItemDoraGDeviceManagementSimultaneousInterpretBinding(r13, r3, r4, r5, r6, r7);
        IDoraAVLinkService r14 = i();
        if (r14 == null) goto L17;
        r14.O0(this.h);
    L17:
        e1.d(j().a, new g0(this));
        e1.d(j().b, new h0(this));
        return r13;
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    public final void h(boolean r4, String r5) {
        g49.d.d("SimultaneousInterpretUIComponent", "adjustViewState from ".concat(r5));
        if (r4 == false) goto L8;
        Boolean r6 = this.e;
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r6, r1) == false) goto L7;
        return;
    L7:
        this.e = r1;
        j().b.setText(2131902681);
        j().b.setTextColorWithPress(ve8.d.a(2131102625, j().a.getContext()));
        j().a.setEnabled(true);
        j().c.setAlpha(1.0f);
        j().e.setAlpha(1.0f);
        return;
    L8:
        Boolean r7 = this.e;
        Boolean r2 = Boolean.FALSE;
        if (Intrinsics.areEqual(r7, r2) == true) goto L11;
        this.e = r2;
        j().b.setText(2131902679);
    L11:
        Boolean r8 = this.f;
        if (r8 == null) goto L14;
        boolean r9 = r8.booleanValue();
    L15:
        if (r9 == false) goto L17;
        j().b.setTextColorWithPress(ve8.d.a(2131103136, j().a.getContext()));
        j().a.setEnabled(true);
        j().c.setAlpha(1.0f);
        j().e.setAlpha(1.0f);
        return;
    L17:
        j().b.setTextColorWithPress(ve8.d.a(2131103165, j().a.getContext()));
        j().a.setEnabled(false);
        j().c.setAlpha(0.3f);
        j().e.setAlpha(0.3f);
        return;
    L14:
        r9 = o59.a.k(DoraAdapterExtKt.h(kj4.a.g()));
        goto L15
    }

    public final void k(String r5, boolean r6) {
        com.bytedance.router.i r0 = SmartRouter.buildRoute(j().a.getContext(), "//flow/dora/simul_interpretat_detail");
        r0.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM, "device_management");
        r0.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, r5);
        r0.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_AUTO_START, r6);
        r0.d();
    }
}
