package x68;

import com.larus.im.service.audio.f1;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ u a;
    public final /* synthetic */ f1 b;

    public /* synthetic */ a(u r1, f1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        u r0 = this.a;
        f1 r1 = this.b;
        Map r5 = (Map) r4;
        Intrinsics.checkNotNullParameter(r5, "$this$params2");
        r5.put("useExternalCapture", r0.c.invoke());
        r5.put("encoderWidth", Integer.valueOf(r1.g));
        r5.put("encoderHeight", Integer.valueOf(r1.h));
        r5.put("encoderFrameRate", Integer.valueOf(r1.f));
        r5.put("needCheckToCallMode", Boolean.valueOf(r1.i));
        return Unit.INSTANCE;
    }
}
