package lc;

import android.support.v4.media.session.PlaybackStateCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.r;
import okio.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f10925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f10926b;

    /* JADX INFO: renamed from: lc.a$a, reason: collision with other inner class name */
    public static final class C0235a {
        private C0235a() {
        }

        public /* synthetic */ C0235a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new C0235a(null);
    }

    public a(f r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        this.f10925a = r10;
        this.f10926b = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public final r a() {
        r.a r10 = new r.a();
    L3:
        String r11 = b();
        if (r11.length() != 0) goto L6;
        boolean r12 = true;
    L7:
        if (r12 == true) goto L10;
        r10.b(r11);
        goto L3
    L10:
        return r10.e();
    L6:
        r12 = false;
        goto L7
    }

    public final String b() {
        String r10 = this.f10925a.q(this.f10926b);
        this.f10926b -= (long) r10.length();
        return r10;
    }
}
