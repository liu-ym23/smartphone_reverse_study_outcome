package m1;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f19954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o1.a f19955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f19956c;
    public final /* synthetic */ ProtocolMessage d;
    public final /* synthetic */ b e;
    public final /* synthetic */ b f;

    public /* synthetic */ a(String r5, o1.a r10, i r11, ProtocolMessage r12, b r13, b r14) {
        this.f19954a = r5;
        this.f19955b = r10;
        this.f19956c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        if (td.d.f22127b == null) goto L5;
        String r5 = this.f19954a;
        Intrinsics.checkNotNullParameter(r5, "traceId");
        a3.i.a(new a3.b(r5, System.currentTimeMillis(), 5));
    L5:
        n1.a r10 = this.f19956c.g;
        JsonObject r11 = this.d.f();
        c r12 = new c(this.e, 0);
        c r13 = new c(this.f, 1);
        this.f19955b.realHandle(r10, r11, r12, r13);
        return Unit.INSTANCE;
    }
}
