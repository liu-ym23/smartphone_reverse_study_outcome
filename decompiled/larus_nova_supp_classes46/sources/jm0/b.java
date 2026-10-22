package jm0;

import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.livesdk.message.model.e3;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import q71.d;
import r71.e;
import r71.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements q71.a {
    public static final d<e> a = null;
    public static final d<r71.d> b = null;
    public static final d<r71.a> c = null;
    public static final d<r71.b> d = null;
    public static final Map<e3, Map<MsgWindowPosition, d<f>>> e = null;
    public static final b f = null;

    public b() {
    }

    public final void release() {
    }

    static {
        f = new b();
        int r0 = d.c;
        a = d.a.a();
        d.a.a();
        b = d.a.a();
        c = d.a.a();
        d = d.a.a();
        e = new LinkedHashMap();
    }

    public final d a() {
        return a;
    }

    public final d b() {
        return c;
    }

    public final d d() {
        return b;
    }

    public final d e() {
        return d;
    }

    public final d<f> c(e3 r5, MsgWindowPosition r6) {
        Intrinsics.checkNotNullParameter(r6, "position");
        if (r5 != null) goto L6;
        return null;
    L6:
        Map<e3, Map<MsgWindowPosition, d<f>>> r0 = e;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Map r2 = (Map) r1.get(r5);
        if (r2 == null) goto L10;
        d<f> r3 = (d) r2.get(r6);
        if (r3 == null) goto L10;
    L16:
        return r3;
    L10:
        int r4 = d.c;
        r3 = d.a.a();
        if (((Map) r1.get(r5)) != null) goto L13;
        Map<MsgWindowPosition, d<f>> r7 = r0.put(r5, new LinkedHashMap());
    L13:
        Map r8 = (Map) r1.get(r5);
        if (r8 == null) goto L16;
        d r9 = (d) r8.put(r6, r3);
        goto L16
    }
}
