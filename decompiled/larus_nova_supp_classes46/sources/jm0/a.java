package jm0;

import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.livesdk.message.model.e3;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import q71.d;
import r71.c;
import r71.e;
import r71.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements q71.a {
    public final d<e> a;
    public final d<c> b;
    public final d<r71.d> c;
    public final d<r71.a> d;
    public final d<r71.b> e;
    public final Map<e3, Map<MsgWindowPosition, d<f>>> f;

    public final void release() {
    }

    public a() {
        int r0 = d.c;
        this.a = d.a.a();
        this.b = d.a.a();
        this.c = d.a.a();
        this.d = d.a.a();
        this.e = d.a.a();
        this.f = new LinkedHashMap();
    }

    public final d a() {
        return this.a;
    }

    public final d b() {
        return this.d;
    }

    public final d d() {
        return this.c;
    }

    public final d e() {
        return this.e;
    }

    public final d<f> c(e3 r4, MsgWindowPosition r5) {
        Intrinsics.checkNotNullParameter(r5, "position");
        if (r4 != null) goto L6;
        return null;
    L6:
        Map r0 = (Map) ((LinkedHashMap) this.f).get(r4);
        if (r0 == null) goto L10;
        d<f> r1 = (d) r0.get(r5);
        if (r1 == null) goto L10;
    L16:
        return r1;
    L10:
        int r2 = d.c;
        r1 = d.a.a();
        if (((Map) ((LinkedHashMap) this.f).get(r4)) != null) goto L13;
        Map<MsgWindowPosition, d<f>> r3 = this.f.put(r4, new LinkedHashMap());
    L13:
        Map r6 = (Map) ((LinkedHashMap) this.f).get(r4);
        if (r6 == null) goto L16;
        d r7 = (d) r6.put(r5, r1);
        goto L16
    }
}
