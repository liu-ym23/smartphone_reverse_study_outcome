package hga;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.spi.audio.WakeupAudioCaptureReadScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public final WakeupAudioCaptureReadScene a;
    public final long b;
    public final String c;
    public final int d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d;
    }

    public final String toString() {
        return "WakeupAudioCaptureReadRequest(scene=" + this.a + ", wantedStartTimeMs=" + this.b + ", reason=" + this.c + ", wakeupId=" + this.d + ')';
    }

    public /* synthetic */ e(WakeupAudioCaptureReadScene r7, long r8, String r10) {
        this(r7, r8, r10, 0);
    }

    public e(WakeupAudioCaptureReadScene r2, long r3, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r5, WindowEvent.Params.REASON);
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
    }
}
