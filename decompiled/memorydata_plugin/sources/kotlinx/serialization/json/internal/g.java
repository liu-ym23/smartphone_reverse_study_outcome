package kotlinx.serialization.json.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\b\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006H\u0086\u0002¢\u0006\u0002\u0010\fJ9\u0010\r\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\t0\u000f¢\u0006\u0002\u0010\u0010J6\u0010\u0011\u001a\u00020\u0012\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u00062\u0006\u0010\u0013\u001a\u0002H\tH\u0086\u0002¢\u0006\u0002\u0010\u0014R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012 \u0012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u0004j\b\u0012\u0004\u0012\u00020\u0001`\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "", "()V", "map", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "Lkotlinx/serialization/json/internal/DescriptorData;", "get", ExifInterface.GPS_DIRECTION_TRUE, "descriptor", "key", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;)Ljava/lang/Object;", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "set", "", EventBody.KEY_VALUE, "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;Ljava/lang/Object;)V", "Key", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<kotlinx.serialization.descriptors.f, Map<a<Object>, Object>> f17842a;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a<T> {
        public a() {
        }
    }

    public g() {
        this.f17842a = f.a(1);
    }

    public final <T> T a(kotlinx.serialization.descriptors.f r3, a<T> r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Intrinsics.checkNotNullParameter(r4, "key");
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(this.f17842a.get(r5), Map.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        Object r6 = r2.get(r4);
    L6:
        if (r6 != null) goto L9;
        return null;
    L9:
        return (T) r6;
    L5:
        r6 = null;
        goto L6
    }

    public final <T> T a(kotlinx.serialization.descriptors.f r3, a<T> r4, Function0<? extends T> r5) {
        kotlinx.serialization.descriptors.f r6 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "descriptor");
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r7, "defaultValue");
        T r0 = (T) a(r6, r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        T r8 = (T) r7.invoke();
        a(r6, r4, r8);
        return r8;
    }

    public final <T> void a(kotlinx.serialization.descriptors.f r3, a<T> r4, T r5) {
        kotlinx.serialization.descriptors.f r6 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "descriptor");
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
        Map<kotlinx.serialization.descriptors.f, Map<a<Object>, Object>> r2 = this.f17842a;
        Map<a<Object>, Object> r0 = r2.get(r6);
        if (r0 != null) goto L5;
        r0 = f.a(1);
        r2.put(r6, r0);
    L5:
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r4, r5);
    }
}
