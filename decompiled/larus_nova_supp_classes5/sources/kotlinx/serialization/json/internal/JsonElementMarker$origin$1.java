package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import luc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class JsonElementMarker$origin$1 extends FunctionReferenceImpl implements Function2<f, Integer, Boolean> {
    public JsonElementMarker$origin$1(Object r8) {
        super(2, r8, JsonElementMarker.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
    }

    public final Boolean invoke(f r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        JsonElementMarker r0 = (JsonElementMarker) ((CallableReference) this).receiver;
        r0.getClass();
        if (r3.i(r4) == false) goto L5;
    L7:
        boolean r5 = false;
    L8:
        r0.b = r5;
        return Boolean.valueOf(r5);
    L5:
        if (r3.h(r4).a() == false) goto L7;
        r5 = true;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((f) r1, ((Number) r2).intValue());
    }
}
