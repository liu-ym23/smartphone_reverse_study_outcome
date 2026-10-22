package com.larus.dora.obric.device_management.setting.earbuds.ota;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.larus.dora.api.device.ota.model.OTAUpdateMeta;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.ota.DoraOTAManagement;
import com.larus.dora.impl.device.ota.DoraOTAViewModel;
import com.larus.dora.impl.device.ota.j0;
import com.larus.dora.impl.log.DoraLogManager;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OProgressButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import d49.c$b;
import d49.c$c;
import d49.c$d;
import d49.c$e;
import d49.c$f;
import d49.c$g;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 e2\u00020\u0001:\u0001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u000b2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00107\u001a\u000208H\u0016J\n\u00109\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010:\u001a\u000205H\u0016J\b\u0010;\u001a\u000205H\u0002J\b\u0010<\u001a\u00020\u000bH\u0002J\b\u0010=\u001a\u00020\u000bH\u0002J\b\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020\u000bH\u0002J\b\u0010A\u001a\u00020\u000bH\u0002J\b\u0010B\u001a\u00020\u000bH\u0002J\b\u0010C\u001a\u00020?H\u0002J\b\u0010D\u001a\u00020\u000bH\u0002J\b\u0010E\u001a\u00020\u000bH\u0002J\b\u0010F\u001a\u000205H\u0002J\b\u0010G\u001a\u000205H\u0002J\u0016\u0010H\u001a\u000205*\u00020\u001d2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J$\u0010K\u001a\u0002052\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010N\u001a\u0002082\b\u0010O\u001a\u0004\u0018\u000108H\u0002J\u0018\u0010P\u001a\u0002052\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u000208H\u0002J\u0018\u0010Q\u001a\u0002052\u0006\u0010L\u001a\u00020M2\u0006\u0010R\u001a\u00020SH\u0003J\u0018\u0010T\u001a\u0002052\u0006\u0010L\u001a\u00020M2\u0006\u0010U\u001a\u000208H\u0002J\u0010\u0010V\u001a\u0002052\u0006\u0010L\u001a\u00020MH\u0002J\b\u0010W\u001a\u000205H\u0002J\f\u0010X\u001a\u000205*\u00020?H\u0002J\f\u0010Y\u001a\u000205*\u00020?H\u0002J\f\u0010Z\u001a\u000205*\u00020#H\u0002J\b\u0010[\u001a\u00020SH\u0002J\b\u0010\\\u001a\u00020SH\u0002J\b\u0010]\u001a\u00020SH\u0002J\b\u0010^\u001a\u00020SH\u0002J\f\u0010_\u001a\u000205*\u00020\u0015H\u0002J\u0010\u0010`\u001a\u0002052\u0006\u0010a\u001a\u00020\u000bH\u0002J\f\u0010b\u001a\u00020S*\u00020SH\u0002J\f\u0010c\u001a\u00020S*\u00020dH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b*\u0010+¨\u0006f"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/ota/DoraObricEarbudsOTAFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/ota/DoraOTAViewModel;", "getModel", "()Lcom/larus/dora/impl/device/ota/DoraOTAViewModel;", "model$delegate", "Lkotlin/Lazy;", "pageMaskView", "Landroid/view/View;", "autoOtaSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "otaLoadingLayout", "Landroid/widget/LinearLayout;", "otaLoadingProgressBar", "Landroid/widget/ProgressBar;", "otaLoadingRetryImgView", "Landroid/widget/ImageView;", "otaLoadingTextView", "Landroid/widget/TextView;", "otaNewVersionTextView", "otaUpdateInfoLayout", "Landroid/widget/ScrollView;", "otaUpdateInfoVersionTextView", "Lcom/obric/oui/text/OTextView;", "otaUpdateInfoSizeTextView", "otaUpdateInfoTextView", "Lcom/larus/business/markdown/impl/markwon/MarkdownTextView;", "otaBottomControlLayout", "Landroid/widget/FrameLayout;", "otaBottomControlBtnLayout", "otaBottomControlCurrentVersionTextView", "otaBottomControlStartButton", "Lcom/obric/oui/button/OButton;", "otaBottomControlProgressLayout", "otaBottomControlProgressButton", "Lcom/obric/oui/button/OProgressButton;", "otaBottomControlProgressTextView", "markdownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "getMarkdownInfo", "()Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "markdownInfo$delegate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "getPageMaskView", "onDestroyView", "bindAutoOtaSwitchListener", "buildContentView", "buildTitleBar", "buildAutoOtaSwitchCard", "Lcom/obric/oui/lisitem/OCardListItem;", "buildContentArea", "buildLoadingLayout", "buildUpdateInfoAndControl", "buildUpdateInfoCard", "buildUpdateInfoHeader", "buildBottomControl", "showLoadingUi", "showLoadFailedUi", "setReleaseNotes", "releaseNotes", "Lcom/larus/dora/api/device/ota/model/OTAUpdateMeta;", "showLoadSuccessUi", "response", "Lcom/larus/dora/api/device/ota/model/OTAUpdateResponse;", "deviceVersion", "newVersion", "showOTAFailed", "showOTAProgressing", "progress", "", "showOTASuccess", "version", "bindOTAInfoHeader", "resetProgressButton", "applyCardStyle", "applyContainerCardStyle", "applyBottomButtonStyle", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "resolveTertiaryTextColor", "applyTitleBarTextStyle", "relaxClipForShadow", "target", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsOTAFragment extends DoraBaseFragment {
    public static final /* synthetic */ int z = 0;
    public final Lazy f;
    public View g;
    public OSwitch h;
    public LinearLayout i;
    public ProgressBar j;
    public ImageView k;
    public TextView l;
    public TextView m;
    public ScrollView n;
    public OTextView o;
    public OTextView p;
    public MarkdownTextView q;
    public FrameLayout r;
    public View s;
    public TextView t;
    public OButton u;
    public View v;
    public OProgressButton w;
    public TextView x;
    public final Lazy y;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsOTAFragment a;

        public b(DoraObricEarbudsOTAFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r8, Continuation r9) {
            d49.c r10 = (d49.c) r8;
            if (Intrinsics.areEqual(r10, d49.c.a.a) == false) goto L5;
        L123:
            DoraLogManager r11 = DoraLogManager.a;
            DoraLogManager.w(r10);
            return Unit.INSTANCE;
        L5:
            if (Intrinsics.areEqual(r10, c$d.a) == false) goto L29;
            DoraObricEarbudsOTAFragment r12 = this.a;
            LinearLayout r0 = r12.i;
            if (r0 == null) goto L9;
            e1.x(r0);
        L9:
            ProgressBar r1 = r12.j;
            if (r1 == null) goto L12;
            e1.x(r1);
        L12:
            ImageView r2 = r12.k;
            if (r2 == null) goto L15;
            e1.o(r2);
        L15:
            TextView r3 = r12.l;
            if (r3 == null) goto L18;
            r3.setText(r12.getString(2131903813));
        L18:
            TextView r4 = r12.m;
            if (r4 == null) goto L21;
            e1.o(r4);
        L21:
            ScrollView r5 = r12.n;
            if (r5 == null) goto L24;
            e1.o(r5);
        L24:
            FrameLayout r6 = r12.r;
            if (r6 == null) goto L27;
            e1.o(r6);
        L27:
            r12.ba0();
            goto L123
        L29:
            if ((r10 instanceof c$b) == false) goto L56;
            final DoraObricEarbudsOTAFragment r13 = this.a;
            LinearLayout r7 = r13.i;
            if (r7 == null) goto L33;
            e1.x(r7);
        L33:
            ProgressBar r14 = r13.j;
            if (r14 == null) goto L36;
            e1.o(r14);
        L36:
            ImageView r15 = r13.k;
            if (r15 == null) goto L39;
            e1.x(r15);
        L39:
            TextView r16 = r13.l;
            if (r16 == null) goto L42;
            r16.setText(r13.getString(2131903812));
        L42:
            LinearLayout r17 = r13.i;
            if (r17 == null) goto L45;
            e1.d(r17, new j(r13));
        L45:
            TextView r18 = r13.m;
            if (r18 == null) goto L48;
            e1.o(r18);
        L48:
            ScrollView r20 = r13.n;
            if (r20 == null) goto L51;
            e1.o(r20);
        L51:
            FrameLayout r21 = r13.r;
            if (r21 == null) goto L54;
            e1.o(r21);
        L54:
            r13.ba0();
            goto L123
        L56:
            if ((r10 instanceof c$c) == false) goto L59;
            DoraObricEarbudsOTAFragment r22 = this.a;
            c$c r23 = (c$c) r10;
            z39.a r24 = r23.a;
            String r25 = r23.b;
            String r26 = r23.c;
            int r27 = DoraObricEarbudsOTAFragment.z;
            r22.fa0(r24, r25, r26);
            goto L123
        L59:
            if ((r10 instanceof c$e) == false) goto L98;
            DoraObricEarbudsOTAFragment r28 = this.a;
            c$e r30 = (c$e) r10;
            final z39.a r31 = r30.b;
            String r32 = r30.d;
            LinearLayout r33 = r28.i;
            if (r33 == null) goto L63;
            e1.o(r33);
        L63:
            TextView r34 = r28.m;
            if (r34 == null) goto L66;
            e1.o(r34);
        L66:
            ScrollView r35 = r28.n;
            if (r35 == null) goto L69;
            e1.x(r35);
        L69:
            r28.Y90(r31);
            MarkdownTextView r36 = r28.q;
            if (r36 == null) goto L72;
            r28.ea0(r36, r31.a());
        L72:
            FrameLayout r37 = r28.r;
            if (r37 == null) goto L75;
            e1.x(r37);
        L75:
            View r38 = r28.s;
            if (r38 == null) goto L78;
            e1.x(r38);
        L78:
            TextView r40 = r28.t;
            if (r40 == null) goto L81;
            e1.x(r40);
        L81:
            TextView r41 = r28.t;
            if (r41 == null) goto L84;
            r41.setText(r28.getString(2131903814, new Object[]{"v" + r32}));
        L84:
            OButton r42 = r28.u;
            if (r42 == null) goto L87;
            r42.setText(r28.getString(2131903826));
        L87:
            OButton r43 = r28.u;
            if (r43 == null) goto L90;
            e1.x(r43);
        L90:
            OButton r44 = r28.u;
            if (r44 == null) goto L93;
            e1.d(r44, new i(r31));
        L93:
            View r45 = r28.v;
            if (r45 == null) goto L96;
            e1.o(r45);
        L96:
            r28.ba0();
            goto L123
        L98:
            if ((r10 instanceof c$f) == false) goto L101;
            DoraObricEarbudsOTAFragment r46 = this.a;
            c$f r47 = (c$f) r10;
            z39.a r48 = r47.b;
            int r50 = r47.c;
            int r51 = DoraObricEarbudsOTAFragment.z;
            r46.ga0(r48, r50);
            goto L123
        L101:
            if ((r10 instanceof c$g) == false) goto L122;
            DoraObricEarbudsOTAFragment r52 = this.a;
            c$g r53 = (c$g) r10;
            z39.a r54 = r53.b;
            String r55 = r53.c;
            LinearLayout r56 = r52.i;
            if (r56 == null) goto L105;
            e1.o(r56);
        L105:
            TextView r57 = r52.m;
            if (r57 == null) goto L108;
            e1.x(r57);
        L108:
            TextView r58 = r52.m;
            if (r58 == null) goto L111;
            r58.setText(r52.getString(2131903821, new Object[]{"v" + r55}));
        L111:
            OButton r60 = r52.u;
            if (r60 == null) goto L114;
            r60.setText(r52.getString(2131903811));
        L114:
            ScrollView r61 = r52.n;
            if (r61 == null) goto L117;
            e1.o(r61);
        L117:
            FrameLayout r62 = r52.r;
            if (r62 == null) goto L120;
            e1.o(r62);
        L120:
            r52.ba0();
            goto L123
        L122:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsOTAFragment a;

        public c(DoraObricEarbudsOTAFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            boolean r5 = ((Boolean) r3).booleanValue();
            DoraObricEarbudsOTAFragment r6 = this.a;
            OSwitch r0 = r6.h;
            if (r0 == null) goto L6;
            r0.setOnCheckedChangeListener(null);
            r0.setChecked(r5);
            r6.X90();
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsOTAFragment a;

        public d(DoraObricEarbudsOTAFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            if (((Boolean) r2).booleanValue() == true) goto L11;
            DoraObricEarbudsOTAFragment r4 = this.a;
            OSwitch r5 = r4.h;
            if (r5 == null) goto L7;
            r5.setOnCheckedChangeListener(null);
            r5.setChecked(((Boolean) r4.aa0().getAutoOTASwitchStateFlow().getValue()).booleanValue());
            r4.X90();
        L7:
            FragmentActivity r6 = this.a.getActivity();
            if (r6 == null) goto L11;
            DoraObricEarbudsOTAFragment r7 = this.a;
            Handler r0 = com.obric.oui.toast.f.n;
            com.obric.oui.toast.f.a.a(r6, r7.getString(2131908080));
        L11:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.earbuds.ota.DoraObricEarbudsOTAFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.ota.DoraObricEarbudsOTAFragment$onViewCreated$2", f = "DoraObricEarbudsOTAFragment.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraObricEarbudsOTAFragment this$0;

        /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.earbuds.ota.DoraObricEarbudsOTAFragment$onViewCreated$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.ota.DoraObricEarbudsOTAFragment$onViewCreated$2$1", f = "DoraObricEarbudsOTAFragment.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DoraObricEarbudsOTAFragment this$0;

            /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.earbuds.ota.DoraObricEarbudsOTAFragment$onViewCreated$2$1$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ DoraObricEarbudsOTAFragment a;

                public a(DoraObricEarbudsOTAFragment r1) {
                    this.a = r1;
                }

                public final Object emit(Object r7, Continuation r8) {
                    j0 r9 = (j0) r7;
                    if ((r9 instanceof j0.c) == false) goto L8;
                    FragmentActivity r10 = this.a.getActivity();
                    if (r10 == null) goto L22;
                    Handler r0 = com.obric.oui.toast.f.n;
                    com.obric.oui.toast.f.a.a(r10, ((j0.c) r9).a);
                L22:
                    return Unit.INSTANCE;
                L8:
                    if (Intrinsics.areEqual(r9, j0.a.a) == false) goto L15;
                    int r11 = j49.a.a;
                    DoraBuryPointManager.a.L("dora_floating_window_show", MapsKt.mapOf(TuplesKt.to("window_content_type", "firmware_update_block_popup_single_ear")));
                    com.obric.oui.dialog.v2.alert.g r12 = new com.obric.oui.dialog.v2.alert.g(this.a.requireContext());
                    r12.w = false;
                    int r13 = com.larus.utils.j0.a;
                    String r14 = com.larus.utils.j0.d(2131903816);
                    r12.j = false;
                    r12.h = r14;
                    r12.i = com.larus.utils.j0.d(2131903815);
                    r12.m = 0;
                    r12.t = true;
                    r12.e(this.a.getString(2131902465), new l());
                    r12.h(this.a.getString(2131902466), new m());
                    com.obric.oui.dialog.v2.alert.c r15 = r12.a();
                    if (DialogLancet.shouldBlockDialogShow(r15) == false) goto L27;
                    DialogLancet.handleBlockedDialogShow(r15);
                    goto L22
                L27:
                    DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
                L13:
                    DialogLancet.beforeDialogShow(r15);
                    r15.show();
                    DialogLancet.afterDialogShow(r15);
                    goto L22
                L15:
                    if (Intrinsics.areEqual(r9, j0.b.a) == false) goto L24;
                    int r16 = j49.a.a;
                    DoraBuryPointManager.a.L("dora_floating_window_show", MapsKt.mapOf(TuplesKt.to("window_content_type", "firmware_update_block_popup_batt")));
                    com.obric.oui.dialog.v2.alert.g r17 = new com.obric.oui.dialog.v2.alert.g(this.a.requireContext());
                    r17.w = false;
                    int r18 = com.larus.utils.j0.a;
                    String r20 = com.larus.utils.j0.d(2131903823);
                    r17.j = false;
                    r17.h = r20;
                    r17.i = com.larus.utils.j0.d(2131903822);
                    r17.m = 0;
                    r17.t = true;
                    r17.e(this.a.getString(2131902465), new n());
                    r17.h(this.a.getString(2131902466), new o());
                    com.obric.oui.dialog.v2.alert.c r21 = r17.a();
                    if (DialogLancet.shouldBlockDialogShow(r21) == false) goto L29;
                    DialogLancet.handleBlockedDialogShow(r21);
                    goto L22
                L29:
                    DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
                L20:
                    DialogLancet.beforeDialogShow(r21);
                    r21.show();
                    DialogLancet.afterDialogShow(r21);
                    goto L22
                L24:
                    throw new NoWhenBranchMatchedException();
                }
            }

            public AnonymousClass1(DoraObricEarbudsOTAFragment r1, Continuation<? super AnonymousClass1> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass1(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r5);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                MutableSharedFlow r6 = DoraOTAManagement.h;
                a r2 = new a(this.this$0);
                this.label = 1;
                if (r6.collect(r2, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass2(DoraObricEarbudsOTAFragment r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            DoraObricEarbudsOTAFragment r7 = this.this$0;
            Lifecycle.State r2 = Lifecycle.State.STARTED;
            AnonymousClass1 r3 = new AnonymousClass1(r7, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(r7, r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final String k() {
        return "firmware_update";
    }

    public final void onDestroyView() {
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final void X90() {
        OSwitch r0 = this.h;
        if (r0 == null) goto L6;
        r0.setOnCheckedChangeListener(new h(this));
        return;
    }

    public final DoraOTAViewModel aa0() {
        return (DoraOTAViewModel) this.f.getValue();
    }

    public final void ba0() {
        OProgressButton r0 = this.w;
        if (r0 == null) goto L5;
        r0.setProgressMode(false);
    L5:
        OProgressButton r1 = this.w;
        if (r1 == null) goto L8;
        r1.setProgress(0);
    L8:
        OProgressButton r2 = this.w;
        if (r2 == null) goto L12;
        e1.o(r2);
        return;
    }

    public DoraObricEarbudsOTAFragment() {
        final Function0<Fragment> r0 = new DoraObricEarbudsOTAFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraOTAViewModel.class), new DoraObricEarbudsOTAFragment$special$$inlined$viewModels$default$2(r0), new DoraObricEarbudsOTAFragment$special$$inlined$viewModels$default$3(r0, this));
        this.y = LazyKt.lazy(new k(this));
    }

    public final int ca0() {
        return v19.c.a(2130972079, requireContext(), 2131103136);
    }

    public final int da0() {
        return v19.c.a(2130972081, requireContext(), 2131103143);
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.g;
    }

    public final void W90(OButton r4) {
        r4.setGravity(17);
        r4.setMinHeight(Z90(56));
        r4.setAllCaps(false);
        r4.setIncludeFontPadding(false);
        r4.setTextSize(2, 17.0f);
        TextViewCompat.setLineHeight(r4, ha0(24.0f));
        r4.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
    }

    public final void Y90(z39.a r8) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        List<OTAUpdatePackage> r9 = r8.b();
        if (r9 == null) goto L27;
        List r10 = CollectionsKt.filterNotNull(r9);
        if (r10 == null) goto L28;
        OTAUpdatePackage r11 = (OTAUpdatePackage) CollectionsKt.firstOrNull(r10);
        if (r11 == null) goto L30;
        Integer r1 = r11.getSize();
        if (r1 == null) goto L15;
        int r2 = r1.intValue();
    L17:
        if (r2 > 102400) goto L19;
        String r3 = "0.1";
    L20:
        OTextView r4 = this.o;
        if (r4 == null) goto L23;
        r4.setText(r0.getString(2131903819, new Object[]{r11.getVersion()}));
    L23:
        OTextView r12 = this.p;
        if (r12 == null) goto L29;
        r12.setText(r0.getString(2131903818, new Object[]{r3 + " MB"}));
        return;
    L29:
        return;
    L19:
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        r3 = String.format(Locale.CHINA, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf((r2 / 1024.0f) / 1024.0f)}, 1));
        goto L20
    L15:
        r2 = 0;
        goto L17
    L30:
        return;
    L28:
        return;
    }

    public final int Z90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final int ha0(float r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(2, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public final void ea0(MarkdownTextView r5, OTAUpdateMeta r6) {
        lw8.l r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getDescDetail();
    L7:
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L20;
        gw8.c.a.getClass();
        gw8.c r4 = gw8.c.a.b();
        if (r4 == null) goto L17;
        r0 = gw8.c.b.b(r4, r5, r1, false, (lw8.d) this.y.getValue());
    L17:
        if (r0 == null) goto L19;
        r5.setMarkdown(r0);
        return;
    L19:
        r5.setText(r6.getDescText());
        return;
    L20:
        if (r6 == null) goto L22;
        r0 = r6.getDescText();
    L22:
        r5.setText(r0);
        return;
    L9:
        if (r1.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    public final void ga0(z39.a r5, int r6) {
        if (DoraOTAManagement.H == true) goto L5;
        return;
    L5:
        LinearLayout r0 = this.i;
        if (r0 == null) goto L8;
        e1.o(r0);
    L8:
        TextView r1 = this.m;
        if (r1 == null) goto L11;
        e1.o(r1);
    L11:
        ScrollView r2 = this.n;
        if (r2 == null) goto L14;
        e1.x(r2);
    L14:
        Y90(r5);
        MarkdownTextView r3 = this.q;
        if (r3 == null) goto L17;
        ea0(r3, r5.a());
    L17:
        FrameLayout r7 = this.r;
        if (r7 == null) goto L20;
        e1.x(r7);
    L20:
        View r8 = this.s;
        if (r8 == null) goto L23;
        e1.o(r8);
    L23:
        View r9 = this.v;
        if (r9 == null) goto L26;
        e1.x(r9);
    L26:
        OProgressButton r10 = this.w;
        if (r10 == null) goto L29;
        e1.x(r10);
    L29:
        OProgressButton r11 = this.w;
        if (r11 == null) goto L32;
        r11.setEnabled(true);
    L32:
        OProgressButton r12 = this.w;
        if (r12 == null) goto L35;
        r12.setClickable(false);
    L35:
        OProgressButton r13 = this.w;
        if (r13 == null) goto L38;
        StringBuilder r4 = new StringBuilder();
        r4.append(r6);
        r4.append('%');
        r13.setText(r4.toString());
    L38:
        OProgressButton r14 = this.w;
        if (r14 == null) goto L41;
        r14.setProgressMode(true);
    L41:
        OProgressButton r15 = this.w;
        if (r15 == null) goto L44;
        r15.e(RangesKt.coerceIn(r6, 0, 100));
    L44:
        TextView r16 = this.x;
        if (r16 == null) goto L48;
        r16.setText(getString(2131903827));
        return;
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r14, r15);
        Lifecycle.State r16 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsOTAFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r16, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsOTAFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r16, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsOTAFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r16, null, this), 3, null);
        X90();
        aa0().loadAutoOTASwitch();
        if (DoraOTAManagement.H == false) goto L5;
    L9:
        DoraOTAManagement.n();
        return;
    L5:
        if ((DoraOTAManagement.f.getValue() instanceof c$f) == false) goto L9;
        c$c r17 = DoraOTAManagement.I;
        if (r17 == null) goto L11;
        fa0(r17.a, r17.b, r17.c);
        return;
    }

    public final void fa0(final z39.a r5, String r6, String r7) {
        if (r7 != null) goto L5;
    L8:
        boolean r8 = true;
    L10:
        if (r8 == true) goto L50;
        if (r5 == null) goto L50;
        LinearLayout r9 = this.i;
        if (r9 == null) goto L16;
        e1.o(r9);
    L16:
        TextView r10 = this.m;
        if (r10 == null) goto L19;
        e1.o(r10);
    L19:
        ScrollView r11 = this.n;
        if (r11 == null) goto L22;
        e1.x(r11);
    L22:
        Y90(r5);
        MarkdownTextView r12 = this.q;
        if (r12 == null) goto L25;
        ea0(r12, r5.a());
    L25:
        FrameLayout r13 = this.r;
        if (r13 == null) goto L28;
        e1.x(r13);
    L28:
        View r14 = this.s;
        if (r14 == null) goto L31;
        e1.x(r14);
    L31:
        TextView r15 = this.t;
        if (r15 == null) goto L34;
        e1.x(r15);
    L34:
        TextView r16 = this.t;
        if (r16 == null) goto L37;
        r16.setText(getString(2131903814, new Object[]{"v" + r6}));
    L37:
        OButton r17 = this.u;
        if (r17 == null) goto L40;
        r17.setText(getString(2131903811));
    L40:
        OButton r18 = this.u;
        if (r18 == null) goto L43;
        e1.x(r18);
    L43:
        OButton r20 = this.u;
        if (r20 == null) goto L46;
        e1.d(r20, new e(r5, this));
    L46:
        View r21 = this.v;
        if (r21 == null) goto L49;
        e1.o(r21);
    L49:
        ba0();
        return;
    L50:
        LinearLayout r22 = this.i;
        if (r22 == null) goto L53;
        e1.o(r22);
    L53:
        TextView r23 = this.m;
        if (r23 == null) goto L56;
        e1.x(r23);
    L56:
        TextView r24 = this.m;
        if (r24 == null) goto L59;
        r24.setText(getString(2131903821, new Object[]{"v" + r6}));
    L59:
        ScrollView r25 = this.n;
        if (r25 == null) goto L62;
        e1.o(r25);
    L62:
        FrameLayout r26 = this.r;
        if (r26 == null) goto L65;
        e1.o(r26);
    L65:
        ba0();
        return;
    L5:
        if (r7.length() == 0) goto L8;
        r8 = false;
        goto L10
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        Context r1 = requireContext();
        FrameLayout r2 = new FrameLayout(r1);
        r2.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LinearLayout r3 = new LinearLayout(r1);
        r3.setOrientation(1);
        r3.setClipChildren(true);
        r3.setClipToPadding(true);
        OFloatingTitleBar r8 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        com.larus.dora.obric.utils.c.a(r8);
        r8.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r8.setCenterTitle(getString(2131903828));
        r8.setCenterTitleColor(ca0());
        TextView r4 = (TextView) r8.findViewById(2131365427);
        if (r4 == null) goto L5;
        r4.setTextColor(ca0());
        r4.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r4, ha0(22.0f));
        r4.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r8.R(false);
        final View r5 = OFloatingTitleBar.k(r8, null, 6);
        r5.setOnClickListener(new com.larus.dora.obric.device_management.setting.earbuds.ota.a(this));
        r8.post(new com.larus.dora.obric.device_management.setting.earbuds.ota.c(this, r5));
        r3.addView(r8, new LinearLayout.LayoutParams(-1, -2));
        final View r6 = new OCardListItem(requireContext(), null, 6, 0);
        r6.setCardType(0);
        OCardListItem.h(r6, 0);
        r6.setShowCardBg(true);
        r6.p(false);
        r6.setTitle(getString(2131903810));
        r6.s(true);
        r6.q(false);
        r6.setDefaultCustomEndView(1);
        r6.m(true);
        r6.r(false);
        OSwitch r9 = r6.getEndSwitch();
        if (r9 == null) goto L8;
        this.h = r9;
    L8:
        r6.setOnContentClickListener(new com.larus.dora.obric.device_management.setting.earbuds.ota.d(r6));
        ViewGroup.LayoutParams r10 = r6.getCardContainer().getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
    L12:
        if (r11 == null) goto L14;
        r11.setMarginStart(0);
        r11.setMarginEnd(0);
        r11.leftMargin = 0;
        r11.rightMargin = 0;
        r6.getCardContainer().setLayoutParams(r11);
    L14:
        r6.getContentContainer().setPadding(0, 0, Z90(4), 0);
        r6.getTitleContainer().setGravity(16);
        r6.getTitleContainer().setPadding(Z90(12), Z90(8), Z90(8), Z90(8));
        OTextView r7 = r6.getTitleView();
        r7.setGravity(8388611);
        r7.setMaxLines(1);
        r7.setTextColor(ca0());
        r7.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r7, ha0(22.0f));
        r7.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r6.o(false);
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(-1, -2);
        r12.setMarginStart(Z90(16));
        r12.setMarginEnd(Z90(16));
        r12.topMargin = Z90(8);
        r12.bottomMargin = Z90(16);
        Unit r13 = Unit.INSTANCE;
        r3.addView(r6, r12);
        Context r14 = requireContext();
        FrameLayout r15 = new FrameLayout(r14);
        r15.setClipChildren(false);
        r15.setClipToPadding(false);
        r15.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Context r16 = requireContext();
        LinearLayout r20 = new LinearLayout(r16);
        r20.setOrientation(1);
        r20.setVisibility(8);
        this.i = r20;
        FrameLayout r111 = new FrameLayout(r16);
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(-2, -2);
        r112.gravity = 1;
        r111.setLayoutParams(r112);
        ProgressBar r113 = new ProgressBar(r16);
        r113.setIndeterminateDrawable(ContextCompat.getDrawable(r16, 2131240533));
        r113.setPadding(Z90(20), Z90(20), Z90(20), Z90(20));
        r111.addView(r113, new FrameLayout.LayoutParams(Z90(60), Z90(60)));
        this.j = r113;
        ImageView r21 = new ImageView(r16);
        r21.setImageResource(2131240637);
        r111.addView(r21, new FrameLayout.LayoutParams(Z90(60), Z90(60)));
        this.k = r21;
        r20.addView(r111);
        TextView r22 = new TextView(r16);
        r22.setGravity(1);
        r22.setTextColor(da0());
        r22.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(-2, -2);
        r114.gravity = 1;
        r20.addView(r22, r114);
        this.l = r22;
        r15.addView(r20, new FrameLayout.LayoutParams(-2, -2, 17));
        TextView r23 = new TextView(r14);
        r23.setGravity(1);
        r23.setTextColor(da0());
        r23.setTextSize(2, 14.0f);
        r23.setVisibility(8);
        r15.addView(r23, new FrameLayout.LayoutParams(-2, -2, 17));
        this.m = r23;
        Context r24 = requireContext();
        LinearLayout r25 = new LinearLayout(r24);
        r25.setOrientation(1);
        r25.setClipChildren(false);
        r25.setClipToPadding(false);
        r25.setPadding(Z90(16), 0, Z90(16), 0);
        ScrollView r26 = new ScrollView(r24);
        r26.setVisibility(8);
        Context r27 = requireContext();
        LinearLayout r115 = new LinearLayout(r27);
        r115.setOrientation(1);
        r115.setPadding(Z90(16), Z90(16), Z90(16), Z90(16));
        Context r28 = requireContext();
        LinearLayout r116 = new LinearLayout(r28);
        r116.setOrientation(1);
        OTextView r117 = new OTextView(r28, null, 0, 14);
        r117.setTextColor(ca0());
        r117.setTextSize(2, 17.0f);
        TextViewCompat.setLineHeight(r117, ha0(24.0f));
        r117.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
        r116.addView(r117, new LinearLayout.LayoutParams(-1, -2));
        this.o = r117;
        OTextView r118 = new OTextView(r28, null, 0, 14);
        r118.setTextColor(da0());
        r118.setTextSize(2, 15.0f);
        TextViewCompat.setLineHeight(r118, ha0(21.0f));
        LinearLayout.LayoutParams r30 = new LinearLayout.LayoutParams(-1, -2);
        r30.topMargin = Z90(2);
        r116.addView(r118, r30);
        this.p = r118;
        r115.addView(r116, new LinearLayout.LayoutParams(-1, -2));
        MarkdownTextView r31 = new MarkdownTextView(r27, null, 6, 0);
        r31.setTextColor(ca0());
        r31.setTextSize(2, 17.0f);
        LinearLayout.LayoutParams r119 = new LinearLayout.LayoutParams(-1, -2);
        r119.topMargin = Z90(16);
        r115.addView(r31, r119);
        this.q = r31;
        OCardListItem r32 = new OCardListItem(r27, null, 6, 0);
        r32.setCardType(2);
        OCardListItem.h(r32, 0);
        r32.setShowCardBg(true);
        r32.setCustomStartView(r115);
        r32.n(true);
        r32.m(false);
        r32.r(false);
        r32.o(false);
        ViewGroup.LayoutParams r33 = r32.getCardContainer().getLayoutParams();
        if ((r33 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r33;
    L18:
        if (r120 == null) goto L20;
        r120.setMarginStart(0);
        r120.setMarginEnd(0);
        r120.leftMargin = 0;
        r120.rightMargin = 0;
        r32.getCardContainer().setLayoutParams(r120);
    L20:
        r32.getContentContainer().setPadding(0, 0, 0, 0);
        r32.o(false);
        r26.addView(r32, new ViewGroup.LayoutParams(-1, -2));
        this.n = r26;
        LinearLayout.LayoutParams r34 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        r34.topMargin = Z90(16);
        r25.addView(r26, r34);
        Context r35 = requireContext();
        FrameLayout r36 = new FrameLayout(r35);
        r36.setPadding(Z90(16), Z90(16), Z90(16), Z90(8));
        r36.setVisibility(8);
        this.r = r36;
        LinearLayout r37 = new LinearLayout(r35);
        r37.setOrientation(1);
        r37.setGravity(1);
        TextView r121 = new TextView(r35);
        r121.setTextColor(da0());
        r121.setTextSize(2, 14.0f);
        r121.setGravity(17);
        r121.setVisibility(8);
        LinearLayout.LayoutParams r122 = new LinearLayout.LayoutParams(-2, -2);
        r122.gravity = 1;
        r122.bottomMargin = Z90(12);
        r37.addView(r121, r122);
        this.t = r121;
        OButton r123 = (OButton) vma.e.a(r35, 2131952832, new f());
        r123.setText(getString(2131903811));
        W90(r123);
        LinearLayout.LayoutParams r124 = new LinearLayout.LayoutParams(-1, Z90(56));
        r124.bottomMargin = Z90(32);
        r37.addView(r123, r124);
        this.u = r123;
        r36.addView(r37, new FrameLayout.LayoutParams(-1, -2, 80));
        this.s = r37;
        LinearLayout r38 = new LinearLayout(r35);
        r38.setOrientation(1);
        r38.setGravity(1);
        r38.setVisibility(8);
        OProgressButton r125 = vma.e.a(r35, 2131953067, new g());
        W90(r125);
        r125.setClickable(false);
        r38.addView(r125, new LinearLayout.LayoutParams(-1, Z90(56)));
        this.w = r125;
        TextView r126 = new TextView(r35);
        r126.setGravity(17);
        r126.setText(getString(2131903827));
        r126.setTextColor(da0());
        r126.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams r40 = new LinearLayout.LayoutParams(-2, -2);
        r40.gravity = 1;
        r40.topMargin = Z90(12);
        r40.bottomMargin = Z90(8);
        r38.addView(r126, r40);
        this.x = r126;
        r36.addView(r38, new FrameLayout.LayoutParams(-1, -2, 80));
        this.v = r38;
        r25.addView(r36, new LinearLayout.LayoutParams(-1, -2));
        r15.addView(r25, new FrameLayout.LayoutParams(-1, -1));
        r3.addView(r15, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        r2.addView(r3, new FrameLayout.LayoutParams(-1, -1));
        View r41 = new View(r1);
        r41.setBackgroundColor(ContextCompat.getColor(r1, 2131103066));
        r41.setClickable(true);
        r41.setFocusable(true);
        r2.addView(r41, new FrameLayout.LayoutParams(-1, -1));
        this.g = r41;
        return r2;
    L17:
        r120 = null;
        goto L18
    L11:
        r11 = null;
        goto L12
    }
}
