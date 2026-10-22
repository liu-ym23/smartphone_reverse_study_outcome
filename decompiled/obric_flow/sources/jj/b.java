package jj;

import ai.g0;
import ai.h0;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements IHostNetworkDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18348a;

    public /* synthetic */ b(int r5) {
        this.f18348a = r5;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend
    public final XIRetrofit createRetrofit(String r5, boolean r10) {
        int r11 = this.f18348a;
        Intrinsics.checkNotNullParameter(r5, "baseUrl");
        switch(r11) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        ConcurrentHashMap r12 = com.ivy.ivykit.api.bridge.b.f9471a;
        Intrinsics.checkNotNullParameter(nl.b.class, "clazz");
        if (com.ivy.ivykit.api.bridge.b.f9471a.get(nl.b.class) != null) goto L9;
        return null;
    L9:
        throw new ClassCastException();
    L10:
        Intrinsics.checkNotNullParameter(r5, "baseUrl");
        g0 r13 = new g0(0);
        r13.g(r5);
        r13.c(aa.a.f());
        r13.g = new h.a(3);
        r13.d(new wa.a(1));
        if (r10 == false) goto L13;
        Object r14 = new t9.a();
    L14:
        r13.f210b = r14;
        h0 r15 = r13.e();
        Intrinsics.checkNotNullParameter(r15, "retrofit");
        we.a r16 = new we.a();
        r16.f22857a = r15;
        return r16;
    L13:
        r14 = new uj.a();
        goto L14
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend
    public final Map getAPIParams() {
        switch(this.f18348a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        ConcurrentHashMap r5 = com.ivy.ivykit.api.bridge.b.f9471a;
        Intrinsics.checkNotNullParameter(nl.b.class, "clazz");
        if (com.ivy.ivykit.api.bridge.b.f9471a.get(nl.b.class) != null) goto L8;
        return null;
    L8:
        throw new ClassCastException();
    L9:
        return null;
    }
}
