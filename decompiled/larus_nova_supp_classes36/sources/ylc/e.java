package ylc;

import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements b {
    public final Map<String, com.ss.ugc.live.sdk.message.wrsc.data.a> a;
    public final HashMap<String, Set<c>> b;
    public final CopyOnWriteArrayList<c> c;
    public final LimitedSizeHashMap<String, Long> d;
    public final LimitedSizeHashMap<String, Long> e;
    public long f;
    public final d g;
    public final vlc.g h;

    public /* synthetic */ e() {
        throw null;
    }

    public final void h() {
        ((LinkedHashMap) this.a).clear();
        Iterator<Map.Entry<String, Set<c>>> r0 = this.b.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Iterator<T> r1 = r0.next().getValue().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        ((c) r1.next()).onClear();
        goto L7
    L9:
        this.b.clear();
        this.c.clear();
    }

    @Override // ylc.b
    public final long getRoomId() {
        return this.f;
    }

    @Override // ylc.b
    public final com.ss.ugc.live.sdk.message.wrsc.data.a b(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return e(r2);
    }

    public final void c(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.c.contains(r2) == true) goto L6;
        this.c.add(r2);
        return;
    }

    public final com.ss.ugc.live.sdk.message.wrsc.data.a e(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return (com.ss.ugc.live.sdk.message.wrsc.data.a) ((LinkedHashMap) this.a).get(r2);
    }

    @Override // ylc.b
    public final void f(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        i(r2);
    }

    public final void g(com.ss.ugc.live.sdk.message.wrsc.data.a r5) {
        if (this.g.b.contains(r5.g) == false) goto L6;
        this.d.put(r5.g, Long.valueOf(r5.a));
    L8:
        Set<c> r0 = this.b.get(r5.g);
        if (r0 == null) goto L14;
        Iterator<T> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        ((c) r1.next()).a(r5);
    L14:
        Iterator<T> r2 = this.c.iterator();
    L16:
        if (r2.hasNext() == false) goto L18;
        ((c) r2.next()).a(r5);
        goto L16
    L18:
        return;
    L6:
        if (this.g.a <= 0) goto L8;
        this.e.put(r5.g, Long.valueOf(r5.a));
        goto L8
    }

    public final void i(c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Iterator<Map.Entry<String, Set<c>>> r0 = this.b.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().remove(r3);
        goto L4
    }

    @Override // ylc.b
    public final void a(String r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "listener");
        d(r2, r3);
    }

    public final void d(String r3, c r4) {
        Intrinsics.checkNotNullParameter(r3, "dataSyncKey");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Set<c> r0 = this.b.get(r3);
        if (r0 != null) goto L5;
        r0 = new CopyOnWriteArraySet();
        this.b.put(r3, r0);
    L5:
        r0.add(r4);
    }

    public e(long r2, d r4, bc2.e r5) {
        Intrinsics.checkNotNullParameter(r4, "wrdsConfig");
        Intrinsics.checkNotNullParameter(r5, "monitor");
        this.f = r2;
        this.g = r4;
        this.h = r5;
        this.a = new LinkedHashMap();
        this.b = new HashMap();
        this.c = new CopyOnWriteArrayList();
        this.d = new LimitedSizeHashMap(Math.max(1, r4.b.size()));
        this.e = new LimitedSizeHashMap(Math.max(1, r4.a - r4.b.size()));
    }
}
