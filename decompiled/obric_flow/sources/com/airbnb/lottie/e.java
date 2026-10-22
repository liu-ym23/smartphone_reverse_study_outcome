package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public final class e implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f1258b;

    public /* synthetic */ e(LottieAnimationView r5, int r10) {
        this.f1257a = r10;
        this.f1258b = r5;
    }

    @Override // com.airbnb.lottie.y
    public final void onResult(Object r5) {
        switch(this.f1257a) {
            case 0: goto L12;
            default: goto L4;
        };
    L4:
        Throwable r10 = (Throwable) r5;
        LottieAnimationView r11 = this.f1258b;
        int r12 = r11.d;
        if (r12 == 0) goto L7;
        r11.setImageResource(r12);
    L7:
        y r13 = r11.f1232c;
        if (r13 != null) goto L10;
        r13 = LottieAnimationView.f1229r;
    L10:
        r13.onResult(r10);
        return;
    L12:
        LottieAnimationView r14 = this.f1258b;
        r14.setComposition((h) r5);
    }
}
