package da2;

import android.view.View;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRealtimeIndicatorNode;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import kotlin.jvm.internal.Intrinsics;
import z32.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements k<T> {
    public final String a;
    public final k<T> b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final String getName() {
        return this.a;
    }

    public b(k<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.b = r2;
        this.a = r2.getName();
    }

    public static String e(Object r4) {
        f r1 = null;
        if ((r4 instanceof f) == true) goto L5;
        r4 = null;
    L5:
        f r5 = (f) r4;
        if (r5 != null) goto L10;
        return CardLockInfo.sUNKNOWN;
    L10:
        if ((r5 instanceof z) == false) goto L13;
        r1 = r5;
    L13:
        z r2 = (z) r1;
        if (r2 == null) goto L17;
        return "IPSMessageModel[" + r2.H.getType() + ']';
    L17:
        return "AbsTextMessage[" + r5.b.getMessageMethod() + '&' + r5.o() + ']';
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final void a(T r2) {
        this.b.a(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final View.OnClickListener c(l r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        return this.b.c(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final void d(T r4) {
        this.b.d(r4);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        boolean r1 = TextMessageTracer.a;
        TextMessageTracer.A("RenderTextProcessor onPreProcess failed, msg is " + e(r4) + ", error is " + e.getMessage());
        SafetyGuard.a(null, e, "TextMessageTracer_RendText");
        s0 r2 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.j("onPreProcess", e(r4), e);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k
    public final j b(T r8, com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f r9, k.a<T> r10) {
        Intrinsics.checkNotNullParameter(r9, "config");
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L8
        j r11 = this.b.b(r8, r9, r10);     // Catch: Exception -> L8
        e.a(PSRealtimeIndicatorNode.MessageRendTextConsume, System.currentTimeMillis() - r3);     // Catch: Exception -> L8
        if (r11.a == null) goto L6;
        e.b(PSRealtimeIndicatorNode.MessageRendTextSuccessRate, true);     // Catch: Exception -> L8
    L7:
        return r11;
    L6:
        e.b(PSRealtimeIndicatorNode.MessageRendTextSuccessRate, false);     // Catch: Exception -> L8
        s0 r13 = PublicScreenTraceMonitor.a;     // Catch: Exception -> L8
        PublicScreenTraceMonitor.j("EmptySpannable", e(r8), null);     // Catch: Exception -> L8
        boolean r14 = TextMessageTracer.a;     // Catch: Exception -> L8
        TextMessageTracer.A("RenderTextProcessor onProcess empty, msg is " + e(r8));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        boolean r15 = TextMessageTracer.a;
        TextMessageTracer.A("RenderTextProcessor onProcess failed, msg is " + e(r8) + ", error is " + e.getMessage());
        SafetyGuard.a(null, e, "TextMessageTracer_RendText");
        s0 r16 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.j("onProcess", e(r8), e);
        e.b(PSRealtimeIndicatorNode.MessageRendTextSuccessRate, false);
        return new j(null, null);
    }
}
