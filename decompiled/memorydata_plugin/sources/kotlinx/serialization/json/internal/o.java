package kotlinx.serialization.json.internal;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0014J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000bH\u0014J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeMapDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", EventBody.KEY_VALUE, "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;)V", "keys", "", "", "position", "", "size", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", LocationMonitorConst.TAG, "decodeElementIndex", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementName", "desc", "index", "endStructure", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class o extends m {
    private final kotlinx.serialization.json.p c;
    private final List<String> d;
    private final int e;
    private int f;

    public o(kotlinx.serialization.json.a r9, kotlinx.serialization.json.p r10) {
        Intrinsics.checkNotNullParameter(r9, "json");
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        super(r9, r10, null, null, 12, null);
        this.c = r10;
        List<String> r11 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(q().keySet(), Iterable.class, "com.obric.memorydata.plugin"));
        this.d = r11;
        this.e = r11.size() * 2;
        this.f = -1;
    }

    @Override // kotlinx.serialization.json.internal.m, kotlinx.serialization.json.internal.c
    public kotlinx.serialization.json.g c(String r3) {
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        if ((this.f % 2) != 0) goto L5;
        Object r2 = kotlinx.serialization.json.h.a(r3);
    L7:
        return (kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(r2, kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin");
    L5:
        r2 = MapsKt.getValue((Map) ZeusTransformUtils.preCheckCast(q(), Map.class, "com.obric.memorydata.plugin"), r3);
        goto L7
    }

    @Override // kotlinx.serialization.json.internal.m, kotlinx.serialization.json.internal.c, kotlinx.serialization.internal.cc, kotlinx.serialization.b.b
    public void d(kotlinx.serialization.descriptors.f r2) {
        Intrinsics.checkNotNullParameter((kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"), "descriptor");
    }

    @Override // kotlinx.serialization.json.internal.m, kotlinx.serialization.b.b
    public int f(kotlinx.serialization.descriptors.f r3) {
        Intrinsics.checkNotNullParameter((kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"), "descriptor");
        int r4 = this.f;
        if (r4 >= (this.e - 1)) goto L6;
        int r5 = r4 + 1;
        this.f = r5;
        return r5;
    L6:
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.m, kotlinx.serialization.internal.be
    public String l(kotlinx.serialization.descriptors.f r3, int r4) {
        Intrinsics.checkNotNullParameter((kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"), "desc");
        List<String> r2 = this.d;
        return (String) ZeusTransformUtils.preCheckCast(r2.get(r4 / 2), String.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.json.internal.m, kotlinx.serialization.json.internal.c
    public /* synthetic */ kotlinx.serialization.json.g p() {
        return (kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(q(), kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.json.internal.m
    public kotlinx.serialization.json.p q() {
        return this.c;
    }
}
