package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p implements com.bytedance.android.scope.o, dy0.c {
    public final Map<Long, Integer> a;
    public boolean b;
    public final a c;

    public static final class a implements IAssetsManager.b {
        public final /* synthetic */ p a;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void a() {
        }

        public a(p r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void b(List<? extends com.bytedance.android.live.core.resources.e> r6) {
            Intrinsics.checkNotNullParameter(r6, "assetsModels");
            if (com.bytedance.android.livesdk.gift.platform.business.effect.a.b() == true) goto L5;
            return;
        L5:
            if (((HashMap) this.a.a).isEmpty() == true) goto L23;
            Iterator<T> r7 = r6.iterator();
        L9:
            if (r7.hasNext() == false) goto L24;
            long r0 = ((com.bytedance.android.live.core.resources.e) r7.next()).getId();
            if (((HashMap) this.a.a).keySet().contains(Long.valueOf(r0)) == false) goto L9;
            p r2 = this.a;
            Map<Long, Integer> r3 = r2.a;
            HashMap r4 = (HashMap) r3;
            Integer r5 = (Integer) r4.get(Long.valueOf(r0));
            if (r5 == null) goto L15;
            int r8 = r5.intValue();
        L16:
            r2.f(r0, r8);
            goto L9
        L15:
            r8 = IAssetsManager.DownloadAssetsSource.SOURCE_JSB_PRELOADING;
            goto L16
        L24:
            return;
        }
    }

    public final void onStart() {
    }

    public p() {
        this.a = new HashMap();
        this.c = new a(this);
    }

    public final void onStop() {
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.b() == false) goto L11;
        IGiftService r0 = jc1.k.f(IGiftService.class);
        if (r0 == null) goto L9;
        IAssetsManager r1 = r0.getAssetsManager();
        if (r1 == null) goto L9;
        r1.l0(this.c);
    L9:
        ((HashMap) this.a).clear();
        this.b = false;
        return;
    }

    public final void a(long r3, int r5) {
        if (this.b == false) goto L6;
    L13:
        Map<Long, Integer> r0 = this.a;
        HashMap r1 = (HashMap) r0;
        r1.put(Long.valueOf(r3), Integer.valueOf(r5));
        return;
    L6:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.b() == false) goto L13;
        IGiftService r2 = jc1.k.f(IGiftService.class);
        if (r2 == null) goto L12;
        IAssetsManager r4 = r2.getAssetsManager();
        if (r4 == null) goto L12;
        r4.T(this.c);
    L12:
        this.b = true;
        goto L13
    }

    public final void f(long r7, int r9) {
        Intrinsics.checkNotNullParameter("JSB", "source");
        IGiftService r0 = jc1.k.f(IGiftService.class);
        if (r0 == null) goto L6;
        r0.downloadAssets("JSB", r7, new o(this), r9);
        return;
    }
}
