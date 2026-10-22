package com.ss.android.lark.forwardv3.plugins;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.base.fragment.BaseForsetiFragment;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.NavPicker;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.config.OnPickerConfirmListener;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.android.lark.search.dto.Source;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.UIHelper;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import z5c.c4;
import zib.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0003\u0014\u0017\u001a\u0018\u0000 42\u00020\u0001:\u0003456B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\n\u0010&\u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020/H\u0002J\u001e\u00100\u001a\u00020\u001d2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020-02j\b\u0012\u0004\u0012\u00020-`3R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u00067"}, d2 = {"Lcom/ss/android/lark/forwardv3/plugins/ForwardAtSelectFragmentV2;", "Lcom/ss/android/lark/base/fragment/BaseForsetiFragment;", "<init>", "()V", "navPicker", "Lcom/ss/android/lark/picker/NavPicker;", "viewModel", "Lcom/ss/android/lark/forwardv3/plugins/ForwardAtSelectViewModel;", "getViewModel", "()Lcom/ss/android/lark/forwardv3/plugins/ForwardAtSelectViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "targets", "", "Lcom/ss/android/lark/forwardv3/plugins/ForwardAtSelectContainerFragment$ForwardTarget;", "scene", "Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;", "multipleSelect", "", "confirmListener", "com/ss/android/lark/forwardv3/plugins/ForwardAtSelectFragmentV2$confirmListener$1", "Lcom/ss/android/lark/forwardv3/plugins/ForwardAtSelectFragmentV2$confirmListener$1;", "pickerListener", "com/ss/android/lark/forwardv3/plugins/ForwardAtSelectFragmentV2$pickerListener$1", "Lcom/ss/android/lark/forwardv3/plugins/ForwardAtSelectFragmentV2$pickerListener$1;", "pickerItemConsumer", "com/ss/android/lark/forwardv3/plugins/ForwardAtSelectFragmentV2$pickerItemConsumer$1", "Lcom/ss/android/lark/forwardv3/plugins/ForwardAtSelectFragmentV2$pickerItemConsumer$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initPicker", "getNavPickerConfig", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "exceedLimit", "searchBaseInfo", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "getMaxSelectCount", "", "finishActivityForResult", "info", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Companion", "ForwardMentionRecommendPullerV1", "ForwardMentionRecommendPuller", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardAtSelectFragmentV2 extends BaseForsetiFragment {
    public static final /* synthetic */ int n = 0;
    public final Lazy g;
    public List<ForwardAtSelectContainerFragment.ForwardTarget> h;
    public PickerStatistics.Scene i;
    public boolean j;
    public final e k;
    public final g l;
    public final f m;

    public static final class a {
        public static ForwardAtSelectFragmentV2 a(Bundle r3) {
            int r0 = zib.e.a;
            s5c.a r1 = c4.d;
            Intrinsics.checkNotNullParameter(r1, "version");
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new j(r1));
            ForwardAtSelectFragmentV2 r2 = new ForwardAtSelectFragmentV2();
            r2.setArguments(r3);
            return r2;
        }
    }

    public static final class b implements y3c.a {
        public final ForwardAtSelectViewModel a;
        public final List<ForwardAtSelectContainerFragment.ForwardTarget> b;

        public final boolean canLoadMore() {
            return false;
        }

        public final boolean needHeader() {
            return false;
        }

        public final void loadData(IGetDataCallback<List<SearchBaseInfo>> r3) {
            Intrinsics.checkNotNullParameter(r3, "callback");
            this.a.loadRecommendUserListV2(this.b, r3);
        }

        public final void onLoadMore(IGetDataCallback<List<SearchBaseInfo>> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
        }

        public b(ForwardAtSelectViewModel r2, List<ForwardAtSelectContainerFragment.ForwardTarget> r3) {
            Intrinsics.checkNotNullParameter(r2, "viewModel");
            Intrinsics.checkNotNullParameter(r3, "targets");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements y3c.a {
        public final ForwardAtSelectViewModel a;

        public final boolean canLoadMore() {
            return false;
        }

        public final boolean needHeader() {
            return false;
        }

        public c(ForwardAtSelectViewModel r2) {
            Intrinsics.checkNotNullParameter(r2, "viewModel");
            this.a = r2;
        }

        public final void loadData(IGetDataCallback<List<SearchBaseInfo>> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            this.a.loadRecommendUserList(r2);
        }

        public final void onLoadMore(IGetDataCallback<List<SearchBaseInfo>> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PickerStatistics.Scene.values().length];
            r0[PickerStatistics.Scene.ProfileMention.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static final class e implements OnPickerConfirmListener {
        public final /* synthetic */ ForwardAtSelectFragmentV2 a;

        public final void onConfirmed() {
            Log.i("NewForward", "forward mention confirmed");
            ForwardAtSelectFragmentV2 r0 = this.a;
            int r1 = ForwardAtSelectFragmentV2.n;
            r0.U90().onConfirmed(this.a);
        }

        public e(ForwardAtSelectFragmentV2 r1) {
            this.a = r1;
        }
    }

    public static final class f implements SearchResultView.IOnBusinessConsumeItem {
        public final /* synthetic */ ForwardAtSelectFragmentV2 a;

        public f(ForwardAtSelectFragmentV2 r1) {
            this.a = r1;
        }

        public final SearchResultView.CheckBoxBindStatus onBusinessBindItemCheckBox(SearchBaseInfo r7) {
            Intrinsics.checkNotNullParameter(r7, "data");
            ForwardAtSelectFragmentV2 r0 = this.a;
            int r1 = ForwardAtSelectFragmentV2.n;
            r0.getClass();
            if (r7.isSelected() == true) goto L11;
            ForwardAtSelectViewModel r2 = r0.U90();
            if (d.a[r0.i.ordinal()] != 1) goto L7;
            int r3 = Integer.MAX_VALUE;
        L9:
            if (r2.isMaxSelectV2(r3) == false) goto L11;
            boolean r4 = true;
        L12:
            Log.i("NewForward", "data id: " + r7.getId() + ", type: " + SearchCommonConstants.a(r7.getType()) + "\ndata is consumed by business: " + r4 + '\n');
            return new SearchResultView.CheckBoxBindStatus(r4, false, true);
        L7:
            r3 = 10;
        L11:
            r4 = false;
            goto L12
        }

        public final boolean onBusinessConsumeItemClick(SearchBaseInfo r7) {
            Intrinsics.checkNotNullParameter(r7, "data");
            ForwardAtSelectFragmentV2 r0 = this.a;
            int r1 = ForwardAtSelectFragmentV2.n;
            r0.getClass();
            int r2 = Integer.MAX_VALUE;
            if (r7.isSelected() == true) goto L11;
            ForwardAtSelectViewModel r8 = r0.U90();
            if (d.a[r0.i.ordinal()] != 1) goto L7;
            int r3 = Integer.MAX_VALUE;
        L9:
            if (r8.isMaxSelectV2(r3) == false) goto L11;
            boolean r9 = true;
        L12:
            if (r9 == false) goto L18;
            FragmentActivity r4 = this.a.requireActivity();
            if (d.a[this.a.i.ordinal()] == 1) goto L17;
            r2 = 10;
        L17:
            UDToast.show(r4, UIHelper.mustacheFormat(2131892185, "select_count", Integer.toString(r2)));
        L18:
            Log.i("NewForward", "create group for forward consume item click: " + r9);
            return r9;
        L7:
            r3 = 10;
        L11:
            r9 = false;
            goto L12
        }
    }

    public static final class g extends BasePicker.IOnPickNotify {
        public final /* synthetic */ ForwardAtSelectFragmentV2 a;

        public g(ForwardAtSelectFragmentV2 r1) {
            this.a = r1;
        }

        public final void onChanged(List<String> r2, List<SearchBaseInfo> r3) {
            Intrinsics.checkNotNullParameter(r2, "ids");
            Intrinsics.checkNotNullParameter(r3, "infoList");
            ForwardAtSelectFragmentV2 r4 = this.a;
            int r0 = ForwardAtSelectFragmentV2.n;
            r4.U90().updatePickerSelectedState(r3);
        }

        public final void onSelected(String r5, SearchBaseInfo r6) {
            Intrinsics.checkNotNullParameter(r5, "id");
            Intrinsics.checkNotNullParameter(r6, "info");
            int r7 = zib.e.a;
            if (r6.getSource() != Source.Type.SEARCH) goto L5;
            boolean r8 = true;
        L6:
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new zib.h(r8));
            ForwardAtSelectFragmentV2 r9 = this.a;
            if (r9.j == false) goto L9;
            return;
        L9:
            r9.U90().updatePickerSelectedState(CollectionsKt.arrayListOf(new SearchBaseInfo[]{r6}));
            this.a.U90().onConfirmed(this.a);
            return;
        L5:
            r8 = false;
            goto L6
        }
    }

    static {
    }

    public final ForwardAtSelectViewModel U90() {
        return (ForwardAtSelectViewModel) this.g.getValue();
    }

    public ForwardAtSelectFragmentV2() {
        final Function0<Fragment> r0 = new ForwardAtSelectFragmentV2$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ForwardAtSelectViewModel.class), new ForwardAtSelectFragmentV2$special$$inlined$viewModels$default$2(r0), new ForwardAtSelectFragmentV2$special$$inlined$viewModels$default$3(r0, this));
        this.i = PickerStatistics.Scene.ImForwardMention;
        this.k = new e(this);
        this.l = new g(this);
        this.m = new f(this);
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        PickerStatistics.Scene r0 = null;
        if (r5 == null) goto L5;
        Serializable r6 = r5.getSerializable("forward_target");
    L7:
        if ((r6 instanceof List) == false) goto L9;
        List<ForwardAtSelectContainerFragment.ForwardTarget> r7 = (List) r6;
    L10:
        Bundle r1 = getArguments();
        if (r1 == null) goto L13;
        Serializable r2 = r1.getSerializable("scene");
    L15:
        if ((r2 instanceof PickerStatistics.Scene) == false) goto L17;
        r0 = (PickerStatistics.Scene) r2;
    L17:
        if (r0 != null) goto L19;
        r0 = PickerStatistics.Scene.ImForwardMention;
    L19:
        this.i = r0;
        if (r7 == null) goto L22;
        this.h = r7;
    L23:
        Context r8 = getContext();
        if (r8 == null) goto L28;
        boolean r3 = true;
        if (ForsetiConfig.a(r8) != true) goto L28;
    L29:
        if (r3 == false) goto L32;
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new AnonymousClass1(this));
        return;
    L32:
        return;
    L28:
        r3 = false;
        goto L29
    L22:
        zab.a.a(this);
        goto L23
    L13:
        r2 = null;
        goto L15
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L7
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        List<ForwardAtSelectContainerFragment.ForwardTarget> r0 = null;
        NavPicker r8 = new NavPicker(requireContext(), null, 2, null);
        r8.scene(this.i);
        FragmentActivity r9 = requireActivity();
        if (this.i != PickerStatistics.Scene.ProfileMention) goto L5;
        final y3c.a r10 = new c(U90());
        List r1 = CollectionsKt.emptyList();
    L10:
        NavPickerConfig r2 = new NavPickerConfig(new Dependency(r9, getChildFragmentManager()), new Permissions(r1));
        r2.navigation(new ForwardAtSelectFragmentV2$getNavPickerConfig$navPickerConfig$1$1(this));
        r2.extra(new ForwardAtSelectFragmentV2$getNavPickerConfig$navPickerConfig$1$2(this));
        r2.searcher(ForwardAtSelectFragmentV2$getNavPickerConfig$navPickerConfig$1$3.INSTANCE);
        r2.recommendList(new ForwardAtSelectFragmentV2$getNavPickerConfig$navPickerConfig$1$4(r10));
        r8.init(r2);
        return r8;
    L5:
        ForwardAtSelectViewModel r3 = U90();
        List<ForwardAtSelectContainerFragment.ForwardTarget> r4 = this.h;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("targets");
    L9:
        r10 = new b(r3, r0);
        r1 = CollectionsKt.listOf(ActionType.SHARE_MESSAGE_SELECT_USER);
        goto L10
    L8:
        r0 = r4;
        goto L9
    }
}
