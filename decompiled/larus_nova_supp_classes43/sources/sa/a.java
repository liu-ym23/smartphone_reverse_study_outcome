package sa;

import android.view.View;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import ue7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class a implements IBDXBridgeContext {
    public final le7.a<?> a;
    public final String b;
    public final String c;
    public final PlatformType d;
    public final C0197a e;
    public String f;

    /* JADX INFO: renamed from: sa.a$a, reason: collision with other inner class name */
    public static final class C0197a implements d {
        public C0197a() {
        }

        public final void a(String r1, Map<String, ? extends Object> r10) {
            Intrinsics.checkNotNullParameter(r1, "eventName");
        }
    }

    public final View getEngineView() {
        return null;
    }

    public final <T> T getService(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        return null;
    }

    public final void sendEvent(String r1, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
    }

    public final le7.a<?> getBridgeCall() {
        return this.a;
    }

    public final String getCallId() {
        return this.f;
    }

    public final String getContainerID() {
        return this.b;
    }

    public final d getJsEventDelegate() {
        return this.e;
    }

    public final String getNamespace() {
        return this.c;
    }

    public final PlatformType getPlatformType() {
        return this.d;
    }

    public a(le7.a<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeCall");
        this.a = r10;
        this.b = "";
        this.c = "";
        this.d = r10.c();
        this.e = new C0197a();
        this.f = UUID.randomUUID().toString();
    }

    public final void setCallId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f = r10;
    }
}
