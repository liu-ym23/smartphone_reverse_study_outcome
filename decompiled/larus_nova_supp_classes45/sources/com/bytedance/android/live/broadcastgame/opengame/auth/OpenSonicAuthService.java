package com.bytedance.android.live.broadcastgame.opengame.auth;

import b94.b;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.opengame.openapi.v;
import com.bytedance.android.live.broadcastgame.opengame.openapi.x;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.g;
import com.bytedance.android.live.broadcastgame.opengame.runtime.j;
import com.bytedance.android.live.broadcastgame.opengame.t;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.live.livecontainer.sonicgame.c;
import com.bytedance.bdp.live.livecontainer.sonicgame.e;
import com.bytedance.bdp.live.livecontainer.sonicgame.f;
import com.bytedance.bdp.serviceapi.hostimpl.hostmethod.BdpInteractHostMethodService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/auth/OpenSonicAuthService;", "Lcom/bytedance/android/live/broadcastgame/opengame/auth/OpenBaseAuthService;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenSonicAuthService extends OpenBaseAuthService {
    public final PluginContext a;

    public static final class a implements c {
        public final /* synthetic */ OpenSonicAuthService a;
        public final /* synthetic */ c b;

        public final void a(JSONObject r11) {
            Intrinsics.checkNotNullParameter("onSettingClick", "status");
            Intrinsics.checkNotNullParameter(r11, "data");
            int r0 = GameDataReportHelper.a;
            PluginContext r1 = this.a.a;
            t r2 = r1.m;
            long r3 = r2.h;
            String r4 = r2.b(r1.o);
            String r5 = ((BootInfoService) this.a.a.o(BootInfoService.class)).e();
            String r6 = r11.optString("status");
            String r7 = r11.optString("authScope");
            Intrinsics.checkNotNullParameter(r4, "gameName");
            Intrinsics.checkNotNullParameter(r5, "gameCategory");
            Intrinsics.checkNotNullParameter(r6, "status");
            Intrinsics.checkNotNullParameter(r7, "authScope");
            u.l().sendLog("livesdk_little_game_authority_setting", MapsKt.mapOf(new Pair[]{TuplesKt.to("game_id", String.valueOf(r3)), TuplesKt.to("game_name", r4), TuplesKt.to("game_category", r5), TuplesKt.to("user_id", k.n(IUserService.class).user().n()), TuplesKt.to("certification_mode", GameDataReportHelper.a(r7)), TuplesKt.to("button_clicked", GameDataReportHelper.a(r7)), TuplesKt.to("status", r6)}), new Object[]{Room.class});
            this.b.a(r11);
        }

        public final void onFail(String r2) {
            Intrinsics.checkNotNullParameter(r2, "errMsg");
            this.b.onFail(r2);
        }

        public final void onSuccess(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "result");
            this.b.onSuccess(r2);
        }

        public a(OpenSonicAuthService r1, c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public OpenSonicAuthService(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        super(r2);
        this.a = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.auth.OpenBaseAuthService
    public final void a(String r2, v.a r3) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        f.a(r2, r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.auth.OpenBaseAuthService
    public final void b(String r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        f.b(r2, new a(this, r3));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.auth.OpenBaseAuthService
    public final void c(String r12, List r13, JSONObject r14, x r15) {
        Intrinsics.checkNotNullParameter(r12, "appId");
        Intrinsics.checkNotNullParameter(r13, "requestList");
        Intrinsics.checkNotNullParameter(r14, "extra");
        Intrinsics.checkNotNullParameter(r15, "callback");
        JSONObject r16 = new JSONObject();
        List r0 = CollectionsKt.toMutableList(r13);
        Iterator r1 = r13.iterator();
    L4:
        if (r1.hasNext() == false) goto L28;
        String r2 = (String) r1.next();
        BootInfoService r4 = (BootInfoService) this.a.o(BootInfoService.class);
        Intrinsics.checkNotNullParameter(r2, "authScope");
        Intrinsics.checkNotNullParameter("getUserInfoV2", "method");
        g r5 = r4.c();
        if (r5 == null) goto L21;
        j r6 = r5.b;
        if (r6 == null) goto L21;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> r7 = r6.a;
        if (r7 == null) goto L21;
        Iterator<T> r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L21;
        com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a r9 = (com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a) r8.next();
        if (Intrinsics.areEqual("getUserInfoV2", r9.c()) == false) goto L13;
        if (r9.a() == null) goto L13;
        Long r11 = r9.a().get(r2);
        if (r11 == null) goto L21;
        long r17 = r11.longValue();
    L23:
        if (r17 == 2) goto L24;
        if (r17 != 0) goto L4;
        r0.remove(r2);
        goto L4
    L24:
        r16.put(r2, true);
    L21:
        r17 = 0;
        goto L23
    L28:
        r14.put("strictPermission", r16);
        if (r0.isEmpty() == false) goto L36;
        Iterator r18 = r13.iterator();
    L32:
        if (r18.hasNext() == false) goto L34;
        String r19 = (String) r18.next();
        int r110 = GameDataReportHelper.a;
        PluginContext r111 = this.a;
        t r112 = r111.m;
        GameDataReportHelper.d(r112.h, r112.b(r111.o), ((BootInfoService) this.a.o(BootInfoService.class)).e(), false, "not_authorized", r19);
        goto L32
    L34:
        r15.b(new ArrayList());
        return;
    L36:
        BdpInteractHostMethodService r113 = f.a;
        l10.a r114 = new l10.a(this, r15, r16);
        ArrayList r115 = new ArrayList();
        Iterator r116 = r0.iterator();
    L38:
        if (r116.hasNext() == false) goto L47;
        String r3 = (String) r116.next();
        Iterator r21 = CollectionsKt.listOf(new b[]{b94.c.a, b94.c.c, b94.c.k, b94.c.m, b94.c.n, b94.c.b, b94.c.d, b94.c.j, b94.c.o, b94.c.q, b94.c.e, b94.c.f, b94.c.g, b94.c.h, b94.c.i, b94.c.l, b94.c.p, b94.c.r}).iterator();
    L41:
        if (r21.hasNext() == false) goto L38;
        b r22 = (b) r21.next();
        if (Intrinsics.areEqual(r3, r22.a) == false) goto L41;
        if (Intrinsics.areEqual(r22, b94.c.b) == false) goto L41;
        r115.add(r22);
        goto L41
    L47:
        if (r14 != null) goto L49;
        new JSONObject();
    L49:
        BdpInteractHostMethodService r117 = f.a;
        if (r117 == null) goto L76;
        new e(r114);
        r117.S1();
        return;
    }
}
