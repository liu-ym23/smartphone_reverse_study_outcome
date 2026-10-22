package a3;

import b3.o;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f71a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f72b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f73c;
    public final /* synthetic */ i2.c d;

    public /* synthetic */ d(String r5, long r10, i2.c r11, int r12) {
        this.f71a = r12;
        this.f72b = r5;
        this.f73c = r10;
        this.d = r11;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch(this.f71a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        LinkedHashMap r5 = i.f84b;
        j r10 = cl.a.b(this.f72b, r5);
        i.e.getClass();
        Intrinsics.checkNotNullParameter(r10, "traceEvent");
        r10.e.put("target_render_type", com.bytedance.android.anniex.base.service.e.h(this.d));
        long r11 = this.f73c;
        Long r12 = Long.valueOf(r11);
        o r13 = r10.f86a;
        r13.a("native_send_call", r12);
        Long r14 = Long.valueOf(r11 - r13.d("forward_call"));
        r10.f87b.a("process_call_duration", r14);
        return Unit.INSTANCE;
    L6:
        LinkedHashMap r15 = i.f84b;
        j r16 = cl.a.b(this.f72b, r15);
        i.g.getClass();
        Intrinsics.checkNotNullParameter(r16, "traceEvent");
        r16.e.put("target_render_type", com.bytedance.android.anniex.base.service.e.h(this.d));
        long r17 = this.f73c;
        Long r18 = Long.valueOf(r17);
        o r19 = r16.f86a;
        r19.a("native_send_event", r18);
        Long r20 = Long.valueOf(r17 - r19.d("native_process_event"));
        r16.f87b.a("process_event_duration", r20);
        return Unit.INSTANCE;
    }
}
