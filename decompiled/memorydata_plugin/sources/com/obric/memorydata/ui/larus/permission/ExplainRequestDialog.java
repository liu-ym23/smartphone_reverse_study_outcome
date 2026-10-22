package com.obric.memorydata.ui.larus.permission;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/ui/larus/permission/ExplainRequestDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", LocationMonitorConst.TAG, "", "", "transaction", "Landroidx/fragment/app/FragmentTransaction;", "showNow", "dismiss", "Companion", "larus_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExplainRequestDialog extends DialogFragment {
    private static final String ARG_SUB_TITLE = "explain_request_dialog_subtitle";
    private static final String ARG_TITLE = "explain_request_dialog_title";
    public static final a Companion = null;
    public static final String TAG = "ExplainRequestDialog";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/ui/larus/permission/ExplainRequestDialog$Companion;", "", "<init>", "()V", "TAG", "", "ARG_TITLE", "ARG_SUB_TITLE", "newInstance", "Lcom/obric/memorydata/ui/larus/permission/ExplainRequestDialog;", "title", "subTitle", "larus_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final ExplainRequestDialog a(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r4, "subTitle");
            ExplainRequestDialog r2 = new ExplainRequestDialog();
            Bundle r0 = new Bundle();
            r0.putString(ExplainRequestDialog.ARG_TITLE, r3);
            r0.putString(ExplainRequestDialog.ARG_SUB_TITLE, r4);
            r2.setArguments(r0);
            return r2;
        }
    }

    static {
        Companion = new a(null);
    }

    public ExplainRequestDialog() {
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();     // Catch: IllegalStateException -> L4
        return;
    L4:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "dismiss crashed: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r8) {
        AlertDialog.Builder r9 = new AlertDialog.Builder((Context) ZeusTransformUtils.preCheckCast((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        String r3 = null;
        View r0 = ZeusTransformUtils.inflate(getLayoutInflater(), ZeusTransformUtils.mapRes(R.layout.larus_dialog_explain_permission, "layout", "larus_dialog_explain_permission"), null, "com.obric.memorydata.plugin");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.dialog_permission_title, OaidModel.KEY_ID, "dialog_permission_title")), TextView.class, "com.obric.memorydata.plugin");
        TextView r4 = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.dialog_permission_subtitle, OaidModel.KEY_ID, "dialog_permission_subtitle")), TextView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        Bundle r5 = getArguments();
        if (r5 == null) goto L7;
        String r6 = r5.getString(ARG_TITLE);
    L8:
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
        goto L9
    L7:
        r6 = null;
    L9:
        if (r4 == null) goto L14;
        Bundle r7 = getArguments();
        if (r7 == null) goto L13;
        r3 = r7.getString(ARG_SUB_TITLE);
    L13:
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    L14:
        r9.setView(r0);
        AlertDialog r10 = r9.create();
        Intrinsics.checkNotNullExpressionValue(r10, "create(...)");
        Window r11 = r10.getWindow();
        if (r11 == null) goto L19;
        WindowManager.LayoutParams r12 = r11.getAttributes();
        if (r12 == null) goto L19;
        r12.width = -1;
        r12.gravity = 48;
    L19:
        Window r13 = r10.getWindow();
        if (r13 == null) goto L22;
        r13.setBackgroundDrawableResource(ZeusTransformUtils.mapRes(R.drawable.larus_toast_background, "drawable", "larus_toast_background"));
    L22:
        Window r14 = r10.getWindow();
        if (r14 == null) goto L26;
        r14.clearFlags(2);
    L26:
        return (Dialog) ZeusTransformUtils.preCheckCast(r10, Dialog.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.DialogFragment
    public int show(FragmentTransaction r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "transaction");
        return super.show(r3, r4);
    L5:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "show(transaction) crashed: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return -1;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        super.show(r3, r4);     // Catch: IllegalStateException -> L5
        return;
    L5:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "show crashed: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.fragment.app.DialogFragment
    public void showNow(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        super.showNow(r3, r4);     // Catch: IllegalStateException -> L5
        return;
    L5:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "showNow crashed: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
