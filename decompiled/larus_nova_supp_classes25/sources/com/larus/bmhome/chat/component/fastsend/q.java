package com.larus.bmhome.chat.component.fastsend;

import android.view.View;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.platform.api.a0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q implements Function1 {
    public final /* synthetic */ FastSendImageComponent a;

    public /* synthetic */ q(FastSendImageComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r7) {
        FastSendImageComponent r0 = this.a;
        View r8 = (View) r7;
        KProperty[] r1 = FastSendImageComponent.M;
        boolean r2 = false;
        r0.X2(false);
        FLogger.a.i("FastSendImageComponent", "[showAlbumFragment]: onBottomSheetCreatedCallBack, peekHeightFallbackFix=" + ((Boolean) r0.D.getValue()).booleanValue() + " pendingPeekHeight=" + r0.J);
        Integer r3 = r0.J;
        if (r3 == null) goto L8;
        int r4 = r3.intValue();
        a0 r5 = r0.i;
        if (r5 == null) goto L7;
        r5.k6(r4, r0.K);
    L7:
        r0.J = null;
        r0.K = false;
    L8:
        a0 r6 = r0.i;
        if (r6 != null) goto L11;
    L13:
        if (r2 == false) goto L17;
        f1 r9 = r0.N2();
        if (r9 != null) goto L22;
        return null;
    L22:
        return r9.J60(r8);
    L17:
        f1 r10 = r0.N2();
        if (r10 != null) goto L20;
        return null;
    L20:
        return r10.Yp(r8);
    L11:
        if (r6.gC() != true) goto L13;
        r2 = true;
        goto L13
    }
}
