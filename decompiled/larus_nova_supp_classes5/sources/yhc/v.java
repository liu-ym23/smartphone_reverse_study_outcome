package yhc;

import android.app.Activity;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class v {
    public final int a;
    public final AppCommonContext b;
    public final String c;
    public final i0 d;
    public final j e;
    public final d f;
    public final boolean g;
    public final boolean h;
    public final d0 i;
    public final boolean j;
    public final String k;
    public final long l;
    public final boolean m;
    public final String n;
    public final boolean o;
    public final c p;
    public final String q;
    public final boolean r;
    public final boolean s;

    public static final class a {
        public int a;
        public AppCommonContext b;
        public String c;
        public i0 d;
        public j e;
        public d f;
        public boolean g;
        public boolean h;
        public boolean i;
        public d0 j;
        public String k;
        public long l;
        public String m;
        public c n;
        public String o;
        public boolean p;
        public boolean q;

        /* JADX INFO: renamed from: yhc.v$a$a, reason: collision with other inner class name */
        public class C0034a implements d {
            @Override // yhc.d
            public final WeakReference<Activity> getCurrentActivity() {
                return null;
            }

            public C0034a() {
            }
        }

        public a() {
            this.f = new C0034a();
            this.l = DownloadConstants.HOUR;
            this.m = "";
            this.p = false;
            this.q = true;
        }
    }

    public final i0 a() {
        i0 r0 = this.d;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("updateStrategyInfo can not null");
    }

    public final j b() {
        j r0 = this.e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("iUpdateForceExit can not null");
    }

    public v(a r4) {
        this.l = DownloadConstants.HOUR;
        this.m = true;
        this.n = "";
        this.o = true;
        this.r = false;
        this.s = true;
        this.a = r4.a;
        this.b = r4.b;
        this.c = r4.c;
        this.d = r4.d;
        this.e = r4.e;
        this.f = r4.f;
        this.h = r4.h;
        this.j = r4.i;
        this.i = r4.j;
        this.k = r4.k;
        this.l = r4.l;
        this.g = r4.g;
        this.m = true;
        this.n = r4.m;
        this.o = true;
        this.p = r4.n;
        this.q = r4.o;
        this.r = r4.p;
        this.s = r4.q;
    }
}
