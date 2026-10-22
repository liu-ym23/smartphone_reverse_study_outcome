package com.bytedance.android.livesdk.gecko;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.geckox.model.UpdatePackage;
import io.reactivex.ObservableEmitter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements xo2.c.a {
    public final /* synthetic */ String a;

    public c(String r1) {
        this.a = r1;
    }

    public final void a(UpdatePackage r5, long r6, long r8) {
        if (r6 == 0) goto L15;
        Set<j.a> r7 = d.a;
        Set r9 = (Set) ((LinkedHashMap) d.b).get(this.a);
        if (r9 == null) goto L21;
        Iterator r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L22;
        ObservableEmitter r0 = (ObservableEmitter) ((WeakReference) r10.next()).get();
        if (r0 == null) goto L8;
        if (v.a() == false) goto L14;
        ALogger.d("AAM.Source.GeckoHelper", "[" + r0.hashCode() + "] progress: " + r8 + " / " + r6);
    L14:
        r0.onNext(new j.c((100 * r8) / r6));
        goto L8
    L22:
        return;
    L21:
        return;
    }
}
