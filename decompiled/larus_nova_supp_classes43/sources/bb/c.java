package bb;

import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.google.gson.Gson;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public static void b(AnnieXLynxView r10, a r11) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        if (r11 == null) goto L30;
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        if (r11.e == true) goto L26;
        LynxBaseUI r12 = r10.findUIByIdSelector("annie-root");
        if (r12 == null) goto L20;
        JavaOnlyMap r13 = r12.getProps();
        if (r13 == null) goto L20;
        String r14 = r13.getString("meta-data");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        Gson r1 = hb.a.a;     // Catch: Throwable -> L14
        r11.d = (gb.c) hb.a.a(r14, gb.c.class);     // Catch: Throwable -> L14
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L17:
        if (Result.exceptionOrNull-impl(r15) == null) goto L19;
        HybridLogger r16 = HybridLogger.a;
        HybridLogger.i("AirSolution", "meta-data parse failed: metaDataStr: " + r14, null, 12);
    L19:
        Result.box-impl(r15);
    L14:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L20:
        gb.c r18 = r11.d;
        if (r18 == null) goto L26;
        b r19 = r11.b;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r18, "metaContent");
        r19.a = r18.c();
        r19.b = r18.a();
        Map<String, Object> r20 = r18.b();
        if (r20 == null) goto L25;
        r19.c.a.putAll(r20);
    L25:
        r11.e = true;
    L26:
        Unit r21 = Unit.INSTANCE;
        return;
    }

    public static a a(AnnieXLynxView r10, LynxBDXBridge r11, ra.a r12) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        Intrinsics.checkNotNullParameter(r11, "lynxBDXBridge");
        Intrinsics.checkNotNullParameter(r12, "lynxViewModel");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        String r13 = UriProtector.getQueryParameter(r12.b, "air_action_strategy");     // Catch: Throwable -> L12
        if (r13 == null) goto L6;
        int r14 = CastIntegerProtector.parseInt(r13);     // Catch: Throwable -> L12
    L8:
        if (r14 != 1) goto L19;
        return new a(r10, r11);
    L19:
        return null;
    L6:
        r14 = 0;
    L12:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        if (Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th))) == null) goto L16;
        HybridLogger r16 = HybridLogger.a;
        HybridLogger.i("AirSolution", "air_action_strategy is illegal. schema:" + r12.b, null, 12);
    L16:
        return null;
    }
}
