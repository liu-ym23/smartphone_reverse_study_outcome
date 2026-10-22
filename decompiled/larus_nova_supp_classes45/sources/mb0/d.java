package mb0;

import com.bytedance.android.live.ktv.common.util.MusicInfoError;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static c a;

    static {
    }

    public static void e(MusicPanel r1) {
        Intrinsics.checkNotNullParameter(r1, "musicPanel");
        c r0 = a;
        if (r0 == null) goto L6;
        r0.e(r1);
        return;
    }

    public static void f(String r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "page");
        c r0 = a;
        if (r0 == null) goto L6;
        c.a.c(r0, r1, r2);
        return;
    }

    @JvmStatic
    public static final void g(String r2, MusicPanel r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "musicPanel");
        c r0 = a;
        if (r0 == null) goto L6;
        r0.b(r2, r3, null);
        return;
    }

    @JvmStatic
    public static final void h(KtvMusic r1, MusicInfoError r2) {
        Intrinsics.checkNotNullParameter(r2, "errorInfo");
        c r0 = a;
        if (r0 == null) goto L6;
        r0.h(r1, r2);
        return;
    }

    public static void a(LinkMonitorData r6, long r7, Throwable r9) {
        JSONObject r5 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r5, "extra");
        c r0 = a;
        if (r0 == null) goto L6;
        r0.a(r6, r7, r9, r5);
        return;
    }

    public static void b(LinkMonitorData r6, long r7, String r9) {
        JSONObject r5 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r9, "logId");
        Intrinsics.checkNotNullParameter(r5, "extra");
        c r0 = a;
        if (r0 == null) goto L6;
        r0.j(r6, r7, r9, r5);
        return;
    }

    @JvmStatic
    public static final void d(MusicPanel r7, String r8, String r9, long r11) {
        Intrinsics.checkNotNullParameter(r8, "type");
        Intrinsics.checkNotNullParameter(r9, "downloadUrl");
        c r1 = a;
        if (r1 == null) goto L6;
        r1.d(r7, r8, r9, r11);
        return;
    }

    @JvmStatic
    public static final void c(MusicPanel r7, String r8, String r9, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "type");
        Intrinsics.checkNotNullParameter(r9, "downloadUrl");
        Intrinsics.checkNotNullParameter(r12, "errorMsg");
        c r1 = a;
        if (r1 == null) goto L6;
        r1.f(r7, r8, r9, r11, r12);
        return;
    }
}
