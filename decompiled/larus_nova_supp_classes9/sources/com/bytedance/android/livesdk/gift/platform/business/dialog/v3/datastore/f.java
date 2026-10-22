package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements com.bytedance.android.scope.o {
    public final HashMap<String, ArrayList<sz1.a>> a;

    public final void onStart() {
    }

    public final void onStop() {
        this.a.clear();
    }

    public f() {
        this.a = new HashMap();
    }

    public static int c(List r4, com.bytedance.android.livesdk.gift.model.n r5) {
        Intrinsics.checkNotNullParameter(r5, "card");
        if (r4 == null) goto L12;
        Iterator r6 = r4.iterator();
        int r2 = 0;
    L6:
        if (r6.hasNext() == false) goto L11;
        if (gz1.b.c((com.bytedance.android.livesdk.gift.model.n) r6.next(), r5) == true) goto L13;
        r2 = r2 + 1;
    L13:
        if (r2 != (-1)) goto L16;
        return 0;
    L16:
        return r2;
    L11:
        r2 = -1;
        goto L13
    L12:
        r2 = 0;
        goto L13
    }

    public final List<com.bytedance.android.livesdk.gift.model.n> d(long r6, com.bytedance.android.livesdk.gift.model.p r8) {
        Intrinsics.checkNotNullParameter(r8, "diyGiftToolbarInfo");
        ArrayList r0 = new ArrayList();
        ArrayList<sz1.a> r1 = this.a.get(String.valueOf(r6));
        if (r1 != null) goto L11;
        r1 = new ArrayList();
        ArrayList<String> r2 = ay1.b.b().get(String.valueOf(r6));
        if (r2 == null) goto L10;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        String r4 = (String) r3.next();
        sz1.a r5 = new sz1.a();
        r5.convertFromString(r4);
        r1.add(r5);
    L10:
        this.a.put(String.valueOf(r6), r1);
    L11:
        ArrayList r7 = new ArrayList();
        if (r1.size() > r8.getMaxLocalCardNumber()) goto L14;
        r7.addAll(r1);
    L17:
        ArrayList<com.bytedance.android.livesdk.gift.model.n> r9 = new ArrayList();
        if (Lists.isEmpty(r8.getForceIndexCards()) == false) goto L20;
        ArrayList<com.bytedance.android.livesdk.gift.model.n> r10 = new ArrayList();
    L22:
        if (Lists.isEmpty(r8.getCards()) == false) goto L24;
        ArrayList<com.bytedance.android.livesdk.gift.model.n> r11 = new ArrayList();
    L25:
        Iterator r13 = r7.iterator();
    L27:
        if (r13.hasNext() == false) goto L35;
        sz1.a r14 = (sz1.a) r13.next();
        if (a(r14, r9, r10) == true) goto L27;
        if (a(r14, r9, r11) == true) goto L27;
        if (r14.isNewCard() == false) goto L27;
        r9.add(r14);
        goto L27
    L35:
        Iterator r15 = CollectionsKt.take(r10, r8.getMaxTotalCardNumber()).iterator();
    L37:
        if (r15.hasNext() == false) goto L39;
        r0.add((com.bytedance.android.livesdk.gift.model.n) r15.next());
        goto L37
    L39:
        Iterator r16 = CollectionsKt.take(r9, r8.getMaxTotalCardNumber() - r0.size()).iterator();
    L41:
        if (r16.hasNext() == false) goto L43;
        r0.add((com.bytedance.android.livesdk.gift.model.n) r16.next());
        goto L41
    L43:
        Iterator r17 = CollectionsKt.take(r11, r8.getMaxTotalCardNumber() - r0.size()).iterator();
    L45:
        if (r17.hasNext() == false) goto L47;
        r0.add((com.bytedance.android.livesdk.gift.model.n) r17.next());
        goto L45
    L47:
        return r0;
    L24:
        r11 = new ArrayList(r8.getCards());
        goto L25
    L20:
        r10 = new ArrayList(r8.getForceIndexCards());
        goto L22
    L14:
        int r18 = r8.getMaxLocalCardNumber();
        int r19 = 0;
    L15:
        if (r19 >= r18) goto L17;
        r7.add(ListProtector.get(r1, r19));
        r19 = r19 + 1;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(sz1.a r6, ArrayList<com.bytedance.android.livesdk.gift.model.n> r7, ArrayList<com.bytedance.android.livesdk.gift.model.n> r8) {
        int r0 = r8.size();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L19;
        if (gz1.c.h(gz1.c.g(r6), gz1.c.g((com.bytedance.android.livesdk.gift.model.n) ListProtector.get(r8, r2))) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        r1 = true;
        if (r6.isRecommend() == false) goto L17;
        com.bytedance.android.livesdk.gift.model.n r9 = (com.bytedance.android.livesdk.gift.model.n) ListProtector.get(r8, r2);
        Intrinsics.checkNotNullParameter(r9, "card");
        if ((!r9.getNotCache()) == false) goto L17;
        com.bytedance.android.livesdk.gift.model.n r10 = (com.bytedance.android.livesdk.gift.model.n) ListProtector.get(r8, r2);
        if (TextUtils.isEmpty(((com.bytedance.android.livesdk.gift.model.n) ListProtector.get(r8, r2)).getMainTextAfterSend()) == true) goto L15;
        String r3 = ((com.bytedance.android.livesdk.gift.model.n) ListProtector.get(r8, r2)).getMainTextAfterSend();
        if (r3 != null) goto L16;
        r3 = s1.B(2131916247);
    L16:
        r10.setMainText(r3);
        goto L17
    L15:
        r3 = s1.B(2131916247);
    L17:
        r7.add(ListProtector.get(r8, r2));
    L20:
        if (r2 >= 0) goto L22;
    L24:
        return r1;
    L22:
        if (r2 >= r8.size()) goto L24;
        ListProtector.remove(r8, r2);
        goto L24
    L19:
        r2 = -1;
        goto L20
    }
}
