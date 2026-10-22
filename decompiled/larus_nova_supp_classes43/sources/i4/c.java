package i4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Resources;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;
import com.bytedance.ai.bridge.service.ActionSheetBuilder;
import com.bytedance.ai.bridge.service.DialogBuilder;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.bridge.service.PageTitleBar;
import com.bytedance.ai.bridge.service.ShowActionSheetListener;
import com.bytedance.ai.bridge.service.ToastBuilder;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements IHostStyleUIDepend {
    public static Toast a;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean hideLoading(e3.a r1) {
        return null;
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final void setPageNaviStyle(e3.a r1, Activity r10, PageTitleBar r11) {
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean showLoading(e3.a r1) {
        return null;
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean hideToast(e3.a r1) {
        Toast r10 = a;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        a = null;
        return Boolean.TRUE;
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean showDialog(final DialogBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "dialogBuilder");
        if (r10.getEditable() == false) goto L5;
        final EditText r0 = new EditText(r10.getContext());
        r0.setInputType(131073);
        r0.setMaxLines(4);
        r0.setHint(r10.getPlaceholderText());
        r0.setSingleLine(false);
        Resources r11 = r0.getResources();
        int r12 = (int) (20 * WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).density);
        Resources r13 = r0.getResources();
        int r14 = (int) (8 * WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics()).density);
        r0.setPadding(r12, r14, r12, r14);
    L6:
        AlertDialog.Builder r15 = new AlertDialog.Builder(r10.getContext()).setTitle(r10.getTitle()).setMessage(r10.getMessage());
        if (r0 == null) goto L9;
        r15.setView(r0);
    L9:
        r15.setPositiveButton(r10.getPositiveBtnText(), null);
        if (r10.getNegativeBtnText() == null) goto L12;
        r15.setNegativeButton(r10.getNegativeBtnText(), r10.getNegativeClickListener());
    L12:
        final AlertDialog r1 = r15.create();
        r1.setCanceledOnTouchOutside(r10.getCancelOnTouchOutside());
        r1.setCancelable(r10.getCancelOnTouchOutside());
        r1.setOnCancelListener(r10.getCancelOnTouchOutsideListener());
        r1.setOnShowListener(new i4.a(r1, r10, r0));
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(r1);
    L17:
        if (r0 == null) goto L22;
        r0.requestFocus();
        Window r16 = r1.getWindow();
        if (r16 == null) goto L22;
        r16.setSoftInputMode(5);
    L22:
        return Boolean.TRUE;
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L16:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean showToast(ToastBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "toastBuilder");
        Toast r0 = a;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Toast r11 = Toast.makeText(r10.getContext().getApplicationContext(), r10.getMessage(), 0);
        r11.show();
        a = r11;
        return Boolean.TRUE;
    }

    @Override // com.bytedance.ai.bridge.service.IHostStyleUIDepend
    public final Boolean showActionSheet(ActionSheetBuilder r10, ShowActionSheetListener r11) {
        Intrinsics.checkNotNullParameter(r10, "actionSheetBuilder");
        Intrinsics.checkNotNullParameter(r11, "showActionSheetListener");
        return null;
    }
}
