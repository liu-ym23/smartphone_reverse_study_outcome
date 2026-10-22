package d6;

import ai.j0;
import android.text.TextUtils;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.concurrent.CopyOnWriteArrayList;
import jg.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends jg.a {
    public final /* synthetic */ c d;

    public a(c r5) {
        this.d = r5;
    }

    @Override // jg.a
    public final void a() {
        char r5 = 0;
        this.f18321a = false;
        c r10 = this.d;
        boolean r11 = r10.e;
        long r12 = jg.a.f18319b;
        long[] r13 = r10.f16601c;
        char r14 = 1;
        r13[1] = r12;
        char r15 = 3;
        r13[3] = jg.a.f18320c;
        CopyOnWriteArrayList r16 = r10.d;
        int r17 = r16.size();
        int r18 = 0;
    L4:
        if (r18 >= r17) goto L34;
        xg.b r19 = (xg.b) r16.get(r18);
        if (r19.f23144a == false) goto L31;
        long r110 = r13[r5];
        long r111 = r13[2];
        boolean r24 = r11;
        long r20 = r13[r14];
        long r112 = r13[r15];
        r19.f23144a = false;
        MethodCollector.o(MethodCollector.METHOD_ID_DISPATCH, jg.a.f18319b);
        xg.a r21 = r19.f;
        if (r21 == null) goto L15;
        r21.f23135b = r24;
        long[] r113 = (long[]) c.f16598k.f16600b.f23549a;
        if ((r113[0] - r113[2]) <= 100) goto L12;
        boolean r22 = true;
    L13:
        r21.f23134a = r22;
        z6.b.f23409a.d(r21);
        r19.f = null;
        goto L15
    L12:
        r22 = false;
    L15:
        if (MethodCollector.getInstance().isAlive() == false) goto L30;
        long r114 = r20 - r110;
        if (r114 < xg.b.f23140i) goto L30;
        xg.b.a("evil_method_begin");
        long[] r23 = MethodCollector.getInstance().copyData(r19.f23145b);
        if (r23 != null) goto L22;
    L23:
        r16 = r16;
        r17 = r17;
        boolean r115 = r24;
        xg.b.a("evil_method_data_null");
    L33:
        r18 = r18 + 1;
        r17 = r17;
        r11 = r115;
        r16 = r16;
        r5 = 0;
        r14 = 1;
        r15 = 3;
        goto L4
    L22:
        if (r23.length == 0) goto L23;
        r16 = r16;
        r17 = r17;
        System.arraycopy(r19.d, 0, new long[3], 0, 3);
        String r25 = com.bytedance.apm.block.b.a();
        if (TextUtils.isEmpty(r25) == false) goto L27;
        String r26 = ActivityLifeObserver.getInstance().getTopActivityClassName();
    L28:
        String r27 = r19.f23146c;
        ActivityLifeObserver.getInstance().isForeground();
        r115 = r24;
        long r28 = System.currentTimeMillis();
        k.m().getClass();
        xg.a r29 = new xg.a();
        r29.g = r26;
        r29.e = r114;
        r29.d = r112 - r111;
        r29.f23136c = r23;
        r29.f = r20;
        r29.f23137h = r27;
        r29.f23138i = r28;
        r19.f = r29;
        goto L33
    L27:
        StringBuilder r30 = j0.w(r25, ",");
        r30.append(ActivityLifeObserver.getInstance().getTopActivityClassName());
        r26 = r30.toString();
    L30:
        r115 = r24;
        goto L33
    L31:
        r115 = r11;
        goto L33
    L34:
        long[] r31 = (long[]) r10.f16600b.f23549a;
        r31[0] = 0;
        r31[1] = 0;
        r31[2] = Long.MAX_VALUE;
        r31[3] = 0;
        r10.f = false;
    }

    @Override // jg.a
    public final void b(String r10) {
        this.f18321a = true;
        c r11 = this.d;
        r11.f = true;
        long r5 = jg.a.f18319b;
        long[] r12 = r11.f16601c;
        int r13 = 0;
        r12[0] = r5;
        r12[2] = jg.a.f18320c;
        CopyOnWriteArrayList r14 = r11.d;
        int r15 = r14.size();
    L3:
        if (r13 >= r15) goto L11;
        xg.b r16 = (xg.b) r14.get(r13);
        if (r16.f23144a == true) goto L10;
        r16.f23144a = true;
        MethodCollector.i(MethodCollector.METHOD_ID_DISPATCH, jg.a.f18319b);
        if ((jg.a.f18319b - r16.e) <= 300) goto L9;
        r16.e = jg.a.f18319b;
        r16.f23145b = MethodCollector.maskIndex("EvilMethodTracer#dispatchBegin", 0);
    L9:
        r16.f23146c = r10;
    L10:
        r13 = r13 + 1;
        goto L3
    }

    @Override // jg.a
    public final boolean c() {
        return this.d.f16599a;
    }
}
