package kotlinx.serialization.json.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001aS\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u0002H\u0005\"\b\b\u0002\u0010\u0007*\u0002H\u0005*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000bH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"carrierDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "module", "Lkotlinx/serialization/modules/SerializersModule;", "selectMapMode", ExifInterface.GPS_DIRECTION_TRUE, "R1", "R2", "Lkotlinx/serialization/json/Json;", "mapDescriptor", "ifMap", "Lkotlin/Function0;", "ifList", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "switchMode", "Lkotlinx/serialization/json/internal/WriteMode;", "desc", "kotlinx-serialization-json"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class w {
    public static final kotlinx.serialization.descriptors.f a(kotlinx.serialization.descriptors.f r2, kotlinx.serialization.modules.d r3) {
        kotlinx.serialization.descriptors.f r4 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "module");
        if (Intrinsics.areEqual(r4.e(), kotlinx.serialization.descriptors.j.a.f17689a) == false) goto L11;
        kotlinx.serialization.descriptors.f r0 = kotlinx.serialization.descriptors.b.a(r3, r4);
        if (r0 == null) goto L14;
        kotlinx.serialization.descriptors.f r5 = a(r0, r3);
        if (r5 != null) goto L15;
        return r4;
    L15:
        return r5;
    L14:
        return r4;
    L11:
        if (r4.c() == true) goto L13;
        return r4;
    L13:
        return a(r4.b(0), r3);
    }
}
