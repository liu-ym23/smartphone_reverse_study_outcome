package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j {

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.b(null, 1, true);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L9;
            return;
        L9:
            throw th;
        }
    }

    static {
    }

    public static void a(boolean r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L9
        r1.put("key_mg_in_cast", r5);     // Catch: Throwable -> L9
        String r2 = r1.toString();     // Catch: Throwable -> L9
        a r3 = a.a;
        if (r5 == false) goto L6;
        i0.c().removeCallbacks(r3);     // Catch: Throwable -> L9
        b(r2, -1, true);     // Catch: Throwable -> L9
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r6);     // Catch: Throwable -> L9
        return;
    L6:
        b(null, 1, false);     // Catch: Throwable -> L9
        b(r2, -1, true);     // Catch: Throwable -> L9
        r6 = Boolean.valueOf(i0.c().postDelayed(r3, 5000));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static void b(String r7, int r8, boolean r9) {
        com.bytedance.android.live.pushstream.d r1 = jc1.k.n(IPushStreamService.class).getPushLiveStream();
        if (r1 == null) goto L6;
        r1.c1("key_game_in_cast", r7, r8, r9, true);
        return;
    }
}
