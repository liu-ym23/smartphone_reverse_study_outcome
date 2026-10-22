package kotlinx.serialization.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\r*\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"equalsImpl", "", "SD", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "other", "", "typeParamsAreEqual", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "otherDescriptor", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "hashCodeImpl", "", "typeParams", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "kotlinx-serialization-core"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class bo {
    public static final int a(kotlinx.serialization.descriptors.f r7, kotlinx.serialization.descriptors.f[] r8) {
        kotlinx.serialization.descriptors.f r9 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r7, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r8, "typeParams");
        int r0 = (r9.f().hashCode() * 31) + Arrays.hashCode(r8);
        Iterable<kotlinx.serialization.descriptors.f> r10 = kotlinx.serialization.descriptors.h.a(r9);
        Iterator<kotlinx.serialization.descriptors.f> r11 = r10.iterator();
        int r2 = 1;
        int r3 = 1;
    L3:
        int r5 = 0;
        if (r11.hasNext() == false) goto L9;
        int r4 = r3 * 31;
        String r6 = ((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r11.next(), kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).f();
        if (r6 == null) goto L8;
        r5 = r6.hashCode();
    L8:
        r3 = r4 + r5;
        goto L3
    L9:
        Iterator<kotlinx.serialization.descriptors.f> r12 = r10.iterator();
    L11:
        if (r12.hasNext() == false) goto L18;
        int r13 = r2 * 31;
        kotlinx.serialization.descriptors.j r14 = ((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r12.next(), kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).e();
        if (r14 == null) goto L15;
        int r15 = r14.hashCode();
    L16:
        r2 = r13 + r15;
        goto L11
    L15:
        r15 = 0;
        goto L16
    L18:
        return (((r0 * 31) + r3) * 31) + r2;
    }
}
