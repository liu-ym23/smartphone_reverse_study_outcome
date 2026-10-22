package mc;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public static final ByteString f11094d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public static final ByteString f11095e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JvmField
    public static final ByteString f11096f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public static final ByteString f11097g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public static final ByteString f11098h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JvmField
    public static final ByteString f11099i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final ByteString f11100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final ByteString f11101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final int f11102c;

    /* JADX INFO: renamed from: mc.a$a, reason: collision with other inner class name */
    public static final class C0242a {
        private C0242a() {
        }

        public /* synthetic */ C0242a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new C0242a(null);
        ByteString.a r10 = ByteString.Companion;
        f11094d = r10.d(":");
        f11095e = r10.d(":status");
        f11096f = r10.d(":method");
        f11097g = r10.d(":path");
        f11098h = r10.d(":scheme");
        f11099i = r10.d(":authority");
    }

    public a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        ByteString.a r12 = ByteString.Companion;
        this(r12.d(r10), r12.d(r11));
    }

    public a(ByteString r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        this(r10, ByteString.Companion.d(r11));
    }

    public a(ByteString r10, ByteString r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        this.f11100a = r10;
        this.f11101b = r11;
        this.f11102c = (r10.size() + 32) + r11.size();
    }

    public final ByteString a() {
        return this.f11100a;
    }

    public final ByteString b() {
        return this.f11101b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.f11100a, r11.f11100a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11101b, r11.f11101b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f11100a.hashCode() * 31) + this.f11101b.hashCode();
    }

    public String toString() {
        return this.f11100a.utf8() + ": " + this.f11101b.utf8();
    }
}
