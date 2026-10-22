package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.config.v20;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements ObservableOnSubscribe {
    public final /* synthetic */ b a;
    public final /* synthetic */ Map b;

    public a(b r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Boolean> r9) {
        Intrinsics.checkNotNullParameter(r9, "emitter");
        GameHonorEffectWidget.a r0 = this.a.a;
        if (r0.a == null) goto L10;
        ALogger.i("GameHonorEffectWidget", "update data " + this.b);
        zy0.b r1 = this.a.a.a;
        if (r1 == null) goto L9;
        xy0.a r2 = r1.g();
        if (r2 == null) goto L9;
        r2.updateData(this.b);
    L9:
        r9.onNext(Boolean.TRUE);
        return;
    L10:
        String r3 = (String) v20.a.getValue();
        ALogger.i("GameHonorEffectWidget", "create LynxView, schema " + r3);
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r5 = null;
        if (r4 == true) goto L23;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r6 = f.a(vy0.c.class).q8(((Widget) r0.c).context, UriProtector.parse(r3), new GameHonorEffectWidget$AnnieCardHolder$createLynxView$1(r9));
        if (r6 == null) goto L23;
        r0.a = r6;
        a1.p(r6.c, -1);
        a1.k(r6.c, -1);
        RxUtilKt.c(r6, r0.c.a);
    L24:
        if (r6 == null) goto L29;
        UtilityKotlinExtentionsKt.z(this.a.a.b, true);
        this.a.a.b.addView(r6.c);
        ALogger.i("GameHonorEffectWidget", "load data " + this.b);
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r7 = r6.d;
        if (r7 == null) goto L28;
        r7.b(this.b);
    L28:
        Unit r8 = Unit.INSTANCE;
        r5 = r6;
    L29:
        r0.a = r5;
        if (this.a.a.a != null) goto L34;
        r9.onNext(Boolean.FALSE);
        return;
    L34:
        return;
    L23:
        r6 = null;
        goto L24
    L13:
        if (r3.length() == 0) goto L16;
        r4 = false;
        goto L17
    }
}
