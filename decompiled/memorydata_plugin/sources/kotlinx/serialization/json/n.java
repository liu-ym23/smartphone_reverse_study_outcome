package kotlinx.serialization.json;

import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bHÆ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006\f"}, d2 = {"Lkotlinx/serialization/json/JsonNull;", "Lkotlinx/serialization/json/JsonPrimitive;", "()V", Params.CONTENT, "", "getContent", "()Ljava/lang/String;", "isString", "", "()Z", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlinx.serialization.h(a = o.class)
public final class n extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f17858a = null;
    private static final String d = null;
    private static final /* synthetic */ Lazy<kotlinx.serialization.c<Object>> e = null;

    static {
        f17858a = new n();
        d = "null";
        e = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) ZeusTransformUtils.preCheckCast(JsonNull$$cachedSerializer$delegate$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private n() {
        super(null);
    }

    @Override // kotlinx.serialization.json.r
    public String b() {
        return d;
    }
}
