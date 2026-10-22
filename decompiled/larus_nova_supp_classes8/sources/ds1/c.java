package ds1;

import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.JoinChorusConcertStatus;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ VSChorusConcertWidget a;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VSChorusConcertWidget r0 = this.a.a;     // Catch: Throwable -> L12
            ViewGroup r1 = r0.d;     // Catch: Throwable -> L12
            if (r1 == null) goto L15;
            SurfaceView r2 = r0.c;     // Catch: Throwable -> L12
            if (r2 == null) goto L19;
            View r3 = r0.e;     // Catch: Throwable -> L12
            if (r3 == null) goto L20;
            es1.a r4 = r0.xq(false);     // Catch: Throwable -> L12
            if (r4 == null) goto L21;
            r4.a(r2, r1, r3);     // Catch: Throwable -> L12
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        L15:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VSChorusConcertWidget r0 = this.a.a;     // Catch: Throwable -> L12
            ViewGroup r1 = r0.d;     // Catch: Throwable -> L12
            if (r1 == null) goto L15;
            SurfaceView r2 = r0.c;     // Catch: Throwable -> L12
            if (r2 == null) goto L19;
            View r3 = r0.e;     // Catch: Throwable -> L12
            if (r3 == null) goto L20;
            es1.a r4 = r0.xq(false);     // Catch: Throwable -> L12
            if (r4 == null) goto L21;
            r4.a(r2, r1, r3);     // Catch: Throwable -> L12
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        L15:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    public c(VSChorusConcertWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        StringBuilder r0 = new StringBuilder("MatchRoomLandScapeAnimUtil.mStateSubject = ");
        if (r6 != null) goto L5;
        Object r1 = "";
    L6:
        r0.append(r1.toString());
        ALogger.i("LiveMultiTab", r0.toString());
        VSChorusConcertWidget r2 = this.a;
        int r3 = VSChorusConcertWidget.l;
        es1.a r4 = r2.xq(false);
        if (r4 == null) goto L18;
        if ((r6 instanceof Integer) == true) goto L11;
        Object r5 = null;
    L12:
        Integer r7 = (Integer) r5;
        if (r7 == null) goto L15;
        int r8 = r7.intValue();
    L16:
        r4.g = r8;
        goto L18
    L15:
        r8 = 0;
        goto L16
    L11:
        r5 = r6;
    L18:
        if (Intrinsics.areEqual(r6, 1) == false) goto L23;
        if (this.a.xq(true) == null) goto L23;
        JoinChorusConcertStatus.JOINING.getValue();
    L23:
        if (Intrinsics.areEqual(r6, 2) == false) goto L34;
        this.a.yq();
        VSChorusConcertWidget r9 = this.a;
        if (r9.i == false) goto L47;
        ViewGroup r10 = r9.d;
        if (r10 == null) goto L29;
        r10.postDelayed(new a(this), 500);
    L29:
        IKtvService r11 = k.f(IKtvService.class);
        if (r11 == null) goto L48;
        gd2.c r12 = r11.getChorusConcertService();
        if (r12 == null) goto L49;
        r12.e(false);
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L34:
        this.a.Cq();
        if (Intrinsics.areEqual(r6, 2) == false) goto L51;
        VSChorusConcertWidget r13 = this.a;
        if (r13.i == false) goto L52;
        r13.i = false;
        ViewGroup r14 = r13.d;
        if (r14 == null) goto L41;
        r14.postDelayed(new b(this), 500);
    L41:
        IKtvService r15 = k.f(IKtvService.class);
        if (r15 == null) goto L53;
        gd2.c r16 = r15.getChorusConcertService();
        if (r16 == null) goto L54;
        r16.e(false);
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L5:
        r1 = r6;
        goto L6
    }
}
