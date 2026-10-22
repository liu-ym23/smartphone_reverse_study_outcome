package com.larus.bmhome.chat.detail.code;

import android.os.Handler;
import android.os.SystemClock;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j0 implements mf9.d {
    public long a;
    public int b;
    public final /* synthetic */ h0 c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;

    public final void onCancel() {
        FLogger.a.i("DeepResearchFetchCodeHelper", "fetch deep research code cancel , id = " + this.d + " curCursor = " + this.e + ", pastTime[" + (SystemClock.elapsedRealtime() - this.c.b) + ']');
        n0 r0 = this.c.c;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public final void a(List<Block> r8) {
        Intrinsics.checkNotNullParameter(r8, "block");
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - this.a) >= 2000) goto L5;
        return;
    L5:
        this.a = r0;
        this.c.getClass();
        String r1 = h0.a(r8);
        if (this.b != r1.length()) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        this.c.getClass();
        this.b = h0.a(r8).length();
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("fetch deep research code update , id = ");
        r4.append(this.d);
        r4.append(" curCursor = ");
        r4.append(this.e);
        r4.append(", pastTime[");
        r4.append(SystemClock.elapsedRealtime() - this.c.b);
        r4.append("], codeLength[");
        this.c.getClass();
        r4.append(Integer.valueOf(h0.a(r8).length()));
        r4.append(']');
        r3.d("DeepResearchFetchCodeHelper", r4.toString());
        n0 r5 = this.c.c;
        if (r5 == null) goto L15;
        r5.c(h0.a(r8), false);
        return;
    L15:
        return;
    L8:
        r2 = false;
        goto L9
    }

    public final void b(final List<Block> r8) {
        Intrinsics.checkNotNullParameter(r8, "block");
        long r2 = 2000 - (SystemClock.elapsedRealtime() - this.a);
        Handler r0 = (Handler) this.c.e.getValue();
        final String r1 = this.d;
        final int r4 = this.e;
        final h0 r5 = this.c;
        r0.postDelayed(new i0(r1, r4, r5, r8), r2);
    }

    public final void onError(int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        FLogger.a.e("DeepResearchFetchCodeHelper", "fetch deep research code error , id = " + this.d + " curCursor = " + this.e + " code = " + r5 + ", msg = " + r6 + ", pastTime[" + (SystemClock.elapsedRealtime() - this.c.b) + ']');
        n0 r7 = this.c.c;
        if (r7 == null) goto L6;
        r7.a();
        return;
    }

    public j0(h0 r1, String r2, int r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }
}
