package com.bytedance.android.livesdk.dislike.sharefans.widget;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ mt1.a a;

    public a(mt1.a r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        if (((e) r5) == null) goto L19;
        pt1.a r6 = this.a.e;
        if (r6 == null) goto L17;
        Room r7 = r6.a;
        if (r7 == null) goto L17;
        pt1.a.b r1 = pt1.a.e;
        long r2 = r7.getRoomId();
        r1.getClass();
        ArrayList r8 = pt1.a.b.a();
        if (r8 != null) goto L13;
        r8 = new ArrayList();
    L13:
        r8.add(Long.valueOf(r2));
        if (r8.size() < 20) goto L16;
        ListProtector.remove(r8, 0);
    L16:
        pt1.a.b.setValue(GsonProtectorUtils.toJson(pt1.a.c, r8));
    L17:
        f2.b(2131922502, 0);
        return;
    }
}
