package com.obric.oui.progress;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.t;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14222b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f14221a = r10;
        this.f14222b = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        Object r10 = this.f14222b;
        switch(this.f14221a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Throwable r11 = (Throwable) r5;
        Result.Companion r12 = Result.Companion;
        Unit r13 = Unit.INSTANCE;
        ((l) r10).resumeWith(Result.m124constructorimpl(r13));
        return r13;
    L6:
        View r14 = (View) r5;
        ODownloadProgressView r15 = (ODownloadProgressView) r10;
        if (r15.f14194a == 0) goto L9;
    L15:
        r15.a();
        return Unit.INSTANCE;
    L9:
        if (r15.isShown() == false) goto L15;
        ValueAnimator r16 = r15.f14209u;
        if (r16.isRunning() == true) goto L17;
        r15.a();
        r16.setInterpolator(new LinearInterpolator());
        r16.setDuration(r15.f14201l);
        r16.setFloatValues(new float[]{0.0f, 360.0f});
        r16.addUpdateListener(new t(this, 4));
        r16.setRepeatCount(-1);
        r16.start();
        return Unit.INSTANCE;
    L17:
        return Unit.INSTANCE;
    }
}
