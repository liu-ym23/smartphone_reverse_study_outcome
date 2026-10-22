package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.ability;

import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.livesdk.sharedpref.c;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements SingleOnSubscribe {
    public final /* synthetic */ List a;

    public a(List r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Gson r5 = new Gson();
        ArrayList r0 = new ArrayList(this.a.size());
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(GsonProtectorUtils.toJson(r5, (h) r1.next()));
        goto L4
    L6:
        e r6 = c.m;
        r6.getClass();
        f.d(r6, r0);
    }
}
