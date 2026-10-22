package com.bytedance.android.livesdk.gift.platform.core.manager;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements SingleOnSubscribe {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final void subscribe(SingleEmitter<Map<Integer, com.bytedance.android.livesdk.gift.platform.core.model.i>> r11) {
        Intrinsics.checkNotNullParameter(r11, "singleEmitter");
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().f() == false) goto L5;
        HashSet<String> r0 = (HashSet) ay1.b.x.getValue(null, ay1.b.a[26]);
        boolean r4 = true;
    L6:
        if (r0 != null) goto L8;
        r0 = new HashSet();
    L8:
        HashMap r5 = new HashMap(4);
        Iterator<String> r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L29;
        int r6 = CastIntegerProtector.parseInt(r1.next());
        if (r4 == false) goto L14;
        GiftManagerKt.z.getClass();
        String r7 = (String) new com.bytedance.android.livesdk.sharedpref.e("gift_list_response_v2_" + r6, BuildConfig.FLAVOR).getValue();
    L15:
        if (r7 != null) goto L17;
    L20:
        boolean r8 = true;
    L21:
        if (r8 == true) goto L10;
        com.bytedance.android.livesdk.gift.platform.core.model.i r9 = (com.bytedance.android.livesdk.gift.platform.core.model.i) GiftManagerKt.m.fromJson(r7, com.bytedance.android.livesdk.gift.platform.core.model.i.class);     // Catch: Exception -> L25
    L26:
        if (r9 == null) goto L10;
        r5.put(Integer.valueOf(r6), r9);
    L25:
        r9 = null;
        goto L26
    L17:
        if (r7.length() == 0) goto L20;
        r8 = false;
        goto L21
    L14:
        GiftManagerKt.z.getClass();
        r7 = (String) GiftManagerKt.w(r6).getValue();
        goto L15
    L29:
        r11.onSuccess(r5);
        return;
    L5:
        r0 = ay1.b.k();
        r4 = false;
        goto L6
    }
}
