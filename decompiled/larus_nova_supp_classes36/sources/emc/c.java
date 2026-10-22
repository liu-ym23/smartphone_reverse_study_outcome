package emc;

import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import com.ss.ugc.live.sdk.msg.utils.f;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Delayed {
    public final IStreamMessage a;
    public final long b;
    public volatile long c;
    public volatile long d;
    public final long e;
    public final vlc.c f;

    @Override // java.lang.Comparable
    public final int compareTo(Delayed r5) {
        return Long.compare(this.b, ((c) r5).b);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit r6) {
        if (this.a.getDelayMode() != IStreamMessage.DelayMode.SEI_DIFF) goto L5;
        long r0 = r6.convert(this.a.getTargetSei() - this.d, TimeUnit.MILLISECONDS);
    L6:
        this.f.log("StreamMessageDelayWrap", String.format("getDelay for %s[%d] = %d", new Object[]{this.a.getMessageMethod(), Long.valueOf(this.a.getMessageId()), Long.valueOf(r0)}));
        return r0;
    L5:
        r0 = r6.convert(((this.b + this.c) - this.e) - f.a(), TimeUnit.MILLISECONDS);
        goto L6
    }

    public c(IStreamMessage r8, long r9, vlc.c r11) {
        this(r8, r9, f.a(), r11);
    }

    public c(IStreamMessage r3, long r4, long r6, vlc.c r8) {
        this.d = 0;
        this.a = r3;
        this.c = r4;
        this.b = r6;
        this.e = r3.getServerDelay();
        this.f = r8;
    }
}
