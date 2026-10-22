package oc;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.forest.utils.m;
import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.x;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f20547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f20549c;

    public c(int r5) {
        m r10 = a(r5);
        this.f20547a = r10;
        this.f20548b = (String) r10.f4651b;
        this.f20549c = true;
    }

    public abstract m a(int r5);

    public final synchronized void b(String r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);     // Catch: Throwable -> L13
        if (this.f20549c == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        com.bytedance.ies.bullet.base.utils.b.g("获取缓存 " + this.f20548b + ", " + r5);     // Catch: Throwable -> L13
        if (this.f20547a.get(r5) != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        throw new ClassCastException();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(int r10) {
        monitor-enter(this);
        this.f20547a.evictAll();     // Catch: Throwable -> L5
    L11:
        if (r10 > 0) goto L13;
        this.f20549c = false;     // Catch: Throwable -> L9
    L14:
        monitor-exit(this);
        return;
    L13:
        this.f20547a = a(r10);     // Catch: Throwable -> L9
        goto L14
    L5:
        th = move-exception;
        com.bytedance.ies.bullet.service.base.b.g("PreloadCache reSize", "PreloadV2", th);     // Catch: Throwable -> L9
        tc.c r5 = tc.c.f22119c;     // Catch: Throwable -> L9
        i r11 = (i) fj.a.a(tc.c.f22119c, i.class, i.class);     // Catch: Throwable -> L9
        if (r11 == null) goto L11;
        x r12 = new x("bdx_preload_cache_fail");     // Catch: Throwable -> L9
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L9
        r13.put("cacheName", (String) this.f20547a.f4651b);     // Catch: Throwable -> L9
        r13.put("updateSize", r10);     // Catch: Throwable -> L9
        r13.put("lruCacheSize", this.f20547a.size());     // Catch: Throwable -> L9
        r13.put("lruMapSize", this.f20547a.snapshot().size());     // Catch: Throwable -> L9
        r12.e = r13;     // Catch: Throwable -> L9
        ((com.bytedance.ies.bullet.service.monitor.i) r11).d(r12);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(String r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);     // Catch: Throwable -> L10
        if (this.f20549c == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f20547a.remove(r5);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
