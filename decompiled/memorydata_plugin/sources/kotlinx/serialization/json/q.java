package kotlinx.serialization.json;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/json/JsonObjectSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonObject;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", EventBody.KEY_VALUE, "JsonObjectDescriptor", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class q implements kotlinx.serialization.c<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f17862a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.serialization.descriptors.f f17863b = null;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001a\u001a\u00020\tH\u0097\u0001J\u0011\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\tH\u0097\u0001J\u0011\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0015H\u0097\u0001J\u0011\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\tH\u0097\u0001J\u0011\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\tH\u0097\u0001R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\r8VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00118\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u00020\u00158\u0016X\u0097D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lkotlinx/serialization/json/JsonObjectSerializer$JsonObjectDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "()V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount", "()I", "isInline", "", "()Z", "isNullable", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "serialName", "", "getSerialName$annotations", "getSerialName", "()Ljava/lang/String;", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", ActivityLifecycle.NAME, "getElementName", "isElementOptional", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a implements kotlinx.serialization.descriptors.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f17864a = null;
        private static final String c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final /* synthetic */ kotlinx.serialization.descriptors.f f17865b;

        static {
            f17864a = new a();
            c = "kotlinx.serialization.json.JsonObject";
        }

        private a() {
            this.f17865b = kotlinx.serialization.a.a.c(kotlinx.serialization.a.a.a(StringCompanionObject.INSTANCE), (kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(i.f17835a, kotlinx.serialization.c.class, "com.obric.memorydata.plugin")).a();
        }

        @Override // kotlinx.serialization.descriptors.f
        public int a(String r2) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            return this.f17865b.a(r2);
        }

        @Override // kotlinx.serialization.descriptors.f
        public List<Annotation> a() {
            return this.f17865b.a();
        }

        @Override // kotlinx.serialization.descriptors.f
        public List<Annotation> a(int r1) {
            return this.f17865b.a(r1);
        }

        @Override // kotlinx.serialization.descriptors.f
        public int b() {
            return this.f17865b.b();
        }

        @Override // kotlinx.serialization.descriptors.f
        public kotlinx.serialization.descriptors.f b(int r1) {
            return this.f17865b.b(r1);
        }

        @Override // kotlinx.serialization.descriptors.f
        public String c(int r1) {
            return this.f17865b.c(r1);
        }

        @Override // kotlinx.serialization.descriptors.f
        public boolean c() {
            return this.f17865b.c();
        }

        @Override // kotlinx.serialization.descriptors.f
        public boolean d() {
            return this.f17865b.d();
        }

        @Override // kotlinx.serialization.descriptors.f
        public boolean d(int r1) {
            return this.f17865b.d(r1);
        }

        @Override // kotlinx.serialization.descriptors.f
        public kotlinx.serialization.descriptors.j e() {
            return this.f17865b.e();
        }

        @Override // kotlinx.serialization.descriptors.f
        public String f() {
            return c;
        }
    }

    static {
        f17862a = new q();
        f17863b = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(a.f17864a, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
    }

    private q() {
    }

    @Override // kotlinx.serialization.b
    public /* synthetic */ Object a(kotlinx.serialization.b.c r3) {
        return b((kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.c, kotlinx.serialization.b
    public kotlinx.serialization.descriptors.f a() {
        return f17863b;
    }

    public p b(kotlinx.serialization.b.c r5) {
        kotlinx.serialization.b.c r4 = (kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "decoder");
        j.b(r4);
        return new p((Map) ZeusTransformUtils.preCheckCast(kotlinx.serialization.a.a.c(kotlinx.serialization.a.a.a(StringCompanionObject.INSTANCE), (kotlinx.serialization.c) ZeusTransformUtils.preCheckCast(i.f17835a, kotlinx.serialization.c.class, "com.obric.memorydata.plugin")).a(r4), Map.class, "com.obric.memorydata.plugin"));
    }
}
