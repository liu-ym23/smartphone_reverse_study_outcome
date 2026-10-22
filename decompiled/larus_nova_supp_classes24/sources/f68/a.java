package f68;

import android.app.Application;
import com.larus.audio.settings.audio.data.AudioRetransmitStrategy;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import m58.b;
import m58.h;
import m58.w;
import m58.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    /* JADX INFO: renamed from: f68.a$a, reason: collision with other inner class name */
    public static final class C0108a {
    }

    static {
    }

    public final Map<String, Object> a() {
        Pair[] r0 = new Pair[11];
        boolean r2 = false;
        r0[0] = TuplesKt.to("bot_id", this.d);
        r0[1] = TuplesKt.to("taskId", this.a);
        r0[2] = TuplesKt.to("speaker", this.b);
        r0[3] = TuplesKt.to("model", this.c);
        r0[4] = TuplesKt.to("new_arch", "arch-v3");
        x58.a r1 = h.a;
        x58.a r3 = h.a;
        Application r4 = null;
        if (r3 == null) goto L9;
        AudioRetransmitStrategy r5 = r3.l;
        if (r5 == null) goto L9;
        t78.a r6 = r5.getData();
        if (r6 == null) goto L9;
        Boolean r7 = Boolean.valueOf(r6.a());
    L10:
        r0[5] = TuplesKt.to("enable_retransmit", String.valueOf(r7));
        r0[6] = TuplesKt.to("sami_sdk_version", "14.92.34-alpha.1-oassistant");
        y r8 = y.a;
        b r9 = h.k;
        if (r9 == null) goto L13;
        Application r10 = r9.getApplication();
    L14:
        r0[7] = TuplesKt.to("phone_volume", String.valueOf(r8.b(r10)));
        b r11 = h.k;
        if (r11 == null) goto L17;
        r4 = r11.getApplication();
    L17:
        r0[8] = TuplesKt.to("phone_is_muted", String.valueOf(r8.f(r4)));
        w r12 = h.f;
        if (r12 == null) goto L21;
        String r13 = r12.getCurrentNetworkStatus();
        if (r13 == null) goto L21;
    L22:
        r0[9] = TuplesKt.to("network_status", r13);
        b r14 = h.k;
        if (r14 != null) goto L25;
    L27:
        if (r2 == false) goto L29;
        String r15 = "background";
    L30:
        r0[10] = TuplesKt.to("app_status", r15);
        return MapsKt.mapOf(r0);
    L29:
        r15 = "foreground";
        goto L30
    L25:
        if (r14.isAppBackground() != true) goto L27;
        r2 = true;
    L21:
        r13 = "";
        goto L22
    L13:
        r10 = null;
    L9:
        r7 = null;
        goto L10
    }

    public a(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "mTaskId");
        Intrinsics.checkNotNullParameter(r3, "mSpeaker");
        Intrinsics.checkNotNullParameter(r4, "mModelName");
        Intrinsics.checkNotNullParameter(r5, "botId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
