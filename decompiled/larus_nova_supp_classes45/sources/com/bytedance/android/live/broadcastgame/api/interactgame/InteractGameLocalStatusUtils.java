package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class InteractGameLocalStatusUtils {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            ALogger.i("InteractGameLocalStatusUtils", "[success]send game stop to server ");
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            ALogger.i("InteractGameLocalStatusUtils", "[failed]send game stop to server ");
        }
    }

    public static void a() {
        c("play_id", String.valueOf(0));
        c("game_token", String.valueOf(0));
        c("game_id", String.valueOf(0));
        String r0 = String.valueOf(0);
        Intrinsics.checkNotNullParameter(r0, "startId");
        c("start_id", r0);
        String r1 = String.valueOf(0);
        Intrinsics.checkNotNullParameter(r1, "appId");
        c(OpenPlatformBaseDebugger.APP_ID, r1);
        String r2 = String.valueOf(0);
        Intrinsics.checkNotNullParameter(r2, "gameId");
        c("xplay_game_id", r2.toString());
        String r3 = String.valueOf(0);
        Intrinsics.checkNotNullParameter(r3, "liveScene");
        c("live_scene", r3);
        String r4 = String.valueOf(0);
        Intrinsics.checkNotNullParameter(r4, "xplayRoomId");
        c("xplay_room_id", r4.toString());
        c("in_game_cast", String.valueOf(false));
    }

    static {
    }

    public static void b(long r19) {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.w2;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0.getValue();
        if (r1 == null) goto L45;
        String r2 = (String) r1.get("game_id");
        if (r2 == null) goto L9;
        Long r3 = StringsKt.toLongOrNull(r2);
        if (r3 == null) goto L9;
        long r8 = r3.longValue();
    L10:
        String r4 = (String) r1.get("room_id");
        if (r4 == null) goto L15;
        Long r5 = StringsKt.toLongOrNull(r4);
        if (r5 == null) goto L15;
        long r6 = r5.longValue();
    L16:
        String r7 = (String) r1.get("play_id");
        if (r7 == null) goto L21;
        Long r9 = StringsKt.toLongOrNull(r7);
        if (r9 == null) goto L21;
        long r12 = r9.longValue();
    L22:
        String r11 = (String) r1.get("game_token");
        if (r11 == null) goto L27;
        Long r13 = StringsKt.toLongOrNull(r11);
        if (r13 == null) goto L27;
        long r17 = r13.longValue();
    L28:
        ALogger.i("InteractGameLocalStatusUtils", ((ConcurrentHashMap) r0.getValue()).toString());
        if (r8 != 0) goto L31;
        return;
    L31:
        if (r6 != 0) goto L33;
        return;
    L33:
        if (r12 != 0) goto L36;
        return;
    L36:
        if (r6 != r19) goto L48;
        RxCompatKt.b(((IInteractGameService) jc1.k.n(IInteractGameService.class)).notifyServerGameStop(r8, r19, r12, "", true, 2, r17).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()), RxUtil.rxRetryHelper(3)).subscribe(a.a, b.a);
        ALogger.i("InteractGameLocalStatusUtils", "send game stop to server");
        c("play_id", String.valueOf(0));
        c("game_token", String.valueOf(0));
        ConcurrentHashMap r14 = (ConcurrentHashMap) r0.getValue();
        if (r14 == null) goto L40;
        String r15 = (String) r14.get("in_game_cast");
    L42:
        if (Intrinsics.areEqual(r15, "true") == false) goto L49;
        UtilityKotlinExtentionsKt.r(n5.DEFAULT_SHOW_DURATION, false, true, InteractGameLocalStatusUtils$notifyServerGameStop$1$1.INSTANCE);
        c("in_game_cast", String.valueOf(false));
        return;
    L49:
        return;
    L40:
        r15 = null;
        goto L42
    L48:
        return;
    L27:
        r17 = 0;
    L21:
        r12 = 0;
    L15:
        r6 = 0;
    L9:
        r8 = 0;
        goto L10
    }

    public static void c(String r3, String r4) {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.w2;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0.getValue();
        if (r1 == null) goto L5;
        r1.put(r3, r4);
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
    L5:
        ALogger.i("InteractGameLocalStatusUtils", "保存缓存 key is " + r3 + ", value is " + r4 + ", properties is " + ((ConcurrentHashMap) r0.getValue()));
    }
}
