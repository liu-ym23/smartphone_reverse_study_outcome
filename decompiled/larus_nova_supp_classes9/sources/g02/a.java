package g02;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.core.resources.h;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.revenue.service.interact.d;
import com.bytedance.android.livesdk.revenue.service.room.b;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import vh6.c;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final com.bytedance.android.livesdk.revenue.room.a d() {
        return c.b(b.class).x2();
    }

    public static final boolean e() {
        k r0 = f.d(j.C0.a(), k.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isAnchor();
    }

    public static final int a(EffectMessage r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        Map r0 = (Map) com.bytedance.android.livesdk.gift.platform.business.effect.a.C.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[27]);
        e r1 = ((AssetsService) f.a(AssetsService.class)).G1(r6.b);
        if (r0.get(String.valueOf(r6.l)) != null) goto L12;
        if (r1 == null) goto L12;
        if (r1.getResourceType() != 8) goto L12;
        if (f(r6) == false) goto L12;
        return 3;
    L12:
        if (r0.get(String.valueOf(r6.l)) != null) goto L15;
        return 0;
    L15:
        if (f(r6) == false) goto L21;
        if (r1 == null) goto L21;
        if (r1.getResourceType() != 8) goto L21;
        return 1;
    L21:
        return 0;
    }

    public static final h b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "lokiJson");
        h r4 = (h) GsonProtectorUtils.fromJson(GsonHelper.get(), r3, h.class);
        if (r4 != null) goto L19;
        Class r5 = h.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r0 = vh7.b.a;
        Object r1 = r0.get(r5);
        if (r1 != null) goto L14;
        r1 = r5.getConstructor(new Class[0]);
        if (r1 == null) goto L13;
        Object r6 = r0.putIfAbsent(r5, r1);
        if (r6 == null) goto L14;
        r1 = r6;
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L14:
        Object r7 = ((SerializableObjectJsonAdapterBase) ((Constructor) r1).newInstance(new Object[0])).createInstance();
        if (r7 == null) goto L18;
        return (h) r7;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.resources.LokiExtraKt");
    L19:
        return r4;
    }

    public static final String c(EffectMessage r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        e r4 = jc1.k.n(IGiftService.class).getAssets("effects", r3.b);
        if (r4 == null) goto L8;
        com.bytedance.android.live.core.resources.f r5 = r4.castToOrNull(com.bytedance.android.live.core.resources.f.class);
        if (r5 == null) goto L8;
        String r6 = r5.getLokiExtra();
        if (r6 == null) goto L8;
        return r6;
    L8:
        return BuildConfig.FLAVOR;
    }

    public static final boolean f(EffectMessage r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        j.a r1 = j.C0;
        k r2 = f.d(r1.a(), k.class);
        if (r2 == null) goto L7;
        IRoom r3 = r2.getRoom();
        if (r3 == null) goto L7;
        r3.getStreamType();
    L7:
        Intrinsics.checkNotNullParameter(r4, "msg");
        h r5 = b(c(r4));
        Intrinsics.checkNotNullParameter(r5, "loki");
        if (Intrinsics.areEqual(r5.getGiftType(), "sticker") == true) goto L12;
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (b(c(r4)).Y7() == true) goto L12;
        return false;
    L12:
        k r6 = f.d(r1.a(), k.class);
        if (r6 != null) goto L15;
    L17:
        gq2.b r7 = c.b(d.class).Qc();
        int r8 = x12.b.a();
        r7.l();
        if (r7.d(r8, 8) == true) goto L25;
        r7.h();
        if (r7.d(r8, 16) == true) goto L25;
        r7.i();
        if (r7.d(r8, 32) == true) goto L25;
        return false;
    L25:
        return true;
    L15:
        if (r6.isAudioRoom() != true) goto L17;
        return true;
    }
}
