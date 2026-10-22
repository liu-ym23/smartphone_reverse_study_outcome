package com.bytedance.android.livesdk.dsl.recyclerview;

import com.bytedance.android.live.core.log.ALogger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class b implements e {
    public WeakReference<BaseDSLViewHolder> a;
    public Long b;
    public HashMap<String, Object> c;
    public int d;
    public HashMap<String, Object> e;
    public final String f;
    public final int g;
    public final String h;

    @Override // com.bytedance.android.livesdk.dsl.recyclerview.e
    public final String getGroupId() {
        return this.h;
    }

    @Override // com.bytedance.android.livesdk.dsl.recyclerview.e
    public final int getItemType() {
        return this.g;
    }

    public final void a(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        if (this.e != null) goto L5;
        this.e = new HashMap();
    L5:
        HashMap<String, Object> r0 = this.e;
        if (r0 == null) goto L11;
        r0.putAll(r2);
        HashMap<String, Object> r3 = this.c;
        if (r3 == null) goto L12;
        r3.putAll(r0);
        return;
    L12:
        return;
    }

    public final void b(Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        long r0 = System.currentTimeMillis();
        String r2 = com.bytedance.android.livesdk.dsl.util.c.d(r7, "merge_type");
        if (r2 != null) goto L6;
        r2 = "1";
    L6:
        if (r2.hashCode() == 49) goto L9;
    L13:
        this.c = new HashMap(r7);
    L14:
        WeakReference<BaseDSLViewHolder> r8 = this.a;
        if (r8 == null) goto L17;
        BaseDSLViewHolder r9 = r8.get();
    L18:
        if (r9 == null) goto L23;
        b r3 = r9.a;
        if (r3 != null) goto L22;
        nq.a.c(null, BaseDSLViewHolder$updateData$1.INSTANCE, 1);
        goto L23
    L22:
        r9.U3(r3, true);
    L23:
        ALogger.d("DSLItem", "update cost " + (System.currentTimeMillis() - r0));
        return;
    L17:
        r9 = null;
        goto L18
    L9:
        if (r2.equals("1") == false) goto L13;
        HashMap<String, Object> r4 = this.c;
        if (r4 == null) goto L14;
        r4.putAll(r7);
        goto L14
    }

    public b(String r1, int r2, String r3) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.d = -1;
    }
}
