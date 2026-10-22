package com.bytedance.android.ad.sdk.api.gecko;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import l6.g;
import t6.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class AdGeckoUtils$isGeckoLocalTest$2 extends Lambda implements Function0<Boolean> {
    public static final AdGeckoUtils$isGeckoLocalTest$2 INSTANCE = null;

    static {
        INSTANCE = new AdGeckoUtils$isGeckoLocalTest$2();
    }

    public AdGeckoUtils$isGeckoLocalTest$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m82invoke() {
        b r0 = b.a.a;
        GeckoGlobalConfig r1 = b.a();
        if (r1 == null) goto L5;
        GeckoGlobalConfig.ENVType r10 = r1.getEnv();
    L7:
        if (r10 != null) goto L9;
        t6.b r11 = a.a;
        g r12 = (g) a.C0199a.a(g.class, null);
        if (r12 != null) goto L16;
    L18:
        return false;
    L16:
        if (r12.isDebug() != true) goto L18;
        return true;
    L9:
        if (r10 != GeckoGlobalConfig.ENVType.PROD) goto L19;
        return false;
    L19:
        return true;
    L5:
        r10 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m82invoke());
    }
}
