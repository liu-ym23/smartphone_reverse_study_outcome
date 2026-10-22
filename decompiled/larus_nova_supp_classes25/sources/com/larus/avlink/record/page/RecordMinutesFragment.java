package com.larus.avlink.record.page;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.keva.Keva;
import com.ixigua.lib.track.TrackParams;
import com.larus.avlink.impl.databinding.LayoutFragmentRecordMinutesBinding;
import com.larus.avlink.impl.databinding.LayoutRecordMinutesNetworkBannerBinding;
import com.larus.avlink.record.ui.RecordMinutesBottomView;
import com.larus.avlink.record.ui.RecordMinutesLoadingOrRetryView;
import com.larus.avlink.record.ui.RecordMinutesOnboardingView;
import com.larus.avlink.record.ui.RecordMinutesSyncHeaderView;
import com.larus.avlink.record.ui.RecordMinutesTitleView;
import com.larus.avlink.record.util.LarkRecordMinutesManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001b\b\u0007\u0018\u0000 I2\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\u0015H\u0016J\n\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010*\u001a\u00020\u0015H\u0002J\b\u0010+\u001a\u00020\u0015H\u0002J\b\u0010,\u001a\u00020\u0015H\u0002J\u0010\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H\u0002J\u0012\u00101\u001a\u00020\u00152\b\u00102\u001a\u0004\u0018\u00010)H\u0002J\u0010\u00103\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020)H\u0002J\u0012\u00106\u001a\u00020\u00152\b\u00105\u001a\u0004\u0018\u00010)H\u0002J\b\u00107\u001a\u00020\u0015H\u0002J\b\u00108\u001a\u00020\u0015H\u0002J\b\u00109\u001a\u00020\u0015H\u0002J\b\u0010:\u001a\u00020\u0015H\u0002J\b\u0010;\u001a\u00020\u0015H\u0003J\b\u0010<\u001a\u00020\u0015H\u0002J\b\u0010=\u001a\u00020\u0015H\u0002J\b\u0010>\u001a\u00020\u0015H\u0002J\b\u0010?\u001a\u00020\u0015H\u0002J\u0010\u0010@\u001a\u00020\u00152\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020\u0015H\u0002J\b\u0010D\u001a\u00020\u0019H\u0016J\b\u0010E\u001a\u00020)H\u0016J\u0010\u0010F\u001a\u00020\u00152\u0006\u0010G\u001a\u00020HH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006J"}, d2 = {"Lcom/larus/avlink/record/page/RecordMinutesFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutFragmentRecordMinutesBinding;", "viewModel", "Lcom/larus/avlink/record/page/RecordMinutesViewModel;", "getViewModel", "()Lcom/larus/avlink/record/page/RecordMinutesViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "recordAdapter", "Lcom/larus/avlink/record/page/RecordMinutesAdapter;", "currentBottomState", "Lcom/larus/avlink/record/page/BottomStatus;", "latestSyncState", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordTransferProgress;", "durationListener", "Lkotlin/Function1;", "", "", "recordStatusUpdateListener", "Lcom/larus/avlink/record/page/Action;", "offlineRecordingListener", "", "doraLinkListener", "com/larus/avlink/record/page/RecordMinutesFragment$doraLinkListener$1", "Lcom/larus/avlink/record/page/RecordMinutesFragment$doraLinkListener$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onDestroyView", "getEntryDoraDeviceMac", "", "initSubscribers", "initRecyclerView", "initSwipeRefresh", "onRecordItemClick", "item", "Lcom/larus/avlink/record/page/RecordMinutesItemData;", "onRecordItemDelete", "openLarkDoc", "larkDocToken", "onUploadIconClick", "uploadOfflineRecording", "recordingId", "openRecordingPage", "setViewListener", "startRecord", "observeNetworkState", "renderSyncHeader", "setRootTouchListener", "showLoadingView", "showOnboardingView", "showRecordHistoryListView", "showErrorView", "handleGlobalTouch", "event", "Landroid/view/MotionEvent;", "showTip", "autoLogEnterPage", "getCurrentPageName", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RecordMinutesFragment extends TraceFragment {
    public static final /* synthetic */ int n = 0;
    public LayoutFragmentRecordMinutesBinding e;
    public final com.larus.ui.arch.vm.internal.l f;
    public RecordMinutesAdapter g;
    public BottomStatus h;
    public com.larus.dora.api.offline.record.d i;
    public final x j;
    public final y k;
    public final z l;
    public final c m;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[Action.values().length];
            r0[Action.START_PULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            r0[Action.END_PULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L30:
            r0[Action.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L8:
            a = r0;
            int[] r1 = new int[TagType.values().length];
            r1[TagType.OFFLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L26:
            r1[TagType.RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L32:
            r1[TagType.CONVERTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L22:
            r1[TagType.OFFLINE_RECORDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L13:
            b = r1;
        }
    }

    public static final class c implements h49.e {
        public final /* synthetic */ RecordMinutesFragment a;

        public final void b(int r1) {
        }

        public c(RecordMinutesFragment r1) {
            this.a = r1;
        }

        public final void a(int r3) {
            FragmentActivity r4 = this.a.getActivity();
            if (r4 == null) goto L6;
            final RecordMinutesFragment r0 = this.a;
            r4.runOnUiThread(new f0(r0));
            return;
        }
    }

    public static final class d implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public d(s r2) {
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

    public static final class e implements Function0<LifecycleOwner> {
        public final /* synthetic */ Fragment a;

        public e(Fragment r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class f implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ Fragment a;

        public f(Fragment r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class g implements Function0<ViewModelProvider.Factory> {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "dora_voice_memos_list";
    }

    public final RecordMinutesViewModel U90() {
        return (RecordMinutesViewModel) this.f.getValue();
    }

    public final void V90() {
        Handler r0 = com.larus.utils.e0.a;
        if (Intrinsics.areEqual(com.larus.utils.e0.c.getValue(), Boolean.TRUE) == false) goto L9;
        LayoutFragmentRecordMinutesBinding r1 = this.e;
        if (r1 == null) goto L15;
        RecordMinutesSyncHeaderView r2 = r1.h;
        if (r2 == null) goto L16;
        r2.R5(this.i);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        LayoutFragmentRecordMinutesBinding r3 = this.e;
        if (r3 == null) goto L18;
        RecordMinutesSyncHeaderView r4 = r3.h;
        if (r4 == null) goto L19;
        com.larus.dora.api.offline.record.d r5 = com.larus.dora.api.offline.record.d.i;
        r4.R5(com.larus.dora.api.offline.record.d.i);
        return;
    L19:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.avlink.record.page.x] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.avlink.record.page.y] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.avlink.record.page.z] */
    public RecordMinutesFragment() {
        this.f = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(RecordMinutesViewModel.class), Reflection.getOrCreateKotlinClass(RecordMinutesState.class), new e(this), new f(this), g.a);
        this.i = com.larus.dora.api.offline.record.d.i;
        this.j = new x(this);
        this.k = new y(this);
        this.l = new z(this);
        this.m = new c(this);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        LarkRecordMinutesManager r0 = LarkRecordMinutesManager.a;
        y r1 = this.k;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "listener");
        if (LarkRecordMinutesManager.s() == false) goto L6;
        LarkRecordMinutesManager.t.remove(r1);
    L6:
        x r2 = this.j;
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (LarkRecordMinutesManager.s() == false) goto L10;
        LarkRecordMinutesManager.r.remove(r2);
    L10:
        z r3 = this.l;
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (LarkRecordMinutesManager.s() == false) goto L14;
        LarkRecordMinutesManager.v.remove(r3);
    L14:
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L19;
        DeviceService r5 = r4.device();
        if (r5 == null) goto L19;
        r5.x0(this.m);
    L19:
        U90().unregisterSyncListener();
        RecordMinutesAdapter r6 = this.g;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
        r6 = null;
    L22:
        r6.y2();
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        com.larus.trace.tracknode.a.a.a(this, r3);
        Bundle r0 = getArguments();
        if (r0 == null) goto L8;
        String r1 = r0.getString("previous_page");
        if (r1 == null) goto L9;
        r3.put("previous_page", r1);
        return;
    L9:
        return;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.avlink.record.page.p] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.avlink.record.page.q] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.larus.avlink.record.page.s] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.avlink.record.page.r] */
    public final void onViewCreated(View r32, Bundle r33) {
        Intrinsics.checkNotNullParameter(r32, "view");
        U90().registerSyncListener();
        U90().fetchRecordMinutesHistoryList(Action.INITIAL_PULL);
        this.g = new RecordMinutesAdapter(requireContext(), new p(this), new q(this), new r(this));
        LayoutFragmentRecordMinutesBinding r1 = this.e;
        final ImageView r2 = null;
        if (r1 == null) goto L8;
        RecyclerView r3 = r1.f;
        r3.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecordMinutesAdapter r4 = this.g;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
        r4 = null;
    L7:
        r3.setAdapter(r4);
        r3.addOnScrollListener(new RecordMinutesFragment$initRecyclerView$4$1$1(this));
    L8:
        LayoutFragmentRecordMinutesBinding r5 = this.e;
        if (r5 == null) goto L13;
        SwipeRefreshLayout r6 = r5.g;
        if (r6 == null) goto L13;
        r6.setOnRefreshListener(new w(this));
    L13:
        U90().observeOfflineRecordingUploadProgress();
        ComponentViewModel.onEach$default(U90(), RecordMinutesFragment$initSubscribers$1.INSTANCE, null, new RecordMinutesFragment$initSubscribers$2(this, null), 2, null);
        ComponentViewModel.onEach$default(U90(), RecordMinutesFragment$initSubscribers$3.INSTANCE, null, new RecordMinutesFragment$initSubscribers$4(this, null), 2, null);
        ComponentViewModel.onEach$default(U90(), RecordMinutesFragment$initSubscribers$5.INSTANCE, null, new RecordMinutesFragment$initSubscribers$6(this, null), 2, null);
        ComponentViewModel.onEach$default(U90(), RecordMinutesFragment$initSubscribers$7.INSTANCE, null, new RecordMinutesFragment$initSubscribers$8(this, null), 2, null);
        ComponentViewModel.onEach$default(U90(), RecordMinutesFragment$initSubscribers$9.INSTANCE, null, new RecordMinutesFragment$initSubscribers$10(this, null), 2, null);
        ComponentViewModel.onEach$default(U90(), RecordMinutesFragment$initSubscribers$11.INSTANCE, null, new RecordMinutesFragment$initSubscribers$12(this, null), 2, null);
        ComponentViewModel.onEach$default(U90(), RecordMinutesFragment$initSubscribers$13.INSTANCE, null, new RecordMinutesFragment$initSubscribers$14(this, null), 2, null);
        com.larus.utils.e0.c.observe(getViewLifecycleOwner(), new d(new s(this)));
        LayoutFragmentRecordMinutesBinding r7 = this.e;
        if (r7 == null) goto L18;
        RecordMinutesTitleView r8 = r7.i;
        if (r8 == null) goto L18;
        r8.setOnBackButtonClick(new a0(this));
        r8.setOnSettingIconClick(new b0(this));
    L18:
        LayoutFragmentRecordMinutesBinding r9 = this.e;
        if (r9 == null) goto L23;
        RecordMinutesOnboardingView r10 = r9.e;
        if (r10 == null) goto L23;
        r10.setOnShortcutClick(new c0(this));
    L23:
        LayoutFragmentRecordMinutesBinding r11 = this.e;
        if (r11 == null) goto L28;
        RecordMinutesBottomView r12 = r11.b;
        if (r12 == null) goto L28;
        r12.setOnStartButtonClick(new d0(this));
        r12.setOnEndButtonClick(new e0(this));
    L28:
        LayoutFragmentRecordMinutesBinding r13 = this.e;
        if (r13 == null) goto L33;
        RecordMinutesLoadingOrRetryView r14 = r13.c;
        if (r14 == null) goto L33;
        r14.setOnRetryClick(new o(this));
    L33:
        LayoutFragmentRecordMinutesBinding r15 = this.e;
        if (r15 == null) goto L38;
        ConstraintLayout r16 = r15.a;
        if (r16 == null) goto L38;
        r16.setOnTouchListener(new v(this));
    L38:
        LarkRecordMinutesManager r17 = LarkRecordMinutesManager.a;
        x r18 = this.j;
        r17.getClass();
        LarkRecordMinutesManager.d(r18);
        y r19 = this.k;
        Intrinsics.checkNotNullParameter(r19, "listener");
        if (LarkRecordMinutesManager.s() == false) goto L42;
        LarkRecordMinutesManager.t.add(r19);
    L42:
        LarkRecordMinutesManager.c(this.l);
        IDoraService r20 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r20 == null) goto L47;
        DeviceService r21 = r20.device();
        if (r21 == null) goto L47;
        r21.t0(this.m);
    L47:
        LayoutFragmentRecordMinutesBinding r22 = this.e;
        if (r22 == null) goto L56;
        RecordMinutesBottomView r23 = r22.b;
        if (r23 == null) goto L56;
        Bundle r24 = getArguments();
        if (r24 == null) goto L54;
        String r25 = r24.getString("mac");
    L55:
        r23.setEntryDoraDeviceMac(r25);
        goto L56
    L54:
        r25 = null;
    L56:
        LayoutFragmentRecordMinutesBinding r26 = this.e;
        if (r26 == null) goto L61;
        RecordMinutesBottomView r27 = r26.b;
        if (r27 == null) goto L61;
        r27.R5();
    L61:
        Keva r28 = DoraConfig.a;
        if (r28.getBoolean("key_is_dora_first_enter_record_page", true) == false) goto L71;
        r28.storeBoolean("key_is_dora_first_enter_record_page", false);
        LayoutFragmentRecordMinutesBinding r29 = this.e;
        if (r29 == null) goto L68;
        RecordMinutesTitleView r30 = r29.i;
        if (r30 == null) goto L68;
        r2 = r30.a.b;
    L68:
        if (r2 == null) goto L72;
        r2.post(new n(this, r2));
        return;
    L72:
        return;
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        ConstraintLayout r14 = r11.inflate(2131563330, r12, false);
        int r15 = 2131364390;
        RecordMinutesBottomView r2 = (RecordMinutesBottomView) ViewBindings.findChildViewById(r14, 2131364390);
        if (r2 == null) goto L21;
        r15 = 2131379049;
        RecordMinutesLoadingOrRetryView r3 = (RecordMinutesLoadingOrRetryView) ViewBindings.findChildViewById(r14, 2131379049);
        if (r3 == null) goto L21;
        r15 = 2131380669;
        View r16 = ViewBindings.findChildViewById(r14, 2131380669);
        if (r16 == null) goto L21;
        LayoutRecordMinutesNetworkBannerBinding r4 = new LayoutRecordMinutesNetworkBannerBinding((LinearLayout) r16);
        r15 = 2131381461;
        RecordMinutesOnboardingView r5 = (RecordMinutesOnboardingView) ViewBindings.findChildViewById(r14, 2131381461);
        if (r5 == null) goto L21;
        r15 = 2131384006;
        RecyclerView r6 = ViewBindings.findChildViewById(r14, 2131384006);
        if (r6 == null) goto L21;
        r15 = 2131384141;
        SwipeRefreshLayout r7 = ViewBindings.findChildViewById(r14, 2131384141);
        if (r7 == null) goto L21;
        r15 = 2131387959;
        RecordMinutesSyncHeaderView r8 = (RecordMinutesSyncHeaderView) ViewBindings.findChildViewById(r14, 2131387959);
        if (r8 == null) goto L21;
        r15 = 2131388924;
        RecordMinutesTitleView r9 = (RecordMinutesTitleView) ViewBindings.findChildViewById(r14, 2131388924);
        if (r9 == null) goto L21;
        ConstraintLayout r17 = r14;
        this.e = new LayoutFragmentRecordMinutesBinding(r17, r2, r3, r4, r5, r6, r7, r8, r9);
        return r17;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
