package l22;

import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public int a;
    public String b;
    public String c;
    public final long d;
    public Long e;
    public long f;
    public String g;
    public long h;
    public final String i;
    public final long j;

    public static final class a {
    }

    static {
    }

    public final String b() {
        int r0 = this.a;
        if (r0 != 0) goto L5;
        return "init";
    L5:
        if (r0 != 1) goto L7;
        return "recognition";
    L7:
        if (r0 != 2) goto L9;
        return "interrupted";
    L9:
        if (r0 != 3) goto L11;
        return "completing";
    L11:
        if (r0 == 4) goto L13;
        return CardLockInfo.sUNKNOWN;
    L13:
        return "complete";
    }

    public final String toString() {
        return "RecognitionInfo(reqId=" + this.b + ", state=" + b() + ", keyword=" + this.i + ", traceback=" + this.j + ", asrResult=" + this.c + ", asrStartTime=" + this.d + ", duration=" + this.f + ", path=" + this.g + ')';
    }

    public final boolean a(String r7) {
        int r0 = this.a;
        if (r0 != 1) goto L5;
    L8:
        this.a = 4;
        this.g = r7;
        this.f = (System.currentTimeMillis() - this.d) + this.j;
        return true;
    L5:
        if (r0 == 3) goto L8;
        return false;
    }

    public f(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "keyword");
        this.i = r2;
        this.j = r3;
        this.c = r2;
        this.d = System.currentTimeMillis();
    }
}
