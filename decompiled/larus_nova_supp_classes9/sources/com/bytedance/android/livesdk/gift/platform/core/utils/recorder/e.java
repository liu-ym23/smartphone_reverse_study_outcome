package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class e {
    public static final a d = null;
    public final b a;
    public final g b;
    public final g c;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e$a$a, reason: collision with other inner class name */
        public static final class C0075a extends e {
            public static final C0075a e = null;

            static {
                e = new C0075a();
            }

            public C0075a() {
            }
        }

        public a() {
        }

        @JvmStatic
        public static void a(Object r7, String r8, Object r9, d r10) {
            Intrinsics.checkNotNullParameter(r7, "msgId");
            Intrinsics.checkNotNullParameter(r8, "content");
            if (v.a() == false) goto L5;
            com.bytedance.android.livesdk.gift.platform.core.utils.c.a("GRecorder", "report " + r7 + ':' + r8);
        L5:
            String r11 = r7.toString();
            JSONObject r2 = new JSONObject();     // Catch: Exception -> L32
            r2.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L32
            com.bytedance.android.livesdk.gift.platform.business.effect.player.i.a().getClass();     // Catch: Exception -> L32
            int r5 = 1;
            if (com.bytedance.android.livesdk.gift.platform.business.effect.player.i.b.get(com.bytedance.android.livesdk.gift.platform.business.effect.player.i.c) == null) goto L9;
            boolean r4 = true;
        L10:
            if (r4 == true) goto L13;
            r5 = 0;
        L13:
            r2.put("player_state", r5);     // Catch: Exception -> L32
            r2.put("message_id", r11);     // Catch: Exception -> L32
            JSONObject r3 = new JSONObject();     // Catch: Exception -> L32
            r3.put("event", "consume_message_err");     // Catch: Exception -> L32
            r3.put("message_id", r11);     // Catch: Exception -> L32
            String r1 = BuildConfig.FLAVOR;
            if (r9 == null) goto L18;
            String r13 = r9.toString();     // Catch: Exception -> L32
            if (r13 == null) goto L18;
        L19:
            r3.put("gift_id", r13);     // Catch: Exception -> L32
            r3.put("err_info", r8);     // Catch: Exception -> L32
            if (r10 == null) goto L25;
            String r14 = r10.b;     // Catch: Exception -> L32
            if (r14 == null) goto L25;
            r1 = r14;
        L25:
            r3.put("err_title", r1);     // Catch: Exception -> L32
            if (r10 == null) goto L29;
            Object r15 = r10.a;     // Catch: Exception -> L32
            if (r15 == null) goto L29;
        L30:
            r3.put("err_code", r15);     // Catch: Exception -> L32
            JSONObject r16 = new JSONObject();     // Catch: Exception -> L32
            r16.put("err_info", r8);     // Catch: Exception -> L32
            d0.n(r3, r16, r2);     // Catch: Exception -> L32
            return;
        L29:
            r15 = "-1";
        L18:
            r13 = BuildConfig.FLAVOR;
            goto L19
        L9:
            r4 = false;
        L32:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
        d = new a();
    }

    public e() {
        this.b = new i();
        this.c = new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.a();
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.A.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[25])).booleanValue() == false) goto L5;
    L8:
        i r0 = new i();
        this.b = r0;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.a r4 = new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.a();
        this.c = r4;
        this.a = new b(new g[]{r0, r4});
        return;
    L5:
        if (v.a() == true) goto L8;
        c r1 = new c();
        this.b = r1;
        c r5 = new c();
        this.c = r5;
        this.a = new b(new g[]{r1, r5});
    }
}
