package z2;

import com.bytedance.ai.bridge.ContainerType;
import d3.a0;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q extends a0 {
    public final Function0<a0> a;
    public final ContainerType b;
    public final String c;
    public volatile String d;

    @Override // d3.a0
    public final String getAppId() {
        a0 r0 = (a0) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAppId();
    }

    @Override // d3.a0
    public final String getAppletId() {
        a0 r0 = (a0) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAppletId();
    }

    @Override // d3.a0
    public final String getContainerId() {
        return this.c;
    }

    @Override // d3.a0
    public final ContainerType getContainerType() {
        return this.b;
    }

    @Override // d3.a0
    public final String getUrl() {
        return this.d;
    }

    public q(k r10) {
        Intrinsics.checkNotNullParameter(r10, "parentContextProvider");
        this.a = r10;
        this.b = ContainerType.EMBED_WEB_VIEW;
        this.c = UUID.randomUUID().toString();
    }
}
