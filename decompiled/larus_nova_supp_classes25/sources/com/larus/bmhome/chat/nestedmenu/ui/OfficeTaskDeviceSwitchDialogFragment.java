package com.larus.bmhome.chat.nestedmenu.ui;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.mainbot.impl.databinding.LarusDialogOfficeTaskDeviceSwitchBinding;
import com.larus.platform.IFlowSdkDepend;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import di8.d0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tx9.n2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0007H\u0016J#\u0010+\u001a\u00020\u00072\u0014\u0010,\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000¢\u0006\u0002\b-J#\u0010.\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0000¢\u0006\u0002\b/J!\u00100\u001a\u00020\u00072\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0005H\u0000¢\u0006\u0002\b1J%\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\n2\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020\u000705H\u0000¢\u0006\u0002\b6J\b\u00107\u001a\u00020\u0007H\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0002J\u0010\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020;H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006="}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/ui/OfficeTaskDeviceSwitchDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onTaskSelected", "Lkotlin/Function1;", "Lcom/larus/bmhome/taskskill/model/PcDevice;", "", "pendingSendResultListeners", "", "", "resolvedShouldContinue", "Ljava/lang/Boolean;", "binding", "Lcom/larus/mainbot/impl/databinding/LarusDialogOfficeTaskDeviceSwitchBinding;", "taskModeModel", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuItemModel;", "localTaskModels", "", "taskAdapter", "Lcom/larus/bmhome/chat/nestedmenu/ui/OfficeTaskAdapter;", "getTaskAdapter", "()Lcom/larus/bmhome/chat/nestedmenu/ui/OfficeTaskAdapter;", "taskAdapter$delegate", "Lkotlin/Lazy;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onStart", "onDestroyView", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDestroy", "addOnTaskSelectedListener", "listener", "addOnTaskSelectedListener$impl_mainlandRelease", "bindTaskModels", "bindTaskModels$impl_mainlandRelease", "addOnSendResultListener", "addOnSendResultListener$impl_mainlandRelease", "dispatchPendingSendResults", "shouldContinue", "beforeDispatch", "Lkotlin/Function0;", "dispatchPendingSendResults$impl_mainlandRelease", "renderTasks", "resolveCurrentDeviceModels", "onTaskItemClicked", "item", "Lcom/larus/bmhome/chat/nestedmenu/ui/OfficeTaskItem;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class OfficeTaskDeviceSwitchDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int k = 0;
    public Function1<? super PcDevice, Unit> d;
    public final List<Function1<Boolean, Unit>> e;
    public Boolean f;
    public LarusDialogOfficeTaskDeviceSwitchBinding g;
    public d0 h;
    public List<? extends d0> i;
    public final Lazy j;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final void onDestroy() {
        this.d = null;
        ((ArrayList) this.e).clear();
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void onDestroyView() {
        LarusDialogOfficeTaskDeviceSwitchBinding r0 = this.g;
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.c;
        if (r1 == null) goto L7;
        r1.setAdapter(null);
    L7:
        this.g = null;
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public OfficeTaskDeviceSwitchDialogFragment() {
        this.e = new ArrayList();
        this.j = LazyKt.lazy(new u(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List<? extends di8.d0>] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.util.ArrayList] */
    public final void T90() {
        String r0 = requireArguments().getString("offline_device_id");
        if (this.h != null) goto L5;
    L8:
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L11;
        r1.P();
        Fragment r2 = ChatServiceImpl.a.f();
    L12:
        if (r2 == null) goto L20;
        t1a.b r3 = s1a.a.g(r2);
        if (r3 == null) goto L20;
        com.larus.bmhome.instruction.g r4 = r3.getAbility(com.larus.bmhome.instruction.g.class);
        if (r4 == null) goto L20;
        z0 r5 = r4.un(ActiveSwitchType.DEEPTHINK, null);
        if (r5 == null) goto L20;
        List<ei8.c> r6 = com.larus.bmhome.chat.nestedmenu.f.a;
        List r7 = com.larus.bmhome.chat.nestedmenu.f.e(requireView(), r5);
    L21:
        d0 r8 = this.h;
        if (r8 != null) goto L37;
        Iterator r9 = r7.iterator();
    L25:
        if (r9.hasNext() == false) goto L33;
        Object r10 = r9.next();
        PcDevice r11 = v.a((d0) r10);
        if (r11 == null) goto L29;
        String r12 = r11.getDeviceId();
    L31:
        if (Intrinsics.areEqual(r12, r0) == false) goto L25;
    L34:
        r8 = (d0) r10;
        if (r8 != null) goto L37;
        return;
    L29:
        r12 = null;
        goto L31
    L33:
        r10 = null;
    L37:
        ?? r13 = this.i;
        if (r13 != 0) goto L54;
        r13 = new ArrayList();
        Iterator r14 = r7.iterator();
    L41:
        if (r14.hasNext() == false) goto L54;
        Object r15 = r14.next();
        d0 r16 = (d0) r15;
        PcDevice r17 = v.a(r16);
        if (r17 == null) goto L45;
        String r18 = r17.getDeviceId();
    L47:
        if (Intrinsics.areEqual(r18, r0) == false) goto L49;
    L51:
        boolean r19 = false;
    L52:
        if (r19 == false) goto L41;
        r13.add(r15);
        goto L41
    L49:
        if (r16.d() == false) goto L51;
        r19 = true;
        goto L52
    L45:
        r18 = null;
    L54:
        ArrayList r20 = new ArrayList();
        Iterator r21 = ((Iterable) r13).iterator();
    L56:
        if (r21.hasNext() == false) goto L63;
        d0 r22 = (d0) r21.next();
        if (v.a(r22) == null) goto L60;
        w.b r23 = new w.b(r22);
    L61:
        if (r23 == null) goto L56;
        r20.add(r23);
        goto L56
    L60:
        r23 = null;
        goto L61
    L63:
        List r24 = CollectionsKt.plus(r20, new w.a(r8));
        ((OfficeTaskAdapter) this.j.getValue()).submitList(r24);
        Iterator r25 = r24.iterator();
    L65:
        if (r25.hasNext() == false) goto L79;
        w r26 = (w) r25.next();
        if (r0 != null) goto L69;
        String r27 = "";
    L71:
        if ((r26 instanceof w.b) == false) goto L74;
        String r28 = "local";
    L76:
        Intrinsics.checkNotNullParameter(r27, "offlineDeviceId");
        Intrinsics.checkNotNullParameter(r28, "computerType");
        n2.a("dispatch_offline_device_single_show", r27, r28);
        goto L65
    L74:
        if ((r26 instanceof w.a) == false) goto L78;
        r28 = "cloud";
        goto L76
    L78:
        throw new NoWhenBranchMatchedException();
    L69:
        r27 = r0;
        goto L71
    L79:
        return;
    L20:
        r7 = CollectionsKt.emptyList();
        goto L21
    L11:
        r2 = null;
        goto L12
    L5:
        if (this.i == null) goto L8;
        r7 = CollectionsKt.emptyList();
        goto L21
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        BottomSheetDialog r1 = null;
        n2.a("dispatch_offline_device_board_show", null, null);
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r2 = r0.getWindow();
        if (r2 == null) goto L7;
        r2.clearFlags(2);
        r2.setDimAmount(0.0f);
    L7:
        BottomSheetDialog r3 = getDialog();
        if ((r3 instanceof BottomSheetDialog) == false) goto L10;
        r1 = r3;
    L10:
        if (r1 == null) goto L16;
        View r4 = r1.findViewById(2131368870);
        if (r4 == null) goto L17;
        r4.setBackgroundResource(R.color.transparent);
        BottomSheetBehavior r5 = BottomSheetBehavior.from(r4);
        r5.setState(3);
        r5.setSkipCollapsed(true);
        return;
    L17:
        return;
    }

    public final void onCancel(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        S90(false, new s());
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r3);
    }

    public final void S90(boolean r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "beforeDispatch");
        if (this.f == null) goto L5;
        return;
    L5:
        this.f = Boolean.valueOf(r3);
        r4.invoke();
        List r5 = CollectionsKt.toList(this.e);
        ((ArrayList) this.e).clear();
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ((Function1) r6.next()).invoke(Boolean.valueOf(r3));
        goto L7
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        LarusDialogOfficeTaskDeviceSwitchBinding r6 = this.g;
        if (r6 == null) goto L8;
        TextView r7 = r6.d;
        Object[] r0 = new Object[1];
        String r1 = requireArguments().getString("offline_device_name");
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        r0[0] = r1;
        r7.setText(getString(2131899340, r0));
        r6.b.setOnClickListener(new t(this));
        r6.c.setAdapter((OfficeTaskAdapter) this.j.getValue());
    L8:
        T90();
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131562090, r4, false);
        int r7 = 2131381393;
        AppCompatImageButton r8 = ViewBindings.findChildViewById(r6, 2131381393);
        if (r8 == null) goto L11;
        r7 = 2131381394;
        RecyclerView r0 = ViewBindings.findChildViewById(r6, 2131381394);
        if (r0 == null) goto L11;
        r7 = 2131381395;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r6, 2131381395);
        if (r1 == null) goto L11;
        FrameLayout r9 = (FrameLayout) r6;
        this.g = new LarusDialogOfficeTaskDeviceSwitchBinding(r9, r8, r0, r1);
        return r9;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
