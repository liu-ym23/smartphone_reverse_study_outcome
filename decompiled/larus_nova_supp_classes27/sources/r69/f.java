package r69;

import android.content.Context;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.util.u;
import com.larus.utils.t0;
import kotlin.Triple;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ DoraDevice a;
    public final /* synthetic */ Triple b;
    public final /* synthetic */ Triple c;
    public final /* synthetic */ Context d;

    public /* synthetic */ f(DoraDevice r1, Triple r2, Triple r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoraDevice r0 = this.a;
        Triple r2 = this.b;
        Triple r3 = this.c;
        Context r4 = this.d;
        i r5 = i.a;
        monitor-enter(r5);
        g49.d.a("DoraWearToastFactory", "toast util dismiss");     // Catch: Throwable -> L41
        t0.e(new g());     // Catch: Throwable -> L41
        monitor-exit(r5);
        Integer r6 = (Integer) r2.component1();
        Integer r7 = (Integer) r2.component2();
        Integer r8 = (Integer) r2.component3();
        Integer r9 = (Integer) r3.component1();
        Integer r10 = (Integer) r3.component3();
        if (o59.a.p(r0) == false) goto L38;
        boolean r11 = v19.h.a;
        if (v19.h.a(null) == false) goto L11;
        int r12 = u.a.a("larus_icon_dora_g_wear_detection_dark");
    L12:
        int r13 = r12;
        String r14 = o59.a.d(r0);
        u r1 = u.a;
        int r15 = r1.a("larus_dora_g_wear_icon");
        if (r6 == null) goto L15;
        int r16 = r6.intValue();
    L17:
        if (r9 != null) goto L20;
    L22:
        boolean r17 = false;
    L23:
        int r18 = r1.a("larus_dora_g_box_wear_icon");
        if (r8 == null) goto L26;
        int r110 = r8.intValue();
    L27:
        if (r10 != null) goto L30;
    L36:
        boolean r111 = false;
    L37:
        a r20 = new d(r13, r14, r15, r16, r17, r18, r110, r111);
    L39:
        r5.a(r20);
        g49.d.a("DoraWearToastFactory", "toast utils show, method name: show");
        r20.show(r4, false);
        return;
    L30:
        if (r10.intValue() != 1) goto L36;
        if (r8 != null) goto L34;
    L35:
        r111 = true;
        goto L37
    L34:
        if (r8.intValue() == 0) goto L36;
    L26:
        r110 = -1;
        goto L27
    L20:
        if (r9.intValue() != 1) goto L22;
        r17 = true;
        goto L23
    L15:
        r16 = 0;
        goto L17
    L11:
        r12 = u.a.a("larus_icon_dora_g_wear_detection");
        goto L12
    L38:
        r20 = new b(o59.a.d(r0), r6, r7);
    L41:
        th = move-exception;
        throw th;
    }
}
