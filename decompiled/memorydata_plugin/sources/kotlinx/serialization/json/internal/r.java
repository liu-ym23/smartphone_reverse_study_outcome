package kotlinx.serialization.json.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\"\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\b"}, d2 = {"unsignedNumberDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getUnsignedNumberDescriptors$annotations", "()V", "isUnsignedNumber", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "kotlinx-serialization-json"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<kotlinx.serialization.descriptors.f> f17851a = null;

    static {
        f17851a = SetsKt.setOf(new kotlinx.serialization.descriptors.f[]{kotlinx.serialization.a.a.a(UInt.Companion).a(), kotlinx.serialization.a.a.a(ULong.Companion).a(), kotlinx.serialization.a.a.a(UByte.Companion).a(), kotlinx.serialization.a.a.a(UShort.Companion).a()});
    }

    public static final boolean a(kotlinx.serialization.descriptors.f r2) {
        kotlinx.serialization.descriptors.f r3 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.c() == true) goto L5;
    L7:
        return false;
    L5:
        if (f17851a.contains(r3) == false) goto L7;
        return true;
    }
}
