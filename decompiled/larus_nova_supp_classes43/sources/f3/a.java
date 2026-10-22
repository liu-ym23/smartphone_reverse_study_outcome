package f3;

import com.byted.cast.sink.api.CastInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final C0156a c = null;
    public static final a d = null;
    public static final a e = null;
    public static final a f = null;
    public static final a g = null;
    public static final a h = null;
    public static final a i = null;
    public static final a j = null;
    public static final a k = null;
    public static final a l = null;
    public static final a m = null;
    public static final a n = null;
    public static final a o = null;
    public static final a p = null;
    public static final a q = null;
    public static final a r = null;
    public static final a s = null;
    public static final a t = null;
    public static final a u = null;
    public static final a v = null;
    public static final a w = null;
    public static final a x = null;
    public static final a y = null;
    public final int a;
    public final String b;

    /* JADX INFO: renamed from: f3.a$a, reason: collision with other inner class name */
    public static final class C0156a {
        public C0156a() {
        }
    }

    static {
        c = new C0156a();
        d = new a(0, com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE);
        e = new a(100, "unknown error");
        f = new a(102, "internal error");
        g = new a(103, "feature not support");
        h = new a(104, "invalid parameter");
        i = new a(CastInfo.TYPE_CAST_RESUME, "authentication fail");
        j = new a(CastInfo.TYPE_DISCONNECT, "system permission denied");
        k = new a(CastInfo.TYPE_PAUSED, "user permission denied");
        l = new a(110, "API call prohibited");
        m = new a(112, "invalid result");
        n = new a(113, "bridge unavailable");
        o = new a(114, "operation cancelled");
        p = new a(115, "operation timeout");
        q = new a(116, "resource not found");
        new a(117, "not implemented");
        r = new a(118, "already exists");
        s = new a(120, "too many requests");
        new a(201, "no read permission");
        new a(202, "no write permission");
        t = new a(203, "file does not exist");
        new a(204, "file already exists");
        u = new a(208, "total size limit exceeded");
        v = new a(213, "invalid file path");
        new a(301, "network request cancelled");
        w = new a(302, "connection timed out");
        x = new a(303, "no network connection");
        y = new a(305, "network failure");
        new a(307, "network SDK parameter error");
    }

    public final String toString() {
        return "AIBridgeApiErr(errNo=" + this.a + ", errMsg='" + this.b + "')";
    }

    public final int hashCode() {
        return this.a;
    }

    public final boolean equals(Object r10) {
        if ((r10 instanceof a) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.a != ((a) r10).a) goto L7;
        return true;
    }

    public a(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errMsg");
        this.a = r10;
        this.b = r11;
    }
}
