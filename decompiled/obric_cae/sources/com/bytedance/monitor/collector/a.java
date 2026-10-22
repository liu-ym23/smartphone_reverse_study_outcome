package com.bytedance.monitor.collector;

import a8.b;
import android.app.Activity;
import android.util.Pair;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import u8.c;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f3967b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f3968c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f3969a;

    /* JADX INFO: renamed from: com.bytedance.monitor.collector.a$a, reason: collision with other inner class name */
    public class C0047a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f3970a;

        public C0047a(a r8) {
            this.f3970a = r8;
        }

        @Override // u8.c
        public final void a() {
        }

        @Override // u8.c
        public final void b() {
        }

        @Override // u8.c
        public final void c(Activity r8) {
        }

        @Override // u8.c
        public final void d(Activity r8) {
            this.f3970a.getClass();
        }

        @Override // u8.c
        public final void e(Activity r8) {
            this.f3970a.getClass();
        }

        @Override // u8.c
        public final void f() {
        }

        @Override // u8.c
        public final void g() {
        }
    }

    public a() {
        this.f3969a = new CopyOnWriteArrayList();
        ActivityLifeObserver.getInstance().register(new C0047a(this));
    }

    public static a b() {
        if (f3968c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3968c != null) goto L9;
        f3968c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f3968c;
    }

    public final JSONObject a() {
        JSONObject r8 = new JSONObject();
        int r10 = 0;
    L3:
        CopyOnWriteArrayList r11 = this.f3969a;
    L8:
        e = move-exception;
        e.printStackTrace();
    L10:
        return r8;
    L5:
        if (r10 >= r11.size()) goto L10;
        Pair<String, ?> r12 = ((b) r11.get(r10)).a();     // Catch: Exception -> L8
        r8.put((String) r12.first, r12.second);     // Catch: Exception -> L8
        r10 = r10 + 1;
        goto L3
    }
}
