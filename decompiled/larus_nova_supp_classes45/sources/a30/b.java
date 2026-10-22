package a30;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetEffectGameStateResultModel;
import com.bytedance.android.livesdk.gift.platform.business.effect.service.EffectGameStatus;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import i12.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.t2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends t2<JsonObject, LiveGetEffectGameStateResultModel> {
    public b() {
    }

    public final void invoke(Object r4, CallContext r5) {
        Intrinsics.checkNotNullParameter((JsonObject) r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        i12.e r6 = o.b();
        String r7 = null;
        if (r6 == null) goto L5;
        Object r8 = com.bytedance.android.scope.m.e.d(r6, l02.e.class);
    L6:
        l02.e r9 = (l02.e) r8;
        LiveGetEffectGameStateResultModel r0 = new LiveGetEffectGameStateResultModel();
        r0.a(LiveGetEffectGameStateResultModel.Code.Success);
        LiveGetEffectGameStateResultModel.a r1 = new LiveGetEffectGameStateResultModel.a();
        if (r9 == null) goto L9;
        Integer r2 = r9.b;
    L10:
        r1.b(r2);
        if (r9 == null) goto L15;
        EffectGameStatus r3 = r9.a;
        if (r3 == null) goto L15;
        Integer r11 = Integer.valueOf(r3.getValue());
    L16:
        r1.c(r11);
        if (r9 == null) goto L19;
        r7 = r9.c;
    L19:
        r1.a(r7);
        Unit r12 = Unit.INSTANCE;
        r0.b(r1);
        finishWithResult(r0);
        return;
    L15:
        r11 = null;
        goto L16
    L9:
        r2 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }
}
