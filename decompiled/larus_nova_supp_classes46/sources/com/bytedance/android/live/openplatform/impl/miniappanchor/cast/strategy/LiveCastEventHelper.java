package com.bytedance.android.live.openplatform.impl.miniappanchor.cast.strategy;

import am2.x;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.n;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.i;
import dp0.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LiveCastEventHelper {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/cast/strategy/LiveCastEventHelper$CastScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SINGLE", "MULTI", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CastScene extends Enum<CastScene> {
        public static final CastScene MULTI = null;
        public static final CastScene SINGLE = null;
        public static final /* synthetic */ CastScene[] a = null;
        private final String value;

        static {
            CastScene r1 = new CastScene("SINGLE", 0, "single");
            SINGLE = r1;
            CastScene r2 = new CastScene("MULTI", 1, "multi");
            MULTI = r2;
            a = new CastScene[]{r1, r2};
        }

        public static CastScene valueOf(String r1) {
            return (CastScene) a.a(CastScene.class, r1);
        }

        public static CastScene[] values() {
            return (CastScene[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public CastScene(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
    }

    public static Map a(OpenPlatformContext r6, CastScene r7) {
        Room r8 = r6.getRoom();
        Pair[] r1 = new Pair[3];
        LiveMode r5 = null;
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r2 == null) goto L8;
        i r3 = r2.getLiveMode();
        if (r3 == null) goto L8;
        r5 = (LiveMode) r3.getValue();
    L8:
        if (r5 == null) goto L18;
        int r4 = c.a[r5.ordinal()];
        if (r4 == 1) goto L23;
        if (r4 == 2) goto L22;
        if (r4 != 3) goto L15;
        String r0 = "third_party";
    L24:
        r1[0] = TuplesKt.to("live_type", r0);
        r1[1] = TuplesKt.to("cast_scene", r7.getValue());
        r1[2] = TuplesKt.to("cast_biz_value", "applet");
        Map r9 = MapsKt.mutableMapOf(r1);
        n.d(r8, r9);
        return r9;
    L15:
        if (r4 != 4) goto L17;
        r0 = "voice_live";
        goto L24
    L17:
        if (r4 != 5) goto L18;
        r0 = "media";
        goto L24
    L22:
        r0 = "game";
        goto L24
    L23:
        r0 = "video_live";
    L18:
        r0 = "";
        goto L24
    }

    @JvmStatic
    public static final void b(OpenPlatformContext r2, CastScene r3) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "castScene");
        Intrinsics.checkNotNullParameter("more_panel", "closeFrom");
        Map r4 = a(r2, r3);
        r4.put("close_from", "more_panel");
        Unit r5 = Unit.INSTANCE;
        c("livesdk_anchor_screenprojection_screenpack_end_button_click", r4);
    }

    public static void c(String r4, Map r5) {
        u.l().sendLog(r4, r5, new Object[]{x.class});
    }
}
