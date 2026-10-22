package m60;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.browser.jsbridge.newmethods.y3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.permission.PermissionFragment;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ru.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    public static final SettingKey<Boolean> a = null;
    public static final TokenCert b = null;

    public static abstract class a implements o60.a {
        public a() {
        }

        @Override // o60.a
        public final void a(Activity r13, final o60.b r14, String[] r15) {
            AlertDialog.setNightMode(new y3());
            AlertDialog.Builder r0 = new AlertDialog.Builder(r13).setTitle(r13.getString(2131921338));
            if (i.a.getValue().booleanValue() == false) goto L22;
            Object[] r1 = new Object[1];
            Map<String, Integer> r6 = m60.c.a;
            HashMap r7 = new HashMap(m60.c.a);
            r7.put("android.permission.WRITE_EXTERNAL_STORAGE", 2131921339);
            ArrayList r8 = new ArrayList();
            int r9 = r15.length;
            int r11 = 0;
        L5:
            if (r11 >= r9) goto L14;
            String r12 = r15[r11];
            if (m60.c.d(r13, new String[]{r12}) == true) goto L13;
            if (r7.containsKey(r12) == false) goto L13;
            Integer r16 = (Integer) r7.get(r12);
            if (r8.contains(r16) == true) goto L13;
            r8.add(r16);
        L13:
            r11 = r11 + 1;
            goto L5
        L14:
            StringBuilder r17 = new StringBuilder();
            Iterator r2 = r8.iterator();
        L16:
            if (r2.hasNext() == false) goto L21;
            Integer r18 = (Integer) r2.next();
            if (r17.length() <= 0) goto L20;
            r17.append(", ");
        L20:
            r17.append(r13.getString(r18.intValue()));
            goto L16
        L21:
            r1[0] = r17.toString();
            String r19 = r13.getString(2131921337, r1);
        L38:
            r0.setMessage(r19).setPositiveButton(r13.getString(2131922469), new e(this, r14)).setNegativeButton(r13.getString(2131915442), new f()).setOnKeyListener(new g()).setCancelable(false).setOnCancelListener(new h(this, r14)).show();
            return;
        L22:
            Object[] r3 = new Object[1];
            Map<String, Integer> r4 = m60.c.a;
            ArrayList r5 = new ArrayList();
            int r21 = r15.length;
            int r22 = 0;
        L23:
            if (r22 >= r21) goto L30;
            String r23 = r15[r22];
            HashMap r24 = (HashMap) m60.c.a;
            if (r24.containsKey(r23) == false) goto L29;
            Integer r25 = (Integer) r24.get(r23);
            if (r5.contains(r25) == true) goto L29;
            r5.add(r25);
        L29:
            r22 = r22 + 1;
            goto L23
        L30:
            StringBuilder r110 = new StringBuilder();
            Iterator r26 = r5.iterator();
        L32:
            if (r26.hasNext() == false) goto L37;
            Integer r27 = (Integer) r26.next();
            if (r110.length() <= 0) goto L36;
            r110.append(", ");
        L36:
            r110.append(r13.getString(r27.intValue()));
            goto L32
        L37:
            r3[0] = r110.toString();
            r19 = r13.getString(2131921337, r3);
            goto L38
        }
    }

    public static class b {
        public final Activity a;
        public final c b;
        public o60.a c;
        public Runnable d;
        public Runnable e;
        public boolean f;

        public b(Activity r2) {
            this.b = new c();
            this.c = new d();
            this.d = new l();
            this.e = new l();
            this.f = true;
            this.a = r2;
        }

        public final void a(o60.e r2, TokenCert r3, List r4) {
            b(r2, null, r3, (String[]) r4.toArray(new String[r4.size()]));
        }

        public final void b(final o60.e r12, o60.d r13, final Cert r14, final String... r15) {
            Activity r1 = this.a;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.isFinishing() == true) goto L20;
            ALogger.e("LivePermissionsRequest", "start to request permissions");     // Catch: Exception -> L9
            PermissionFragment.f(this.a, r12, r13, this.d, this.b, this.c, this.e, r14, r15);     // Catch: Exception -> L9
            ALogger.e("LivePermissionsRequest", "finish to request permissions");     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            SafetyGuard.a(null, e, "Permission request error");
            if ((e instanceof IllegalStateException) == true) goto L13;
        L15:
            ALogger.e("LivePermissionsRequest", e.toString(), new Throwable());
            return;
        L13:
            if (this.f == false) goto L15;
            new Handler(Looper.getMainLooper()).post(new j(this, r12, r14, r15));
            this.f = false;
            ALogger.e("LivePermissionsRequest", "try request in handler post");
            goto L15
        }
    }

    public static class c implements o60.a {
        public c() {
        }

        @Override // o60.a
        public final void a(Activity r1, o60.b r2, String[] r3) {
            r2.execute();
        }
    }

    public static class d extends a {
        public d() {
        }
    }

    static {
        Boolean r1 = Boolean.TRUE;
        a = new SettingKey("change_hotsoon_permission_request_never_ask_dialog_message", "火山neverAskDialog权限弹窗文案修复", r1, r1);
        b = TokenCert.with("bpea-permissionfragment_request_permission");
    }
}
