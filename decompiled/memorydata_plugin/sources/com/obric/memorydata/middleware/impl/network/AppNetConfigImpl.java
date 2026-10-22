package com.obric.memorydata.middleware.impl.network;

import com.bytedance.retrofit2.intercept.Interceptor;
import com.obric.memorydata.middleware.api.env.EnvManager;
import com.obric.memorydata.middleware.api.env.NetEnv;
import com.obric.memorydata.middleware.api.rpc.IAppNetConfig;
import com.obric.memorydata.utils.ae;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\u0000H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/AppNetConfigImpl;", "Lcom/obric/memorydata/middleware/api/rpc/IAppNetConfig;", "<init>", "()V", "whiteHeaderPath", "", "", "getInst", "hitWhite", "", "url", "getBaseUrl", "getBaseHost", "getEnvHeaders", "", "getReleaseUrl", "getInterceptors", "", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppNetConfigImpl implements IAppNetConfig {
    public static final AppNetConfigImpl INSTANCE = null;
    private static final List<String> whiteHeaderPath = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11755a = null;

        static {
            int[] r0 = new int[NetEnv.values().length];
            r0[NetEnv.PPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[NetEnv.BOE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f11755a = r0;
        }
    }

    static {
        INSTANCE = new AppNetConfigImpl();
        whiteHeaderPath = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    private AppNetConfigImpl() {
    }

    @JvmStatic
    public static final AppNetConfigImpl getInst() {
        return INSTANCE;
    }

    private final boolean hitWhite(String r6) {
        Iterator<String> r5 = whiteHeaderPath.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IAppNetConfig
    public String getBaseHost() {
        NetEnv r1 = EnvManager.INSTANCE.getAdminNetEnv();
        int r2 = a.f11755a[r1.ordinal()];
        if (r2 == 1) goto L9;
        if (r2 == 2) goto L11;
        return b.f11762a.b();
    L11:
        return b.f11762a.a();
    L9:
        return b.f11762a.c();
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IAppNetConfig
    public String getBaseUrl() {
        NetEnv r1 = EnvManager.INSTANCE.getAdminNetEnv();
        int r2 = a.f11755a[r1.ordinal()];
        if (r2 == 1) goto L9;
        if (r2 == 2) goto L11;
        return b.f11762a.f();
    L11:
        return b.f11762a.d();
    L9:
        return b.f11762a.e();
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IAppNetConfig
    public Map<String, String> getEnvHeaders(String r6) {
        Intrinsics.checkNotNullParameter(r6, "url");
        String r0 = EnvManager.INSTANCE.getAdminTTEnvHeader();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        return MapsKt.emptyMap();
    L10:
        if (hitWhite(r6) == true) goto L18;
        if (EnvManager.INSTANCE.getAdminNetEnv() != NetEnv.BOE) goto L16;
        Map<String, String> r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("x-use-boe", "1")});
    L14:
        ae.a(r5, "X-TT-Env", r0);
        return r5;
    L16:
        r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("X-Use-PPE", "1")});
        goto L14
    L18:
        return MapsKt.emptyMap();
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IAppNetConfig
    public List<Interceptor> getInterceptors() {
        return CollectionsKt.listOf(com.obric.memorydata.middleware.impl.network.a.f11759a);
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IAppNetConfig
    public String getReleaseUrl() {
        return b.f11762a.f();
    }
}
