package t10;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.ies.web.jsbridge2.o;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public na4.b a;
    public final d0 b;

    /* JADX INFO: renamed from: t10.a$a, reason: collision with other inner class name */
    public static final class C0277a extends com.bytedance.ies.web.jsbridge2.b {
        public final Map<String, C0278a> n;
        public final Context o;
        public final b p;

        /* JADX INFO: renamed from: t10.a$a$a, reason: collision with other inner class name */
        public static final class C0278a {
            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof C0278a) == false) goto L10;
                ((C0278a) r2).getClass();
                if (Intrinsics.areEqual(null, null) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(null, null) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public final int hashCode() {
                return 0;
            }

            public final String toString() {
                return "HandlerWrap(eventName=null, sender=null)";
            }
        }

        /* JADX INFO: renamed from: t10.a$a$b */
        public interface b {
            void a(JSONObject r1);
        }

        /* JADX INFO: renamed from: t10.a$a$c */
        public static final class c {
            public final JSONObject a;

            /* JADX INFO: renamed from: t10.a$a$c$a, reason: collision with other inner class name */
            public static final class C0279a {
            }

            static {
            }

            public c() {
                JSONObject r0 = new JSONObject();
                r0.put("__liveOpenPlatform", true);
                Unit r1 = Unit.INSTANCE;
                this.a = r0;
            }
        }

        public final String h() {
            return "https://snssdk.com";
        }

        public final void j(o r1) {
        }

        public Context getContext(o r1) {
            return this.o;
        }

        public final void k(String r8) {
            if (r8 == null) goto L34;
            LiveSeiUtil.i.getClass();     // Catch: Exception -> L31
            Object r9 = LiveSeiUtil.c(r8).remove("__params");     // Catch: Exception -> L31
            Object r4 = null;
            if ((r9 instanceof JSONObject) == true) goto L7;
            r9 = null;
        L7:
            JSONObject r11 = (JSONObject) r9;     // Catch: Exception -> L31
            if (r11 == null) goto L35;
            Object r3 = r11.remove("eventName");     // Catch: Exception -> L31
            if ((r3 instanceof String) == true) goto L12;
            r3 = null;
        L12:
            String r5 = (String) r3;     // Catch: Exception -> L31
            Object r6 = r11.remove("eventId");     // Catch: Exception -> L31
            if ((r6 instanceof Integer) == true) goto L15;
            r6 = null;
        L15:
            Integer r7 = (Integer) r6;     // Catch: Exception -> L31
            Object r12 = r11.remove("data");     // Catch: Exception -> L31
            if ((r12 instanceof JSONObject) == false) goto L19;
            r4 = r12;
        L19:
            JSONObject r13 = (JSONObject) r4;     // Catch: Exception -> L31
            c r14 = new c();     // Catch: Exception -> L31
            if (r5 != null) goto L22;
            r5 = "";
        L22:
            Intrinsics.checkNotNullParameter(r5, "name");     // Catch: Exception -> L31
            r14.a.put("eventName", r5);     // Catch: Exception -> L31
            if (r7 == null) goto L25;
            int r2 = r7.intValue();     // Catch: Exception -> L31
        L26:
            r14.a.put("eventId", r2);     // Catch: Exception -> L31
            JSONObject r1 = r14.a;     // Catch: Exception -> L31
            if (r13 != null) goto L29;
            r13 = new JSONObject();     // Catch: Exception -> L31
        L29:
            r1.put("data", r13);     // Catch: Exception -> L31
            this.p.a(r14.a);     // Catch: Exception -> L31
            Unit r15 = Unit.INSTANCE;     // Catch: Exception -> L31
            return;
        L25:
            r2 = 0;
            goto L26
        L35:
            return;
        L36:
            return;
        }

        public C0277a(Context r2, b r3) {
            Intrinsics.checkNotNullParameter(r2, "ctx");
            Intrinsics.checkNotNullParameter(r3, "sender");
            this.o = r2;
            this.p = r3;
            this.n = new LinkedHashMap();
        }

        public final void m(String r8, c0 r9) {
            if (r9 == null) goto L6;
            String r2 = r9.f;
            if (r2 == null) goto L6;
        L7:
            C0278a r3 = this.n.remove(r2);
            if (r3 != null) goto L15;
            int r4 = q.a;
            Object[] r5 = new Object[4];
            r5[0] = "event handler is null, event id: ";
            r5[1] = r2;
            r5[2] = ", name: ";
            if (r9 == null) goto L13;
            String r11 = r9.d;
            if (r11 == null) goto L13;
        L14:
            r5[3] = r11;
            q.e("PluginJsBridgeAdapter", r5);
        L13:
            r11 = "null";
        L15:
            c r12 = new c();
            Intrinsics.checkNotNullParameter("", "name");
            r12.a.put("eventName", "");
            int r1 = CastIntegerProtector.parseInt(r2);
            r12.a.put("eventId", r1);
            if (r3 != null) goto L30;
            return;
        L30:
            JSONObject r6 = new JSONObject(r8);     // Catch: Throwable -> L27
            r6.remove("__msg_type");     // Catch: Throwable -> L27
            r6.remove("__callback_id");     // Catch: Throwable -> L27
            Object r13 = r6.remove("__params");     // Catch: Throwable -> L27
            if (r13 == null) goto L26;
            JSONObject r14 = (JSONObject) r13;     // Catch: Throwable -> L27
            int r7 = r14.optInt("errCode", -1);     // Catch: Throwable -> L27
            if (r7 != (-1)) goto L23;
            r7 = r14.optInt("code");     // Catch: Throwable -> L27
        L23:
            r12.a.put("resultCode", r7);     // Catch: Throwable -> L27
            r12.a.put("data", r14);     // Catch: Throwable -> L27
            throw null;     // Catch: Throwable -> L27
        L26:
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: Throwable -> L27
        L27:
            r12.a.put("resultCode", -1);
            Intrinsics.checkNotNullParameter("数据解析错误，操作失败", "errMsg");
            r12.a.put("errMsg", "数据解析错误，操作失败");
            throw null;
        L6:
            r2 = "";
            goto L7
        }
    }

    public static final class b implements C0277a.b {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // t10.a.C0277a.b
        public final void a(JSONObject r5) {
            Intrinsics.checkNotNullParameter(r5, "params");
            int r0 = r5.optInt("eventId", 0);
            int r2 = q.a;
            q.f("PluginJsBridgeAdapter", new Object[]{"post js message, event id: ", Integer.valueOf(r0), ", params:", r5});
            na4.b r1 = this.a.a;
            if (r1 == null) goto L6;
            r1.c(r5);
            return;
        }
    }

    public a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        C0277a r1 = new C0277a(r4, new b(this));
        t10.b r0 = new t10.b(r1);
        d0.a r2 = d0.g;
        o r3 = new o(r0);
        r3.f = r4;
        r3.c = r1;
        r3.g = false;
        r3.h = true;
        r3.d = "OpenPlatformMiniGameJsbridge";
        r3.o = true;
        r3.c(new c());
        r3.k = "webcast";
        this.b = r3.a();
    }
}
