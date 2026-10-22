package com.bytedance.android.ec.core.gecko;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.ec.sdk.helper.d;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.i;
import com.bytedance.forest.model.o;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b&\u0010'J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\u0002J$\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00022\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00110\u000fR\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010%\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010!¨\u0006("}, d2 = {"Lcom/bytedance/android/ec/core/gecko/ECForestLoader;", "", "", "accessKey", "appVersion", "Lcom/bytedance/forest/Forest;", "createEcForestByKey", "", "isASync", "Lcom/bytedance/forest/model/RequestParams;", "getRequestParams", "prodKey", "testKey", "getAccessKey", com.bytedance.android.ec.core.event.a.KEY_URL, "Lkotlin/Function1;", "Lcom/bytedance/forest/model/Response;", "", "callback", "fetchAsync", "Lcom/bytedance/forest/model/o;", "fetchSync", "resourcePath", "", "bytesCB", "fetchResource", "TEST_LIVE_ACCESS_KEY", "Ljava/lang/String;", "PROD_ACCESS_KEY", "PROD_LIVE_ACCESS_KEY", "forest", "Lcom/bytedance/forest/Forest;", "getForest", "()Lcom/bytedance/forest/Forest;", "liveForest$delegate", "Lkotlin/Lazy;", "getLiveForest", "liveForest", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECForestLoader {
    public static final ECForestLoader INSTANCE = null;
    private static final String PROD_ACCESS_KEY = "11f41d655db1c7dd83e5c59c5122ca5e";
    private static final String PROD_LIVE_ACCESS_KEY = "5fb33cde3ebff01c8433ddc22aac0816";
    private static final String TEST_LIVE_ACCESS_KEY = "36723dc3e85a23e701d1697d57de07ed";
    private static final Forest forest = null;
    private static final Lazy liveForest$delegate = null;

    private ECForestLoader() {
    }

    public final Forest getLiveForest() {
        return (Forest) liveForest$delegate.getValue();
    }

    static {
        ECForestLoader r0 = new ECForestLoader();
        INSTANCE = r0;
        forest = r0.createEcForestByKey(getAccessKey$default(r0, PROD_ACCESS_KEY, null, 2, null), ECGeckoRegister.a());
        liveForest$delegate = LazyKt.lazy(ECForestLoader$liveForest$2.INSTANCE);
    }

    public final Forest getForest() {
        return forest;
    }

    private final RequestParams getRequestParams(boolean r10) {
        RequestParams r0 = new RequestParams(0);
        Boolean r11 = Boolean.TRUE;
        r0.v = r11;
        r0.b = getAccessKey$default(INSTANCE, PROD_ACCESS_KEY, null, 2, null);
        r0.g = r10;
        r0.i = false;
        r0.s = 5;
        r0.u = r11;
        return r0;
    }

    public final o fetchSync(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return forest.createSyncRequest(r10, getRequestParams$default(this, false, 1, null));
    }

    private final Forest createEcForestByKey(String r14, String r15) {
        d r1 = d.b;
        Context r10 = r1.getIECHostAppInfo().getApplicationContext();
        if (r10 == null) goto L14;
        Application r11 = (Application) r10;
        String r12 = r1.getIECHostAppInfo().getAppId();
        if (r12 == null) goto L7;
        long r13 = CastLongProtector.parseLong(r12);
    L8:
        long r16 = r13;
        String r17 = r1.getIECHostAppInfo().getServerDeviceId();
        if (r17 != null) goto L12;
        r17 = "";
    L12:
        return new Forest(r11, new i("gecko.zijieapi.com", new GeckoConfig(r14, "offlineX", r16, r15, r17, "cn"), 4));
    L7:
        r13 = 0;
        goto L8
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    private final String getAccessKey(String r10, String r11) {
        if (r11 == null) goto L8;
        d r0 = d.b;
        if (r0.getIECHostAppInfo().isDebug() == false) goto L6;
    L7:
        return r11;
    L6:
        if (r0.getIECHostAppInfo().isLocalTest() == true) goto L7;
    L8:
        return r10;
    }

    public final void fetchAsync(String r10, final Function1<? super Response, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "callback");
        forest.fetchResourceAsync(r10, getRequestParams(true), new AnonymousClass1(r11));
    }

    public final void fetchResource(String r10, final Function1<? super byte[], Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "resourcePath");
        Intrinsics.checkNotNullParameter(r11, "bytesCB");
        forest.fetchResourceAsync(r10, new RequestParams(0), new C02421(r11));
    }

    public static final /* synthetic */ Forest access$createEcForestByKey(ECForestLoader r0, String r1, String r10) {
        return r0.createEcForestByKey(r1, r10);
    }

    public static final /* synthetic */ String access$getAccessKey(ECForestLoader r0, String r1, String r10) {
        return r0.getAccessKey(r1, r10);
    }

    public static /* synthetic */ RequestParams getRequestParams$default(ECForestLoader r0, boolean r1, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.getRequestParams(r1);
    }

    public static /* synthetic */ String getAccessKey$default(ECForestLoader r0, String r1, String r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L6;
        r10 = null;
    L6:
        return r0.getAccessKey(r1, r10);
    }
}
