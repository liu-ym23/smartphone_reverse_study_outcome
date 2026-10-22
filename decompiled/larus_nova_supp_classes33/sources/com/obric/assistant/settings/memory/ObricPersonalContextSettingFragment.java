package com.obric.assistant.settings.memory;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ObricFragmentPersonalContextSettingBinding;
import com.obric.assistant.permission.IObricPermissionService;
import com.obric.assistant.permission.IObricPermissionService$Companion;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.settings.ToggleName;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001VB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J$\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010-\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020+H\u0016J\u0010\u0010/\u001a\u00020+2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020+H\u0002J\u0010\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020!H\u0002J\u0010\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\u0013H\u0002J\u0010\u00107\u001a\u00020+2\u0006\u00108\u001a\u000209H\u0002J \u0010:\u001a\u00020+2\u0006\u00108\u001a\u0002092\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<H\u0002J(\u0010>\u001a\u00020+2\u0006\u00108\u001a\u0002092\u0006\u0010?\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<H\u0002J3\u0010@\u001a\u00020+2\u0006\u00108\u001a\u0002092\f\u0010A\u001a\b\u0012\u0004\u0012\u00020<0B2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0002\u0010CJ\u0010\u0010D\u001a\u00020+2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010E\u001a\u00020+2\u0006\u00108\u001a\u000209H\u0002J\b\u0010F\u001a\u00020+H\u0002J\b\u0010G\u001a\u00020\u0013H\u0002J\u0010\u0010H\u001a\u00020+2\u0006\u0010I\u001a\u00020\u0013H\u0002J\u000e\u0010J\u001a\b\u0012\u0004\u0012\u00020<0KH\u0002J\u0010\u0010L\u001a\u00020\u00132\u0006\u00108\u001a\u000209H\u0002J\b\u0010M\u001a\u00020\u0013H\u0016J\b\u0010N\u001a\u00020<H\u0016J \u0010O\u001a\u00020+2\u0006\u00108\u001a\u0002092\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<H\u0002J(\u0010P\u001a\u00020+2\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010R2\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010RH\u0002J\u0010\u0010T\u001a\u00020<2\u0006\u00108\u001a\u000209H\u0002J\u0012\u0010U\u001a\u0004\u0018\u00010<2\u0006\u00108\u001a\u000209H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b\u001d\u0010\u001e¨\u0006W"}, d2 = {"Lcom/obric/assistant/settings/memory/ObricPersonalContextSettingFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/obric/assistant/settings/ObricFloatingTitleBarProvider;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentPersonalContextSettingBinding;", "viewModel", "Lcom/obric/assistant/settings/memory/ObricPersonalContextSettingViewModel;", "getViewModel", "()Lcom/obric/assistant/settings/memory/ObricPersonalContextSettingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "aiLabService", "Lcom/obric/assistant/settings/IAILabService;", "getAiLabService", "()Lcom/obric/assistant/settings/IAILabService;", "aiLabService$delegate", "isObricOS", "", "personalContextSettingsDelegate", "Lcom/obric/assistant/settings/ObricPersonalContextSettingApiDelegate;", "getPersonalContextSettingsDelegate", "()Lcom/obric/assistant/settings/ObricPersonalContextSettingApiDelegate;", "personalContextSettingsDelegate$delegate", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "adapter", "Lcom/obric/assistant/settings/memory/ObricPersonalContextSettingAdapter;", "getAdapter", "()Lcom/obric/assistant/settings/memory/ObricPersonalContextSettingAdapter;", "adapter$delegate", "getFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "initRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "observeUiState", "initTopBar", "topBar", "handleLocalDataSearchToggleClick", "isChecked", "handleDataSourceClick", "toggleName", "Lcom/obric/assistant/settings/ToggleName;", "handleSystemPermissionClick", "title", "", "message", "handleSystemSinglePermissionClick", "manifest", "handleSystemMultiplePermissionsClick", "manifests", "", "(Lcom/obric/assistant/settings/ToggleName;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "jumpToPermissionDetailPage", "handleCustomPermissionClick", "tryBatchRequestInitPermissions", "shouldSkipLocalDataSearchInitPermissionRequest", "tryRequestMultiCustomPermission", "forceRefresh", "getTotalSystemPermissions", "", "isSystemPermissionAllowed", "autoLogEnterPage", "getCurrentPageName", "showCustomPermissionToggleDialog", "handleLocalDataSwitchOffRetentionDialog", "onConfirmDisable", "Lkotlin/Function0;", "onCancel", "getPermissionTitle", "getPermissionSubTitle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPersonalContextSettingFragment extends TraceFragment implements com.obric.assistant.settings.t {
    public static final /* synthetic */ int l = 0;
    public ObricFragmentPersonalContextSettingBinding e;
    public final Lazy f;
    public final Lazy g;
    public final boolean h;
    public final Lazy i;
    public final CoroutineScope j;
    public final Lazy k;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ToggleName.values().length];
            r0[ToggleName.CONTACTS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L65:
            r0[ToggleName.CALL_LOGS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L77:
            r0[ToggleName.MESSAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L47:
            r0[ToggleName.ALBUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L49:
            r0[ToggleName.CALENDAR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L59:
            r0[ToggleName.FILE_MANAGEMENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L71:
            r0[ToggleName.NOTES.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L53:
            r0[ToggleName.CLOCK.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L67:
            r0[ToggleName.RECORD.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
        L69:
            r0[ToggleName.COLLECTION_MEMORY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L34
        L45:
            r0[ToggleName.PERSONAL_INFO_MEMORY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L61:
            r0[ToggleName.EVENT_MEMORY.ordinal()] = 12;     // Catch: NoSuchFieldError -> L36
        L75:
            r0[ToggleName.SCREEN_MEMORY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L37
        L43:
            r0[ToggleName.AI_DIARY.ordinal()] = 14;     // Catch: NoSuchFieldError -> L38
        L51:
            r0[ToggleName.HEARING_MEMORY.ordinal()] = 15;     // Catch: NoSuchFieldError -> L39
        L73:
            r0[ToggleName.GLOBAL_MEMORY.ordinal()] = 16;     // Catch: NoSuchFieldError -> L40
        L20:
            a = r0;
            int[] r1 = new int[IObricPermissionService$Companion.ObricPermissionStatus.values().length];
            r1[IObricPermissionService$Companion.ObricPermissionStatus.GRANTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L63:
            r1[IObricPermissionService$Companion.ObricPermissionStatus.LIMITED_GRANTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L23:
            b = r1;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(u r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "personal_context_setting";
    }

    public final ObricPersonalContextSettingApiDelegate U90() {
        return (ObricPersonalContextSettingApiDelegate) this.i.getValue();
    }

    public final ObricPersonalContextSettingViewModel V90() {
        return (ObricPersonalContextSettingViewModel) this.f.getValue();
    }

    @Override // com.obric.assistant.settings.t
    public final OFloatingTitleBar gW() {
        if (this.h == true) goto L5;
        return null;
    L5:
        ObricFragmentPersonalContextSettingBinding r0 = this.e;
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.c;
    }

    public final void onDestroyView() {
        ObricFragmentPersonalContextSettingBinding r0 = this.e;
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.b;
        if (r1 == null) goto L7;
        r1.setAdapter(null);
    L7:
        this.e = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public ObricPersonalContextSettingFragment() {
        final Function0<Fragment> r0 = new ObricPersonalContextSettingFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ObricPersonalContextSettingViewModel.class), new ObricPersonalContextSettingFragment$special$$inlined$viewModels$default$2(r0), new ObricPersonalContextSettingFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = LazyKt.lazy(new o());
        this.h = t9a.b.a().b();
        this.i = LazyKt.lazy(new p());
        this.j = CoroutineScopeKt.MainScope();
        this.k = LazyKt.lazy(new q(this));
    }

    public final void onResume() {
        super.onResume();
        V90().refresh();
    }

    public final void W90(ToggleName r12) {
        List r0 = com.obric.assistant.settings.i.a(r12);
        int r1 = r0.size();
        if (r1 == 0) goto L64;
        int r2 = 0;
        if (r1 == 1) goto L46;
        String[] r3 = (String[]) r0.toArray(new String[0]);
        switch(b.a[r12.ordinal()]) {
            case 1: goto L21;
            case 2: goto L21;
            case 3: goto L21;
            case 4: goto L9;
            case 5: goto L21;
            case 6: goto L21;
            default: goto L22;
        };
    L9:
        IObricPermissionService r4 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r4 == null) goto L12;
        IObricPermissionService$Companion.ObricPermissionStatus r5 = r4.h();
    L13:
        if (r5 != null) goto L15;
        int r6 = -1;
    L16:
        if (r6 != 1) goto L18;
    L20:
        boolean r7 = true;
    L23:
        if (r7 == false) goto L25;
        X90(r12);
        return;
    L25:
        FragmentActivity r8 = getActivity();
        if (r8 == null) goto L66;
        int r9 = r3.length;
        boolean r10 = false;
    L28:
        if (r2 >= r9) goto L33;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r8, r3[r2]) == false) goto L32;
        r10 = true;
    L32:
        r2 = r2 + 1;
        goto L28
    L33:
        FLogger.a.i("ObricPersonalContextSettingFragment", "handleSystemMultiplePermissionsClick, shouldShowRequest: " + r10);
        IObricPermissionService r11 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (ArraysKt.contains(r3, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == false) goto L40;
        if (r10 == false) goto L40;
        if (r11 == null) goto L38;
        r11.c();
    L38:
        if (r11 == null) goto L67;
        r11.j(this, r8, ArraysKt.toMutableList(r3), null, new s(this));
        return;
    L67:
        return;
    L40:
        if (r10 == false) goto L45;
        if (r11 == null) goto L43;
        r11.c();
    L43:
        if (r11 == null) goto L69;
        r11.a(r8, ArraysKt.toMutableList(r3), new j(this));
        return;
    L69:
        return;
    L45:
        X90(r12);
        return;
    L66:
        return;
    L18:
        if (r6 == 2) goto L20;
    L15:
        r6 = b.b[r5.ordinal()];
        goto L16
    L12:
        r5 = null;
        goto L13
    L21:
        r7 = U90().o(r12);
    L22:
        r7 = false;
        goto L23
    L46:
        String r13 = (String) ListProtector.get(r0, 0);
        if (Intrinsics.areEqual(r13, "android.permission.MANAGE_EXTERNAL_STORAGE") == false) goto L50;
        X90(r12);
        return;
    L50:
        if (U90().o(r12) == false) goto L52;
        X90(r12);
        return;
    L52:
        FragmentActivity r14 = getActivity();
        if (r14 == null) goto L74;
        boolean r15 = ActivityCompat.shouldShowRequestPermissionRationale(r14, r13);
        FLogger.a.i("ObricPersonalContextSettingFragment", "handleSystemSinglePermissionClick, shouldShowRequest: " + r15);
        if (r15 == false) goto L59;
        IObricPermissionService r16 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r16 == null) goto L75;
        r16.c();
        r16.a(r14, CollectionsKt.mutableListOf(new String[]{r13}), new e(this));
        return;
    L75:
        return;
    L59:
        X90(r12);
        return;
    L74:
        return;
    }

    public final void X90(ToggleName r4) {
        FLogger.a.i("ObricPersonalContextSettingFragment", "jumpToPermissionDetailPage, toggleName: " + r4);
        if (b.a[r4.ordinal()] != 6) goto L5;
        String r5 = "android.permission.MANAGE_EXTERNAL_STORAGE";
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L14;
        IObricPermissionService r1 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r1 == null) goto L15;
        r1.e(r0, CollectionsKt.listOf(r5), null);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r5 = (String) CollectionsKt.firstOrNull(com.obric.assistant.settings.i.a(r4));
        goto L6
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        ObricFragmentPersonalContextSettingBinding r12 = this.e;
        if (r12 == null) goto L18;
        OFloatingTitleBar r13 = r12.c;
        if (r13 != null) goto L8;
        return;
    L8:
        if (this.h == true) goto L10;
        NovaTitleBarEx r2 = rda.a.b(r13);
        NovaTitleBarEx.Y5(r2, getString(2131912174), null, null, 6);
        NovaTitleBarEx.b6(r2, 2131241477, false, null, null, new k(this), 14);
    L11:
        ObricFragmentPersonalContextSettingBinding r14 = this.e;
        if (r14 == null) goto L19;
        RecyclerView r15 = r14.b;
        if (r15 == null) goto L21;
        final Context r16 = requireContext();
        r15.setLayoutManager(new ObricPersonalContextSettingFragment$initRecyclerView$1(r16));
        r15.setAdapter((ObricPersonalContextSettingAdapter) this.k.getValue());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ObricPersonalContextSettingFragment$observeUiState$1(this, null), 3, null);
        return;
    L21:
        return;
    L19:
        return;
    L10:
        r13.setCenterTitle(2131912174);
        OFloatingTitleBar.k(r13, new l(this), 2);
        goto L11
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        ObricFragmentPersonalContextSettingBinding r4 = ObricFragmentPersonalContextSettingBinding.a(r1, r2);
        this.e = r4;
        ConstraintLayout r5 = r4.a;
        Intrinsics.checkNotNull(r5);
        r5.setTag(2131377847, this);
        return r5;
    }
}
