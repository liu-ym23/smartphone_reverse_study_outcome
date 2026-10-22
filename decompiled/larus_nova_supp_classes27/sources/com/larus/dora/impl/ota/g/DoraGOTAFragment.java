package com.larus.dora.impl.ota.g;

import android.app.Application;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.dora.api.device.ota.model.OTAUpdateMeta;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.impl.databinding.LarusDoraPageOtaV2Binding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.ota.DoraOTACheckFrom;
import com.larus.dora.impl.ota.tracker.DoraOTAPreCheckReason;
import com.larus.dora.impl.view.DoraNovaTitleBarEx;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Arrays;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 i2\u00020\u0001:\u0001iB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001a\u00102\u001a\u0002032\u0006\u00104\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u000101H\u0017J\b\u00105\u001a\u000203H\u0016J\b\u00106\u001a\u000203H\u0016J\b\u00107\u001a\u000203H\u0016J\b\u00108\u001a\u00020)H\u0002J\u0010\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020)H\u0002J\b\u0010;\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u000203H\u0002J\b\u0010=\u001a\u000203H\u0002J\u0016\u0010>\u001a\u000203*\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0010\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u0002032\u0006\u0010F\u001a\u00020GH\u0003J\u0010\u0010H\u001a\u0002032\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010I\u001a\u0002032\u0006\u0010F\u001a\u00020GH\u0002J\u0018\u0010J\u001a\u0002032\u0006\u0010F\u001a\u00020G2\u0006\u0010K\u001a\u00020LH\u0003J\u0010\u0010M\u001a\u0002032\u0006\u0010F\u001a\u00020GH\u0002J\u0018\u0010N\u001a\u0002032\u0006\u0010F\u001a\u00020G2\u0006\u0010O\u001a\u00020LH\u0003J\u0010\u0010P\u001a\u0002032\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020LH\u0003J<\u0010S\u001a\u00020!2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00122\b\b\u0002\u0010W\u001a\u00020\u00122\b\b\u0002\u0010X\u001a\u00020)2\u000e\b\u0002\u0010Y\u001a\b\u0012\u0004\u0012\u0002030ZH\u0002J\b\u0010[\u001a\u000203H\u0002J\b\u0010\\\u001a\u000203H\u0002J\b\u0010]\u001a\u000203H\u0002J\b\u0010^\u001a\u000203H\u0002J\b\u0010_\u001a\u000203H\u0002J\u0010\u0010`\u001a\u0002032\u0006\u0010a\u001a\u00020GH\u0002J\b\u0010b\u001a\u000203H\u0002J\u0010\u0010c\u001a\u0002032\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010d\u001a\u0002032\u0006\u0010e\u001a\u00020LH\u0002J\b\u0010f\u001a\u000203H\u0002J\b\u0010g\u001a\u000203H\u0002J\b\u0010h\u001a\u00020LH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001b\u0010\u0015R\u001b\u0010\u001d\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001e\u0010\u0015R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/larus/dora/impl/ota/g/DoraGOTAFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageOtaV2Binding;", "markdownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "getMarkdownInfo", "()Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "markdownInfo$delegate", "Lkotlin/Lazy;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/ota/g/DoraGOTAViewModel;", "getModel", "()Lcom/larus/dora/impl/ota/g/DoraGOTAViewModel;", "model$delegate", "manualPageSessionId", "", "otaNewestVersionText", "getOtaNewestVersionText", "()Ljava/lang/String;", "otaNewestVersionText$delegate", "otaFirmwareSizeText", "getOtaFirmwareSizeText", "otaFirmwareSizeText$delegate", "otaDownloadingText", "getOtaDownloadingText", "otaDownloadingText$delegate", "otaUpdatingText", "getOtaUpdatingText", "otaUpdatingText$delegate", "vpnConnectedDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "peripheralsLowBatteryDialog", "peripheralsOTAFailedRequireRebootDialog", "peripheralsDisconnectedDialog", "peripheralsSpaceNotEnoughDialog", "phoneSpaceNotEnoughDialog", "transferFailedDialog", "isBackEnabled", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onPause", "onDestroyView", "fromOTADebugPage", "setTitleBackEnabled", "enabled", "getCurrentPageName", "showCheckUpdatingUi", "showCheckUpdateFailedUi", "setReleaseNotes", "Lcom/larus/business/markdown/impl/markwon/MarkdownTextView;", "releaseNotes", "Lcom/larus/dora/api/device/ota/model/OTAUpdateMeta;", "showAlreadyLatestVersionUi", "device", "Lcom/larus/dora/api/ota/OTADevice;", "bindUpdateContentInfoLayout", "responseWrapper", "Lcom/larus/dora/api/ota/model/DoraOTAResponseWrapper;", "showCheckUpdateSuccessUi", "showCheckingEnvironmentUi", "showDownloadingUi", "downloadProgress", "", "showDownloadSuccessUi", "showDataTransferringUi", "transferProgress", "showDeviceRestartingUi", "getSizeText", "actualSize", "buildErrorDialog", "context", "Landroid/content/Context;", "title", "message", "cancelOnTouchOutSide", "confirmAction", "Lkotlin/Function0;", "showVpnConnectedDialog", "showPeripheralsDisconnectedDialog", "showPeripheralsLowBatteryDialog", "showPeripheralsSpaceNotEnoughDialog", "showPhoneSpaceNotEnoughDialog", "startDownload", "response", "showNetworkErrorDialog", "showDownloadOnNonWifiDialog", "showTransferFailDialog", "messageResId", "showPeripheralsOTAFailedRequireRebootDialog", "showNotExistSavedWifiDialog", "currentProductId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOTAFragment extends DoraBaseFragment {
    public static final /* synthetic */ int v = 0;
    public LarusDoraPageOtaV2Binding f;
    public final Lazy g;
    public final Lazy h;
    public final String i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public CommonDialog n;
    public CommonDialog o;
    public CommonDialog p;
    public CommonDialog q;
    public CommonDialog r;
    public CommonDialog s;
    public CommonDialog t;
    public boolean u;

    public static final class a {
    }

    public static final class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), i5.q());
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraGOTAFragment a;

        public c(DoraGOTAFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            x r8 = (x) r6;
            g49.d.a("DoraOTA", "otaUiStateFlow collect " + r8);
            if (Intrinsics.areEqual(r8, x.l.a) == true) goto L55;
            if (Intrinsics.areEqual(r8, x.d.a) == false) goto L10;
            DoraGOTAFragment r9 = this.a;
            LarusDoraPageOtaV2Binding r10 = r9.f;
            if (r10 == null) goto L55;
            r9.ga0(true);
            e1.x(r10.s);
            e1.x(r10.t);
            e1.o(r10.u);
            e1.o(r10.w);
            r10.v.setText(r9.getString(2131903813));
            e1.o(r10.x);
            goto L55
        L10:
            if (Intrinsics.areEqual(r8, x.a.a) == false) goto L15;
            final DoraGOTAFragment r11 = this.a;
            final LarusDoraPageOtaV2Binding r12 = r11.f;
            if (r12 == null) goto L55;
            r11.ga0(true);
            e1.x(r12.s);
            e1.o(r12.t);
            e1.x(r12.u);
            r12.v.setText(r11.getString(2131903812));
            e1.d(r12.s, new com.larus.dora.impl.ota.g.c(r11, r12));
            e1.o(r12.w);
            e1.o(r12.x);
            goto L55
        L15:
            if ((r8 instanceof x.c) == false) goto L18;
            DoraGOTAFragment.Z90(this.a, ((x.c) r8).a);
            goto L55
        L18:
            if ((r8 instanceof x.b) == false) goto L21;
            DoraGOTAFragment.Y90(this.a, ((x.b) r8).a);
            goto L55
        L21:
            if ((r8 instanceof x.k) == false) goto L26;
            DoraGOTAFragment r13 = this.a;
            x.k r14 = (x.k) r8;
            e49.a r3 = r14.a;
            int r15 = r14.b;
            LarusDoraPageOtaV2Binding r4 = r13.f;
            if (r4 == null) goto L55;
            r13.ga0(true);
            r13.ca0(r3);
            e1.o(r4.d);
            e1.x(r4.j);
            r4.i.setProgress(r15);
            r4.k.setText(((String) r13.l.getValue()) + ' ' + r15 + '%');
            e1.o(r4.l);
            e1.o(r4.m);
            e1.o(r4.e);
            goto L55
        L26:
            if ((r8 instanceof x.j) == false) goto L29;
            DoraGOTAFragment.aa0(this.a, ((x.j) r8).a);
            goto L55
        L29:
            if ((r8 instanceof x.e) == false) goto L34;
            DoraGOTAFragment r16 = this.a;
            e49.a r17 = ((x.e) r8).a;
            LarusDoraPageOtaV2Binding r1 = r16.f;
            if (r1 == null) goto L55;
            r16.ga0(true);
            r16.ca0(r17);
            e1.o(r1.d);
            e1.o(r1.j);
            e1.o(r1.m);
            e1.x(r1.e);
            goto L55
        L34:
            if ((r8 instanceof x.g) == false) goto L39;
            DoraGOTAFragment r18 = this.a;
            x.g r20 = (x.g) r8;
            e49.a r0 = r20.a;
            int r21 = r20.b;
            LarusDoraPageOtaV2Binding r5 = r18.f;
            if (r5 == null) goto L55;
            r18.ga0(false);
            r18.ca0(r0);
            e1.o(r5.d);
            e1.x(r5.j);
            r5.i.setProgress(r21);
            r5.k.setText(((String) r18.m.getValue()) + ' ' + r21 + '%');
            e1.x(r5.l);
            e1.o(r5.m);
            e1.o(r5.e);
            goto L55
        L39:
            if ((r8 instanceof x.h) == false) goto L44;
            DoraGOTAFragment r22 = this.a;
            e49.a r23 = ((x.h) r8).a;
            LarusDoraPageOtaV2Binding r2 = r22.f;
            if (r2 == null) goto L55;
            r22.ga0(true);
            r22.ca0(r23);
            e1.o(r2.d);
            e1.o(r2.j);
            e1.x(r2.m);
            e1.o(r2.e);
            goto L55
        L44:
            if ((r8 instanceof x.m) == false) goto L47;
            DoraGOTAFragment.Y90(this.a, ((x.m) r8).a);
            goto L55
        L47:
            if ((r8 instanceof x.i) == false) goto L50;
            DoraGOTAFragment.Z90(this.a, ((x.i) r8).a);
            goto L55
        L50:
            if ((r8 instanceof x.f) == false) goto L53;
            DoraGOTAFragment.aa0(this.a, ((x.f) r8).a);
            goto L55
        L53:
            throw new NoWhenBranchMatchedException();
        L55:
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ DoraGOTAFragment a;

        public d(DoraGOTAFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            com.larus.dora.impl.ota.a r9 = (com.larus.dora.impl.ota.a) r7;
            if (Intrinsics.areEqual(r9, com.larus.dora.impl.ota.a.f.a) == false) goto L12;
            DoraGOTAFragment r10 = this.a;
            int r11 = DoraGOTAFragment.v;
            Context r1 = r10.getContext();
            if (r1 == null) goto L44;
            CommonDialog r12 = r10.s;
            if (r12 == null) goto L10;
            DoraGOTAFragment.W90(r12);
        L10:
            CommonDialog r13 = DoraGOTAFragment.da0(r10, r1, r1.getString(2131902850), r1.getString(2131902849), null, 24);
            r10.s = r13;
            DoraGOTAFragment.X90(r13, r10.getChildFragmentManager(), "PhoneSpaceNotEnoughDialog");
        L44:
            return Unit.INSTANCE;
        L12:
            if (Intrinsics.areEqual(r9, com.larus.dora.impl.ota.a.c.a) == false) goto L15;
            t19.s r14 = t19.s.a;
            Application r15 = AppHost.a.getApplication();
            r14.getClass();
            t19.s.b(r15, 2131902866, false);
            goto L44
        L15:
            if (Intrinsics.areEqual(r9, com.larus.dora.impl.ota.a.C0090a.a) == false) goto L17;
        L42:
            t19.s r16 = t19.s.a;
            Application r17 = AppHost.a.getApplication();
            r16.getClass();
            t19.s.b(r17, 2131902879, false);
            goto L44
        L17:
            if (Intrinsics.areEqual(r9, com.larus.dora.impl.ota.a.e.a) == true) goto L42;
            if ((r9 instanceof com.larus.dora.impl.ota.a.d) == false) goto L23;
            DoraGOTAFragment r18 = this.a;
            e49.a r20 = ((com.larus.dora.impl.ota.a.d) r9).a;
            int r0 = DoraGOTAFragment.v;
            r18.ha0(r20);
            goto L44
        L23:
            if ((r9 instanceof com.larus.dora.impl.ota.a.b) == false) goto L32;
            DoraGOTAFragment r21 = this.a;
            int r22 = DoraGOTAFragment.v;
            Context r2 = r21.getContext();
            if (r2 == null) goto L44;
            CommonDialog r23 = r21.q;
            if (r23 == null) goto L30;
            DoraGOTAFragment.W90(r23);
        L30:
            CommonDialog r24 = DoraGOTAFragment.da0(r21, r2, r2.getString(2131902855), null, null, 28);
            r21.q = r24;
            DoraGOTAFragment.X90(r24, r21.getChildFragmentManager(), "PeripheralsDisconnectedDialog");
            goto L44
        L32:
            if ((r9 instanceof com.larus.dora.impl.ota.a.g) == false) goto L41;
            DoraGOTAFragment r25 = this.a;
            int r26 = DoraGOTAFragment.v;
            Context r3 = r25.getContext();
            if (r3 == null) goto L44;
            CommonDialog r27 = r25.n;
            if (r27 == null) goto L39;
            DoraGOTAFragment.W90(r27);
        L39:
            CommonDialog r28 = DoraGOTAFragment.da0(r25, r3, r3.getString(2131902875), null, null, 28);
            r25.n = r28;
            DoraGOTAFragment.X90(r28, r25.getChildFragmentManager(), "VpnConnectedDialog");
            goto L44
        L41:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class e<T> implements FlowCollector {
        public final /* synthetic */ DoraGOTAFragment a;

        public e(DoraGOTAFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            com.larus.dora.impl.ota.connector.a r5 = (com.larus.dora.impl.ota.connector.a) r3;
            if (Intrinsics.areEqual(r5, com.larus.dora.impl.ota.connector.a.C0091a.a) == false) goto L6;
            DoraGOTAFragment.ba0(this.a, 2131902862);
        L23:
            return Unit.INSTANCE;
        L6:
            if (Intrinsics.areEqual(r5, com.larus.dora.impl.ota.connector.a.b.a) == false) goto L9;
            DoraGOTAFragment.ba0(this.a, 2131902863);
            goto L23
        L9:
            if ((r5 instanceof com.larus.dora.impl.ota.connector.a.e) == false) goto L12;
            t19.s r6 = t19.s.a;
            Application r7 = AppHost.a.getApplication();
            r6.getClass();
            t19.s.b(r7, 2131902876, false);
            goto L23
        L12:
            if (Intrinsics.areEqual(r5, com.larus.dora.impl.ota.connector.a.f.a) == false) goto L15;
            DoraGOTAFragment.ba0(this.a, 2131902865);
            goto L23
        L15:
            if (Intrinsics.areEqual(r5, com.larus.dora.impl.ota.connector.a.d.a) == false) goto L17;
        L21:
            t19.s r8 = t19.s.a;
            Application r9 = AppHost.a.getApplication();
            r8.getClass();
            t19.s.b(r9, 2131902876, false);
            goto L23
        L17:
            if (Intrinsics.areEqual(r5, com.larus.dora.impl.ota.connector.a.c.a) == true) goto L21;
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class f<T> implements FlowCollector {
        public final /* synthetic */ DoraGOTAFragment a;

        public f(DoraGOTAFragment r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.dora.impl.ota.g.i] */
        public final Object emit(Object r10, Continuation r11) {
            u r12 = (u) r10;
            if (Intrinsics.areEqual(r12, u.c.a) == false) goto L19;
            DoraGOTAFragment r13 = this.a;
            int r14 = DoraGOTAFragment.v;
            Context r2 = r13.getContext();
            if (r2 == null) goto L47;
            CommonDialog r15 = r13.o;
            if (r15 == null) goto L10;
            DoraGOTAFragment.W90(r15);
        L10:
            String r3 = r2.getString(2131902846);
            Bundle r16 = r13.getArguments();
            int r1 = -1;
            if (r16 == null) goto L14;
            r1 = r16.getInt("route_param_product_id", -1);
        L14:
            if (o59.a.m(Integer.valueOf(r1)) == false) goto L16;
            int r17 = 2131902586;
        L17:
            CommonDialog r18 = DoraGOTAFragment.da0(r13, r2, r3, r2.getString(r17), null, 24);
            r13.o = r18;
            DoraGOTAFragment.X90(r18, r13.getChildFragmentManager(), "PeripheralsLowBatteryDialog");
            goto L47
        L16:
            r17 = 2131902845;
        L47:
            return Unit.INSTANCE;
        L19:
            if (Intrinsics.areEqual(r12, u.f.a) == false) goto L28;
            DoraGOTAFragment r110 = this.a;
            int r111 = DoraGOTAFragment.v;
            Context r112 = r110.getContext();
            if (r112 == null) goto L47;
            CommonDialog r0 = r110.r;
            if (r0 == null) goto L26;
            DoraGOTAFragment.W90(r0);
        L26:
            CommonDialog.a r4 = new CommonDialog.a();
            r4.i(r112.getString(2131902844));
            r4.g(r112.getString(2131902843));
            CommonDialog.a.f(r4, new s(), r112.getString(2131902854), false, 12);
            com.larus.common_ui.dialog.f0 r5 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r112, 2131103203)), Typeface.DEFAULT_BOLD, 1);
            Intrinsics.checkNotNullParameter(r5, "commonDialogTextStyleConfig");
            r4.D = r5;
            CommonDialog.a.e(r4, new t(), r112.getString(2131902465), 4);
            com.larus.common_ui.dialog.f0 r6 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r112, 2131103146)), null, 5);
            Intrinsics.checkNotNullParameter(r6, "commonDialogTextStyleConfig");
            r4.E = r6;
            CommonDialog r113 = r4.a();
            r110.r = r113;
            DoraGOTAFragment.X90(r113, r110.getChildFragmentManager(), "PeripheralsSpaceNotEnoughDialog");
            goto L47
        L28:
            if ((r12 instanceof u.a) == true) goto L47;
            if ((r12 instanceof u.e) == true) goto L47;
            if ((r12 instanceof u.b) == false) goto L36;
            t19.s r114 = t19.s.a;
            Application r115 = AppHost.a.getApplication();
            r114.getClass();
            t19.s.b(r115, 2131902879, false);
            goto L47
        L36:
            if (Intrinsics.areEqual(r12, u.d.a) == false) goto L45;
            final DoraGOTAFragment r116 = this.a;
            int r117 = DoraGOTAFragment.v;
            Context r7 = r116.getContext();
            if (r7 == null) goto L47;
            CommonDialog r118 = r116.p;
            if (r118 == null) goto L43;
            DoraGOTAFragment.W90(r118);
        L43:
            CommonDialog r119 = DoraGOTAFragment.da0(r116, r7, r7.getString(2131902879), null, new com.larus.dora.impl.ota.g.i(r116), 4);
            r116.p = r119;
            DoraGOTAFragment.X90(r119, r116.getChildFragmentManager(), "PeripheralsLowBatteryDialog");
            goto L47
        L45:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class g<T> implements FlowCollector {
        public final /* synthetic */ DoraGOTAFragment a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[SilentOTASwitchState.values().length];
                r0[SilentOTASwitchState.On.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[SilentOTASwitchState.Off.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[SilentOTASwitchState.Unsupported.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public g(DoraGOTAFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            int r3 = a.a[((SilentOTASwitchState) r1).ordinal()];
            if (r3 != 1) goto L5;
            LarusDoraPageOtaV2Binding r4 = this.a.f;
            if (r4 == null) goto L32;
            ItemGroup r5 = r4.b;
            if (r5 == null) goto L32;
            e1.x(r5);
        L32:
            LarusDoraPageOtaV2Binding r6 = this.a.f;
            if (r6 == null) goto L40;
            ItemTextToggle r7 = r6.c;
            if (r7 == null) goto L40;
            CustomSwitchCompat r8 = r7.getToggleView();
            if (r8 == null) goto L40;
            r8.setChecked(true);
        L40:
            return Unit.INSTANCE;
        L5:
            if (r3 != 2) goto L7;
            LarusDoraPageOtaV2Binding r9 = this.a.f;
            if (r9 == null) goto L20;
            ItemGroup r10 = r9.b;
            if (r10 == null) goto L20;
            e1.x(r10);
        L20:
            LarusDoraPageOtaV2Binding r11 = this.a.f;
            if (r11 == null) goto L40;
            ItemTextToggle r12 = r11.c;
            if (r12 == null) goto L40;
            CustomSwitchCompat r13 = r12.getToggleView();
            if (r13 == null) goto L40;
            r13.setChecked(false);
            goto L40
        L7:
            if (r3 != 3) goto L14;
            LarusDoraPageOtaV2Binding r14 = this.a.f;
            if (r14 == null) goto L40;
            ItemGroup r15 = r14.b;
            if (r15 == null) goto L40;
            e1.o(r15);
            goto L40
        L14:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class h<T> implements FlowCollector {
        public final /* synthetic */ DoraGOTAFragment a;

        public h(DoraGOTAFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r9, Continuation r10) {
            w r11 = (w) r9;
            if (Intrinsics.areEqual(r11, w.a.a) == false) goto L9;
            DoraGOTAFragment r12 = this.a;
            int r13 = DoraGOTAFragment.v;
            Context r14 = r12.getContext();
            if (r14 == null) goto L12;
            CommonDialog.a r1 = new CommonDialog.a();
            r1.i(r12.getString(2131903825));
            r1.g(r12.getString(2131903824));
            CommonDialog.a.f(r1, new q(r14, r12), r12.getString(2131902341), false, 12);
            com.larus.common_ui.dialog.f0 r0 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r14, 2131103203)), Typeface.DEFAULT_BOLD, 1);
            Intrinsics.checkNotNullParameter(r0, "commonDialogTextStyleConfig");
            r1.D = r0;
            CommonDialog.a.e(r1, new r(), r12.getString(2131902465), 4);
            com.larus.common_ui.dialog.f0 r2 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r14, 2131103203)), Typeface.DEFAULT_BOLD, 1);
            Intrinsics.checkNotNullParameter(r2, "commonDialogTextStyleConfig");
            r1.E = r2;
            DoraGOTAFragment.X90(r1.a(), r12.getChildFragmentManager(), "NotExistSavedWifiDialog");
        L12:
            return Unit.INSTANCE;
        L9:
            if (Intrinsics.areEqual(r11, w.b.a) == false) goto L14;
            t19.s r15 = t19.s.a;
            Application r16 = AppHost.a.getApplication();
            r15.getClass();
            t19.s.b(r16, 2131904037, false);
            goto L12
        L14:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class i implements p0 {
        public final /* synthetic */ DoraGOTAFragment a;
        public final /* synthetic */ e49.a b;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            DoraGOTAFragment r0 = this.a;
            int r1 = DoraGOTAFragment.v;
            r0.fa0().download(this.b, false, this.a.ea0(), this.a.i);
        }

        public i(DoraGOTAFragment r1, e49.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class j implements com.larus.common_ui.dialog.u {
        public j() {
        }

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            int r0 = j69.a.a;
            j69.a.h(DoraOTAPreCheckReason.NOT_ALLOWED_CELLULAR);
        }
    }

    static {
    }

    public final String k() {
        return "firmware_update";
    }

    public final DoraGOTAViewModel fa0() {
        return (DoraGOTAViewModel) this.h.getValue();
    }

    public DoraGOTAFragment() {
        this.g = LazyKt.lazy(new com.larus.dora.impl.ota.g.j());
        final Function0<Fragment> r0 = new DoraGOTAFragment$special$$inlined$viewModels$default$1(this);
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraGOTAViewModel.class), new DoraGOTAFragment$special$$inlined$viewModels$default$2(r0), new DoraGOTAFragment$special$$inlined$viewModels$default$3(r0, this));
        this.i = UUID.randomUUID().toString();
        this.j = LazyKt.lazy(new k());
        this.k = LazyKt.lazy(new l());
        this.l = LazyKt.lazy(new m());
        this.m = LazyKt.lazy(new n());
        this.u = true;
    }

    public final boolean ea0() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getBoolean("from_ota_debug_page", false);
    }

    public final void onDestroyView() {
        fa0().onManualPageDestroyed(this.i);
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final void onPause() {
        fa0().onManualPagePaused();
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public final void onResume() {
        super.onResume();
        fa0().onManualPageResumed(ea0(), this.i);
        fa0().loadSilentSwitchState();
    }

    public static void W90(CommonDialog r1) {
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

    public final void ca0(e49.a r10) {
        LarusDoraPageOtaV2Binding r0 = this.f;
        if (r0 == null) goto L37;
        OTAUpdatePackage r1 = e49.b.a(r10);
        lw8.l r2 = null;
        if (r1 == null) goto L7;
        String r3 = r1.getVersion();
    L8:
        e1.o(r0.s);
        e1.o(r0.w);
        e1.x(r0.x);
        r0.z.setText(((String) this.j.getValue()) + r3);
        OTAUpdatePackage r4 = e49.b.a(r10);
        if (r4 == null) goto L13;
        Integer r5 = r4.getSize();
        if (r5 == null) goto L13;
        int r6 = r5.intValue();
    L14:
        AppCompatTextView r7 = r0.y;
        StringBuilder r8 = new StringBuilder();
        r8.append((String) this.k.getValue());
        float r9 = Math.max(0.1f, (r6 / 1024.0f) / 1024.0f);
        StringBuilder r11 = new StringBuilder();
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;
        boolean r13 = true;
        r11.append(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r9)}, 1)));
        r11.append(" MB");
        r8.append(r11.toString());
        r7.setText(r8.toString());
        MarkdownTextView r14 = r0.A;
        z39.a r15 = r10.a;
        if (r15 == null) goto L17;
        OTAUpdateMeta r16 = r15.a();
    L18:
        if (r16 == null) goto L20;
        String r17 = r16.getDescDetail();
    L21:
        if (r17 != null) goto L23;
    L26:
        if (r13 == true) goto L33;
        gw8.c.a.getClass();
        gw8.c r18 = gw8.c.a.b();
        if (r18 == null) goto L30;
        r2 = gw8.c.b.b(r18, r14, r17, false, (lw8.d) this.g.getValue());
    L30:
        if (r2 == null) goto L32;
        r14.setMarkdown(r2);
        return;
    L32:
        r14.setText(r16.getDescText());
        return;
    L33:
        if (r16 == null) goto L35;
        r2 = r16.getDescText();
    L35:
        r14.setText(r2);
        return;
    L23:
        if (r17.length() == 0) goto L26;
        r13 = false;
        goto L26
    L20:
        r17 = null;
        goto L21
    L17:
        r16 = null;
    L13:
        r6 = 0;
        goto L14
    L7:
        r3 = null;
        goto L8
    }

    public final void ga0(boolean r3) {
        g49.d.d("DoraGOTAFragment", "setTitleBackEnabled: enabled=" + r3);
        LarusDoraPageOtaV2Binding r0 = this.f;
        if (r0 == null) goto L9;
        DoraNovaTitleBarEx r1 = r0.B;
        if (r1 == null) goto L9;
        if (r3 == false) goto L8;
        DoraNovaTitleBarEx.T5(r1, new o(this));
        goto L9
    L8:
        r1.getBinding().b.setVisibility(8);
    L9:
        this.u = r3;
    }

    public final void ha0(e49.a r9) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        CommonDialog.a r1 = new CommonDialog.a();
        r1.i(getString(2131902848));
        CommonDialog.a.f(r1, new i(this, r9), getString(2131902467), false, 12);
        com.larus.common_ui.dialog.f0 r10 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r0, 2131103203)), Typeface.DEFAULT_BOLD, 1);
        Intrinsics.checkNotNullParameter(r10, "commonDialogTextStyleConfig");
        r1.D = r10;
        CommonDialog.a.e(r1, new j(), getString(2131902465), 4);
        com.larus.common_ui.dialog.f0 r11 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r0, 2131103203)), Typeface.DEFAULT_BOLD, 1);
        Intrinsics.checkNotNullParameter(r11, "commonDialogTextStyleConfig");
        r1.E = r11;
        X90(r1.c(), getChildFragmentManager(), "DownloadOnNonWifiDialog");
    }

    public static final void Y90(DoraGOTAFragment r5, d49.b r6) {
        LarusDoraPageOtaV2Binding r0 = r5.f;
        if (r0 == null) goto L6;
        r5.ga0(true);
        e1.o(r0.s);
        e1.x(r0.w);
        String r7 = r6.a + '-' + r6.b;
        r0.w.setText(r5.getString(2131903821, new Object[]{"v" + r7}));
        e1.o(r0.x);
        return;
    }

    public static final void Z90(final DoraGOTAFragment r3, final e49.a r4) {
        LarusDoraPageOtaV2Binding r0 = r3.f;
        if (r0 == null) goto L6;
        r3.ga0(true);
        r3.ca0(r4);
        e1.x(r0.d);
        e1.o(r0.p);
        e1.o(r0.q);
        e1.o(r0.r);
        e1.x(r0.o);
        r0.o.setText(2131902856);
        e1.d(r0.o, new com.larus.dora.impl.ota.g.b(r4, r3));
        e1.o(r0.j);
        e1.o(r0.m);
        e1.o(r0.e);
        return;
    }

    public static final void aa0(final DoraGOTAFragment r3, final e49.a r4) {
        LarusDoraPageOtaV2Binding r0 = r3.f;
        if (r0 == null) goto L6;
        r3.ga0(true);
        r3.ca0(r4);
        e1.x(r0.d);
        e1.o(r0.p);
        e1.o(r0.q);
        e1.o(r0.r);
        e1.x(r0.o);
        r0.o.setText(2131902857);
        e1.d(r0.o, new com.larus.dora.impl.ota.g.a(r4, r3));
        e1.o(r0.j);
        e1.o(r0.m);
        e1.o(r0.e);
        return;
    }

    public static final void ba0(DoraGOTAFragment r6, int r7) {
        Context r1 = r6.getContext();
        if (r1 == null) goto L10;
        CommonDialog r0 = r6.t;
        if (r0 == null) goto L8;
        W90(r0);
    L8:
        CommonDialog r8 = da0(r6, r1, r1.getString(2131902864), r1.getString(r7), null, 24);
        r6.t = r8;
        X90(r8, r6.getChildFragmentManager(), "TransferFailDialog");
        return;
    }

    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r20, r21);
        LarusDoraPageOtaV2Binding r1 = this.f;
        if (r1 == null) goto L14;
        DoraNovaTitleBarEx r3 = r1.B;
        DoraNovaTitleBarEx.S5(r3, getString(2131902649));
        DoraNovaTitleBarEx.T5(r3, new com.larus.dora.impl.ota.g.g(this));
        e1.o(r1.s);
        e1.o(r1.w);
        e1.o(r1.x);
        Bundle r4 = getArguments();
        int r5 = -1;
        if (r4 == null) goto L7;
        r5 = r4.getInt("route_param_product_id", -1);
    L7:
        Integer r6 = 2131902586;
        r6.intValue();
        if (o59.a.m(Integer.valueOf(r5)) == true) goto L11;
        r6 = null;
    L11:
        if (r6 == null) goto L13;
        r1.p.setText(r6.intValue());
    L13:
        AppCompatTextView r2 = r1.n;
        int r7 = j0.a;
        r2.setText(StringsKt.trim(j0.d(2131902871)).toString());
    L14:
        FragmentActivity r8 = getActivity();
        if (r8 == null) goto L19;
        OnBackPressedDispatcher r9 = r8.getOnBackPressedDispatcher();
        if (r9 == null) goto L19;
        r9.addCallback(getViewLifecycleOwner(), new AnonymousClass2(this));
    L19:
        Lifecycle.State r10 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOTAFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r10, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOTAFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r10, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOTAFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r10, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOTAFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r10, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOTAFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$5(this, r10, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOTAFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$6(this, r10, null, this), 3, null);
        final LarusDoraPageOtaV2Binding r11 = this.f;
        if (r11 == null) goto L22;
        r11.c.getToggleView().a = true;
        e1.d(r11.b, new com.larus.dora.impl.ota.g.h(r11, this));
    L22:
        fa0().checkUpdate(DoraOTACheckFrom.FRAGMENT_VIEW_CREATED, ea0(), this.i);
    }

    public static void X90(CommonDialog r1, FragmentManager r2, String r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r1, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r1.show(r2, r3);
    }

    public final View onCreateView(LayoutInflater r33, ViewGroup r34, Bundle r35) {
        Intrinsics.checkNotNullParameter(r33, "inflater");
        ConstraintLayout r0 = r33.inflate(2131562285, r34, false);
        int r1 = 2131369426;
        ItemGroup r5 = ViewBindings.findChildViewById(r0, 2131369426);
        if (r5 == null) goto L75;
        r1 = 2131369427;
        ItemTextToggle r6 = ViewBindings.findChildViewById(r0, 2131369427);
        if (r6 == null) goto L75;
        r1 = 2131381688;
        ConstraintLayout r7 = ViewBindings.findChildViewById(r0, 2131381688);
        if (r7 == null) goto L75;
        r1 = 2131381689;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131381689)) == null) goto L75;
        r1 = 2131381690;
        ConstraintLayout r8 = ViewBindings.findChildViewById(r0, 2131381690);
        if (r8 == null) goto L75;
        r1 = 2131381691;
        if (((ProgressBar) ViewBindings.findChildViewById(r0, 2131381691)) == null) goto L75;
        r1 = 2131381693;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381693);
        if (r9 == null) goto L75;
        r1 = 2131381694;
        View r10 = ViewBindings.findChildViewById(r0, 2131381694);
        if (r10 == null) goto L75;
        r1 = 2131381695;
        View r11 = ViewBindings.findChildViewById(r0, 2131381695);
        if (r11 == null) goto L75;
        r1 = 2131381696;
        ProgressBar r2 = (ProgressBar) ViewBindings.findChildViewById(r0, 2131381696);
        if (r2 == null) goto L75;
        r1 = 2131381697;
        ConstraintLayout r13 = ViewBindings.findChildViewById(r0, 2131381697);
        if (r13 == null) goto L75;
        r1 = 2131381698;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r0, 2131381698);
        if (r14 == null) goto L75;
        r1 = 2131381699;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r0, 2131381699);
        if (r15 == null) goto L75;
        r1 = 2131381700;
        if (ViewBindings.findChildViewById(r0, 2131381700) == null) goto L75;
        r1 = 2131381701;
        ConstraintLayout r16 = ViewBindings.findChildViewById(r0, 2131381701);
        if (r16 == null) goto L75;
        r1 = 2131381702;
        if (((ProgressBar) ViewBindings.findChildViewById(r0, 2131381702)) == null) goto L75;
        r1 = 2131381703;
        if (ViewBindings.findChildViewById(r0, 2131381703) == null) goto L75;
        r1 = 2131381704;
        AppCompatTextView r17 = ViewBindings.findChildViewById(r0, 2131381704);
        if (r17 == null) goto L75;
        r1 = 2131381705;
        TextView r18 = (TextView) ViewBindings.findChildViewById(r0, 2131381705);
        if (r18 == null) goto L75;
        r1 = 2131381706;
        AppCompatTextView r110 = ViewBindings.findChildViewById(r0, 2131381706);
        if (r110 == null) goto L75;
        r1 = 2131381707;
        AppCompatTextView r20 = ViewBindings.findChildViewById(r0, 2131381707);
        if (r20 == null) goto L75;
        r1 = 2131381708;
        AppCompatTextView r21 = ViewBindings.findChildViewById(r0, 2131381708);
        if (r21 == null) goto L75;
        r1 = 2131381710;
        LinearLayoutCompat r22 = ViewBindings.findChildViewById(r0, 2131381710);
        if (r22 == null) goto L75;
        r1 = 2131381711;
        ProgressBar r23 = (ProgressBar) ViewBindings.findChildViewById(r0, 2131381711);
        if (r23 == null) goto L75;
        r1 = 2131381712;
        ImageView r24 = (ImageView) ViewBindings.findChildViewById(r0, 2131381712);
        if (r24 == null) goto L75;
        r1 = 2131381713;
        TextView r25 = (TextView) ViewBindings.findChildViewById(r0, 2131381713);
        if (r25 == null) goto L75;
        r1 = 2131381714;
        AppCompatTextView r26 = ViewBindings.findChildViewById(r0, 2131381714);
        if (r26 == null) goto L75;
        r1 = 2131381715;
        ConstraintLayout r27 = ViewBindings.findChildViewById(r0, 2131381715);
        if (r27 == null) goto L75;
        r1 = 2131381716;
        if (ViewBindings.findChildViewById(r0, 2131381716) == null) goto L75;
        r1 = 2131381717;
        if (ViewBindings.findChildViewById(r0, 2131381717) == null) goto L75;
        r1 = 2131381718;
        AppCompatTextView r28 = ViewBindings.findChildViewById(r0, 2131381718);
        if (r28 == null) goto L75;
        r1 = 2131381720;
        AppCompatTextView r210 = ViewBindings.findChildViewById(r0, 2131381720);
        if (r210 == null) goto L75;
        r1 = 2131381721;
        if (((ScrollView) ViewBindings.findChildViewById(r0, 2131381721)) == null) goto L75;
        r1 = 2131381722;
        MarkdownTextView r30 = ViewBindings.findChildViewById(r0, 2131381722);
        if (r30 == null) goto L75;
        r1 = 2131388772;
        DoraNovaTitleBarEx r31 = (DoraNovaTitleBarEx) ViewBindings.findChildViewById(r0, 2131388772);
        if (r31 == null) goto L75;
        ConstraintLayout r3 = r0;
        LarusDoraPageOtaV2Binding r4 = new LarusDoraPageOtaV2Binding(r3, r5, r6, r7, r8, r9, r10, r11, r2, r13, r14, r15, r16, r17, r18, r110, r20, r21, r22, r23, r24, r25, r26, r27, r28, r210, r30, r31);
        r2.setOutlineProvider(new b());
        r2.setClipToOutline(true);
        this.f = r4;
        return r3;
    L75:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public static CommonDialog da0(DoraGOTAFragment r4, Context r5, String r6, String r7, com.larus.dora.impl.ota.g.i r8, int r9) {
        if ((r9 & 4) == 0) goto L5;
        r7 = "";
    L5:
        boolean r1 = true;
        if ((r9 & 8) == 0) goto L8;
        final boolean r0 = true;
    L9:
        Function0 r10 = r8;
        if ((r9 & 16) == 0) goto L12;
        r10 = new com.larus.dora.impl.ota.g.d();
    L12:
        r4.getClass();
        CommonDialog.a r11 = new CommonDialog.a();
        Intrinsics.checkNotNullParameter(r6, "title");
        r11.a = r6;
        r11.g(r7);
        CommonDialog.a.f(r11, new p(r10), r4.getString(2131902851), false, 12);
        com.larus.common_ui.dialog.f0 r12 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r5, 2131103203)), Typeface.DEFAULT_BOLD, 1);
        Intrinsics.checkNotNullParameter(r12, "commonDialogTextStyleConfig");
        r11.D = r12;
        r11.z = r0;
        Function0<Boolean> r13 = new com.larus.dora.impl.ota.g.f(r0);
        Intrinsics.checkNotNullParameter(r13, "callback");
        r11.B = r13;
        if (r7.length() > 0) goto L16;
        r1 = false;
    L16:
        r11.b = r1;
        return r11.a();
    L8:
        r0 = false;
        goto L9
    }
}
