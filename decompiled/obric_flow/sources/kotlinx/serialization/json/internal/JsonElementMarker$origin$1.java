package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
final /* synthetic */ class JsonElementMarker$origin$1 extends FunctionReferenceImpl implements Function2<kotlinx.serialization.descriptors.g, Integer, Boolean> {
    public JsonElementMarker$origin$1(Object r10) {
        super(2, r10, e.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
    }

    public final Boolean invoke(kotlinx.serialization.descriptors.g r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        e r11 = (e) this.receiver;
        r11.getClass();
        if (r5.i(r10) == false) goto L5;
    L7:
        boolean r12 = false;
    L8:
        r11.f19422b = r12;
        return Boolean.valueOf(r12);
    L5:
        if (r5.g(r10).b() == false) goto L7;
        r12 = true;
        goto L8
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Boolean mo2invoke(kotlinx.serialization.descriptors.g r5, Integer r10) {
        return invoke(r5, r10.intValue());
    }
}
