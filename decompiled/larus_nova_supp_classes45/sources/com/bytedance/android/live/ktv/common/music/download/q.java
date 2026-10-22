package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import io.reactivex.ObservableEmitter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q implements p.a {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ ObservableEmitter c;
    public final /* synthetic */ String d;

    @Override // com.bytedance.android.live.ktv.common.music.download.p.a
    public final void c(MusicPanel r5, int r6) {
        int r0 = this.a;
        if (r0 == 4) goto L43;
        if (r5 == null) goto L8;
        Map r2 = r5.i;
        if (r2 == null) goto L8;
        r2.put(Integer.valueOf(r0), Integer.valueOf(r6 / 4));
    L8:
        ObservableEmitter r7 = this.c;
        if (r7 != null) goto L11;
        return;
    L11:
        if (r7.isDisposed() == true) goto L50;
        ObservableEmitter r8 = this.c;
        int r1 = 0;
        if (r5 == null) goto L19;
        Map r3 = r5.i;
        if (r3 == null) goto L19;
        Integer r4 = (Integer) r3.get(0);
        if (r4 == null) goto L19;
        int r9 = r4.intValue();
    L20:
        if (r5 == null) goto L26;
        Map r11 = r5.i;
        if (r11 == null) goto L26;
        Integer r12 = (Integer) r11.get(1);
        if (r12 == null) goto L26;
        int r13 = r12.intValue();
    L27:
        int r14 = r9 + r13;
        if (r5 == null) goto L34;
        Map r15 = r5.i;
        if (r15 == null) goto L34;
        Integer r16 = (Integer) r15.get(2);
        if (r16 == null) goto L34;
        int r17 = r16.intValue();
    L35:
        int r18 = r14 + r17;
        if (r5 == null) goto L42;
        Map r19 = r5.i;
        if (r19 == null) goto L42;
        Integer r21 = (Integer) r19.get(3);
        if (r21 == null) goto L42;
        r1 = r21.intValue();
    L42:
        r8.onNext(Integer.valueOf(r18 + r1));
        return;
    L34:
        r17 = 0;
    L26:
        r13 = 0;
    L19:
        r9 = 0;
        goto L20
    L50:
        return;
    L43:
        ObservableEmitter r22 = this.c;
        if (r22 != null) goto L46;
        return;
    L46:
        if (r22.isDisposed() == true) goto L53;
        this.c.onNext(Integer.valueOf(r6));
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.p.a
    public final void a(MusicPanel r7, String r8, String r9) {
        StringBuilder r11 = new StringBuilder("onSuccessed,resType:");
        r11.append(this.a);
        r11.append(",song:");
        if (r7 == null) goto L7;
        KtvMusic r0 = r7.a;
        if (r0 == null) goto L7;
        String r1 = r0.getMTitle();
    L8:
        r11.append(r1);
        r.a(r11.toString());
        e r2 = KtvMusicManager.k;
        if (r2 == null) goto L11;
        r2.b(f.a(this.a), r7, r8, this.b);
    L11:
        if (r7 == null) goto L15;
        Map r12 = r7.i;
        if (r12 == null) goto L15;
        r12.put(Integer.valueOf(this.a), 25);
    L15:
        ObservableEmitter r13 = this.c;
        if (r13 != null) goto L18;
        return;
    L18:
        if (r13.isDisposed() == true) goto L22;
        this.c.onComplete();
        return;
    L22:
        return;
    L7:
        r1 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.p.a
    public final void b(MusicPanel r8, int r9, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMsg");
        StringBuilder r0 = new StringBuilder("onFailed,resType:");
        r0.append(this.a);
        r0.append(",song:");
        if (r8 == null) goto L7;
        KtvMusic r1 = r8.a;
        if (r1 == null) goto L7;
        String r2 = r1.getMTitle();
    L8:
        r0.append(r2);
        r0.append(", errorMsg:");
        r0.append(r11);
        r.a(r0.toString());
        e r3 = KtvMusicManager.k;
        if (r3 == null) goto L11;
        r3.a(f.a(this.a), r8, r9, r11, this.d);
    L11:
        ObservableEmitter r12 = this.c;
        if (r12 != null) goto L14;
        return;
    L14:
        if (r12.isDisposed() == true) goto L22;
        ObservableEmitter r13 = this.c;
        if (vm2.h.o() == false) goto L18;
        Throwable r4 = new DownLoadFailException(r9, r11);
    L19:
        r13.onError(r4);
        return;
    L18:
        r4 = new Throwable(r11);
        goto L19
    L22:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public q(int r1, long r2, ObservableEmitter r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }
}
