package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m0 implements com.bytedance.android.scope.o {
    public final HashMap<String, ArrayList<sz1.a>> a;
    public final HashMap<String, ArrayList<com.bytedance.android.livesdk.gift.model.e3>> b;
    public final com.bytedance.android.livesdk.gift.platform.core.giftlist.i c;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f d;

    public static final class a<T> implements SingleOnSubscribe {
        public final /* synthetic */ m0 a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ long c;

        public a(m0 r1, ArrayList r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void subscribe(SingleEmitter<Object> r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            this.a.d(this.b, this.c);
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
        this.a.clear();
        this.b.clear();
    }

    public final void d(ArrayList<sz1.a> r3, long r4) {
        ArrayList<String> r0 = new ArrayList();
        Iterator<sz1.a> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(r5.next().convertToString());
        goto L4
    L6:
        Map<String, ArrayList<String>> r6 = ay1.b.b();
        r6.put(String.valueOf(r4), r0);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        ay1.b.y.setValue(null, ay1.b.a[27], r6);
    }

    public m0(e1 r2, com.bytedance.android.livesdk.gift.platform.core.giftlist.i r3, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f r4) {
        Intrinsics.checkNotNullParameter(r2, "giftListService");
        Intrinsics.checkNotNullParameter(r3, "giftListRepo");
        Intrinsics.checkNotNullParameter(r4, "giftDiyDataStore");
        this.c = r3;
        this.d = r4;
        this.a = new HashMap();
        this.b = new HashMap();
    }

    public final void c(ArrayList<com.bytedance.android.livesdk.gift.model.e3> r7, long r8, boolean r10) {
        ArrayList<sz1.a> r0 = this.a.get(String.valueOf(r8));
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        int r3 = 0;
    L7:
        sz1.a r4 = null;
        if (r3 >= r2) goto L18;
        if (r0 == null) goto L13;
        sz1.a r5 = (sz1.a) ListProtector.get(r0, r3);
        if (r5 == null) goto L13;
        ArrayList<com.bytedance.android.livesdk.gift.model.e3> r6 = gz1.c.g(r5);
    L15:
        if (gz1.c.h(r6, r7) == true) goto L18;
        r3 = r3 + 1;
    L13:
        r6 = null;
    L18:
        if (r10 == false) goto L61;
        ArrayList<sz1.a> r11 = this.d.a.get(String.valueOf(r8));
        if (r11 == null) goto L22;
        int r9 = r11.size();
    L23:
        int r13 = 0;
    L24:
        if (r13 >= r9) goto L34;
        if (r11 == null) goto L29;
        sz1.a r14 = (sz1.a) ListProtector.get(r11, r13);
        if (r14 == null) goto L29;
        ArrayList<com.bytedance.android.livesdk.gift.model.e3> r15 = gz1.c.g(r14);
    L31:
        if (gz1.c.h(r15, r7) == true) goto L35;
        r13 = r13 + 1;
    L35:
        if (r13 < 0) goto L41;
        if (r11 == null) goto L38;
        r1 = r11.size();
    L38:
        if (r13 >= r1) goto L41;
        if (r11 == null) goto L41;
        sz1.a r16 = (sz1.a) ListProtector.remove(r11, r13);
    L41:
        ArrayList<String> r17 = ay1.b.b().get(String.valueOf(r8));
        if (r17 != null) goto L44;
        r17 = new ArrayList();
    L44:
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L46:
        if (r19.hasNext() == false) goto L51;
        String r20 = (String) r19.next();
        sz1.a r21 = new sz1.a();
        r21.convertFromString(r20);
        if (gz1.c.h(r7, gz1.c.g(r21)) == false) goto L50;
        r4 = r21;
    L50:
        r18.add(r21);
        goto L46
    L51:
        if (r4 == null) goto L62;
        r18.remove(r4);
        Single.create(new a(this, r18, r8)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L62:
        return;
    L29:
        r15 = null;
        goto L31
    L34:
        r13 = -1;
        goto L35
    L22:
        r9 = 0;
        goto L23
    L61:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public static final void a(m0 r5, long r6, sz1.a r8, ArrayList r9) {
        r5.getClass();
        ArrayList<String> r0 = ay1.b.b().get(String.valueOf(r6));
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        ArrayList<sz1.a> r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
        sz1.a r3 = null;
    L7:
        if (r2.hasNext() == false) goto L18;
        String r4 = (String) r2.next();
        sz1.a r7 = new sz1.a();
        r7.convertFromString(r4);
        if (r8 != null) goto L11;
    L12:
        if (r9 == null) goto L16;
        if (gz1.c.h(r9, gz1.c.g(r7)) == false) goto L16;
    L15:
        r3 = r7;
    L16:
        r1.add(r7);
        goto L7
    L11:
        if (gz1.b.c(r7, r8) == true) goto L15;
    L18:
        if (r3 != null) goto L20;
        if (r8 == null) goto L27;
    L32:
        if (r8 == null) goto L40;
        ListProtector.add(r1, 0, r8);
        r5.d(r1, r6);
        return;
    L40:
        return;
    L27:
        if (Lists.isEmpty(r9) == true) goto L32;
        r8 = new sz1.a();
        if (r9 == null) goto L31;
        Intrinsics.checkNotNullParameter(r8, "$this$plugins");
        Intrinsics.checkNotNullParameter(r9, "value");
        r8.setPluginsFlex(r9);
    L31:
        r8.setRecommend(true);
        goto L32
    L20:
        if (r1.remove(r3) == false) goto L24;
        if (r8 != null) goto L23;
        r8 = r3;
    L23:
        ListProtector.add(r1, 0, r8);
    L24:
        r5.d(r1, r6);
    }
}
