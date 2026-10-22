package com.larus.asr;

import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.audio.i0;
import com.larus.utils.logger.FLogger;
import gw5.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import lw5.h;
import m58.h$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n4 {
    public static final /* synthetic */ int l = 0;
    public final String a;
    public final qw5.a b;
    public final Function0<ww5.a> c;
    public final Function1<n4, Boolean> d;
    public final Function0<Unit> e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile boolean h;
    public volatile h$a i;
    public volatile r4 j;
    public volatile Boolean k;

    public static final class a {
    }

    public static final class b implements h {
        public final /* synthetic */ n4 b;
        public final /* synthetic */ r4 c;

        public final void T2(final lw5.c r4) {
            Intrinsics.checkNotNullParameter(r4, "result");
            final n4 r0 = this.b;
            final r4 r1 = this.c;
            com.larus.utils.t0.e(new q4(r0, r1, r4));
        }

        public final void c1(final hw5.a r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            final n4 r0 = this.b;
            final r4 r1 = this.c;
            com.larus.utils.t0.e(new p4(r0, r1, r4));
        }

        public final void n(final boolean r4) {
            final n4 r0 = this.b;
            final r4 r1 = this.c;
            com.larus.utils.t0.e(new o4(r0, r4, r1));
        }

        public b(n4 r1, r4 r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    static {
    }

    public final boolean a() {
        if (this.h == false) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) this.d.invoke(this)).booleanValue() == false) goto L7;
        return true;
    }

    public final void e() {
        if (this.h == false) goto L5;
        return;
    L5:
        this.h = true;
        this.f = false;
        h$a r0 = this.i;
        if (r0 == null) goto L8;
        r0.a();
    L8:
        this.i = null;
        r4 r1 = this.j;
        if (r1 == null) goto L11;
        r1.release();
    L11:
        this.j = null;
        this.k = null;
        d("released");
    }

    public final void f() {
        if (a() == true) goto L5;
        return;
    L5:
        if (this.f == true) goto L7;
        return;
    L7:
        if (this.g == true) goto L48;
        final r4 r0 = this.j;
        if (r0 != null) goto L12;
        return;
    L12:
        Boolean r1 = this.k;
        if (r1 != null) goto L16;
        return;
    L16:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L36;
        if (a() == true) goto L20;
        return;
    L20:
        if (this.g == true) goto L45;
        i0 r2 = i0.a;
        qw5.a r3 = this.b;
        r2.getClass();
        qw5.a r4 = i0.c(r3);
        if (r4 == null) goto L26;
        g(r0, r4);
        return;
    L26:
        if (this.i != null) goto L46;
        i r5 = this.b.j;
        if (r5 == null) goto L33;
        gw5.c r6 = r5.g;
        if (r6 == null) goto L33;
        long r7 = r6.b;
    L34:
        d("wait for AudioSdk init timeout=" + r7);
        x58.a r8 = m58.h.a;
        this.i = m58.h.e(r7, new j4(this, r0), new k4(this, r0));
        return;
    L33:
        r7 = 25000;
        goto L34
    L46:
        return;
    L45:
        return;
    L36:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L40;
        c("retry aborted because audio file save failed");
        r0.k0(new hw5.a(FlowAsrErrorType.SOURCE_PREPARE_FAILED, "ASR retry audio file save failed", -1002, "taskId=" + this.a + ",audioFileSaveSucceeded=false"));
        return;
    L40:
        throw new NoWhenBranchMatchedException();
    }

    public final void c(String r4) {
        FLogger.a.e("SamiNotReadyAsrRetryCoordinator", "[" + this.a + "] " + r4);
    }

    public final void d(String r4) {
        FLogger.a.i("SamiNotReadyAsrRetryCoordinator", "[" + this.a + "] " + r4);
    }

    public final void b(r4 r7, String r8) {
        StringBuilder r0 = new StringBuilder("finish failure caller=");
        r0.append(r8);
        r0.append(" hasInit=");
        r0.append(Intrinsics.areEqual(m58.h.p.getValue(), Boolean.TRUE));
        r0.append(" hasCommonConfig=");
        if (m58.h.a == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        c(r0.toString());
        if (a() == true) goto L9;
        return;
    L9:
        h$a r2 = this.i;
        if (r2 == null) goto L12;
        r2.a();
    L12:
        this.i = null;
        FlowAsrErrorType r3 = FlowAsrErrorType.CLIENT_ERROR;
        AsrEventEnum r4 = AsrEventEnum.ASR_SAMI_NOT_READY_ERROR;
        r7.k0(new hw5.a(r3, r4.getText(), r4.getCode(), "taskId=" + this.a + ",caller=" + r8));
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void g(r4 r8, qw5.a r9) {
        if (a() == true) goto L5;
        return;
    L5:
        if (this.g == true) goto L51;
        h$a r0 = this.i;
        if (r0 == null) goto L10;
        r0.a();
    L10:
        this.i = null;
        i r1 = r9.j;
        if (r1 == null) goto L33;
        gw5.c r2 = r1.g;
        if (r2 == null) goto L33;
        if (r2.a <= 0) goto L33;
        String r4 = String.valueOf(AsrEventEnum.ASR_SAMI_NOT_READY_ERROR.getCode());
        if (r2.c.contains(r4) == true) goto L32;
        List r3 = r2.d;
        if ((r3 instanceof Collection) == true) goto L24;
    L26:
        Iterator r5 = r3.iterator();
    L28:
        if (r5.hasNext() == false) goto L32;
        if (StringsKt.startsWith$default(r4, (String) r5.next(), false, 2, null) == false) goto L28;
    L24:
        if (r3.isEmpty() == false) goto L26;
    L32:
        boolean r6 = true;
    L34:
        if (r6 == true) goto L37;
        b(r8, "retryRejected");
        return;
    L37:
        this.g = true;
        d("retry saved recording");
        ww5.a r7 = (ww5.a) this.c.invoke();
        if (r7 != null) goto L41;
        r8.k0(new hw5.a(FlowAsrErrorType.CLIENT_ERROR, "IFlowAudioService is unavailable for ASR retry", 500, "taskId=" + this.a + ",kmpAudioService=null"));
        return;
    L41:
        i r10 = r9.j;
        if (r10 != null) goto L45;
        b(r8, "missingAsrConfig");
        return;
    L45:
        gw5.c r11 = r10.g;
        r7.U2(this.a, qw5.a.a(r9, null, null, i.a(r10, null, null, gw5.c.a(r11, RangesKt.coerceAtLeast(r11.a - 1, 0)), 447), 7679), new b(this, r8));
        return;
    L33:
        r6 = false;
        goto L34
    }

    public n4(String r2, qw5.a r3, j2 r4, k2 r5, l2 r6) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "initialConfig");
        Intrinsics.checkNotNullParameter(r4, "audioServiceProvider");
        Intrinsics.checkNotNullParameter(r5, "isActive");
        Intrinsics.checkNotNullParameter(r6, "onReceiveStreamAsrEnd");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
