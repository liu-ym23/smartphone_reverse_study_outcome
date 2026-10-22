package jr;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends q {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f18441k;

    public /* synthetic */ m(int r5) {
        this.f18441k = r5;
    }

    @Override // jr.q
    public final boolean d(float r5, long r10, View r11, gr.e r12) {
        switch(this.f18441k) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        r11.setTranslationZ(b(r5, r10, r11, r12));
        return this.f18450h;
    L6:
        r11.setTranslationY(b(r5, r10, r11, r12));
        return this.f18450h;
    L8:
        r11.setTranslationX(b(r5, r10, r11, r12));
        return this.f18450h;
    L10:
        r11.setScaleY(b(r5, r10, r11, r12));
        return this.f18450h;
    L12:
        r11.setScaleX(b(r5, r10, r11, r12));
        return this.f18450h;
    L14:
        r11.setRotationY(b(r5, r10, r11, r12));
        return this.f18450h;
    L16:
        r11.setRotationX(b(r5, r10, r11, r12));
        return this.f18450h;
    L18:
        r11.setRotation(b(r5, r10, r11, r12));
        return this.f18450h;
    L20:
        r11.setElevation(b(r5, r10, r11, r12));
        return this.f18450h;
    L22:
        r11.setAlpha(b(r5, r10, r11, r12));
        return this.f18450h;
    }
}
