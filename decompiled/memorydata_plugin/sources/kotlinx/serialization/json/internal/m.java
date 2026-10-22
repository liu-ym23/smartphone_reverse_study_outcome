package kotlinx.serialization.json.internal;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.ar;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\tH\u0016J \u0010\u0016\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", EventBody.KEY_VALUE, "Lkotlinx/serialization/json/JsonObject;", "polyDiscriminator", "", "polyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "forceNull", "", "position", "", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "absenceIsNull", "descriptor", "index", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "coerceInputValue", LocationMonitorConst.TAG, "currentElement", "Lkotlinx/serialization/json/JsonElement;", "decodeElementIndex", "decodeNotNullMark", "elementName", "desc", "endStructure", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
class m extends c {
    private final kotlinx.serialization.json.p c;
    private final String d;
    private final kotlinx.serialization.descriptors.f e;
    private int f;
    private boolean g;

    public m(kotlinx.serialization.json.a r3, kotlinx.serialization.json.p r4, String r5, kotlinx.serialization.descriptors.f r6) {
        kotlinx.serialization.descriptors.f r7 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "json");
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        super(r3, (kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(r4, kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin"), null);
        this.c = r4;
        this.d = r5;
        this.e = r7;
    }

    public /* synthetic */ m(kotlinx.serialization.json.a r2, kotlinx.serialization.json.p r3, String r4, kotlinx.serialization.descriptors.f r5, int r6, DefaultConstructorMarker r7) {
        kotlinx.serialization.descriptors.f r8 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r8 = null;
    L8:
        this(r2, r3, r4, r8);
    }

    private final boolean a(kotlinx.serialization.descriptors.f r6, int r7, String r8) {
        kotlinx.serialization.descriptors.f r9 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        kotlinx.serialization.json.a r0 = a();
        kotlinx.serialization.descriptors.f r10 = r9.b(r7);
        if (r10.d() == true) goto L8;
        if (ZeusTransformUtils.instanceOf(c(r8), kotlinx.serialization.json.n.class) == false) goto L8;
        return true;
    L8:
        if (Intrinsics.areEqual(r10.e(), kotlinx.serialization.descriptors.j.b.f17690a) == false) goto L21;
        kotlinx.serialization.json.g r5 = c(r8);
        String r11 = null;
        if (ZeusTransformUtils.instanceOf(r5, kotlinx.serialization.json.r.class) == false) goto L12;
        kotlinx.serialization.json.r r12 = (kotlinx.serialization.json.r) ZeusTransformUtils.preCheckCast(r5, kotlinx.serialization.json.r.class, "com.obric.memorydata.plugin");
    L13:
        if (r12 == null) goto L15;
        r11 = kotlinx.serialization.json.h.f(r12);
    L15:
        if (r11 == null) goto L21;
        if (k.a(r10, r0, r11) != (-3)) goto L21;
        return true;
    L12:
        r12 = null;
    L21:
        return false;
    }

    private final boolean n(kotlinx.serialization.descriptors.f r3, int r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        if (a().a().d() == false) goto L5;
    L9:
        boolean r6 = false;
    L10:
        this.g = r6;
        return r6;
    L5:
        if (r5.d(r4) == true) goto L9;
        if (r5.b(r4).d() == false) goto L9;
        r6 = true;
        goto L10
    }

    @Override // kotlinx.serialization.json.internal.c, kotlinx.serialization.internal.cc, kotlinx.serialization.b.c
    public boolean b() {
        if (this.g == false) goto L5;
    L7:
        return false;
    L5:
        if (super.b() == false) goto L7;
        return true;
    }

    @Override // kotlinx.serialization.json.internal.c, kotlinx.serialization.internal.cc, kotlinx.serialization.b.c
    public kotlinx.serialization.b.b c(kotlinx.serialization.descriptors.f r3) {
        kotlinx.serialization.descriptors.f r4 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "descriptor");
        if (r4 != this.e) goto L7;
        return (kotlinx.serialization.b.b) ZeusTransformUtils.preCheckCast(this, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin");
    L7:
        return super.c(r4);
    }

    @Override // kotlinx.serialization.json.internal.c
    public kotlinx.serialization.json.g c(String r3) {
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        return (kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(MapsKt.getValue((Map) ZeusTransformUtils.preCheckCast(q(), Map.class, "com.obric.memorydata.plugin"), r3), kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.json.internal.c, kotlinx.serialization.internal.cc, kotlinx.serialization.b.b
    public void d(kotlinx.serialization.descriptors.f r5) {
        kotlinx.serialization.descriptors.f r6 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "descriptor");
        if (this.f17839b.a() == false) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r6.e(), kotlinx.serialization.descriptors.d.class) == false) goto L8;
        return;
    L8:
        if (this.f17839b.i() == true) goto L10;
        Set<String> r7 = ar.a(r6);
    L17:
        Iterator<String> r0 = q().keySet().iterator();
    L19:
        if (r0.hasNext() == false) goto L35;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (r7.contains(r2) == true) goto L19;
        if (Intrinsics.areEqual(r2, this.d) == true) goto L19;
        throw j.a(r2, q().toString());
    L35:
        return;
    L10:
        Set<String> r1 = ar.a(r6);
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(kotlinx.serialization.json.t.a(a()).a(r6, k.a()), Map.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L13;
        Set r9 = r8.keySet();
    L14:
        if (r9 != null) goto L16;
        r9 = SetsKt.emptySet();
    L16:
        r7 = SetsKt.plus(r1, (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"));
        goto L17
    L13:
        r9 = null;
        goto L14
    }

    @Override // kotlinx.serialization.b.b
    public int f(kotlinx.serialization.descriptors.f r6) {
        kotlinx.serialization.descriptors.f r7 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "descriptor");
    L4:
        if (this.f >= r7.b()) goto L14;
        int r0 = this.f;
        this.f = r0 + 1;
        String r1 = k(r7, r0);
        int r2 = this.f - 1;
        this.g = false;
        if (((Map) ZeusTransformUtils.preCheckCast(q(), Map.class, "com.obric.memorydata.plugin")).containsKey(r1) == true) goto L10;
        if (n(r7, r2) == false) goto L4;
    L10:
        if (this.f17839b.e() == false) goto L13;
        if (a(r7, r2, r1) == true) goto L4;
    L13:
        return r2;
    L14:
        return -1;
    }

    @Override // kotlinx.serialization.internal.be
    public String l(kotlinx.serialization.descriptors.f r7, int r8) {
        kotlinx.serialization.descriptors.f r9 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r7, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "desc");
        String r0 = r9.c(r8);
        if (this.f17839b.i() == true) goto L6;
        return r0;
    L6:
        if (q().keySet().contains(r0) == false) goto L8;
        return r0;
    L8:
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(kotlinx.serialization.json.t.a(a()).a(r9, k.a(), (Function0) ZeusTransformUtils.preCheckCast(new JsonTreeDecoder$elementName$alternativeNamesMap$1(r9), Function0.class, "com.obric.memorydata.plugin")), Map.class, "com.obric.memorydata.plugin");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(q().keySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r6.hasNext() == false) goto L20;
        Object r2 = r6.next();
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r10.get((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L10;
    L21:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L25;
        return r0;
    L25:
        return r11;
    L15:
        if (r3.intValue() != r8) goto L17;
        r4 = true;
        goto L18
    L20:
        r2 = null;
        goto L21
    }

    @Override // kotlinx.serialization.json.internal.c
    public /* synthetic */ kotlinx.serialization.json.g p() {
        return (kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(q(), kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin");
    }

    public kotlinx.serialization.json.p q() {
        return this.c;
    }
}
