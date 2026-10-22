package com.ss.android.lark.flow.passport.ui.widget.common;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0006\u0010\u0013\u001a\u00020\u0010J\b\u0010\u0014\u001a\u00020\u0010H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/flow/passport/ui/widget/common/FlowBaseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "loadingDialog", "Lcom/ss/android/lark/flow/passport/ui/widget/common/LoadingDialog;", "getLoadingDialog", "()Lcom/ss/android/lark/flow/passport/ui/widget/common/LoadingDialog;", "setLoadingDialog", "(Lcom/ss/android/lark/flow/passport/ui/widget/common/LoadingDialog;)V", "isShowBlackOnWhiteStatusBar", "", "()Z", "setShowBlackOnWhiteStatusBar", "(Z)V", "initLoadingDialog", "", "showLoadingDialog", "showLoading", "hideLoadingDialog", "hideLoading", "Companion", "flow-passport-ui_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class FlowBaseFragment extends Fragment {
    public static final /* synthetic */ int e = 0;
    public f d;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FlowBaseFragment a;

        public b(FlowBaseFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FlowBaseFragment r0 = this.a;     // Catch: Throwable -> L4
            int r1 = FlowBaseFragment.e;     // Catch: Throwable -> L4
            r0.hideLoading();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ FlowBaseFragment a;

        public c(FlowBaseFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FlowBaseFragment r0 = this.a;     // Catch: Throwable -> L4
            int r1 = FlowBaseFragment.e;     // Catch: Throwable -> L4
            r0.showLoading();     // Catch: Throwable -> L4
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

    public final void hideLoading() {
        f r0 = this.d;
        if (r0 != null) goto L6;
        PassportLog.b("FlowBaseFragment", "loadingDialog is null");
        return;
    L6:
        if (r0.isShowing() == true) goto L8;
    L28:
        PassportLog.d("FlowBaseFragment", "isShowing=" + r0.isShowing() + ",isRemoving=" + isRemoving() + ",isDetached()=" + isDetached());
        return;
    L8:
        if (isRemoving() == true) goto L28;
        if (isDetached() == true) goto L28;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r2 == null) goto L25;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        if (Looper.myLooper() == r1.getLooper()) goto L16;
        r1.post(DialogLancet.createDismissRunnable(r0));
    }

    public final void showLoading() {
        boolean r1 = true;
        if (this.d != null) goto L5;
        f r0 = new f(getActivity(), true);
        this.d = r0;
        r0.setOnKeyListener(e.a);
    L5:
        f r2 = this.d;
        if (r2 != null) goto L8;
    L25:
        StringBuilder r3 = new StringBuilder("isShowing=");
        f r4 = this.d;
        if (r4 == null) goto L28;
        Boolean r5 = Boolean.valueOf(r4.isShowing());
    L29:
        r3.append(r5);
        r3.append(",isRemoving=");
        r3.append(isRemoving());
        r3.append(",isDetached()=");
        r3.append(isDetached());
        PassportLog.d("FlowBaseFragment", r3.toString());
        return;
    L28:
        r5 = null;
        goto L29
    L8:
        if (r2 != null) goto L10;
    L12:
        r1 = false;
    L13:
        if (r1 == false) goto L25;
        if (isRemoving() == true) goto L25;
        if (isDetached() == true) goto L25;
        f r6 = this.d;
        if (r6 != null) goto L21;
        return;
    L21:
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L32;
        DialogLancet.handleBlockedDialogShow(r6);
        return;
    L32:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L24:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        return;
    L10:
        if (r2.isShowing() == true) goto L12;
        goto L12
    }

    public final void S90() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        hideLoading();
        return;
    L5:
        UICallbackExecutor.post(new b(this));
    }

    public final void T90() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        showLoading();
        return;
    L5:
        UICallbackExecutor.post(new c(this));
    }

    public FlowBaseFragment() {
    }
}
