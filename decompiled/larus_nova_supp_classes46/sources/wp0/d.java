package wp0;

import android.view.View;
import android.widget.EditText;
import com.bytedance.android.live.openplatform.impl.miniappanchor.sellingpoint.ShelfManagementSellingPointSettingDialog;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements View.OnFocusChangeListener {
    public final /* synthetic */ ShelfManagementSellingPointSettingDialog a;

    public static final class a implements Runnable {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((EditText) this.a.a.S90(2131371463)).setSelection(((EditText) this.a.a.S90(2131371463)).getText().toString().length());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public d(ShelfManagementSellingPointSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r1, boolean r2) {
        if (r2 == false) goto L5;
        r1.post(new a(this));
        return;
    }
}
