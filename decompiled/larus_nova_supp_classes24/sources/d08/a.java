package d08;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import j08.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ float b;
    public final /* synthetic */ double c;

    public final void a() {
        if (this.a != null) goto L5;
        return;
    L5:
        Log.i("LKUIStatus", "setViewOnScreenTranslation translationY =" + this.b);
        float r0 = this.b;
        if (r0 <= 0.0f) goto L9;
        this.a.setTranslationY(r0);
        return;
    L9:
        float r1 = (float) (((double) d.c(this.a.getContext()).b) * this.c);
        int[] r2 = new int[2];
        this.a.getLocationOnScreen(r2);
        float r3 = r2[1];
        Log.i("LKUIStatus", "distance of the view relative to the top of the screen：" + r3);
        this.a.setTranslationY(r1 - (r3 - this.a.getTranslationY()));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(View r1, float r2) {
        this.a = r1;
        this.b = r2;
        this.c = 0.33d;
    }
}
