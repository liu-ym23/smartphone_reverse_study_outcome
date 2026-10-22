package c;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public final class h implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1054b;

    public h(d r5, String r10) {
        this.f1054b = r5;
        this.f1053a = r10;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r10) {
        String r11 = this.f1053a;
        f r12 = this.f1054b.f1032a;
        if (ContextCompat.checkSelfPermission(r12, "android.permission.CALL_PHONE") == 0) goto L10;
        ActivityCompat.requestPermissions(r12, new String[]{"android.permission.CALL_PHONE"}, 1);
        return;
    L10:
        Intent r13 = new Intent("android.intent.action.CALL");     // Catch: Exception -> L6
        r13.setData(Uri.parse("tel:".concat(r11)));     // Catch: Exception -> L6
        r13.addFlags(268435456);     // Catch: Exception -> L6
        s0.g(r12, r13);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        m.i("DetailViewAdapter", "realCallPhone: " + e);
    }
}
