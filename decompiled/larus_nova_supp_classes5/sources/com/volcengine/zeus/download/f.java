package com.volcengine.zeus.download;

import android.app.Activity;
import com.volcengine.zeus.EmptyActivityLifecycleCallbacks;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import dqc.d;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public static volatile f b;
    public final List<String> a;

    public class a extends EmptyActivityLifecycleCallbacks {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // com.volcengine.zeus.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r4) {
            Iterator r5 = ((CopyOnWriteArrayList) this.a.a).iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            String r0 = (String) r5.next();
            j.b().a(r0, false);
            goto L4
        }
    }

    public f() {
        this.a = new CopyOnWriteArrayList();
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(new a(this));
    }

    public final void a(String r2, boolean r3) {
        if (d.d(Zeus.getAppApplication()) == true) goto L5;
        return;
    L5:
        if (GlobalParam.getInstance().autoFetch() == false) goto L9;
        j.b().c(r2);
        j.b().a(r2, r3);
        if (((CopyOnWriteArrayList) this.a).contains(r2) == true) goto L12;
        ((CopyOnWriteArrayList) this.a).add(r2);
        return;
    L12:
        return;
    L9:
        j.b().a(r2, r3);
    }
}
