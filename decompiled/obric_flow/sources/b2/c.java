package b2;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.bridge.method.log.ReportPerformanceEntriesMethod;
import com.bytedance.ai.core.base.g;
import com.bytedance.ai.model.AppletRuntime;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f822b;

    public /* synthetic */ c(String r5, int r10) {
        this.f821a = r10;
        this.f822b = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r10) {
        switch(this.f821a) {
            case 0: goto L50;
            case 1: goto L48;
            case 2: goto L46;
            case 3: goto L43;
            case 4: goto L38;
            case 5: goto L19;
            case 6: goto L9;
            default: goto L4;
        };
    L4:
        XmlSerializer r11 = (XmlSerializer) r10;
        Intrinsics.checkNotNullParameter(r11, "$this$insertTag");
        String r5 = this.f822b;
        if (r5 == null) goto L8;
        r11.text(r5);
    L8:
        return Unit.INSTANCE;
    L9:
        AppletRuntime r12 = (AppletRuntime) r10;
        Intrinsics.checkNotNullParameter(r12, ST.IMPLICIT_ARG_NAME);
        r12.getClass();
        String r13 = this.f822b;
        Intrinsics.checkNotNullParameter(r13, "sessionId");
        g r14 = (g) r12.f2206q.get(r13);
        if ((r14 instanceof com.bytedance.ai.core.base.a) == false) goto L12;
        com.bytedance.ai.core.base.a r15 = (com.bytedance.ai.core.base.a) r14;
    L13:
        if (r15 == null) goto L18;
        r15.d = true;
        String r16 = "Session(" + r15.f2094a + ") is Active --> " + r15.d;
        Intrinsics.checkNotNullParameter("Session", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L18;
        r17.d("Session", r16);
    L18:
        return Unit.INSTANCE;
    L12:
        r15 = null;
        goto L13
    L19:
        AppletRuntime r18 = (AppletRuntime) r10;
        Intrinsics.checkNotNullParameter(r18, ST.IMPLICIT_ARG_NAME);
        r18.getClass();
        String r19 = this.f822b;
        Intrinsics.checkNotNullParameter(r19, "sessionId");
        ConcurrentHashMap r20 = r18.f2206q;
        g r21 = (g) r20.get(r19);
        if ((r21 instanceof com.bytedance.ai.core.base.a) == false) goto L22;
        com.bytedance.ai.core.base.a r22 = (com.bytedance.ai.core.base.a) r21;
    L23:
        if (r22 == null) goto L27;
        r22.d = false;
        String r23 = "Session(" + r22.f2094a + ") is Active --> " + r22.d;
        Intrinsics.checkNotNullParameter("Session", "tag");
        t0.d r24 = com.bytedance.ai.utils.c.f2846a;
        if (r24 == null) goto L27;
        r24.d("Session", r23);
    L27:
        Intrinsics.checkNotNullParameter(r19, "sessionId");
        Intrinsics.checkNotNullParameter(r19, "sessionId");
        g r25 = (g) r20.get(r19);
        if (r25 == null) goto L37;
        if (r25.a() == true) goto L37;
        g r26 = (g) r20.remove(r19);
        if (r26 == null) goto L37;
        if ((r26 instanceof com.bytedance.ai.core.base.a) == false) goto L37;
        r18.h();
    L37:
        return Unit.INSTANCE;
    L22:
        r22 = null;
        goto L23
    L38:
        String r27 = "runApplet success " + this.f822b + " appletRuntime=" + ((AppletRuntime) r10);
        Intrinsics.checkNotNullParameter("WidgetResourceLoader", "tag");
        t0.d r28 = com.bytedance.ai.utils.c.f2846a;
        if (r28 == null) goto L42;
        r28.i("WidgetResourceLoader", r27);
    L42:
        return Unit.INSTANCE;
    L43:
        AppletRuntime r29 = (AppletRuntime) r10;
        Intrinsics.checkNotNullParameter(r29, ST.IMPLICIT_ARG_NAME);
        r29.q(this.f822b);
        return Unit.INSTANCE;
    L46:
        return ReportPerformanceEntriesMethod.b(this.f822b, ((Boolean) r10).booleanValue());
    L48:
        return ReportPerformanceEntriesMethod.d(this.f822b, ((Boolean) r10).booleanValue());
    L50:
        return ReportPerformanceEntriesMethod.c(this.f822b, ((Boolean) r10).booleanValue());
    }
}
