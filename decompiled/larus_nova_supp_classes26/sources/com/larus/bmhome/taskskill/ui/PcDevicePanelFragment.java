package com.larus.bmhome.taskskill.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.bmhome.taskskill.interaction.PcDeviceSelectionHandler;
import com.larus.bmhome.taskskill.k2;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.network.PcDeviceRepository;
import com.larus.common_res.common_ui.databinding.LarusLayoutBottomSheetHeaderBinding;
import com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment;
import com.larus.flowskill.impl.databinding.LarusFragmentPcDevicePanelBinding;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.OmniDispatchCommandFrom;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.im.service.a0;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import v19.c7;
import v19.m7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0002\u001d \u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001UB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010,\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0016J\u001e\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\u00112\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0014J\b\u00104\u001a\u00020*H\u0002J\b\u00105\u001a\u00020*H\u0002J\u0006\u00106\u001a\u00020*J\u0016\u00107\u001a\u00020*2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00152\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0010\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020:H\u0002J\u0010\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020\u0016H\u0002J\u0010\u0010E\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u0016H\u0002J\u0012\u0010F\u001a\u00020*2\b\u0010G\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010H\u001a\u00020*H\u0002J\b\u0010I\u001a\u00020\u001aH\u0002J\u0016\u0010J\u001a\u00020*2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0010\u0010K\u001a\u00020*2\u0006\u0010L\u001a\u00020\u0018H\u0002J\f\u0010M\u001a\u00020\u0018*\u00020\u0016H\u0002J\u0016\u0010N\u001a\u00020*2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020:0\u0015H\u0002J\u0010\u0010P\u001a\u00020*2\u0006\u0010Q\u001a\u00020\u0006H\u0002J\u0010\u0010R\u001a\u00020*2\u0006\u0010>\u001a\u00020\u0016H\u0002J\u001c\u0010S\u001a\u00020*2\u0006\u0010T\u001a\u00020\u00182\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0016H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bA\u0010B¨\u0006V"}, d2 = {"Lcom/larus/bmhome/taskskill/ui/PcDevicePanelFragment;", "Lcom/larus/common_ui/dialog/RoundedBottomSheetDialogFragment;", "Lcom/obric/assistant/common/spi/window/RetainOnWindowStash;", "<init>", "()V", "roundedBottomSheetBackgroundRes", "", "getRoundedBottomSheetBackgroundRes", "()I", "binding", "Lcom/larus/flowskill/impl/databinding/LarusFragmentPcDevicePanelBinding;", "headerController", "Lcom/larus/common_ui/dialog/BottomSheetHeaderController;", "adapter", "Lcom/larus/bmhome/taskskill/ui/PcDeviceListAdapter;", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "loadDevicesJob", "Lkotlinx/coroutines/Job;", "currentDevices", "", "Lcom/larus/bmhome/taskskill/model/PcDevice;", "selectedPcDeviceId", "", "hasReachedExpandedState", "", "hasReportedConnectBoardShow", "dispatchCommandListener", "com/larus/bmhome/taskskill/ui/PcDevicePanelFragment$dispatchCommandListener$1", "Lcom/larus/bmhome/taskskill/ui/PcDevicePanelFragment$dispatchCommandListener$1;", "behaviorCallback", "com/larus/bmhome/taskskill/ui/PcDevicePanelFragment$behaviorCallback$1", "Lcom/larus/bmhome/taskskill/ui/PcDevicePanelFragment$behaviorCallback$1;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onRoundedBottomSheetReady", "bottomSheet", "behavior", "initViews", "loadDevices", "refreshDevices", "renderDeviceList", "devices", "buildItems", "Lcom/larus/bmhome/taskskill/ui/PcDevicePanelItem;", "handleItemClick", "item", "handleDeviceClick", "device", "pcDeviceSelectionHandler", "Lcom/larus/bmhome/taskskill/interaction/PcDeviceSelectionHandler;", "getPcDeviceSelectionHandler", "()Lcom/larus/bmhome/taskskill/interaction/PcDeviceSelectionHandler;", "pcDeviceSelectionHandler$delegate", "Lkotlin/Lazy;", "updateAuthorizedDevice", "updateAuthorizingDevice", "deviceId", "showLoading", "shouldShowCloudComputer", "reportConnectBoardShowOnce", "reportConnectBoardClick", "clickFrom", "toConnectBoardClickFrom", "submitItems", "items", "updateRecyclerHeight", "itemCount", "publishDeviceSelected", "publishEvent", "event", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcDevicePanelFragment extends RoundedBottomSheetDialogFragment implements qda.a {
    public static final /* synthetic */ int o = 0;
    public LarusFragmentPcDevicePanelBinding d;
    public PcDeviceListAdapter e;
    public BottomSheetBehavior<View> f;
    public Job g;
    public List<PcDevice> h;
    public String i;
    public boolean j;
    public boolean k;
    public final c l;
    public final b m;
    public final Lazy n;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ PcDevicePanelFragment a;

        public b(PcDevicePanelFragment r1) {
            this.a = r1;
        }

        public final void onSlide(View r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            PcDevicePanelFragment r4 = this.a;
            if (r4.j == true) goto L5;
            return;
        L5:
            if (r3 > 0.05f) goto L17;
            BottomSheetBehavior<View> r5 = r4.f;
            boolean r0 = false;
            if (r5 != null) goto L9;
        L11:
            if (r0 == true) goto L18;
            BottomSheetBehavior<View> r6 = this.a.f;
            if (r6 == null) goto L19;
            r6.setState(5);
            return;
        L19:
            return;
        L18:
            return;
        L9:
            if (r5.getState() != 5) goto L11;
            r0 = true;
            goto L11
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 3) goto L5;
            PcDevicePanelFragment r4 = this.a;
            r4.j = true;
            BottomSheetBehavior<View> r5 = r4.f;
            if (r5 == null) goto L31;
            r5.setSkipCollapsed(true);
            return;
        L31:
            return;
        L5:
            if (r3 == 4) goto L15;
            if (r3 == 5) goto L24;
            return;
        L24:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r6 = DialogFragmentLancet.sLastShowStack;
            if (r6 == null) goto L26;
            com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L26:
            return;
        L15:
            PcDevicePanelFragment r7 = this.a;
            if (r7.j == false) goto L28;
            BottomSheetBehavior<View> r8 = r7.f;
            if (r8 == null) goto L29;
            r8.setState(5);
            return;
        L29:
            return;
        }
    }

    public static final class c implements a0 {
        public final /* synthetic */ PcDevicePanelFragment a;

        public c(PcDevicePanelFragment r1) {
            this.a = r1;
        }

        public final void onReceiveDispatchCommand(OmniDispatchCommandResponse r3) {
            Intrinsics.checkNotNullParameter(r3, "response");
            if (r3.from != OmniDispatchCommandFrom.FROM_DISPATCHER) goto L17;
            DispatchCommandPayload r4 = r3.payload;
            if (r4 == null) goto L7;
            DispatchCommand r5 = r4.command;
        L9:
            if (r5 != DispatchCommand.DEVICE_STATUS_CHANGE) goto L18;
            PcDevicePanelFragment r6 = this.a;
            if (r6.d != null) goto L13;
            return;
        L13:
            if (r6.isAdded() == false) goto L20;
            FLogger.a.i("PcDevicePanelFragment", "[onReceiveDispatchCommand] device online changed, refresh devices");
            this.a.W90();
            return;
        L20:
            return;
        L18:
            return;
        L7:
            r5 = null;
            goto L9
        }

        public final void a(String r1, String r2, IIMError r3) {
            a0.a.a(r1, r2, r3);
        }
    }

    public static final class d implements PcDeviceSelectionHandler.a {
        public final /* synthetic */ PcDevicePanelFragment a;

        public d(PcDevicePanelFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.taskskill.interaction.PcDeviceSelectionHandler.a
        public final void a(PcDevice r3) {
            Intrinsics.checkNotNullParameter(r3, "device");
            PcDevicePanelFragment r0 = this.a;
            int r1 = PcDevicePanelFragment.o;
            r0.X90("device_selected", r3);
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L12;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // com.larus.bmhome.taskskill.interaction.PcDeviceSelectionHandler.a
        public final void b(String r7) {
            PcDevicePanelFragment r0 = this.a;
            List<PcDevice> r1 = r0.h;
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator<T> r3 = r1.iterator();
        L4:
            if (r3.hasNext() == false) goto L10;
            PcDevice r4 = (PcDevice) r3.next();
            if (Intrinsics.areEqual(r4.getDeviceId(), r7) == false) goto L8;
            PcDevice r5 = bs8.g.a(r4, Intrinsics.areEqual(r4.c(), Boolean.TRUE), true);
        L9:
            r2.add(r5);
            goto L4
        L8:
            r5 = bs8.g.a(r4, Intrinsics.areEqual(r4.c(), Boolean.TRUE), false);
            goto L9
        L10:
            r0.h = r2;
            r0.Y90(r2);
        }

        @Override // com.larus.bmhome.taskskill.interaction.PcDeviceSelectionHandler.a
        public final void c(PcDevice r9) {
            Intrinsics.checkNotNullParameter(r9, "device");
            PcDevicePanelFragment r0 = this.a;
            if (r0.d != null) goto L5;
            return;
        L5:
            if (r0.isAdded() == false) goto L32;
            PcDevicePanelFragment r1 = this.a;
            r1.getClass();
            String r2 = r9.getDeviceId();
            if (r2 != null) goto L10;
            r2 = "";
        L10:
            PcDevice r10 = bs8.g.a(r9, true, false);
            r1.i = r2;
            List<PcDevice> r4 = r1.h;
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator<T> r6 = r4.iterator();
        L12:
            if (r6.hasNext() == false) goto L17;
            PcDevice r7 = (PcDevice) r6.next();
            if (Intrinsics.areEqual(r7.getDeviceId(), r2) == false) goto L16;
            r7 = bs8.g.a(r7, true, false);
        L16:
            r5.add(r7);
            goto L12
        L17:
            r1.h = r5;
            r1.Y90(r5);
            PcDeviceRepository r3 = PcDeviceRepository.a;
            List<PcDevice> r8 = r1.h;
            Intrinsics.checkNotNullParameter(r8, "devices");
            PcDeviceRepository.b = r8;
            this.a.X90("device_selected", r10);
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L20
            return;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r11 = DialogFragmentLancet.sLastShowStack;
            if (r11 == null) goto L31;
            com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L31:
            return;
        }
    }

    static {
    }

    public final int S90() {
        return 2131239798;
    }

    public final void W90() {
        Job r0 = this.g;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.g = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new PcDevicePanelFragment$loadDevices$1(this, null), 3, null);
    }

    public PcDevicePanelFragment() {
        this.h = CollectionsKt.emptyList();
        this.l = new c(this);
        this.m = new b(this);
        this.n = LazyKt.lazy(new h(this));
    }

    public final void onDestroyView() {
        com.larus.im.d.b().unregisterDispatchCommandListener(this.l);
        LarusFragmentPcDevicePanelBinding r0 = this.d;
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.c;
        if (r1 == null) goto L7;
        r1.setAdapter(null);
    L7:
        Job r2 = this.g;
        if (r2 == null) goto L10;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L10:
        this.g = null;
        this.j = false;
        this.k = false;
        this.f = null;
        this.e = null;
        this.d = null;
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        m7.a(r1);
        return;
    L9:
        return;
    }

    public static void Z90(String r4) {
        int r0 = k2.a;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        Intrinsics.checkNotNullParameter(r4, "clickFrom");
        com.larus.platform.service.o r1 = com.larus.platform.service.o.a;
        JSONObject r2 = new JSONObject();
        r2.put("current_page", "chat");
        r2.put("click_from", r4);
        Unit r5 = Unit.INSTANCE;
        r1.reportEvent("local_computer_connect_board_click", r2);
    }

    public final void Y90(List<PcDevice> r8) {
        Pair r9 = com.larus.dispatcher.api.d.a(r8);
        List r0 = (List) r9.component1();
        List r10 = (List) r9.component2();
        List r1 = CollectionsKt.filterNotNull(r0);
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        PcDevice r4 = (PcDevice) r3.next();
        r2.add(new i.b(r4, Intrinsics.areEqual(r4.getDeviceId(), this.i)));
        goto L4
    L6:
        List r5 = CollectionsKt.toMutableList(r2);
        List r11 = CollectionsKt.filterNotNull(r10);
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        PcDevice r7 = (PcDevice) r12.next();
        r6.add(new i.b(r7, Intrinsics.areEqual(r7.getDeviceId(), this.i)));
        goto L8
    L10:
        List r13 = CollectionsKt.toMutableList(r6);
        ArrayList r14 = new ArrayList();
        r14.addAll(r5);
        Bundle r15 = getArguments();
        boolean r16 = true;
        if (r15 == null) goto L13;
        boolean r17 = r15.getBoolean("arg_show_cloud_computer", true);
    L14:
        if (r17 == false) goto L22;
        String r18 = this.i;
        if (r18 != null) goto L18;
    L21:
        r14.add(new i.c(r16));
        goto L22
    L18:
        if (StringsKt.isBlank(r18) == true) goto L21;
        r16 = false;
    L22:
        r14.addAll(r13);
        r14.add(i.a.a);
        submitItems(r14);
        return;
    L13:
        r17 = true;
        goto L14
    }

    public final void onDismiss(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");     // Catch: Throwable -> L5
        com.larus.im.d.b().unregisterDispatchCommandListener(this.l);     // Catch: Throwable -> L5
        X90("panel_closed", null);     // Catch: Throwable -> L5
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r3);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void submitItems(List<? extends i> r10) {
        int r0 = r10.size();
        LarusFragmentPcDevicePanelBinding r1 = this.d;
        if (r1 == null) goto L8;
        int r2 = getResources().getDimensionPixelSize(v19.c.b(2130971541, null, 2131167451));
        int r3 = m0.a;
        int r4 = m0.a(getContext());
        i0.a.getClass();
        int r5 = RangesKt.coerceAtLeast((r4 - i0.g()) - (((getResources().getDimensionPixelSize(v19.c.b(2130971505, null, 2131167379)) + getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462))) + getResources().getDimensionPixelSize(v19.c.b(2130971139, null, 2131166648))) + getResources().getDimensionPixelSize(v19.c.b(2130971255, null, 2131166880))), r2);
        int r6 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r2 * r0, r5), 0);
        RecyclerView r7 = r1.c;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L13;
        r8.height = r6;
        r7.setLayoutParams(r8);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L8:
        PcDeviceListAdapter r9 = this.e;
        if (r9 == null) goto L14;
        r9.submitList(r10, new g(this));
        return;
    }

    public final void V90(View r7, BottomSheetBehavior<View> r8) {
        Intrinsics.checkNotNullParameter(r7, "bottomSheet");
        Intrinsics.checkNotNullParameter(r8, "behavior");
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        int r1 = m0.a;
        int r2 = m0.a(getContext());
        i0.a.getClass();
        int r3 = r2 - i0.g();
        if (r0 == null) goto L5;
        r0.height = -1;
    L5:
        r7.setLayoutParams(r0);
        Object r9 = r7.getParent();
        if ((r9 instanceof View) == false) goto L8;
        View r10 = (View) r9;
    L9:
        if (r10 == null) goto L18;
        ViewGroup.LayoutParams r4 = r10.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
    L14:
        int r6 = getResources().getDimensionPixelSize(v19.c.b(2130971163, null, 2131166696));
        if (r5 == null) goto L17;
        r5.topMargin = r6;
    L17:
        r10.setLayoutParams(r5);
        goto L18
    L13:
        r5 = null;
    L18:
        this.f = r8;
        r8.setPeekHeight((int) (r3 * 0.5f));
        r8.setSkipCollapsed(false);
        r8.setHideable(true);
        r8.setFitToContents(true);
        r8.setBottomSheetCallback(this.m);
        r8.setState(4);
        return;
    L8:
        r10 = null;
        goto L9
    }

    public final void X90(String r5, PcDevice r6) {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("arg_request_key");
    L6:
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        if (StringsKt.isBlank(r1) == false) goto L11;
        return;
    L11:
        FragmentManager r2 = getParentFragmentManager();
        Bundle r3 = new Bundle();
        r3.putString("key_event", r5);
        if (r6 == null) goto L14;
        r3.putParcelable("key_device", r6);
    L14:
        Unit r7 = Unit.INSTANCE;
        r2.setFragmentResult(r1, r3);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        Bundle r12 = getArguments();
        Integer r13 = null;
        if (r12 == null) goto L5;
        String r14 = r12.getString("arg_selected_pc_device_id");
    L6:
        this.i = r14;
        LarusFragmentPcDevicePanelBinding r15 = this.d;
        if (r15 == null) goto L53;
        LarusLayoutBottomSheetHeaderBinding r0 = r15.b;
        Intrinsics.checkNotNullParameter(r0, "binding");
        Bundle r1 = getArguments();
        boolean r2 = true;
        if (r1 == null) goto L20;
        Integer r3 = Integer.valueOf(r1.getInt("arg_title_res_id"));
        if (r3.intValue() == 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L18;
        r3 = null;
    L18:
        if (r3 == null) goto L20;
        int r5 = r3.intValue();
    L21:
        r0.d.setText(r5);
        r0.b.setOnClickListener(new f(this));
        Bundle r6 = getArguments();
        if (r6 == null) goto L29;
        Integer r7 = Integer.valueOf(r6.getInt("arg_navigation_icon_res_id"));
        if (r7.intValue() == 0) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == false) goto L29;
    L30:
        if (r7 == null) goto L32;
        int r9 = r7.intValue();
        ConstraintLayout r16 = r15.b.a;
        r16.setPaddingRelative(c7.b(16), r16.getPaddingTop(), c7.b(16), r16.getPaddingBottom());
        r15.b.b.setImageResource(r9);
    L32:
        Bundle r17 = getArguments();
        if (r17 == null) goto L44;
        Integer r18 = Integer.valueOf(r17.getInt("arg_bottom_sheet_close_size_dp"));
        if (r18.intValue() > 0) goto L38;
        r2 = false;
    L38:
        if (r2 == true) goto L41;
        r18 = null;
    L41:
        if (r18 == null) goto L44;
        r13 = r18;
    L46:
        if (r13 == null) goto L52;
        int r19 = r13.intValue();
        AppCompatImageView r20 = r15.b.b;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if (r21 == null) goto L51;
        r21.width = c7.b(Integer.valueOf(r19));
        r21.height = c7.b(Integer.valueOf(r19));
        r20.setLayoutParams(r21);
        goto L52
    L51:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L52:
        this.e = new PcDeviceListAdapter(new PcDevicePanelFragment$initViews$4(this));
        r15.c.setLayoutManager(new LinearLayoutManager(getContext()));
        r15.c.setAdapter(this.e);
    L44:
        if (r7 == null) goto L46;
        r7.intValue();
        r13 = 36;
        goto L46
    L26:
        r8 = false;
    L29:
        r7 = null;
        goto L30
    L14:
        r4 = false;
    L20:
        r5 = 2131908245;
    L53:
        com.larus.im.d.b().registerDispatchCommandListener(this.l);
        W90();
        return;
    L5:
        r14 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562421, r3, false);
        int r6 = 2131382081;
        if (ViewBindings.findChildViewById(r5, 2131382081) == null) goto L12;
        r6 = 2131382082;
        View r7 = ViewBindings.findChildViewById(r5, 2131382082);
        if (r7 == null) goto L12;
        LarusLayoutBottomSheetHeaderBinding r8 = LarusLayoutBottomSheetHeaderBinding.a(r7);
        RecyclerView r0 = ViewBindings.findChildViewById(r5, 2131382083);
        if (r0 == null) goto L10;
        LinearLayout r9 = (LinearLayout) r5;
        this.d = new LarusFragmentPcDevicePanelBinding(r9, r8, r0);
        return r9;
    L10:
        r6 = 2131382083;
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
