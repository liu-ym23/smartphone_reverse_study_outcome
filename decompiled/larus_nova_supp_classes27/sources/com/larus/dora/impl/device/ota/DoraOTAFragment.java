package com.larus.dora.impl.device.ota;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.api.device.ota.model.OTAUpdateMeta;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.databinding.LarusDoraPageOtaBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.log.DoraLogManager;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\u0016\u0010!\u001a\u00020\u001a*\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J$\u0010%\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010*\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dH\u0002J\u0018\u0010+\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'2\u0006\u0010,\u001a\u00020-H\u0003J\u0018\u0010.\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'2\u0006\u0010/\u001a\u00020\u001dH\u0002J\u0010\u00100\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u00062"}, d2 = {"Lcom/larus/dora/impl/device/ota/DoraOTAFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageOtaBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/ota/DoraOTAViewModel;", "getModel", "()Lcom/larus/dora/impl/device/ota/DoraOTAViewModel;", "model$delegate", "Lkotlin/Lazy;", "markdownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "getMarkdownInfo", "()Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "markdownInfo$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "onResume", "showLoadingUi", "showLoadFailedUi", "setReleaseNotes", "Lcom/larus/business/markdown/impl/markwon/MarkdownTextView;", "releaseNotes", "Lcom/larus/dora/api/device/ota/model/OTAUpdateMeta;", "showLoadSuccessUi", "response", "Lcom/larus/dora/api/device/ota/model/OTAUpdateResponse;", "deviceVersion", "newVersion", "showOTAFailed", "showOTAProgressing", "progress", "", "showOTASuccess", "version", "getOTAInfoHeader", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraOTAFragment extends DoraBaseFragment {
    public static final /* synthetic */ int i = 0;
    public LarusDoraPageOtaBinding f;
    public final Lazy g;
    public final Lazy h;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ DoraOTAFragment a;

        public b(DoraOTAFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r9, Continuation r10) {
            d49.c r11 = (d49.c) r9;
            if (Intrinsics.areEqual(r11, d49.c.a.a) == false) goto L5;
        L32:
            DoraLogManager r12 = DoraLogManager.a;
            DoraLogManager.w(r11);
            return Unit.INSTANCE;
        L5:
            if (Intrinsics.areEqual(r11, c$d.a) == false) goto L10;
            DoraOTAFragment r13 = this.a;
            LarusDoraPageOtaBinding r0 = r13.f;
            if (r0 == null) goto L32;
            e1.x(r0.j);
            e1.x(r0.k);
            e1.o(r0.l);
            r0.m.setText(r13.getString(2131903813));
            e1.o(r0.n);
            e1.o(r0.p);
            e1.o(r0.e);
            goto L32
        L10:
            if ((r11 instanceof c$b) == false) goto L15;
            DoraOTAFragment r14 = this.a;
            final LarusDoraPageOtaBinding r1 = r14.f;
            if (r1 == null) goto L32;
            e1.x(r1.j);
            e1.o(r1.k);
            e1.x(r1.l);
            r1.m.setText(r14.getString(2131903812));
            e1.d(r1.j, new j(r1));
            e1.o(r1.n);
            e1.o(r1.p);
            e1.o(r1.e);
            goto L32
        L15:
            if ((r11 instanceof c$c) == false) goto L18;
            DoraOTAFragment r15 = this.a;
            c$c r2 = (c$c) r11;
            z39.a r3 = r2.a;
            String r4 = r2.b;
            String r5 = r2.c;
            int r6 = DoraOTAFragment.i;
            r15.Z90(r3, r4, r5);
            goto L32
        L18:
            if ((r11 instanceof c$e) == false) goto L23;
            DoraOTAFragment r16 = this.a;
            c$e r7 = (c$e) r11;
            final z39.a r8 = r7.b;
            String r17 = r7.d;
            LarusDoraPageOtaBinding r18 = r16.f;
            if (r18 == null) goto L32;
            e1.o(r18.j);
            e1.o(r18.n);
            e1.x(r18.p);
            r18.o.setText(r16.X90(r8));
            r16.Y90(r18.q, r8.a());
            e1.x(r18.e);
            e1.x(r18.c);
            e1.x(r18.d);
            r18.d.setText(r16.getString(2131903814, new Object[]{"v" + r17}));
            r18.i.setText(r16.getString(2131903826));
            e1.x(r18.i);
            e1.d(r18.i, new m(r8));
            e1.o(r18.g);
            goto L32
        L23:
            if ((r11 instanceof c$f) == false) goto L26;
            DoraOTAFragment r110 = this.a;
            c$f r20 = (c$f) r11;
            z39.a r21 = r20.b;
            int r22 = r20.c;
            int r23 = DoraOTAFragment.i;
            r110.aa0(r21, r22);
            goto L32
        L26:
            if ((r11 instanceof c$g) == false) goto L31;
            DoraOTAFragment r111 = this.a;
            c$g r24 = (c$g) r11;
            z39.a r25 = r24.b;
            String r26 = r24.c;
            LarusDoraPageOtaBinding r27 = r111.f;
            if (r27 == null) goto L32;
            e1.o(r27.j);
            e1.x(r27.n);
            r27.n.setText(r111.getString(2131903821, new Object[]{"v" + r26}));
            r27.i.setText(r111.getString(2131903811));
            e1.o(r27.p);
            e1.o(r27.e);
            goto L32
        L31:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraOTAFragment a;

        public c(DoraOTAFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            boolean r3 = ((Boolean) r1).booleanValue();
            LarusDoraPageOtaBinding r4 = this.a.f;
            if (r4 == null) goto L10;
            ItemTextToggle r5 = r4.b;
            if (r5 == null) goto L10;
            CustomSwitchCompat r6 = r5.getToggleView();
            if (r6 == null) goto L10;
            r6.setChecked(r3);
        L10:
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ DoraOTAFragment a;

        public d(DoraOTAFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            if (((Boolean) r3).booleanValue() == true) goto L13;
            LarusDoraPageOtaBinding r5 = this.a.f;
            if (r5 == null) goto L11;
            ItemTextToggle r6 = r5.b;
            if (r6 == null) goto L11;
            CustomSwitchCompat r7 = r6.getToggleView();
            if (r7 == null) goto L11;
            r7.setChecked(((Boolean) this.a.W90().getAutoOTASwitchStateFlow().getValue()).booleanValue());
        L11:
            s.a.g(AppHost.a.getApplication(), 2131908080, false);
        L13:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ota.DoraOTAFragment$onViewCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAFragment$onViewCreated$3", f = "DoraOTAFragment.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraOTAFragment this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.ota.DoraOTAFragment$onViewCreated$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAFragment$onViewCreated$3$1", f = "DoraOTAFragment.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DoraOTAFragment this$0;

            /* JADX INFO: renamed from: com.larus.dora.impl.device.ota.DoraOTAFragment$onViewCreated$3$1$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ DoraOTAFragment a;

                public a(DoraOTAFragment r1) {
                    this.a = r1;
                }

                public static void a(CommonDialog r2, FragmentManager r3) {
                    LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
                    LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r0);
                    if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
                    return;
                L9:
                    DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
                L6:
                    r2.show(r3, null);
                }

                public final Object emit(Object r8, Continuation r9) {
                    j0 r10 = (j0) r8;
                    if ((r10 instanceof j0.c) == false) goto L6;
                    s r11 = s.a;
                    Application r0 = AppHost.a.getApplication();
                    String r12 = ((j0.c) r10).a;
                    r11.getClass();
                    s.c(r0, r12);
                L12:
                    return Unit.INSTANCE;
                L6:
                    if (Intrinsics.areEqual(r10, j0.a.a) == false) goto L9;
                    int r13 = j49.a.a;
                    DoraBuryPointManager.a.L("dora_floating_window_show", MapsKt.mapOf(TuplesKt.to("window_content_type", "firmware_update_block_popup_single_ear")));
                    CommonDialog.a r14 = new CommonDialog.a();
                    int r15 = com.larus.utils.j0.a;
                    r14.i(com.larus.utils.j0.d(2131903816));
                    r14.g(com.larus.utils.j0.d(2131903815));
                    CommonDialog.a.f(r14, new o(), this.a.getString(2131902466), false, 12);
                    CommonDialog.a.e(r14, new p(), this.a.getString(2131902465), 4);
                    a(r14.a(), this.a.getChildFragmentManager());
                    goto L12
                L9:
                    if (Intrinsics.areEqual(r10, j0.b.a) == false) goto L14;
                    int r16 = j49.a.a;
                    DoraBuryPointManager.a.L("dora_floating_window_show", MapsKt.mapOf(TuplesKt.to("window_content_type", "firmware_update_block_popup_batt")));
                    CommonDialog.a r17 = new CommonDialog.a();
                    int r18 = com.larus.utils.j0.a;
                    r17.i(com.larus.utils.j0.d(2131903823));
                    r17.g(com.larus.utils.j0.d(2131903822));
                    CommonDialog.a.f(r17, new q(), this.a.getString(2131902466), false, 12);
                    CommonDialog.a.e(r17, new r(), this.a.getString(2131902465), 4);
                    a(r17.a(), this.a.getChildFragmentManager());
                    goto L12
                L14:
                    throw new NoWhenBranchMatchedException();
                }
            }

            public AnonymousClass1(DoraOTAFragment r1, Continuation<? super AnonymousClass1> r2) {
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

        public AnonymousClass3(DoraOTAFragment r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
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
            DoraOTAFragment r7 = this.this$0;
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

    public final DoraOTAViewModel W90() {
        return (DoraOTAViewModel) this.g.getValue();
    }

    public DoraOTAFragment() {
        final Function0<Fragment> r0 = new DoraOTAFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraOTAViewModel.class), new DoraOTAFragment$special$$inlined$viewModels$default$2(r0), new DoraOTAFragment$special$$inlined$viewModels$default$3(r0, this));
        this.h = LazyKt.lazy(new k(this));
    }

    public final void onResume() {
        super.onResume();
    }

    public final String X90(z39.a r8) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return "";
    L5:
        List<OTAUpdatePackage> r9 = r8.b();
        if (r9 == null) goto L22;
        List r10 = CollectionsKt.filterNotNull(r9);
        if (r10 == null) goto L22;
        OTAUpdatePackage r11 = (OTAUpdatePackage) CollectionsKt.firstOrNull(r10);
        if (r11 == null) goto L22;
        Integer r1 = r11.getSize();
        if (r1 == null) goto L15;
        int r2 = r1.intValue();
    L17:
        if (r2 > 102400) goto L19;
        String r3 = "0.1";
    L21:
        return r0.getString(2131903819, new Object[]{r11.getVersion()}) + '\n' + r0.getString(2131903818, new Object[]{r3 + " MB"});
    L19:
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        r3 = String.format(Locale.CHINA, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf((r2 / 1024.0f) / 1024.0f)}, 1));
        goto L21
    L15:
        r2 = 0;
    L22:
        return "";
    }

    public final void Y90(MarkdownTextView r5, OTAUpdateMeta r6) {
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
        r0 = gw8.c.b.b(r4, r5, r1, false, (lw8.d) this.h.getValue());
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

    public final void aa0(z39.a r4, int r5) {
        if (DoraOTAManagement.H == true) goto L5;
        return;
    L5:
        LarusDoraPageOtaBinding r0 = this.f;
        if (r0 == null) goto L9;
        e1.o(r0.j);
        e1.o(r0.n);
        e1.x(r0.p);
        r0.o.setText(X90(r4));
        Y90(r0.q, r4.a());
        e1.x(r0.e);
        e1.o(r0.c);
        e1.x(r0.g);
        r0.f.setProgress(r5);
        TextView r6 = r0.h;
        StringBuilder r1 = new StringBuilder();
        r1.append(r5);
        r1.append('%');
        r6.setText(r1.toString());
        return;
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r14, r15);
        LarusDoraPageOtaBinding r16 = this.f;
        if (r16 == null) goto L5;
        NovaTitleBarEx r0 = r16.r;
        NovaTitleBarEx.Y5(r0, getString(2131903828), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new h(this), 14);
    L5:
        Lifecycle.State r17 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraOTAFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r17, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass3(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraOTAFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r17, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraOTAFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r17, null, this), 3, null);
        LarusDoraPageOtaBinding r18 = this.f;
        if (r18 == null) goto L12;
        ItemTextToggle r110 = r18.b;
        if (r110 == null) goto L12;
        CustomSwitchCompat r111 = r110.getToggleView();
        if (r111 == null) goto L12;
        r111.setOnCheckedChangeListener(new i(this));
    L12:
        W90().loadAutoOTASwitch();
        if (DoraOTAManagement.H == false) goto L15;
    L19:
        DoraOTAManagement.n();
        return;
    L15:
        if ((DoraOTAManagement.f.getValue() instanceof c$f) == false) goto L19;
        c$c r112 = DoraOTAManagement.I;
        if (r112 == null) goto L21;
        Z90(r112.a, r112.b, r112.c);
        return;
    }

    public final void Z90(final z39.a r6, String r7, String r8) {
        LarusDoraPageOtaBinding r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r8 != null) goto L7;
    L10:
        boolean r9 = true;
    L12:
        if (r9 == true) goto L16;
        if (r6 == null) goto L16;
        e1.o(r0.j);
        e1.o(r0.n);
        e1.x(r0.p);
        r0.o.setText(X90(r6));
        Y90(r0.q, r6.a());
        e1.x(r0.e);
        e1.x(r0.c);
        e1.x(r0.d);
        r0.d.setText(getString(2131903814, new Object[]{"v" + r7}));
        e1.x(r0.i);
        e1.d(r0.i, new l(r6, this));
        e1.o(r0.g);
        return;
    L16:
        e1.o(r0.j);
        e1.x(r0.n);
        r0.n.setText(getString(2131903821, new Object[]{"v" + r7}));
        e1.o(r0.p);
        e1.o(r0.e);
        return;
    L7:
        if (r8.length() == 0) goto L10;
        r9 = false;
        goto L12
    }

    public final View onCreateView(LayoutInflater r23, ViewGroup r24, Bundle r25) {
        Intrinsics.checkNotNullParameter(r23, "inflater");
        ConstraintLayout r0 = r23.inflate(2131562284, r24, false);
        int r1 = 2131369426;
        if (ViewBindings.findChildViewById(r0, 2131369426) == null) goto L43;
        r1 = 2131369427;
        ItemTextToggle r5 = ViewBindings.findChildViewById(r0, 2131369427);
        if (r5 == null) goto L43;
        r1 = 2131381688;
        ConstraintLayout r6 = ViewBindings.findChildViewById(r0, 2131381688);
        if (r6 == null) goto L43;
        r1 = 2131381692;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r0, 2131381692);
        if (r7 == null) goto L43;
        r1 = 2131381693;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131381693);
        if (r8 == null) goto L43;
        r1 = 2131381696;
        ProgressBar r9 = (ProgressBar) ViewBindings.findChildViewById(r0, 2131381696);
        if (r9 == null) goto L43;
        r1 = 2131381697;
        ConstraintLayout r10 = ViewBindings.findChildViewById(r0, 2131381697);
        if (r10 == null) goto L43;
        r1 = 2131381698;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r0, 2131381698);
        if (r11 == null) goto L43;
        r1 = 2131381699;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131381699)) == null) goto L43;
        r1 = 2131381705;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r0, 2131381705);
        if (r12 == null) goto L43;
        r1 = 2131381710;
        LinearLayoutCompat r13 = ViewBindings.findChildViewById(r0, 2131381710);
        if (r13 == null) goto L43;
        r1 = 2131381711;
        ProgressBar r14 = (ProgressBar) ViewBindings.findChildViewById(r0, 2131381711);
        if (r14 == null) goto L43;
        r1 = 2131381712;
        ImageView r15 = (ImageView) ViewBindings.findChildViewById(r0, 2131381712);
        if (r15 == null) goto L43;
        r1 = 2131381713;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r0, 2131381713);
        if (r16 == null) goto L43;
        r1 = 2131381714;
        AppCompatTextView r17 = ViewBindings.findChildViewById(r0, 2131381714);
        if (r17 == null) goto L43;
        r1 = 2131381719;
        AppCompatTextView r18 = ViewBindings.findChildViewById(r0, 2131381719);
        if (r18 == null) goto L43;
        r1 = 2131381721;
        ScrollView r110 = (ScrollView) ViewBindings.findChildViewById(r0, 2131381721);
        if (r110 == null) goto L43;
        r1 = 2131381722;
        MarkdownTextView r20 = ViewBindings.findChildViewById(r0, 2131381722);
        if (r20 == null) goto L43;
        r1 = 2131388772;
        NovaTitleBarEx r21 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r21 == null) goto L43;
        ConstraintLayout r2 = r0;
        this.f = new LarusDoraPageOtaBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21);
        return r2;
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
