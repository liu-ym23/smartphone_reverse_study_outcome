package n48;

import com.larus.api.serviceimpl.AoEcomServiceImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ AtomicBoolean b;

    public /* synthetic */ a(AtomicBoolean r1, AtomicBoolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        AtomicBoolean r0 = this.a;
        AtomicBoolean r1 = this.b;
        int r2 = AoEcomServiceImpl.a;
        r0.set(false);
        r1.set(false);
        return Unit.INSTANCE;
    }
}
