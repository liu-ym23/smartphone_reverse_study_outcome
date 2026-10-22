package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements SingleOnSubscribe {
    public final /* synthetic */ GiftListCacheRepo a;

    public i(GiftListCacheRepo r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Map<Integer, com.bytedance.android.livesdk.gift.platform.core.model.i>> r7) {
        Intrinsics.checkNotNullParameter(r7, "singleEmitter");
        HashSet<String> r0 = ay1.b.k();
        HashMap r1 = new HashMap();
        Iterator<String> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        int r3 = CastIntegerProtector.parseInt(r2.next());
        this.a.getClass();
        String r4 = (String) new com.bytedance.android.livesdk.sharedpref.e("gift_list_response_v3_" + r3, BuildConfig.FLAVOR).getValue();
        if (StringUtils.isEmpty(r4) == true) goto L4;
        com.bytedance.android.livesdk.gift.platform.core.model.i r5 = (com.bytedance.android.livesdk.gift.platform.core.model.i) this.a.a.fromJson(r4, com.bytedance.android.livesdk.gift.platform.core.model.i.class);     // Catch: Exception -> L10
    L11:
        if (r5 == null) goto L4;
        r1.put(Integer.valueOf(r3), r5);
    L10:
        r5 = null;
        goto L11
    L14:
        r7.onSuccess(r1);
    }
}
