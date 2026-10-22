package u80;

import android.text.Editable;
import com.bytedance.android.live.core.utils.d2;
import com.bytedance.android.live.core.verify.fragment.CommonVerifyFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i extends d2 {
    public final /* synthetic */ CommonVerifyFragment a;

    public i(CommonVerifyFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.core.utils.d2, android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
        CommonVerifyFragment.T90(this.a);
    }
}
