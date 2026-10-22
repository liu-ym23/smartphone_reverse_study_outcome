package ii;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends c {
    public final /* synthetic */ int d;

    public /* synthetic */ a(int r5) {
        this.d = r5;
    }

    @Override // ii.c
    public final void b(Context r5, Intent r10) {
        switch(this.d) {
            case 0: goto L20;
            default: goto L4;
        };
    L4:
        hi.a r11 = this.f17572b;
        Uri r12 = r11.f17332j;
        if (r12 == null) goto L8;
        r10.setData(r12);
    L8:
        if ((r5 instanceof Activity) == false) goto L14;
        r5.startActivity(r10);
        if (r11.f17330h == (-1)) goto L12;
    L13:
        hi.a r13 = this.f17572b;
        ((Activity) r5).overridePendingTransition(r13.f17330h, r13.f17331i);
        return;
    L12:
        if (r11.f17331i != (-1)) goto L13;
        return;
    L14:
        r10.addFlags(268435456);
        r5.startActivity(r10);
        if (r11.f17330h == (-1)) goto L17;
    L18:
        Log.e("SmartRouter", "SmartRoute.withAnimation(int enterAnim, int exitAnim):the context must be Activity !!!");
        return;
    L17:
        if (r11.f17331i != (-1)) goto L18;
        return;
    L20:
        r5.sendBroadcast(r10);
    }
}
