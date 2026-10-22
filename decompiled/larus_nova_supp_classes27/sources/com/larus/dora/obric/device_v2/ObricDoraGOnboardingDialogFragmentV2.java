package com.larus.dora.obric.device_v2;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.TextViewCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingDialogBinding;
import com.larus.dora.impl.onboarding.TOAST_TYPE;
import com.larus.dora.impl.onboarding.g.DoraGOnboardingShimmerTextView;
import com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment;
import com.larus.dora.impl.onboarding.i0;
import com.larus.dora.impl.onboarding.o0;
import com.larus.dora.impl.onboarding.q0;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.resource.DoraResourceTheme;
import com.larus.dora.impl.resource.DoraResourceType;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.dora.impl.util.DoraVideoType;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.obric.oui.sheet.v2.OSheetFooterBtnContainer;
import com.obric.oui.sheet.v2.OSheetTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.live.alphaplayer.Configuration;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 r2\u00020\u0001:\u0001rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010&\u001a\u00020'H\u0016J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020'0)H\u0014J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0015H\u0014J\b\u00100\u001a\u000201H\u0014J\u0010\u00102\u001a\u0002012\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000201H\u0002J\b\u00106\u001a\u000201H\u0002J\u0010\u00107\u001a\u0002012\u0006\u00103\u001a\u000204H\u0016J\u0010\u00108\u001a\u0002012\u0006\u00103\u001a\u000204H\u0016J\u0010\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020;H\u0014J\u0010\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020\u0017H\u0016J\b\u0010@\u001a\u000201H\u0016J\u0016\u0010A\u001a\u000201*\u00020B2\b\b\u0002\u0010C\u001a\u00020 H\u0002J\f\u0010D\u001a\u000201*\u00020BH\u0002J\f\u0010E\u001a\u000201*\u00020BH\u0002J\f\u0010F\u001a\u000201*\u00020BH\u0002J\b\u0010G\u001a\u000201H\u0002J\u0010\u0010H\u001a\u00020+2\u0006\u0010I\u001a\u00020 H\u0002J\b\u0010J\u001a\u00020\u0017H\u0002J\b\u0010K\u001a\u000201H\u0002J\b\u0010L\u001a\u00020\u0005H\u0002J\b\u0010M\u001a\u00020\u000bH\u0002J\b\u0010N\u001a\u00020\u0005H\u0002J\b\u0010O\u001a\u00020\u0005H\u0002J\b\u0010P\u001a\u00020\u0005H\u0002J \u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\u0005H\u0002J2\u0010U\u001a\u0002012\u0006\u0010V\u001a\u00020+2\u0006\u0010W\u001a\u00020\u00152\b\u0010X\u001a\u0004\u0018\u00010+2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010ZH\u0002J\b\u0010[\u001a\u000201H\u0002J \u0010\\\u001a\u0002012\u0006\u0010]\u001a\u00020+2\u000e\u0010:\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010ZH\u0002J\b\u0010^\u001a\u000201H\u0002J\b\u0010_\u001a\u000201H\u0002J\b\u0010`\u001a\u000201H\u0002J\u0010\u0010a\u001a\u0002012\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010b\u001a\u00020c2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010d\u001a\u00020+2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010e\u001a\u00020 2\u0006\u0010f\u001a\u00020gH\u0002J\b\u0010h\u001a\u000201H\u0002J\b\u0010i\u001a\u000201H\u0002J\b\u0010j\u001a\u000201H\u0002J\b\u0010k\u001a\u00020\u0007H\u0002J\n\u0010l\u001a\u0004\u0018\u00010mH\u0002J\n\u0010n\u001a\u0004\u0018\u00010mH\u0002J\u0012\u0010o\u001a\u0004\u0018\u00010p2\u0006\u0010q\u001a\u00020+H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001cX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u0017X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006s"}, d2 = {"Lcom/larus/dora/obric/device_v2/ObricDoraGOnboardingDialogFragmentV2;", "Lcom/larus/dora/impl/onboarding/g/v2/base/DoraGOnboardingDialogBaseFragment;", "<init>", "()V", "connectOverlayLayer", "Landroid/widget/FrameLayout;", "alphaPlayer", "Lcom/ss/android/ugc/aweme/live/alphaplayer/controller/IPlayerController;", "onboardingSheet", "Lcom/obric/oui/sheet/v2/OSheet;", "onboardingTitleBar", "Lcom/obric/oui/sheet/v2/OSheetTitleBar;", "onboardingMediaBody", "onboardingCopyFooter", "onboardingActionFooter", "onboardingActionButton", "Lcom/obric/oui/sheet/v2/OSheetFooterBtnContainer;", "onboardingConnectingFooter", "g2RebindDialog", "Landroid/content/DialogInterface;", "renderedBody", "Landroid/view/View;", "isConnectOverlayPlaying", "", "isTimeoutMediaShowing", "playTipsRunnable", "Ljava/lang/Runnable;", "scanForALongTimeInMillis", "", "getScanForALongTimeInMillis", "()J", "bluetoothOffToastResId", "", "getBluetoothOffToastResId", "()Ljava/lang/Integer;", "usesCustomDialogContainer", "getUsesCustomDialogContainer", "()Z", "productType", "Lcom/bytedance/dora/annotation/ProductNameType;", "scanProductTypes", "", "productTypeDisplayName", "", "sku", "createCustomDialog", "Landroid/app/Dialog;", "content", "onOnboardingContentReady", "", "handleMovie", "state", "Lcom/larus/dora/impl/onboarding/OnboardingUiState;", "showTimeoutMovie", "showG2TimeoutMovie", "handleBottomTips", "handleUiState", "handleAction", "action", "Lcom/larus/dora/impl/onboarding/OnboardingAction;", "handleUnbind", "device", "Lcom/bytedance/dora/device/DoraDevice;", "shouldAuthDevice", "onDestroy", "playTips", "Lcom/larus/dora/impl/onboarding/g/DoraGOnboardingShimmerTextView;", "tipIndex", "playTimeoutTip", "playG2TimeoutTip", "restoreDefaultTipStyle", "cancelPlayTips", "getTip", "index", "shouldUseG2Copy", "initObricSheetControls", "createOnboardingMediaBody", "createOnboardingTitleBar", "createOnboardingCopyFooter", "createOnboardingConnectingFooter", "createOnboardingActionFooter", "createOnboardingFooter", "copyFooter", "actionFooter", "connectingFooter", "renderSheetState", "title", "body", "footerText", "footerAction", "Lkotlin/Function0;", "showCopyFooter", "showActionFooter", "buttonText", "showConnectingFooter", "dismissOnboardingSheet", "restoreDiscoveredMedia", "renderConnectFailedState", "createDefaultConnectFailedBody", "Landroid/widget/TextView;", "getConnectFailedMessage", "dpToPx", "dp", "", "showConnectOverlay", "showConnectOverlayMedia", "hideOnboardingMedia", "createAlphaPlayer", "createConnectOverlayDataSource", "Lcom/ss/android/ugc/aweme/live/alphaplayer/model/DataSource;", "createG2TimeoutDataSource", "resolveVideoFile", "Ljava/io/File;", "assetPath", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDoraGOnboardingDialogFragmentV2 extends DoraGOnboardingDialogBaseFragment {
    public static final /* synthetic */ int D = 0;
    public final long A;
    public final int B;
    public final boolean C;
    public FrameLayout m;
    public IPlayerController n;
    public OSheet o;
    public OSheetTitleBar p;
    public FrameLayout q;
    public FrameLayout r;
    public FrameLayout s;
    public OSheetFooterBtnContainer t;
    public FrameLayout u;
    public AbstractDialog v;
    public View w;
    public boolean x;
    public boolean y;
    public u z;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final boolean oa0() {
        return true;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final String pa0() {
        return "";
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final Integer W90() {
        return Integer.valueOf(this.B);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final void ja0() {
        LarusDoraGOnboardingDialogBinding r0 = this.d;
        if (r0 == null) goto L5;
        e1.o(r0.b);
        e1.o(r0.e);
        e1.o(r0.k);
        e1.o(r0.j);
        e1.o(r0.f);
        e1.o(r0.g);
        e1.o(r0.d);
        AppCompatTextView r1 = r0.c;
        r1.setTextSize(2, 16.0f);
        r1.setGravity(17);
        r1.setTypeface(Typeface.create("sans-serif-medium", 0));
        Resources r2 = r1.getResources();
        TextViewCompat.setLineHeight(r1, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
        r1.setTextColor(r1.getContext().getColor(2131104359));
    L5:
        final LarusDoraGOnboardingDialogBinding r3 = this.d;
        if (r3 == null) goto L8;
        r3.h.post(new i(r3));
        FrameLayout r4 = new FrameLayout(requireContext());
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        e1.o(r4);
        this.m = r4;
        r3.i.addView(r4);
        Configuration r5 = new Configuration();
        r5.a = requireContext();
        r5.b = this;
        r5.c = 1;
        r5.e = true;
        PlayerController r6 = new PlayerController(r5, null);
        r6.attachAlphaView(r4);
        this.n = r6;
        r4.post(new n(this));
    L8:
        com.larus.dora.impl.onboarding.d.a = true;
        int r7 = j49.a.a;
        j49.a.g(this.i, "connection");
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final String la0() {
        int r0 = j0.a;
        return j0.d(2131903932);
    }

    public final void onDestroy() {
        AbstractDialog r0 = this.v;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        this.v = null;
        sa0();
        IPlayerController r1 = this.n;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        this.n = null;
        this.m = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.w = null;
        LarusDoraGOnboardingDialogBinding r2 = this.d;
        if (r2 == null) goto L13;
        DoraMovieView r3 = r2.h;
        if (r3 == null) goto L13;
        r3.g();
        r3.f();
    L13:
        com.larus.dora.impl.onboarding.d.a = false;
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void sa0() {
        Runnable r0 = this.z;
        if (r0 == null) goto L11;
        LarusDoraGOnboardingDialogBinding r1 = this.d;
        if (r1 == null) goto L9;
        AppCompatTextView r2 = r1.c;
        if (r2 == null) goto L9;
        r2.removeCallbacks(r0);
    L9:
        this.z = null;
        g49.d.a("ObricDoraGOnboardingDialog", "cancelPlayTips");
        return;
    }

    public final void xa0() {
        if (this.x == false) goto L5;
        return;
    L5:
        FrameLayout r0 = this.m;
        if (r0 != null) goto L8;
        return;
    L8:
        IPlayerController r1 = this.n;
        if (r1 != null) goto L11;
        return;
    L11:
        boolean r2 = v19.h.a;
        DataSource r3 = null;
        if (v19.h.a(null) == false) goto L14;
        String r4 = "onboarding/connect_overlay/dark/connect_overlay_afx.mp4";
    L15:
        File r5 = wa0(r4);
        if (r5 == null) goto L20;
        DataSource.DataInfo r6 = new DataSource.DataInfo(r5.getAbsolutePath());
        r6.j = 1;
        r6.c = 241;
        r6.f = 1440;
        r6.g = 448;
        r6.h = 720;
        r6.i = 440;
        r6.b(new int[]{0, 0, 720, 440});
        r6.c(new int[]{720, 0, 720, 440});
        r6.b = DataSource.ScaleType.ScaleAspectFill;
        DataSource r7 = new DataSource();
        r7.b = r6;
        r7.a();
        r7.g = false;
        r7.d = false;
        r3 = r7;
    L20:
        if (r3 != null) goto L23;
        e1.o(r0);
        g49.d.b("ObricDoraGOnboardingDialog", "skip connect overlay because video resource is missing");
        return;
    L23:
        LarusDoraGOnboardingDialogBinding r8 = this.d;
        if (r8 == null) goto L28;
        DoraMovieView r9 = r8.h;
        if (r9 == null) goto L28;
        e1.o(r9);
    L28:
        e1.x(r0);
        this.x = true;
        g49.d.d("ObricDoraGOnboardingDialog", "play connect overlay on view created once with last frame hold");
        r1.f(r3, true);
        return;
    L14:
        r4 = "onboarding/connect_overlay/light/connect_overlay_afx.mp4";
        goto L15
    }

    public ObricDoraGOnboardingDialogFragmentV2() {
        this.A = DoraObricDeviceHomeViewModel.SCAN_TIMEOUT_MS;
        this.B = 2131903650;
        this.C = true;
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
        if (r1 == null) goto L19;
        if (r1.intValue() != r5) goto L19;
        return r4;
    L19:
        return ProductNameType.DORA_G;
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

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final long Y90() {
        return this.A;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final boolean aa0() {
        return this.C;
    }

    public static void ra0(ObricDoraGOnboardingDialogFragmentV2 r1) {
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

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final Dialog U90(View r17) {
        Intrinsics.checkNotNullParameter(r17, "content");
        LarusDoraGOnboardingDialogBinding r1 = this.d;
        if (r1 == null) goto L5;
        FrameLayout r2 = r1.i;
    L7:
        if (r2 == null) goto L43;
        ViewParent r4 = r2.getParent();
        if ((r4 instanceof ViewGroup) == false) goto L11;
        ViewGroup r5 = (ViewGroup) r4;
    L12:
        if (r5 == null) goto L14;
        r5.removeView(r2);
    L14:
        FrameLayout r6 = new FrameLayout(requireContext());
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, ta0(220.0f)));
        r6.addView(r2, new FrameLayout.LayoutParams(-1, ta0(220.0f), 17));
        LarusDoraGOnboardingDialogBinding r3 = this.d;
        if (r3 == null) goto L17;
        AppCompatTextView r7 = r3.c;
    L18:
        if (r7 == null) goto L41;
        ViewParent r8 = r7.getParent();
        if ((r8 instanceof ViewGroup) == false) goto L22;
        ViewGroup r9 = (ViewGroup) r8;
    L23:
        if (r9 == null) goto L25;
        r9.removeView(r7);
    L25:
        FrameLayout r10 = new FrameLayout(requireContext());
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, ta0(80.0f)));
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-1, -1, 17);
        r11.setMarginStart(ta0(24.0f));
        r11.setMarginEnd(ta0(24.0f));
        Unit r12 = Unit.INSTANCE;
        r10.addView(r7, r11);
        FrameLayout r13 = new FrameLayout(requireContext());
        r13.setLayoutParams(new ViewGroup.LayoutParams(-1, ta0(80.0f)));
        OSheetFooterBtnContainer r14 = new OSheetFooterBtnContainer(r13.getContext(), null);
        this.t = r14;
        r13.addView(r14, new FrameLayout.LayoutParams(-1, -2, 17));
        LarusDoraGOnboardingDialogBinding r15 = this.d;
        if (r15 == null) goto L28;
        LinearLayoutCompat r16 = r15.g;
    L29:
        if (r16 == null) goto L39;
        ViewParent r18 = r16.getParent();
        if ((r18 instanceof ViewGroup) == false) goto L33;
        ViewGroup r20 = (ViewGroup) r18;
    L34:
        if (r20 == null) goto L36;
        r20.removeView(r16);
    L36:
        FrameLayout r21 = new FrameLayout(requireContext());
        r21.setLayoutParams(new ViewGroup.LayoutParams(-1, ta0(80.0f)));
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(-1, ta0(56.0f), 17);
        r110.setMarginStart(ta0(32.0f));
        r110.setMarginEnd(ta0(32.0f));
        r21.addView(r16, r110);
        FrameLayout r22 = new FrameLayout(requireContext());
        r22.setLayoutParams(new ViewGroup.LayoutParams(-1, ta0(80.0f)));
        e1.o(r13);
        e1.o(r21);
        r22.addView(r10);
        r22.addView(r13);
        r22.addView(r21);
        OSheetTitleBar r23 = new OSheetTitleBar(requireContext(), null, 6, 0);
        r23.setShowLeftBack(false);
        r23.setTitleText(getString(2131902189));
        r23.getMTitleView().setTextSize(16.0f);
        r23.d(r23.getContext(), r23.getMRightContainer(), 2131245980, r23.getContext().getColorStateList(2131105420), 2131912815).setOnClickListener(new j(this));
        OSheet r24 = new OSheet(requireContext(), 0, false, 14);
        this.o = r24;
        this.p = r23;
        this.q = r6;
        this.r = r10;
        this.s = r13;
        this.u = r21;
        this.w = r6;
        OSheetBase.DefaultImpls.q(r24, OSheet.HeightMode.WRAP_HEIGHT);
        OSheetBase.DefaultImpls.r(r24, Color.argb(255, 255, 255, 255));
        OSheetBase.DefaultImpls.p(r24, r23);
        OSheetBase.DefaultImpls.j(r24, r6);
        OSheetBase.DefaultImpls.m(r24, r22);
        r24.setOnDismissListener(new o(this));
        return r24;
    L33:
        r20 = null;
        goto L34
    L39:
        throw new IllegalArgumentException("Required value was null.".toString());
    L28:
        r16 = null;
        goto L29
    L22:
        r9 = null;
        goto L23
    L41:
        throw new IllegalArgumentException("Required value was null.".toString());
    L17:
        r7 = null;
        goto L18
    L11:
        r5 = null;
        goto L12
    L43:
        throw new IllegalArgumentException("Required value was null.".toString());
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final void ca0(o0 r9) {
        Intrinsics.checkNotNullParameter(r9, "action");
        if ((r9 instanceof o0.d) == false) goto L17;
        o0.d r0 = (o0.d) r9;
        if (r0.getType() != TOAST_TYPE.TOAST_TYPE_ERROR) goto L17;
        q0 r1 = (q0) X90().getUiStateFlow().getValue();
        if ((r1 instanceof q0.a) == false) goto L10;
        return;
    L10:
        if ((r1 instanceof q0.c) == false) goto L13;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricDoraGOnboardingDialogFragmentV2$handleAction$1(this, r9, null), 3, null);
        return;
    L13:
        Context r2 = getContext();
        if (r2 == null) goto L17;
        WeakReference<com.obric.oui.toast.f> r10 = DoraObricToastUtils.a;
        String r11 = r0.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r11, "text");
        t19.s.a.getClass();
        t19.s.c(r2, r11);
        return;
    L17:
        super.ca0(r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.larus.dora.impl.onboarding.g.DoraGOnboardingShimmerTextView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final void da0(q0 r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        LarusDoraGOnboardingDialogBinding r0 = this.d;
        if (r0 == null) goto L31;
        ?? r1 = r0.c;
        if (r1 == 0) goto L32;
        boolean r2 = true;
        if (Intrinsics.areEqual(r10, q0.e.a) == false) goto L14;
        e1.x(r1);
        ViewGroup.LayoutParams r11 = r1.getLayoutParams();
        if (r11 == null) goto L12;
        r11.height = ta0(80.0f);
        r1.setLayoutParams(r11);
        r1.setMinimumHeight(0);
        r1.setMaxLines(1);
        r1.setEllipsize(TextUtils.TruncateAt.END);
        r1.setGravity(17);
        r1.setPadding(0, 0, 0, 0);
        r1.setLineSpacing(0.0f, 1.0f);
        ua0(r1, 0);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        if (Intrinsics.areEqual(r10, q0.f.a) == false) goto L29;
        e1.x(r1);
        IObricDoraService r12 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r12 != null) goto L18;
    L20:
        r2 = false;
    L22:
        if (r2 == false) goto L28;
        sa0();
        r1.x();
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if (r3 == null) goto L27;
        r3.height = ta0(80.0f);
        r1.setLayoutParams(r3);
        r1.setMinimumHeight(ta0(80.0f));
        r1.setMaxLines(2);
        r1.setEllipsize(null);
        r1.setGravity(17);
        r1.setLineSpacing(0.0f, 1.0f);
        int r4 = j0.a;
        r1.setText(j0.d(2131902585));
        g49.d.a("ObricDoraGOnboardingDialog", "play G2 timeout tip: " + r1.getText());
        r1.setAnimRepeatCount(-1);
        r1.y();
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L28:
        sa0();
        r1.x();
        int r5 = j0.a;
        r1.setText(j0.d(2131902831));
        g49.d.a("ObricDoraGOnboardingDialog", "playTimeoutTip: " + r1.getText());
        r1.setAnimRepeatCount(-1);
        r1.y();
        return;
    L18:
        if (r12.h() != true) goto L20;
    L29:
        e1.o(r1);
        sa0();
        r1.x();
        return;
    L32:
        return;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final void ea0(q0 r8) {
        Intrinsics.checkNotNullParameter(r8, "state");
        if ((r8 instanceof q0.a) == false) goto L18;
        this.y = false;
        this.x = false;
        LarusDoraGOnboardingDialogBinding r9 = this.d;
        if (r9 == null) goto L9;
        DoraMovieView r10 = r9.h;
        if (r10 == null) goto L9;
        e1.o(r10);
    L9:
        LarusDoraGOnboardingDialogBinding r11 = this.d;
        if (r11 == null) goto L14;
        FrameLayout r12 = r11.i;
        if (r12 == null) goto L14;
        e1.o(r12);
    L14:
        FrameLayout r13 = this.m;
        if (r13 == null) goto L90;
        e1.o(r13);
        return;
    L90:
        return;
    L18:
        if (Intrinsics.areEqual(r8, q0.f.a) == false) goto L52;
        this.y = true;
        IObricDoraService r0 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r0 != null) goto L22;
    L24:
        boolean r1 = false;
    L26:
        if (r1 == false) goto L45;
        FrameLayout r2 = this.m;
        if (r2 == null) goto L102;
        IPlayerController r3 = this.n;
        if (r3 == null) goto L103;
        File r4 = wa0("onboarding/bind_timeout/light/larus_dora_obric_g2_onboarding_bind_timeout.mp4");
        if (r4 != null) goto L36;
        DataSource r5 = null;
    L37:
        if (r5 != null) goto L39;
        e1.o(r2);
        g49.d.b("ObricDoraGOnboardingDialog", "skip G2 timeout video because resource is missing");
        return;
    L39:
        LarusDoraGOnboardingDialogBinding r6 = this.d;
        if (r6 == null) goto L44;
        DoraMovieView r7 = r6.h;
        if (r7 == null) goto L44;
        e1.o(r7);
    L44:
        e1.x(r2);
        this.x = false;
        r3.f(r5, true);
        return;
    L36:
        DataSource.DataInfo r14 = new DataSource.DataInfo(r4.getAbsolutePath());
        r14.j = 1;
        r14.c = 681;
        r14.f = 1440;
        r14.g = 448;
        r14.h = 720;
        r14.i = 448;
        r14.b(new int[]{0, 0, 720, 448});
        r14.c(new int[]{720, 0, 720, 448});
        r14.b = DataSource.ScaleType.ScaleAspectFill;
        r5 = new DataSource();
        r5.b = r14;
        r5.a();
        r5.g = false;
        r5.d = true;
        goto L37
    L103:
        return;
    L102:
        return;
    L45:
        FrameLayout r15 = this.m;
        if (r15 == null) goto L48;
        e1.o(r15);
    L48:
        LarusDoraGOnboardingDialogBinding r16 = this.d;
        if (r16 == null) goto L94;
        DoraMovieView r17 = r16.h;
        Intrinsics.checkNotNull(r17);
        e1.x(r17);
        r17.f();
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r16.h, "alpha", new float[]{0.0f, 1.0f});
        r18.setDuration(300);
        r18.setInterpolator(new DecelerateInterpolator());
        r18.start();
        i0.b(r17, DoraVideoType.DORA_G_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX_TIMEOUT, com.larus.dora.impl.util.u.a.b("larus_dora_g_onboarding_unboxing_timeout"), DoraSKU.WHITE);
        g49.d.a("ObricDoraGOnboardingDialog", "--UNBOXING");
        r17.b();
        return;
    L94:
        return;
    L22:
        if (r0.h() != true) goto L24;
        r1 = true;
        goto L26
    L52:
        if ((r8 instanceof q0.d) == true) goto L68;
        if ((r8 instanceof q0.c) == true) goto L68;
        LarusDoraGOnboardingDialogBinding r20 = this.d;
        if (r20 == null) goto L62;
        DoraMovieView r21 = r20.h;
        if (r21 == null) goto L62;
        e1.o(r21);
    L62:
        if (this.x == false) goto L66;
        FrameLayout r22 = this.m;
        if (r22 == null) goto L96;
        e1.x(r22);
        return;
    L96:
        return;
    L66:
        xa0();
        return;
    L68:
        if (this.y == true) goto L80;
        LarusDoraGOnboardingDialogBinding r23 = this.d;
        if (r23 == null) goto L75;
        DoraMovieView r24 = r23.h;
        if (r24 == null) goto L75;
        e1.o(r24);
    L75:
        if (this.x == false) goto L79;
        FrameLayout r25 = this.m;
        if (r25 == null) goto L99;
        e1.x(r25);
        return;
    L99:
        return;
    L79:
        xa0();
        return;
    L80:
        this.y = false;
        LarusDoraGOnboardingDialogBinding r26 = this.d;
        if (r26 == null) goto L85;
        FrameLayout r27 = r26.i;
        if (r27 == null) goto L85;
        e1.x(r27);
    L85:
        FrameLayout r28 = this.m;
        if (r28 == null) goto L88;
        e1.o(r28);
    L88:
        this.x = false;
        xa0();
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final Object fa0(final q0 r18) {
        Intrinsics.checkNotNullParameter(r18, "state");
        super.fa0(r18);
        if ((r18 instanceof q0.a) == false) goto L21;
        final DoraDevice r1 = ((q0.a) r18).a;
        LarusDoraGOnboardingDialogBinding r2 = this.d;
        if (r2 == null) goto L9;
        FrameLayout r3 = r2.i;
        if (r3 == null) goto L9;
        e1.o(r3);
    L9:
        FrameLayout r4 = this.m;
        if (r4 == null) goto L12;
        e1.o(r4);
    L12:
        IPlayerController r5 = this.n;
        if (r5 == null) goto L15;
        r5.stop();
    L15:
        this.x = false;
        String r6 = getString(2131902387);
        TextView r7 = new TextView(requireContext());
        if (r1.productId != ProductNameType.DORA_G2.id) goto L18;
        String r8 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Integer[]{2131903615, 2131903616, 2131903617}), "\n", null, null, 0, null, new m(), 30, null);
    L19:
        r7.setText(r8);
        r7.setGravity(8388659);
        r7.setTextSize(2, 16.0f);
        r7.setTypeface(Typeface.create("sans-serif", 0));
        Resources r9 = r7.getResources();
        TextViewCompat.setLineHeight(r7, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics())));
        r7.setTextColor(r7.getContext().getColor(2131104350));
        r7.setPadding(ta0(20.0f), ta0(16.0f), ta0(20.0f), ta0(16.0f));
        r7.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        va0(r6, r7, getString(2131902344), new l(this, r1));
    L59:
        return Unit.INSTANCE;
    L18:
        int r10 = j0.a;
        r8 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{j0.d(2131902893), j0.d(2131902890), j0.d(2131902891), j0.d(2131902892)}), "\n", null, null, 0, null, null, 62, null);
        goto L19
    L21:
        if ((r18 instanceof q0.d) == false) goto L28;
        String r11 = getString(2131903697);
        View r12 = this.q;
        if (r12 == null) goto L26;
        va0(r11, r12, getString(2131903671), new v(this, r18));
        goto L59
    L26:
        throw new IllegalArgumentException("Required value was null.".toString());
    L28:
        if ((r18 instanceof q0.c) == false) goto L43;
        String r13 = getString(Z90(r18));
        View r14 = this.q;
        if (r14 == null) goto L41;
        va0(r13, r14, null, null);
        FrameLayout r15 = this.r;
        if (r15 == null) goto L34;
        e1.o(r15);
    L34:
        FrameLayout r16 = this.s;
        if (r16 == null) goto L37;
        e1.o(r16);
    L37:
        FrameLayout r17 = this.u;
        if (r17 == null) goto L59;
        e1.x(r17);
        goto L59
    L41:
        throw new IllegalArgumentException("Required value was null.".toString());
    L43:
        if (Intrinsics.areEqual(r18, q0.e.a) == true) goto L53;
        if (Intrinsics.areEqual(r18, q0.f.a) == true) goto L53;
        String r20 = getString(Z90(r18));
        View r21 = this.q;
        if (r21 == null) goto L51;
        va0(r20, r21, null, null);
        goto L59
    L51:
        throw new IllegalArgumentException("Required value was null.".toString());
    L53:
        if (Intrinsics.areEqual(r18, q0.f.a) == false) goto L55;
        X90().stopScan();
    L55:
        String r22 = getString(Z90(r18));
        View r23 = this.q;
        if (r23 == null) goto L61;
        va0(r22, r23, null, null);
        goto L59
    L61:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment
    public final void ga0(final DoraDevice r6) {
        Intrinsics.checkNotNullParameter(r6, "device");
        if (o59.a.m(Integer.valueOf(r6.productId)) == false) goto L14;
        g49.d.d("ObricDoraGOnboardingDialog", "handleUnbind use G2 rebind flow, isFactory=" + r6.isFactory());
        if (r6.isFactory() == false) goto L8;
        X90().replaceBindAndConnect(r6, W90());
        return;
    L8:
        AbstractDialog r0 = this.v;
        if (r0 == null) goto L11;
        r0.dismiss();
    L11:
        int r1 = a79.c.a;
        this.v = a79.c.a(getContext(), true, new p(this, r6), new q(this, r6));
        return;
    L14:
        if (o59.a.v(r6) == true) goto L18;
        super.ga0(r6);
        return;
    L18:
        if (r6.isFactory() == false) goto L20;
        X90().replaceBindAndConnect(r6, W90());
        return;
    L20:
        CommonDialog r2 = n69.c.a;
        n69.c.b(getContext(), getChildFragmentManager(), new r(this, r6), new s(this, r6), new t(this, r6));
    }

    public final int ta0(float r3) {
        Resources r0 = getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    public final File wa0(String r17) {
        if (StringsKt.contains$default(r17, "/dark/", false, 2, null) == false) goto L5;
        DoraResourceTheme r0 = DoraResourceTheme.NIGHT;
    L6:
        String r1 = StringsKt.replace$default(StringsKt.replace$default(r17, "/dark/", "/", false, 4, null), "/light/", "/", false, 4, null);
        com.larus.dora.impl.resource.j0 r2 = com.larus.dora.impl.resource.j0.a;
        DoraResourceDeviceType r4 = DoraResourceDeviceType.G2;
        DoraResourceType r5 = DoraResourceType.RAW;
        r2.getClass();
        com.larus.dora.impl.resource.k r3 = com.larus.dora.impl.resource.j0.e(r4, r5, r1, r0);
        if ((r3 instanceof com.larus.dora.impl.resource.k.b) == true) goto L9;
        g49.d.b("ObricDoraGOnboardingDialog", "video resource is missing, path=" + r1);
        return null;
    L9:
        return ((com.larus.dora.impl.resource.k.b) r3).a;
    L5:
        r0 = DoraResourceTheme.LIGHT;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.dora.obric.device_v2.u, java.lang.Runnable] */
    public final void ua0(final DoraGOnboardingShimmerTextView r7, final int r8) {
        sa0();
        StringBuilder r0 = new StringBuilder("playTips: ");
        r0.append(r8);
        r0.append(", ");
        String r1 = "";
        if (r8 == 0) goto L7;
        if (r8 == 1) goto L6;
        String r5 = "";
    L8:
        r0.append(r5);
        g49.d.a("ObricDoraGOnboardingDialog", r0.toString());
        if (r8 == 0) goto L13;
        if (r8 != 1) goto L14;
        r1 = j0.d(2131902828);
    L14:
        r7.setText(r1);
        r7.setAnimRepeatCount(3);
        r7.y();
        if (r8 == 0) goto L19;
        if (r8 == 1) goto L18;
        return;
    L18:
        long r2 = 8000;
    L20:
        ?? r3 = new u(this, r8, r7);
        this.z = r3;
        r7.postDelayed(r3, r2);
        return;
    L19:
        r2 = 10000;
        goto L20
    L13:
        r1 = j0.d(2131902830);
        goto L14
    L6:
        r5 = j0.d(2131902828);
        goto L8
    L7:
        r5 = j0.d(2131902830);
        goto L8
    }

    public final void va0(String r8, View r9, String r10, final Function0<Unit> r11) {
        OSheet r0 = this.o;
        if (r0 != null) goto L5;
        return;
    L5:
        OSheetTitleBar r1 = this.p;
        if (r1 == null) goto L9;
        r1.setTitleText(r8);
    L9:
        if (this.w == r9) goto L12;
        OSheetBase.DefaultImpls.j(r0, r9);
        this.w = r9;
    L12:
        if (r9 != this.q) goto L18;
        LarusDoraGOnboardingDialogBinding r12 = this.d;
        if (r12 == null) goto L18;
        FrameLayout r13 = r12.i;
        if (r13 == null) goto L18;
        e1.x(r13);
    L18:
        if (r10 != null) goto L28;
        FrameLayout r14 = this.r;
        if (r14 == null) goto L22;
        e1.x(r14);
    L22:
        FrameLayout r15 = this.s;
        if (r15 == null) goto L25;
        e1.o(r15);
    L25:
        FrameLayout r16 = this.u;
        if (r16 == null) goto L41;
        e1.o(r16);
        return;
    L41:
        return;
    L28:
        FrameLayout r17 = this.r;
        if (r17 == null) goto L31;
        e1.o(r17);
    L31:
        FrameLayout r18 = this.u;
        if (r18 == null) goto L34;
        e1.o(r18);
    L34:
        OSheetFooterBtnContainer r2 = this.t;
        if (r2 == null) goto L37;
        r2.b(null, false, null, r10, true, new k(r11));
    L37:
        FrameLayout r20 = this.s;
        if (r20 == null) goto L43;
        e1.x(r20);
        return;
    }
}
