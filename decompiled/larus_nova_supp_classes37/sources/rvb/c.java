package rvb;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmSubtitleAsrOptConfig;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.helper.MmSubtitleSmoothType;
import com.ss.android.lark.pb.minutes.v1.RecordingSubtitleData;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements Runnable {
    public final /* synthetic */ RecordingSubtitleData a;
    public final /* synthetic */ a b;

    public c(RecordingSubtitleData r1, a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Long r0 = this.a.seg_id;
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
    L6:
        boolean r2 = this.b.e.containsKey(Long.valueOf(r1));
        if (r2 == false) goto L9;
        int r4 = -1;
    L10:
        a.d r5 = this.b.d.get(Long.valueOf(r1));
        ConcurrentHashMap<Long, a.d> r6 = this.b.d;
        Long r7 = Long.valueOf(r1);
        if (r5 == null) goto L13;
        RecordingSubtitleData r8 = this.a;
        int r9 = r5.b;
        Intrinsics.checkNotNullParameter(r8, "data");
        a.d r10 = new a.d(r8, r9);
    L14:
        r6.put(r7, r10);
        if (r2 == true) goto L17;
        this.b.e.put(Long.valueOf(r1), Boolean.TRUE);
    L17:
        a r3 = this.b;
        RecordingSubtitleData r11 = this.a;
        MmSubtitleSmoothType r12 = r3.a;
        MmSubtitleSmoothType r13 = MmSubtitleSmoothType.TARGET;
        if (r12 != r13) goto L20;
        RecordingSubtitleData.Subtitle r14 = r11.target;
    L21:
        RecordingSubtitleData.SSDSpeaker r15 = r11.ssd_speaker;
        RecordingSubtitleData.Subtitle r16 = null;
        if (r15 == null) goto L25;
        String r17 = r15.speaker_user_id;
        if (r17 == null) goto L25;
    L31:
        if (r14 == null) goto L62;
        MmSubtitleAsrOptConfig r18 = r3.k;
        if (r18 != null) goto L35;
    L37:
        boolean r19 = false;
    L38:
        if (r19 == false) goto L62;
        Long r20 = r3.f.get(r17);
        if (r20 != null) goto L42;
    L45:
        r3.f.put(r17, Long.valueOf(r1));
    L46:
        if (r20 == null) goto L62;
        a.d r21 = r3.d.get(r20);
        if (r21 == null) goto L50;
        RecordingSubtitleData r22 = r21.a;
    L51:
        if (r22 != null) goto L53;
    L57:
        if (r22 == null) goto L62;
        if (a.b(r22) == false) goto L62;
        if (r16 == null) goto L62;
        r3.f.remove(r17);
        goto L62
    L53:
        if (r3.a != r13) goto L55;
        RecordingSubtitleData.Subtitle r23 = r22.target;
    L56:
        r16 = r23;
        goto L57
    L55:
        r23 = r22.source;
        goto L56
    L50:
        r22 = null;
        goto L51
    L42:
        if (r20.longValue() < r1) goto L45;
        if (a.b(r11) == true) goto L46;
    L35:
        if (r18.getEnabled() != true) goto L37;
        r19 = true;
    L62:
        a r24 = this.b;
        if (r24.h.compareAndSet(false, true) == false) goto L71;
        lvb.a.a(r24.c, "start consume loop");
        if (r24.g != null) goto L67;
        PthreadHandlerThreadV2 r25 = new PthreadHandlerThreadV2("mmSubtitleSmoothThread");
        ThreadMethodProxy.start(r25);
        r24.g = new b(r24, r25.getLooper());
    L67:
        Handler r26 = r24.g;
        if (r26 == null) goto L72;
        r26.sendEmptyMessage(1);
        return;
    L72:
        return;
    L71:
        return;
    L25:
        if (r15 == null) goto L27;
        r17 = r15.user_id;
    L28:
        if (r17 != null) goto L31;
        r17 = "1";
        goto L31
    L27:
        r17 = null;
        goto L28
    L20:
        r14 = r11.source;
        goto L21
    L13:
        r10 = new a.d(this.a, r4);
        goto L14
    L9:
        r4 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
