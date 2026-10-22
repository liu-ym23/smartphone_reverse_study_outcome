package r2a;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.voice_setting.voice.bean.RequestType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public final List<SpeakerVoice> a;
    public final Integer b;
    public final Integer c;
    public final RequestType d;

    public e() {
        this(null, null, null, 31);
    }

    public e(List r3, Integer r4, Integer r5, int r6) {
        RequestType r1 = null;
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = null;
    L12:
        if ((r6 & 16) == 0) goto L14;
        r1 = RequestType.INIT;
    L14:
        Intrinsics.checkNotNullParameter(r1, "requestType");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r1;
    }
}
