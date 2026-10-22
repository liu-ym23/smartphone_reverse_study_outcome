package com.bytedance.android.live.broadcastgame.opengame.debug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.g0;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.mt.protector.impl.UriProtector;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/debug/GameReceiver;", "Landroid/content/BroadcastReceiver;", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameReceiver extends BroadcastReceiver {
    public final HashSet<String> a;
    public com.bytedance.android.live.broadcastgame.api.openplatform.b b;

    public static final class a {
    }

    static {
    }

    public GameReceiver() {
        this(null);
    }

    public GameReceiver(com.bytedance.android.live.broadcastgame.api.openplatform.b r1) {
        this.b = r1;
        this.a = new HashSet();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r24, Intent r25) {
        Intrinsics.checkNotNullParameter(r25, "intent");
        String r2 = r25.getStringExtra("schema");
        String r1 = r25.getStringExtra("cloudgame_order_id");
        if (r2 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L20;
        String r11 = URLDecoder.decode(r2, "UTF-8");
        if (r11 == null) goto L20;
        int r3 = q.a;
        q.h("adb pull game ==>  schema: ".concat(r11));
        String r4 = UriProtector.getQueryParameter(UriProtector.parse(r11), OpenPlatformBaseDebugger.APP_ID);
        String r21 = "{\"game_id\":123,\"game_type\":1,\"group_type\":1,\"need_game_desc\":false,\"rank\":10,\"show_anchor_float_entrance\":true,\"show_audience_float_entrance\":true,\"app_id\":\"" + r4 + "\",\"app_version\":\"0.1\"}";
        InteractID r22 = InteractID.SonicMiniGame;
        u r6 = new u(r22.getValue(), "调试", CollectionsKt.emptyList(), 1, 1, CollectionsKt.emptyList(), r21);
        r6.b.a = true;
        r r7 = r6.c();
        if (r7 == null) goto L20;
        Map<String, ? extends Object> r12 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_debug", Boolean.TRUE), TuplesKt.to("game", r6), TuplesKt.to("app_version", "0.1"), TuplesKt.to(OpenPlatformBaseDebugger.APP_ID, r4), TuplesKt.to("game_id", 123)});
        com.bytedance.android.live.broadcastgame.api.openplatform.b r8 = this.b;
        if (r8 == null) goto L19;
        r8.i(r7.p(), r7.b(), r11, r12, true, true);
    L19:
        ImageModel r15 = new ImageModel();
        r15.setUrls(CollectionsKt.emptyList());
        Unit r9 = Unit.INSTANCE;
        InteractEntranceCell r13 = new InteractEntranceCell(r22.getValue(), "调试", "当前直播间本地调试", r15, 1, r21, 130976);
        r13.f.a = true;
        xs2.b.a().post(new g0(true, r13));
    L20:
        if (r1 != null) goto L23;
        return;
    L23:
        if (this.a.contains(r1) == true) goto L28;
        this.a.add(r1);
        xs2.b.a().post(new b(r1));
        return;
    L28:
        return;
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r5 = false;
        goto L9
    }
}
