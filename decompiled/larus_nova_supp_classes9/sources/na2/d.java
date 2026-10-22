package na2;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.n;
import com.bytedance.android.livesdk.interactivity.publicscreen.stylesetting.ui.PublicScreenStyleSettingDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ PublicScreenStyleSettingDialog a;

    public d(PublicScreenStyleSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        PublicScreenStyleSettingDialog r4 = this.a;
        int r0 = PublicScreenStyleSettingDialog.u;
        r4.getClass();
        r4.dismiss();     // Catch: Exception -> L5
    L9:
        r4.t.h();
        n.a r5 = r4.d;
        if (r5 == null) goto L15;
        r5.onFinish();
        return;
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L9;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
