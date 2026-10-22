package com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource;

import c12.n;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.core.resources.k;
import com.bytedance.android.live.core.resources.l;
import com.bytedance.android.live.core.resources.m;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.gift.configmodel.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends DefaultResourceSupport {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final boolean a(e r5) {
        if (((h) this.b.getValue()).Z6() == false) goto L20;
        c12.e r0 = g(r5, 0);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r3 = GiftResourceManagerFactory.a();
        if (r3 != null) goto L7;
    L9:
        n r1 = f(r5, 0);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r4 = GiftResourceManagerFactory.a();
        if (r4 != null) goto L12;
    L14:
        c12.e r6 = e(r5, 0);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r2 = GiftResourceManagerFactory.a();
        if (r2 != null) goto L17;
    L19:
        return false;
    L17:
        if (r2.e(r6) != true) goto L19;
        return true;
    L12:
        if (r4.e(r1) != true) goto L14;
        return true;
    L7:
        if (r3.e(r0) != true) goto L9;
        return true;
    L20:
        Iterator r7 = ((ArrayList) b(r5, 0)).iterator();
    L22:
        if (r7.hasNext() == false) goto L28;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r8 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r7.next();
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r9 = GiftResourceManagerFactory.a();
        if (r9 == null) goto L22;
        if (r9.e(r8) != true) goto L22;
        return true;
    L28:
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final boolean d(e r4) {
        if (DefaultResourceSupport.h(r4) == false) goto L5;
        return true;
    L5:
        if (DefaultResourceSupport.i(r4) == false) goto L7;
        return true;
    L7:
        if (r4 != null) goto L10;
    L34:
        boolean r5 = false;
    L35:
        if (r5 == true) goto L41;
        return false;
    L41:
        return true;
    L10:
        if (r4.getH265SuperResourceModel() == null) goto L34;
        k r2 = r4.getH265SuperResourceModel();
        if (r2 == null) goto L15;
        String r3 = r2.getMd5();
    L16:
        if (r3 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == true) goto L34;
        k r7 = r4.getH265SuperResourceModel();
        if (r7 == null) goto L34;
        l r8 = r7.getResourceModel();
        if (r8 == null) goto L34;
        List r9 = m.a(r8);
        if (r9 == null) goto L34;
        if (r9.isEmpty() == true) goto L34;
        r5 = true;
        goto L35
    L18:
        if (r3.length() == 0) goto L21;
        r6 = false;
        goto L22
    L15:
        r3 = null;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final List<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> b(e r3, int r4) {
        ArrayList r0 = new ArrayList();
        c12.e r1 = e(r3, r4);
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        n r2 = f(r3, r4);
        if (r2 == null) goto L8;
        r0.add(r2);
    L8:
        c12.e r5 = g(r3, r4);
        if (r5 == null) goto L11;
        r0.add(r5);
    L11:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.d
    public final c12.e c(e r5, int r6) {
        if (r5 != null) goto L5;
    L28:
        c12.e r1 = g(r5, r6);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r2 = GiftResourceManagerFactory.a();
        if (r2 != null) goto L31;
    L33:
        c12.e r3 = e(r5, r6);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r4 = GiftResourceManagerFactory.a();
        if (r4 != null) goto L36;
    L38:
        n r7 = f(r5, r6);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r8 = GiftResourceManagerFactory.a();
        if (r8 != null) goto L41;
    L43:
        if (r1 == null) goto L45;
        return r1;
    L45:
        if (r7 == null) goto L47;
        return r7;
    L47:
        return r3;
    L41:
        if (r8.e(r7) != true) goto L43;
        return r7;
    L36:
        if (r4.e(r3) != true) goto L38;
        return r3;
    L31:
        if (r2.e(r1) != true) goto L33;
        return r1;
    L5:
        if (r5.getResourceType() != 4) goto L28;
        if (((h) this.b.getValue()).r7() == false) goto L28;
        c12.e r9 = g(r5, r6);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r10 = GiftResourceManagerFactory.a();
        if (r10 != null) goto L11;
    L13:
        n r11 = f(r5, r6);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r13 = GiftResourceManagerFactory.a();
        if (r13 != null) goto L16;
    L18:
        c12.e r14 = e(r5, r6);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r15 = GiftResourceManagerFactory.a();
        if (r15 != null) goto L21;
    L23:
        if (r9 == null) goto L25;
        return r9;
    L25:
        if (r11 == null) goto L27;
        return r11;
    L27:
        return r14;
    L21:
        if (r15.e(r14) != true) goto L23;
        return r14;
    L16:
        if (r13.e(r11) != true) goto L18;
        return r11;
    L11:
        if (r10.e(r9) != true) goto L13;
        return r9;
    }
}
