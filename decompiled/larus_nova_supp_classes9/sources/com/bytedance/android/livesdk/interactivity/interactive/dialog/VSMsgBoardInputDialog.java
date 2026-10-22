package com.bytedance.android.livesdk.interactivity.interactive.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.f1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.f;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.android.livesdkapi.interact.IVSInputDialog;
import com.bytedance.android.livesdkapi.interact.InputDraft;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import i40.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/VSMsgBoardInputDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/bytedance/android/livesdkapi/interact/IVSInputDialog;", "<init>", "()V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VSMsgBoardInputDialog extends DialogFragment implements IVSInputDialog {
    public t9 d;
    public IVSInputDialog.InputListener e;
    public MeasureLinearLayout f;
    public k82.a g;
    public final List<VSInputPanelSectionContainer> h;
    public DataCenter i;
    public boolean j;
    public boolean k;
    public boolean l;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ VSMsgBoardInputDialog b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        public b(EditText r1, VSMsgBoardInputDialog r2, long r3, int r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        public final void a() {
            if (this.b.isResumed() == false) goto L11;
            VSMsgBoardInputDialog r0 = this.b;
            if (r0.j == false) goto L11;
            if (r0.getContext() == null) goto L11;
            t2.b(this.b.getContext(), this.a);
            this.b.V90(this.c, this.d + 1, this.e);
            return;
        L11:
            h.a("V3 tryRestoreSoftKeyboard return");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public void T90(MeasureLinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "layout");
    }

    public void U90(MeasureLinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "layout");
    }

    public int getLayoutId() {
        return 0;
    }

    public void hideSoftKeyBoard() {
    }

    public final void onSendFailed() {
        this.l = false;
        f2.c("发送失败，请稍后再试", 0);
    }

    public void onSendSuccess() {
        k82.a r0 = this.g;
        if (r0 == null) goto L7;
        EditText r1 = r0.a;
        if (r1 == null) goto L7;
        r1.setText(BuildConfig.FLAVOR);
    L7:
        dismissInputDialog();
    }

    public VSMsgBoardInputDialog() {
        this.h = new ArrayList();
    }

    public void dismissInputDialog() {
        hideSoftKeyBoard();     // Catch: Exception -> L10
        dismissAllowingStateLoss();     // Catch: Exception -> L5
    L18:
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L10
        Throwable r0 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L10
        if (r0 == null) goto L17;
        d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L10
        return;
    L17:
        return;
    L10:
        e = move-exception;
        h.a("dismiss input dialog V3 exception: " + e.getMessage());
    }

    public final void S90(DialogInterface r6) {
        Intrinsics.checkNotNullParameter(r6, "dialog");
        f.d().c = false;
        f.d().f();
        Iterator r0 = ((ArrayList) this.h).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Iterator<Map.Entry<VSInputSectionType, k82.d>> r2 = ((VSInputPanelSectionContainer) r0.next()).getSectionProviders().entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        r2.next().getValue().d();
        goto L7
    L9:
        IVSInputDialog.InputListener r1 = this.e;
        if (r1 == null) goto L18;
        k82.a r4 = this.g;
        if (r4 == null) goto L16;
        EditText r5 = r4.a;
        if (r5 == null) goto L16;
        Editable r7 = r5.getText();
    L17:
        r1.onDismiss(new InputDraft(r7), this.l);
    L16:
        r7 = null;
    L18:
        this.k = false;
        this.j = false;
        this.l = false;
        super.onDismiss(r6);
        b0.o().getClass();
        g.i("ttlive_msg", "input dialog V3 dismiss");
        this.e = null;
    }

    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        Dialog r3 = getDialog();
        if (r3 == null) goto L8;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L8;
        r4.setLayout(-1, -1);
    L8:
        if (PadConfigUtils.c() == true) goto L10;
        return;
    L10:
        if (e5.g(getActivity()) == true) goto L18;
        Dialog r5 = getDialog();
        if (r5 == null) goto L19;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L20;
        r6.clearFlags(1024);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        MeasureLinearLayout r3 = this.f;
        if (r3 != null) goto L5;
    L7:
        dismissInputDialog();
        return;
    L5:
        if (f1.a().booleanValue() == false) goto L7;
        r3.b++;
        goto L7
    }

    public void onCreate(Bundle r3) {
        setStyle(1, 2131954667);
        super.onCreate(r3);
        setCancelable(true);
    }

    public final Dialog onCreateDialog(Bundle r8) {
        Dialog r9 = super.onCreateDialog(r8);
        r9.setCanceledOnTouchOutside(false);
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L5;
        return r9;
    L5:
        Window r2 = r9.getWindow();
        if (r2 == null) goto L22;
        r2.setGravity(80);
        r2.setLayout(-1, -2);
        r2.setBackgroundDrawable(new ColorDrawable(0));
        r2.setSoftInputMode(19);
        boolean r3 = e5.j(r1);
        if (PadConfigUtils.c() == false) goto L11;
        r3 = e5.f(r1.getRequestedOrientation());
    L11:
        if (r1.getRequestedOrientation() != 1) goto L13;
        boolean r4 = true;
    L15:
        if (PadConfigUtils.c() == false) goto L17;
        r4 = !e5.f(r1.getRequestedOrientation());
    L17:
        if (r3 == false) goto L19;
    L20:
        r2.addFlags(1024);
    L21:
        r2.clearFlags(2);
        goto L22
    L19:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(r1, r4, false) == true) goto L21;
    L13:
        r4 = false;
    L22:
        return r9;
    }

    public final void onDismiss(DialogInterface r2) {
        S90(r2);     // Catch: Throwable -> L5
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

    public final void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super.onSaveInstanceState(r2);
        this.k = this.j;
    }

    public final void setDataCenter(DataCenter r1) {
        this.i = r1;
    }

    public final void setInputListener(IVSInputDialog.InputListener r1) {
        this.e = r1;
    }

    public final void updateInput(String r2) {
        if (r2 == null) goto L9;
        k82.a r0 = this.g;
        if (r0 == null) goto L10;
        EditText r1 = r0.a;
        if (r1 == null) goto L11;
        r1.setText(r2);
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void show(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        f.d().c = true;
        f.d().a();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == false) goto L10;
    L7:
        b0.o().getClass();
        g.i("ttlive_msg", "input dialog v3 show");
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        super.show(r3, r4);
        goto L7
    }

    public final void showNow(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        f.d().c = true;
        f.d().a();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == false) goto L10;
    L7:
        b0.o().getClass();
        g.i("ttlive_msg", "input dialog V3 showNow");
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        super.showNow(r3, r4);
        goto L7
    }

    public final void show(Activity r2, String r3) {
        if ((r2 instanceof FragmentActivity) == false) goto L13;
        FragmentManager r4 = ((FragmentActivity) r2).getSupportFragmentManager();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, this, r0) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        show(r4, r3);
        return;
    L14:
        return;
    }

    public final void V90(long r10, int r13, int r14) {
        k82.a r0 = this.g;
        if (r0 == null) goto L5;
        EditText r1 = r0.a;
    L6:
        if (r1 == null) goto L14;
        if (r13 > r14) goto L17;
        if (r0 == null) goto L15;
        EditText r2 = r0.a;
        if (r2 == null) goto L16;
        r2.postDelayed(new b(r2, this, r10, r13, r14), r10);
        return;
    L16:
        return;
    L15:
        return;
    L17:
        return;
    L14:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = LayoutInflater.from(getContext()).inflate(getLayoutId(), r3, false);
        if ((r5 instanceof MeasureLinearLayout) == true) goto L5;
        r5 = null;
    L5:
        MeasureLinearLayout r6 = (MeasureLinearLayout) r5;
        this.f = r6;
        if (r6 != null) goto L9;
        ALogger.e("VSMsgBoardInputDialog", "inflate root view error");
        return null;
    L9:
        T90(r6);
        U90(r6);
        return this.f;
    }
}
