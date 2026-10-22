package com.obric.assistant.view.listening;

import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import laa.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ n b;
    public final /* synthetic */ byte[] c;

    public /* synthetic */ c(f r1, n r2, byte[] r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r0 = this.a;
        n r1 = this.b;
        byte[] r2 = this.c;
        b r3 = r0.d(r1);
        if (r3 != null) goto L5;
        r3 = r0.d(r0.e);
    L5:
        int r4 = 0;
        int r5 = 0;
    L6:
        int r6 = r4 + 1;
        if (r6 >= r2.length) goto L16;
        int r7 = r2[r4] & 255;
        short r8 = (short) ((r2[r6] << 8) | r7);
        if (r8 != Short.MIN_VALUE) goto L11;
        int r9 = 32768;
    L12:
        if (r9 <= r5) goto L14;
        r5 = r9;
    L14:
        r4 = r4 + 2;
        goto L6
    L11:
        r9 = Math.abs(r8);
        goto L12
    L16:
        if (r0.e(r3, ((double) r5) / 32768.0d) == true) goto L26;
        Job r10 = r0.h;
        if (r10 == null) goto L21;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
    L21:
        r0.h = BuildersKt.launch$default(r0.a, null, null, new ObricListeningViewController$setAudioData$1$1(r2, r0, r3, null), 3, null);
        return;
    }
}
