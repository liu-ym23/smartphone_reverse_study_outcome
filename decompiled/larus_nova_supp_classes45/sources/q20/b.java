package q20;

import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ r20.a a;

    public b(r20.a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        new AlertDialog.Builder(r2.getContext()).setTitle("详情").setMessage(this.a.c.toString()).show();
    }
}
