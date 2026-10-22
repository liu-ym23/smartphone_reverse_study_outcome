package fn8;

import com.larus.list.expose.ExposureTrackerExtKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class e implements Function0 {
    public final /* synthetic */ w a;
    public final /* synthetic */ x b;
    public final /* synthetic */ c0 c;

    public /* synthetic */ e(w r1, x r2, c0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        w r0 = this.a;
        final x r1 = this.b;
        final c0 r2 = this.c;
        ExposureTrackerExtKt.a(r0, new k(r1, r2));
        return Unit.INSTANCE;
    }
}
