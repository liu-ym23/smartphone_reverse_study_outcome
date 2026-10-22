package x68;

import com.larus.im.service.audio.e1;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ e1 a;
    public final /* synthetic */ u b;

    public /* synthetic */ d(e1 r1, u r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        e1 r0 = this.a;
        u r1 = this.b;
        Map r5 = (Map) r4;
        Intrinsics.checkNotNullParameter(r5, "$this$params2");
        r5.put("needCheckToCallMode", Boolean.valueOf(r0.a));
        r5.put("isExternalCaptureRunning", Boolean.valueOf(r1.h));
        return Unit.INSTANCE;
    }
}
