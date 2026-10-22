package com.larus.bmhome.view;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a2 implements View.OnTouchListener {
    public final /* synthetic */ FastScrollButton a;

    public /* synthetic */ a2(FastScrollButton r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r13, MotionEvent r14) {
        FastScrollButton r15 = this.a;
        int r0 = FastScrollButton.f;
        boolean r1 = true;
        if (r14.getActionMasked() != 0) goto L5;
    L8:
        Intrinsics.checkNotNull(r14);
        r15.getClass();
        long r4 = SystemClock.elapsedRealtime();
        Object r2 = r15.d.getTag(123400002);
        Long r7 = null;
        if ((r2 instanceof Long) == false) goto L11;
        Long r3 = (Long) r2;
    L13:
        if (r3 == null) goto L15;
        long r10 = r3.longValue();
    L16:
        Object r5 = r15.d.getTag(123400001);
        if ((r5 instanceof Long) == false) goto L19;
        r7 = (Long) r5;
    L19:
        if (r7 == null) goto L21;
        long r6 = r7.longValue();
    L23:
        if (r10 <= 0) goto L25;
        long r8 = r4 - r10;
    L26:
        if (r10 > 0) goto L28;
    L30:
        boolean r9 = false;
    L31:
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("fast_button_touch action=");
        int r16 = r14.getActionMasked();
        if (r16 == 0) goto L38;
        if (r16 == 1) goto L37;
        if (r16 == 3) goto L36;
        String r17 = String.valueOf(r16);
    L39:
        r12.append(r17);
        r12.append(" x=");
        r12.append(r14.getX());
        r12.append(" y=");
        r12.append(r14.getY());
        r12.append(" rawX=");
        r12.append(r14.getRawX());
        r12.append(" rawY=");
        r12.append(r14.getRawY());
        r12.append(" clickDelta=");
        r12.append(r8);
        r12.append(" clickGap=");
        r12.append(r6);
        r12.append(" quickClickCandidate=");
        r12.append(r9);
        r12.append(" parentVisible=");
        if (r15.getVisibility() != 0) goto L42;
        boolean r18 = true;
    L43:
        r12.append(r18);
        r12.append(" parentAlpha=");
        r12.append(r15.getAlpha());
        r12.append(" parentTranslationY=");
        r12.append(r15.getTranslationY());
        r12.append(" isShow=");
        r12.append(r15.e);
        r12.append(" iconVisible=");
        if (r15.d.getVisibility() == 0) goto L47;
        r1 = false;
    L47:
        r12.append(r1);
        r12.append(" iconAlpha=");
        r12.append(r15.d.getAlpha());
        r12.append(" iconEnabled=");
        r12.append(r15.d.isEnabled());
        r12.append(" iconClickable=");
        r12.append(r15.d.isClickable());
        r11.i("fast-scroll-click-chain", r12.toString());
    L48:
        return false;
    L42:
        r18 = false;
        goto L43
    L36:
        r17 = "CANCEL";
        goto L39
    L37:
        r17 = "UP";
        goto L39
    L38:
        r17 = "DOWN";
        goto L39
    L28:
        if (r8 >= r6) goto L30;
        r9 = true;
        goto L31
    L25:
        r8 = -1;
        goto L26
    L21:
        r6 = 500;
        goto L23
    L15:
        r10 = 0;
        goto L16
    L11:
        r3 = null;
        goto L13
    L5:
        if (r14.getActionMasked() == 1) goto L8;
        if (r14.getActionMasked() != 3) goto L48;
        goto L8
    }
}
