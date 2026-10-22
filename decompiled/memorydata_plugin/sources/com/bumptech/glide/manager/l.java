package com.bumptech.glide.manager;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map<Lifecycle, com.bumptech.glide.i> f922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n.a f923b;

    private final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FragmentManager f927b;

        a(l r1, FragmentManager r2) {
            this.f926a = r1;
            this.f927b = r2;
        }

        private void a(FragmentManager r6, Set<com.bumptech.glide.i> r7) {
            Set<com.bumptech.glide.i> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
            List<Fragment> r9 = r6.getFragments();
            int r0 = r9.size();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L8;
            Fragment r3 = (Fragment) ZeusTransformUtils.preCheckCast(r9.get(r2), Fragment.class, "com.obric.memorydata.plugin");
            a(r3.getChildFragmentManager(), r8);
            com.bumptech.glide.i r4 = this.f926a.a(r3.getLifecycle());
            if (r4 == null) goto L7;
            r8.add(r4);
        L7:
            r2 = r2 + 1;
            goto L3
        }

        @Override // com.bumptech.glide.manager.o
        public Set<com.bumptech.glide.i> a() {
            HashSet r0 = new HashSet();
            a(this.f927b, r0);
            return r0;
        }
    }

    l(n.a r3) {
        n.a r4 = (n.a) ZeusTransformUtils.wrapperContextForParams(r3, n.a.class, "com.obric.memorydata.plugin");
        this.f922a = new HashMap();
        this.f923b = r4;
    }

    com.bumptech.glide.i a(Context r4, com.bumptech.glide.c r5, final Lifecycle r6, FragmentManager r7, boolean r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.util.k.a();
        com.bumptech.glide.i r0 = a(r6);
        if (r0 != null) goto L9;
        LifecycleLifecycle r1 = new LifecycleLifecycle(r6);
        com.bumptech.glide.i r10 = this.f923b.a(r5, r1, new a(this, r7), r9);
        this.f922a.put(r6, r10);
        r1.addListener(new AnonymousClass1(this, r6));
        if (r8 == false) goto L8;
        r10.e();
    L8:
        return r10;
    L9:
        return r0;
    }

    com.bumptech.glide.i a(Lifecycle r2) {
        com.bumptech.glide.util.k.a();
        return (com.bumptech.glide.i) ZeusTransformUtils.preCheckCast(this.f922a.get(r2), com.bumptech.glide.i.class, "com.obric.memorydata.plugin");
    }
}
