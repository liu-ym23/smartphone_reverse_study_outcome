package y81;

import com.bytedance.android.livesdkapi.business.OnLiveDouPlusDialogListener;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q implements OnLiveDouPlusDialogListener {
    public final /* synthetic */ l a;

    public final void onLiveDouPlusDialogDismiss() {
        DataCenter r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.put("data_dou_plus_dialog_showing", Boolean.FALSE);
        return;
    }

    public final void onLiveDouPlusDialogShow() {
        DataCenter r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.put("data_dou_plus_dialog_showing", Boolean.TRUE);
        return;
    }

    public q(l r1) {
        this.a = r1;
    }
}
