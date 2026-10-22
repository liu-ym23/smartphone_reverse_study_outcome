package com.obric.aiagent.platform;

import com.obric.aiagent.platform.a.c;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.platform.a.e;
import com.obric.aiagent.platform.a.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0013"}, d2 = {"Lcom/obric/aiagent/platform/IAIAgentPlatform;", "", "getAppContext", "Lcom/obric/aiagent/platform/depend/IAppContext;", "getRuntimeContext", "Lcom/obric/aiagent/platform/depend/IRuntimeContext;", "getBuildContext", "Lcom/obric/aiagent/platform/depend/IBuildContext;", "getLogger", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "getSecureLogger", "Lcom/obric/aiagent/platform/depend/ISecureLogDepend;", "getSysLogger", "Lcom/obric/aiagent/platform/depend/ISysLogDepend;", "getTracer", "Lcom/obric/aiagent/platform/depend/ITraceDepend;", "getCloudConfig", "Lcom/obric/aiagent/platform/depend/ICloudConfig;", "Companion", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5959a = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aiagent/platform/IAIAgentPlatform$Companion;", "", "<init>", "()V", "commons", "", "", "setCommonParams", "", "key", "obj", "getCommonParams", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f5960a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Map<String, Object> f5961b = null;

        static {
            f5960a = new a();
            f5961b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        }

        private a() {
        }

        public final Object a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "key");
            return f5961b.get(r1);
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.platform.b$b, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C0242b {
        public static com.obric.aiagent.platform.a.b a(b r2) {
            b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            return null;
        }

        public static e b(b r2) {
            b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            return null;
        }

        public static f c(b r2) {
            b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            return null;
        }
    }

    static {
        f5959a = a.f5960a;
    }

    com.obric.aiagent.platform.a.a a();

    com.obric.aiagent.platform.a.b b();

    d c();

    e d();

    f e();

    c f();
}
