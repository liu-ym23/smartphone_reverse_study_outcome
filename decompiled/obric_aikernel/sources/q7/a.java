package q7;

import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.appcontext.IAppConfig;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12479a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f12480b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f12481c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12482d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f12483e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f12484f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f12485g = null;

    static {
        f12479a = new a();
        AppContext r10 = AppContext.INSTANCE;
        String r11 = r10.getHost(IAppConfig.HOST_TYPE.BOE_HOST);
        f12480b = r11;
        String r12 = r10.getHost(IAppConfig.HOST_TYPE.RELEASE_HOST);
        f12481c = r12;
        String r13 = r10.getHost(IAppConfig.HOST_TYPE.PPE_HOST);
        f12482d = r13;
        f12483e = r11;
        f12484f = r13;
        f12485g = r12;
    }

    private a() {
    }

    public final String a() {
        return f12483e;
    }

    public final String b() {
        return f12484f;
    }

    public final String c() {
        return f12485g;
    }

    public final String d() {
        return f12480b;
    }

    public final String e() {
        return f12482d;
    }

    public final String f() {
        return f12481c;
    }
}
