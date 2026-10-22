package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.log.i;
import cy0.e;
import cy0.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements View.OnTouchListener {
    public final /* synthetic */ BaseVideoGiftWidget a;
    public final /* synthetic */ Boolean b;

    public a(BaseVideoGiftWidget r1, Boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        if (r5.getAction() != 0) goto L22;
        BaseVideoGiftWidget r6 = this.a;
        if (r6.w > 0) goto L13;
        FrameLayout r1 = r6.n;
        if (r1 == null) goto L10;
        int r2 = r1.getHeight();
    L11:
        r6.w = r2;
        goto L13
    L10:
        r2 = 0;
    L13:
        if (this.b.booleanValue() == false) goto L22;
        if (this.a.l == false) goto L22;
        float r7 = r5.getY();
        BaseVideoGiftWidget r8 = this.a;
        int r3 = r8.w;
        if (r7 <= (r3 / 2)) goto L22;
        if (r3 <= 0) goto L22;
        EffectMessage r9 = r8.o;
        if (r9 == null) goto L22;
        long r10 = r9.l;
        HashMap r11 = new HashMap();
        r11.put("gift_id", String.valueOf(r10));
        String r13 = h.a;
        Intrinsics.checkNotNullParameter(r11, "param");
        n r14 = new n();
        Map r15 = r14.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r11, "map");
        r15.putAll(r11);
        m r16 = new m();
        r16.b(LogCommon.LIVE_SHARE_LOG);
        r16.b(LogCommon.ROOM);
        i r17 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r17, "pageSourceLog");
        ((ArrayList) r16.a).add(r17.a);
        ((ArrayList) r14.b).addAll(r16.a);
        e.a.getClass();
        j r18 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r19 = com.bytedance.android.scope.m.b(r18).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r19);
        ((f80.a) r19).w3("livesdk_gift_effect_show_touch", r14.a, r14.b);
    L22:
        return false;
    }
}
