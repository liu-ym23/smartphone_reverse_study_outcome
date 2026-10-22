package b3;

import java.io.StringWriter;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.e0;
import okhttp3.n0;
import okhttp3.q0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f828c;
    public final /* synthetic */ int d;

    public /* synthetic */ b(int r5, Object r10, int r11, Object r12) {
        this.f826a = r11;
        this.f827b = r10;
        this.f828c = r12;
        this.d = r5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int r5 = this.d;
        Object r10 = this.f828c;
        Object r11 = this.f827b;
        switch(this.f826a) {
            case 0: goto L12;
            case 1: goto L10;
            default: goto L4;
        };
    L4:
        u1.d r12 = (u1.d) r11;
        OkHttpClient r13 = r12.f22221a;
        n0 r14 = new n0();
        e0 r15 = r12.f22222b;
        Intrinsics.checkNotNullParameter(r15, "url");
        r14.f20713a = r15;
        r14.d("PROPFIND", q0.create(u1.d.d, ((StringWriter) r10).toString()));
        if (r5 < 0) goto L7;
        String r16 = String.valueOf(r5);
    L8:
        r14.c("Depth", r16);
        return r13.a(r14.b()).execute();
    L7:
        r16 = "infinity";
        goto L8
    L10:
        n r17 = h.f842b;
        String r18 = (String) r11;
        r17.a(r5, r18, (String) r10);
        JSONObject r19 = r17.o(r18);
        String r20 = r19.getString("eventName");
        AtomicBoolean r21 = z2.d.f23373a;
        Intrinsics.checkNotNull(r20);
        z2.d.d(r20, new g(r19));
        Intrinsics.checkNotNullParameter(r18, "traceId");
        com.lynx.tasm.base.a.a(r18, r17.e).f844a = true;
        return Unit.INSTANCE;
    L12:
        p r22 = h.f841a;
        String r23 = (String) r11;
        r22.a(r5, r23, (String) r10);
        JSONObject r24 = r22.o(r23);
        String r25 = r24.getString("eventName");
        AtomicBoolean r26 = z2.d.f23373a;
        Intrinsics.checkNotNull(r25);
        z2.d.d(r25, new g(r24));
        Intrinsics.checkNotNullParameter(r23, "traceId");
        com.lynx.tasm.base.a.a(r23, r22.e).f844a = true;
        return Unit.INSTANCE;
    }
}
