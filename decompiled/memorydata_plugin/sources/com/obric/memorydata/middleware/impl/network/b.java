package com.obric.memorydata.middleware.impl.network;

import com.bytedance.apm6.util.constant.ReportConsts;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.appcontext.IAppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/AppNetworkConst;", "", "<init>", "()V", "BOE_HOST", "", "getBOE_HOST", "()Ljava/lang/String;", "RELEASE_HOST", "getRELEASE_HOST", "PPE_HOST", "getPPE_HOST", "BASE_URL_BOE", "getBASE_URL_BOE", "BASE_URL_PPE", "getBASE_URL_PPE", "BASE_URL_RELEASE", "getBASE_URL_RELEASE", "HEADER_VALUE_USE", "HEADER_USE_PPE", "HEADER_TT_ENV", "HEADER_FEATURE", "HEADER_USE_BOE", "BOE_ENV_TAG", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11762a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f11763b = null;
    private static final String c = null;
    private static final String d = null;
    private static final String e = null;
    private static final String f = null;
    private static final String g = null;

    static {
        f11762a = new b();
        String r0 = AppContext.INSTANCE.getHost(IAppConfig.HOST_TYPE.BOE_HOST);
        f11763b = r0;
        String r1 = AppContext.INSTANCE.getHost(IAppConfig.HOST_TYPE.RELEASE_HOST);
        c = r1;
        String r2 = AppContext.INSTANCE.getHost(IAppConfig.HOST_TYPE.PPE_HOST);
        d = r2;
        e = ReportConsts.HTTPS + r0;
        f = ReportConsts.HTTPS + r2;
        g = ReportConsts.HTTPS + r1;
    }

    private b() {
    }

    public final String a() {
        return f11763b;
    }

    public final String b() {
        return c;
    }

    public final String c() {
        return d;
    }

    public final String d() {
        return e;
    }

    public final String e() {
        return f;
    }

    public final String f() {
        return g;
    }
}
