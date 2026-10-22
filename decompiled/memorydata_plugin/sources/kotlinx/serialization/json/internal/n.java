package kotlinx.serialization.json.internal;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\bH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeListDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", EventBody.KEY_VALUE, "Lkotlinx/serialization/json/JsonArray;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonArray;)V", "currentIndex", "", "size", "getValue", "()Lkotlinx/serialization/json/JsonArray;", "currentElement", "Lkotlinx/serialization/json/JsonElement;", LocationMonitorConst.TAG, "", "decodeElementIndex", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementName", "desc", "index", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class n extends c {
    private final kotlinx.serialization.json.b c;
    private final int d;
    private int e;

    public n(kotlinx.serialization.json.a r3, kotlinx.serialization.json.b r4) {
        Intrinsics.checkNotNullParameter(r3, "json");
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        super(r3, (kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(r4, kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin"), null);
        this.c = r4;
        this.d = q().size();
        this.e = -1;
    }

    @Override // kotlinx.serialization.json.internal.c
    public kotlinx.serialization.json.g c(String r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        return q().a(Integer.parseInt(r2));
    }

    @Override // kotlinx.serialization.b.b
    public int f(kotlinx.serialization.descriptors.f r3) {
        Intrinsics.checkNotNullParameter((kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"), "descriptor");
        int r4 = this.e;
        if (r4 >= (this.d - 1)) goto L6;
        int r5 = r4 + 1;
        this.e = r5;
        return r5;
    L6:
        return -1;
    }

    @Override // kotlinx.serialization.internal.be
    public String l(kotlinx.serialization.descriptors.f r2, int r3) {
        Intrinsics.checkNotNullParameter((kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"), "desc");
        return String.valueOf(r3);
    }

    @Override // kotlinx.serialization.json.internal.c
    public /* synthetic */ kotlinx.serialization.json.g p() {
        return (kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(q(), kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin");
    }

    public kotlinx.serialization.json.b q() {
        return this.c;
    }
}
