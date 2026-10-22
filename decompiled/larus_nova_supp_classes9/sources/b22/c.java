package b22;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.vs.panel.view.VSGiftDialogFragmentNew;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ VSGiftDialogFragmentNew a;

    public c(VSGiftDialogFragmentNew r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        VSGiftDialogFragmentNew r0 = this.a;
        VSGiftDialogFragmentNew.T90(r0, (GiftStateMachineConfig.g) r2);
    }
}
