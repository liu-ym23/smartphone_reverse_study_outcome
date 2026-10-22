package com.bytedance.android.live.effect.sticker.chain;

import android.content.Context;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.livesdk.config.et0;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements m {
    public h() {
    }

    @Override // com.bytedance.android.live.effect.sticker.chain.m
    public final void a(l r8) {
        Intrinsics.checkNotNullParameter(r8, "chain");
        if (((Boolean) et0.a.getValue()).booleanValue() == false) goto L5;
    L18:
        r8.a();
        return;
    L5:
        if (((k81) ft0.a.getValue()).b() == false) goto L18;
        if (r8.e != LiveEffectScene.Live) goto L18;
        List<String> r0 = LiveEffectContext.h;
        if ((!LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(d0.d).isEmpty()) == false) goto L17;
        Context r1 = r8.getContext();
        u.l().sendLog("livesdk_anchor_interactive_extension_conflict_popup", MapsKt.mapOf(TuplesKt.to("action_type", "show")), new Object[]{IRoom.class});
        z0.a().getClass();
        x0.d r2 = new x0.d();
        r2.b = r1;
        r2.a = 4;
        r2.l = false;
        r2.c = "请先退出当前互动特效";
        r2.d = "最多可同时使用一种特效/互动特效";
        g r3 = g.a;
        x0.c[] r4 = r2.g;
        x0.c r5 = r4[0];
        if (r5 != null) goto L13;
        r5 = new x0.c();
        r4[0] = r5;
    L13:
        r5.a = "我知道了";
        r5.b = r3;
        x0.c[] r6 = r2.g;
        x0.c r7 = r6[0];
        if (r7 != null) goto L16;
        r7 = new x0.c();
        r6[0] = r7;
    L16:
        r7.c = true;
        x0.b.g(new x0(r2.b, r2));
        Intrinsics.checkNotNullParameter("互动工具互斥", "reason");
        r8.b = false;
        return;
    L17:
        r8.a();
    }
}
