package x59;

import android.text.Editable;
import android.text.TextWatcher;
import com.larus.dora.impl.noti_v3.special_contacts.dialog.NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements TextWatcher {
    public final /* synthetic */ NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public c(NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r2) {
        NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment r3 = this.a;
        int r0 = NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment.g;
        r3.S90();
    }
}
