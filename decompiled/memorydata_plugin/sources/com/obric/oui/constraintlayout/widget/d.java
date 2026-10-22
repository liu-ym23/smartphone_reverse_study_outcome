package com.obric.oui.constraintlayout.widget;

import android.util.SparseIntArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SparseIntArray f13781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<Integer, HashSet<WeakReference<a>>> f13782b;

    public interface a {
    }

    public d() {
        this.f13781a = new SparseIntArray();
        this.f13782b = new HashMap();
    }

    public void a(int r4, a r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        HashSet<WeakReference<a>> r0 = (HashSet) ZeusTransformUtils.preCheckCast(this.f13782b.get(Integer.valueOf(r4)), HashSet.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new HashSet();
        this.f13782b.put(Integer.valueOf(r4), r0);
    L5:
        r0.add(new WeakReference(r6));
    }

    public void b(int r6, a r7) {
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
        HashSet r5 = (HashSet) ZeusTransformUtils.preCheckCast(this.f13782b.get(Integer.valueOf(r6)), HashSet.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        ArrayList r9 = new ArrayList();
        Iterator r0 = r5.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.memorydata.plugin");
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2.get(), a.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        if (r3 != r8) goto L7;
    L11:
        r9.add(r2);
        goto L7
    L12:
        r5.removeAll(r9);
    }
}
