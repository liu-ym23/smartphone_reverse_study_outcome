package e68;

import com.larus.audio.settings.audio.data.AudioRetransmitStrategy;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import m58.b;
import m58.h;
import m58.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final String a;
    public final String b;

    /* JADX INFO: renamed from: e68.a$a, reason: collision with other inner class name */
    public static final class C0105a {
    }

    static {
    }

    public final Map<String, Object> a() {
        Pair[] r0 = new Pair[7];
        Pair r1 = TuplesKt.to("bot_id", this.b);
        boolean r2 = false;
        r0[0] = r1;
        x58.a r3 = h.a;
        w r4 = h.f;
        String r5 = "";
        if (r4 == null) goto L6;
        String r6 = r4.getNetworkAccessType();
        if (r6 == null) goto L6;
    L7:
        r0[1] = TuplesKt.to("network", r6);
        r0[2] = TuplesKt.to("asr_language", this.a);
        w r7 = h.f;
        if (r7 == null) goto L13;
        String r8 = r7.getCurrentNetworkStatus();
        if (r8 == null) goto L13;
        r5 = r8;
    L13:
        r0[3] = TuplesKt.to("network_status", r5);
        r0[4] = TuplesKt.to("new_arch", "arch-v3");
        x58.a r9 = h.a;
        if (r9 == null) goto L20;
        AudioRetransmitStrategy r10 = r9.l;
        if (r10 == null) goto L20;
        t78.a r11 = r10.getData();
        if (r11 == null) goto L20;
        Boolean r12 = Boolean.valueOf(r11.a());
    L21:
        r0[5] = TuplesKt.to("enable_retransmit", String.valueOf(r12));
        b r13 = h.k;
        if (r13 != null) goto L24;
    L26:
        if (r2 == false) goto L28;
        String r14 = "background";
    L29:
        r0[6] = TuplesKt.to("app_status", r14);
        return MapsKt.mapOf(r0);
    L28:
        r14 = "foreground";
        goto L29
    L24:
        if (r13.isAppBackground() != true) goto L26;
        r2 = true;
    L20:
        r12 = null;
    L6:
        r6 = "";
        goto L7
    }

    public a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "mAsrLanguage");
        Intrinsics.checkNotNullParameter(r3, "botId");
        this.a = r2;
        this.b = r3;
    }
}
