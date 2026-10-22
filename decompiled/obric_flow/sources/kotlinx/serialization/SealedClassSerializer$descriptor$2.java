package kotlinx.serialization;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.k;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/descriptors/g;", "invoke", "()Lkotlinx/serialization/descriptors/g;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
final class SealedClassSerializer$descriptor$2 extends Lambda implements Function0<kotlinx.serialization.descriptors.g> {
    final /* synthetic */ String $serialName;
    final /* synthetic */ f this$0;

    public SealedClassSerializer$descriptor$2(String r5, f r10) {
        this.$serialName = r5;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ kotlinx.serialization.descriptors.g invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final kotlinx.serialization.descriptors.g invoke2() {
        final f r5 = null;
        return k.b(this.$serialName, kotlinx.serialization.descriptors.c.f19223c, new kotlinx.serialization.descriptors.g[0], new AnonymousClass1(r5));
    }
}
