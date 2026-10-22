package com.bytedance.android.live.liveinteract.pre;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final Handler a;
    public final Map<String, String> b;
    public final Map<String, Integer> c;
    public final SparseBooleanArray d;
    public long e;
    public long f;
    public int g;
    public int h;
    public final RunnableC0064a i;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.pre.a$a, reason: collision with other inner class name */
    public class RunnableC0064a implements Runnable {
        public final /* synthetic */ a a;

        public final void a() {
            HashMap r0 = new HashMap();
            Iterator r1 = ((HashMap) this.a.c).entrySet().iterator();
            int r3 = 0;
        L4:
            if (r1.hasNext() == false) goto L6;
            Map.Entry r4 = (Map.Entry) r1.next();
            r3 = r3 + ((Integer) r4.getValue()).intValue();
            r0.put((String) r4.getKey(), String.valueOf(r4.getValue()));
            goto L4
        L6:
            Map<String, String> r2 = this.a.b;
            HashMap r5 = (HashMap) r2;
            r5.put("load_count_cache", String.valueOf(r3));
            a r6 = this.a;
            Map<String, String> r7 = r6.b;
            HashMap r8 = (HashMap) r7;
            r8.put("load_count_total", String.valueOf(r6.h));
            Map<String, String> r9 = this.a.b;
            HashMap r10 = (HashMap) r9;
            r10.put("load_detail", new JSONObject(r0).toString());
            a r11 = this.a;
            Map<String, String> r12 = r11.b;
            HashMap r13 = (HashMap) r12;
            r13.put("load_time", String.valueOf(r11.f - r11.e));
            j0.l().sendLog("livesdk_vertical_preinflate_count", this.a.b, new Object[0]);
            ((HashMap) this.a.b).clear();
            ((HashMap) this.a.c).clear();
            a r14 = this.a;
            r14.h = 0;
            r14.d.delete(r14.g);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0064a(a r1) {
            this.a = r1;
        }
    }

    public static class b implements Runnable {
        public final Handler a;
        public int b;
        public final Runnable c;

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = this.b;     // Catch: Throwable -> L7
            if (r0 == 1) goto L5;
            int r1 = r0 - 1;     // Catch: Throwable -> L7
            this.b = r1;     // Catch: Throwable -> L7
            Handler r2 = this.a;     // Catch: Throwable -> L7
            r2.post(new b(r2, r1, this.c));     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            this.c.run();     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public b(Handler r1, int r2, Runnable r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static class c {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public a() {
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new SparseBooleanArray();
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = 0;
        this.i = new RunnableC0064a(this);
        this.a = new Handler(Looper.getMainLooper());
    }

    public final void a(int r6, int r7) {
        this.d.put(r6, true);
        this.a.removeCallbacks(this.i);
        if (this.d.get(this.g) == false) goto L5;
        j0.l().sendLog("livesdk_vertical_preinflate_count", this.b, new Object[0]);
        this.d.delete(this.g);
    L5:
        this.g = r6;
        this.e = System.currentTimeMillis();
        ((HashMap) this.b).clear();
        ((HashMap) this.c).clear();
        this.h = 0;
        Map<String, String> r8 = this.b;
        HashMap r9 = (HashMap) r8;
        r9.put("room_sei_local", String.valueOf(r7));
    }

    public final void b(String r5, boolean r6) {
        this.h++;
        if (TextUtils.equals(r5, VerticalNitaInflate.Tag.GuestBattleQuickInteractView.name()) == true) goto L5;
        this.f = System.currentTimeMillis();
    L5:
        if (r6 == false) goto L11;
        Integer r7 = (Integer) ((HashMap) this.c).get(r5);
        if (r7 != null) goto L9;
        ((HashMap) this.c).put(r5, 1);
        return;
    L9:
        ((HashMap) this.c).put(r5, Integer.valueOf(r7.intValue() + 1));
        return;
    }

    public final void c(IRoom r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getLinkMap() != null) goto L6;
        return;
    L6:
        if (r5.getLinkerDetail() == null) goto L20;
        Set r0 = r5.getLinkMap().keySet();
        ((HashMap) this.b).put("cache_type", "load");
        Map<String, String> r1 = this.b;
        if (r6 == false) goto L11;
        String r7 = "1";
    L12:
        ((HashMap) r1).put("cache_scene", r7);
        Map<String, String> r8 = this.b;
        if (r0.size() <= 0) goto L15;
        String r2 = (String) r0.toArray()[0];
    L16:
        ((HashMap) r8).put("room_scene", r2);
        Map<String, String> r9 = this.b;
        HashMap r10 = (HashMap) r9;
        r10.put("room_uilayout", String.valueOf(r5.getLinkerDetail().getUiLayout()));
        return;
    L15:
        r2 = "";
        goto L16
    L11:
        r7 = "2";
        goto L12
    }
}
