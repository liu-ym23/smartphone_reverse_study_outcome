package com.bytedance.android.livesdk.interactivity.square;

import am2.x;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.settings.config.q0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;
import r52.u3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final int a = 0;
    public static final int b = 0;
    public static Disposable c;
    public static Disposable d;
    public static int e;
    public static int f;
    public static final List<Long> g = null;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r17) {
            Integer r0 = (Integer) r17;
            HashMap r2 = new HashMap();
            if (e.a() == false) goto L5;
            String r1 = "live_take_detail";
        L6:
            r2.put("event_page", r1);
            r2.put("module_name", "public_screen_square");
            r2.put("element_name", "message_cell");
            if (e.a() == false) goto L9;
            String r3 = "anchor";
        L22:
            r2.put("user_type", r3);
            if (e.a() == false) goto L25;
            String r4 = "1";
        L26:
            r2.put("is_anchor", r4);
            r2.put("comment_action_number", String.valueOf(e.f));
            r2.put("comment_action_pv", String.valueOf(e.f));
            r2.put("comment_id_list", CollectionsKt.joinToString$default(e.g, ",", null, null, 0, null, null, 62, null));
            JSONObject r5 = new JSONObject();     // Catch: Exception -> L29
            r5.put("common_msg_pv", String.valueOf(e.e));     // Catch: Exception -> L29
            Unit r6 = Unit.INSTANCE;     // Catch: Exception -> L29
            r2.put("square_msg_type_count", r5.toString());     // Catch: Exception -> L29
        L31:
            j0.l().sendLog("livesdk_live_square_tab_message_show", r2, new Object[]{IRoom.class, x.class});
            e.f = 0;
            e.e = 0;
            ((ArrayList) e.g).clear();
            return;
        L29:
            e = move-exception;
            SafetyGuard.a("square_msg_type_count", e, null);
            goto L31
        L25:
            r4 = "0";
            goto L26
        L9:
            MiddlewareRoomContext r7 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
            if (r7 == null) goto L18;
            m r8 = r7.getUser();
            if (r8 == null) goto L18;
            User r9 = (User) r8.getValue();
            if (r9 == null) goto L18;
            if (o.b(r9) != true) goto L18;
            boolean r10 = true;
        L19:
            if (r10 == false) goto L21;
            r3 = "admin";
            goto L22
        L21:
            r3 = "user";
        L18:
            r10 = false;
            goto L19
        L5:
            r1 = "live_detail";
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            SafetyGuard.a("reportShowStatistics error", (Throwable) r3, null);
        }
    }

    public static void b() {
        c = Observable.just(1).observeOn(Schedulers.computation()).subscribe(a.a, b.a);
    }

    static {
        q0 r0 = (q0) u3.a.getValue();
        a = r0.c();
        b = r0.g();
        g = new ArrayList();
    }

    public static boolean a() {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }
}
