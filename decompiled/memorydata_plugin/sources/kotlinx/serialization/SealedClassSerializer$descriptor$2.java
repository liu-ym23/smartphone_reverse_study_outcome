package kotlinx.serialization;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlinx/serialization/descriptors/SerialDescriptor;", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SealedClassSerializer$descriptor$2 extends Lambda implements Function0<kotlinx.serialization.descriptors.f> {
    final /* synthetic */ String $serialName;
    final /* synthetic */ c<? extends T>[] $subclassSerializers;
    final /* synthetic */ g<T> this$0;

    SealedClassSerializer$descriptor$2(String r1, g<T> r2, c<? extends T>[] r3) {
        this.$serialName = r1;
        this.this$0 = r2;
        this.$subclassSerializers = r3;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ kotlinx.serialization.descriptors.f invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final kotlinx.serialization.descriptors.f invoke2() {
        final g<T> r5 = this.this$0;
        final c<? extends T>[] r6 = this.$subclassSerializers;
        return kotlinx.serialization.descriptors.i.a(this.$serialName, (kotlinx.serialization.descriptors.j) ZeusTransformUtils.preCheckCast(kotlinx.serialization.descriptors.d.b.f17671a, kotlinx.serialization.descriptors.j.class, "com.obric.memorydata.plugin"), new kotlinx.serialization.descriptors.f[0], (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5, r6), Function1.class, "com.obric.memorydata.plugin"));
    }
}
