package com.larus.drive.biz.impl.view;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.drive.biz.impl.databinding.LarusPageDriveMainBinding;
import com.larus.drive.biz.impl.view.fileselect.DriveSelectActionType;
import com.larus.drive.biz.impl.view.fileselect.DriveSelectPanelDialog;
import com.larus.drive.biz.impl.view.widget.DriveTagListView;
import com.larus.drive.biz.impl.viewmodel.DriveMainViewModel;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import tx9.a1;
import tx9.i3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002!$\u0018\u0000 _2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002_`B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J\b\u0010+\u001a\u00020'H\u0016J\u0012\u0010,\u001a\u00020'2\b\u0010-\u001a\u0004\u0018\u00010)H\u0016J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u00104\u001a\u00020'H\u0002J\u0010\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u001dH\u0016J\b\u00107\u001a\u00020'H\u0016J\u0016\u00108\u001a\u00020'2\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0016J\u001e\u0010<\u001a\u00020'2\u0006\u0010=\u001a\u00020>2\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0016J\u0016\u0010?\u001a\u00020'2\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0002J\b\u0010@\u001a\u00020'H\u0002J\u0010\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020/H\u0002J\b\u0010C\u001a\u00020'H\u0002J\b\u0010D\u001a\u00020'H\u0002J\u0010\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020\u0019H\u0002J\u001c\u0010G\u001a\u00020'2\b\b\u0002\u0010F\u001a\u00020\u00192\b\b\u0002\u0010H\u001a\u00020\u0010H\u0002J\b\u0010I\u001a\u00020'H\u0002J\u001a\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u00020/2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010L\u001a\u00020'H\u0016J\b\u0010M\u001a\u00020'H\u0016J\b\u0010N\u001a\u00020'H\u0016J\b\u0010O\u001a\u00020'H\u0016J\b\u0010P\u001a\u00020'H\u0016J\b\u0010Q\u001a\u00020\u0015H\u0016J\u0010\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020\u0015H\u0002J\b\u0010V\u001a\u00020\u0019H\u0016J\u0012\u0010W\u001a\u00020'2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010X\u001a\u00020'2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010Y\u001a\u0004\u0018\u00010\u0015J\b\u0010Z\u001a\u00020'H\u0016J \u0010[\u001a\u00020'2\u0006\u0010\\\u001a\u00020\u00102\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010^H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006a"}, d2 = {"Lcom/larus/drive/biz/impl/view/DriveMainFragment;", "Lcom/larus/bmhome/BaseHomeTabFragment;", "Lcom/larus/common_ui/tab/TabChildFragment;", "Lcom/larus/bmhome/ISideBarChildFragment;", "Lcom/larus/drive/biz/impl/view/fileselect/IDrivePageSelectMode;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusPageDriveMainBinding;", "viewModel", "Lcom/larus/drive/biz/impl/viewmodel/DriveMainViewModel;", "getViewModel", "()Lcom/larus/drive/biz/impl/viewmodel/DriveMainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isFromOnCreate", "", "isSideBar", "()Z", "isSideBar$delegate", "previousPage", "", "tabPagerAdapter", "Lcom/larus/drive/biz/impl/view/DriveMainFragment$DriveTabPagerAdapter;", "lastSelectedIndex", "", "isDriveTabActive", "isSelectMode", "selectOwner", "Lcom/larus/drive/biz/impl/view/AbsDriveListFragment;", "selectModeBackCallback", "Landroidx/activity/OnBackPressedCallback;", "logPageChangeCallback", "com/larus/drive/biz/impl/view/DriveMainFragment$logPageChangeCallback$1", "Lcom/larus/drive/biz/impl/view/DriveMainFragment$logPageChangeCallback$1;", "tabSyncPageChangeCallback", "com/larus/drive/biz/impl/view/DriveMainFragment$tabSyncPageChangeCallback$1", "Lcom/larus/drive/biz/impl/view/DriveMainFragment$tabSyncPageChangeCallback$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "autoLogEnterPage", "logEnterPage", "onNewIntent", "bundle", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupTitleBar", "enterSelectMode", "owner", "exitSelectMode", "updateSelectedFiles", "selectedFiles", "", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "onSelectPanelActionClick", "actionType", "Lcom/larus/drive/biz/impl/view/fileselect/DriveSelectActionType;", "showSelectPanelDialog", "dismissSelectPanelDialog", "showMoreActionMenu", "anchor", "setupViewPager", "setupTabLayout", "bindHostCallback", "position", "activateCurrentListFragment", "forbidLoadingAnim", "setupUploadBanner", "onViewCreated", "view", "onResume", "onPause", "onStop", "onDestroyView", "onDestroy", "getCurrentPageName", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "getEnterFrom", "tabIndex", "onEnterTab", "onFirstEnterTab", "getPreviousPage", "onLeaveTab", "onTabClick", "doubleClick", "callback", "Lkotlin/Function0;", "Companion", "DriveTabPagerAdapter", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMainFragment extends BaseHomeTabFragment implements s19.a, com.larus.bmhome.z, o79.g {
    public static WeakReference<DriveMainFragment> w;
    public LarusPageDriveMainBinding j;
    public final Lazy k;
    public boolean l;
    public final Lazy m;
    public String n;
    public b o;
    public int p;
    public boolean q;
    public boolean r;
    public AbsDriveListFragment s;
    public AnonymousClass1 t;
    public final DriveMainFragment$logPageChangeCallback$1 u;
    public final DriveMainFragment$tabSyncPageChangeCallback$1 v;

    public static final class a {
        public static DriveMainFragment a() {
            WeakReference<DriveMainFragment> r0 = DriveMainFragment.w;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get();
        }
    }

    public final class b extends FragmentStateAdapter {
        public final Lazy a;
        public final Lazy b;

        public final int getItemCount() {
            return 2;
        }

        public b(Fragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            super(r2);
            this.a = LazyKt.lazy(new n0());
            this.b = LazyKt.lazy(new o0());
        }

        public final Fragment createFragment(int r4) {
            if (r4 == 0) goto L9;
            if (r4 != 1) goto L7;
            return (DriveMineListFragment) this.b.getValue();
        L7:
            throw new IllegalArgumentException("Invalid position: " + r4);
        L9:
            return (DriveRecentListFragment) this.a.getValue();
        }

        public final AbsDriveListFragment y2(int r2) {
            if (r2 == 0) goto L8;
            if (r2 == 1) goto L10;
            return null;
        L10:
            return (DriveMineListFragment) this.b.getValue();
        L8:
            return (DriveRecentListFragment) this.a.getValue();
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(e0 r2) {
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

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.drive.biz.impl.view.DriveMainFragment$logPageChangeCallback$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.drive.biz.impl.view.DriveMainFragment$tabSyncPageChangeCallback$1] */
    public DriveMainFragment() {
        super(false);
        final Function0<Fragment> r0 = new DriveMainFragment$special$$inlined$viewModels$default$1(this);
        this.k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DriveMainViewModel.class), new DriveMainFragment$special$$inlined$viewModels$default$2(r0), new DriveMainFragment$special$$inlined$viewModels$default$3(r0, this));
        this.m = LazyKt.lazy(new l0(this));
        this.u = new DriveMainFragment$logPageChangeCallback$1();
        this.v = new DriveMainFragment$tabSyncPageChangeCallback$1(this);
    }

    public final boolean S90() {
        return false;
    }

    @Override // s19.a
    public final void a2(Bundle r1) {
    }

    public final String k() {
        return "ai_space_list";
    }

    public final void T90() {
        if (((Boolean) this.m.getValue()).booleanValue() == false) goto L5;
        String r0 = "click_navigation_cell";
    L6:
        a1.c(null, null, null, null, null, null, null, null, r0, null, null, null, null, null, null, "ai_space_list", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this, null, null, null, null, null, null, null, -525313, -16777217, 7);
        return;
    L5:
        r0 = "click_tab";
        goto L6
    }

    public final DriveMainViewModel Z90() {
        return (DriveMainViewModel) this.k.getValue();
    }

    public final void aa0() {
        LarusPageDriveMainBinding r0 = this.j;
        if (r0 == null) goto L12;
        final NovaTitleBarEx r1 = r0.b;
        if (r1 == null) goto L13;
        e1.o(r1.getBinding().e);
        r1.getBinding().j.setVisibility(8);
        if (((Boolean) this.m.getValue()).booleanValue() == false) goto L10;
        NovaTitleBarEx.b6(r1, 2131241256, false, ImageView.ScaleType.CENTER_INSIDE, null, new h0(this), 10);
    L10:
        NovaTitleBarEx.k6(r1, 2131241255, 0.0f, null, null, new i0(this), 30);
        i3.b(null, null, null, null, null, "space", null, this, 95);
        NovaTitleBarEx.i6(r1, 2131241254, null, null, new j0(this, r1), 14);
        return;
    L13:
        return;
    }

    public final String b() {
        String r0 = this.n;
        if (r0 != null) goto L9;
        Bundle r1 = getArguments();
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getString(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE);
    L9:
        return r0;
    }

    @Override // o79.g
    public final void j() {
        if (this.r == true) goto L5;
        return;
    L5:
        this.r = false;
        AnonymousClass1 r1 = this.t;
        if (r1 == null) goto L8;
        r1.setEnabled(false);
    L8:
        DriveSelectPanelDialog r0 = getChildFragmentManager().findFragmentByTag("DriveSelectPanelDialog");
        if ((r0 instanceof DriveSelectPanelDialog) == false) goto L11;
        DriveSelectPanelDialog r2 = r0;
    L12:
        if (r2 != null) goto L37;
    L19:
        com.larus.bmhome.a0 r3 = com.larus.bmhome.b0.a(this);
        if (r3 == null) goto L22;
        r3.ED(!this.r, "drive select mode");
    L22:
        LarusPageDriveMainBinding r4 = this.j;
        if (r4 == null) goto L27;
        ViewPager2 r5 = r4.j;
        if (r5 == null) goto L27;
        r5.setUserInputEnabled(true);
    L27:
        LarusPageDriveMainBinding r6 = this.j;
        if (r6 == null) goto L32;
        DriveTagListView r7 = r6.c;
        if (r7 == null) goto L32;
        e1.x(r7);
    L32:
        AbsDriveListFragment r8 = this.s;
        this.s = null;
        if (r8 == null) goto L35;
        r8.j();
    L35:
        aa0();
        return;
    L37:
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L19;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L19
    L11:
        r2 = null;
        goto L12
    }

    public final void onDestroy() {
        FLogger.a.i("DriveMainFragment", "[onDestroy]");
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        WeakReference<DriveMainFragment> r0 = w;
        if (r0 == null) goto L5;
        DriveMainFragment r1 = r0.get();
    L7:
        if (Intrinsics.areEqual(r1, this) == false) goto L10;
        w = null;
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void onDestroyView() {
        LarusPageDriveMainBinding r0 = this.j;
        if (r0 == null) goto L5;
        ViewPager2 r1 = r0.j;
    L6:
        if (r1 == null) goto L8;
        r1.unregisterOnPageChangeCallback(this.u);
    L8:
        if (r1 == null) goto L10;
        r1.unregisterOnPageChangeCallback(this.v);
    L10:
        if (r1 == null) goto L12;
        r1.setAdapter(null);
    L12:
        Z90().getUploadTasks().removeObservers(getViewLifecycleOwner());
        this.j = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onPause() {
        FLogger.a.i("DriveMainFragment", "[onPause]");
        this.l = false;
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public final void onStop() {
        FLogger.a.i("DriveMainFragment", "[onStop]");
        super/*androidx.fragment.app.Fragment*/.onStop();
    }

    @Override // s19.a
    public final int sb() {
        return BaseHomeTabFragment.MainTab.Drive.getIndex();
    }

    @Override // s19.a
    public final void t1() {
        FLogger.a.i("DriveMainFragment", "onLeaveTab");
        this.q = false;
    }

    public final void onResume() {
        super.onResume();
        FLogger.a.i("DriveMainFragment", "[onResume] isFromOnCreate: " + this.l);
        this.l = true;
        DriveMainViewModel r0 = Z90();
        JSONObject r1 = new JSONObject();
        r1.put("current_page", "ai_space_list");
        r1.put(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, b());
        r0.setEventParams(r1);
        Z90().onResume();
    }

    @Override // o79.g
    public final void F70(List<DriveFileItem> r6) {
        Intrinsics.checkNotNullParameter(r6, "selectedFiles");
        if (r6.isEmpty() == false) goto L6;
        j();
        return;
    L6:
        FragmentManager r1 = getChildFragmentManager();
        DriveSelectPanelDialog r3 = r1.findFragmentByTag("DriveSelectPanelDialog");
        if ((r3 instanceof DriveSelectPanelDialog) == false) goto L9;
        DriveSelectPanelDialog r4 = r3;
    L10:
        if (r4 == null) goto L12;
        Intrinsics.checkNotNullParameter(r6, "selectedFiles");
        r4.f = r6;
        r4.S90();
        return;
    L12:
        DriveSelectPanelDialog r5 = new DriveSelectPanelDialog();
        r5.setArguments(new Bundle());
        Intrinsics.checkNotNullParameter(r6, "selectedFiles");
        r5.f = r6;
        r5.S90();
        if (r1.isStateSaved() == false) goto L19;
        FragmentTransaction r7 = r1.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "DriveSelectPanelDialog", 0) == true) goto L18;
        r7 = r7.add(r5, "DriveSelectPanelDialog");
    L18:
        r7.commitAllowingStateLoss();
        return;
    L19:
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r5, "DriveSelectPanelDialog", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, r5, r8) == true) goto L30;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L23:
        r5.show(r1, "DriveSelectPanelDialog");
        return;
    L30:
        return;
    L9:
        r4 = null;
        goto L10
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        com.larus.trace.tracknode.a.a.a(this, r3);
        String r0 = b();
        if (r0 == null) goto L6;
        r3.put(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r0);
        return;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.activity.OnBackPressedCallback, com.larus.drive.biz.impl.view.DriveMainFragment$onCreate$1] */
    public final void onCreate(Bundle r4) {
        FLogger.a.i("DriveMainFragment", "[onCreate]");
        super/*com.larus.trace.tracknode.TraceFragment*/.onCreate(r4);
        w = new WeakReference(this);
        ?? r5 = new AnonymousClass1(this);
        requireActivity().getOnBackPressedDispatcher().addCallback(this, r5);
        this.t = r5;
    }

    @Override // o79.g
    public final void pg(AbsDriveListFragment r4) {
        Intrinsics.checkNotNullParameter(r4, "owner");
        if (this.r == false) goto L5;
        return;
    L5:
        this.r = true;
        this.s = r4;
        AnonymousClass1 r5 = this.t;
        if (r5 == null) goto L8;
        r5.setEnabled(true);
    L8:
        com.larus.bmhome.a0 r6 = com.larus.bmhome.b0.a(this);
        if (r6 == null) goto L11;
        r6.ED(true ^ this.r, "drive select mode");
    L11:
        LarusPageDriveMainBinding r7 = this.j;
        if (r7 == null) goto L16;
        ViewPager2 r8 = r7.j;
        if (r8 == null) goto L16;
        r8.setUserInputEnabled(false);
    L16:
        LarusPageDriveMainBinding r9 = this.j;
        if (r9 == null) goto L21;
        DriveTagListView r10 = r9.c;
        if (r10 == null) goto L21;
        e1.o(r10);
    L21:
        LarusPageDriveMainBinding r11 = this.j;
        if (r11 == null) goto L28;
        NovaTitleBarEx r12 = r11.b;
        if (r12 == null) goto L29;
        String r0 = getString(R.string.cancel);
        View.OnClickListener r1 = new k0(this);
        int r2 = NovaTitleBarEx.d;
        r12.c6(r0, null, r1);
        NovaTitleBarEx.Y5(r12, getString(2131900819), null, null, 6);
        r12.R5();
        e1.o(r12.getBinding().g);
        e1.o(r12.getBinding().h);
        return;
    L29:
        return;
    }

    public final void pp(String r4) {
        FLogger.a.i("DriveMainFragment", "onFirstEnterTab");
        this.n = r4;
        this.q = true;
        LarusPageDriveMainBinding r0 = this.j;
        if (r0 == null) goto L7;
        ViewPager2 r1 = r0.j;
        if (r1 == null) goto L7;
        int r2 = r1.getCurrentItem();
    L8:
        Y90(r2, true);
        return;
    L7:
        r2 = this.p;
        goto L8
    }

    @Override // s19.a
    public final void y2(String r4) {
        FLogger.a.i("DriveMainFragment", "onEnterTab");
        if (r4 == null) goto L5;
        this.n = r4;
    L5:
        this.q = true;
        LarusPageDriveMainBinding r0 = this.j;
        if (r0 == null) goto L10;
        ViewPager2 r1 = r0.j;
        if (r1 == null) goto L10;
        int r2 = r1.getCurrentItem();
    L11:
        Y90(r2, true);
        return;
    L10:
        r2 = this.p;
        goto L11
    }

    @Override // s19.a
    public final void KC(boolean r3, Function0<Unit> r4) {
        FLogger.a.i("DriveMainFragment", "onTabClick doubleClick[" + r3 + ']');
        LarusPageDriveMainBinding r5 = this.j;
        if (r5 == null) goto L13;
        ViewPager2 r6 = r5.j;
        if (r6 == null) goto L14;
        int r7 = r6.getCurrentItem();
        b r8 = this.o;
        if (r8 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("tabPagerAdapter");
        r8 = null;
    L9:
        AbsDriveListFragment r9 = r8.y2(r7);
        if (r9 == null) goto L15;
        r9.ea0();
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // o79.g
    public final void SC(DriveSelectActionType r2, List<DriveFileItem> r3) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r3, "selectedFiles");
        AbsDriveListFragment r4 = this.s;
        if (r4 == null) goto L6;
        r4.X90(r2);
        return;
    }

    public final void Y90(int r6, boolean r7) {
        b r0 = this.o;
        b r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabPagerAdapter");
        r0 = null;
    L5:
        AbsDriveListFragment r2 = r0.y2(r6);
        if (r2 == null) goto L9;
        Z90().setHostCallback(new p0(r2, this));
    L9:
        b r3 = this.o;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("tabPagerAdapter");
    L13:
        AbsDriveListFragment r8 = r1.y2(r6);
        if (r8 == null) goto L17;
        r8.ba0(r7);
        return;
    L17:
        return;
    L12:
        r1 = r3;
        goto L13
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        FLogger r0 = FLogger.a;
        r0.i("DriveMainFragment", "[onViewCreated]");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        if (((Boolean) this.m.getValue()).booleanValue() == false) goto L23;
        LarusPageDriveMainBinding r9 = this.j;
        if (r9 == null) goto L24;
        ConstraintLayout r10 = r9.a;
        if (r10 == null) goto L25;
        FragmentActivity r11 = getContext();
        FragmentActivity r2 = null;
        if ((r11 instanceof FragmentActivity) == false) goto L11;
        FragmentActivity r12 = r11;
    L12:
        int r1 = 0;
        if (r12 == null) goto L15;
        int r13 = com.larus.utils.u.c(r12);
    L16:
        Context r3 = getContext();
        if ((r3 instanceof FragmentActivity) == false) goto L19;
        r2 = (FragmentActivity) r3;
    L19:
        if (r2 == null) goto L21;
        r1 = com.larus.utils.u.b(r2);
    L21:
        int r4 = r10.getPaddingStart();
        int r5 = r10.getPaddingEnd();
        r0.i("updatePaddingRelative", "view:" + r10.getClass().getSimpleName() + ",source:,start:" + r4 + ",top:" + r13 + ",end:" + r5 + ",bottom:" + r1);
        r10.setPaddingRelative(r4, r13, r5, r1);
        return;
    L15:
        r13 = 0;
        goto L16
    L11:
        r12 = null;
        goto L12
    L25:
        return;
    L24:
        return;
    }

    /* JADX WARN: Type inference failed for: r15v13, types: [com.larus.drive.biz.impl.view.e0] */
    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        ConstraintLayout r16 = r13.inflate(2131563039, r14, false);
        int r17 = 2131377289;
        NovaTitleBarEx r3 = ViewBindings.findChildViewById(r16, 2131377289);
        if (r3 == null) goto L61;
        r17 = 2131377309;
        DriveTagListView r4 = (DriveTagListView) ViewBindings.findChildViewById(r16, 2131377309);
        if (r4 == null) goto L61;
        r17 = 2131377326;
        CardView r5 = ViewBindings.findChildViewById(r16, 2131377326);
        if (r5 == null) goto L61;
        r17 = 2131377327;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r16, 2131377327);
        if (r6 == null) goto L61;
        r17 = 2131377328;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r16, 2131377328);
        if (r7 == null) goto L61;
        r17 = 2131377329;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r16, 2131377329);
        if (r8 == null) goto L61;
        r17 = 2131377330;
        ProgressBar r9 = (ProgressBar) ViewBindings.findChildViewById(r16, 2131377330);
        if (r9 == null) goto L61;
        r17 = 2131377331;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r16, 2131377331);
        if (r10 == null) goto L61;
        r17 = 2131377332;
        ViewPager2 r11 = ViewBindings.findChildViewById(r16, 2131377332);
        if (r11 == null) goto L61;
        this.j = new LarusPageDriveMainBinding(r16, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        aa0();
        b r18 = new b(this);
        this.o = r18;
        LarusPageDriveMainBinding r110 = this.j;
        if (r110 == null) goto L25;
        ViewPager2 r111 = r110.j;
        if (r111 == null) goto L25;
        r111.setAdapter(r18);
    L25:
        LarusPageDriveMainBinding r112 = this.j;
        if (r112 == null) goto L30;
        ViewPager2 r113 = r112.j;
        if (r113 == null) goto L30;
        r113.registerOnPageChangeCallback(this.u);
    L30:
        LarusPageDriveMainBinding r114 = this.j;
        if (r114 == null) goto L45;
        DriveTagListView r115 = r114.c;
        if (r115 == null) goto L45;
        r115.d(CollectionsKt.listOf(new zp9.w[]{new zp9.w(0, getString(2131905379), 60), new zp9.w(1, getString(2131905378), 60)}));
        this.p = 0;
        r115.b(0, false);
        LarusPageDriveMainBinding r116 = this.j;
        if (r116 == null) goto L40;
        ViewPager2 r117 = r116.j;
        if (r117 == null) goto L40;
        r117.setCurrentItem(0);
    L40:
        Function2<? super Integer, ? super String, Unit> r118 = new d0(this);
        Intrinsics.checkNotNullParameter(r118, "click");
        r115.h = r118;
        LarusPageDriveMainBinding r119 = this.j;
        if (r119 == null) goto L45;
        ViewPager2 r120 = r119.j;
        if (r120 == null) goto L45;
        r120.registerOnPageChangeCallback(this.v);
    L45:
        Z90().getUploadTasks().observe(getViewLifecycleOwner(), new c(new e0(this)));
        LarusPageDriveMainBinding r121 = this.j;
        if (r121 == null) goto L50;
        ImageView r122 = r121.e;
        if (r122 == null) goto L50;
        r122.setOnClickListener(new f0());
    L50:
        LarusPageDriveMainBinding r123 = this.j;
        if (r123 == null) goto L55;
        CardView r124 = r123.d;
        if (r124 == null) goto L55;
        r124.setOnClickListener(new g0(this));
    L55:
        LarusPageDriveMainBinding r125 = this.j;
        if (r125 != null) goto L62;
        return null;
    L62:
        return r125.a;
    L61:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
