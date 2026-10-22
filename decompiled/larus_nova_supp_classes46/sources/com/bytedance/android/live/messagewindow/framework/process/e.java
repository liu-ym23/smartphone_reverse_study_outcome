package com.bytedance.android.live.messagewindow.framework.process;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements h71.e {
    public final h71.b a;

    public final float a() {
        h71.b r0 = this.a;
        float r1 = 0.0f;
        if (r0 == null) goto L14;
        HashMap r2 = r0.k();
        if (r2 == null) goto L14;
        Iterator r3 = r2.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) r3.next();
        Float r5 = ((h71.a) r4.getValue()).c;
        if (r5 == null) goto L8;
        float r6 = r5.floatValue();
        if (((h71.a) r4.getValue()).a == false) goto L8;
        r1 = Math.max(r1, r6 + r1);
    L14:
        return r1;
    }

    public final float b() {
        h71.b r0 = this.a;
        float r1 = 0.0f;
        if (r0 == null) goto L14;
        HashMap r2 = r0.k();
        if (r2 == null) goto L14;
        Iterator r3 = r2.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) r3.next();
        Float r5 = ((h71.a) r4.getValue()).e;
        if (r5 == null) goto L8;
        float r6 = r5.floatValue();
        if (((h71.a) r4.getValue()).a == false) goto L8;
        r1 = Math.max(r1, r6 + r1);
    L14:
        return r1;
    }

    public final float c() {
        h71.b r0 = this.a;
        float r1 = 0.0f;
        if (r0 == null) goto L14;
        HashMap r2 = r0.k();
        if (r2 == null) goto L14;
        Iterator r3 = r2.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) r3.next();
        Float r5 = ((h71.a) r4.getValue()).d;
        if (r5 == null) goto L8;
        float r6 = r5.floatValue();
        if (((h71.a) r4.getValue()).a == false) goto L8;
        r1 = Math.max(r1, r6 + r1);
    L14:
        return r1;
    }

    public final float d() {
        h71.b r0 = this.a;
        float r1 = 0.0f;
        if (r0 == null) goto L14;
        HashMap r2 = r0.k();
        if (r2 == null) goto L14;
        Iterator r3 = r2.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) r3.next();
        Float r5 = ((h71.a) r4.getValue()).b;
        if (r5 == null) goto L8;
        float r6 = r5.floatValue();
        if (((h71.a) r4.getValue()).a == false) goto L8;
        r1 = Math.max(r1, r6 + r1);
    L14:
        return r1;
    }

    public e(c r2) {
        Intrinsics.checkNotNullParameter(r2, "liveComponentsStatusHolder");
        this.a = r2;
    }
}
