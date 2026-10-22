package com.bytedance.android.livesdk.gecko;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoConfig;
import io.reactivex.Observable;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class TC21GeckoClientImpl implements o {
    public static final /* synthetic */ int e = 0;
    public GeckoClient a;
    public final Lazy b;
    public String c;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    private final Context getContext() {
        return (Context) this.b.getValue();
    }

    public TC21GeckoClientImpl() {
        this.b = LazyKt.lazy(TC21GeckoClientImpl$context$2.INSTANCE);
        this.c = "";
        this.d = LazyKt.lazy(new TC21GeckoClientImpl$geckoDir$2(this));
    }

    public static final /* synthetic */ Context b(TC21GeckoClientImpl r0) {
        return r0.getContext();
    }

    @Override // com.bytedance.android.livesdk.gecko.o
    public final Observable a(o.a r7) {
        Intrinsics.checkNotNullParameter(r7, "args");
        if (Intrinsics.areEqual(r7.a, "") == true) goto L5;
        boolean r1 = true;
        if ((!Intrinsics.areEqual(this.c, r7.a)) == false) goto L22;
        String r0 = r7.a;
        p r2 = p.a;     // Catch: Exception -> L19
        GeckoConfig.Builder r3 = new GeckoConfig.Builder(getContext()).host("gecko.zijieapi.com").appId(jc1.k.n(IHostContext.class).appId()).appVersion(jc1.k.n(IHostContext.class).getVersionName()).allLocalAccessKeys(new String[]{r0}).region("CN").accessKey(new String[]{r0});     // Catch: Exception -> L19
        String r4 = jc1.k.n(IHostContext.class).getServerDeviceId();     // Catch: Exception -> L19
        if (r4 != null) goto L12;
    L15:
        if (r1 == false) goto L17;
        r4 = "test";
    L17:
        GeckoClient r5 = GeckoClient.create(r3.deviceId(r4).resRootDir((File) this.d.getValue()).updateExecutor(r2).checkUpdateExecutor(r2).build());     // Catch: Exception -> L19
    L21:
        this.a = r5;
        this.c = r7.a;
        goto L22
    L12:
        if (StringsKt.isBlank(r4) == true) goto L15;
        r1 = false;
    L19:
        e = move-exception;
        ALogger.e("AAM.Source.TC21GeckoClientImpl", "create gecko client failed with exception:" + Log.getStackTraceString(e));
        r5 = null;
    L22:
        GeckoClient r6 = this.a;
        if (r6 != null) goto L27;
        return Observable.error(new RuntimeException("client is null"));
    L27:
        if (TextUtils.isEmpty(r7.b) == false) goto L31;
        return Observable.error(new RuntimeException("channel is empty"));
    L31:
        return Observable.create(new q(this, r6, r7)).flatMap(new r(r7));
    L5:
        return Observable.error(new RuntimeException("access key is empty"));
    }
}
