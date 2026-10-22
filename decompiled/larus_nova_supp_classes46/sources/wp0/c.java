package wp0;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.sellingpoint.ShelfManagementSellingPointSettingDialog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements TextView.OnEditorActionListener {
    public final /* synthetic */ ShelfManagementSellingPointSettingDialog a;

    public c(ShelfManagementSellingPointSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 4) goto L5;
    L14:
        ShelfManagementSellingPointSettingDialog r4 = this.a;
        ShelfManagementSellingPointSettingDialog.T90(r4, ((EditText) r4.S90(2131371463)).getText().toString());
        return true;
    L5:
        if (r2 == 6) goto L14;
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.getAction() == 0) goto L10;
        return false;
    L10:
        if (r3.getKeyCode() == 66) goto L14;
        return false;
    }
}
