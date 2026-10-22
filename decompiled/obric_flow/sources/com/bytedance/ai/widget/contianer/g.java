package com.bytedance.ai.widget.contianer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.ai.monitor.AppletErrorCode;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3046a;

    public g(Looper r5, WidgetContainer r10) {
        Intrinsics.checkNotNullParameter(r5, "looper");
        Intrinsics.checkNotNullParameter(r10, "widgetContainer");
        super(r5);
        this.f3046a = new WeakReference(r10);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r10) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        if (r10.what != 3) goto L30;
        WeakReference r11 = this.f3046a;
        WidgetContainer r12 = (WidgetContainer) r11.get();
        if (r12 == null) goto L7;
        WidgetContainer.LifecycleEvent r13 = r12.f3023j;
    L9:
        if (r13 != WidgetContainer.LifecycleEvent.f3032a) goto L32;
        String r14 = "request time out " + r11.get();
        Intrinsics.checkNotNullParameter("WidgetContainer", "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L13;
        r5.d("WidgetContainer", r14);
    L13:
        WidgetContainer r15 = (WidgetContainer) r11.get();
        if (r15 == null) goto L33;
        StringBuilder r16 = new StringBuilder("request time out widget=null data=");
        WidgetContainer r17 = (WidgetContainer) r11.get();
        WidgetContainer r18 = (WidgetContainer) r11.get();
        if (r18 == null) goto L18;
        h r19 = r18.f;
    L19:
        r16.append(r19);
        String r20 = r16.toString();
        if (r20 != null) goto L22;
        r20 = "";
    L22:
        String r21 = "Fail to load widget: ".concat(r20);
        Intrinsics.checkNotNullParameter("WidgetContainer", "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L25;
        r22.e("WidgetContainer", r21);
    L25:
        r15.i(WidgetContainer.LifecycleEvent.f3034c);
        String r23 = com.lynx.tasm.behavior.utils.d.c("reportErrorEvent: ", r21, "WidgetContainer");
        t0.d r24 = com.bytedance.ai.utils.c.f2846a;
        if (r24 == null) goto L28;
        r24.i("WidgetContainer", r23);
    L28:
        AtomicBoolean r25 = z2.d.f23373a;
        AppletErrorCode r26 = AppletErrorCode.d;
        com.bytedance.ai.bridge.method.net.e r27 = new com.bytedance.ai.bridge.method.net.e(r15, 5);
        Intrinsics.checkNotNullParameter(r26, "code");
        Intrinsics.checkNotNullParameter(r21, "msg");
        Intrinsics.checkNotNullParameter(r27, "build");
        z2.d.a(new z2.c(r26, r21, null, r27, System.currentTimeMillis()));
        return;
    L18:
        r19 = null;
        goto L19
    L33:
        return;
    L32:
        return;
    L7:
        r13 = null;
        goto L9
    L30:
        super.handleMessage(r10);
    }
}
