package com.obric.aiagent.platform.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/platform/depend/ICloudConfig;", "", "getSettingsConfig", "Lorg/json/JSONObject;", "key", "", "Companion", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5952a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/platform/depend/ICloudConfig$Companion;", "Lcom/obric/aiagent/platform/depend/ICloudConfig;", "<init>", "()V", "impl", "getImpl", "()Lcom/obric/aiagent/platform/depend/ICloudConfig;", "impl$delegate", "Lkotlin/Lazy;", "getSettingsConfig", "Lorg/json/JSONObject;", "key", "", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ a f5953b = null;
        private static final Lazy<c> c = null;

        static {
            f5953b = new a();
            c = LazyKt.lazy($$Lambda$c$a$mro2nmUAdw98xAvcsTlQoETOiKo.INSTANCE);
        }

        private a() {
        }

        private final c a() {
            return (c) ZeusTransformUtils.preCheckCast(c.getValue(), c.class, "com.obric.memorydata.plugin");
        }

        private static final c b() {
            com.obric.aiagent.platform.b r0 = com.obric.aiagent.platform.a.f5946a.a();
            if (r0 == null) goto L7;
            c r1 = r0.f();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return (c) ZeusTransformUtils.preCheckCast(com.ss.android.ugc.aweme.framework.services.f.a().a(c.class), c.class, "com.obric.memorydata.plugin");
        }

        public static /* synthetic */ c lambda$mro2nmUAdw98xAvcsTlQoETOiKo() {
            return b();
        }

        @Override // com.obric.aiagent.platform.a.c
        public JSONObject a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            c r1 = a();
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.a(r2);
        }
    }

    static {
        f5952a = a.f5953b;
    }

    JSONObject a(String r1);
}
