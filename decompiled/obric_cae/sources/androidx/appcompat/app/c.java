package androidx.appcompat.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes.dex */
public final class c implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlertController f639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertController.b f640b;

    public c(AlertController.b r8, AlertController r10) {
        this.f640b = r8;
        this.f639a = r10;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r8, View r10, int r11, long r12) {
        AlertController.b r13 = this.f640b;
        DialogInterface.OnClickListener r14 = r13.f569h;
        AlertController r15 = this.f639a;
        r14.onClick(r15.f536b, r11);
        if (r13.f570i == true) goto L6;
        r15.f536b.dismiss();
        return;
    }
}
