package s12;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.format.panel.view.FormatGiftDialog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ FormatGiftDialog a;

    public a(FormatGiftDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        FormatGiftDialog r0 = this.a;
        FormatGiftDialog.S90(r0, (GiftStateMachineConfig.g) r2);
    }
}
