package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.bytedance.live.richcontent.model.style.ImageStyle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements LottieListener {
    public final /* synthetic */ h a;
    public final /* synthetic */ ek6.d b;
    public final /* synthetic */ ob2.e c;
    public final /* synthetic */ hk6.b.a d;

    public i(h r1, ek6.d r2, ob2.e r3, hk6.d r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void onResult(Object r10) {
        LottieComposition r11 = (LottieComposition) r10;
        LottieDrawable r0 = new LottieDrawable();
        h r1 = this.a;
        ek6.d r2 = this.b;
        r1.getClass();
        boolean r3 = r2 instanceof fk6.a;
        if (r3 == true) goto L5;
        ek6.d r4 = null;
    L6:
        fk6.a r5 = (fk6.a) r4;
        float r6 = 1.0f;
        if (r5 == null) goto L58;
        ImageStyle r7 = r5.e();
        if (r7 == null) goto L58;
        ImageStyle.AdjustType r8 = r7.a;
        if (r8 == null) goto L58;
        if (r3 == true) goto L15;
        ek6.d r9 = null;
    L16:
        fk6.a r13 = (fk6.a) r9;
        if (r13 == null) goto L58;
        ImageStyle r14 = r13.e();
        if (r14 == null) goto L58;
        int r15 = r14.b;
        if (r3 == true) goto L23;
        ek6.d r16 = null;
    L24:
        fk6.a r17 = (fk6.a) r16;
        if (r17 == null) goto L58;
        ImageStyle r18 = r17.e();
        if (r18 == null) goto L58;
        int r19 = r18.c;
        if (r3 == true) goto L31;
        r2 = null;
    L31:
        fk6.a r20 = (fk6.a) r2;
        if (r20 == null) goto L58;
        ImageStyle r21 = r20.e();
        if (r21 == null) goto L58;
        float r23 = r21.d;
        int r24 = r11.getBounds().height();
        int r25 = r11.getBounds().width();
        if (r8 == ImageStyle.AdjustType.ORIGIN) goto L58;
        if (r8 != ImageStyle.AdjustType.SCALE) goto L44;
        if (r23 <= 0) goto L44;
        r6 = r23;
    L44:
        if (r8 != ImageStyle.AdjustType.ADJUST_HEIGHT) goto L46;
    L47:
        if (r24 <= 0) goto L51;
        if (r15 <= 0) goto L51;
        float r26 = r15 * 1.0f;
        float r27 = r24;
    L57:
        r6 = r26 / r27;
    L51:
        if (r8 != ImageStyle.AdjustType.ADJUST_WIDTH) goto L53;
    L54:
        if (r25 <= 0) goto L58;
        if (r19 <= 0) goto L58;
        r26 = r19 * 1.0f;
        r27 = r25;
        goto L57
    L53:
        if (r8 != ImageStyle.AdjustType.EXACTLY) goto L58;
    L46:
        if (r8 != ImageStyle.AdjustType.EXACTLY) goto L51;
    L23:
        r16 = r2;
        goto L24
    L15:
        r9 = r2;
    L58:
        r0.d = r6;
        r0.x();
        r0.m(r11);
        r0.w(-1);
        r0.c.setRepeatMode(1);
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.a.info("LiveLottieResourceLoader, load lottie resource success " + this.c);
        this.d.b(r0);
        return;
    L5:
        r4 = r2;
        goto L6
    }
}
