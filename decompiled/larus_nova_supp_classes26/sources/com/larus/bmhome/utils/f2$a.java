package com.larus.bmhome.utils;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class f2$a implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ String b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (f2.b == true) goto L15;
        f2.b = true;
        FLogger r0 = FLogger.a;
        StringBuilder r2 = new StringBuilder("feedFirstShown by view: ");
        r2.append(this.a.getClass().getSimpleName());
        r2.append(", act: ");
        r2.append(this.a.getContext().getClass().getSimpleName());
        r2.append(", fragment: ");
        Fragment r3 = com.larus.utils.e1.k(this.a);
        if (r3 != null) goto L7;
        String r4 = "null";
    L8:
        r2.append(r4);
        r0.i("launch_trace", r2.toString());
        String r1 = this.b;
        Iterator r5 = new ArrayList(f2.d).iterator();
    L10:
        if (r5.hasNext() == false) goto L15;
        ((f2.b) r5.next()).a(r1);     // Catch: Throwable -> L14
        goto L10
    L7:
        r4 = r3.getClass().getSimpleName();
    L15:
        return true;
    }

    public f2$a(View r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
