package com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource;

import c12.n;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.gift.configmodel.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends DefaultResourceSupport {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.a$a, reason: collision with other inner class name */
    public static final class C0049a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final boolean a(e r5) {
        if (((h) this.b.getValue()).Z6() == false) goto L15;
        n r0 = f(r5, 0);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r3 = GiftResourceManagerFactory.a();
        if (r3 != null) goto L7;
    L9:
        c12.e r6 = e(r5, 0);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r1 = GiftResourceManagerFactory.a();
        if (r1 != null) goto L12;
    L14:
        return false;
    L12:
        if (r1.e(r6) != true) goto L14;
        return true;
    L7:
        if (r3.e(r0) != true) goto L9;
        return true;
    L15:
        Iterator r7 = ((ArrayList) b(r5, 0)).iterator();
    L17:
        if (r7.hasNext() == false) goto L23;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r2 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r7.next();
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r4 = GiftResourceManagerFactory.a();
        if (r4 == null) goto L17;
        if (r4.e(r2) != true) goto L17;
        return true;
    L23:
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final boolean d(e r2) {
        if (DefaultResourceSupport.h(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (DefaultResourceSupport.i(r2) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final List<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> b(e r3, int r4) {
        ArrayList r0 = new ArrayList();
        c12.e r1 = e(r3, r4);
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        n r5 = f(r3, r4);
        if (r5 == null) goto L8;
        r0.add(r5);
    L8:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final c12.e c(e r4, int r5) {
        if (r4 != null) goto L4;
    L14:
        c12.e r0 = e(r4, r5);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r1 = GiftResourceManagerFactory.a();
        if (r1 != null) goto L17;
    L19:
        n r6 = f(r4, r5);
        if (r6 == null) goto L22;
        return r6;
    L22:
        return r0;
    L17:
        if (r1.e(r0) != true) goto L19;
        return r0;
    L4:
        if (r4.getResourceType() != 4) goto L14;
        if (((h) this.b.getValue()).r7() == false) goto L14;
        if (r4.getH265ResourceModel() == null) goto L13;
        n r2 = f(r4, r5);
        if (r2 == null) goto L13;
        return r2;
    L13:
        return e(r4, r5);
    }
}
