package a3;

import android.net.Uri;
import b3.n;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.monitor.timeline.LoadingStage;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f74a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f75b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f76c;
    public final /* synthetic */ long d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ e(long r5, m1.j r10, String r11, String r12, i2.c r13) {
        this.f74a = 0;
        this.d = r5;
        this.e = r10;
        this.f75b = r11;
        this.f76c = r12;
        this.f = r13;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        long r5 = this.d;
        Object r10 = this.f;
        Object r11 = this.e;
        String r12 = this.f76c;
        String r13 = this.f75b;
        switch(this.f74a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        n r14 = b3.h.f842b;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r13, "traceId");
        Intrinsics.checkNotNullParameter(r12, "pageId");
        String r15 = (String) r11;
        Intrinsics.checkNotNullParameter(r15, "pageType");
        String r16 = (String) r10;
        Intrinsics.checkNotNullParameter(r16, "from");
        StringBuilder r17 = com.lynx.tasm.base.a.e("onOpenPageCalled: ", r13, ", ", r15, ", ");
        r17.append(r16);
        r17.append(", ");
        r17.append(r5);
        String r18 = r17.toString();
        String r19 = r14.g;
        Intrinsics.checkNotNullParameter(r19, "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L7;
        r20.d(r19, r18);
    L7:
        com.lynx.tasm.base.a.l(r13, r14.f849c).a("open_time", Long.valueOf(r5));
        b3.i r110 = com.lynx.tasm.base.a.a(r13, r14.e);
        LoadingStage[] r21 = LoadingStage.f2393a;
        Intrinsics.checkNotNullParameter("openPage", "<set-?>");
        r110.f845b = "openPage";
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r110.f846c = r16;
        LinkedHashMap r111 = r110.d;
        r111.put("page_type", r15);
        r111.put("render_type", "webview");
        r111.put("pageId", r12);
        return Unit.INSTANCE;
    L9:
        j r112 = cl.a.b(r12, i.f84b);
        i.d.getClass();
        Intrinsics.checkNotNullParameter(r13, "callName");
        Intrinsics.checkNotNullParameter(r112, "traceEvent");
        r112.f86a.a("native_receive_call", Long.valueOf(r5));
        LinkedHashMap r113 = r112.e;
        r113.put("name", r13);
        m1.j r22 = (m1.j) r11;
        String r23 = null;
        if (r22 == null) goto L12;
        String r24 = r22.b();
    L13:
        r113.put("packageId", r24);
        if (r22 == null) goto L16;
        String r25 = r22.a();
    L17:
        r113.put(Constant.APPID, r25);
        if (r22 == null) goto L22;
        ContainerType r26 = r22.d();
        if (r26 == null) goto L22;
        String r27 = r26.f1802a;
    L23:
        r113.put("source_container_type", r27);
        if (r22 == null) goto L26;
        String r28 = r22.e();
    L27:
        if (r28 != null) goto L29;
    L30:
        r28 = null;
    L31:
        if (r28 == null) goto L33;
        r23 = Uri.parse(r28).buildUpon().clearQuery().toString();
    L33:
        r113.put("url", r23);
        r113.put("source_render_type", com.bytedance.android.anniex.base.service.e.h((i2.c) r10));
        return Unit.INSTANCE;
    L29:
        if (r28.length() != 0) goto L31;
    L26:
        r28 = null;
    L22:
        r27 = null;
        goto L23
    L16:
        r25 = null;
        goto L17
    L12:
        r24 = null;
        goto L13
    }

    public /* synthetic */ e(String r5, String r10, String r11, String r12, long r13) {
        this.f74a = 1;
        this.f75b = r5;
        this.f76c = r10;
        this.e = r11;
        this.f = r12;
        this.d = r13;
    }
}
