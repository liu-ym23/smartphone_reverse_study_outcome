package sr9;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i implements com.larus.bmhome.setting.b {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void a(String r1, SpeakerVoice r2, String r3) {
    }

    public final void b(int r1, long r2, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "botId");
        Intrinsics.checkNotNullParameter(r5, "errTips");
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "toLanguage");
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "editMethod");
    }
}
