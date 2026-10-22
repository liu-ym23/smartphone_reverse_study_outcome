package kotlinx.serialization;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ContextualSerializer$descriptor$1 extends Lambda implements Function1<kotlinx.serialization.descriptors.a, Unit> {
    final /* synthetic */ a<T> this$0;

    ContextualSerializer$descriptor$1(a<T> r1) {
        this.this$0 = r1;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(kotlinx.serialization.descriptors.a r3) {
        invoke2((kotlinx.serialization.descriptors.a) ZeusTransformUtils.preCheckCast(r3, kotlinx.serialization.descriptors.a.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(kotlinx.serialization.descriptors.a r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$buildSerialDescriptor");
        c r1 = a.a(this.this$0);
        if (r1 == null) goto L7;
        kotlinx.serialization.descriptors.f r3 = r1.a();
        if (r3 == null) goto L7;
        List<Annotation> r4 = r3.a();
    L8:
        if (r4 != null) goto L10;
        r4 = CollectionsKt.emptyList();
    L10:
        r2.a(r4);
        return;
    L7:
        r4 = null;
        goto L8
    }
}
