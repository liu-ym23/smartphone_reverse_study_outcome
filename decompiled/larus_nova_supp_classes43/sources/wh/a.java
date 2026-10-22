package wh;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.d;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.i;
import com.bytedance.forest.utils.h;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static Forest a;

    static {
    }

    @JvmStatic
    public static final long a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "channel");
        Context r0 = ECAppInfoService.e.getApplicationContext();
        if (r0 == null) goto L19;
        File r1 = r0.getFilesDir();
        if (r1 == null) goto L19;
        String r11 = r1.getAbsolutePath();
        if (r11 == null) goto L19;
        PolarisFileWrapper r12 = new PolarisFileWrapper(r11, "offlineX");
        d r13 = d.b;
        if (r13.getIECHostAppInfo().isDebug() == false) goto L12;
    L15:
        String r14 = "36723dc3e85a23e701d1697d57de07ed";
    L16:
        Long r15 = ResLoadUtils.getLatestChannelVersion(r12, r14, r10);
        if (r15 == null) goto L19;
        return r15.longValue();
    L12:
        if (r13.getIECHostAppInfo().isLocalTest() == true) goto L15;
        r14 = "5fb33cde3ebff01c8433ddc22aac0816";
    L19:
        return -1;
    }

    public static Forest b(Context r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        Forest r0 = a;
        if (r0 != null) goto L69;
        Context r16 = r15.getApplicationContext();
        if (r16 == null) goto L68;
        Application r17 = (Application) r16;
        d r1 = d.b;
        if (r1.getIECHostAppInfo().isDebug() == false) goto L9;
    L12:
        String r10 = "36723dc3e85a23e701d1697d57de07ed";
    L13:
        boolean r11 = false;
        vi.a r12 = null;
        String r13 = r1.getIECHostAppInfo().getAppId();     // Catch: Throwable -> L26
        if (r13 != null) goto L17;
    L28:
        long r14 = 0;
    L29:
        long r18 = r14;
        Lazy r19 = HybridAppInfoService.a;
        if (HybridAppInfoService.n() == false) goto L44;
        int r20 = ECSdk.a;
        IECHostService r21 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r21 == null) goto L34;
        r12 = r21.getIECHostAppInfo();
    L34:
        if (r12 != null) goto L36;
    L37:
        if (r12 != null) goto L39;
    L41:
        if (r11 == false) goto L43;
        String r22 = "webofflinex_debug/live";
    L45:
        String r23 = r22;
        d r24 = d.b;
        String r25 = r24.getIECHostAppInfo().getAppVersionName();
        if (r25 != null) goto L48;
        String r110 = "";
    L49:
        String r26 = r24.getIECHostAppInfo().getServerDeviceId();
        if (r26 != null) goto L52;
        String r111 = "";
    L53:
        r0 = new Forest(r17, new i("gecko.zijieapi.com", new GeckoConfig("-1", r23, r18, r110, r111, "cn"), 4));
        GeckoConfig r112 = r0.getConfig().a(r10);
        if (r112 == null) goto L63;
        int r27 = h.a;
        if (h.a(r112.c) == false) goto L63;
        GeckoConfig r28 = r0.getConfig().h;
        if (r28 == null) goto L60;
        r28.c = r112.c;
    L60:
        GeckoConfig r29 = r0.getConfig().h;
        if (r29 == null) goto L63;
        r29.h = r112.h;
    L63:
        GeckoConfig r113 = r0.getConfig().h;
        if (r113 == null) goto L66;
        r113.b = r10;
    L66:
        a = r0;
        goto L69
    L52:
        r111 = r26;
        goto L53
    L48:
        r110 = r25;
        goto L49
    L43:
        r22 = "webofflinex/live";
        goto L45
    L39:
        if (r12.isLocalTest() != true) goto L41;
    L40:
        r11 = true;
        goto L41
    L36:
        if (r12.isDebug() == true) goto L40;
    L44:
        r22 = "offlineX";
        goto L45
    L17:
        if (r13.length() <= 0) goto L19;
        boolean r30 = true;
    L20:
        if (r30 == true) goto L23;
        r13 = null;
    L23:
        if (r13 == null) goto L28;
        r14 = CastLongProtector.parseLong(r13);     // Catch: Throwable -> L26
        goto L29
    L19:
        r30 = false;
    L26:
        th = move-exception;
        ECExceptionMonitor.e(th);
        goto L28
    L9:
        if (r1.getIECHostAppInfo().isLocalTest() == true) goto L12;
        r10 = "5fb33cde3ebff01c8433ddc22aac0816";
        goto L13
    L68:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    L69:
        return r0;
    }
}
