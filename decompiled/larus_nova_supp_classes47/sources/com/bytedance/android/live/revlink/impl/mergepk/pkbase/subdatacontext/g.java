package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ MediatorLiveData a;

    public g(MediatorLiveData r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        List r4 = (List) r3;
        ArrayList r0 = new ArrayList();
        if (r4 == null) goto L8;
        Iterator r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r0.add(((cf2.a) r5.next()).d);
    L8:
        this.a.setValue(r0);
    }
}
