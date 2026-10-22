package com.bytedance.android.livesdk.gift.platform.business.ai;

import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.gift.configmodel.c2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftAsyncSortManager {
    public static final Lazy e = null;
    public final HashMap<String, String> a;
    public boolean b;
    public final c2 c;
    public final b d;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ GiftAsyncSortManager a;

        public b(GiftAsyncSortManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.b == false) goto L9;
            JSONObject r0 = new JSONObject();     // Catch: Throwable -> L6
            r0.put("trigger_name", "livesdk_timer");     // Catch: Throwable -> L6
            this.a.a(r0, true);     // Catch: Throwable -> L6
            return;
        }
    }

    static {
        e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, GiftAsyncSortManager$Companion$INSTANCE$2.INSTANCE);
    }

    public GiftAsyncSortManager() {
        this.a = new HashMap();
        this.b = true;
        this.c = (c2) com.bytedance.android.livesdk.gift.platform.business.a.o.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[13]);
        this.d = new b(this);
    }

    public final void a(JSONObject r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (d.h() == false) goto L5;
        return;
    L5:
        if (this.c.a() == false) goto L13;
        c.b(rq2.a.class).triggerGiftAsyncSort(r3);
        if (r4 == true) goto L9;
        return;
    L9:
        if (this.b == false) goto L15;
        i0.c().postDelayed(this.d, this.c.c());
        return;
    L15:
        return;
    }
}
