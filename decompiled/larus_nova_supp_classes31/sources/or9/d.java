package or9;

import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.model.video.business.VideoFeedConfigure;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public long A;
    public EnterVideoMethod a;
    public List<String> b;
    public JSONObject c;
    public boolean d;
    public List<Pair<String, String>> e;
    public final boolean f;
    public boolean g;
    public final boolean h;
    public final boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public final String n;
    public JSONObject o;
    public String p;
    public long q;
    public String r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public final long x;
    public String y;
    public boolean z;

    public static final class a {
    }

    static {
    }

    public final VideoFeedConfigure a() {
        VideoFeedConfigure r0 = new VideoFeedConfigure();
        r0.f = this.a;
        List<String> r1 = this.b;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.h = r1;
        r0.j = this.f;
        r0.k = this.g;
        r0.v = this.h;
        r0.w = this.i;
        r0.x = this.n;
        r0.y = this.p;
        r0.i = this.r;
        r0.t = this.k;
        r0.b = this.z;
        r0.s = this.j;
        JSONObject r2 = this.c;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.g = r2;
        r0.c = this.d;
        r0.u = this.s;
        JSONObject r3 = new JSONObject();
        EnterVideoMethod r4 = r0.f;
        if (r4 == null) goto L5;
        String r5 = r4.getValue();
    L6:
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r3.put("host_enter_from", r5);
        Iterator<String> r6 = this.o.keys();
    L10:
        if (r6.hasNext() == false) goto L12;
        String r7 = r6.next();
        r3.put(r7, this.o.get(r7));
        goto L10
    L12:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.d = r3;
        JSONObject r8 = new JSONObject();
        Iterator<T> r9 = this.e.iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        Pair r10 = (Pair) r9.next();
        r8.put((String) r10.getFirst(), r10.getSecond());
        goto L14
    L16:
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r0.e = r8;
        r0.l = this.t;
        r0.z = this.v;
        r0.a = this.w;
        r0.r = this.y;
        r0.m = 0.0f;
        r0.q = this.x;
        r0.o = this.m;
        r0.n = this.l;
        r0.p = this.u;
        r0.A = this.q;
        r0.B = this.A;
        return r0;
    L5:
        r5 = null;
        goto L6
    }

    public d() {
        this.a = EnterVideoMethod.MAIN_DOUBLE_TAG;
        this.b = CollectionsKt.emptyList();
        this.c = new JSONObject();
        this.e = CollectionsKt.emptyList();
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.k = true;
        this.n = "";
        this.o = new JSONObject();
        this.p = "";
        this.q = -1;
        this.r = "";
        this.t = true;
        this.w = -1;
        this.x = 300;
        this.z = true;
    }
}
