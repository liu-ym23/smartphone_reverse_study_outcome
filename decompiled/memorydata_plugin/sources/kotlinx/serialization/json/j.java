package kotlinx.serialization.json;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u0007H\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\tH\u0000¨\u0006\u000e"}, d2 = {"defer", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "deferred", "Lkotlin/Function0;", "verify", "", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "asJsonDecoder", "Lkotlinx/serialization/json/JsonDecoder;", "asJsonEncoder", "Lkotlinx/serialization/json/JsonEncoder;", "kotlinx-serialization-json"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class j {

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"kotlinx/serialization/json/JsonElementSerializersKt$defer$1", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementsCount", "", "getElementsCount", "()I", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "original", "getOriginal", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "original$delegate", "Lkotlin/Lazy;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", ActivityLifecycle.NAME, "getElementName", "isElementOptional", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements kotlinx.serialization.descriptors.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Lazy f17854a;

        a(Function0<? extends kotlinx.serialization.descriptors.f> r3) {
            this.f17854a = LazyKt.lazy((Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin"));
        }

        private final kotlinx.serialization.descriptors.f g() {
            return (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(this.f17854a.getValue(), kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.serialization.descriptors.f
        public int a(String r2) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            return g().a(r2);
        }

        @Override // kotlinx.serialization.descriptors.f
        public List<Annotation> a() {
            return kotlinx.serialization.descriptors.f.a.c(this);
        }

        @Override // kotlinx.serialization.descriptors.f
        public List<Annotation> a(int r1) {
            return g().a(r1);
        }

        @Override // kotlinx.serialization.descriptors.f
        public int b() {
            return g().b();
        }

        @Override // kotlinx.serialization.descriptors.f
        public kotlinx.serialization.descriptors.f b(int r1) {
            return g().b(r1);
        }

        @Override // kotlinx.serialization.descriptors.f
        public String c(int r1) {
            return g().c(r1);
        }

        @Override // kotlinx.serialization.descriptors.f
        public boolean c() {
            return kotlinx.serialization.descriptors.f.a.b(this);
        }

        @Override // kotlinx.serialization.descriptors.f
        public boolean d() {
            return kotlinx.serialization.descriptors.f.a.a(this);
        }

        @Override // kotlinx.serialization.descriptors.f
        public boolean d(int r1) {
            return g().d(r1);
        }

        @Override // kotlinx.serialization.descriptors.f
        public kotlinx.serialization.descriptors.j e() {
            return g().e();
        }

        @Override // kotlinx.serialization.descriptors.f
        public String f() {
            return g().f();
        }
    }

    public static final /* synthetic */ kotlinx.serialization.descriptors.f a(Function0 r2) {
        return b((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final f a(kotlinx.serialization.b.c r3) {
        kotlinx.serialization.b.c r4 = (kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, f.class) == false) goto L5;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L9;
        return r0;
    L9:
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + Reflection.getOrCreateKotlinClass(r4.getClass()));
    L5:
        r0 = null;
        goto L6
    }

    private static final kotlinx.serialization.descriptors.f b(Function0<? extends kotlinx.serialization.descriptors.f> r2) {
        return (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(new a((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")), kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void b(kotlinx.serialization.b.c r2) {
        c((kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin"));
    }

    private static final void c(kotlinx.serialization.b.c r2) {
        a((kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin"));
    }
}
