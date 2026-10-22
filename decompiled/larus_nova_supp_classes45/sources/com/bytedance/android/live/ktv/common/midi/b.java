package com.bytedance.android.live.ktv.common.midi;

import com.bytedance.android.live.ktv.common.model.api.q0;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final /* synthetic */ int e = 0;
    public int a;
    public int b;
    public int c;
    public final ArrayList<InterfaceC0208b> d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.midi.b$b, reason: collision with other inner class name */
    public interface InterfaceC0208b {
        void a();
    }

    static {
    }

    public final void a() {
        this.b = 0;
        this.c = 0;
        this.a = -1;
    }

    public b() {
        this.a = -1;
        this.d = new ArrayList();
    }

    public static /* synthetic */ int c(b r1, float r2, int r3) {
        return r1.b(r2, r3, null);
    }

    public final int b(float r3, int r4, Map<String, q0> r5) {
        if (r4 != this.a) goto L6;
        return 0;
    L6:
        int r6 = p.a(r5, r3);
        e.b("HitComboCalculator", "score :" + r3 + " curHitType : " + r6 + " lastHitType : " + this.b + " sentenceIndex: " + r4 + " lastSentenceIndex: " + this.a);
        if (r6 == 3) goto L9;
    L11:
        this.c = 1;
    L12:
        this.b = r6;
        this.a = r4;
        if (KtvSettingHelper.z() == false) goto L15;
        KtvSettingHelper.l();
    L16:
        Iterator<InterfaceC0208b> r7 = this.d.iterator();
    L18:
        if (r7.hasNext() == false) goto L21;
        r7.next().a();
        goto L18
    L21:
        return this.c;
    L15:
        vm2.h.x();
        goto L16
    L9:
        if (r6 != this.b) goto L11;
        this.c++;
        goto L12
    }
}
