package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.revenue.platform.interacteffect.api.MessageType;
import com.bytedance.android.live.revenue.platform.interacteffect.api.Scene;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z2 implements com.bytedance.android.scope.o {
    public int a;
    public Disposable b;
    public final List<f12.a> c;
    public Disposable d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;
    public final com.bytedance.android.livesdk.gift.platform.business.effect.assets.h f;
    public final ez0.b g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ z2 a;

        public b(z2 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            z2 r0 = this.a;
            ((ez0.a) r2).getClass();
            r0.getClass();
            int r3 = a3.a;
            throw null;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ z2 a;

        public c(z2 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (((Boolean) r1).booleanValue() == false) goto L6;
            this.a.c();
            return;
        }
    }

    static {
    }

    public final void c() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("type", "gift_ready");
        String r1 = GsonProtectorUtils.toJson(l97.a.a, r0);
        this.g.Vf(MessageType.MSG_TYPE_LIVE_INTERACTION, Scene.GIFT, 10000000, r1);
    }

    public final void onStart() {
        List<f12.a> r0 = this.c;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new f12.b());
        this.d = this.g.observeEffectMessage().subscribe(new b(this));
        if (((Boolean) this.e.getRoomContext().isAnchorEffectInit().getValue()).booleanValue() == false) goto L5;
        c();
        return;
    L5:
        this.b = this.e.getRoomContext().isAnchorEffectInit().a().subscribe(new c(this));
    }

    public final void onStop() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.d;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public final void a(Map<String, Object> r4, List<String> r5) {
        r4.put("type", "gift_message_notify");
        r4.put("key_list", r5);
        String r6 = GsonProtectorUtils.toJson(l97.a.a, r4);
        if (this.a <= 9999999) goto L5;
        this.a = 1000000;
    L5:
        this.g.Vf(MessageType.MSG_TYPE_LIVE_INTERACTION, Scene.GIFT, this.a, r6);
        this.a++;
    }

    public z2(com.bytedance.android.livesdk.revenue.service.room.c r2, com.bytedance.android.livesdk.gift.platform.business.effect.assets.h r3, ez0.b r4) {
        Intrinsics.checkNotNullParameter(r2, "roomService");
        Intrinsics.checkNotNullParameter(r3, "giftManager");
        Intrinsics.checkNotNullParameter(r4, "revInteractEffectService");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.a = 1000000;
        this.c = new ArrayList();
    }
}
