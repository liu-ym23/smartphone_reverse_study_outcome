package oba;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.attention.ObricAttentionServiceImpl;
import com.obric.assistant.attention.ObricAttentionServiceImpl$b;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ ObricAttentionServiceImpl a;
    public final /* synthetic */ ObricAttentionServiceImpl$b b;

    public /* synthetic */ e(ObricAttentionServiceImpl r1, ObricAttentionServiceImpl$b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricAttentionServiceImpl r0 = this.a;
        ObricAttentionServiceImpl$b r1 = this.b;
        int r2 = ObricAttentionServiceImpl.k;
        r0.getClass();
        if (r1.c == false) goto L6;
        return;
    L6:
        if (r0.b == null) goto L8;
        ObricAttentionServiceImpl.e(r1, false);
        return;
    L8:
        r0.b = r1;
        boolean r8 = true;
        if (r1.b <= SystemClock.uptimeMillis()) goto L11;
        r0.a.postAtTime(r1.f, r1.b);
        if (r0.i == true) goto L59;
        Object r4 = ObricAttentionServiceImpl.h().getSystemService("camera");
        if ((r4 instanceof CameraManager) == false) goto L20;
        CameraManager r5 = (CameraManager) r4;
    L21:
        if (r5 != null) goto L65;
    L47:
        r8 = false;
        goto L59
    L65:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L37
        String[] r7 = r5.getCameraIdList();     // Catch: Throwable -> L37
        LinkedHashSet r9 = new LinkedHashSet();     // Catch: Throwable -> L37
        int r10 = r7.length;     // Catch: Throwable -> L37
        int r11 = 0;
    L24:
        if (r11 >= r10) goto L35;
        String r12 = r7[r11];     // Catch: Throwable -> L37
        Integer r13 = (Integer) r5.getCameraCharacteristics(r12).get(CameraCharacteristics.LENS_FACING);     // Catch: Throwable -> L37
        if (r13 != null) goto L29;
    L31:
        boolean r14 = false;
    L32:
        if (r14 == false) goto L34;
        r9.add(r12);     // Catch: Throwable -> L37
    L34:
        r11 = r11 + 1;     // Catch: Throwable -> L37
        goto L24
    L29:
        if (r13.intValue() != 0) goto L31;
        r14 = true;
        goto L32
    L35:
        Object r15 = Result.constructor-impl(r9);     // Catch: Throwable -> L37
    L39:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L42;
        FLogger.a.e("ObricAttentionService", "enumerate front cameras failed", r16);
    L42:
        Set r17 = SetsKt.emptySet();
        if (Result.isFailure-impl(r15) == false) goto L45;
        r15 = r17;
    L45:
        Set r18 = (Set) r15;
        r0.f = r18;
        if (r18.isEmpty() == true) goto L47;
        r5.registerAvailabilityCallback(r0.j, r0.a);     // Catch: Throwable -> L50
        r0.i = true;     // Catch: Throwable -> L50
        Object r19 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L50
    L52:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L55;
        r0.f = SetsKt.emptySet();
        r0.g.clear();
        r0.h.clear();
        FLogger.a.e("ObricAttentionService", "register camera availability callback failed", r20);
    L55:
        Boolean r21 = Boolean.FALSE;
        if (Result.isFailure-impl(r19) == false) goto L58;
        r19 = r21;
    L58:
        r8 = ((Boolean) r19).booleanValue();
    L50:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
    L37:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L20:
        r5 = null;
    L59:
        if (r8 == true) goto L61;
        FLogger.a.i("ObricAttentionService", "attention check skipped: front camera unavailable");
        r0.g(r1, Boolean.FALSE, false);
        return;
    L61:
        r0.d();
        return;
    L11:
        if (r0.b != r1) goto L74;
        FLogger.a.w("ObricAttentionService", "attention check timed out");
        r0.g(r1, Boolean.FALSE, true);
        return;
    }
}
