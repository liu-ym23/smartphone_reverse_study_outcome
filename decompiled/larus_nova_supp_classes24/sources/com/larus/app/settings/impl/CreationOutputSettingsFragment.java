package com.larus.app.settings.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.app.settings.impl.databinding.LarusPageCreationOutputSettingsBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0002J\u0017\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/app/settings/impl/CreationOutputSettingsFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/app/settings/impl/databinding/LarusPageCreationOutputSettingsBinding;", "refreshJob", "Lkotlinx/coroutines/Job;", "currentStatus", "", "Ljava/lang/Integer;", "isPreloadingWatermarkConfig", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "autoLogEnterPage", "getCurrentPageName", "", "updateOutputSettingVisibility", "renderStatus", "status", "(Ljava/lang/Integer;)V", "openMaterialCompliancePage", "preloadWatermarkConfigAndRoute", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CreationOutputSettingsFragment extends TraceFragment {
    public static final /* synthetic */ int i = 0;
    public LarusPageCreationOutputSettingsBinding e;
    public Job f;
    public Integer g;
    public boolean h;

    /* JADX INFO: renamed from: com.larus.app.settings.impl.CreationOutputSettingsFragment$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.app.settings.impl.CreationOutputSettingsFragment$onResume$1", f = "CreationOutputSettingsActivity.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $userId;
        int label;
        final /* synthetic */ CreationOutputSettingsFragment this$0;

        public AnonymousClass1(String r1, CreationOutputSettingsFragment r2, Continuation<? super AnonymousClass1> r3) {
            this.$userId = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$userId, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r16) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            Integer r14 = null;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L25 CancellationException -> L27
            Object r2 = r16;
        L16:
            com.larus.network.http.y r3 = (com.larus.network.http.a) r2;     // Catch: Throwable -> L25 CancellationException -> L27
            if ((r3 instanceof com.larus.network.http.y) == false) goto L19;
            com.larus.network.http.y r4 = r3;     // Catch: Throwable -> L25 CancellationException -> L27
        L20:
            if (r4 == null) goto L30;
            t r5 = (t) ((com.larus.network.http.a) r4).b;     // Catch: Throwable -> L25 CancellationException -> L27
            if (r5 == null) goto L30;
            r14 = n.a(r5);     // Catch: Throwable -> L25 CancellationException -> L27
        L30:
            if (r14 == null) goto L41;
            if (Intrinsics.areEqual(AccountService.a.getUserId(), this.$userId) == false) goto L41;
            Lazy r6 = m.a;
            String r7 = this.$userId;
            int r8 = r14.intValue();
            Intrinsics.checkNotNullParameter(r7, "userId");
            if (StringsKt.isBlank(r7) == true) goto L38;
            ((SharedPreferences) m.a.getValue()).edit().putInt("portrait_auth_status_" + r7, r8).apply();
        L38:
            CreationOutputSettingsFragment r9 = this.this$0;
            int r10 = CreationOutputSettingsFragment.i;
            r9.U90(r14);
            return Unit.INSTANCE;
        L41:
            return Unit.INSTANCE;
        L19:
            r4 = null;
            goto L20
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r16);
            if (StringsKt.isBlank(this.$userId) == true) goto L12;
            JSONObject r11 = new JSONObject();     // Catch: Throwable -> L25 CancellationException -> L27
            this.label = 1;     // Catch: Throwable -> L25 CancellationException -> L27
            r2 = HttpExtKt.k("Social", t.class, "/creativity/user_config/get", r11, null, null, true, null, null, null, this, 944);     // Catch: Throwable -> L25 CancellationException -> L27
            if (r2 != r0) goto L16;
            return r0;
        L12:
            return Unit.INSTANCE;
        L27:
            e = move-exception;
            throw e;
        L25:
            th = move-exception;
            FLogger.a.w("CreationOutputSettings", "refresh material compliance status failed, msg=" + th.getMessage());
            goto L30
        }
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "creation_output_settings";
    }

    public final boolean V90() {
        boolean r1 = true;
        int r2 = 0;
        if (AccountService.a.isLogin().booleanValue() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        boolean r3 = !Intrinsics.areEqual(z2.a.watermarkRemovalConfig().a(), Boolean.FALSE);
        LarusPageCreationOutputSettingsBinding r4 = this.e;
        if (r4 == null) goto L16;
        ItemTextArrow r5 = r4.c;
        if (r5 == null) goto L16;
        if (r0 == false) goto L14;
        int r6 = 0;
    L15:
        r5.setVisibility(r6);
        goto L16
    L14:
        r6 = 8;
    L16:
        LarusPageCreationOutputSettingsBinding r7 = this.e;
        if (r7 == null) goto L24;
        ItemTextArrow r8 = r7.d;
        if (r8 == null) goto L24;
        if (r3 == false) goto L22;
        int r9 = 0;
    L23:
        r8.setVisibility(r9);
        goto L24
    L22:
        r9 = 8;
    L24:
        LarusPageCreationOutputSettingsBinding r10 = this.e;
        if (r10 == null) goto L36;
        ItemGroup r11 = r10.b;
        if (r11 == null) goto L36;
        if (r0 == true) goto L32;
        if (r3 == true) goto L32;
        r1 = false;
    L32:
        if (r1 == true) goto L35;
        r2 = 8;
    L35:
        r11.setVisibility(r2);
    L36:
        return r0;
    L5:
        if (z2.a.n2() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void onDestroyView() {
        Job r0 = this.f;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.e = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final void onResume() {
        super.onResume();
        if (V90() == true) goto L8;
        Job r0 = this.f;
        if (r0 == null) goto L13;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        return;
    L13:
        return;
    L8:
        String r1 = AccountService.a.getUserId();
        U90(m.a(r1));
        Job r3 = this.f;
        if (r3 == null) goto L11;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L11:
        this.f = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass1(r1, this, null), 3, null);
    }

    public CreationOutputSettingsFragment() {
    }

    public final void U90(Integer r3) {
        this.g = r3;
        if (r3 != null) goto L6;
    L8:
        String r4 = "aiCreation_uploadPermission_settings_outputs_permisssion_status_no";
    L9:
        LarusPageCreationOutputSettingsBinding r0 = this.e;
        if (r0 == null) goto L15;
        ItemTextArrow r1 = r0.c;
        if (r1 == null) goto L16;
        int r2 = j0.a;
        String r5 = j0.e(r4);
        int r6 = ItemTextArrow.k;
        r1.Z5(r5, null);
        return;
    L16:
        return;
    L15:
        return;
    L6:
        if (r3.intValue() != 1) goto L8;
        r4 = "aiCreation_uploadPermission_settings_outputs_permisssion_status_yes";
        goto L9
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        LarusPageCreationOutputSettingsBinding r13 = this.e;
        if (r13 != null) goto L5;
        return;
    L5:
        NovaTitleBarEx r14 = r13.e;
        int r0 = j0.a;
        NovaTitleBarEx.Y5(r14, j0.e("aiCreation_uploadPermission_settings_outputs"), null, null, 6);
        NovaTitleBarEx.b6(r13.e, 2131241477, false, null, null, new o(this), 14);
        r13.c.setText(j0.e("aiCreation_uploadPermission_settings_outputs_permisssion"));
        e1.d(r13.c, new p(this));
        ItemTextArrow r15 = r13.d;
        int r1 = c0.a;
        Context r2 = getContext();
        if (r2 == null) goto L9;
        String r3 = r2.getString(2131897438);
        if (r3 == null) goto L9;
    L10:
        r15.setText(r3);
        e1.d(r13.d, new q(this));
        if (V90() == false) goto L14;
        Lazy r16 = m.a;
        U90(m.a(AccountService.a.getUserId()));
        return;
    L14:
        return;
    L9:
        r3 = "";
        goto L10
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131563030, r8, false);
        int r11 = 2131379713;
        ItemGroup r2 = ViewBindings.findChildViewById(r10, 2131379713);
        if (r2 == null) goto L13;
        r11 = 2131379714;
        ItemTextArrow r3 = ViewBindings.findChildViewById(r10, 2131379714);
        if (r3 == null) goto L13;
        r11 = 2131384261;
        ItemTextArrow r4 = ViewBindings.findChildViewById(r10, 2131384261);
        if (r4 == null) goto L13;
        r11 = 2131388772;
        NovaTitleBarEx r5 = ViewBindings.findChildViewById(r10, 2131388772);
        if (r5 == null) goto L13;
        LinearLayout r12 = (LinearLayout) r10;
        this.e = new LarusPageCreationOutputSettingsBinding(r12, r2, r3, r4, r5);
        return r12;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
