package com.obric.aikernel.middleware.impl.network;

import com.bytedance.apm6.util.constant.NetConst;
import com.obric.aikernel.middleware.api.env.EnvManager;
import com.obric.aikernel.middleware.api.env.NetEnv;
import com.obric.aikernel.middleware.api.rpc.IAppNetConfig;
import com.obric.aikernel.utils.i;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class AppNetConfigImpl implements IAppNetConfig {
    public static final AppNetConfigImpl INSTANCE = null;
    private static final List<String> whiteHeaderPath = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4558a = null;

        static {
            int[] r10 = new int[NetEnv.values().length];
            r10[NetEnv.PPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r10[NetEnv.BOE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f4558a = r10;
        }
    }

    static {
        INSTANCE = new AppNetConfigImpl();
        whiteHeaderPath = CollectionsKt.mutableListOf(new String[]{""});
    }

    private AppNetConfigImpl() {
    }

    @JvmStatic
    public static final AppNetConfigImpl getInst() {
        return INSTANCE;
    }

    private final boolean hitWhite(String r10) {
        Iterator<String> r11 = whiteHeaderPath.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (StringsKt.contains$default(r10, r11.next(), false, 2, null) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IAppNetConfig
    public String getBaseHost() {
        NetEnv r10 = EnvManager.INSTANCE.getAdminNetEnv();
        int r11 = a.f4558a[r10.ordinal()];
        if (r11 == 1) goto L9;
        if (r11 == 2) goto L11;
        return q7.a.f12479a.f();
    L11:
        return q7.a.f12479a.d();
    L9:
        return q7.a.f12479a.e();
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IAppNetConfig
    public String getBaseUrl() {
        NetEnv r10 = EnvManager.INSTANCE.getAdminNetEnv();
        int r11 = a.f4558a[r10.ordinal()];
        if (r11 == 1) goto L9;
        if (r11 == 2) goto L11;
        return q7.a.f12479a.c();
    L11:
        return q7.a.f12479a.a();
    L9:
        return q7.a.f12479a.b();
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IAppNetConfig
    public Map<String, String> getEnvHeaders(String r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        EnvManager r11 = EnvManager.INSTANCE;
        String r12 = r11.getAdminTTEnvHeader();
        if (r12.length() != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L10;
        return MapsKt.emptyMap();
    L10:
        if (hitWhite(r10) == true) goto L18;
        if (r11.getAdminNetEnv() != NetEnv.BOE) goto L16;
        Map<String, String> r14 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("x-use-boe", NetConst.ENCRYPT_VERISON_CODE)});
    L14:
        i.a(r14, "X-TT-Env", r12);
        return r14;
    L16:
        r14 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("X-Use-PPE", NetConst.ENCRYPT_VERISON_CODE)});
        goto L14
    L18:
        return MapsKt.emptyMap();
    L5:
        r13 = false;
        goto L6
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IAppNetConfig
    public List<q4.a> getInterceptors() {
        return CollectionsKt.listOf(AppNetInterceptor.f4559c);
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IAppNetConfig
    public String getReleaseUrl() {
        return q7.a.f12479a.c();
    }
}
