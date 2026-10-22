package kotlinx.serialization.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\t¨\u0006\u000f"}, d2 = {"Lkotlinx/serialization/internal/InlineClassDescriptor;", "Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", ActivityLifecycle.NAME, "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;)V", "isInline", "", "()Z", "equals", "other", "", "hashCode", "", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class am extends bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f17716a;

    public am(String r3, ah<?> r4) {
        ah r5 = (ah) ZeusTransformUtils.wrapperContextForParams(r4, ah.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "generatedSerializer");
        super(r3, r5, 1);
        this.f17716a = true;
    }

    @Override // kotlinx.serialization.internal.bn, kotlinx.serialization.descriptors.f
    public boolean c() {
        return this.f17716a;
    }

    @Override // kotlinx.serialization.internal.bn
    public boolean equals(Object r8) {
        kotlinx.serialization.descriptors.f r1 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(this, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        if (r1 != r8) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, am.class) == true) goto L9;
    L31:
        return false;
    L9:
        if (Intrinsics.areEqual(r1.f(), ((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r8, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).f()) == false) goto L31;
        am r0 = (am) ZeusTransformUtils.preCheckCast(r8, am.class, "com.obric.memorydata.plugin");
        if (r0.c() == true) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == false) goto L31;
        if (r1.b() != ((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r8, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).b()) goto L31;
        int r9 = r1.b();
        int r2 = 0;
    L23:
        if (r2 >= r9) goto L36;
        if (Intrinsics.areEqual(r1.b(r2).f(), ((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r8, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).b(r2).f()) == false) goto L31;
        if (Intrinsics.areEqual(r1.b(r2).e(), ((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r8, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).b(r2).e()) == false) goto L31;
        r2 = r2 + 1;
        goto L23
    L36:
        return true;
    L14:
        if (Arrays.equals(h(), r0.h()) == false) goto L16;
        r7 = true;
        goto L17
    }

    @Override // kotlinx.serialization.internal.bn
    public int hashCode() {
        return super.hashCode() * 31;
    }
}
