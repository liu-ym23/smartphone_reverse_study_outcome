package t6;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile EnumC0161a f12274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f12275b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicLong f12276c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f12277d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicLong f12278e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLong f12279f = null;

    /* JADX INFO: renamed from: t6.a$a, reason: collision with other inner class name */
    public static final enum EnumC0161a extends Enum<EnumC0161a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0161a f12280b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ EnumC0161a[] f12281m = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12282a;

        static {
            EnumC0161a r8 = new EnumC0161a("NormalStart", 0, -1);
            f12280b = r8;
            f12281m = new EnumC0161a[]{r8, new EnumC0161a("ColdStart", 1, 0), new EnumC0161a("HotStart", 2, 1), new EnumC0161a("WarmStart", 3, 2)};
        }

        public EnumC0161a(String r8, int r10, int r11) {
            super(r8, r10);
            this.f12282a = r11;
        }

        public static EnumC0161a valueOf(String r8) {
            return (EnumC0161a) Enum.valueOf(EnumC0161a.class, r8);
        }

        public static EnumC0161a[] values() {
            return (EnumC0161a[]) f12281m.clone();
        }
    }

    static {
        f12274a = EnumC0161a.f12280b;
        f12275b = new AtomicBoolean(false);
        f12276c = new AtomicLong(0);
        f12277d = new AtomicLong(0);
        f12278e = new AtomicLong(0);
        f12279f = new AtomicLong(0);
    }

    public static void a(JSONObject r8) {
        AtomicBoolean r10 = f12275b;
        if (r8.optInt("request_tag_enabled") <= 0) goto L5;
        boolean r11 = true;
    L6:
        r10.set(r11);
        AtomicLong r12 = f12277d;
        r12.set(r8.optInt("cold_start_seconds"));
        AtomicLong r13 = f12278e;
        r13.set(r8.optInt("hot_start_seconds"));
        AtomicLong r14 = f12279f;
        r14.set(r8.optInt("warm_start_seconds"));
        if (Logger.debug() == false) goto L10;
        Logger.d("a", "set coldDuration hostDuration warmDuration " + r12.get() + r13.get() + r14.get());
        return;
    L10:
        return;
    L5:
        r11 = false;
        goto L6
    }
}
