package kd2;

import com.bytedance.android.live.core.log.ALogger;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public int a;
    public final int b;
    public int c;
    public int d;

    public static final class a {
    }

    static {
    }

    public b() {
        this(0, 0);
    }

    public final boolean b() {
        int r0 = this.c;
        if (r0 == 1) goto L5;
    L7:
        return false;
    L5:
        if (r0 != this.d) goto L7;
        return true;
    }

    public final boolean a(int r7) {
        if (r7 != 1) goto L20;
        if (r7 != this.c) goto L10;
        if (r7 != this.d) goto L10;
        return false;
    L10:
        if (r7 == this.d) goto L14;
        ALogger.i("SpeechRecognitionAedState", "start change, currentState: " + this.d + ", newState: " + r7);
        this.d = r7;
        if (this.c == r7) goto L14;
        return false;
    L14:
        int r3 = this.c;
        int r5 = this.d;
        if (r3 == r5) goto L31;
        if (r5 != r7) goto L32;
        ALogger.i("SpeechRecognitionAedState", "update state, targetState: " + this.c + ", newState: " + r7);
        this.c = r7;
    L18:
        return true;
    L32:
        return false;
    L31:
        return false;
    L20:
        if (r7 != this.c) goto L25;
        if (r7 != this.d) goto L25;
        return false;
    L25:
        if (r7 != this.d) goto L27;
        this.a++;
    L28:
        this.d = r7;
        if (this.a != this.b) goto L34;
        ALogger.i("SpeechRecognitionAedState", this.b + " times change, new state: " + r7 + ", currentState: " + this.d);
        this.c = this.d;
        goto L18
    L34:
        return false;
    L27:
        this.a = 1;
        goto L28
    }

    public b(int r1, int r2) {
        this.c = r1;
        this.d = r2;
        this.b = h.t().a();
    }
}
