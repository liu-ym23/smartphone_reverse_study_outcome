package dd;

import android.app.ActivityManager;
import android.app.Application;
import com.bytedance.ies.bullet.core.h;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z4.a f16635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16636c;
    public final /* synthetic */ String d;

    public /* synthetic */ a(z4.a r5, String r10, String r11, int r12) {
        this.f16634a = r12;
        this.f16635b = r5;
        this.f16636c = r10;
        this.d = r11;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f16634a) {
            case 0: goto L36;
            default: goto L4;
        };
    L4:
        Long r5 = (Long) c.e().get("mem_java_used");
        z4.a r10 = this.f16635b;
        String r11 = this.f16636c;
        String r12 = this.d;
        if (r5 == null) goto L7;
        r10.c(r5.longValue(), r12, r11);
    L7:
        LinkedHashMap r13 = (LinkedHashMap) r10.d;
        Intrinsics.checkNotNull(r13);
        Long r14 = (Long) r13.get("initTime");
        Long r15 = (Long) r13.get("appCpuStat");
        Long r16 = (Long) r13.get("totalCpuStat");
        long r17 = com.bytedance.apm.util.a.h();
        long r18 = com.bytedance.apm.util.a.m();
        double r19 = -1.0d;
        if (r14 != null) goto L10;
    L21:
        double r20 = -1.0d;
    L22:
        HashMap r21 = new HashMap();
        r21.put("cpu_rate", Double.valueOf(r20));
        r21.put("cpu_speed", Double.valueOf(r19));
        Double r22 = (Double) r21.get("cpu_rate");
        if (r22 == null) goto L26;
        r10.e(r12, r11, r22.doubleValue());
    L26:
        if (Intrinsics.areEqual(r11, "view_page_start") == false) goto L35;
        Application r23 = h.g.f5316b;
        if (r23 == null) goto L30;
        Object r24 = r23.getSystemService("activity");
    L31:
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type android.app.ActivityManager");
        HashMap r25 = new HashMap();
        ActivityManager.MemoryInfo r26 = new ActivityManager.MemoryInfo();
        ((ActivityManager) r24).getMemoryInfo(r26);
        long r27 = 1024;
        r25.put("MEM_DEVICE_TOTAL", Long.valueOf(r26.totalMem / r27));
        r25.put("mem_device_threshold", Long.valueOf(r26.threshold / r27));
        r25.put("mem_device_avail", Long.valueOf(r26.availMem / r27));
        Long r28 = (Long) r25.get("MEM_DEVICE_TOTAL");
        if (r28 == null) goto L35;
        r10.c(r28.longValue(), r12, "device_totalmem");
        goto L35
    L30:
        r24 = null;
    L35:
        return Unit.INSTANCE;
    L10:
        if (r14.longValue() <= 0) goto L21;
        if (r15 == null) goto L21;
        if (r15.longValue() <= 0) goto L21;
        if (r16 == null) goto L21;
        if (r16.longValue() <= 0) goto L21;
        if ((r18 - r16.longValue()) <= 0) goto L20;
        r19 = (r17 - r15.longValue()) / (r18 - r16.longValue());
    L20:
        double r29 = (((r17 - r15.longValue()) * ((double) 1000)) / (System.currentTimeMillis() - r14.longValue())) / com.bytedance.apm.util.a.j();
        r20 = r19;
        r19 = r29;
        goto L22
    L36:
        Long r30 = (Long) c.e().get("mem_java_used");
        String r31 = this.d;
        String r32 = this.f16636c;
        z4.a r33 = this.f16635b;
        if (r30 == null) goto L39;
        r33.c(r30.longValue(), r32, r31);
    L39:
        Double r34 = (Double) c.a().get("cpu_rate");
        if (r34 == null) goto L43;
        r33.e(r32, r31, r34.doubleValue());
    L43:
        return Unit.INSTANCE;
    }
}
