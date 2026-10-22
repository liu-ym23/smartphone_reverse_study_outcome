package i2;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f17488b;

    public /* synthetic */ b(Object r5, int r10) {
        this.f17487a = r10;
        this.f17488b = r5;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object r5) {
        Object r10 = this.f17488b;
        switch(this.f17487a) {
            case 0: goto L13;
            default: goto L4;
        };
    L4:
        a r11 = (a) r10;
        com.bytedance.ai.applet.render.core.relax.a r12 = (com.bytedance.ai.applet.render.core.relax.a) r5;
        long r13 = System.currentTimeMillis();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L10
        ProtocolMessage r15 = com.lynx.tasm.utils.b.b(r12.f1789a);     // Catch: Throwable -> L10
        if (r15 == null) goto L23;
        Intrinsics.checkNotNullParameter(r15, "message");     // Catch: Throwable -> L10
        j2.b r16 = new j2.b(r15);     // Catch: Throwable -> L10
        r16.f18231c = r13;     // Catch: Throwable -> L10
        r11.accept(r16);     // Catch: Throwable -> L10
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L23:
        return;
    L10:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        return;
    L13:
        j2.a r18 = (j2.a) r5;
        c r19 = (c) r10;
        if (r19.f17489a.get() == true) goto L25;
        String r20 = "[" + r19.getClass().getSimpleName() + "] post msg to view " + ((ProtocolMessage) r18.f22372b);
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter(r20, "msg");
        a1.a.f43a.d("ai_bridge", r20);
        com.lynx.tasm.utils.a r21 = r18.f18230c;
        if (r21 == null) goto L19;
        r21.l();
    L19:
        Intrinsics.checkNotNull(r18);
        r19.d(r18);
        return;
    }
}
