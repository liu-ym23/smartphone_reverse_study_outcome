package com.larus.dora.impl.device.settings.general;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextDescView;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.doc.sdk.impl.v2.plugins.snapshot.DocShotConsts;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraPageGeneralSettingsBinding;
import com.larus.dora.impl.device.settings.DoraUnbindBaseFragment;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0002J\u0018\u0010&\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/dora/impl/device/settings/general/GeneralSettingsFragment;", "Lcom/larus/dora/impl/device/settings/DoraUnbindBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageGeneralSettingsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/general/GeneralSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/general/GeneralSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "hasUplpad", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDoraConnectStateChanged", "isConnected", "getCurrentPageName", "", "getPageMaskView", "showContent", "state", "Lcom/larus/dora/impl/device/settings/general/GeneralSettingsState$Success;", "showRebootConfirmDialog", "showUnbindConfirmDialog", "title", "msg", "showResetFactoryConfirmDialog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GeneralSettingsFragment extends DoraUnbindBaseFragment {
    public static final /* synthetic */ int j = 0;
    public LarusDoraPageGeneralSettingsBinding g;
    public final Lazy h;
    public boolean i;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ GeneralSettingsFragment a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[IntentState.values().length];
                r0[IntentState.ACTION_SERVER_UNBIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[IntentState.ACTION_NO_DEVICE_CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[IntentState.ACTION_SERVER_UNBIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[IntentState.ACTION_SPP_DISCONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[IntentState.ACTION_UNBIND_SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        public b(GeneralSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r9, Continuation r10) {
            Pair r11 = (Pair) r9;
            int r12 = a.a[((IntentState) r11.getFirst()).ordinal()];
            boolean r0 = true;
            if (r12 != 1) goto L5;
            t19.s r13 = t19.s.a;
            Application r14 = AppHost.a.getApplication();
            r13.getClass();
            t19.s.b(r14, 2131908080, false);
        L59:
            return Unit.INSTANCE;
        L5:
            if (r12 != 2) goto L7;
        L56:
            t19.s r15 = t19.s.a;
            Application r16 = AppHost.a.getApplication();
            r15.getClass();
            t19.s.b(r16, 2131904036, false);
            goto L59
        L7:
            if (r12 == 3) goto L56;
            if (r12 == 4) goto L56;
            if (r12 != 5) goto L55;
            FragmentActivity r17 = this.a.getActivity();
            if (r17 == null) goto L59;
            DoraDevice r2 = (DoraDevice) r11.getSecond();
            Intent r3 = new Intent("action.DEVICE_UNBIND");
            r3.setPackage(r17.getPackageName());
            DoraDevice r4 = (DoraDevice) r11.getSecond();
            if (r4 == null) goto L17;
            String r5 = r4.mac;
        L19:
            if (TextUtils.isEmpty(r5) == true) goto L26;
            DoraDevice r18 = (DoraDevice) r11.getSecond();
            if (r18 == null) goto L24;
            String r20 = r18.mac;
            if (r20 == null) goto L24;
        L25:
            r3.putExtra("mac", r20);
        L24:
            r20 = "";
        L26:
            LocalBroadcastManager.getInstance(r17).sendBroadcast(r3);
            List r21 = DoraAdapterExtKt.k(kj4.a.g());
            ArrayList r6 = new ArrayList();
            Iterator<T> r22 = r21.iterator();
        L28:
            if (r22.hasNext() == false) goto L37;
            T r7 = r22.next();
            String r8 = ((DoraDevice) r7).mac;
            if (r2 == null) goto L32;
            String r23 = r2.mac;
        L34:
            if ((!Intrinsics.areEqual(r8, r23)) == false) goto L28;
            r6.add(r7);
            goto L28
        L32:
            r23 = null;
            goto L34
        L37:
            if (r6.isEmpty() == true) goto L48;
            Iterator r24 = r6.iterator();
        L41:
            if (r24.hasNext() == false) goto L48;
            if (((DoraDevice) r24.next()).productId != ProductNameType.DORA_G.id) goto L45;
            boolean r25 = true;
        L46:
            if (r25 == false) goto L41;
        L50:
            if (com.larus.dora.impl.util.s.a() == false) goto L53;
            if (r0 == false) goto L53;
            com.bytedance.router.i r26 = SmartRouter.buildRoute(r17, "//dora_g_device_management");
            r26.c.addFlags(335544320);
            r26.d();
        L53:
            r17.finish();
            goto L59
        L45:
            r25 = false;
        L48:
            r0 = false;
            goto L50
        L17:
            r5 = null;
            goto L19
        L55:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.GeneralSettingsFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.general.GeneralSettingsFragment$onViewCreated$2", f = "GeneralSettingsFragment.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GeneralSettingsFragment this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.GeneralSettingsFragment$onViewCreated$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.device.settings.general.GeneralSettingsFragment$onViewCreated$2$1", f = "GeneralSettingsFragment.kt", i = {}, l = {DocShotConsts.INPUT_VIEW_HEIGHT}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ GeneralSettingsFragment this$0;

            /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.GeneralSettingsFragment$onViewCreated$2$1$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ GeneralSettingsFragment a;

                public a(GeneralSettingsFragment r1) {
                    this.a = r1;
                }

                /* JADX WARN: Type inference failed for: r11v14, types: [android.view.View, android.widget.TextView, com.larus.dora.impl.view.DoraTextView] */
                public final Object emit(Object r11, Continuation r12) {
                    w r13 = (w) r11;
                    if (Intrinsics.areEqual(r13, w.a.a) == true) goto L94;
                    if ((r13 instanceof w.b) == false) goto L92;
                    final GeneralSettingsFragment r14 = this.a;
                    LarusDoraPageGeneralSettingsBinding r0 = r14.g;
                    boolean r2 = true;
                    if (r0 != null) goto L9;
                L30:
                    final GeneralSettingsFragment r15 = this.a;
                    w.b r16 = (w.b) r13;
                    final LarusDoraPageGeneralSettingsBinding r1 = r15.g;
                    if (r1 == null) goto L94;
                    final DoraDevice r4 = r16.b;
                    boolean r5 = o59.a.p(r4);
                    String r6 = o59.a.e(r4);
                    final ItemTextArrow r7 = r1.d;
                    if (r5 == false) goto L35;
                    String r8 = r15.getString(2131902649);
                L36:
                    Intrinsics.checkNotNull(r8);
                    r7.setText(r8);
                    String r17 = r16.e;
                    if (r17 != null) goto L39;
                L42:
                    boolean r18 = true;
                L43:
                    if (r18 == false) goto L45;
                    r7.U5();
                    r7.Z5(r6, null);
                    r7.setVisible(true);
                L46:
                    e1.d(r7, new h(r7, r4, r15));
                    ItemTextDescView r110 = r1.b;
                    r110.getTextView().setTextSize(0, i5.q());
                    r110.getDescView().setTextSize(0, i5.q());
                    r110.getDescView().setTextColor(ContextCompat.getColor(r110.getContext(), v19.c.b(2130972081, r110.getContext(), 2131103143)));
                    String r3 = "";
                    if (r5 == false) goto L66;
                    String r9 = r4.caseSoftVersion;
                    if (r9 != null) goto L51;
                L54:
                    boolean r10 = true;
                L55:
                    if (r10 == true) goto L66;
                    Intrinsics.checkNotNull(r110);
                    e1.x(r110);
                    r110.setText(r15.getString(2131902641));
                    Intrinsics.checkNotNullParameter(r4, "<this>");
                    String r20 = r4.caseSoftVersion;
                    if (r20 != null) goto L59;
                L62:
                    if (r2 == false) goto L64;
                    String r21 = "";
                L65:
                    r110.setDescText(r21);
                L67:
                    ItemTextDescView r111 = r1.f;
                    r111.getTextView().setTextSize(0, i5.q());
                    r111.getDescView().setTextSize(0, i5.q());
                    r111.getDescView().setTextColor(ContextCompat.getColor(r111.getContext(), v19.c.b(2130972081, r111.getContext(), 2131103143)));
                    if (r5 == false) goto L70;
                    r111.setText(r15.getString(2131902648));
                L71:
                    String r22 = r4.sn;
                    if (r22 == null) goto L75;
                    r3 = r22;
                L75:
                    r111.setDescText(r3);
                    e1.d(r111, new i(r1, r15));
                    AppCompatTextView r112 = r1.i;
                    if (r5 == false) goto L78;
                    r112.setText(2131902766);
                L79:
                    if (r5 == true) goto L81;
                    e1.o(r1.l);
                    e1.o(r1.m);
                L81:
                    AppCompatTextView r113 = r1.n;
                    Intrinsics.checkNotNull(r113);
                    e1.y(r113, r5);
                    if (r5 == false) goto L84;
                    e1.d(r113, new j(r15));
                L84:
                    AppCompatTextView r114 = r1.g;
                    Intrinsics.checkNotNull(r114);
                    e1.y(r114, r5);
                    if (r5 == false) goto L87;
                    r114.setText(2131902982);
                    e1.d(r114, new k(r15));
                L87:
                    final ?? r115 = r1.e;
                    if (r5 == false) goto L90;
                    int r116 = j0.a;
                    r115.setText(j0.d(2131902947));
                    e1.d(r115, new l(r115, r4));
                    goto L94
                L90:
                    r115.setText(2131902350);
                    e1.d(r115, new m(r15));
                    goto L94
                L78:
                    r112.setText(2131903373);
                    goto L79
                L70:
                    r111.setText(r15.getString(2131902452));
                    goto L71
                L64:
                    r21 = "v" + r4.caseSoftVersion;
                    goto L65
                L59:
                    if (r20.length() == 0) goto L62;
                    r2 = false;
                    goto L62
                L51:
                    if (r9.length() == 0) goto L54;
                    r10 = false;
                L66:
                    Intrinsics.checkNotNull(r110);
                    e1.o(r110);
                    goto L67
                L45:
                    r7.i6(r6);
                    goto L46
                L39:
                    if (r17.length() == 0) goto L42;
                    r18 = false;
                    goto L43
                L35:
                    r8 = r15.getString(2131903828);
                    goto L36
                L9:
                    if (r14.X90().isMultiDeviceEnable() == false) goto L14;
                    e1.x(r0.c);
                    e1.x(r0.i);
                    w.b r23 = (w.b) r13;
                    if (r0.h.getToggleView().isChecked() == r23.c) goto L13;
                    r0.h.getToggleView().setOnCheckedChangeListener(null);
                    r0.h.getToggleView().setChecked(r23.c);
                L13:
                    g49.d.d("GeneralSettingsFragment", "doraMultiDevicesSwitch: " + r23.c);
                    r0.h.getToggleView().setOnCheckedChangeListener(new n(r14));
                L15:
                    w.b r24 = (w.b) r13;
                    if (o59.a.p(r24.b) == true) goto L26;
                    DoraDevice r25 = r24.b;
                    if (r25 != null) goto L20;
                L22:
                    boolean r26 = false;
                L23:
                    if (r26 == true) goto L26;
                    e1.o(r0.l);
                    e1.o(r0.m);
                    goto L30
                L20:
                    if (r25.productId != ProductNameType.DORA_E.id) goto L22;
                    r26 = true;
                L26:
                    e1.x(r0.l);
                    e1.x(r0.m);
                    if (r0.k.getToggleView().isChecked() == r24.d) goto L29;
                    r0.k.getToggleView().setOnCheckedChangeListener(null);
                    r0.k.getToggleView().setChecked(r24.d);
                L29:
                    g49.d.d("GeneralSettingsFragment", "doraWearSensor: " + r24.d);
                    r0.k.getToggleView().setOnCheckedChangeListener(new o(r14));
                    goto L30
                L14:
                    e1.o(r0.c);
                    e1.o(r0.i);
                    goto L15
                L92:
                    throw new NoWhenBranchMatchedException();
                L94:
                    return Unit.INSTANCE;
                }
            }

            public AnonymousClass1(GeneralSettingsFragment r1, Continuation<? super AnonymousClass1> r2) {
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
                GeneralSettingsFragment r6 = this.this$0;
                int r2 = GeneralSettingsFragment.j;
                i1<w> r7 = r6.X90().getGeneralSettingsStateFlow();
                a r3 = new a(this.this$0);
                this.label = 1;
                if (r7.collect(r3, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass2(GeneralSettingsFragment r1, Continuation<? super AnonymousClass2> r2) {
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
            GeneralSettingsFragment r7 = this.this$0;
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
        return "general_setting";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageGeneralSettingsBinding r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j;
    }

    public final GeneralSettingsViewModel X90() {
        return (GeneralSettingsViewModel) this.h.getValue();
    }

    public GeneralSettingsFragment() {
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GeneralSettingsViewModel.class), new GeneralSettingsFragment$special$$inlined$activityViewModels$default$1(this), new GeneralSettingsFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onResume() {
        super.onResume();
        X90().loadGeneralSettings();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r1) {
        super.V90(r1);
        if (r1 == false) goto L6;
        X90().loadGeneralSettings();
        return;
    }

    @Override // com.larus.dora.impl.device.settings.DoraUnbindBaseFragment
    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r15);
        LarusDoraPageGeneralSettingsBinding r16 = this.g;
        if (r16 == null) goto L7;
        NovaTitleBarEx r0 = r16.o;
        if (r0 == null) goto L7;
        NovaTitleBarEx.Y5(r0, getString(2131902422), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new g(this), 14);
    L7:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(this, null), 3, null);
        Lifecycle.State r17 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new GeneralSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r17, null, this), 3, null);
    }

    public static void W90(CommonDialog r1, FragmentManager r2, String r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r1, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r1.show(r2, r3);
    }

    public final View onCreateView(LayoutInflater r20, ViewGroup r21, Bundle r22) {
        Intrinsics.checkNotNullParameter(r20, "inflater");
        ConstraintLayout r0 = r20.inflate(2131562265, r21, false);
        int r1 = 2131369462;
        ItemTextDescView r5 = ViewBindings.findChildViewById(r0, 2131369462);
        if (r5 == null) goto L37;
        r1 = 2131369485;
        if (ViewBindings.findChildViewById(r0, 2131369485) == null) goto L37;
        r1 = 2131369492;
        ItemGroup r6 = ViewBindings.findChildViewById(r0, 2131369492);
        if (r6 == null) goto L37;
        r1 = 2131369500;
        ItemTextArrow r7 = ViewBindings.findChildViewById(r0, 2131369500);
        if (r7 == null) goto L37;
        r1 = 2131369502;
        DoraTextView r8 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369502);
        if (r8 == null) goto L37;
        r1 = 2131369506;
        ItemTextDescView r9 = ViewBindings.findChildViewById(r0, 2131369506);
        if (r9 == null) goto L37;
        r1 = 2131369508;
        DoraTextView r10 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369508);
        if (r10 == null) goto L37;
        r1 = 2131369710;
        ItemTextToggle r11 = ViewBindings.findChildViewById(r0, 2131369710);
        if (r11 == null) goto L37;
        r1 = 2131369711;
        AppCompatTextView r12 = ViewBindings.findChildViewById(r0, 2131369711);
        if (r12 == null) goto L37;
        r1 = 2131369962;
        View r13 = ViewBindings.findChildViewById(r0, 2131369962);
        if (r13 == null) goto L37;
        r1 = 2131370044;
        ItemTextToggle r14 = ViewBindings.findChildViewById(r0, 2131370044);
        if (r14 == null) goto L37;
        r1 = 2131370045;
        ItemGroup r15 = ViewBindings.findChildViewById(r0, 2131370045);
        if (r15 == null) goto L37;
        r1 = 2131370046;
        AppCompatTextView r16 = ViewBindings.findChildViewById(r0, 2131370046);
        if (r16 == null) goto L37;
        r1 = 2131377267;
        DoraTextView r17 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131377267);
        if (r17 == null) goto L37;
        r1 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r0, 2131385238)) == null) goto L37;
        r1 = 2131388772;
        NovaTitleBarEx r18 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r18 == null) goto L37;
        ConstraintLayout r2 = r0;
        this.g = new LarusDoraPageGeneralSettingsBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
        return r2;
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
